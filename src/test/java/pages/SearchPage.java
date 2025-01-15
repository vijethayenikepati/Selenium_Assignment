package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    private By searchBox = By.id("registration-input"); // Replace with actual locator
    private By submitButton = By.id("search-button"); // Replace with actual locator
    private By makeModelField = By.cssSelector(".make-model"); // Replace with actual locator
    private By yearField = By.cssSelector(".year"); // Replace with actual locator

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchVehicle(String registrationNumber) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(registrationNumber);
        driver.findElement(submitButton).click();
    }

    public String getMakeModel() {
        return driver.findElement(makeModelField).getText();
    }

    public String getYear() {
        return driver.findElement(yearField).getText();
    }
}
