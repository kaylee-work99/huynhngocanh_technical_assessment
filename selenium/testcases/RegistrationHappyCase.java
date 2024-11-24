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

public class RegistrationHappyCase extends BaseTest {
    WebDriver driver;
    private RegistrationPageOject registrationPage;
    String firstName = "Kaylee";
    String lastName = "Huynh";
    String email = "kaylee123@gmail.com";
    String gender = "Female";
    String mobile = "0908765431";
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
    public void TC_Fill_Full_Information_Happy_Flow(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_02_Mobile_Phone_Blank to system with full fields");

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 01: Input to First Name textbox with value is " + firstName);
        registrationPage.inputToFirstname(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 02: Input to Last Name textbox with value is " + lastName);
        registrationPage.inputToLastName(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 03: Input to Email textbox with value is " + email);
        registrationPage.inputToEmail(email);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 04: Select Gender checkbox with value is " + gender);
        registrationPage.selectGender(gender);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 05: Input to Phone Number textbox with value is " + mobile);
        registrationPage.inputToPhone(mobile);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 06: Input to Subjects textbox with value is " + subject);
        registrationPage.inputToSubjects(subject);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 07: Check to Hobbies with value is Sports");
        registrationPage.checkToHobbies_sports();

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 08: Check to Hobbies with value is Reading");
        registrationPage.checkToHobbies_reading();

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 09: Check to Hobbies with value is Music");
        registrationPage.checkToHobbies_music();

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 10: Upload picture file with value is " + pictureName);
        registrationPage.uploadPicture(picture);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 11: Input to Address textarea with value is " + address);
        registrationPage.inputToAddress(address);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 12: Select State dropdown with value is " + state);
        registrationPage.selectState(state);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 13: Select City dropdown with value is " + city);
        registrationPage.selectCity(city);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 14: Select Date Of Birth with value is " + dob);
        registrationPage.inputToDOB(dob);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 15: Click to submit button");
        registrationPage.clickToSubmit();

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 16: Verify Thank you for submitting is displayed");
        verifyTrue(registrationPage.isThankForSubmittingDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 17: Verify Full Name: " + firstName + " " + lastName + " is displayed");
        verifyEquals(registrationPage.getFullName(), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 18: Verify Email: " + email + "  is displayed");
        verifyEquals(registrationPage.getEmail(), email);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 19: Verify Gender: " + gender + " is displayed");
        verifyEquals(registrationPage.getGender(), gender);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 20: Verify Mobile:" + mobile + " is displayed");
        verifyEquals(registrationPage.getMobilePhone(), mobile);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 21: Verify Date of Birth is displayed");
        verifyEquals(registrationPage.getDOB(), "01 November,1999");

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 22: Verify Subjects: " + subject + " is displayed");
        verifyEquals(registrationPage.getSubjects(), subject);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 23: Verify Hobby: Sports is displayed");
        verifyTrue(registrationPage.isHobbyContained("Sports"));

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 24: Verify Hobby: Reading is displayed");
        verifyTrue(registrationPage.isHobbyContained("Reading"));

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 25: Verify Hobby: Music is displayed");
        verifyTrue(registrationPage.isHobbyContained("Music"));

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 26: Verify Picture Name " + pictureName + " is displayed");
        verifyEquals(registrationPage.getPicture(), pictureName);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 27: Verify Address: " + address + " is displayed");
        verifyEquals(registrationPage.getAddress(), address);

        ExtentTestManager.getTest().log(Status.INFO, "TC_01_Fill_Full_Information - Step 28: Verify State and City: " + state + " " + city + " are displayed");
        verifyEquals(registrationPage.getStateCity(), state + " " + city);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
