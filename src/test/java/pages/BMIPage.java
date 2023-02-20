package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Objects;

public class BMIPage extends BasePage{
    public BMIPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input[placeholder='1–300']")
    WebElement Tezina;
    @FindBy(css="input[placeholder='1–250']")
    WebElement Visina;
    @FindBy(css=".sc-caPbAK")
    WebElement OpisRezultata;
    @FindBy(css=".sc-gUJyNl")
    WebElement Rezultat;

    public void setTezina() throws Exception {
        Tezina.sendKeys("79");
    }
    public void setVisina() throws Exception {
        Visina.sendKeys("178");
    }
    public void opisRezultata() throws Exception {
        Assert.assertTrue(OpisRezultata.getText().equals("Normal weight"));

    }
    public void rezultat() throws Exception {
        Assert.assertTrue(Rezultat.getText().equals("24,93"));
        //hex:#05B562  rgb(5, 181, 98) rgba(5, 181, 98, 1)
        Assert.assertTrue(Rezultat.getCssValue("color").equals("rgba(5, 181, 98, 1)"));
    }
}
