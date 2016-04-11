package universaladapter.easyrecycler.debouncedlisteners;

import android.view.View;

/**
 * Created by Jam on 2016/3/14.
 * 去抖动
 */
public interface DebouncedListener {
    boolean onDebouncedClick(View v, int position);
}
