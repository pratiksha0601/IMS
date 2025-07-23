package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
@Parameters({"browser"})
@BeforeClass
public void setUp(String br) {
	switch(br) {
	case "chrome":driver=new ChromeDriver();
	break;
	case "edge":driver=new EdgeDriver();
	break;
	case "firefox":driver=new FirefoxDriver();
	break;
	default:System.out.println("Invalid");
	return;
	}
	
	driver.get("https://techassignments.imsindia.com/ipm-indore-classroom-2026/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
@AfterClass
public void tearDown() {
	driver.close();
}
public String captureScreen(String tname) throws IOException {
	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sourceFile=ts.getScreenshotAs(OutputType.FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;
}
}
