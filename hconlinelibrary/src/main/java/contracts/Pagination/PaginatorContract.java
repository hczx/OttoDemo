package contracts.Pagination;

import java.util.List;

import model.entity.Entity;

/**
 * Created by Jam on 2016/3/14.
 */
public interface PaginatorContract<T extends Entity> {

    /**
     * Get all of the items being paginated.
     * 把所有的物品分页。
     *
     * @return collection
     */
    List<T> items();

    /**
     * Determine how many items are being shown per page.
     * 确定每一页所显示的有多少项。
     */
    int perPage();

    /**
     * Determine if there is more items in the data store.
     * 确定数据存储区中是否有更多的项目
     *
     * @return has more
     */
    boolean hasMorePages();

    /**
     * Determine if the list of items is empty or not.
     * 确定项目列表是否为空或不。
     */
    boolean isEmpty();

    boolean hasError();

    boolean dataHasLoaded();

    boolean canLoadMore();

    boolean isRefresh();

    boolean isLoading();

    void refresh();

    void loadMore();

    void cancel();

    enum LoadStyle {
        REFRESH,
        LOAD_MORE,
    }
}
