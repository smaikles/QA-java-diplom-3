package yandex.pages;

import io.qameta.allure.Step;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import yandex.model.UserModel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    final public static String URL = MainPage.URL + "register";

    // локатор поля для ввода имени
    private SelenideElement nameInputField = $(By.xpath("//label[text()='Имя']//following-sibling::input"));
    // локатор поля для ввода email
    private SelenideElement emailInputField = $(By.xpath("//label[text()='Email']//following-sibling::input"));
    // локатор поля для ввода пароля
    private SelenideElement passwordInputField = $(By.xpath("//input[@type='password']"));
    // локатор кнопки <зарегистрироваться>
    private SelenideElement registerButton = $(By.xpath("//button[text()='Зарегистрироваться']"));
    // локатор текстового элемента <Некорректный пароль>
    private SelenideElement incorrectPasswordWarning = $(By.xpath("//p[text()='Некорректный пароль']"));
    // локатор ссылки <Войти>
    private SelenideElement loginLink = $(By.xpath("//a[text()='Войти']"));


    // метод заполнения поля ввода имени
    @Step("Заполнить поле Имя")
    public RegisterPage inputName(String name) {
        nameInputField.sendKeys(name);
        return this;
    }

    // метод заполнения поля ввода email
    @Step("Заполнить поле Имейл")
    public RegisterPage inputEmail(String email) {
        emailInputField.sendKeys(email);
        return this;
    }

    // метод заполнения поля ввода пароля
    @Step("Заполнить поле Пароль")
    public RegisterPage inputPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    // Метод клика по кнопке <Зарегистрироваться>
    @Step("Нажать кнопку Регистрация")
    public LoginPage clickRegisterButton() {
        registerButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод регистрации нового пользователя

    @Step("Заполнить форму регистрации")
    public LoginPage registerNewUser(UserModel user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();
        return Selenide.page(LoginPage.class);
    }

    // метод регистрации нового пользователя с неверным паролем
    @Step("Заполнить форму регистрации не валидными данными")
    public RegisterPage registerNewUserWithIncorrectPass(UserModel user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();
        return this;
    }

    // Метод клика по ссылке <Войти>
    @Step("Нажать кнопку Войти")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }

    // метод проверки видимости элемента <Некорректный пароль>
    public boolean isIncorrectPassDisplayed() {
        return incorrectPasswordWarning.shouldBe(visible).isDisplayed();
    }
}
