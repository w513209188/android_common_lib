package com.example.lib_common.arouter;


import com.alibaba.android.arouter.launcher.ARouter;
import com.wb.lib_arch.base.IFragment;
/**
 * ARouter路由跳转工具类
 */
public class ARouterUtils {

    /**
     *  获取fragment
     */
    public static IFragment navFragment(String path) {
        return (IFragment) ARouter.getInstance().build(path).navigation();
    }

    public static void navActivity(String path) {
        ARouter.getInstance().build(path).navigation();
    }


    public static void startFragment(Class aClass){

    }
}
