package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Check that an user can switch between constructor tabs")
    public void checkConstructorFilingsTabs() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);

        SelenideElement fillingsTab = mainPage.chooseFilings();
        fillingsTab.shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }

    @Test
    @DisplayName("Check that an user can switch between constructor tabs")
    public void checkConstructorSaucesTabs() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);

        SelenideElement saucesTab = mainPage.chooseSauces();
        saucesTab.shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));

    }

    @Test
    @DisplayName("Check that an user can switch between constructor tabs")
    public void checkConstructorBunsTabs() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        //сначала переходим на вкладку Соусы, чтобы проверить переход на вкладку Булочка
        SelenideElement saucesTab = mainPage.chooseSauces(); SelenideElement bunsTab = mainPage.chooseBuns();
        //проверяем что Булки выбраны
        bunsTab.shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        //проверяем что Соусы не выбраны
        saucesTab.shouldHave(attribute("class", "tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect"));
    }
}
