package olxproject.pages;

import olxproject.interfacepage.BasePage;
import olxproject.interfacepage.Getters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void tabToEntrance(String userEmailOrNumberPhone, String userPass){
        driver.findElement(Getters.getTabEntranceLoginPage()).click();
        driver.findElement(Getters.getFieldUserEmailLogin()).sendKeys(userEmailOrNumberPhone);
        driver.findElement(Getters.getFieldUserPassLogin()).click();
        driver.findElement(Getters.getFieldUserPassLogin()).sendKeys(userPass);
        driver.findElement(Getters.getButtonSubmitEntranceLogin()).submit();
    }

    public void tabToRegister(String userEmailOrNumberPhone){
        driver.findElement(Getters.getTabRegisterLoginPage()).click();
        driver.findElement(Getters.getFieldUserEmailPhoneRegister()).sendKeys(userEmailOrNumberPhone);
        driver.findElement(Getters.getCheckBoxArgumentRegister()).click();
        driver.findElement(Getters.getButtonSubmitRegister()).submit();
    }

    public void tabToEntranceFacebookLogin(){
        driver.findElement(Getters.getTabEntranceLoginPage()).click();
        driver.findElement(Getters.getTabEntranceFacebookLogin()).click();
    }

    public void tabToEntranceFacebookRegister(){
        driver.findElement(Getters.getTabRegisterLoginPage()).click();
        driver.findElement(Getters.getTabEntranceFacebookRegister()).click();
    }

    public String getText(By element){
        return driver.findElement(element).getText();
    }
}
