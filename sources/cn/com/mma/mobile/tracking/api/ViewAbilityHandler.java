package cn.com.mma.mobile.tracking.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.com.mma.mobile.tracking.bean.Argument;
import cn.com.mma.mobile.tracking.bean.Company;
import cn.com.mma.mobile.tracking.bean.SDK;
import cn.com.mma.mobile.tracking.util.CommonUtil;
import cn.com.mma.mobile.tracking.util.DeviceInfoUtil;
import cn.com.mma.mobile.tracking.util.Logger;
import cn.com.mma.mobile.tracking.util.SdkConfigUpdateUtil;
import cn.com.mma.mobile.tracking.viewability.origin.CallBack;
import cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityEventListener;
import cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityService;
import cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityStats;
import cn.com.mma.mobile.tracking.viewability.origin.sniffer.ViewAbilityConfig;
import cn.com.mma.mobile.tracking.viewability.webjs.ViewAbilityJsService;
import java.util.HashMap;
import java.util.List;

public class ViewAbilityHandler {
    private ViewAbilityConfig abilityConfig;
    private Context context;
    private HashMap<String, String> impressions = null;
    private ViewAbilityEventListener mmaSdkCallback;
    private SDK sdkConfig;
    private ViewAbilityJsService viewAbilityJsService;
    private ViewAbilityService viewAbilityService;

    public enum MonitorType {
        CLICK,
        IMPRESSION,
        EXPOSEWITHABILITY,
        VIDEOEXPOSEWITHABILITY,
        VIEWABLE,
        NONVIEWABLE,
        UNMEASURED
    }

    public ViewAbilityHandler(Context context2, ViewAbilityEventListener mmaSdkCallback2, SDK sdk) {
        this.context = context2;
        this.mmaSdkCallback = mmaSdkCallback2;
        this.impressions = new HashMap<>();
        this.sdkConfig = sdk;
        this.abilityConfig = initViewAbilityGlobalConfig();
        this.viewAbilityService = new ViewAbilityService(context2, mmaSdkCallback2, this.abilityConfig);
        this.viewAbilityJsService = new ViewAbilityJsService(context2);
    }

