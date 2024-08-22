package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.c;
import com.baidu.wallet.paysdk.beans.f;
import com.baidu.wallet.paysdk.datamodel.BindCardProtocolPreviewResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.a.b;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.storage.HtmlDataCache;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;

public class BindCardProtocolActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener {
    public static final String BANK_CODE = "band_code";
    public static final String CARD_NO = "card_no";
    public static final String FROM_BAND_CARD = "from_band_card";
    public static final String IDENTITY_CODE = "identity_code";
    public static final String IDENTITY_TYPE = "identity_type";
    public static final String MOBILE = "mobile";
    public static final String PROTOCOL_DATA = "protocol_data";
    public static final String PROTOCOL_SNAPSHOT_ID = "snapshotId";
    public static final String TRUE_NAME = "true_name";
    public b a;
    public BindFastRequest b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: i  reason: collision with root package name */
    public String f3611i;
    public boolean j;
    public GetCardInfoResponse.ProtocolPlatformInfo k;
    public String l;

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesh_bind_card_protocol_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void onBackPressed() {
        StatHelper.statServiceEvent(PayStatServiceEvent.CLOSE_PROTOCOL_PAGE);
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        WalletGlobalUtils.DismissLoadingDialog();
        GlobalUtils.toast(getActivity(), str);
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        WalletGlobalUtils.DismissLoadingDialog();
        BindCardProtocolPreviewResponse bindCardProtocolPreviewResponse = (BindCardProtocolPreviewResponse) obj;
        if (bindCardProtocolPreviewResponse != null) {
            String str2 = bindCardProtocolPreviewResponse.protocolHtml;
            if (!TextUtils.isEmpty(str2)) {
                HtmlDataCache.getInstance().setHtml(str2);
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("webview_title_string", this.d);
                intent.putExtra(WebViewActivity.HTML_DATA_FROM_SCENE, "1");
                startActivity(intent);
                return;
            }
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
            return;
        }
        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
        this.c = getIntent().getStringExtra(PROTOCOL_SNAPSHOT_ID);
        this.e = getIntent().getStringExtra("true_name");
        this.g = getIntent().getStringExtra("identity_code");
        this.f = getIntent().getStringExtra(IDENTITY_TYPE);
        this.h = getIntent().getStringExtra("card_no");
        this.f3611i = getIntent().getStringExtra("mobile");
        this.j = getIntent().getBooleanExtra(FROM_BAND_CARD, false);
        this.l = getIntent().getStringExtra(BANK_CODE);
        this.k = (GetCardInfoResponse.ProtocolPlatformInfo) getIntent().getSerializableExtra(PROTOCOL_DATA);
        StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_PROTOCOL_PAGE);
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        this.b = null;
        this.k = null;
        this.a = null;
        BeanManager.getInstance().removeAllBeans("BindCardProtocolActivity");
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void a() {
        GetCardInfoResponse.ProtocolPlatformItem[] protocolPlatformItemArr;
        GetCardInfoResponse.ProtocolPlatformItem[] protocolPlatformItemArr2;
        this.mLeftImg.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_bindcard_protocol_main_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_bindcard_protocol_tip);
        TextView textView3 = (TextView) findViewById(R.id.tv_bindcard_protocol_subtitle);
        ListView listView = (ListView) findViewById(R.id.list_bindcard_protocol);
        GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo = this.k;
        if (protocolPlatformInfo != null) {
            textView.setText(protocolPlatformInfo.main_title);
            textView2.setText(this.k.prompt);
            textView3.setText(this.k.sub_title);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            if (this.j) {
                GetCardInfoResponse.ProtocolPlatformItem[] protocolPlatformItemArr3 = this.k.list;
                if (protocolPlatformItemArr3 != null && protocolPlatformItemArr3.length > 0) {
                    int length = protocolPlatformItemArr3.length;
                    while (i2 < length) {
                        arrayList.add(protocolPlatformItemArr3[i2]);
                        i2++;
                    }
                }
            } else {
                if (!TextUtils.isEmpty(this.l) && (protocolPlatformItemArr2 = this.k.ext_list) != null && protocolPlatformItemArr2.length > 0) {
                    for (GetCardInfoResponse.ProtocolPlatformItem protocolPlatformItem : protocolPlatformItemArr2) {
                        if (this.l.equals(protocolPlatformItem.front_bank_code)) {
                            arrayList.add(protocolPlatformItem);
                        }
                    }
                }
                if (com.baidu.wallet.paysdk.a.b.a() && (protocolPlatformItemArr = this.k.list) != null && protocolPlatformItemArr.length > 0) {
                    int length2 = protocolPlatformItemArr.length;
                    while (i2 < length2) {
                        arrayList.add(protocolPlatformItemArr[i2]);
                        i2++;
                    }
                }
            }
            b bVar = new b(this, (GetCardInfoResponse.ProtocolPlatformItem[]) arrayList.toArray(new GetCardInfoResponse.ProtocolPlatformItem[arrayList.size()]));
            this.a = bVar;
            listView.setAdapter(bVar);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    GetCardInfoResponse.ProtocolPlatformItem a2 = BindCardProtocolActivity.this.a.getItem(i2);
                    if (a2 != null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.CLICK_PROTOCOL_ITEM);
                        String unused = BindCardProtocolActivity.this.d = a2.templateName;
                        BindCardProtocolActivity.this.a(a2.protocolType, a2.templateCode, a2.spId, a2.snapshotId);
                    }
                }
            });
            return;
        }
        BindFastRequest bindFastRequest = this.b;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.b.getmBankInfo().protocol_platform_info != null && this.b.getmBankInfo().protocol_platform_info.list != null) {
            a(textView, textView2, textView3, listView);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        WalletGlobalUtils.showLoadingDialog(this);
        f fVar = (f) PayBeanFactory.getInstance().getBean((Context) this, (int) PayBeanFactory.BEAN_ID_CASHIER_PROTOCOL_PREVIEW, "BindCardProtocolActivity");
        fVar.e(this.e);
        fVar.f(this.f);
        fVar.g(this.g);
        fVar.i(this.f3611i);
        fVar.h(this.h);
        fVar.b(str);
        fVar.d(str3);
        fVar.a(str4);
        fVar.c(str2);
        fVar.setResponseCallback(this);
        fVar.execBean();
    }

    private void a(TextView textView, TextView textView2, TextView textView3, ListView listView) {
        GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo = this.b.getmBankInfo().protocol_platform_info;
        textView.setText(protocolPlatformInfo.main_title);
        textView2.setText(protocolPlatformInfo.prompt);
        textView3.setText(protocolPlatformInfo.sub_title);
        b bVar = new b(this, protocolPlatformInfo.list);
        this.a = bVar;
        listView.setAdapter(bVar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                GetCardInfoResponse.ProtocolPlatformItem a2 = BindCardProtocolActivity.this.a.getItem(i2);
                if (a2 != null) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.CLICK_PROTOCOL_ITEM);
                    String unused = BindCardProtocolActivity.this.d = a2.templateName;
                    BindCardProtocolActivity.this.a(a2.protocolType, a2.templateCode);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        WalletGlobalUtils.showLoadingDialog(this);
        c cVar = (c) PayBeanFactory.getInstance().getBean((Context) this, 605, "BindCardProtocolActivity");
        cVar.d(this.e);
        cVar.e(this.f);
        cVar.f(this.g);
        cVar.h(this.f3611i);
        cVar.g(this.h);
        cVar.b(str);
        cVar.a(this.c);
        cVar.c(str2);
        cVar.setResponseCallback(this);
        cVar.execBean();
    }
}
