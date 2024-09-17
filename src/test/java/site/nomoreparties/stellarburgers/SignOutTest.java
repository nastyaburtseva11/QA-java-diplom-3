package site.nomoreparties.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

public class SignOutTest {

    private UserOperations userOperations;

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        userOperations.delete();
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Check that an user can sign out")
    public void checkSignOut() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();
        loginPage = profilePage.pressSignOutButton();
        String expected = "Вход";
        String actual = loginPage.getSignInHeader();
        MatcherAssert.assertThat(actual, is(expected));
    }
}
