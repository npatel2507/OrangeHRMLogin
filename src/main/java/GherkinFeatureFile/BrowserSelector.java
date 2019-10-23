package GherkinFeatureFile;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserSelector extends Utils{
    public static LoadProps loadProps = new LoadProps();
    public static final String USERNAME = loadProps.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProps.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://"+ USERNAME + ":" +ACCESS_KEY +"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
//    public static final String browser =System.getProperty("Browser");

    public void setUpBrowser() {
        String browser = loadProps.getProperty("Browser");
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        // If sauce lab is true
        if (SAUCE_LAB) {
            System.out.println("Running in Saucelab....... with browser" + browser);
            if (browser.equalsIgnoreCase("Chrome")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "77.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL),browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if (browser.equalsIgnoreCase("IE")){
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "11.285");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL),browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else if (browser.equalsIgnoreCase("Firefox")){
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "37.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL),browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace(); }
                }
        }
             else {

                 if(browser.equalsIgnoreCase("chrome")){

                     System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
                     driver = new ChromeDriver();
            }else if (browser.equalsIgnoreCase("Firefox")){

                     System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
                     driver = new FirefoxDriver();
            }else if (browser.equalsIgnoreCase("Internet Explorer")){

                     System.setProperty("webdriver.internet explorer.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                     driver = new InternetExplorerDriver();
            }else {
                System.out.println("Browser name is empty or type the wrong:" + browser);
            }
        }
    }
}
