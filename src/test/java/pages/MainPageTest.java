package pages;

import olxproject.pages.MainPage;
import olxproject.pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Артем\\MavenTestENAndSeleniumWebDriver\\driver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchIphoneInKiev(){
        mainPage.clickOnHeaderLogoMainPage();
        mainPage.closeAlertWindow();
        mainPage.choosingTheRightCity("Киевская","Киев");
        mainPage.headerSearch("Iphone 7");
        mainPage.submitSearch();
        searchPage.nextPageButton(true);
        searchPage.clickOnHeaderLogoMainPage();
    }

    @Test
    public void searchBikeInOdessa(){
        mainPage.clickOnHeaderLogoMainPage();
        mainPage.closeAlertWindow();
        mainPage.choosingTheRightCity("Одесская","Одесса");
        mainPage.headerSearch("Велосипед");
        mainPage.submitSearch();
        searchPage.checkBoxSearchOnlyByPhoto(true);
        searchPage.nextPageButton(true);
        searchPage.clickOnHeaderLogoMainPage();
    }

    @Test
    public void searchTransportAllCountry(){
        mainPage.clickOnHeaderLogoMainPage();
        mainPage.closeAlertWindow();
        mainPage.wholeCountry();
        mainPage.listCategories("Транспорт","Мото");
        searchPage.closeAlertWindowSearchPage();
        searchPage.checkBoxSearchByDelivery(true);
        searchPage.forDefiningSortingCriteria("Самые дешевые");
        searchPage.forDeterminingTheCurrency("$");
        searchPage.nextPageNumber(7);
        searchPage.clickOnHeaderLogoMainPage();
    }

    @After
    public void testDown(){
        driver.quit();
    }
}