    private ViewAbilityConfig initViewAbilityGlobalConfig() {
        ViewAbilityConfig config = new ViewAbilityConfig();
        try {
            SDK sdk = this.sdkConfig;
            if (!(sdk == null || sdk.viewAbility == null)) {
                config.setInspectInterval(this.sdkConfig.viewAbility.intervalTime);
                config.setExposeValidDuration(this.sdkConfig.viewAbility.viewabilityTime);
                config.setCoverRateScale(1.0f - (((float) this.sdkConfig.viewAbility.viewabilityFrame) / 100.0f));
                config.setMaxDuration(this.sdkConfig.viewAbility.maxExpirationSecs);
                config.setMaxUploadAmount(this.sdkConfig.viewAbility.maxAmount);
                config.setVideoExposeValidDuration(this.sdkConfig.viewAbility.viewabilityVideoTime);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return config;
    }

    public void onJSExpose(String adURL, View adView, boolean isVideo) {
        Company company = getCompany(adURL);
        if (company == null || TextUtils.isEmpty(company.name)) {
            Logger.w("监测链接:" + adURL + " 没有对应的配置项,请检查sdkconfig.xml是否存在链接域名对应的Company配置!");
        } else {
            this.viewAbilityJsService.addTrack(adURL, adView, company, isVideo);
        }
    }

    public void onClick(String originUrl, CallBack callBack) {
        handlerOriginURL(originUrl, MonitorType.CLICK, (View) null, 0, 0, callBack);
    }

    public void onExpose(String originUrl, View view2, int type, CallBack callBack) {
        handlerOriginURL(originUrl, MonitorType.IMPRESSION, view2, 0, type, callBack);
    }

    public void onExpose(String originUrl, View adView, CallBack callBack) {
        handlerOriginURL(originUrl, MonitorType.EXPOSEWITHABILITY, adView, 0, 0, callBack);
    }

    public void onVideoExpose(String originUrl, View videoView, int videoPlayType, CallBack callBack) {
        handlerOriginURL(originUrl, MonitorType.VIDEOEXPOSEWITHABILITY, videoView, videoPlayType, 0, callBack);
    }

    public void stop(String originUrl) {
        Company company = getCompany(originUrl);
        if (company == null) {
            Logger.w("监测链接:" + originUrl + " 没有对应的配置项,请检查sdkconfig.xml是否存在链接域名对应的Company配置!");
            return;
        }
        String adAreaID = null;
        try {
            adAreaID = getAdAreaID(company, originUrl);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.viewAbilityService.stopViewAbilityMonitor(company.domain.url + adAreaID);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v15, resolved type: java.lang.StringBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v37, resolved type: java.lang.StringBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v39, resolved type: java.lang.StringBuffer} */
    /* JADX WARNING: type inference failed for: r0v60, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x046b A[Catch:{ Exception -> 0x0563 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x055a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fd A[SYNTHETIC, Splitter:B:35:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016e A[SYNTHETIC, Splitter:B:58:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x028e A[SYNTHETIC, Splitter:B:83:0x028e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handlerOriginURL(java.lang.String r33, cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType r34, android.view.View r35, int r36, int r37, cn.com.mma.mobile.tracking.viewability.origin.CallBack r38) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            r11 = r34
            r12 = r35
            r13 = r37
            r14 = r38
            java.lang.String r15 = "********************************************"
            java.lang.String r3 = ""
            cn.com.mma.mobile.tracking.bean.Company r10 = r32.getCompany(r33)
            if (r10 != 0) goto L_0x0034
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "监测链接:"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r3 = " 没有对应的配置项,请检查sdkconfig.xml是否存在链接域名对应的Company配置!"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            cn.com.mma.mobile.tracking.util.Logger.w(r0)
            return
        L_0x0034:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r1.getRedirectIdentifier(r10)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r4 = r10.equalizer
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r9 = r0.toString()
            java.lang.String r0 = ""
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r10.separator
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r5 = ".*"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r16 = r4.toString()
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r16)
            java.util.regex.Matcher r6 = r8.matcher(r2)
            boolean r4 = r6.find()
            r5 = 0
            if (r4 == 0) goto L_0x007b
            java.lang.String r0 = r6.group(r5)
            r4 = r0
            goto L_0x007c
        L_0x007b:
            r4 = r0
        L_0x007c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = r0
            java.lang.String r0 = r10.separator     // Catch:{ Exception -> 0x00c0 }
            java.lang.String[] r0 = r2.split(r0)     // Catch:{ Exception -> 0x00c0 }
            int r5 = r0.length     // Catch:{ Exception -> 0x00c0 }
            r19 = r4
            r4 = 0
        L_0x008c:
            if (r4 >= r5) goto L_0x00ad
            r17 = r0[r4]     // Catch:{ Exception -> 0x00be }
            r20 = r17
            r17 = r0
            r0 = r20
            boolean r20 = r0.startsWith(r9)     // Catch:{ Exception -> 0x00be }
            if (r20 == 0) goto L_0x009d
            goto L_0x00af
        L_0x009d:
            r7.append(r0)     // Catch:{ Exception -> 0x00be }
            r20 = r0
            java.lang.String r0 = r10.separator     // Catch:{ Exception -> 0x00be }
            r7.append(r0)     // Catch:{ Exception -> 0x00be }
            int r4 = r4 + 1
            r0 = r17
            goto L_0x008c
        L_0x00ad:
            r17 = r0
        L_0x00af:
            int r0 = r7.length()     // Catch:{ Exception -> 0x00be }
            r4 = 1
            int r0 = r0 - r4
            r7.deleteCharAt(r0)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x00be }
            r5 = r0
            goto L_0x00c9
        L_0x00be:
            r0 = move-exception
            goto L_0x00c3
        L_0x00c0:
            r0 = move-exception
            r19 = r4
        L_0x00c3:
            r0.printStackTrace()
            r4 = r33
            r5 = r4
        L_0x00c9:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r4 = r0
            cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityStats r0 = new cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityStats     // Catch:{ Exception -> 0x05a1 }
            r0.<init>()     // Catch:{ Exception -> 0x05a1 }
            r17 = r6
            java.lang.String r6 = r10.separator     // Catch:{ Exception -> 0x0592 }
            r0.setSeparator(r6)     // Catch:{ Exception -> 0x0592 }
            java.lang.String r6 = r10.equalizer     // Catch:{ Exception -> 0x0592 }
            r0.setEqualizer(r6)     // Catch:{ Exception -> 0x0592 }
            cn.com.mma.mobile.tracking.bean.Config r6 = r10.config     // Catch:{ Exception -> 0x0592 }
            java.util.HashMap<java.lang.String, cn.com.mma.mobile.tracking.bean.Argument> r6 = r6.viewabilityarguments     // Catch:{ Exception -> 0x0592 }
            r0.setViewabilityarguments(r6)     // Catch:{ Exception -> 0x0592 }
            java.lang.String r6 = r1.getAdAreaID(r10, r5)     // Catch:{ Exception -> 0x0592 }
            r20 = r7
            java.lang.String r7 = "ImpressionID"
            java.lang.String r7 = r0.get(r7)     // Catch:{ Exception -> 0x0583 }
            r21 = r3
            r22 = r3
            boolean r23 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0583 }
            if (r23 != 0) goto L_0x0150
            java.lang.String r23 = r1.getImpressionID(r10, r11, r6)     // Catch:{ Exception -> 0x0141 }
            r21 = r23
            java.lang.StringBuilder r23 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            r23.<init>()     // Catch:{ Exception -> 0x0141 }
            r20 = r23
            r23 = r8
            java.lang.String r8 = r10.separator     // Catch:{ Exception -> 0x0133 }
            r24 = r9
            r9 = r20
            r9.append(r8)     // Catch:{ Exception -> 0x0129 }
            r9.append(r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r8 = r10.equalizer     // Catch:{ Exception -> 0x0129 }
            r9.append(r8)     // Catch:{ Exception -> 0x0129 }
            r8 = r21
            r9.append(r8)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r20 = r9.toString()     // Catch:{ Exception -> 0x0129 }
            r22 = r20
            goto L_0x015a
        L_0x0129:
            r0 = move-exception
            r6 = r2
            r15 = r4
            r7 = r9
            r14 = r10
            r9 = r12
            r2 = r19
            goto L_0x05b1
        L_0x0133:
            r0 = move-exception
            r24 = r9
            r9 = r20
            r6 = r2
            r15 = r4
            r7 = r9
            r14 = r10
            r9 = r12
            r2 = r19
            goto L_0x05b1
        L_0x0141:
            r0 = move-exception
            r6 = r2
            r15 = r4
            r23 = r8
            r24 = r9
            r14 = r10
            r9 = r12
            r2 = r19
            r7 = r20
            goto L_0x05b1
        L_0x0150:
            r23 = r8
            r24 = r9
            r9 = r20
            r8 = r21
            r20 = r22
        L_0x015a:
            r21 = r9
            java.lang.String r9 = "ImpressionType"
            java.lang.String r9 = r0.get(r9)     // Catch:{ Exception -> 0x0578 }
            cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType r2 = cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType.EXPOSEWITHABILITY     // Catch:{ Exception -> 0x0574 }
            r22 = r15
            java.lang.String r15 = "1"
            r25 = r8
            java.lang.String r8 = "0"
            if (r11 == r2) goto L_0x0288
            cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType r2 = cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType.VIDEOEXPOSEWITHABILITY     // Catch:{ Exception -> 0x027c }
            if (r11 != r2) goto L_0x0178
            r26 = r0
            r0 = r20
            goto L_0x028c
        L_0x0178:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>()     // Catch:{ Exception -> 0x027c }
            r26 = r0
            cn.com.mma.mobile.tracking.bean.Domain r0 = r10.domain     // Catch:{ Exception -> 0x027c }
            java.lang.String r0 = r0.url     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ Exception -> 0x027c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x027c }
            cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityService r2 = r1.viewAbilityService     // Catch:{ Exception -> 0x027c }
            r2.stopForStrongInteract(r0, r14, r11)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x01f4
            cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType r2 = cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType.CLICK     // Catch:{ Exception -> 0x027c }
            if (r11 == r2) goto L_0x01f4
            if (r12 != 0) goto L_0x01c8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r10.separator     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            r2.append(r9)     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r10.equalizer     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r8.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r2.toString()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x027c }
            r5 = r8
            goto L_0x0226
        L_0x01c8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r10.separator     // Catch:{ Exception -> 0x027c }
            r2.append(r8)     // Catch:{ Exception -> 0x027c }
            r2.append(r9)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r10.equalizer     // Catch:{ Exception -> 0x027c }
            r2.append(r8)     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r8.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r2.toString()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x027c }
            r5 = r8
            goto L_0x0226
        L_0x01f4:
            r2 = 1
            if (r13 != r2) goto L_0x0226
            cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType r2 = cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType.CLICK     // Catch:{ Exception -> 0x027c }
            if (r11 == r2) goto L_0x0226
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r10.separator     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            r2.append(r9)     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r10.equalizer     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r8.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = r2.toString()     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x027c }
            r5 = r8
        L_0x0226:
            boolean r2 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x027c }
            if (r2 != 0) goto L_0x0265
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r10.separator     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r10.equalizer     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = "[^"
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = r10.separator     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.String r8 = "]*"
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x027c }
            java.lang.String r3 = r5.replaceAll(r2, r3)     // Catch:{ Exception -> 0x027c }
            r4.append(r3)     // Catch:{ Exception -> 0x027c }
            r8 = r20
            r4.append(r8)     // Catch:{ Exception -> 0x027c }
            goto L_0x026a
        L_0x0265:
            r8 = r20
            r4.append(r5)     // Catch:{ Exception -> 0x027c }
        L_0x026a:
            r15 = r4
            r0 = r6
            r27 = r7
            r18 = r8
            r12 = r9
            r14 = r10
            r2 = r19
            r7 = r21
            r30 = r25
            r29 = r26
            goto L_0x0464
        L_0x027c:
            r0 = move-exception
            r6 = r33
            r15 = r4
            r14 = r10
            r9 = r12
            r2 = r19
            r7 = r21
            goto L_0x05b1
        L_0x0288:
            r26 = r0
            r0 = r20
        L_0x028c:
            if (r12 == 0) goto L_0x042f
            cn.com.mma.mobile.tracking.bean.Switch r2 = r10.sswitch     // Catch:{ Exception -> 0x0423 }
            int r2 = r2.viewabilityTrackPolicy     // Catch:{ Exception -> 0x0423 }
            r3 = r26
            r3.setViewabilityTrackPolicy(r2)     // Catch:{ Exception -> 0x0423 }
            r3.setURLExposeDuration(r5)     // Catch:{ Exception -> 0x0423 }
            r3.setURLShowCoverRate(r5)     // Catch:{ Exception -> 0x0423 }
            cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType r2 = cn.com.mma.mobile.tracking.api.ViewAbilityHandler.MonitorType.VIDEOEXPOSEWITHABILITY     // Catch:{ Exception -> 0x0423 }
            if (r11 != r2) goto L_0x02bf
            r2 = 1
            r3.setVideoExpose(r2)     // Catch:{ Exception -> 0x02b1 }
            r2 = r36
            r3.setVideoPlayType(r2)     // Catch:{ Exception -> 0x027c }
            r3.setURLVideoDuration(r5)     // Catch:{ Exception -> 0x027c }
            r3.setURLVideoProgressTracks(r5)     // Catch:{ Exception -> 0x027c }
            goto L_0x02c1
        L_0x02b1:
            r0 = move-exception
            r2 = r36
            r6 = r33
            r15 = r4
            r14 = r10
            r9 = r12
            r2 = r19
            r7 = r21
            goto L_0x05b1
        L_0x02bf:
            r2 = r36
        L_0x02c1:
            java.lang.String r18 = r1.filterIdentifiers(r10, r3, r5)     // Catch:{ Exception -> 0x0423 }
            r20 = r18
            r2 = r20
            r4.append(r2)     // Catch:{ Exception -> 0x0423 }
            r4.append(r0)     // Catch:{ Exception -> 0x0423 }
            java.lang.StringBuffer r18 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0423 }
            r18.<init>()     // Catch:{ Exception -> 0x0423 }
            r20 = r18
            r18 = r0
            r0 = r20
            r0.append(r4)     // Catch:{ Exception -> 0x0423 }
            r20 = r2
            java.lang.String r2 = "Adviewability"
            java.lang.String r2 = r3.get(r2)     // Catch:{ Exception -> 0x0423 }
            boolean r26 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0423 }
            if (r26 != 0) goto L_0x0330
            java.lang.StringBuilder r26 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0322 }
            r26.<init>()     // Catch:{ Exception -> 0x0322 }
            r21 = r26
            r26 = r5
            java.lang.String r5 = r10.separator     // Catch:{ Exception -> 0x0314 }
            r27 = r7
            r7 = r21
            r7.append(r5)     // Catch:{ Exception -> 0x0308 }
            r7.append(r2)     // Catch:{ Exception -> 0x0308 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0308 }
            r4.append(r5)     // Catch:{ Exception -> 0x0308 }
            goto L_0x0336
        L_0x0308:
            r0 = move-exception
            r6 = r33
            r15 = r4
            r14 = r10
            r9 = r12
            r2 = r19
            r5 = r26
            goto L_0x05b1
        L_0x0314:
            r0 = move-exception
            r7 = r21
            r6 = r33
            r15 = r4
            r14 = r10
            r9 = r12
            r2 = r19
            r5 = r26
            goto L_0x05b1
        L_0x0322:
            r0 = move-exception
            r26 = r5
            r6 = r33
            r15 = r4
            r14 = r10
            r9 = r12
            r2 = r19
            r7 = r21
            goto L_0x05b1
        L_0x0330:
            r26 = r5
            r27 = r7
            r7 = r21
        L_0x0336:
            java.lang.String r5 = "AdviewabilityResult"
            java.lang.String r5 = r3.get(r5)     // Catch:{ Exception -> 0x0415 }
            boolean r21 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0415 }
            if (r21 != 0) goto L_0x0366
            if (r12 == 0) goto L_0x0366
            java.lang.StringBuilder r21 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0308 }
            r21.<init>()     // Catch:{ Exception -> 0x0308 }
            r7 = r21
            r28 = r2
            java.lang.String r2 = r10.separator     // Catch:{ Exception -> 0x0308 }
            r7.append(r2)     // Catch:{ Exception -> 0x0308 }
            r7.append(r5)     // Catch:{ Exception -> 0x0308 }
            java.lang.String r2 = r10.equalizer     // Catch:{ Exception -> 0x0308 }
            r7.append(r2)     // Catch:{ Exception -> 0x0308 }
            r7.append(r8)     // Catch:{ Exception -> 0x0308 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0308 }
            r4.append(r2)     // Catch:{ Exception -> 0x0308 }
            r2 = r7
            goto L_0x0369
        L_0x0366:
            r28 = r2
            r2 = r7
        L_0x0369:
            if (r12 == 0) goto L_0x03ec
            boolean r7 = r12 instanceof android.view.View     // Catch:{ Exception -> 0x03d8 }
            if (r7 == 0) goto L_0x03ec
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03d8 }
            r7.<init>()     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r8 = r10.separator     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r8 = r10.equalizer     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r15)     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x03d8 }
            r15 = r7
            r4.append(r15)     // Catch:{ Exception -> 0x03d8 }
            r0.append(r15)     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03d8 }
            r7.<init>()     // Catch:{ Exception -> 0x03d8 }
            cn.com.mma.mobile.tracking.bean.Domain r8 = r10.domain     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r8 = r8.url     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x03d8 }
            java.lang.StringBuilder r7 = r7.append(r6)     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x03d8 }
            cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityService r8 = r1.viewAbilityService     // Catch:{ Exception -> 0x03d8 }
            java.lang.String r21 = r0.toString()     // Catch:{ Exception -> 0x03d8 }
            r29 = r3
            r3 = r8
            r8 = r4
            r31 = r19
            r19 = r2
            r2 = r31
            r4 = r21
            r21 = r5
            r13 = r26
            r5 = r35
            r26 = r0
            r0 = r6
            r6 = r25
            r14 = r25
            r25 = r15
            r15 = r8
            r8 = r29
            r12 = r9
            r9 = r38
            r30 = r14
            r14 = r10
            r10 = r34
            r3.addViewAbilityMonitor(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x040b }
            goto L_0x0406
        L_0x03d8:
            r0 = move-exception
            r15 = r4
            r14 = r10
            r13 = r26
            r31 = r19
            r19 = r2
            r2 = r31
            r6 = r33
            r9 = r35
            r5 = r13
            r7 = r19
            goto L_0x05b1
        L_0x03ec:
            r29 = r3
            r15 = r4
            r21 = r5
            r12 = r9
            r14 = r10
            r30 = r25
            r13 = r26
            r26 = r0
            r0 = r6
            r31 = r19
            r19 = r2
            r2 = r31
            java.lang.String r3 = "监测链接传入的AdView为空,以正常曝光方式监测."
            cn.com.mma.mobile.tracking.util.Logger.w(r3)     // Catch:{ Exception -> 0x040b }
        L_0x0406:
            r5 = r13
            r7 = r19
            goto L_0x0464
        L_0x040b:
            r0 = move-exception
            r6 = r33
            r9 = r35
            r5 = r13
            r7 = r19
            goto L_0x05b1
        L_0x0415:
            r0 = move-exception
            r15 = r4
            r14 = r10
            r2 = r19
            r13 = r26
            r6 = r33
            r9 = r35
            r5 = r13
            goto L_0x05b1
        L_0x0423:
            r0 = move-exception
            r15 = r4
            r13 = r5
            r14 = r10
            r2 = r19
            r6 = r33
            r9 = r35
            goto L_0x0580
        L_0x042f:
            r18 = r0
            r15 = r4
            r13 = r5
            r0 = r6
            r27 = r7
            r12 = r9
            r14 = r10
            r2 = r19
            r30 = r25
            r29 = r26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056a }
            r3.<init>()     // Catch:{ Exception -> 0x056a }
            java.lang.String r4 = r14.separator     // Catch:{ Exception -> 0x056a }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x056a }
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch:{ Exception -> 0x056a }
            java.lang.String r4 = r14.equalizer     // Catch:{ Exception -> 0x056a }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x056a }
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ Exception -> 0x056a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x056a }
            r15.append(r13)     // Catch:{ Exception -> 0x056a }
            r15.append(r3)     // Catch:{ Exception -> 0x056a }
            r5 = r13
            r7 = r21
        L_0x0464:
            r15.append(r2)     // Catch:{ Exception -> 0x0563 }
            boolean r3 = cn.com.mma.mobile.tracking.api.Countly.LOCAL_TEST     // Catch:{ Exception -> 0x0563 }
            if (r3 == 0) goto L_0x055a
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x0563 }
            java.lang.String r4 = cn.com.mma.mobile.tracking.api.Countly.ACTION_STATS_EXPOSE     // Catch:{ Exception -> 0x0563 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0563 }
            android.content.Context r4 = r1.context     // Catch:{ Exception -> 0x0563 }
            r4.sendBroadcast(r3)     // Catch:{ Exception -> 0x0563 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r22)     // Catch:{ Exception -> 0x0563 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0563 }
            r4.<init>()     // Catch:{ Exception -> 0x0563 }
            java.lang.String r6 = "originURL:"
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ Exception -> 0x0563 }
            r6 = r33
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r8 = "monitiorType:"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r8 = "REDIRECT_STR:"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = r4.append(r2)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r8 = "withoutRedirectURL:"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r8 = "adAreaID:"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r8 = "imressionID:"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            r8 = r30
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r9 = "trackURL:"
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r9 = r15.toString()     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ Exception -> 0x0558 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0558 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0558 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0558 }
            r4.<init>()     // Catch:{ Exception -> 0x0558 }
            java.lang.String r9 = "adView:"
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ Exception -> 0x0558 }
            r9 = r35
            r10 = r12
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0555 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0555 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0555 }
            r4.<init>()     // Catch:{ Exception -> 0x0555 }
            java.lang.String r12 = "eventListener:"
            java.lang.StringBuilder r4 = r4.append(r12)     // Catch:{ Exception -> 0x0555 }
            cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityEventListener r12 = r1.mmaSdkCallback     // Catch:{ Exception -> 0x0555 }
            java.lang.StringBuilder r4 = r4.append(r12)     // Catch:{ Exception -> 0x0555 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0555 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r4)     // Catch:{ Exception -> 0x0555 }
            cn.com.mma.mobile.tracking.util.klog.KLog.i(r22)     // Catch:{ Exception -> 0x0555 }
            goto L_0x0561
        L_0x0555:
            r0 = move-exception
            goto L_0x05b1
        L_0x0558:
            r0 = move-exception
            goto L_0x0566
        L_0x055a:
            r6 = r33
            r9 = r35
            r10 = r12
            r8 = r30
        L_0x0561:
            goto L_0x05b4
        L_0x0563:
            r0 = move-exception
            r6 = r33
        L_0x0566:
            r9 = r35
            goto L_0x05b1
        L_0x056a:
            r0 = move-exception
            r6 = r33
            r9 = r35
            r5 = r13
            r7 = r21
            goto L_0x05b1
        L_0x0574:
            r0 = move-exception
            r6 = r33
            goto L_0x057a
        L_0x0578:
            r0 = move-exception
            r6 = r2
        L_0x057a:
            r15 = r4
            r13 = r5
            r14 = r10
            r9 = r12
            r2 = r19
        L_0x0580:
            r7 = r21
            goto L_0x05b1
        L_0x0583:
            r0 = move-exception
            r6 = r2
            r15 = r4
            r13 = r5
            r23 = r8
            r24 = r9
            r14 = r10
            r9 = r12
            r2 = r19
            r7 = r20
            goto L_0x05b1
        L_0x0592:
            r0 = move-exception
            r6 = r2
            r15 = r4
            r13 = r5
            r20 = r7
            r23 = r8
            r24 = r9
            r14 = r10
            r9 = r12
            r2 = r19
            goto L_0x05b1
        L_0x05a1:
            r0 = move-exception
            r15 = r4
            r13 = r5
            r17 = r6
            r20 = r7
            r23 = r8
            r24 = r9
            r14 = r10
            r9 = r12
            r6 = r2
            r2 = r19
        L_0x05b1:
            r0.printStackTrace()
        L_0x05b4:
            cn.com.mma.mobile.tracking.viewability.origin.ViewAbilityEventListener r0 = r1.mmaSdkCallback
            java.lang.String r3 = r15.toString()
            r4 = r38
            r0.onEventPresent(r3, r4, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.mma.mobile.tracking.api.ViewAbilityHandler.handlerOriginURL(java.lang.String, cn.com.mma.mobile.tracking.api.ViewAbilityHandler$MonitorType, android.view.View, int, int, cn.com.mma.mobile.tracking.viewability.origin.CallBack):void");
    }

    private String getAdAreaIdentifier(Company company) throws Exception {
        Argument argument;
        HashMap<String, Argument> adplacements = company.config.adplacements;
        if (adplacements == null || (argument = adplacements.get(ViewAbilityStats.ADPLACEMENT)) == null) {
            return "";
        }
        return argument.value;
    }

    private String getRedirectIdentifier(Company company) {
        List<Argument> arguments = company.config.arguments;
        if (arguments == null) {
            return "u";
        }
        for (Argument argument : arguments) {
            if (argument != null && !TextUtils.isEmpty(argument.key) && argument.key.equals(Constant.REDIRECTURL)) {
                return argument.value;
            }
        }
        return "u";
    }

    private boolean checkViewAbilityEnabled(ViewAbilityStats abilityStatsResult, String originUrl) throws Exception {
        String[] splits = originUrl.split(abilityStatsResult.getSeparator());
        String viewabilityIdentifier = abilityStatsResult.get(ViewAbilityStats.ADVIEWABILITY_ENABLE);
        if (!TextUtils.isEmpty(viewabilityIdentifier)) {
            String prefix = viewabilityIdentifier + abilityStatsResult.getEqualizer();
            for (String item : splits) {
                if (item.startsWith(prefix)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Company getCompany(String adURL) {
        SDK sdk = this.sdkConfig;
        if (sdk == null || sdk.companies == null) {
            this.sdkConfig = SdkConfigUpdateUtil.getSDKConfig(this.context);
            return null;
        }
        String host = CommonUtil.getHostURL(adURL);
        for (Company company : this.sdkConfig.companies) {
            if (host.endsWith(company.domain.url)) {
                return company;
            }
        }
        return null;
    }

    private String getAdAreaID(Company company, String adUrl) throws Exception {
        String adAreaIdentifier = getAdAreaIdentifier(company);
        for (String item : adUrl.split(company.separator)) {
            if (item.startsWith(adAreaIdentifier)) {
                return item.replaceFirst(adAreaIdentifier + company.equalizer, "");
            }
        }
        return "";
    }

    private String getImpressionID(Company company, MonitorType monitorType, String adAreaId) throws Exception {
        String adidKey = company.domain.url + adAreaId;
        if (monitorType == MonitorType.CLICK) {
            for (String adidkey : this.impressions.keySet()) {
                if (adidKey.equals(adidkey)) {
                    return this.impressions.get(adidkey);
                }
            }
            return "";
        }
        String impressionID = generateImpressionID(this.context, adAreaId);
        this.impressions.put(adidKey, impressionID);
        return impressionID;
    }

    private static String generateImpressionID(Context context2, String adAreaId) {
        try {
            String android2 = DeviceInfoUtil.getAndroidId(context2);
            return CommonUtil.md5("" + android2 + adAreaId + String.valueOf(System.currentTimeMillis()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String filterIdentifiers(Company company, ViewAbilityStats abilityStats, String adURL) {
        int coverRate;
        int urlExposeDuration;
        Company company2 = company;
        try {
            HashMap<String, Argument> arguments = company2.config.viewabilityarguments;
            String separator = company2.separator;
            String equalizer = company2.equalizer;
            String showCoverRate = "";
            String exposeDuration = "";
            String filterURL = adURL;
            if (arguments == null) {
                return filterURL;
            }
            String filterURL2 = filterURL;
            String exposeDuration2 = exposeDuration;
            String showCoverRate2 = showCoverRate;
            for (String argumentKey : arguments.keySet()) {
                if (!TextUtils.isEmpty(argumentKey)) {
                    String value = arguments.get(argumentKey).value;
                    if (!TextUtils.isEmpty(value)) {
                        if (!argumentKey.equals(ViewAbilityStats.ADVIEWABILITY_RECORD)) {
                            if (!argumentKey.equals(ViewAbilityStats.ADVIEWABILITY_VIDEO_DURATION)) {
                                if (!argumentKey.equals(ViewAbilityStats.ADVIEWABILITY_VIDEO_PROGRESSPOINT)) {
                                    if (argumentKey.equals(ViewAbilityStats.ADVIEWABILITY_CONFIG_THRESHOLD)) {
                                        try {
                                            int urlExposeDuration2 = abilityStats.getURLExposeDuration();
                                            if (urlExposeDuration2 > 0) {
                                                urlExposeDuration = urlExposeDuration2 / 1000;
                                            } else {
                                                urlExposeDuration = (abilityStats.isVideoExpose() ? this.abilityConfig.getVideoExposeValidDuration() : this.abilityConfig.getExposeValidDuration()) / 1000;
                                            }
                                            exposeDuration2 = value + equalizer + String.valueOf(urlExposeDuration);
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    } else if (argumentKey.equals(ViewAbilityStats.ADVIEWABILITY_CONFIG_AREA)) {
                                        try {
                                            if (abilityStats.getURLShowCoverRate() > 0.0f) {
                                                coverRate = (int) (abilityStats.getURLShowCoverRate() * 100.0f);
                                            } else {
                                                coverRate = (int) (this.abilityConfig.getCoverRateScale() * 100.0f);
                                            }
                                            showCoverRate2 = value + equalizer + String.valueOf(coverRate);
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (filterURL2.contains(separator + value + equalizer)) {
                                        filterURL2 = filterURL2.replaceAll(separator + value + equalizer + "[^" + separator + "]*", "");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append(filterURL2);
            if (!TextUtils.isEmpty(exposeDuration2)) {
                sb.append(separator);
                sb.append(exposeDuration2);
            }
            if (!TextUtils.isEmpty(showCoverRate2)) {
                sb.append(separator);
                sb.append(showCoverRate2);
            }
            return sb.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return adURL;
        }
    }
}
