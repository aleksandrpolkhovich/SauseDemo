import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SauseDemoTagsTest extends BaseTest {

    @Test
    public void tagsSauseDemo() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.tagName("footer"));
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Bike Light")).click();
        driver.findElement(By.cssSelector("[href='https://twitter.com/saucelabs']"));
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']"));

    }
}
