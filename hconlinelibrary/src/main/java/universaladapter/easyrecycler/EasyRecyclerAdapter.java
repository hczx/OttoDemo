package universaladapter.easyrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.carlosdelachica.easyrecycleradapters.adapter.debouncedlisteners.DebouncedOnClickListener;

import java.util.ArrayList;
import java.util.List;

import universaladapter.easyrecycler.debouncedlisteners.DebouncedOnLongClickListener;

/**
 * Created by 99165 on 2016/3/14.
 */
public abstract class EasyRecyclerAdapter extends RecyclerView.Adapter<EasyViewHolder> {
    private List<Object> dataList = new ArrayList<>();
    private BaseEasyViewHolderFactory viewHolderFactory;
    private EasyViewHolder.OnItemClickListener itemClickListener;
    private EasyViewHolder.OnItemLongClickListener longClickListener;


    public EasyRecyclerAdapter(Context context, Class valueClass, Class<? extends EasyViewHolder> easyViewHolderClass) {
        this(context);
        bind(valueClass, easyViewHolderClass);
    }

    public EasyRecyclerAdapter(Context context) {
        this(new BaseEasyViewHolderFactory(context));
    }

    public EasyRecyclerAdapter(BaseEasyViewHolderFactory easyViewHolderFactory, Class valueClass, Class<? extends EasyViewHolder> easyViewHolderClass) {
        this(easyViewHolderFactory);
        bind(valueClass, easyViewHolderClass);
    }

    public EasyRecyclerAdapter(BaseEasyViewHolderFactory easyViewHolderFactory) {
        this.viewHolderFactory = easyViewHolderFactory;
    }

    public void bind(Class valueClass, Class<? extends EasyViewHolder> viewHolder) {
        viewHolderFactory.bind(valueClass, viewHolder);
    }

    public void viewHolderFactory(BaseEasyViewHolderFactory easyViewHolderFactory) {
        this.viewHolderFactory = easyViewHolderFactory;
    }

    @Override
    public EasyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EasyViewHolder easyViewHolder = viewHolderFactory.create(viewType, parent);
        bindListeners(easyViewHolder);
        return null;
    }

    private void bindListeners(EasyViewHolder easyViewHolder) {
        if (easyViewHolder != null) {
            easyViewHolder.setItemClickListener(itemClickListener);
            easyViewHolder.setLongClickListener(longClickListener);
        }
    }

    @Override
    public void onBindViewHolder(EasyViewHolder holder, int position) {
        holder.bindTo(dataList.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return viewHolderFactory.itemViewType(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void add(Object object, int position) {
        dataList.add(position, object);
        notifyItemInserted(position);
    }

    public void add(Object object) {
        dataList.add(object);
        notifyItemInserted(getIndex(object));
    }

    public int getIndex(Object item) {
        return dataList.indexOf(item);
    }

    public void addAll(List<?> objects) {
        dataList.clear();
    }

    public void appendAll(List<?> objects) {
        if (objects == null) {
            throw new IllegalArgumentException("objects can not be null");
        }
        dataList.addAll(objects);
        notifyDataSetChanged();
    }

    public boolean upDate(Object data, int position) {
        Object oldData = dataList.set(position, data);
        if (oldData != null) {
            notifyItemChanged(position);
        }
        return oldData != null;
    }

    public boolean remove(Object data) {
        if (dataList.contains(data)) {
            return remove(getIndex(data));
        }
        return false;
    }

    public boolean remove(int position) {
        boolean validIndex = isValidIndex(position);
        if (validIndex) {
            dataList.remove(position);
            notifyItemChanged(position);
        }
        return validIndex;
    }

    public void clear() {
        dataList.clear();
        notifyDataSetChanged();
    }

    public Object get(int position) {
        return dataList.get(position);
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void setOnClickLister(final EasyViewHolder.OnItemClickListener listener) {
        this.itemClickListener = new universaladapter.easyrecycler.debouncedlisteners.DebouncedOnClickListener() {
            @Override
            public boolean onDebouncedClick(View v, int position) {
                if (listener != null) {
                    listener.onItemClick(position, v);
                }
                return true;
            }
        };
    }


    public void setOnLongClickListener(final EasyViewHolder.OnItemLongClickListener listener) {
        this.longClickListener = new DebouncedOnLongClickListener() {
            @Override
            public boolean onDebouncedClick(View v, int position) {
                if (listener != null) {
                    return listener.onLongItemClicked(position, v);
                }
                return false;
            }
        };
    }

    /**
     * 判断Position是否是有效指数
     *
     * @param position
     * @return
     */
    private boolean isValidIndex(int position) {
        return position >= 0 && position < getItemCount();
    }
}
