package driver;

import driver.driverFactory.ChromeBrowser;
import org.openqa.selenium.WebDriver;
import utils.Browsers;

public class DriverInitializer {

    private String browser;

    public DriverInitializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() throws Exception {

        WebDriver webDriver = null;

        switch (browser) {
            case Browsers.CHROME:
                webDriver = new ChromeBrowser().getDriver();
                break;

            /*case Browsers.FIREFOX:
                webDriver = new FirefoxBrowser().getDriver();
                break;

            case Browsers.IE:
                webDriver = new IeBrowser().getDriver();
                break;

            case Browsers.SAFARI:
                webDriver= new SafariBrowser().getDriver();
*/
            default:

        }

        DriverProvider.setDriver(webDriver);
        return webDriver;
    }

}
