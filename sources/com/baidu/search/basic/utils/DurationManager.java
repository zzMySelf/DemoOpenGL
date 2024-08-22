package com.baidu.search.basic.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.browser.components.ad.AdStatisticAttribute;
import com.baidu.browser.statistic.BrowserStatisticConstants;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.statistic.SSTPST;
import com.baidu.search.duration.pyramid.ISearchDuration;
import com.baidu.search.duration.pyramid.ISearchDurationStat;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u000201J\u0018\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u0002012\b\u0010h\u001a\u0004\u0018\u00010\u0006J\u0006\u0010i\u001a\u00020fJ\u0006\u0010j\u001a\u00020fJ\u001a\u0010k\u001a\u00020f2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010X\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\"\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R(\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010'R$\u00102\u001a\u0002012\u0006\u0010#\u001a\u000201@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u00107\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010'R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010'R\u001c\u0010=\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010'R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001c\u0010I\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010'R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010'R\u001c\u0010U\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001f\"\u0004\bW\u0010'R\u001a\u0010X\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u001f\"\u0004\bZ\u0010'R\u001c\u0010[\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u001f\"\u0004\b]\u0010'R4\u0010`\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006l"}, d2 = {"Lcom/baidu/search/basic/utils/DurationManager;", "Lcom/baidu/searchbox/NoProGuard;", "()V", "DEBUG", "", "TAG", "", "TYPE_APPLID", "", "TYPE_LID", "UBC_FROM_VALUE", "UBC_PAGE_DURATION", "UBC_PAGE_DURATION_AD_URL", "UBC_PAGE_DURATION_APPLID", "UBC_PAGE_DURATION_DURATION", "UBC_PAGE_DURATION_ENDTIME", "UBC_PAGE_DURATION_EXT_CLICK_PARAMS", "UBC_PAGE_DURATION_LID", "UBC_PAGE_DURATION_PST", "UBC_PAGE_DURATION_REFER", "UBC_PAGE_DURATION_SID", "UBC_PAGE_DURATION_SST", "UBC_PAGE_DURATION_STARTTIME", "UBC_PAGE_DURATION_URL", "UBC_PAGE_DURATION_VIDEO_LIST", "UBC_PAGE_PAGES", "UBC_PAGE_PAGES_H5_H", "UBC_PAGE_PAGES_PROGRESS", "UBC_PAGE_PAGES_WEB_H", "URL_PARAM_PD", "getURL_PARAM_PD", "()Ljava/lang/String;", "URL_PARAM_SA", "getURL_PARAM_SA", "URL_PARAM_WORD", "value", "applid", "getApplid", "setApplid", "(Ljava/lang/String;)V", "durationPage", "Lcom/baidu/search/basic/utils/DurationH5Page;", "getDurationPage", "()Lcom/baidu/search/basic/utils/DurationH5Page;", "setDurationPage", "(Lcom/baidu/search/basic/utils/DurationH5Page;)V", "from", "getFrom", "setFrom", "", "h5StartTime", "getH5StartTime", "()J", "setH5StartTime", "(J)V", "lid", "getLid", "setLid", "productForPst", "getProductForPst", "setProductForPst", "pst", "getPst", "setPst", "pstForApplid", "Lcom/baidu/search/basic/statistic/SSTPST;", "getPstForApplid", "()Lcom/baidu/search/basic/statistic/SSTPST;", "setPstForApplid", "(Lcom/baidu/search/basic/statistic/SSTPST;)V", "pstForLid", "getPstForLid", "setPstForLid", "refer", "getRefer", "setRefer", "searchDurationStat", "Lcom/baidu/search/duration/pyramid/ISearchDurationStat;", "getSearchDurationStat", "()Lcom/baidu/search/duration/pyramid/ISearchDurationStat;", "setSearchDurationStat", "(Lcom/baidu/search/duration/pyramid/ISearchDurationStat;)V", "source", "getSource", "setSource", "sst", "getSst", "setSst", "type", "getType", "setType", "url", "getUrl", "setUrl", "", "Lorg/json/JSONObject;", "videoTabList", "getVideoTabList", "()Ljava/util/List;", "setVideoTabList", "(Ljava/util/List;)V", "finishDuration", "", "finishTime", "ad_rul", "refreshUbcSession", "startDuration", "updatePst", "lib_search_basic_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DurationManager.kt */
public final class DurationManager implements NoProGuard {
    private final boolean DEBUG = AppConfig.isDebug();
    private final String TAG = "DurationManager";
    private final int TYPE_APPLID = 1;
    private final int TYPE_LID;
    private final String UBC_FROM_VALUE = "search";
    private final String UBC_PAGE_DURATION = "843";
    private final String UBC_PAGE_DURATION_AD_URL = AdStatisticAttribute.UBC_PAGE_DURATION_AD_URL;
    private final String UBC_PAGE_DURATION_APPLID = "applid";
    private final String UBC_PAGE_DURATION_DURATION = "duration";
    private final String UBC_PAGE_DURATION_ENDTIME = "endtime";
    private final String UBC_PAGE_DURATION_EXT_CLICK_PARAMS = "extclickparams";
    private final String UBC_PAGE_DURATION_LID = "lid";
    private final String UBC_PAGE_DURATION_PST = "pst";
    private final String UBC_PAGE_DURATION_REFER = "refer";
    private final String UBC_PAGE_DURATION_SID = "sid";
    private final String UBC_PAGE_DURATION_SST = "sst";
    private final String UBC_PAGE_DURATION_STARTTIME = "starttime";
    private final String UBC_PAGE_DURATION_URL = "url";
    private final String UBC_PAGE_DURATION_VIDEO_LIST = "videoTabList";
    private final String UBC_PAGE_PAGES = "pages";
    private final String UBC_PAGE_PAGES_H5_H = BrowserStatisticConstants.UBC_PAGE_PAGES_H5_H;
    private final String UBC_PAGE_PAGES_PROGRESS = "progress";
    private final String UBC_PAGE_PAGES_WEB_H = BrowserStatisticConstants.UBC_PAGE_PAGES_WEB_H;
    private final String URL_PARAM_PD = "pd";
    private final String URL_PARAM_SA = "sa";
    private final String URL_PARAM_WORD = "word";
    private String applid;
    private DurationH5Page durationPage;
    private String from;
    private long h5StartTime;
    private String lid;
    private String productForPst;
    private String pst;
    private SSTPST pstForApplid;
    private SSTPST pstForLid;
    private String refer;
    private ISearchDurationStat searchDurationStat;
    private String source;
    private String sst;
    private String type = "noh5";
    private String url;
    private List<? extends JSONObject> videoTabList;

    public final String getURL_PARAM_PD() {
        return this.URL_PARAM_PD;
    }

    public final String getURL_PARAM_SA() {
        return this.URL_PARAM_SA;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getFrom() {
        return this.from;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setFrom(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0017
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r1.length()
            if (r2 != 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            java.lang.String r0 = (java.lang.String) r0
        L_0x0017:
            r3.from = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.search.basic.utils.DurationManager.setFrom(java.lang.String):void");
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getLid() {
        return this.lid;
    }

    public final void setLid(String value) {
        if (!Intrinsics.areEqual((Object) this.lid, (Object) value)) {
            updatePst(value, this.TYPE_LID);
        }
        this.lid = value;
    }

    public final String getApplid() {
        return this.applid;
    }

    public final void setApplid(String value) {
        if (!Intrinsics.areEqual((Object) this.applid, (Object) value)) {
            updatePst(value, this.TYPE_APPLID);
        }
        this.applid = value;
    }

    public final String getSst() {
        return this.sst;
    }

    public final void setSst(String str) {
        this.sst = str;
    }

    public final String getPst() {
        return this.pst;
    }

    public final void setPst(String str) {
        this.pst = str;
    }

    public final String getRefer() {
        return this.refer;
    }

    public final void setRefer(String str) {
        this.refer = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getProductForPst() {
        return this.productForPst;
    }

    public final void setProductForPst(String str) {
        this.productForPst = str;
    }

    public final SSTPST getPstForLid() {
        return this.pstForLid;
    }

    public final void setPstForLid(SSTPST sstpst) {
        this.pstForLid = sstpst;
    }

    public final SSTPST getPstForApplid() {
        return this.pstForApplid;
    }

    public final void setPstForApplid(SSTPST sstpst) {
        this.pstForApplid = sstpst;
    }

    public final List<JSONObject> getVideoTabList() {
        return this.videoTabList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<? extends org.json.JSONObject>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.List<? extends org.json.JSONObject>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.util.List<? extends org.json.JSONObject>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.List<? extends org.json.JSONObject>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.List<? extends org.json.JSONObject>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setVideoTabList(java.util.List<? extends org.json.JSONObject> r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0012
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x000f
            r1 = 0
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            java.util.List r0 = (java.util.List) r0
        L_0x0012:
            r3.videoTabList = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.search.basic.utils.DurationManager.setVideoTabList(java.util.List):void");
    }

    public final long getH5StartTime() {
        return this.h5StartTime;
    }

    public final void setH5StartTime(long value) {
        if (this.DEBUG) {
            Log.i(this.TAG, "h5StartTime");
        }
        this.h5StartTime = value;
    }

    public final ISearchDurationStat getSearchDurationStat() {
        return this.searchDurationStat;
    }

    public final void setSearchDurationStat(ISearchDurationStat iSearchDurationStat) {
        this.searchDurationStat = iSearchDurationStat;
    }

    public final DurationH5Page getDurationPage() {
        return this.durationPage;
    }

    public final void setDurationPage(DurationH5Page durationH5Page) {
        this.durationPage = durationH5Page;
    }

    public final void startDuration() {
        if (this.DEBUG) {
            Log.i(this.TAG, "startDuration");
        }
        ISearchDuration iSearchDuration = (ISearchDuration) ServiceManager.getService(ISearchDuration.Companion.getSERVICE_REFERENCE());
        ISearchDurationStat statInstance = iSearchDuration != null ? iSearchDuration.getStatInstance() : null;
        this.searchDurationStat = statInstance;
        long j2 = this.h5StartTime;
        if (j2 != 0) {
            if (statInstance != null) {
                statInstance.startLogDuration(Long.valueOf(j2));
            }
            setH5StartTime(0);
        } else if (statInstance != null) {
            statInstance.startLogDuration();
        }
    }

    public final void finishDuration(long finishTime) {
        finishDuration(finishTime, (String) null);
    }

    public final void finishDuration(long finishTime, String ad_rul) {
        ISearchDurationStat durationStat = this.searchDurationStat;
        if (durationStat != null) {
            try {
                Map params = UrlUtils.getParamsMap(this.url);
                String str = null;
                ISearchDurationStat pd = durationStat.setSa(params != null ? params.get(this.URL_PARAM_SA) : null).setPd(params != null ? params.get(this.URL_PARAM_PD) : null);
                if (params != null) {
                    str = params.get(this.URL_PARAM_WORD);
                }
                pd.setQuery(str);
            } catch (RuntimeException e2) {
                if (AppConfig.isDebug()) {
                    Log.e(this.TAG, "finishDuration: missing params. url=" + this.url);
                    Log.e(this.TAG, "finishDuration: missing params.", e2);
                }
            }
            ISearchDurationStat type2 = durationStat.setType(this.type);
            String str2 = this.from;
            if (str2 == null) {
                str2 = this.UBC_FROM_VALUE;
            }
            type2.setFrom(str2).setSource(this.source).setUrl(this.url).setRefer(this.refer);
            if (ad_rul != null) {
                durationStat.setExtraValue(this.UBC_PAGE_DURATION_AD_URL, ad_rul);
            }
            DurationH5Page it = this.durationPage;
            if (it != null) {
                durationStat.setExtraValue(this.UBC_PAGE_PAGES, new JSONObject().put(this.UBC_PAGE_PAGES_WEB_H, it.getWebViewHeight()).put(this.UBC_PAGE_PAGES_H5_H, Float.valueOf(it.getH5ContentHeight())).put(this.UBC_PAGE_PAGES_PROGRESS, Float.valueOf(it.getProgress())));
            }
            List it2 = this.videoTabList;
            if (it2 != null) {
                durationStat.setExtraValue(this.UBC_PAGE_DURATION_VIDEO_LIST, it2);
            }
            durationStat.syncPst().endLogDuration();
        }
    }

    public final void refreshUbcSession() {
        UBCDurationSearchSession.setLid(this.lid);
        UBCDurationSearchSession.setApplid(this.applid);
        UBCDurationSearchSession.setSst(this.sst);
        UBCDurationSearchSession.setPst(this.pst);
    }

    private final void updatePst(String lid2, int type2) {
        if (!TextUtils.isEmpty(lid2)) {
            String sessionType = "2";
            if (type2 == this.TYPE_APPLID) {
                sessionType = "3";
            }
            SSTPST newpst = new SSTPST("2", "1", this.productForPst, sessionType, lid2, "1", "0");
            if (type2 == this.TYPE_APPLID) {
                this.pstForApplid = newpst;
            } else {
                this.pstForLid = newpst;
            }
            if (TextUtils.isEmpty(this.pst)) {
                this.pst = newpst.getStr62();
            } else {
                this.pst += AbstractJsonLexerKt.COMMA + newpst.getStr62();
            }
        }
    }
}
