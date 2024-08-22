package fe.mmm.qw.th.qw.rg.de;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.manager.DialogCtrListener;
import com.tera.scan.framework.kernel.BaseApplication;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public Button f8336ad;

    /* renamed from: de  reason: collision with root package name */
    public Button f8337de;

    /* renamed from: fe  reason: collision with root package name */
    public Dialog f8338fe;
    public LinearLayout qw;

    /* renamed from: rg  reason: collision with root package name */
    public DialogCtrListener f8339rg;

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            DialogCtrListener dialogCtrListener = de.this.f8339rg;
            if (dialogCtrListener != null) {
                dialogCtrListener.qw();
            }
            de.this.f8338fe.dismiss();
        }
    }

    public void ad(boolean z) {
        Dialog dialog = this.f8338fe;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void de(DialogCtrListener dialogCtrListener) {
        this.f8339rg = dialogCtrListener;
    }

    public final void fe(Activity activity) {
        this.f8336ad.setTextColor(activity.getResources().getColor(fe.mmm.qw.de.de.qw.qw.qw(BaseApplication.getInstance()) ? R.color.normal_dialog_confirm_button_selector_youth : R.color.normal_dialog_confirm_button_selector));
    }

    public Dialog qw(Activity activity, String str, String str2) {
        this.f8338fe = new Dialog(activity, R.style.BaiduNetDiskDialogTheme);
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.dialog_base_layout, (ViewGroup) null);
        this.f8338fe.setContentView(inflate);
        this.qw = (LinearLayout) inflate.findViewById(R.id.loadingBox);
        this.f8337de = (Button) inflate.findViewById(R.id.dialog_button_cancel);
        this.f8336ad = (Button) this.f8338fe.findViewById(R.id.dialog_button_ok);
        if (TextUtils.isEmpty(str2)) {
            this.f8336ad.setVisibility(8);
        } else {
            this.f8336ad.setText(str2);
            fe(activity);
            this.f8336ad.setOnClickListener(new qw());
        }
        TextView textView = (TextView) this.f8338fe.findViewById(R.id.txt_confirmdialog_title);
        if (TextUtils.isEmpty(str)) {
            ((View) textView.getParent()).setVisibility(8);
        } else {
            textView.setText(str);
        }
        this.f8338fe.setCanceledOnTouchOutside(false);
        return this.f8338fe;
    }
}
