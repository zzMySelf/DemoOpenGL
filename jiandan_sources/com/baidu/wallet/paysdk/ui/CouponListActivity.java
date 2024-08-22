package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.CouponListPresenter;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;

public class CouponListActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public ViewGroup a;
    public View b;
    public CouponListContract.Presenter mPresenter;

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_coupon_list"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
    }

    public void initData() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        this.mPresenter.calcPayamount((CouponListPresenter.a) null);
    }

    public void initView() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        this.mRightTxt.setVisibility(8);
        TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "couponlist_title"));
        this.mTitle = textView;
        textView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_ebpay_white"));
        this.mTitle.setText(ResUtils.getString(getActivity(), "ebpay_select_coupon"));
        this.a = (ViewGroup) findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_container"));
    }

    public void onBackPressed() {
        if (this.mHalfScreenContainer.isClickable()) {
            EventBus instance = EventBus.getInstance();
            EventBus instance2 = EventBus.getInstance();
            instance.getClass();
            instance2.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", (Object) null));
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CouponListPresenter couponListPresenter = new CouponListPresenter(this);
        this.mPresenter = couponListPresenter;
        couponListPresenter.onCreate(bundle);
        initView();
        initData();
    }

    public void onDestroy() {
        super.onDestroy();
        CouponListContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
            this.mPresenter = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        CouponListContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void returnToPreviousPage() {
        finishWithoutAnim();
    }

    public void revertItemView() {
        View view = this.b;
        if (view != null) {
            a((ProgressBar) view.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar")), (ImageView) this.b.findViewById(ResUtils.id(this, "coupon_select")), false);
        }
        this.b = null;
    }

    public void setPageClickable(boolean z) {
        this.mHalfScreenContainer.setClickable(z);
    }

    public void showLoading(int i2) {
        WalletGlobalUtils.safeShowDialog(this, i2, "");
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    public void reFreshUI(ArrayList<CouponListPresenter.a> arrayList) {
        if (arrayList != null) {
            this.b = null;
            setPageClickable(true);
            this.a.removeAllViews();
            int dimension = (int) ResUtils.getDimension(this.mAct, "bd_wallet_coupon_height");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                View a2 = a(arrayList.get(i2));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimension);
                if (i2 == arrayList.size() - 1) {
                    layoutParams.bottomMargin = DisplayUtils.dip2px(this, 5.0f);
                }
                a2.setLayoutParams(layoutParams);
                this.a.addView(a2);
            }
        }
    }

    public void setPresenter(CouponListContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /* access modifiers changed from: private */
    public void a(ProgressBar progressBar, ImageView imageView, boolean z) {
        if (z) {
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
            return;
        }
        progressBar.setVisibility(8);
        imageView.setVisibility(0);
    }

    private View a(CouponListPresenter.a aVar) {
        final View inflate = LayoutInflater.from(this).inflate(ResUtils.layout(this, "wallet_cashdesk_coupon_item_view"), (ViewGroup) null);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar"));
        final ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(this, "coupon_select"));
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View unused = CouponListActivity.this.b = inflate;
                CouponListPresenter.a aVar = (CouponListPresenter.a) view.getTag();
                if (aVar.g) {
                    StatisticManager.onEvent("switchCoupon");
                    CouponListActivity.this.a(progressBar, imageView, true);
                    CouponListActivity.this.mPresenter.calcPayamount(aVar);
                    return;
                }
                GlobalUtils.toast(CouponListActivity.this, aVar.f);
            }
        });
        a(progressBar, imageView, false);
        ((NetImageView) inflate.findViewById(ResUtils.id(this, "ebpay_coupon_logo"))).setImageUrl(aVar.a);
        ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_name"))).setText(aVar.d);
        ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_tip"))).setText(aVar.e);
        TextView textView = (TextView) inflate.findViewById(ResUtils.id(this, "coupon_disable_reason"));
        if (!TextUtils.isEmpty(aVar.f)) {
            textView.setVisibility(0);
            textView.setText(aVar.f);
        } else {
            textView.setVisibility(8);
        }
        if (aVar.g) {
            imageView.setSelected(aVar.h);
            inflate.setTag(aVar);
            a(inflate, true);
        } else {
            imageView.setSelected(false);
            inflate.setTag(aVar);
            a(inflate, false);
        }
        return inflate;
    }

    private void a(View view, boolean z) {
        if (z) {
            ViewHelper.setAlpha(view, 1.0f);
        } else {
            ViewHelper.setAlpha(view, 0.4f);
        }
    }
}
