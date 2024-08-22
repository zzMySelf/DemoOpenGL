package com.baidu.wallet.personal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshListView;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.a.b;
import com.baidu.wallet.personal.beans.QueryCouponListBean;
import com.baidu.wallet.personal.datamodel.BannerList;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import com.duxiaoman.imageloader.listener.IImageLoaderListener;
import com.dxmpay.wallet.utils.StatHelper;
import fe.th.ad.ad;
import fe.th.ad.qw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class UnuseCouponListFragment extends CouponBaseFragment {
    public static final String FRAGMENT_ID = "UnuseCouponListFragment";
    public static final String KEY = "last_coupon_receive_timestamp_key";
    public static final int REQUEST_CODE_COUPON_DETAIL = 1;
    public static final String TAG = UnuseCouponListFragment.class.getSimpleName();
    public static final String TIMESTAMP = "coupon_recive_timestamp";
    public static long mCreateTime = 0;
    public int coupon_receive_timestamp;
    public int firstStartPage;
    public boolean hasAnchor;
    public int last_coupon_receive_timestamp = 0;
    public int mCurrPage = 0;
    public Handler mHandler = new Handler();
    public b mUnuseCouponAdapter = null;
    public MyCouponListActivity myCouponListActivity;
    public a myOnScrollListener;
    public boolean needRefresh = true;
    public int recvCount = 0;

    public class a implements PullToRefreshBase.OnScrollListener2 {
        public SparseArray a = new SparseArray(0);
        public int b;

        /* renamed from: com.baidu.wallet.personal.ui.UnuseCouponListFragment$a$a  reason: collision with other inner class name */
        public class C0174a {
            public int a = 0;
            public int b = 0;

            public C0174a() {
            }
        }

        public a() {
        }

        private int a() {
            int i2 = 0;
            for (int i3 = 0; i3 < this.b; i3++) {
                C0174a aVar = (C0174a) this.a.get(i3);
                if (aVar != null) {
                    i2 += aVar.a;
                }
            }
            UnuseCouponListFragment unuseCouponListFragment = UnuseCouponListFragment.this;
            int dip2px = i2 + (unuseCouponListFragment.firstStartPage * 10 * DisplayUtils.dip2px(unuseCouponListFragment.getActivity(), 139.0f));
            C0174a aVar2 = (C0174a) this.a.get(this.b);
            if (aVar2 == null) {
                aVar2 = new C0174a();
            }
            return dip2px - aVar2.b;
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            com.baidu.wallet.personal.ui.view.a aVar;
            com.baidu.wallet.personal.ui.view.a aVar2;
            this.b = i2;
            View childAt = absListView.getChildAt(0);
            if (childAt != null) {
                C0174a aVar3 = (C0174a) this.a.get(i2);
                if (aVar3 == null) {
                    aVar3 = new C0174a();
                }
                aVar3.a = childAt.getHeight();
                aVar3.b = childAt.getTop();
                this.a.append(i2, aVar3);
                if (a() >= DisplayUtils.dip2px(UnuseCouponListFragment.this.getActivity(), 139.0f) * 10) {
                    MyCouponListActivity myCouponListActivity = UnuseCouponListFragment.this.myCouponListActivity;
                    if (myCouponListActivity != null && (aVar2 = myCouponListActivity.mBackTopView) != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                MyCouponListActivity myCouponListActivity2 = UnuseCouponListFragment.this.myCouponListActivity;
                if (myCouponListActivity2 != null && (aVar = myCouponListActivity2.mBackTopView) != null) {
                    aVar.b();
                }
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 0 && UnuseCouponListFragment.this.mListView.getFirstVisiblePosition() == 0) {
                MyCouponListActivity myCouponListActivity = UnuseCouponListFragment.this.myCouponListActivity;
                if (myCouponListActivity.isClickBackTop) {
                    myCouponListActivity.resetParams();
                    UnuseCouponListFragment unuseCouponListFragment = UnuseCouponListFragment.this;
                    unuseCouponListFragment.mCurrPage = 0;
                    unuseCouponListFragment.queryCoupon(true);
                }
            }
            if (i2 == 0 || i2 == 3) {
                MyCouponListActivity myCouponListActivity2 = UnuseCouponListFragment.this.myCouponListActivity;
                if (myCouponListActivity2 != null) {
                    myCouponListActivity2.mBackTopView.c();
                    return;
                }
                return;
            }
            MyCouponListActivity myCouponListActivity3 = UnuseCouponListFragment.this.myCouponListActivity;
            if (myCouponListActivity3 != null) {
                myCouponListActivity3.mBackTopView.d();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleResFailure(int i2, int i3, String str) {
        setStat("1");
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (i3 == 5003) {
            showEmptyView(i3);
            if (WalletLoginHelper.getInstance().isPassLogin()) {
                WalletLoginHelper.getInstance().handlerWalletError(5003);
                if (!TextUtils.isEmpty(str)) {
                    GlobalUtils.toast(this.mAct, str);
                }
                this.mAct.finish();
            }
        } else if (!(this.mCurrPage == 0 && this.mUnuseCouponAdapter == null) && this.mUnuseCouponAdapter.getCount() > 0) {
            BaseActivity baseActivity = this.mAct;
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mAct, "fp_get_data_fail");
            }
            GlobalUtils.toast(baseActivity, str);
            PullToRefreshListView pullToRefreshListView = this.mContainer;
            if (pullToRefreshListView != null) {
                pullToRefreshListView.onPullDownRefreshComplete();
                this.mContainer.onPullUpRefreshComplete();
            }
        } else {
            showEmptyView(i3);
            PullToRefreshListView pullToRefreshListView2 = this.mContainer;
            if (pullToRefreshListView2 != null) {
                pullToRefreshListView2.setVisibility(4);
            }
        }
    }

    private void loadTopTipImage(CouponListResponse couponListResponse) {
        if (couponListResponse != null && !TextUtils.isEmpty(couponListResponse.remind_pic_url)) {
            ad ad2 = ad.ad();
            qw.C0221qw th2 = qw.th();
            th2.m331if(getActivity());
            th2.m332switch(this.myCouponListActivity.mTopTip);
            th2.ppp(couponListResponse.remind_pic_url);
            th2.when(new IImageLoaderListener() {
                public void onCompleted(Bitmap bitmap) {
                }

                public void onFailure(Exception exc) {
                }
            });
            ad2.rg(th2.pf());
        }
    }

    private void refreshUI(CouponListResponse couponListResponse) {
        if (couponListResponse != null && couponListResponse.checkResponseValidity()) {
            this.mContainer.setVisibility(0);
        }
    }

    private void setAnchorScroll(CouponListResponse couponListResponse, List<CouponList.Coupon> list, int i2) {
        if (list != null && list.size() != 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    i3 = -1;
                    break;
                }
                CouponList.Coupon coupon = list.get(i3);
                if (coupon != null && i2 != -1 && coupon.is_global_top != 1 && i2 == coupon.coupon_type) {
                    break;
                }
                i3++;
            }
            if (list.get(0).local_view_type == 1 && i3 == 1) {
                i3 = 0;
            }
            if (i3 > -1) {
                this.hasAnchor = true;
                if (i3 > 0) {
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < i3; i6++) {
                            View view = adapter.getView(i6, (View) null, this.mListView);
                            view.measure(0, 0);
                            int measuredHeight = view.getMeasuredHeight();
                            if (i6 == i3 - 1) {
                                i5 = measuredHeight;
                            }
                            i4 += measuredHeight;
                        }
                        final int i7 = i4 - (i5 / 2);
                        this.mListView.post(new Runnable() {
                            public void run() {
                                UnuseCouponListFragment.this.mContainer.setScrollLoadEnabled(false);
                                UnuseCouponListFragment.this.mListView.smoothScrollBy(i7, 200);
                                UnuseCouponListFragment.this.mListView.postDelayed(new Runnable() {
                                    public void run() {
                                        UnuseCouponListFragment.this.setScrollListener();
                                        UnuseCouponListFragment.this.mContainer.setScrollLoadEnabled(true);
                                    }
                                }, 210);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            setScrollListener();
        }
    }

    /* access modifiers changed from: private */
    public void setScrollListener() {
        com.baidu.wallet.personal.ui.view.a aVar;
        MyCouponListActivity myCouponListActivity2 = this.myCouponListActivity;
        if (myCouponListActivity2 != null && (aVar = myCouponListActivity2.mBackTopView) != null && aVar.a != null) {
            this.mContainer.setOnScrollListener2(this.myOnScrollListener);
        }
    }

    private void setStat(String str) {
        List asList;
        String str2;
        MyCouponListActivity myCouponListActivity2 = (MyCouponListActivity) getActivity();
        if (myCouponListActivity2 != null) {
            int i2 = myCouponListActivity2.mLastClickId;
            if (i2 == R.id.rela_all) {
                asList = Arrays.asList(new String[]{myCouponListActivity2.mSelectCouponTypeName, str, String.valueOf(System.currentTimeMillis() - myCouponListActivity2.clickClassifyRequestTime), myCouponListActivity2.mSelectCouponType});
                str2 = "Coupon_type_Request";
            } else if (i2 == R.id.rela_unuse) {
                asList = Arrays.asList(new String[]{myCouponListActivity2.mSelectFilterStatusNewName, str, String.valueOf(System.currentTimeMillis() - myCouponListActivity2.clickClassifyRequestTime), myCouponListActivity2.mSelectFilterStatusNew});
                str2 = "Filter_status_Request";
            } else if (i2 == R.id.rela_get_time) {
                asList = Arrays.asList(new String[]{myCouponListActivity2.mSelectCouponSortName, str, String.valueOf(System.currentTimeMillis() - myCouponListActivity2.clickClassifyRequestTime), myCouponListActivity2.mSelectCouponSort});
                str2 = "Coupon_time_Request";
            } else {
                return;
            }
            DXMSdkSAUtils.onEventWithValues(str2, asList);
        }
    }

    private void setTopTip(int i2, String str) {
        com.baidu.wallet.personal.ui.view.a aVar;
        MyCouponListActivity myCouponListActivity2 = this.myCouponListActivity;
        if (myCouponListActivity2 != null && (aVar = myCouponListActivity2.mBackTopView) != null && aVar.a != null && myCouponListActivity2.isClickBackTop) {
            if (this.hasAnchor) {
                myCouponListActivity2.showTopTip(i2, str);
                this.hasAnchor = false;
            }
            this.myCouponListActivity.isClickBackTop = false;
        }
    }

    private void updateData(CouponListResponse couponListResponse) {
        CouponList.Coupon[] couponArr;
        if (couponListResponse != null && this.myCouponListActivity != null) {
            loadTopTipImage(couponListResponse);
            if (this.mCurrPage == 1 && (couponArr = couponListResponse.coupon_list) != null && couponArr.length >= 1) {
                CouponList.Coupon coupon = new CouponList.Coupon();
                BannerList[] bannerListArr = couponListResponse.banner_list;
                if (bannerListArr != null && bannerListArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        BannerList[] bannerListArr2 = couponListResponse.banner_list;
                        if (i2 >= bannerListArr2.length) {
                            break;
                        }
                        if (bannerListArr2[i2] != null && !TextUtils.isEmpty(bannerListArr2[i2].getPicAddr())) {
                            arrayList.add(couponListResponse.banner_list[i2]);
                        }
                        i2++;
                    }
                    if (arrayList.size() > 0) {
                        coupon.local_view_type = 1;
                        coupon.bannerLists = (BannerList[]) arrayList.toArray(new BannerList[arrayList.size()]);
                        this.mUnuseCouponAdapter.a(coupon);
                    }
                }
            }
            CouponList.Coupon[] couponArr2 = couponListResponse.coupon_list;
            if (couponArr2 != null && couponArr2.length >= 1) {
                int i3 = 0;
                while (true) {
                    CouponList.Coupon[] couponArr3 = couponListResponse.coupon_list;
                    if (i3 >= couponArr3.length) {
                        break;
                    }
                    if (couponArr3[i3].coupon_receive_timestamp > this.coupon_receive_timestamp) {
                        this.coupon_receive_timestamp = couponArr3[i3].coupon_receive_timestamp;
                    }
                    this.recvCount++;
                    this.mUnuseCouponAdapter.a(couponListResponse.coupon_list[i3]);
                    i3++;
                }
                if ("1".equals(this.myCouponListActivity.mSelectFilterStatusNew)) {
                    this.mUnuseCouponAdapter.b(0);
                } else {
                    this.mUnuseCouponAdapter.b(1);
                }
                if (this.mCurrPage == 1) {
                    this.firstStartPage = couponListResponse.current_page;
                    this.mListView.setAdapter(this.mUnuseCouponAdapter);
                    setAnchorScroll(couponListResponse, this.mUnuseCouponAdapter.a(), couponListResponse.coupon_scene);
                    setTopTip(couponListResponse.remind_pic_max_count, couponListResponse.remind_pic_url);
                } else {
                    this.mUnuseCouponAdapter.notifyDataSetChanged();
                    setScrollListener();
                }
            }
            int i4 = couponListResponse.current_page;
            if (i4 >= 0) {
                this.mCurrPage = i4;
                this.mCurrPage = i4 + 1;
            }
        }
    }

    public View addCusterview() {
        init();
        return null;
    }

    public void handleEmptyView() {
    }

    public void handleResSuccess(int i2, Object obj, String str) {
        CouponList.Coupon[] couponArr;
        setStat("0");
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (i2 == 515 && this.mAct != null && str != null && (obj instanceof CouponListResponse)) {
            this.mContainer.onPullUpRefreshComplete();
            this.mContainer.onPullDownRefreshComplete();
            CouponListResponse couponListResponse = (CouponListResponse) obj;
            EventBus instance = EventBus.getInstance();
            Objects.requireNonNull(instance);
            EventBus.getInstance().post(new EventBus.Event("showTitleBarRightZone", couponListResponse.code_equity));
            boolean z = true;
            boolean z2 = couponListResponse.coupon_list != null && couponListResponse.total_count > 0;
            if (this.mCurrPage == 0 && ((couponArr = couponListResponse.coupon_list) == null || couponArr.length == 0)) {
                showEmptyView(-1);
                this.mContainer.setVisibility(4);
                MyCouponListActivity myCouponListActivity2 = this.myCouponListActivity;
                if (myCouponListActivity2 != null) {
                    myCouponListActivity2.updateTopTabData(couponListResponse);
                    return;
                }
                return;
            }
            if (z2) {
                hideEmptyView();
                refreshUI(couponListResponse);
                if (this.mCurrPage == 0) {
                    this.mUnuseCouponAdapter.b();
                    this.recvCount = 0;
                }
                this.mCurrPage++;
                updateData(couponListResponse);
                LogUtil.d("queryRecords. handleMessage. list size = " + this.recvCount);
                CouponList.Coupon[] couponArr2 = couponListResponse.coupon_list;
                if (couponArr2 == null || couponArr2.length <= 0 || this.recvCount >= couponListResponse.total_count) {
                    z = false;
                }
                configHasMore(z, couponListResponse.limit_desc);
                configDxmLogo();
            } else {
                showEmptyView(-1);
                this.mContainer.setVisibility(4);
            }
            MyCouponListActivity myCouponListActivity3 = this.myCouponListActivity;
            if (myCouponListActivity3 != null) {
                myCouponListActivity3.updateTopTabData(couponListResponse);
            }
        }
    }

    public void init() {
        Context context = getContext();
        if (this.mUnuseCouponAdapter == null) {
            this.mUnuseCouponAdapter = new b(this.mListView, context);
        }
        this.mListView.setAdapter(this.mUnuseCouponAdapter);
        PassUtil.onCreate();
        this.mContainer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                UnuseCouponListFragment unuseCouponListFragment = UnuseCouponListFragment.this;
                unuseCouponListFragment.mCurrPage = 0;
                unuseCouponListFragment.queryCoupon(false);
            }

            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                UnuseCouponListFragment.this.queryCoupon(false);
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                CouponList.Coupon d;
                BaseActivity baseActivity;
                BaiduWalletDelegate baiduWalletDelegate;
                String str;
                if (UnuseCouponListFragment.this.getActivity() != null && !CheckUtils.isFastDoubleClick() && (d = UnuseCouponListFragment.this.mUnuseCouponAdapter.getItem(i2)) != null && d.need_unlock != 1) {
                    if (d.coupon_receive_timestamp > UnuseCouponListFragment.this.last_coupon_receive_timestamp) {
                        UnuseCouponListFragment unuseCouponListFragment = UnuseCouponListFragment.this;
                        int unused = unuseCouponListFragment.last_coupon_receive_timestamp = unuseCouponListFragment.coupon_receive_timestamp;
                        SharedPreferencesUtils.setParam(UnuseCouponListFragment.this.mAct, UnuseCouponListFragment.TIMESTAMP, UnuseCouponListFragment.KEY, Integer.valueOf(UnuseCouponListFragment.this.last_coupon_receive_timestamp));
                        UnuseCouponListFragment.this.mUnuseCouponAdapter.c(UnuseCouponListFragment.this.last_coupon_receive_timestamp);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("coupon_name", d.coupon_name);
                        jSONObject.put("template_num", d.template_num);
                        jSONObject.put("coupon_num", d.coupon_num);
                        jSONObject.put(StatHelper.CARD_TYPE, d.card_type);
                        jSONObject.put("coupon_list_clicktime", System.currentTimeMillis() - UnuseCouponListFragment.mCreateTime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String[] strArr = new String[5];
                    strArr[0] = jSONObject.toString();
                    strArr[1] = "";
                    int i3 = 2;
                    strArr[2] = d.coupon_type + "";
                    strArr[3] = d.status + "";
                    if (d.isUnlockCoupon()) {
                        i3 = 1;
                    }
                    strArr[4] = String.valueOf(i3);
                    DXMSdkSAUtils.onEventWithValues("CouponListToUseBtnClick", Arrays.asList(strArr));
                    CouponList.Coupon.AppSceneService appSceneService = d.app_scene_service;
                    if (appSceneService != null) {
                        if (appSceneService.f3644android > 0) {
                            BaiduWalletServiceController.getInstance().gotoWalletService((Context) UnuseCouponListFragment.this.mAct, (long) d.app_scene_service.f3644android, "");
                        } else if (!TextUtils.isEmpty(appSceneService.url)) {
                            baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            baseActivity = UnuseCouponListFragment.this.mAct;
                            str = d.app_scene_service.url;
                        }
                        boolean unused2 = UnuseCouponListFragment.this.needRefresh = true;
                    } else if (!TextUtils.isEmpty(d.list_scene_service_label_URL)) {
                        baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                        baseActivity = UnuseCouponListFragment.this.mAct;
                        str = d.list_scene_service_label_URL;
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(UnuseCouponListFragment.this.mAct, MyCouponDetailActivity.class);
                        intent.putExtra("cardType", d.card_type);
                        intent.putExtra("couponNum", d.coupon_num);
                        intent.putExtra("templateNum", d.template_num);
                        UnuseCouponListFragment.this.mAct.startActivityForResult(intent, 1);
                        boolean unused3 = UnuseCouponListFragment.this.needRefresh = true;
                    }
                    baiduWalletDelegate.openH5Module(baseActivity, str, true);
                    boolean unused4 = UnuseCouponListFragment.this.needRefresh = true;
                }
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.myCouponListActivity = (MyCouponListActivity) activity;
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        DXMSdkSAUtils.onEventEndWithValues("CouponListRequest", 1, Arrays.asList(new String[]{QueryCouponListBean.CouponStatus.UNUSE.getVal()}));
        BaseActivity baseActivity = this.mAct;
        if (baseActivity != null) {
            baseActivity.runOnUiThread(new Runnable() {
                public void run() {
                    if (UnuseCouponListFragment.this.mAct != null) {
                        UnuseCouponListFragment.this.handleResFailure(i2, i3, str);
                    }
                }
            });
        }
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        DXMSdkSAUtils.onEventEndWithValues("CouponListRequest", 0, Arrays.asList(new String[]{QueryCouponListBean.CouponStatus.UNUSE.getVal()}));
        this.mHandler.post(new Runnable() {
            public void run() {
                UnuseCouponListFragment.this.handleResSuccess(i2, obj, str);
            }
        });
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.d("coupon", "UnuseCouponListFragment onCreate");
        int intValue = ((Integer) SharedPreferencesUtils.getParam(this.mAct, TIMESTAMP, KEY, 0)).intValue();
        this.last_coupon_receive_timestamp = intValue;
        this.coupon_receive_timestamp = intValue;
        if (this.mUnuseCouponAdapter == null) {
            this.mUnuseCouponAdapter = new b(this.mListView, this.mAct);
        }
        this.mUnuseCouponAdapter.c(this.last_coupon_receive_timestamp);
        if (this.needRefresh) {
            this.mCurrPage = 0;
            this.myOnScrollListener = new a();
            queryCoupon(true);
            this.needRefresh = false;
        }
        mCreateTime = System.currentTimeMillis();
        EventBus.getInstance().register((Object) this, "wallet_coupon_refresh", 0, EventBus.ThreadMode.MainThread);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        LogUtil.d("coupon", "UnuseCouponListFragment onDestroy");
        EventBus.getInstance().unregister(this);
        int i2 = this.coupon_receive_timestamp;
        if (i2 > this.last_coupon_receive_timestamp) {
            this.last_coupon_receive_timestamp = i2;
            SharedPreferencesUtils.setParam(this.mAct, TIMESTAMP, KEY, Integer.valueOf(i2));
            this.mUnuseCouponAdapter.c(this.last_coupon_receive_timestamp);
        }
        BeanManager instance = BeanManager.getInstance();
        instance.removeAllBeans(FRAGMENT_ID + hashCode());
        this.mUnuseCouponAdapter.b();
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"wallet_coupon_refresh".equals(event.mEventKey)) {
            super.onModuleEvent(event);
            return;
        }
        this.mCurrPage = 0;
        queryCoupon(false);
    }

    public void onPause() {
        super.onPause();
        LogUtil.d("coupon", "UnuseCouponListFragment onPause");
    }

    public void onResume() {
        LogUtil.d("coupon", "UnuseCouponListFragment onResume adapter = " + this.mUnuseCouponAdapter);
        super.onResume();
        b bVar = this.mUnuseCouponAdapter;
        if (bVar != null && bVar.getCount() > 0) {
            LogUtil.d("coupon", "UnuseCouponListFragment onResume adapterSize = " + this.mUnuseCouponAdapter.getCount());
            this.mUnuseCouponAdapter.notifyDataSetChanged();
            configDxmLogo();
        }
    }

    public void queryCoupon(boolean z) {
        PullToRefreshListView pullToRefreshListView;
        DXMSdkSAUtils.onEventStart("CouponListRequest");
        if (!this.needRefresh) {
            MyCouponListActivity myCouponListActivity2 = this.myCouponListActivity;
            myCouponListActivity2.mCouponScene = "";
            myCouponListActivity2.mFirstEnter = "0";
        }
        if (this.mCurrPage == 0 && (pullToRefreshListView = this.mContainer) != null) {
            pullToRefreshListView.setOnScrollListener2((PullToRefreshBase.OnScrollListener2) null);
        }
        if (this.mCurrPage == 0) {
            mCreateTime = System.currentTimeMillis();
        }
        MyCouponListActivity myCouponListActivity3 = this.myCouponListActivity;
        if (myCouponListActivity3 != null) {
            queryCoupon(this.mAct, FRAGMENT_ID, z, this.mCurrPage, myCouponListActivity3.mSelectFilterStatusNew, myCouponListActivity3.mSelectCouponType, myCouponListActivity3.mSelectCouponSort, myCouponListActivity3.mCouponScene, myCouponListActivity3.mFirstEnter, this);
        }
    }

    public void reQueryCoupon() {
        this.mCurrPage = 0;
        this.mUnuseCouponAdapter.b();
        LogUtil.d("onActivityCreated. onRefresh. curr page = " + this.mCurrPage);
        queryCoupon(true);
    }
}
