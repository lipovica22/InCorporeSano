package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="email")
    WebElement Email;
    @FindBy (id="password")
    WebElement Lozinka;
    @FindBy (css="button[type='submit']")
    WebElement Prijava;
    @FindBy (id="Icons/User-settings")
    WebElement User;

    public void setEmail(String email) throws Exception {
        Email.sendKeys(email);
    }

    public void setLozinka(String password) throws Exception {
        Lozinka.sendKeys(password);
    }
    public void clickSubmit() throws Exception {
        click(Prijava);
        Thread.sleep(5000);
    }

    public void user() throws Exception {
        Assert.assertEquals(true,User.isDisplayed());
        User.click();
    }
}
