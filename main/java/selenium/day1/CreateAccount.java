package selenium.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {
	public static void main(String[] args) {
	//set up browser	
	ChromeDriver driver=new ChromeDriver();
	//Maximize the browser
	driver.manage().window().maximize();
	//Global time wait to handle all slowness over application
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	//launch the URL
	driver.get("https://login.salesforce.com");

	//user name entered using id locator
    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
    //password entered using id locator
    driver.findElement(By.id("password")).sendKeys("Leaf$1234");
    //Login clicked using id locator
    driver.findElement(By.id("Login")).click();
   
    // toggle menu clicked based on the class name
    driver.findElement(By.className("slds-icon-waffle")).click();
   //clicking the view All button from the drop down
    driver.findElement(By.xpath("//button[text()='View All']")).click();
    //click Sales from App Launcher using text 
    driver.findElement(By.xpath("//p[text()='Sales']")).click();
    //
    WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
    driver.executeScript("arguments[0].click();", account);
    driver.findElement(By.xpath("//div[text()='New']")).click();
    
    WebElement accountname = driver.findElement(By.xpath("//input[@name='Name']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountname);
    accountname.sendKeys("Balaji Saravanan");
    
    driver.findElement(By.xpath("//button[text()='Save']")).click();
   
    //closing the browser session using quit method
    driver.quit();


	}

}
