package com.hc.android.ottodemo.funcation.comment.adapter;

/**
 * Created by 99165 on 2016/4/6.
 */
public interface MultiItemTypeSupport<T> {

    int getLayoutId(int position, T t);

    int getViewTypeCount();

    int getItemViewType(int position, T t);
}
