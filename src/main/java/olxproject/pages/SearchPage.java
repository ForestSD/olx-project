package olxproject.pages;

import olxproject.interfacepage.BasePage;
import olxproject.interfacepage.Getters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SearchPage extends BasePage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void submitSearchOnSearchPage() {
        clickElement(Getters.getSubmitSearchPage());
    }

    public void headerSearchOnSearchPage(String product) {
        sendKeysElement(Getters.getFieldSearchOnSearchPage(),product);
        submitSearchOnSearchPage();
    }

    public void checkHeadingSearchPage(String nameCategoryOnList){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Getters.getCategoriesHeadingSearchPage())).click().perform();
        WebElement elementCategoryList = driver.findElement(By.xpath(String.format(Getters.getLocatorCheckHeading(),nameCategoryOnList)));
        elementCategoryList.click();
    }

    public void closeAlertWindowSearchPage(){
        visibilityElementOnPageBySelector(Getters.getBoxCloseAlertWindowSearchPage());
    }

    public void checkBoxSearchInDescriptionTitleSearchPage(boolean search){
        checkBoxSearch(search, Getters.getOnlyDescriptionTitleSearchPage());
    }

    public void checkBoxSearchOnlyByPhotoSearchPage(boolean photo){
        checkBoxSearch(photo, Getters.getOnlyPhotoSearchPage());
    }

    public void checkBoxSearchByDeliverySearchPage(boolean delivery){
        checkBoxSearch(delivery, Getters.getOnlyDeliverySearchPage());
    }

    public void priceFromSearchPage(Integer price){
        pricing(price, Getters.getButtonFromPriceSearchPage(), Getters.getInputFromPriceSearchPage());
    }

    public void priceToSearchPage(Integer price){
        pricing(price, Getters.getButtonToPriceSearchPage(), Getters.getInputToPriceSearchPage());
    }

    public void priceFromAndTo(Integer variablePriceFrom, Integer variablePriceTo){
        this.priceFromSearchPage(variablePriceFrom);
        this.priceToSearchPage(variablePriceTo);
    }

    /**
     * Все
     * Частное
     * Бизнес
     **/
    public void forDeterminingFromWhomTheAdWasSubmittedSearchPage(String nameAdvert){
        sortListByName(nameAdvert, Getters.getListAdvertSearchPage());
    }

    /**
     * Самые новые
     * Самые дешевые
     * Самые дорогие
     **/
    public void forDefiningSortingCriteriaSearchPage(String nameCriteria){
        sortListByName(nameCriteria, Getters.getListByTheCriteriaSearchPage());
    }

    /**
     * грн
     * $
     * €
     **/
    public void forDeterminingTheCurrencySearchPage(String nameCurrency){
        sortListByName(nameCurrency, Getters.getListCurrencySearchPage());
    }

    /**
     * Список
     * Галерея
     **/
    public void forDisplayingGoodsSearchPage(String nameView){
        sortListByName(nameView, Getters.getListViewSearchPage());
    }

    public void viewAllProductsOnTheSearchPage(){
        clickElement(Getters.getViewAllProductSearchPage());
    }

    public void nextPageNumberOnSearchPage(Integer numberPage){
        javaScriptExecutorScrollPage();
        waitSecond(3);
        visibilityElementOnPageBySelector(Getters.getBoxCloseCookieWindowSearchPage());
        List<WebElement> elementsPager = driver.findElements(Getters.getNextNumberSearchPage());
        for (WebElement page : elementsPager) {
            String text = page.getText();
            String stringNumberPage = numberPage.toString();
            if(stringNumberPage.equals(text)){
                page.click();
                break;
            }
        }

    }

    public void nextPageButtonOnSearchPage(boolean nextPage){
        switchingPage(nextPage, Getters.getNextButtonSearchPage());
    }

    public void previousPageButtonOnSearchPage(boolean previousPage){
        switchingPage(previousPage, Getters.getPreviousButtonSearchPage());
    }

    public void headerSearch(String product) {
        sendKeysElement(Getters.getFieldSearchOnSearchPage(), product);
        submitSearch();
    }


    public void submitSearch() {
        clickElement(Getters.getSubmitSearchPage());
    }
}
