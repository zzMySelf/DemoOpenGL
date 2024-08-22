package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ad;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.SignBank;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignChannelListActivity extends PayBaseBeanActivity implements View.OnClickListener {
    public BankPageAdapter a;
    public ViewPager b;
    public List<View> c = new ArrayList();
    public ListView d;
    public ListView e;
    public final List<SignBank> f = new ArrayList();
    public final List<SignBank> g = new ArrayList();
    public String h = "0";

    /* renamed from: i  reason: collision with root package name */
    public boolean f3621i = false;
    public Activity j;
    public BankListAdapter k;
    public BankListAdapter l;
    public BindFastRequest m;
    public ad n;

    /* renamed from: o  reason: collision with root package name */
    public View f3622o;
    public View p;
    public TextView q;
    public TextView r;
    public ViewGroup s;
    public ViewGroup t;
    public View u;
    public View v;
    public TableLayout w;

    public class BankListAdapter extends BaseAdapter implements SectionIndexer, NoProguard {
        public final LayoutInflater b;
        public List<SignBank> c;

        public class a {
            public LinearLayout b;
            public TextView c;
            public RelativeLayout d;
            public NetImageView e;
            public TextView f;

            public a() {
            }
        }

        public BankListAdapter(List<SignBank> list) {
            this.c = list;
            this.b = LayoutInflater.from(SignChannelListActivity.this.j);
        }

        public int getCount() {
            List<SignBank> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public Object getItem(int i2) {
            if (i2 < this.c.size()) {
                return this.c.get(i2);
            }
            return null;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getPositionForSection(int i2) {
            return -1;
        }

        public int getSectionForPosition(int i2) {
            return 0;
        }

        public Object[] getSections() {
            return null;
        }

        public View getView(final int i2, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null || view.getTag() == null) {
                view = this.b.inflate(ResUtils.layout(SignChannelListActivity.this.j, "wallet_cashdesk_sign_bank_info"), (ViewGroup) null);
                aVar = new a();
                LinearLayout unused = aVar.b = (LinearLayout) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_item_title_layout"));
                TextView unused2 = aVar.c = (TextView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "item_title"));
                NetImageView unused3 = aVar.e = (NetImageView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_logo"));
                TextView unused4 = aVar.f = (TextView) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_name"));
                RelativeLayout unused5 = aVar.d = (RelativeLayout) view.findViewById(ResUtils.id(SignChannelListActivity.this.j, "bank_item_layout"));
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (i2 < BankListAdapter.this.c.size() && SignChannelListActivity.this.f3621i) {
                        StatisticManager.onEventWithValue("sdk_frontpage_idauth_type_choice_bank", SignChannelListActivity.this.b.getCurrentItem() == 0 ? "2" : "1");
                        SignChannelListActivity.this.m.setSubBankCode(((SignBank) BankListAdapter.this.c.get(i2)).bank_code);
                        Intent intent = SignChannelListActivity.this.getIntent();
                        if (intent == null) {
                            intent = new Intent();
                        }
                        intent.putExtra("subbankcode", ((SignBank) BankListAdapter.this.c.get(i2)).bank_code);
                        SignChannelListActivity.this.setResult(-1, intent);
                        SignChannelListActivity.this.finish();
                    }
                }
            });
            if (i2 == getPositionForSection(getSectionForPosition(i2))) {
                aVar.b.setVisibility(0);
            } else {
                aVar.b.setVisibility(8);
            }
            aVar.e.setVisibility(0);
            aVar.e.setImageResource(ResUtils.drawable(SignChannelListActivity.this.j, "wallet_base_banklogo_defult"));
            aVar.e.setImageUrl(this.c.get(i2).bank_url);
            aVar.f.setText(this.c.get(i2).bank_name);
            return view;
        }
    }

    public class BankPageAdapter extends PagerAdapter implements NoProguard {
        public BankPageAdapter() {
        }

        public void destroyItem(View view, int i2, Object obj) {
            ((ViewPager) view).removeView((View) SignChannelListActivity.this.c.get(i2));
        }

        public void finishUpdate(View view) {
        }

        public int getCount() {
            return SignChannelListActivity.this.c.size();
        }

        public Object instantiateItem(View view, int i2) {
            View view2 = (View) SignChannelListActivity.this.c.get(i2);
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            ((ViewPager) view).addView(view2);
            return view2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View view) {
        }
    }

    public class GuidePageChangeListener implements ViewPager.OnPageChangeListener, NoProguard {
        public GuidePageChangeListener() {
        }

        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f, int i3) {
        }

        public void onPageSelected(int i2) {
            if (i2 == 0) {
                SignChannelListActivity.this.a(true);
            } else if (i2 == 1) {
                SignChannelListActivity.this.a(false);
            }
        }
    }

    public void cancleRequest() {
        if (this.n != null) {
            BeanManager.getInstance().removeBean(this.n);
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i2 == this.n.getBeanId()) {
            GlobalUtils.toast(this.j, str);
            finish();
            return;
        }
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
        SignBank[] signBankArr;
        SignBank[] signBankArr2;
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i2 == this.n.getBeanId()) {
            this.c.clear();
            this.a.notifyDataSetChanged();
            SignChannelResponse signChannelResponse = (SignChannelResponse) obj;
            if (!(signChannelResponse == null || (signBankArr2 = signChannelResponse.arr_debit) == null || signBankArr2.length <= 0)) {
                this.c.add(this.e);
                this.g.clear();
                this.g.addAll(Arrays.asList(signChannelResponse.arr_debit));
                BankListAdapter bankListAdapter = this.l;
                if (bankListAdapter != null) {
                    bankListAdapter.notifyDataSetChanged();
                }
            }
            if (!(signChannelResponse == null || (signBankArr = signChannelResponse.arr_credit) == null || signBankArr.length <= 0)) {
                this.c.add(this.d);
                this.f.clear();
                this.f.addAll(Arrays.asList(signChannelResponse.arr_credit));
                BankListAdapter bankListAdapter2 = this.k;
                if (bankListAdapter2 != null) {
                    bankListAdapter2.notifyDataSetChanged();
                }
            }
            TableLayout tableLayout = this.w;
            if (tableLayout != null) {
                tableLayout.setVisibility(0);
                this.b.setVisibility(0);
                this.a.notifyDataSetChanged();
                a(signChannelResponse);
            }
        }
    }

    public void onClick(View view) {
        if (view == this.q) {
            this.b.setCurrentItem(1);
        } else if (view == this.r) {
            this.b.setCurrentItem(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f3621i = getIntent().getExtras().getBoolean("isSelectBank");
        }
        setFlagPaySdk();
        this.j = getActivity();
        c();
        a();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans("SignChannelListActivity");
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    private void b() {
        PayRequestCache.BindCategory bindCategory = PayRequestCache.getInstance().isPaying() ? PayRequestCache.BindCategory.Other : PayRequestCache.BindCategory.Initiative;
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(bindCategory.name());
        this.m = bindFastRequest;
        if (bindFastRequest == null) {
            this.m = new BindFastRequest();
            PayRequestCache.getInstance().addBeanRequestToCache(bindCategory.name(), this.m);
        }
        WalletGlobalUtils.safeShowDialog(this, -1, "");
        if (this.n == null) {
            this.n = (ad) PayBeanFactory.getInstance().getBean((Context) this.j, (int) PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, "SignChannelListActivity");
        }
        this.n.setResponseCallback(this);
        this.n.execBean();
    }

    private void c() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View inflate = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
        this.f3622o = inflate;
        this.d = (ListView) inflate.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
        View inflate2 = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
        this.p = inflate2;
        this.e = (ListView) inflate2.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
        BankListAdapter bankListAdapter = new BankListAdapter(this.f);
        this.k = bankListAdapter;
        this.d.setAdapter(bankListAdapter);
        BankListAdapter bankListAdapter2 = new BankListAdapter(this.g);
        this.l = bankListAdapter2;
        this.e.setAdapter(bankListAdapter2);
    }

    private void a() {
        setContentView(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_list_activity"));
        initActionBar(this.f3621i ? "bd_wallet_own_parent_banks" : "bd_wallet_own_support_banks");
        TextView textView = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_credit"));
        this.q = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        TextView textView2 = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_debit"));
        this.r = textView2;
        AccessibilityUtils.changeRoleDescription(textView2, ResUtils.getString(this, "wallet_access_button"));
        this.s = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_first_tab"));
        this.t = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_second_tab"));
        this.b = (ViewPager) findViewById(ResUtils.id(this.j, "bd_wallet_viewPager"));
        this.u = findViewById(ResUtils.id(this.j, "bd_wallet_credit_tab"));
        this.v = findViewById(ResUtils.id(this.j, "bd_wallet_debit_tab"));
        this.w = (TableLayout) findViewById(ResUtils.id(this.j, "table_layout"));
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        BankPageAdapter bankPageAdapter = new BankPageAdapter();
        this.a = bankPageAdapter;
        this.b.setAdapter(bankPageAdapter);
        this.b.setOnPageChangeListener(new GuidePageChangeListener());
    }

    private void b(boolean z) {
        if (z) {
            this.s.getChildAt(0).setVisibility(4);
            this.s.getChildAt(1).setVisibility(0);
            this.t.getChildAt(0).setVisibility(0);
            this.t.getChildAt(1).setVisibility(4);
            return;
        }
        this.s.getChildAt(0).setVisibility(0);
        this.s.getChildAt(1).setVisibility(4);
        this.t.getChildAt(0).setVisibility(4);
        this.t.getChildAt(1).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_font_text3Color")));
            this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_mainColor")));
            b(false);
            return;
        }
        this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_mainColor")));
        this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_font_text3Color")));
        b(true);
    }

    private void a(SignChannelResponse signChannelResponse) {
        if (signChannelResponse == null) {
            this.v.setVisibility(0);
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            b(true);
            this.b.setCurrentItem(0);
            a(true);
            return;
        }
        SignBank[] signBankArr = signChannelResponse.arr_debit;
        if (signBankArr == null || signBankArr.length <= 0) {
            this.v.setVisibility(8);
            this.s.setVisibility(8);
            b(false);
        } else {
            this.v.setVisibility(0);
            this.s.setVisibility(0);
            b(true);
        }
        SignBank[] signBankArr2 = signChannelResponse.arr_credit;
        if (signBankArr2 == null || signBankArr2.length <= 0) {
            b(false);
            this.u.setVisibility(8);
            this.t.setVisibility(8);
        } else {
            this.u.setVisibility(0);
            this.t.setVisibility(0);
            b(true);
        }
        if (this.v.getVisibility() == 0) {
            this.b.setCurrentItem(0);
            a(true);
            return;
        }
        this.b.setCurrentItem(1);
        a(false);
    }
}
