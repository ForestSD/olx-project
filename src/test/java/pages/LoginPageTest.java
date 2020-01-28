package pages;

import olxproject.pages.LoginPage;
import olxproject.pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Артем\\MavenTestENAndSeleniumWebDriver\\driver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/account/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void registerNewUser(){
        loginPage.tabToRegister("380973348234");
        loginPage.clickOnHeaderLogoMainPage();
    }

    @Test
    public void enterUser(){
        loginPage.tabToEntrance("380937462822","736649cfhe");
    }

    @Test
    public void clickTabFacebookLogin(){
        loginPage.tabToEntranceFacebookLogin();
    }

    @Test
    public void clickTabFacebookRegister(){
        loginPage.tabToEntranceFacebookRegister();
    }

    @Test
    public void testAll(){
        loginPage.tabToEntrance("380937462822","736649cfhe");
        loginPage.tabToRegister("380973348234");
        loginPage.tabToEntranceFacebookRegister();
    }

    @After
    public void testDown(){
        driver.quit();
    }
}
