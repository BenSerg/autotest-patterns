package org.example;

import org.junit.Assert;

import org.junit.Test;



public class LoginPageTest extends BaseTest
{
  public static final String LOGIN="technoPol30";
  public static final String PASSWORD="technoPolis2022";
  public static final String USERNAME="Bot Receiver";
  @Test
  public void entry()
  {
    setup(); //- если раскоментить setup, все заработает
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=loginPage.loginAs(LOGIN, PASSWORD);
    Assert.assertEquals(homePage.getUserName(), USERNAME);
  }
}
