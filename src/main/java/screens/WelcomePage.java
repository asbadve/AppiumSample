package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WelcomePage extends UtilBaseClass {
    WelcomePageObjectsSample welcomePageObjectsSample;

    public WelcomePage(AppiumDriver driver) {
        super(driver);
        welcomePageObjectsSample = new WelcomePageObjectsSample();
        PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), welcomePageObjectsSample);
    }

    public void enterUserNameAndContinue() {
        welcomePageObjectsSample.userName.sendKeys("vodqa@gmail.com\n");
        waitForElement(welcomePageObjectsSample.nextButton).click();

    }
}
