package com.baidu.searchbox.aipersonal.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.aipersonal.AiPersonalUtils;
import com.baidu.searchbox.aipersonal.data.FavorHistoryModel;
import com.baidu.searchbox.aipersonal.widgets.PersonalAiCloseView;
import com.baidu.searchbox.aipersonal.widgets.PersonalAiVideoArrowImageView;
import com.baidu.searchbox.aipersonal.widgets.TouchPressStateListener;
import com.baidu.searchbox.bookmark.BookmarkUtil;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListenerAdapter;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001:\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010<\u001a\u00020=H\u0002J\u0012\u0010>\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020\u0002H\u0017J\b\u0010B\u001a\u00020=H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b4\u0010(R\u001b\u00106\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b7\u0010(R\u0010\u00109\u001a\u00020:X\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/aipersonal/viewholder/PersonalAiSingleUrlHolder;", "Lcom/baidu/searchbox/aipersonal/viewholder/AiBaseViewHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/PersonalCenterBaseModel;", "itemView", "Landroid/view/View;", "listener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListenerAdapter;", "(Landroid/view/View;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListenerAdapter;)V", "TAG", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isDefaultEmptyTitle", "", "getListener", "()Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListenerAdapter;", "setListener", "(Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListenerAdapter;)V", "mData", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "mFavorHisModel", "Lcom/baidu/searchbox/aipersonal/data/FavorHistoryModel;", "mRightCloseView", "Lcom/baidu/searchbox/aipersonal/widgets/PersonalAiCloseView;", "getMRightCloseView", "()Lcom/baidu/searchbox/aipersonal/widgets/PersonalAiCloseView;", "mRightCloseView$delegate", "mRootView", "Landroid/widget/LinearLayout;", "getMRootView", "()Landroid/widget/LinearLayout;", "mRootView$delegate", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "mTitle$delegate", "mUrlImage", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "getMUrlImage", "()Lcom/baidu/searchbox/ui/BdBaseImageView;", "mUrlImage$delegate", "mUrlLayout", "getMUrlLayout", "()Landroid/view/View;", "mUrlLayout$delegate", "mUrlTitle", "getMUrlTitle", "mUrlTitle$delegate", "mUrlWebSite", "getMUrlWebSite", "mUrlWebSite$delegate", "urlCallback", "com/baidu/searchbox/aipersonal/viewholder/PersonalAiSingleUrlHolder$urlCallback$1", "Lcom/baidu/searchbox/aipersonal/viewholder/PersonalAiSingleUrlHolder$urlCallback$1;", "jumpToMore", "", "openFavorHisItem", "favorHisModel", "populate", "data", "updateContent", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiSingleUrlHolder.kt */
public final class PersonalAiSingleUrlHolder extends AiBaseViewHolder<PersonalCenterBaseModel> {
    /* access modifiers changed from: private */
    public final String TAG = "PersonalSingleUrlHolder";
    private final Lazy context$delegate;
    private boolean isDefaultEmptyTitle;
    private ModuleActionListenerAdapter listener;
    /* access modifiers changed from: private */
    public PersonalCenterTabModel mData;
    /* access modifiers changed from: private */
    public FavorHistoryModel mFavorHisModel;
    private final Lazy mRightCloseView$delegate;
    private final Lazy mRootView$delegate;
    private final Lazy mTitle$delegate;
    private final Lazy mUrlImage$delegate;
    private final Lazy mUrlLayout$delegate;
    private final Lazy mUrlTitle$delegate;
    private final Lazy mUrlWebSite$delegate;
    private final PersonalAiSingleUrlHolder$urlCallback$1 urlCallback;

    public final ModuleActionListenerAdapter getListener() {
        return this.listener;
    }

    public final void setListener(ModuleActionListenerAdapter moduleActionListenerAdapter) {
        this.listener = moduleActionListenerAdapter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalAiSingleUrlHolder(View itemView, ModuleActionListenerAdapter listener2) {
        super(itemView, listener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener2;
        this.context$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$context$2(itemView));
        this.mRootView$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mRootView$2(itemView));
        this.mTitle$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mTitle$2(itemView));
        this.mUrlLayout$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mUrlLayout$2(itemView));
        this.mUrlImage$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mUrlImage$2(itemView));
        this.mUrlTitle$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mUrlTitle$2(itemView));
        this.mUrlWebSite$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mUrlWebSite$2(itemView));
        this.mRightCloseView$delegate = LazyKt.lazy(new PersonalAiSingleUrlHolder$mRightCloseView$2(itemView));
        this.urlCallback = new PersonalAiSingleUrlHolder$urlCallback$1(this);
    }

    private final Context getContext() {
        return (Context) this.context$delegate.getValue();
    }

    private final LinearLayout getMRootView() {
        Object value = this.mRootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mRootView>(...)");
        return (LinearLayout) value;
    }

    private final TextView getMTitle() {
        Object value = this.mTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTitle>(...)");
        return (TextView) value;
    }

    private final View getMUrlLayout() {
        Object value = this.mUrlLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mUrlLayout>(...)");
        return (View) value;
    }

    private final BdBaseImageView getMUrlImage() {
        Object value = this.mUrlImage$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mUrlImage>(...)");
        return (BdBaseImageView) value;
    }

    private final TextView getMUrlTitle() {
        Object value = this.mUrlTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mUrlTitle>(...)");
        return (TextView) value;
    }

    private final TextView getMUrlWebSite() {
        Object value = this.mUrlWebSite$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mUrlWebSite>(...)");
        return (TextView) value;
    }

    private final PersonalAiCloseView getMRightCloseView() {
        Object value = this.mRightCloseView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mRightCloseView>(...)");
        return (PersonalAiCloseView) value;
    }

    public void populate(PersonalCenterBaseModel data) {
        String str;
        CharSequence charSequence;
        PersonalCenterBaseModel personalCenterBaseModel = data;
        Intrinsics.checkNotNullParameter(personalCenterBaseModel, "data");
        super.populate(data);
        getMRootView().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_ai_card_bg));
        if (personalCenterBaseModel instanceof PersonalCenterTabModel) {
            this.mData = (PersonalCenterTabModel) personalCenterBaseModel;
            TextView $this$populate_u24lambda_u2d0 = getMTitle();
            if (!this.isDefaultEmptyTitle) {
                if (TextUtils.isEmpty(((PersonalCenterTabModel) personalCenterBaseModel).getTitle())) {
                    charSequence = $this$populate_u24lambda_u2d0.getContext().getText(R.string.personal_recent_visited_url_hint);
                } else {
                    charSequence = ((PersonalCenterTabModel) personalCenterBaseModel).getTitle();
                }
                $this$populate_u24lambda_u2d0.setText(charSequence);
            }
            $this$populate_u24lambda_u2d0.setTextColor(ContextCompat.getColor($this$populate_u24lambda_u2d0.getContext(), R.color.GC1));
            FontSizeTextViewExtKt.setScaledSizeRes$default($this$populate_u24lambda_u2d0, 2, R.dimen.personal_edit_tab_panel_spacing, 0, 4, (Object) null);
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder().append(" mIvRightArrowIcon: ");
            ImageView mIvRightArrowIcon$lib_personal_center_release = getMIvRightArrowIcon$lib_personal_center_release();
            String str3 = null;
            log$lib_personal_center_release(str2, append.append(mIvRightArrowIcon$lib_personal_center_release instanceof PersonalAiVideoArrowImageView ? (PersonalAiVideoArrowImageView) mIvRightArrowIcon$lib_personal_center_release : null).toString());
            ImageView mIvRightArrowIcon$lib_personal_center_release2 = getMIvRightArrowIcon$lib_personal_center_release();
            PersonalAiVideoArrowImageView personalAiVideoArrowImageView = mIvRightArrowIcon$lib_personal_center_release2 instanceof PersonalAiVideoArrowImageView ? (PersonalAiVideoArrowImageView) mIvRightArrowIcon$lib_personal_center_release2 : null;
            if (personalAiVideoArrowImageView != null) {
                personalAiVideoArrowImageView.getRecentVisitedOrFavoredWebDataFromDb((PersonalCenterTabModel) personalCenterBaseModel, 1, this.urlCallback);
            }
            TextView $this$populate_u24lambda_u2d1 = getMUrlTitle();
            $this$populate_u24lambda_u2d1.setTextColor(ContextCompat.getColor($this$populate_u24lambda_u2d1.getContext(), R.color.GC1));
            FontSizeTextViewExtKt.setScaledSizeRes$default($this$populate_u24lambda_u2d1, 2, R.dimen.personal_ai_card_v2_sub_title_size, 0, 4, (Object) null);
            TextView $this$populate_u24lambda_u2d2 = getMUrlWebSite();
            $this$populate_u24lambda_u2d2.setTextColor(ContextCompat.getColor($this$populate_u24lambda_u2d2.getContext(), R.color.GC4));
            FontSizeTextViewExtKt.setScaledSizeRes$default($this$populate_u24lambda_u2d2, 2, R.dimen.personal_ai_card_v2_sub_desc_size, 0, 4, (Object) null);
            PersonalCenterTabModel personalCenterTabModel = this.mData;
            if (personalCenterTabModel == null || (str = personalCenterTabModel.getScheme()) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                LinearLayout $this$populate_u24lambda_u2d4 = getMRootView();
                $this$populate_u24lambda_u2d4.setOnTouchListener(new TouchPressStateListener());
                $this$populate_u24lambda_u2d4.setOnClickListener(new PersonalAiSingleUrlHolder$$ExternalSyntheticLambda0(this, $this$populate_u24lambda_u2d4, personalCenterBaseModel));
            }
            PersonalCenterTabModel personalCenterTabModel2 = this.mData;
            if (Intrinsics.areEqual((Object) personalCenterTabModel2 != null ? personalCenterTabModel2.getShowHiddenEntry() : null, (Object) "1")) {
                getMRightCloseView().setVisibility(0);
                getMRightCloseView().populate();
                getMRightCloseView().setOnCloseClickListener(new PersonalAiSingleUrlHolder$populate$5(this));
                return;
            }
            String str4 = this.TAG;
            StringBuilder append2 = new StringBuilder().append(" 不展示隐藏文字 ");
            PersonalCenterTabModel personalCenterTabModel3 = this.mData;
            if (personalCenterTabModel3 != null) {
                str3 = personalCenterTabModel3.getShowHiddenEntry();
            }
            log$lib_personal_center_release(str4, append2.append(str3).append(' ').toString());
            getMRightCloseView().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-4$lambda-3  reason: not valid java name */
    public static final void m15021populate$lambda4$lambda3(PersonalAiSingleUrlHolder this$0, LinearLayout $this_apply, PersonalCenterBaseModel $data, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter($data, "$data");
        PersonalCenterTabModel personalCenterTabModel = this$0.mData;
        if (TextUtils.equals(personalCenterTabModel != null ? personalCenterTabModel.getForceLogin() : null, "1")) {
            AiPersonalUtils aiPersonalUtils = AiPersonalUtils.INSTANCE;
            Context context = $this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aiPersonalUtils.checkoutLoginAndRun(context, ((PersonalCenterTabModel) $data).getUbcType(), (Function0<Unit>) new PersonalAiSingleUrlHolder$populate$4$1$1(this$0));
            this$0.log$lib_personal_center_release(this$0.TAG, " 命中强制登录");
            return;
        }
        this$0.jumpToMore();
    }

    /* access modifiers changed from: private */
    public final void updateContent() {
        TemplateModel templateModel;
        TemplateModel templateModel2;
        String str;
        CharSequence charSequence;
        int i2 = 0;
        String str2 = null;
        if (this.mFavorHisModel == null) {
            getMTitle().setText(getContext().getString(R.string.personal_ai_url_unexist));
            this.isDefaultEmptyTitle = true;
        } else {
            this.isDefaultEmptyTitle = false;
            TextView mTitle = getMTitle();
            PersonalCenterTabModel personalCenterTabModel = this.mData;
            if (personalCenterTabModel == null || (str = personalCenterTabModel.getTitle()) == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                FavorHistoryModel favorHistoryModel = this.mFavorHisModel;
                if ((favorHistoryModel != null ? favorHistoryModel.getFavorModel() : null) != null) {
                    charSequence = getContext().getText(R.string.personal_recent_favored_url_hint);
                } else {
                    FavorHistoryModel favorHistoryModel2 = this.mFavorHisModel;
                    if ((favorHistoryModel2 != null ? favorHistoryModel2.getHistoryModel() : null) != null) {
                        charSequence = getContext().getText(R.string.personal_recent_visited_url_hint);
                    } else {
                        this.isDefaultEmptyTitle = true;
                        charSequence = getContext().getString(R.string.personal_ai_url_unexist);
                    }
                }
            } else {
                PersonalCenterTabModel personalCenterTabModel2 = this.mData;
                charSequence = personalCenterTabModel2 != null ? personalCenterTabModel2.getTitle() : null;
            }
            mTitle.setText(charSequence);
        }
        TextView mUrlTitle = getMUrlTitle();
        FavorHistoryModel favorHistoryModel3 = this.mFavorHisModel;
        mUrlTitle.setText((favorHistoryModel3 == null || (templateModel2 = favorHistoryModel3.getTemplateModel()) == null) ? null : templateModel2.getTitle());
        TextView mUrlWebSite = getMUrlWebSite();
        FavorHistoryModel favorHistoryModel4 = this.mFavorHisModel;
        mUrlWebSite.setText((favorHistoryModel4 == null || (templateModel = favorHistoryModel4.getTemplateModel()) == null) ? null : templateModel.getSource());
        getMUrlImage().setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_personal_ai_web_default));
        getMUrlLayout().setOnTouchListener(new TouchPressStateListener());
        getMUrlLayout().setOnClickListener(new PersonalAiSingleUrlHolder$$ExternalSyntheticLambda1(this));
        if (!this.isDefaultEmptyTitle) {
            getMUrlLayout().setVisibility(0);
            LinearLayout mLlSeeMore$lib_personal_center_release = getMLlSeeMore$lib_personal_center_release();
            if (mLlSeeMore$lib_personal_center_release != null) {
                PersonalCenterTabModel personalCenterTabModel3 = this.mData;
                if (personalCenterTabModel3 != null) {
                    str2 = personalCenterTabModel3.getMoreText();
                }
                if (TextUtils.isEmpty(str2)) {
                    i2 = 8;
                }
                mLlSeeMore$lib_personal_center_release.setVisibility(i2);
                return;
            }
            return;
        }
        getMUrlLayout().setVisibility(8);
        LinearLayout mLlSeeMore$lib_personal_center_release2 = getMLlSeeMore$lib_personal_center_release();
        if (mLlSeeMore$lib_personal_center_release2 != null) {
            mLlSeeMore$lib_personal_center_release2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getBody();
     */
    /* renamed from: updateContent$lambda-5  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m15022updateContent$lambda5(com.baidu.searchbox.aipersonal.viewholder.PersonalAiSingleUrlHolder r5, android.view.View r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r0 = r5.mData
            r1 = 0
            if (r0 == 0) goto L_0x0018
            java.util.List r0 = r0.getBody()
            if (r0 == 0) goto L_0x0018
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel r0 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r0
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            com.baidu.searchbox.aipersonal.data.FavorHistoryModel r2 = r5.mFavorHisModel
            if (r2 == 0) goto L_0x0022
            com.baidu.searchbox.favor.data.FavorModel r2 = r2.getFavorModel()
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            if (r2 == 0) goto L_0x002e
            if (r0 != 0) goto L_0x0028
            goto L_0x0043
        L_0x0028:
            java.lang.String r2 = "feature"
            r0.setUbcSource(r2)
            goto L_0x0043
        L_0x002e:
            com.baidu.searchbox.aipersonal.data.FavorHistoryModel r2 = r5.mFavorHisModel
            if (r2 == 0) goto L_0x0037
            com.baidu.searchbox.history.api.data.HistoryModel r2 = r2.getHistoryModel()
            goto L_0x0038
        L_0x0037:
            r2 = r1
        L_0x0038:
            if (r2 == 0) goto L_0x0043
            if (r0 != 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            java.lang.String r2 = "history"
            r0.setUbcSource(r2)
        L_0x0043:
            if (r0 == 0) goto L_0x004f
            com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListenerAdapter r2 = r5.listener
            if (r2 == 0) goto L_0x004f
            r3 = 0
            int r4 = r5.cardPosition
            r2.onChildItemClickListener(r0, r3, r4)
        L_0x004f:
            if (r0 == 0) goto L_0x0057
            java.lang.String r2 = r0.getForceLogin()
            if (r2 != 0) goto L_0x0059
        L_0x0057:
            java.lang.String r2 = ""
        L_0x0059:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = "1"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x0088
            com.baidu.searchbox.aipersonal.AiPersonalUtils r2 = com.baidu.searchbox.aipersonal.AiPersonalUtils.INSTANCE
            android.content.Context r3 = r5.getContext()
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r0 == 0) goto L_0x0076
            java.lang.String r1 = r0.getUbcType()
        L_0x0076:
            com.baidu.searchbox.aipersonal.viewholder.PersonalAiSingleUrlHolder$updateContent$1$1 r4 = new com.baidu.searchbox.aipersonal.viewholder.PersonalAiSingleUrlHolder$updateContent$1$1
            r4.<init>(r5)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.checkoutLoginAndRun((android.content.Context) r3, (java.lang.String) r1, (kotlin.jvm.functions.Function0<kotlin.Unit>) r4)
            java.lang.String r1 = r5.TAG
            java.lang.String r2 = " 命中强制登录"
            r5.log$lib_personal_center_release(r1, r2)
            goto L_0x008d
        L_0x0088:
            com.baidu.searchbox.aipersonal.data.FavorHistoryModel r1 = r5.mFavorHisModel
            r5.openFavorHisItem(r1)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aipersonal.viewholder.PersonalAiSingleUrlHolder.m15022updateContent$lambda5(com.baidu.searchbox.aipersonal.viewholder.PersonalAiSingleUrlHolder, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public final void jumpToMore() {
        String str;
        String scheme;
        Context context = getContext();
        PersonalCenterTabModel personalCenterTabModel = this.mData;
        String str2 = "";
        if (personalCenterTabModel == null || (str = personalCenterTabModel.getScheme()) == null) {
            str = str2;
        }
        Router.invoke(context, str);
        ModuleActionListenerAdapter moduleActionListenerAdapter = this.listener;
        if (moduleActionListenerAdapter != null) {
            moduleActionListenerAdapter.onClickMoreListener(this.mData, 0, this.cardPosition);
        }
        String str3 = this.TAG;
        StringBuilder append = new StringBuilder().append(" jumpToNovel, cardPosition = ").append(this.cardPosition).append(", scheme ：");
        PersonalCenterTabModel personalCenterTabModel2 = this.mData;
        if (!(personalCenterTabModel2 == null || (scheme = personalCenterTabModel2.getScheme()) == null)) {
            str2 = scheme;
        }
        log$lib_personal_center_release(str3, append.append(str2).toString());
    }

    /* access modifiers changed from: private */
    public final void openFavorHisItem(FavorHistoryModel favorHisModel) {
        HistoryModel historyModel = null;
        FavorModel favorModel = favorHisModel != null ? favorHisModel.getFavorModel() : null;
        if (favorHisModel != null) {
            historyModel = favorHisModel.getHistoryModel();
        }
        if (favorModel != null) {
            BookmarkUtil.openItem(getContext(), favorModel.cmd, favorModel.url, "favourate", favorModel.getExtData(), "", "", "", "");
            AiPersonalUtils.INSTANCE.updateFavorVisitTime(favorModel);
        } else if (historyModel != null) {
            BookmarkUtil.openItem(getContext(), historyModel.getCmd(), historyModel.getUrl(), "history", historyModel.getExtra(), "", "", "", "");
            AiPersonalUtils.INSTANCE.updateHistoryVisitTime(historyModel);
        }
    }
}
