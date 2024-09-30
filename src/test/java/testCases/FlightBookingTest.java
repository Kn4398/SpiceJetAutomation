package testCases;

import config.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightBookingTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = BrowserSetup.initializeDriver(browser);
        driver.get("https://www.spicejet.com/");
    }

    @Test
    public void searchFlight() {
        // Searching for One-way Flight
        driver.findElement(By.xpath("//input[@value='Delhi (DEL)']")).sendKeys("Delhi");
        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@type='text']")).sendKeys("Mum");
//        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();
//        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/*[name()='svg'][1]")).sendKeys(Keys.RETURN);;
        driver.findElement(By.className("css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79")).click();
        // Select flight and proceed to booking
//        driver.findElement(By.xpath("//div[@class='flight-option']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
        // Add validations
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
