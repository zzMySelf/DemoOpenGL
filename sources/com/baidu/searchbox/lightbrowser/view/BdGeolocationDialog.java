package com.baidu.searchbox.lightbrowser.view;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.lightbrowser.base.R;
import com.baidu.webkit.sdk.GeolocationPermissions;

public class BdGeolocationDialog {
    private final GeolocationPermissions.Callback mCallback;
    private final Context mContext;
    private BoxAlertDialog mGeoDialog;
    private TextView mMessage;
    private final String mOrigin;
    private CheckBox mRemember;

    public BdGeolocationDialog(Context context, String origin, GeolocationPermissions.Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
        this.mOrigin = origin;
        createDialog();
    }

    private void createDialog() {
        View v = View.inflate(this.mContext, R.layout.light_browser_geolocation_dialog, (ViewGroup) null);
        this.mRemember = (CheckBox) v.findViewById(R.id.remember);
        TextView textView = (TextView) v.findViewById(R.id.message_text);
        this.mMessage = textView;
        textView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.box_dialog_message_text_color));
        this.mMessage.setText(getMessage());
        this.mGeoDialog = new BoxAlertDialog.Builder(this.mContext).setTitle(R.string.geolocation_permissions_prompt_title).setView(v).setNegativeButton(R.string.geolocation_permissions_prompt_dont_share, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                BdGeolocationDialog.this.handleButtonClick(false);
            }
        }).setPositiveButton(R.string.geolocation_permissions_prompt_share, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                BdGeolocationDialog.this.handleButtonClick(true);
            }
        }).create();
    }

    /* access modifiers changed from: private */
    public void handleButtonClick(boolean allow) {
        int resId;
        boolean remember = this.mRemember.isChecked();
        if (remember) {
            if (allow) {
                resId = R.string.geolocation_permissions_prompt_toast_allowed;
            } else {
                resId = R.string.geolocation_permissions_prompt_toast_disallowed;
            }
            UniversalToast.makeText(this.mContext.getApplicationContext(), resId).setDuration(3).showToast();
        }
        this.mCallback.invoke(this.mOrigin, allow, remember);
    }

    private String getMessage() {
        Uri uri = Uri.parse(this.mOrigin);
        String message = this.mOrigin;
        if ("http".equals(uri.getScheme())) {
            message = this.mOrigin.substring("http://".length());
        }
        return String.format(this.mContext.getResources().getString(R.string.geolocation_permissions_prompt_message), new Object[]{message});
    }

    public void show() {
        BoxAlertDialog boxAlertDialog = this.mGeoDialog;
        if (boxAlertDialog != null) {
            boxAlertDialog.show();
        }
    }

    public void hide() {
        BoxAlertDialog boxAlertDialog = this.mGeoDialog;
        if (boxAlertDialog != null) {
            boxAlertDialog.hide();
        }
    }
}
