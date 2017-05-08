package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageFactory.DEWALogoutPageFactory;
import pages.DEWADashboardPage;


public class DEWALogoutTest {

    WebDriver driver;

    DEWALogoutPageFactory objLogout;

    DEWADashboardPage objDashboard;

    

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

    objLogout = new DEWALogoutPageFactory(driver);

     //login to application

    objLogout.logoutFromDEWA();

    // go the next page

    objDashboard = new DEWADashboardPage(driver);

    //Verify Dashboard

    Assert.assertTrue(objLogout.toString().equals("http://dewa.hubeleon.ae/wicket/bookmarkable/com.hubeleon.wicket.principal.SignIn?1"));

    }
}