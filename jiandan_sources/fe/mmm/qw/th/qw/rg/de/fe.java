package fe.mmm.qw.th.qw.rg.de;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.manager.DialogCtrListener;

public class fe extends de {

    public static abstract class ad {
        public abstract void ad();

        public abstract void qw();
    }

    public class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Dialog f8341ad;

        public qw(Dialog dialog) {
            this.f8341ad = dialog;
        }

        public void onClick(View view) {
            DialogCtrListener dialogCtrListener = fe.this.f8339rg;
            if (dialogCtrListener != null) {
                dialogCtrListener.ad();
            }
            this.f8341ad.dismiss();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static /* synthetic */ void m1003if(Dialog dialog, ad adVar, View view) {
        dialog.dismiss();
        if (adVar != null) {
            adVar.ad();
        }
    }

    public static /* synthetic */ void pf(Dialog dialog, ad adVar, View view) {
        dialog.dismiss();
        if (adVar != null) {
            adVar.qw();
        }
    }

    public Dialog i(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnShowListener onShowListener) {
        Dialog qw2 = qw(activity, str, str3);
        Button button = (Button) qw2.findViewById(R.id.dialog_button_cancel);
        if (z) {
            if (TextUtils.isEmpty(str4)) {
                str4 = activity.getString(17039360);
            }
            button.setText(str4);
            button.setOnClickListener(new qw(qw2));
        } else {
            button.setVisibility(8);
        }
        TextView textView = (TextView) qw2.findViewById(R.id.text_content);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(str2);
        if (!activity.isFinishing()) {
            o(activity);
            if (onShowListener != null) {
                qw2.setOnShowListener(onShowListener);
            }
            try {
                qw2.show();
            } catch (Exception e) {
                fe.mmm.qw.i.qw.th("DialogBuilder", e.getMessage(), e);
            }
        }
        return qw2;
    }

    public final void o(Activity activity) {
        Dialog dialog = this.f8338fe;
        if (dialog != null) {
            Button button = (Button) dialog.findViewById(R.id.dialog_button_cancel);
            Button button2 = (Button) this.f8338fe.findViewById(R.id.dialog_button_center);
            Button button3 = (Button) this.f8338fe.findViewById(R.id.dialog_button_ok);
            if (button.getVisibility() == 0 && button2.getVisibility() == 8 && button3.getVisibility() == 8) {
                button.setTextColor(ContextCompat.getColorStateList(activity, R.color.normal_dialog_confirm_button_selector));
            }
        }
    }

    public Dialog rg(Context context, String str, String str2, String str3, String str4, ad adVar) {
        if (context == null) {
            return null;
        }
        Dialog dialog = new Dialog(context, R.style.BaiduNetDiskDialogTheme);
        try {
            dialog.setContentView(LayoutInflater.from(context).inflate(R.layout.dialog_base_alert_layout, (ViewGroup) null));
            TextView textView = (TextView) dialog.findViewById(R.id.tv_dialog_alert_title);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            TextView textView2 = (TextView) dialog.findViewById(R.id.tv_dialog_alert_content);
            if (TextUtils.isEmpty(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(str2);
            }
            TextView textView3 = (TextView) dialog.findViewById(R.id.tv_dialog_alert_cancel);
            if (TextUtils.isEmpty(str3)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(str3);
                textView3.setOnClickListener(new ad(dialog, adVar));
            }
            TextView textView4 = (TextView) dialog.findViewById(R.id.tv_dialog_alert_confirm);
            if (TextUtils.isEmpty(str4)) {
                textView4.setVisibility(8);
            } else {
                textView4.setText(str4);
                textView4.setOnClickListener(new qw(dialog, adVar));
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                dialog.findViewById(R.id.v_dialog_buttons_gap).setVisibility(8);
            }
            return dialog;
        } catch (Exception unused) {
            return null;
        }
    }

    public Dialog th(Activity activity) {
        if (activity == null) {
            return null;
        }
        Dialog dialog = new Dialog(activity, R.style.BaiduNetDiskDialogTheme);
        dialog.setContentView(((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.dialog_loading_without_text, (ViewGroup) null));
        Animation loadAnimation = AnimationUtils.loadAnimation(activity.getApplicationContext(), R.anim.clockwise_rotate_animation);
        loadAnimation.setInterpolator(new LinearInterpolator());
        dialog.setCanceledOnTouchOutside(false);
        dialog.findViewById(R.id.loading_image).startAnimation(loadAnimation);
        return dialog;
    }

    public Dialog uk(Activity activity, int i2, int i3, int i4, int i5) {
        String str = "";
        String string = i2 != -1 ? activity.getString(i2) : str;
        String string2 = i3 != -1 ? activity.getString(i3) : str;
        String string3 = i4 != -1 ? activity.getString(i4) : str;
        if (i5 != -1) {
            str = activity.getString(i5);
        }
        return i(activity, string, string2, string3, str, true, (DialogInterface.OnShowListener) null);
    }

    public Dialog yj(Activity activity, String str, String str2, String str3) {
        return i(activity, str, str2, str3, (String) null, false, (DialogInterface.OnShowListener) null);
    }
}
