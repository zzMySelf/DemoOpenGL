package com.baidu.swan.apps.impl.sailor;

public class SwanSailorFactory {
    public static final String SAILOR_DEFAULT = "sailor_default";
    public static final String SAILOR_PRESET = "sailor_preset";
    public static final String SAILOR_REMOTE = "sailor_remote";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.swan.apps.adaptation.interfaces.ISwanSailor buildSailor(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case 585866218: goto L_0x0013;
                case 631353681: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x001e
        L_0x0008:
            java.lang.String r0 = "sailor_remote"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x001f
        L_0x0013:
            java.lang.String r0 = "sailor_preset"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = -1
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x002e;
                case 1: goto L_0x0028;
                default: goto L_0x0022;
            }
        L_0x0022:
            com.baidu.swan.apps.adaptation.implementation.DefaultSwanSailorImpl r0 = new com.baidu.swan.apps.adaptation.implementation.DefaultSwanSailorImpl
            r0.<init>()
            return r0
        L_0x0028:
            com.baidu.swan.apps.impl.sailor.SwanSailorPreset r0 = new com.baidu.swan.apps.impl.sailor.SwanSailorPreset
            r0.<init>()
            return r0
        L_0x002e:
            com.baidu.swan.apps.impl.sailor.SwanSailorRemote r0 = new com.baidu.swan.apps.impl.sailor.SwanSailorRemote
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.sailor.SwanSailorFactory.buildSailor(java.lang.String):com.baidu.swan.apps.adaptation.interfaces.ISwanSailor");
    }
}
