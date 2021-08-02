package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import util.BaseClass;

public class Scenario3 extends BaseClass {

  @When("Get the price of all products and remove the dollar symbol")
  public void getThePriceOfAllProductsAndRemoveTheDollarSymbol() {
    HomePage.getItemsPrice();
  }

  @Then("Validate the price with product listing with product individual page")
  public void validateThePriceWithProductListingWithProductIndividualPage() {
    HomePage.validateItemsPrice();
    driver.quit();
  }
}
