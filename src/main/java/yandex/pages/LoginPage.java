package yandex.pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import yandex.model.UserModel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    final public static String URL = MainPage.URL + "login";


    SelenideElement loginButton = $(By.xpath("//button[text()='Войти']"));
    SelenideElement userLoginText = $(By.xpath("//h2[text()='Вход']"));
    SelenideElement restorePasswordLink = $(By.xpath("//a[text()='Восстановить пароль']"));
    SelenideElement registerLink = $(By.xpath("//a[text()='Зарегистрироваться']"));
    SelenideElement emailInputField = $(By.xpath("//label[@class='input__placeholder text noselect text_type_main-default'][text()='Email']/parent::div/input"));
    SelenideElement passwordInputField = $(By.xpath("//label[@class='input__placeholder text noselect text_type_main-default'][text()='Пароль']/parent::div/input"));

    @Step("Нажать кнопку Регистрация")
    public RegisterPage clickRegisterLink() {
        registerLink.shouldBe(visible).click();
        return Selenide.page(RegisterPage.class);
    }

    @Step("Нажать сбросить пароль")
    public ForgotPasswordPage clickRestorePasswordLink() {
        restorePasswordLink.click();
        return Selenide.page(ForgotPasswordPage.class);
    }

    @Step("Нажать Войти")
    public MainPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(MainPage.class);
    }

    @Step("Заполнить Email")
    public LoginPage inputEmail(String email) {
        emailInputField.sendKeys(email);
        return this;
    }

    @Step("Заполнить пароль")
    public LoginPage inputPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Заполнить Email и пароль, нажать кнопку Войти")
    public MainPage userLogin(UserModel user) {
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickLoginButton();
        return Selenide.page(MainPage.class);
    }

    public boolean isUserLoginTextDisplayed() {
        return userLoginText.shouldBe(visible).isDisplayed();
    }
}