package InterfaceFramework;

import Utils.ReportUtils;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by chongqing on 2017/4/13.
 * 框架底层
 */
public class RequestUtils {
    private static ReportUtils report=new ReportUtils();
    private static HttpClientBuilder builder = HttpClients.custom()
            .disableAutomaticRetries()//关闭自动重定向
            .setRedirectStrategy(new LaxRedirectStrategy());
    //利用LaxRedirectStrategy处理post重定向问题
    private static CloseableHttpClient httpClient = builder.build();

    //对excel中获取的表头进行匹配，并将符合的数据放入list
    public static List<NameValuePair> list(Map<String,String> map,String values){
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        Set set = map.keySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            String key = itr.next().toString();
            String value = map.get(key);
            boolean contain = key.contains(values);
            if (contain == true){
                String[] key1 = key.split(":");
                String listKey = key1[1];
                list.add(new BasicNameValuePair(listKey,value));
            }
        }
        return list;
    }

    //private static CloseableHttpClient httpClient =HttpClients.createDefault();
    //传递Map类型的参数组装成url返回
    public static String getUrl(String url, List<NameValuePair>... parameter) {
        report.log("组装url");
        url = url + "?";
        for(int i=0;i<parameter[0].size();i++){
            url = url + parameter[0].get(i);
            if(i<(parameter[0].size()-1)){
                url = url + "&";
            }
        }
        report.log(url);
        return url;
    }

    //判断是否有参数的get，并执行
    public static String Get(String url, List<NameValuePair>... parameter){
        report.log("开始执行get请求");
        String stringresponse=null;
        if(url==null){
            report.error("url为空，不执行请求");
            return null;
        } else {
            if(parameter.length!=0){
                stringresponse=doGet(getUrl(url,parameter));
            }else {
                stringresponse=doGet(url);
                return stringresponse;
            }
        }
        return stringresponse;
    }

    //执行get请求
    public static String doGet(String url){
        //CloseableHttpClient httpClient =HttpClients.createDefault();
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
    public static String Post(String url,String jsonobject){
        //CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost post=new HttpPost(url);
        CloseableHttpResponse response = null;
        String stringresponse=null;
        try {
            if(jsonobject!=null){
                StringEntity entity=new StringEntity(jsonobject);
                post.setEntity(entity);
                try {
                    response=httpClient.execute(post);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stringresponse=toString(response);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;
    }

    //post上传list数据
    public static String Post(String uri,Map<String,String> map,String values){
        CloseableHttpResponse response=null;
        String stringresponse=null;
        report.log("开始执行post请求");
        //CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建HttpClient实例
        HttpPost httpPost=new HttpPost(uri); // 创建httpPost
        report.log("同请求发送的"+list(map,values));
        UrlEncodedFormEntity postentity=new UrlEncodedFormEntity(list(map,values), Consts.UTF_8);//把要上传的参数转换成一个实体
        httpPost.setEntity(postentity);//把实体添加到请求中
        try {
            report.log("执行请求的URI为：" + httpPost.getURI());
            response = httpClient.execute(httpPost); // 执行post请求
            stringresponse=toString(response);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                //httpClient.close();//关闭连接，释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;

    }

    //组合post发送图片时的实体
    protected static HttpEntity entityTP(String pathname){
        File file = new File(pathname);
        MultipartEntityBuilder multipart = MultipartEntityBuilder.create();//entity构建工具
        multipart.addBinaryBody("media",file);
        HttpEntity entity = multipart.build();
        return entity;
    }

    //post方法发送多媒体文件：请求-->响应
    public static String PostTP(String url,String pathname){
        CloseableHttpResponse response = null;
        String stringResponse = null;
        HttpPost httpPost = new HttpPost(url);
        File file = new File(pathname);
        MultipartEntityBuilder multipart = MultipartEntityBuilder.create();//entity构建工具
        multipart.addBinaryBody("media",file);
        HttpEntity entity = multipart.build();
        httpPost.setEntity(entity);
        try {
            response = httpClient.execute(httpPost);
            stringResponse = toString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringResponse;
    }

    public static String postTP(String url, String pathname, List<NameValuePair> ... parameter){
        report.log("发送httpPost请求");
        String stringResponse = null;
        if(url != null) {
            if (parameter != null) {
                url = getUrl(url,parameter[0]);
                stringResponse = PostTP(url,pathname);
            }else {
                stringResponse = PostTP(url,pathname);
            }
        }else {
            report.error("url为空，无法执行请求");
        }
        return stringResponse;
    }

    //上传媒体文件post请求
    static public String Post(String url, File file,List<NameValuePair> ...parameter) {
        //CloseableHttpClient httpClient = HttpClients.createDefault();//定义一个httpclient
        String response1 = null;//定义一个字符串类型响应消息
        CloseableHttpResponse response = null;//定义一个响应消息
        //声明多媒体文件构建工具
        MultipartEntityBuilder entityBuilder=MultipartEntityBuilder.create();
        //将需要上传的文件放入构建工具
        entityBuilder.addBinaryBody("media",file);
        HttpPost post = new HttpPost(url);//定义请求的方法
        //构建多媒体文件entityBuilder.build()并将其放入post方法中
        post.setEntity(entityBuilder.build());
        try {
            response = httpClient.execute(post);//执行post请求
            response1 = toString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response1;
    }

    //响应转化为字符串
    private static String toString(CloseableHttpResponse response){
        //CloseableHttpClient httpClient =HttpClients.createDefault();
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
                //httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //打印jsonObject内容
        report.log("jsonObject"+stringresponse);
        return stringresponse;
    }
    //Put方法
    public static String Put(String url,List<NameValuePair> list) {
        report.log("开始put方法");
        //CloseableHttpClient httpClient = HttpClients.createDefault();
        String stringresponse = null;
        CloseableHttpResponse response = null;
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);//吧值对转换成实体
            HttpPost post = new HttpPost(url);
            post.setEntity(entity);
            response = httpClient.execute(post);
            stringresponse =toString(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;
    }
    //Delete
    public static String Delete(String uri){
        //CloseableHttpClient httpClient = HttpClients.createDefault();
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
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringresponse;
    }
}
