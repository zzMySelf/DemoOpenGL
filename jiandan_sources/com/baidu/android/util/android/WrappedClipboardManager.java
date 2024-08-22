package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import androidx.webkit.internal.AssetHelper;

public abstract class WrappedClipboardManager {
    public static Context sTheApp;

    @TargetApi(11)
    public static class HoneycombClipboardManager extends WrappedClipboardManager {
        public static ClipData sClipData;
        public static ClipboardManager sInstance;

        @SuppressLint({"ServiceCast"})
        public HoneycombClipboardManager() {
            sInstance = (ClipboardManager) WrappedClipboardManager.sTheApp.getSystemService("clipboard");
        }

        public CharSequence getText() {
            try {
                sClipData = sInstance.getPrimaryClip();
            } catch (Exception unused) {
            }
            ClipData clipData = sClipData;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : sClipData.getItemAt(0).getText();
        }

        public boolean hasText() {
            return sInstance.hasPrimaryClip();
        }

        public void setText(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText(AssetHelper.DEFAULT_MIME_TYPE, charSequence);
            sClipData = newPlainText;
            sInstance.setPrimaryClip(newPlainText);
        }
    }

    public static class OldClipboardManager extends WrappedClipboardManager {
        public static android.text.ClipboardManager sInstance;

        public OldClipboardManager() {
            sInstance = (android.text.ClipboardManager) WrappedClipboardManager.sTheApp.getSystemService("clipboard");
        }

        public CharSequence getText() {
            return sInstance.getText();
        }

        public boolean hasText() {
            return sInstance.hasText();
        }

        public void setText(CharSequence charSequence) {
            sInstance.setText(charSequence);
        }
    }

    public static WrappedClipboardManager newInstance(Context context) {
        sTheApp = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 11) {
            return new HoneycombClipboardManager();
        }
        return new OldClipboardManager();
    }

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charSequence);
}
