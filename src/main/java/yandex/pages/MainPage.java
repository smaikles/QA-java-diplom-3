package yandex.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";



    private SelenideElement loginButton = $(By.xpath("//button[text()='Войти в аккаунт']"));
    private SelenideElement orderButton = $(By.xpath("//button[text()='Оформить заказ']"));
    private SelenideElement profileLink= $(By.xpath("//p[text()='Личный Кабинет']"));
    private SelenideElement createBurgerText= $(By.xpath("//h1[text()='Соберите бургер']"));
    private SelenideElement bunsTab= $(By.xpath("//span[text()='Булки']//parent::div"));
    private SelenideElement saucesTab= $(By.xpath("//span[text()='Соусы']//parent::div"));
    private SelenideElement fillingsTab= $(By.xpath("//span[text()='Начинки']//parent::div"));
    private SelenideElement ingredientsScrollDown= $(By.name("BurgerIngredients_ingredients__list__2A-mT"));


    public MainPage() {
       //  new WebDriverWait(WebDriverRunner.getWebDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Личный Кабинет']")));
    }

    @Step("Нажать кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Нажать кнопку Оформить заказ")
    public LoginPage clickOrderButton() {
        orderButton.click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isOrderButtonDisplayed() {
        return orderButton.shouldBe(visible).isDisplayed();
    }

    @Step("Нажать кнопку Личный кабинет")
    public LoginPage clickProfileLink() {
        profileLink.click();
        return Selenide.page(LoginPage.class);
    }
    @Step("Нажать кнопку Личный кабинет после логина")
    public ProfilePage clickProfileLinkUserLogged() {
        profileLink.click();
        return Selenide.page(ProfilePage.class);
    }

    public boolean isCreateBurgerTextDisplayed() {
        return createBurgerText.shouldBe(visible).isDisplayed();
    }


    public MainPage displayAvailableBuns() {
        bunsTab.click();
     //   Selenide.sleep(3000);
        return this;
    }

    public MainPage displayAvailableSauces() {
        saucesTab.click();
      //  Selenide.sleep(3000);
        return this;
    }

    public MainPage displayAvailableFillings() {
        fillingsTab.click();
      //  Selenide.sleep(3000);
        return this;
    }

    public String getBunsTabClassValue() {
        return bunsTab.getAttribute("class");
    }

    public String getSaucesTabClassValue() {
        return saucesTab.getAttribute("class");
    }

    public String getFillingsTabClassValue() {
        return fillingsTab.getAttribute("class");
    }
}
