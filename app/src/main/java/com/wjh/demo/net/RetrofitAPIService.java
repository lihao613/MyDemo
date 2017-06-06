package com.wjh.demo.net;

import com.wjh.demo.bean.AliRechargeResponse;
import com.wjh.demo.bean.RequestWXRechargeEntity;
import com.wjh.demo.bean.ResponseWXPayEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * retrofit请求接口服务类
 * Created by admin on 2016/3/14.
 */
public interface RetrofitAPIService {
    /**
     *支付宝充值
     */
    @GET("ali.php")
    Call<AliRechargeResponse> getAliRecharge(@Query("member_id") String id, @Query("token") String token, @Query("method") String mothod, @Query("recharge") String recharge);
    /**
     * 微信充值
     */
    @POST("shop/ybkapi.php/?act=ybkapi&op=topay")
    Call<ResponseWXPayEntity> WXRecharge(@Body RequestWXRechargeEntity requestWXRechargeEntity);
}
