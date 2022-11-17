package org.example;

public class TestBot
{
  private final String login;
  private final String password;
  private String name;

  public TestBot(String login, String password, String name)
  {
    this.login = login;
    this.password = password;
    this.name = name;
  }
  public String getLogin()
  {
    return this.login;
  }
  public String getPassword()
  {
    return this.password;
  }
  public String getName()
  {
    return this.name;
  }
}
