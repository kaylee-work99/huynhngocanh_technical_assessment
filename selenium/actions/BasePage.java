package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait explicitWait;
    WebElement element;
    JavascriptExecutor jsExecutor;
    Actions action;
    Select select;


    protected String getCurrentPageUrl(WebDriver driver) {
        String url = "";
        try {
            url = driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("Cannot get current URL: " + e.getMessage());
        }
        return url;
    }


    protected WebElement getElement(WebDriver driver, String locator) {
        try {
            element = driver.findElement(getByXpath(locator));
        } catch (Exception e) {
            System.out.println("Cannot get element: " + e.getMessage());
        }
        return element;
    }

    protected WebElement getElement(WebDriver driver, String locator, String... values) {
        try {
            element = driver.findElement(getByXpath(castToParameter(locator, values)));
        } catch (Exception e) {
            System.out.println("Cannot get element: " + e.getMessage());
        }
        return element;
    }

    protected List<WebElement> getElements(WebDriver driver, String locator) {
        List<WebElement> listElements = new ArrayList<WebElement>();
        try {
            listElements = driver.findElements(getByXpath(locator));
        } catch (Exception e) {
            System.out.println("Cannot get list elements: " + e.getMessage());
        }
        return listElements;
    }

    protected List<WebElement> getElements(WebDriver driver, String locator, String... values) {
        List<WebElement> listElements = new ArrayList<WebElement>();
        try {
            listElements = driver.findElements(getByXpath(castToParameter(locator, values)));
        } catch (Exception e) {
            System.out.println("Cannot get list elements: " + e.getMessage());
        }
        return listElements;
    }


    protected By getByXpath(String locator) {
        return By.xpath(locator);
    }

    protected void clickToElement(WebDriver driver, String locator) {
        try {
            element = getElement(driver, locator);
            element.click();
        } catch (Exception e) {
            System.out.println("Cannot click to element: " + e.getMessage());
        }
    }


    protected void sendKeyToElement(WebDriver driver, String locator, String textValue) {
        try {
            element = getElement(driver, locator);
            element.clear();
            element.sendKeys(textValue);
        } catch (Exception e) {
            System.out.println("Cannot senkey to element: " + e.getMessage());
        }
    }

    protected void sendKeyToElementWithoutClearing(WebDriver driver, String locator, String textValue) {
        try {
            element = getElement(driver, locator);
            element.sendKeys(textValue);
        } catch (Exception e) {
            System.out.println("Cannot senkey to element: " + e.getMessage());
        }
    }

    protected String getElementText(WebDriver driver, String locator) {
        String elementText = "";
        try {
            element = getElement(driver, locator);
            elementText = element.getText().trim();
        } catch (Exception e) {
            System.out.println("Cannot get element text: " + e.getMessage());
        }
        return elementText;
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        boolean check = true;
        try {
            if (getElement(driver, locator).isDisplayed()) {
                return check;
            }
        } catch (Exception e) {
            check = false;
            System.out.println("Element is displayed error: " + e.getMessage());
        }
        return check;

    }


    protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        try {
            action = new Actions(driver);
            action.sendKeys(getElement(driver, locator), key).perform();
        } catch (Exception e) {
            System.out.println("Cannot send key board to element: " + e.getMessage());
        }
    }


    // Wait
    protected void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    protected String castToParameter(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return locator;
    }


    protected void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));

    }


    protected Object scrollToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
    }

    protected void clickElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", getElement(driver, locator));
    }

    protected void sendKeyByKeyBoard(WebDriver driver, String locator, String textValue) {
        element = getElement(driver, locator);
        clickToElement(driver, locator);
        action = new Actions(driver);
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        sleepInSecond(2);
        sendKeyToElementWithoutClearing(driver, locator, textValue);
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected String getCssValue(WebDriver driver, String locator, String attribute) {

        element = getElement(driver, locator);
        return element.getCssValue(attribute);

    }


}
