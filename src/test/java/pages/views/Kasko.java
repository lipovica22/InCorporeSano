package pages.views;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Kasko extends BasePage {


    public Kasko(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (className="ico_casco")
    WebElement Kasko;



    public void clickKasko() throws Exception {
       Kasko.click();
    }



}
