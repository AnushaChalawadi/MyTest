package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Base_page
{
	public static WebDriver driver;
	public Base_page(WebDriver driver)
	{
		Base_page.driver=driver;
	}
	public void verifyTitle(String etitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleContains(etitle));
			Reporter.log("Title is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching",true);
			Assert.fail();
		}
			
	}
		public void verifyElementIsPresent(WebElement element)
		{
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			try
			{
				wait1.until(ExpectedConditions.visibilityOf(element));
				//wait1.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
				
				//WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='post_shout_group_selectbox_chzn']")));
				//wait1.until(ExpectedConditions.elementToBeClickable(element));
				Reporter.log("Element is present",true);
			}
			catch(Exception e)
			{
				Reporter.log("Element is not Present ",true);
				Assert.fail();
			}
			
		}
	
		
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		//wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("xpath_of_element_to_be_invisible")));
}
