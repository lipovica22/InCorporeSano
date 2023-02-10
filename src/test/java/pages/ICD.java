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
    @FindBy (xpath="//h4[normalize-space()='U07.1']")
    WebElement SifraDG;
    @FindBy (css=".div[data-testid='highlighted-text']")
    WebElement Naziv;

    public void setPretrazivanje() throws Exception {
        Pretrazivanje.sendKeys("U07.1");
    }
    public void checkLista() throws Exception {
        Lista.getText();
    }
}
