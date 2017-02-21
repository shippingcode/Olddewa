/* Add sub-menu Map from DEVICES Tab */
package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DEVICES_Map {
    boolean test = false;

    @Test
    public void map() throws FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
        try {
            prop.load(file);
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url1"));
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"username")).sendKeys(new CharSequence[]{prop.getProperty("username1")});
            driver.findElement(By.name((String)"password")).sendKeys(new CharSequence[]{prop.getProperty("password1")});
            driver.findElement(By.xpath((String)"//input[@value='Log In']")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            WebElement orgdropdown = driver.findElement(By.name((String)"organisation"));
            Select org = new Select(orgdropdown);
            org.selectByVisibleText("TEST");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id((String)"devices")).click();
            driver.findElement(By.linkText((String)"List")).isDisplayed();
            driver.findElement(By.linkText((String)"Map")).isDisplayed();
            driver.findElement(By.linkText((String)"Events")).isDisplayed();
            driver.findElement(By.linkText((String)"Overview")).isDisplayed();
            driver.findElement(By.linkText((String)"Location")).isDisplayed();
            driver.findElement(By.linkText((String)"Map Location")).isDisplayed();
            driver.findElement(By.linkText((String)"Report")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.linkText((String)"Map")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id((String)"search2")).sendKeys("device1");
            driver.findElement(By.id((String)"btnSearch")).click();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.className((String)"icon-eject")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        this.test = true;
    }
}