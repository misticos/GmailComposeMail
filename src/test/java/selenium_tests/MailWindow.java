package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailWindow extends PageObject {

    //@FindBy(css = "tr.btC td:nth-of-type(1) div div:nth-of-type(2)")
    @FindBy(xpath = "//div[@class='dC']/div")
    private WebElement sendButton;

    public MailWindow(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait getWebDriverWait(int waitTimeout, int pollingInterval){
        // import webdriverwait
        WebDriverWait wait = new WebDriverWait(driver, waitTimeout, pollingInterval);
        return wait;
    }

    public WebElement waitForElementBeClickable(By locator, int waitTimeout, int pollingInterval){
        WebDriverWait wait = this.getWebDriverWait(waitTimeout, pollingInterval);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void sendButton() {

        this.waitForElementBeClickable(By.xpath("//div[@class='dC']//div"), 3, 100).click();


    }
}
