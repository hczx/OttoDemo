package universaladapter.easyrecycler.debouncedlisteners;

import android.view.View;

import universaladapter.easyrecycler.EasyViewHolder;

/**
 * Created by Jam on 2016/3/14.
 */
public abstract class DebouncedOnLongClickListener implements DebouncedListener, EasyViewHolder.OnItemLongClickListener {
    private final DebouncedClickHandler debouncedClickHandler;

    protected DebouncedOnLongClickListener(){
        this.debouncedClickHandler = new DebouncedClickHandler(this);
    }

    @Override
    public boolean onLongItemClicked(int position, View view) {
        return debouncedClickHandler.invokeDebouncedClick(position,view);
    }
}
