package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class WebDriverBase {

    protected WebDriver driver;

    /*
        Set up driver to work with Chrome browser
        Page load strategy = NONE to not wait for all resources
     */
    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }


    public void teardownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
