package www.eurobank.pl.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import www.eurobank.pl.Pages.BankLoanFormPage;
import www.eurobank.pl.Pages.CashLoanWithLowInterestRatesPage;
import www.eurobank.pl.Pages.MainPage;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.*;

public class CashLoanWithLowInterestRatesPageTest extends FunctionalTest {

    MainPage mainPage = new MainPage(webDriver);
    CashLoanWithLowInterestRatesPage cashLoanPage = new CashLoanWithLowInterestRatesPage(webDriver);
    BankLoanFormPage bankLoanFormPage = new BankLoanFormPage(webDriver);

    @Before
    public void selectCashLoanWithLowInterestRatesPage() {
        if (mainPage.isVisibleCookieMessage())
            mainPage.clickCookieAcceptButton();
        mainPage.clickOnSubmenuElement(nameOfBarWithLoan).clickOnElementFromDropdownFromSubmenu(cashLoanWithLowInterestRate);
        cashLoanPage.waitForCashLoanWithLowInterestRatesPage();
    }

    @Test
    public void goToAppGoForTakeLoan() {
        cashLoanPage.clickOnTheButtonToTakeLoan();
        bankLoanFormPage.waitForBankLoanFormPage();
        Assert.assertEquals(webDriver.getCurrentUrl(), bankLoanFormURL);
    }
}
