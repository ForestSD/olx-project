package olxproject.interfacepage;

import olxproject.enumcategoris.CategoriesId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class OlxManager extends BasePage {
    private WebDriver driver;

    public OlxManager(WebDriver driver) {
        super(driver);
    }

    private Getters getters = new Getters();

    public void closeAlertWindowMainPage(){
        this.visibilityElementOnPageBySelector(getters.getAlertElementCloseWindowMainPage());
    }

    public void headerSearchMainPage(String product){
        WebElement element = driver.findElement(getters.getFieldSearchMainPage());
        element.click();
        element.sendKeys(product);
        this.submitSearchMainPage();
    }

    public void checkForAlert(){
        this.clickOnHeaderLogoPage();
        this.closeAlertWindowMainPage();
    }

    public void submitSearchMainPage(){
        driver.findElement(getters.getButtonSearchMainMainPage()).click();
    }

    public void listCategoriesOnMainPage(String nameOfCategories, String locator){
        List<WebElement> elements = driver.findElements(getters.getMainCategoriesMainPage());
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

    public void submitSearchOnSearchPage() {
        driver.findElement(getters.getSubmitSearchPage()).click();
    }

    public void headerSearchOnSearchPage(String product) {
        driver.findElement(getters.getFieldSearchOnSearchPage()).sendKeys(product);
        submitSearchOnSearchPage();
    }

    public void checkHeadingSearchPage(String nameCategoryOnList){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(getters.getCategoriesHeadingSearchPage())).click().perform();
        WebElement elementCategoryList = driver.findElement(By.xpath(String.format(getters.getLocatorCheckHeading(),nameCategoryOnList)));
        elementCategoryList.click();
    }

    public void closeAlertWindowSearchPage(){
        visibilityElementOnPageBySelector(getters.getBoxCloseAlertWindowSearchPage());
    }

    public void checkBoxSearchInDescriptionTitleSearchPage(boolean search){
        checkBoxSearch(search,getters.getOnlyDescriptionTitleSearchPage());
    }

    public void checkBoxSearchOnlyByPhotoSearchPage(boolean photo){
        checkBoxSearch(photo,getters.getOnlyPhotoSearchPage());
    }

    public void checkBoxSearchByDeliverySearchPage(boolean delivery){
        checkBoxSearch(delivery,getters.getOnlyDeliverySearchPage());
    }

    private void priceFromSearchPage(Integer price){
        pricing(price,getters.getButtonFromPriceSearchPage(),getters.getInputFromPriceSearchPage());
    }

    private void priceToSearchPage(Integer price){
        pricing(price,getters.getButtonToPriceSearchPage(), getters.getInputToPriceSearchPage());
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
        sortListByName(nameAdvert, getters.getListAdvertSearchPage());
    }

    /**
     * Самые новые
     * Самые дешевые
     * Самые дорогие
     **/
    public void forDefiningSortingCriteriaSearchPage(String nameCriteria){
        sortListByName(nameCriteria,getters.getListByTheCriteriaSearchPage());
    }

    /**
     * грн
     * $
     * €
     **/
    public void forDeterminingTheCurrencySearchPage(String nameCurrency){
        sortListByName(nameCurrency, getters.getListCurrencySearchPage());
    }

    /**
     * Список
     * Галерея
     **/
    public void methodForDisplayingGoodsSearchPage(String nameView){
        sortListByName(nameView,getters.getListViewSearchPage());
    }

    public void viewAllProductsOnTheSearchPage(){
        WebElement element = driver.findElement(getters.getViewAllProductSearchPage());
        element.click();
    }

    public void nextPageNumberOnSearchPage(Integer numberPage){
        javaScriptExecutorScrollPage();
        waitSecond(3);
        visibilityElementOnPageBySelector(getters.getBoxCloseCookieWindowSearchPage());
        List<WebElement> elementsPager = driver.findElements(getters.getNextNumberSearchPage());
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
        switchingPage(nextPage, getters.getNextButtonSearchPage());
    }

    public void previousPageButtonOnSearchPage(boolean previousPage){
        switchingPage(previousPage,getters.getPreviousButtonSearchPage());
    }

    public void tabToEntrance(String userEmailOrNumberPhone, String userPass){
        driver.findElement(getters.getTabEntranceLoginPage()).click();
        driver.findElement(getters.getFieldUserEmailLogin()).sendKeys(userEmailOrNumberPhone);
        driver.findElement(getters.getFieldUserPassLogin()).click();
        driver.findElement(getters.getFieldUserPassLogin()).sendKeys(userPass);
        driver.findElement(getters.getButtonSubmitEntranceLogin()).submit();
    }

    public void tabToRegister(String userEmailOrNumberPhone){
        driver.findElement(getters.getTabRegisterLoginPage()).click();
        driver.findElement(getters.getFieldUserEmailPhoneRegister()).sendKeys(userEmailOrNumberPhone);
        driver.findElement(getters.getCheckBoxArgumentRegister()).click();
        driver.findElement(getters.getButtonSubmitRegister()).submit();
    }

    public void tabToEntranceFacebookLogin(){
        driver.findElement(getters.getTabEntranceLoginPage()).click();
        driver.findElement(getters.getTabEntranceFacebookLogin()).click();
    }

    public void tabToEntranceFacebookRegister(){
        driver.findElement(getters.getTabRegisterLoginPage()).click();
        driver.findElement(getters.getTabEntranceFacebookRegister()).click();
    }
}
