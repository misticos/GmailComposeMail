package selenium_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject{

    @FindBy(id="identifierId")
    private WebElement userEmail;

    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement userPassword;

    @FindBy(className = "CwaK9")
    private WebElement nextButtonOnEmail;

    @FindBy(className = "CwaK9")
    private WebElement nextButtonOnPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return userEmail.isDisplayed();
    }

    public boolean isPasswordInitialized() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(userPassword));
        return userPassword.isDisplayed();
    }

    public void enterUserEmail(String userEmail) {
        this.userEmail.clear();
        this.userEmail.sendKeys(userEmail);
        nextButtonOnEmail.click();
    }

    public void enterUserPassword(String userPassword) {
        this.userPassword.sendKeys(userPassword);
    }

    public InboxPage nextOnPassword(){
        nextButtonOnPassword.click();
        return new InboxPage(driver);
    }
}
