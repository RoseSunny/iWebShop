package config;

import java.util.ResourceBundle;

/**
 * Created by chongqing on 2017/4/14.
 * 1、创建properties文件
 *      1、key=value
 *      2、value没有“”
 * 2、创建config.java文件
 *      1、定义静态常量接收properties文件中个的value值
 * 3、
 */
public class Config {
    private static ResourceBundle rb=ResourceBundle.getBundle("config");
    public final static String host_url=rb.getString("host.url");
    public final static int request_type=Integer.valueOf(rb.getString("request.type"));



}
