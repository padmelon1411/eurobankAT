package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalAccountPage extends PageObject {

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForPersonalAccountPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("ProductGroup")));
    }
}
