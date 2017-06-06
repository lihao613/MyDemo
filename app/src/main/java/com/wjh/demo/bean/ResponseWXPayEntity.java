package com.wjh.demo.bean;


/**
 * Created by admin on 2016/12/15.
 */

public class ResponseWXPayEntity {


    /**
     * info : {"appid":"wx03df5def2b39235f","partnerid":"1418857302","prepay_id":"wx20161215145337dcad567e400169157455","package":"Sign=WXPay","noncestr":"58523de474a99","timestamp":1481784804,"sign":"D7FC9E04D91B5A7E5117833FED08D328"}
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
         * appid : wx03df5def2b39235f
         * partnerid : 1418857302
         * prepay_id : wx20161215145337dcad567e400169157455
         * package : Sign=WXPay
         * noncestr : 58523de474a99
         * timestamp : 1481784804
         * sign : D7FC9E04D91B5A7E5117833FED08D328
         */

        private String appid;
        private String partnerid;
        private String prepayid;
        private String packageX;
        private String noncestr;
        private int timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepay_id() {
            return prepayid;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepayid = prepay_id;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "InfoBean{" +
                    "appid='" + appid + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", prepay_id='" + prepayid + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", timestamp=" + timestamp +
                    ", sign='" + sign + '\'' +
                    '}';
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
