
/* Add sub-menu Events from DEVICES Tab */
package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
        FileInputStream file = new FileInputStream("D:\\workspace\\DEWA\\src\\DEWA\\datadriven.properties");
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
            driver.findElement(By.linkText((String)"Events")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"search")).sendKeys(new CharSequence[]{"device1"});
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"start")).sendKeys(new CharSequence[]{"01/01/2015"});
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"end")).sendKeys(new CharSequence[]{"01/01/2017"});
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"searchBtn")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.cssSelector((String)"span.icon-cogs")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"panelEventDetail:deviceLink")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"statusDevice")).click();
            driver.findElement(By.name((String)"locationDevice")).click();
            driver.findElement(By.name((String)"controlDevice")).click();
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