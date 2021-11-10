import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    WebDriver driver;//выносим driver в переменную класса, чтобы взаимодействовать с ним в нескольких разныъ методах!

    @BeforeMethod//прекондишен. Не BeforeTest!
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);//отркрывается браузер;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)//посткондишен. закрыть браузер в любом случае, даже когда тест упал!
    public void tearDown() {
        driver.quit();
    }
}
