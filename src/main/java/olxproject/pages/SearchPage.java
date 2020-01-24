package olxproject.pages;

import olxproject.interfacepage.GeneralClassPage;
import olxproject.interfacepage.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    private By listAdvert = By.cssSelector(".sort-order-type li.fleft");
    private By listByTheCriteria = By.cssSelector(".sort-order-type li a.link");
    private By listCurrency = By.cssSelector(".view-currency li span");
    private By listView = By.xpath("//ul[@id='viewSelector']//span");


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
        visibilityElementOnPage("a[id = 'geo-suggestions-close']");
    }

    public void checkBoxSearchInDescriptionTitle(boolean search){
        checkBoxSearch(search,"div > label[for = title-desc]");
    }

    public void checkBoxSearchOnlyByPhoto(boolean photo){
        checkBoxSearch(photo,"div > label[for = photo-only]");
    }

    public void checkBoxSearchByDelivery(boolean delivery){
        checkBoxSearch(delivery,"div > label[for = safedeal-only]");
    }

    public void priceFrom(Integer price){
        pricingMethod(price,".button-from",".filter-item-from input");
    }

    public void priceTo(Integer price){
        pricingMethod(price,".button-to",".filter-item-to input");
    }

    public void priceFromAndTo(Integer variablePriceFrom, Integer variablePriceTo){
        this.priceFrom(variablePriceFrom);
        this.priceTo(variablePriceTo);
    }

    /**
    * Все
    * Частное
    * Бизнес
    **/
    public void MethodForDeterminingFromWhomTheAdWasSubmitted(String nameAdvert){
        methodSort(nameAdvert, listAdvert);
    }

    /**
     * Самые новые
     * Самые дешевые
     * Самые дорогие
     **/
    public void methodForDefiningSortingCriteria(String nameCriteria){
        methodSort(nameCriteria,listByTheCriteria);
    }

    /**
     * грн
     * $
     * €
     **/
    public void methodForDeterminingTheCurrency(String nameCurrency){
        methodSort(nameCurrency, listCurrency);
    }

    /**
     * Список
     * Галерея
     **/
    public void methodForDisplayingGoods(String nameView){
        methodSort(nameView,listView);
    }

    public void viewAllProductsOnTheSearchPage(){
        WebElement element = driver.findElement(By.cssSelector("a.x-normal span"));
        element.click();
    }

    public void nextPage(Integer numberPage){
        javascriptExecutorScrollPage();
        waitSecond(3);
        visibilityElementOnPage(".cookie-close");
        List<WebElement> elementsPager = driver.findElements(By.cssSelector(".pager span"));
        for (WebElement page : elementsPager) {
            String text = page.getText();
            String stringNumberPage = numberPage.toString();
            if(stringNumberPage.equals(text)){
                page.click();
                break;
            }
        }

    }

}
