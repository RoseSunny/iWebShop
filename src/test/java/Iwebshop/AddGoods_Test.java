package Iwebshop;

import Interfaces.SystemLogin;
import Utils.DataUtils;
import Utils.IteratorUtils;
import Utils.ReportUtils;
import org.jsoup.nodes.Document;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class AddGoods_Test {
    private static ReportUtils report=new ReportUtils();
    Assertion assertion=new Assertion();
    @DataProvider(name="addgoods")
    public Iterator<Object[]> addgoods() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/iwebshop","addgoods",".xlsx");
    }
    @Test(dataProvider = "addgoods")
    public void addgoods(Map<String,String> map){
        String response= SystemLogin.systemlogin(map);
        System.out.println(response);
        Document document=DataUtils.StringToHtml(response);
        if (response.length()!=0){
            if(document.title().equals(map.get("断言"))){
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
