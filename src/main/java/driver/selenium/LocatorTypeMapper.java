package driver.selenium;

import org.openqa.selenium.By;

public class LocatorTypeMapper {

    public static By map(LocatorType locatorType, String locator) throws Exception {

        switch (locatorType) {
            case ID:
                return By.id(locator);
            case CLASSNAME:
                return By.className(locator);
            case CSS:
                return By.cssSelector(locator);
            case XPATH:
                return By.xpath(locator);
            case LINKTEXT:
                return By.linkText(locator);
            case TAG:
                return By.tagName(locator);
            case PARTIALLINKTEXT:
                return By.partialLinkText(locator);
            default:
                throw new Exception("ERROR : InvalidLocatorTypeException");

        }

    }
}
