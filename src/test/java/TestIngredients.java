
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.pages.*;

import static org.junit.Assert.assertEquals;
import static yandex.config.Init.setSettings;


public class TestIngredients {


    private final String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";


    @Before
    public void setUp() {
        setSettings();
        Selenide.open("/");
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Булки» - Успешно")
    public void checkBunsTabGetsActivatedSuccessfully() {
        final String actual = new MainPage()
                .displayAvailableFillings()
                .displayAvailableSauces()
                .displayAvailableBuns()
                .getBunsTabClassValue();
        assertEquals(expected, actual);
    }

  //  @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Соусы» - Успешно")
    public void checkSaucesTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableBuns()
                .displayAvailableSauces()
                .getSaucesTabClassValue();
        assertEquals(expected, actual);
    }

 //   @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Начинки» - Успешно")
    public void checkFillingsTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableSauces()
                .displayAvailableBuns()
                .displayAvailableFillings()
                .getFillingsTabClassValue();
        assertEquals(expected, actual);
    }
}
