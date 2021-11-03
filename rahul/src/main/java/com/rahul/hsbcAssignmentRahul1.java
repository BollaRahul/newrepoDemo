package com.rahul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class hsbcAssignmentRahul1 {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rahul.Bolla\\eclipse-workspace\\Demo\\src\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "first name, last name and Email-id")
	public void Name_Email() throws Exception {

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Bolla");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("bollarahul@gmail.com");
		Thread.sleep(2000);
	}

	@Test(priority = 10, description = "Select City")
	public void City() throws Exception {
		driver.findElement(By.xpath("//div[@id='city']")).click();
		WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Delhi')]"));
		city.click();
	}
	
	@Test(priority = 9, description = "Select State")
	public void State() throws Exception {
		driver.findElement(By.xpath("//div[@id='state']")).click();
		WebElement state = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
		state.click();

		Thread.sleep(2000);
	}
	
	@Test(priority = 8, description = "Current Address")
	public void Address() throws Exception {
   
	driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Hyderabad");
	Thread.sleep(2000);
	
	}	
		
		@Test(priority = 2, description = "Verify the Radio button")
	public void Radio_btn() throws Exception {
			driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
			Thread.sleep(2000);
	}

	@Test(priority = 3, description = "Enter Phone Number")
	public void Phone_no() throws Exception {
		WebElement Ph_no = driver.findElement(By.xpath("//input[@id='userNumber']"));
		Ph_no.sendKeys("9177581543");
		Thread.sleep(2000);

	}

	@Test(priority = 4, description = "Select date of Birth")
	public void Date_of_Birth() throws Exception {
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		Thread.sleep(2000);
		WebElement Month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select select = new Select(Month);
		select.selectByVisibleText("April");

		WebElement Year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select select1 = new Select(Year);
		select1.selectByVisibleText("1998");
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--012 react-datepicker__day--weekend']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 5, description = "Enter Subjects")
	public void Subjects() throws Exception {

		WebElement subject = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		Actions action = new Actions(driver);
		action.moveToElement(subject).click().sendKeys("English").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		action.moveToElement(subject).click().sendKeys("Physics").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		action.moveToElement(subject).click().sendKeys("Computer Science").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400);");
	}

	@Test(priority = 6, description = "Hobbies")
	public void Hobbies() throws Exception {
		WebElement hobbies = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(hobbies).click().build().perform();
		action1.sendKeys(Keys.RETURN);
		hobbies.click();
		Thread.sleep(2000);
	}

	@Test(priority = 7, description = "Choose File to upload")
	public void ChooseFile() throws Exception {
		WebElement selectpicture = driver.findElement(By.id("uploadPicture"));
		selectpicture.sendKeys("C:\\OneDriveTemp\\OneDrive - Coforge Limited\\Pictures\\Screenshots");
		Thread.sleep(2000);
	}

	@Test(priority = 11, description = "Submit Button")
	public void Submit() throws Exception {
		WebElement btn = driver.findElement(By.xpath("//button[@id='submit']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(btn).click().build().perform();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
