package com.wb.lib_arch.delegate;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.wb.lib_utils.interfaces.ILifecycle;

/**
 * @author yyx
 */
public interface IFragmentDelegate extends ILifecycle {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onAttached(Context context);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreated(Bundle savedInstanceState);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onViewCreated(View view, Bundle savedInstanceState);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onActivityCreated(Bundle savedInstanceState);

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStarted();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResumed();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPaused();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStopped();

    void onSaveInstanceState(Bundle outState);

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onViewDestroyed();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroyed();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDetached();

    boolean isAdd();

}
