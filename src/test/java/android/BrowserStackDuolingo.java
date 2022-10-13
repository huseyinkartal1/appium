package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserStackDuolingo {


    public static String userName = "huseyinkartal_3nk15I";
    public static String accessKey = "yisbgwmYjx8gvszoHKre";

    @Test

    public void DuolingoTest() throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "11.0");
        capabilities.setCapability("device", "Samsung Galaxy M52");
        capabilities.setCapability("app", "bs://e1f8fc81849df5915ed91e07cc4190a112df5442");
        capabilities.setCapability("browserstack.debug", "true");
        capabilities.setCapability("browserstack.idleTimeout", "5");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);


        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        var actual = getStarted.getText();
        String expected = "Get Started";

        System.out.println(actual);

        Assert.assertTrue(actual.equalsIgnoreCase(expected));

        getStarted.click();


        WebElement continueButton = driver.findElement(By.id("com.duolingo:id/continueButton"));

        continueButton.click();

        Thread.sleep(2000);

        WebElement continue2Button = driver.findElement(By.xpath("//*[@text=\"CONTINUE\"]"));

        continue2Button.click();

        Thread.sleep(2000);

        WebElement ingilizceButton = driver.findElement(By.xpath("//*[@text=\"Spanish\"]"));
        ingilizceButton.click();

        Thread.sleep(2000);

        WebElement continue3Button = driver.findElement(By.xpath("//*[@text=\"CONTINUE\"]"));
        continue3Button.click();




        TouchAction touchAction=new TouchAction<>(driver);


            touchAction.press(PointOption.point(700,1700)).moveTo(PointOption.point(700, 250))
                    .release().perform();


    }}
