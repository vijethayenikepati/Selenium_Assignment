package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MileagePage {

    private WebDriver driver;

    private By confirmMilageBtn = By.xpath("//span[contains(text(), 'Confirm mileage')]");

    public MileagePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the confirm button to proceed to the next page.
     */
    public void clickConfirmButton() {
        driver.findElement(confirmMilageBtn).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
