package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteMessageTest extends BaseTest
{
  @Test
  public void deleteTest()
  {
    String old_msg = userPage.timeLineClick().getLastPostMessage();
    userPage.deleteLastMsg();
    Assertions.assertNotEquals(userPage.getLastPostMessage(), old_msg);
  }
}
