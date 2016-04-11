package com.hc.android.ottodemo.funcation.otto;


import com.squareup.otto.Bus;

/**
 * Created by Jam on 2016/3/30.
 * 通过单例模式创建Bus
 */
public class AppBus extends Bus {

    private static AppBus bus;

    public static AppBus getInstance() {
        if (bus == null) synchronized (AppBus.class) {
            bus = new AppBus();
        }
        return bus;
    }
}
