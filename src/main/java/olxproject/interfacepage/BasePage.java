package olxproject.interfacepage;

import olxproject.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage  {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickOnHeaderLogoPage(){
        clickElement(Getters.getHeaderLogoBasePage());
    }

    public void clickButtonPostAn(){
        clickElement(Getters.getButtonPostAnBasePage());
        new LoginPage(driver);
    }

    public void clickButtonMyProfile(){
        clickElement(Getters.getMyProfileBasePage());
        new LoginPage(driver);
    }

    public void changeLanguage(String language){
        List<WebElement> elements = driver.findElements(Getters.getLanguageOnBasePage());
        iterateElement(elements,language);
    }

    public void specificCity(String location){
        sendKeysElement(Getters.getSearchAreaBasePage(),location);
    }

    public void wholeCountry(){
        clickElement(Getters.getSearchAreaBasePage());
        clickElement(Getters.getWholeCountryBasePage());
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

    public void checkForAlert(){
        this.clickOnHeaderLogoPage();
        this.closeAlertWindowMainPage();
    }

    public void closeAlertWindowMainPage(){
        this.visibilityElementOnPageBySelector(Getters.getAlertElementCloseWindowMainPage());
    }

    protected void pageLocator(String name, String locator){
        List<WebElement> elements = driver.findElements(By.xpath(String.format(Getters.getLocalCategoriesString(), name)));
        iterateElement(elements,locator);
    }

    protected void javaScriptExecutorScrollPage(){
        WebElement webElement = findElementBy(Getters.getDownElementOnPage());
        ((JavascriptExecutor)driver).executeScript(Getters.getScrollOnDownPage(), webElement);
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
        try {
            String stringPrice = price.toString();
            clickElement(selectorButton);
            sendKeysElement(selectorInput, stringPrice);
        }catch (Exception e){}

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
                visibilityElementOnPageBySelector(Getters.getBoxCloseCookieWindowSearchPage());
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

    public String getText(By element){
        return driver.findElement(element).getText();
    }

    public void clickElement(By selector){
        driver.findElement(selector).click();
    }

    public WebElement findElementBy(By selector){
        return driver.findElement(selector);
    }

    public void sendKeysElement(By selector, String key){
        driver.findElement(selector).sendKeys(key);
    }

    public void submitElement(By selector){ driver.findElement(selector).submit();}
}
