package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import seleniumCore.DriverManager;
import seleniumCore.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class baseTest {
    DriverManager driverManager;
    WebDriver driver;
    String path = "src/results/screenshots/";

    public void initialization(String type) throws Exception {
        driverManager =  DriverManagerFactory.getDriverManager(type);
        driver=driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void quit(){
        driverManager.quitDriver();

    }

    public void openApp(String env) throws Exception {
        env = env.toLowerCase();
        switch (env) {
            case "DEVELOPMENT": {
                driver.get("0");
            }
            break;

            case "TEST": {
                driver.get("https://t-score.uniqa.rs/POS/Serbia/NoAD");
            }
            break;

            case "INTEGRATION": {
                driver.get("01");
            }
            break;
            case "PRODUCTION": {
                driver.get("022");
            }
            break;
            default:
                driver.get("https://t-score.uniqa.rs/POS/Serbia/NoAD");
        }
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path +fileName+".png"));
    }

    public void reporterScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path filePath = Paths.get(path +fileName+".png");
        InputStream is = Files.newInputStream(filePath);
        Allure.addAttachment(desc,is);
    }
}


