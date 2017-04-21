package Interfaces.weixin;

import InterfaceFramework.weixin.RequestUtils;
import Utils.DataUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/15.
 */
public class Get_Token {
    public static  String gettoken(Map<String,String> map){
        String response=null;
        Map<String,String> map1=new HashMap<String, String>();
        map1.put("grant_type",map.get("参数grant_type"));
        map1.put("appid",map.get("参数appid"));
        map1.put("secret",map.get("参数secret"));
        response= RequestUtils.get(map.get("接口地址"),map1);
        return response;
    }



}
