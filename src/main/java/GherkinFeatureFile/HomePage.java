package GherkinFeatureFile;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

    LoadProps loadProps = new LoadProps();

    private By _userNameLink = By.id("txtUsername");
    private By _passwordLink = By.xpath("//input[@type=\"password\"]");
    private By _loginButtonLink = By.id("btnLogin");
    private By _welcomeLink = By.id("welcome");

    public void clickOnOrangeHRM(){

        assertURL("orangehrmlive");
    }

    public void UserNameAndPassword(String username ,String password){

            enterText(_userNameLink,username);

            enterText(_passwordLink,password);}

        public void clickOnLoginButton() {

            clickElement(_loginButtonLink);
        }
        public void loginSuccessful(){

        String expectedResult ="Welcome Admin";
        String actualResult  = getTextFromElement(_welcomeLink);

            Assert.assertEquals(expectedResult,actualResult);

           //assertURL("dashboard");
    }
        public void loginUnsuccessfull(){

         assertURL("validateCredentials");
    }

}
