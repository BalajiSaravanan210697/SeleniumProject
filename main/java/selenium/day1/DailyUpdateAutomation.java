package selenium.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DailyUpdateAutomation {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//Maximize the browser
		driver.manage().window().maximize();
		//Global time wait to handle all slowness over application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//launch the URL
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfXDNzdaaOHK9ayAksfJjTpsedBj00FcZITdIOJaQkptTuK1g/viewform");
		driver.findElement(By.xpath("(//span[text()='sign in'])[2]")).click();
		try {
			Thread.sleep(5);
			WebElement usernameField = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
		    usernameField.sendKeys("Balajibai931@gmail.com");
		} catch (InterruptedException e) {
			 driver.navigate().refresh();
			 WebElement usernameField = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
			    usernameField.sendKeys("Balajibai931@gmail.com");
		}
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//Quitting the browser
        driver.quit();
	}
}
