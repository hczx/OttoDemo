package contracts.Pagination;

/**
 * Created by Jam on 2016/3/14.
 * 发射器
 */
public interface Emitter<T> {
    void beforeRefresh();

    void beforeLoadMore();

    T register(final T item);

    Object getKeyForData(T item);
}
