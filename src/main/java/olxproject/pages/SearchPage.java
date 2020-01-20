package olxproject.pages;

import olxproject.interfacepage.GeneralClassPage;
import olxproject.interfacepage.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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


    private By listAdvert = By.xpath("//ul[@class='tabs offerseek clr large fleft tohide rel zi3 sort-order-type']//li");
    private By listCate = By.xpath("//fieldset[@id='paramsList']");
    //fieldset[@id='paramsList']//ul[@class = 'grid-ul grid-2']

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

    public void priceFromAndTo(String fromPrice){
        WebElement element = driver.findElement(By.xpath("//a[@class='button button-from numeric gray block fnormal rel zi3 clr']//span[@class='header block'][contains(text(),'.)')]"));
        element.click();
        WebElement input = driver.findElement(By.cssSelector(".filter-item-from input"));
        input.sendKeys(fromPrice);
    }

}
