package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.VascularAge;
import java.io.IOException;

public class VascularAgeDef extends BaseTest {

    @BeforeMethod
    @Parameters({"browser","env"})
    public void setup(String browser, String env) throws Exception{
        initialization(browser);
        openApp(env);
    }
    @AfterMethod
    @Parameters({"quit"})
    public void tearDown (String quit) throws IOException {
        takeScreenshot("slika" + System.currentTimeMillis());
        if (quit.equalsIgnoreCase("Yes")) {
           quit();
        }
    }
    @Test
    @Parameters({"Starost"})
    @Description("Određivanje vaskularne starosti")
    public void vascularAge() throws Exception {
        new HomePage(driver).acceptCoocies();
        new VascularAge(driver).setPolMuski();
        new VascularAge(driver).setStarost();
        new VascularAge(driver).setNepusac();
        new VascularAge(driver).setPritisak120139();
        new VascularAge(driver).setHDLHolesterol();
        new VascularAge(driver).getVaskularnaStarost();
    }



}
