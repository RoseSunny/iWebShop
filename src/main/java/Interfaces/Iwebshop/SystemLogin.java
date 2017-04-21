package Interfaces.Iwebshop;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class SystemLogin {
    public static  String systemlogin(Map<String,String> map){
        String response=null;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller",map.get("参数controller")));
        list.add(new BasicNameValuePair("action",map.get("参数action")));
        list.add(new BasicNameValuePair("admin_name",map.get("参数admin_name")));
        list.add(new BasicNameValuePair("password",map.get("参数password")));
        list.add(new BasicNameValuePair("captcha",map.get("参数captcha")));

        response= InterfaceFramework.Iwebshop.RequestUtils.Get(map.get("接口地址"),list);
        return response;
    }
}
