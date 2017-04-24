package config;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017-04-23.
 */
public class Selenium {
    private static ResourceBundle rb=ResourceBundle.getBundle("selenium");
    public final static int driverType=Integer.valueOf(rb.getString("driver.Type"));
}
