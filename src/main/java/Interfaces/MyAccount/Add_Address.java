package Interfaces.MyAccount;

import InterfaceFramework.RequestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-22.
 */
public class Add_Address {
    //新增地址
    static public String add_address(Map<String,String> map){
        String response;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller",map.get("controller")));
        list.add(new BasicNameValuePair("action",map.get("参数:action")));
        list.add(new BasicNameValuePair("id",map.get("参数:id")));
        //组装url
        String url = RequestUtils.getUrl(map.get("接口地址"),list);
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("accept_name",map.get("参数：accept_name"));
        map1.put("province",map.get("参数:province"));
        map1.put("city",map.get("参数:city"));
        map1.put("area",map.get("参数:area"));
        map1.put("address",map.get("参数：address"));
        map1.put("mobile",map.get("参数:mobile"));
        map1.put("telphone",map.get("参数:telphone"));
        map1.put("zip",map.get("参数:zip"));
        response = RequestUtils.Post(url,map1,"参数");
        return response;
    }
}
