package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankLoanFormPage extends PageObject {

    @FindBy(id = "form_amount")
    private WebElement loanAmount;

    @FindBy(id = "form_months")
    private WebElement loanPeriod;

    @FindBy(id = "cookies_accept")
    private WebElement cookieAcceptButton;

    @FindBy(css = ".form-submit")
    private WebElement goToFormButton;

    public BankLoanFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForBankLoanFormPage() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("form_calculator")));
    }
}
