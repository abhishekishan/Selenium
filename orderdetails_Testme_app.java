package com.acc.selenium_training;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

 

public class orderdetails_Testme_app {

     WebDriver driver;

     @BeforeTest

     public void action1()

     {

         System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");

 

         //Create Browser object

         driver = new ChromeDriver();

         

          driver.get("http://10.232.237.143:443/TestMeApp");

         driver.manage().window().maximize();

 

     }

     @Test

     public void action2() throws InterruptedException 

     

     {

     driver.findElement(By.xpath("//a[@href='login.htm']")).click();

         Thread.sleep(2000);

     driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");

     driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");

     driver.findElement(By.xpath("//input[@name='Login']")).click();

     //driver.findElement(By.xpath("//span[contains(.,'OrderDetails')]")).click();

     driver.findElement(By.linkText("OrderDetails")).click();

         Thread.sleep(3000);

         

         //Get Row Count

         int rowCount=driver.findElements(By.tagName("tr")).size();

 

         //Get Column Count

         int colCount=driver.findElements(By.xpath("//thead//th")).size();

 

         System.out.println("Row count :" + rowCount);

         System.out.println("Col count :" + colCount);

 

         //Print table Data

 

         for(WebElement tdata:driver.findElements(By.tagName("tr")))

         {

         System.out.println(tdata.getText());

     }

         

          int linkcount=driver.findElements(By.xpath("/html/body/b/section/div/div/div/form/table/tbody/tr/td[5]/a")).size();

          System.out.println("Link Count :" + linkcount);

     }

     

}
