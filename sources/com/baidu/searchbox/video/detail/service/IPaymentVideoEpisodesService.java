package com.baidu.searchbox.video.detail.service;

public interface IPaymentVideoEpisodesService extends IService {

    public interface RefreshStyle {
        public static final int PAYMENT_SINGLE_SUCCESS_REFRESH = 6;
        public static final int PAYMENT_SUCCESS_REFRESH = 1;
        public static final int VIDEO_CONTINUE_REFRESH = 2;
        public static final int VIDEO_COUPON_LOGIN_REFRESH = 5;
        public static final int VIDEO_DISCOUNT_END_REFRESH = 4;
        public static final int VIDEO_EPISODES_CLICK = 3;
    }

    void reset();

    void setRefreshStyle(int i2);

    void setSinglePaidNid(String str);
}
