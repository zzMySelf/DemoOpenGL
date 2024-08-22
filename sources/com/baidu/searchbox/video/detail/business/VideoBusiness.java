package com.baidu.searchbox.video.detail.business;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "", "from", "", "page", "pd", "scene", "secondJumpSource", "setScene", "", "setSecondJumpSource", "source", "tpl", "type", "value", "Companion", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoBusiness.kt */
public interface VideoBusiness {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String SOURCE_FROM_FEED = "video_landingpage";
    public static final String SOURCE_FROM_SEARCH = "search_video_landingpage";
    public static final String SOURCE_UGC_GROUP_LIST = "ugc_group_list";
    public static final String VIDEO_FROM_DEFAULT = "video";
    public static final String VIDEO_FROM_FEED = "feed";
    public static final String VIDEO_FROM_SEARCH = "search";
    public static final String VIDEO_LIST_PAGE_FROM = "list_page";
    public static final String VIDEO_PAGE_CHANNEL = "bigscreen_video_landing";
    public static final String VIDEO_PAGE_CHANNEL_FLOW_STYLE = "channel_video_landing";
    public static final String VIDEO_PAGE_CHANNEL_LANDSCAPE = "landscapePage";
    public static final String VIDEO_PAGE_COLLECTION = "collection_video_landing";
    public static final String VIDEO_PAGE_COLLECTION_DETAIL = "collection_detail_landing";
    public static final String VIDEO_PAGE_FEED = "feed_video_landing";
    public static final String VIDEO_PAGE_HOME = "home_video_landing";
    public static final String VIDEO_PAGE_HOT_FLOW = "flowhot_video_landing";
    public static final String VIDEO_PAGE_LANDING = "video_landing";
    public static final String VIDEO_PAGE_MERGE = "merge_video_landing";
    public static final String VIDEO_PAGE_SEARCH_IMMERSIVE_NA = "immersive_na";
    public static final String VIDEO_PAGE_UNKNOWN = "unknown";
    public static final String VIDEO_PD_CHANNEL_NA = "channel-na";
    public static final String VIDEO_PD_CHANNEL_NA_COLD_START = "cold_start";
    public static final String VIDEO_PD_COMMENT_LIST = "comment_list";
    public static final String VIDEO_PD_DEFAULT_SEARCH = "search";
    public static final String VIDEO_PD_DOWNLOAD = "download";
    public static final String VIDEO_PD_FAVORITE = "favorite";
    public static final String VIDEO_PD_FEED = "feed";
    public static final String VIDEO_PD_FEED_AD = "feed_ad";
    public static final String VIDEO_PD_FEED_TAB_VIDEO = "feed_tab_video";
    public static final String VIDEO_PD_HOME = "homepage";
    public static final String VIDEO_PD_INVOKE = "invoke";
    public static final String VIDEO_PD_MERGE = "fancy";
    public static final String VIDEO_PD_PAYMENT_COLUMN = "column_page";
    public static final String VIDEO_PD_PUSH = "push";
    public static final String VIDEO_PD_PUSH_NEWS = "push_news";
    public static final String VIDEO_PD_SHARE = "share";
    public static final String VIDEO_PD_XIAOMI_DEEP_LINK = "xiaomi_deeplink";
    public static final String VIDEO_STABLE_FROM = "land_page";
    public static final String VIDEO_TPL_DEFAULT = "flowfeed";
    public static final String VIDEO_TPL_SEARCH_CHANNEL = "search_channel";

    String from();

    String page();

    String pd();

    String scene();

    String secondJumpSource();

    void setScene(String str);

    void setSecondJumpSource(String str);

    String source();

    String tpl();

    String type();

    String value();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoBusiness.kt */
    public static final class DefaultImpls {
        public static String secondJumpSource(VideoBusiness videoBusiness) {
            return "";
        }

        public static void setSecondJumpSource(VideoBusiness videoBusiness, String secondJumpSource) {
            Intrinsics.checkNotNullParameter(secondJumpSource, "secondJumpSource");
        }

        public static String scene(VideoBusiness videoBusiness) {
            return "";
        }

