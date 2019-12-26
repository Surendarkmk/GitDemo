package driver.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public class SeleniumDriver implements IDriver {

    private WebDriver driver;

    public SeleniumDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getNativeDriver() {
        return driver;
    }

    @Override
    public void click(String locator, LocatorType locatorType, Optional<Long> waitTimeInMills) throws Exception {

        WebElement webElement = findElement(locator, locatorType, waitTimeInMills);
        waitForElementToBeClickable(webElement);
        webElement.click();
        waitForPageToLoad();

    }

    @Override
    public void type(String locator, LocatorType locatorType, String value, Optional<Long> waitTimeInMills) throws Exception {

        WebElement webElement = findElement(locator, locatorType, waitTimeInMills);
        waitForElementToBeClickable(webElement);
        webElement.sendKeys(value);

    }

    @Override
    public void select(String locator, LocatorType locatorType, String value, Optional<Long> waitTimeInMills) throws Exception {
        WebElement webElement = findElement(locator, locatorType, waitTimeInMills);
        waitForElementToBeClickable(webElement);
        Select selectElement = new Select(webElement);
        selectElement.selectByVisibleText(value);

    }

    @Override
    public String getText(String locator, LocatorType locatorType, Optional<Long> waitTimeInMills) throws Exception {
        WebElement webElement = findElement(locator, locatorType, waitTimeInMills);
        waitForElementToBeClickable(webElement);
        return webElement.getText();

    }

    public <T> String readText (T elementAttr) throws Exception {
        if(elementAttr.getClass().getName().contains("By")) {
            return findElement(elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    public <T> WebElement findElement (T elementAttr) throws Exception {
        if(elementAttr.getClass().getName().contains("By")) {

            List<WebElement> webElements = (new WebDriverWait(driver, 2))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) elementAttr));

            if(webElements.size() == 0) {
                String reason = String.format("WebElement with locator %s and locatorType %s not found");
                throw new NoSuchElementException(reason);
            }

            if(webElements.size() > 1) {
                String reason = String.format("There are %s WebElements with locator %s and locatorType %s",
                        webElements.size());
                throw new Exception(reason);
            }

            return webElements.get(0);

        } else {
            waitForElementToBeClickable((WebElement) elementAttr);
            return ((WebElement) elementAttr);
        }
    }



    public WebElement findElement(String locator, LocatorType locatorType, Optional<Long> waitTimeInMills) throws Exception {

        long waitTime = waitTimeInMills.isPresent() ? waitTimeInMills.get() : 100;
        By locatorStrategy = LocatorTypeMapper.map(locatorType, locator);

        List<WebElement> webElements = (new WebDriverWait(driver, waitTime))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorStrategy));

        if(webElements.size() == 0) {
            String reason = String.format("WebElement with locator %s and locatorType %s not found",
                    locator,
                    locatorType.toString());
            throw new NoSuchElementException(reason);
        }

        if(webElements.size() > 1) {
            String reason = String.format("There are %s WebElements with locator %s and locatorType %s",
                    webElements.size(),
                    locator,
                    locatorType.toString());
            throw new Exception(reason);
        }

        return webElements.get(0);


    }

    private void waitForElementToBeClickable(WebElement webElement) throws Exception {

        try {
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(webElement));
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    private void waitForPageToLoad() {
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void get(String url) {
        driver.get(url);
        waitForPageToLoad();
    }

    public void close() {
        driver.close();
        driver.quit();
    }

}
