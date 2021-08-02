package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import util.BaseClass;

public class Scenario2 extends BaseClass {

  @When("I get the list of all products")
  public void iGetTheListOfAllProducts() {
    //HomePage.getItemsList();
  }

  @Then("I verify Sauce Labs Bolt T-Shirt is in the list")
  public void iVerifySauceLabsBoltTShirtIsInTheList(String message) {
    Assert.assertTrue(HomePage.getItemsList(message));
    driver.quit();
  }
}
