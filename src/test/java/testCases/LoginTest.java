package testCases;

import config.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = BrowserSetup.initializeDriver(browser);
        driver.get("https://www.spicejet.com/");
    }

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[4]/div[2]/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[1]/div[2]/input")).sendKeys("Password@123");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]")).click();
        // Add validations
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
