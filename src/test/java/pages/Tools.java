package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tools extends BasePage{


    public Tools(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath="//div[text()='Kalkulator vaskularne starosti']")
    WebElement KalkulatorVaskularneStarosti;


    public void clickKalkulatorVaskularneStarosti() throws Exception {

        KalkulatorVaskularneStarosti.click();
    }


}
