package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void test() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);

        //скорее всего можно сделать тоже через параметризацию с циклом как в тесте и по сути будет 2 прогона хром и мозилла, но оставвил закомменченым

         org.openqa.selenium.firefox.FirefoxOptions optionsFx = new org.openqa.selenium.firefox.FirefoxOptions();
         optionsFx.addArguments("--no-sandbox");
         driver = new org.openqa.selenium.firefox.FirefoxDriver(optionsFx);

        //Когда-то давно учился уже на AQA и привык смотреть на выполнение АТ глазами, оставил такую настройку
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
    }
}