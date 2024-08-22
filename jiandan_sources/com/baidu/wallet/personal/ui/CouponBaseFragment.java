package com.baidu.wallet.personal.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.DialogFragment;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.pulltorefresh.FooterLoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshListView;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.beans.QueryCouponListBean;
import com.baidu.wallet.personal.beans.b;

public abstract class CouponBaseFragment extends DialogFragment {
    public View footer;
    public ImageView footerImage;
    public boolean isInvaild = false;
    public PullToRefreshListView mContainer;
    public View mEmptyView;
    public ListView mListView;
    public WalletBaseEmptyView mReloadView;
    public ViewGroup mRootView = null;
    public MyCouponListActivity myCouponListActivity;
    public ImageView noCouponImage;
    public TextView noCouponLint;
    public TextView noCouponText;

    private void initView() {
        this.mEmptyView = this.mRootView.findViewById(ResUtils.id(getContext(), "bd_wallet_empty_coupon"));
        this.mReloadView = (WalletBaseEmptyView) this.mRootView.findViewById(ResUtils.id(getContext(), "wallet_coupon_reload_view"));
        this.noCouponImage = (ImageView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "wallet_no_coupon"));
        this.noCouponText = (TextView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "bd_wallet_coupon_nocoupon"));
        this.noCouponLint = (TextView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "bd_wallet_coupon_gowalk"));
        PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) this.mRootView.findViewById(ResUtils.id(this.mAct, "pull_refresh_listview"));
        this.mContainer = pullToRefreshListView;
        pullToRefreshListView.setPullLoadEnabled(false);
        this.mContainer.setPullRefreshEnabled(true);
        this.mContainer.setScrollLoadEnabled(true);
        this.mContainer.setBackgroundColor(ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa"));
        this.mContainer.getHeaderLoadingLayout().setRefreshingLabel(ResUtils.getString(this.mAct, "wallet_personal_coupon_list_pull_refreshing"));
        this.mContainer.findViewById(ResUtils.id(this.mAct, "top_divider")).setVisibility(8);
        ListView listView = (ListView) this.mContainer.getRefreshableView();
        this.mListView = listView;
        listView.setBackgroundColor(ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa"));
        this.mListView.setAlwaysDrawnWithCacheEnabled(true);
        this.mListView.setCacheColorHint(ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa"));
        this.mListView.setDividerHeight(0);
        this.mListView.setDivider(new ColorDrawable(ResUtils.getColor(this.mAct, "wallet_base_transparent")));
        ((FooterLoadingLayout) this.mContainer.getFooterLoadingLayout()).showTopDivider(false);
        this.mListView.setFadingEdgeLength(0);
        if (Build.VERSION.SDK_INT >= 3) {
            this.mListView.setFooterDividersEnabled(false);
            this.mListView.setHeaderDividersEnabled(false);
        }
        this.mListView.setSelector(new ColorDrawable(ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa")));
        BaseActivity baseActivity = this.mAct;
        View inflate = View.inflate(baseActivity, ResUtils.layout(baseActivity, "wallet_personal_coupon_list_footer"), (ViewGroup) null);
        this.footer = inflate;
        this.footerImage = (ImageView) inflate.findViewById(ResUtils.id(this.mAct, "footer_image"));
        this.mListView.addFooterView(this.footer);
    }

    public abstract View addCusterview();

    public void configDxmLogo() {
        this.footer.post(new Runnable() {
            public void run() {
                String str;
                StringBuilder sb;
                if (CouponBaseFragment.this.mAct != null) {
                    int bottom = CouponBaseFragment.this.mListView.getBottom();
                    LogUtil.d("coupon", "footer listSize = " + CouponBaseFragment.this.mListView.getChildCount() + " ; listAdapter.count = " + CouponBaseFragment.this.mListView.getAdapter().getCount() + " ; listAdapter.footerViewCount = " + CouponBaseFragment.this.mListView.getFooterViewsCount());
                    int dip2px = DisplayUtils.dip2px(CouponBaseFragment.this.mAct, 120.0f) + DisplayUtils.dip2px(CouponBaseFragment.this.mAct, 25.0f) + CouponBaseFragment.this.footerImage.getHeight();
                    ListView listView = CouponBaseFragment.this.mListView;
                    boolean z = true;
                    View childAt = listView.getChildAt(listView.getChildCount() - 1);
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) CouponBaseFragment.this.footer.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(-1, -2);
                    }
                    if (childAt == null || !childAt.equals(CouponBaseFragment.this.footer)) {
                        layoutParams.height = dip2px;
                    } else {
                        LogUtil.d("coupon", "footer getChild.height = " + childAt.getHeight() + " ; currentBottomView.top = " + childAt.getTop() + " ; currentBottomView.bottom = " + childAt.getBottom());
                        int height = CouponBaseFragment.this.mListView.getHeight();
                        int top = CouponBaseFragment.this.footer.getTop();
                        int height2 = CouponBaseFragment.this.footer.getHeight();
                        int i2 = (height - height2) - top;
                        LogUtil.d("coupon", "footer.height = " + CouponBaseFragment.this.footer.getHeight() + " ; footer whole height = " + height2 + " ; footer.Top = " + CouponBaseFragment.this.footer.getTop() + " ; listViewBottom = " + bottom + " ; listViewHeight = " + height + " ; footer.paddingTOp = " + CouponBaseFragment.this.footer.getPaddingTop() + " ; footer.paddingBottom = " + CouponBaseFragment.this.footer.getPaddingBottom() + " ; margin = " + i2);
                        if (height - CouponBaseFragment.this.footer.getTop() > dip2px) {
                            layoutParams.height = height - CouponBaseFragment.this.footer.getTop();
                            sb = new StringBuilder();
                            str = "footer change Height = ";
                        } else {
                            layoutParams.height = dip2px;
                            sb = new StringBuilder();
                            str = "footer rechange Height = ";
                        }
                        sb.append(str);
                        sb.append(layoutParams.height);
                        LogUtil.d("coupon", sb.toString());
                    }
                    CouponBaseFragment.this.footer.setLayoutParams(layoutParams);
                    CouponBaseFragment.this.footer.setVisibility(0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("footer GetFooter.visible = ");
                    sb2.append(CouponBaseFragment.this.footer.getVisibility() == 0);
                    sb2.append(" ; footer.visible = ");
                    if (CouponBaseFragment.this.footer.getVisibility() != 0) {
                        z = false;
                    }
                    sb2.append(z);
                    sb2.append(" ； footer == ");
                    sb2.append(CouponBaseFragment.this.footer.equals(CouponBaseFragment.this.footer));
                    LogUtil.d("coupon", sb2.toString());
                    LogUtil.d("coupon", "footer height = " + CouponBaseFragment.this.footer.getHeight() + " ; listViewHeight = " + CouponBaseFragment.this.mListView.getHeight() + " ; paddingTOp = " + CouponBaseFragment.this.footer.getPaddingTop() + " ; paddingBottom = " + CouponBaseFragment.this.footer.getPaddingBottom() + " ; footer.top = " + CouponBaseFragment.this.footer.getTop() + " ; footer.bottom = " + CouponBaseFragment.this.footer.getBottom() + " ; listView.bottom = " + CouponBaseFragment.this.mListView.getBottom());
                }
            }
        });
    }

    public void configHasMore(boolean z, String str) {
        this.mContainer.setHasMoreData(z);
        PullToRefreshListView pullToRefreshListView = this.mContainer;
        if (!z) {
            pullToRefreshListView.setScrollLoadEnabled(false);
        } else {
            pullToRefreshListView.setScrollLoadEnabled(true);
        }
        TextView textView = (TextView) this.mContainer.findViewById(ResUtils.id(this.mAct, "bd_wallet_loadmore_text"));
        textView.setTextSize(0, (float) DisplayUtils.dip2px(this.mAct, 13.0f));
        textView.setTextColor(ResUtils.getColor(this.mAct, "coupon_base_blue_cc5d667a"));
        if (TextUtils.isEmpty(str) || z) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
        this.mContainer.showOrHideFootView(0);
        LogUtil.d("pull", "Base Fragment config desc = " + str);
    }

    public void handleEmptyView() {
        this.noCouponImage.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_personal_coupon_empty"));
        this.noCouponText.setText(ResUtils.getString(getContext(), "wallet_couponlist_empty_tip"));
        this.noCouponLint.setText(ResUtils.getString(getContext(), "ebpay_bd_wallet_base_coupon_info"));
    }

    public void hideEmptyView() {
        this.mEmptyView.setVisibility(8);
        this.mReloadView.setVisibility(8);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.myCouponListActivity = (MyCouponListActivity) activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) layoutInflater.inflate(ResUtils.layout(getContext(), "wallet_personal_coupon_fragment_base"), (ViewGroup) null);
            initView();
            if (addCusterview() != null) {
                this.mRootView.addView(addCusterview());
            }
        }
        return this.mRootView;
    }

    public void onResume() {
        LogUtil.d("coupon", "couponBaseFragment onResume");
        super.onResume();
        showEmptyView(-1);
    }

    @SuppressLint({"HandlerLeak"})
    public void queryCoupon(BaseActivity baseActivity, String str, boolean z, int i2, String str2, String str3, String str4, String str5, String str6, CouponBaseFragment couponBaseFragment) {
        if (getActivity() != null) {
            if (z) {
                WalletGlobalUtils.safeShowDialog(baseActivity, -1, "");
            }
            b a = b.a();
            QueryCouponListBean queryCouponListBean = (QueryCouponListBean) a.getBean(baseActivity, 515, str + hashCode());
            queryCouponListBean.a(String.valueOf(i2));
            queryCouponListBean.b(str2);
            queryCouponListBean.c(str3);
            queryCouponListBean.d(str4);
            queryCouponListBean.e(str5);
            queryCouponListBean.f(str6);
            queryCouponListBean.setResponseCallback(couponBaseFragment);
            queryCouponListBean.execBean();
        }
    }

    public abstract void reQueryCoupon();

    public void showEmptyView(int i2) {
        if (this.mEmptyView != null && getActivity() != null) {
            View view = this.footer;
            if (view != null && view.getVisibility() == 0) {
                this.footer.setVisibility(8);
            }
            if (i2 == -1) {
                this.mEmptyView.setVisibility(0);
                this.mReloadView.setVisibility(8);
                handleEmptyView();
                return;
            }
            this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(getActivity(), "wallet_base_no_net"), ResUtils.getString(getActivity(), "wallet_base_no_network"), ResUtils.getString(getActivity(), "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() {
                public void onBtnClick() {
                    CouponBaseFragment.this.reQueryCoupon();
                }
            });
            this.mReloadView.setVisibility(0);
            this.mEmptyView.setVisibility(8);
        }
    }
}
