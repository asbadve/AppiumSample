package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilBaseClass {
    AppiumDriver driver;
    private WebDriverWait webDriverWait;
    public UtilBaseClass(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,50);
    }

    public MobileElement waitForElement(MobileElement mobileElement) {
        webDriverWait.until(ExpectedConditions.
                elementToBeClickable(mobileElement));
        return mobileElement;

    }
}
