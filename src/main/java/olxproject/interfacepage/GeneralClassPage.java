package olxproject.interfacepage;

import olxproject.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
