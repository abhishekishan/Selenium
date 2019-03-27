package com.acc.selenium_training;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class HDFC_Mine
{
	public static WebDriver driver;
  
  @Test
  public void frame_hdfc() throws Exception
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://netbanking.hdfcbank.com/netbanking/");
      Thread.sleep(2500);
      
      int tot = driver.findElements(By.tagName("frame")).size();
      System.out.println("Total frames = "+tot);
      
      driver.switchTo().frame("login_page");
      driver.findElement(By.name("fldLoginUserId")).sendKeys("Kalli");
      
      driver.switchTo().defaultContent();
      
      driver.switchTo().frame("footer");
      
      driver.findElement(By.linkText("Privacy Policy")).click();
      
    Set<String> winIDs =  driver.getWindowHandles();
    System.out.println("Total windows = "+winIDs.size());
    
    Iterator<String> itr = winIDs.iterator();
    String mainWindow = itr.next();
    String firstPopup = itr.next();
    
    System.out.println(mainWindow);
    System.out.println(firstPopup);
    
    driver.switchTo().window(firstPopup);
    driver.findElement(By.linkText("Personal")).click();
    driver.switchTo().defaultContent();
    Thread.sleep(2500);
    driver.switchTo().window(mainWindow);
    driver.switchTo().frame(0);
    driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a/img")).click();
    
    

  }
  

}
