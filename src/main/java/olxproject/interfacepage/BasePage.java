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
        clickElement(getters.getHeaderLogoBasePage());
    }

    public void clickButtonPostAn(){
        clickElement(getters.getButtonPostAnBasePage());
        new LoginPage(driver);
    }

    public void clickButtonMyProfile(){
        clickElement(getters.getMyProfileBasePage());
        new LoginPage(driver);
    }

    public void changeLanguage(String language){
        List<WebElement> elements = driver.findElements(getters.getLanguageOnBasePage());
        iterateElement(elements,language);
    }

    public void specificCity(String location){
        sendKeysElement(getters.getSearchAreaBasePage(),location);
    }

    public void wholeCountry(){
        clickElement(getters.getSearchAreaBasePage());
        clickElement(getters.getWholeCountryBasePage());
    }

    protected void sortListByName(String name, By list){
        try {
            waitSecond(2.5);
            List<WebElement> elements = driver.findElements(list);
            iterateElement(elements,name);
        }catch (Exception e){

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
        iterateElement(elements,locator);
    }

    protected void javaScriptExecutorScrollPage(){
        WebElement webElement = findElementBy(getters.getDownElementOnPage());
        ((JavascriptExecutor)driver).executeScript(getters.getScrollOnDownPage(), webElement);
    }

    protected void visibilityElementOnPageBySelector(By selector){
        waitSecond(1);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3, 200);
            WebElement element = findElementBy(selector);
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
        try {
            if(value){
                clickElement(selector);
            }
        }catch (Exception e){

        }
    }

    protected void switchingPage(boolean nextOrPreviousPage, By selector){
        try {

            if (nextOrPreviousPage) {
                waitSecond(2);
                javaScriptExecutorScrollPage();
                waitSecond(1.5);
                visibilityElementOnPageBySelector(getters.getBoxCloseCookieWindowSearchPage());
                this.clickElement(selector);
            }
        }catch (Exception e){

        }
    }

    private void iterateElement(List<WebElement> elements, String locator){
        for (WebElement element : elements) {
            String text = element.getText();
            if(text.equalsIgnoreCase(locator)){
                element.click();
                break;
            }
        }
    }

    protected void clickElement(By selector){
        driver.findElement(selector).click();
    }

    protected WebElement findElementBy(By selector){
        return driver.findElement(selector);
    }

    protected void sendKeysElement(By selector, String key){
        driver.findElement(selector).sendKeys(key);
    }

    protected void submitElement(By selector){ driver.findElement(selector).submit();}
}
