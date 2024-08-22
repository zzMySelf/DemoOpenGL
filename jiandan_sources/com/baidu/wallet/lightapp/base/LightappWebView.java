package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.webmanager.SafeWebView;

public class LightappWebView extends SafeWebView {
    public a a;

    public interface a {
        void a(int i2);
    }

    public LightappWebView(Context context) {
        super(new MutableContextWrapper(context));
    }

    public void impactJavascriptInterfaces() {
        super.impactJavascriptInterfaces();
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript("(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()", (ValueCallback) null);
            } else {
                super.loadUrl("javascript:" + "(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()");
            }
        } catch (Throwable unused) {
        }
        LogUtil.d("LightappWebView", "RuntimeReady:" + "(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()");
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void setBaseContext(Context context) {
        ((MutableContextWrapper) getContext()).setBaseContext(context);
    }

    public void setOnMyScrollChangeListener(a aVar) {
        this.a = aVar;
    }

    public LightappWebView(Context context, AttributeSet attributeSet) {
        super(new MutableContextWrapper(context), attributeSet);
    }
}
