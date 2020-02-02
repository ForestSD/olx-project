package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.interfacepage.OlxManager;
import olxproject.pages.LoginPage;
import olxproject.pages.MainPage;
import olxproject.pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private LoginPage loginPage;
    private OlxManager manager;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");
        mainPage = new MainPage(driver,manager);
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void searchIphoneInKiev(){
        mainPage.clickOnHeaderLogoPage();
        mainPage.closeAlertWindow();
        mainPage.choosingTheRightCity("Киевская","Киев");
        mainPage.headerSearch("Iphone 7");
        mainPage.submitSearch();
        searchPage.nextPageButton(true);
        searchPage.clickOnHeaderLogoPage();
    }

    @Test
    public void searchBikeInOdessa(){
        mainPage.clickOnHeaderLogoPage();
        mainPage.closeAlertWindow();
        mainPage.choosingTheRightCity("Одесская","Одесса");
        mainPage.headerSearch("Велосипед");
        mainPage.submitSearch();
        searchPage.clickOnHeaderLogoPage();
    }

    @Test
    public void searchTransportWholeCountry(){
        mainPage.clickOnHeaderLogoPage();
        mainPage.closeAlertWindow();
        mainPage.wholeCountry();
        mainPage.listCategories("Транспорт","Мото");
        searchPage.clickOnHeaderLogoPage();
    }

    @Test
    public void searchTeddyBeerInKharkiv(){
        mainPage.clickOnHeaderLogoPage();
        mainPage.closeAlertWindow();
        mainPage.specificCity("Харьков");
        mainPage.headerSearch("Плюшевый медведь");
        mainPage.submitSearch();
        searchPage.clickOnHeaderLogoPage();
    }

    @Test
    public void clickButtonInMyAccount(){
        mainPage.clickOnHeaderLogoPage();
        mainPage.closeAlertWindow();
        mainPage.clickButtonMyProfile();
        loginPage.clickOnHeaderLogoMainPage();
    }

    @After
    public void testDown(){
        driver.quit();
    }
}
