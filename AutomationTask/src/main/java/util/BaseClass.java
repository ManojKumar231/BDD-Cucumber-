package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass {

  public static WebDriver driver;

  public static void waitForExpectedElement(WebDriver driver, final By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static void click(WebDriver driver, final By locator) {
    waitForExpectedElement(driver, locator);
    driver.findElement(locator).click();
  }

  public static String getElementText(WebDriver driver, final By locator) {
    waitForExpectedElement(driver, locator);
    return driver.findElement(locator).getText();
  }

  public static void fillTextField(WebDriver driver, final By locator, String text) {
    waitForExpectedElement(driver, locator);
    driver.findElement(locator).sendKeys(text);
  }

  public static boolean elementIsDisplayed(WebDriver driver, final By locator) {
    waitForExpectedElement(driver, locator);
    return driver.findElement(locator).isDisplayed();
  }

  public void launchBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
  }
}
