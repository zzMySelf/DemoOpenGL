package com.baidu.searchbox.search.webvideo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.menu.BaseMenuPopupWindow;
import com.baidu.android.common.menu.BaseMenuView;
import com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow;
import com.baidu.android.ext.widget.DownloadUrlCheckWindow;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.ui.fusion.FileManagerActivity;
import com.baidu.searchbox.download.util.DownloadByteConverter;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.search.videodetail.R;
import com.baidu.searchbox.search.webvideo.cache.H5PlayerCache;
import com.baidu.searchbox.search.webvideo.model.SearchVideoH5DownloadModel;
import com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer;
import com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer;
import com.baidu.searchbox.search.webvideo.player.component.SearchH5VipBanner;
import com.baidu.searchbox.search.webvideo.player.component.SearchH5VipBannerOperatorInfo;
import com.baidu.searchbox.search.webvideo.ui.SearchVideoSnifferMenuView;
import com.baidu.searchbox.search.webvideo.vip.LcbSendVipManager;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a \u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0002\u001a.\u0010Q\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010R\u001a\u00020<2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020P0T2\u0006\u0010U\u001a\u00020\u0005H\u0002\u001a\u0010\u0010V\u001a\u00020&2\u0006\u0010O\u001a\u00020PH\u0000\u001a\u0012\u0010V\u001a\u00020&2\b\u0010W\u001a\u0004\u0018\u00010XH\u0000\u001a\u0006\u0010Y\u001a\u00020J\u001a\u0006\u0010Z\u001a\u00020&\u001a \u0010[\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010\\\u001a\u00020]2\u0006\u0010O\u001a\u00020PH\u0003\u001a \u0010^\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010\\\u001a\u00020]2\u0006\u0010O\u001a\u00020PH\u0002\u001a*\u0010_\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010\\\u001a\u00020]2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010O\u001a\u00020PH\u0002\u001a \u0010b\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010\\\u001a\u00020]2\u0006\u0010O\u001a\u00020PH\u0003\u001a\u0006\u0010c\u001a\u00020J\u001a\u000e\u0010d\u001a\u00020J2\u0006\u0010e\u001a\u00020\u0005\u001a\u0006\u0010f\u001a\u00020J\u001a\b\u0010g\u001a\u00020JH\u0000\u001a\u001a\u0010h\u001a\u00020J2\b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020lH\u0002\u001a\u0012\u0010m\u001a\u0004\u0018\u00010a2\u0006\u0010K\u001a\u00020LH\u0002\u001a@\u0010n\u001a\u00020J2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u00052\b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0006\u0010v\u001a\u00020J\u001a\u0006\u0010w\u001a\u00020&\u001a \u0010x\u001a\u00020J2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010K\u001a\u00020LH\u0002\u001a\u0010\u0010y\u001a\u00020&2\u0006\u0010z\u001a\u00020\u0005H\u0002\u001a\u0006\u0010{\u001a\u00020&\u001a\u0010\u0010|\u001a\u00020J2\u0006\u0010}\u001a\u00020DH\u0000\u001a\u000e\u0010~\u001a\u00020J2\u0006\u0010\u001a\u00020\u0005\u001a\u0018\u0010~\u001a\u00020J2\u0006\u0010\u001a\u00020\u00052\b\u0010o\u001a\u0004\u0018\u00010L\u001a$\u0010~\u001a\u00020J2\u0006\u0010\u001a\u00020\u00052\b\u0010o\u001a\u0004\u0018\u00010L2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u001a\u0011\u0010\u0001\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010P\u001a\u001a\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010L\u001a=\u0010\u0001\u001a\u00020J2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020&2\b\b\u0002\u0010r\u001a\u00020\u0005\u001a=\u0010\u0001\u001a\u00020J2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020&2\b\b\u0002\u0010r\u001a\u00020\u0005\u001aC\u0010\u0001\u001a\u00020J2\u0006\u0010o\u001a\u00020L2\b\u0010\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020J\u0018\u00010\u0001H\u0003\u001a\u0007\u0010\u0001\u001a\u00020J\u001a=\u0010\u0001\u001a\u00020J2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020&2\b\b\u0002\u0010r\u001a\u00020\u0005\u001aC\u0010\u0001\u001a\u00020J2\u0006\u0010o\u001a\u00020L2\b\u0010\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020J\u0018\u00010\u0001H\u0002\u001a\u0007\u0010\u0001\u001a\u00020J\u001a8\u0010\u0001\u001a\u00020J2\u0006\u0010o\u001a\u00020L2\b\u0010\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020J\u0018\u00010\u0001H\u0003\u001a\u0013\u0010\u0001\u001a\u00020J2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010L\u001a\u0007\u0010\u0001\u001a\u00020J\u001a=\u0010\u0001\u001a\u00020J2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020&2\b\b\u0002\u0010r\u001a\u00020\u0005\u001a?\u0010\u0001\u001a\u00020J2\u0006\u0010q\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020J\u0018\u00010\u00012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010L\u001a/\u0010\u0001\u001a\u00020J2\u0006\u0010r\u001a\u00020\u00052\b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0005\u001a%\u0010\u0001\u001a\u00020J2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020P0T2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0005\u001a\t\u0010\u0001\u001a\u00020JH\u0002\u001a\u0011\u0010\u0001\u001a\u00020J2\u0006\u0010}\u001a\u00020DH\u0000\u001a\u0007\u0010\u0001\u001a\u00020J\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\" \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)\"\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)\"\u001a\u0010,\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)\"\u001a\u0010.\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)\"\u001a\u00100\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)\"\u001a\u00102\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)\"\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\"&\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\"'\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0B8BX\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010F¨\u0006\u0001"}, d2 = {"BANNER_TRANSLATION_Y", "", "DETECTED_TOAST_DURATION", "", "EXTENSION_M3U", "", "EXTENSION_M3U8", "HAS_USER_EVENT", "PAN_HOME_PAGE_SCHEME", "SCHEMA_TO_KEY_PREFIX", "SCHEMA_TO_PLAYER", "SCHEMA_TO_PLAYER_EXP1", "SCHEMA_TO_SWAN_PREFIX", "SCHEMA_TO_TRANS_LIST", "SCHEMA_TO_VIDEO_LIST_EXP2", "SCHEMA_TO_VIDEO_LIST_EXP3", "STATISTIC_DOWNLOAD_PARTNER_ID", "STATISTIC_PARTNER_ID", "THOUSAND_MULTIPLE", "UBC_FROM_SEARCH", "UBC_SOURCE_SEARCH", "downloadPanel", "Lcom/baidu/android/ext/widget/DownloadMultiBtnUrlCheckWindow;", "getDownloadPanel", "()Lcom/baidu/android/ext/widget/DownloadMultiBtnUrlCheckWindow;", "setDownloadPanel", "(Lcom/baidu/android/ext/widget/DownloadMultiBtnUrlCheckWindow;)V", "globalClickFrom", "getGlobalClickFrom", "()Ljava/lang/String;", "setGlobalClickFrom", "(Ljava/lang/String;)V", "globalVideoListSize", "getGlobalVideoListSize", "()I", "setGlobalVideoListSize", "(I)V", "isAutoShowing", "", "()Z", "setAutoShowing", "(Z)V", "isNeedRefVip", "setNeedRefVip", "isShowBanner", "setShowBanner", "isShowBannerFinal", "setShowBannerFinal", "isShowVerticalStyle", "setShowVerticalStyle", "isSnifferSource", "setSnifferSource", "snifferBannerOperatorInfo", "Lcom/baidu/searchbox/search/webvideo/player/component/SearchH5VipBannerOperatorInfo;", "getSnifferBannerOperatorInfo", "()Lcom/baidu/searchbox/search/webvideo/player/component/SearchH5VipBannerOperatorInfo;", "setSnifferBannerOperatorInfo", "(Lcom/baidu/searchbox/search/webvideo/player/component/SearchH5VipBannerOperatorInfo;)V", "snifferPanel", "Lcom/baidu/android/common/menu/BaseMenuPopupWindow;", "Lcom/baidu/searchbox/search/webvideo/ui/SearchVideoSnifferMenuView;", "getSnifferPanel", "()Lcom/baidu/android/common/menu/BaseMenuPopupWindow;", "setSnifferPanel", "(Lcom/baidu/android/common/menu/BaseMenuPopupWindow;)V", "snifferPanelDismissListeners", "", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/android/ext/widget/PopupWindow$OnDismissListener;", "getSnifferPanelDismissListeners", "()Ljava/util/List;", "snifferPanelDismissListeners$delegate", "Lkotlin/Lazy;", "addTopViewForDownloadPanel", "", "context", "Landroid/content/Context;", "downloadBuilder", "Lcom/baidu/android/ext/widget/DownloadMultiBtnUrlCheckWindow$Builder;", "downloadInfo", "Lcom/baidu/searchbox/search/webvideo/model/SearchVideoH5DownloadModel;", "addTopViewForSnifferPanel", "snifferMenuView", "videoList", "", "clickFrom", "canShowPlayDownloadTip", "videoSeries", "Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;", "cancelAutoDismiss", "checkNetworkConnected", "configDownloadAndNetDiskBtn", "dialogBuilder", "Lcom/baidu/android/ext/widget/DownloadUrlCheckWindow$Builder;", "configDownloadBtn", "configNetDiskBtn", "subText", "", "configOnlyDownloadBtn", "dismissDownloadPanelOrDialog", "dismissPanelWithDuration", "source", "dismissSnifferPanel", "dispatchSnifferPanelDismiss", "dispatchTouchEvent", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "getSaveNetDiskSubTitle", "gotoVipPage", "activity", "Landroid/app/Activity;", "title", "step", "errorCode", "errorMsg", "resourceTitle", "initSnifferPanelCommandAndOperatorInfo", "isDownloadPanelShowing", "isInterceptTouch", "isM3U8Extension", "extension", "isSnifferPanelShowing", "registerSnifferPanelDismissListener", "listener", "showDownloadMsgToast", "msg", "ext", "Lorg/json/JSONObject;", "showDownloadPanel", "showDownloadTaskExistToast", "status", "showFullScreenSaveDoneToast", "savePath", "fsid", "isRapid", "saveBefore", "showLcpFreeVipFullScreenSaveDoneToast", "showLcpFreeVipNetDiskToast", "btnStr", "subTitle", "callback", "Lkotlin/Function0;", "showLcpFreeVipSaveBeginToast", "showLcpFreeVipSaveDoneToast", "showNetDiskGoldBtnToast", "showNetDiskGuideToast", "showNetDiskToast", "showPlayableDownloadStartToast", "showSaveBeginToast", "showSaveDoneToast", "showSaveFailDetailToast", "rightCheckText", "showSaveFailToast", "showSnifferPanel", "unknownErrorCodeToast", "unregisterSnifferPanelDismissListener", "updateSnifferPanel", "lib_search_video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5ToastUtil.kt */
public final class SearchH5ToastUtilKt {
    private static final float BANNER_TRANSLATION_Y = 17.0f;
    private static final int DETECTED_TOAST_DURATION = 5;
    private static final String EXTENSION_M3U = "m3u";
    private static final String EXTENSION_M3U8 = "m3u8";
    private static final int HAS_USER_EVENT = 20520;
    public static final String PAN_HOME_PAGE_SCHEME = "baiduboxapp://swan/OyIvf6LYVhKkbIHS1USP7xnSKYxc36SH/pages/home/index?from=1026350x_1026350y&_baiduboxapp=%7B%22from%22%3A%221201001310003000%22%2C%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
    public static final String SCHEMA_TO_KEY_PREFIX = "baiduboxapp://v1/browser/search?sa=ld_quick_play_huisou&query=";
    public static final String SCHEMA_TO_PLAYER = "/pages/file/play-video/index?source=spnative&from=1025163u_1025163v&savepath=%s&exp_id=%s&_baiduboxapp={\"from\":\"1081000810007000\"}";
    public static final String SCHEMA_TO_PLAYER_EXP1 = "/pages/file/play-video/index?source=spnative&from=1027327m_1027327n&savepath=%s&exp_id=%s";
    public static final String SCHEMA_TO_SWAN_PREFIX = "baiduboxapp://swan/OyIvf6LYVhKkbIHS1USP7xnSKYxc36SH";
    public static final String SCHEMA_TO_TRANS_LIST = "/pages/task/index?source=spnative&from=1025163w_1025163x&current_type=sp_native&exp_id=%s&_baiduboxapp={\"from\":\"1081000810007000\"}";
    public static final String SCHEMA_TO_VIDEO_LIST_EXP2 = "/pages/home/index?source=spnative&from=1027327o_1027327p&isSaved=1&path=%s&saveList=%s&exp_id=%s";
    public static final String SCHEMA_TO_VIDEO_LIST_EXP3 = "/pages/file/play-video/index?source=spnative&from=1027940c_1027940d&savepath=%s&source_url=%s&type=0&file_name=%s&http_type=%s&app_id=5494197&is_rapid=1&is_sniff_video=1&exp_id=%s";
    public static final String STATISTIC_DOWNLOAD_PARTNER_ID = "search_video_dialog";
    public static final String STATISTIC_PARTNER_ID = "search";
    private static final int THOUSAND_MULTIPLE = 1000;
    public static final String UBC_FROM_SEARCH = "wpkuorong";
    public static final String UBC_SOURCE_SEARCH = "search";
    private static DownloadMultiBtnUrlCheckWindow downloadPanel;
    private static String globalClickFrom = "";
    private static int globalVideoListSize;
    private static boolean isAutoShowing;
    private static boolean isNeedRefVip;
    private static volatile boolean isShowBanner;
    private static volatile boolean isShowBannerFinal;
    private static volatile boolean isShowVerticalStyle;
    private static boolean isSnifferSource;
    private static volatile SearchH5VipBannerOperatorInfo snifferBannerOperatorInfo;
    private static BaseMenuPopupWindow<SearchVideoSnifferMenuView> snifferPanel;
    private static final Lazy snifferPanelDismissListeners$delegate = LazyKt.lazy(SearchH5ToastUtilKt$snifferPanelDismissListeners$2.INSTANCE);

    public static final boolean isNeedRefVip() {
        return isNeedRefVip;
    }

    public static final void setNeedRefVip(boolean z) {
        isNeedRefVip = z;
    }

    public static final void showDownloadTaskExistToast(int status, Context context) {
        if (context != null) {
            switch (status) {
                case 190:
                    String string = context.getString(R.string.search_h5_video_downloading);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…rch_h5_video_downloading)");
                    showDownloadMsgToast(string);
                    return;
                case 192:
                    String string2 = context.getString(R.string.search_h5_video_downloading);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…rch_h5_video_downloading)");
                    showDownloadMsgToast(string2);
                    return;
                case 193:
                    String string3 = context.getString(R.string.search_h5_video_download_pause);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…_h5_video_download_pause)");
                    showDownloadMsgToast(string3);
                    return;
                case 200:
                    String string4 = context.getString(R.string.search_h5_video_downloaded);
                    Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…arch_h5_video_downloaded)");
                    showDownloadMsgToast(string4);
                    return;
                default:
                    String string5 = context.getString(R.string.search_h5_video_download_fail);
                    Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…h_h5_video_download_fail)");
                    showDownloadMsgToast(string5);
                    return;
            }
        }
    }

    public static final void showDownloadMsgToast(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        showDownloadMsgToast(msg, BdBoxActivityManager.getTopActivity());
    }

    public static final void showDownloadMsgToast(String msg, Context activity) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        showDownloadMsgToast(msg, activity, (JSONObject) null);
    }

    public static final void showDownloadMsgToast(String msg, Context activity, JSONObject ext) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (activity != null && !SearchH5VideoUtils.isDownloadActivity(activity)) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda0(activity, msg, ext));
            if (Intrinsics.areEqual((Object) msg, (Object) activity.getString(R.string.search_h5_video_download_start))) {
                SearchH5VideoUbcUtils.downloadTipsShow("toast_begin");
                SearchH5VideoUbcUtils.startDownload();
            } else if (!Intrinsics.areEqual((Object) msg, (Object) activity.getString(R.string.search_h5_video_downloaded))) {
            } else {
                if (ext != null) {
                    SearchH5VideoUbcUtils.downloadTipsShow("toast_done", ext);
                } else {
                    SearchH5VideoUbcUtils.downloadTipsShow("toast_done");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadMsgToast$lambda-2  reason: not valid java name */
    public static final void m3042showDownloadMsgToast$lambda2(Context $activity, String $msg, JSONObject $ext) {
        Intrinsics.checkNotNullParameter($msg, "$msg");
        UniversalToast.makeText($activity, (CharSequence) $msg).setDuration(3).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda12($activity, $msg, $ext)).showClickableToastForFullScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadMsgToast$lambda-2$lambda-1  reason: not valid java name */
    public static final void m3043showDownloadMsgToast$lambda2$lambda1(Context $activity, String $msg, JSONObject $ext) {
        Intrinsics.checkNotNullParameter($msg, "$msg");
        Intent it = new Intent($activity, FileManagerActivity.class);
        it.putExtra(DownloadCenterFunConstants.EXTRA_ENTER_COMPLETED_TAB, false);
        $activity.startActivity(it);
        if (Intrinsics.areEqual((Object) $msg, (Object) $activity.getString(R.string.search_h5_video_download_start))) {
            SearchH5VideoUbcUtils.downloadTipsClick("toast_begin");
        } else if (!Intrinsics.areEqual((Object) $msg, (Object) $activity.getString(R.string.search_h5_video_downloaded))) {
        } else {
            if ($ext != null) {
                SearchH5VideoUbcUtils.downloadTipsClick("toast_done", $ext);
            } else {
                SearchH5VideoUbcUtils.downloadTipsClick("toast_done");
            }
        }
    }

    public static /* synthetic */ void showPlayableDownloadStartToast$default(Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = BdBoxActivityManager.getTopActivity();
        }
        showPlayableDownloadStartToast(context);
    }

    public static final void showPlayableDownloadStartToast(Context activity) {
        if (activity != null) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda2(activity));
            SearchH5VideoUbcUtils.downloadTipsShow("toast_begin");
            SearchH5VideoUbcUtils.startDownload();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showPlayableDownloadStartToast$lambda-5  reason: not valid java name */
    public static final void m3052showPlayableDownloadStartToast$lambda5(Context $activity) {
        String title = $activity.getString(R.string.search_h5_video_download_start);
        Intrinsics.checkNotNullExpressionValue(title, "activity.getString(R.str…_h5_video_download_start)");
        String subTitle = $activity.getString(R.string.search_h5_video_play_while_download_sub_toast);
        Intrinsics.checkNotNullExpressionValue(subTitle, "activity.getString(R.str…while_download_sub_toast)");
        String rightCheckText = $activity.getString(R.string.search_h5_video_download_toast_check);
        Intrinsics.checkNotNullExpressionValue(rightCheckText, "activity.getString(R.str…deo_download_toast_check)");
        UniversalToast.makeText($activity).setTitleText(title).setSubTitle(subTitle).setRightText(rightCheckText).setTemplate(ToastTemplate.T3).setDuration(3).setFullScreen(true).setOverFloatWindow(true).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda26($activity)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showPlayableDownloadStartToast$lambda-5$lambda-4  reason: not valid java name */
    public static final void m3053showPlayableDownloadStartToast$lambda5$lambda4(Context $activity) {
        Intent it = new Intent($activity, FileManagerActivity.class);
        it.putExtra(DownloadCenterFunConstants.EXTRA_ENTER_COMPLETED_TAB, false);
        $activity.startActivity(it);
        SearchH5VideoUbcUtils.downloadTipsClick("toast_begin");
    }

    public static final BaseMenuPopupWindow<SearchVideoSnifferMenuView> getSnifferPanel() {
        return snifferPanel;
    }

    public static final void setSnifferPanel(BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow) {
        snifferPanel = baseMenuPopupWindow;
    }

    public static final boolean isSnifferSource() {
        return isSnifferSource;
    }

    public static final void setSnifferSource(boolean z) {
        isSnifferSource = z;
    }

    public static final boolean isAutoShowing() {
        return isAutoShowing;
    }

    public static final void setAutoShowing(boolean z) {
        isAutoShowing = z;
    }

    public static final String getGlobalClickFrom() {
        return globalClickFrom;
    }

    public static final void setGlobalClickFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        globalClickFrom = str;
    }

    public static final int getGlobalVideoListSize() {
        return globalVideoListSize;
    }

    public static final void setGlobalVideoListSize(int i2) {
        globalVideoListSize = i2;
    }

    public static final boolean isShowBanner() {
        return isShowBanner;
    }

    public static final void setShowBanner(boolean z) {
        isShowBanner = z;
    }

    public static final SearchH5VipBannerOperatorInfo getSnifferBannerOperatorInfo() {
        return snifferBannerOperatorInfo;
    }

    public static final void setSnifferBannerOperatorInfo(SearchH5VipBannerOperatorInfo searchH5VipBannerOperatorInfo) {
        snifferBannerOperatorInfo = searchH5VipBannerOperatorInfo;
    }

    public static final boolean isShowBannerFinal() {
        return isShowBannerFinal;
    }

    public static final void setShowBannerFinal(boolean z) {
        isShowBannerFinal = z;
    }

    public static final boolean isShowVerticalStyle() {
        return isShowVerticalStyle;
    }

    public static final void setShowVerticalStyle(boolean z) {
        isShowVerticalStyle = z;
    }

    private static final List<WeakReference<PopupWindow.OnDismissListener>> getSnifferPanelDismissListeners() {
        return (List) snifferPanelDismissListeners$delegate.getValue();
    }

    public static final void dispatchSnifferPanelDismiss() {
        for (WeakReference it : getSnifferPanelDismissListeners()) {
            PopupWindow.OnDismissListener onDismissListener = (PopupWindow.OnDismissListener) it.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }
    }

    public static final void registerSnifferPanelDismissListener(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getSnifferPanelDismissListeners().add(new WeakReference(listener));
    }

    public static final void unregisterSnifferPanelDismissListener(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        for (WeakReference it : getSnifferPanelDismissListeners()) {
            if (Intrinsics.areEqual(it.get(), (Object) listener)) {
                getSnifferPanelDismissListeners().remove(it);
            }
        }
    }

    public static final void initSnifferPanelCommandAndOperatorInfo() {
        isShowBanner = SearchVideoSnifferPanelStyleExperiment.INSTANCE.getIsShowBanner();
        snifferBannerOperatorInfo = SearchH5VipBanner.Companion.getCachedOperatorInfo();
        isShowBannerFinal = isShowBanner || snifferBannerOperatorInfo != null;
        isShowVerticalStyle = SearchVideoSnifferPanelStyleExperiment.INSTANCE.getIsShowVerticalStyle();
    }

    public static final void showSnifferPanel(List<SearchVideoH5DownloadModel> videoList, String source, String clickFrom) {
        Activity activity;
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(clickFrom, "clickFrom");
        if (!LcbSendVipManager.INSTANCE.isShieldedNetDiskAbility()) {
            SearchH5ProxyPlayer player = H5PlayerCache.getInstance().getPlayer();
            if (player == null || (activity = player.getActivity()) == null) {
                activity = BdBoxActivityManager.getTopActivity();
            }
            Activity context = activity;
            if (context != null) {
                Ref.BooleanRef showSubTitle = new Ref.BooleanRef();
                Iterator<SearchVideoH5DownloadModel> it = videoList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getShowNetDiskBtn()) {
                            showSubTitle.element = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                globalClickFrom = clickFrom;
                globalVideoListSize = videoList.size();
                UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda1(context, source, clickFrom, videoList, showSubTitle));
                if (!SearchH5DetectUtlsKt.getSnifferVideoList().isEmpty()) {
                    SearchH5DetectUtlsKt.setLastDetectedPage(SearchH5DetectUtlsKt.getSnifferVideoList().get(0).getPageUrl());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSnifferPanel$lambda-10  reason: not valid java name */
    public static final void m3056showSnifferPanel$lambda10(Activity $context, String $source, String $clickFrom, List $videoList, Ref.BooleanRef $showSubTitle) {
        SearchH5VideoPlayer searchH5VideoPlayer;
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($source, "$source");
        Intrinsics.checkNotNullParameter($clickFrom, "$clickFrom");
        Intrinsics.checkNotNullParameter($videoList, "$videoList");
        Intrinsics.checkNotNullParameter($showSubTitle, "$showSubTitle");
        View attachView = $context.findViewById(16908290);
        if (attachView != null) {
            dismissSnifferPanel();
            initSnifferPanelCommandAndOperatorInfo();
            BaseMenuPopupWindow<SearchVideoSnifferMenuView> searchH5ToastUtilKt$showSnifferPanel$1$1 = new SearchH5ToastUtilKt$showSnifferPanel$1$1($context, attachView, $source, $clickFrom, $videoList, $showSubTitle);
            snifferPanel = searchH5ToastUtilKt$showSnifferPanel$1$1;
            searchH5ToastUtilKt$showSnifferPanel$1$1.setMaskClickListener(new SearchH5ToastUtilKt$$ExternalSyntheticLambda14());
            BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
            if (baseMenuPopupWindow != null) {
                baseMenuPopupWindow.setSoftInputMode(3);
            }
            BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow2 = snifferPanel;
            if (baseMenuPopupWindow2 != null) {
                baseMenuPopupWindow2.setOnDismissListener(new SearchH5ToastUtilKt$showSnifferPanel$1$3());
            }
            BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow3 = snifferPanel;
            if (baseMenuPopupWindow3 != null) {
                baseMenuPopupWindow3.setTouchInterceptor(new SearchH5ToastUtilKt$$ExternalSyntheticLambda15($context));
            }
            if (!$context.isFinishing() && !$context.isDestroyed()) {
                FloatingBallViewUtilsKt.hideFloatingBallView();
                FloatingBallExpandViewUtilsKt.dismissFloatingBallExpandView$default(false, (ExpandViewAnimatorListener) null, 3, (Object) null);
                dismissSnifferPanel();
                BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow4 = snifferPanel;
                if (baseMenuPopupWindow4 != null) {
                    baseMenuPopupWindow4.showView();
                }
                SearchH5NetDiskVipUtilsKt.preloadNetDisk();
                dismissPanelWithDuration($source);
                SearchH5ProxyPlayer player = H5PlayerCache.getInstance().getPlayer();
                if (player != null && (searchH5VideoPlayer = player.mPlayer) != null) {
                    searchH5VideoPlayer.disableOrientationEventHelper();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSnifferPanel$lambda-10$lambda-8  reason: not valid java name */
    public static final void m3057showSnifferPanel$lambda10$lambda8(BaseMenuView it) {
        dismissSnifferPanel();
    }

    /* access modifiers changed from: private */
    /* renamed from: showSnifferPanel$lambda-10$lambda-9  reason: not valid java name */
    public static final boolean m3058showSnifferPanel$lambda10$lambda9(Activity $context, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        Intrinsics.checkNotNullExpressionValue(event, "event");
        isInterceptTouch(view2, event, $context);
        view2.performClick();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void addTopViewForSnifferPanel(Context context, SearchVideoSnifferMenuView snifferMenuView, List<SearchVideoH5DownloadModel> videoList, String clickFrom) {
        SearchH5NetDiskVipUtilsKt.setPurchaseFrom(SearchH5NetDiskVipUtilsKt.FROM_SNIFFER_BANNER);
        SearchH5VipBanner searchH5VipBanner = new SearchH5VipBanner(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        searchH5VipBanner.setOperatorInfo(snifferBannerOperatorInfo);
        snifferMenuView.setTopView(searchH5VipBanner, new RelativeLayout.LayoutParams(-1, -2));
        searchH5VipBanner.setTranslationY((float) DeviceUtils.ScreenInfo.dp2px(context, 17.0f));
        searchH5VipBanner.setZ(-1.0f);
        searchH5VipBanner.setAttachedScene(SearchH5VipBanner.AttachedScene.SNIFFER_PANEL);
        searchH5VipBanner.update();
        searchH5VipBanner.setOnClickListener(new SearchH5ToastUtilKt$$ExternalSyntheticLambda9(searchH5VipBanner, context, videoList, clickFrom));
        SearchH5VideoUbcUtils.snifferBannerUbc("show");
    }

    /* access modifiers changed from: private */
    /* renamed from: addTopViewForSnifferPanel$lambda-11  reason: not valid java name */
    public static final void m3033addTopViewForSnifferPanel$lambda11(SearchH5VipBanner $topView, Context $context, List $videoList, String $clickFrom, View it) {
        Intrinsics.checkNotNullParameter($topView, "$topView");
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($videoList, "$videoList");
        Intrinsics.checkNotNullParameter($clickFrom, "$clickFrom");
        if (!LcbSendVipManager.INSTANCE.isTargetFreeSend7DaysUser() && !LcbSendVipManager.INSTANCE.isTargetFreeSendExp2()) {
            dismissDownloadPanelOrDialog();
            SearchH5SaveNetUtilsKt.login(new SearchH5ToastUtilKt$addTopViewForSnifferPanel$1$1($topView, $context, $videoList, $clickFrom));
            SearchH5VideoUbcUtils.snifferBannerUbc("click");
            if (SearchH5AbManager.INSTANCE.isSnifferShieldOpen()) {
                SnifferPanelShieldManager.INSTANCE.onConsume();
            }
        }
    }

    private static final void addTopViewForDownloadPanel(Context context, DownloadMultiBtnUrlCheckWindow.Builder downloadBuilder, SearchVideoH5DownloadModel downloadInfo) {
        if ((!SearchH5NetDiskVipUtilsKt.isVip() || LcbSendVipManager.INSTANCE.isTempDuVip() || LcbSendVipManager.INSTANCE.isTargetFreeSendUser()) && !SearchH5NetDiskVipUtilsKt.isSVip() && !SearchH5NetDiskVipUtilsKt.isNewVip()) {
            SearchH5NetDiskVipUtilsKt.setPurchaseFrom(SearchH5NetDiskVipUtilsKt.FROM_DOWNLOAD_BANNER);
            SearchH5VipBanner searchH5VipBanner = new SearchH5VipBanner(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            downloadBuilder.setTopView(searchH5VipBanner);
            searchH5VipBanner.setTranslationY((float) DeviceUtils.ScreenInfo.dp2px(context, 17.0f));
            searchH5VipBanner.setZ(-1.0f);
            searchH5VipBanner.setAttachedScene(SearchH5VipBanner.AttachedScene.DOWNLOAD_PANEL);
            searchH5VipBanner.setClickListener(new SearchH5ToastUtilKt$$ExternalSyntheticLambda3(downloadInfo));
            SearchH5VideoUbcUtils.vipBannerShow("download");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addTopViewForDownloadPanel$lambda-12  reason: not valid java name */
    public static final void m3032addTopViewForDownloadPanel$lambda12(SearchVideoH5DownloadModel $downloadInfo, View it) {
        Intrinsics.checkNotNullParameter($downloadInfo, "$downloadInfo");
        if (!LcbSendVipManager.INSTANCE.isTargetFreeSend7DaysUser() && !LcbSendVipManager.INSTANCE.isTargetFreeSendExp2()) {
            dismissDownloadPanelOrDialog();
            SearchH5SaveNetUtilsKt.login(new SearchH5ToastUtilKt$addTopViewForDownloadPanel$1$1($downloadInfo));
            SearchH5VideoUbcUtils.vipBannerClick("download");
        }
    }

    public static final void updateSnifferPanel() {
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        boolean z = true;
        if (baseMenuPopupWindow == null || !baseMenuPopupWindow.isShowing()) {
            z = false;
        }
        if (z) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda25());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateSnifferPanel$lambda-13  reason: not valid java name */
    public static final void m3059updateSnifferPanel$lambda13() {
        SearchVideoSnifferMenuView mainMenuView;
        SearchVideoSnifferMenuView mainMenuView2;
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        if (!(baseMenuPopupWindow == null || (mainMenuView2 = baseMenuPopupWindow.getMainMenuView()) == null)) {
            mainMenuView2.updateTips();
        }
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow2 = snifferPanel;
        if (baseMenuPopupWindow2 != null && (mainMenuView = baseMenuPopupWindow2.getMainMenuView()) != null) {
            mainMenuView.updateTopView();
        }
    }

    public static final void dismissDownloadPanelOrDialog() {
        UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda21());
    }

    /* access modifiers changed from: private */
    /* renamed from: dismissDownloadPanelOrDialog$lambda-14  reason: not valid java name */
    public static final void m3039dismissDownloadPanelOrDialog$lambda14() {
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        if (baseMenuPopupWindow != null) {
            baseMenuPopupWindow.dismiss();
        }
        DownloadMultiBtnUrlCheckWindow downloadMultiBtnUrlCheckWindow = downloadPanel;
        if (downloadMultiBtnUrlCheckWindow != null) {
            downloadMultiBtnUrlCheckWindow.dismiss();
        }
    }

    public static final boolean isDownloadPanelShowing() {
        DownloadMultiBtnUrlCheckWindow downloadMultiBtnUrlCheckWindow = downloadPanel;
        return downloadMultiBtnUrlCheckWindow != null && downloadMultiBtnUrlCheckWindow.isShowing();
    }

    public static final boolean isSnifferPanelShowing() {
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        return baseMenuPopupWindow != null && baseMenuPopupWindow.isShowing();
    }

    public static final DownloadMultiBtnUrlCheckWindow getDownloadPanel() {
        return downloadPanel;
    }

    public static final void setDownloadPanel(DownloadMultiBtnUrlCheckWindow downloadMultiBtnUrlCheckWindow) {
        downloadPanel = downloadMultiBtnUrlCheckWindow;
    }

    public static final void showDownloadPanel(SearchVideoH5DownloadModel downloadInfo) {
        String downloadUrl;
        dismissSnifferPanel();
        if (downloadInfo != null && (downloadUrl = downloadInfo.getDownloadUrl()) != null && !TextUtils.isEmpty(downloadUrl)) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda13(downloadInfo, downloadUrl));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r6 = r4.getSecondSourceUrl();
     */
    /* renamed from: showDownloadPanel$lambda-16  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3044showDownloadPanel$lambda16(com.baidu.searchbox.search.webvideo.model.SearchVideoH5DownloadModel r17, java.lang.String r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "$downloadUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.baidu.searchbox.search.webvideo.cache.H5PlayerCache r2 = com.baidu.searchbox.search.webvideo.cache.H5PlayerCache.getInstance()
            if (r2 == 0) goto L_0x001b
            com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer r2 = r2.getPlayer()
            if (r2 == 0) goto L_0x001b
            android.app.Activity r2 = r2.getActivity()
            if (r2 != 0) goto L_0x001f
        L_0x001b:
            android.app.Activity r2 = com.baidu.searchbox.appframework.BdBoxActivityManager.getTopActivity()
        L_0x001f:
            if (r2 == 0) goto L_0x0165
            boolean r3 = com.baidu.searchbox.downloads.appsearch.helper.TransferNetDiskDownloadHelperKt.getEnableFastDownloadPanel()
            java.lang.String r4 = "lcb_xz_bt_show"
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x00b6
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.lcbVideoStepCommonUbc(r4)
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showDownloadPanel$1$1 r3 = com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showDownloadPanel$1$1.INSTANCE
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            java.lang.String r4 = "fastDownloadPanel"
            com.baidu.searchbox.download.util.DebugUtilsKt.printLog(r4, r3)
            java.lang.String r3 = r17.getExtension()
            com.baidu.searchbox.search.webvideo.model.NetDiskParamsInfo r4 = r17.getNetDiskParamsInfo()
            java.lang.String r6 = "m3u8"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0056
            if (r4 == 0) goto L_0x0054
            java.lang.String r6 = r4.getSecondSourceUrl()
            if (r6 != 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r8 = r6
            goto L_0x005f
        L_0x0054:
            r8 = r5
            goto L_0x005f
        L_0x0056:
            java.lang.String r6 = r17.getDownloadUrl()
            if (r6 != 0) goto L_0x005e
            r8 = r5
            goto L_0x005f
        L_0x005e:
            r8 = r6
        L_0x005f:
            r7 = r2
            android.content.Context r7 = (android.content.Context) r7
            r9 = 0
            if (r4 == 0) goto L_0x006e
            int r6 = r4.getFileSize()
            long r11 = (long) r6
            goto L_0x006f
        L_0x006e:
            r11 = r9
        L_0x006f:
            java.lang.Long r6 = java.lang.Long.valueOf(r11)
            if (r4 == 0) goto L_0x0079
            long r9 = r4.getLastModifyTime()
        L_0x0079:
            java.lang.Long r10 = java.lang.Long.valueOf(r9)
            if (r4 == 0) goto L_0x0088
            java.lang.String r9 = r4.getSecondFileMd5()
            if (r9 != 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            r11 = r9
            goto L_0x0089
        L_0x0088:
            r11 = r5
        L_0x0089:
            r12 = 2000(0x7d0, double:9.88E-321)
            java.lang.String r14 = r17.getTitle()
            java.lang.String r15 = r17.getWebsite()
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showDownloadPanel$1$2 r5 = new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showDownloadPanel$1$2
            r5.<init>(r1, r0, r2)
            r16 = r5
            kotlin.jvm.functions.Function5 r16 = (kotlin.jvm.functions.Function5) r16
            r9 = r6
            com.baidu.searchbox.download.business.util.P2pNetDiskDownloadUtilsKt.queryP2pNetDiskDownloadInfo(r7, r8, r9, r10, r11, r12, r14, r15, r16)
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.panelShowUbcStatistic()
            com.baidu.searchbox.search.webvideo.cache.H5PlayerCache r5 = com.baidu.searchbox.search.webvideo.cache.H5PlayerCache.getInstance()
            com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer r5 = r5.getPlayer()
            if (r5 == 0) goto L_0x0165
            com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer r5 = r5.mPlayer
            if (r5 == 0) goto L_0x0165
            r5.disableOrientationEventHelper()
            goto L_0x0165
        L_0x00b6:
            com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow$Builder r3 = new com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow$Builder
            android.view.Window r6 = r2.getWindow()
            android.view.View r6 = r6.getDecorView()
            r3.<init>(r6)
            r6 = 1
            r3.setDividerVisible(r6)
            java.lang.String r6 = r17.getDownloadUrl()
            r3.setUrl(r6)
            java.lang.String r6 = r17.getFileName()
            r3.setMessage((java.lang.String) r6)
            com.baidu.searchbox.search.webvideo.utils.SearchH5AbManager r6 = com.baidu.searchbox.search.webvideo.utils.SearchH5AbManager.INSTANCE
            boolean r6 = r6.netDiskSwitch()
            if (r6 == 0) goto L_0x00ff
            boolean r6 = com.baidu.searchbox.search.webvideo.utils.VideoDetectShieldServiceHelperKt.getShowNetDisk()
            if (r6 == 0) goto L_0x00ff
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.lcbVideoStepCommonUbc(r4)
            r4 = r2
            android.content.Context r4 = (android.content.Context) r4
            r6 = r3
            com.baidu.android.ext.widget.DownloadUrlCheckWindow$Builder r6 = (com.baidu.android.ext.widget.DownloadUrlCheckWindow.Builder) r6
            configDownloadAndNetDiskBtn(r4, r6, r0)
            com.baidu.searchbox.search.webvideo.vip.LcbSendVipManager r4 = com.baidu.searchbox.search.webvideo.vip.LcbSendVipManager.INSTANCE
            boolean r4 = r4.isShieldedNetDiskAbility()
            if (r4 != 0) goto L_0x0108
            r4 = r2
            android.content.Context r4 = (android.content.Context) r4
            addTopViewForDownloadPanel(r4, r3, r0)
            goto L_0x0108
        L_0x00ff:
            r4 = r2
            android.content.Context r4 = (android.content.Context) r4
            r6 = r3
            com.baidu.android.ext.widget.DownloadUrlCheckWindow$Builder r6 = (com.baidu.android.ext.widget.DownloadUrlCheckWindow.Builder) r6
            configOnlyDownloadBtn(r4, r6, r0)
        L_0x0108:
            java.lang.String r4 = r17.getDesc()
            r3.setFileSize(r4)
            com.baidu.searchbox.downloads.FilePathChangeImpl r4 = new com.baidu.searchbox.downloads.FilePathChangeImpl
            r4.<init>()
            r6 = r4
            com.baidu.android.ext.widget.ListBtnPopupWindow$IFilePathChange r6 = (com.baidu.android.ext.widget.ListBtnPopupWindow.IFilePathChange) r6
            java.lang.String r7 = r17.getFileName()
            r8 = 0
            r3.setDownloadPathChangeListener(r6, r7, r5, r8)
            com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow r5 = r3.create()
            boolean r6 = r5 instanceof com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow
            if (r6 == 0) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            r5 = 0
        L_0x012b:
            downloadPanel = r5
            if (r5 != 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            r6 = 3
            r5.setSoftInputMode(r6)
        L_0x0134:
            com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow r5 = downloadPanel
            com.baidu.android.ext.widget.ListBtnPopupWindow r5 = (com.baidu.android.ext.widget.ListBtnPopupWindow) r5
            r4.setRealDialog(r5)
            com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow r5 = downloadPanel
            if (r5 == 0) goto L_0x0147
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$$ExternalSyntheticLambda22 r6 = new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$$ExternalSyntheticLambda22
            r6.<init>()
            r5.setOnDismissListener(r6)
        L_0x0147:
            com.baidu.android.ext.widget.DownloadMultiBtnUrlCheckWindow r5 = downloadPanel
            if (r5 == 0) goto L_0x014e
            r5.show()
        L_0x014e:
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.panelShowUbcStatistic()
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.downloadUserInfoEvent()
            com.baidu.searchbox.search.webvideo.cache.H5PlayerCache r5 = com.baidu.searchbox.search.webvideo.cache.H5PlayerCache.getInstance()
            com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer r5 = r5.getPlayer()
            if (r5 == 0) goto L_0x0165
            com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer r5 = r5.mPlayer
            if (r5 == 0) goto L_0x0165
            r5.disableOrientationEventHelper()
        L_0x0165:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt.m3044showDownloadPanel$lambda16(com.baidu.searchbox.search.webvideo.model.SearchVideoH5DownloadModel, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadPanel$lambda-16$lambda-15  reason: not valid java name */
    public static final void m3045showDownloadPanel$lambda16$lambda15() {
        SearchH5VideoPlayer searchH5VideoPlayer;
        SearchH5VideoUbcUtils.snifferPanelDismiss("close", (Long) null);
        downloadPanel = null;
        SearchH5ProxyPlayer player = H5PlayerCache.getInstance().getPlayer();
        if (player != null && (searchH5VideoPlayer = player.mPlayer) != null) {
            searchH5VideoPlayer.enableOrientationEventHelper();
        }
    }

    private static final void configOnlyDownloadBtn(Context context, DownloadUrlCheckWindow.Builder dialogBuilder, SearchVideoH5DownloadModel downloadInfo) {
        dialogBuilder.addListBtnItem(context.getText(com.baidu.searchbox.download.base.R.string.download_default_text), com.baidu.searchbox.download.base.R.color.download_strong_btn_text_color, 0, com.baidu.searchbox.download.base.R.drawable.download_popup_multi_btn_single_line_blue_bg, new SearchH5ToastUtilKt$$ExternalSyntheticLambda6(context, downloadInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: configOnlyDownloadBtn$lambda-17  reason: not valid java name */
    public static final void m3038configOnlyDownloadBtn$lambda17(Context $context, SearchVideoH5DownloadModel $downloadInfo, AdapterView adapterView, View view2, int i2, long j2) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($downloadInfo, "$downloadInfo");
        SearchH5DownloadUtilsKt.download$default($context, $downloadInfo, false, 4, (Object) null);
    }

    private static final void configDownloadAndNetDiskBtn(Context context, DownloadUrlCheckWindow.Builder dialogBuilder, SearchVideoH5DownloadModel downloadInfo) {
        CharSequence subText = getSaveNetDiskSubTitle(context);
        if (!LcbSendVipManager.INSTANCE.isShieldedNetDiskAbility()) {
            configNetDiskBtn(context, dialogBuilder, subText, downloadInfo);
        }
        configDownloadBtn(context, dialogBuilder, downloadInfo);
    }

    private static final void configDownloadBtn(Context context, DownloadUrlCheckWindow.Builder dialogBuilder, SearchVideoH5DownloadModel downloadInfo) {
        String it;
        Context context2 = context;
        SearchVideoH5DownloadModel searchVideoH5DownloadModel = downloadInfo;
        String it2 = DownloadByteConverter.convertByte(((double) DownloadHelper.getAvailableBytes(Environment.getExternalStorageDirectory())) * 1.0d, 1, false);
        if (it2 != null) {
            it = context2.getText(R.string.download_panel_download_btn_desc) + it2;
        } else {
            it = null;
        }
        if (!canShowPlayDownloadTip(downloadInfo)) {
            dialogBuilder.addListBtnItem(context2.getText(R.string.download_panel_download_btn_txt), com.baidu.android.common.ui.style.R.color.GC1, (CharSequence) it, com.baidu.android.common.ui.style.R.color.GC4, com.baidu.searchbox.download.base.R.drawable.download_popup_multi_btn_two_lines_stroke_bg, false, (AdapterView.OnItemClickListener) new SearchH5ToastUtilKt$$ExternalSyntheticLambda7(context2, searchVideoH5DownloadModel));
            return;
        }
        String highlightText = context2.getString(R.string.search_h5_video_play_while_download);
        Intrinsics.checkNotNullExpressionValue(highlightText, "context.getString(R.stri…ideo_play_while_download)");
        String downloadSubText = "支持" + highlightText + " | " + it;
        SpannableString spannableSubText = new SpannableString(downloadSubText);
        int highlightStart = StringsKt.indexOf$default((CharSequence) downloadSubText, highlightText, 0, false, 6, (Object) null);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context2, com.baidu.android.common.ui.style.R.color.GC7));
        spannableSubText.setSpan(colorSpan, highlightStart, highlightText.length() + highlightStart, 17);
        ForegroundColorSpan foregroundColorSpan = colorSpan;
        SpannableString spannableString = spannableSubText;
        dialogBuilder.addListBtnItem(context2.getText(R.string.download_panel_download_btn_txt), com.baidu.android.common.ui.style.R.color.GC1, spannableSubText, com.baidu.android.common.ui.style.R.color.GC4, com.baidu.searchbox.download.base.R.drawable.download_popup_multi_btn_two_lines_stroke_bg, false, (AdapterView.OnItemClickListener) new SearchH5ToastUtilKt$$ExternalSyntheticLambda8(context2, searchVideoH5DownloadModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: configDownloadBtn$lambda-20  reason: not valid java name */
    public static final void m3035configDownloadBtn$lambda20(Context $context, SearchVideoH5DownloadModel $downloadInfo, AdapterView adapterView, View view2, int i2, long j2) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($downloadInfo, "$downloadInfo");
        SearchH5DownloadUtilsKt.download$default($context, $downloadInfo, false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: configDownloadBtn$lambda-21  reason: not valid java name */
    public static final void m3036configDownloadBtn$lambda21(Context $context, SearchVideoH5DownloadModel $downloadInfo, AdapterView adapterView, View view2, int i2, long j2) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($downloadInfo, "$downloadInfo");
        SearchH5DownloadUtilsKt.download$default($context, $downloadInfo, false, 4, (Object) null);
    }

    private static final void configNetDiskBtn(Context context, DownloadUrlCheckWindow.Builder dialogBuilder, CharSequence subText, SearchVideoH5DownloadModel downloadInfo) {
        dialogBuilder.addListBtnItem(context.getText(R.string.download_panel_save_to_net_disk), com.baidu.android.common.ui.style.R.color.GC96, subText, com.baidu.android.common.ui.style.R.color.GC96, com.baidu.searchbox.download.base.R.drawable.download_popup_multi_btn_two_lines_golden_bg, SearchH5NetDiskVipUtilsKt.showLcpTempFreeVipBubble() ? false : SearchH5NetDiskVipUtilsKt.showFreeRightsBubble(), (AdapterView.OnItemClickListener) new SearchH5ToastUtilKt$$ExternalSyntheticLambda23(downloadInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: configNetDiskBtn$lambda-22  reason: not valid java name */
    public static final void m3037configNetDiskBtn$lambda22(SearchVideoH5DownloadModel $downloadInfo, AdapterView adapterView, View view2, int i2, long j2) {
        Intrinsics.checkNotNullParameter($downloadInfo, "$downloadInfo");
        SearchH5NetDiskVipUtilsKt.setPurchaseFrom(SearchH5NetDiskVipUtilsKt.FROM_DOWNLOAD_PANEL);
        SearchH5SaveNetUtilsKt.checkBeforeSave($downloadInfo.getDownloadUrl(), false, new SearchH5ToastUtilKt$configNetDiskBtn$1$1($downloadInfo, SearchH5NetDiskVipUtilsKt.isVip()));
        SearchH5VideoUbcUtils.lcbVideoStepCommonUbc(SearchH5VideoUbcUtils.STEP_LCB_XZ_BT_CLICK);
    }

    /* access modifiers changed from: private */
    public static final CharSequence getSaveNetDiskSubTitle(Context context) {
        String str;
        String str2;
        if (!SearchH5NetDiskVipUtilsKt.isLogin()) {
            if (LcbSendVipManager.INSTANCE.isTargetFreeSendUser()) {
                str2 = context.getString(R.string.lcp_user_get_free_download_btn_text);
            } else {
                str2 = context.getString(R.string.download_panel_save_to_net_disk_subtext);
            }
            return str2;
        } else if (LcbSendVipManager.INSTANCE.isTargetFreeSendExp2()) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getText(R.string.search_h5_vip_floating_free_vip_subtitle);
            }
            return null;
        } else if (LcbSendVipManager.INSTANCE.isTargetFreeSend7DaysUser()) {
            Resources resources2 = context.getResources();
            if (resources2 != null) {
                return resources2.getText(R.string.search_h5_vip_floating_free_day_already_vip_subtitle);
            }
            return null;
        } else if (SearchH5NetDiskVipUtilsKt.isVip()) {
            return context.getString(R.string.download_panel_save_to_net_disk_subtext_vip);
        } else {
            if (SearchH5NetDiskVipUtilsKt.isSVip()) {
                Resources resources3 = context.getResources();
                if (resources3 != null) {
                    return resources3.getText(R.string.search_h5_vip_banner_title_svip);
                }
                return null;
            } else if (SearchH5NetDiskVipUtilsKt.isNewVip()) {
                Resources resources4 = context.getResources();
                if (resources4 != null) {
                    return resources4.getText(R.string.search_h5_vip_banner_title_new_vip);
                }
                return null;
            } else if (LcbSendVipManager.INSTANCE.isTargetFreeSendUser()) {
                if (!LcbSendVipManager.INSTANCE.isAlreadyRequestGetFreeVip()) {
                    str = context.getString(R.string.lcp_user_get_free_download_btn_text);
                } else if (SearchH5NetDiskVipUtilsKt.isVip() || LcbSendVipManager.INSTANCE.isTempDuVip()) {
                    str = context.getString(R.string.download_panel_save_to_net_disk_subtext_vip);
                } else if (SearchH5NetDiskVipUtilsKt.hasFreeRights()) {
                    String limitStr = context.getString(R.string.download_panel_save_to_net_disk_subtext_limit_count);
                    Intrinsics.checkNotNullExpressionValue(limitStr, "context.getString(R.stri…disk_subtext_limit_count)");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format(limitStr, Arrays.copyOf(new Object[]{Integer.valueOf(SearchH5NetDiskVipUtilsKt.getFreeNumFromCache())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                } else {
                    str = context.getString(R.string.download_panel_save_to_net_disk_subtext_no_limit_count);
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                    co…_count)\n                }");
                }
                return str;
            } else if (!SearchH5NetDiskVipUtilsKt.hasFreeRights()) {
                return context.getString(R.string.download_panel_save_to_net_disk_subtext_no_limit_count);
            } else {
                String limitStr2 = context.getString(R.string.download_panel_save_to_net_disk_subtext_limit_count);
                Intrinsics.checkNotNullExpressionValue(limitStr2, "context.getString(R.stri…disk_subtext_limit_count)");
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format = String.format(limitStr2, Arrays.copyOf(new Object[]{Integer.valueOf(SearchH5NetDiskVipUtilsKt.getFreeNumFromCache())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
        }
    }

    public static final boolean canShowPlayDownloadTip(SearchVideoH5DownloadModel downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        if (!SearchH5AbManager.INSTANCE.isHitPlayDownloadTest()) {
            return false;
        }
        return isM3U8Extension(downloadInfo.getExtension());
    }

    public static final boolean canShowPlayDownloadTip(BdVideoSeries videoSeries) {
        if (videoSeries == null || !SearchH5AbManager.INSTANCE.isHitPlayDownloadTest()) {
            return false;
        }
        String extension = SearchH5VideoUtils.getVideoExtensionFromUrl(videoSeries.getPlayUrl());
        Intrinsics.checkNotNullExpressionValue(extension, "extension");
        return isM3U8Extension(extension);
    }

    private static final boolean isM3U8Extension(String extension) {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCaseExt = extension.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCaseExt, "this as java.lang.String).toLowerCase(locale)");
        return Intrinsics.areEqual((Object) lowerCaseExt, (Object) "m3u8") || Intrinsics.areEqual((Object) lowerCaseExt, (Object) EXTENSION_M3U);
    }

    public static final void showNetDiskGuideToast() {
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            String msg = activity.getString(R.string.search_video_net_disk_guid);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…arch_video_net_disk_guid)");
            String btnStr = activity.getString(R.string.search_video_net_disk_toast_btn_save);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…_net_disk_toast_btn_save)");
            SearchH5DownloadUtilsKt.getCurrentVideoInfo("3", new SearchH5ToastUtilKt$showNetDiskGuideToast$1(activity, msg, btnStr));
        }
    }

    public static final void showLcpFreeVipSaveBeginToast() {
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            String msg = activity.getString(R.string.search_video_net_disk_begin);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…rch_video_net_disk_begin)");
            String btnStr = activity.getString(R.string.search_h5_video_detect_btn);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…arch_h5_video_detect_btn)");
            String subTitle = null;
            if (LcbSendVipManager.INSTANCE.isTempDuVip() && LcbSendVipManager.INSTANCE.isGetFreeVipSuccess()) {
                subTitle = activity.getString(R.string.lcp_user_get_free_success_toast_tips);
            } else if (SearchH5NetDiskVipUtilsKt.isVip() || SearchH5NetDiskVipUtilsKt.isSVip() || SearchH5NetDiskVipUtilsKt.isNewVip()) {
                subTitle = activity.getString(R.string.lcp_user_already_vip_toast_tips);
            } else if (SearchH5NetDiskVipUtilsKt.getFreeNumFromCache() > 0) {
                subTitle = activity.getString(R.string.lcp_user_get_free_fail_feed_back_tips);
            } else if (LcbSendVipManager.INSTANCE.isApplyFreeVipFail()) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_tips).showToast();
            } else {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_feed_back_tips).showToast();
            }
            boolean z = false;
            if (subTitle != null && true == (!StringsKt.isBlank(subTitle))) {
                z = true;
            }
            if (z) {
                showLcpFreeVipNetDiskToast(activity, msg, btnStr, subTitle, SearchH5ToastUtilKt$showLcpFreeVipSaveBeginToast$1.INSTANCE);
            }
            SearchH5VideoUbcUtils.addTaskToastShow();
        }
    }

    public static final void showSaveBeginToast() {
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            String msg = activity.getString(R.string.search_video_net_disk_begin_new);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…video_net_disk_begin_new)");
            String btnStr = activity.getString(R.string.search_h5_video_detect_btn);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…arch_h5_video_detect_btn)");
            String subTitle = activity.getString(R.string.search_video_net_disk_begin_sub_new);
            Intrinsics.checkNotNullExpressionValue(subTitle, "activity.getString(R.str…o_net_disk_begin_sub_new)");
            showNetDiskGoldBtnToast(activity, msg, btnStr, subTitle, SearchH5ToastUtilKt$showSaveBeginToast$1.INSTANCE);
            SearchH5VideoUbcUtils.addTaskToastShow();
        }
    }

    public static /* synthetic */ void showSaveDoneToast$default(String str, String str2, boolean z, boolean z2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            str3 = "";
        }
        showSaveDoneToast(str, str2, z, z2, str3);
    }

    public static final void showSaveDoneToast(String savePath, String fsid, boolean isRapid, boolean saveBefore, String step) {
        Activity activity;
        Intrinsics.checkNotNullParameter(step, "step");
        if (savePath != null && (activity = BdBoxActivityManager.getTopActivity()) != null) {
            String msg = activity.getString(R.string.search_video_net_disk_done_new);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…_video_net_disk_done_new)");
            String btnStr = activity.getString(R.string.search_h5_net_disk_text_2);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…earch_h5_net_disk_text_2)");
            String subTitle = activity.getString(R.string.search_video_net_disk_done_news_sub);
            Intrinsics.checkNotNullExpressionValue(subTitle, "activity.getString(R.str…o_net_disk_done_news_sub)");
            showNetDiskGoldBtnToast(activity, msg, btnStr, subTitle, new SearchH5ToastUtilKt$showSaveDoneToast$1(savePath, fsid, isRapid, saveBefore));
            SearchH5VideoUbcUtils.addCompleteToastShow(isRapid, saveBefore, false, step);
        }
    }

    public static /* synthetic */ void showLcpFreeVipSaveDoneToast$default(String str, String str2, boolean z, boolean z2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            str3 = "";
        }
        showLcpFreeVipSaveDoneToast(str, str2, z, z2, str3);
    }

    public static final void showLcpFreeVipSaveDoneToast(String savePath, String fsid, boolean isRapid, boolean saveBefore, String step) {
        Activity activity;
        String str;
        Intrinsics.checkNotNullParameter(step, "step");
        if (savePath != null && (activity = BdBoxActivityManager.getTopActivity()) != null) {
            String msg = activity.getString(R.string.search_video_net_disk_done);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…arch_video_net_disk_done)");
            String btnStr = activity.getString(R.string.search_video_save_net_disk_toast_btn_play);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…_net_disk_toast_btn_play)");
            String subTitle = null;
            if (SearchH5NetDiskVipUtilsKt.isVip()) {
                if (!LcbSendVipManager.INSTANCE.isTempDuVip() || !LcbSendVipManager.INSTANCE.isGetFreeVipSuccess()) {
                    str = activity.getString(R.string.lcp_user_already_vip_toast_tips);
                } else {
                    str = activity.getString(R.string.lcp_user_get_free_success_toast_tips);
                }
                subTitle = str;
            } else if (SearchH5NetDiskVipUtilsKt.getFreeNumFromCache() > 0) {
                subTitle = activity.getString(R.string.lcp_user_get_free_fail_feed_back_tips);
            } else if (LcbSendVipManager.INSTANCE.isApplyFreeVipFail()) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_tips).showToast();
            } else {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_feed_back_tips).showToast();
            }
            boolean z = true;
            if (subTitle == null || true != (!StringsKt.isBlank(subTitle))) {
                z = false;
            }
            if (z) {
                showLcpFreeVipNetDiskToast(activity, msg, btnStr, subTitle, new SearchH5ToastUtilKt$showLcpFreeVipSaveDoneToast$1(savePath, fsid, isRapid, saveBefore));
            }
            SearchH5VideoUbcUtils.addCompleteToastShow(isRapid, saveBefore, false, step);
        }
    }

    public static /* synthetic */ void showLcpFreeVipFullScreenSaveDoneToast$default(String str, String str2, boolean z, boolean z2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            str3 = "";
        }
        showLcpFreeVipFullScreenSaveDoneToast(str, str2, z, z2, str3);
    }

    public static final void showLcpFreeVipFullScreenSaveDoneToast(String savePath, String fsid, boolean isRapid, boolean saveBefore, String step) {
        Activity activity;
        String str;
        Intrinsics.checkNotNullParameter(step, "step");
        if (savePath != null && (activity = BdBoxActivityManager.getTopActivity()) != null) {
            String msg = activity.getString(R.string.search_video_net_disk_done);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…arch_video_net_disk_done)");
            String btnStr = activity.getString(R.string.search_video_save_net_disk_toast_btn_play);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…_net_disk_toast_btn_play)");
            String subTitle = null;
            if (SearchH5NetDiskVipUtilsKt.isVip() || SearchH5NetDiskVipUtilsKt.isSVip() || SearchH5NetDiskVipUtilsKt.isNewVip()) {
                if (!LcbSendVipManager.INSTANCE.isTempDuVip() || !LcbSendVipManager.INSTANCE.isGetFreeVipSuccess()) {
                    str = activity.getString(R.string.lcp_user_already_vip_toast_tips);
                } else {
                    str = activity.getString(R.string.lcp_user_get_free_success_toast_tips);
                }
                subTitle = str;
            } else if (SearchH5NetDiskVipUtilsKt.getFreeNumFromCache() > 0) {
                subTitle = activity.getString(R.string.lcp_user_get_free_fail_feed_back_tips);
            } else if (LcbSendVipManager.INSTANCE.isApplyFreeVipFail()) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_tips).showToast();
            } else {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_fail_feed_back_tips).showToast();
            }
            boolean z = false;
            if (subTitle != null && true == (!StringsKt.isBlank(subTitle))) {
                z = true;
            }
            if (z) {
                showLcpFreeVipNetDiskToast(activity, msg, btnStr, subTitle, new SearchH5ToastUtilKt$showLcpFreeVipFullScreenSaveDoneToast$1(savePath, fsid, isRapid, saveBefore));
            }
            SearchH5VideoUbcUtils.addCompleteToastShow(isRapid, saveBefore, true, step);
        }
    }

    public static /* synthetic */ void showFullScreenSaveDoneToast$default(String str, String str2, boolean z, boolean z2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            str3 = "";
        }
        showFullScreenSaveDoneToast(str, str2, z, z2, str3);
    }

    public static final void showFullScreenSaveDoneToast(String savePath, String fsid, boolean isRapid, boolean saveBefore, String step) {
        Activity activity;
        Intrinsics.checkNotNullParameter(step, "step");
        if (savePath != null && (activity = BdBoxActivityManager.getTopActivity()) != null) {
            String msg = activity.getString(R.string.search_video_net_disk_done_new);
            Intrinsics.checkNotNullExpressionValue(msg, "activity.getString(R.str…_video_net_disk_done_new)");
            String btnStr = activity.getString(R.string.search_h5_net_disk_text_2);
            Intrinsics.checkNotNullExpressionValue(btnStr, "activity.getString(R.str…earch_h5_net_disk_text_2)");
            String subTitle = activity.getString(R.string.search_video_net_disk_done_news_sub);
            Intrinsics.checkNotNullExpressionValue(subTitle, "activity.getString(R.str…o_net_disk_done_news_sub)");
            showNetDiskGoldBtnToast(activity, msg, btnStr, subTitle, new SearchH5ToastUtilKt$showFullScreenSaveDoneToast$1(savePath, fsid, isRapid, saveBefore));
            SearchH5VideoUbcUtils.addCompleteToastShow(isRapid, saveBefore, true, step);
        }
    }

    public static /* synthetic */ void showSaveFailToast$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        showSaveFailToast(str, str2, str3, str4);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
        if (r12.equals(com.baidu.searchbox.search.webvideo.request.SearchH5NetDiskRequestKt.NET_DISK_PARAM_ERROR) == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        if (r12.equals(com.baidu.searchbox.search.webvideo.request.SearchH5NetDiskRequestKt.NET_DISK_INTERNAL_SERVER_ERROR) == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009a, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
        if (r1 == null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
        if (r1.length() != 0) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a8, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
        if (r1 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ab, code lost:
        unknownErrorCodeToast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        r1 = r0.getString(com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_source_link_subtitle);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "activity.getString(R.str…ail_source_link_subtitle)");
        r7 = r1;
        r1 = r0.getString(com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_source_link_subtitle_right);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "activity.getString(R.str…urce_link_subtitle_right)");
        showSaveFailDetailToast(r8, r7, r1, new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$2(r0, r14, r11, r12, r13), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (r12.equals(com.baidu.searchbox.search.webvideo.request.SearchH5NetDiskRequestKt.NET_DISK_LOCAL_TIMEOUT) == false) goto L_0x00db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void showSaveFailToast(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "step"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            android.app.Activity r0 = com.baidu.searchbox.appframework.BdBoxActivityManager.getTopActivity()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            int r1 = com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_storage_limit_title
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "activity.getString(R.str…fail_storage_limit_title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r8 = r1
            if (r12 == 0) goto L_0x00db
            int r1 = r12.hashCode()
            switch(r1) {
                case 48755949: goto L_0x0091;
                case 48755950: goto L_0x0088;
                case 48755958: goto L_0x005d;
                case 48755983: goto L_0x002e;
                case 1535446014: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00db
        L_0x0024:
            java.lang.String r1 = "410001"
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x009a
            goto L_0x00db
        L_0x002e:
            java.lang.String r1 = "36013"
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x0038
            goto L_0x00db
        L_0x0038:
            int r1 = com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_too_many_task_title_subtitle
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "activity.getString(R.str…many_task_title_subtitle)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = com.baidu.searchbox.search.videodetail.R.string.search_h5_video_download_toast_check
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = "activity.getString(R.str…deo_download_toast_check)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$3 r3 = new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$3
            r3.<init>(r0, r11, r12, r13)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            showSaveFailDetailToast(r8, r1, r2, r3, r4)
            goto L_0x00de
        L_0x005d:
            java.lang.String r1 = "36009"
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x0067
            goto L_0x00db
        L_0x0067:
            boolean r1 = isNeedRefVip
            if (r1 == 0) goto L_0x007e
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$1 r9 = new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$1
            r1 = r9
            r2 = r0
            r3 = r8
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            com.baidu.searchbox.search.webvideo.utils.SearchH5NetDiskVipUtilsKt.refreshNetDiskUserInfo(r9)
            goto L_0x00de
        L_0x007e:
            r1 = r0
            r2 = r8
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            gotoVipPage(r1, r2, r3, r4, r5, r6)
            goto L_0x00de
        L_0x0088:
            java.lang.String r1 = "36001"
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x009a
            goto L_0x00db
        L_0x0091:
            java.lang.String r1 = "36000"
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x009a
            goto L_0x00db
        L_0x009a:
            r1 = r14
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00a8
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r1 = 0
            goto L_0x00a9
        L_0x00a8:
            r1 = 1
        L_0x00a9:
            if (r1 == 0) goto L_0x00af
            unknownErrorCodeToast()
            goto L_0x00de
        L_0x00af:
            int r1 = com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_source_link_subtitle
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "activity.getString(R.str…ail_source_link_subtitle)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r7 = r1
            int r1 = com.baidu.searchbox.search.videodetail.R.string.search_video_net_disk_fail_source_link_subtitle_right
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "activity.getString(R.str…urce_link_subtitle_right)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r9 = r1
            com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$2 r10 = new com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt$showSaveFailToast$2
            r1 = r10
            r2 = r0
            r3 = r14
            r4 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            showSaveFailDetailToast(r8, r7, r9, r10, r1)
            goto L_0x00de
        L_0x00db:
            unknownErrorCodeToast()
        L_0x00de:
            java.lang.String r1 = "show"
            com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils.addFailToastShow(r11, r12, r13, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.webvideo.utils.SearchH5ToastUtilKt.showSaveFailToast(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void gotoVipPage$default(Activity activity, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str5 = null;
        }
        gotoVipPage(activity, str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: private */
    public static final void gotoVipPage(Activity activity, String title, String step, String errorCode, String errorMsg, String resourceTitle) {
        if (SearchH5NetDiskVipUtilsKt.isSVip() || SearchH5NetDiskVipUtilsKt.isNewVip()) {
            String subTitle = activity.getString(R.string.search_video_net_disk_fail_storage_limit_subtitle);
            Intrinsics.checkNotNullExpressionValue(subTitle, "activity.getString(R.str…l_storage_limit_subtitle)");
            String rightCheckText = activity.getString(R.string.search_h5_video_download_toast_check);
            Intrinsics.checkNotNullExpressionValue(rightCheckText, "activity.getString(R.str…deo_download_toast_check)");
            showSaveFailDetailToast(title, subTitle, rightCheckText, new SearchH5ToastUtilKt$gotoVipPage$1(activity, step, errorCode, errorMsg), activity);
            return;
        }
        String subTitle2 = activity.getString(R.string.search_video_net_disk_fail_storage_limit_subtitle_not_vip);
        Intrinsics.checkNotNullExpressionValue(subTitle2, "activity.getString(R.str…e_limit_subtitle_not_vip)");
        String rightCheckText2 = activity.getString(R.string.search_video_net_disk_fail_storage_limit_subtitle_not_vip_right);
        Intrinsics.checkNotNullExpressionValue(rightCheckText2, "activity.getString(R.str…t_subtitle_not_vip_right)");
        showSaveFailDetailToast(title, subTitle2, rightCheckText2, new SearchH5ToastUtilKt$gotoVipPage$2(activity, step, errorCode, errorMsg), activity);
    }

    private static final void unknownErrorCodeToast() {
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            UniversalToast.makeText((Context) activity, R.string.search_video_net_disk_fail_not_know).setFullScreen(true).show();
        }
    }

    public static /* synthetic */ void showSaveFailDetailToast$default(String str, String str2, String str3, Function0 function0, Context context, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            context = BdBoxActivityManager.getTopActivity();
        }
        showSaveFailDetailToast(str, str2, str3, function0, context);
    }

    public static final void showSaveFailDetailToast(String title, String subTitle, String rightCheckText, Function0<Unit> callback, Context activity) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(rightCheckText, "rightCheckText");
        if (activity != null) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda24(activity, title, subTitle, rightCheckText, callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSaveFailDetailToast$lambda-24  reason: not valid java name */
    public static final void m3054showSaveFailDetailToast$lambda24(Context $activity, String $title, String $subTitle, String $rightCheckText, Function0 $callback) {
        Intrinsics.checkNotNullParameter($title, "$title");
        Intrinsics.checkNotNullParameter($subTitle, "$subTitle");
        Intrinsics.checkNotNullParameter($rightCheckText, "$rightCheckText");
        dismissSnifferPanel();
        UniversalToast.makeText($activity).setTitleText($title).setSubTitle($subTitle).setRightText($rightCheckText).setTemplate(ToastTemplate.T3).setDuration(3).setFullScreen(false).setOverFloatWindow(true).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda20($callback)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showSaveFailDetailToast$lambda-24$lambda-23  reason: not valid java name */
    public static final void m3055showSaveFailDetailToast$lambda24$lambda23(Function0 $callback) {
        if ($callback != null) {
            $callback.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void showNetDiskToast(Context activity, String msg, String btnStr, Function0<Unit> callback) {
        if (msg != null) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda18(activity, msg, btnStr, callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNetDiskToast$lambda-27  reason: not valid java name */
    public static final void m3050showNetDiskToast$lambda27(Context $activity, String $msg, String $btnStr, Function0 $callback) {
        Intrinsics.checkNotNullParameter($activity, "$activity");
        UniversalToast duration = UniversalToast.makeText($activity).setTitleText($msg).setRightText($btnStr).setDuration(5);
        ToastRightAreaStyle toastRightAreaStyle = ToastRightAreaStyle.BUTTON;
        ToastRightAreaStyle $this$showNetDiskToast_u24lambda_u2d27_u24lambda_u2d25 = toastRightAreaStyle;
        $this$showNetDiskToast_u24lambda_u2d27_u24lambda_u2d25.btnBgDrawableResId = R.drawable.search_video_h5_vip_toast_button_bg;
        $this$showNetDiskToast_u24lambda_u2d27_u24lambda_u2d25.btnTextColorResId = R.color.BC319;
        duration.setRightClickStyle(toastRightAreaStyle).setTemplate(ToastTemplate.T3).setFullScreen(true).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda11($callback)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showNetDiskToast$lambda-27$lambda-26  reason: not valid java name */
    public static final void m3051showNetDiskToast$lambda27$lambda26(Function0 $callback) {
        if ($callback != null) {
            $callback.invoke();
        }
    }

    private static final void showNetDiskGoldBtnToast(Context activity, String msg, String btnStr, String subTitle, Function0<Unit> callback) {
        if (msg != null) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda27(activity, msg, btnStr, subTitle, callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNetDiskGoldBtnToast$lambda-30  reason: not valid java name */
    public static final void m3048showNetDiskGoldBtnToast$lambda30(Context $activity, String $msg, String $btnStr, String $subTitle, Function0 $callback) {
        Intrinsics.checkNotNullParameter($activity, "$activity");
        UniversalToast duration = UniversalToast.makeText($activity).setTitleText($msg).setRightText($btnStr).setSubTitle($subTitle).setDuration(5);
        ToastRightAreaStyle toastRightAreaStyle = ToastRightAreaStyle.BUTTON;
        ToastRightAreaStyle $this$showNetDiskGoldBtnToast_u24lambda_u2d30_u24lambda_u2d28 = toastRightAreaStyle;
        $this$showNetDiskGoldBtnToast_u24lambda_u2d30_u24lambda_u2d28.btnBgDrawableResId = R.drawable.search_video_h5_vip_toast_button_bg;
        $this$showNetDiskGoldBtnToast_u24lambda_u2d30_u24lambda_u2d28.btnTextColorResId = R.color.BC319;
        duration.setRightClickStyle(toastRightAreaStyle).setTemplate(ToastTemplate.T3).setFullScreen(true).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda17($callback)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showNetDiskGoldBtnToast$lambda-30$lambda-29  reason: not valid java name */
    public static final void m3049showNetDiskGoldBtnToast$lambda30$lambda29(Function0 $callback) {
        if ($callback != null) {
            $callback.invoke();
        }
    }

    private static final void showLcpFreeVipNetDiskToast(Context activity, String msg, String btnStr, String subTitle, Function0<Unit> callback) {
        if (msg != null) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda16(activity, msg, subTitle, btnStr, callback), 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLcpFreeVipNetDiskToast$lambda-33  reason: not valid java name */
    public static final void m3046showLcpFreeVipNetDiskToast$lambda33(Context $activity, String $msg, String $subTitle, String $btnStr, Function0 $callback) {
        Intrinsics.checkNotNullParameter($activity, "$activity");
        UniversalToast duration = UniversalToast.makeText($activity).setTitleText($msg).setSubTitle($subTitle).setRightText($btnStr).setDuration(5);
        ToastRightAreaStyle toastRightAreaStyle = ToastRightAreaStyle.BUTTON;
        ToastRightAreaStyle $this$showLcpFreeVipNetDiskToast_u24lambda_u2d33_u24lambda_u2d31 = toastRightAreaStyle;
        $this$showLcpFreeVipNetDiskToast_u24lambda_u2d33_u24lambda_u2d31.btnBgDrawableResId = R.drawable.search_video_h5_vip_toast_button_bg;
        $this$showLcpFreeVipNetDiskToast_u24lambda_u2d33_u24lambda_u2d31.btnTextColorResId = R.color.BC319;
        duration.setRightClickStyle(toastRightAreaStyle).setTemplate(ToastTemplate.T3).setFullScreen(true).setToastCallback(new SearchH5ToastUtilKt$$ExternalSyntheticLambda4($callback)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showLcpFreeVipNetDiskToast$lambda-33$lambda-32  reason: not valid java name */
    public static final void m3047showLcpFreeVipNetDiskToast$lambda33$lambda32(Function0 $callback) {
        if ($callback != null) {
            $callback.invoke();
        }
    }

    public static final boolean checkNetworkConnected() {
        if (NetWorkUtils.isNetworkConnected()) {
            return true;
        }
        UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda10());
        SearchH5VideoUbcUtils.saveNetDisconnect();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: checkNetworkConnected$lambda-34  reason: not valid java name */
    public static final void m3034checkNetworkConnected$lambda34() {
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.search_video_toast_bad_net).show();
    }

    public static final void dismissSnifferPanel() {
        BaseMenuPopupWindow panel = snifferPanel;
        if (!UiThreadUtils.isOnUiThread()) {
            UiThreadUtils.runOnUiThread(new SearchH5ToastUtilKt$$ExternalSyntheticLambda5(panel));
        } else if (panel != null) {
            panel.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dismissSnifferPanel$lambda-35  reason: not valid java name */
    public static final void m3041dismissSnifferPanel$lambda35(BaseMenuPopupWindow $panel) {
        if ($panel != null) {
            $panel.dismiss();
        }
    }

    public static final void dismissPanelWithDuration(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual((Object) source, (Object) "2")) {
            Handler handler = UiThreadUtils.getMainHandler();
            Message message = Message.obtain(handler, new SearchH5ToastUtilKt$$ExternalSyntheticLambda19());
            message.what = HAS_USER_EVENT;
            handler.sendMessageDelayed(message, ((long) SearchH5AbManager.INSTANCE.snifferPanelDuration()) * ((long) 1000));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dismissPanelWithDuration$lambda-36  reason: not valid java name */
    public static final void m3040dismissPanelWithDuration$lambda36() {
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        if (baseMenuPopupWindow != null) {
            baseMenuPopupWindow.dismiss();
        }
        SearchH5VideoUbcUtils.snifferPanelDismiss("disappear", Long.valueOf(((long) SearchH5AbManager.INSTANCE.snifferPanelDuration()) * ((long) 1000)));
    }

    public static final void cancelAutoDismiss() {
        Handler handler = UiThreadUtils.getMainHandler();
        if (handler.hasMessages(HAS_USER_EVENT)) {
            handler.removeMessages(HAS_USER_EVENT);
        }
    }

    private static final void isInterceptTouch(View view2, MotionEvent event, Context context) {
        Window window;
        RectF mMainMenuRect = new RectF();
        BaseMenuPopupWindow<SearchVideoSnifferMenuView> baseMenuPopupWindow = snifferPanel;
        View decor = null;
        SearchVideoSnifferMenuView mMainMenuView = baseMenuPopupWindow != null ? baseMenuPopupWindow.getMainMenuView() : null;
        if (mMainMenuView != null) {
            int[] location = new int[2];
            mMainMenuView.getLocationOnScreen(location);
            float x = (float) location[0];
            float y = (float) location[1];
            mMainMenuRect.set(x, y, ((float) mMainMenuView.getWidth()) + x, ((float) mMainMenuView.getHeight()) + y);
        }
        if (mMainMenuRect.contains(event.getX(), event.getY())) {
            cancelAutoDismiss();
        } else if (mMainMenuView != null) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (!(activity == null || (window = activity.getWindow()) == null)) {
                decor = window.getDecorView();
            }
            int[] loc = new int[2];
            view2.getLocationOnScreen(loc);
            event.offsetLocation((float) loc[0], (float) loc[1]);
            dispatchTouchEvent(decor, event);
            event.offsetLocation(-((float) loc[0]), -((float) loc[1]));
        }
    }

    private static final void dispatchTouchEvent(View view2, MotionEvent event) {
        if (view2 != null) {
            try {
                view2.dispatchTouchEvent(event);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    throw e2;
                }
            }
        }
    }
}
