package Iwebshop;

import Interfaces.USER.user;
import Utils.IteratorUtils;
import Utils.ReportUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class UserLogin_Test {
    private static ReportUtils report = new ReportUtils();
    Assertion assertion = new Assertion();

    @DataProvider(name = "open")
    public Iterator<Object[]> open() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "打开首页", ".xlsx");
    }

    @Test(dataProvider = "open", priority = 0)
    public void open(Map<String, String> map) {
        String response = user.open(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "login")
    public Iterator<Object[]> login() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "登录", ".xlsx");
    }

    @Test(dataProvider = "login", priority = 1)
    public void login(Map<String, String> map) {
        String response = user.login(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "choosegoods")
    public Iterator<Object[]> choosegoods() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "选择商品", ".xlsx");
    }

    @Test(dataProvider = "choosegoods", priority = 2)
    public void choosegoods(Map<String, String> map) {
        String response = user.choosegoods(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "buy")
    public Iterator<Object[]> buy() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "直接购买", ".xlsx");
    }

    @Test(dataProvider = "buy", priority = 3)
    public void buy(Map<String, String> map) {
        String response = user.buy(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "shopping_cart")
    public Iterator<Object[]> shopping_cart() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "加入购物车", ".xlsx");
    }

    @Test(dataProvider = "shopping_cart", priority = 4)
    public void shopping_cart(Map<String, String> map) {
        String response = user.shopping_cart(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "address")
    public Iterator<Object[]> address() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "收货地址", ".xlsx");
    }

    @Test(dataProvider = "address", priority = 5)
    public void address(Map<String, String> map) {
        String response = user.address(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "submit")
    public Iterator<Object[]> submit() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "提交订单", ".xlsx");
    }

    @Test(dataProvider = "submit", priority = 6)
    public void submit(Map<String, String> map) {
        String response = user.submit(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "pay")
    public Iterator<Object[]> pay() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "支付", ".xlsx");
    }

    @Test(dataProvider = "pay", priority = 7)
    public void pay(Map<String, String> map) {
        String response = user.pay(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "search")
    public Iterator<Object[]> search() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "商品搜索", ".xlsx");
    }

    @Test(dataProvider = "search", priority = 8)
    public void search(Map<String, String> map) {
        String response = user.search(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    @DataProvider(name = "loginout")
    public Iterator<Object[]> loginout() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/用户中心接口用例", "退出", ".xlsx");
    }

    @Test(dataProvider = "loginout",priority = 9)
    public void loginout(Map<String, String> map) {
        String response = user.loginout(map);
        System.out.println(response);
        if (response.length() != 0) {
            if (response.contains(map.get("断言"))) {
                assertion.assertEquals(map.get("实际结果"), map.get("预期结果"));
                report.log("测试通过");
            } else {
                report.warn("测试不通过");
            }
        } else {
            report.error("错误");
        }
    }

    public static void main(String[] args) {

    }
}
