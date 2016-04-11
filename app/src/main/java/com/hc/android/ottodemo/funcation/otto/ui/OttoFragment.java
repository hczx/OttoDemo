package com.hc.android.ottodemo.funcation.otto.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hc.android.ottodemo.R;
import com.hc.android.ottodemo.funcation.otto.AppBus;
import com.hc.android.ottodemo.funcation.otto.model.BusEventModel;
import com.squareup.otto.Subscribe;

import baserobot.StarterFragment;

/**
 * Created by 99165 on 2016/3/30.
 */
public class OttoFragment extends Fragment {

    private EditText mContentET;

    public static OttoFragment getInstance() {
        OttoFragment fragment = new OttoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_otto, container, false);
        mContentET = (EditText) view.findViewById(R.id.content);
        return view;
    }

//    public void onMyScrollChange(ScrollEventData data){
//
//    }


    @Override
    public void onStart() {
        super.onStart();
        //注册到bus时间总线中
        AppBus.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        AppBus.getInstance().unregister(this);
    }

    /**
     * 定义订阅者，Activity发布的消息，在此处会接收到，在此之前需要现在程序中register,
     * onStrart  和 onStop 函数
     */

    @Subscribe
    public void setContent(BusEventModel data) {
        mContentET.setText(data.getContent());
    }

    @Subscribe
    public void onDataChange(String str) {
        System.out.println("========================" + str);
    }
}
