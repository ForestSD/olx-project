package olxproject.interfacepage;

import olxproject.enumcategoris.CategoriesId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class OlxManager extends BasePage implements Methods {
    private WebDriver driver;

    public OlxManager(WebDriver driver) {
        super(driver);
    }

    private Getters getters = new Getters();
    private BasePage basePage;

    public void closeAlertWindowMainPage(){
        this.visibilityElementOnPageBySelector(getters.getAlertElementCloseWindowMainPage());
    }

    public void headerSearchMainPage(String product){
        WebElement element = basePage.findElementBy(getters.getFieldSearchMainPage());
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
        basePage.clickElement(getters.getSubmitSearchPage());
    }

    public void headerSearchOnSearchPage(String product) {
        basePage.sendKeysElement(getters.getFieldSearchOnSearchPage(),product);
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
    public void forDisplayingGoodsSearchPage(String nameView){
        sortListByName(nameView,getters.getListViewSearchPage());
    }

    public void viewAllProductsOnTheSearchPage(){
        basePage.clickElement(getters.getViewAllProductSearchPage());
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
        basePage.clickElement(getters.getTabEntranceLoginPage());
        basePage.sendKeysElement(getters.getFieldUserEmailLogin(), userEmailOrNumberPhone);
        basePage.clickElement(getters.getFieldUserPassLogin());
        basePage.sendKeysElement(getters.getFieldUserPassLogin(),userPass);
        basePage.submitElement(getters.getButtonSubmitEntranceLogin());
    }

    public void tabToRegister(String userEmailOrNumberPhone){
        basePage.clickElement(getters.getTabRegisterLoginPage());
        basePage.sendKeysElement(getters.getFieldUserEmailPhoneRegister(),userEmailOrNumberPhone);
        basePage.clickElement(getters.getCheckBoxArgumentRegister());
        basePage.submitElement(getters.getButtonSubmitRegister());
    }

    public void tabToEntranceFacebookLogin(){
        basePage.clickElement(getters.getTabEntranceLoginPage());
        basePage.clickElement(getters.getTabEntranceFacebookLogin());
    }

    public void tabToEntranceFacebookRegister(){
        basePage.clickElement(getters.getTabRegisterLoginPage());
        basePage.clickElement(getters.getTabEntranceFacebookRegister());
    }

    @Override
    public void headerSearch(String product) {
        driver.findElement(getters.getFieldSearchOnSearchPage()).sendKeys(product);
        submitSearch();
    }

    @Override
    public void submitSearch() {
        driver.findElement(getters.getSubmitSearchPage()).click();
    }
}
