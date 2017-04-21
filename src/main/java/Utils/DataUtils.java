package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by chongqing on 2017/4/13.
 */
public class DataUtils {
    private static Logger logger=Logger.getLogger(DataUtils.class);
    //String 转化为 JSONObject
    public static JSONObject StringToJson(String response){
        if(response==null||response==""){
            logger.error("传入的reponse为空");
            return null;
        }else {
            return JSON.parseObject(response);
        }
    }
    //根据path获取值
    private static String JsonParse(JSONObject jsonObject, String path){
        if (path==null&path==""){
            logger.error("传入的path为空，返回原来的jsonObject");
            return jsonObject.toString();
        }else {
            return JSONPath.eval(jsonObject,path).toString();
        }
    }
    //返回想要的结果
    public static String JsonParse(String response, String path){
        //调用StringToJson()和JsonParse()获得要取的值
        return JsonParse(StringToJson(response),path);
    }
    //字符串转化为Document
    public static Document StringToHtml(String response){
        if(response==null||response==""){
            logger.error("传入的response为空");
            return null;
        }else {
            return Jsoup.parse(response);
        }
    }
    //url转Document
    private static Document UrlToHtml(String url){
        if(url==null||url==""){
            logger.error("传入的response为空");
            return null;
        }else {
            return Jsoup.parse(url);
        }
    }
    //
    private static String HtmlParseText(Document document, String path){
        if (path==null||path==""){
            logger.error("传入的参数为空");
            return document.toString();
        }
        return document.select(path).text();
    }
    //
    private static String HtmlParseAttr(Document document, String path,String key){
        if (path==null||path==""){
            logger.error("传入的参数为空");
            return document.toString();
        }
        return document.select(path).attr(key);
    }
    //根据key=value来定位元素，再根据attr获取值
    public static String HtmlParse(String response, String key, String value, String attr){
        if (key==null||key==""||value==null||value==""||attr==null||attr==""){
            logger.error("传入的参数为空");
            return StringToHtml(response).toString();
        }else {
            return StringToHtml(response).getElementsByAttributeValue(key,value).attr(attr);
        }
    }
    //注意用绝对path定位，返回的只能有一个元素
    public static String HtmlParse(String response, String path, String ... key){
        if (key.length==0){
            return HtmlParseText(StringToHtml(response),path);
        }else {
            return HtmlParseAttr(StringToHtml(response),path,key[0]);
        }
    }
    public static void main(String[] args) {
//        String url="http://192.168.42.128/phpwind/";
//        Map map=new HashMap();
//        String response=kuangJia.get(url,map);
//
//        //response=HtmlParse(response,"name","csrf_token","value");
//        //response=HtmlParse(response,"a[role=button]","tabindex");
//        response=HtmlParse(response,"a[id=back_top]");
//        System.out.println(response);

    }

}
