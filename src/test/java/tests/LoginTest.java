package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkingTheItemInTheCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //проверим, находимся ли мы на нужной странице после логина
        boolean checklogin = driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
        assertTrue(checklogin, "Не удалось залогиниться");
    }
}