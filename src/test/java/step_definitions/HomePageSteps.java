package step_definitions;

import org.junit.Assert;

import cucumber.api.java.en.*;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePageSteps {
	public static String title;

	@Given("I navigate to the company website")
	public void i_navigate_to_the_company_website() {
	    Driver.getDriver()
	    .get(ConfigReader.getProperty("url"));
	}

	@When("I check the title")
	public void i_check_the_title() {
	    title = Driver.getDriver().getTitle();
	}

//	@Then("I should see My Store")
//	public void i_should_see_My_Store() {
//	    Assert.assertEquals("The title is wrong", 
//	    		"My Store", title);
//	}
	
	@Then("I should see {string}")
	public void i_should_see(String param) {
		Assert.assertEquals("The title is wrong", 
	    		param, title);
	}
	
	@Then("I quit the driver in {int} seconds")
	public void i_quit_the_driver_in_seconds(Integer seconds) throws Exception{
	    Thread.sleep(seconds * 1000);
	    Driver.closeDriver();
	}
}
