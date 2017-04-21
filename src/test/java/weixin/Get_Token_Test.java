package weixin;


import Interfaces.Iwebshop.Get_Token;
import Utils.DataUtils;
import Utils.IteratorUtils;
import Utils.ReportUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/14.
 */
public class Get_Token_Test {
    private static ReportUtils report=new ReportUtils();
    Assertion assertion=new Assertion();
    @DataProvider(name="gettoken")
    public Iterator<Object[]> getDate() throws IOException {
        return new IteratorUtils("TestData/weixin/weixin","get_token",".xls");
    }
    @Test(dataProvider = "gettoken")
    public void gettoken(Map<String,String> map){
        String response=Get_Token.gettoken(map);
        if (response.length()!=0){
            if(response.contains(map.get("断言"))){
                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
                report.log("测试通过");
                String access_token= DataUtils.JsonParse(response,"$access_token");
                System.out.println("access_token为："+access_token);
            }else {
                report.warn("测试不通过");
            }
        }else {
            report.error("appid错误");
        }
    }
}
