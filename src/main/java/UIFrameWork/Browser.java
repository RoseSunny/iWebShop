package UIFrameWork;

import config.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 2017-04-23.
 */
public class Browser {
    public static WebDriver driver;

    public Browser(){
        DriverType(Selenium.driverType);//打开火狐浏览器
        max();//浏览器最大化
    }
    //
    public static void DriverType(int driverType){
        switch (driverType){
            case 1:
                setUpFirefoxDriver();
                break;
            case 2:
                setUpChromeDriver();
                break;
        }
    }
    //打开火狐浏览器
    private static void setUpFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    //打开谷歌浏览器
    private static void setUpChromeDriver(){
        System.setProperty("webdriver.chrome.driver","");
        driver = new ChromeDriver();
    }
    //最大化
    private static void max(){
        driver.manage().window().maximize();//浏览器最大化
    }

    public static void main(String[] args) {
        Browser b = new Browser();
    }
}
