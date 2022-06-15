package Chrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {
    public static void main(String args[]) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset","true");

        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub/");
            AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[contains(@text,'Search or type web address')]")).sendKeys("nerdytree.com");
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

            driver.findElement(By.xpath("//*[contains(@resource-id,'com.android.chrome:id/tab_switcher_button')]")).click();

//            driver.findElement(By.xpath("//*[contains(@content-desc,'New tab')]")).click();
            boolean flag = driver.findElement(By.xpath("//*[contains(@content-desc,'New tab')]")).isDisplayed();
            if (flag)
                System.out.println("True");
            else
                System.out.println("False");
            driver.findElement(By.xpath("//*[contains(@bounds,'[0,66][154,220]')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[contains(@resource-id,'com.android.chrome:id/tab_switcher_button')]")).click();
            driver.findElement(By.xpath("//*[contains(@text,'NerdyTree: Master Your Finance')]")).click();
            driver.findElement(By.xpath("//*[contains(@resource-id,'com.android.chrome:id/home_button')]")).click();



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
