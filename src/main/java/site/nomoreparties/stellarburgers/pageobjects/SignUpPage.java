package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class SignUpPage {

    //имя и email
    @FindBy(how = How.NAME,using="name")
    private ElementsCollection nameAndEmailFields;

    //пароль
    @FindBy(how = How.NAME,using="Пароль")
    private SelenideElement passwordField;

    //кнопка зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement signUpButton;

    //ссылка войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement signInLink;

    //некорректный пароль
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordLabel;

    @Step("Set name")
    public void setNameField(String name){
        nameAndEmailFields.get(0).setValue(name);
    }

    @Step("Get forgot password message")
    public String getForgotPasswordMessage(){
        return incorrectPasswordLabel.getText();
    }

    @Step("Set email")
    public void setEmailField(String email){
        nameAndEmailFields.get(1).setValue(email);
    }

    @Step("Set password")
    public void setPassword(String password){
        passwordField.setValue(password);
    }

    @Step("Press Sign Up")
    public LoginPage pressSignUpButton(){
        signUpButton.click();
        return page(LoginPage.class);
    }

    @Step("Press Sign In")
    public LoginPage pressSignInLink(){
        signInLink.click();
        return page(LoginPage.class);
    }
}