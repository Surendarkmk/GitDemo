package driver.selenium;

import java.util.Optional;

public interface IDriver {

    void click(String locator, LocatorType locatorType, Optional<Long> waitTimeInMills) throws Exception;
    void type(String locator, LocatorType locatorType, String value, Optional<Long> waitTimeInMills) throws Exception;
    void select(String locator, LocatorType locatorType, String value, Optional<Long> waitTimeInMills) throws Exception;
    String getText(String locator, LocatorType locatorType, Optional<Long> waitTimeInMills) throws Exception;

}
