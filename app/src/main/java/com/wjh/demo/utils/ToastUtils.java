package com.wjh.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Toast显示工具
 */
public class ToastUtils {

    private static String oldMsg;
    private Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;
    private ToastUtils utils;

    /**
     * 显示Toast
     * @param context 上下文对象
     * @param s 显示的字符串
     * @param duration 显示时长
     */
    public void showUniqueToast(Context context, String s, int duration) {

        if (toast == null) {
            toast = Toast.makeText(context, s, duration);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > duration) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    /**
     * 显示Toast
     * @param context 上下文对象
     * @param s 显示的字符串
     */
    public void showUniqueToast(Context context, String s) {

        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_LONG);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_LONG) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    /**
     * 显示toast
     * @param context 上下文对象
     * @param resId 资源ID
     */
    public static void showToast(Context context, @Nullable int resId) {
        //showUniqueToast(context, context.getString(resId));
        toast_Short(context, resId);
    }

    /**
     * 显示toast
     * @param context 上下文对象
     * @param content 显示内容
     */
    public static void showToast(Context context, String content) {
        //showUniqueToast(context, content);
        toast_Short(context, content);
    }

    /**
     * 短toast 提示
     * @param context
     * @param content
     */
    private  static void toast_Short(final Context context, final String content) {

        if (content == null)
            return;
        if (StringUtils.isEmpty(content))
            return;
        try{
            Activity activity = (Activity) context;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            try{
                Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    private  static void toast_Short(final Context context, final int  idRes){

        if (context == null)
            return;
        if (StringUtils.isEmpty(idRes+""))
            return;

        try {
            Activity activity = (Activity) context;

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context,context.getResources().getString(idRes), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            try {
                Toast.makeText(context,context.getResources().getString(idRes), Toast.LENGTH_SHORT).show();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }

    }

}
