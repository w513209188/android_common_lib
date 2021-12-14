package com.wb.lib_arch.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.wb.lib_arch.annotations.SwipeStyle;
import com.wb.lib_arch.delegate.ActivityDelegate;
import com.wb.lib_arch.utils.AppManager;

/**
 * Activity 需实现
 *
 * @author wb
 */
public interface IActivity extends IView {

    /**
     * Activity代理
     *
     * @return ActivityDelegate
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    default ActivityDelegate getBaseDelegate() {
        return AppManager.getInstance().getActivityDelegate(this, hashCode());
    }

    /**
     * 初始化窗口
     */
    default void initWindows() {
    }

    /**
     * 侧滑返回
     *
     * @param mSwipeBack 是否返回 {@link SwipeStyle}
     */
    default void setSwipeBack(@SwipeStyle int mSwipeBack) {
    }

}
