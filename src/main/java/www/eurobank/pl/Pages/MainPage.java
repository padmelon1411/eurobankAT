package www.eurobank.pl.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends PageObject {

    @FindBy(id = "topSearch")
    private WebElement searchEngineTextField;

    @FindBy(id = "submit-search")
    private WebElement magnifyingGlassButton;

    @FindBy(id = "mcCookiesAcceptButton")
    private WebElement cookieAcceptButton;

    @FindBy(id = "mcCookiesLawMessage")
    private WebElement cookieMessage;

    public MainPage(WebDriver webDriver) {

        super(webDriver);
    }

    public boolean isInitializedSearchingBox() {
        return searchEngineTextField.isDisplayed();
    }

    public void searchExpression(String searchingPhrase) {
        Actions builder = new Actions(webDriver);
        Action searchPhrase = builder
                .moveToElement(searchEngineTextField)
                .doubleClick(searchEngineTextField)
                .sendKeys(searchEngineTextField, searchingPhrase)
                .moveToElement(magnifyingGlassButton)
                .click(magnifyingGlassButton)
                .build();
        searchPhrase.perform();
    }

    public MainPage clickOnSubmenuElement(String textMenuBar) {
        final String nameOfMenuBar = "//span[text()[contains(.,'" + textMenuBar + "')]]";
        webDriver.findElement(By.xpath(nameOfMenuBar)).click();
        return this;
    }

    public MainPage clickOnElementFromDropdownFromSubmenu(String textDropdown) {
        final String nameOfElement = "//h3[text()[contains(.,'" + textDropdown + "')]]";
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(nameOfElement)));
        webDriver.findElement(By.xpath(nameOfElement)).click();
        return this;
    }

    public MainPage openFromSubmenuSelectedElement(String textMenuBar) {
        final String nameOfMenuBar = "//span[text()[contains(.,'" + textMenuBar + "')]]";
        WebElement selectedOption = webDriver.findElement(By.xpath(nameOfMenuBar));
        Actions builder = new Actions(webDriver);
        Action selectOptionFromMenubar = builder
                .moveToElement(selectedOption)
                .doubleClick(selectedOption)
                .build();
        selectOptionFromMenubar.perform();
        return this;
    }

    public void clickOnLanguageButton() {
        String text = "english version";
        scrollPage("0", "document.body.scrollHeight");
        final String languageButton = "//span[text()[contains(.,'" + text + "')]]";
        webDriver.findElement(By.xpath(languageButton)).click();
    }

    public void clickCookieAcceptButton() {
        cookieAcceptButton.click();
    }

    public boolean isVisibleCookieMessage() {
        return cookieMessage.isDisplayed();
    }
}


