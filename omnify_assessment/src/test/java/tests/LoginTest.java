package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.WebDriverSetup;

public class LoginTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new WebDriverSetup().initializeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Login before each test
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername("Admin");
            loginPage.enterPassword("admin123");
            loginPage.clickLogin();
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
