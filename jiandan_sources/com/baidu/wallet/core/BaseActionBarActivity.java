package com.baidu.wallet.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.WalletGlobalUtils;

public abstract class BaseActionBarActivity extends BeanActivity {
    public BdActionBar mBdActionBar;
    public FrameLayout mContentLayout;
    public View mContentView;
    public IErrorViewDelegate mErrorViewDelegate;

    public class ErrorViewDelegate implements IErrorViewDelegate {
        public WalletBaseEmptyView a;

        public ErrorViewDelegate() {
            WalletBaseEmptyView walletBaseEmptyView = new WalletBaseEmptyView(BaseActionBarActivity.this.getActivity());
            this.a = walletBaseEmptyView;
            walletBaseEmptyView.setVisibility(8);
            BaseActionBarActivity.this.mContentLayout.addView(this.a);
        }

        public void showContentView() {
            BaseActionBarActivity.this.mContentView.setVisibility(0);
            this.a.setVisibility(8);
        }

        public void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            this.a.setVisibility(0);
            BaseActionBarActivity.this.mContentView.setVisibility(8);
            this.a.showTip1_Tip2_NextBtn(ResUtils.drawable(BaseActionBarActivity.this.mAct, "wallet_base_no_net"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(BaseActionBarActivity.this.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
        }

        public void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            this.a.setVisibility(0);
            BaseActionBarActivity.this.mContentView.setVisibility(8);
            this.a.showTip1_NextBtn(ResUtils.drawable(BaseActionBarActivity.this.mAct, "wallet_base_no_net"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network"), ResUtils.getString(BaseActionBarActivity.this.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
        }
    }

    public interface IErrorViewDelegate {
        void showContentView();

        void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);

        void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);
    }

    private IErrorViewDelegate createErrorViewDelegate() {
        return new ErrorViewDelegate();
    }

    public void closeLoadingDialog() {
        WalletGlobalUtils.safeDismissDialog(this, 0);
    }

    public <T> T findViewByIdExt(int i2) {
        return findViewById(i2);
    }

    public BdActionBar getBdActionBar() {
        return this.mBdActionBar;
    }

    public FrameLayout getContentLayout() {
        return this.mContentLayout;
    }

    public IErrorViewDelegate getErrorViewDelegate() {
        return this.mErrorViewDelegate;
    }

    public abstract void init(View view);

    public void initBdActionBar() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BaseActionBarActivity.this.getActivity());
                    BaseActionBarActivity.this.onBackPressed();
                }
            });
        }
    }

    public boolean isStrEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    public abstract int onBindLayoutId();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(DxmApplicationContextImpl.getApplicationContext(this), "wallet_base_title_activity"));
        this.mBdActionBar = (BdActionBar) findViewByIdExt(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "bdactionbar"));
        this.mContentLayout = (FrameLayout) findViewByIdExt(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "content_frame_layout"));
        View inflate = LayoutInflater.from(this).inflate(onBindLayoutId(), (ViewGroup) null);
        this.mContentView = inflate;
        this.mContentLayout.addView(inflate);
        initBdActionBar();
        init(this.mContentLayout);
        this.mErrorViewDelegate = createErrorViewDelegate();
    }

    public void showLoadingDialog() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
    }

    public void showThemeDialog(CharSequence charSequence, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final PromptDialog promptDialog = new PromptDialog(this.mAct);
        promptDialog.setMessage(charSequence);
        promptDialog.setNegativeBtn(ResUtils.string(this.mAct, "ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "wallet_varify_quick"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }
}
