package UserInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import UserInformation.AccountInformation;
import common.WaitForAction;

public class UpdateInfoTestCase_001 extends AccountInformation{

  
@AfterMethod
	
  public void UserInformation() {
}
	

// Click on save button
@AfterMethod
public void checkNewUPass() {
		WaitForAction.Sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save')]")).click();
		//check validation message for password, do not enter passwords and click on save button
		String Msg=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/ul/li")).getText();
		String Msg1="New password is a required field";
		if(Msg==Msg1);
		System.out.println("message displayed:New password is a required field");
}
		// enter new password and click on save button
@AfterMethod
public void checkConfrimUPass() {
		driver.findElement(By.xpath("//div[@class='input-group']//input[@id='loginPassword']")).clear();
		driver.findElement(By.xpath("//div[@class='input-group']//input[@id='loginPassword']")).sendKeys("344@test.com");
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save')]")).click();
		WaitForAction.Sleep(2000);
		String Msg2=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/ul/li")).getText();
		String Msg3="The passwords do not match";
		if(Msg2==Msg3);

  }
}
