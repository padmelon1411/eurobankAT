package www.eurobank.pl.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static www.eurobank.pl.TemporaryDataProvider.TemporaryDataProvider.mainPageURL;

public class FunctionalTest {
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Before
    public void openMainPage() {
        webDriver.get(mainPageURL);
    }

    @After
    public void cleanUp() {
        webDriver.manage().deleteAllCookies();
    }

}
