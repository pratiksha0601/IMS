package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ImsCourse;
import testBase.BaseClass;
import utilities.DataProviders;

public class VerifyCourseFeesDisplayedCorrectly extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyCourseFeesDisplayedCorrectly(String city,String centre,String expectedprice) {
		ImsCourse course=new ImsCourse(driver);
		course.selectCity(city);
		course.selectCentre(centre);
		boolean result=course.compareBaseExpectedPrice(Integer.parseInt(expectedprice));
		Assert.assertTrue(result,"Price does not match");
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
//		sourcefile.renameTo(targetfile);
		
	}
}
