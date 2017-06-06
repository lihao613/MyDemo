package com.wjh.demo.net;



import android.util.Log;


import com.wjh.demo.bean.AliRechargeResponse;
import com.wjh.demo.bean.RequestWXRechargeEntity;
import com.wjh.demo.bean.ResponseWXPayEntity;

import java.util.ArrayList;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 网络请求实现类，使用Retrofit网络库
 * Created by admin on 2016/3/14.
 */
public class HttpInterfaceImpl implements HttpInterface {

    private ArrayList<Call> calls = new ArrayList<>();
    private HashMap<String, Call> callHashMap = new HashMap<>();


    /***6500-1300     1040
     * 微信充值240    4500-900   720
     * @param requestWXRechargeEntity
     * @param operate
     */
    @Override
    public void WXRecharge(RequestWXRechargeEntity requestWXRechargeEntity, OnRequestResult<ResponseWXPayEntity> operate) {
        try {
            Call<ResponseWXPayEntity> call = HttpService.getInstance().getApiService().WXRecharge(requestWXRechargeEntity);
            calls.add(call);
            executeCall(call, operate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 支付宝充值
     *
     */
    @Override
    public void getAliRecharge(String id, String token, String method, String recharge, OnRequestResult<AliRechargeResponse> operate) {
        try {
            Call<AliRechargeResponse> call = HttpService.getInstance().getApiService().getAliRecharge(id,token,method,recharge);
            calls.add(call);
            executeCall(call, operate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    /**
     * 执行请求
     *
     *
     * @param call    请求执行参数
     * @param operate 结果回调参数
     */
    public <T> void executeCall(Call<T> call, final OnRequestResult<T> operate) {
        if (true) {
            call.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    if (operate != null) {
                        if (response != null && response.body() != null) {
                            T result = response.body();
                            operate.onSuccess(result);
                        } else {
                            operate.onFail();
                        }
                    }
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    Log.e("请求失败",t.toString());
                    if (operate != null) {
                        operate.onFail();
                    }
                }
            });
        } else {
            operate.netUnlink();
        }
    }



}
