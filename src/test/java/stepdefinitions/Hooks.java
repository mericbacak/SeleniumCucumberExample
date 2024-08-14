package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;
import static utils.Driver.getWebDriver;

public class Hooks {
    public static void killChromeProcesses() {
        try {
            // This will kill all Chrome processes
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            System.out.println("Chrome kill completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Before
    public void setUp() {
        killChromeProcesses();
        getWebDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDownWeb(@NotNull Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = Driver.getWebDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        killChromeProcesses();
    }
}