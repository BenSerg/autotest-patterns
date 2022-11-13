package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest
{
  public static final String DRIVER_NAME = "webdriver.gecko.driver";
  public static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  public static final String URL = "https://ok.ru/";
  protected static WebDriver driver;
  @BeforeAll
  static void setup()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    driver.get(URL);
  }
}
