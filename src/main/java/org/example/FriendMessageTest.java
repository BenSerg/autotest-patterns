package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FriendMessageTest extends BaseTest
{
  private static final By FRIENDS_BUTTON = By.xpath("//*[@data-l = 't,userFriend']");
  private static final By GRID_CARD_LOCATOR = By.xpath("//*[@class = 'user-grid-card']");
  private static final By MESSAGE_BUTTON = By.xpath("//*[contains(@class, button) and contains(@class, 'send-msg')]");
  @Test
  public void friendMsgTest()
  {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(FRIENDS_BUTTON)).click();
    List< WebElement > list = new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElements(GRID_CARD_LOCATOR));
    ArrayList<FriendCard> friendCards = new ArrayList<>();
    for (WebElement elem : list)
    {
      friendCards.add(new FriendCard(elem));
    }
    int friend_number = (int)(Math.random() * friendCards.size());
    String friendName = friendCards.get(friend_number).getName();
    driver.findElement(MESSAGE_BUTTON).click();
    MessagePage messagePage = new MessagePage(driver);
    Assertions.assertEquals(friendName, messagePage.getFriendName());
  }
}
