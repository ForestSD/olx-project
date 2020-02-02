package olxproject.interfacepage;

import olxproject.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage extends Getters {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private Getters getters = new Getters();


    public void clickOnHeaderLogoPage(){
        driver.findElement(getters.getHeaderLogoBasePage()).click();
    }

    public void clickButtonPostAn(){
        driver.findElement(getters.getButtonPostAnBasePage()).click();
        new LoginPage(driver);
    }

    public void clickButtonMyProfile(){
        driver.findElement(getters.getMyProfileBasePage()).click();
        new LoginPage(driver);
    }

    public void changeLanguage(String language){
        List<WebElement> elements = driver.findElements(getters.getLanguageOnBasePage());
        for (WebElement element : elements){
            String text = element.getText();
            if(text.equals(language)){
                element.click();
            }
        }
    }

    public void specificCity(String location){
        driver.findElement(getters.getSearchAreaBasePage()).sendKeys(location);
    }

    public void wholeCountry(){
        driver.findElement(getters.getSearchAreaBasePage()).click();
        driver.findElement(getters.getWholeCountryBasePage()).click();
    }

    protected void sortListByName(String name, By list){
        waitSecond(2.5);
        List<WebElement> elements = driver.findElements(list);
        for (WebElement element : elements) {
            if(name.equalsIgnoreCase(element.getText())){
                element.click();
            }
        }
    }


    protected void waitSecond(double seconds){
        Double millisecond = seconds * 1000;
        Integer millisecondInt = millisecond.intValue();
        try {
            Thread.sleep(millisecondInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void pageLocator(String name, String locator){
        List<WebElement> elements = driver.findElements(By.xpath(String.format(getters.getLocalCategoriesString(), name)));
        for (WebElement element : elements) {
            String text = element.getText();
            if(text.contains(locator)){
                element.click();
                break;
            }
        }
    }

    protected void javaScriptExecutorScrollPage(){
        WebElement webElement = driver.findElement(getters.getDownElementOnPage());
        ((JavascriptExecutor)driver).executeScript(getters.getScrollOnDownPage(), webElement);
    }

    protected void visibilityElementOnPageBySelector(By selector){
        waitSecond(1);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3, 200);
            WebElement element = driver.findElement(selector);
            if(element.isDisplayed()) {
                WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
                waitElement.click();
            }else {
                return;
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    protected void pricing(Integer price, By selectorButton, By selectorInput){
        String stringPrice = price.toString();
        clickElement(selectorButton);
        sendKeysElement(selectorInput,stringPrice);

    }

    protected void checkBoxSearch(boolean value, By selector){
        if(value){
            clickElement(selector);
        }
    }

    protected void switchingPage(boolean nextOrPreviousPage, By selector){
        if(nextOrPreviousPage) {
            waitSecond(2);
            javaScriptExecutorScrollPage();
            waitSecond(1.5);
            visibilityElementOnPageBySelector(getters.getBoxCloseCookieWindowSearchPage());
            this.clickElement(selector);
        }
    }

    private void clickElement(By selector){
        driver.findElement(selector).click();
    }

    private WebElement findElementBy(By selector){
        return driver.findElement(selector);
    }

    private void sendKeysElement(By selector, String key){
        driver.findElement(selector).sendKeys(key);
    }

    //TODO
    /*Сделать методы FOR TEXT они повторяються*/
}
