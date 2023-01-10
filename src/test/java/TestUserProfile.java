import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.model.*;
import yandex.pages.*;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertTrue;


public class TestUserProfile extends StandartTest {

    private UserClient userClient;
    private UserModel userModel;
    private String bearerToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        userModel = UserModel.getRandom();
        UserCredentials creds = UserCredentials.from(userModel);
        userClient.registerNewUser(userModel);
        bearerToken = userClient.login(creds)
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .path("accessToken");
    }

    @After
    public void teardown() {
        userClient.delete(userModel.getEmail(), bearerToken);
    }


    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет» - Успешно")
    public void successfullyDisplayUserProfile() {
        final boolean profileTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .isProfileTextDisplayed();
        assertTrue(profileTextDisplayed);
    }

    @Test
    @DisplayName("Проверь переход по клику на «Конструктор» - Успешно")
    public void successfullyDisplayCreateBurgerTextByClickingTheCreateBurgerLink() {
        final boolean createBurgerTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickCreateBurger()
                .isCreateBurgerTextDisplayed();
        assertTrue(createBurgerTextDisplayed);
    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers - Успешно")
    public void successfullyDisplayCreateBurgerTextByClickingTheBurgerLogo() {
        final boolean createBurgerTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickBurgerLogo()
                .isCreateBurgerTextDisplayed();
        assertTrue(createBurgerTextDisplayed);
    }


    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете - Успешно")
    public void successfullyLogoutUser() {
        final boolean userLoginTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickLogoutButton()
                .isUserLoginTextDisplayed();
        assertTrue(userLoginTextDisplayed);
    }
}
