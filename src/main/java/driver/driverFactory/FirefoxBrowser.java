package driver.driverFactory;

import driver.BrowserStackDriver;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FirefoxBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() throws Exception {
        setDriverBinaryPath();
        switch (driverEnvironment) {
            case DriverEnvironment.ZALENIUM:
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                return new RemoteWebDriver(new URL("http://10.140.10.138:4444/wd/hub"), capabilities);

            case DriverEnvironment.BROWSERSTACK:
                return new BrowserStackDriver().getDriver(driver);

            default:
                return new FirefoxDriver();
        }
    }

    @Override
    public void setDriverBinaryPath() {
        if (SystemUtils.IS_OS_MAC)
            System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
    }
}
