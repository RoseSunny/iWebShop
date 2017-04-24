package UIInterfaceFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Lian on 2017-04-23.
 */
public class Webelement {
    WebDriver driver;
    Actions action = new Actions(driver);

    public void xpath(String element) {
        try {
            if (element == null || element.equals("")) {
                System.out.println("传入元素为空");
            } else {
                driver.findElement(By.xpath(element));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void classname(String classname) {
        if (classname == null || classname.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.className(classname));
        }
    }

    public void name(String name) {
        if (name == null || name.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.name(name));
        }
    }

    public void id(String id) {
        if (id == null || id.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.id(id));
        }
    }

    public void lintext(String text) {
        if (text == null || text.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.linkText(text));
        }
    }

    public void tagname(String tagname) {
        if (tagname == null || tagname.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.tagName(tagname));
        }
    }

    public void cssselector(String css) {
        if (css == null || css.equals("")) {
            System.out.println("传入元素为空");
        } else {
            driver.findElement(By.cssSelector(css));
        }
    }

    public void mouse(WebElement element) {
//        Actions action=new Actions(driver);
        action.contextClick().perform();
        action.doubleClick().perform();
        action.clickAndHold().perform();
        action.release().perform();
        action.moveToElement(element).perform();
    }

    public void click() {
        action.click();
    }

    public void submit(WebElement element) {
        if (element == null || element.equals("")) {
            System.out.println("element为空");
        } else {
            element.submit();
        }
    }

    public void sendkeys(WebElement element, String key) {
        if (element == null || element.equals("")) {
            System.out.println("element为空");
        } else if (key == null || key.equals("")) {
            System.out.println("key为空");
        } else {
            element.sendKeys(key);
        }
    }
}
