package olxproject.pages;

import olxproject.interfacepage.BasePage;
import olxproject.interfacepage.Getters;
import olxproject.interfacepage.Methods;
import olxproject.interfacepage.OlxManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SearchPage extends BasePage implements Methods {

    private WebDriver driver;
    private OlxManager manager;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private Getters getters = new Getters();


    public void submitSearch() {
        driver.findElement(getters.getSubmitSearchPage()).click();
    }

    public void headerSearch(String product) {
        driver.findElement(getters.getFieldSearchOnSearchPage()).sendKeys(product);
        submitSearch();
    }

    public void checkHeading(String nameCategoryOnList){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(getters.getCategoriesHeadingSearchPage())).click().perform();
        WebElement elementCategoryList = driver.findElement(By.xpath(String.format(getters.getLocatorCheckHeading(),nameCategoryOnList)));
        elementCategoryList.click();
    }

    public void closeAlertWindowSearchPage(){
        visibilityElementOnPageBySelector(getters.getBoxCloseAlertWindowSearchPage());
    }

    public void checkBoxSearchInDescriptionTitle(boolean search){
        checkBoxSearch(search,getters.getOnlyDescriptionTitleSearchPage());
    }

    public void checkBoxSearchOnlyByPhoto(boolean photo){
        checkBoxSearch(photo,getters.getOnlyPhotoSearchPage());
    }

    public void checkBoxSearchByDelivery(boolean delivery){
        checkBoxSearch(delivery,getters.getOnlyDeliverySearchPage());
    }

    private void priceFrom(Integer price){
        pricing(price,getters.getButtonFromPriceSearchPage(),getters.getInputFromPriceSearchPage());
    }

    private void priceTo(Integer price){
        pricing(price,getters.getButtonToPriceSearchPage(), getters.getInputToPriceSearchPage());
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
    public void forDeterminingFromWhomTheAdWasSubmitted(String nameAdvert){
        sortListByName(nameAdvert, getters.getListAdvertSearchPage());
    }

    /**
     * Самые новые
     * Самые дешевые
     * Самые дорогие
     **/
    public void forDefiningSortingCriteria(String nameCriteria){
        sortListByName(nameCriteria,getters.getListByTheCriteriaSearchPage());
    }

    /**
     * грн
     * $
     * €
     **/
    public void forDeterminingTheCurrency(String nameCurrency){
        sortListByName(nameCurrency, getters.getListCurrencySearchPage());
    }

    /**
     * Список
     * Галерея
     **/
    public void methodForDisplayingGoods(String nameView){
        sortListByName(nameView,getters.getListViewSearchPage());
    }

    public void viewAllProductsOnTheSearchPage(){
        WebElement element = driver.findElement(getters.getViewAllProductSearchPage());
        element.click();
    }



    public void nextPageButton(boolean nextPage){
        switchingPage(nextPage, getters.getNextButtonSearchPage());
    }

    public void previousPageButton(boolean previousPage){
        switchingPage(previousPage,getters.getPreviousButtonSearchPage());
    }

}
