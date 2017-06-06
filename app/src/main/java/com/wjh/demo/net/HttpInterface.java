package com.wjh.demo.net;


import com.wjh.demo.bean.AliRechargeResponse;
import com.wjh.demo.bean.RequestWXRechargeEntity;
import com.wjh.demo.bean.ResponseWXPayEntity;

/**
 * 网络请求相关接口
 * Created by admin on 2016/3/14.
 */
public interface HttpInterface {

    /**
     * 支付宝充值
     */
    void getAliRecharge(String id, String token, String method, String recharge, OnRequestResult<AliRechargeResponse> operate);
    /***
     * 微信充值
     * @return
     */
    void WXRecharge(RequestWXRechargeEntity requestWXRechargeEntity, OnRequestResult<ResponseWXPayEntity> operate);
}

