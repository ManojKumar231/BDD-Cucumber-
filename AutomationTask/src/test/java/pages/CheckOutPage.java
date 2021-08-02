package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseClass;

public class CheckOutPage extends BaseClass {

  public static final By TXT_FIRSTNAME = By.id("first-name");

  public static final By TXT_LASTNAME = By.id("last-name");

  public static final By TXT_POSTCODE = By.id("postal-code");

  public static final By CONTINUE_BUTTON = By.id("continue");

  WebDriver driver;

/*  @FindBy(how = How.ID, using = "first-name")
  WebElement txt_firstname;

  @FindBy(how = How.ID, using = "last-name")
  WebElement txt_lastname;

  @FindBy(how = How.ID, using = "postal-code")
  WebElement txt_postcode;

  @FindBy(how = How.ID, using = "continue")
  WebElement continue_button;*/

  public CheckOutPage(WebDriver driver) {
    this.driver = driver;
  }

  public void fillFirstName(String firstname) {
    fillTextField(driver, TXT_FIRSTNAME, firstname);
  }

  public void fillLastName(String lastname) {
    fillTextField(driver, TXT_LASTNAME, lastname);
  }

  public void fillPostalCode(String postcode) {
    fillTextField(driver, TXT_POSTCODE, postcode);
  }

  public void clickContinueButton() {
    click(driver, CONTINUE_BUTTON);
  }
}
