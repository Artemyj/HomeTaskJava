import PageObjects.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.LocalDate;

@Execution(ExecutionMode.CONCURRENT)
class TiketsUaViaFramework {

    private WebDriver driver;

    @BeforeEach
    void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("chrome.verbose", true);
        options.setCapability("networkConnectionEnabled", true);
        options.setCapability("takesScreenshot", true);

        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
        builder.usingAnyFreePort();
        builder.usingDriverExecutable(new File("C:\\Users\\melny\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        ChromeDriverService driverService = builder.build();

        driver = new ChromeDriver(driverService, options);
    }

    @AfterEach
    void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @RepeatedTest(25)
    @DisplayName("Tickets test via framework")
    void SearchForFlyAndFillForm() {
        LocalDate localDate = LocalDate.now();
        new Main(driver).
                SetFromField("Berlin").
                ChooseAutoCompleteByCountryCode("BER").
                SetToField("Kita-Kjucu").
                ChooseAutoCompleteByCountryCode("KKJ").
                SetDate(localDate).
                SetCheckBox3Days().
                SetDate(localDate.plusMonths(1)).
                SearchClickAndGo().
                ChooseBestOfferAndGo().
                SetEmail("melnykartemyj@gmail.com").
                SetPhoneNumber("674191473").
                SetGender("Чоловіча").
                SetFirstName("Artemii").
                SetSurname("Melnyk").
                SetBirthDay("11").
                SetBirthMonth("05").
                SetBirthYear("1996").
                SetCitizenship("Україна").
                SetDocumentId("NU000000").
                BookClickAndGoPopUp().
                NextClick().
                NextClick().
                NextClick().
                SaveClickAndGo().
                AdditionalFeeConfirmClick().
                SetCardNumber("0000 0000 0000 0000");
    }
}
