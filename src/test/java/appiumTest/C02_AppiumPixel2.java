package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_AppiumPixel2 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        //todo emulator -list-avds => cihaz ismini de bu kod sayesinde buluruz.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        //todo adb shell getprop ro.build.version.release => version bulmak için
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Java\\Appium\\src\\app\\apidemos.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);


        //1. Apidemos'a girilir
        //2. Preference tıklanır
        //3. Preference dependencies tıklanır
        //4. WiFi check box aktif edilir.
        //5. Wifi Settings tıklanır
        //6. Gelen ekrana 'Appium çok güzel' yazılır ve OK tıklanır
        //7. Tekrar tıklayıp yazılan cümleyi dogrulayıp konsola yazdırınız.

        WebElement preference = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]"));
        preference.click();
        WebElement dependencies = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
        dependencies.click();
        WebElement checkbox = driver.findElement(By.id("android:id/checkbox"));
        checkbox.click();
        WebElement settings = driver.findElement(By.xpath("//*[@text=\"WiFi settings\"]"));
        settings.click();

        WebElement edit = driver.findElement(By.xpath("//*[@resource-id=\"android:id/edit\"]"));
        edit.sendKeys("Appium Cok Güzel");
        WebElement ok = driver.findElement(By.id("android:id/button1"));
        ok.click();

        Thread.sleep(1000);

       settings.click();

        Thread.sleep(1000);

        String expected="Appium Cok Güzel";
        WebElement edit2 = driver.findElement(By.xpath("//*[@resource-id=\"android:id/edit\"]"));

        Assert.assertEquals("yazi aynı değil",edit2.getText(),expected);

        System.out.println(edit2.getText());

    }

}
