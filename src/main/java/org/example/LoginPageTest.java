package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginPageTest extends BaseTest
{
  @ParameterizedTest
  @Timeout(10)
  @ValueSource(strings = {"Bot Receiver"})
  public void entry(String username)
  {
    Assertions.assertEquals(userPage.getUserName(), username);
  }
}
