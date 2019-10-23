package GherkinFeatureFile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDefs {

    HomePage homePage = new HomePage();

    @Given("^user is on login page$")
    public void user_is_on_login_page()  {
        homePage.clickOnOrangeHRM();
        }

    @When("^user enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_valid_and(String username, String password)  {

        homePage.UserNameAndPassword(username,password);
    }
    @When("^click on login button$")
    public void click_on_login_button() {

        homePage.clickOnLoginButton();
    }
    @Then("^user should able to login successfully$")
    public void user_should_able_to_login_successfully() {

        homePage.loginSuccessful();
    }
    @Then("^when enters invalid details user should get error message$")
    public void when_enters_invalid_details_user_should_get_error_message(){

        homePage.loginUnsuccessfull();
    }
}