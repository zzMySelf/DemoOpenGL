package com.baidu.searchbox.items.accountprivacy;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001e\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/items/accountprivacy/AccountPrivacy;", "", "()V", "mAddressSwitch", "", "getMAddressSwitch", "()Z", "setMAddressSwitch", "(Z)V", "mAttentionFansSwitch", "getMAttentionFansSwitch", "setMAttentionFansSwitch", "mItemClick", "Lcom/baidu/searchbox/items/accountprivacy/AccountPrivacy$IAccountPrivacyItemClick;", "mSearchByTel", "getMSearchByTel", "setMSearchByTel", "mShowComment", "getMShowComment", "setMShowComment", "getAddressSwitchItem", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "context", "Landroid/content/Context;", "getAttentionFans", "getBlackList", "getHisSug", "getPersonalRec", "getProgramAd", "getSearchByNumberItem", "getShowComment", "isNormalUser", "setAccountPrivacyItemClick", "", "itemClick", "Companion", "IAccountPrivacyItemClick", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountPrivacy.kt */
public final class AccountPrivacy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SETTING_DSP_AD_SCHEME = "key_setting_dsp_ad_scheme";
    private boolean mAddressSwitch;
    private boolean mAttentionFansSwitch;
    /* access modifiers changed from: private */
    public IAccountPrivacyItemClick mItemClick;
    private boolean mSearchByTel;
    private boolean mShowComment;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/items/accountprivacy/AccountPrivacy$IAccountPrivacyItemClick;", "", "onAccountPrivacyItemClick", "", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountPrivacy.kt */
    public interface IAccountPrivacyItemClick {
        void onAccountPrivacyItemClick();
    }

    public final boolean getMSearchByTel() {
        return this.mSearchByTel;
    }

    public final void setMSearchByTel(boolean z) {
        this.mSearchByTel = z;
    }

    public final boolean getMAddressSwitch() {
        return this.mAddressSwitch;
    }

    public final void setMAddressSwitch(boolean z) {
        this.mAddressSwitch = z;
    }

    public final boolean getMShowComment() {
        return this.mShowComment;
    }

    public final void setMShowComment(boolean z) {
        this.mShowComment = z;
    }

    public final boolean getMAttentionFansSwitch() {
        return this.mAttentionFansSwitch;
    }

    public final void setMAttentionFansSwitch(boolean z) {
        this.mAttentionFansSwitch = z;
    }

    public final void setAccountPrivacyItemClick(IAccountPrivacyItemClick itemClick) {
        Intrinsics.checkNotNullParameter(itemClick, "itemClick");
        this.mItemClick = itemClick;
    }

    public final SettingItemModel getSearchByNumberItem(Context context) {
        return new AccountPrivacy$getSearchByNumberItem$1(this, context);
    }

    public final SettingItemModel getAddressSwitchItem(Context context) {
        return new AccountPrivacy$getAddressSwitchItem$1(context, this);
    }

    public final SettingItemModel getShowComment(Context context) {
        return new AccountPrivacy$getShowComment$1(context, this);
    }

    public final SettingItemModel getAttentionFans(Context context) {
        return new AccountPrivacy$getAttentionFans$1(context, this);
    }

    private final boolean isNormalUser() {
        BoxAccount boxAccount = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getBoxAccount();
        if (boxAccount != null) {
            return Intrinsics.areEqual((Object) "0", (Object) boxAccount.getUserType());
        }
        return true;
    }

    public final SettingItemModel getBlackList(Context context) {
        return new AccountPrivacy$getBlackList$1(context);
    }

    public final SettingItemModel getProgramAd(Context context) {
        return new AccountPrivacy$getProgramAd$1(context);
    }

    public final SettingItemModel getHisSug(Context context) {
        return new AccountPrivacy$getHisSug$1(context);
    }

    public final SettingItemModel getPersonalRec(Context context) {
        return new AccountPrivacy$getPersonalRec$1(context);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/items/accountprivacy/AccountPrivacy$Companion;", "", "()V", "KEY_SETTING_DSP_AD_SCHEME", "", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountPrivacy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
