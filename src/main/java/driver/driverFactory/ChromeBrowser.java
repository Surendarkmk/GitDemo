package driver.driverFactory;

import driver.BrowserStackDriver;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("allow-running-insecure-content");
        options.addArguments("--start-fullscreen");
        setDriverBinaryPath();
        switch (driverEnvironment) {
            case DriverEnvironment.ZALENIUM:
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                return new RemoteWebDriver(new URL("http://10.140.10.138:4444/wd/hub"), capabilities);

            case DriverEnvironment.BROWSERSTACK:
                return new BrowserStackDriver().getDriver(driver);
            default:
                return new ChromeDriver(options);
        }
    }

    public void setDriverBinaryPath() {
        if (SystemUtils.IS_OS_MAC)
            System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
        else if (SystemUtils.IS_OS_LINUX)
            System.setProperty("webdriver.chrome.driver", "libs/chromedriver_linux");
        else if (SystemUtils.IS_OS_WINDOWS)
            System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");

    }

}
