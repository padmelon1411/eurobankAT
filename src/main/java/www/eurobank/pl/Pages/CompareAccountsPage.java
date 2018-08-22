package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompareAccountsPage extends PageObject {

    @FindBy(id = "table-compare")
    private WebElement compareTable;

    public CompareAccountsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isInitializedCompareTable() {
        return compareTable.isDisplayed();
    }

    public boolean isDisplayedSelectedAccount(String... accounts) {
        for (String account : accounts) {
            final String nameOfAccount = "//th[(@class='js-compare-column-width js-onstart-compare " + account + "')]";
            webDriver.findElement(By.xpath(nameOfAccount)).isDisplayed();
        }
        return true;
    }

    public void unmarkCheckboxInAccountComparator(String... idOfTheElements) {
        for (String idElement : idOfTheElements) {
            webDriver.findElement(By.id(idElement)).click();
        }
    }

    public void waitForCompareAccountPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("compare")));
    }
}
