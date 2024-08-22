package com.baidu.searchbox.mall.comp.talos;

import android.os.Bundle;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.common.BundleInfo;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.DataMgrConstantsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/mall/comp/talos/CommonTalosModel;", "Lcom/baidu/searchbox/mall/comp/talos/ITalosModel;", "mainBizName", "", "bundleName", "requireBundleVersion", "bizDataPrefetch", "bizParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizDataPrefetch", "()Ljava/lang/String;", "setBizDataPrefetch", "(Ljava/lang/String;)V", "getBizParams", "setBizParams", "getBundleName", "getMainBizName", "getRequireBundleVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "", "bundle", "Landroid/os/Bundle;", "toString", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosModels.kt */
public final class CommonTalosModel implements ITalosModel {
    private String bizDataPrefetch;
    private String bizParams;
    private final String bundleName;
    private final String mainBizName;
    private final String requireBundleVersion;

    public static /* synthetic */ CommonTalosModel copy$default(CommonTalosModel commonTalosModel, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commonTalosModel.getMainBizName();
        }
        if ((i2 & 2) != 0) {
            str2 = commonTalosModel.getBundleName();
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = commonTalosModel.requireBundleVersion;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = commonTalosModel.bizDataPrefetch;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = commonTalosModel.bizParams;
        }
        return commonTalosModel.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return getMainBizName();
    }

    public final String component2() {
        return getBundleName();
    }

    public final String component3() {
        return this.requireBundleVersion;
    }

    public final String component4() {
        return this.bizDataPrefetch;
    }

    public final String component5() {
        return this.bizParams;
    }

    public final CommonTalosModel copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "mainBizName");
        Intrinsics.checkNotNullParameter(str2, "bundleName");
        return new CommonTalosModel(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonTalosModel)) {
            return false;
        }
        CommonTalosModel commonTalosModel = (CommonTalosModel) obj;
        return Intrinsics.areEqual((Object) getMainBizName(), (Object) commonTalosModel.getMainBizName()) && Intrinsics.areEqual((Object) getBundleName(), (Object) commonTalosModel.getBundleName()) && Intrinsics.areEqual((Object) this.requireBundleVersion, (Object) commonTalosModel.requireBundleVersion) && Intrinsics.areEqual((Object) this.bizDataPrefetch, (Object) commonTalosModel.bizDataPrefetch) && Intrinsics.areEqual((Object) this.bizParams, (Object) commonTalosModel.bizParams);
    }

    public int hashCode() {
        int hashCode = ((getMainBizName().hashCode() * 31) + getBundleName().hashCode()) * 31;
        String str = this.requireBundleVersion;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bizDataPrefetch;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bizParams;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "CommonTalosModel(mainBizName=" + getMainBizName() + ", bundleName=" + getBundleName() + ", requireBundleVersion=" + this.requireBundleVersion + ", bizDataPrefetch=" + this.bizDataPrefetch + ", bizParams=" + this.bizParams + ')';
    }

    public CommonTalosModel(String mainBizName2, String bundleName2, String requireBundleVersion2, String bizDataPrefetch2, String bizParams2) {
        Intrinsics.checkNotNullParameter(mainBizName2, "mainBizName");
        Intrinsics.checkNotNullParameter(bundleName2, "bundleName");
        this.mainBizName = mainBizName2;
        this.bundleName = bundleName2;
        this.requireBundleVersion = requireBundleVersion2;
        this.bizDataPrefetch = bizDataPrefetch2;
        this.bizParams = bizParams2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CommonTalosModel(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r4 = r0
            goto L_0x0008
        L_0x0007:
            r4 = r10
        L_0x0008:
            r10 = r13 & 8
            if (r10 == 0) goto L_0x000e
            r5 = r0
            goto L_0x000f
        L_0x000e:
            r5 = r11
        L_0x000f:
            r10 = r13 & 16
            if (r10 == 0) goto L_0x0015
            r6 = r0
            goto L_0x0016
        L_0x0015:
            r6 = r12
        L_0x0016:
            r1 = r7
            r2 = r8
            r3 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mall.comp.talos.CommonTalosModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getMainBizName() {
        return this.mainBizName;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public final String getRequireBundleVersion() {
        return this.requireBundleVersion;
    }

    public final String getBizDataPrefetch() {
        return this.bizDataPrefetch;
    }

    public final void setBizDataPrefetch(String str) {
        this.bizDataPrefetch = str;
    }

    public final String getBizParams() {
        return this.bizParams;
    }

    public final void setBizParams(String str) {
        this.bizParams = str;
    }

    public void toBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putString(BundleInfo.BUNDLE_ID, getMainBizName());
        bundle.putString(BundleInfo.COMP_NAME, getBundleName());
        bundle.putBoolean(DataMgrConstantsKt.SHOW_GROUP_ITEM_TYPE_DARK_MODE, NightModeHelper.isNightMode());
        bundle.putString("userAgent", TalosModelsKt.getUserAgent());
        boolean z = true;
        bundle.putInt("searchFontSize", FeedConfig.Font.FONT_LEVEL + 1);
        CharSequence charSequence = this.requireBundleVersion;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            bundle.putString("requireBundleVersion", this.requireBundleVersion);
        }
        bundle.putString("bizDataPrefetch", this.bizDataPrefetch);
        bundle.putString("bizparams", this.bizParams);
    }
}
