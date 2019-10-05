package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import cucumber.api.java.en.*;
import pages.ContactUsPage;
import utilities.Driver;

public class ContactUsSteps {

	@When("I click on Contact Us link")
	public void i_click_on_Contact_Us_link() {
		Driver.getDriver().findElement(By.linkText("Contact us")).click();
	}

//	@Then("I should see Contact Us - My Store")
//	public void i_should_see_Contact_Us_My_Store() {
//	    String actualTitle = Driver.getDriver().getTitle();
//	    
//	    Assert.assertEquals("Contact Us page title is not correct",
//	    		"Contact us - My Store", actualTitle);
//	}

	@When("I select {string} from Subject Heading")
	public void i_select_from_Subject_Heading(String selection) {
		new ContactUsPage().subjectHeadingDropdown()
							.selectByVisibleText(selection);
		try { Thread.sleep(2000); } catch (Exception e) {}
	}

	@When("I add an email address")
	public void i_add_an_email_address() {
		new ContactUsPage().emailText
							.sendKeys(new Faker().internet().emailAddress());
		try { Thread.sleep(2000); } catch (Exception e) {}
	}

	@When("I add an order reference")
	public void i_add_an_order_reference() {
		new ContactUsPage().orderRefText
							.sendKeys(new Faker().business().creditCardNumber());
		try { Thread.sleep(2000); } catch (Exception e) {}
	}

	@When("I add a message")
	public void i_add_a_message() {
		new ContactUsPage().messageText
							.sendKeys(new Faker().gameOfThrones().quote());
		try { Thread.sleep(5000); } catch (Exception e) {}
	}

	@When("I click {string} button")
	public void i_click_button(String button) {
		WebElement buttonToClick = null;
		
		if (button.equals("Send")) {
			buttonToClick = new ContactUsPage().sendButton;
		}
		
		buttonToClick.click();
		try { Thread.sleep(2000); } catch (Exception e) {}
	}

	@Then("I should get the following message")
	public void i_should_get_the_following_message(String messageBody) {
		String actualMessage = new ContactUsPage().successMessage.getText();
		
		Assert.assertEquals("We got a wrong message",
				messageBody, actualMessage);
		
		try { Thread.sleep(2000); } catch (Exception e) {}
	}

}
