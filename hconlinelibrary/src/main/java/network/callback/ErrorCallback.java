package network.callback;

import java.net.UnknownHostException;

import model.ErrorModel;

/**
 * Created by Jam on 2016/3/14.
 * 网络请求失败回调
 */
public interface ErrorCallback {

    /**
     * 没有数据或者请求的路径找不到
     *
     * @param errorModel ErrorModel
     */
    void errorNotFound(ErrorModel errorModel);

    /**
     * 因为参数不对，导致无法继续处理后面逻辑
     *
     * @param errorModel ErrorModel
     */
    void errorUnProcessable(ErrorModel errorModel);

    /**
     * 当前请求需要用户验证
     *
     * @param errorModel ErrorModel
     */
    void errorUnauthorized(ErrorModel errorModel);

    /**
     * 权限校验不通过
     *
     * @param errorModel ErrorModel
     */
    void errorForbidden(ErrorModel errorModel);

    /**
     * 无网络错误
     *
     * @param t Throwable
     * @param errorModel ErrorModel
     */
    void eNetUnReach(Throwable t, ErrorModel errorModel);

    /**
     * 链接超时错误
     *
     * @param e Throwable
     * @param errorModel ErrorModel
     */
    void errorSocketTimeout(Throwable e, ErrorModel errorModel);

    /**
     * java.net.UnknownHostException: Unable to resolve host "xxx": No address associated with
     * hostname
     *
     * @param e UnknownHostException
     * @param errorModel ErrorModel
     */
    void errorUnknownHost(UnknownHostException e, ErrorModel errorModel);

    /**
     * 未处理的 error 信息
     *
     * @param errorModel ErrorModel
     */
    void error(ErrorModel errorModel);

}
