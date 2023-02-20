package steps.BMI;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.BMIPage;
import pages.HomePage;
import tests.BaseTest;

import java.io.IOException;

public class BMISteps extends BaseTest {
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
    @When("click on BMI tool")
    public void clickOnBMITools() throws Exception{
        new HomePage(driver).clickBMI();
        Thread.sleep(3000);
    }
    @Then("page is BMI")
    public void pageIsBMI() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://mediately.co/rs/tools/BMI");
    }

    @And("input weight")
    public void inputWeight() throws Exception {
        new BMIPage(driver).setTezina();
    }
    @And("input height")
    public void inputHeight()throws Exception {
        new BMIPage(driver).setVisina();
    }

    @Then("BMI change colour in green")
    public void BMIChangeColourInGreen()throws Exception {
        new BMIPage(driver).opisRezultata();
    }
    @And("get index of BMI")
    public void getIndexOfBMI()throws Exception {
        new BMIPage(driver).rezultat();
    }
}

