package PageObjects;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResult {
    public WebDriver driver;
    public WebDriverWait wait;
    public Main mainPage;


    @FindBy(how = How.XPATH, using = "//span[@class='label-corner the_cheapest']//ancestor::section//input[@type='button']")
    private WebElement BestOferChoose;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.ignoring(StaleElementReferenceException.class, ElementNotInteractableException.class);
    }

    public SearchResult(Main parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        mainPage = parent;
    }

    public Booking ChooseBestOfferAndGo() {
        wait.withMessage("Click on best offer choose button ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (BestOferChoose.isDisplayed() && BestOferChoose.isEnabled()) {
                BestOferChoose.click();
                return true;
            }
            return false;
        });
        return new Booking(this);
    }
}
