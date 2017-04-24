package Interfaces.Iwebshop;

import InterfaceFramework.Iwebshop.RequestUtils;

import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class UserLogin {
    public static  String userlogin(Map<String,String> map){
        String response=null;
        response= InterfaceFramework.Iwebshop.RequestUtils.Get(map.get("接口地址"), RequestUtils.list(map));
        return response;
    }

}
