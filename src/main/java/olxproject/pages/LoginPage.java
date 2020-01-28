package olxproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tabEntrance = By.xpath("//section[@class='login-page']//a[@id='login_tab']");
    private By tabRegister = By.xpath("//section[@class='login-page']//a[@id='register_tab']");

    private By tabEntranceFacebookLogin = By.xpath("//section[@class='login-page']//a[@id='fblogin']");
    private By fieldUserEmailLogin = By.xpath("//section[@class='login-page']//input[@id='userEmail']");
    private By fieldUserPassLogin = By.cssSelector("input#userPass");
    private By buttonSubmitEntranceLogin = By.xpath("//section[@class='login-page']//button[@id='se_userLogin']");

    private By fieldUserEmailPhoneRegister = By.xpath("//li[@class='active']//input[@id='userEmailPhoneRegister']");
    private By checkBoxArgumentRegister = By.cssSelector("div > span + label");
    private By tabEntranceFacebookRegister = By.xpath("//li[@class='active']//form[@id='registerForm']//a[@class='login-button login-button--facebook'][contains(text(),'Facebook')]");
    private By buttonSubmitRegister = By.xpath("//li[@class='active']//button[@id='button_register']");


    public LoginPage tabToEntrance(String userEmailOrNumberPhone,String userPass){
        driver.findElement(tabEntrance).click();
        driver.findElement(fieldUserEmailLogin).sendKeys(userEmailOrNumberPhone);
        driver.findElement(fieldUserPassLogin).click();
        driver.findElement(fieldUserPassLogin).sendKeys(userPass);
        driver.findElement(buttonSubmitEntranceLogin).submit();
        return this;
    }

    public LoginPage tabToRegister(String userEmailOrNumberPhone){
        driver.findElement(tabRegister).click();
        driver.findElement(fieldUserEmailPhoneRegister).sendKeys(userEmailOrNumberPhone);
        driver.findElement(checkBoxArgumentRegister).click();
        driver.findElement(buttonSubmitRegister).submit();
        return this;
    }

    public LoginPage tabToEntranceFacebookLogin(){
        driver.findElement(tabEntrance).click();
        driver.findElement(tabEntranceFacebookLogin).click();
        return this;
    }

    public LoginPage tabToEntranceFacebookRegister(){
        driver.findElement(tabRegister).click();
        driver.findElement(tabEntranceFacebookRegister).click();
        return this;
    }

    public void clickOnHeaderLogoMainPage(){
        driver.findElement(By.xpath("//a[@id='headerLogo']")).click();
    }

}
