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
    @Description("Login")
    public void regularLogin() throws Exception {

        new HomePage(driver).acceptCoocies();
        new HomePage(driver).Prijava();

        new LoginPage(driver).setEmail("srdjanstech@gmail.com");
        new LoginPage(driver).setLozinka("incorporesano");
        new LoginPage(driver).clickSubmit();

    }



}
