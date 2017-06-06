package com.wjh.demo.net;


import com.wjh.demo.utils.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求服务类
 * Created by admin on 2016/3/14.
 */
public class HttpService {
    private static Retrofit retrofit;
    private static RetrofitAPIService service;

    /**
     * 静态单例内部工具类
     */
    private static class SingletonHolder {
        private static final HttpService instance = new HttpService();
    }
    /**
     * 获取请求工具实例对象
     * @return 工具对象
     */
    public static final HttpService  getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 实例化Retrofit
     */
    private void createApi() {
        if (retrofit == null) {
            synchronized (HttpService.class) {
                if (retrofit == null) {
                    Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                            addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(genericClient());
                    retrofit = builder.build();
                }
            }
        }
        service = retrofit.create(RetrofitAPIService.class);
    }

    /**
     * 获取API服务
     * @return
     */
    public RetrofitAPIService getApiService(){
        if(service == null){
            createApi();
        }
        return service;
    }

    /**
     * 获取OkHttpClient实例
     * @return 返回 OkHttpClient实例
     */
    public OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        });
        return  okHttpClient;
    }

    /**
     * 添加请求头
     * @return
     */
    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Connection", "Keep-Alive")
                                .addHeader("Accept", "application/json")
                                .addHeader("platform", "Android")
                                .addHeader("appversion", "1.0")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return httpClient;
    }

}
