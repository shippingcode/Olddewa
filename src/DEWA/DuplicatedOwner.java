package DEWA;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DEWA.AddOwner;


public class DuplicatedOwner extends AddOwner{
	WebDriver driver = null;
	GenerateData genData = null;
	String doubleowner = GenerateData.generateRandomString(20);
	
	public void duplicatedownercheck() throws FileNotFoundException {
         int i;
		 AddOwner owner = new AddOwner();
		 for(i=1; i<3;i++){
	     owner.addowner();
		 }
		 if(driver.getPageSource().contains("Error! Owner name duplicity"));
		   {
			   try{
				Thread.sleep(1500);
				driver.findElement(By.id("closeOwner")).click();
			   }catch(Exception e)
				{
				System.out.println(e);
				}
			
		   }
		 //Logout 
	 		try{
	 		Thread.sleep(1500);
	 		driver.findElement(By.className("icon-eject")).click();
	 		}catch(Exception e)
	 		{
	 		System.out.println(e);
	 		}
	 }
}
		 			  	 





 		
 		
 	
 		
 	

 	
