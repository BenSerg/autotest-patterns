package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest
{
  private static final String DRIVER_NAME = "webdriver.gecko.driver";
  private static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  private static final String URL = "https://ok.ru/";
  private static final String LOGIN="technoPol30";
  private static final String PASSWORD="technoPolis2022";
  private static final String USERNAME="Bot Receiver";
  protected static WebDriver driver;
  protected static UserPage userPage;
  @BeforeEach
  public void setup()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    driver.get(URL);
    TestBot testBot = new TestBot(LOGIN, PASSWORD, USERNAME);
    LoginPage loginPage = new LoginPage(driver);
    userPage = loginPage.loginAs(testBot);
  }
  @AfterEach
  public void quit()
  {
    driver.quit();
  }
}
