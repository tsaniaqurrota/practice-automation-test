package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends BasePages {
    private String loginPageUrl = "https://practicetestautomation.com/practice-test-login/";


    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameLogin;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordLogin;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement btnLogin;

    public LoginPages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(loginPageUrl);
    }

    public void inputCredential(String username, String password) {
        usernameLogin.sendKeys(username);
        passwordLogin.sendKeys(password);
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }
}
