package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject {
    @FindBy(xpath = "//*[@id=\"user_email\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"user_password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"new_user\"]/div[4]/input")
    private WebElement enterButton;
    @FindBy(xpath = "//*[@id=\"parsley-id-5\"]")
    private List<WebElement> parsleyLogin;
    @FindBy(xpath = "//*[@id=\"parsley-id-7\"]")
    private List<WebElement> parsleyPassword;

    public PageObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void setLogin(String login){
        loginField.sendKeys(login);
    }
    public void setPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickEnterButton(){
        enterButton.click();
    }
    public void login(String login, String password){
        setLogin(login);
        setPassword(password);
        clickEnterButton();
    }

    public List<WebElement> getParsleyLogin() {
        return parsleyLogin;
    }

    public List<WebElement> getParsleyPassword() {
        return parsleyPassword;
    }
}
