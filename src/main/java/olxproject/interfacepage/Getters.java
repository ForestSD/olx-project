package olxproject.interfacepage;

import org.openqa.selenium.By;

public class Getters {

    public static By fieldSearchMainPage = By.xpath("//input[@id='headerSearch']");
    public static By fieldCityMainPage = By.xpath("//input[@id='cityField']");
    public static By regionSelectionMainPage = By.xpath("//div[@id='regionslinks']//ul//li");
    public static By citySelectionMainPage = By.xpath("//div[@id='subregionslinks']//ul//li");
    public static By buttonSearchMainMainPage = By.xpath("//input[@id='submit-searchmain']");
    public static By mainCategoriesMainPage = By.xpath("//div[@class='maincategories']//div//div//a//span");
    public static By alertElementCloseWindowMainPage = By.xpath("//div[@class='gtm-survey__close js-gtm-survey-close']");

    public static By headerLogoBasePage = By.xpath("//a[@id='headerLogo']");
    public static By buttonPostAnBasePage = By.xpath("//a[@id='postNewAdLink']//span");
    public static By myProfileBasePage = By.xpath("//span[@class='link inlblk']//strong");
    public static By languageOnBasePage = By.xpath("//ul[@class='breaklist inlblk']//li");
    public static By searchAreaBasePage = By.xpath("//input[@id='cityField']");
    public static By wholeCountryBasePage = By.xpath("//a[@class='regionSelectA1']");
    public static String localCategoriesString = "//div[@id='%s']//ul//li//a";
    public static By downElementOnPage = By.xpath("//div[@class='pager rel clr']");
    public static String scrollOnDownPage = "arguments[0].scrollIntoView();";

    public static By tabEntranceLoginPage = By.xpath("//section[@class='login-page']//a[@id='login_tab']");
    public static By tabRegisterLoginPage = By.xpath("//section[@class='login-page']//a[@id='register_tab']");
    public static By tabEntranceFacebookLogin = By.xpath("//section[@class='login-page']//a[@id='fblogin']");
    public static By fieldUserEmailLogin = By.xpath("//section[@class='login-page']//input[@id='userEmail']");
    public static By fieldUserPassLogin = By.cssSelector("input#userPass");
    public static By buttonSubmitEntranceLogin = By.xpath("//section[@class='login-page']//button[@id='se_userLogin']");
    public static By fieldUserEmailPhoneRegister = By.xpath("//li[@class='active']//input[@id='userEmailPhoneRegister']");
    public static By checkBoxArgumentRegister = By.cssSelector("div > span + label");
    public static By tabEntranceFacebookRegister = By.xpath("//li[@class='active']//form[@id='registerForm']//a[@class='login-button login-button--facebook'][contains(text(),'Facebook')]");
    public static By buttonSubmitRegister = By.xpath("//li[@class='active']//button[@id='button_register']");

    public static By fieldSearchOnSearchPage = By.xpath("//input[@id='search-text']");
    public static By categoriesHeadingSearchPage = By.xpath("//span[@class='block overh']");
    public static By submitSearchPage = By.xpath("//input[@id='search-submit']");
    public static By listAdvertSearchPage = By.cssSelector(".sort-order-type li.fleft");
    public static By listByTheCriteriaSearchPage = By.cssSelector(".sort-order-type li a.link");
    public static By listCurrencySearchPage = By.cssSelector(".view-currency li span");
    public static By listViewSearchPage = By.xpath("//ul[@id='viewSelector']//span");
    public static By boxCloseAlertWindowSearchPage = By.xpath("//ul[@id='viewSelector']//span");
    public static By boxCloseCookieWindowSearchPage = By.xpath(".cookie-close");
    public static By onlyDescriptionTitleSearchPage = By.cssSelector("div > label[for = title-desc]");
    public static By onlyPhotoSearchPage = By.cssSelector("div > label[for = photo-only]");
    public static By onlyDeliverySearchPage = By.cssSelector("div > label[for = safedeal-only]");
    public static By buttonFromPriceSearchPage = By.cssSelector(".button-from");
    public static By buttonToPriceSearchPage = By.cssSelector(".button-to");
    public static By inputFromPriceSearchPage = By.cssSelector(".filter-item-from input");
    public static By inputToPriceSearchPage = By.cssSelector(".filter-item-to input");
    public static By viewAllProductSearchPage = By.cssSelector("a.x-normal span");
    public static By nextNumberSearchPage = By.xpath("//div[@class='pager rel clr']//span//a");
    public static By nextButtonSearchPage = By.xpath("//a[@class='link pageNextPrev {page:2}']");
    public static By previousButtonSearchPage = By.xpath("//span[contains(text(),'«')]");
    public static String locatorCheckHeading = "//ul[@id='categorySelectList']//a[contains(text(),'%s')]";

