package com.acc.selenium_training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Order_Details
{
	WebDriver driver;
	@Test
	public void order() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.linkText("OrderDetails")).click();
        Thread.sleep(3000);
        
        int totRows = driver.findElements(By.tagName("tr")).size();
        int totCols = driver.findElements(By.tagName("th")).size();
        
        System.out.println("Total Rows = "+totRows);
        System.out.println("Total Columns = "+totCols);
        
        List<WebElement> ele = driver.findElements(By.tagName("tr"));
        
        for (WebElement welmt : ele)
        {
			System.out.println(welmt.getText());
		}
        int linkCount = driver.findElements(By.xpath("/html/body/b/section/div/div/div/form/table/tbody/tr/td[5]/a")).size();
        System.out.println(" Reorder Link = "+linkCount);
	}
}
