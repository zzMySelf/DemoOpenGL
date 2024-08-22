package com.baidu.searchbox.safeurl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.ext.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;

public class SslCertificateDialog extends AutoOrientationBtnDialog {
    private Builder mBuilder;
    private FrameLayout mContainer;

    protected SslCertificateDialog(Context context) {
        super(context);
    }

    public void setSafeBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    /* access modifiers changed from: protected */
    public View createContentView(ViewGroup parent) {
        View view2 = LayoutInflater.from(this.mContext).inflate(R.layout.view_ssl_certificate_dialog, parent, false);
        this.mContainer = (FrameLayout) view2.findViewById(R.id.ssl_certificate_container);
        bindView();
        return view2;
    }

    private void bindView() {
        Builder builder = this.mBuilder;
        if (builder != null) {
            this.mContainer.addView(builder.contentView);
        }
    }

    public static class Builder extends AutoOrientationBtnDialog.Builder {
        /* access modifiers changed from: private */
        public View contentView;

        public Builder(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public BoxAlertDialog onCreateDialog(Context context) {
            return new SslCertificateDialog(context);
        }

        public Builder setTitle(int titleId) {
            super.setTitle(titleId);
            return this;
        }

        public Builder setContentView(View contentView2) {
            this.contentView = contentView2;
            return this;
        }

        public BoxAlertDialog create() {
            SslCertificateDialog dialog = (SslCertificateDialog) super.create();
            dialog.setSafeBuilder(this);
            return dialog;
        }
    }
}
