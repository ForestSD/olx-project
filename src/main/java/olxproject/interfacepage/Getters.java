package olxproject.interfacepage;

import org.openqa.selenium.By;

public class Getters {

    private By fieldSearchMainPage = By.xpath("//input[@id='headerSearch']");
    private By fieldCityMainPage = By.xpath("//input[@id='cityField']");
    private By regionSelectionMainPage = By.xpath("//div[@id='regionslinks']//ul//li");
    private By citySelectionMainPage = By.xpath("//div[@id='subregionslinks']//ul//li");
    private By buttonSearchMainMainPage = By.xpath("//input[@id='submit-searchmain']");
    private By mainCategoriesMainPage = By.xpath("//div[@class='maincategories']//div//div//a//span");
    private By alertElementCloseWindowMainPage = By.xpath("//div[@class='gtm-survey__close js-gtm-survey-close']");

    private By headerLogoBasePage = By.xpath("//a[@id='headerLogo']");
    private By buttonPostAnBasePage = By.xpath("//a[@id='postNewAdLink']//span");
    private By myProfileBasePage = By.xpath("//span[@class='link inlblk']//strong");
    private By languageOnBasePage = By.xpath("//ul[@class='breaklist inlblk']//li");
    private By searchAreaBasePage = By.xpath("//input[@id='cityField']");
    private By wholeCountryBasePage = By.xpath("//a[@class='regionSelectA1']");
    private String localCategoriesString = "//div[@id='%s']//ul//li//a";
    private By downElementOnPage = By.xpath("//div[@class='pager rel clr']");
    private String scrollOnDownPage = "arguments[0].scrollIntoView();";

    private By tabEntranceLoginPage = By.xpath("//section[@class='login-page']//a[@id='login_tab']");
    private By tabRegisterLoginPage = By.xpath("//section[@class='login-page']//a[@id='register_tab']");
    private By tabEntranceFacebookLogin = By.xpath("//section[@class='login-page']//a[@id='fblogin']");
    private By fieldUserEmailLogin = By.xpath("//section[@class='login-page']//input[@id='userEmail']");
    private By fieldUserPassLogin = By.cssSelector("input#userPass");
    private By buttonSubmitEntranceLogin = By.xpath("//section[@class='login-page']//button[@id='se_userLogin']");
    private By fieldUserEmailPhoneRegister = By.xpath("//li[@class='active']//input[@id='userEmailPhoneRegister']");
    private By checkBoxArgumentRegister = By.cssSelector("div > span + label");
    private By tabEntranceFacebookRegister = By.xpath("//li[@class='active']//form[@id='registerForm']//a[@class='login-button login-button--facebook'][contains(text(),'Facebook')]");
    private By buttonSubmitRegister = By.xpath("//li[@class='active']//button[@id='button_register']");

    private By fieldSearchOnSearchPage = By.xpath("//input[@id='search-text']");
    private By categoriesHeadingSearchPage = By.xpath("//span[@class='block overh']");
    private By submitSearchPage = By.xpath("//input[@id='search-submit']");
    private By listAdvertSearchPage = By.cssSelector(".sort-order-type li.fleft");
    private By listByTheCriteriaSearchPage = By.cssSelector(".sort-order-type li a.link");
    private By listCurrencySearchPage = By.cssSelector(".view-currency li span");
    private By listViewSearchPage = By.xpath("//ul[@id='viewSelector']//span");
    private By boxCloseAlertWindowSearchPage = By.xpath("//ul[@id='viewSelector']//span");
    private By boxCloseCookieWindowSearchPage = By.xpath(".cookie-close");
    private By onlyDescriptionTitleSearchPage = By.cssSelector("div > label[for = title-desc]");
    private By onlyPhotoSearchPage = By.cssSelector("div > label[for = photo-only]");
    private By onlyDeliverySearchPage = By.cssSelector("div > label[for = safedeal-only]");
    private By buttonFromPriceSearchPage = By.cssSelector(".button-from");
    private By buttonToPriceSearchPage = By.cssSelector(".button-to");
    private By inputFromPriceSearchPage = By.cssSelector(".filter-item-from input");
    private By inputToPriceSearchPage = By.cssSelector(".filter-item-to input");
    private By viewAllProductSearchPage = By.cssSelector("a.x-normal span");
    private By nextNumberSearchPage = By.cssSelector(".pager span");
    private By nextButtonSearchPage = By.xpath("//a[@class='link pageNextPrev {page:2}']");
    private By previousButtonSearchPage = By.xpath("//span[contains(text(),'«')]");
    private String locatorCheckHeading = "//ul[@id='categorySelectList']//a[contains(text(),'%s')]";

