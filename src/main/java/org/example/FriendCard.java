package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FriendCard
{
  private final WebElement item;
  private static final By NAME = By.xpath("//*[@class = 'ellip']");

  public FriendCard(WebElement element)
  {
    this.item = element;
  }

  public String getName()
  {
    return item.findElement(NAME).getText();
  }
}