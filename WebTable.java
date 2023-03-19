package week4.assignment2w4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*1. Launch the URL https://html.com/tags/table/
2. You have to print the respective values based on given Library
(hint: if the library was absolute usage, then print all its value)
*/
public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> noOfRows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		int size=noOfRows.size();
		System.out.println(size);
		List<String> value=new ArrayList<String>();
		Thread.sleep(2000);
		for(int i=1;i<=size;i++) {
			String w = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td[1]")).getText();
			value.add(w);
		}
		System.out.println(value);
		driver.close();
	}

}
