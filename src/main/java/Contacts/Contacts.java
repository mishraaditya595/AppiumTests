package Contacts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Contacts {
    public static AppiumDriver<MobileElement> driver;

    public static void main(String arg[])
    {

        appiumTest1();

    }
    //code for contact automation
    public static void appiumTest1() {
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("waitForQuietness", false);
        //caps.setCapability("waitForQuiescence", false);
        //caps.setCapability("wdaEventloopIdleDelay", 7);
        //caps.setCapability("eventLoopIdleDelaySec", 4);
        //caps.setCapability("startIWDP", true);
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Pixel 4");
        //caps.setCapability("udid","emulator-5554"); use one devicename or udid
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub/");
            driver=new AppiumDriver<MobileElement>(url,caps);
            //to wait for 20 sec
            WebDriverWait wait = new WebDriverWait(driver,10);

            // ADD A new contact button
            WebElement addContactButton= driver.findElementById("com.android.contacts:id/floating_action_button_container");
            addContactButton.click();

            //Add some wait
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.contacts:id/left_button")));

            //click cancel button
            WebElement cancelButton= driver.findElementById("com.android.contacts:id/left_button");
            cancelButton.click();

            //wait to fill the details and then to save it on device
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.contacts:id/account_name")));
            //Enter the first name
            WebElement FirstName= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]");
            FirstName.click();
            FirstName.sendKeys("manoj");

            //Enter last name
            WebElement lastname=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]");
            lastname.click();
            lastname.sendKeys("abc");

            //enter number
            WebElement number=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
            number.click();
            number.sendKeys("9081234545");

            WebElement save=driver.findElementById("com.android.contacts:id/editor_menu_save_button");
            save.click();


        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }
}