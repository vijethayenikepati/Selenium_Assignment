package utils;

import model.Vehicle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class VehicleFileProcessor {
    private static final String REGISTRATION_PATTERN = "\\b[A-Z]{2}\\d{2}\\s[A-Z]{3}\\b";

    /**
     * Extract registration numbers from unstructured input text.
     *
     * @param filePath Path to the input file.
     * @return List of registration numbers.
     * @throws IOException If the file cannot be read.
     */
    public List<String> extractRegistrationNumbers(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        Pattern pattern = Pattern.compile(REGISTRATION_PATTERN);
        Matcher matcher = pattern.matcher(content);

        return matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }

    /**
     * Parse vehicles from the output file.
     *
     * @param filePath Path to the output file.
     * @return List of Vehicle objects.
     * @throws IOException If the file cannot be read.
     */
    public List<Vehicle> readVehicles(String filePath) throws IOException {
        return Files.lines(Path.of(filePath))
                .map(line -> {
                    String[] parts = line.split(",");
                    String registrationNumber = parts[0].trim();
                    String makeModel = parts[1].trim();
                    String year = parts[2].trim();
                    return new Vehicle(registrationNumber, makeModel, year);
                })
                .collect(Collectors.toList());
    }
}
