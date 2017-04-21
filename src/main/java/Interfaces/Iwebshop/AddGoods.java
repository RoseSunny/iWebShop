package Interfaces.Iwebshop;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class AddGoods {
    public static  String addgoods(Map<String,String> map){
        String response=null;
        List<NameValuePair> list=new ArrayList();
        list.add(new BasicNameValuePair("id",map.get("参数id")));
        list.add(new BasicNameValuePair("img",map.get("参数img")));
        list.add(new BasicNameValuePair("_imgList",map.get("参数_imgList")));
        list.add(new BasicNameValuePair("callback",map.get("参数callback")));
        list.add(new BasicNameValuePair("name",map.get("参数name")));
        list.add(new BasicNameValuePair("search_words",map.get("参数search_words")));
        list.add(new BasicNameValuePair("seller_id",map.get("参数seller_id")));
        list.add(new BasicNameValuePair("_goods_category",map.get("参数_goods_category[]")));
        list.add(new BasicNameValuePair("is_del",map.get("参数is_del")));
        list.add(new BasicNameValuePair("is_share",map.get("参数is_share")));
        list.add(new BasicNameValuePair("is_delivery_fee",map.get("参数is_delivery_fee")));
        list.add(new BasicNameValuePair("point",map.get("参数point")));
        list.add(new BasicNameValuePair("sort",map.get("参数sort")));
        list.add(new BasicNameValuePair("unit",map.get("参数unit")));
        list.add(new BasicNameValuePair("exp",map.get("参数exp")));
        list.add(new BasicNameValuePair("_goods_no[0]",map.get("参数_goods_no[0]")));
        list.add(new BasicNameValuePair("_store_nums[0]",map.get("参数_store_nums[0]")));
        list.add(new BasicNameValuePair("_market_price[0]point",map.get("参数_market_price[0]point")));
        list.add(new BasicNameValuePair("_groupPrice[0]",map.get("参数_groupPrice[0]")));
        list.add(new BasicNameValuePair("_sell_price[0]",map.get("参数_sell_price[0]")));
        list.add(new BasicNameValuePair("_cost_price[0]",map.get("参数_cost_price[0]")));
        list.add(new BasicNameValuePair("_weight[0]",map.get("参数_weight[0]")));
        list.add(new BasicNameValuePair("model_id",map.get("参数model_id")));
        list.add(new BasicNameValuePair("_goods_commend[]",map.get("参数_goods_commend[]")));
        list.add(new BasicNameValuePair("brand_id",map.get("参数brand_id")));
        list.add(new BasicNameValuePair("content",map.get("参数content")));
        list.add(new BasicNameValuePair("keywords",map.get("参数keywords")));
        list.add(new BasicNameValuePair("description",map.get("参数description")));

        response= InterfaceFramework.Iwebshop.RequestUtils.Post(map.get("接口地址"),list);
        return response;
    }
}
