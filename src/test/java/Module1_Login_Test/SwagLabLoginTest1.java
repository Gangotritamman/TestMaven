package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIbraryFiles.BaseClass;
import LIbraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabMenuPage;

public class SwagLabLoginTest1 extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{
		InitilizeBrowser();
		 login=new SwagLabLoginPage(driver);
		 home=new SwagLabHomePage(driver);
	     menu=new SwagLabMenuPage(driver);			
	}
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		login.inpSwagLabLoginPageUN(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagePWd(UtilityClass.getDataFromPF("PWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageBtn();
		Thread.sleep(3000);
	}
	@Test
	public void VerifyTitle() throws EncryptedDocumentException, IOException 
	{
		TCID=101;
		//home.verifySwagLabHomePageTitle(sh.getRow(0).getCell(2).getStringCellValue());
		String actTitle = home.getSwagLabHomePageTitle();
		String expTitle = UtilityClass.GetTD(0,2);
		Assert.assertEquals(actTitle, expTitle,"failed:both results are failed");
	}
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			//code to capture ss
			UtilityClass.captureSS(driver, TCID);
		}
		home.clickSwagLabHomePagemenuBtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPagelogout();
		Thread.sleep(2000);
	}
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();;
	}

}
