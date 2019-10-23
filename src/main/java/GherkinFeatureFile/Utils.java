package GherkinFeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {
    //generate new email
    public static String generateemail(String startValue) {
        String email = startValue.concat(new Date().toString());
        return email;
    }

    //random date for email
    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }

    //click on element
    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    //enter text in input field
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //for get text from element
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //wait until element clickable
    public static void waitForelementClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait until element visible
    public static void waitForElementVisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for alert present
    public static void waitForAlertPresent(long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //select value from dropdown
    public static void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //dropdown select by index
    public static void selectByIndex(By by, int num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(0);
    }

    //when dropdown present
    public static void selectByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //all option is selected
    public static void getAllSelectedOptions(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.getAllSelectedOptions();
    }

    //get first selected option
    public static void getFirstSelectedoption(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.getFirstSelectedOption();
    }

    //wait for element to be invisible
    public static void waitForElementToBeInvisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfAllElements());
    }

    //clear text
    public static void clearText(By by) {
        driver.findElement(by).clear();
    }

    //checking webelement display or not
    public static void checkingWebElementDisplayOrNot(By by, String text) {
        driver.findElement(by).isDisplayed();
    }

    //imlicity wait
    public static void waitForFixTimeGivenInSeconds(By by, long time) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    //get css property of element
    public static void getCSSPropertyofElement(By by, String text) {
        driver.findElement(by).getCssValue(text);
        return;
    }

    //to get attribute
    public static String getAttributes(By by, String text) {
        return driver.findElement(by).getAttribute(text);
    }

    //nevigate to url
    public static void nevigateToUrl(String text) {
        driver.navigate().to(text);
    }

    //assert url
    public static void assertURL(String text) {

        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //assert text message
    public static void assertTextMessage(String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(expected, actual);
    }

    //assert current url
    public static void assertCurrentURL(String url) {

        Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }

    //get a screenshot
    // public static void getScreenShot() {
    // File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //try {
    // FileUtils.copyFile(scrFile, new File("src\\test\\Resources\\SreenShot\\screenshot" + randomDate() + ".png"));
    //} catch (IOException e) {
    //  e.printStackTrace();}}
}



