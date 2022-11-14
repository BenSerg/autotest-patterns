package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest
{
  public static final String LOGIN="technoPol30";
  public static final String PASSWORD="technoPolis2022";
  public static final String USERNAME="Bot Receiver";
  @Test
  public void entry()
  {
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=loginPage.loginAs(LOGIN, PASSWORD);
    Assertions.assertEquals(homePage.getUserName(), USERNAME);
  }
}
