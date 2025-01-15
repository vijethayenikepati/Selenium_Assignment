package base;

import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Get the WebDriver instance from DriverFactory
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        // Quit the driver and clean up resources
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.removeDriver();
    }
}
