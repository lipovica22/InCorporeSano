package steps.Login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

import java.io.IOException;

public class LoginSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    @Before
    public void setup() throws Exception{
        initialization(browser);
        //driver.get("https://mediately.co/rs");
    }

    @After
    public void tearDown () throws IOException {
        takeScreenshot("slika" + System.currentTimeMillis());
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("Open app ICD1")
    public void OpenAppICD1()  {
        driver.get("https://mediately.co/rs");
    }

    @When("accept cookies1")
    public void acceptCookies1() throws Exception {
        new HomePage(driver).acceptCoocies();
    }

    @And("click on Login")
    public void clickOnLogin() throws Exception{
        new HomePage(driver).Prijava();
    }

    @And("enter email {string}")
    public void enterEmail(String email) throws Exception{
        new LoginPage(driver).setEmail(email);
    }

    @And("enter password {string}")
    public void enterPassword(String password) throws Exception {
        new LoginPage(driver).setLozinka(password);
    }
    @And("click on Submit button")
    public void clickOnSubmitButton() throws Exception{
        new LoginPage(driver).clickSubmit();
    }

    @Then("Logged in")
    public void loggedIn() throws Exception {
        Assert.assertEquals(driver.getCurrentUrl(), "https://mediately.co/rs");
        new LoginPage(driver).user();
    }

}
