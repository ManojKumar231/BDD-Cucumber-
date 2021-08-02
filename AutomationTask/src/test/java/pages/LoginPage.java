package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseClass;

public class LoginPage extends BaseClass {

  public static final By TXT_USERNAME = By.id("user-name");

  public static final By TXT_PASSWORD = By.id("password");

  public static final By LOGIN_BUTTON = By.id("login-button");

  public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public static void enterUserName(String username) {
    fillTextField(driver, TXT_USERNAME, username);
  }

  public static void enterPassword(String password) {
    fillTextField(driver, TXT_PASSWORD, password);
  }

  public static void clickLogin() {
    click(driver, LOGIN_BUTTON);
  }

  public static void login(WebDriver driver
                    ,String username, String password) {
    fillTextField(driver, TXT_USERNAME, username);
    fillTextField(driver, TXT_PASSWORD, password);
    click(driver, LOGIN_BUTTON);
  }

  public static String getErrorMsg() {
    return getElementText(driver, ERROR_MESSAGE);
  }

  public static boolean checkErrorMessage(){
    boolean message = elementIsDisplayed(driver,ERROR_MESSAGE);
    return message;
  }
}
