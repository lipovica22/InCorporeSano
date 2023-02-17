package steps.VA;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.HomePage;
import pages.Tools;
import pages.VascularAge;
import tests.BaseTest;

import java.io.IOException;

public class VascularAgeSteps extends BaseTest {
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
    //@AfterStep
    //public void screenshot () throws IOException, InterruptedException {
    //    takeScreenshot("slika" + System.currentTimeMillis());
    //    Thread.sleep(1000);
    // }
    @Given("open app ICD")
    public void open_App_ICD()  {
        driver.get("https://mediately.co/rs");
    }
    @And("accept cookies")
    public void acceptCookies() throws Exception {
        new HomePage(driver).acceptCoocies();
    }
    @When("click on AllTools")
    public void clickOnAllTools() throws Exception{
        new HomePage(driver).clickSviAlati();
        Thread.sleep(2000);
    }

    @Then("page is tools")
    public void pageIsTools() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://mediately.co/rs/tools");
    }

    @And("click on VascularAgeCalculator")
    public void clickOnVascularAgeCalculator() throws Exception{
        new Tools(driver).clickKalkulatorVaskularneStarosti();
        Thread.sleep(2000);
    }
    @Then("page is VascularAgeVeryHigh")
    public void pageIsVascularAgeVeryHigh() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://mediately.co/rs/tools/VascularAgeVeryHigh");

    }
    @Then("set gender {string}")
    public void setGender(String pol) throws Exception{
        new VascularAge(driver).setPol(pol);
    }

    @And("set age {string}")
    public void setAge(String age) throws Exception{
        new VascularAge(driver).setStarost(age);
    }

    @And("choose smokerNonsmoker {string}")
    public void chooseSmokerNonsmoker(String smoker)throws Exception {
        new VascularAge(driver).setPusac(smoker);
    }
    @And("choose blood pressure {string}")
    public void chooseBloodPressure(String bloodPressure) throws Exception{
        new VascularAge(driver).setPritisak(bloodPressure);
    }

    @And("choose HDL {string}")
    public void chooseHDL(String hdl) throws Exception{
        new VascularAge(driver).setHDLHolesterol(hdl);
    }

    @Then("check vaslukar age {string}")
    public void checkVaslukarAge(String vaskularnaStarostRezultat) throws Exception {
        new VascularAge(driver).getVaskularnaStarost(vaskularnaStarostRezultat);
    }

    @And("check risk {string}")
    public void checkRisk(String rizik) throws Exception {
        new VascularAge(driver).getRizik(rizik);
    }
}
