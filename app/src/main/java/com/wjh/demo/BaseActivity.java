package com.wjh.demo;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;



/**
 * Activity基类
 * Created by Administrator on 2015/12/10.
 */
public abstract class BaseActivity extends FragmentActivity {

    public static String TAG = "BaseActivity";
    public Resources mResources = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitWindow();
        setContentLayout();
        mResources = getResources();
        initViews(savedInstanceState);
        setOnListener();
    }

    protected void InitWindow() {
        Window window =getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }
    /**
     * 设置布局文件
     */
    public abstract void setContentLayout();

    /**
     * 初始化view组件
     */
    public abstract void initViews(Bundle savedInstanceState);

    /***
     * 设置组件监听
     */
    public abstract void setOnListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
