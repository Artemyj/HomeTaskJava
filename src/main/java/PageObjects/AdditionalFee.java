package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdditionalFee {
    public WebDriver driver;
    public WebDriverWait wait;
    public PopUp popUp;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='До оплати']")
    private WebElement Buy;

    @FindBy(how = How.XPATH, using = "//input[@id='product_standard_fullword']/parent::div")
    private WebElement CheckBox;


    public AdditionalFee(PopUp parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        popUp = parent;
    }

    public Payment AdditionalFeeConfirmClick() {
        wait.withMessage("Click on buy ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (CheckBox.isDisplayed() && Buy.isEnabled() && Buy.isDisplayed()) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", Buy);
                return true;
            }
            return false;
        });
        return new Payment(this);
    }
}

