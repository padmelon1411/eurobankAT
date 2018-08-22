package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FamilyAndFriendProgramPage extends PageObject {

    @FindBy(css = ".submit")
    private WebElement sendContactFormButton;

    @FindBy(id = "pAF2-name")
    private WebElement fullNameTextField;

    @FindBy(id = "pAF2-phone")
    private WebElement phoneNumberTextField;

    @FindBy(id = "pAF2-email")
    private WebElement emailTextField;

    @FindBy(id = "txtFormThx")
    private WebElement confirmationMessage;

    public FamilyAndFriendProgramPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForFamilyAndFiendProgramPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("tabs1")));
    }

    public FamilyAndFriendProgramPage clickSendButton() {
        sendContactFormButton.click();
        return this;
    }

    public FamilyAndFriendProgramPage enterFullName(String fullName) {
        fullNameTextField.sendKeys(fullName);
        return this;
    }

    public FamilyAndFriendProgramPage enterPhoneNumber(String phoneNumber) {
        phoneNumberTextField.sendKeys(phoneNumber);
        return this;
    }

    public FamilyAndFriendProgramPage enterEmail(String email) {
        emailTextField.sendKeys(email);
        return this;
    }

    public boolean isVisibleConfirmationMessage() {
        return confirmationMessage.isDisplayed();
    }

    public void waitForConfirmationMessageLoad() {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(confirmationMessage, "Dziękujemy za wysłanie"));
    }

    public boolean isDisplayedErrorMessageAboveTextField(String error) {
        final String errorText = "//div[text()[contains(.,'" + error + "')]]";
        WebElement errorMessage = webDriver.findElement(By.xpath(errorText));
        return errorMessage.isDisplayed();
    }
}
