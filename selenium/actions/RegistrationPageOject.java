package actions;

import interfaces.RegistrationPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegistrationPageOject extends BasePage {
    WebDriver driver;

    public RegistrationPageOject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToFirstname(String firstName) {
        scrollToElementByJS(driver, RegistrationPageUI.FIRSTNAME_TEXT_BOX);
        waitForElementVisible(driver, RegistrationPageUI.FIRSTNAME_TEXT_BOX);
        sendKeyToElement(driver, RegistrationPageUI.FIRSTNAME_TEXT_BOX, firstName);
    }

    public void inputToLastName(String lastName) {
        waitForElementVisible(driver, RegistrationPageUI.LASTNAME_TEXT_BOX);
        sendKeyToElement(driver, RegistrationPageUI.LASTNAME_TEXT_BOX, lastName);
    }

    public void inputToEmail(String email) {
        waitForElementVisible(driver, RegistrationPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, RegistrationPageUI.EMAIL_TEXT_BOX, email);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Female")) {
            waitForElementVisible(driver, RegistrationPageUI.FEMALE_CHECKBOX);
            clickToElement(driver, RegistrationPageUI.FEMALE_CHECKBOX);
        } else {
            waitForElementVisible(driver, RegistrationPageUI.MALE_CHECKBOX);
            clickToElement(driver, RegistrationPageUI.MALE_CHECKBOX);
        }

    }

    public void inputToPhone(String mobile) {
        waitForElementVisible(driver, RegistrationPageUI.PHONE_TEXT_BOX);
        sendKeyToElement(driver, RegistrationPageUI.PHONE_TEXT_BOX, mobile);
    }


    public void inputToSubjects(String subject) {
        waitForElementVisible(driver, RegistrationPageUI.SUBJECTS_TEXT_BOX);
        sendKeyToElement(driver, RegistrationPageUI.SUBJECTS_TEXT_BOX, subject);
        sendKeyBoardToElement(driver, RegistrationPageUI.SUBJECTS_TEXT_BOX, Keys.TAB);
    }

    public void checkToHobbies_sports() {
        waitForElementVisible(driver, RegistrationPageUI.HOBBIES_SPORTS_CHECKBOX);
        clickToElement(driver, RegistrationPageUI.HOBBIES_SPORTS_CHECKBOX);
    }

    public void checkToHobbies_reading() {
        waitForElementVisible(driver, RegistrationPageUI.HOBBIES_READING_CHECKBOX);
        clickToElement(driver, RegistrationPageUI.HOBBIES_READING_CHECKBOX);
    }

    public void checkToHobbies_music() {
        waitForElementVisible(driver, RegistrationPageUI.HOBBIES_MUSIC_CHECKBOX);
        clickToElement(driver, RegistrationPageUI.HOBBIES_MUSIC_CHECKBOX);
    }

    public void uploadPicture(String picture) {
        waitForElementVisible(driver, RegistrationPageUI.PICTURE_TEXTBOX);
        sendKeyToElement(driver, RegistrationPageUI.PICTURE_TEXTBOX, picture);

    }

    public void inputToAddress(String address) {
        waitForElementVisible(driver, RegistrationPageUI.ADDRESS_TEXT_AREA);
        sendKeyToElement(driver, RegistrationPageUI.ADDRESS_TEXT_AREA, address);
    }

    public void selectState(String state) {
        waitForElementVisible(driver, RegistrationPageUI.STATE_DROPDOWN);
        sendKeyToElement(driver, RegistrationPageUI.STATE_DROPDOWN, state);
        sleepInSecond(3);
        sendKeyBoardToElement(driver, RegistrationPageUI.STATE_DROPDOWN_SELECTED, Keys.TAB);

    }

    public void selectCity(String city) {
        waitForElementVisible(driver, RegistrationPageUI.CITY_DROPDOWN);
        sleepInSecond(3);
        sendKeyToElement(driver, RegistrationPageUI.CITY_DROPDOWN, city);
        sleepInSecond(3);
        sendKeyBoardToElement(driver, RegistrationPageUI.CITY_DROPDOWN_SELECTED, Keys.TAB);
    }

    public void inputToDOB(String dob) {
        waitForElementVisible(driver, RegistrationPageUI.DOB_TEXT_BOX);
        scrollToElementByJS(driver, RegistrationPageUI.DOB_TEXT_BOX);
        sendKeyByKeyBoard(driver, RegistrationPageUI.DOB_TEXT_BOX, dob);
        sleepInSecond(2);
    }

    public void clickToSubmit() {
        waitForElementVisible(driver, RegistrationPageUI.SUBMIT_BUTTON);
        scrollToElementByJS(driver, RegistrationPageUI.SUBMIT_BUTTON);
        clickToElement(driver, RegistrationPageUI.SUBMIT_BUTTON);
    }

    public String getFullName() {
        waitForElementVisible(driver, RegistrationPageUI.FULL_NAME_LABEL);
        return getElementText(driver, RegistrationPageUI.FULL_NAME_LABEL);
    }

    public String getEmail() {
        waitForElementVisible(driver, RegistrationPageUI.EMAIL_LABEL);
        return getElementText(driver, RegistrationPageUI.EMAIL_LABEL);
    }

    public String getGender() {
        waitForElementVisible(driver, RegistrationPageUI.GENDER_LABEL);
        return getElementText(driver, RegistrationPageUI.GENDER_LABEL);
    }

    public String getMobilePhone() {
        waitForElementVisible(driver, RegistrationPageUI.PHONE_LABEL);
        return getElementText(driver, RegistrationPageUI.PHONE_LABEL);
    }

    public String getDOB() {
        waitForElementVisible(driver, RegistrationPageUI.DOB_LABEL);
        return getElementText(driver, RegistrationPageUI.DOB_LABEL);
    }

    public String getSubjects() {
        waitForElementVisible(driver, RegistrationPageUI.SUBJECTS_LABEL);
        return getElementText(driver, RegistrationPageUI.SUBJECTS_LABEL);
    }

    public boolean isHobbyContained(String hobby) {
        waitForElementVisible(driver, RegistrationPageUI.HOBBIES_LABEL);
        String hobbies = getElementText(driver, RegistrationPageUI.HOBBIES_LABEL);
        if (hobbies.contains(hobby)) {
            return true;
        } else {
            return false;
        }

    }

    public String getPicture() {
        waitForElementVisible(driver, RegistrationPageUI.PICTURE_LABEL);
        return getElementText(driver, RegistrationPageUI.PICTURE_LABEL);
    }

    public String getAddress() {
        waitForElementVisible(driver, RegistrationPageUI.ADDRESS_LABEL);
        return getElementText(driver, RegistrationPageUI.ADDRESS_LABEL);
    }


    public String getStateCity() {
        waitForElementVisible(driver, RegistrationPageUI.STATE_CITY_LABEL);
        return getElementText(driver, RegistrationPageUI.STATE_CITY_LABEL);
    }

    public boolean isThankForSubmittingDisplayed() {
        waitForElementVisible(driver, RegistrationPageUI.THANK_YOU_SUBMIT_MSG);
        return isElementDisplayed(driver, RegistrationPageUI.THANK_YOU_SUBMIT_MSG);
    }

    public boolean isMobilePhoneWarning() {
        String background_image = getCssValue(driver, RegistrationPageUI.PHONE_TEXT_BOX, "background-image");
        if (background_image.contains("circle")) {
            return true;
        } else {
            return false;
        }
    }



}
