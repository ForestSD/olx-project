package olxproject.pages;

import olxproject.interfacepage.GeneralClassPage;
import olxproject.interfacepage.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage extends GeneralClassPage implements Methods {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    private By fieldSearch = By.xpath("//input[@id='search-text']");

    private By categoriesHeading = By.xpath("//span[@class='block overh']");

    private By searchSubmit = By.xpath("//input[@id='search-submit']");

    private By additionalSettings = By.xpath("//ul[contains(@class,'clr multifilters')]");


    private By creteriaTop = By.xpath("//a[@id='cancelSearchCriteriaTop']//span[@class='link hn']");


    private By listAdvert = By.cssSelector(".sort-order-type li.fleft");
    private By listByTheCriteria = By.cssSelector(".sort-order-type li a.link");
    private By listCurrency = By.cssSelector(".view-currency li span");
    private By listCate = By.xpath("//fieldset[@id='paramsList']");

    public void submitSearch() {
        driver.findElement(searchSubmit).click();
    }

    public void headerSearch(String product) {
        driver.findElement(fieldSearch).sendKeys(product);
        submitSearch();
    }

    public void checkHeading(String nameCategoryOnList){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(categoriesHeading)).click().perform();
        //driver.findElement(categoriesHeading).click();
        String locator = "//ul[@id='categorySelectList']//a[contains(text(),'%s')]";
        WebElement elementCategoryList = driver.findElement(By.xpath(String.format(locator,nameCategoryOnList)));
        elementCategoryList.click();
    }

    public void waitAlertWindow(){
        WebDriverWait wait = new WebDriverWait(driver, 5, 200);
        WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='geo-suggestions-close']")));
        waitElement.click();
    }

    public void checkBoxSearchInDescriptionTitle(boolean search){
        if(search) {
            WebElement elementBoxSearch = driver.findElement(By.xpath("//div[@class='checkboxsepa clr']//div[1]"));
            elementBoxSearch.click();
        }
    }

    public void checkBoxSearchOnlyByPhoto(boolean photo){
        if(photo){
            WebElement elementBoxPhoto = driver.findElement(By.xpath("//div[@class='checkboxsepa clr']//div[2]"));
            elementBoxPhoto.click();
        }
    }

    public void checkBoxSearchByDelivery(boolean delivery){
        if(delivery){
            WebElement elementBoxDelivery = driver.findElement(By.xpath("//div[@class='checkboxsepa clr']//div[3]"));
            elementBoxDelivery.click();
        }

    }

    public void priceFrom(String price){
        WebElement element = driver.findElement(By.xpath("//a[@class='button button-from numeric gray block fnormal rel zi3 clr']//span[@class='header block'][contains(text(),'.)')]"));
        element.click();
        WebElement input = driver.findElement(By.cssSelector(".filter-item-from input"));
        input.sendKeys(price);
    }

    public void priceTo(String price){
        WebElement element = driver.findElement(By.xpath("//a[@class='button button-to numeric gray block fnormal rel zi3 clr']//span[@class='header block'][contains(text(),'.)')]"));
        element.click();
        WebElement input = driver.findElement(By.cssSelector(".filter-item-to input"));
        input.sendKeys(price);
    }

    public void priceFromAndTo(String variablePriceFrom, String variablePriceTo){
        this.priceFrom(variablePriceFrom);
        this.priceTo(variablePriceTo);
    }

    /*
    * Метод для определения от кого лица подалось объявление
    * Все
    * Частное
    * Бизнес
    * */
    public void sortListAdvert(String nameAdvert){
        methodSort(nameAdvert, listAdvert);
    }

    /*
     * Метод для определения кретерий сортировки объявлений
     * Самые новые
     * Самые дешевые
     * Самые дорогие
     * */
    public void sortListByTheCriteria(String nameCriteria){
        methodSort(nameCriteria,listByTheCriteria);
    }

    /*
     * Метод для определения валюты
     * грн
     * $
     * €
     * */
    public void sortListCurrency(String nameCurrency){
        methodSort(nameCurrency, listCurrency);
    }

    public void methodSort(String name, By list){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(list);
        for (WebElement element : elements) {
            if(name.equalsIgnoreCase(element.getText())){
                element.click();
            }
        }
    }

}
