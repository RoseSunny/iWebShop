package Interfaces.Iwebshop.MyAccount;

import InterfaceFramework.Iwebshop.RequestUtils;

import java.util.Map;

/**
 * Created by Administrator on 2017-04-22.
 */
public class WebIndex {
    static public String webIndex(Map<String,String> map){
        String response;
        response= RequestUtils.Get(map.get("接口地址"),null);
        return response;
    }
}
