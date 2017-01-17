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

public class DEVICES_Map_Location {
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
            driver.findElement(By.linkText((String)"Map Location")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        if (driver.findElement(By.id((String)"codMap")).isDisplayed()) {
            System.out.println("Site map is being displayed");
        } else {
            System.out.println("Site map is not being displayed");
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