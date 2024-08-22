package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPages;

import java.time.Duration;

public class LoginStepDef {
    WebDriver driver;
    LoginPages loginPage;

    public LoginStepDef() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPages(driver);
    }

    @When("User inputs valid credentials")
    public void userInputsValidCredentials() {
        loginPage.inputCredential("student", "Password123");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("User logins successfully")
    public void userLoginsSuccessfully() {
        assert driver.getCurrentUrl().equals("");
    }

    @When("^User inputs login details with \"([^\"]*)\", \"([^\"]*)\"$")
    public void userInputsLoginDetailsWith(String username, String password) {
        loginPage.inputCredential(username, password);
    }

    @Then("^User gets login error \"([^\"]*)\"$")
    public void userGetsLoginError(String errorMessage) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + errorMessage + "')]"))
        );
    }

    @Given("User is on practicesautomation page")
    public void userIsOnPracticesautomationPage() {
        loginPage.openLoginPage();
    }

    @And("User click submit button")
    public void userClickSubmitButton() {
    }


}
