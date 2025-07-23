package pageObjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ImsCourse extends BasePage {
	
	public ImsCourse(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="city")
	WebElement select_cities;
	@FindBy(id="centernew")
	WebElement select_center;
	@FindBy(xpath="//*[@class='course-cost__cost']/span[2]")
	WebElement base_price;
	
	public void selectCity(String cityname) {
		Select s=new Select(select_cities);
		s.selectByVisibleText(cityname);
		
	}
	public void selectCentre(String centrename) {
		Select s=new Select(select_center);
		s.selectByVisibleText(centrename);
	}
	public boolean compareBaseExpectedPrice(int expectedprice) {
		int base=Integer.parseInt(base_price.getText().substring(1));
		if(base==expectedprice) {
			System.out.println(base+" is equal to expected "+expectedprice);
			return true;
		}
		else {
			System.out.println(base+" is not equal to expected "+expectedprice);
			return false;
		}
	}

	
}
