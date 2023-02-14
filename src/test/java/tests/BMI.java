package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BMIPage;
import pages.HomePage;
import java.io.IOException;

public class BMI extends BaseTest{

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
    @Description("Određivanje BMI")
    public void calkBMI() throws Exception {
        new HomePage(driver).acceptCoocies();
        new HomePage(driver).clickBMI();
        new BMIPage(driver).setTezina();
        new BMIPage(driver).setVisina();
        new BMIPage(driver).opisRezultata();
        new BMIPage(driver).rezultat();
    }
}
