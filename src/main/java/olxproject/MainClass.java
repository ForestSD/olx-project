package olxproject;

import olxproject.pages.MainPage;
import olxproject.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Артем\\MavenTestENAndSeleniumWebDriver\\driver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");


        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);


        mainPage.headerSearch("Iphone 6S");
        searchPage.priceTo("984");
        searchPage.sortListAdvert("Частное");
        searchPage.sortListByTheCriteria("Самые дешевые");
        searchPage.sortListCurrency("€");
        /*
        searchPage.waitAlertWindow();
        searchPage.checkBoxSearchInDescriptionTitle(true);
        searchPage.checkBoxSearchOnlyByPhoto(true);
        searchPage.checkBoxSearchByDelivery(true);
        searchPage.priceFromAndTo("893");
        searchPage.checkHeading("Недвижимость");
        searchPage.clickOnHeaderLogoMainPage();
        mainPage.choosingTheRightCity("Харьковская","Харьков");
        mainPage.listCategories("Детский Мир", "Игрушки");
        searchPage.checkBoxSearchByDelivery(true);
        searchPage.clickOnHeaderLogoMainPage();
        */
    }
}
