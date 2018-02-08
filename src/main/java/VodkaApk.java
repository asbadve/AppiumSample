import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class VodkaApk {
    private DesiredCapabilities caps;
    private AndroidDriver driver;

    @Before
    public void before() {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                AutomationName.ANDROID_UIAUTOMATOR2);
//        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.vodqareactnative");
//        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
//                "com.vodqareactnative.MainActivity");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/VodQA.apk");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void horizontalSwipe() throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement chainedView = (MobileElement) driver.findElementByAccessibilityId("slider1");
        chainedView.click();
        Thread.sleep(4000L);
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        TouchAction action = new TouchAction(driver);
        Dimension d = slider.getSize();
        action.press(ElementOption.element(slider, 0, d.getHeight() / 2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider, d.getWidth() / 2, d.getHeight() / 2)) // move it
                .release().perform();//release it

        Thread.sleep(4000L);

    }

    @Test
    public void verticalSwipe() throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementByAccessibilityId("verticalSwipe").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement list = (MobileElement) driver.findElementByAccessibilityId("listview");


        TouchAction action = new TouchAction(driver);
        Dimension d = list.getSize();

        action.press(ElementOption.element(list, d.getWidth() / 2, d.getHeight() / 2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few seconds since APpIUM has bug for iOS devices
                moveTo(ElementOption.element(list, d.getWidth() / 2, d.getHeight() / 4)) // move it
                .release().perform();//release it
        Thread.sleep(4000L);

    }

    @Test
    public void dragDrop() throws InterruptedException {
//        dragMe
//        dropzone
        driver.findElement(By.className("android.widget.Button")).click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementByAccessibilityId("dragAndDrop").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement dragMe = (MobileElement) driver.findElementByAccessibilityId("dragMe");
        MobileElement dropZone = (MobileElement) driver.findElementByAccessibilityId("dropzone");


        TouchAction action = new TouchAction(driver);
        Dimension d = dragMe.getSize();
        Dimension dz = dropZone.getSize();

        action.press(ElementOption.element(dragMe, d.getWidth() / 2, d.getHeight() / 2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few seconds since APpIUM has bug for iOS devices
                moveTo(ElementOption.element(dropZone, dz.getWidth() / 2, dz.getHeight() / 2)) // move it
                .release().perform();//release it
        Thread.sleep(4000L);


    }

    @Test
    public void multiHorizontalSwipe() throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement chainedView = (MobileElement) driver.findElementByAccessibilityId("slider1");
        chainedView.click();
        Thread.sleep(4000L);
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        TouchAction action = new TouchAction(driver);
        Dimension d = slider.getSize();
        action.press(ElementOption.element(slider, 0, d.getHeight() / 2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider, d.getWidth() / 2, d.getHeight() / 2)) // move it
                .release();//release it

        MobileElement slider2 = (MobileElement) driver.findElementByAccessibilityId("slider1");
        TouchAction action2 = new TouchAction(driver);
        Dimension d2 = slider2.getSize();
        action2.press(ElementOption.element(slider2, 0, d2.getHeight() / 2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider2, d2.getWidth() / 2, d2.getHeight() / 2)) // move it
                .release();//release it


        new MultiTouchAction(driver).add(action).add(action2).perform();

        Thread.sleep(4000L);

    }

    @Test
    public void dooubleTap() throws InterruptedException {
//        doubleTap
//        doubleTapMe

        driver.findElement(By.className("android.widget.Button")).click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement chainedView = (MobileElement) driver.findElementByAccessibilityId("doubleTap");
        chainedView.click();
        Thread.sleep(4000L);

        MobileElement doubleTapView = (MobileElement) driver.findElementByAccessibilityId("doubleTapMe");
        Dimension d = doubleTapView.getSize();
        TouchAction action1 = new TouchAction(driver);


        action1.tap(ElementOption.element(doubleTapView, d.getWidth() / 2, d.getHeight() / 2));
        action1.tap(ElementOption.element(doubleTapView, d.getWidth() / 2, d.getHeight() / 2));
        action1.perform();


        Assert.assertEquals("Double tap successful!", driver.findElement(By.id("android:id/message")).getText());

        Thread.sleep(4000L);


    }


    @After
    public void quit() {
        driver.quit();

    }
}
