package Calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    public static void main(String[] args) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        String finalOutput = "";

        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub/");
            AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url, caps);

            WebDriverWait wait = new WebDriverWait(driver,10);

            MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("multiply");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_0");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("equals");
            el6.click();

            finalOutput = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
