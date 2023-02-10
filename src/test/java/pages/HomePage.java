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

    @FindBy (css="div.sc-e9f474d6-3>button:first-child>div:first-child")
    WebElement Prijava;

    @FindBy(xpath="//button[text()='Razumem']")
    WebElement Razumem;

    @FindBy (xpath="//span[text()='Svi alati']")
    WebElement SviAlati;

    public void Prijava() throws Exception {
        click(Prijava);
    }
    public void acceptCoocies() throws Exception {
        click(Razumem);
    }
    public void clickSviAlati() throws Exception {
        click(SviAlati);
    }

}
