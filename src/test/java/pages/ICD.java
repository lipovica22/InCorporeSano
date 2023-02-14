package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ICD extends BasePage{


    public ICD(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="searchInput")
    WebElement Pretrazivanje;

    @FindBy (css=".div[data-testid='icd-list']")
    WebElement Lista;
    @FindBy (xpath="//h4[normalize-space()='U07']")
    WebElement SifraDG;
    @FindBy (xpath="//span[text()='COVID-19, virus nije identifikovan']")
    WebElement DG;

    @FindBy (xpath="//div[text()='Klinički i epidemiološki dijagnostikovan COVID-19; Verovatna infekcija virusom COVID-19; Sumnja se na COVID-19']")
    WebElement Napomena;

    @FindBy (css=".div[data-testid='highlighted-text']")
    WebElement Naziv;


    //div[text()="Klinički i epidemiološki dijagnostikovan COVID-19; Verovatna infekcija virusom COVID-19; Sumnja se na COVID-19"]
    public void setPretrazivanje() throws Exception {
        Pretrazivanje.sendKeys("U07");
        Thread.sleep(2000);
    }
    public void checkLista() throws Exception {
        Lista.getText();
    }
    public void clickDG() throws Exception {
        click(DG);
    }
    public void getNapomena() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Assert.assertTrue(Napomena.getText().equals("Klinički i epidemiološki dijagnostikovan COVID-19; Verovatna infekcija virusom COVID-19; Sumnja se na COVID-19"));
    }
}
