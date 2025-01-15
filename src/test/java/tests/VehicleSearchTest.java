package tests;

import base.BaseTest;
import model.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import utils.VehicleFileProcessor;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleSearchTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(VehicleSearchTest.class);

    @Test
    public void testVehicleProperties() throws IOException {
        logger.info("Starting Vehicle Property Validation Test");

        VehicleFileProcessor processor = new VehicleFileProcessor();

        // Extract registration numbers from car_input.txt
        List<String> registrationNumbers = processor.extractRegistrationNumbers("src/test/resources/car_input.txt");
        logger.info("Extracted Registration Numbers: {}", registrationNumbers);

        // Load expected vehicle properties from car_output.txt
        List<Vehicle> expectedVehicles = processor.readVehicles("src/test/resources/car_output.txt");
        logger.info("Extracted Registration Numbers: {}", expectedVehicles);


        driver.get("https://motorway.co.uk/");
        SearchPage searchPage = new SearchPage(driver);
//
//        for (int i = 0; i < registrationNumbers.size(); i++) {
//            String registrationNumber = registrationNumbers.get(i);
//            Vehicle expectedVehicle = expectedVehicles.get(i);
//
//            logger.info("Searching for vehicle with registration: {}", registrationNumber);
//
//            // Search vehicle and fetch properties
//            searchPage.searchVehicle(registrationNumber);
//            String actualMakeModel = searchPage.getMakeModel();
//            String actualYear = searchPage.getYear();
//
//            logger.info("Expected Make/Model: {}, Actual Make/Model: {}", expectedVehicle.getMakeModel(), actualMakeModel);
//            logger.info("Expected Year: {}, Actual Year: {}", expectedVehicle.getYear(), actualYear);
//
//            // Compare properties
//            assertEquals(expectedVehicle.getMakeModel(), actualMakeModel, "Make/Model mismatch for: " + registrationNumber);
//            assertEquals(expectedVehicle.getYear(), actualYear, "Year mismatch for: " + registrationNumber);
//        }
//
//        logger.info("Vehicle Property Validation Test Completed");
    }
}
