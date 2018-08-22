package www.eurobank.pl.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import www.eurobank.pl.Pages.ActiveAccountPage;
import www.eurobank.pl.Pages.CreatingAccountPage;
import www.eurobank.pl.Pages.MainPage;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.*;

public class ActiveAccountPageTest extends FunctionalTest {

    MainPage mainPage = new MainPage(webDriver);
    ActiveAccountPage activeAccountPage = new ActiveAccountPage(webDriver);
    CreatingAccountPage creatingAccountPage = new CreatingAccountPage(webDriver);

    @Before
    public void selectActiveAccountPage() {
        if (mainPage.isVisibleCookieMessage())
            mainPage.clickCookieAcceptButton();
        mainPage.clickOnSubmenuElement(nameOfBarWithAccount).clickOnElementFromDropdownFromSubmenu(nameOfAccount);
        activeAccountPage.waitForActiveAccountPageLoad();
    }

    /**
     * activeAccountSubmenuOption1 - o koncie
     * activeAccountSubmenuOption2 - jak otworzyć konto
     * activeAccountSubmenuOption3 - opłaty i prowizje
     * activeAccountSubmenuOption4 - dokumenty
     */
    @Test
    public void selectOptionFromGraySubmenu() {
        activeAccountPage.selectOptionFromSubmenuActiveAccount(activeAccountSubmenuOption3);
    }

    //TODO ---> you should check if it is downloaded
    @Test
    public void downloadPackOfExtraDocs() {
        activeAccountPage.selectOptionFromSubmenuActiveAccount(activeAccountSubmenuOption4);
        activeAccountPage.scrollPage("0", "600");
        activeAccountPage.expandListExtraDocuments();
        activeAccountPage.scrollPage("0", "1200");
        activeAccountPage.clickOnDownloadDocsButton();
    }

    @Test
    public void displayArchivalDocuments() {
        activeAccountPage.selectOptionFromSubmenuActiveAccount(activeAccountSubmenuOption4);
        activeAccountPage.scrollPage("0", "900");
        activeAccountPage.clickOnArchivalDocuments();
        Assert.assertTrue(activeAccountPage.isVisibleListOfArchivalDocuments() == true);
    }

    @Test
    public void selectBankBranchSearchEngine() {
        activeAccountPage.selectOptionFromSubmenuActiveAccount(activeAccountSubmenuOption2);
        activeAccountPage.scrollPage("0", "1200");
        activeAccountPage.clickOnLookingForBankBranchButton();
        Assert.assertEquals(webDriver.getCurrentUrl(), bankBranchSearchEngineURL);
    }

    @Test
    public void goToAppGoForCreatingAccount() {
        activeAccountPage.selectOptionFromSubmenuActiveAccount(activeAccountSubmenuOption2);
        activeAccountPage.scrollPage("0", "300");
        activeAccountPage.clickOnCreateAccountButton();
        creatingAccountPage.waitForCompareAccountPageLoad();
        Assert.assertEquals(webDriver.getCurrentUrl(), creatingAccountFormURL);
    }

    /**
     * contactForm1 = "telefonicznie";
     * contactForm2 = "e-mail";
     */
    //TODO ---> What with fluent interfaces?
    @Test
    public void sendContactFormWithValidDataContactForm1() {
        activeAccountPage.scrollPage("0", "document.body.scrollHeight - 100");
        activeAccountPage.clickOnAskAboutOfferButton();
        activeAccountPage.waitForContactFormLoad();
        activeAccountPage.enterFullName(validFullName);
        activeAccountPage.selectFormOfContact(contactForm1);
        activeAccountPage.enterPhoneNumber(validPhoneNumber);
        activeAccountPage.selectConversationSubject(conversationSubject);
        activeAccountPage.clickSubmitContactFormButton();
        activeAccountPage.waitForConfirmationMessageLoad();
        Assert.assertTrue(activeAccountPage.isDisplayedPhoneConfirmationMessage() == true);
    }

    @Test
    public void sendContactFormWithValidDataContactForm2() throws InterruptedException {
        activeAccountPage.scrollPage("0", "document.body.scrollHeight - 100");
        activeAccountPage.clickOnAskAboutOfferButton();
        activeAccountPage.waitForContactFormLoad();
        activeAccountPage.enterFullName(validFullName);
        activeAccountPage.selectFormOfContact(contactForm2);
        activeAccountPage.enterEmail(validEmail);
        activeAccountPage.selectConversationSubject(conversationSubject);
        activeAccountPage.enterMessage(message);
        activeAccountPage.clickSubmitContactFormButton();
        activeAccountPage.waitForConfirmationMessageLoad();
        Assert.assertTrue(activeAccountPage.isDisplayedEmailConfirmationMessage());
    }

    @Test
    public void sendContactFormWithInvalidEmail() {
        activeAccountPage.scrollPage("0", "document.body.scrollHeight - 100");
        activeAccountPage.clickOnAskAboutOfferButton();
        activeAccountPage.waitForContactFormLoad();
        activeAccountPage.enterFullName(validFullName);
        activeAccountPage.selectFormOfContact(contactForm2);
        activeAccountPage.enterEmail(invalidEmail);
        activeAccountPage.selectConversationSubject(conversationSubject);
        activeAccountPage.enterMessage(message);
        activeAccountPage.clickSubmitContactFormButton();
        Assert.assertTrue(activeAccountPage.isDisplayedInformationAboutWrongEmail());
    }

    //TODO ---> why compilator can not see message about the lack of email despite the fact that it has appeared ???
    @Test
    public void sendContactFormWithoutEmail() throws InterruptedException {
        activeAccountPage.scrollPage("0", "document.body.scrollHeight - 100");
        activeAccountPage.clickOnAskAboutOfferButton();
        activeAccountPage.waitForContactFormLoad();
        activeAccountPage.enterFullName(validFullName);
        activeAccountPage.selectFormOfContact(contactForm2);
        activeAccountPage.selectConversationSubject(conversationSubject);
        activeAccountPage.enterMessage(message);
        activeAccountPage.clickSubmitContactFormButton();
        //Assert.assertTrue(activeAccountPage.isDisplayedInformationAboutLackOfData());
    }

    @Test
    public void sendContactFormWithoutMessage() {
        activeAccountPage.scrollPage("0", "document.body.scrollHeight - 100");
        activeAccountPage.clickOnAskAboutOfferButton();
        activeAccountPage.waitForContactFormLoad();
        activeAccountPage.enterFullName(validFullName);
        activeAccountPage.selectFormOfContact(contactForm2);
        activeAccountPage.enterEmail(invalidEmail);
        activeAccountPage.selectConversationSubject(conversationSubject);
        activeAccountPage.clickSubmitContactFormButton();
        Assert.assertTrue(activeAccountPage.isDisplayedInformationAboutLackOfData());
    }


}
