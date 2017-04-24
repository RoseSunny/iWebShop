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
public class PageSkip {
    //页面跳转
    static public String pageskip(){
        String response;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("controller","ucenter"));
        list.add(new BasicNameValuePair("action","index"));
        String url = RequestUtils.getUrl("http://localhost:82/iwebshop/index.php",list);
        response = RequestUtils.Get(url,null);
        return response;
    }
}
