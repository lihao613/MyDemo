package com.wjh.demo.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.wjh.demo.BaseActivity;
import com.wjh.demo.R;
import com.wjh.demo.utils.Cookie;
import com.wjh.demo.utils.ToastUtils;



public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler,View.OnClickListener{

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    TextView successAgainShop;
    TextView successLookAllOrder;
    TextView success_price;
    public static Activity payActivity;
    private IWXAPI api;
    Cookie cookie;

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_paysuccess);

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        successAgainShop= (TextView) findViewById(R.id.success_again_shop);
        successLookAllOrder= (TextView) findViewById(R.id.success_look_AllOrder);
        success_price= (TextView) findViewById(R.id.success_price);

        cookie= new Cookie(WXPayEntryActivity.this,Cookie.USER_DATA);
        api = WXAPIFactory.createWXAPI(this, "wx03df5def2b39235f");
        api.handleIntent(getIntent(), this);

    }

    @Override
    public void setOnListener() {
        successAgainShop.setOnClickListener(this);
        successLookAllOrder.setOnClickListener(this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        Log.i("onPayFinish", "onPayFinish, errCode = " + req.openId);// 支付结果码
    }

    @Override
    public void onResp(BaseResp resp) {
        Log.i("onPayFinish", "onPayFinish, errCode = " + resp.errCode);// 支付结果码
    /*	if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			Log.i("WXPayEntryActivity","WXPayEntryActivity-----");
		}*/
        int code = resp.errCode;

        if (code == 0) {
            //显示充值成功的页面和需要的操作
            ToastUtils.showToast(this, "支付成功");
            //刷新购物车数量
            payActivity.finish();
        }

        if (code == -1) {
            //错误
            ToastUtils.showToast(this, "支付失败");
            Bundle bundle = new Bundle();
            bundle.putString("state", "unpaid");
          //  Jump.forward(this, MainActivity.class);
            finish();

        }

        if (code == -2) {
            //用户取消
            //显示充值成功的页面和需要的操作
            //刷新购物车数量

            ToastUtils.showToast(this, "取消支付");
            Bundle bundle = new Bundle();
            bundle.putString("state", "unpaid");
          //  Jump.forward(this, MainActivity.class);
            finish();
        }
    }


    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.success_again_shop:
                    finish();
                    break;
                case R.id.success_look_AllOrder:
                    Bundle bM = new Bundle();
                    bM.putString("state", "all");
                    finish();
                    break;
            }
    }
}