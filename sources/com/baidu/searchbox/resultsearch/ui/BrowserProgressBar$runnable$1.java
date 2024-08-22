package com.baidu.searchbox.resultsearch.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.Log;
import com.baidu.android.util.devices.DeviceUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/resultsearch/ui/BrowserProgressBar$runnable$1", "Ljava/lang/Runnable;", "run", "", "lib-result-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserProgressBar.kt */
public final class BrowserProgressBar$runnable$1 implements Runnable {
    final /* synthetic */ BrowserProgressBar this$0;

    BrowserProgressBar$runnable$1(BrowserProgressBar $receiver) {
        this.this$0 = $receiver;
    }

    public void run() {
        int selfWidth = this.this$0.getMeasuredWidth() > 0 ? this.this$0.getMeasuredWidth() : DeviceUtil.ScreenInfo.getDisplayWidth(this.this$0.getContext());
        if (this.this$0.isBegin) {
            long currentTime = System.currentTimeMillis();
            float gap = ((float) (currentTime - this.this$0.preTime)) * this.this$0.currentSpeed;
            if (gap < 1.0f) {
                gap = 1.0f;
            }
            float newProgress = this.this$0.preProgress + gap;
            if (newProgress <= ((float) selfWidth) * 0.9f || this.this$0.isEnd) {
                this.this$0.progressWidth = newProgress;
                if (newProgress < ((float) selfWidth) * 0.5f || newProgress >= ((float) selfWidth)) {
                    if (newProgress >= ((float) selfWidth)) {
                        this.this$0.isBegin = false;
                        if (this.this$0.DEBUG) {
                            Log.i(this.this$0.TAG, "before resetToDefaultValue");
                        }
                        this.this$0.resetToDefaultValue();
                        this.this$0.setVisibility(4);
                        long timeConsuming = System.currentTimeMillis() - this.this$0.beginTime;
                        if (this.this$0.DEBUG && ((float) timeConsuming) > this.this$0.frontTime + this.this$0.latterTime) {
                            Log.i(this.this$0.TAG, "超时了，提示网络有问题");
                        }
                    }
                } else if (!this.this$0.isEnd) {
                    BrowserProgressBar browserProgressBar = this.this$0;
                    browserProgressBar.currentSpeed = browserProgressBar.latterDefaultSpeed;
                }
                this.this$0.paintAlpha();
                this.this$0.preProgress = newProgress;
                this.this$0.preTime = currentTime;
                BrowserProgressBar browserProgressBar2 = this.this$0;
                LinearGradient linearGradient = r10;
                LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, this.this$0.progressWidth, 0.0f, this.this$0.startColor, this.this$0.endColor, Shader.TileMode.CLAMP);
                browserProgressBar2.linearGradient = linearGradient;
                this.this$0.invalidate();
                this.this$0.progressHandler.postDelayed(this, this.this$0.refreshRate);
                return;
            }
            this.this$0.preTime = currentTime;
            this.this$0.progressHandler.postDelayed(this, this.this$0.refreshRate);
        }
    }
}
