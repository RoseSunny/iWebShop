package UIFrameWork;

import UIFrameWork.Browser;
import Utils.ReportUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2017-04-23.
 */
public class BrowserUtils extends Browser {
    private static ReportUtils report=new ReportUtils();

    //打开浏览器
    public WebDriver getDriver(){
        report.log("打开浏览器");
        return driver;
    }

    //打开网页
    public void openWeb(String url){
        if(url == null || url.equals("")){
            System.out.println("url为空");
            report.greenLight("url为空！");
            return;
        }else{
            driver.get(url);
            report.log("打开网页wei："+url);
        }
    }

    //关闭网页
    public void closeWeb(){
        report.log("关闭网页");
        driver.close();
    }

    //等待时间
    public void pause(int time){
        if(time <= 0 ){
            report.error("无需等待");
            return;
        }else{
            try {
                Thread.sleep(time);
                report.log("等待时间为："+time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭浏览器
    public void quit(){
        report.log("关闭浏览器");
        driver.quit();
    }

    //获取当前url
    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        report.log("获取当前url："+url);
        return url;
    }

    //刷新
    public void refresh(){
        driver.navigate().refresh();
        report.log("刷新");
    }

    //跳转窗口
    public WebDriver switchTo_window(String handle){
        WebDriver currDriver = driver.switchTo().window(handle);//通过获取到的窗口句柄跳转到窗口去
        report.log("跳转到窗口");
        return currDriver;
    }

    //内嵌页面的跳转通过id
    public WebDriver switchTo_Frame(String id){
        WebDriver frame = driver.switchTo().frame(id);
        report.log("跳转到内嵌页面");
        return frame;
    }

    //内嵌页面的跳转通过name
    public WebDriver switchTo_Frame(int index){
        WebDriver frame = driver.switchTo().frame(index);
        report.log("跳转到内嵌页面");
        return frame;
    }

    //内嵌页面的跳转通过元素
    public WebDriver switchTo_Frame(WebElement element){
        WebDriver frame = driver.switchTo().frame(element);
        report.log("跳转到内嵌页面");
        return frame;
    }

    //前进
    public void forward(){
        driver.navigate().forward();
        report.log("前进");
    }

    //后退
    public void back(){
        driver.navigate().back();
        report.log("后退");
    }
}
