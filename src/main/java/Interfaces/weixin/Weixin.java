package Interfaces.weixin;

import Utils.DataUtils;
import Utils.IteratorUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/17.
 */
public class Weixin {
    String response=null;
    String access_token=null;
    String openid = null;
    private static Logger logger=Logger.getLogger(Weixin.class);
    @DataProvider(name="gettoken")
    public Iterator<Object[]> gettoken() throws IOException {
        return new IteratorUtils("TestData/weixin/weixin","get_token",".xls");
    }
    @Test(dataProvider = "gettoken")
    public void WeiXin_Token_Assections(Map<String,String> map){
        String errcode = null;
        response=Get_Token.gettoken(map);
        if(response.contains("access_token")){
            access_token = DataUtils.JsonParse(response,"$.access_token");
            try {
                assert (access_token != null);
            }catch(AssertionError error){
                logger.error(error);
            }
        }else{
            try {
                assert (errcode == map.get("预期结果"));
            }catch(AssertionError error){
                logger.error(error);
            }
        }
    }
}
