package Iwebshop;

import Interfaces.USER.user;
import UILogic.GoodsManager;
import Utils.IteratorUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chongqing on 2017/4/29.
 */
public class UIManager_Test {
    @DataProvider(name = "login")
    public Iterator<Object[]> login() throws IOException {
        return new IteratorUtils("TestData/Iwebshop/UI自动化", "login", ".xlsx");
    }

    @Test(dataProvider = "login", priority = 0)
    public void login(Map<String, String> map) {
        GoodsManager.Login(map);
        //System.out.println();
    }
}
