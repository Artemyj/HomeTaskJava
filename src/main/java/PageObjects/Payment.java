package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Payment {
    public WebDriver driver;
    public WebDriverWait wait;
    public AdditionalFee additionalFee;


    @FindBy(how = How.XPATH, using = "//div[@class='pay-order']//a")
    private WebElement Buy;

    public Payment(AdditionalFee parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        additionalFee = parent;
    }

    public Payment BuyClick() {
        wait.withMessage("Click on booking ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Buy.isDisplayed() && Buy.isEnabled()) {
                Buy.click();
                return true;
            }
            return false;
        });
        return this;
    }

    public Payment SetCardNumber(String text) {
        String[] numbers = text.trim().split(" ");

        for (int i = 0; i < 4; i++) {
            wait.withMessage("Click on card num " + i);
            //????
            List<WebElement> cardNums = driver.findElements(new By.ByXPath("//div[@class='card-num-wrapper']//input"));
            int finalI = i;
            wait.until(drv -> {
                PageFactory.initElements(driver, this);
                cardNums.get(finalI).click();
                cardNums.get(finalI).clear();
                cardNums.get(finalI).sendKeys(numbers[finalI]);
                return true;
            });
        }
        return this;
    }
}

