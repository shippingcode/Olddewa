package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.DEWALogout;
import pages.DEWADashboard;


public class TestDEWALogout {

    WebDriver driver;

    DEWALogout objLogout;

    DEWADashboard objDashboard;

    

  /*  @BeforeTest

    public void setup(){

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://dewa.hubeleon.ae/");

    }

    /**

     * This test case will login in http://dewa.hubeleon.ae/

     * Login to application

     * Verify the home page using Dashboard message

    */

    @Test(priority=0)

    public void test_logout_with_success(){

        //Create Login Page object

    objLogout = new DEWALogout(driver);

     //login to application

    objLogout.logoutFromDEWA();

    // go the next page

    objDashboard = new DEWADashboard(driver);

    //Verify Dashboard

    Assert.assertTrue(objLogout.toString().equals("http://dewa.hubeleon.ae/wicket/bookmarkable/com.hubeleon.wicket.principal.SignIn?1"));

    }
}