package com.baidu.searchbox.newpersonalcenter.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator;
import com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.utils.PersonalCenterStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/viewholder/CommonFunHolder;", "Lcom/baidu/searchbox/newpersonalcenter/viewholder/TemplateViewHolder;", "itemView", "Landroid/view/View;", "moduleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "(Landroid/view/View;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mFirstAdapter", "Lcom/baidu/searchbox/newpersonalcenter/commonfun/PersonalCommonFunAdapter;", "mFirstGridView", "Landroid/widget/GridView;", "mIndicator", "Lcom/baidu/searchbox/newpersonalcenter/commonfun/CommonFunIndicator;", "mSecondAdapter", "mSecondGridView", "getModuleActionListener", "()Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "setModuleActionListener", "(Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "checkoutLogin", "", "context", "itemInfo", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "onItemClick", "info", "populate", "data", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunHolder.kt */
public final class CommonFunHolder extends TemplateViewHolder {
    private final Context mContext;
    private PersonalCommonFunAdapter mFirstAdapter;
    private GridView mFirstGridView;
    /* access modifiers changed from: private */
    public CommonFunIndicator mIndicator;
    private PersonalCommonFunAdapter mSecondAdapter;
    private GridView mSecondGridView;
    private ModuleActionListener moduleActionListener;

    public final ModuleActionListener getModuleActionListener() {
        return this.moduleActionListener;
    }

    public final void setModuleActionListener(ModuleActionListener moduleActionListener2) {
        this.moduleActionListener = moduleActionListener2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonFunHolder(View itemView, ModuleActionListener moduleActionListener2) {
        super(itemView.getContext(), itemView, moduleActionListener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.moduleActionListener = moduleActionListener2;
        Context context = itemView.getContext();
        this.mContext = context;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.personal_common_fun_grid_view_layout, (ViewGroup) null).findViewById(R.id.grid_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "from(mContext).inflate(R…dViewById(R.id.grid_view)");
        this.mFirstGridView = (GridView) findViewById;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        PersonalCommonFunAdapter personalCommonFunAdapter = new PersonalCommonFunAdapter(context);
        this.mFirstAdapter = personalCommonFunAdapter;
        this.mFirstGridView.setAdapter(personalCommonFunAdapter);
        View findViewById2 = LayoutInflater.from(context).inflate(R.layout.personal_common_fun_grid_view_layout, (ViewGroup) null).findViewById(R.id.grid_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "from(mContext).inflate(R…dViewById(R.id.grid_view)");
        this.mSecondGridView = (GridView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        PersonalCommonFunAdapter personalCommonFunAdapter2 = new PersonalCommonFunAdapter(context);
        this.mSecondAdapter = personalCommonFunAdapter2;
        this.mSecondGridView.setAdapter(personalCommonFunAdapter2);
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        this.mIndicator = new CommonFunIndicator(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        ConstraintLayout.LayoutParams indicatorParams = new ConstraintLayout.LayoutParams((int) FontSizeHelper.getScaledSize(2, context.getResources().getDimension(R.dimen.personal_common_fun_indicator_width)), (int) FontSizeHelper.getScaledSize(2, context.getResources().getDimension(R.dimen.personal_common_fun_indicator_height)));
        indicatorParams.topToBottom = R.id.viewPager;
        indicatorParams.topMargin = (int) context.getResources().getDimension(R.dimen.personal_common_fun_indicator_margin_top);
        indicatorParams.bottomMargin = context.getResources().getDimensionPixelOffset(R.dimen.personal_common_fun_indicator_margin_bottom);
        indicatorParams.bottomToBottom = R.id.root_layout;
        indicatorParams.leftToLeft = R.id.root_layout;
        indicatorParams.rightToRight = R.id.root_layout;
        this.mIndicator.setLayoutParams(indicatorParams);
        this.mIndicator.setId(R.id.CommonFunIndicator);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r2 = (r2 = r11.getPersonalCenterTabs()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel r11) {
        /*
            r10 = this;
            android.view.View r0 = r10.itemView
            int r1 = com.baidu.searchbox.personalcenter.R.id.customTabView
            android.view.View r0 = r0.findViewById(r1)
            com.baidu.searchbox.newpersonalcenter.tabcontainer.CustomTabView r0 = (com.baidu.searchbox.newpersonalcenter.tabcontainer.CustomTabView) r0
            r1 = 8
            r0.setVisibility(r1)
            r10.data = r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r11 == 0) goto L_0x002c
            java.util.List r2 = r11.getPersonalCenterTabs()
            if (r2 == 0) goto L_0x002c
            java.lang.Object r2 = r2.get(r1)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r2 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r2
            if (r2 == 0) goto L_0x002c
            java.util.List r2 = r2.getBody()
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 == 0) goto L_0x00e8
            int r3 = r2.size()
            r4 = 10
            if (r3 > r4) goto L_0x0079
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r1 = r10.mFirstAdapter
            r1.setCommonFunData(r2)
            android.widget.GridView r1 = r10.mFirstGridView
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r3 = r10.mFirstAdapter
            android.widget.ListAdapter r3 = (android.widget.ListAdapter) r3
            r1.setAdapter(r3)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r1 = r10.mFirstAdapter
            com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$1 r3 = new com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$1
            r3.<init>(r2, r10)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter$OnCommonFunItemClickListener r3 = (com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter.OnCommonFunItemClickListener) r3
            r1.setOnCommonFunItemClickListener(r3)
            android.widget.GridView r1 = r10.mFirstGridView
            r0.add(r1)
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r1 = r10.mIndicator
            android.view.ViewParent r1 = r1.getParent()
            if (r1 == 0) goto L_0x00e8
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r1 = r10.mIndicator
            android.view.ViewParent r1 = r1.getParent()
            if (r1 == 0) goto L_0x0070
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r3 = r10.mIndicator
            android.view.View r3 = (android.view.View) r3
            r1.removeView(r3)
            goto L_0x00e8
        L_0x0070:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type android.view.ViewGroup"
            r1.<init>(r3)
            throw r1
        L_0x0079:
            java.util.List r1 = r2.subList(r1, r4)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r3 = r10.mFirstAdapter
            r3.setCommonFunData(r1)
            android.widget.GridView r3 = r10.mFirstGridView
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r5 = r10.mFirstAdapter
            android.widget.ListAdapter r5 = (android.widget.ListAdapter) r5
            r3.setAdapter(r5)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r3 = r10.mFirstAdapter
            com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$2 r5 = new com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$2
            r5.<init>(r1, r10)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter$OnCommonFunItemClickListener r5 = (com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter.OnCommonFunItemClickListener) r5
            r3.setOnCommonFunItemClickListener(r5)
            int r3 = r2.size()
            java.util.List r3 = r2.subList(r4, r3)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r4 = r10.mSecondAdapter
            r4.setCommonFunData(r3)
            android.widget.GridView r4 = r10.mSecondGridView
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r5 = r10.mSecondAdapter
            android.widget.ListAdapter r5 = (android.widget.ListAdapter) r5
            r4.setAdapter(r5)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter r4 = r10.mSecondAdapter
            com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$3 r5 = new com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$3
            r5.<init>(r3, r10)
            com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter$OnCommonFunItemClickListener r5 = (com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter.OnCommonFunItemClickListener) r5
            r4.setOnCommonFunItemClickListener(r5)
            android.widget.GridView r4 = r10.mFirstGridView
            r0.add(r4)
            android.widget.GridView r4 = r10.mSecondGridView
            r0.add(r4)
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r4 = r10.mIndicator
            android.view.ViewParent r4 = r4.getParent()
            if (r4 != 0) goto L_0x00e8
            android.view.View r4 = r10.itemView
            int r5 = com.baidu.searchbox.personalcenter.R.id.root_layout
            android.view.View r4 = r4.findViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r5 = r10.mIndicator
            android.view.View r5 = (android.view.View) r5
            r4.addView(r5)
            com.baidu.searchbox.newpersonalcenter.tabcontainer.TabViewPager r4 = r10.viewPager
            com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$4 r5 = new com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder$populate$4
            r5.<init>(r10, r11)
            com.baidu.searchbox.newpersonalcenter.viewpager.BaseViewPager$OnPageChangeListener r5 = (com.baidu.searchbox.newpersonalcenter.viewpager.BaseViewPager.OnPageChangeListener) r5
            r4.addOnPageChangeListener(r5)
        L_0x00e8:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            com.baidu.searchbox.newpersonalcenter.tabcontainer.TabViewPager r1 = r10.viewPager
            int r1 = r1.getCurrentItem()
            r11.setCurrentSelectedPosition(r1)
            com.baidu.searchbox.newpersonalcenter.tabcontainer.TabViewPager r1 = r10.viewPager
            com.baidu.searchbox.newpersonalcenter.viewpager.BasePagerAdapter r1 = r1.getAdapter()
            com.baidu.searchbox.newpersonalcenter.tabcontainer.TabPagerAdapter r1 = (com.baidu.searchbox.newpersonalcenter.tabcontainer.TabPagerAdapter) r1
            if (r1 == 0) goto L_0x0155
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            r1.setData(r3)
            r1.notifyDataSetChanged()
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r3 = r10.mIndicator
            android.view.ViewParent r3 = r3.getParent()
            if (r3 == 0) goto L_0x0155
            android.content.Context r3 = r10.mContext
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.searchbox.personalcenter.R.dimen.personal_common_fun_indicator_width
            float r3 = r3.getDimension(r4)
            r4 = 2
            float r3 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r4, r3)
            int r3 = (int) r3
            android.content.Context r5 = r10.mContext
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.baidu.searchbox.personalcenter.R.dimen.personal_common_fun_indicator_height
            float r5 = r5.getDimension(r6)
            float r4 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r4, r5)
            int r4 = (int) r4
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r5 = r10.mIndicator
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            r5.width = r3
            r5.height = r4
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r6 = r10.mIndicator
            r6.setLayoutParams(r5)
            com.baidu.searchbox.newpersonalcenter.commonfun.CommonFunIndicator r6 = r10.mIndicator
            int r7 = r0.size()
            com.baidu.searchbox.newpersonalcenter.tabcontainer.TabViewPager r8 = r10.viewPager
            int r8 = r8.getCurrentItem()
            r9 = 0
            r6.updateForegroundPosition(r7, r8, r9)
        L_0x0155:
            android.view.View r3 = r10.itemView
            android.content.Context r4 = r10.mContext
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.baidu.searchbox.personalcenter.R.drawable.templae_background_corner
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r5)
            r3.setBackground(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.newpersonalcenter.viewholder.CommonFunHolder.populate(com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel):void");
    }

    /* access modifiers changed from: private */
    public final void onItemClick(PersonalCenterTabItemModel info) {
        if (TextUtils.equals(info.getForceLogin(), "1")) {
            Context context = this.mContext;
            Intrinsics.checkNotNullExpressionValue(context, "mContext");
            checkoutLogin(context, info);
            return;
        }
        Router.invoke(this.itemView.getContext(), info.getScheme());
        PersonalCenterStats.doArrivalStats(info.getScheme());
    }

    private final void checkoutLogin(Context context, PersonalCenterTabItemModel itemInfo) {
        Object service = ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (service != null) {
            BoxAccountManager accountManager = (BoxAccountManager) service;
            if (accountManager.isLogin(2)) {
                Router.invoke(context, itemInfo.getScheme());
            } else {
                accountManager.combineLogin(context, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, itemInfo.getUbcType())).setVoiceLogin(true).setLoginMode(5).build(), 2, new CommonFunHolder$$ExternalSyntheticLambda0(accountManager, context, itemInfo));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.account.BoxAccountManager");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkoutLogin$lambda-0  reason: not valid java name */
    public static final void m1649checkoutLogin$lambda0(BoxAccountManager $accountManager, Context $context, PersonalCenterTabItemModel $itemInfo, int it) {
        Intrinsics.checkNotNullParameter($accountManager, "$accountManager");
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($itemInfo, "$itemInfo");
        if ($accountManager.isLogin(2)) {
            Router.invoke($context, $itemInfo.getScheme());
        }
    }
}
