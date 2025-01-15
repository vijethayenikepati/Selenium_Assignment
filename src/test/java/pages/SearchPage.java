package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    private By searchBtn = By.id("vrm-input"); // Replace with actual locator
    private By submitBtn = By.xpath("//*[@id='main']//button/span[1]");

    private By makeModelField =By.cssSelector("h1.VehicleHeader-module__model-zw5I");
    private By yearField = By.xpath("//*[@id='main']//ol/li[1]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchVehicle(String registrationNumber) {
        driver.findElement(searchBtn).clear();
        driver.findElement(searchBtn).sendKeys(registrationNumber);
        driver.findElement(submitBtn).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMakeModel() {
        return driver.findElement(makeModelField).getText();
    }

    public String getYear() {
        return driver.findElement(yearField).getText();
    }
}
