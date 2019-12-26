package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static utils.Browsers.CHROME;

public class BrowserStackDriver {

    public WebDriver getDriver(String browser) throws Exception {

        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.local", browserstackLocal);
        capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        capabilities.setCapability("browserstack.local", true);
        capabilities.setCapability("browserstack.debug", true);
        capabilities.setCapability("browser", browser);
        String username = "shaileshgupta1";
        String accessKey = "Ws651axspWdf59uHLRns";

        switch (browser) {
            case CHROME:
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setVersion("71");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;

            /*case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                break;

            case IE:
                capabilities.setPlatform(Platform.WIN10);
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(CapabilityType.BROWSER_NAME, "IE");
                internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                break;

            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setUseTechnologyPreview(true);*/


        }

        return new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), capabilities);
    }
}
