package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VascularAge extends BasePage{


    public VascularAge(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//*[contains(text(),'Vaskularna starost:')]")
    WebElement VaskularnaStarost;

    @FindBy(xpath="//*[contains(text(),'Rizik')]")
    WebElement Rizik;

    @FindBy(xpath="//h1[contains(text(),'Kalkulator vaskularne starosti')]")

    WebElement Kalkulator;

    @FindBy(xpath ="//div[text()='Muško']")
    WebElement Musko;
    @FindBy(xpath ="//div[text()='Žensko']")
    WebElement Zensko;
    @FindBy(css="input[placeholder='40–89']")
    WebElement Starost;
    @FindBy(xpath ="//div[text()='Nepušač']")
    WebElement Nepusac;
    @FindBy(xpath ="//div[text()='Pušač']")
    WebElement Pusac;
    @FindBy(xpath="//*[contains(text(),'100–119')]")
    WebElement Pritisak100119;
    @FindBy(xpath="//*[contains(text(),'120–139')]")
    WebElement Pritisak120139;
    @FindBy(xpath="//*[contains(text(),'140–159')]")
    WebElement Pritisak140159;
    @FindBy(xpath="//*[contains(text(),'160–179')]")
    WebElement Pritisak160179;
    @FindBy(id="react-select-2-placeholder")
    WebElement HDLHolesterol;
    @FindBy(xpath="//*[@id='react-select-2-option-1']/span")
    WebElement HDLHolesterolList;

    @FindBy(id=".sc-eKBdFk.cxZmQh")
    WebElement StampaPDF;

    public void setPol(String pol) throws Exception {
       switch (pol) {
            case "Muško": {
                click(Musko);
            }break;
            case "Žensko": {
                click(Zensko);
            }break;
            default:
                break;
        }
    }

    public void setStarost(String starost) throws Exception {
        Starost.sendKeys(starost);
    }

    public void setPusac(String pusac) throws Exception {
        switch (pusac) {
            case "Pušač": {
                click(Pusac);
            }break;
            case "Nepušač": {
                click(Nepusac);
            }break;
            default:
                break;
        }
    }
    public void chackIsClickable() throws Exception {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(Kalkulator));

    }
    public void setPritisak(String bloodPressure) throws Exception {
        switch (bloodPressure) {
            case "100-119": {
                click(Pritisak100119);
            }
            break;
            case "120-139": {
                click(Pritisak120139);
            }
            break;
            case "140-159": {
                click(Pritisak140159);
            }
            break;
            case "160-179": {
                click(Pritisak160179);
            }
            break;
            default:
                break;
        }
    }
    public void setHDLHolesterol(String hdl) throws Exception {
        HDLHolesterol.click();

        switch (hdl){

            case "3,0–3,9 mmol/L (116–151 mg/dL)": {
                driver.findElement(By.xpath("//*[@id='react-select-2-option-0']/span")).click();
            }break;
            case "4,0–4,9 mmol/L (155–190 mg/dL)": {
                driver.findElement(By.xpath("//*[@id='react-select-2-option-1']/span")).click();
            }break;
            case "5,0–5,9 mmol/L (193–228 mg/dL)": {
                driver.findElement(By.xpath("//*[@id='react-select-2-option-2']/span")).click();
            }break;
            case "6,0–6,9 mmol/L (232–267 mg/dL)": {
                driver.findElement(By.xpath("//*[@id='react-select-2-option-3']/span")).click();
            }break;
            default:
                break;
        }
    }

    public void getVaskularnaStarost(String vaskularnaStarostRezultat) throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Assert.assertTrue(VaskularnaStarost.getText().equals(vaskularnaStarostRezultat));
    }

    public void getRizik(String rizik) throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Assert.assertTrue(Rizik.getText().equals(rizik));
    }
}
