package olxproject.interfacepage;

import olxproject.pages.LoginPage;
import olxproject.pages.MainPage;
import olxproject.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class OlxManager {

    public WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    public OlxManager(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }



    public void searchProductByCity(String city,String product){
        mainPage.checkForAlert();
        mainPage.specificCity(city);
        mainPage.headerSearchMainPage(product);
    }

    public void searchProductWholeCountry(String product){
        mainPage.checkForAlert();
        mainPage.wholeCountry();
        mainPage.headerSearchMainPage(product);
    }

    public void enterOnLoginPage(){
        mainPage.clickButtonPostAn();
    }

    public void searchProductByCategoris(String categorie, String subCategorie){
        mainPage.listCategoriesOnMainPage(categorie, subCategorie);
    }


    public void searchProductAndCheckingCheckBoxSearchPage(String product){
        mainPage.headerSearchMainPage(product);
        searchPage.headerSearch(product);
        searchPage.closeAlertWindowSearchPage();
    }

    public void checkBoxActivateSearchPage(String product, boolean delivery,boolean descriptionTitle, boolean photo){
        mainPage.headerSearchMainPage(product);
        searchPage.checkBoxSearchByDeliverySearchPage(delivery);
        searchPage.checkBoxSearchInDescriptionTitleSearchPage(descriptionTitle);
        searchPage.checkBoxSearchOnlyByPhotoSearchPage(photo);
    }

    public void additionalSettingsSearchPage(String product, String criteria, String nameAdvert, String nameCurrency, String nameView){
        mainPage.headerSearchMainPage(product);
        searchPage.forDefiningSortingCriteriaSearchPage(criteria);
        searchPage.forDeterminingFromWhomTheAdWasSubmittedSearchPage(nameAdvert);
        searchPage.forDeterminingTheCurrencySearchPage(nameCurrency);
        searchPage.forDisplayingGoodsSearchPage(nameView);
    }

    public void buttonAndNumberPage(String product, boolean nextButton, boolean previousButton){
        mainPage.headerSearchMainPage(product);
        searchPage.nextPageButtonOnSearchPage(nextButton);
        searchPage.previousPageButtonOnSearchPage(previousButton);
    }



    public void changeLanguageOnPageByLoginPage(String lang){
        mainPage.clickButtonPostAn();
        mainPage.changeLanguage(lang);
    }

    public void enterByLogin(String user, String pass ){
        mainPage.clickButtonPostAn();
        loginPage.tabToEntrance(user, pass);
    }

    public void enterByRegister(String phoneOrEmail){
        mainPage.clickButtonPostAn();
        loginPage.tabToRegister(phoneOrEmail);
    }

    public void enterByLoginFaceBook(){
        mainPage.clickButtonPostAn();
        loginPage.tabToEntranceFacebookLogin();
    }

    public void enterByRegisterFaceBook(){
        mainPage.clickButtonPostAn();
        loginPage.tabToEntranceFacebookRegister();
    }

}
