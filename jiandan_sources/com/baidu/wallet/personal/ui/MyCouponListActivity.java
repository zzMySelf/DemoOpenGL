package com.baidu.wallet.personal.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.aiscan.R;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.utils.CommonUtils;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import com.baidu.wallet.personal.ui.view.CouponTabHostView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyCouponListActivity extends CouponBaseActivity implements View.OnClickListener {
    public static String COUPON_NAME = "coupon_list";
    public static String COUPON_TOP_TIP_COUNT = "coupon_top_tip_count";
    public static final String EXTRA_DATA = "extra_data";
    public static final String TAG = MyCouponListActivity.class.getSimpleName();
    public static long mCreateTime = 0;
    public ImageView actionBarLine;
    public Animation animation;
    public Animation animation1;
    public BdActionBar bdActionBar;
    public long clickClassifyRequestTime;
    public a couponSortAdapter;
    public a couponTypeAdapter;
    public String extraData = "";
    public a filterStatusAdapter;
    public boolean isClickBackTop;
    public ImageView mBackTop;
    public com.baidu.wallet.personal.ui.view.a mBackTopView;
    public String mCouponScene = "";
    public List<CouponListResponse.CouponSpinner> mCouponSortList = new ArrayList();
    public CouponTabHostView mCouponTabHostView;
    public List<CouponListResponse.CouponSpinner> mCouponTypeList = new ArrayList();
    public List<CouponListResponse.CouponSpinner> mFilterStatusList = new ArrayList();
    public String mFirstEnter = "1";
    public FragmentManager mFragmentManager;
    public GridView mGridviewClassify;
    public ImageView mImageGetTimeArrow;
    public ImageView mImageTypeArrow;
    public ImageView mImageUnuseArrow;
    public int mLastClickId;
    public String mLastCouponScene = "";
    public String mLastSelectCouponSort = "1";
    public String mLastSelectCouponType = "-1";
    public String mLastSelectFilterStatusNew = "1";
    public RelativeLayout mRelaAll;
    public RelativeLayout mRelaGetTime;
    public RelativeLayout mRelaGetTimeArrow;
    public LinearLayout mRelaPop;
    public RelativeLayout mRelaTypeArrow;
    public RelativeLayout mRelaUnuse;
    public RelativeLayout mRelaUnuseArrow;
    public String mSelectCouponSort = "1";
    public String mSelectCouponSortName;
    public String mSelectCouponType = "-1";
    public String mSelectCouponTypeName;
    public String mSelectFilterStatusNew = "1";
    public String mSelectFilterStatusNewName;
    public ObjectAnimator mTipAlphaAnimator;
    public ImageView mTopTip;
    public TextView mTvAllType;
    public TextView mTvGetTime;
    public TextView mTvUnUse;
    public View placeHolder;
    public int showTipCount = 0;

    public class a extends BaseAdapter {
        public List<CouponListResponse.CouponSpinner> a = new ArrayList();

        /* renamed from: com.baidu.wallet.personal.ui.MyCouponListActivity$a$a  reason: collision with other inner class name */
        public class C0173a {
            public TextView a;

            public C0173a() {
            }
        }

        public a(List<CouponListResponse.CouponSpinner> list) {
            this.a = list;
        }

        public int getCount() {
            return this.a.size();
        }

        public Object getItem(int i2) {
            return this.a.get(i2);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            C0173a aVar;
            String str;
            Activity activity;
            TextView textView;
            String str2;
            TextView textView2;
            StringBuilder sb;
            String str3;
            if (view == null) {
                view = LayoutInflater.from(MyCouponListActivity.this).inflate(ResUtils.layout(MyCouponListActivity.this, "coupon_classify_item"), viewGroup, false);
                aVar = new C0173a();
                aVar.a = (TextView) view.findViewById(R.id.tv_cassify);
                view.setTag(aVar);
            } else {
                aVar = (C0173a) view.getTag();
            }
            String str4 = this.a.get(i2).spinner_type_name;
            if (this.a.get(i2).spinner_type_count > 0) {
                if (this.a.get(i2).spinner_type_count > 999) {
                    sb = new StringBuilder();
                    sb.append(str4);
                    str3 = "(999+)";
                } else {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append("(");
                    sb.append(this.a.get(i2).spinner_type_count);
                    str3 = ")";
                }
                sb.append(str3);
                str4 = sb.toString();
            }
            aVar.a.setText(str4);
            if (this.a.get(i2).spinner_show_type == 1) {
                textView = aVar.a;
                activity = MyCouponListActivity.this.getActivity();
                str = "coupon_classify_item_select";
            } else {
                textView = aVar.a;
                activity = MyCouponListActivity.this.getActivity();
                str = "coupon_classify_item_default";
            }
            textView.setBackground(ResUtils.getDrawable(activity, str));
            if (this.a.get(i2).spinner_show_type == 1) {
                textView2 = aVar.a;
                str2 = "#F75348";
            } else {
                textView2 = aVar.a;
                str2 = "#666666";
            }
            textView2.setTextColor(Color.parseColor(str2));
            return view;
        }
    }

    private void doRoateAnimation(View view, ImageView imageView, int i2) {
        int i3;
        if (i2 == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, ResUtils.anim(this, "arrow_roate_contrarotate"));
            this.animation = loadAnimation;
            view.startAnimation(loadAnimation);
            i3 = 1;
        } else if (i2 == 1) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, ResUtils.anim(this, "arrow_roate_contrarotate2"));
            this.animation1 = loadAnimation2;
            view.startAnimation(loadAnimation2);
            i3 = 0;
        } else {
            return;
        }
        imageView.setTag(i3);
    }

    private void init(Bundle bundle) {
        this.mCouponTabHostView = (CouponTabHostView) findViewById(ResUtils.id(this, "coupon_list_tab_host"));
        this.mRelaAll = (RelativeLayout) findViewById(ResUtils.id(this, "rela_all"));
        this.mRelaUnuse = (RelativeLayout) findViewById(ResUtils.id(this, "rela_unuse"));
        this.mRelaGetTime = (RelativeLayout) findViewById(ResUtils.id(this, "rela_get_time"));
        this.mRelaPop = (LinearLayout) findViewById(ResUtils.id(this, "rela_pop"));
        this.mImageTypeArrow = (ImageView) findViewById(ResUtils.id(this, "image_type_arrow"));
        this.placeHolder = findViewById(ResUtils.id(this, "placeHolder"));
        this.mGridviewClassify = (GridView) findViewById(ResUtils.id(this, "gridview_classify"));
        this.mRelaTypeArrow = (RelativeLayout) findViewById(ResUtils.id(this, "rela_type_arrow"));
        this.mRelaUnuseArrow = (RelativeLayout) findViewById(ResUtils.id(this, "rela_unuse_arrow"));
        this.mRelaGetTimeArrow = (RelativeLayout) findViewById(ResUtils.id(this, "rela_get_time_arrow"));
        this.mImageTypeArrow = (ImageView) findViewById(ResUtils.id(this, "image_type_arrow"));
        this.mImageUnuseArrow = (ImageView) findViewById(ResUtils.id(this, "image_unuse_arrow"));
        this.mImageGetTimeArrow = (ImageView) findViewById(ResUtils.id(this, "image_get_time_arrow"));
        this.mTvAllType = (TextView) findViewById(ResUtils.id(this, "tv_all_type"));
        this.mTvUnUse = (TextView) findViewById(ResUtils.id(this, "tv_unuse"));
        this.mTvGetTime = (TextView) findViewById(ResUtils.id(this, "tv_get_time"));
        this.mBackTop = (ImageView) findViewById(ResUtils.id(this, "backTop"));
        this.mTopTip = (ImageView) findViewById(ResUtils.id(this, "top_tip"));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mFragmentManager = supportFragmentManager;
        this.mCouponTabHostView.a(supportFragmentManager);
        this.mRelaAll.setOnClickListener(this);
        this.mRelaUnuse.setOnClickListener(this);
        this.mRelaGetTime.setOnClickListener(this);
        this.placeHolder.setOnClickListener(this);
        this.mBackTop.setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra(EXTRA_DATA);
        this.extraData = stringExtra;
        try {
            int parseInt = Integer.parseInt(stringExtra);
            this.mCouponScene = parseInt + "";
        } catch (Exception unused) {
            this.mCouponScene = "";
        }
        this.couponTypeAdapter = new a(this.mCouponTypeList);
        this.filterStatusAdapter = new a(this.mFilterStatusList);
        this.couponSortAdapter = new a(this.mCouponSortList);
        this.mGridviewClassify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                List<CouponListResponse.CouponSpinner> list = MyCouponListActivity.this.mCouponTypeList;
                if (list != null && list.get(i2) != null) {
                    MyCouponListActivity.this.clickClassifyRequestTime = System.currentTimeMillis();
                    MyCouponListActivity myCouponListActivity = MyCouponListActivity.this;
                    int i3 = myCouponListActivity.mLastClickId;
                    if (i3 == R.id.rela_all) {
                        myCouponListActivity.mTvAllType.setText(myCouponListActivity.mCouponTypeList.get(i2).spinner_type_name);
                        MyCouponListActivity myCouponListActivity2 = MyCouponListActivity.this;
                        myCouponListActivity2.mSelectCouponType = String.valueOf(myCouponListActivity2.mCouponTypeList.get(i2).spinner_type);
                        MyCouponListActivity myCouponListActivity3 = MyCouponListActivity.this;
                        myCouponListActivity3.mSelectCouponTypeName = myCouponListActivity3.mCouponTypeList.get(i2).spinner_type_name;
                    } else if (i3 == R.id.rela_unuse) {
                        myCouponListActivity.mTvUnUse.setText(myCouponListActivity.mFilterStatusList.get(i2).spinner_type_name);
                        MyCouponListActivity myCouponListActivity4 = MyCouponListActivity.this;
                        myCouponListActivity4.mSelectFilterStatusNew = String.valueOf(myCouponListActivity4.mFilterStatusList.get(i2).spinner_type);
                        MyCouponListActivity myCouponListActivity5 = MyCouponListActivity.this;
                        myCouponListActivity5.mSelectFilterStatusNewName = myCouponListActivity5.mFilterStatusList.get(i2).spinner_type_name;
                    } else if (i3 == R.id.rela_get_time) {
                        myCouponListActivity.mSelectCouponSort = String.valueOf(myCouponListActivity.mCouponSortList.get(i2).spinner_type);
                        MyCouponListActivity myCouponListActivity6 = MyCouponListActivity.this;
                        myCouponListActivity6.mTvGetTime.setText(myCouponListActivity6.mCouponSortList.get(i2).spinner_type_name);
                        MyCouponListActivity myCouponListActivity7 = MyCouponListActivity.this;
                        myCouponListActivity7.mSelectCouponSortName = myCouponListActivity7.mCouponSortList.get(i2).spinner_type_name;
                    }
                    MyCouponListActivity.this.requestData();
                    MyCouponListActivity myCouponListActivity8 = MyCouponListActivity.this;
                    myCouponListActivity8.mLastSelectFilterStatusNew = myCouponListActivity8.mSelectFilterStatusNew;
                    myCouponListActivity8.mLastSelectCouponType = myCouponListActivity8.mSelectCouponType;
                    myCouponListActivity8.mLastSelectCouponSort = myCouponListActivity8.mSelectCouponSort;
                    myCouponListActivity8.mLastCouponScene = myCouponListActivity8.mCouponScene;
                    myCouponListActivity8.mRelaPop.setVisibility(8);
                    MyCouponListActivity.this.resetArrowAndText(0);
                }
            }
        });
        this.mBackTopView.a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListView listView;
                if (!CheckUtils.isFastDoubleClick()) {
                    DXMSdkSAUtils.onEvent("Back_to_top_Click");
                    MyCouponListActivity myCouponListActivity = MyCouponListActivity.this;
                    myCouponListActivity.isClickBackTop = true;
                    UnuseCouponListFragment unuseCouponListFragment = (UnuseCouponListFragment) MyCouponListActivity.this.mCouponTabHostView.a(MyCouponListActivity.this.getSupportFragmentManager(), myCouponListActivity.mCouponTabHostView.getCurrentTabTag());
                    if (unuseCouponListFragment != null && (listView = unuseCouponListFragment.mListView) != null) {
                        if (listView.getFirstVisiblePosition() == 0) {
                            MyCouponListActivity.this.resetParams();
                            unuseCouponListFragment.mCurrPage = 0;
                            unuseCouponListFragment.queryCoupon(true);
                            return;
                        }
                        unuseCouponListFragment.mListView.smoothScrollToPosition(0);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void requestData() {
        UnuseCouponListFragment unuseCouponListFragment = (UnuseCouponListFragment) this.mCouponTabHostView.a(getSupportFragmentManager(), this.mCouponTabHostView.getCurrentTabTag());
        unuseCouponListFragment.mCurrPage = 0;
        unuseCouponListFragment.queryCoupon(true);
    }

    /* access modifiers changed from: private */
    public void resetArrowAndText(int i2) {
        this.mTvAllType.setTextColor(Color.parseColor("#222222"));
        this.mTvUnUse.setTextColor(Color.parseColor("#222222"));
        this.mTvGetTime.setTextColor(Color.parseColor("#222222"));
        this.mImageTypeArrow.setColorFilter(Color.parseColor("#222222"));
        this.mImageUnuseArrow.setColorFilter(Color.parseColor("#222222"));
        this.mImageGetTimeArrow.setColorFilter(Color.parseColor("#222222"));
        if (this.mImageTypeArrow.getTag() != null && ((Integer) this.mImageTypeArrow.getTag()).intValue() == 1) {
            doRoateAnimation(this.mRelaTypeArrow, this.mImageTypeArrow, 1);
        }
        if (this.mImageUnuseArrow.getTag() != null && ((Integer) this.mImageUnuseArrow.getTag()).intValue() == 1) {
            doRoateAnimation(this.mRelaUnuseArrow, this.mImageUnuseArrow, 1);
        }
        if (this.mImageGetTimeArrow.getTag() != null && ((Integer) this.mImageGetTimeArrow.getTag()).intValue() == 1) {
            doRoateAnimation(this.mRelaGetTimeArrow, this.mImageGetTimeArrow, 1);
        }
    }

    private void setTopTabText() {
        List<CouponListResponse.CouponSpinner> list = this.mCouponTypeList;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.mCouponTypeList.size(); i2++) {
                if (this.mCouponTypeList.get(i2) != null && this.mCouponTypeList.get(i2).spinner_show_type == 1) {
                    this.mTvAllType.setText(this.mCouponTypeList.get(i2).spinner_type_name);
                }
            }
        }
        List<CouponListResponse.CouponSpinner> list2 = this.mFilterStatusList;
        if (list2 != null && list2.size() > 0) {
            for (int i3 = 0; i3 < this.mFilterStatusList.size(); i3++) {
                if (this.mFilterStatusList.get(i3) != null && this.mFilterStatusList.get(i3).spinner_show_type == 1) {
                    this.mTvUnUse.setText(this.mFilterStatusList.get(i3).spinner_type_name);
                }
            }
        }
        List<CouponListResponse.CouponSpinner> list3 = this.mCouponSortList;
        if (list3 != null && list3.size() > 0) {
            for (int i4 = 0; i4 < this.mCouponSortList.size(); i4++) {
                if (this.mCouponSortList.get(i4) != null && this.mCouponSortList.get(i4).spinner_show_type == 1) {
                    this.mTvGetTime.setText(this.mCouponSortList.get(i4).spinner_type_name);
                }
            }
        }
    }

    private void setViewSelect(TextView textView, ImageView imageView) {
        textView.setTextColor(Color.parseColor("#F75348"));
        imageView.setColorFilter(Color.parseColor("#F75348"));
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initView() {
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "title_bottom_seperator"));
        this.actionBarLine = imageView;
        imageView.setVisibility(8);
        initHomeActionBar("bd_wallet_tab_coupon");
        this.bdActionBar = getBdActionBar();
        this.mBackTopView = new com.baidu.wallet.personal.ui.view.a(findViewById(ResUtils.id(this.mAct, "backTop")));
        PassUtil.onCreate();
        DXMSdkSAUtils.onEventWithValues("CouponListPageShow", (Collection<String>) null);
    }

    public boolean isNeedRefresh(String str, String str2, String str3, String str4) {
        return !TextUtils.equals(str, this.mSelectFilterStatusNew) || !TextUtils.equals(str2, this.mSelectCouponType) || !TextUtils.equals(str3, this.mSelectCouponSort) || !TextUtils.equals(str4, this.mCouponScene);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onClick(View view) {
        GridView gridView;
        a aVar;
        RelativeLayout relativeLayout;
        ImageView imageView;
        int id = view.getId();
        if (this.mLastClickId != id) {
            this.mRelaPop.setVisibility(8);
        }
        resetArrowAndText(id);
        if (id == R.id.rela_all) {
            DXMSdkSAUtils.onEventWithValues("Filter_Button_Click", Arrays.asList(new String[]{"券类型"}));
            this.mTopTip.setVisibility(8);
            if (this.mRelaPop.getVisibility() == 0) {
                this.mRelaPop.setVisibility(8);
                relativeLayout = this.mRelaTypeArrow;
                imageView = this.mImageTypeArrow;
            } else {
                setViewSelect(this.mTvAllType, this.mImageTypeArrow);
                doRoateAnimation(this.mRelaTypeArrow, this.mImageTypeArrow, 0);
                this.mRelaPop.setVisibility(0);
                gridView = this.mGridviewClassify;
                aVar = this.couponTypeAdapter;
                gridView.setAdapter(aVar);
                this.mLastClickId = view.getId();
            }
        } else if (id == R.id.rela_unuse) {
            DXMSdkSAUtils.onEventWithValues("Filter_Button_Click", Arrays.asList(new String[]{"券状态"}));
            this.mTopTip.setVisibility(8);
            if (this.mRelaPop.getVisibility() == 0) {
                this.mRelaPop.setVisibility(8);
                relativeLayout = this.mRelaUnuseArrow;
                imageView = this.mImageUnuseArrow;
            } else {
                setViewSelect(this.mTvUnUse, this.mImageUnuseArrow);
                doRoateAnimation(this.mRelaUnuseArrow, this.mImageUnuseArrow, 0);
                this.mRelaPop.setVisibility(0);
                gridView = this.mGridviewClassify;
                aVar = this.filterStatusAdapter;
                gridView.setAdapter(aVar);
                this.mLastClickId = view.getId();
            }
        } else if (id == R.id.rela_get_time) {
            DXMSdkSAUtils.onEventWithValues("Filter_Button_Click", Arrays.asList(new String[]{"券时间"}));
            this.mTopTip.setVisibility(8);
            if (this.mRelaPop.getVisibility() == 0) {
                this.mRelaPop.setVisibility(8);
                relativeLayout = this.mRelaGetTimeArrow;
                imageView = this.mImageGetTimeArrow;
            } else {
                setViewSelect(this.mTvGetTime, this.mImageGetTimeArrow);
                doRoateAnimation(this.mRelaGetTimeArrow, this.mImageGetTimeArrow, 0);
                this.mRelaPop.setVisibility(0);
                gridView = this.mGridviewClassify;
                aVar = this.couponSortAdapter;
                gridView.setAdapter(aVar);
                this.mLastClickId = view.getId();
            }
        } else {
            if (id == R.id.placeHolder) {
                this.mRelaPop.setVisibility(8);
            }
            this.mLastClickId = view.getId();
        }
        doRoateAnimation(relativeLayout, imageView, 1);
        this.mLastClickId = view.getId();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_list"));
        initView();
        init(bundle);
        EventBus.getInstance().register((Object) this, "showTitleBarRightZone", 0, EventBus.ThreadMode.MainThread);
    }

    public void onDestroy() {
        super.onDestroy();
        b.a = null;
        EventBus.getInstance().unregister(this);
        Animation animation2 = this.animation;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.animation1;
        if (animation3 != null) {
            animation3.cancel();
        }
        com.baidu.wallet.personal.ui.view.a aVar = this.mBackTopView;
        if (aVar != null) {
            aVar.e();
        }
        ObjectAnimator objectAnimator = this.mTipAlphaAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "showTitleBarRightZone".equals(event.mEventKey)) {
            updateBdActionBarRight((CouponListResponse.CodeCoupon) event.mEventObj);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCouponTabHostView.getCurrentTabTag());
        if (findFragmentByTag != null) {
            findFragmentByTag.onHiddenChanged(false);
        }
    }

    public void resetParams() {
        this.mSelectCouponType = "-1";
        this.mSelectCouponSort = "1";
        this.mSelectFilterStatusNew = "1";
        this.mCouponScene = "";
    }

    public void showTopTip(int i2, String str) {
        int intValue = ((Integer) SharedPreferencesUtils.getParam(this, COUPON_NAME, COUPON_TOP_TIP_COUNT + str, 0)).intValue();
        this.showTipCount = intValue;
        if (intValue != i2) {
            this.mTopTip.setVisibility(0);
            this.mTopTip.postDelayed(new Runnable() {
                public void run() {
                    MyCouponListActivity.this.mTopTip.setVisibility(8);
                }
            }, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            this.showTipCount++;
            SharedPreferencesUtils.setParam(this, COUPON_NAME, COUPON_TOP_TIP_COUNT + str, Integer.valueOf(this.showTipCount));
        }
    }

    public void updateBdActionBarRight(final CouponListResponse.CodeCoupon codeCoupon) {
        if (this.bdActionBar != null) {
            if (codeCoupon == null || TextUtils.isEmpty(codeCoupon.desc) || TextUtils.isEmpty(codeCoupon.url)) {
                this.bdActionBar.setRightNotifyZone1Visibility(8);
            } else {
                this.bdActionBar.setRightNotifyText(codeCoupon.desc);
                this.bdActionBar.setRightNotifyZone1Visibility(0);
                this.bdActionBar.setRightNotifyTextColor(-16777216);
                this.bdActionBar.setRightNotifyTextSize(12);
                this.bdActionBar.setRightNotifyImg(ResUtils.getDrawable(getActivity(), "wallet_personal_code_coupon_triangle"));
                CommonUtils.setPressedAlpha(this.bdActionBar.getRightNotifyZone1());
                this.bdActionBar.setRightNotifyZone1ClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BaiduWalletDelegate.getInstance().openH5Module((Context) MyCouponListActivity.this.getActivity(), codeCoupon.url);
                        DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_CLICK, "CouponListPageExchange", (Collection<String>) null);
                    }
                });
            }
            this.bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(MyCouponListActivity.this.getActivity());
                    MyCouponListActivity.this.onBackPressed();
                    DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_CLICK, "CouponListPageBack", (Collection<String>) null);
                }
            });
        }
        BdActionBar bdActionBar2 = this.bdActionBar;
        if (bdActionBar2 != null) {
            bdActionBar2.setRightImgZone2Visibility(0);
        }
    }

    public void updateTopTabData(CouponListResponse couponListResponse) {
        if (couponListResponse != null) {
            ArrayList arrayList = new ArrayList();
            CouponListResponse.CouponSpinner[] couponSpinnerArr = couponListResponse.coupon_type_list;
            int i2 = 0;
            if (couponSpinnerArr != null && couponSpinnerArr.length > 0) {
                int i3 = 0;
                while (true) {
                    CouponListResponse.CouponSpinner[] couponSpinnerArr2 = couponListResponse.coupon_type_list;
                    if (i3 >= couponSpinnerArr2.length) {
                        break;
                    }
                    CouponListResponse.CouponSpinner couponSpinner = couponSpinnerArr2[i3];
                    if (couponSpinner != null && !TextUtils.isEmpty(couponSpinner.spinner_type_name)) {
                        arrayList.add(couponSpinner);
                    }
                    i3++;
                }
            }
            List<CouponListResponse.CouponSpinner> list = this.mCouponTypeList;
            if (list != null) {
                list.clear();
            } else {
                this.mCouponTypeList = new ArrayList();
            }
            this.mCouponTypeList.addAll(arrayList);
            a aVar = this.couponTypeAdapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            ArrayList arrayList2 = new ArrayList();
            CouponListResponse.CouponSpinner[] couponSpinnerArr3 = couponListResponse.filter_status_new_list;
            if (couponSpinnerArr3 != null && couponSpinnerArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    CouponListResponse.CouponSpinner[] couponSpinnerArr4 = couponListResponse.filter_status_new_list;
                    if (i4 >= couponSpinnerArr4.length) {
                        break;
                    }
                    CouponListResponse.CouponSpinner couponSpinner2 = couponSpinnerArr4[i4];
                    if (couponSpinner2 != null && !TextUtils.isEmpty(couponSpinner2.spinner_type_name)) {
                        arrayList2.add(couponSpinner2);
                    }
                    i4++;
                }
            }
            List<CouponListResponse.CouponSpinner> list2 = this.mFilterStatusList;
            if (list2 != null) {
                list2.clear();
            } else {
                this.mFilterStatusList = new ArrayList();
            }
            this.mFilterStatusList.addAll(arrayList2);
            a aVar2 = this.filterStatusAdapter;
            if (aVar2 != null) {
                aVar2.notifyDataSetChanged();
            }
            ArrayList arrayList3 = new ArrayList();
            CouponListResponse.CouponSpinner[] couponSpinnerArr5 = couponListResponse.coupon_sort_list;
            if (couponSpinnerArr5 != null && couponSpinnerArr5.length > 0) {
                while (true) {
                    CouponListResponse.CouponSpinner[] couponSpinnerArr6 = couponListResponse.coupon_sort_list;
                    if (i2 >= couponSpinnerArr6.length) {
                        break;
                    }
                    CouponListResponse.CouponSpinner couponSpinner3 = couponSpinnerArr6[i2];
                    if (couponSpinner3 != null && !TextUtils.isEmpty(couponSpinner3.spinner_type_name)) {
                        arrayList3.add(couponSpinner3);
                    }
                    i2++;
                }
            }
            List<CouponListResponse.CouponSpinner> list3 = this.mCouponSortList;
            if (list3 != null) {
                list3.clear();
            } else {
                this.mCouponSortList = new ArrayList();
            }
            this.mCouponSortList.addAll(arrayList3);
            a aVar3 = this.couponSortAdapter;
            if (aVar3 != null) {
                aVar3.notifyDataSetChanged();
            }
            setTopTabText();
        }
    }
}
