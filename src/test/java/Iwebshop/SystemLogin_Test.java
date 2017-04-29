package Iwebshop;

import Interfaces.SystemLogin;
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
public class SystemLogin_Test {
    private static ReportUtils report=new ReportUtils();
    Assertion assertion=new Assertion();
    @DataProvider(name="systemlogin")
    public Iterator<Object[]> systemlogin() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/iwebshop","systemlogin",".xlsx");
    }
    @Test(dataProvider = "systemlogin")
    public void systemlogin(Map<String,String> map){
        String response= SystemLogin.systemlogin(map);
        System.out.println(response);
        if (response.length()!=0){
            if(response.contains(map.get("断言"))){
                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
                report.log("测试通过");
            }else {
                report.warn("测试不通过");
            }
        }else {
            report.error("错误");
        }
    }
}
