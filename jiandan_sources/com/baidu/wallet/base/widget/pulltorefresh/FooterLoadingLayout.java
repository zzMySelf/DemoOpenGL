package com.baidu.wallet.base.widget.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;

public class FooterLoadingLayout extends LoadingLayout {
    public ProgressBar a;
    public TextView b;
    public CharSequence c;
    public CharSequence d;

    public FooterLoadingLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.a = (ProgressBar) findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"));
        this.b = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_loadmore_text"));
        setState(LoadingLayout.State.RESET);
    }

    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_base_load_more"), (ViewGroup) null);
    }

    public int getContentSize() {
        return ResUtils.dimen(getContext(), "wallet_base_footer_height");
    }

    public void onNoMoreData() {
        this.b.setVisibility(0);
        if (TextUtils.isEmpty(this.d)) {
            this.b.setText(ResUtils.getString(getContext(), "wallet_base_no_more"));
        } else {
            this.b.setText(this.d);
        }
    }

    public void onRefreshing() {
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        if (TextUtils.isEmpty(this.c)) {
            this.b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
        } else {
            this.b.setText(this.c);
        }
    }

    public void onReset() {
        if (TextUtils.isEmpty(this.c)) {
            this.b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
        } else {
            this.b.setText(this.c);
        }
    }

    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        this.a.setVisibility(8);
        this.b.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public void setNoMoreDataLabel(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.d = charSequence;
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.c = charSequence;
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public void showTopDivider(boolean z) {
        View findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"));
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
