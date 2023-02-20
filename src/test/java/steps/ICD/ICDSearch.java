package steps.ICD;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.HomePage;
import pages.ICD;
import tests.BaseTest;

import java.io.IOException;

public class ICDSearch extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

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

    @Given("Open app ICD")
    public void OpenAppICD()  {
        driver.get("https://mediately.co/rs");
    }
    @And("accept cookies")
    public void acceptCookies() throws Exception {
        new HomePage(driver).acceptCoocies();
    }

    @Then("input a diagnose index")
    public void inputADiagnoseInex() throws Exception{
        new ICD(driver).setPretrazivanje();

    }

    @And("check diagnose")
    public void checkDiagnose() throws Exception{
        new ICD(driver).clickDG();
    }

    @Then("get description")
    public void getDescription() throws Exception{
        new ICD(driver).getNapomena();
    }

    @And("click on MKB{int}")
    public void clickOnMKB(int arg0) throws Exception{
        new HomePage(driver).clickICD();
    }

    @Then("page is ICD")
    public void pageIsICD() {
        driver.get("https://mediately.co/rs/icd");
    }

}

