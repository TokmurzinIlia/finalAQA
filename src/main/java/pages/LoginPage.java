package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement loginField = $(By.id("txtUsername"));
    SelenideElement passwordField = $(By.id("txtPassword"));
    SelenideElement signInButton = $(By.id("btnLogin"));
    public SelenideElement loginPageLoginPanel = $(By.id("logInPanelHeading"));

    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";

    @Step("Login details")
    public void logInData() {

        loginField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);
        signInButton.click();
    }
    @Step("Open Login Page")
    public void openLoginPage(){

        open("https://opensource-demo.orangehrmlive.com/");

    }

    @Step("Login")
    public void logIn(){

        openLoginPage();
        logInData();
    }
    @Step("Logout")
    public void logOut(){
        $(By.id("welcome")).click();
        $(By.xpath("//a[text()=\"Logout\"]")).click();
    }
}
