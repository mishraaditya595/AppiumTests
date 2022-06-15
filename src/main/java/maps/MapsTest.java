package maps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class MapsTest {
    public static void main(String[] args) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.maps");
        caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        caps.setCapability("noReset","true");

        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub/");
            AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[contains(@resource-id,'com.google.android.apps.maps:id/mylocation_button')]")).click();
            driver.findElement(By.xpath("//*[contains(@text,'Approximate')]")).click();


        } catch (Exception e) {}
    }
}