        public static void setScene(VideoBusiness videoBusiness, String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/video/detail/business/VideoBusiness$Companion;", "", "()V", "SOURCE_FROM_FEED", "", "SOURCE_FROM_SEARCH", "SOURCE_UGC_GROUP_LIST", "VIDEO_FROM_DEFAULT", "VIDEO_FROM_FEED", "VIDEO_FROM_SEARCH", "VIDEO_LIST_PAGE_FROM", "VIDEO_PAGE_CHANNEL", "VIDEO_PAGE_CHANNEL_FLOW_STYLE", "VIDEO_PAGE_CHANNEL_LANDSCAPE", "VIDEO_PAGE_COLLECTION", "VIDEO_PAGE_COLLECTION_DETAIL", "VIDEO_PAGE_FEED", "VIDEO_PAGE_HOME", "VIDEO_PAGE_HOT_FLOW", "VIDEO_PAGE_LANDING", "VIDEO_PAGE_MERGE", "VIDEO_PAGE_SEARCH_IMMERSIVE_NA", "VIDEO_PAGE_UNKNOWN", "VIDEO_PD_CHANNEL_NA", "VIDEO_PD_CHANNEL_NA_COLD_START", "VIDEO_PD_COMMENT_LIST", "VIDEO_PD_DEFAULT_SEARCH", "VIDEO_PD_DOWNLOAD", "VIDEO_PD_FAVORITE", "VIDEO_PD_FEED", "VIDEO_PD_FEED_AD", "VIDEO_PD_FEED_TAB_VIDEO", "VIDEO_PD_HOME", "VIDEO_PD_INVOKE", "VIDEO_PD_MERGE", "VIDEO_PD_PAYMENT_COLUMN", "VIDEO_PD_PUSH", "VIDEO_PD_PUSH_NEWS", "VIDEO_PD_SHARE", "VIDEO_PD_XIAOMI_DEEP_LINK", "VIDEO_STABLE_FROM", "VIDEO_TPL_DEFAULT", "VIDEO_TPL_SEARCH_CHANNEL", "getBusiness", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "name", "creator", "Lkotlin/Function1;", "Lcom/baidu/searchbox/video/detail/business/VideoBusinessProxy;", "", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoBusiness.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SOURCE_FROM_FEED = "video_landingpage";
        public static final String SOURCE_FROM_SEARCH = "search_video_landingpage";
        public static final String SOURCE_UGC_GROUP_LIST = "ugc_group_list";
        public static final String VIDEO_FROM_DEFAULT = "video";
        public static final String VIDEO_FROM_FEED = "feed";
        public static final String VIDEO_FROM_SEARCH = "search";
        public static final String VIDEO_LIST_PAGE_FROM = "list_page";
        public static final String VIDEO_PAGE_CHANNEL = "bigscreen_video_landing";
        public static final String VIDEO_PAGE_CHANNEL_FLOW_STYLE = "channel_video_landing";
        public static final String VIDEO_PAGE_CHANNEL_LANDSCAPE = "landscapePage";
        public static final String VIDEO_PAGE_COLLECTION = "collection_video_landing";
        public static final String VIDEO_PAGE_COLLECTION_DETAIL = "collection_detail_landing";
        public static final String VIDEO_PAGE_FEED = "feed_video_landing";
        public static final String VIDEO_PAGE_HOME = "home_video_landing";
        public static final String VIDEO_PAGE_HOT_FLOW = "flowhot_video_landing";
        public static final String VIDEO_PAGE_LANDING = "video_landing";
        public static final String VIDEO_PAGE_MERGE = "merge_video_landing";
        public static final String VIDEO_PAGE_SEARCH_IMMERSIVE_NA = "immersive_na";
        public static final String VIDEO_PAGE_UNKNOWN = "unknown";
        public static final String VIDEO_PD_CHANNEL_NA = "channel-na";
        public static final String VIDEO_PD_CHANNEL_NA_COLD_START = "cold_start";
        public static final String VIDEO_PD_COMMENT_LIST = "comment_list";
        public static final String VIDEO_PD_DEFAULT_SEARCH = "search";
        public static final String VIDEO_PD_DOWNLOAD = "download";
        public static final String VIDEO_PD_FAVORITE = "favorite";
        public static final String VIDEO_PD_FEED = "feed";
        public static final String VIDEO_PD_FEED_AD = "feed_ad";
        public static final String VIDEO_PD_FEED_TAB_VIDEO = "feed_tab_video";
        public static final String VIDEO_PD_HOME = "homepage";
        public static final String VIDEO_PD_INVOKE = "invoke";
        public static final String VIDEO_PD_MERGE = "fancy";
        public static final String VIDEO_PD_PAYMENT_COLUMN = "column_page";
        public static final String VIDEO_PD_PUSH = "push";
        public static final String VIDEO_PD_PUSH_NEWS = "push_news";
        public static final String VIDEO_PD_SHARE = "share";
        public static final String VIDEO_PD_XIAOMI_DEEP_LINK = "xiaomi_deeplink";
        public static final String VIDEO_STABLE_FROM = "land_page";
        public static final String VIDEO_TPL_DEFAULT = "flowfeed";
        public static final String VIDEO_TPL_SEARCH_CHANNEL = "search_channel";

        private Companion() {
        }

        public static /* synthetic */ VideoBusiness getBusiness$default(Companion companion, String str, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            return companion.getBusiness(str, function1);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.baidu.searchbox.video.detail.business.VideoBusiness getBusiness(java.lang.String r18, kotlin.jvm.functions.Function1<? super com.baidu.searchbox.video.detail.business.VideoBusinessProxy, kotlin.Unit> r19) {
            /*
                r17 = this;
                r0 = r18
                r1 = r19
                java.lang.String r2 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                com.baidu.searchbox.video.detail.business.VideoBusinessProxy r2 = new com.baidu.searchbox.video.detail.business.VideoBusinessProxy
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 127(0x7f, float:1.78E-43)
                r12 = 0
                r3 = r2
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                if (r1 == 0) goto L_0x001e
                r1.invoke(r2)
            L_0x001e:
                int r3 = r18.hashCode()
                switch(r3) {
                    case -2073701006: goto L_0x0146;
                    case -2030109044: goto L_0x0122;
                    case -1701404941: goto L_0x00fe;
                    case -821065289: goto L_0x00db;
                    case -610965901: goto L_0x00b6;
                    case 876484631: goto L_0x0093;
                    case 1974553171: goto L_0x006f;
                    case 1981275762: goto L_0x004b;
                    case 2043063488: goto L_0x0027;
                    default: goto L_0x0025;
                }
            L_0x0025:
                goto L_0x016a
            L_0x0027:
                java.lang.String r3 = "bigscreen_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x0030
                goto L_0x0025
            L_0x0030:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "好看大屏版"
                java.lang.String r7 = "video"
                java.lang.String r8 = "bigscreen_video_landing"
                java.lang.String r12 = "feed"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x004b:
                java.lang.String r3 = "collection_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x0054
                goto L_0x0025
            L_0x0054:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "合集融合落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "collection_video_landing"
                java.lang.String r12 = "feed"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x006f:
                java.lang.String r3 = "video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x0079
                goto L_0x0025
            L_0x0079:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 242(0xf2, float:3.39E-43)
                r14 = 0
                java.lang.String r5 = "普通视频落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "video_landing"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x0093:
                java.lang.String r3 = "channel_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x009c
                goto L_0x0025
            L_0x009c:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "好看融合版"
                java.lang.String r7 = "feed"
                java.lang.String r8 = "channel_video_landing"
                java.lang.String r12 = "feed"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x00b6:
                java.lang.String r3 = "flowhot_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x00c0
                goto L_0x0025
            L_0x00c0:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "热榜融合落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "flowhot_video_landing"
                java.lang.String r12 = "feed"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x00db:
                java.lang.String r3 = "immersive_na"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x00e5
                goto L_0x0025
            L_0x00e5:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "搜索融合落地页"
                java.lang.String r7 = "search"
                java.lang.String r8 = "immersive_na"
                java.lang.String r12 = "search"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x00fe:
                java.lang.String r3 = "home_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x0108
                goto L_0x0025
            L_0x0108:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "号主页，融合落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "home_video_landing"
                java.lang.String r12 = "homepage"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x0122:
                java.lang.String r3 = "merge_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x012c
                goto L_0x0025
            L_0x012c:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "心潮融合落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "merge_video_landing"
                java.lang.String r12 = "fancy"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x0146:
                java.lang.String r3 = "feed_video_landing"
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x0150
                goto L_0x0025
            L_0x0150:
                com.baidu.searchbox.video.detail.business.DefaultBusiness r3 = new com.baidu.searchbox.video.detail.business.DefaultBusiness
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 114(0x72, float:1.6E-43)
                r14 = 0
                java.lang.String r5 = "主feed融合落地页"
                java.lang.String r7 = "video"
                java.lang.String r8 = "feed_video_landing"
                java.lang.String r12 = "feed"
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                goto L_0x016b
            L_0x016a:
                r3 = 0
            L_0x016b:
                if (r3 == 0) goto L_0x0198
                r4 = r3
                r5 = 0
                com.baidu.searchbox.video.detail.business.VideoBusinessImp$Companion r6 = com.baidu.searchbox.video.detail.business.VideoBusinessImp.Companion
                java.lang.String r7 = r2.getTpl()
                java.lang.String r8 = r2.getFrom()
                java.lang.String r9 = r2.getPage()
                java.lang.String r10 = r2.getSource()
                java.lang.String r11 = r2.getType()
                java.lang.String r12 = r2.getValue()
                java.lang.String r13 = r2.getPd()
                r14 = r3
                com.baidu.searchbox.video.detail.business.VideoBusiness r14 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r14
                com.baidu.searchbox.video.detail.business.VideoBusinessImp r6 = r6.invoke(r7, r8, r9, r10, r11, r12, r13, r14)
                com.baidu.searchbox.video.detail.business.VideoBusiness r6 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r6
                return r6
            L_0x0198:
                com.baidu.searchbox.video.detail.business.UnknownBiz r4 = new com.baidu.searchbox.video.detail.business.UnknownBiz
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 127(0x7f, float:1.78E-43)
                r16 = 0
                r7 = r4
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                com.baidu.searchbox.video.detail.business.VideoBusiness r4 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.detail.business.VideoBusiness.Companion.getBusiness(java.lang.String, kotlin.jvm.functions.Function1):com.baidu.searchbox.video.detail.business.VideoBusiness");
        }
    }
}
