package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.js;

import com.baidu.voice.vscb.IVoiceSearchCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003Jy\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/model/js/JsMappingBean;", "", "iThirdPartSearchCallBack", "Lcom/baidu/voice/vscb/IVoiceSearchCallback$IThirdPartSearchCallBack;", "url", "", "titleListeningContent", "titleGuideContent", "titleGuideWakeUpContent", "titleGuideErrorContent", "titleGuideErrorWakeUpContent", "jsVoiceFrom", "shouldTakeOverWakeUp", "shouldTakeOverVoiceRecognitionResult", "hideSettingButton", "(Lcom/baidu/voice/vscb/IVoiceSearchCallback$IThirdPartSearchCallBack;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHideSettingButton", "()Ljava/lang/String;", "getIThirdPartSearchCallBack", "()Lcom/baidu/voice/vscb/IVoiceSearchCallback$IThirdPartSearchCallBack;", "setIThirdPartSearchCallBack", "(Lcom/baidu/voice/vscb/IVoiceSearchCallback$IThirdPartSearchCallBack;)V", "getJsVoiceFrom", "getShouldTakeOverVoiceRecognitionResult", "getShouldTakeOverWakeUp", "getTitleGuideContent", "getTitleGuideErrorContent", "getTitleGuideErrorWakeUpContent", "getTitleGuideWakeUpContent", "getTitleListeningContent", "getUrl", "setUrl", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsMappingBean.kt */
public final class JsMappingBean {
    private final String hideSettingButton;
    private IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack;
    private final String jsVoiceFrom;
    private final String shouldTakeOverVoiceRecognitionResult;
    private final String shouldTakeOverWakeUp;
    private final String titleGuideContent;
    private final String titleGuideErrorContent;
    private final String titleGuideErrorWakeUpContent;
    private final String titleGuideWakeUpContent;
    private final String titleListeningContent;
    private String url;

    public JsMappingBean() {
        this((IVoiceSearchCallback.IThirdPartSearchCallBack) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ JsMappingBean copy$default(JsMappingBean jsMappingBean, IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, Object obj) {
        JsMappingBean jsMappingBean2 = jsMappingBean;
        int i3 = i2;
        return jsMappingBean.copy((i3 & 1) != 0 ? jsMappingBean2.iThirdPartSearchCallBack : iThirdPartSearchCallBack2, (i3 & 2) != 0 ? jsMappingBean2.url : str, (i3 & 4) != 0 ? jsMappingBean2.titleListeningContent : str2, (i3 & 8) != 0 ? jsMappingBean2.titleGuideContent : str3, (i3 & 16) != 0 ? jsMappingBean2.titleGuideWakeUpContent : str4, (i3 & 32) != 0 ? jsMappingBean2.titleGuideErrorContent : str5, (i3 & 64) != 0 ? jsMappingBean2.titleGuideErrorWakeUpContent : str6, (i3 & 128) != 0 ? jsMappingBean2.jsVoiceFrom : str7, (i3 & 256) != 0 ? jsMappingBean2.shouldTakeOverWakeUp : str8, (i3 & 512) != 0 ? jsMappingBean2.shouldTakeOverVoiceRecognitionResult : str9, (i3 & 1024) != 0 ? jsMappingBean2.hideSettingButton : str10);
    }

    public final IVoiceSearchCallback.IThirdPartSearchCallBack component1() {
        return this.iThirdPartSearchCallBack;
    }

    public final String component10() {
        return this.shouldTakeOverVoiceRecognitionResult;
    }

    public final String component11() {
        return this.hideSettingButton;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.titleListeningContent;
    }

    public final String component4() {
        return this.titleGuideContent;
    }

    public final String component5() {
        return this.titleGuideWakeUpContent;
    }

    public final String component6() {
        return this.titleGuideErrorContent;
    }

    public final String component7() {
        return this.titleGuideErrorWakeUpContent;
    }

    public final String component8() {
        return this.jsVoiceFrom;
    }

    public final String component9() {
        return this.shouldTakeOverWakeUp;
    }

    public final JsMappingBean copy(IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "titleListeningContent");
        Intrinsics.checkNotNullParameter(str3, "titleGuideContent");
        Intrinsics.checkNotNullParameter(str4, "titleGuideWakeUpContent");
        Intrinsics.checkNotNullParameter(str5, "titleGuideErrorContent");
        Intrinsics.checkNotNullParameter(str6, "titleGuideErrorWakeUpContent");
        String str11 = str7;
        Intrinsics.checkNotNullParameter(str11, "jsVoiceFrom");
        Intrinsics.checkNotNullParameter(str8, JsCommandKt.PARAMS_TAKE_OVER_WAKE_UP);
        Intrinsics.checkNotNullParameter(str9, "shouldTakeOverVoiceRecognitionResult");
        Intrinsics.checkNotNullParameter(str10, "hideSettingButton");
        return new JsMappingBean(iThirdPartSearchCallBack2, str, str2, str3, str4, str5, str6, str11, str8, str9, str10);
    }

    public int hashCode() {
        IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack2 = this.iThirdPartSearchCallBack;
        return ((((((((((((((((((((iThirdPartSearchCallBack2 == null ? 0 : iThirdPartSearchCallBack2.hashCode()) * 31) + this.url.hashCode()) * 31) + this.titleListeningContent.hashCode()) * 31) + this.titleGuideContent.hashCode()) * 31) + this.titleGuideWakeUpContent.hashCode()) * 31) + this.titleGuideErrorContent.hashCode()) * 31) + this.titleGuideErrorWakeUpContent.hashCode()) * 31) + this.jsVoiceFrom.hashCode()) * 31) + this.shouldTakeOverWakeUp.hashCode()) * 31) + this.shouldTakeOverVoiceRecognitionResult.hashCode()) * 31) + this.hideSettingButton.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JsMappingBean(iThirdPartSearchCallBack=").append(this.iThirdPartSearchCallBack).append(", url=").append(this.url).append(", titleListeningContent=").append(this.titleListeningContent).append(", titleGuideContent=").append(this.titleGuideContent).append(", titleGuideWakeUpContent=").append(this.titleGuideWakeUpContent).append(", titleGuideErrorContent=").append(this.titleGuideErrorContent).append(", titleGuideErrorWakeUpContent=").append(this.titleGuideErrorWakeUpContent).append(", jsVoiceFrom=").append(this.jsVoiceFrom).append(", shouldTakeOverWakeUp=").append(this.shouldTakeOverWakeUp).append(", shouldTakeOverVoiceRecognitionResult=").append(this.shouldTakeOverVoiceRecognitionResult).append(", hideSettingButton=").append(this.hideSettingButton).append(')');
        return sb.toString();
    }

    public JsMappingBean(IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack2, String url2, String titleListeningContent2, String titleGuideContent2, String titleGuideWakeUpContent2, String titleGuideErrorContent2, String titleGuideErrorWakeUpContent2, String jsVoiceFrom2, String shouldTakeOverWakeUp2, String shouldTakeOverVoiceRecognitionResult2, String hideSettingButton2) {
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(titleListeningContent2, "titleListeningContent");
        Intrinsics.checkNotNullParameter(titleGuideContent2, "titleGuideContent");
        Intrinsics.checkNotNullParameter(titleGuideWakeUpContent2, "titleGuideWakeUpContent");
        Intrinsics.checkNotNullParameter(titleGuideErrorContent2, "titleGuideErrorContent");
        Intrinsics.checkNotNullParameter(titleGuideErrorWakeUpContent2, "titleGuideErrorWakeUpContent");
        Intrinsics.checkNotNullParameter(jsVoiceFrom2, "jsVoiceFrom");
        Intrinsics.checkNotNullParameter(shouldTakeOverWakeUp2, JsCommandKt.PARAMS_TAKE_OVER_WAKE_UP);
        Intrinsics.checkNotNullParameter(shouldTakeOverVoiceRecognitionResult2, "shouldTakeOverVoiceRecognitionResult");
        Intrinsics.checkNotNullParameter(hideSettingButton2, "hideSettingButton");
        this.iThirdPartSearchCallBack = iThirdPartSearchCallBack2;
        this.url = url2;
        this.titleListeningContent = titleListeningContent2;
        this.titleGuideContent = titleGuideContent2;
        this.titleGuideWakeUpContent = titleGuideWakeUpContent2;
        this.titleGuideErrorContent = titleGuideErrorContent2;
        this.titleGuideErrorWakeUpContent = titleGuideErrorWakeUpContent2;
        this.jsVoiceFrom = jsVoiceFrom2;
        this.shouldTakeOverWakeUp = shouldTakeOverWakeUp2;
        this.shouldTakeOverVoiceRecognitionResult = shouldTakeOverVoiceRecognitionResult2;
        this.hideSettingButton = hideSettingButton2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JsMappingBean(com.baidu.voice.vscb.IVoiceSearchCallback.IThirdPartSearchCallBack r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r12
        L_0x0009:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r13
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r15
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r3
            goto L_0x0028
        L_0x0026:
            r6 = r16
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r3
            goto L_0x0030
        L_0x002e:
            r7 = r17
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r3
            goto L_0x0038
        L_0x0036:
            r8 = r18
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r3 = r19
        L_0x003f:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0046
            java.lang.String r9 = "0"
            goto L_0x0048
        L_0x0046:
            r9 = r20
        L_0x0048:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x004f
            java.lang.String r10 = "1"
            goto L_0x0051
        L_0x004f:
            r10 = r21
        L_0x0051:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = "show"
            goto L_0x005b
        L_0x0059:
            r0 = r22
        L_0x005b:
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r3
            r20 = r9
            r21 = r10
            r22 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mms.voicesearch.mmsvoicesearchv2.model.js.JsMappingBean.<init>(com.baidu.voice.vscb.IVoiceSearchCallback$IThirdPartSearchCallBack, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final IVoiceSearchCallback.IThirdPartSearchCallBack getIThirdPartSearchCallBack() {
        return this.iThirdPartSearchCallBack;
    }

    public final void setIThirdPartSearchCallBack(IVoiceSearchCallback.IThirdPartSearchCallBack iThirdPartSearchCallBack2) {
        this.iThirdPartSearchCallBack = iThirdPartSearchCallBack2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getTitleListeningContent() {
        return this.titleListeningContent;
    }

    public final String getTitleGuideContent() {
        return this.titleGuideContent;
    }

    public final String getTitleGuideWakeUpContent() {
        return this.titleGuideWakeUpContent;
    }

    public final String getTitleGuideErrorContent() {
        return this.titleGuideErrorContent;
    }

    public final String getTitleGuideErrorWakeUpContent() {
        return this.titleGuideErrorWakeUpContent;
    }

    public final String getJsVoiceFrom() {
        return this.jsVoiceFrom;
    }

    public final String getShouldTakeOverWakeUp() {
        return this.shouldTakeOverWakeUp;
    }

    public final String getShouldTakeOverVoiceRecognitionResult() {
        return this.shouldTakeOverVoiceRecognitionResult;
    }

    public final String getHideSettingButton() {
        return this.hideSettingButton;
    }

    public boolean equals(Object other) {
        if (other instanceof String) {
            return Intrinsics.areEqual(other, (Object) this.url);
        }
        return super.equals(other);
    }
}
