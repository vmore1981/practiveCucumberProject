package step_definitions;

import org.junit.Assert;

import utils.DataReader;
import utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoLoginPage;
import pages.SauceHomepage;

public class SauceDemoTests {

	
	SauceDemoLoginPage sauceloginpage = new SauceDemoLoginPage();
	SauceHomepage homepage = new SauceHomepage();
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {

		Driver.getDriver().get(DataReader.getProperty("sauce_url"));
	}

	@When("user enters a valid username and valid password")
	public void user_enters_a_valid_username_and_valid_password() {

		sauceloginpage.loginUsername.sendKeys(DataReader.getProperty("sauce_username"));
		sauceloginpage.loginPassword.sendKeys(DataReader.getProperty("sauce_password"));
	
	}

	@When("user clicks on the signin button")
	public void user_clicks_on_the_signin_button() {

		sauceloginpage.loginBtn.click();
		
	}

	@Then("user is logged successfully")
	public void user_is_logged_successfully() throws InterruptedException {
		
		Thread.sleep(500);
		Assert.assertTrue(homepage.homepage_product_text.isDisplayed());

	}
	
	
	@When("user enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() {

		sauceloginpage.loginUsername.sendKeys("invalidusername");
		sauceloginpage.loginPassword.sendKeys(DataReader.getProperty("sauce_password"));
		
}

	@Then("user should not be logged in")
	public void user_should_not_be_logged_in() throws InterruptedException {

		Thread.sleep(100);
		Assert.assertTrue(sauceloginpage.loginBtn.isDisplayed());
		
	}
	
	@When("user enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() {
	
		sauceloginpage.loginUsername.sendKeys(DataReader.getProperty("sauce_username"));
		sauceloginpage.loginPassword.sendKeys("invalidpassword");
	
	}
	
	
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {

		sauceloginpage.loginUsername.sendKeys(username);
		sauceloginpage.loginPassword.sendKeys(password);
	
		
	}
	
	// Scenario step parameter - starts
		
	@When("user enters invalid username {string} and invalid password {string}")
	public void user_enters_invalid_username_and_invalid_password(String username, String password) {

		sauceloginpage.loginUsername.sendKeys(username);
		sauceloginpage.loginPassword.sendKeys(password);

	}

	@Then("user should not be logged in with an error message as {string}")
	public void user_should_not_be_logged_in_with_an_error_message_as(String errorMessage) {

		System.out.println(errorMessage);

	}
	
	// Scenario step parameter - ends	
	
	
	
}
