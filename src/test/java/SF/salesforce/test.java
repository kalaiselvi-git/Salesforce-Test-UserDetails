package SF.salesforce;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test
{
	public WebDriver driver;
	public String URL, Node;

	@BeforeClass
	public void sflogin() 
	{
		driver.get("http://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("kalai_selvi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("kalaisf1");
		driver.findElement(By.id("Login")).click();
		System.out.println("Salesforce Login succesfully!!!");
		System.out.println(driver.getTitle());
		//System.out.println(driver.getTitle());
		//driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
	}

	@Parameters("browser")
	@BeforeTest
	public void testgrid(String browser) throws MalformedURLException 
	{
		String URL = "http://c.ap5.visual.force.com/apex/Home";
		if (browser.equalsIgnoreCase("firefox")) 
		{
			System.out.println("Executing on Firefox");
			System.out.println("********************");
			String Node = "http://192.168.100.110:3334/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().window().maximize();
			driver.navigate().to(URL);

		}

		/*if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Executing on Chrome");
			System.out.println("*******************");
			String Node = "http://192.168.100.110:3335/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().window().maximize();
			driver.navigate().to(URL);
		}*/

	}

	@Test
	public void testUserDetails()
	{
		driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
		System.out.println(driver.getTitle());
		if("UserDetails-Home".equals(driver.getTitle()))
		{
			System.out.println("Test 1: Passed");
			System.out.println("Redirecting to Home Page");
		}
		else
		{
			System.out.println("Test 1: Failed");
			System.out.println("Failed to navigate Home Page");
		}
		
		driver.findElement(By.name("j_id0:j_id2:j_id3")).click();
		String stitle = driver.getTitle();
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
			driver.findElement(By.name("j_id0:j_id31:name")).sendKeys("Arun");
			driver.findElement(By.name("j_id0:j_id31:email")).sendKeys("Arun@gmail.com");
			driver.findElement(By.name("j_id0:j_id31:username")).sendKeys("Arun");
			driver.findElement(By.name("j_id0:j_id31:pwd")).sendKeys("Arun");
			driver.findElement(By.name("j_id0:j_id31:repwd")).sendKeys("Arun");
			driver.findElement(By.name("j_id0:j_id31:j_id38")).click();
			String home1 = driver.getTitle();
			if ("UserDetails-Home".equals(home1))
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
				//driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
			}				
		//driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
		driver.findElement(By.name("j_id0:j_id2:j_id5")).click();
		// verify it is redirected to Login Page
		// ***************************************
		String login = driver.getTitle();
		if ("LoginPage".equals(login)) 
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
		driver.findElement(By.name("j_id0:login_form:un")).sendKeys("Arun");
		driver.findElement(By.name("j_id0:login_form:pwd")).sendKeys("Arun");
		driver.findElement(By.name("j_id0:login_form:j_id6")).click();

		// verify it is redirected to Userdetails Page
		// *******************************************
		String user = driver.getTitle();
		if ("UserDetail".equals(user)) 
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

		String id = driver.findElement(By.name("editable:j_id2:j_id6")).getText();
		String email = driver.findElement(By.name("editable:j_id2:j_id8")).getText();
		String name = driver.findElement(By.name("editable:j_id2:j_id10")).getText();

		// verify the retrieved details should not be null
		// ***********************************************
		if (id != null && email != null && name != null) {
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

		// click Edit Button
		driver.findElement(By.name("editable:j_id2:edit")).click();

		// Edit values
		driver.findElement(By.name("editable:j_id2:j_id6")).sendKeys("a" + id);
		driver.findElement(By.name("editable:j_id2:j_id8")).sendKeys("a");
		driver.findElement(By.name("editable:j_id2:j_id10")).sendKeys("a");
		driver.findElement(By.name("editable:j_id2:j_id12")).click();

		// Back to Home
		driver.get("https://c.ap5.visual.force.com/apex/Home");
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
	}
	
	//UserDetails_grid ug= new UserDetails_grid();
}
