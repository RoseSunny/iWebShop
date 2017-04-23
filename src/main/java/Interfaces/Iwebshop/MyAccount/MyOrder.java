package Interfaces.Iwebshop.MyAccount;

import InterfaceFramework.Iwebshop.RequestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-22.
 */
public class MyOrder {
    static public String myOrder(Map<String,String> map){
        String response;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller",map.get("参数:controller")));
        list.add(new BasicNameValuePair("action",map.get("参数:action")));
        response= RequestUtils.getUrl(map.get("接口地址"),list);
        return response;
    }
}
