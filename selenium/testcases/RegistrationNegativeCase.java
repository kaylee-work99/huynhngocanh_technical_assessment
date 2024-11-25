package testcases;

import actions.BaseTest;
import actions.GlobalConstants;
import actions.PageGeneratorManager;
import actions.RegistrationPageOject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.time.Duration;

public class RegistrationNegativeCase extends BaseTest {
    WebDriver driver;
    private RegistrationPageOject registrationPage;
    String firstName = "Kaylee";
    String lastName = "Huynh";
    String email = "kaylee123@gmail.com";
    String gender = "Female";
    String dob = "01 Nov 1999";
    String address = "12/9 Tran Hung Dao, HCMC";
    String subject = "English";
    String pictureName = "smile.png";
    String picture = GlobalConstants.UPLOAD_FOLDER + pictureName;
    String state = "NCR";
    String city = "Delhi";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/automation-practice-form");
        registrationPage = PageGeneratorManager.getRegistrationPage(driver);
    }

    @Test
    public void TC_02_Mobile_Phone_Blank_Negative_Flow(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 02 Register without Phone Number");

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 01: Input to First Name textbox with value is " + firstName);
        registrationPage.inputToFirstname(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 02: Input to Last Name textbox with value is " + lastName);
        registrationPage.inputToLastName(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 03: Input to Email textbox with value is " + email);
        registrationPage.inputToEmail(email);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 04: Select Gender checkbox with value is " + gender);
        registrationPage.selectGender(gender);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 05: Input to Subjects textbox with value is " + subject);
        registrationPage.inputToSubjects(subject);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 06: Check to Hobbies with value is Sports");
        registrationPage.checkToHobbies_sports();

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 07: Check to Hobbies with value is Reading");
        registrationPage.checkToHobbies_reading();

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 08: Check to Hobbies with value is Music");
        registrationPage.checkToHobbies_music();

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 09: Upload picture file with value is " + pictureName);
        registrationPage.uploadPicture(picture);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 10: Input to Address textarea with value is " + address);
        registrationPage.inputToAddress(address);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 11: Select State dropdown with value is " + state);
        registrationPage.selectState(state);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 12: Select City dropdown with value is " + city);
        registrationPage.selectCity(city);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 13: Select Date Of Birth with value is " + dob);
        registrationPage.inputToDOB(dob);

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 14: Click to submit button");
        registrationPage.clickToSubmit();

        ExtentTestManager.getTest().log(Status.INFO, "TC_02_Mobile_Phone_Blank - Step 15: Verify Warning field");
        verifyTrue(registrationPage.isMobilePhoneWarning());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
