package Interfaces.Iwebshop;

import InterfaceFramework.Iwebshop.RequestUtils;
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

        response= InterfaceFramework.Iwebshop.RequestUtils.Get(map.get("接口地址"), RequestUtils.list(map));
        return response;
    }
}
