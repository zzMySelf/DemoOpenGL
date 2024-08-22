package com.baidu.searchbox.newpersonalcenter.ioc;

import com.baidu.searchbox.personalcenter.constellation.IPersonalConstellationProvider;
import com.baidu.searchbox.utils.PersonalCenterConstellationKvUtils;
import com.baidu.searchbox.utils.PersonalCenterSpUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/ioc/ConstellationImpl;", "Lcom/baidu/searchbox/personalcenter/constellation/IPersonalConstellationProvider;", "()V", "getConstellationType", "", "setConstellationType", "", "type", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConstellationImpl.kt */
public final class ConstellationImpl implements IPersonalConstellationProvider {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (true == (r0.length() > 0)) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getConstellationType() {
        /*
            r5 = this;
            com.baidu.searchbox.utils.PersonalCenterConstellationKvUtils$Companion r0 = com.baidu.searchbox.utils.PersonalCenterConstellationKvUtils.Companion
            com.baidu.searchbox.utils.PersonalCenterConstellationKvUtils r0 = r0.getInstance()
            java.lang.String r1 = "KEY_CONSTELLATION_NAME"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)
            r1 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0024
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0020
            r4 = r1
            goto L_0x0021
        L_0x0020:
            r4 = r3
        L_0x0021:
            if (r1 != r4) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = r3
        L_0x0025:
            if (r1 == 0) goto L_0x0028
            return r0
        L_0x0028:
            java.lang.String r1 = "KEY_CONSTELLATION_TYPE"
            java.lang.String r1 = com.baidu.searchbox.utils.PersonalCenterSpUtils.getString(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.newpersonalcenter.ioc.ConstellationImpl.getConstellationType():java.lang.String");
    }

    public void setConstellationType(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.length() > 0) {
            PersonalCenterConstellationKvUtils.Companion.getInstance().putString(PersonalCenterConstellationKvUtils.KEY_CONSTELLATION_NAME, type);
            PersonalCenterSpUtils.putString("KEY_CONSTELLATION_TYPE", type);
        }
    }
}
