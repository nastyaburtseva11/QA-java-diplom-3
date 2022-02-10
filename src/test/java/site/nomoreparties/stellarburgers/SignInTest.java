package site.nomoreparties.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

public class SignInTest {

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
    @DisplayName("Check that an  user can sign in by Sign in button")
    public void checkSignInByMainPage() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.pressSignInButton();

        userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();

        String actualLogin = profilePage.getLogin().toLowerCase();
        MatcherAssert.assertThat(actualLogin, is(login.toLowerCase()));

    }

    @Test
    @DisplayName("Check that an user can sign in by Personal Area")
    public void checkSignInByPersonalArea() {
        SignUpPage signUpPage = open("https://stellarburgers.nomoreparties.site/register", SignUpPage.class);
        LoginPage loginPage = signUpPage.pressSignInLink();

        userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();

        String actualLogin = profilePage.getLogin().toLowerCase();
        MatcherAssert.assertThat(actualLogin, is(login.toLowerCase()));
    }

    @Test
    @DisplayName("Check that an user can sign in by Sign Up Page")
    public void checkSignInBySignUpPage() {
        SignUpPage signUpPage = open("https://stellarburgers.nomoreparties.site/register", SignUpPage.class);
        LoginPage loginPage = signUpPage.pressSignInLink();

        userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();

        String actualLogin = profilePage.getLogin().toLowerCase();
        MatcherAssert.assertThat(actualLogin, is(login.toLowerCase()));
    }

    @Test
    @DisplayName("Check that an user can sign in by Forgot Password Page")
    public void checkSignInByForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.pressSignInLink();

        userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String login = responseData.get("email");
        String password = responseData.get("password");

        loginPage.setPassword(password);
        loginPage.setEmail(login);
        MainPage mainPage = loginPage.pressSignInButton();
        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();

        String actualLogin = profilePage.getLogin().toLowerCase();
        MatcherAssert.assertThat(actualLogin, is(login.toLowerCase()));
    }

}
