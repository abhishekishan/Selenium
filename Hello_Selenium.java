package com.acc.selenium_training;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Hello_Selenium
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		System.out.println("Hello Selenium");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	/*driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("kalli hudugi");*/
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Kalli");
		driver.findElement(By.name("lastName")).sendKeys("Arch");
		driver.findElement(By.name("phone")).sendKeys("7090217880");
		driver.findElement(By.id("userName")).sendKeys("kalli@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Davangere");
		driver.findElement(By.name("city")).sendKeys("Bangalore");
		driver.findElement(By.name("state")).sendKeys("Karnataka");
		driver.findElement(By.name("postalCode")).sendKeys("577004");
	//	driver.findElement(By.name("country")).sendKeys("INDIA");
		WebElement cntry = driver.findElement(By.name("country"));
		Select s1 = new Select(cntry);
	//	s1.deselectByVisibleText("INDIA");
		s1.selectByValue("95");
		driver.findElement(By.name("email")).sendKeys("kalliarch");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.name("confirmPassword")).sendKeys("12345");
		driver.findElement(By.name("register")).click();
		driver.findElement(By.linkText("sign-in")).click();
		
		
		
		
		
		
		
	}
}