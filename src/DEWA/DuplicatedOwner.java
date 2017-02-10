package DEWA;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import DEWA.AddOwner;


public class DuplicatedOwner extends AddOwner{
	 @SuppressWarnings("null")
	public void f() throws FileNotFoundException {
		 WebDriver driver = null;
         int i;
		 AddOwner owner = new AddOwner();
		 for(i=1; i<3;i++){
	     owner.f();
		 }
		 if(driver.getPageSource().contains("Error! Owner name duplicity"));
		   {
			   try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.id("closeOwner"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
				}catch(Exception e)
				{
					System.out.println(e);
				}
		   }
		 			  	 
	    }
	}




 		
 		
 	
 		
 	

 	