    public static By getAlertElementCloseWindowMainPage() {
        return alertElementCloseWindowMainPage;
    }

    public static By getFieldSearchMainPage() {
        return fieldSearchMainPage;
    }

    public static By getFieldCityMainPage() {
        return fieldCityMainPage;
    }

    public static By getRegionSelectionMainPage() {
        return regionSelectionMainPage;
    }

    public static By getCitySelectionMainPage() {
        return citySelectionMainPage;
    }

    public static By getButtonSearchMainMainPage() {
        return buttonSearchMainMainPage;
    }

    public static By getMainCategoriesMainPage() {
        return mainCategoriesMainPage;
    }


    public static By getHeaderLogoBasePage() {
        return headerLogoBasePage;
    }

    public static By getButtonPostAnBasePage() {
        return buttonPostAnBasePage;
    }

    public static By getMyProfileBasePage() {
        return myProfileBasePage;
    }

    public static By getLanguageOnBasePage() {
        return languageOnBasePage;
    }

    public static By getSearchAreaBasePage() {
        return searchAreaBasePage;
    }

    public static By getWholeCountryBasePage() {
        return wholeCountryBasePage;
    }

    public static String getLocalCategoriesString() {
        return localCategoriesString;
    }

    public static By getDownElementOnPage() {
        return downElementOnPage;
    }

    public static String getScrollOnDownPage() {
        return scrollOnDownPage;
    }

    public static By getTabEntranceLoginPage() {
        return tabEntranceLoginPage;
    }

    public static By getTabRegisterLoginPage() {
        return tabRegisterLoginPage;
    }

    public static By getTabEntranceFacebookLogin() {
        return tabEntranceFacebookLogin;
    }

    public static By getFieldUserEmailLogin() {
        return fieldUserEmailLogin;
    }

    public static By getFieldUserPassLogin() {
        return fieldUserPassLogin;
    }

    public static By getButtonSubmitEntranceLogin() {
        return buttonSubmitEntranceLogin;
    }

    public static By getFieldUserEmailPhoneRegister() {
        return fieldUserEmailPhoneRegister;
    }

    public static By getCheckBoxArgumentRegister() {
        return checkBoxArgumentRegister;
    }

    public static By getTabEntranceFacebookRegister() {
        return tabEntranceFacebookRegister;
    }

    public static By getButtonSubmitRegister() {
        return buttonSubmitRegister;
    }


    public static By getFieldSearchOnSearchPage() {
        return fieldSearchOnSearchPage;
    }

    public static By getCategoriesHeadingSearchPage() {
        return categoriesHeadingSearchPage;
    }

    public static By getSubmitSearchPage() {
        return submitSearchPage;
    }

    public static By getListAdvertSearchPage() {
        return listAdvertSearchPage;
    }

    public static By getListByTheCriteriaSearchPage() {
        return listByTheCriteriaSearchPage;
    }

    public static By getListCurrencySearchPage() {
        return listCurrencySearchPage;
    }

    public static By getListViewSearchPage() {
        return listViewSearchPage;
    }

    public static By getBoxCloseAlertWindowSearchPage() {
        return boxCloseAlertWindowSearchPage;
    }

    public static By getBoxCloseCookieWindowSearchPage() {
        return boxCloseCookieWindowSearchPage;
    }

    public static By getOnlyDescriptionTitleSearchPage() {
        return onlyDescriptionTitleSearchPage;
    }

    public static By getOnlyPhotoSearchPage() {
        return onlyPhotoSearchPage;
    }

    public static By getOnlyDeliverySearchPage() {
        return onlyDeliverySearchPage;
    }

    public static By getButtonFromPriceSearchPage() {
        return buttonFromPriceSearchPage;
    }

    public static By getButtonToPriceSearchPage() {
        return buttonToPriceSearchPage;
    }

    public static By getInputFromPriceSearchPage() {
        return inputFromPriceSearchPage;
    }

    public static By getInputToPriceSearchPage() {
        return inputToPriceSearchPage;
    }

    public static By getViewAllProductSearchPage() {
        return viewAllProductSearchPage;
    }

    public static By getNextNumberSearchPage() {
        return nextNumberSearchPage;
    }

    public static By getNextButtonSearchPage() {
        return nextButtonSearchPage;
    }

    public static By getPreviousButtonSearchPage() {
        return previousButtonSearchPage;
    }

    public static String getLocatorCheckHeading() {
        return locatorCheckHeading;
    }

}
