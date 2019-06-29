package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailWindow extends PageObject {

    //@FindBy(css = "tr.btC td:nth-of-type(1) div div:nth-of-type(2)")
    @FindBy(css = "//div[@class='dC']//div")
    private WebElement sendButton;

    public MailWindow(WebDriver driver) {
        super(driver);
    }

    public void sendButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement sendButtonElement = wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        this.sendButton.click();
        //WebElement sendButton = driver.findElement(By.xpath("//div[@class='dC']//div"));

    }
}
