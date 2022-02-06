package site.nomoreparties.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.ProfilePage;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

public class ProfileToMainPageTest {

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Check that an authorized user can go to main from profile page by Constructor Button")
    public void checkProfileToMainByConstructorButton() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();
        mainPage = profilePage.pressConstructorButton();

        String actual = mainPage.getHeaderText();
        String expected = "Соберите бургер";
        MatcherAssert.assertThat(actual, is(expected));

    }

    @Test
    @DisplayName("Check that an authorized user can go to main from profile page by logo")
    public void checkProfileToMainByLogo() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");
        loginPage.pressSignInButton(); //костыль для логина
        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();
        mainPage = profilePage.pressProfileLogo();

        String actual = mainPage.getHeaderText();
        String expected = "Соберите бургер";
        MatcherAssert.assertThat(actual, is(expected));
        userOperations.delete();
    }
}
