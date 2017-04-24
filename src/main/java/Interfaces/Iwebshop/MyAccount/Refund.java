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
public class Refund {
    //退款申请
    static public String refund1(Map<String,String> map){
        String response;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller",map.get("controller")));
        list.add(new BasicNameValuePair("action",map.get("参数:action")));
        response = RequestUtils.Get(map.get("接口地址"),list);
        return response;
    }
}
