package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ConfigReader;
import utilities.Driver;

public class ContactUsPage {
	public ContactUsPage() {
	        PageFactory.initElements(Driver.getDriver(), this);
	    }

	@FindBy (id = "submitMessage")
	public WebElement sendButton;
	
	public Select subjectHeadingDropdown() {
		return new Select(Driver.getDriver()
				.findElement(By.id("id_contact")));
	}
	
	@FindBy (id = "email")
	public WebElement emailText;
	
	@FindBy (id = "id_order")
	public WebElement orderRefText;
	
	@FindBy (id = "message")
	public WebElement messageText;
	
	@FindBy (css = "p[class=\"alert alert-success\"]")
	public WebElement successMessage;
	
	public static boolean fillingForm() {
		contactUsHeadingSelector(ConfigReader.getProperty("contactUsHeading"));
		contactUsEmailInput(ConfigReader.getProperty("contactUsEmail"));
		contactUsOrderRef(ConfigReader.getProperty("contactUsRef"));
		contactUsAttactFile();
		contactUsMessage();
		Driver.getDriver().findElement(By.id("submitMessage")).click();

		return contactUsSubmitChecker();
	}

	public static void contactUsHeadingSelector(String heading) {
		WebElement subjectHeading = Driver.getDriver().findElement(By.id("id_contact"));
		Select mySelect = new Select(subjectHeading);
		mySelect.selectByVisibleText(heading);
	}

	public static void contactUsEmailInput(String email) {
		WebElement emailAddress = Driver.getDriver().findElement(By.id("email"));
		emailAddress.sendKeys(email);
	}

	public static void contactUsOrderRef(String reference) {
		WebElement orderRef = Driver.getDriver().findElement(By.id("id_order"));
		orderRef.sendKeys(reference);
	}

	public static void contactUsAttactFile() {
		WebElement attachFile = Driver.getDriver().findElement(By.id("fileUpload"));
		attachFile.sendKeys("C:\\Users\\pmamm\\Downloads\\SDET\\g-1151_0.pdf");
	}

	public static void contactUsMessage() {
		WebElement message = Driver.getDriver().findElement(By.id("message"));
		message.sendKeys("I have a suggestion");
	}

	public static boolean contactUsSubmitChecker() {

		WebElement successMessage = Driver.getDriver()
				.findElement(By.cssSelector("p[class=\"alert alert-success\"]"));

		return (successMessage.getText()
				.equals("Your message has been successfully sent to our team."));
	}
}
