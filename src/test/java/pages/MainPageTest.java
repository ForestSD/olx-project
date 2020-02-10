package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.interfacepage.Getters;
import olxproject.pages.MainPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    public WebDriver driver;
    public MainPage mainPage;


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
        mainPage = new MainPage(driver);
    }

    @Test
    public void headerSearch(){
        mainPage.headerSearchMainPage("Iphone");
        mainPage.submitSearchMainPage();
    }

    @Test
    public void changeLanguage(){
        mainPage.changeLanguage("мова");
    }

    @Test
    public void searchWholeCountry(){
        mainPage.wholeCountry();
    }

    @Test
    public void clickButtonPostAn(){
        mainPage.clickButtonPostAn();
    }

    @Test
    public void clickHeaderLogo(){
        mainPage.clickOnHeaderLogoPage();
        String text = mainPage.getText(Getters.getHeaderLogoBasePage());
        Assert.assertEquals(text,"На главную OLX - бесплатные объявления");
    }

    @Test
    public void clickButtonInMyProfile(){
        mainPage.clickButtonMyProfile();
    }

    @Test
    public void checkCategories(){
        mainPage.listCategoriesOnMainPage("Хобби","Книги");
    }

    @After
    public void testDown(){
        driver.quit();
    }
}
