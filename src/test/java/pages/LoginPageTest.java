package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import olxproject.interfacepage.Getters;
import olxproject.pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public WebDriverManager firefoxdriver;


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver();
    }

    @Before
    public void setUp(){
        firefoxdriver = WebDriverManager.firefoxdriver();
        firefoxdriver.clearCache();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/account/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void registerNewUser(){
        loginPage.tabToEntrance("Name","3784hdkrue");
        String text = loginPage.getText(Getters.getTabEntranceLoginPage());
        Assert.assertEquals("Войти", text);
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


    @After
    public void testDown(){
        driver.quit();
    }
}
