package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PostingTest extends BaseTest
{
  @ParameterizedTest
  @ValueSource(strings = {"SHRECK", "shreck2"})
  public void postTest(String MESSAGE)
  {
    Assertions.assertEquals(userPage.timeLineClick().createPost().writePost(MESSAGE).getLastPostMessage(), MESSAGE);
  }
}
