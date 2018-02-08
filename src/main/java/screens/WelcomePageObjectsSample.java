package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePageObjectsSample {
    @AndroidFindBy(id = "org.wordpress.android:id/nux_username")
    public MobileElement userName;
    @AndroidFindBy(id = "org.wordpress.android:id/nux_sign_in_button")
    public MobileElement nextButton;

}
