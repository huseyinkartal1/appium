package appiumTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_AppiumTest {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        //todo emulator -list-avds => cihaz ismini de bu kod sayesinde buluruz.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        //todo adb shell getprop ro.build.version.release => version bulmak için
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Java\\Appium\\src\\app\\Duolingo.apk");

        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);


        WebElement getStarted=driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        var actual = getStarted.getText();
        String expected="Get Started";

        System.out.println(actual);

        Assert.assertTrue(actual.equalsIgnoreCase(expected));

        getStarted.click();


        WebElement continueButton=driver.findElement(By.id("com.duolingo:id/continueButton"));

        continueButton.click();

        Thread.sleep(2000);

        WebElement continue2Button=driver.findElement(By.xpath("//*[@text=\"CONTINUE\"]"));

        continue2Button.click();

        WebElement ingilizceButton=driver.findElement(By.xpath("//*[@text=\"İngilizce\"]"));

        ingilizceButton.click();

        WebElement continue3Button=driver.findElement(By.xpath("//*[@text=\"CONTINUE\"]"));
        continue3Button.click();



        WebElement changeButton=driver.findElement(By.id("com.duolingo:id/changeButton"));

       changeButton.click();



        WebElement changeTurkish=driver.findElement(By.xpath("//*[@text=\"CHANGE TO TURKISH\"]"));
        changeTurkish.click();


    }

}