package com.baidu.searchbox.socialshare.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.searchbox.socialshare.OnSocialListener;
import com.baidu.searchbox.socialshare.utils.ShareLinkUpdateManager;

public interface ISwanScreenShot {
    public static final ISwanScreenShot EMPTY = new ISwanScreenShot() {
        public void setOriginalImg(Bitmap bmp) {
        }

        public void setOnSocialShareListener(OnSocialListener listener) {
        }

        public void setShareSource(String source) {
        }

        public void setQrCodeUrl(String qrCodeUrl) {
        }

        public void setQrCodeUrlUpdateManager(ShareLinkUpdateManager holder) {
        }

        public void actionStart(Context context) {
        }

        public boolean containScreenShot() {
            return false;
        }
    };

    void actionStart(Context context);

    boolean containScreenShot();

    void setOnSocialShareListener(OnSocialListener onSocialListener);

    void setOriginalImg(Bitmap bitmap);

    void setQrCodeUrl(String str);

    void setQrCodeUrlUpdateManager(ShareLinkUpdateManager shareLinkUpdateManager);

    void setShareSource(String str);

    public static final class Impl {
        private static ISwanScreenShot sIScreenShot = SocialShareRuntime.getSwanScreenShot();

        private Impl() {
        }

        public static ISwanScreenShot get() {
            if (sIScreenShot == null) {
                sIScreenShot = ISwanScreenShot.EMPTY;
            }
            return sIScreenShot;
        }
    }
}
