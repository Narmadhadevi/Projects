package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.PimPage;
import pages.LogoutPage;
import pages.DashboardPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class EmployeeManagementTest extends LoginTest {

    @Test
    public void loginAddEmployeesAndLogoutTest() throws InterruptedException {
        // Verify dashboard
        DashboardPage dashboard = new DashboardPage(driver);
        assert dashboard.isDashboardDisplayed() : "Dashboard is not displayed";

        PimPage pim = new PimPage(driver);
        pim.goToPIM();

        // Add employees
        for (int i = 1; i <= 3; i++) {
            pim.clickAddEmployee();
            driver.findElement(By.name("firstName")).sendKeys("Test" + i);
            driver.findElement(By.name("lastName")).sendKeys("User" + i);Thread.sleep(5000);
            driver.findElement(By.xpath("//button[contains(@class,' oxd-button--secondary orangehrm-left-space')]")).click();
            Thread.sleep(10000);
        }
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()='Employee List']")).click();

        WebElement nameInput = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
        nameInput.sendKeys("Test");

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, '--medium oxd-button--secondary orangehrm-left-space')]"));
        searchButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-table-row")));

        List<String> expectedNames = Arrays.asList("Test1 User1", "Test2 User2", "Test3 User3", "Test4 User4");

        for (String expectedName : expectedNames) {
            boolean found = false;

            List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row"));
            for (WebElement row : rows) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", row);

                List<WebElement> cells = row.findElements(By.cssSelector(".oxd-table-cell"));
                if (cells.size() >= 4) {
                    String firstName = cells.get(2).getText().trim();
                    String lastName = cells.get(3).getText().trim();
                    String fullName = firstName + " " + lastName;

                    if (fullName.equals(expectedName)) {
                        System.out.println(expectedName + " - found");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println(expectedName + " - not found");
            }
        }

        LogoutPage logout = new LogoutPage(driver);
        logout.logout();
    }
}
