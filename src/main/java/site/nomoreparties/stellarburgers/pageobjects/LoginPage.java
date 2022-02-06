package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //ссылка Зарегистрироваться
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement signUpLink;

    //email
    @FindBy(how = How.NAME,using="name")
    private SelenideElement emailField;

    //пароль
    @FindBy(how = How.NAME,using="Пароль")
    private SelenideElement passwordField;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement signInButton;

    //заголовок Вход
    @FindBy(how = How.XPATH,using = ".//h2[text()='Вход']")
    private SelenideElement signInHeader;

    @Step("Sign Up")
    public SignUpPage pressSignUpLink(){
        signUpLink.click();
        return page(SignUpPage.class);
    }

    @Step("Set email")
    public void setEmail(String email){
        emailField.setValue(email);
    }

    @Step("Set password")
    public void setPassword(String password){
        passwordField.setValue(password);
    }

    @Step("Sign In")
    public MainPage pressSignInButton(){
        signInButton.click();
        return page(MainPage.class);
    }

    public String getSignInHeader() {
        return signInHeader.getText();
    }
}
