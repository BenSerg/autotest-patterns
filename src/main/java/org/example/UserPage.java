package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserPage
{
  private final WebDriver driver;
  private static final By USERNAME = By.xpath("//*[@data-l = 't,userPage']");
  private static final By TIMELINE_LOCATOR = By.xpath("//*[@data-l = 't,userMain']");
  private static final By POSTING_LOCATOR = By.xpath("//*[contains(@data-l,'input')]");
  private static final By WRITING_LOCATOR = By.xpath("//*[contains(@class,'posting-handler')]");
  private static final By SHARE_BUTTON = By.xpath("//*[contains(@class,'posting') and contains(@class,'submit " + "button')]");
  private static final By LAST_POST_LOCATOR = By.xpath("//*[contains(@class,'feed') and contains(@data-l,'ownerUser')]/div[@class='feed_b']");
  public UserPage(WebDriver driver)
  {
    this.driver = driver;
  }

  public String getUserName()
  {
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(USERNAME)).getText();
  }

  public UserPage timeLineClick()
  {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(TIMELINE_LOCATOR)).click();
    return this;
  }

  public UserPage createPost()
  {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(POSTING_LOCATOR)).click();
    return this;
  }

  public UserPage writePost(String message)
  {
    new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> driver.findElement(WRITING_LOCATOR)).sendKeys(message);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(SHARE_BUTTON)).click();
    return this;
  }
  public String getLastPostMessage()
  {
    driver.navigate().refresh();
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(LAST_POST_LOCATOR)).getText();
  }
}
