package www.eurobank.pl.Tests;

import org.junit.Test;
import www.eurobank.pl.Pages.ActiveAccountPage;
import www.eurobank.pl.Pages.MainPage;
import www.eurobank.pl.Pages.PersonalAccountPage;
import www.eurobank.pl.Pages.SearchReceiptPage;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.*;

public class MainPageTest extends FunctionalTest {

    MainPage mainPage = new MainPage(webDriver);
    SearchReceiptPage searchingReceiptPage = new SearchReceiptPage(webDriver);
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
    ActiveAccountPage activeAccountPage = new ActiveAccountPage(webDriver);

    @Test
    public void searchExpressionTest() {
        mainPage.isInitializedSearchingBox();
        mainPage.searchExpression(searchedPhrase);
        searchingReceiptPage.waitForSearchingReceiptPageLoad();
        searchingReceiptPage.checkExpressionInSearchEngineTextFieldAfterSearching(searchedPhrase);
        searchingReceiptPage.lookForSearchingExpressionInLinks(searchedPhrase);
    }

    @Test
    public void displayPageWithAllTypeOfPersonalAccount() {
        mainPage.openFromSubmenuSelectedElement(nameOfBarWithAccount);
        personalAccountPage.waitForPersonalAccountPageLoad();
    }

    @Test
    public void displayInformationAboutActiveAccount() {
        mainPage.returnMainPage(webDriver).clickOnSubmenuElement(nameOfBarWithAccount).clickOnElementFromDropdownFromSubmenu(nameOfAccount);
        activeAccountPage.waitForActiveAccountPageLoad();
    }

    @Test
    public void changeLanguageOfMainPage() {
        mainPage.clickOnLanguageButton();
    }
}