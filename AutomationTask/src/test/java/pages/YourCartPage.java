package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseClass;

public class YourCartPage extends BaseClass {
  public static final By CHECKOUT_BUTTON = By.id("checkout");

  WebDriver driver;

  /*@FindBy(how = How.ID,using = "checkout")
  WebElement checkout_button;
*/

  public YourCartPage(WebDriver driver) {
    this.driver = driver;
    //PageFactory.initElements(driver,this);
  }

  public void clickOnCheckOutButton() {
    click(driver, CHECKOUT_BUTTON);
  }
}