package pages;

import olxproject.pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Артем\\MavenTestENAndSeleniumWebDriver\\driver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/list/");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchCookBookInKiev(){
        searchPage.headerSearch("Кулинарная книга");
        searchPage.closeAlertWindowSearchPage();
        searchPage.specificCity("Киев");
        searchPage.submitSearch();
        searchPage.checkBoxSearchOnlyByPhoto(true);
        searchPage.forDefiningSortingCriteria("Самые дешевые");
        searchPage.nextPageNumber(4);
    }

    @After
    public void testDown(){
        driver.quit();
    }
}