package com.wb.lib_arch.common;
import android.graphics.Color;

import com.wb.lib_arch.R;
import com.wb.lib_arch.annotations.BarStyle;
import com.wb.lib_arch.annotations.SwipeStyle;
import com.wb.lib_utils.AppConfig;
import java.io.Serializable;
public class ArchConfig implements Serializable {
    public static final String FRAGMENT = "FRAGMENT";
    public static final String BUNDLE = "BUNDLE";
    public static final String REQUEST_CODE = "REQUEST_CODE";
    public static final String MSG_EVENT = "MSG_EVENT";
    /**
     * 登录code
     */
    public static final int NEED_LOGIN_CODE = -100;
    /**
     * 侧滑
     */
    public static int swipeBack = SwipeStyle.EDGE;
    /**
     * 状态栏透明
     */
    public static boolean statusBarTranslucent = true;
    /**
     * 给系统窗口留出空间
     */
    public static boolean fitsSystemWindows = false;
    /**
     * 状态栏文字颜色
     */
    public static int statusBarStyle = BarStyle.DARK_CONTENT;
    /**
     * 状态栏颜色
     */
    public static int statusBarColor = AppConfig.getInstance().getContext().getResources().getColor(R.color.statusBar);
    /**
     * 如果状态栏处于白色且状态栏文字也处于白色，避免看不见
     */
    public static int shouldAdjustForWhiteStatusBar = Color.parseColor("#4A4A4A");
    /**
     * 虚拟键背景颜色
     */
    public static int navigationBarColor = Color.TRANSPARENT;
    /**
     * 虚拟键颜色
     */
    public static int navigationBarStyle = BarStyle.DARK_CONTENT;
    /**
     * 登录状态
     */
    public static boolean needLogin = false;
}
