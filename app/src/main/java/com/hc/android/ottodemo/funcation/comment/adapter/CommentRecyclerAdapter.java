package com.hc.android.ottodemo.funcation.comment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Jam on 2016/4/1.
 */
public abstract class CommentRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    protected List<T> mDatas;
    protected Context mContext;
    private int mLayoutId;

    public CommentRecyclerAdapter(List<T> mDatas, Context mContext, int mLayoutId) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RecyclerViewHolder.get(mContext, parent, mLayoutId, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setmPosition(position);
        convert(holder, mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void convert(RecyclerViewHolder holder, T t);
}
