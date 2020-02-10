package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.interfacepage.OlxManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OlxManagerTest {

    public WebDriver driver;
    public OlxManager olxManager;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver();
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");
        olxManager = new OlxManager(driver);
    }

    @Test
    public void searchByCity(){
        olxManager.searchProductByCity("Киев", "Samsung");
    }

    @Test
    public void searchWholeCountry(){
        olxManager.searchProductWholeCountry("Iphone");
    }

    @Test
    public void enterLoginPage(){
        olxManager.enterOnLoginPage();
    }

    @Test
    public void searchProductCategoris(){
        olxManager.searchProductByCategoris("Электроника", "Телефоны");
    }

    @Test
    public void searchProductOnSearchPage(){
        olxManager.searchProductAndCheckingCheckBoxSearchPage("Колесо");
    }

    @Test
    public void checkBoxActivate(){
        olxManager.checkBoxActivateSearchPage("Чашка", true, true, true);
    }

    @Test
    public void addSettings(){
        olxManager.additionalSettingsSearchPage("Собака", "Самые дорогие", "Частное", "€","Галерея");
    }

    @Test
    public void checkButtonPage(){
        olxManager.buttonAndNumberPage("Компьютер",true, true);
    }

    @Test
    public void changeLanguage(){
        olxManager.changeLanguageOnPageByLoginPage("мова");
    }

    @Test
    public void checkLogin(){
        olxManager.enterByLogin("My name is", "489gjrf40");
    }

    @Test
    public void checkRegister(){
        olxManager.enterByRegister("380957389291");
    }

    @Test
    public void checkFaceboock(){
        olxManager.enterByLoginFaceBook();
    }

    @After
    public void testDown(){
        driver.quit();
    }

}
