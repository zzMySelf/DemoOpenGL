package com.baidu.browser.explore.safeguard;

import com.baidu.browser.abblock.AdBlockManager;
import com.baidu.browser.abblock.AdBlockSp;
import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/baidu/browser/explore/safeguard/PromptSwitchOperator;", "Lcom/baidu/browser/explore/safeguard/IPromptSwitch;", "()V", "abSwitch", "", "getAbSwitch", "()Z", "abSwitch$delegate", "Lkotlin/Lazy;", "abTestService", "Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "getAbTestService", "()Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "abTestService$delegate", "adBlockPopFrequency", "", "getAdBlockPopFrequency", "()I", "adBlockPopFrequency$delegate", "expandPopFrequency", "getExpandPopFrequency", "expandPopFrequency$delegate", "skipInterceptPopFrequency", "getSkipInterceptPopFrequency", "skipInterceptPopFrequency$delegate", "getPopFrequency", "type", "Lcom/baidu/browser/explore/safeguard/SafeguardType;", "isAdBlockSwitchOpen", "isBaseSwitchOpen", "isExpandSwitchOpen", "isPromptSettingSwitchOpen", "isPromptSwitchOpen", "isSafeCautionSwitchOpen", "isSkipInterceptSwitchOpen", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PromptSwitchOperator.kt */
public final class PromptSwitchOperator implements IPromptSwitch {
    private final Lazy abSwitch$delegate = LazyKt.lazy(new PromptSwitchOperator$abSwitch$2(this));
    private final Lazy abTestService$delegate = LazyKt.lazy(PromptSwitchOperator$abTestService$2.INSTANCE);
    private final Lazy adBlockPopFrequency$delegate = LazyKt.lazy(new PromptSwitchOperator$adBlockPopFrequency$2(this));
    private final Lazy expandPopFrequency$delegate = LazyKt.lazy(new PromptSwitchOperator$expandPopFrequency$2(this));
    private final Lazy skipInterceptPopFrequency$delegate = LazyKt.lazy(new PromptSwitchOperator$skipInterceptPopFrequency$2(this));

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PromptSwitchOperator.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SafeguardType.values().length];
            iArr[SafeguardType.EMPTY.ordinal()] = 1;
            iArr[SafeguardType.AD_BLOCK.ordinal()] = 2;
            iArr[SafeguardType.SAFE_CAUTION.ordinal()] = 3;
            iArr[SafeguardType.EXPAND_ARTICLE.ordinal()] = 4;
            iArr[SafeguardType.SKIP_INTERCEPT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final AbTestService getAbTestService() {
        return (AbTestService) this.abTestService$delegate.getValue();
    }

    private final boolean getAbSwitch() {
        return ((Boolean) this.abSwitch$delegate.getValue()).booleanValue();
    }

    private final int getAdBlockPopFrequency() {
        return ((Number) this.adBlockPopFrequency$delegate.getValue()).intValue();
    }

    private final int getSkipInterceptPopFrequency() {
        return ((Number) this.skipInterceptPopFrequency$delegate.getValue()).intValue();
    }

    private final int getExpandPopFrequency() {
        return ((Number) this.expandPopFrequency$delegate.getValue()).intValue();
    }

    public boolean isPromptSwitchOpen(SafeguardType type) {
        boolean z;
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                if (isBaseSwitchOpen() && (isAdBlockSwitchOpen() || isSafeCautionSwitchOpen() || isExpandSwitchOpen() || isSkipInterceptSwitchOpen())) {
                    z = true;
                    break;
                } else {
                    z = false;
                    break;
                }
                break;
            case 2:
                z = isAdBlockSwitchOpen();
                break;
            case 3:
                z = isSafeCautionSwitchOpen();
                break;
            case 4:
                z = isExpandSwitchOpen();
                break;
            case 5:
                z = isSkipInterceptSwitchOpen();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (!z || !getAbSwitch()) {
            return false;
        }
        return true;
    }

    public boolean isPromptSettingSwitchOpen(SafeguardType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 2:
                if (!AdBlockManager.isEnableAds(AppRuntime.getAppContext()) || !AdBlockManager.isOpenAutoAds(AppRuntime.getAppContext())) {
                    return false;
                }
                return true;
            case 3:
            case 5:
                return true;
            case 4:
                return AdBlockSp.getAutoExpandShowSwitch();
            default:
                return false;
        }
    }

    public int getPopFrequency(SafeguardType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 2:
                return getExpandPopFrequency();
            case 4:
                return getSkipInterceptPopFrequency();
            case 5:
                return getAdBlockPopFrequency();
            default:
                return 0;
        }
    }

    private final boolean isBaseSwitchOpen() {
        return SafeguardPromptPreferences.INSTANCE.getBoolean("sp_safeguard_prompt_switch", false);
    }

    private final boolean isAdBlockSwitchOpen() {
        return SafeguardPromptPreferences.INSTANCE.getBoolean("sp_ad_block_switch", false);
    }

    private final boolean isSafeCautionSwitchOpen() {
        return SafeguardPromptPreferences.INSTANCE.getBoolean("sp_safe_caution_switch", false);
    }

    private final boolean isExpandSwitchOpen() {
        return SafeguardPromptPreferences.INSTANCE.getBoolean("sp_expand_article_switch", false);
    }

    private final boolean isSkipInterceptSwitchOpen() {
        return SafeguardPromptPreferences.INSTANCE.getBoolean("sp_skip_intercept_switch", false);
    }
}
