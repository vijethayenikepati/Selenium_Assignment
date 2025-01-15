package tests;

import base.BaseTest;
import model.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.MileagePage;
import pages.SearchPage;
import utils.VehicleFileProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleSearchMultipleFilesTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(VehicleSearchMultipleFilesTest.class);

    // Directory paths for input and output files
    private static final String INPUT_FILES_DIRECTORY = "src/test/resources/input_files/";
    private static final String OUTPUT_FILES_DIRECTORY = "src/test/resources/output_files/";

    @Test
    public void testMultipleInputFiles() throws IOException {
        logger.info("Starting Vehicle Property Validation Test for Multiple Input Files");

        // Create file processor
        VehicleFileProcessor processor = new VehicleFileProcessor();

        // Get all input files
        File[] inputFiles = new File(INPUT_FILES_DIRECTORY).listFiles((dir, name) -> name.startsWith("car_input_") && name.endsWith(".txt"));
        if (inputFiles == null || inputFiles.length == 0) {
            logger.error("No input files found in directory: {}", INPUT_FILES_DIRECTORY);
            return;
        }

        for (File inputFile : inputFiles) {
            String inputFileName = inputFile.getName();
            String outputFileName = inputFileName.replace("input", "output");

            logger.info("Processing Input File: {}", inputFileName);

            // Extract registration numbers from the input file
            List<String> registrationNumbers = processor.extractRegistrationNumbers(inputFile.getAbsolutePath());
            logger.info("Extracted Registration Numbers: {}", registrationNumbers);

            // Read expected vehicles from the corresponding output file
            List<Vehicle> expectedVehicles = processor.readVehicles(OUTPUT_FILES_DIRECTORY + outputFileName);

            // Validate each vehicle
            SearchPage searchPage = new SearchPage(driver);
            MileagePage confirmPage = new MileagePage(driver);

            for (int i = 0; i < registrationNumbers.size(); i++) {
                String registrationNumber = registrationNumbers.get(i);
                Vehicle expectedVehicle = expectedVehicles.get(i);

                logger.info("Navigating to Search Page for vehicle: {}", registrationNumber);
                driver.get("https://motorway.co.uk/");

                logger.info("Searching for vehicle with registration: {}", registrationNumber);
                searchPage.searchVehicle(registrationNumber);

                confirmPage.clickConfirmButton();
                logger.info("Clicked Confirm Button for registration: {}", registrationNumber);

                String actualMakeModel = searchPage.getMakeModel();
                String actualYear = searchPage.getYear();

                logger.info("Expected Make/Model: {}, Actual Make/Model: {}", expectedVehicle.getMakeModel(), actualMakeModel);
                logger.info("Expected Year: {}, Actual Year: {}", expectedVehicle.getYear(), actualYear);

                // Compare properties
                assertEquals(expectedVehicle.getMakeModel(), actualMakeModel, "Make/Model mismatch for: " + registrationNumber);
                assertEquals(expectedVehicle.getYear(), actualYear, "Year mismatch for: " + registrationNumber);
            }

            logger.info("Validation Completed for Input File: {}", inputFileName);
        }

        logger.info("Vehicle Property Validation Test for Multiple Input Files Completed");
    }
}
