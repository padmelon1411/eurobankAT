package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CashLoanWithLowInterestRatesPage extends PageObject {

    @FindBy(css = ".btn-placer-img")
    private WebElement takeLoanButton;

    public CashLoanWithLowInterestRatesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForCashLoanWithLowInterestRatesPage() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("rotator-data-box-0")));
    }

    public void clickOnTheButtonToTakeLoan() {
        takeLoanButton.click();
    }
}
