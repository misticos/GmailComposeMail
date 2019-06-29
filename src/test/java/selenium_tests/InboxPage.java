package selenium_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends PageObject{

    @FindBy(className = "Z0")
    private WebElement Compose;

    @FindBy(className = "v0")
    private WebElement FieldTo;

    @FindBy(className = ":9t")
    private WebElement FieldSubject;

    @FindBy(className = ":ay")
    private WebElement FieldBody;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    //User to troubleshoot
    public boolean isInitialized(){
        return Compose.isDisplayed();
    }

    public void newMail() {
        this.Compose.click();
    }

    public void fillToField(String toField) {
        this.FieldTo.sendKeys(toField);
    }

    public void fillSubjectField(String subject) {
        this.FieldTo.sendKeys(subject);
    }

    public void fillBodyOfEmail(String subject) {
        this.FieldTo.sendKeys(subject);
    }

    /*public String confirmationInboxFolder(){
        return inboxFolder.getText();
    }*/
}
