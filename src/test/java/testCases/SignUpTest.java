package testCases;

import config.BrowserSetup;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = BrowserSetup.initializeDriver(browser);
        driver.get("https://www.spicejet.com/");
    }

    @Test
    public void signUpTest() {
    	String originalWindow = driver.getWindowHandle();
        WebElement signup = driver.findElement(By.linkText("Signup"));
        signup.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")).click();

        
        
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/select/option[2]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Karthi");
        driver.findElement(By.id("last_name")).sendKeys("Karthik");
        driver.findElement(By.id("dobDate")).sendKeys("07/04/1998");
        driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']")).sendKeys("9876543211");
        driver.findElement(By.id("email_id")).sendKeys("dummyemail02@gmail.com");
        driver.findElement(By.id("new-password")).sendKeys("Password@123");
        driver.findElement(By.id("c-password")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='defaultCheck1']")).click();
        driver.findElement(By.linkText("Submit")).click();
        // Add validations
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
