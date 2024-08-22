package com.baidu.searchbox.account.userinfo.view;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.ui.style.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/account/userinfo/view/AiGenerateSignatureView$updateTextRunnable$1", "Ljava/lang/Runnable;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "loadingTextArray", "", "", "getLoadingTextArray", "()[Ljava/lang/String;", "[Ljava/lang/String;", "run", "", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiGenerateSignatureView.kt */
public final class AiGenerateSignatureView$updateTextRunnable$1 implements Runnable {
    private int currentIndex;
    private final String[] loadingTextArray = {"正在生成中|", "正在生成中.|", "正在生成中..|", "正在生成中...|"};
    final /* synthetic */ AiGenerateSignatureView this$0;

    AiGenerateSignatureView$updateTextRunnable$1(AiGenerateSignatureView $receiver) {
        this.this$0 = $receiver;
    }

    public final String[] getLoadingTextArray() {
        return this.loadingTextArray;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i2) {
        this.currentIndex = i2;
    }

    public void run() {
        String currentText = this.loadingTextArray[this.currentIndex];
        SpannableString spannableString = new SpannableString(currentText);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.this$0.mContext, R.color.GC7)), currentText.length() - 1, currentText.length(), 33);
        if (spannableString.length() > 0) {
            this.this$0.mEditArea.setText(spannableString);
            this.this$0.mEditArea.setSelection(spannableString.length());
        }
        int i2 = this.currentIndex + 1;
        this.currentIndex = i2;
        if (i2 >= this.loadingTextArray.length) {
            this.currentIndex = 0;
        }
        this.this$0.getLoadingHandler().postDelayed(this, 500);
    }
}
