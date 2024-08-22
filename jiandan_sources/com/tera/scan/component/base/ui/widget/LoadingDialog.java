package com.tera.scan.component.base.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.aiscan.R;
import java.lang.ref.WeakReference;

public class LoadingDialog extends Dialog {
    public static final String TAG = "LoadingDialog";
    public Animation animationRotate;
    public DialogOnBackKeyDownListener backKeyListener;
    public TextView loadingText = ((TextView) findViewById(R.id.loading_text));
    public ImageView loadingView = ((ImageView) findViewById(R.id.loading_icon));
    public WeakReference<Context> mReference;

    public interface DialogOnBackKeyDownListener {
        void qw();
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            try {
                LoadingDialog.this.loadingView.clearAnimation();
            } catch (Exception e) {
                fe.mmm.qw.i.qw.th("LoadingDialog", "", e);
            }
        }
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.loading_dialog, (ViewGroup) null);
        setCancelable(true);
        setContentView(inflate);
        this.animationRotate = AnimationUtils.loadAnimation(context, R.anim.clockwise_rotate_animation);
        this.animationRotate.setInterpolator(new LinearInterpolator());
        this.mReference = new WeakReference<>(context);
    }

    public static Dialog build(Context context, String str, DialogOnBackKeyDownListener dialogOnBackKeyDownListener) {
        LoadingDialog loadingDialog = new LoadingDialog(context, R.style.BaiduNetDiskDialogTheme);
        loadingDialog.setBackKeyListener(dialogOnBackKeyDownListener);
        loadingDialog.setMessage(str);
        return loadingDialog;
    }

    private boolean canNotShow(Context context) {
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    private void clearAnimation() {
        new Handler().postDelayed(new qw(), 500);
    }

    public static Dialog show(Context context, String str) {
        Dialog build = build(context, str);
        build.setCanceledOnTouchOutside(false);
        build.setCancelable(false);
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            build.show();
        }
        return build;
    }

    private void startAnimation() {
        this.loadingView.startAnimation(this.animationRotate);
    }

    public void dismiss() {
        super.dismiss();
        clearAnimation();
    }

    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode()) {
            fe.mmm.qw.i.qw.ad("LoadingDialog", "loading dialog时按下返回键");
            DialogOnBackKeyDownListener dialogOnBackKeyDownListener = this.backKeyListener;
            if (dialogOnBackKeyDownListener != null) {
                dialogOnBackKeyDownListener.qw();
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void setBackKeyListener(DialogOnBackKeyDownListener dialogOnBackKeyDownListener) {
        this.backKeyListener = dialogOnBackKeyDownListener;
    }

    public void setMessage(String str) {
        TextView textView = this.loadingText;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public static Dialog build(Context context) {
        return new LoadingDialog(context, R.style.BaiduNetDiskDialogTheme);
    }

    public static Dialog build(Context context, String str) {
        LoadingDialog loadingDialog = new LoadingDialog(context, R.style.BaiduNetDiskDialogTheme);
        loadingDialog.setMessage(str);
        return loadingDialog;
    }

    public static Dialog show(Context context, String str, DialogOnBackKeyDownListener dialogOnBackKeyDownListener) {
        Dialog build = build(context, str, dialogOnBackKeyDownListener);
        build.setCanceledOnTouchOutside(false);
        build.setCancelable(false);
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            build.show();
        }
        return build;
    }

    public static Dialog show(Context context, int i2) {
        return show(context, context.getResources().getString(i2));
    }

    public void show() {
        WeakReference<Context> weakReference = this.mReference;
        if (weakReference == null || !canNotShow((Context) weakReference.get())) {
            super.show();
            startAnimation();
            return;
        }
        fe.mmm.qw.i.qw.rg("LoadingDialog", "can not show LoadingDialog : " + this.mReference.get());
    }

    public static Dialog show(Context context) {
        return show(context, (String) null, (DialogOnBackKeyDownListener) null);
    }

    public static Dialog show(Context context, DialogOnBackKeyDownListener dialogOnBackKeyDownListener) {
        return show(context, (String) null, dialogOnBackKeyDownListener);
    }
}
