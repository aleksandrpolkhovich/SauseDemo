import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SauseDemoCheckingTheItemInTheCartTest extends BaseTest {

    @Test
    public void checkingTheItemInTheCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //проверим, находимся ли мы на нужной странице после логина
        boolean checklogin = driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
        assertTrue(checklogin, "Не удалось залогиниться");

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        String productname = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productname, "Sauce Labs Bike Light",
                "Не совпадают имена товара в каталоге и в корзине");
        String productprice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        assertEquals(productprice, "$9.99",
                "Не совпадает цена товара в каталоге и в корзине");
    }
}
