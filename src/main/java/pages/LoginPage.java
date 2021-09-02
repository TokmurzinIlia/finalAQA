package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement loginField = $(By.id("txtUsername"));
    SelenideElement passwordField = $(By.id("txtPassword"));
    SelenideElement signInButton = $(By.id("btnLogin"));

    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";


    public void logInData() {

        loginField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);
        signInButton.click();
    }

    public void openLoginPage(){

        open("https://opensource-demo.orangehrmlive.com/");

    }
    public void logIn(){

        openLoginPage();
        logInData();
    }
}
