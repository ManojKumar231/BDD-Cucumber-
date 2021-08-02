package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseClass {

  public static final By ITEM_NAME = By.xpath("//a[@id='item_4_title_link']/div");

  public static final By ITEM_DESCRIPTION = By.xpath("((//div[@class='inventory_item_desc'])[position()=1])");

  public static final By ITEM_PRICE = By.xpath("((//div[@class='inventory_item_price'])[position()=1])");

  public static final By ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");

  public static final By CART_ICON = By.id("shopping_cart_container");

  public static final By ITEMS_LIST = By.xpath("//div[@class='inventory_item_name']");

  public static final By ITEMS_PRICE = By.xpath("//div[@class='inventory_item_price']");

  public static final By PRODUCT_PRICE = By.xpath("//div[@class='inventory_details_price']");

  public static final By BACK_BUTTON = By.name("back-to-products");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public static boolean getItemsList(String message) {
    List<WebElement> list1 = driver.findElements(ITEMS_LIST);
    for (WebElement list2 : list1) {
      if (list2.getText().equalsIgnoreCase(message)) {
        return true;
      }
    }
    return false;
  }

  public static void getItemsPrice() {
    List<WebElement> li = driver.findElements(ITEMS_PRICE);
    ArrayList al = new ArrayList();
    for (WebElement li2 : li) {
      String price = li2.getText();
      String newPrice = (price.replaceAll("[$,]", ""));
      al.add(newPrice);
    }
  }

  public static void validateItemsPrice() {
    List<WebElement> li = driver.findElements(ITEMS_PRICE);
    ArrayList al = new ArrayList();
    for (WebElement li2 : li) {
      String price = li2.getText();
      String newPrice = (price.replaceAll("[$,]", ""));
      al.add(newPrice);
    }
    int count = 0;
    ArrayList al2 = new ArrayList();
    List<WebElement> li3 = driver.findElements(ITEMS_LIST);
    for (int i = 1; i <= li3.size(); i++) {
      driver.findElement(By.xpath("(//a/div[@class='inventory_item_name'])[" + i + "]")).click();
      String productprice = getElementText(driver, PRODUCT_PRICE);
      String newproductprice = productprice.replaceAll("[$,]", "");
      System.out.println("new product price: " + newproductprice);
      System.out.println(al.get(count));
      if (al.get(count).equals(newproductprice)) {
        System.out.println("Both prices are equal");
      } else {
        System.out.println("Both prices are not equal");
      }
      count++;
      click(driver, BACK_BUTTON);
    }
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

  public void clickAddToCart() {
    click(driver, ADD_TO_CART);
  }

  public void clickOnCartButton() {
    click(driver, CART_ICON);
  }
}
