package com.baidu.searchbox.video.feedflow.ubc;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b{\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010|\u001a\u0004\u0018\u00010}2\b\u0010~\u001a\u0004\u0018\u00010\u001a\u0012\u0010\u0001\u001a\u00020\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0012\u0010\u0001\u001a\u00020\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0012\u0010\u0001\u001a\u00020\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a)\u0010\u0001\u001a\u00020\u00012\b\u0010~\u001a\u0004\u0018\u000102\n\b\u0002\u0010\u0001\u001a\u00030\u00012\n\b\u0002\u0010\u0001\u001a\u00030\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010~\u001a\u0005\u0018\u00010\u0001\u001a\u0016\u0010\u0001\u001a\u00030\u0001*\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001\u001a\u0016\u0010\u0001\u001a\u00030\u0001*\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001\u001a\u0015\u0010\u0001\u001a\u00030\u0001*\u000b\u0012\u0004\u0012\u00020\u0018\u00010\u0001\u001a\u0015\u0010\u0001\u001a\u00030\u0001*\u000b\u0012\u0004\u0012\u00020\u0018\u00010\u0001\u001a\u0015\u0010\u0001\u001a\u00030\u0001*\u000b\u0012\u0004\u0012\u00020\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010g\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010h\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010i\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010k\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010l\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010o\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010s\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010u\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010v\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010w\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010x\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010y\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010z\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010{\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"EXT_CHANNEL_ID", "", "EXT_CLIENT_SILENCE_CANCEL", "EXT_SHORT_PLAY_SOURCE", "LAND_PAGE_PV", "PAGE_FEED_VIDEO_LANDING", "PAGE_IMMERSIVE_VIDEO_LANDING", "PAGE_MERGE_VIDEO_LANDING", "UBC_CLICK", "UBC_DISPLAY", "UBC_FAVOR_UBC_ID", "UBC_HOT_COMMENT_UBC_ID", "UBC_ID_102", "UBC_ID_1077", "UBC_ID_1439", "UBC_ID_15396", "UBC_ID_221", "UBC_ID_2549", "UBC_ID_3838", "UBC_ID_3951", "UBC_ID_406", "UBC_ID_464", "UBC_ID_4972", "UBC_ID_499", "UBC_ID_502", "UBC_ID_5063", "UBC_ID_5066", "UBC_ID_5089", "UBC_ID_5090", "UBC_ID_5192", "UBC_ID_5213", "UBC_ID_5351", "UBC_ID_5375", "UBC_ID_5394", "UBC_ID_5426", "UBC_ID_5460", "UBC_ID_5466", "UBC_ID_5487", "UBC_ID_5507", "UBC_ID_5524", "UBC_ID_5525", "UBC_ID_5526", "UBC_ID_5618", "UBC_ID_5619", "UBC_ID_5755", "UBC_ID_5796", "UBC_ID_5800", "UBC_ID_5854", "UBC_ID_5881", "UBC_ID_5888", "UBC_ID_5895", "UBC_ID_5908", "UBC_ID_5929", "UBC_ID_5943", "UBC_ID_5993", "UBC_ID_5994", "UBC_ID_6035", "UBC_ID_6037", "UBC_ID_6057", "UBC_ID_6079", "UBC_ID_6085", "UBC_ID_6101", "UBC_ID_6102", "UBC_ID_6123", "UBC_ID_6132", "UBC_ID_6145", "UBC_ID_6146", "UBC_ID_6150", "UBC_ID_6151", "UBC_ID_6203", "UBC_ID_6226", "UBC_ID_6233", "UBC_ID_6240", "UBC_ID_6241", "UBC_ID_6242", "UBC_ID_6250", "UBC_ID_6271", "UBC_ID_6274", "UBC_ID_6304", "UBC_ID_6305", "UBC_ID_6340", "UBC_ID_6381", "UBC_ID_6400", "UBC_ID_6427", "UBC_ID_6430", "UBC_ID_6431", "UBC_ID_6432", "UBC_ID_6469", "UBC_ID_6470", "UBC_ID_6518", "UBC_ID_6581", "UBC_ID_6589", "UBC_ID_6652", "UBC_ID_6664", "UBC_ID_6671", "UBC_ID_6672", "UBC_ID_6694", "UBC_ID_6720", "UBC_ID_6721", "UBC_ID_6736", "UBC_ID_6737", "UBC_ID_6889", "UBC_ID_6900", "UBC_ID_7007", "UBC_ID_7054", "UBC_ID_7486", "UBC_ID_7501", "UBC_ID_7509", "UBC_ID_7524", "UBC_ID_FLOW_PERCEPTION_EXCEPTION", "UBC_ID_RED_DOT", "UBC_LANDING_PAGE_DURATION_KEY", "UBC_LANDING_PAGE_FROM_TOOL", "UBC_LANDING_PAGE_ITEM_KEY", "UBC_LANDING_PAGE_ITEM_KEY_DYNAMIC", "UBC_LANDING_PAGE_SEARCH_DURATION_KEY", "UBC_LANDING_PAGE_TOP_MENU_KEY", "UBC_LANDING_PAGE_TYPE_MENU_CLK", "UBC_LAUNCH_START", "UBC_MENU_FAVOR_SOURCE", "UBC_MENU_UBC_ID", "UBC_PREVIEW_ID_6037", "UBC_SHOW", "UBC_THIRD_PARTY_6306", "getIntentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getLandscapeModeStatus", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "getPage", "getPd", "getRealCurSceneString", "isGetNewScene", "", "switchState", "isPageFromSearchFlow", "isPageSourceFromChannelFlow", "isPageSourceFromCollection", "isPageSourceFromFeed", "isPageSourceFromHome", "isPageSourceFromHot", "isPageSourceFromMerge", "isPageSourceFromSearch", "isPdSourceFromChannelNa", "isPdSourceFromFeed", "isPdSourceFromHome", "isPdSourceFromHot", "isPdSourceFromMerge", "isPdSourceFromPaymentColumn", "isFromSearchEntrance", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBCManifest.kt */
public final class UBCManifestKt {
    public static final String EXT_CHANNEL_ID = "channel_id";
    public static final String EXT_CLIENT_SILENCE_CANCEL = "silence_cancel";
    public static final String EXT_SHORT_PLAY_SOURCE = "shortplay_source";
    public static final String LAND_PAGE_PV = "71";
    public static final String PAGE_FEED_VIDEO_LANDING = "feed_video_landing";
    public static final String PAGE_IMMERSIVE_VIDEO_LANDING = "immersive_na";
    public static final String PAGE_MERGE_VIDEO_LANDING = "merge_video_landing";
    public static final String UBC_CLICK = "click";
    public static final String UBC_DISPLAY = "display";
    public static final String UBC_FAVOR_UBC_ID = "743";
    public static final String UBC_HOT_COMMENT_UBC_ID = "619";
    public static final String UBC_ID_102 = "102";
    public static final String UBC_ID_1077 = "1077";
    public static final String UBC_ID_1439 = "1439";
    public static final String UBC_ID_15396 = "15396";
    public static final String UBC_ID_221 = "221";
    public static final String UBC_ID_2549 = "2549";
    public static final String UBC_ID_3838 = "3838";
    public static final String UBC_ID_3951 = "3951";
    public static final String UBC_ID_406 = "406";
    public static final String UBC_ID_464 = "464";
    public static final String UBC_ID_4972 = "4972";
    public static final String UBC_ID_499 = "499";
    public static final String UBC_ID_502 = "502";
    public static final String UBC_ID_5063 = "5063";
    public static final String UBC_ID_5066 = "5066";
    public static final String UBC_ID_5089 = "5089";
    public static final String UBC_ID_5090 = "5090";
    public static final String UBC_ID_5192 = "5192";
    public static final String UBC_ID_5213 = "5213";
    public static final String UBC_ID_5351 = "5351";
    public static final String UBC_ID_5375 = "5375";
    public static final String UBC_ID_5394 = "5394";
    public static final String UBC_ID_5426 = "5426";
    public static final String UBC_ID_5460 = "5460";
    public static final String UBC_ID_5466 = "5466";
    public static final String UBC_ID_5487 = "5487";
    public static final String UBC_ID_5507 = "5507";
    public static final String UBC_ID_5524 = "5524";
    public static final String UBC_ID_5525 = "5525";
    public static final String UBC_ID_5526 = "5526";
    public static final String UBC_ID_5618 = "5618";
    public static final String UBC_ID_5619 = "5619";
    public static final String UBC_ID_5755 = "5755";
    public static final String UBC_ID_5796 = "5796";
    public static final String UBC_ID_5800 = "5800";
    public static final String UBC_ID_5854 = "5854";
    public static final String UBC_ID_5881 = "5881";
    public static final String UBC_ID_5888 = "5888";
    public static final String UBC_ID_5895 = "5895";
    public static final String UBC_ID_5908 = "5908";
    public static final String UBC_ID_5929 = "5929";
    public static final String UBC_ID_5943 = "5943";
    public static final String UBC_ID_5993 = "5993";
    public static final String UBC_ID_5994 = "5994";
    public static final String UBC_ID_6035 = "6035";
    public static final String UBC_ID_6037 = "6037";
    public static final String UBC_ID_6057 = "6057";
    public static final String UBC_ID_6079 = "6079";
    public static final String UBC_ID_6085 = "6085";
    public static final String UBC_ID_6101 = "6101";
    public static final String UBC_ID_6102 = "6102";
    public static final String UBC_ID_6123 = "6123";
    public static final String UBC_ID_6132 = "6132";
    public static final String UBC_ID_6145 = "6145";
    public static final String UBC_ID_6146 = "6146";
    public static final String UBC_ID_6150 = "6150";
    public static final String UBC_ID_6151 = "6151";
    public static final String UBC_ID_6203 = "6203";
    public static final String UBC_ID_6226 = "6226";
    public static final String UBC_ID_6233 = "6233";
    public static final String UBC_ID_6240 = "6240";
    public static final String UBC_ID_6241 = "6241";
    public static final String UBC_ID_6242 = "6242";
    public static final String UBC_ID_6250 = "6250";
    public static final String UBC_ID_6271 = "6271";
    public static final String UBC_ID_6274 = "6274";
    public static final String UBC_ID_6304 = "6304";
    public static final String UBC_ID_6305 = "6305";
    public static final String UBC_ID_6340 = "6340";
    public static final String UBC_ID_6381 = "6381";
    public static final String UBC_ID_6400 = "6400";
    public static final String UBC_ID_6427 = "6427";
    public static final String UBC_ID_6430 = "6430";
    public static final String UBC_ID_6431 = "6431";
    public static final String UBC_ID_6432 = "6432";
    public static final String UBC_ID_6469 = "6469";
    public static final String UBC_ID_6470 = "6470";
    public static final String UBC_ID_6518 = "6518";
    public static final String UBC_ID_6581 = "6581";
    public static final String UBC_ID_6589 = "6589";
    public static final String UBC_ID_6652 = "6652";
    public static final String UBC_ID_6664 = "6664";
    public static final String UBC_ID_6671 = "6671";
    public static final String UBC_ID_6672 = "6672";
    public static final String UBC_ID_6694 = "6694";
    public static final String UBC_ID_6720 = "6720";
    public static final String UBC_ID_6721 = "6721";
    public static final String UBC_ID_6736 = "6736";
    public static final String UBC_ID_6737 = "6737";
    public static final String UBC_ID_6889 = "6889";
    public static final String UBC_ID_6900 = "6900";
    public static final String UBC_ID_7007 = "7007";
    public static final String UBC_ID_7054 = "7054";
    public static final String UBC_ID_7486 = "7486";
    public static final String UBC_ID_7501 = "7501";
    public static final String UBC_ID_7509 = "7509";
    public static final String UBC_ID_7524 = "7524";
    public static final String UBC_ID_FLOW_PERCEPTION_EXCEPTION = "4641";
    public static final String UBC_ID_RED_DOT = "5665";
    public static final String UBC_LANDING_PAGE_DURATION_KEY = "346";
    public static final String UBC_LANDING_PAGE_FROM_TOOL = "tool";
    public static final String UBC_LANDING_PAGE_ITEM_KEY = "2736";
    public static final String UBC_LANDING_PAGE_ITEM_KEY_DYNAMIC = "2728";
    public static final String UBC_LANDING_PAGE_SEARCH_DURATION_KEY = "843";
    public static final String UBC_LANDING_PAGE_TOP_MENU_KEY = "260";
    public static final String UBC_LANDING_PAGE_TYPE_MENU_CLK = "menu_clk";
    public static final String UBC_LAUNCH_START = "5107";
    public static final String UBC_MENU_FAVOR_SOURCE = "menu";
    public static final String UBC_MENU_UBC_ID = "919";
    public static final String UBC_PREVIEW_ID_6037 = "6037";
    public static final String UBC_SHOW = "show";
    public static final String UBC_THIRD_PARTY_6306 = "6306";

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getPage(com.baidu.searchbox.feed.detail.frame.AbsState r1) {
        /*
            if (r1 == 0) goto L_0x000f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r1.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.page
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = ""
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(com.baidu.searchbox.feed.detail.frame.AbsState):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getPd(com.baidu.searchbox.feed.detail.frame.AbsState r1) {
        /*
            if (r1 == 0) goto L_0x000f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r1.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.pd
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = ""
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPd(com.baidu.searchbox.feed.detail.frame.AbsState):java.lang.String");
    }

    public static final boolean isPageSourceFromFeed(Store<CommonState> $this$isPageSourceFromFeed) {
        return isPageSourceFromFeed((AbsState) $this$isPageSourceFromFeed != null ? $this$isPageSourceFromFeed.getState() : null);
    }

    public static final boolean isPageSourceFromFeed(AbsState state) {
        return VideoBizUtilsKt.isFromFeed(getPage(state));
    }

    public static final boolean isPageSourceFromMerge(AbsState state) {
        return VideoBizUtilsKt.isFromMerge(getPage(state));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isPageSourceFromSearch(com.baidu.searchbox.feed.detail.frame.AbsState r2) {
        /*
            if (r2 == 0) goto L_0x000f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r2.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.page
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = ""
        L_0x0014:
            java.lang.String r1 = "immersive_na"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageSourceFromSearch(com.baidu.searchbox.feed.detail.frame.AbsState):boolean");
    }

    public static final boolean isFromSearchEntrance(Store<AbsState> $this$isFromSearchEntrance) {
        if ($this$isFromSearchEntrance == null) {
            return false;
        }
        AbsState state = $this$isFromSearchEntrance.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
        if (intentData != null) {
            str = intentData.from;
        }
        String from = str;
        if (Intrinsics.areEqual((Object) "search", (Object) from) || Intrinsics.areEqual((Object) "search_feed", (Object) from)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isPageFromSearchFlow(com.baidu.searchbox.feed.detail.frame.AbsState r2) {
        /*
            if (r2 == 0) goto L_0x000f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r2.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.page
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = ""
        L_0x0014:
            java.lang.String r1 = "immersive_na"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x002a
            com.baidu.searchbox.video.detail.export.IVideoSearchBeeUtils$Impl r1 = com.baidu.searchbox.video.detail.export.IVideoSearchBeeUtils.Impl.INSTANCE
            com.baidu.searchbox.video.detail.export.IVideoSearchBeeUtils r1 = r1.get()
            boolean r1 = r1.isSearchFlowCPage()
            if (r1 == 0) goto L_0x002a
            r1 = 1
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageFromSearchFlow(com.baidu.searchbox.feed.detail.frame.AbsState):boolean");
    }

    public static final boolean isPageFromSearchFlow(Store<AbsState> $this$isPageFromSearchFlow) {
        return isPageFromSearchFlow($this$isPageFromSearchFlow != null ? $this$isPageFromSearchFlow.getState() : null);
    }

    public static final boolean isPageSourceFromCollection(Store<CommonState> $this$isPageSourceFromCollection) {
        return isPageSourceFromCollection((AbsState) $this$isPageSourceFromCollection != null ? $this$isPageSourceFromCollection.getState() : null);
    }

    public static final boolean isPageSourceFromCollection(AbsState state) {
        return VideoBizUtilsKt.isFromCollection(getPage(state));
    }

    public static final boolean isPageSourceFromHot(AbsState state) {
        return VideoBizUtilsKt.isFromHotFlow(getPage(state));
    }

    public static final boolean isPageSourceFromChannelFlow(Store<CommonState> $this$isPageSourceFromChannelFlow) {
        return isPageSourceFromChannelFlow((AbsState) $this$isPageSourceFromChannelFlow != null ? $this$isPageSourceFromChannelFlow.getState() : null);
    }

    public static final boolean isPageSourceFromChannelFlow(AbsState state) {
        return VideoBizUtilsKt.isFromChannelFlow(getPage(state));
    }

    public static final boolean isPageSourceFromHome(AbsState state) {
        return VideoBizUtilsKt.isFromUserHomePage(getPage(state));
    }

    public static final boolean isPdSourceFromFeed(AbsState state) {
        return VideoBizUtilsKt.isPdFromFeed(getPd(state));
    }

    public static final boolean isPdSourceFromMerge(AbsState state) {
        return VideoBizUtilsKt.isPdFromMerge(getPd(state));
    }

    public static final boolean isPdSourceFromHome(AbsState state) {
        return VideoBizUtilsKt.isPdFromHome(getPd(state));
    }

    public static final boolean isPdSourceFromPaymentColumn(AbsState state) {
        return VideoBizUtilsKt.isPdFromPaymentColumn(getPd(state));
    }

    public static final boolean isPdSourceFromChannelNa(AbsState state) {
        return VideoBizUtilsKt.isPdFromChannelNa(getPd(state));
    }

    public static /* synthetic */ String getRealCurSceneString$default(CommonState commonState, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return getRealCurSceneString(commonState, z, z2);
    }

    public static final String getRealCurSceneString(CommonState state, boolean isGetNewScene, boolean switchState) {
        IntentData intentData = getIntentData(state);
        String str = null;
        String chanelId = intentData != null ? intentData.entranceId : null;
        String str2 = "";
        if (chanelId == null) {
            chanelId = str2;
        }
        String pd = intentData != null ? intentData.pd : null;
        if (pd == null) {
            pd = str2;
        }
        String from = intentData != null ? intentData.from : null;
        if (from == null) {
            from = str2;
        }
        if (intentData != null) {
            str = intentData.page;
        }
        if (str != null) {
            str2 = str;
        }
        String page = str2;
        if (isGetNewScene || switchState) {
            if (chanelId.length() > 0) {
                return from + '-' + page + '-' + pd + '-' + chanelId;
            }
        }
        return from + '-' + page + '-' + pd;
    }

    public static final IntentData getIntentData(CommonState state) {
        IntentData intentData;
        FirstJumpNidState firstJumpNidState;
        IntentData intentData2 = null;
        if (state != null) {
            intentData = (IntentData) state.select(IntentData.class);
        } else {
            intentData = null;
        }
        if (intentData != null) {
            return intentData;
        }
        if (!(state == null || (firstJumpNidState = (FirstJumpNidState) state.select(FirstJumpNidState.class)) == null)) {
            intentData2 = firstJumpNidState.getIntentData();
        }
        return intentData2;
    }

    public static final boolean isPdSourceFromHot(AbsState state) {
        return VideoBizUtilsKt.isFromHotFlow(getPd(state));
    }

    public static final String getLandscapeModeStatus(AbsState state) {
        return LandscapeFlowSwitchKt.isLandscapeFlowMode(state) ? "landscape" : "portrait";
    }
}
