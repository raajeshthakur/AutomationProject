package UserInformation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

import common.WaitForAction;

public class Update_User_information extends AccountInformation {
	
@AfterMethod

public void UpdateUserInforamation()
{

	WaitForAction.Sleep(2000);
	// enter password, confirm password
	  driver.findElement(By.xpath("//div[@class='input-group']//input[@id='loginPassword']")).sendKeys("344@test.com");
	  WaitForAction.Sleep(2000);
	  driver.findElement(By.id("loginPasswordConfirm")).sendKeys("344@test.com");
	  WaitForAction.Sleep(2000);
	//update street address
	driver.findElement(By.id("street1")).clear();
	driver.findElement(By.id("street1")).sendKeys("345 greeat brome avenue");
	//update phone number
	driver.findElement(By.id("phone")).clear();
	driver.findElement(By.id("phone")).sendKeys("4443657893");
	driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save')]")).click();
	
	String Msg=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/ul/li")).getText();
	String Msg1="Your information has been saved";
	if(Msg==Msg1);
	System.out.println("street and phone number Updated succesfully");
	

}}
