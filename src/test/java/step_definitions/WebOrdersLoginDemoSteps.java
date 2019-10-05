package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.*;
import utilities.Driver;

public class WebOrdersLoginDemoSteps {
	@Given("I go to {string}")
	public void i_go_to(String url) {
		Driver.getDriver().get(url);
	}

	@When("I pass in {string} as username")
	public void i_pass_in_as_username(String username) {
		Driver.getDriver()
			.findElement(By.id("ctl00_MainContent_username"))
			.sendKeys(username);
	}

	@When("I pass in {string} as password")
	public void i_pass_in_as_password(String password) {
		Driver.getDriver()
			.findElement(By.id("ctl00_MainContent_password"))
			.sendKeys(password);
	}

	@When("I click on Login button")
	public void i_click_on_Login_button() {
		Driver.getDriver()
			.findElement(By.id("ctl00_MainContent_login_button"))
			.click();
	}

	@Then("I should be on {string} page")
	public void i_should_be_on_page(String expectedTitle) {
		Assert.assertEquals("The login test failed! REPORT!", 
				expectedTitle, Driver.getDriver().getTitle());

		try {Thread.sleep(3000);} catch (Exception e) {
		}
	}

}
