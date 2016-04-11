package com.hc.android.ottodemo.funcation.comment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Jam on 2016/4/1.
 */
public abstract class CommentAdapter<T> extends BaseAdapter {
    protected List<T> mDatas;
    protected Context mContext;
    private int mLayoutId;

    public CommentAdapter(List<T> mDatas, Context mContext, int mLayoutId) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getCount() {
        if (mDatas == null) {
            return 0;
        }
        return mDatas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(convertView, parent, mContext, mLayoutId, position);
        convert(holder, mDatas.get(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder helper, T t);
}
