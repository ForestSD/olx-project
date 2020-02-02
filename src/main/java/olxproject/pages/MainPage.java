package olxproject.pages;

import olxproject.interfacepage.OlxManager;
import org.openqa.selenium.WebDriver;

public class MainPage extends OlxManager {

    private OlxManager manager;

    public MainPage(WebDriver driver, OlxManager manager) {
        super(driver);
        this.manager = manager;
    }


    private void serchProductByCity(String city,String product){
        manager.checkForAlert();
        manager.specificCity(city);
        manager.headerSearchMainPage(product);
    }

    private void serchProductWholeCountry(String product){
        manager.checkForAlert();
        manager.wholeCountry();
        manager.headerSearchMainPage(product);
    }

    private void enterOnLoginPage(){
        manager.clickButtonPostAn();
    }

    private void serchProductByCategoris(String categorie, String subCategorie){
        manager.listCategoriesOnMainPage(categorie, subCategorie);
    }

    private void chengeLanguageOnPage(String lang){
        manager.changeLanguage(lang);
    }



}