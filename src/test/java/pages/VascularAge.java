package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VascularAge extends BasePage{


    public VascularAge(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".sc-eKBdFk.cxZmQh")
    WebElement VaskularnaStarost;

    @FindBy(css=".sc-bUbCnL bDRQXj")
    WebElement Rizik;



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
    @FindBy(css=".list-group-item[data-id='bloodPressure1']")
    WebElement Pritisak110119;
    @FindBy(css=".list-group-item[data-id='bloodPressure2']")
    WebElement Pritisak120139;
    @FindBy(css=".list-group-item[data-id='bloodPressure3']")
    WebElement Pritisak140159;
    @FindBy(css=".list-group-item[data-id='bloodPressure4']")
    WebElement Pritisak160179;
    @FindBy(id="react-select-2-placeholder")
    WebElement HDLHolesterol;
    @FindBy(id="react-select-2-input")
    WebElement HDLHolesterolValue;

    @FindBy(id=".sc-eKBdFk.cxZmQh")
    WebElement StampaPDF;

    public void setPolMuski() throws Exception {
        click(Musko);
    }

    public void setPolZenski() throws Exception {
        click(Zensko);
    }

    public void setStarost() throws Exception {
        Starost.sendKeys("45");
    }

    public void setNepusac() throws Exception {
        click(Nepusac);
    }

    public void setPusac() throws Exception {
        click(Pusac);
    }

    public void setPritisak110119() throws Exception {
        click(Pritisak110119);
    }

    public void setPritisak120139() throws Exception {
        click(Pritisak120139);
    }
    public void setPritisak140159() throws Exception {
        click(Pritisak140159);
    }
    public void setPritisak160179() throws Exception {
        click(Pritisak160179);
    }
    public void setHDLHolesterol() throws Exception {
        HDLHolesterol.click();
        HDLHolesterolValue.sendKeys("4,0–4,9 mmol/L (155–190 mg/dL)");
    }
    public void getVaskularnaStarost() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        String vvv=VaskularnaStarost.getText();
        Assert.assertTrue(VaskularnaStarost.getText().equals("Vaskularna starost: 47 godina"));
    }

    public void getRizik() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        String vvv=VaskularnaStarost.getText();
        Assert.assertTrue(VaskularnaStarost.getText().equals("Rizik SCORE: 5 %"));
    }
}
