package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    //имя
    @FindBy(how = How.NAME,using="Name")
    private SelenideElement nameField;

    //логин
    @FindBy(how = How.NAME,using="name")
    private SelenideElement loginField;

    //конструктор
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //Профиль
    @FindBy(how = How.XPATH,using = ".//a[text()='Профиль']")
    private SelenideElement profileButton;

    //логотип
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement profileLogo;

    //кнопка Выход
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement signOutButton;

    @Step("Get name from profile")
    public String getName(){
        return nameField.getValue();
    }

    @Step("Get login from profile")
    public String getLogin(){
        return loginField.getValue();
    }

    @Step("Press Constructor button")
    public MainPage pressConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    public String getTextProfileButton(){
        return profileButton.getText();
    }

    @Step("Press logo")
    public MainPage pressProfileLogo() {
        profileLogo.click();
        return page(MainPage.class);
    }

    @Step("Press Sign Out")
    public LoginPage pressSignOutButton() {
        signOutButton.click();
        return page(LoginPage.class);
    }
}
