package com.acc.selenium_training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDrop
{
	public static WebDriver driver;
  @Test
  public void action() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("http://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  
	  WebElement from = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[3]/div/div/span"));
	  WebElement to = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_priceChecker\"]"));
	  
	  Actions act = new Actions(driver);
	  
	  act.dragAndDrop(from, to).perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("//*[@id=\"ctl00_ContentPlaceholder1_Label1\"]"), "Drop a package here to check price"));

	 String price = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
	 
	 Assert.assertTrue(price.contains("$")); 
  }
}