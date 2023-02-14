package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.HomePage;
import pages.LoginPage;
import pages.Tools;
import pages.VascularAge;
import tests.BaseTest;

import java.io.IOException;

public class LoginSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");

    @Before
    public void setup() throws Exception{
        initialization(browser);
    }

    @After
    public void tearDown () throws IOException {
        takeScreenshot("slika" + System.currentTimeMillis());
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }
    @AfterStep
    public void screenshot () throws IOException, InterruptedException {
        takeScreenshot("slika" + System.currentTimeMillis());
        Thread.sleep(1000);
    }
    @Given("Open app ICD")
    public void LoginOnAppICD() throws Exception {
        driver.get("https://mediately.co/rs");
    }

    @When("accept cookies")
    public void acceptCookies() throws Exception {
        new HomePage(driver).acceptCoocies();
    }

    @And("click on Login")
    public void clickOnLogin() throws Exception{
        new HomePage(driver).Prijava();
    }
    @And("enter email")
    public void enterEmail() throws Exception {
        new LoginPage(driver).setEmail();
    }

    @And("enter password")
    public void enterPassword() throws Exception{
        new LoginPage(driver).setLozinka();
    }

    @And("click on Submit button")
    public void clickOnSubmitButton() throws Exception{
        new LoginPage(driver).clickSubmit();
    }

    @Then("Loged in")
    public void logedIn() throws Exception{

    }

    @And("page is Products")
    public void pageIsProducts() throws Exception{
    }

    @And("click on AllTools")
    public void clickOnAllTools() throws Exception{
        new HomePage(driver).clickSviAlati();
    }

    @Then("page is tools")
    public void pageIsTools() throws Exception{
    }

    @And("click on VascularAgeCalkulator")
    public void clickOnVascularAgeCalkulator() throws Exception{
        new Tools(driver).clickKalkulatorVaskularneStarosti();
    }

    @Then("set male gender")
    public void setMaleGender() throws Exception{
        new VascularAge(driver).setPolMuski();
    }

    @And("set age")
    public void setAge() throws Exception{
        new VascularAge(driver).setStarost();
    }

    @And("choose nonsmoker")
    public void chooseNonsmoker() throws Exception{
        new VascularAge(driver).setNepusac();
    }

    @And("choose blood pressure")
    public void chooseBloodPressure() throws Exception{
        new VascularAge(driver).setPritisak120139();
    }

    @And("choose HDL")
    public void chooseHDL() throws Exception{
        new VascularAge(driver).setHDLHolesterol();
    }

    @Then("check vaslukar age")
    public void checkVaslukarAge() throws Exception{
        new VascularAge(driver).getVaskularnaStarostM();
    }

    @And("check risk")
    public void checkRisk() throws Exception{
        new VascularAge(driver).getRizikM();
    }


}
