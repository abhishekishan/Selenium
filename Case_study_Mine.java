package com.acc.selenium_training;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
public class Case_study_Mine {
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		
		//driver=Drivers.getDriver("chrome");
		//driver=Drivers.getDriver("ie");
		//driver=Drivers.getDriver("selenium3firefox");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://10.116.240.149:8083/TestMeApp/");
		String str5=  driver.getTitle();
		System.out.println(str5);
		Assert.assertEquals(str5,"Home" );
		
}

	@Test(priority=1,enabled=true)
	public void signup() {

		driver.findElement(By.linkText("SignUp")).click();
		String str=  driver.getTitle();
		System.out.println(str);
		Assert.assertEquals(str,"Sign Up" );

		driver.findElement(By.name("userName")).sendKeys("kalliiii");
		driver.findElement(By.name("firstName")).sendKeys("praveen");
		driver.findElement(By.name("lastName")).sendKeys("singh");
		driver.findElement(By.name("password")).sendKeys("samar918");
		driver.findElement(By.name("confirmPassword")).sendKeys("samar918");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("pravinsingh918@gmail.com");
		driver.findElement(By.name("mobileNumber")).sendKeys("9986111370");
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.xpath("//img[@alt='Ch']")).click();
		WebElement mon=driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
		Select s2 = new Select(mon);
		s2.selectByVisibleText("Feb");
		Select s3 = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
		
		//*[@id="ui-datepicker-div"]/div/div/select[1]
		s3.selectByVisibleText("1995");
		driver.findElement(By.xpath("//a[contains(.,'28')]")).click();
		driver.findElement(By.id("address")).sendKeys("Marathahalli, Spice Garden");
		Select s1 = new Select(driver.findElement(By.name("securityQuestion")));
		s1.selectByVisibleText("What is your favour color?");
		driver.findElement(By.name("answer")).sendKeys("Red");
		driver.findElement(By.name("Submit")).click();
	}
	@Test(priority=2, enabled=true)
	public void login() throws Exception {
		driver.get("http://10.116.240.149:8083/TestMeApp/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SignIn")).click();
		String str1=  driver.getTitle();
		System.out.println(str1);
		Assert.assertEquals(str1,"Login" );

		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("password123");
		driver.findElement(By.name("Login")).click();
		String str2=  driver.getTitle();
		System.out.println(str2);
		Assert.assertEquals(str2,"Home" );
		
		WebElement str99= driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul"));
		String str100=str99.getText();
		System.out.println(str100);
		Assert.assertEquals(str100, "Hi, lalitha SignOut");
		System.out.println(" test passed ");
		Thread.sleep(3000);


		//driver.findElement(By.linkText("SignOut")).click();
	}
	@Test(priority=3, enabled=true)
	public void cart() throws Exception  {

		//Main Menu
		WebElement mainMenu = driver.findElement(By.xpath("//span[contains(.,'All Categories')]"));
		//Create object 'action' of an Actions class
		Actions act = new Actions(driver);
		//To mouseover on main menu
		act.moveToElement(mainMenu);
		


		//Sub Menuact
		WebElement subMenu = driver.findElement(By.xpath("//span[contains(.,'Electronics')]"));
		//To mouseover on sub menu
		act.moveToElement(subMenu);
		//build() method is used to compile all the actions into a single step 
		act.click().build().perform();



		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,' Add to cart')]")).click();
		driver.findElement(By.xpath("//a[contains(.,' Cart')]")).click();
		String str3=  driver.getTitle();
		System.out.println(str3);
		Assert.assertEquals(str3,"View Cart" );
		

		driver.findElement(By.xpath("//a[contains(.,'Checkout ')]")).click();
		String str4=  driver.getTitle();
		System.out.println(str4);
		Assert.assertEquals(str4,"Cart Checkout" );
		driver.findElement(By.xpath("//input[contains(@value,'Proceed to Pay')]")).click();

	}



	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
}

