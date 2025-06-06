package week7.day1w7;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClass {
	public ChromeDriver driver;
	public String filename;
	public int sheetNo;

	@Parameters({"url","username","password"})
	@BeforeMethod

public void pre(String url,String username,String password) {
	WebDriverManager.chromiumdriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	
}
	
	@DataProvider(name="fetch")
	public String[][] sendData() throws IOException{
		return ExcelAll.excelAll(filename,sheetNo);
	}
	
	
	
	
@AfterMethod
public void post() {
driver.close();
}
}
