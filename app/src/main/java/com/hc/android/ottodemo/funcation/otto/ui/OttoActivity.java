package com.hc.android.ottodemo.funcation.otto.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.hc.android.ottodemo.R;
import com.hc.android.ottodemo.funcation.otto.AppBus;
import com.hc.android.ottodemo.funcation.otto.model.BusEventModel;

import baserobot.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 99165 on 2016/3/30.
 */
public class OttoActivity extends BaseActivity {


    @Bind(R.id.otto_content)
    FrameLayout ottoContent;
    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;
    @Bind(R.id.back)
    FloatingActionButton back;
    @Bind(R.id.send)
    FloatingActionButton send;
    @Bind(R.id.send2)
    FloatingActionButton send2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto);
        initView();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().add(R.id.otto_content, new OttoFragment()).commit();
    }

    @OnClick({R.id.back, R.id.send, R.id.send2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                ActivityCompat.finishAffinity(this);
                break;
            case R.id.send:
                AppBus.getInstance().post(new BusEventModel("somebody alive"));
                break;
            case R.id.send2:
                AppBus.getInstance().post("hello");
                break;
        }
    }

}
