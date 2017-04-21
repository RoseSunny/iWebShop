package weixin;

import InterfaceFramework.weixin.RequestUtils;
import Utils.DataUtils;
import Utils.IteratorUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/16.
 */
public class Token {
    public static String gettoken(){
        String access_token=null;
        Map<String,String> map=new HashMap();
        map.put("grant_type","client_credential");
        map.put("appid","wx04ee7951e094124c");
        map.put("secret","758dd7de422ce5565148aa47f25a489a");
        String url="https://api.weixin.qq.com/cgi-bin/token";
        String response= RequestUtils.get(url,map);
        if (response.length()!=0){
            if(response.contains("access_token")){
                access_token= DataUtils.JsonParse(response,"$access_token");
                System.out.println("access_token为："+access_token);
            }else {
                System.out.println("出错");
            }
        }else {
            System.out.println("appid错误");
        }
        return access_token;
    }
}
