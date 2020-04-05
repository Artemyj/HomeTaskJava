package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking {
    public WebDriver driver;
    public WebDriverWait wait;
    public SearchResult searchResult;
    public PopUp popUp;
    @FindBy(how = How.ID, using = "passengers_gender_0_chosen")
    public WebElement Gender;
    @FindBy(how = How.ID, using = "citizenship_name_0_chosen")
    public WebElement Citenship;
    @FindBy(how = How.ID, using = "email")
    private WebElement Email;
    @FindBy(how = How.ID, using = "phone_number")
    private WebElement PhoneNumber;
    @FindBy(how = How.ID, using = "lastname_0")
    private WebElement Surname;
    @FindBy(how = How.ID, using = "firstname_0")
    private WebElement FirstName;
    @FindBy(how = How.ID, using = "birthday_day_0")
    private WebElement BirthDay;
    @FindBy(how = How.ID, using = "birthday_month_0")
    private WebElement BirthMonth;
    @FindBy(how = How.ID, using = "birthday_year_0")
    private WebElement BirthYear;
    @FindBy(how = How.ID, using = "docnum_0")
    private WebElement DocumentId;
    @FindBy(how = How.XPATH, using = "//input[@data-uil='to_pay']")
    private WebElement Book;

    public Booking(SearchResult parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        searchResult = parent;
    }

    public Booking(PopUp parent) {
        this.driver = parent.driver;
        this.wait = parent.wait;
        PageFactory.initElements(driver, this);
        popUp = parent;
    }

    public Booking SetEmail(String text) {
        wait.withMessage("Setting email field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Email.isDisplayed() && Email.isEnabled()) {
                Email.click();
                Email.clear();
                Email.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetPhoneNumber(String text) {
        wait.withMessage("Setting PhoneNumber field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (PhoneNumber.isDisplayed() && PhoneNumber.isEnabled()) {
                PhoneNumber.click();
                PhoneNumber.clear();
                PhoneNumber.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetGender(String text) {
        wait.withMessage("Setting Gender field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            Gender.click();
            driver.findElement(new By.ByXPath("//li[normalize-space()='" + text + "']")).click();
            return true;
        });
        return this;
    }

    public Booking SetCitizenship(String text) {
        wait.withMessage("Setting Citenship field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            Citenship.click();
            driver.findElement(new By.ByXPath("//li[normalize-space()='" + text + "']")).click();
            return true;
        });
        return this;
    }

    public Booking SetFirstName(String text) {
        wait.withMessage("Setting FirstName field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (FirstName.isDisplayed() && FirstName.isEnabled()) {
                FirstName.click();
                FirstName.clear();
                FirstName.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetSurname(String text) {
        wait.withMessage("Setting Surname field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Surname.isDisplayed() && Surname.isEnabled()) {
                Surname.click();
                Surname.clear();
                Surname.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetBirthDay(String text) {
        wait.withMessage("Setting BirthDay field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (BirthDay.isDisplayed() && BirthDay.isEnabled()) {
                BirthDay.click();
                BirthDay.clear();
                BirthDay.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetBirthMonth(String text) {
        wait.withMessage("Setting BirthMonth field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (BirthMonth.isDisplayed() && BirthMonth.isEnabled()) {
                BirthMonth.click();
                BirthMonth.clear();
                BirthMonth.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetBirthYear(String text) {
        wait.withMessage("Setting BirthYear field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (BirthYear.isDisplayed() && BirthYear.isEnabled()) {
                BirthYear.click();
                BirthYear.clear();
                BirthYear.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public Booking SetDocumentId(String text) {
        wait.withMessage("Setting DocumentId field with " + text);
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (DocumentId.isDisplayed() && DocumentId.isEnabled()) {
                DocumentId.click();
                DocumentId.clear();
                DocumentId.sendKeys(text);
                return true;
            }
            return false;
        });
        return this;
    }

    public PopUp BookClickAndGoPopUp() {
        wait.withMessage("Click on booking ");
        wait.until(drv -> {
            PageFactory.initElements(driver, this);
            if (Book.isDisplayed() && Book.isEnabled()) {
                Book.click();
                return true;
            }
            return false;
        });
        return new PopUp(this);
    }
}

