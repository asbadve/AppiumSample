import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchMode {

    public static final String PASSWORD = "org.wordpress.android:id/nux_password";
    public static final String SIGN_IN_BUTTON = "org.wordpress.android:id/nux_sign_in_button";
    public static final String BLOG_POSTS_TEXT_VIEW = "org.wordpress.android:id/my_site_blog_posts_text_view";
    public static final String ORG_WORDPRESS_TEXT = "org.wordpress.android:id/text_excerpt";

    private DesiredCapabilities caps;
    private AppiumDriver<MobileElement> driver;
    private AppiumDriver driverMobile;

    @Test
    public void launchwithAndroid() throws InterruptedException {
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
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        driver.findElement(By.id("org.wordpress.android:id/nux_create_account_button")).click();
//        driver.findElement(By.xpath("org.wordpress.android:id/email_address")).click();
        driver.findElement(By.id("org.wordpress.android:id/email_address")).click();
        driver.findElement(By.id("org.wordpress.android:id/email_address")).sendKeys("asbadve@gmail.com");//org.wordpress.android:id/email_address
        driver.findElement(By.id("org.wordpress.android:id/username")).click();
        driver.findElement(By.id("org.wordpress.android:id/username")).sendKeys("asbadve1234");//org.wordpress.android:id/email_address
        driver.findElement(By.id("org.wordpress.android:id/password")).click();
        driver.findElement(By.id("org.wordpress.android:id/password")).sendKeys("123456");//org.wordpress.android:id/email_address
        driver.findElement(By.id("org.wordpress.android:id/site_url")).click();
        driver.findElement(By.id("org.wordpress.android:id/site_url")).sendKeys("www.google.com");//org.wordpress.android:id/email_address

        driver.findElement(By.id("org.wordpress.android:id/signup_button")).click();

        Thread.sleep(4000);

    }

    @Test
    public void launchSignIn() throws InterruptedException, MalformedURLException {
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

        Thread.sleep(4000L);

        String password = "Hello12345678";
        String userName = "vodqa@gmail.com";


        driver.findElement(By.id("org.wordpress.android:id/nux_username")).setValue(userName);
        driver.findElement(By.id(SIGN_IN_BUTTON)).click();

        String USE_PASSWORD_INSTEAD_LINK = "org.wordpress.android:id/password_layout";
        WebDriverWait wait = new WebDriverWait(driver, 80);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(USE_PASSWORD_INSTEAD_LINK)));

        driver.findElement(By.id(USE_PASSWORD_INSTEAD_LINK)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD)));
        driver.findElement(By.id(PASSWORD)).setValue(password);
        driver.findElement(By.id(SIGN_IN_BUTTON)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BLOG_POSTS_TEXT_VIEW)));
        driver.findElement(By.id(BLOG_POSTS_TEXT_VIEW)).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ORG_WORDPRESS_TEXT)));
        Assert.assertEquals("VodQA Rocks!!", driver.findElement(By.id(ORG_WORDPRESS_TEXT)).getText());

        driver.quit();
    }

    @Test
    public void SampleTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/wordpress.apk");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        try {
            driverMobile = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver.hideKeyboard();

        driverMobile.findElementById("org.wordpress.android:id/nux_username").sendKeys("vodqa@gmail.com");


        new WebDriverWait(driverMobile, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/nux_sign_in_button")));
        driverMobile.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driverMobile, 70).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/password_layout")));
        driverMobile.findElementById("org.wordpress.android:id/password_layout").click();


        driverMobile.findElementById("org.wordpress.android:id/nux_password").sendKeys("Hello12345678");
        driverMobile.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driverMobile, 70).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/my_site_blog_posts_text_view")));
        driverMobile.findElementById("org.wordpress.android:id/my_site_blog_posts_text_view").click();


        new WebDriverWait(driverMobile, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/card_view")));

        String text = driverMobile.findElementById("org.wordpress.android:id/text_title").getText();
        Assert.assertTrue(text.contains("Vod"));
    }
}
