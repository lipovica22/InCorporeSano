package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    public void setEmail() throws Exception {
        Email.sendKeys("srdjanstech@gmail.com");
    }

    public void setLozinka() throws Exception {
        Lozinka.sendKeys("incorporesano");
    }
    public void clickSubmit() throws Exception {
        click(Prijava);
        Thread.sleep(5000);
    }


}
