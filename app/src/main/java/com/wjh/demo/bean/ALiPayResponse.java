package com.wjh.demo.bean;

/**
 * Created by admin on 2016/12/20.
 */

public class ALiPayResponse {

    /**
     * info : {"sign":"Uk3prtj8ZEC9LyF2vOGehgyPO6922/98HaFUn4waJ18w3Hftc4TmLRw9dAyoD3GWDSFeylfWMDdvAV6YEANuQjw/ZJQvRyNv8OkH+sqllRmfmWQ5l7I3iCoi0iwaex3qEP9qgWoSA39Ioe1LBeHC6wZfTK+P7GRv2sR28sMZltM=","app_id":"2016072900119743","biz_content":"{\"subject\":\"圣怡琳梅洛干红葡萄酒 澳洲 16° 梅洛\",\"out_trade_no\":\"8001216742209004\",\"total_amount\":\"560.00\",\"product_code\":\"QUICK_MSECURITY_PAY\"}","charset":"utf-8","method":"alipay.mobile.public.menu.pay","notify_url":"http://shop.zhulongwan.com/alipay.php","timestamp":"2016-12-22 09:17:42","version":"1.0","sign_type":"RSA"}
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
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * sign : Uk3prtj8ZEC9LyF2vOGehgyPO6922/98HaFUn4waJ18w3Hftc4TmLRw9dAyoD3GWDSFeylfWMDdvAV6YEANuQjw/ZJQvRyNv8OkH+sqllRmfmWQ5l7I3iCoi0iwaex3qEP9qgWoSA39Ioe1LBeHC6wZfTK+P7GRv2sR28sMZltM=
         * app_id : 2016072900119743
         * biz_content : {"subject":"圣怡琳梅洛干红葡萄酒 澳洲 16° 梅洛","out_trade_no":"8001216742209004","total_amount":"560.00","product_code":"QUICK_MSECURITY_PAY"}
         * charset : utf-8
         * method : alipay.mobile.public.menu.pay
         * notify_url : http://shop.zhulongwan.com/alipay.php
         * timestamp : 2016-12-22 09:17:42
         * version : 1.0
         * sign_type : RSA
         */

        private String url;
        private String sign;
        private String app_id;
        private String biz_content;
        private String charset;
        private String method;
        private String notify_url;
        private String timestamp;
        private String version;
        private String sign_type;

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
