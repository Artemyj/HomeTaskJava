package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUp {
    public WebDriver driver;
    public WebDriverWait wait;
    public Booking boooking;

    @FindBy(how = How.XPATH, using = "//div[@class='popup__footer']//a[contains(@class,'next')]")
    private WebElement Next;

    @FindBy(how = How.XPATH, using = "//div[@class='popup__footer']//a[contains(@class,'save')]")
    private WebElement Save;

    public PopUp(Booking parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        boooking = parent;
    }

    public PopUp NextClick() {
        wait.withMessage("Click on booking ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Next.isDisplayed() && Next.isEnabled()) {
                Next.click();
                return true;
            }
            return false;
        });
        return this;
    }

    public AdditionalFee SaveClickAndGo() {
        wait.withMessage("Click on booking ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Save.isDisplayed() && Save.isEnabled()) {
                Save.click();
                return true;
            }
            return false;
        });
        return new AdditionalFee(this);
    }
}

