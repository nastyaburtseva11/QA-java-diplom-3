package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.pageobjects.MainPage;
import site.nomoreparties.stellarburgers.pageobjects.ProfilePage;
import site.nomoreparties.stellarburgers.pageobjects.SignUpPage;
import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

public class SignUpTest {

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Check that an user can sign up")
    public void checkSignUpWithCorrectPassword(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.pressPersonalAreaButtonForNotAuthorizedUser();
        SignUpPage signUpPage = loginPage.pressSignUpLink();

        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        String password = RandomStringUtils.randomAlphabetic(10);
        signUpPage.setNameField(name);
        signUpPage.setEmailField(email);
        signUpPage.setPassword(password);

        loginPage = signUpPage.pressSignUpButton();

        loginPage.setPassword(password);
        loginPage.setEmail(email);

        mainPage = loginPage.pressSignInButton();

        ProfilePage profilePage = mainPage.pressPersonalAreaButtonForAuthorizedUser();

        String actualName = profilePage.getName().toLowerCase();
        String actualLogin = profilePage.getLogin().toLowerCase();
        MatcherAssert.assertThat(actualName, is(name.toLowerCase()));
        MatcherAssert.assertThat(actualLogin, is(email.toLowerCase()));
    }

    @Test
    @DisplayName("Check that an user can not sign up with incorrect password")
    public void checkSignUpWithIncorrectPassword(){
        SignUpPage signUpPage = open("https://stellarburgers.nomoreparties.site/register", SignUpPage.class);

        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        String password = RandomStringUtils.randomAlphabetic(5);
        signUpPage.setNameField(name);
        signUpPage.setEmailField(email);
        signUpPage.setPassword(password);

        signUpPage.pressSignUpButton();
        String actualMessage = signUpPage.getForgotPasswordMessage();

        String expectedMessage = "Некорректный пароль";
        MatcherAssert.assertThat(actualMessage, is(expectedMessage));
    }
}
