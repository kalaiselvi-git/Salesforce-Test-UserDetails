package SF.salesforce;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Userdetails_Test 
{

public static void main(String[] args)
	
	{
		String stitle;
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//salesforce Credentials
		driver.get("https://c.ap5.visual.force.com/apex/Home");	
		//To UserDetails-Home
				String home=driver.getTitle();
				//System.out.println("---------------->"+home);
				if("Login | Salesforce".equals(home))
				{
					System.out.println("Test 1: Passed");
					System.out.println("Welcome to Salesforce");
					System.out.println("---------------------");
				}
				else
				{
					System.out.println("Test 1: Failed");
					System.out.println("Failed to Login SF Org");
					System.out.println("----------------------");
				}
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		username.sendKeys("kalai_selvi@gmail.com");
		password.sendKeys("kalaisf1");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Open Signup Page
		driver.findElement(By.name("j_id0:j_id2:j_id3")).click();
		stitle=driver.getTitle();
		//System.out.println("hai");
		//System.out.println("-------------------->"+stitle);
	
	if("Signup".equals(stitle))
		{
			System.out.println("Test 2: Passed");
			System.out.println("Redirecting to Signup Page");
			System.out.println("--------------------------");
			
		}
		else
		{
			System.out.println("Test 2: Failed");
			System.out.println("Failed to navigate to signup Page");
			System.out.println("---------------------------------");
		}
		
	//Signup
	driver.findElement(By.name("j_id0:j_id31:name")).sendKeys("Nimmy");
	driver.findElement(By.name("j_id0:j_id31:email")).sendKeys("Nimmy@gmail.com");
	driver.findElement(By.name("j_id0:j_id31:username")).sendKeys("Nimmy");
	driver.findElement(By.name("j_id0:j_id31:pwd")).sendKeys("Nimmy");
	driver.findElement(By.name("j_id0:j_id31:repwd")).sendKeys("Nimmy");
	driver.findElement(By.name("j_id0:j_id31:j_id38")).click();
	//Signup is done
	
	//Back to Home
	String home1=driver.getTitle();
	if("UserDetails-Home".equals(home1))
	{
		System.out.println("Test 3: Passed");
		System.out.println("After signup you are navigate to Home Page");
		System.out.println("------------------------------------------");
	}
	else
	{
		System.out.println("Test 3: Failed");
		System.out.println("Error in redirecting to Home Page");
		System.out.println("---------------------------------");
	}
	
	
	//click login
	driver.findElement(By.name("j_id0:j_id2:j_id5")).click();
	//verify it is redirected to Login Page
	//***************************************
	String login=driver.getTitle();
	if("LoginPage".equals(login))
	{
		System.out.println("Test 4: passed");
		System.out.println("Redirecting to Login Page");
		System.out.println("-------------------------");
	}
	else
	{
		System.out.println("Test 4: Failed");
		System.out.println("Failed to navigate Login Page");
		System.out.println("-----------------------------");
	}
	driver.findElement(By.name("j_id0:login_form:un")).sendKeys("vinoth");
	driver.findElement(By.name("j_id0:login_form:pwd")).sendKeys("vinoth");
	driver.findElement(By.name("j_id0:login_form:j_id6")).click();
	
	//verify it is redirected to Userdetails Page
	//*******************************************
	String user=driver.getTitle();
	if("UserDetail".equals(user))
	{
		System.out.println("Test 5: passed");
		System.out.println("Redirecting to UserDetail-Page");
		System.out.println("------------------------------");
	}
	else
	{
		System.out.println("Test 5: Failed");
		System.out.println("Failed Redirecting to UserDetail-Page");
		System.out.println("-------------------------------------");
	}
	
	String id=driver.findElement(By.name("editable:j_id2:j_id6")).getText();
	String email=driver.findElement(By.name("editable:j_id2:j_id8")).getText();
	String name=driver.findElement(By.name("editable:j_id2:j_id10")).getText();
	
	//verify the retrieved details should not be null
	//***********************************************
	if(id!=null && email != null && name!=null)
	{
		System.out.println("Test Case 6: Passed");
		System.out.println("UserDetails are Retrieved");
		System.out.println("-------------------------");
	}
	else
	{
		System.out.println("Test Case 6: Failed");
		System.out.println("Null Reference in Userdetails");
		System.out.println("-----------------------------");
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
    }
}


