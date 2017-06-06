package com.wjh.demo.net;

/**
 * 请求接口回调
 * Created by admin on 2016/5/13.
 */
public interface OnRequestResult<T> {
    /**请求成功*/
    void onSuccess(T result);
    /**请求失败*/
    void onFail();
    /**当前没有网络*/
    void netUnlink();
}
