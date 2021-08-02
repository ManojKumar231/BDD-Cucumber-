package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckOutOverviewPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.YourCartPage;
import util.BaseClass;
import util.ConfigFile;

public class LoginSteps extends BaseClass {

  ConfigFile con = new ConfigFile();

  LoginPage loginPage = new LoginPage(driver);

  HomePage homePage = new HomePage(driver);

  String itemName = null;

  String itemDescription = null;

  String itemPrice = null;

  CheckOutPage checkOutPage = new CheckOutPage(driver);

  YourCartPage yourCartPage = new YourCartPage(driver);

  CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(driver);

  String expected_itemName = null;

  String expected_itemDescription = null;

  String expected_itemPrice = null;

  @Given("^I login with (.*) and (.*)")
  public void login_with_standard_user_and_secret_sauce(String username, String password) {
    launchBrowser();
    loginPage.login(driver, username, password);
  }

  @When("Add the product to cart")
  public void add_the_product_to_cart() {
    itemName = homePage.getItemName();
    itemDescription = homePage.getItemDescription();
    itemPrice = homePage.getItemPrice();
    homePage.clickAddToCart();
    homePage.clickOnCartButton();
  }

  @And("Checkout the product")
  public void checkout_the_product() {
    yourCartPage = new YourCartPage(driver);
    yourCartPage.clickOnCheckOutButton();
  }

  @And("^I fill the checkout details (.*) and (.*) and (.*)")
  public void iFillTheCheckoutDetailsManojAndRAnd(String firstname, String lastname, String postcode) {
    checkOutPage = new CheckOutPage(driver);
    checkOutPage.fillFirstName(firstname);
    checkOutPage.fillLastName(lastname);
    checkOutPage.fillPostalCode(postcode);
    checkOutPage.clickContinueButton();
  }

  @Then("Validate the product details whether you are ordered the correct product")
  public void validate_the_product_details_whether_you_are_ordered_the_correct_product() {
    checkOutOverviewPage = new CheckOutOverviewPage(driver);
    expected_itemName = checkOutOverviewPage.getItemName();
    Assert.assertEquals(itemName, expected_itemName);
    expected_itemDescription = checkOutOverviewPage.getItemDescription();
    Assert.assertEquals(itemDescription, expected_itemDescription);
    expected_itemPrice = checkOutOverviewPage.getItemPrice();
    Assert.assertEquals(itemPrice, expected_itemPrice);
    driver.quit();
  }
}
