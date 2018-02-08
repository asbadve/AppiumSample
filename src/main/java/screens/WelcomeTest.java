package screens;

import org.junit.Test;

import java.net.MalformedURLException;

public class WelcomeTest extends BaseClass {
    public WelcomeTest() throws MalformedURLException {
    }

    @Test
    public void loginPage() {
        WelcomePage welcomePage =new WelcomePage(driver);
        welcomePage.enterUserNameAndContinue();
    }

}
