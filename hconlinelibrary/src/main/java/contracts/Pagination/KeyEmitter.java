package contracts.Pagination;

import java.util.ArrayList;

import model.entity.Entity;
import retrofit2.Call;

/**
 * Created by 99165 on 2016/3/14.
 */
public interface KeyEmitter<T extends Entity> extends Emitter<T> {

    /**
     * maxItem 在 loadMore 的时候需要
     * sinceItem 在获取最新数据需要
     *
     * @param sinceItem 第一条数据
     * @param maxItem   最后一条数据
     * @param perPage   每页获取多少条数据
     * @return Call
     */
    Call<ArrayList<T>> paginate(T sinceItem, T maxItem, int perPage);
}
