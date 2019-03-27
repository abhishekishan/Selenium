package com.acc.selenium_training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Me_Selenium
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		System.out.println("Hello Selenium");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[48]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]/option[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("Kalli");
	}
}