package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import util.BaseClass;

public class Scenario4 extends BaseClass {

  @When("I see the error message")
  public void i_see_the_error_message() {
    Assert.assertTrue(LoginPage.checkErrorMessage());
  }

  @Then("Validate the error message")
  public void validate_the_error_message(String message) {
    Assert.assertEquals(LoginPage.getErrorMsg(), message);
    driver.quit();
  }
}
