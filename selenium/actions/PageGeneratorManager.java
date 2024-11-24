package actions;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static RegistrationPageOject getRegistrationPage(WebDriver driver) {
        return new RegistrationPageOject(driver);
    }

}

