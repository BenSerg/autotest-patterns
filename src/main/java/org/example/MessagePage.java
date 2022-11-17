package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePage
{
  private static final By FRIEND_NAME_LOCATOR = By.xpath("//*[@class='title']//*[@class='container']");
  private final WebDriver driver;

  public MessagePage(WebDriver driver)
  {
    this.driver = driver;
  }

  public String getFriendName()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(FRIEND_NAME_LOCATOR)).getText();
  }
}