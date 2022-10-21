package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.example.Constants.*;

public class LoginPageTest
{
  public WebDriver driver_;

  public LoginPageTest()
  {
  }

  @Before
  public void setup()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver_=new FirefoxDriver();
    driver_.get(URL);
  }

  @Test
  public void entry()
  {
    LoginPage loginPage=new LoginPage(driver_);
    HomePage homePage=loginPage.loginAs(LOGIN, PASSWORD);
    Assert.assertEquals(homePage.getUserName(), USERNAME);
    driver_.close();
  }
}
