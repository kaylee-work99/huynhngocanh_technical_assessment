package interfaces;

public class RegistrationPageUI {
    // Registration Form
    public static final String FIRSTNAME_TEXT_BOX = "//input[@id='firstName']";
    public static final String LASTNAME_TEXT_BOX = "//input[@id='lastName']";
    public static final String EMAIL_TEXT_BOX = "//input[@id='userEmail']";
    public static final String PHONE_TEXT_BOX = "//input[@id='userNumber']";
    public static final String ADDRESS_TEXT_AREA = "//textarea[@id='currentAddress']";
    public static final String FEMALE_CHECKBOX = "//label[text()='Female']";
    public static final String MALE_CHECKBOX = "//label[text()='Male']";
    public static final String DOB_TEXT_BOX = "//input[@id='dateOfBirthInput']";
    public static final String SUBJECTS_TEXT_BOX = "//div[@id='subjectsContainer']//input";
    public static final String HOBBIES_SPORTS_CHECKBOX = "//label[contains(.,'Sports')]";
    public static final String HOBBIES_READING_CHECKBOX = "//label[contains(.,'Reading')]";
    public static final String HOBBIES_MUSIC_CHECKBOX = "//label[contains(.,'Music')]";
    public static final String PICTURE_TEXTBOX = "//input[@id='uploadPicture']";
    public static final String STATE_DROPDOWN = "//div[text()='Select State']/following-sibling::div/div/input";
    public static final String STATE_DROPDOWN_SELECTED = "//div[text()='NCR']";
    public static final String CITY_DROPDOWN_SELECTED = "//div[text()='Delhi']";
    public static final String CITY_DROPDOWN = "//div[text()='Select City']/following-sibling::div/div/input";
    public static final String SUBMIT_BUTTON = "//button[@id='submit']";

    // REGISTRATION TABLE
    public static final String FULL_NAME_LABEL = "//td[text()='Student Name']/following-sibling::td";
    public static final String EMAIL_LABEL = "//td[text()='Student Email']/following-sibling::td";
    public static final String PHONE_LABEL = "//td[text()='Mobile']/following-sibling::td";
    public static final String GENDER_LABEL = "//td[text()='Gender']/following-sibling::td";
    public static final String DOB_LABEL = "//td[text()='Date of Birth']/following-sibling::td";
    public static final String SUBJECTS_LABEL = "//td[text()='Subjects']/following-sibling::td";
    public static final String PICTURE_LABEL = "//td[text()='Picture']/following-sibling::td";
    public static final String HOBBIES_LABEL = "//td[text()='Hobbies']/following-sibling::td";
    public static final String ADDRESS_LABEL = "//td[text()='Address']/following-sibling::td";
    public static final String STATE_CITY_LABEL = "//td[text()='State and City']/following-sibling::td";

    public static final String THANK_YOU_SUBMIT_MSG = "//div[text()='Thanks for submitting the form']";




}
