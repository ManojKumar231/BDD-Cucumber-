package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseClass;

public class CheckOutOverviewPage extends BaseClass {

  public static final By ITEM_NAME = By.xpath("//a[@id='item_4_title_link']/div");

  public static final By ITEM_DESCRIPTION = By.xpath("((//div[@class='inventory_item_desc'])[position()=1])");

  public static final By ITEM_PRICE = By.xpath("((//div[@class='inventory_item_price'])[position()=1])");

  WebDriver driver;

  public CheckOutOverviewPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getItemName() {
    return getElementText(driver, ITEM_NAME);
  }

  public String getItemDescription() {
    return getElementText(driver, ITEM_DESCRIPTION);
  }

  public String getItemPrice() {
    return getElementText(driver, ITEM_PRICE);
  }
}
