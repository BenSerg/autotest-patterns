package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
  private final By USERNAME_LOCATOR=By.xpath("//*[@id=\"field_email\"]");
  private final By PASSWORD_LOCATOR=By.xpath("//*[@id=\"field_password\"]");
  private final By LOGIN_BUTTON_LOCATOR=By.xpath("//*[@value='Войти в Одноклассники']");
  private final WebDriver driver;

  public LoginPage(WebDriver driver)
  {
    this.driver=driver;
    By LOGIN_FORM_LOCATOR = By.xpath("//*[@id='hook_Block_AnonymMain']");
    Assert.assertNotNull(driver.findElement(LOGIN_FORM_LOCATOR));
    Assert.assertNotNull(driver.findElement(USERNAME_LOCATOR));
    Assert.assertNotNull(driver.findElement(PASSWORD_LOCATOR));
    Assert.assertNotNull(driver.findElement(LOGIN_BUTTON_LOCATOR));
  }

  public void typeUsername(String username)
  {
    driver.findElement(USERNAME_LOCATOR).sendKeys(username);
  }

  public void typePassword(String password)
  {
    driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
  }

  public void submitLogin()
  {
    WebElement elem = driver.findElement(LOGIN_BUTTON_LOCATOR);
    Assert.assertNotNull(elem);
    elem.submit();
  }

  public HomePage loginAs(String username, String password)
  {
    typeUsername(username);
    typePassword(password);
    submitLogin();
    return new HomePage(driver);
  }
}
