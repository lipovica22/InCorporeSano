package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".navbar-nav>a[href$='icd']")
    WebElement ICD;

    @FindBy (xpath="//span[contains(text(),'Prijava')]")
    WebElement Prijava;

    @FindBy(xpath="//button[text()='Razumem']")
    WebElement Razumem;
    @FindBy(xpath="//h6[contains(text(),'BMI')]")
    WebElement BMI;
    @FindBy (xpath="//span[text()='Svi alati']")
    WebElement SviAlati;
    public void clickICD() throws Exception {
        click(ICD);
        Thread.sleep(2000);
    }
    public void Prijava() throws Exception {
        click(Prijava);
    }
    public void acceptCoocies() throws Exception {
        click(Razumem);
    }
    public void clickSviAlati() throws Exception {
        click(SviAlati);
    }
    public void clickBMI() throws Exception {
        click(BMI);
    }

}