    public By getAlertElementCloseWindowMainPage() {
        return alertElementCloseWindowMainPage;
    }

    public By getFieldSearchMainPage() {
        return fieldSearchMainPage;
    }

    public By getFieldCityMainPage() {
        return fieldCityMainPage;
    }

    public By getRegionSelectionMainPage() {
        return regionSelectionMainPage;
    }

    public By getCitySelectionMainPage() {
        return citySelectionMainPage;
    }

    public By getButtonSearchMainMainPage() {
        return buttonSearchMainMainPage;
    }

    public By getMainCategoriesMainPage() {
        return mainCategoriesMainPage;
    }


    By getHeaderLogoBasePage() {
        return headerLogoBasePage;
    }

    By getButtonPostAnBasePage() {
        return buttonPostAnBasePage;
    }

    By getMyProfileBasePage() {
        return myProfileBasePage;
    }

    By getLanguageOnBasePage() {
        return languageOnBasePage;
    }

    By getSearchAreaBasePage() {
        return searchAreaBasePage;
    }

    By getWholeCountryBasePage() {
        return wholeCountryBasePage;
    }

    String getLocalCategoriesString() {
        return localCategoriesString;
    }

    By getDownElementOnPage() {
        return downElementOnPage;
    }

    String getScrollOnDownPage() {
        return scrollOnDownPage;
    }

    public By getTabEntranceLoginPage() {
        return tabEntranceLoginPage;
    }

    public By getTabRegisterLoginPage() {
        return tabRegisterLoginPage;
    }

    public By getTabEntranceFacebookLogin() {
        return tabEntranceFacebookLogin;
    }

    public By getFieldUserEmailLogin() {
        return fieldUserEmailLogin;
    }

    public By getFieldUserPassLogin() {
        return fieldUserPassLogin;
    }

    public By getButtonSubmitEntranceLogin() {
        return buttonSubmitEntranceLogin;
    }

    public By getFieldUserEmailPhoneRegister() {
        return fieldUserEmailPhoneRegister;
    }

    public By getCheckBoxArgumentRegister() {
        return checkBoxArgumentRegister;
    }

    public By getTabEntranceFacebookRegister() {
        return tabEntranceFacebookRegister;
    }

    public By getButtonSubmitRegister() {
        return buttonSubmitRegister;
    }


    public By getFieldSearchOnSearchPage() {
        return fieldSearchOnSearchPage;
    }

    public By getCategoriesHeadingSearchPage() {
        return categoriesHeadingSearchPage;
    }

    public By getSubmitSearchPage() {
        return submitSearchPage;
    }

    public By getListAdvertSearchPage() {
        return listAdvertSearchPage;
    }

    public By getListByTheCriteriaSearchPage() {
        return listByTheCriteriaSearchPage;
    }

    public By getListCurrencySearchPage() {
        return listCurrencySearchPage;
    }

    public By getListViewSearchPage() {
        return listViewSearchPage;
    }

    public By getBoxCloseAlertWindowSearchPage() {
        return boxCloseAlertWindowSearchPage;
    }

    public By getBoxCloseCookieWindowSearchPage() {
        return boxCloseCookieWindowSearchPage;
    }

    public By getOnlyDescriptionTitleSearchPage() {
        return onlyDescriptionTitleSearchPage;
    }

    public By getOnlyPhotoSearchPage() {
        return onlyPhotoSearchPage;
    }

    public By getOnlyDeliverySearchPage() {
        return onlyDeliverySearchPage;
    }

    public By getButtonFromPriceSearchPage() {
        return buttonFromPriceSearchPage;
    }

    public By getButtonToPriceSearchPage() {
        return buttonToPriceSearchPage;
    }

    public By getInputFromPriceSearchPage() {
        return inputFromPriceSearchPage;
    }

    public By getInputToPriceSearchPage() {
        return inputToPriceSearchPage;
    }

    public By getViewAllProductSearchPage() {
        return viewAllProductSearchPage;
    }

    public By getNextNumberSearchPage() {
        return nextNumberSearchPage;
    }

    public By getNextButtonSearchPage() {
        return nextButtonSearchPage;
    }

    public By getPreviousButtonSearchPage() {
        return previousButtonSearchPage;
    }

    public String getLocatorCheckHeading() {
        return locatorCheckHeading;
    }

}
