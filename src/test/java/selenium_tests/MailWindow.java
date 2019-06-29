package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailWindow extends PageObject {

    //@FindBy(css = "tr.btC td:nth-of-type(1) div div:nth-of-type(2)")
    @FindBy(xpath = "//div[@class='dC']//div")
    private WebElement sendButton;

    public MailWindow(WebDriver driver) {
        super(driver);
    }

    public void sendButton() {
        try {
            this.sendButton.click();
        }
        catch (StaleElementReferenceException e) {
            WebElement sendButton = driver.findElement(By.xpath("//div[@class='dC']//div"));
            sendButton.click();
        }
    }
}
