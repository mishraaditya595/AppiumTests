package Calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest3 {
    //by using xpath
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");




            URL url = new URL("http://0.0.0.0:4723/wd/hub/");
            AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url, caps);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.findElement(By.xpath("//*[contains(@text,'8')]")).click();

            Thread.sleep(5000);

            String finalOutput =driver.findElement(By.xpath("//*[contains(@resource-id,'com.google.android.calculator:id/formula_scroll_view')]/android.widget.TextView")).getText();
            System.out.println(finalOutput);

            //finalOutput=String.valueOf(finalOutput);
            //System.out.println("in try "+finalOutput);

            //System.out.println("Output: "+finalOutput);
    }
}
