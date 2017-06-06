package com.wjh.demo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;

import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.wjh.demo.BaseActivity;
import com.wjh.demo.R;
import com.wjh.demo.bean.ALiPayResponse;
import com.wjh.demo.bean.AliRechargeResponse;
import com.wjh.demo.bean.PayResult;
import com.wjh.demo.bean.RequestWXRechargeEntity;
import com.wjh.demo.bean.ResponseWXPayEntity;
import com.wjh.demo.net.HttpInterface;
import com.wjh.demo.net.HttpInterfaceImpl;
import com.wjh.demo.net.OnRequestResult;
import com.wjh.demo.utils.ToastUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RechargeActivity extends BaseActivity implements View.OnClickListener {


    TextView titlename;
    TextView pview1;
    TextView pview2;
    TextView pview3;
    TextView pview4;
    LinearLayout zfbLayout;
    ImageView zfbImg;
    LinearLayout wxLayout;
    ImageView wxImg;
    TextView payButton;

    RelativeLayout recharge_re_one;
    RelativeLayout recharge_re_two;
    RelativeLayout recharge_re_three;
    RelativeLayout recharge_re_four;

    private String payMoney = "";
    private int payNum = 1;
    private Activity mActivity;
    IWXAPI iwxapi;
    HttpInterface imp;


    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_recharge);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        titlename = (TextView) findViewById(R.id.comment_title_name);
        pview1 = (TextView) findViewById(R.id.recharg_ralyout_view1);
        pview2 = (TextView) findViewById(R.id.recharg_ralyout_view2);
        pview3 = (TextView) findViewById(R.id.recharg_ralyout_view3);
        pview4 = (TextView) findViewById(R.id.recharg_ralyout_view4);

        zfbLayout = (LinearLayout) findViewById(R.id.recharg_ralyout_tabr1);
        zfbImg = (ImageView) findViewById(R.id.recharg_ralyout_payzfb);
        wxLayout = (LinearLayout) findViewById(R.id.recharg_ralyout_tabr2);
        wxImg = (ImageView) findViewById(R.id.recharg_ralyout_paywx);
        payButton = (TextView) findViewById(R.id.recharg_ralyout_but);

        recharge_re_one = (RelativeLayout) findViewById(R.id.recharge_re_one);
        recharge_re_two = (RelativeLayout) findViewById(R.id.recharge_re_two);
        recharge_re_three = (RelativeLayout) findViewById(R.id.recharge_re_three);
        recharge_re_four = (RelativeLayout) findViewById(R.id.recharge_re_four);


        titlename.setText("充值中心");
        mActivity = RechargeActivity.this;
        zfbImg.setBackgroundResource(R.drawable.selected);

        iwxapi = WXAPIFactory.createWXAPI(mActivity, "wx03df5def2b39235f", true);
        iwxapi.registerApp("wx03df5def2b39235f");
    }


    @Override
    public void setOnListener() {
        recharge_re_one.setOnClickListener(this);
        recharge_re_two.setOnClickListener(this);
        recharge_re_three.setOnClickListener(this);
        recharge_re_four.setOnClickListener(this);
        zfbLayout.setOnClickListener(this);
        zfbImg.setOnClickListener(this);
        wxLayout.setOnClickListener(this);
        wxImg.setOnClickListener(this);
        payButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comment_title_back:
                /*回到上一界面*/
                finish();
                break;
            case R.id.recharge_re_one:
                /*选择支付金额*/
                getPayView();
                clearStatus();
                recharge_re_one.setBackgroundResource(R.drawable.textview_border);
                payMoney = "5000";
                break;
            case R.id.recharge_re_two:
                /*选择支付金额*/
                getPayView();
                clearStatus();
                recharge_re_two.setBackgroundResource(R.drawable.textview_border);
                payMoney = "10000";
                break;
            case R.id.recharge_re_three:
                /*选择支付金额*/
                getPayView();
                clearStatus();
                recharge_re_three.setBackgroundResource(R.drawable.textview_border);
                payMoney = "20000";
                break;
            case R.id.recharge_re_four:
                /*选择支付金额*/
                getPayView();
                clearStatus();
                recharge_re_four.setBackgroundResource(R.drawable.textview_border);
                payMoney = "50000";
                break;
            case R.id.recharg_ralyout_tabr1:
            case R.id.recharg_ralyout_payzfb:
                /*选择支付支付宝支付*/
                setPayImageView();
                zfbImg.setBackgroundResource(R.drawable.selected);
                payNum = 1;
                break;
            case R.id.recharg_ralyout_tabr2:
            case R.id.recharg_ralyout_paywx:
                /*选择微信支付*/
                setPayImageView();
                wxImg.setBackgroundResource(R.drawable.selected);
                payNum = 2;
                break;
            case R.id.recharg_ralyout_but:
                /*确定充值*/
                getPayButton();
                break;
        }
    }

    public void clearStatus() {
        recharge_re_one.setBackgroundResource(R.color.white);
        recharge_re_two.setBackgroundResource(R.color.white);
        recharge_re_three.setBackgroundResource(R.color.white);
        recharge_re_four.setBackgroundResource(R.color.white);
    }

    private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    //微信支付
    private void WeiXinPay() {
        //  首先判断目前微信版本是否支持微信支付
        boolean isPaySupported = iwxapi.getWXAppSupportAPI() >= TIMELINE_SUPPORTED_VERSION;
        // 检查是否安装微信
        boolean sIsWXAppInstalledAndSupported;
        sIsWXAppInstalledAndSupported = iwxapi.isWXAppInstalled() && iwxapi.isWXAppSupportAPI();

        if (!sIsWXAppInstalledAndSupported) {
            ToastUtils.showToast(mActivity, "您未安装微信,请下载微信");
            return;
        } else {
            if (isPaySupported) {
                getWXData();
            } else {
                ToastUtils.showToast(mActivity, "您安装微信,不支持支付");
            }
        }
    }

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_CHECK_FLAG = 2;
    //支付宝支付结果
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case SDK_PAY_FLAG: {

                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showToast(RechargeActivity.this, "支付成功");
                        finish();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败20
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            ToastUtils.showToast(RechargeActivity.this, "支付结果确认中");

                        } else if (TextUtils.equals(resultStatus, "6001")) {
                            ToastUtils.showToast(RechargeActivity.this, "支付取消");
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            ToastUtils.showToast(RechargeActivity.this, "支付失败");

                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
                    ToastUtils.showToast(RechargeActivity.this, "检查结果为：" + msg.obj);
                    break;
                }

            }
        }
    };

    // 支付宝 接口调用
    public void pay(final String info) {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(RechargeActivity.this);
                // 调用支付接口，获取支付结果
                Map<String, String> result = alipay.payV2(info, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 从接口请求数据得到支付串
     */
    private void getAliPay() {
        if (imp == null) {
            imp = new HttpInterfaceImpl();
        }

        imp.getAliRecharge("", "", "alipay", payMoney, new OnRequestResult<AliRechargeResponse>() {
            @Override
            public void onSuccess(AliRechargeResponse result) {
                String code = result.getErr().getErrorcode();
                if (code.equals("0")) {
                    //支付宝支付
                    pay(result.getInfo().getUrl());
                } else if (code.equals("4")) {
                    ToastUtils.showToast(mActivity, getResources().getString(R.string.code_4));
                } else {
                    ToastUtils.showToast(mActivity, getResources().getString(R.string.code_1));

                }

            }

            @Override
            public void onFail() {

                ToastUtils.showToast(mActivity, getResources().getString(R.string.onFail));
            }

            @Override
            public void netUnlink() {
                ToastUtils.showToast(mActivity, getResources().getString(R.string.netUnlink));
            }
        });
    }

    /**
     * 从接口请求数据得到支付串
     * 微信
     */

    private void getWXData() {
        if (imp == null) {
            imp = new HttpInterfaceImpl();
        }
        RequestWXRechargeEntity entity = new RequestWXRechargeEntity();
        entity.setMember_id("");
        entity.setToken("");
        entity.setMethod("wx");
        entity.setRecharge(payMoney);
        imp.WXRecharge(entity, new OnRequestResult<ResponseWXPayEntity>() {
            @Override
            public void onSuccess(ResponseWXPayEntity result) {
                String code = result.getErr().getErrorcode();
                Log.i("正在调起微信支付", result.getInfo().toString() + "");
                if (code.equals("0")) {
                    ToastUtils.showToast(mActivity, "正在调起微信支付...");
                    PayReq req = new PayReq();
                    //req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
                    req.appId = result.getInfo().getAppid();
                    req.partnerId = result.getInfo().getPartnerid();
                    req.prepayId = result.getInfo().getPrepay_id();
                    req.nonceStr = result.getInfo().getNoncestr();
                    req.timeStamp = result.getInfo().getTimestamp() + "";
                    req.packageValue = result.getInfo().getPackageX();
                    req.sign = result.getInfo().getSign();
                    // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                    boolean tag = iwxapi.sendReq(req);
                    Log.i("正在调起微信支付", tag + "");
                } else if (code.equals("4")) {
                    ToastUtils.showToast(mActivity, getResources().getString(R.string.code_4));
                } else {
                    ToastUtils.showToast(mActivity, getResources().getString(R.string.code_1));

                }

            }

            @Override
            public void onFail() {

                ToastUtils.showToast(mActivity, getResources().getString(R.string.onFail));
            }

            @Override
            public void netUnlink() {

                ToastUtils.showToast(mActivity, getResources().getString(R.string.netUnlink));
            }
        });
    }


    private void getPayView() {
        pview1.setBackgroundColor(Color.parseColor("#ffffff"));
        pview2.setBackgroundColor(Color.parseColor("#ffffff"));
        pview3.setBackgroundColor(Color.parseColor("#ffffff"));
        pview4.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void setPayImageView() {
        zfbImg.setBackgroundResource(R.drawable.kong);
        wxImg.setBackgroundResource(R.drawable.kong);
    }

    private void getPayButton() {
        if (payNum == 1) {
            getAliPay();
        } else if (payNum == 2) {
            WeiXinPay();
        }
    }


    /**
     * 构造支付订单参数信息
     * 支付订单参数
     *
     * @return
     */
    public static String buildOrderParam(ALiPayResponse result) {
        Map<String, String> map = getAliPayString(result);

        List<String> keys = new ArrayList<String>(map.keySet());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            sb.append(buildKeyValue(key, value, true));
            sb.append("&");
        }

        String ss = sb.toString();
        ss = ss.substring(0, ss.length() - 1);
        Log.i("wjh", "-------->" + sb.toString());
        return sb.toString();

    }

    /**
     * 支付宝自己拼接支付串
     *
     * @param result
     * @return
     */
    private static Map<String, String> getAliPayString(ALiPayResponse result) {
        Map<String, String> keyValues = new HashMap<String, String>();

        keyValues.put("app_id", result.getInfo().getApp_id());

        keyValues.put("biz_content", result.getInfo().getBiz_content());

        keyValues.put("charset", result.getInfo().getCharset());

        keyValues.put("format", "json");

        keyValues.put("method", result.getInfo().getMethod());

        keyValues.put("notify_url", result.getInfo().getNotify_url());

        keyValues.put("sign_type", result.getInfo().getSign_type());

        keyValues.put("timestamp", result.getInfo().getTimestamp());

        keyValues.put("version", result.getInfo().getVersion());

        keyValues.put("sign", result.getInfo().getSign());


        return keyValues;
    }

    /**
     * 拼接键值对
     *
     * @param key
     * @param value
     * @param isEncode
     * @return
     */
    private static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode) {
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }
        return sb.toString();
    }
}
