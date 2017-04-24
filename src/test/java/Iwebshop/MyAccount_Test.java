package Iwebshop;

import InterfaceFramework.Iwebshop.RequestUtils;
import Interfaces.Iwebshop.MyAccount.*;
import Interfaces.Iwebshop.UserLogin;
import Utils.IteratorUtils;
import Utils.ReportUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/20.
 */
public class MyAccount_Test {
    private static ReportUtils report=new ReportUtils();
    Assertion assertion=new Assertion();
    //打开首页
    @DataProvider(name = "Index")
    public Iterator<Object[]> getData1() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","首页",".xlsx");
    }
    @Test(dataProvider = "Index",priority = 0)
    public void Index(Map<String,String> map){
        String response= WebIndex.webIndex(map);
        //System.out.println(response);
        if (response.length()!=0){
            if(response.contains(map.get("断言"))){
                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
                report.log("测试通过");
                System.out.println("测试通过");
            }else {
                report.warn("测试不通过");
                System.out.println("测试不通过");
            }
        }else {
            report.error("错误");
        }
    }
    //进入登陆

    //登录
    @DataProvider(name = "login")
    public Iterator<Object[]> getData2() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","登录",".xlsx");
    }
    @Test(priority = 1,dataProvider = "login")
    public void Login(Map<String,String> map) throws IOException {
        String response = UserLogin.userlogin(map);
        if (response.length() == 0){
            report.log("测试通过");
            System.out.println("测试通过");
            String response1 = PageSkip.pageskip();
            System.out.println(response1);
        }else {
            System.out.println("测试不通过");
        }
    }

//    //页面跳转
//    @DataProvider(name = "pageskip")
//    public Iterator<Object[]> getData3() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","跳转页面",".xlsx");
//    }
//    @Test(priority = 2,dataProvider = "pageskip")
//    public void pageSkip(Map<String,String> map) throws IOException {
//        String response= PageSkip.pageskip(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//            }else {
//                report.warn("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }

//    //我的订单
//    @DataProvider(name = "myorder")
//    public Iterator<Object[]> getData4() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","我的订单",".xlsx");
//    }
//    @Test(priority = 2,dataProvider = "myorder")
//    public void myorder(Map<String,String> map) throws IOException {
//        String response= MyOrder.myOrder(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//            }else {
//                report.warn("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //我的积分
//    @DataProvider(name = "myintegral")
//    public Iterator<Object[]> getData5() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","我的积分",".xlsx");
//    }
//    @Test(priority = 3,dataProvider = "myintegral")
//    public void myintegral(Map<String,String> map) throws IOException {
//        String response= MyIntegral.myInteral(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //我的代金券
//    @DataProvider(name = "myvoucher")
//    public Iterator<Object[]> getData6() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","我的代金券",".xlsx");
//    }
//    @Test(priority = 4,dataProvider = "myvoucher")
//    public void myvoucher(Map<String,String> map) throws IOException {
//        String response= MyVoucher.myVouchar(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //退款申请
//    @DataProvider(name = "refund")
//    public Iterator<Object[]> getData7() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","退款申请",".xlsx");
//    }
//    @Test(priority = 5,dataProvider = "refund")
//    public void refund(Map<String,String> map) throws IOException {
//        String response=Refund.refund1(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //我的余额
//    @DataProvider(name = "money")
//    public Iterator<Object[]> getData8() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","我的余额",".xlsx");
//    }
//    @Test(priority = 6,dataProvider = "money")
//    public void money(Map<String,String> map) throws IOException {
//        String response=MyMoney.myMoney(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //地址管理
//    @DataProvider(name = "address")
//    public Iterator<Object[]> getData9() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","地址管理",".xlsx");
//    }
//    @Test(priority = 7,dataProvider = "address")
//    public void address(Map<String,String> map) throws IOException {
//        String response=MyAddress.Address(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
//
//    //新增地址
//    @DataProvider(name = "address1")
//    public Iterator<Object[]> getData10() throws IOException {
//        return new IteratorUtils("TestData/Iwebshop/我的账户接口用例","新增地址",".xlsx");
//    }
//    @Test(priority = 8,dataProvider = "address1")
//    public void address1(Map<String,String> map) throws IOException {
//        String response=Add_Address.add_address(map);
//        System.out.println(response);
//        if (response.length() != 0){
//            if(response.contains(map.get("断言"))){
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                report.log("测试通过");
//                System.out.println("测试通过");
//            }else {
//                report.warn("测试不通过");
//                System.out.println("测试不通过");
//            }
//        }else {
//            report.error("错误");
//        }
//    }
}
