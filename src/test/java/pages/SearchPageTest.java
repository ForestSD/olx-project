package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.interfacepage.Getters;
import olxproject.pages.SearchPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageTest {

    public WebDriver driver;
    public SearchPage searchPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver();
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/list/");
        searchPage = new SearchPage(driver);
    }


    @Test
    public void headerSearch(){
        searchPage.headerSearchOnSearchPage("Iphone");
    }

    @Test
    public void changeLanguage(){
        searchPage.changeLanguage("мова");
    }

    @Test
    public void searchWholeCountry(){
        searchPage.wholeCountry();
    }

    @Test
    public void clickButtonPostAn(){
        searchPage.clickButtonPostAn();
    }

    @Test
    public void clickHeaderLogo(){
        searchPage.clickOnHeaderLogoPage();
        String text = searchPage.getText(Getters.getHeaderLogoBasePage());
        Assert.assertEquals(text,"На главную OLX - бесплатные объявления");
    }

    @Test
    public void clickButtonInMyProfile(){
        searchPage.clickButtonMyProfile();
    }

    @Test
    public void checkHeadingCategory(){
        searchPage.checkHeadingSearchPage("Электроника");
    }

    @Test
    public void checkBoxDelivery(){
        searchPage.checkBoxSearchByDeliverySearchPage(true);
    }

    @Test
    public void checkBoxPhoto(){
        searchPage.checkBoxSearchOnlyByPhotoSearchPage(true);
    }

    @Test
    public void checkBoxDescriptionTitle(){
        searchPage.checkBoxSearchInDescriptionTitleSearchPage(true);
    }

    @Test
    public void checkPriceFrom(){
        searchPage.priceFromSearchPage(500);
    }

    @Test
    public void checkPriceTo(){
        searchPage.priceToSearchPage(1000);
    }

    @Test
    public void checkPriceFromAndTo(){
        searchPage.priceFromAndTo(100, 1000);
    }

    @Test
    public void viewAllProduct(){
        searchPage.viewAllProductsOnTheSearchPage();
    }

    @Test
    public void nextPage(){
        searchPage.nextPageButtonOnSearchPage(true);
    }

    @Test
    public void nextPageNumber(){
        searchPage.nextPageNumberOnSearchPage(9);
    }


    @After
    public void testDown(){
        driver.quit();
    }
}
