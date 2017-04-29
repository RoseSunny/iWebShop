package Interfaces.Iwebshop.USER;

import InterfaceFramework.Iwebshop.RequestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lian on 2017-04-21.
 */
public class user {
    public static String open(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String login(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Post(map.get("接口地址"), map,"参数");
        return response;
    }

    public static String loginout(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String choosegoods(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String buy(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String shopping_cart(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String address(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }

    public static String submit(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Post(map.get("接口地址"),map,"参数");
        return response;
    }

    public static String pay(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Post(map.get("接口地址"),map,"参数");
        return response;
    }

    public static String search(Map<String, String> map) {
        String response = null;
        response = RequestUtils.Get(map.get("接口地址"));
        return response;
    }
}
