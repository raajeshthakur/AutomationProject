package UserInformation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import common.WaitForAction;
import common.WebDriversFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
public class Update_User_Password extends AccountInformation
{

  @AfterMethod
  
  public void update_password() throws InterruptedException
  {
	  
	  this.driver= WebDriversFactory.getWebDriversInstance("firefox");
	 driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 PageFactory.initElements(driver, this);
	  WaitForAction.Sleep(2000);
	  driver.findElement(By.xpath("//div[@class='input-group']//input[@id='loginPassword']")).sendKeys("344@test.com");
	  WaitForAction.Sleep(2000);
	  driver.findElement(By.id("loginPasswordConfirm")).sendKeys("344@test.com");
	  WaitForAction.Sleep(2000);
	  driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save')]")).click();
	  
	 //
	  String Message= driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/ul/li")).getText();
	  String Message1="Your information has been saved";
	  if (Message==Message1);{
	  System.out.println("information updated successfully");}
	  
	  if (Message!=Message1)
	  {	
		  System.out.println("information not updated successfully");
		  }
	 
	//Assert.assertEquals(Message.getText("Your information has been saved"), "Your information has been saved");
	  Assert.assertEquals(driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/ul/li")).getText(),"Your information has been saved");
	System.out.println("information updated successfully");
	
  }
}
