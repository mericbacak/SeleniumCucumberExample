package utils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class Driver {
    private static WebDriver driver;
    private Driver() {
    }
    public static WebDriver getWebDriver() {
        if (driver == null) {
            String desiredBrowser = ConfigReader.getProperty("browser");
            switch (desiredBrowser) {
                case "chrome":
                    ChromeOptions chromeOptions2 = new ChromeOptions();
                    chromeOptions2.addArguments("--disable-infobars");
                    chromeOptions2.addArguments("--version");
                    chromeOptions2.addArguments("--no-sandbox");  // Sandbox modunu devre dışı bırak
                    chromeOptions2.addArguments("--start-maximized");
                    chromeOptions2.addArguments("--disable-popup-blocking");
                    chromeOptions2.addArguments("--enable-automation");
                    chromeOptions2.addArguments("--incognito");
                    chromeOptions2.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(chromeOptions2);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                   driver=new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}