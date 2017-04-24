package InterfaceFramework.Iwebshop.UIFrame;

import Utils.ReportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2017-04-23.
 */
public class webElementUtils extends Browser{
    private static ReportUtils report=new ReportUtils();
    //通过元素的id来定位
    public static WebElement findElement_Id(String id){
        if(id == null || id.equals("")){
            report.error("id为空");
            return null;
        }else{
            WebElement element = driver.findElement(By.id(id));
            report.log("通过id定位");
            return element;
        }
    }

    //通过元素的name来定位
    public static WebElement findElement_Name(String Name){
        if(Name.equals("") || Name == null){
            report.error("name为空");
            return null;
        }else {
            WebElement element = driver.findElement(By.className(Name));
            return element;
        }
    }

    //通过元素的tagName来定位
    public static WebElement findElement_tagName(String tagName){
        if(tagName.equals("") || tagName == null){
            report.error("tagName为空");
            return null;
        }else {
            WebElement element = driver.findElement(By.tagName(tagName));
            return element;
        }
    }

    //通过元素的classname来定位
    public static WebElement findElement_clsName(String clsName){
        if(clsName.equals("") || clsName == null){
            report.error("clsName为空");
            return null;
        }else {
            WebElement element = driver.findElement(By.className(clsName));
            return element;
        }
    }

    //通过linkText来定位
    public static void findElement_linkText(String linkText){
        if(linkText == null || linkText.equals("")){
            report.error("linkText为空");
            return;
        }else {
            driver.findElement(By.linkText(linkText));
        }
    }

    //通过xpath来定位
    public static WebElement findElement_xPath(String path){
        if(path == null || path.equals("")){
            report.error("path为空");
            return null;
        }else {
            WebElement element = driver.findElement(By.xpath(path));
            return element;
        }
    }

    //输入sendKey
    public void sendKey(WebElement element,String key){
        if(element == null || element.equals("")){
            report.error("element为空");
            return;
        }else {
            if(key == null || key.equals("")){
                report.error("key为空");
                return;
            }else {
                element.sendKeys(key);
            }
        }
    }

    //点击按钮
    public void click(WebElement element){
        if(element == null || element.equals("")){
            report.error("element为空");
            return;
        }else {
            element.click();
        }
    }

    //提交表单
    public void submit(WebElement element){
        if(element == null || element.equals("")){
            report.error("key为空");
            return;
        }else {
            element.submit();
        }
    }


    //下拉框的处理
    public Select selectId(String id,int index){
        WebElement selector = findElement_Id(id);
        Select select = new Select(selector);
        select.selectByIndex(index);//通过index
        return select;
    }

    //下拉框的处理
    public Select selectText(String id,String text){
        WebElement selector = findElement_Id(id);
        Select select = new Select(selector);
        select.selectByVisibleText(text);//下拉框中的值
        return select;
    }

    //下拉框的处理
    public Select selectValue(String id,String value){
        WebElement selector = findElement_Id(id);
        Select select = new Select(selector);
        select.selectByValue(value);//下拉框的标签里的值
        return select;
    }

    //鼠标事件(单击)
    public void contextClick(WebElement element){
        if (element == null || element.equals("")){
            report.log("元素为空");
        }else {
            report.log("单击");
            Actions action = new Actions(driver);
            action.contextClick(element).perform();
        }
    }

    //鼠标事件(双击)
    public void doubleClick(WebElement element){
        if (element == null || element.equals("")){
            report.log("元素为空");
        }else {
            report.log("双击");
            Actions action = new Actions(driver);
            action.doubleClick(element).perform();
        }
    }

    //鼠标事件(移动到另一个元素上)
    public void moveToElement(WebElement element){
        report.log("移动到另一个元素上");
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //鼠标事件(在一个对象上按住鼠标左键)
    public void clickAndHold(WebElement element){
        if (element == null || element.equals("")){
            report.log("元素为空");
        }else {
            report.log("在一个对象上按住鼠标左键");
            Actions action = new Actions(driver);
            action.clickAndHold(element).perform();
        }
    }

    //鼠标事件(释放鼠标)
    public void release(WebElement element){
        if (element == null || element.equals("")){
            report.log("元素为空");
        }else {
            report.log("释放鼠标");
            Actions action = new Actions(driver);
            action.click(element).release(element).perform();
        }
    }

    //键盘事件(tab键)
    public void Tab(WebElement element){
        if (element == null || element.equals("")){
            report.log("元素为空");
        }else {
            element.sendKeys(Keys.ALT);
        }
    }

}
