package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ICD;

import java.io.IOException;

public class ICDsearch extends BaseTest {

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
    @Description("Pretaga bolesti po šifri ili nazivu")
    public void ICDSearch() throws Exception {
        new HomePage(driver).acceptCoocies();
        new HomePage(driver).clickICD();
        new ICD(driver).setPretrazivanje();
        new ICD(driver).clickDG();
        new ICD(driver).getNapomena();
    }



}
