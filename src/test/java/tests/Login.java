package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tools;
import pages.VascularAge;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login extends BaseTest {

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
    @Description("Prijava i provera Vaskularne starosti - Muškarac")
    public void vascularAgeM() throws Exception {
        new HomePage(driver).acceptCoocies();
        new HomePage(driver).Prijava();

        new LoginPage(driver).setEmail();
        new LoginPage(driver).setLozinka();
        new LoginPage(driver).clickSubmit();

        new HomePage(driver).clickSviAlati();

        new Tools(driver).clickKalkulatorVaskularneStarosti();

        new VascularAge(driver).setPolMuski();
        new VascularAge(driver).setStarost();
        new VascularAge(driver).setNepusac();
        new VascularAge(driver).setPritisak120139();
        new VascularAge(driver).setHDLHolesterol();
        new VascularAge(driver).getVaskularnaStarost();
   }

    @Test
    @Description("Prijava i provera Vaskularne starosti- Žena")
    public void vascularAgeZ() throws Exception {
        try{
            new HomePage(driver).acceptCoocies();
            new HomePage(driver).clickSviAlati();

            new Tools(driver).clickKalkulatorVaskularneStarosti();

            new VascularAge(driver).setPolZenski();
            new VascularAge(driver).setStarost();
            new VascularAge(driver).setNepusac();
            new VascularAge(driver).setPritisak120139();
            new VascularAge(driver).setHDLHolesterol();
            new VascularAge(driver).getVaskularnaStarost();
        }
        catch (Exception ex) {
        }


    }

}
