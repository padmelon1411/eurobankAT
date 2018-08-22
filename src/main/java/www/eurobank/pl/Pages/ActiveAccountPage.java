package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActiveAccountPage extends PageObject {

    @FindBy(id = "show_not_important")
    private WebElement linkToListOfActualDocsButton;

    @FindBy(id = "showArchivumButton")
    private WebElement linkToListOfArchivalDocumentsButton;

    @FindBy(id = "doc_archivum")
    private WebElement divWithArchivalDocuments;

    @FindBy(id = "popup-contact")
    private WebElement contactForm;

    @FindBy(id = "contact-name")
    private WebElement fullNameTextField;

    @FindBy(id = "contact-phone")
    private WebElement phoneNumberTextField;

    @FindBy(id = "contact-message")
    private WebElement messageTextField;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "txtDziekujemyZaWyslanie")
    private WebElement confirmationMessage;

    @FindBy(css = ".submit")
    private WebElement submitContactFormButton;

    @FindBy(css = "#txtDziekujemyPhone")
    private WebElement phoneConfirmationMessage;

    @FindBy(css = "#txtDziekujemyEmail")
    private WebElement emailConfirmationMessage;

    public ActiveAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForActiveAccountPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("tabs1")));
    }

    public void selectOptionFromSubmenuActiveAccount(String option) {
        final String optionText = "//a[text()[contains(.,'" + option + "')]]";
        WebElement selectedOption = webDriver.findElement(By.xpath(optionText));
        selectedOption.click();
    }

    public void expandListExtraDocuments() {
        linkToListOfActualDocsButton.click();
    }

    public void clickOnDownloadDocsButton() {
        final String downloadButtonTitle = "//i[text()[contains(.,'pobierz paczkę wszystkich dokumentów')]]";
        WebElement downloadDocsButton = webDriver.findElement(By.xpath(downloadButtonTitle));
        downloadDocsButton.click();
    }

    public void clickOnArchivalDocuments() {
        linkToListOfArchivalDocumentsButton.click();
    }

    public boolean isVisibleListOfArchivalDocuments() {
        return divWithArchivalDocuments.isDisplayed();
    }

    public void clickOnLookingForBankBranchButton() {
        final String lokingForButtonTitle = "//i[text()[contains(.,'szukaj placówki')]]";
        WebElement lookingForBranchButton = webDriver.findElement(By.xpath(lokingForButtonTitle));
        lookingForBranchButton.click();
    }

    public void clickOnAskAboutOfferButton() {
        final String buttonTitle = "//i[text()[contains(.,'zapytaj o ofertę')]]";
        WebElement askingAboutOfferButton = webDriver.findElement(By.xpath(buttonTitle));
        askingAboutOfferButton.click();
    }

    public void waitForContactFormLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("popup-contact")));
    }

    public ActiveAccountPage enterFullName(String fullName) {
        fullNameTextField.sendKeys(fullName);
        return this;
    }

    public void selectFormOfContact(String contactForm) {
        final String contactFormField = "//a[text()[contains(.,'e-mail')]]";
        WebElement ddContactFormList = webDriver.findElement(By.xpath(contactFormField));
        ddContactFormList.click();
        final String buttonTitle = "//a[text()[contains(.,'" + contactForm + "')]]";
        WebElement contactFormOption = webDriver.findElement(By.xpath(buttonTitle));
        contactFormOption.click();
    }

    public ActiveAccountPage enterEmail(String email) {
        emailTextField.sendKeys(email);
        return this;
    }

    public ActiveAccountPage enterPhoneNumber(String phoneNumber) {
        phoneNumberTextField.sendKeys(phoneNumber);
        return this;
    }

    public void selectConversationSubject(String conversationSubject) {
        final String conversationSubjectField = "//a[text()[contains(.,'wybierz')]]";
        WebElement ddconversationSubjectList = webDriver.findElement(By.xpath(conversationSubjectField));
        ddconversationSubjectList.click();
        final String buttonTitle = "//a[text()[contains(.,'" + conversationSubject + "')]]";
        WebElement conversationSubjectOption = webDriver.findElement(By.xpath(buttonTitle));
        conversationSubjectOption.click();
    }

    public ActiveAccountPage enterMessage(String message) {
        messageTextField.sendKeys(message);
        return this;
    }

    public void clickSubmitContactFormButton() {
        submitContactFormButton.click();
    }

    public void waitForConfirmationMessageLoad() {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(confirmationMessage, "Dziękujemy za"));
    }

//    public void waitForEmailConfirmationMessageLoad() {
//        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("txtDziekujemyZaWyslanie")));
//    }

    public boolean isDisplayedConfirmationMessage() {
        return confirmationMessage.isDisplayed();
    }

    public boolean isDisplayedPhoneConfirmationMessage() {
        return phoneConfirmationMessage.isDisplayed();
    }

    public boolean isDisplayedEmailConfirmationMessage() {
        return emailConfirmationMessage.isDisplayed();
    }

    public boolean isDisplayedInformationAboutWrongEmail() {
        final String errorText = "//div[text()[contains(.,'Wpisz poprawny adres e-mail')]]";
        WebElement errorMessage1 = webDriver.findElement(By.xpath(errorText));
        return errorMessage1.isDisplayed();
    }

    public boolean isDisplayedInformationAboutLackOfData() {
        final String errorText = "//div[text()[contains(.,'Uzupełnij pole')]]";
        WebElement errorMessage2 = webDriver.findElement(By.xpath(errorText));
        return errorMessage2.isDisplayed();
    }

    public void clickOnCreateAccountButton() {
        final String buttonText = "//i[text()[contains(.,'przejdź do wniosku')]]";
        WebElement creatingAccountButton = webDriver.findElement(By.xpath(buttonText));
        creatingAccountButton.click();
    }


}
