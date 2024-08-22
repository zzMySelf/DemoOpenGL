package com.baidu.searchbox.search.tab.implement.tplview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.tab.view.FeedThickDividerPolicy;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.view.RoundOutlineProvider;
import com.baidu.searchbox.search.tab.implement.model.NextPlayPosition;
import com.baidu.searchbox.search.tab.implement.player.SearchTabPlayer;
import com.baidu.searchbox.search.tab.implement.player.callback.GestureListener;
import com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext;
import com.baidu.searchbox.search.tab.implement.player.helper.VideoLoftPrefetchHelper;
import com.baidu.searchbox.search.tab.implement.player.layer.SearchTabVideoLayer;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumVideoModel;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoExtLog;
import com.baidu.searchbox.search.tab.implement.utils.VideoAlbumVideoViewUtils;
import com.baidu.searchbox.search.tab.implement.utils.VideoCommonVideoViewUtilsKt;
import com.baidu.searchbox.search.tab.implement.utils.VideoFontUtilsKt;
import com.baidu.searchbox.search.tab.implement.view.RoundCornerFrameLayout;
import com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter;
import com.baidu.searchbox.search.tab.utils.CustomLayoutManager;
import com.baidu.searchbox.search.tab.utils.FastClickUtils;
import com.baidu.searchbox.search.tab.utils.MultiStyleTitleUtils;
import com.baidu.searchbox.search.tab.utils.VideoLoftCmdUtils;
import com.baidu.searchbox.search.tab.view.VideoCommonBottomView;
import com.baidu.searchbox.search.video.business.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ugc.utils.TextViewExtKt;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020\nH\u0016J\u0012\u0010`\u001a\u00020^2\b\u0010a\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010b\u001a\u00020^2\b\u0010a\u001a\u0004\u0018\u00010AH\u0016J\n\u0010c\u001a\u0004\u0018\u00010dH\u0016J\n\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020\rH\u0016J\n\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020\nH\u0014J\b\u0010k\u001a\u00020\nH\u0014J\b\u0010l\u001a\u00020\nH\u0016J\b\u0010m\u001a\u00020\nH\u0014J\n\u0010n\u001a\u0004\u0018\u00010 H\u0016J\b\u0010o\u001a\u00020pH\u0016J\b\u0010q\u001a\u00020XH\u0016J\b\u0010r\u001a\u00020\nH\u0016J\n\u0010s\u001a\u0004\u0018\u00010tH\u0016J\n\u0010u\u001a\u0004\u0018\u00010fH\u0016J\b\u0010v\u001a\u00020\nH\u0016J\b\u0010w\u001a\u00020\nH\u0014J\b\u0010x\u001a\u00020\nH\u0014J\n\u0010y\u001a\u0004\u0018\u00010XH\u0016J0\u0010z\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010X\u0018\u00010{j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010X\u0018\u0001`|H\u0016J\b\u0010}\u001a\u00020^H\u0014J\b\u0010~\u001a\u00020^H\u0003J\b\u0010\u001a\u00020^H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0014J\t\u0010\u0001\u001a\u00020^H\u0016J\u0013\u0010\u0001\u001a\u00020^2\b\u0010a\u001a\u0004\u0018\u00010AH\u0016J\u0013\u0010\u0001\u001a\u00020^2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010\u0001\u001a\u00020^H\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J$\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020tH\u0016J)\u0010\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010X2\t\u0010\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u0001\u001a\u00030\u0001H\u0014J$\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020E2\u0007\u0010 \u0001\u001a\u00020A2\u0007\u0010¡\u0001\u001a\u00020(H\u0002J\u0013\u0010¢\u0001\u001a\u00020^2\b\u0010¢\u0001\u001a\u00030\u0001H\u0014J\n\u0010£\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010¤\u0001\u001a\u00020^2\b\u0010¥\u0001\u001a\u00030\u0001H\u0016J-\u0010¦\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010 2\u0017\u0010§\u0001\u001a\u0012\u0012\u0004\u0012\u00020X\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¨\u0001H\u0017J\u0015\u0010ª\u0001\u001a\u00020^2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\t\u0010­\u0001\u001a\u00020^H\u0002J\t\u0010®\u0001\u001a\u00020^H\u0002J\t\u0010¯\u0001\u001a\u00020^H\u0002J\u0013\u0010°\u0001\u001a\u00020^2\b\u0010±\u0001\u001a\u00030\u0001H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\bH\u0010IR\u001a\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\bK\u0010IR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010T\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-R\u001a\u0010W\u001a\u00020XX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006²\u0001"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonAlbumMainChainStrongView;", "Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonSlideBaseView;", "Lcom/baidu/searchbox/search/tab/view/VideoCommonBottomView$IOnClickItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "currentPlayEntity", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel$SlideCardEntity;", "getCurrentPlayEntity", "()Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel$SlideCardEntity;", "setCurrentPlayEntity", "(Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel$SlideCardEntity;)V", "currentPlayPosition", "getCurrentPlayPosition", "()I", "setCurrentPlayPosition", "(I)V", "eventTag", "Ljava/lang/Object;", "layoutManager", "Lcom/baidu/searchbox/search/tab/utils/CustomLayoutManager;", "mBottomView", "Lcom/baidu/searchbox/search/tab/view/VideoCommonBottomView;", "mFeedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "mHolder", "Lcom/baidu/searchbox/search/tab/implement/view/RoundCornerFrameLayout;", "mItemModel", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel;", "mPlayTips", "Landroid/widget/TextView;", "mSlideView", "Landroidx/recyclerview/widget/RecyclerView;", "mSubTitle", "getMSubTitle", "()Landroid/widget/TextView;", "setMSubTitle", "(Landroid/widget/TextView;)V", "mTitle", "getMTitle", "setMTitle", "mTitleAlbumIcon", "Landroid/widget/ImageView;", "mTitleAlbumLine", "mTitleAlbumSigh", "mVideoImage", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "getMVideoImage", "()Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "setMVideoImage", "(Lcom/baidu/searchbox/feed/template/FeedDraweeView;)V", "mVideoImageHeight", "mVideoImageWidth", "mVideoLength", "getMVideoLength", "setMVideoLength", "mVideoLengthContainer", "Landroid/view/View;", "mVideoPlayIcon", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "rvRect", "Landroid/graphics/Rect;", "seekbar", "Landroid/widget/FrameLayout;", "getSeekbar$annotations", "()V", "seekbarOutContainer", "getSeekbarOutContainer$annotations", "slideAdapter", "Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;", "getSlideAdapter", "()Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;", "setSlideAdapter", "(Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;)V", "slideCardScrollOffset", "subImageUnderLayer", "subInfo", "getSubInfo", "setSubInfo", "viewId", "", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "bindFullScreenClick", "", "business", "clickAuthor", "v", "clickIvk", "createGestureListener", "Lcom/baidu/searchbox/search/tab/implement/player/callback/GestureListener;", "getAttachedContainer", "Landroid/view/ViewGroup;", "getAutoPlayWeight", "getFeedDividerPolicy", "Lcom/baidu/searchbox/feed/base/FeedTemplate$FeedDividerPolicy;", "getHorizontalPaddings", "getHorizontalParentMargin", "getItemPosition", "getLayoutId", "getModel", "getNextPlayPosition", "Lcom/baidu/searchbox/search/tab/implement/model/NextPlayPosition;", "getNid", "getOrderForClick", "getPlayHelper", "Lcom/baidu/searchbox/search/tab/implement/player/helper/IListPlayerContext;", "getSeekBarContainer", "getSkipToastBottomMarginRes", "getSlideRecycleViewDividerWidth", "getSlideRecycleViewPaddings", "getVideoInfo", "getVideoInfoMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleTitleColor", "hideSubtitleWithAnimation", "initSubtitlePadding", "isEnableDragSeek", "", "isRVCompletelyVisible", "isRVRectInParent", "isSupportAutoPlay", "isSupportCToB", "measureTitle", "needBottomCorner", "onBeginPlay", "onClick", "onFeedNightModeChanged", "isNightMode", "onFindView", "onFontSizeChanged", "fontSizeInPx", "onHideInfo", "onUpdateProgress", "progress", "buffer", "max", "resetState", "scrollToNext", "nextCompilationItemPosition", "setListPlayerHelper", "listPlayerContext", "setPostImageToView", "url", "feedModel", "size", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "showDecoration", "outRect", "view", "parent", "showSubtitle", "supportSkipToast", "tryPlay", "loopPlay", "update", "options", "", "", "updateByLinkageDate", "linkageData", "Lcom/baidu/searchbox/feed/model/LinkageData;", "updateImagePoster", "updateList", "updateSeekBarLayout", "updateUnderLayerVisible", "isShow", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonAlbumMainChainStrongView.kt */
public class VideoCommonAlbumMainChainStrongView extends VideoCommonSlideBaseView implements VideoCommonBottomView.IOnClickItem {
    public Map<Integer, View> _$_findViewCache;
    private final float cornerRadius;
    private VideoCommonAlbumMainChainStrongModel.SlideCardEntity currentPlayEntity;
    private int currentPlayPosition;
    private final Object eventTag;
    private CustomLayoutManager layoutManager;
    private VideoCommonBottomView mBottomView;
    private FeedBaseModel mFeedBaseModel;
    private RoundCornerFrameLayout mHolder;
    private VideoCommonAlbumMainChainStrongModel mItemModel;
    private TextView mPlayTips;
    private RecyclerView mSlideView;
    private TextView mSubTitle;
    private TextView mTitle;
    private ImageView mTitleAlbumIcon;
    private TextView mTitleAlbumLine;
    private TextView mTitleAlbumSigh;
    private FeedDraweeView mVideoImage;
    private int mVideoImageHeight;
    private int mVideoImageWidth;
    private TextView mVideoLength;
    private View mVideoLengthContainer;
    private BdBaseImageView mVideoPlayIcon;
    private final Rect rvRect;
    private FrameLayout seekbar;
    private FrameLayout seekbarOutContainer;
    private VideoCommonAlbumViewAdapter slideAdapter;
    private int slideCardScrollOffset;
    private ImageView subImageUnderLayer;
    private TextView subInfo;
    private String viewId;

    @Nullable
    private static /* synthetic */ void getSeekbar$annotations() {
    }

    @Nullable
    private static /* synthetic */ void getSeekbarOutContainer$annotations() {
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoCommonAlbumMainChainStrongView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewGroup.LayoutParams $this$_init__u24lambda_u2d1;
        this._$_findViewCache = new LinkedHashMap();
        this.viewId = "";
        this.rvRect = new Rect();
        this.eventTag = new Object();
        this.cornerRadius = ViewExKt.getDpF(17.0f);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        int cornerRadius2 = DeviceUtils.ScreenInfo.dp2px(context, 9.0f);
        ((TextView) findViewById(R.id.search_video_base_title)).setVisibility(8);
        this.mTitleAlbumSigh = (TextView) findViewById(R.id.search_video_album_text);
        this.mTitleAlbumIcon = (ImageView) findViewById(R.id.search_video_album_icon);
        this.mTitleAlbumLine = (TextView) findViewById(R.id.search_video_album_line);
        ImageView imageView = this.mTitleAlbumIcon;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_album_main));
        }
        VideoCommonVideoViewUtilsKt.updateTextBoldWeight(this.mTitleAlbumSigh, true);
        this.mVideoImage = (FeedDraweeView) findViewById(R.id.search_video_placeholder);
        BdBaseImageView it = (BdBaseImageView) findViewById(R.id.search_video_play_icon);
        this.mVideoPlayIcon = it;
        if (it != null) {
            it.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.search_video_slide_card_play));
            VideoCommonVideoViewUtilsKt.adjustPlayIconSize(it);
        }
        this.slideCardScrollOffset = (DeviceUtils.ScreenInfo.getDisplayWidth(context) / 2) - (InvokerUtils.di2pi(77.0f) / 2);
        View findViewById = findViewById(R.id.search_video_length_area);
        this.mVideoLengthContainer = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.mSubTitle = (TextView) findViewById(R.id.video_common_subtitle);
        VideoCommonVideoViewUtilsKt.updateTextBoldWeight(this.mTitle, true);
        initSubtitlePadding();
        this.mPlayTips = (TextView) findViewById(R.id.search_video_playTips);
        this.mVideoLength = (TextView) findViewById(R.id.search_video_play_length);
        View view2 = this.mVideoLengthContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_video_album_main_chain_list);
        this.mSlideView = recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(this) {
                final /* synthetic */ VideoCommonAlbumMainChainStrongView this$0;

                {
                    this.this$0 = $receiver;
                }

                public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view2, parent, state);
                    this.this$0.showDecoration(outRect, view2, parent);
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.search_video_seekbar);
        this.seekbar = frameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.search_video_seekbar_out_container);
        this.seekbarOutContainer = frameLayout2;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        CustomLayoutManager customLayoutManager = new CustomLayoutManager(context2, 0);
        this.layoutManager = customLayoutManager;
        customLayoutManager.setOrientation(0);
        RecyclerView recyclerView2 = this.mSlideView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(this.layoutManager);
        }
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "this.context");
        FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
        Intrinsics.checkNotNullExpressionValue(feedTemplateImpl, "mFeedTemplateImplBase");
        this.slideAdapter = new VideoCommonAlbumViewAdapter(context3, feedTemplateImpl, this);
        updateTipsViewStyle(this.mPlayTips, context);
        View findViewById2 = findViewById(R.id.search_video_album_sub_area);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.search_video_album_sub_area)");
        ViewGroup subVideoRegion = (ViewGroup) findViewById2;
        VideoAlbumVideoViewUtils.INSTANCE.adjustSubVideoRegionMargin(subVideoRegion);
        this.subImageUnderLayer = (ImageView) findViewById(R.id.search_video_image_bottom_layer);
        TextView textView = (TextView) findViewById(R.id.search_video_album_title);
        this.mTitle = textView;
        VideoCommonVideoViewUtilsKt.updateTextBoldWeight(textView, true);
        this.subInfo = (TextView) findViewById(R.id.sub_info);
        onFontSizeChanged(FeedConfig.Font.get().getBiSerialFlowTitleFontSize());
        this.mHolder = (RoundCornerFrameLayout) findViewById(R.id.search_video_videoplayer);
        if (needBottomCorner()) {
            RoundCornerFrameLayout roundCornerFrameLayout = this.mHolder;
            if (roundCornerFrameLayout != null) {
                roundCornerFrameLayout.setCornerRadius(cornerRadius2);
            }
        } else {
            RoundCornerFrameLayout roundCornerFrameLayout2 = this.mHolder;
            if (roundCornerFrameLayout2 != null) {
                roundCornerFrameLayout2.setCornerRadius((float) cornerRadius2, (float) cornerRadius2, 0.0f, 0.0f);
            }
        }
        RoundCornerFrameLayout roundCornerFrameLayout3 = this.mHolder;
        if (roundCornerFrameLayout3 != null) {
            roundCornerFrameLayout3.setBackgroundColor(Color.parseColor("#00ffffff"));
        }
        RoundCornerFrameLayout roundCornerFrameLayout4 = this.mHolder;
        if (roundCornerFrameLayout4 != null) {
            roundCornerFrameLayout4.setOnClickListener(this);
        }
        int calculateWidth = (FeedTemplateUtil.getCalculateWidth(context) - (getHorizontalPaddings() * 2)) - (getHorizontalParentMargin() * 2);
        this.mVideoImageWidth = calculateWidth;
        this.mVideoImageHeight = Math.round((((float) calculateWidth) * 9.0f) / 16.0f);
        RoundCornerFrameLayout roundCornerFrameLayout5 = this.mHolder;
        if (!(roundCornerFrameLayout5 == null || ($this$_init__u24lambda_u2d1 = roundCornerFrameLayout5.getLayoutParams()) == null)) {
            $this$_init__u24lambda_u2d1.height = this.mVideoImageHeight;
            $this$_init__u24lambda_u2d1.width = this.mVideoImageWidth;
            setOnClickListener(this);
        }
        VideoCommonBottomView videoCommonBottomView = (VideoCommonBottomView) findViewById(R.id.search_video_album_main_chain_bottom_view);
        this.mBottomView = videoCommonBottomView;
        if (videoCommonBottomView != null) {
            videoCommonBottomView.setClickItemListener(this);
        }
        VideoCommonBottomView videoCommonBottomView2 = this.mBottomView;
        if (videoCommonBottomView2 != null) {
            videoCommonBottomView2.setHolder(this.mHolder);
        }
        if (needBottomCorner()) {
            FeedTemplateImgCornersUtil.processSingleImgRoundCorner(this.mVideoImage, cornerRadius2, cornerRadius2, cornerRadius2, cornerRadius2);
        } else {
            FeedTemplateImgCornersUtil.processSingleImgRoundCorner(this.mVideoImage, cornerRadius2, cornerRadius2, 0, 0);
        }
        onFindView();
        onFeedNightModeChanged(NightModeHelper.getNightModeSwitcherState());
        subVideoRegion.setOnClickListener(this);
        this.viewId = String.valueOf(System.currentTimeMillis());
        updateUnderLayerVisible(false);
    }

    public VideoCommonAlbumMainChainStrongView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoCommonAlbumMainChainStrongView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* access modifiers changed from: protected */
    public final FeedDraweeView getMVideoImage() {
        return this.mVideoImage;
    }

    /* access modifiers changed from: protected */
    public final void setMVideoImage(FeedDraweeView feedDraweeView) {
        this.mVideoImage = feedDraweeView;
    }

    /* access modifiers changed from: protected */
    public final TextView getMSubTitle() {
        return this.mSubTitle;
    }

    /* access modifiers changed from: protected */
    public final void setMSubTitle(TextView textView) {
        this.mSubTitle = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getMTitle() {
        return this.mTitle;
    }

    /* access modifiers changed from: protected */
    public final void setMTitle(TextView textView) {
        this.mTitle = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getSubInfo() {
        return this.subInfo;
    }

    /* access modifiers changed from: protected */
    public final void setSubInfo(TextView textView) {
        this.subInfo = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getMVideoLength() {
        return this.mVideoLength;
    }

    /* access modifiers changed from: protected */
    public final void setMVideoLength(TextView textView) {
        this.mVideoLength = textView;
    }

    /* access modifiers changed from: protected */
    public final VideoCommonAlbumViewAdapter getSlideAdapter() {
        return this.slideAdapter;
    }

    /* access modifiers changed from: protected */
    public final void setSlideAdapter(VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter) {
        this.slideAdapter = videoCommonAlbumViewAdapter;
    }

    public final VideoCommonAlbumMainChainStrongModel.SlideCardEntity getCurrentPlayEntity() {
        return this.currentPlayEntity;
    }

    public final void setCurrentPlayEntity(VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity) {
        this.currentPlayEntity = slideCardEntity;
    }

    public final int getCurrentPlayPosition() {
        return this.currentPlayPosition;
    }

    public final void setCurrentPlayPosition(int i2) {
        this.currentPlayPosition = i2;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setViewId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.viewId = str;
    }

    /* access modifiers changed from: private */
    public final void showDecoration(Rect outRect, View view2, RecyclerView parent) {
        int childLayoutPosition = parent.getChildLayoutPosition(view2);
        if (childLayoutPosition == 0) {
            outRect.left = getSlideRecycleViewPaddings();
            return;
        }
        RecyclerView.Adapter adapter = parent.getAdapter();
        boolean z = true;
        if (adapter == null || childLayoutPosition != adapter.getItemCount() - 1) {
            z = false;
        }
        if (z) {
            outRect.left = getSlideRecycleViewDividerWidth();
            outRect.right = getSlideRecycleViewPaddings();
            return;
        }
        outRect.left = getSlideRecycleViewDividerWidth();
    }

    private final void updateUnderLayerVisible(boolean isShow) {
        ImageView imageView = this.subImageUnderLayer;
        if (imageView != null) {
            imageView.setVisibility(isShow ? 0 : 8);
        }
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> slideCardMainList;
        List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> slideCardMainList2;
        String it;
        String it2;
        VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter;
        super.update(feedModel, options);
        this.mFeedBaseModel = feedModel;
        if (feedModel != null && (feedModel.data instanceof VideoCommonAlbumMainChainStrongModel)) {
            FeedItemData feedItemData = feedModel.data;
            VideoCommonAlbumViewAdapter.MoreItemClick moreItemClick = null;
            this.mItemModel = feedItemData instanceof VideoCommonAlbumMainChainStrongModel ? (VideoCommonAlbumMainChainStrongModel) feedItemData : null;
            VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter2 = this.slideAdapter;
            if ((videoCommonAlbumViewAdapter2 != null ? videoCommonAlbumViewAdapter2.getMMoreItemClick() : null) == null && (videoCommonAlbumViewAdapter = this.slideAdapter) != null) {
                if (videoCommonAlbumViewAdapter != null) {
                    moreItemClick = new VideoCommonAlbumViewAdapter.MoreItemClick(this.mItemModel, getContext());
                }
                videoCommonAlbumViewAdapter.setMMoreItemClick(moreItemClick);
            }
            handleTitleColor();
            measureTitle();
            StringBuilder stringBuilder = new StringBuilder();
            VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = this.mItemModel;
            if (!(videoCommonAlbumMainChainStrongModel == null || (it2 = videoCommonAlbumMainChainStrongModel.getAlbumNumText()) == null)) {
                stringBuilder.append(it2).append(TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE);
            }
            VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel2 = this.mItemModel;
            if (!(videoCommonAlbumMainChainStrongModel2 == null || (it = videoCommonAlbumMainChainStrongModel2.getPlaycntText()) == null)) {
                stringBuilder.append(it);
            }
            TextView textView = this.subInfo;
            if (textView != null) {
                textView.setText(stringBuilder.toString());
            }
            showSubtitle(true);
            VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel3 = this.mItemModel;
            int i2 = 0;
            if ((videoCommonAlbumMainChainStrongModel3 == null || (slideCardMainList2 = videoCommonAlbumMainChainStrongModel3.getSlideCardMainList()) == null || !(slideCardMainList2.isEmpty() ^ true)) ? false : true) {
                updateList();
            }
            updateImagePoster();
            VideoCommonBottomView videoCommonBottomView = this.mBottomView;
            if (videoCommonBottomView != null) {
                videoCommonBottomView.update(feedModel);
            }
            CustomLayoutManager customLayoutManager = this.layoutManager;
            if (customLayoutManager != null) {
                int i3 = this.currentPlayPosition;
                VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel4 = this.mItemModel;
                if (i3 != ((videoCommonAlbumMainChainStrongModel4 == null || (slideCardMainList = videoCommonAlbumMainChainStrongModel4.getSlideCardMainList()) == null) ? 0 : slideCardMainList.size()) - 1) {
                    i2 = this.slideCardScrollOffset;
                }
                customLayoutManager.scrollToPositionWithOffset(i3, i2);
            }
            updateSeekBarLayout();
        }
    }

    private final void updateSeekBarLayout() {
        FrameLayout $this$updateSeekBarLayout_u24lambda_u2d4 = this.seekbarOutContainer;
        if ($this$updateSeekBarLayout_u24lambda_u2d4 != null) {
            $this$updateSeekBarLayout_u24lambda_u2d4.setClipToOutline(true);
            $this$updateSeekBarLayout_u24lambda_u2d4.setOutlineProvider(new RoundOutlineProvider(this.cornerRadius));
        }
    }

    public void measureTitle() {
        if (this.mVideoImageWidth > 0) {
            int layoutWidth = this.mVideoImageWidth;
            TextView textView = this.mTitleAlbumSigh;
            int i2 = 0;
            if (textView != null) {
                textView.measure(0, 0);
            }
            TextView textView2 = this.mTitleAlbumSigh;
            ViewGroup.LayoutParams lp = null;
            Integer rightViewWidth = textView2 != null ? Integer.valueOf(textView2.getMeasuredWidth()) : null;
            if (rightViewWidth != null) {
                layoutWidth -= rightViewWidth.intValue();
            }
            TextView textView3 = this.mTitleAlbumLine;
            if (textView3 != null) {
                textView3.measure(0, 0);
            }
            TextView textView4 = this.mTitleAlbumLine;
            Integer centerViewWidth = textView4 != null ? Integer.valueOf(textView4.getMeasuredWidth() + (getResources().getDimensionPixelOffset(R.dimen.dimens_3dp) * 2)) : null;
            if (centerViewWidth != null) {
                layoutWidth -= (centerViewWidth.intValue() + ((int) FontSizeHelper.getScaledSize(3, getContext().getResources().getDimension(R.dimen.dimens_17dp)))) + ((int) FontSizeHelper.getScaledSize(3, getContext().getResources().getDimension(R.dimen.dimens_3dp)));
            }
            TextView textView5 = this.mTitle;
            if (textView5 != null) {
                textView5.measure(0, 0);
            }
            TextView textView6 = this.mTitle;
            if (textView6 != null) {
                lp = textView6.getLayoutParams();
            }
            TextView textView7 = this.mTitle;
            if (textView7 != null) {
                i2 = textView7.getMeasuredWidth();
            }
            if (i2 <= layoutWidth) {
                TextView textView8 = this.mTitle;
                if (textView8 != null) {
                    textView8.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                }
            } else if (lp != null) {
                lp.width = layoutWidth;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handleTitleColor() {
        TextView textView = this.mTitle;
        if (textView != null) {
            MultiStyleTitleUtils.handleTitleColor(textView, getContext(), getFeedModel(), ContextCompat.getColor(getContext(), VideoCommonVideoViewUtilsKt.getTitleColorResRed()), Integer.valueOf(ContextCompat.getColor(getContext(), VideoCommonVideoViewUtilsKt.getTitleColorRes())));
        }
    }

    private final void updateImagePoster() {
        List it;
        VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo;
        VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = this.mItemModel;
        if (videoCommonAlbumMainChainStrongModel != null && (it = videoCommonAlbumMainChainStrongModel.getSlideCardMainList()) != null) {
            String str = null;
            if (!(!it.isEmpty())) {
                it = null;
            }
            if (it != null) {
                ResizeOptions size = new ResizeOptions(this.mVideoImageWidth / 2, this.mVideoImageHeight / 2, 0.0f, 0.0f, 12, (DefaultConstructorMarker) null);
                VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity = it.get(this.currentPlayPosition);
                if (!(slideCardEntity == null || (videoInfo = slideCardEntity.getVideoInfo()) == null)) {
                    str = videoInfo.getPosterImage();
                }
                setPostImageToView(str, getFeedModel(), size);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setPostImageToView(String url, FeedBaseModel feedModel, ResizeOptions size) {
        FeedDraweeView placeHolderWithSelfFlag;
        Intrinsics.checkNotNullParameter(size, "size");
        FeedDraweeView feedDraweeView = this.mVideoImage;
        if (feedDraweeView != null && (placeHolderWithSelfFlag = feedDraweeView.setPlaceHolderWithSelfFlag()) != null) {
            placeHolderWithSelfFlag.loadImageWithSize(url, feedModel, size);
        }
    }

    private final void updateList() {
        RecyclerView recyclerView = this.mSlideView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.slideAdapter);
        }
        VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter = this.slideAdapter;
        if (videoCommonAlbumViewAdapter != null) {
            videoCommonAlbumViewAdapter.setData(this.mFeedBaseModel);
        }
    }

    public void setListPlayerHelper(IListPlayerContext listPlayerContext) {
        Intrinsics.checkNotNullParameter(listPlayerContext, "listPlayerContext");
        super.setListPlayerHelper(listPlayerContext);
        VideoCommonBottomView videoCommonBottomView = this.mBottomView;
        if (videoCommonBottomView != null) {
            videoCommonBottomView.setPlayerHelper(listPlayerContext, business());
        }
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), VideoCommonVideoViewUtilsKt.getTitleColorRes()));
        }
        TextView textView2 = this.mSubTitle;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(getContext(), R.color.search_video_video_length_color));
        }
        TextView textView3 = this.mVideoLength;
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.search_video_video_length_color));
        }
        TextView textView4 = this.subInfo;
        if (textView4 != null) {
            textView4.setTextColor(ContextCompat.getColor(getContext(), R.color.DC6));
        }
        ImageView imageView = this.subImageUnderLayer;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.search_video_album_layer));
        }
        VideoCommonBottomView videoCommonBottomView = this.mBottomView;
        if (videoCommonBottomView != null) {
            videoCommonBottomView.onFeedNightModeChanged(isNightMode);
        }
        BdBaseImageView it = this.mVideoPlayIcon;
        if (it != null) {
            it.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.search_video_slide_card_play));
            VideoCommonVideoViewUtilsKt.adjustPlayIconSize(it);
        }
        TextView textView5 = this.mTitleAlbumSigh;
        if (textView5 != null) {
            textView5.setTextColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.search.style.res.R.color.SC2));
        }
        TextView textView6 = this.mTitleAlbumLine;
        if (textView6 != null) {
            textView6.setTextColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.search.style.res.R.color.SC2));
        }
        ImageView imageView2 = this.mTitleAlbumIcon;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_album_main));
        }
    }

    public void onClick(View v) {
        String str;
        String newCmd;
        VideoExtLog extLogInfo;
        String $this$onClick_u24lambda_u2d11_u24lambda_u2d10;
        VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo;
        VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo2;
        String it;
        IListPlayerContext iListPlayerContext;
        VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo3;
        if (!FastClickUtils.Companion.getInstance().fastClick()) {
            String str2 = null;
            Integer viewId2 = v != null ? Integer.valueOf(v.getId()) : null;
            FeedBaseModel feedBaseModel = this.mFeedBaseModel;
            if (feedBaseModel != null) {
                if ((feedBaseModel != null ? feedBaseModel.data : null) instanceof VideoCommonAlbumMainChainStrongModel) {
                    FeedBaseModel feedBaseModel2 = this.mFeedBaseModel;
                    FeedItemData feedItemData = feedBaseModel2 != null ? feedBaseModel2.data : null;
                    VideoCommonAlbumMainChainStrongModel itemData = feedItemData instanceof VideoCommonAlbumMainChainStrongModel ? (VideoCommonAlbumMainChainStrongModel) feedItemData : null;
                    VideoLoftPrefetchHelper.prefetchItem(this);
                    int i2 = R.id.search_video_videoplayer;
                    boolean z = true;
                    if (viewId2 == null || viewId2.intValue() != i2) {
                        int i3 = R.id.search_a_video_btn_full_screen;
                        if (viewId2 == null || viewId2.intValue() != i3) {
                            z = false;
                        }
                    }
                    if (z) {
                        VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity = this.currentPlayEntity;
                        str = (slideCardEntity == null || (videoInfo3 = slideCardEntity.getVideoInfo()) == null) ? null : videoInfo3.getCmd();
                    } else {
                        int i4 = R.id.search_video_album_sub_area;
                        if (viewId2 != null && viewId2.intValue() == i4) {
                            VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity2 = this.currentPlayEntity;
                            str = slideCardEntity2 != null ? slideCardEntity2.getCmd() : null;
                        } else {
                            String str3 = null;
                            str = null;
                        }
                    }
                    String cmd = str;
                    if (!TextUtils.isEmpty(cmd)) {
                        int i5 = R.id.search_video_album_sub_area;
                        if (viewId2 != null && viewId2.intValue() == i5) {
                            newCmd = VideoLoftCmdUtils.updateCmd(new UnitedSchemeEntity(Uri.parse(cmd)), this.mHolder, v, (Integer) null, (Integer) null, (String) null);
                        } else {
                            newCmd = VideoLoftCmdUtils.updateCmd(new UnitedSchemeEntity(Uri.parse(cmd)), this.mHolder, v);
                        }
                        if (!TextUtils.isEmpty(newCmd)) {
                            cmd = newCmd;
                        }
                        AppConfig.isDebug();
                        VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity3 = this.currentPlayEntity;
                        if (!(slideCardEntity3 == null || (videoInfo2 = slideCardEntity3.getVideoInfo()) == null || (it = videoInfo2.getVid()) == null || (iListPlayerContext = this.playerHelper) == null)) {
                            iListPlayerContext.setKLayerCache(it, business());
                        }
                        if (v != null) {
                            v.setTag(R.id.video_search_cmd, cmd);
                        }
                        if (v != null) {
                            int i6 = R.id.search_video_vid_tag;
                            VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity4 = this.currentPlayEntity;
                            if (!(slideCardEntity4 == null || (videoInfo = slideCardEntity4.getVideoInfo()) == null)) {
                                str2 = videoInfo.getVid();
                            }
                            v.setTag(i6, str2);
                        }
                        if (v != null) {
                            v.setTag(R.id.video_tab_play_info, this);
                        }
                        VideoCommonAlbumMainChainStrongModel it2 = this.mItemModel;
                        if (it2 != null) {
                            VideoCommonAlbumVideoModel.AlbumVideoEntity searchVideoInfo = it2.getSearchVideoInfo();
                            if (!(searchVideoInfo == null || (extLogInfo = searchVideoInfo.getExtLogInfo()) == null || ($this$onClick_u24lambda_u2d11_u24lambda_u2d10 = extLogInfo.getSrcid()) == null)) {
                                if (v != null) {
                                    v.setTag(R.id.search_a_video_srcid, $this$onClick_u24lambda_u2d11_u24lambda_u2d10);
                                }
                                if (v != null) {
                                    v.setTag(R.id.search_a_video_position, Integer.valueOf(getItemPosition()));
                                }
                                if (it2.getIteration() > -1 && v != null) {
                                    v.setTag(R.id.search_a_video_iteration, Integer.valueOf(it2.getIteration()));
                                }
                            }
                            FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
                            if (feedTemplateImpl != null) {
                                feedTemplateImpl.onClick(v);
                            }
                        }
                    }
                }
            }
        }
    }

    public ViewGroup getAttachedContainer() {
        return this.mHolder;
    }

    public String getNid() {
        FeedBaseModel feedModel = getFeedModel();
        String str = feedModel != null ? feedModel.id : null;
        return str == null ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r0 = r0.getSlideCardMainList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tryPlay(boolean r6) {
        /*
            r5 = this;
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r0 = r5.mItemModel
            r1 = 1
            if (r0 == 0) goto L_0x001c
            java.util.List r0 = r0.getSlideCardMainList()
            if (r0 == 0) goto L_0x001c
            r2 = 0
            int r3 = r5.currentPlayPosition
            int r4 = r0.size()
            if (r3 < r4) goto L_0x001b
            int r3 = r0.size()
            int r3 = r3 - r1
            r5.currentPlayPosition = r3
        L_0x001b:
        L_0x001c:
            com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter r0 = r5.slideAdapter
            if (r0 == 0) goto L_0x0026
            int r2 = r5.currentPlayPosition
            r0.updateLottie(r2)
        L_0x0026:
            com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext r0 = r5.playerHelper
            r2 = 0
            if (r0 == 0) goto L_0x0032
            boolean r0 = r0.canPlay()
            if (r0 != r1) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r1 = r2
        L_0x0033:
            if (r1 == 0) goto L_0x0075
            com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext r0 = r5.playerHelper
            if (r0 == 0) goto L_0x003f
            r1 = r5
            com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo r1 = (com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo) r1
            r0.bindCurInfo(r1)
        L_0x003f:
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r0 = r5.mItemModel
            r1 = 0
            if (r0 == 0) goto L_0x0053
            java.util.List r0 = r0.getSlideCardMainList()
            if (r0 == 0) goto L_0x0053
            int r2 = r5.currentPlayPosition
            java.lang.Object r0 = r0.get(r2)
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity r0 = (com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel.SlideCardEntity) r0
            goto L_0x0054
        L_0x0053:
            r0 = r1
        L_0x0054:
            r5.currentPlayEntity = r0
            com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView$tryPlay$callback$1 r0 = new com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView$tryPlay$callback$1
            r0.<init>(r5)
            com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper$PlayingCallback r0 = (com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper.PlayingCallback) r0
            boolean r2 = r5.supportSkipToast()
            if (r2 == 0) goto L_0x0067
            r5.skipToastSeekToPosition(r0)
            goto L_0x0075
        L_0x0067:
            com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext r2 = r5.playerHelper
            if (r2 == 0) goto L_0x0075
            r3 = r5
            com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo r3 = (com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo) r3
            android.content.Context r4 = r5.getContext()
            r2.tryPlay(r3, r4, r1, r0)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.tryPlay(boolean):void");
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        VideoFontUtilsKt.updateFontSize(this.mTitle, R.dimen.search_video_title_size);
        VideoFontUtilsKt.updateFontSize(this.subInfo, R.dimen.dimens_12dp);
        VideoFontUtilsKt.updateFontSize(this.mTitleAlbumSigh, R.dimen.search_video_title_size);
        VideoFontUtilsKt.updateFontSize(this.mTitleAlbumLine, R.dimen.search_video_title_size);
        VideoFontUtilsKt.updateViewScaledSize(this.mTitleAlbumIcon, getContext().getResources().getDimension(R.dimen.search_video_title_size), getContext().getResources().getDimension(R.dimen.search_video_title_size));
        measureTitle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getVideoInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVideoInfo() {
        /*
            r1 = this;
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity r0 = r1.currentPlayEntity
            if (r0 == 0) goto L_0x000f
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity$SlideVideoInfo r0 = r0.getVideoInfo()
            if (r0 == 0) goto L_0x000f
            org.json.JSONObject r0 = r0.toJson()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.getVideoInfo():java.lang.String");
    }

    public int getItemPosition() {
        FeedRuntimeStatus feedRuntimeStatus;
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        if (feedBaseModel == null || feedBaseModel == null || (feedRuntimeStatus = feedBaseModel.runtimeStatus) == null) {
            return 0;
        }
        return feedRuntimeStatus.viewPosition;
    }

    public int getOrderForClick() {
        VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = this.mItemModel;
        if (videoCommonAlbumMainChainStrongModel != null) {
            return videoCommonAlbumMainChainStrongModel.getOrderForClick();
        }
        return 0;
    }

    public void onBeginPlay() {
        ViewGroup.MarginLayoutParams value$iv;
        super.onBeginPlay();
        int i2 = 0;
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoImage, false);
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoPlayIcon, false);
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoLength, false);
        bindFullScreenClick();
        TextView $this$onBeginPlay_u24lambda_u2d14 = this.mSubTitle;
        if ($this$onBeginPlay_u24lambda_u2d14 != null) {
            View $this$marginLayoutParams$iv = $this$onBeginPlay_u24lambda_u2d14;
            View $this$marginLayoutParams$iv2 = $this$onBeginPlay_u24lambda_u2d14;
            if ($this$marginLayoutParams$iv2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = $this$marginLayoutParams$iv2.getLayoutParams();
                if (layoutParams != null) {
                    value$iv = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            } else {
                ViewGroup.LayoutParams layoutParams2 = $this$marginLayoutParams$iv2.getLayoutParams();
                int i3 = layoutParams2 != null ? layoutParams2.width : 0;
                ViewGroup.LayoutParams layoutParams3 = $this$marginLayoutParams$iv2.getLayoutParams();
                if (layoutParams3 != null) {
                    i2 = layoutParams3.height;
                }
                value$iv = new ViewGroup.MarginLayoutParams(i3, i2);
            }
            value$iv.rightMargin = VideoCommonVideoViewUtilsKt.SUB_TITLE_RIGHT_MARGIN_MAX_IN_PX;
            $this$marginLayoutParams$iv.setLayoutParams(value$iv);
        }
    }

    public void resetState() {
        super.resetState();
        VideoCommonVideoViewUtilsKt.clearAnimate(this.mVideoImage);
        FeedDraweeView feedDraweeView = this.mVideoImage;
        if (feedDraweeView != null) {
            feedDraweeView.setAlpha(1.0f);
        }
        BdBaseImageView bdBaseImageView = this.mVideoPlayIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.setAlpha(1.0f);
        }
        TextView textView = this.mVideoLength;
        if (textView != null) {
            textView.setAlpha(1.0f);
        }
        showSubtitle(true);
        initSubtitlePadding();
    }

    public HashMap<Integer, String> getVideoInfoMap() {
        return null;
    }

    public int business() {
        return 1;
    }

    public void onHideInfo() {
        super.onHideInfo();
        TextView textView = this.mSubTitle;
        if (textView != null && textView.getVisibility() == 0) {
            hideSubtitleWithAnimation();
        }
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoLength, false);
    }

    public void onUpdateProgress(int progress, int buffer, int max) {
    }

    public FeedBaseModel getModel() {
        return getFeedModel();
    }

    public NextPlayPosition getNextPlayPosition() {
        List it;
        VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = this.mItemModel;
        if (videoCommonAlbumMainChainStrongModel == null || (it = videoCommonAlbumMainChainStrongModel.getSlideCardMainList()) == null) {
            return super.getNextPlayPosition();
        }
        int position = this.currentPlayPosition;
        if (position + 1 < it.size()) {
            return new NextPlayPosition(getItemPosition(), position + 1);
        }
        return new NextPlayPosition(getItemPosition(), it.size() - 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r2 = r2.getSlideCardMainList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scrollToNext(int r5) {
        /*
            r4 = this;
            r0 = 0
            r4.hideSkipToast(r0)
            com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext r1 = r4.playerHelper
            if (r1 == 0) goto L_0x000b
            r1.unBind()
        L_0x000b:
            r4.currentPlayPosition = r5
            r4.updateImagePoster()
            r1 = r4
            com.baidu.searchbox.search.tab.implement.tplview.VideoCommonSlideBaseView r1 = (com.baidu.searchbox.search.tab.implement.tplview.VideoCommonSlideBaseView) r1
            r2 = 0
            r3 = 1
            com.baidu.searchbox.search.tab.implement.tplview.VideoCommonSlideBaseView.tryPlay$default(r1, r0, r3, r2)
            com.baidu.searchbox.search.tab.utils.CustomLayoutManager r1 = r4.layoutManager
            if (r1 == 0) goto L_0x0035
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r2 = r4.mItemModel
            if (r2 == 0) goto L_0x002b
            java.util.List r2 = r2.getSlideCardMainList()
            if (r2 == 0) goto L_0x002b
            int r2 = r2.size()
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            int r2 = r2 - r3
            if (r5 != r2) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            int r0 = r4.slideCardScrollOffset
        L_0x0032:
            r1.scrollToPositionWithOffset(r5, r0)
        L_0x0035:
            r4.showSubtitle(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.scrollToNext(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r3 = r3.getSlideCardMainList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isSupportAutoPlay() {
        /*
            r6 = this;
            r0 = 0
            android.graphics.Rect r1 = r6.rvRect
            r1.setEmpty()
            boolean r1 = r6.isRVRectInParent()
            int r2 = r6.currentPlayPosition
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r3 = r6.mItemModel
            r4 = 0
            if (r3 == 0) goto L_0x001c
            java.util.List r3 = r3.getSlideCardMainList()
            if (r3 == 0) goto L_0x001c
            int r3 = r3.size()
            goto L_0x001d
        L_0x001c:
            r3 = r4
        L_0x001d:
            r5 = 1
            int r3 = r3 + r5
            if (r2 >= r3) goto L_0x0027
            int r2 = r6.currentPlayPosition
            if (r2 < 0) goto L_0x0027
            r4 = r5
            goto L_0x0028
        L_0x0027:
        L_0x0028:
            r2 = r4
            if (r1 == 0) goto L_0x0034
            boolean r3 = r6.isRVCompletelyVisible()
            if (r3 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            r0 = 1
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.isSupportAutoPlay():boolean");
    }

    private final boolean isRVCompletelyVisible() {
        float f2 = (float) (this.rvRect.bottom - this.rvRect.top);
        FeedDraweeView feedDraweeView = this.mVideoImage;
        return this.rvRect.bottom > 0 && f2 / (feedDraweeView != null ? (float) feedDraweeView.getMeasuredHeight() : 1.0f) >= 1.0f;
    }

    private final boolean isRVRectInParent() {
        FeedDraweeView feedDraweeView = this.mVideoImage;
        if (feedDraweeView != null) {
            return feedDraweeView.getGlobalVisibleRect(this.rvRect);
        }
        return false;
    }

    public float getAutoPlayWeight() {
        Rect childRect = new Rect();
        FeedDraweeView feedDraweeView = this.mVideoImage;
        boolean z = true;
        if (feedDraweeView == null || !feedDraweeView.getGlobalVisibleRect(childRect)) {
            z = false;
        }
        boolean isInParent = z;
        float f2 = (float) (childRect.bottom - childRect.top);
        FeedDraweeView feedDraweeView2 = this.mVideoImage;
        float visibleAreaRatio = f2 / (feedDraweeView2 != null ? (float) feedDraweeView2.getMeasuredHeight() : 1.0f);
        AppConfig.isDebug();
        if (!isInParent || childRect.bottom <= 0) {
            return 0.0f;
        }
        return visibleAreaRatio;
    }

    public GestureListener createGestureListener() {
        return null;
    }

    private final void hideSubtitleWithAnimation() {
        if (this.playerHelper != null) {
            IListPlayerContext iListPlayerContext = this.playerHelper;
            if ((iListPlayerContext != null ? iListPlayerContext.getPlayer(business()) : null) instanceof SearchTabPlayer) {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this.mSubTitle, "alpha", new float[]{1.0f, 0.0f});
                alphaAnimator.setDuration(240);
                alphaAnimator.addListener(new VideoCommonAlbumMainChainStrongView$hideSubtitleWithAnimation$1(this));
                animatorSet.play(alphaAnimator);
                animatorSet.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r0 = r0.getSlideCardMainList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showSubtitle(boolean r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0063
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity r0 = r5.currentPlayEntity
            if (r0 != 0) goto L_0x001c
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r0 = r5.mItemModel
            if (r0 == 0) goto L_0x0019
            java.util.List r0 = r0.getSlideCardMainList()
            if (r0 == 0) goto L_0x0019
            int r1 = r5.currentPlayPosition
            java.lang.Object r0 = r0.get(r1)
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity r0 = (com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel.SlideCardEntity) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r5.currentPlayEntity = r0
        L_0x001c:
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity r0 = r5.currentPlayEntity
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.widget.TextView r2 = r5.mVideoLength
            if (r2 != 0) goto L_0x0026
            goto L_0x002f
        L_0x0026:
            java.lang.String r3 = r0.getDuration()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x002f:
            android.widget.TextView r2 = r5.mVideoLength
            r3 = 0
            if (r2 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r2.setVisibility(r3)
        L_0x0038:
            android.widget.TextView r2 = r5.mSubTitle
            if (r2 != 0) goto L_0x003d
            goto L_0x0046
        L_0x003d:
            java.lang.String r4 = r0.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x0046:
            android.widget.TextView r2 = r5.mSubTitle
            if (r2 != 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            r4 = 1065353216(0x3f800000, float:1.0)
            r2.setAlpha(r4)
        L_0x0050:
            android.widget.TextView r2 = r5.mSubTitle
            if (r2 != 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            r2.setVisibility(r3)
        L_0x0058:
            android.widget.TextView r2 = r5.mSubTitle
            if (r2 == 0) goto L_0x0062
            r3 = 1
            r4 = 1096810496(0x41600000, float:14.0)
            r2.setTextSize(r3, r4)
        L_0x0062:
            goto L_0x0075
        L_0x0063:
            android.widget.TextView r0 = r5.mVideoLength
            r1 = 8
            if (r0 != 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r0.setVisibility(r1)
        L_0x006d:
            android.widget.TextView r0 = r5.mSubTitle
            if (r0 != 0) goto L_0x0072
            goto L_0x0075
        L_0x0072:
            r0.setVisibility(r1)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.showSubtitle(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clickAuthor(android.view.View r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x000e
            int r2 = r5.getId()
            int r3 = com.baidu.searchbox.search.video.business.R.id.search_video_comment
            if (r2 != r3) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 != 0) goto L_0x001f
            if (r5 == 0) goto L_0x001c
            int r2 = r5.getId()
            int r3 = com.baidu.searchbox.search.video.business.R.id.search_video_album_main_chain_bottom_view
            if (r2 != r3) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 != 0) goto L_0x0025
        L_0x001f:
            r0 = r4
            com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo r0 = (com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo) r0
            com.baidu.searchbox.search.tab.implement.player.helper.VideoLoftPrefetchHelper.prefetchItem(r0)
        L_0x0025:
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel r0 = r4.mItemModel
            if (r0 == 0) goto L_0x003e
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.getAuthorCmd()
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003e
            com.baidu.searchbox.feed.template.FeedTemplateImpl r0 = r4.mFeedTemplateImplBase
            r0.onClick(r5)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView.clickAuthor(android.view.View):void");
    }

    public void clickIvk(View v) {
        FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
        if (feedTemplateImpl != null) {
            feedTemplateImpl.onClick(v);
        }
    }

    public boolean isSupportCToB() {
        return false;
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThickDividerPolicy.getDefault();
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.video_common_album_main_chain_strong;
    }

    public ViewGroup getSeekBarContainer() {
        return this.seekbar;
    }

    public boolean isEnableDragSeek() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFindView() {
    }

    /* access modifiers changed from: protected */
    public int getHorizontalPaddings() {
        return VideoCommonAlbumMainChainStrongViewKt.FIRST_ITEM_LEFT_MARGIN;
    }

    /* access modifiers changed from: protected */
    public int getSlideRecycleViewPaddings() {
        return getHorizontalPaddings();
    }

    /* access modifiers changed from: protected */
    public int getSlideRecycleViewDividerWidth() {
        return VideoCommonAlbumMainChainStrongViewKt.LEFT_MARGIN;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalParentMargin() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean needBottomCorner() {
        return true;
    }

    private final void bindFullScreenClick() {
        SearchTabVideoLayer layer;
        IListPlayerContext iListPlayerContext = this.playerHelper;
        SearchTabPlayer searchTabPlayer = null;
        BaseVulcanVideoPlayer player = iListPlayerContext != null ? iListPlayerContext.getPlayer(business()) : null;
        if (player instanceof SearchTabPlayer) {
            searchTabPlayer = (SearchTabPlayer) player;
        }
        SearchTabPlayer player2 = searchTabPlayer;
        if (player2 != null && (layer = player2.getLayer()) != null) {
            layer.setFullScreenClickLister(this);
        }
    }

    private final void initSubtitlePadding() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        TextView $this$initSubtitlePadding_u24lambda_u2d18 = this.mSubTitle;
        if ($this$initSubtitlePadding_u24lambda_u2d18 != null) {
            View $this$marginLayoutParams$iv = $this$initSubtitlePadding_u24lambda_u2d18;
            View $this$marginLayoutParams$iv2 = $this$initSubtitlePadding_u24lambda_u2d18;
            if ($this$marginLayoutParams$iv2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = $this$marginLayoutParams$iv2.getLayoutParams();
                if (layoutParams != null) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            } else {
                ViewGroup.LayoutParams layoutParams2 = $this$marginLayoutParams$iv2.getLayoutParams();
                int i2 = 0;
                int i3 = layoutParams2 != null ? layoutParams2.width : 0;
                ViewGroup.LayoutParams layoutParams3 = $this$marginLayoutParams$iv2.getLayoutParams();
                if (layoutParams3 != null) {
                    i2 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i2);
            }
            ViewGroup.MarginLayoutParams value$iv = marginLayoutParams;
            value$iv.rightMargin = VideoCommonVideoViewUtilsKt.SUB_TITLE_RIGHT_MARGIN_MIN_IN_PX;
            $this$marginLayoutParams$iv.setLayoutParams(value$iv);
        }
    }

    public void updateByLinkageDate(LinkageData linkageData) {
        VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel;
        FeedBar feedBar;
        FeedBar.Like it;
        FeedBar feedBar2;
        FeedBar.Comment it2;
        if (linkageData != null) {
            if (TextUtils.equals(linkageData.type, "comment")) {
                VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel2 = this.mItemModel;
                if (!(videoCommonAlbumMainChainStrongModel2 == null || (feedBar2 = videoCommonAlbumMainChainStrongModel2.feedBar) == null || (it2 = feedBar2.comment) == null)) {
                    it2.count = FeedUtil.convertStringToIntSafe(linkageData.count);
                }
            } else if (!(!TextUtils.equals(linkageData.type, "pro") || (videoCommonAlbumMainChainStrongModel = this.mItemModel) == null || (feedBar = videoCommonAlbumMainChainStrongModel.feedBar) == null || (it = feedBar.like) == null)) {
                it.status = TextUtils.equals(linkageData.status, "1");
                it.count = FeedUtil.convertStringToIntSafe(linkageData.count);
            }
            VideoCommonBottomView videoCommonBottomView = this.mBottomView;
            if (videoCommonBottomView != null) {
                videoCommonBottomView.updateFeedBarIcon();
            }
        }
    }

    public IListPlayerContext getPlayHelper() {
        return this.playerHelper;
    }

    public boolean supportSkipToast() {
        return true;
    }

    public int getSkipToastBottomMarginRes() {
        return R.dimen.skip_toast_margin_bottom_in_album;
    }
}
