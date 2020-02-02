package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/account/");
        loginPage = new LoginPage(driver, manager);
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
