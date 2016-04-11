package network;

import com.paginate.Paginate;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import contracts.Pagination.Emitter;
import contracts.Pagination.PaginatorContract;
import model.entity.Entity;
import network.callback.GenericCallback;
import network.callback.NetworkCallback;
import network.callback.PaginatorCallback;
import widget.StarterKit;

/**
 * Created by Jam on 2016/3/14.
 * 分页工具
 */
public abstract class Paginator <T extends Entity> implements PaginatorContract<T>,GenericCallback<ArrayList<T>> {


    static final int DEFAULT_PER_PAGE = StarterKit.getsItemsPerPage();
    static final int DTFAULT_FIRST_PAGE = StarterKit.getsItemFristPage();

    int  mPerPage;

    boolean mHasMore;
    boolean mIsLoading = false;
    boolean mDataHasLoaded = false;
    boolean mHasError = false;

    final LinkedHashMap<Object,T> mResources = new LinkedHashMap<>();
//
//    protected Paginate(Emitter<T> emitter, PaginatorCallback<T> )
}
