package com.wjh.demo.bean;

/**
 * Created by admin on 2017/1/11.
 */

public class AliRechargeResponse {

    /**
     * info : {"sign":"CPHkvqGtvY1eWC48xd+ehLQdmfI9jFzt86m1TPB+q+huRKWhOV30pQ8Kp/cbEnuWgWExYshnHg+kBX5mh/ej0bZL9/e5CxFezvNGgUItk5I+yt6utF8Wj/H6Se8zhahGz5zhAez9+0kS3jsZjHFBTE7ZcYNikdDW9qw+dVu9YYc=","app_id":"2016121904405754","biz_content":"{\"subject\":\"充值500元\",\"out_trade_no\":\"8000111283154795\",\"total_amount\":\"1\",\"product_code\":\"QUICK_MSECURITY_PAY\"}","charset":"utf-8","method":"alipay.trade.app.pay","notify_url":"http://shop.zhulongwan.com/alipay.php","timestamp":"2017-01-11 17:53:40","version":"1.0","sign_type":"RSA","url":"app_id=2016121904405754&biz_content=%7B%22subject%22%3A%22%E5%85%85%E5%80%BC500%E5%85%83%22%2C%22out_trade_no%22%3A%228000111283154795%22%2C%22total_amount%22%3A%221%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=utf-8&method=alipay.trade.app.pay¬ify_url=http%3A%2F%2Fshop.zhulongwan.com%2Falipay.php&sign=CPHkvqGtvY1eWC48xd%2BehLQdmfI9jFzt86m1TPB%2Bq%2BhuRKWhOV30pQ8Kp%2FcbEnuWgWExYshnHg%2BkBX5mh%2Fej0bZL9%2Fe5CxFezvNGgUItk5I%2Byt6utF8Wj%2FH6Se8zhahGz5zhAez9%2B0kS3jsZjHFBTE7ZcYNikdDW9qw%2BdVu9YYc%3D&sign_type=RSA×tamp=2017-01-11+17%3A53%3A40&version=1.0&sign=CPHkvqGtvY1eWC48xd%2BehLQdmfI9jFzt86m1TPB%2Bq%2BhuRKWhOV30pQ8Kp%2FcbEnuWgWExYshnHg%2BkBX5mh%2Fej0bZL9%2Fe5CxFezvNGgUItk5I%2Byt6utF8Wj%2FH6Se8zhahGz5zhAez9%2B0kS3jsZjHFBTE7ZcYNikdDW9qw%2BdVu9YYc%3D"}
     * err : {"errorcode":"0","errorinfo":"ok"}
     */

    private InfoBean info;
    private ErrBean err;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public ErrBean getErr() {
        return err;
    }

    public void setErr(ErrBean err) {
        this.err = err;
    }

    public static class InfoBean {
        /**
         * sign : CPHkvqGtvY1eWC48xd+ehLQdmfI9jFzt86m1TPB+q+huRKWhOV30pQ8Kp/cbEnuWgWExYshnHg+kBX5mh/ej0bZL9/e5CxFezvNGgUItk5I+yt6utF8Wj/H6Se8zhahGz5zhAez9+0kS3jsZjHFBTE7ZcYNikdDW9qw+dVu9YYc=
         * app_id : 2016121904405754
         * biz_content : {"subject":"充值500元","out_trade_no":"8000111283154795","total_amount":"1","product_code":"QUICK_MSECURITY_PAY"}
         * charset : utf-8
         * method : alipay.trade.app.pay
         * notify_url : http://shop.zhulongwan.com/alipay.php
         * timestamp : 2017-01-11 17:53:40
         * version : 1.0
         * sign_type : RSA
         * url : app_id=2016121904405754&biz_content=%7B%22subject%22%3A%22%E5%85%85%E5%80%BC500%E5%85%83%22%2C%22out_trade_no%22%3A%228000111283154795%22%2C%22total_amount%22%3A%221%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=utf-8&method=alipay.trade.app.pay¬ify_url=http%3A%2F%2Fshop.zhulongwan.com%2Falipay.php&sign=CPHkvqGtvY1eWC48xd%2BehLQdmfI9jFzt86m1TPB%2Bq%2BhuRKWhOV30pQ8Kp%2FcbEnuWgWExYshnHg%2BkBX5mh%2Fej0bZL9%2Fe5CxFezvNGgUItk5I%2Byt6utF8Wj%2FH6Se8zhahGz5zhAez9%2B0kS3jsZjHFBTE7ZcYNikdDW9qw%2BdVu9YYc%3D&sign_type=RSA×tamp=2017-01-11+17%3A53%3A40&version=1.0&sign=CPHkvqGtvY1eWC48xd%2BehLQdmfI9jFzt86m1TPB%2Bq%2BhuRKWhOV30pQ8Kp%2FcbEnuWgWExYshnHg%2BkBX5mh%2Fej0bZL9%2Fe5CxFezvNGgUItk5I%2Byt6utF8Wj%2FH6Se8zhahGz5zhAez9%2B0kS3jsZjHFBTE7ZcYNikdDW9qw%2BdVu9YYc%3D
         */

        private String sign;
        private String app_id;
        private String biz_content;
        private String charset;
        private String method;
        private String notify_url;
        private String timestamp;
        private String version;
        private String sign_type;
        private String url;

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getBiz_content() {
            return biz_content;
        }

        public void setBiz_content(String biz_content) {
            this.biz_content = biz_content;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getSign_type() {
            return sign_type;
        }

        public void setSign_type(String sign_type) {
            this.sign_type = sign_type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ErrBean {
        /**
         * errorcode : 0
         * errorinfo : ok
         */

        private String errorcode;
        private String errorinfo;

        public String getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(String errorcode) {
            this.errorcode = errorcode;
        }

        public String getErrorinfo() {
            return errorinfo;
        }

        public void setErrorinfo(String errorinfo) {
            this.errorinfo = errorinfo;
        }
    }
}
