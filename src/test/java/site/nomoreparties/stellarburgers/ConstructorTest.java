package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Check that an user can switch between constructor tabs")
    public void checkConstructorTabs(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);

        SelenideElement fillingsTab = mainPage.chooseFilings();
        fillingsTab.shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        SelenideElement saucesTab = mainPage.chooseSauces();
        saucesTab.shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        fillingsTab.shouldHave(attribute("class"));
        SelenideElement bunsTab = mainPage.chooseBuns();
        bunsTab.shouldHave(attribute("class"));
        saucesTab.shouldHave(attribute("class"));
    }
}
