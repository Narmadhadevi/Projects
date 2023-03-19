package week7.day1w7;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends AllClass {
	@BeforeClass
	public void setFile() {
		filename="create";
		sheetNo=0;
	}
	
	@Test(dataProvider="fetch",threadPoolSize=2)
		public void runCreate(String cname,String fname,String lname,String phno) {		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	
}






