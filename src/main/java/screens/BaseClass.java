package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    private final DesiredCapabilities caps;
    AppiumDriver driver;

    public BaseClass() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/wordpress.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);


    }
}
