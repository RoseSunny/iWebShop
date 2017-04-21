package InterfaceFramework.weixin;

import Utils.ReportUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by chongqing on 2017/4/13.
 * 框架底层
 */
public class RequestUtils {
    private static ReportUtils report=new ReportUtils();
    //private static Logger logger=Logger.getLogger(RequestUtils.class);
//    private static HttpClientBuilder builder = HttpClients.custom()
//            .disableAutomaticRetries()//关闭自动重定向
//            .setRedirectStrategy(new LaxRedirectStrategy());//利用LaxRedirectStrategy处理post重定向问题
//    private static CloseableHttpClient httpClient = builder.build();
    //private static CloseableHttpClient httpClient =HttpClients.createDefault();
    //组装uri
    private static URI getUri(String sheme, String host, String path, Map<String, String>... parameter) {
        URI uri=null;
        //建一个NameValuePair型的有序数组
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        if (parameter != null) {
            //把参数转换为一个迭代器
            Iterator<String> itr = parameter[0].keySet().iterator();
            //循环取值并转换为值对的形式
            while (itr.hasNext()) {
                //取key的值
                String key = itr.next();
                //取vlaue的值
                String vlaue = parameter[0].get(key);
                //转为值对形式
                NameValuePair nameValuePair = new BasicNameValuePair(key, vlaue);
                //添加到param中
                param.add(nameValuePair);
            }
            try {
                //组装有参数的uri
                uri = new URIBuilder()
                        .setScheme(sheme)
                        .setHost(host)
                        .setPath(path)
                        .addParameters(param)
                        .build();
                System.out.println("现在的uri:"+uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }else {
            try {
                //组装没有参数的uri
                uri = new URIBuilder()
                        .setScheme(sheme)
                        .setHost(host)
                        .setPath(path)
                        .build();
                System.out.println("现在的uri:"+uri);
                return uri;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return uri;
    }
    //传递Map类型的参数组装成url返回
    public static String getUrl(String url, Map<String, String>... parameter) {
        // List<NameValuePair> param = new ArrayList<NameValuePair>();
        report.log("组装url");
        //把参数转换为一个迭代器
        Iterator<String> itr = parameter[0].keySet().iterator();
        NameValuePair nameValuePair =null;
        String canshu="";
        //循环取值并转换为值对的形式
        while (itr.hasNext()) {
            String key = itr.next();
            String vlaue = parameter[0].get(key);
            nameValuePair = new BasicNameValuePair(key, vlaue);
            canshu=canshu+nameValuePair.toString();
            if (itr.hasNext()) {
                canshu = canshu + "&";
            }
        }
        url=url+"?"+canshu;
        return url;
    }
    /*

     */
    //判断是否有参数的get，并执行
    public static String get(String url,Map<String, String>... parameter){
        report.log("开始执行get请求");
        if(url==null){
            report.error("url为空，不执行请求");
            return null;
        }else if(url.contains(" ")){
            report.error("url有空格");
            return url.trim();
        }
        String stringresponse=null;
        if(parameter.length!=0){
            stringresponse=doGet(getUrl(url,parameter));
        }else {
            stringresponse=doGet(url);
        }
        return stringresponse;
    }
    //执行get请求
    private static String doGet(String url){
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        String stringresponse=null;
        try {
            report.log("现在的uri:"+url);
            response = httpClient.execute(httpGet);
            if(response!=null){
                stringresponse=toString(response);
            }else {
                report.error("response为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("stringresponse:"+stringresponse);
        return stringresponse;
    }
    //post上传JSONObject数据
    public static String post(String url,JSONObject jsonobject){
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost post=new HttpPost(url);
        CloseableHttpResponse response = null;
        String stringresponse=null;
        try {
            if(jsonobject!=null){
                StringEntity entity=new StringEntity(jsonobject.toString());
                post.setEntity(entity);
                try {
                    response=httpClient.execute(post);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stringresponse=toString(response);
            }
            doGet(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                response.close();
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;
    }
    //post上传list数据
    public static String Post(String uri,List<NameValuePair> list){
        CloseableHttpResponse response=null;
        String stringresponse=null;
        report.log("开始执行post请求");
        // 创建HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建httpPost
        HttpPost httpPost=new HttpPost(uri);
        report.log("同请求发送的"+list);
        //把要上传的参数转换成一个实体2
        UrlEncodedFormEntity postentity=new UrlEncodedFormEntity(list, Consts.UTF_8);
        //把实体添加到请求中
        httpPost.setEntity(postentity);
        try {
            report.log("执行请求的URI为：" + httpPost.getURI());
            // 执行post请求
            response = httpClient.execute(httpPost);
            stringresponse=toString(response);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             //关闭连接，释放资源
            try {
                response.close();
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.log("stringresponse"+stringresponse);
        return stringresponse;

    }
    //上传图片
    public static String post(String uri,String filepath){
        String stringresponse=null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        File file = new File(filepath);
        //上传文件
        //创建一个多媒体实体构建工具
        MultipartEntityBuilder multipart = MultipartEntityBuilder.create();
        //把文件以二进制的形式放入实体构建工具
        multipart.addBinaryBody("File",file);
        //通过构建工具构建实体
        HttpEntity entity = multipart.build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            stringresponse=toString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                response.close();
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.log("stringresponse"+stringresponse);
        return stringresponse;
    }
    //上传文件
    public static CloseableHttpResponse posttext(String uri,String pathname){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        File file = new File(pathname);
        FileEntity entity = new FileEntity(file, ContentType.create("text/plain", "UTF-8"));
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            if (response!=null){
                int status=response.getStatusLine().getStatusCode();
                if (status==200){
                    report.log("请求成功");
                    return response;
                } else {
                    report.error("请求失败");
                    return null;
                }
            }else {
                report.error("response为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                response.close();
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //响应转化为字符串
    private static String toString(CloseableHttpResponse response){
        CloseableHttpClient httpClient =HttpClients.createDefault();
        String stringresponse=null;
        try {
            if (response != null) {
                // 获取状态码
                int statuCode = response.getStatusLine().getStatusCode();
                // 若状态码不为200，则关闭response，若为200，则获取返回信息
                if (statuCode != 200) {
                    if(response.getEntity().getContentLength()==0){
                        report.error("返回实体内容为空");
                        return null;
                    }
                    report.error("访问失败，返回的状态码为：" + statuCode + response.getStatusLine());
                    response.close();
                } else {
                    // 将响应内容转化成string
                    HttpEntity httpEntity=response.getEntity();
                    stringresponse = EntityUtils.toString(httpEntity);
                }
            } else {
                report.error("response为空");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //打印jsonObject内容
        report.log("jsonObject"+stringresponse);
        return stringresponse;
    }
    public static String put(String url,Map<String,String>...parameter) {
        return null;
    }
    public static String doDelete(String uri){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(uri);
        CloseableHttpResponse response = null;
        String stringresponse=null;
        try {
            System.out.println("现在的uri:"+uri);
            response = httpClient.execute(delete);
            stringresponse=toString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                response.close();
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;
    }
    //傅宇飞的代码，实现list值对读取
    protected static List<NameValuePair> list(Map<String,String> map,String contains){
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        Set set = map.keySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            String key = itr.next().toString();
            String value = map.get(key);
            boolean contain = key.contains(contains);
            if (contain == true){
                String[] value1 = value.split("=");
                String listKey = value1[0];
                String listVlaue = value1[1];
                list.add(new BasicNameValuePair(listKey,listVlaue));
            }
        }
        return list;
    }
    //断言
    public static String Assertion(){
        String assertion="";
        return assertion;
    }
}
