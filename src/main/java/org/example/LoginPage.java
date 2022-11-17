package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginPage
{
  private static final By USERNAME_LOCATOR = By.xpath("//*[@id=\"field_email\"]");
  private static final By PASSWORD_LOCATOR = By.xpath("//*[@id=\"field_password\"]");
  private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//*[@value='Войти в Одноклассники']");
  private final WebDriver driver;
  public LoginPage(WebDriver driver)
  {
    this.driver = driver;
    By LOGIN_FORM_LOCATOR = By.xpath("//*[@id='hook_Block_AnonymMain']");
    Assertions.assertAll(
      () -> assertNotNull(driver.findElement(LOGIN_FORM_LOCATOR)),
      () -> assertNotNull(driver.findElement(USERNAME_LOCATOR)),
      () -> assertNotNull(driver.findElement(PASSWORD_LOCATOR)),
      () -> assertNotNull(driver.findElement(LOGIN_BUTTON_LOCATOR)));
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
    driver.findElement(LOGIN_BUTTON_LOCATOR).submit();
  }

  public UserPage loginAs(TestBot testBot)
  {
    typeUsername(testBot.getLogin());
    typePassword(testBot.getPassword());
    submitLogin();
    return new UserPage(driver);
  }
}
