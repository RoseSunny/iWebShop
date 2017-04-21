package Interfaces.Iwebshop;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class UserLogin {
    public static  String userlogin(Map<String,String> map){
        String response=null;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("grant_type",map.get("参数grant_type")));
        list.add(new BasicNameValuePair("appid",map.get("参数appid")));
        list.add(new BasicNameValuePair("secret",map.get("参数secret")));

        response= InterfaceFramework.Iwebshop.RequestUtils.Get(map.get("接口地址"),list);
        return response;
    }

}
