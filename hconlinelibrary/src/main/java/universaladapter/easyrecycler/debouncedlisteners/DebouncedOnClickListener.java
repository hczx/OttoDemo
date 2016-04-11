package universaladapter.easyrecycler.debouncedlisteners;

import android.view.View;

import universaladapter.easyrecycler.EasyViewHolder;

/**
 * Created by Jam on 2016/3/14.
 * 去除抖动 的监听事件
 */
public abstract class DebouncedOnClickListener implements EasyViewHolder.OnItemClickListener,DebouncedListener{
    private final DebouncedClickHandler debouncedClickHandler;
    protected DebouncedOnClickListener(){
        this.debouncedClickHandler = new DebouncedClickHandler(this);
    }

    @Override
    public void onItemClick(int position, View view) {
        debouncedClickHandler.invokeDebouncedClick(position,view);
    }
}
