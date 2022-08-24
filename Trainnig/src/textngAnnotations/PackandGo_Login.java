package textngAnnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PackandGo_Login {
public	static WebDriver driver;
	
	@BeforeSuite 
	@Parameters({"Browser", "URL"})
	public void setup(@Optional("FireFox") String broweser,@Optional("FireFox") String url ){
		switch ("browser"){
		case "IE":
			System.setProperty("webdriver.ie.driver", "path");
			driver= new  InternetExplorerDriver(); 
			driver.get(url);
			break;
		
		case "Edge":
			System.setProperty("webdriver.edge.driver", "path");
			driver= new  EdgeDriver(); 
			driver.get(url);
			break;	
			
		case "FireFox":
			System.setProperty("webdriver.gecko.driver", "path");
			driver= new  FirefoxDriver(); 
			driver.get(url);
			break;	
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "path");
			driver= new  ChromeDriver(); 
			driver.get(url);
			break;	
			
		}
		}
	
	@DataProvider(name="credentials")
	public  Object [][] dataInput(){
		Object [][] data= new Object [2][2];
		data [0][0]= "pgguru";
		data [0][1]="freezeray";
		
		data[1][0]="pgAlmacho";
		data[1][1]="freezeray";
		return data;
		
		}
	
	
  @Test(dataProvider="credentials")
  public void login_Test(String username, String pass) {
	  driver.findElement(By.xpath("//*[@id=\'myNavbar\']/ul/li[4]/a")).click();
	  driver.findElement(By.id("usernameLogin")).sendKeys(username);
	  driver.findElement(By.id("passwordLogin")).sendKeys(pass);
	  driver.findElement(By.id("login")).click();
	try {
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("topMenu2")));
	System.out.println("login succesfull");
	}
	catch(Exception e) {
		System.out.println("Login failure");
	}
	 driver.findElement(By.id("topMenu2"));
  }

}
