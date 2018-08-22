package www.eurobank.pl.Tests;

import org.junit.Assert;
import org.junit.Test;
import www.eurobank.pl.Pages.FamilyAndFriendProgramPage;
import www.eurobank.pl.Pages.MainPage;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.*;

public class FamilyAndFriendProgramPageTest extends FunctionalTest {

    MainPage mainPage = new MainPage(webDriver);
    FamilyAndFriendProgramPage familyAndFriendProgramPage = new FamilyAndFriendProgramPage(webDriver);

    @Test
    public void selectFamilyAndFriendProgramPage() {
        mainPage.clickOnSubmenuElement(nameOfBarWithAccount).clickOnElementFromDropdownFromSubmenu(familyAndFriendsOption);
        familyAndFriendProgramPage.waitForFamilyAndFiendProgramPageLoad();
    }

    @Test
    public void sendContactFormWithValidData() throws InterruptedException {
        selectFamilyAndFriendProgramPage();
        familyAndFriendProgramPage.scrollPage("0", "450");
        familyAndFriendProgramPage.enterFullName(validFullName).enterPhoneNumber(validPhoneNumber).enterEmail(validEmail).clickSendButton();
        familyAndFriendProgramPage.waitForConfirmationMessageLoad();
        Assert.assertTrue(familyAndFriendProgramPage.isVisibleConfirmationMessage() == true);
    }

    //TODO ---> isVisibleConfirmationMessage()==true?
//    @Test
//    public void sendContactFormWithInvalidFullName() {
//        selectFamilyAndFriendProgramPage();
//        familyAndFriendProgramPage.scrollPage("0", "450");
//        familyAndFriendProgramPage.enterFullName(invalidFullName).enterPhoneNumber(validPhoneNumber).clickSendButton();
//        Assert.assertTrue(familyAndFriendProgramPage.isVisibleConfirmationMessage() == false);
//        Assert.assertFalse(familyAndFriendProgramPage.isDisplayedErrorMessageAboveTextField(errorMessage1));
//    }

    @Test
    public void sendContactFormWithoutPhoneNumber() {
        selectFamilyAndFriendProgramPage();
        familyAndFriendProgramPage.scrollPage("0", "450");
        familyAndFriendProgramPage.enterFullName(validFullName).enterEmail(validEmail).clickSendButton();
        Assert.assertTrue(familyAndFriendProgramPage.isVisibleConfirmationMessage() == false);
        Assert.assertTrue(familyAndFriendProgramPage.isDisplayedErrorMessageAboveTextField(errorMessage1));
    }

    @Test
    public void sendContactFormWithInvalidEmail() {
        selectFamilyAndFriendProgramPage();
        familyAndFriendProgramPage.scrollPage("0", "450");
        familyAndFriendProgramPage.enterFullName(validFullName).enterPhoneNumber(validPhoneNumber).enterEmail(invalidEmail).clickSendButton();
        Assert.assertTrue(familyAndFriendProgramPage.isVisibleConfirmationMessage() == false);
        Assert.assertTrue(familyAndFriendProgramPage.isDisplayedErrorMessageAboveTextField(errorMessage2));
    }
}
