
/* Add sub-menu Events from DEVICES Tab */
package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DEVICES_Events {
    boolean test = false;

    @Test
    public void f() throws FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
        try {
            prop.load(file);
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        WebDriver driver = new FirefoxDriver(); 
        //System.setProperty("webdriver.chrome.driver", "C://Users/Aila/Downloads/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url1"));
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"username")).sendKeys(prop.getProperty("username1"));
            driver.findElement(By.name((String)"password")).sendKeys(prop.getProperty("password1"));
            driver.findElement(By.xpath((String)"//input[@value='Log In']")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            WebElement orgdropdown = driver.findElement(By.name("organisation"));
            Select org = new Select(orgdropdown);
            org.selectByVisibleText("TEST");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("devices")).click();
            driver.findElement(By.linkText("List")).isDisplayed();
            driver.findElement(By.linkText("Map")).isDisplayed();
            driver.findElement(By.linkText("Events")).isDisplayed();
            driver.findElement(By.linkText("Overview")).isDisplayed();
            driver.findElement(By.linkText("Location")).isDisplayed();
            driver.findElement(By.linkText("Map Location")).isDisplayed();
            driver.findElement(By.linkText("Report")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.linkText("Events")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("search")).sendKeys("device1");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("startScreen")).clear();
            driver.findElement(By.name("startScreen")).sendKeys("01/01/2015 00:00");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("startScreen")).clear();
            driver.findElement(By.name("endScreen")).sendKeys("01/01/2017 00:00");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("searchBtn")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("searchEvents")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("panelEventDetail:deviceLink")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
           driver.findElement(By.id("statusDevice")).isDisplayed();
            driver.findElement(By.id("locationDevice")).isDisplayed();
            driver.findElement(By.id("controlDevice")).isDisplayed();
            driver.findElement(By.id("controlDocuments")).isDisplayed();
            driver.findElement(By.id("historyEvents")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
        Thread.sleep(1500);
        driver.findElement(By.id("locationDevice")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("controlDevice")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("controlDocuments")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("historyEvents")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        
        //Logout
        try {
            Thread.sleep(1500);
            driver.findElement(By.className("icon-eject")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        test = true;
    }
}