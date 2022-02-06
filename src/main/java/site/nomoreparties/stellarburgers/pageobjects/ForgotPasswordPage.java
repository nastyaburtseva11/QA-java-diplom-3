package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    //ссылка войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement signInLink;

    @Step("Sign In")
    public LoginPage pressSignInLink(){
        signInLink.click();
        return page(LoginPage.class);
    }
}
