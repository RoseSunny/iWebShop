package UIInterfaceFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Lian on 2017-04-23.
 */
public class Browser {
    WebDriver Driver;

    public void SetupFirefox() {
//        System.setProperty ( "webdriver.firefox.bin" , "E:/Program Files/Mozilla Firefox/firefox.exe" );
        Driver = new FirefoxDriver();
    }

    public void SetupChrome() {
        System.setProperty("webdriver.chromedriver.exe", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        Driver = new ChromeDriver();
    }

    public Browser(int driverType) {
        setDriver(driverType);
        maxBrowser();
    }

    public void setDriver(int driverType) {
        switch (driverType) {
            case 1:
                SetupFirefox();
                break;
            case 2:
                SetupChrome();
                break;
        }
    }

    public void maxBrowser() {
        Driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        Browser browser = new Browser(2);
    }
}
