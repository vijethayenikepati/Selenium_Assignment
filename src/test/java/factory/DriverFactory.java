package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    // Thread-local storage for WebDriver instances
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * Get the WebDriver instance for the current thread.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            String browser = System.getProperty("browser", "chrome"); // Default to Chrome
            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                threadLocalDriver.set(new ChromeDriver());
            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return threadLocalDriver.get();
    }

    /**
     * Remove the WebDriver instance for the current thread.
     */
    public static void removeDriver() {
        threadLocalDriver.remove();
    }
}
