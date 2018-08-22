package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatingAccountPage extends PageObject {

    public CreatingAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForCompareAccountPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("bookmarkFull")));
    }
}
