package android;
import java.net.URL;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackSample {



    public static String userName = "huseyinkartal_3nk15I";
    public static String accessKey = "yisbgwmYjx8gvszoHKre";

    @Test
    public void browserStackTest01() throws MalformedURLException {

// Use Java Client v6.0.0 or above
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("app", "bs://e1f8fc81849df5915ed91e07cc4190a112df5442");

       //     AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        AndroidDriver <AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
    }
}