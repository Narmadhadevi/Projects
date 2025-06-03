package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverSetup;

public class EmployeeListPage {
    WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEmployeePresent(String name) {
        return driver.getPageSource().contains(name);
    }
}
