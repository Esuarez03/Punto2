package automatizacion;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class navegador {	
	
	WebDriver driver;
	WebDriver driver1;  
	String url = "http://automationpractice.com/index.php";
	
	@Test
	public void setUpDriver () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/java/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/java/resources/drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver1 = new FirefoxDriver(); 	
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?id_product=1&controller=product\"]")).click();
		driver.switchTo().frame(driver.findElement(By.id("fancybox-frame1657561810660")));
		driver.findElement(By.name("Submit"));
		driver.findElement(By.className("cross"));
		driver.switchTo().parentFrame();
		
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver1.get(url);
		driver1.findElement(By.className("button lnk_view btn btn-default")).click();
		driver1.switchTo().frame(driver1.findElement(By.className("clearfix")));
		driver1.findElement(By.className("exclusive")).click();
		driver1.findElement(By.className("continue btn btn-default button exclusive-medium")).click();
		driver1.switchTo().parentFrame();
		
	}
}
