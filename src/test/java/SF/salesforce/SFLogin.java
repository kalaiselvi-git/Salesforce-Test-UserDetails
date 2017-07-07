package SF.salesforce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
public class SFLogin 
{
public static void main(String[] args)
	{
			WebDriver driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			//salesforce Credentials
			driver.get("https://c.ap5.visual.force.com/apex/Home");
			WebElement username=driver.findElement(By.id("username"));
			WebElement password=driver.findElement(By.id("password"));
			username.sendKeys("kalai_selvi@gmail.com");
			password.sendKeys("kalaisf1");
			driver.findElement(By.id("Login")).click();
			
			//verify it is redirected to  UserDetails Home Page
			//***************************************
			//String home=driver.getTitle();
			System.out.println("hai");
			System.out.println(driver.getTitle());
			/*if(home == "UserDetails-Home")
			{
				System.out.println("Test 1: passed");
				System.out.println("You are navigate to UserDetails-Home");
			}
			else
			{
				System.out.println("Test 1: Failed");
				System.out.println("Failed to navigate UserDetails-Home");
			}
			
			
			//click login
			driver.findElement(By.name("j_id0:j_id2:j_id5")).click();
			//verify it is redirected to Login Page
			//***************************************
			String login=driver.getTitle();
			if(login == "UserDetails-Login")
			{
				System.out.println("Test 2: passed");
				System.out.println("You are navigate to UserDetails-Login Page");
			}
			else
			{
				System.out.println("Test 2: Failed");
				System.out.println("Failed to navigate UserDetails-Login Page");
			}
			driver.findElement(By.name("j_id0:login_form:un")).sendKeys("kalai");
			driver.findElement(By.name("j_id0:login_form:pwd")).sendKeys("kalai");
			driver.findElement(By.name("j_id0:login_form:j_id6")).click();
			
			//verify it is redirected to Userdetails Page
			//*******************************************
			String userdetails=driver.getTitle();
			if(userdetails == "UserDetails")
			{
				System.out.println("Test 3: passed");
				System.out.println("You are navigate to Details-Page");
			}
			else
			{
				System.out.println("Test 3: Failed");
				System.out.println("Failed to navigate Details-Page");
			}
			String id=driver.findElement(By.name("editable:j_id2:j_id6")).getText();
			String email=driver.findElement(By.name("editable:j_id2:j_id8")).getText();
			String name=driver.findElement(By.name("editable:j_id2:j_id10")).getText();
			
			//verify the retrieved details should not be null
			//***********************************************
			if(id!=null && email != null && name!=null)
			{
				System.out.println("Test Case 4: Passed");
				System.out.println("UserDetails are Retrieved");
			}
			else
			{
				System.out.println("Test Case 4: Failed");
				System.out.println("Userdetails cannot be fetched from object");
			}
			
			//click Edit Button
			driver.findElement(By.name("editable:j_id2:edit")).click();
			
			//Edit values
			driver.findElement(By.name("editable:j_id2:j_id6")).sendKeys("a"+id);
		    driver.findElement(By.name("editable:j_id2:j_id8")).sendKeys("a");
		    driver.findElement(By.name("editable:j_id2:j_id10")).sendKeys("a");
			driver.findElement(By.name("editable:j_id2:j_id12")).click();
			
			//Back to Home
			driver.get("https://c.ap5.visual.force.com/apex/Home");	
		    
			//Signup
			driver.findElement(By.name("j_id0:j_id2:j_id3")).click();
			driver.findElement(By.name("j_id0:j_id30:name")).sendKeys("krish");
			driver.findElement(By.name("j_id0:j_id30:email")).sendKeys("krish@gmail.com");
			driver.findElement(By.name("j_id0:j_id30:username")).sendKeys("krish");
			driver.findElement(By.name("j_id0:j_id30:pwd")).sendKeys("krish");
			driver.findElement(By.name("j_id0:j_id30:repwd")).sendKeys("krish");
			driver.findElement(By.name("j_id0:j_id30:j_id37")).click();
			//Signup is done
			
			//Back to Home
			String home1=driver.getTitle();
			if(home1=="UserDetails-Home")
			{
				System.out.println("Test 5: Passed");
				System.out.println("After signup you are navigate to Home Page");
			}
			else
			{
				System.out.println("Test 5: Failed");
				System.out.println("Error in redirecting to Home Page");
			}
			*/
			
			}
			}

