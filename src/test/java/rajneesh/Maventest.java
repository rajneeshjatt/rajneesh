package rajneesh;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;

public class Maventest {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "/home/nishant/Desktop/pgdac/chromedriver_linux64/chromedriver";
	public WebDriver driver;

	@BeforeTest
	public void f() {
		// System.setProperty("webdriver.chrome.driver",
		// "/home/nishant/Desktop/pgdac/chromedriver_linux64/chromedriver");
		// webDriver driver = new ChromeDriver();
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		System.out.println("init");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions);
		//driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void login() {
		System.out.println("matching tilte");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("matched tilte");
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("rajneesh");
		System.out.println("email entered");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("123456");
		System.out.println("password entered");
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		System.out.println("clicked on login");
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
