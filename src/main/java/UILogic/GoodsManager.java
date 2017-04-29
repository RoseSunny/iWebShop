package UILogic;

import UIFrameWork.BrowserUtils;
import UIFrameWork.WebElementUtils;
import org.openqa.selenium.WebElement;

import java.util.Map;

/**
 * Created by chongqing on 2017/4/29.
 */
public class GoodsManager {
    public static void Login(Map<String,String> map){
        BrowserUtils browserUtils=new BrowserUtils();
        browserUtils.getDriver();
        browserUtils.openWeb(map.get("URL地址"));
        WebElement name=WebElementUtils.findElement_Name(map.get("findElement_Name"));
        WebElementUtils.sendKey(name,map.get("用户名"));
        WebElement password=WebElementUtils.findElement_Name(map.get("findElement_Password"));
        WebElementUtils.sendKey(password,map.get("密码"));
        browserUtils.pause(Integer.getInteger(map.get("等待时间")));
        WebElement captcha=WebElementUtils.findElement_Name(map.get("findElement_Captcha"));
        WebElementUtils.sendKey(captcha,map.get("验证码"));
        WebElement submit=WebElementUtils.findElement_xPath(map.get("findElement_Submit"));
        WebElementUtils.submit(submit);

    }
}
