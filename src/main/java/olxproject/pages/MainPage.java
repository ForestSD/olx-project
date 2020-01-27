package olxproject.pages;

import olxproject.interfacepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import olxproject.enumcategoris.CategoriesId;
import olxproject.interfacepage.Methods;

import java.util.List;

public class MainPage extends BasePage implements Methods {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    private By fieldSearch = By.xpath("//input[@id='headerSearch']");
    private By fieldCity = By.xpath("//input[@id='cityField']");
    private By regionSelection = By.xpath("//div[@id='regionslinks']//ul//li");
    private By citySelection = By.xpath("//div[@id='subregionslinks']//ul//li");

    private By buttonSearchMain = By.xpath("//input[@id='submit-searchmain']");

    private By mainCategories = By.xpath("//div[@class='maincategories']//div//div//a//span");

    public void closeAlertWindow(){
        this.visibilityElementOnPageByXpathSelector("//div[@class='gtm-survey__close js-gtm-survey-close']");
    }

    public void headerSearch(String product){
        WebElement element = driver.findElement(fieldSearch);
        element.click();
        element.sendKeys(product);
    }

    public void submitSearch(){
        driver.findElement(buttonSearchMain).click();

    }

    public void choosingTheRightCity(String nameRegion, String nameCity){
        driver.findElement(fieldCity).click();
        List<WebElement> areas = driver.findElements(regionSelection);
        for (WebElement region : areas){
            String textRegion = region.getText();
            if(textRegion.contains(nameRegion)){
                region.click();
                List<WebElement> cities = driver.findElements(citySelection);
                for (WebElement city : cities){
                    String textCity = city.getText();
                    if(textCity.contains(nameCity)){
                        city.click();
                    }
                }
            }
        }
    }

    public void listCategories(String nameOfCategories, String locator){
        List<WebElement> elements = driver.findElements(mainCategories);
        for (WebElement element : elements){
            String text = element.getText();
            if(text.equalsIgnoreCase(nameOfCategories)) {
                element.click();
                CategoriesId byName = CategoriesId.getByName(nameOfCategories);
                pageLocator(byName.giveId(),locator);
                break;
            }
        }
    }

}