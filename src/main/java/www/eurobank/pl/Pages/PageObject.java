package www.eurobank.pl.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    private final static int SECONDS = 20;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, SECONDS);
    }

    public static MainPage returnMainPage(WebDriver webDriver) {
        return new MainPage(webDriver);
    }

    public void scrollPage(String offsetX, String offsetY) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(" + offsetX + ", " + offsetY + ")");
    }
}
