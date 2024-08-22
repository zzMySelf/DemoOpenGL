package com.baidu.searchbox.video.payment.player;

import android.text.TextUtils;
import com.baidu.searchbox.player.layer.ContinuePlayLayer;

public class VideoPaymentContinuePlayLayer extends ContinuePlayLayer {
    /* access modifiers changed from: protected */
    public void setupContinueBarData() {
        if (getBindPlayer() instanceof VideoPaymentPlayer) {
            VideoPaymentPlayer paymentPlayer = (VideoPaymentPlayer) getBindPlayer();
            String vid = paymentPlayer.getNextColumnVid();
            String title = paymentPlayer.getNextColumnTitle();
            if (TextUtils.isEmpty(vid) || TextUtils.isEmpty(title)) {
                this.mDataInit = false;
                return;
            }
            this.mTitle.setText(title);
            this.mVid = vid;
            String poster = paymentPlayer.getNextColumnPoster();
            if (!TextUtils.isEmpty(poster)) {
                this.mPoster.setImageURI(poster);
            }
            this.mDataInit = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean interceptShow() {
        if (getBindPlayer() instanceof VideoPaymentPlayer) {
            VideoPaymentPlayer paymentPlayer = (VideoPaymentPlayer) getBindPlayer();
            if (!paymentPlayer.isAlbumPaid() && !paymentPlayer.isFree() && !paymentPlayer.isAlreadySinglePaid()) {
                return true;
            }
        }
        return super.interceptShow();
    }
}
