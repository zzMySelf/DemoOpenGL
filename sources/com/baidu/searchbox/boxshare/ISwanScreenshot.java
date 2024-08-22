package com.baidu.searchbox.boxshare;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.searchbox.boxshare.listener.OnShareResultListener;

public interface ISwanScreenshot {
    public static final ISwanScreenshot EMPTY = new ISwanScreenshot() {
        public void setOriginalImg(Bitmap bmp) {
        }

        public void setOnSocialShareListener(OnShareResultListener listener) {
        }

        public void setShareSource(String source) {
        }

        public void setQrCodeUrl(String qrCodeUrl) {
        }

        public void setQrCodeUrlUpdateManager(IShareLinkUpdate holder) {
        }

        public void actionStart(Context context) {
        }

        public boolean containScreenShot() {
            return false;
        }
    };

    void actionStart(Context context);

    boolean containScreenShot();

    void setOnSocialShareListener(OnShareResultListener onShareResultListener);

    void setOriginalImg(Bitmap bitmap);

    void setQrCodeUrl(String str);

    void setQrCodeUrlUpdateManager(IShareLinkUpdate iShareLinkUpdate);

    void setShareSource(String str);
}
