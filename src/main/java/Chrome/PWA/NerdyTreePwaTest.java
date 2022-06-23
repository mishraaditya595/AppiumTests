package Chrome.PWA;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NerdyTreePwaTest {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("noReset","true");
        caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(CapabilityType.VERSION, "91.0.4472.114");

        URL url = new URL("http://0.0.0.0:4723/wd/hub/");
        AndroidDriver driver = new AndroidDriver<MobileElement>(url, caps);
        driver.get("https://www.nerdytree.com");
        Thread.sleep(1000);
        Boolean flag = driver.findElement(By.xpath("//*[@id=\"img_comp-kyb3nqad\"]/img")).isDisplayed();
        System.out.println(flag);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/span/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"MENU_AS_CONTAINER_TOGGLE\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MENU_AS_CONTAINER_EXPANDABLE_MENU\"]/ul/li[3]/div/span/a")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//*[@id=\"comp-ky9q658k\"]")).getText();
        System.out.println(text);
        assert (text.equals("The meaning of Karma is in the intention. The intention behind the action is what matters."));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"MENU_AS_CONTAINER_TOGGLE\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"comp-ky89xnk2\"]/button/span")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"switchToEmailLink_SM_ROOT_COMP13\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"input_input_emailInput_SM_ROOT_COMP13\"]")).sendKeys("WRONGUSER");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"input_input_passwordInput_SM_ROOT_COMP13\"]")).sendKeys("PASS");
        Thread.sleep(500);
        scrollDown(driver);
        Thread.sleep(500);
        scrollDown(driver);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"okButton_SM_ROOT_COMP13\"]")).click();
        Thread.sleep(1000);
        String err = driver.findElement(By.xpath("//*[@id=\"siteMembersInputErrorMessage_emailInput_SM_ROOT_COMP13\"]")).getText();
        System.out.println(err);
    }

    private static void scrollDown(AppiumDriver driver) {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY, driver);
    }

    private static void scroll(int fromX, int fromY, int toX, int toY, AppiumDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }
}
