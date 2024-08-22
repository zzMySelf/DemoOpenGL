package com.baidu.sapi2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;

public class ToastUtil implements NoProguard {
    public static final int a = -1;
    public static Toast b;

    public static void a(Context context) {
        Toast toast = new Toast(context.getApplicationContext());
        b = toast;
        toast.setGravity(80, 0, ViewUtils.dp2px(context, 100.0f));
        b.setDuration(0);
    }

    public static void show(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null) {
            Toast toast = b;
            if (toast != null) {
                toast.cancel();
            }
            Context context = confignation.getContext();
            a(context);
            b.setView(a(context, -1, str));
            b.show();
        }
    }

    public static View a(Context context, int i2, String str) {
        View view;
        LayoutInflater from = LayoutInflater.from(context);
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null || (!DarkModeUtil.isDarkMode(context) && !confignation.isNightMode)) {
            view = from.inflate(R.layout.layout_sapi_sdk_common_toast, (ViewGroup) null);
        } else {
            view = from.inflate(R.layout.layout_sapi_sdk_common_night_toast, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.sapi_sdk_toast_msg_icon);
        TextView textView = (TextView) view.findViewById(R.id.sapi_sdk_toast_msg_tv);
        if (-1 == i2) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(i2);
        }
        textView.setText(str);
        return view;
    }

    public static void show(int i2, String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null) {
            Toast toast = b;
            if (toast != null) {
                toast.cancel();
            }
            Context context = confignation.getContext();
            a(context);
            b.setView(a(context, i2, str));
            b.show();
        }
    }
}
