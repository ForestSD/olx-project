package olxproject.pages;

import olxproject.enumcategoris.CategoriesId;
import olxproject.interfacepage.BasePage;
import olxproject.interfacepage.Getters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    public WebDriver driver;


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void headerSearchMainPage(String product){
        WebElement element = findElementBy(Getters.getFieldSearchMainPage());
        element.click();
        element.sendKeys(product);
    }

    public void submitSearchMainPage(){
        clickElement(Getters.getButtonSearchMainMainPage());
    }

    public void listCategoriesOnMainPage(String nameOfCategories, String locator){
        List<WebElement> elements = driver.findElements(Getters.getMainCategoriesMainPage());
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