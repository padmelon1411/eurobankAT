package www.eurobank.pl.Tests;

import org.junit.Assert;
import org.junit.Test;
import www.eurobank.pl.Pages.CompareAccountsPage;
import www.eurobank.pl.Pages.MainPage;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.*;

public class CompareAccountPageTest extends FunctionalTest {

    MainPage mainPage = new MainPage(webDriver);
    CompareAccountsPage compareAccountsPage = new CompareAccountsPage(webDriver);

    @Test
    public void selectCompareAccountPage() {
        mainPage.clickOnSubmenuElement(nameOfBarWithAccount).clickOnElementFromDropdownFromSubmenu(accountComparisonOption);
        compareAccountsPage.waitForCompareAccountPageLoad();
    }

    @Test
    public void compareAccountWithoutSelectedCheckboxes() {
        selectCompareAccountPage();
        compareAccountsPage.unmarkCheckboxInAccountComparator(activeAccountComparisonCheckbox, prestigeAccountComparisonCheckbox, everydayAccountComparisonCheckbox);
        Assert.assertTrue(compareAccountsPage.isInitializedCompareTable() == false);
    }

    @Test
    public void compareOnlyTwoAccounts() {
        selectCompareAccountPage();
        compareAccountsPage.unmarkCheckboxInAccountComparator(activeAccountComparisonCheckbox);
        System.out.println(compareAccountsPage.isDisplayedSelectedAccount(prestigeAccountComparisonCheckbox, everydayAccountComparisonCheckbox));
    }
}
