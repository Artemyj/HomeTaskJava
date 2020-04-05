package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//div[@data-uil='direction-from']//input")
    public WebElement From;

    @FindBy(how = How.XPATH, using = "//div[@data-uil='direction-to']//input")
    public WebElement To;

    @FindBy(how = How.XPATH, using = "//div[@class='datepicker-wrapper' and not(contains(@style,'none'))]//input[@type='checkbox']")
    public WebElement Days;

    @FindBy(how = How.XPATH, using = "//button[@data-uil='btn-search']")
    public WebElement Search;


    public Main(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://tickets.ua/uk");
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.ignoring(StaleElementReferenceException.class, ElementNotInteractableException.class);
    }

    public Main SetToField(String text) {
        wait.withMessage("Setting To field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (To.isDisplayed() && To.isEnabled()) {
                To.click();
                To.clear();
                To.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Main SetFromField(String text) {
        //Java do not have string interpolation as C#:(
        //in C# this looks like  wait.withMessage($Executing nameof(SetFromField) with value {text});
        wait.withMessage("Setting From field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (From.isDisplayed() && From.isEnabled()) {
                From.click();
                From.clear();
                From.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public SearchResult SearchClickAndGo() {
        wait.withMessage("Click on searh button ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Search.isDisplayed() && Search.isEnabled()) {
                Search.click();
                return true;
            }
            return false;
        });
        return new SearchResult(this);
    }

    private WebElement GetDynamicElement(String xpath) {
        return driver.findElement(new By.ByXPath(xpath));
    }

    public Main ChooseAutoCompleteByCountryCode(String text) {
        wait.withMessage("Click on country with code " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            new Actions(driver).moveToElement(GetDynamicElement("//div[contains(@class,'item-code') and normalize-space()='" + text + "']")).click().build().perform();
            return true;
        });
        return this;
    }

    public Main SetDate(LocalDate date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        wait.withMessage("Set date as " + formattedDate);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            GetDynamicElement("//div[@class='datepicker-wrapper' and not(contains(@style,'none'))]//span[@data-date='" + formattedDate + "' and @class='day-cell']").click();
            return true;
        });
        return this;
    }

    public Main SetCheckBox3Days() {
        wait.withMessage("Setting SetCheckBox3Days to " + Days.isSelected());
        PageFactory.initElements(driver, this);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Days);
        return this;
    }


}

