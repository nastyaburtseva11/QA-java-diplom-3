package site.nomoreparties.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    //локатор вкладки Булки
    @FindBy(how = How.XPATH,using = ".//div[span[text()='Булки']]")
    private SelenideElement bunsTab;

    //локатор вкладки Соусы
    @FindBy(how = How.XPATH,using = ".//div[span[text()='Соусы']]")
    private SelenideElement saucesTab;
    //локатора вкладки Начинки

    @FindBy(how = How.XPATH,using = ".//div[span[text()='Начинки']]")
    private SelenideElement fillingsTab;

    //кнопка личный кабинет
    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAreaButton;

    //кнопка войти в аккаунт
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement signInButton;

    //кнопка Соусы
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sausesButton;

    //заголовок Соберите бургер
    @FindBy(how = How.XPATH,using = ".//h1[text()='Соберите бургер']")
    private SelenideElement mainHeader;

    @Step("Choose filings")
    public SelenideElement chooseFilings(){
        fillingsTab.click();
        return fillingsTab;
    }

    @Step("Choose sauces")
    public SelenideElement chooseSauces(){
        saucesTab.click();
        return saucesTab;
    }

    @Step("Choose buns")
    public SelenideElement chooseBuns(){
        bunsTab.click();
        return bunsTab;
    }
    @Step("Go to personal area")
    public LoginPage pressPersonalAreaButtonForNotAuthorizedUser(){
        personalAreaButton.click();
        return page(LoginPage.class);
    }

    @Step("Sign in")
    public LoginPage pressSignInButton(){
        signInButton.click();
        return page(LoginPage.class);
    }

    @Step("Go to personal area")
    public ProfilePage pressPersonalAreaButtonForAuthorizedUser(){
        personalAreaButton.click();
        return page(ProfilePage.class);
    }

    public String getHeaderText(){
        return mainHeader.getText();
    }
}

