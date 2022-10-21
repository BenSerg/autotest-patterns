package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
  private final WebDriver driver_;
  By userName=By.xpath("//*[@data-l='t,userPage']");

  public HomePage(WebDriver driver)
  {
    this.driver_=driver;
  }

  public String getUserName()
  {
    WebElement firstResult=new WebDriverWait(driver_, Duration.ofSeconds(10)).until(driver_ -> driver_.findElement(userName));
    return firstResult.getText();
  }
}
