/* Add sub-menu Location from DEVICES Tab */

package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DEVICES_Location {
    boolean test = false;

    @Test
    public void devicelocation() throws FileNotFoundException {
    	//Login
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
            driver.findElement(By.name("username")).sendKeys(prop.getProperty("username1"));
            driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
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
        driver.findElement(By.linkText("Location")).click();
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("search")).sendKeys("Strada Zambilei, Cluj-Napoca, Romania");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("btnSearch")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.cssSelector("span.icon-search")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
           if(driver.findElement(By.linkText("Offline")).isDisplayed());
           {
           driver.findElement(By.linkText("Offline")).click();
           if(driver.getPageSource().contains("Offline")){
        	   System.out.println("Device status correponds to the status location");
        	   test = true;
             }
           else
           {
        	   System.out.println("Something went wrong");
             }
           }
           
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.className("icon-eject")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
    }
}