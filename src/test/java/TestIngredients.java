
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import yandex.pages.*;

import static org.junit.Assert.assertEquals;

public class TestIngredients extends StandartTest {

    private final String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Булки» - Успешно")
    public void checkBunsTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableSauces()
                .displayAvailableBuns()
                .getBunsTabClassValue();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Соусы» - Успешно")
    public void checkSaucesTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableBuns()
                .displayAvailableSauces()
                .getSaucesTabClassValue();
        assertEquals(expected, actual);
    }

    @Test
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