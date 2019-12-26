package driver;

import org.openqa.selenium.WebDriver;

public class DriverProvider {

    private static DriverProvider instance = null;
    private static WebDriver driver;


    public static DriverProvider getInstance() {
        if (null == instance) {
            instance = new DriverProvider();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static void setDriver(WebDriver driver) {
        DriverProvider.driver = driver;
    }
}
