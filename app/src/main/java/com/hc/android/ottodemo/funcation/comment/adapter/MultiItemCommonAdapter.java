package com.hc.android.ottodemo.funcation.comment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 99165 on 2016/4/6.
 */
public abstract class MultiItemCommonAdapter<T> extends CommentAdapter<T> {

    protected MultiItemTypeSupport<T> multiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(datas, context, -1);
        this.multiItemTypeSupport = multiItemTypeSupport;
    }


    @Override
    public int getItemViewType(int position) {
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        if (multiItemTypeSupport != null)
            return multiItemTypeSupport.getViewTypeCount();
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (multiItemTypeSupport == null)
            return super.getView(position, convertView, parent);
        int layoutId = multiItemTypeSupport.getLayoutId(position, mDatas.get(position));
        ViewHolder holder = ViewHolder.get(convertView, parent, mContext, layoutId, position);
        convert(holder, mDatas.get(position));
        return holder.getConvertView();
    }
}
