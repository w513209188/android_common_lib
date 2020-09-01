package com.example.lib_common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.mmkv.MMKV;
import com.wb.lib_image_loadcal.ImageManager;
import com.wb.lib_utils.AppConfig;

import me.jessyan.autosize.AutoSizeConfig;
/**
 * debug包下的代码不参与编译，仅作为独立模块运行时初始化数据
 */

public class DebugApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化阿里路由框架
        if (AppConfig.getInstance().isDebug()) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);

        MMKV.initialize(this);

        ImageManager.getInstance().init(this.getApplicationContext());
        // 布局
        AutoSizeConfig.getInstance()
                //按照宽度适配 默认true
                .setBaseOnWidth(true)
                //是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
                //如果没有这个需求建议不开启
                .setCustomFragment(true);
        // 侧滑监听
        AppConfig.getInstance().getApp().registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
