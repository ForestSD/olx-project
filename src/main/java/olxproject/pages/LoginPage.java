package olxproject.pages;

import olxproject.interfacepage.OlxManager;
import org.openqa.selenium.WebDriver;

public class LoginPage extends OlxManager {

    private OlxManager manager;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private void enterByLogin(String user, String pass ){
        manager.tabToEntrance(user, pass);
    }

    private void enterByRegister(String phoneOrEmail){
        manager.tabToRegister(phoneOrEmail);
    }

    private void enterByLoginFaceBook(){
        manager.tabToEntranceFacebookLogin();
    }

    private void enterByRegisterFaceBook(){
        manager.tabToEntranceFacebookRegister();
    }
}
