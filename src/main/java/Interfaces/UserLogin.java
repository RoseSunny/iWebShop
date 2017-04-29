package Interfaces;

import InterfaceFramework.RequestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class UserLogin {
    public static  String userlogin(Map<String,String> map) throws IOException {
        String response=null;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller",map.get("controller")));
        list.add(new BasicNameValuePair("action",map.get("action")));
        String url = RequestUtils.getUrl(map.get("接口地址"),list);
        List<NameValuePair> list1=new ArrayList();
        list1.add(new BasicNameValuePair("login_info",map.get("参数:login_info")));
        list1.add(new BasicNameValuePair("password",map.get("参数:password")));
       // response = RequestUtils.Post1(url,list1);//RequestUtils.Post(url,map);
        return response;
    }

}
