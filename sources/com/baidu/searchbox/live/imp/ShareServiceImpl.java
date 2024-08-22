package com.baidu.searchbox.live.imp;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.service.ShareService;
import com.baidu.searchbox.socialshare.BDShare;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016JR\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\\\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016Jx\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0001\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0001\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u000e*\u00020\u001cH\u0002¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/imp/ShareServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/ShareService;", "()V", "canShareInLandScreen", "", "clean", "", "isShowing", "startShare", "context", "Landroid/content/Context;", "root", "Landroid/view/View;", "title", "", "content", "linkUrl", "iconUrl", "ext", "listener", "Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;", "userInfo", "source", "type", "", "talosLiteData", "ugcScheme", "command", "Lcom/baidu/searchbox/live/interfaces/service/ShareService$BdCommand;", "formatJson", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareServiceImpl.kt */
public final class ShareServiceImpl implements ShareService {
    public void startShare(Context context, View root, String title, String content, String linkUrl, String iconUrl, String ext, ShareService.IOnSocialListener listener) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(ext, "ext");
        startShare(context, root, title, content, linkUrl, iconUrl, ext, "", listener);
    }

    public void startShare(Context context, View root, String title, String content, String linkUrl, String iconUrl, String ext, String userInfo, ShareService.IOnSocialListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(ext, "ext");
        startShare(context, root, title, content, linkUrl, iconUrl, ext, "", "", 1, "", listener);
    }

    public void startShare(Context context, View root, String title, String content, String linkUrl, String iconUrl, String ext, String userInfo, String source, int type, String talosLiteData, ShareService.IOnSocialListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(ext, "ext");
        startShare(context, root, title, content, linkUrl, iconUrl, ext, "", "", 1, "", "", listener);
    }

    public void startShare(Context context, View root, String title, String content, String linkUrl, String iconUrl, String ext, String userInfo, String source, int type, String talosLiteData, String ugcScheme, ShareService.IOnSocialListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(ext, "ext");
        startShare(context, root, title, content, linkUrl, iconUrl, ext, userInfo, source, type, talosLiteData, ugcScheme, (ShareService.BdCommand) null, listener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startShare(android.content.Context r24, android.view.View r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, java.lang.String r34, java.lang.String r35, com.baidu.searchbox.live.interfaces.service.ShareService.BdCommand r36, com.baidu.searchbox.live.interfaces.service.ShareService.IOnSocialListener r37) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r27
            r4 = r30
            r5 = r34
            r6 = r35
            r7 = r36
            r8 = r37
            java.lang.String r0 = "share_channel"
            java.lang.String r9 = "share_image_url"
            java.lang.String r10 = "share_type"
            java.lang.String r11 = "share_source"
            java.lang.String r12 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r12)
            java.lang.String r12 = "root"
            r13 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r12)
            java.lang.String r12 = "ext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r12)
            com.baidu.searchbox.live.interfaces.context.PluginContextUtil r12 = com.baidu.searchbox.live.interfaces.context.PluginContextUtil.INSTANCE
            android.content.Context r12 = r12.getRealContext(r2)
            r14 = r32
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            if (r14 == 0) goto L_0x0043
            boolean r14 = kotlin.text.StringsKt.isBlank(r14)
            if (r14 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r14 = 0
            goto L_0x0044
        L_0x0043:
            r14 = 1
        L_0x0044:
            if (r14 != 0) goto L_0x0049
            r14 = r32
            goto L_0x004b
        L_0x0049:
            java.lang.String r14 = "liveshow"
        L_0x004b:
            r17 = 1
            java.lang.String r18 = ""
            java.lang.String r19 = "all"
            java.lang.String r20 = ""
            r21 = r4
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21     // Catch:{ Exception -> 0x00d5 }
            boolean r21 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x00d5 }
            if (r21 != 0) goto L_0x00cd
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d5 }
            r15.<init>(r4)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = "yy_anchor_bduid"
            boolean r2 = r15.has(r2)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x0072
            java.lang.String r2 = "yyshow"
            r20 = r2
        L_0x0072:
            boolean r2 = r15.has(r11)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x008f
            r2 = r32
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x0087
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r2 = 0
            goto L_0x0088
        L_0x0087:
            r2 = 1
        L_0x0088:
            if (r2 == 0) goto L_0x008f
            java.lang.String r2 = r15.optString(r11)     // Catch:{ Exception -> 0x00d5 }
            r14 = r2
        L_0x008f:
            boolean r2 = r15.has(r10)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x009b
            int r2 = r15.optInt(r10)     // Catch:{ Exception -> 0x00d5 }
            r17 = r2
        L_0x009b:
            boolean r2 = r15.has(r9)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x00ac
            java.lang.String r2 = r15.optString(r9)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r9 = "extJO.optString(\"share_image_url\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ Exception -> 0x00d5 }
            r18 = r2
        L_0x00ac:
            boolean r2 = r15.has(r0)     // Catch:{ Exception -> 0x00d5 }
            if (r2 == 0) goto L_0x00c5
            java.lang.String r0 = r15.optString(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = "extJO.optString(\"share_channel\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x00d5 }
            r19 = r0
            r2 = r14
            r9 = r18
            r10 = r19
            r11 = r20
            goto L_0x00e0
        L_0x00c5:
            r2 = r14
            r9 = r18
            r10 = r19
            r11 = r20
            goto L_0x00e0
        L_0x00cd:
            r2 = r14
            r9 = r18
            r10 = r19
            r11 = r20
            goto L_0x00e0
        L_0x00d5:
            r0 = move-exception
            r0.printStackTrace()
            r2 = r14
            r9 = r18
            r10 = r19
            r11 = r20
        L_0x00e0:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = new com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder
            r0.<init>()
            java.lang.String r14 = ""
            if (r26 != 0) goto L_0x00eb
            r15 = r14
            goto L_0x00ed
        L_0x00eb:
            r15 = r26
        L_0x00ed:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setTitle(r15)
            if (r3 != 0) goto L_0x00f5
            r15 = r14
            goto L_0x00f6
        L_0x00f5:
            r15 = r3
        L_0x00f6:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setContent(r15)
            if (r28 != 0) goto L_0x00fe
            r15 = r14
            goto L_0x0100
        L_0x00fe:
            r15 = r28
        L_0x0100:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setLinkUrl(r15)
            if (r29 != 0) goto L_0x0108
            r15 = r14
            goto L_0x010a
        L_0x0108:
            r15 = r29
        L_0x010a:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setIconUrl(r15)
            com.baidu.searchbox.socialshare.statistics.SharePageEnum r15 = com.baidu.searchbox.socialshare.statistics.SharePageEnum.OTHER
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setSourcePage(r15)
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setMediaType(r10)
            r15 = r11
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0123
            r15 = r2
            goto L_0x0124
        L_0x0123:
            r15 = r11
        L_0x0124:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setSource(r15)
            java.lang.String r15 = com.baidu.searchbox.socialshare.bean.MediaType.SCREENSHOT
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.addRemoveMenuItem((java.lang.String) r15)
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setCategoryInfo(r4)
            if (r31 != 0) goto L_0x0135
            goto L_0x0137
        L_0x0135:
            r14 = r31
        L_0x0137:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setUserInfo(r14)
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setImageUrl(r9)
            r15 = r0
            r0 = 0
            switch(r33) {
                case 1: goto L_0x01a0;
                case 2: goto L_0x0191;
                case 3: goto L_0x0177;
                case 4: goto L_0x016c;
                case 5: goto L_0x0148;
                default: goto L_0x0144;
            }
        L_0x0144:
            r22 = r2
            goto L_0x01ef
        L_0x0148:
            r17 = 3
            r14 = 1
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r15.setNeedImagePreview(r14)
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setPosterTalosData(r5)
            com.baidu.searchbox.socialshare.bean.ShareMenuType r14 = com.baidu.searchbox.socialshare.bean.ShareMenuType.MENU_SINGLE_LINE
            java.lang.String r14 = r14.toString()
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r0.setPanelStyle(r14)
            com.baidu.share.core.bean.Theme r14 = com.baidu.share.core.bean.Theme.SINGLE_LINE
            java.lang.String r14 = r14.getType()
            r0.setTheme(r14)
            r22 = r2
            r2 = r17
            goto L_0x01f1
        L_0x016c:
            r17 = 9
            r15.setTextContent(r3)
            r22 = r2
            r2 = r17
            goto L_0x01f1
        L_0x0177:
            r17 = 8
            if (r7 == 0) goto L_0x017f
            java.lang.String r0 = r1.formatJson(r7)
        L_0x017f:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r15.setCommandData(r0)
            com.baidu.share.widget.MenuItem r14 = com.baidu.share.widget.MenuItem.FORWARD
            java.lang.String r14 = r14.name()
            r0.addRemoveMenuItem((java.lang.String) r14)
            r22 = r2
            r2 = r17
            goto L_0x01f1
        L_0x0191:
            r14 = 1
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r15.setNeedImagePreview(r14)
            r0.setTalosLiteData(r5)
            r17 = 3
            r22 = r2
            r2 = r17
            goto L_0x01f1
        L_0x01a0:
            if (r5 == 0) goto L_0x01b6
            r14 = r5
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            if (r14 <= 0) goto L_0x01ad
            r14 = 1
            goto L_0x01ae
        L_0x01ad:
            r14 = 0
        L_0x01ae:
            r22 = r2
            r2 = 1
            if (r14 != r2) goto L_0x01b9
            r21 = r2
            goto L_0x01bb
        L_0x01b6:
            r22 = r2
            r2 = 1
        L_0x01b9:
            r21 = 0
        L_0x01bb:
            if (r21 == 0) goto L_0x01c4
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r14 = r15.setNeedImagePreview(r2)
            r14.setPosterTalosData(r5)
        L_0x01c4:
            if (r7 == 0) goto L_0x01ca
            java.lang.String r0 = r1.formatJson(r7)
        L_0x01ca:
            if (r0 == 0) goto L_0x01de
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x01d7
            r14 = 1
            goto L_0x01d8
        L_0x01d7:
            r14 = 0
        L_0x01d8:
            r2 = 1
            if (r14 != r2) goto L_0x01de
            r16 = r2
            goto L_0x01e0
        L_0x01de:
            r16 = 0
        L_0x01e0:
            if (r16 == 0) goto L_0x01ef
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r2 = r15.setCommandData(r0)
            com.baidu.share.widget.MenuItem r14 = com.baidu.share.widget.MenuItem.FORWARD
            java.lang.String r14 = r14.name()
            r2.addRemoveMenuItem((java.lang.String) r14)
        L_0x01ef:
            r2 = r17
        L_0x01f1:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x020f
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x020e }
            r0.<init>()     // Catch:{ Exception -> 0x020e }
            java.lang.String r14 = "ugc_scheme"
            r0.putOpt(r14, r6)     // Catch:{ Exception -> 0x020e }
            java.lang.String r14 = r0.toString()     // Catch:{ Exception -> 0x020e }
            r15.setCategoryData(r14)     // Catch:{ Exception -> 0x020e }
            goto L_0x020f
        L_0x020e:
            r0 = move-exception
        L_0x020f:
            com.baidu.searchbox.socialshare.bean.BaiduShareContent$Builder r0 = r15.setShareType(r2)
            com.baidu.searchbox.socialshare.bean.BaiduShareContent r0 = r0.create()
            r14 = r10
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0250
            r14 = r10
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r16 = "all"
            r1 = r16
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.equals(r14, r1)
            if (r1 == 0) goto L_0x0232
            r21 = r2
            goto L_0x0252
        L_0x0232:
            com.baidu.searchbox.live.imp.ShareServiceImpl$startShare$onSocialListener$1 r1 = new com.baidu.searchbox.live.imp.ShareServiceImpl$startShare$onSocialListener$1
            r1.<init>(r8)
            com.baidu.searchbox.socialshare.BDShare r14 = com.baidu.searchbox.socialshare.BDShare.getInstance()
            r21 = r2
            r2 = r1
            com.baidu.searchbox.socialshare.OnSocialListener r2 = (com.baidu.searchbox.socialshare.OnSocialListener) r2
            r14.setOnSocialListener(r2)
            com.baidu.searchbox.socialshare.BDShare r2 = com.baidu.searchbox.socialshare.BDShare.getInstance()
            android.view.View r14 = r25.getRootView()
            r2.share(r12, r14, r0)
            r2 = r15
            goto L_0x027d
        L_0x0250:
            r21 = r2
        L_0x0252:
            com.baidu.searchbox.live.imp.ShareServiceImpl$startShare$shareListener$1 r1 = new com.baidu.searchbox.live.imp.ShareServiceImpl$startShare$shareListener$1
            r1.<init>(r8)
            com.baidu.searchbox.socialshare.BDShare r14 = com.baidu.searchbox.socialshare.BDShare.getInstance()
            android.view.View r16 = r25.getRootView()
            com.baidu.searchbox.socialshare.plugin.PluginShareListener r18 = new com.baidu.searchbox.socialshare.plugin.PluginShareListener
            r18.<init>()
            r2 = r18
            r17 = 0
            r3 = r1
            com.baidu.searchbox.socialshare.plugin.PluginShareResultListenr r3 = (com.baidu.searchbox.socialshare.plugin.PluginShareResultListenr) r3
            r2.bindShareResultListener(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r19 = r1
            com.baidu.searchbox.socialshare.plugin.PluginShareResultListenr r19 = (com.baidu.searchbox.socialshare.plugin.PluginShareResultListenr) r19
            r20 = 0
            r2 = r15
            r15 = r12
            r17 = r0
            r14.shareForPlugin(r15, r16, r17, r18, r19, r20)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.imp.ShareServiceImpl.startShare(android.content.Context, android.view.View, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, com.baidu.searchbox.live.interfaces.service.ShareService$BdCommand, com.baidu.searchbox.live.interfaces.service.ShareService$IOnSocialListener):void");
    }

    public void clean() {
        BDShare.clean();
    }

    public boolean isShowing() {
        return BDShare.getInstance().isShowing();
    }

    public boolean canShareInLandScreen() {
        return true;
    }

    private final String formatJson(ShareService.BdCommand $this$formatJson) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ShareService.BdCommand $this$formatJson_u24lambda_u2d3 = $this$formatJson;
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$formatJson_u24lambda_u2d3_u24lambda_u2d2 = jSONObject;
            $this$formatJson_u24lambda_u2d3_u24lambda_u2d2.put("cmd_pannel", new JSONArray($this$formatJson_u24lambda_u2d3.getChannels()));
            JSONObject info = new JSONObject();
            info.put("type", $this$formatJson_u24lambda_u2d3.getType()).put("img_show", $this$formatJson_u24lambda_u2d3.getImgUrl()).put("img_save", $this$formatJson_u24lambda_u2d3.getImgSavePath()).put("key", $this$formatJson_u24lambda_u2d3.getCmdKey()).put("title", $this$formatJson_u24lambda_u2d3.getTitle()).put("content", $this$formatJson_u24lambda_u2d3.getContent());
            Unit unit = Unit.INSTANCE;
            $this$formatJson_u24lambda_u2d3_u24lambda_u2d2.put("info", info);
            obj = Result.m8971constructorimpl(jSONObject.toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && AppConfig.isDebug()) {
            it.printStackTrace();
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }
}
