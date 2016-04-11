package com.hc.android.ottodemo;

import android.accounts.Account;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;

import baserobot.BaseActivity;
import baserobot.BaseApplication;
import butterknife.ButterKnife;
import network.retrofit.RetrofitBuilder;

/**
 * Created by 99165 on 2016/3/30.
 */
public class MyApp extends BaseApplication {


    @Override
    public Account accountFromJson(String json) {
        return null;
    }
}
