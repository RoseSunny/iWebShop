package UIInterfaceFramework;

import Utils.ReportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lian on 2017-04-23.
 */
public class BrowserUtils extends Browser {
    ReportUtils report = new ReportUtils();
    WebDriver driver;

    public BrowserUtils(int driverType) {
        super(driverType);
    }

    //    打开浏览器
    public WebDriver getDriver() {
        System.out.println("打开firefox浏览器");
        BrowserUtils browserUtils = new BrowserUtils(1);
        return driver;
    }

    //    打开页面
    public void openweb(String url) {
        if (url.equals("") || url.length() == 0) {
            System.out.println("URL为空");
            return;
        } else {
            driver.get(url);
            System.out.println("URL为：");
        }
    }

    //    关闭页面
    public void closeweb() {
        driver.close();
    }

    //    关闭浏览器
    public void quit() {
        driver.quit();
    }

    //    暂停
    public void pause(long milliseconds) {
        if (milliseconds <= 0) {
            return;
        }
        driver.manage().timeouts();
    }

    public String getCurrenturl(String url) {
        System.out.println("获取当前页面");
        driver.getCurrentUrl();
        return url;
    }

    //    刷新
    public void refresh() {
        driver.navigate().refresh();
    }

    public WebDriver switch_frame(String element) {
        driver.switchTo().frame(element);
        return driver;
    }

    //    public WebDriver switch_frame(int){
//        return driver;
//    }
//    public WebDriver switch_frame(WebElement element){
//        driver.findElement(By.xpath(element.toString()));
//        return driver;
//    }
    public WebDriver switchto_windows(String element) {
        driver.switchTo().window(element);
        return driver;
    }

    //    前进
    public void forword() {
        driver.navigate().forward();
    }

    //   后退
    public void back() {
        driver.navigate().back();
    }
//    public void screenShot(String){}
//    public void screenShot(String,String){}
//    private void sshot(String,String){}
}
