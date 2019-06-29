package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class InboxPage extends PageObject{

    @FindBy(xpath = "//*[@class=\"z0\"]")
    private WebElement compose;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement FieldTo;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement FieldSubject;

    @FindBy(xpath = "//div[@class='Ar Au']//div")
    private WebElement FieldBody;

    @FindBy(xpath = "//div[@class='dC']/div")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@title='Sent']")
    private WebElement sentFolder;

    @FindBy(xpath = "//*[contains(text(),'Hello Appium')]")
    private WebElement subjectOfSentEmail;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    //User to troubleshoot
    public boolean isInitialized(){
        return compose.isDisplayed();
    }

    public void newMail() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement composeButton = wait.until(ExpectedConditions.elementToBeClickable(compose));
        this.compose.click();
    }

    public void fillToField(String toField) {
        this.FieldTo.sendKeys(toField);
    }

    public void fillSubjectField(String subject) {
        this.FieldSubject.sendKeys(subject);
    }

    public MailWindow fillBodyOfEmail(String subject) {
        this.FieldBody.sendKeys(subject);
        return new MailWindow(driver);
    }

    public void sendButton() {
        this.sendButton.click();
    }

    public void sentFolder(){
        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement sentFolderLink = wait.until(ExpectedConditions.elementToBeClickable(sentFolder));*/
        try {
            this.sentFolder.click();
        }
        catch (StaleElementReferenceException e) {
            sentFolder = driver.findElement(By.xpath("//*[@title='Sent']"));
            this.sentFolder.click();
        }
    }

    public boolean summarySentEmailDisplayed(){
        return subjectOfSentEmail.isDisplayed();
    }
}
