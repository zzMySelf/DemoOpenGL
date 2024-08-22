package com.baidu.searchbox.account.friendselect;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.socialsharebusiness.R;

public class OpenContactsPermissionDialog extends DialogFragment implements View.OnClickListener {
    private static final int PADDING_HORI = 38;
    private Activity mActivity;
    private Callback mCallback;
    private TextView mNextStepView;

    public interface Callback {
        void onConfig();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    public void setCallback(Callback onClickListener) {
        this.mCallback = onClickListener;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.socialshare_business_no_contact_perm_dialog_style);
    }

    public Dialog getDialog() {
        return super.getDialog();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window = getDialog().getWindow();
        View root = inflater.inflate(R.layout.open_contacts_perm_dialog_layout, (ViewGroup) window.findViewById(16908290), false);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.getDecorView().setPadding(DeviceUtil.ScreenInfo.dp2px(this.mActivity, 38.0f), 0, DeviceUtil.ScreenInfo.dp2px(this.mActivity, 38.0f), 0);
        TextView textView = (TextView) root.findViewById(R.id.tv_ok);
        this.mNextStepView = textView;
        textView.setOnClickListener(this);
        root.findViewById(R.id.contact_perm_dialog_wrapper).setBackground(getResources().getDrawable(com.baidu.android.common.ui.style.R.drawable.dialog_bg_white));
        ((TextView) root.findViewById(R.id.contact_perm_dialog_tip)).setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.black));
        ((TextView) root.findViewById(R.id.contact_perm_dialog_content_tip)).setTextColor(getResources().getColor(R.color.socialshare_business_open_contacts_perm_tip));
        root.findViewById(R.id.divider1).setBackground(new ColorDrawable(getResources().getColor(R.color.socialshare_business_divider_color_classic)));
        this.mNextStepView.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.black));
        this.mNextStepView.setBackground(getResources().getDrawable(com.baidu.android.common.ui.style.R.drawable.alertdialog_button_day_bg_selector));
        return root;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.tv_ok) {
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onConfig();
            }
            dismiss();
        }
    }

    public void dismiss() {
        this.mNextStepView.setOnClickListener((View.OnClickListener) null);
        super.dismiss();
    }
}
