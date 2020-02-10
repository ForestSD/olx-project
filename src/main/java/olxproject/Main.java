package olxproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static olxproject.InitConfig.getConfig;
import static olxproject.InitDriver.initDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        initDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");
        getConfig();
    }



}
