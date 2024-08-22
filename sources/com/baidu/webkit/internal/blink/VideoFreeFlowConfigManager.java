package com.baidu.webkit.internal.blink;

import android.text.TextUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.ArrayList;

public class VideoFreeFlowConfigManager implements INoProGuard {
    public static final String DIRECT = "DIRECT";
    public static final String HOST_MATCH = "HOSTMATCH";
    public static final String HOST_STR = "HOSTSTR";
    public static final String HOST_STR_MATCH = "HOSTSTRMATCH";
    public static final int INDEX_MATCH_RULE = 0;
    public static final int INDEX_MATCH_STR = 1;
    public static final int INDEX_PAC_STR = 2;
    private static final String[] LOCAL_RULE_STRINGS = {"HOSTMATCH#m.baidu.com#DIRECT", "HOSTMATCH#mbd.baidu.com#DIRECT", "HOSTMATCH#vdf1.bdstatic.com#DIRECT", "HOSTMATCH#vdf2.bdstatic.com#DIRECT", "HOSTMATCH#vdf3.bdstatic.com#DIRECT", "HOSTMATCH#vdf4.bdstatic.com#DIRECT", "HOSTMATCH#shouji.baidu.com#DIRECT", "HOSTMATCH#appc.baidu.com#DIRECT", "HOSTMATCH#v.gdown.baidu.com #DIRECT", "HOSTMATCH#pan.baidu.com#DIRECT", "HOSTMATCH#d.pcs.baidu.com#DIRECT", "HOSTMATCH#pcs.baidu.com#DIRECT", "HOSTMATCH#pcsdata.baidu.com#DIRECT", "HOSTMATCH#thumbnail0.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail1.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail2.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail3.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail4.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail5.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail6.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail7.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail8.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail9.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail10.baidupcs.com#DIRECT", "HOSTMATCH#update.pan.baidu.com#DIRECT", "HOSTMATCH#d14.baidupcs.com#DIRECT", "HOSTMATCH#d16.baidupcs.com#DIRECT", "HOSTMATCH#v6.baidupcs.com#DIRECT", "HOSTMATCH#v8.baidupcs.com#DIRECT", "HOSTMATCH#allall05.baidupcs.com#DIRECT", "HOSTMATCH#allall04.baidupcs.com#DIRECT", "HOSTMATCH#allnest.pcs.baidu.com#DIRECT", "HOSTMATCH#c.pcs.baidu.com#DIRECT", "HOSTMATCH#tieba.baidu.com?#DIRECT", "HOSTMATCH#tiebac.baidu.com#DIRECT", "HOSTMATCH#c.tieba.baidu.com#DIRECT", "HOSTMATCH#client.map.baidu.com#DIRECT", "HOSTMATCH#newclient.map.baidu.com#DIRECT", "HOSTMATCH#map.baidu.com#DIRECT", "HOSTMATCH#loc.map.baidu.com#DIRECT", "HOSTMATCH#lbsyun.baidu.com#DIRECT", "HOSTMATCH#api.map.baidu.com#DIRECT", "HOSTMATCH#its.map.baidu.com#DIRECT", "HOSTMATCH#sv.map.baidu.com#DIRECT", "HOSTMATCH#wapmap.baidu.com#DIRECT", "HOSTMATCH#newvector.map.baidu.com#DIRECT", "HOSTMATCH#or.map.baidu.com#DIRECT", "HOSTMATCH#s0.map.bdimg.com#DIRECT", "HOSTMATCH#s1.map.bdimg.com#DIRECT", "HOSTMATCH#offmap2.baidu.com#DIRECT", "HOSTMATCH#offmap1.baidu.com#DIRECT", "HOSTMATCH#offmap0.baidu.com#DIRECT", "HOSTMATCH#wapmap0.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap1.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap2.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap3.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap4.map.bdimg.com#DIRECT", "HOSTMATCH#webapp0.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp1.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp2.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp3.map.bdstatic.com#DIRECT", "HOSTMATCH#webmap0.bdimg.com#DIRECT", "HOSTMATCH#webmap1.bdimg.com#DIRECT", "HOSTMATCH#webmap2.bdimg.com#DIRECT", "HOSTMATCH#webmap3.bdimg.com#DIRECT", "HOSTMATCH#webmap4.bdimg.com#DIRECT", "HOSTMATCH#hiphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.baidu.com#DIRECT", "HOSTMATCH#hiphotos.bdimg.com#DIRECT", "HOSTMATCH#picphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.bdimg.com#DIRECT", "HOSTMATCH#imagecdn.baidu.com#DIRECT", "HOSTMATCH#q1.baidu.com#DIRECT", "HOSTMATCH#q2.baidu.com#DIRECT", "HOSTMATCH#q3.baidu.com#DIRECT", "HOSTMATCH#q4.baidu.com#DIRECT", "HOSTMATCH#q5.baidu.com#DIRECT", "HOSTMATCH#q6.baidu.com#DIRECT", "HOSTMATCH#q7.baidu.com#DIRECT", "HOSTMATCH#q8.baidu.com#DIRECT", "HOSTMATCH#t1.baidu.com#DIRECT", "HOSTMATCH#t2.baidu.com#DIRECT", "HOSTMATCH#t3.baidu.com#DIRECT", "HOSTMATCH#t4.baidu.com#DIRECT", "HOSTMATCH#t10.baidu.com#DIRECT", "HOSTMATCH#t11.baidu.com#DIRECT", "HOSTMATCH#t12.baidu.com#DIRECT", "HOSTMATCH#i1.baidu.com#DIRECT", "HOSTMATCH#i2.baidu.com#DIRECT", "HOSTMATCH#i3.baidu.com#DIRECT", "HOSTMATCH#i4.baidu.com#DIRECT", "HOSTMATCH#i5.baidu.com#DIRECT", "HOSTMATCH#i6.baidu.com#DIRECT", "HOSTMATCH#i7.baidu.com#DIRECT", "HOSTMATCH#i8.baidu.com#DIRECT", "HOSTMATCH#i9.baidu.com#DIRECT", "HOSTMATCH#i10.baidu.com#DIRECT", "HOSTMATCH#i11.baidu.com#DIRECT", "HOSTMATCH#i12.baidu.com#DIRECT", "HOSTMATCH#tnimg1.baidu.com#DIRECT", "HOSTMATCH#tnimg2.baidu.com#DIRECT", "HOSTMATCH#img0.bdstatic.com#DIRECT", "HOSTMATCH#img1.bdstatic.com#DIRECT", "HOSTMATCH#img2.bdstatic.com#DIRECT", "HOSTMATCH#img3.bdstatic.com#DIRECT", "HOSTMATCH#img4.bdstatic.com#DIRECT", "HOSTMATCH#img5.bdstatic.com#DIRECT", "HOSTMATCH#img6.bdstatic.com#DIRECT", "HOSTMATCH#img7.bdstatic.com#DIRECT", "HOSTMATCH#f10.baidu.com#DIRECT", "HOSTMATCH#f11.baidu.com#DIRECT", "HOSTMATCH#f12.baidu.com#DIRECT", "HOSTMATCH#timg01.bdimg.com#DIRECT", "HOSTMATCH#timg02.bdimg.com#DIRECT", "HOSTMATCH#timg03.bdimg.com#DIRECT", "HOSTMATCH#timg04.bdimg.com#DIRECT", "HOSTMATCH#timg05.bdimg.com#DIRECT", "HOSTMATCH#cdn00.baidu-img.cn#DIRECT", "HOSTMATCH#cdn01.baidu-img.cn#DIRECT", "HOSTMATCH#cdn02.baidu-img.cn#DIRECT", "HOSTMATCH#cdn03.baidu-img.cn#DIRECT", "HOSTMATCH#wiseala.baidu-img.cn#DIRECT", "HOSTMATCH#wa1.baidu-1img.cn#DIRECT", "HOSTMATCH#wa2.baidu-1img.cn#DIRECT", "HOSTMATCH#wa3.baidu-1img.cn#DIRECT", "HOSTMATCH#imgtn.bdimg.com#DIRECT", "HOSTMATCH#browserkernel.baidu.com#DIRECT", "HOSTMATCH#browsersafe.baidu.com#DIRECT", "URLMATCH#https://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#ws://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#wss://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "HOSTMATCH#*#PROXY cloudnproxy.baidu.com:443;DIRECT;"};
    public static final String PROXY = "PROXY";
    public static final String SEPARATOR_STR = "#";
    public static final String TAG = "VideoFreeFlowConfigManager";
    public static final String URL_MATCH = "URLMATCH";
    private static VideoFreeFlowConfigManager sInstance;
    private byte[] mListLock = new byte[0];
    private ArrayList<a> mPacRulesList = new ArrayList<>();

    private VideoFreeFlowConfigManager() {
    }

    public static synchronized VideoFreeFlowConfigManager getInstance() {
        VideoFreeFlowConfigManager videoFreeFlowConfigManager;
        synchronized (VideoFreeFlowConfigManager.class) {
            if (sInstance == null) {
                sInstance = new VideoFreeFlowConfigManager();
            }
            videoFreeFlowConfigManager = sInstance;
        }
        return videoFreeFlowConfigManager;
    }

    public void setPacData(String str) {
        initPacRule(str);
    }

    public boolean isFreeFlowEnable() {
        if (WebSettingsGlobalBlink.canUseFreeFlow()) {
            return true;
        }
        return false;
    }

    private void initPacRule(String str) {
        Log.w(TAG, "initPacRule:".concat(String.valueOf(str)));
        synchronized (this.mListLock) {
            this.mPacRulesList.clear();
            for (String aVar : str.split("\n")) {
                this.mPacRulesList.add(new a(aVar));
            }
        }
    }

    public void initLocalRule() {
        Log.w(TAG, "initLocalRule called");
        synchronized (this.mListLock) {
            this.mPacRulesList.clear();
            for (String aVar : LOCAL_RULE_STRINGS) {
                this.mPacRulesList.add(new a(aVar));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getFreeFlowProxy(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = r11.isFreeFlowEnable()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x000f
            return r1
        L_0x000f:
            byte[] r0 = r11.mListLock
            monitor-enter(r0)
            java.util.ArrayList<com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager$a> r2 = r11.mPacRulesList     // Catch:{ all -> 0x00ea }
            int r2 = r2.size()     // Catch:{ all -> 0x00ea }
            android.net.Uri r3 = android.net.Uri.parse(r12)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = r3.getHost()     // Catch:{ all -> 0x00ea }
            r4 = 0
            r5 = r4
        L_0x0022:
            if (r5 >= r2) goto L_0x00e8
            java.util.ArrayList<com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager$a> r6 = r11.mPacRulesList     // Catch:{ all -> 0x00ea }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x00ea }
            com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager$a r6 = (com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager.a) r6     // Catch:{ all -> 0x00ea }
            boolean r7 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00ea }
            r8 = 1
            if (r7 != 0) goto L_0x00cf
            java.lang.String r7 = r6.f3953a     // Catch:{ all -> 0x00ea }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00cd
            java.lang.String r7 = r6.f3954b     // Catch:{ all -> 0x00ea }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00cd
            java.lang.String r7 = r6.f3955c     // Catch:{ all -> 0x00ea }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x004e
            goto L_0x00cd
        L_0x004e:
            java.lang.String r7 = r6.f3954b     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = "*"
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x005b
            r7 = r8
            goto L_0x00d0
        L_0x005b:
            java.lang.String r7 = r6.f3953a     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = "HOSTMATCH"
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x0090
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00cf
            int r7 = r3.length()     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r6.f3954b     // Catch:{ all -> 0x00ea }
            int r9 = r9.length()     // Catch:{ all -> 0x00ea }
            if (r7 < r9) goto L_0x00cf
            int r7 = r3.length()     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r6.f3954b     // Catch:{ all -> 0x00ea }
            int r9 = r9.length()     // Catch:{ all -> 0x00ea }
            int r7 = r7 - r9
            java.lang.String r7 = r3.substring(r7)     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r6.f3954b     // Catch:{ all -> 0x00ea }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x00cf
            r7 = r8
            goto L_0x00d0
        L_0x0090:
            java.lang.String r7 = r6.f3953a     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = "HOSTSTR"
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00ea }
            r9 = -1
            if (r7 == 0) goto L_0x00a5
            java.lang.String r7 = r6.f3954b     // Catch:{ all -> 0x00ea }
            int r7 = r3.indexOf(r7)     // Catch:{ all -> 0x00ea }
            if (r7 == r9) goto L_0x00cf
            r7 = r8
            goto L_0x00d0
        L_0x00a5:
            java.lang.String r7 = r6.f3953a     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = "HOSTSTRMATCH"
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x00b9
            java.lang.String r7 = r6.f3954b     // Catch:{ all -> 0x00ea }
            boolean r7 = r3.equals(r7)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x00cf
            r7 = r8
            goto L_0x00d0
        L_0x00b9:
            java.lang.String r7 = r6.f3953a     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = "URLMATCH"
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x00cf
            java.lang.String r7 = r6.f3954b     // Catch:{ all -> 0x00ea }
            int r7 = r12.indexOf(r7)     // Catch:{ all -> 0x00ea }
            if (r7 == r9) goto L_0x00cf
            r7 = r8
            goto L_0x00d0
        L_0x00cd:
            r7 = r4
            goto L_0x00d0
        L_0x00cf:
            r7 = r4
        L_0x00d0:
            if (r7 == 0) goto L_0x00e4
            int r7 = r6.f3956d     // Catch:{ all -> 0x00ea }
            if (r7 != r8) goto L_0x00dc
            java.lang.String r12 = r6.f3957e     // Catch:{ all -> 0x00ea }
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            return r12
        L_0x00dc:
            int r6 = r6.f3956d     // Catch:{ all -> 0x00ea }
            r7 = 2
            if (r6 != r7) goto L_0x00e4
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            return r1
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x0022
        L_0x00e8:
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            return r1
        L_0x00ea:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager.getFreeFlowProxy(java.lang.String):java.lang.String");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        String f3953a = null;

        /* renamed from: b  reason: collision with root package name */
        String f3954b = null;

        /* renamed from: c  reason: collision with root package name */
        String f3955c = null;

        /* renamed from: d  reason: collision with root package name */
        int f3956d = 2;

        /* renamed from: e  reason: collision with root package name */
        String f3957e = null;

        public a(String str) {
            if (!TextUtils.isEmpty(str) && str.contains("#")) {
                String[] split = str.split("#");
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(split[i2])) {
                        if (i2 == 0) {
                            this.f3953a = split[i2];
                        } else if (i2 == 1) {
                            this.f3954b = split[i2];
                        } else if (i2 == 2) {
                            String str2 = split[i2];
                            this.f3955c = str2;
                            if (!TextUtils.isEmpty(str2)) {
                                String trim = str2.trim();
                                this.f3955c = trim;
                                if (trim.startsWith(VideoFreeFlowConfigManager.DIRECT)) {
                                    this.f3956d = 2;
                                } else if (this.f3955c.startsWith(VideoFreeFlowConfigManager.PROXY)) {
                                    this.f3956d = 1;
                                    String str3 = this.f3955c;
                                    String trim2 = str3.substring(str3.indexOf(VideoFreeFlowConfigManager.PROXY) + 5).trim();
                                    if (!TextUtils.isEmpty(trim2)) {
                                        String[] split2 = trim2.split(";");
                                        if (split2.length > 0 && !TextUtils.isEmpty(split2[0])) {
                                            this.f3957e = split2[0];
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
