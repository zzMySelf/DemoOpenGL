package com.baidu.android.ext.widget.dialog;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/android/ext/widget/dialog/LoadingDialog$mDotAnimAction$1", "Ljava/lang/Runnable;", "run", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog$mDotAnimAction$1 implements Runnable {
    final /* synthetic */ LoadingDialog this$0;

    LoadingDialog$mDotAnimAction$1(LoadingDialog $receiver) {
        this.this$0 = $receiver;
    }

    public void run() {
        TextView access$getMDotAnimTv$p = this.this$0.mDotAnimTv;
        if (access$getMDotAnimTv$p != null) {
            access$getMDotAnimTv$p.removeCallbacks(this);
        }
        TextView access$getMDotAnimTv$p2 = this.this$0.mDotAnimTv;
        if ((access$getMDotAnimTv$p2 != null && access$getMDotAnimTv$p2.getVisibility() == 0) && this.this$0.isShowing()) {
            switch (this.this$0.mDotAnimCounter) {
                case 0:
                    TextView access$getMDotAnimTv$p3 = this.this$0.mDotAnimTv;
                    if (access$getMDotAnimTv$p3 != null) {
                        access$getMDotAnimTv$p3.setText("");
                        break;
                    }
                    break;
                case 1:
                    TextView access$getMDotAnimTv$p4 = this.this$0.mDotAnimTv;
                    if (access$getMDotAnimTv$p4 != null) {
                        access$getMDotAnimTv$p4.setText(".");
                        break;
                    }
                    break;
                case 2:
                    TextView access$getMDotAnimTv$p5 = this.this$0.mDotAnimTv;
                    if (access$getMDotAnimTv$p5 != null) {
                        access$getMDotAnimTv$p5.setText("..");
                        break;
                    }
                    break;
                case 3:
                    TextView access$getMDotAnimTv$p6 = this.this$0.mDotAnimTv;
                    if (access$getMDotAnimTv$p6 != null) {
                        access$getMDotAnimTv$p6.setText("...");
                        break;
                    }
                    break;
            }
            LoadingDialog loadingDialog = this.this$0;
            loadingDialog.mDotAnimCounter = loadingDialog.mDotAnimCounter + 1;
            if (this.this$0.mDotAnimCounter > 3) {
                this.this$0.mDotAnimCounter = 0;
            }
            TextView access$getMDotAnimTv$p7 = this.this$0.mDotAnimTv;
            Intrinsics.checkNotNull(access$getMDotAnimTv$p7);
            access$getMDotAnimTv$p7.postDelayed(this, 250);
        }
    }
}
