package com.acc.selenium_training;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.Test;

 

public class Rediff_alert {

static WebDriver driver;

//   public static void main(String[] args) throws Exception {

@Test

public void rediff_alert_assertion() throws Exception  {

System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");

             driver = new ChromeDriver();

             driver.get("http://www.rediff.com/");

            

             driver.findElement(By.linkText("Sign in")).click();

             Thread.sleep(2000);

             String str = driver.getTitle();

             System.out.println(str);

             Assert.assertEquals("Rediffmail",str);

             //Assert.assertNotEquals("Rediffmail",str);

             driver.findElement(By.name("proceed")).click();

             WebDriverWait wait = new WebDriverWait(driver,10);

              wait.until(ExpectedConditions.alertIsPresent());

              

              Alert al= driver.switchTo().alert();

              String str1 =  al.getText();

                System.out.println(str1);

                  Thread.sleep(2000);

                  al.accept();

              

//                al.dismiss();

                  driver.close();

                  }

}
