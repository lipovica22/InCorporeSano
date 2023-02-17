package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Tools;
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
    @Parameters({"pol"})
    @Description("Prijava i provera Vaskularne starosti- Muškarac")
    public void vascularAgeM() throws Exception {

        new HomePage(driver).acceptCoocies();
        new Tools(driver).clickKalkulatorVaskularneStarosti();
        new VascularAge(driver).setPol("Muški");
        new VascularAge(driver).setStarost("45");
        new VascularAge(driver).setPusac("Nepušač");
        new VascularAge(driver).setPritisak("120-139");
        new VascularAge(driver).setHDLHolesterol("4,0–4,9 mmol/L (155–190 mg/dL)");
        new VascularAge(driver).getVaskularnaStarost("Vaskularna starost: 50 godina");
        new VascularAge(driver).getRizik("Rizik SCORE: 5 %");

}



}
