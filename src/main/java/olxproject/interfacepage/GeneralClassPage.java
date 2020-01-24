package olxproject.interfacepage;

import olxproject.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class GeneralClassPage {

    private WebDriver driver;


    private By headerLogo = By.xpath("//a[@id='headerLogo']");
    private By buttonPostAn = By.xpath("//a[@id='postNewAdLink']//span");
    private By myProfile = By.xpath("//span[@class='link inlblk']//strong");
    private By languageOnPage = By.xpath("//ul[@class='breaklist inlblk']//li");
    private By searchArea = By.xpath("//input[@id='cityField']");
    private By wholeCountry = By.xpath("//a[@class='regionSelectA1']");

    public GeneralClassPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnHeaderLogoMainPage(){
        driver.findElement(headerLogo).click();
    }

    public LoginPage clickButtonPostAn(){
        driver.findElement(buttonPostAn).click();
        return new LoginPage(driver);
    }

    public LoginPage clickButtonMyProfile(){
        driver.findElement(myProfile).click();
        return new LoginPage(driver);
    }

    public void changeLanguage(String language){
        List<WebElement> elements = driver.findElements(languageOnPage);
        for (WebElement element : elements){
            String text = element.getText();
            if(text.equals(language)){
                element.click();
            }
        }
    }

    public void specificCity(String location){
        driver.findElement(searchArea).sendKeys(location);
    }

    public void wholeCountry(){
        driver.findElement(searchArea).click();
        driver.findElement(wholeCountry).click();
    }

    protected void methodSort(String name, By list){
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

    protected void javascriptExecutorScrollPage(){
        WebElement webElement = driver.findElement(By.xpath("//div[@class='pager rel clr']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void visibilityElementOnPage(String selector){
        WebDriverWait wait = new WebDriverWait(driver, 5, 200);
        WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        waitElement.click();
    }

    protected void pricingMethod(Integer price, String selectorButton, String selectorInput){
        String stringPrice = price.toString();
        WebElement element = driver.findElement(By.cssSelector(selectorButton));
        element.click();
        WebElement input = driver.findElement(By.cssSelector(selectorInput));
        input.sendKeys(stringPrice);
    }

    protected void checkBoxSearch(boolean value, String selector){
        if(value){
            WebElement elementBox = driver.findElement(By.cssSelector(selector));
            elementBox.click();
        }
    }

}
