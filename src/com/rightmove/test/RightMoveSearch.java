package com.rightmove.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RightMoveSearch {
	
	public WebDriver driver; 
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.rightmove.co.uk");
  }
  @Test
  public void testSearch(){
	  driver.findElement(By.id("searchLocation")).sendKeys("HA1 1RQ");
	  driver.findElement(By.id("rent")).click();
	  driver.manage().window().maximize();
	  System.out.println(driver.getTitle());
	  Select radius = new Select(driver.findElement(By.id("radius")));
	  radius.selectByValue("1.0");
	  Select priceMin = new Select(driver.findElement(By.id("minPrice")));
	  priceMin.selectByValue("800");
	  Select bedrooms = new Select(driver.findElement(By.id("minBedrooms")));
	  bedrooms.selectByValue("1");
	  Select addedToSite = new Select(driver.findElement(By.id("maxDaysSinceAdded")));
	  addedToSite.selectByValue("7");
	  driver.findElement(By.id("submit")).click();
	  WebElement we = driver.findElement(By.id("numberOfProperties"));
	  System.out.printf(we.getAttribute("class"));
	  
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
