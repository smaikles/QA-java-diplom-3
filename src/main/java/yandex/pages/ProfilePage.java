package yandex.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public static final String URL = MainPage.URL + "profile";

    // локатор элемента страницы Профиль
    private SelenideElement profileText = $(By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']"));
    // локатор элемента <Конструктор>
    private SelenideElement createBurger = $(By.xpath("//p[text()='Конструктор']"));
    // локатор элемента логотип <Stellar Burgers>
    private SelenideElement burgerLogo = $(By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a"));
    // локатор кнопки <Выход>
    private SelenideElement logoutButton = $(By.xpath("//button[text()='Выход']"));

    // Метод проверки видимости текстового элемента <В этом разделе вы можете изменить свои персональные данные>
    public boolean isProfileTextDisplayed() {
        return profileText.shouldBe(visible).isDisplayed();
    }

    // Метод клика по элементу <Конструктор>
    @Step("Нажать Конструктор")
    public MainPage clickCreateBurger() {
        createBurger.click();
        return Selenide.page(MainPage.class);
    }


    // Метод клика по элементу <Логотип>
    @Step("Нажать на элемент логотип")
    public MainPage clickBurgerLogo() {
        burgerLogo.click();
        return Selenide.page(MainPage.class);
    }



    // Метод клика по кнопке <Выход>
    @Step("Нажать Выход")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return Selenide.page(LoginPage.class);
    }
}
