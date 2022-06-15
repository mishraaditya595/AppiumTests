package Calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest2 {
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

            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("left or right parenthesis");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("divide");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("left or right parenthesis");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("plus");
            el6.click();
            MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Expand");
            el7.click();
            MobileElement el8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
            el8.click();
            MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("power");
            el9.click();
            MobileElement el10 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_0");
            el10.click();
            MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Collapse");
            el11.click();
            MobileElement el12 = (MobileElement) driver.findElementByAccessibilityId("minus");
            el12.click();
            MobileElement el13 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
            el13.click();
            MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("point");
            el14.click();
            el14.click();
            MobileElement el15 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
            el15.click();
            MobileElement el16 = (MobileElement) driver.findElementByAccessibilityId("equals");
            el16.click();

            finalOutput = driver.findElementById("com.google.android.calculator:id/result_final").getText();
            System.out.println(finalOutput);

            MobileElement el17 = (MobileElement) driver.findElementByAccessibilityId("clear");
            el17.click();

            finalOutput = driver.findElementById("com.google.android.calculator:id/formula").getText();
            System.out.println(finalOutput);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
