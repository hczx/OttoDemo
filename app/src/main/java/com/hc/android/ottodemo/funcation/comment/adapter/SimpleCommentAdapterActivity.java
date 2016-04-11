package com.hc.android.ottodemo.funcation.comment.adapter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.hc.android.ottodemo.R;

import java.util.ArrayList;
import java.util.List;

import baserobot.BaseActivity;
import butterknife.Bind;
import universaladapter.*;
import universaladapter.ViewHolder;
import widget.UriUtils;

/**
 * Created by 99165 on 2016/4/1.
 */
public class SimpleCommentAdapterActivity extends BaseActivity {


    @Bind(R.id.simple_recyclerview)
    RecyclerView mRecyclerview;
    @Bind(R.id.simple_listview)
    ListView mListview;

    private List<String> strings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_adapter);
        strings = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            strings.add("Model" + i);
        }

        listViewCommentAdapter();
        recyclerViewCommonAdapter();
    }

    private void recyclerViewCommonAdapter() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerview.setAdapter(new CommentRecyclerAdapter<String>(strings, context, R.layout.item_model) {
            @Override
            public void convert(RecyclerViewHolder holder, String s) {
                holder.setText(R.id.item_text, s);
            }
        });
    }

    private void listViewCommentAdapter() {
        mListview.setAdapter(new CommonAdapter<String>(context, strings, R.layout.item_model) {
            @Override
            public void conver(ViewHolder helper, String item) {
                helper.setText(R.id.item_text, item);
            }
        });
    }
}
