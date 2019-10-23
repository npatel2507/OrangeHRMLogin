package GherkinFeatureFile;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import static com.sun.deploy.cache.Cache.copyFile;

public class Hooks extends Utils {
    BrowserSelector browserSelector = new BrowserSelector();

    @Before
    public void setUpBrowser(){
        browserSelector.setUpBrowser();

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @After
    public void closeBrowser(Scenario scenario)throws IOException {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("[.,:;?!]", "") + randomDate() + ".png";
            try {
                //this takes a screenshot from the driver at save it to the specified locatoin
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                //building up the destination path for the screenshot to save
                //also make sure to create a folder 'screenshot'with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/Destination/screenshots/" + screenshotName);

                //copy taken screenshot from source locatoin to destination location
                copyFile(sourcePath, destinationPath);
                scenario.write("Scenario failed ...........Plase see the screenshot for error");

                //attach the screenshot to our report
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (IOException e) {
            }
        }
        driver.quit();
    }
}
