package driver.driverFactory;

import driver.BrowserStackDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IeBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() throws Exception {

        switch (driverEnvironment) {

            case DriverEnvironment.BROWSERSTACK:
                return new BrowserStackDriver().getDriver(driver);

            default:
                return new InternetExplorerDriver();

        }

    }

    @Override
    public void setDriverBinaryPath() {

    }

}