package com.baidu.searchbox.card;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.menu.bottomlist.BottomCommonMenuItem;
import com.baidu.android.common.menu.bottomlist.BottomCustomMenuItem;
import com.baidu.android.common.menu.bottomlist.BottomListMenu;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg;
import com.baidu.android.imsdk.chatmessage.request.IMSendGratitudeMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.searchbox.MessageStatisticUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.im.ui.HorizontalOverlapRoundImagesView;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.card.CardNetwork;
import com.baidu.searchbox.card.model.CardDataEvent;
import com.baidu.searchbox.card.model.CardDataEventType;
import com.baidu.searchbox.card.utils.InteractCardRichTextFormatter;
import com.baidu.searchbox.card.utils.InteractCardUIUtil;
import com.baidu.searchbox.card.utils.InteractShieldRelationUtils;
import com.baidu.searchbox.comment.model.ForwardCommentInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.follow.FollowManager;
import com.baidu.searchbox.follow.callback.FollowRequestCallback;
import com.baidu.searchbox.iminteract.imrichtext.IRichTextFormatter;
import com.baidu.searchbox.iminteract.imrichtext.RichTextFormatter;
import com.baidu.searchbox.iminteract.imrichtext.TextWithCompoundDrawableSpan;
import com.baidu.searchbox.imsdk.ImMsgReceiverListener;
import com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeBaseFragment;
import com.baidu.searchbox.message.interactionupgrade.InteractionUserHelper;
import com.baidu.searchbox.message.interactionupgrade.InteractionUtils;
import com.baidu.searchbox.message.interactionupgrade.UserIdentityCallback;
import com.baidu.searchbox.message.interactionupgrade.ubc.InteractionUpgradeParamsUtil;
import com.baidu.searchbox.message.interactionupgrade.ubc.InteractionUpgradeUBCUtil;
import com.baidu.searchbox.plugins.helper.CambrianPluginHelper;
import com.baidu.searchbox.plugins.helper.IMPluginHelper;
import com.baidu.searchbox.push.CommentNotifyInAppModel;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.MyMessageUtils;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.mymessagefragment.PushNotifyBaseFragment;
import com.baidu.searchbox.push.mymessagefragment.params.PushAttrs;
import com.baidu.searchbox.push.mymessagefragment.recyclerview.IPushNotifyView;
import com.baidu.searchbox.push.mymessagefragment.util.PushNotifyParamsUtil;
import com.baidu.searchbox.push.mymessagefragment.util.PushNotifyUBCUtil;
import com.baidu.searchbox.push.mymessagefragment.util.RecommendFollowUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.sumeru.implugin.invoke.IChatInvokeListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InteractCardUpgradeView extends FrameLayout implements IPushNotifyView<NotificationMsgData> {
    public static final String ACTION_AITE = "@";
    public static final String ACTION_COLLECTION = "collection";
    public static final String ACTION_COMMENT = "comment";
    public static final String ACTION_COMMENT_AT = "comment_at";
    public static final String ACTION_COMMENT_FAVOR = "comment_favor";
    public static final String ACTION_COMMENT_REPLY = "comment_reply";
    public static final String ACTION_DONGTAI = "dongtai";
    public static final String ACTION_FEED_TRUSTED = "feed_trusted";
    public static final String ACTION_FOLLOW = "follow";
    public static final String ACTION_GENGXINTIXING = "gengxintixing";
    public static final String ACTION_VISITOR = "visitor";
    public static final String ACTION_VOTE = "vote";
    public static final String ACTION_ZAN = "zan";
    public static final String ACTION_ZAN_COMMENT = "zan_comment";
    public static final String ACTION_ZAN_COMMENT_REPLY = "zan_comment_reply";
    private static final int DYNAMIC_ERRNO = 202206;
    public static final int FOLLOW_RELATION_EACH = 3;
    public static final int FOLLOW_RELATION_FOLLOW_ME = 2;
    public static final int FOLLOW_RELATION_MY_FOLLOW = 1;
    public static final int FOLLOW_RELATION_NONE = 0;
    private static final String FOLLOW_SOURCE = "message";
    private static final String FROM = "im";
    private static final int ITEM_ID_CAN_RECEIVE_ARTICLE = 4;
    private static final int ITEM_ID_CAN_RECEIVE_TYPE = 6;
    private static final int ITEM_ID_CAN_RECEIVE_USER = 5;
    private static final int ITEM_ID_DO_NOT_RECEIVE_ARTICLE = 1;
    private static final int ITEM_ID_DO_NOT_RECEIVE_TYPE = 3;
    private static final int ITEM_ID_DO_NOT_RECEIVE_USER = 2;
    private static final int ITEM_ID_MY_NOTIFY_DELETE = 0;
    private static final String LIKE_SOURCE = "im";
    private static final int MESSAGE_TYPE_B = 80;
    private static final int MESSAGE_TYPE_C = 0;
    private static final String OPERATION = "like";
    private static final String STRATEGY_INFO_PB_KEY = "pb";
    private static final String STRATEGY_INFO_PB_VALUE = "message_center";
    private static final String TAG = "InteractCardUpgradeView";
    private static final String TYPE = "feed";
    public static final int TYPE_COMMENT_PK = 310;
    public static final int TYPE_COMMENT_VIDEOS = 309;
    private static final int WIDTH_NON_CONTENT = 140;
    private static String sPlaceHolderDoublePortrait = "";
    private static String sPlaceHolderThreePortrait = "";
    /* access modifiers changed from: private */
    public int hasGreet;
    /* access modifiers changed from: private */
    public int hasThanks;
    /* access modifiers changed from: private */
    public boolean isLoading;
    protected String mAction;
    protected int mAggregatedCount;
    private JSONObject mAggregatedInfo;
    private JSONObject mBlockInfo;
    private ChatUser mChatUser;
    private int mContentGroupWidth;
    /* access modifiers changed from: private */
    public final Context mContext;
    private String mCover;
    /* access modifiers changed from: private */
    public NotificationMsgData mData;
    private FrameLayout mFLRightGroup;
    private FrameLayout mFlAvatarGroup;
    private FrameLayout mFlOriginalImage;
    /* access modifiers changed from: private */
    public RelativeLayout mFlRightButton;
    /* access modifiers changed from: private */
    public int mFollowRelation;
    private HorizontalOverlapRoundImagesView mHorizontalImgView;
    private final LayoutInflater mInflater;
    private LinearLayout mInteractGratitudeFrameButton;
    /* access modifiers changed from: private */
    public SimpleDraweeView mInteractGratitudeImage;
    /* access modifiers changed from: private */
    public ProgressBar mInteractGratitudeLoading;
    /* access modifiers changed from: private */
    public ImageView mInteractGratitudeRight;
    /* access modifiers changed from: private */
    public TextView mInteractOneClickGratitude;
    private SimpleDraweeView mInteractSayHelloImage;
    protected boolean mIsAggregated;
    private boolean mIsVideo;
    private SimpleDraweeView mIvAvatar;
    private SimpleDraweeView mIvAvatarDarkHolder;
    /* access modifiers changed from: private */
    public SimpleDraweeView mIvLikeBtnIcon;
    private SimpleDraweeView mIvOriginalImage;
    private SimpleDraweeView mIvOriginalImageVideoTag;
    private SimpleDraweeView mIvReplyBtnIcon;
    private ImageView mIvShieldImage;
    private SimpleDraweeView mIvTagIcon;
    private SimpleDraweeView mIvTagIconDarkHolder;
    private LinearLayout mLlButtomBtnGroup;
    private LinearLayout mLlCenterGroup;
    /* access modifiers changed from: private */
    public LinearLayout mLlInteractItem;
    private LinearLayout mLlLikeBtn;
    private LinearLayout mLlOriginalGroup;
    private LinearLayout mLlReplyBtn;
    private ViewGroup mLlTitleGroup;
    private View.OnTouchListener mOnTouchListener;
    protected int mOriginalTemplate;
    /* access modifiers changed from: private */
    public ProgressBar mPbRightButtonLoading;
    /* access modifiers changed from: private */
    public PushAttrs mPushAttrs;
    private View mRootView;
    private IRichTextFormatter mRtfRichTextFormatter;
    /* access modifiers changed from: private */
    public String mSchema;
    private JSONObject mSourceInfo;
    private final int mTag;
    protected int mTemplate;
    /* access modifiers changed from: private */
    public JSONObject mTextInfo;
    private long mTime;
    /* access modifiers changed from: private */
    public Map<String, String> mTrackParamsMap;
    private TextView mTvContent;
    /* access modifiers changed from: private */
    public TextView mTvLikeBtnText;
    private TextView mTvOriginalText;
    private TextView mTvReplyBtnText;
    /* access modifiers changed from: private */
    public TextView mTvRightButtonText;
    private TextView mTvTitle;
    /* access modifiers changed from: private */
    public TextView mTvTitleTag;
    /* access modifiers changed from: private */
    public JSONObject mUserInfo;
    private JSONArray mUserInfoArray;
    /* access modifiers changed from: private */
    public String mUserPaid;
    private View mViewOriginalTip;
    /* access modifiers changed from: private */
    public RedDotAnimView mViewRedDotTip;
    /* access modifiers changed from: private */
    public int mZanStatus;
    /* access modifiers changed from: private */
    public TimeOutRunnable runnable;

    public static class ShieldStateRefreshEvent {
    }

    private static class TimeOutRunnable implements Runnable {
        private Context mContext;
        private WeakReference<InteractCardUpgradeView> mReference;
        private int type = 0;

        public TimeOutRunnable(InteractCardUpgradeView interactCardUpgradeView, Context context, int type2) {
            this.mReference = new WeakReference<>(interactCardUpgradeView);
            this.mContext = context;
            this.type = type2;
        }

        public void run() {
            InteractCardUpgradeView interactCardUpgradeView;
            if (MessageRuntime.GLOBAL_DEBUG) {
                Log.d(InteractCardUpgradeView.TAG, "run: 4s超时");
            }
            WeakReference<InteractCardUpgradeView> weakReference = this.mReference;
            if (weakReference != null && (interactCardUpgradeView = (InteractCardUpgradeView) weakReference.get()) != null) {
                boolean unused = interactCardUpgradeView.isLoading = false;
                int unused2 = interactCardUpgradeView.hasThanks = 1;
                interactCardUpgradeView.mInteractOneClickGratitude.setVisibility(0);
                interactCardUpgradeView.mInteractGratitudeLoading.setVisibility(8);
                interactCardUpgradeView.mInteractOneClickGratitude.setPadding(DeviceUtil.ScreenInfo.dp2px(this.mContext, 5.0f), 0, 0, 0);
                interactCardUpgradeView.mInteractOneClickGratitude.setText("已感谢，去聊天");
                interactCardUpgradeView.mInteractGratitudeRight.setVisibility(0);
                interactCardUpgradeView.mInteractGratitudeImage.setVisibility(8);
                UniversalToast.makeText(MessageRuntime.getAppContext(), (CharSequence) "感谢表情已发送").showToast();
                BdEventBus.Companion.getDefault().post(new InteractionUpgradeBaseFragment.GratitudeMsgEvent(this.type, interactCardUpgradeView.mData.getMsg().getMsgId(), ""));
            }
        }
    }

    public InteractCardUpgradeView(Context context, int tag) {
        this(context, (AttributeSet) null, tag);
    }

    public InteractCardUpgradeView(Context context, AttributeSet attrs, int tag) {
        this(context, attrs, 0, tag);
    }

    public InteractCardUpgradeView(Context context, AttributeSet attrs, int defStyleAttr, int tag) {
        super(context, attrs, defStyleAttr);
        this.mTrackParamsMap = new HashMap();
        this.isLoading = false;
        this.mOnTouchListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1 || event.getAction() == 3) {
                    v.setAlpha(1.0f);
                }
                if (event.getAction() != 0) {
                    return false;
                }
                v.setAlpha(0.2f);
                return false;
            }
        };
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mTag = tag;
        this.mRtfRichTextFormatter = new RichTextFormatter(context);
        sPlaceHolderDoublePortrait = "";
        sPlaceHolderThreePortrait = "";
        initView();
    }

    private void initView() {
        View inflate = this.mInflater.inflate(R.layout.card_view_interact_message_upgrade, this);
        this.mRootView = inflate;
        this.mLlInteractItem = (LinearLayout) inflate.findViewById(R.id.interact_item_ll);
        this.mFlAvatarGroup = (FrameLayout) this.mRootView.findViewById(R.id.interact_item_fl_avatar_group);
        this.mIvAvatar = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_avatar);
        this.mIvAvatarDarkHolder = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_avatar_dark_holder);
        this.mIvTagIcon = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_tagicon);
        this.mIvTagIconDarkHolder = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_tagicon_dark_holder);
        this.mViewRedDotTip = (RedDotAnimView) this.mRootView.findViewById(R.id.interact_item_red_dot_tip);
        this.mLlCenterGroup = (LinearLayout) this.mRootView.findViewById(R.id.interact_item_ll_center_group);
        this.mLlTitleGroup = (ViewGroup) this.mRootView.findViewById(R.id.interact_item_ll_title_group);
        this.mTvTitle = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_title);
        this.mTvTitleTag = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_title_tag);
        this.mIvShieldImage = (ImageView) this.mRootView.findViewById(R.id.interact_item_iv_shield_image);
        this.mHorizontalImgView = (HorizontalOverlapRoundImagesView) this.mRootView.findViewById(R.id.horizontal_img_view);
        this.mTvContent = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_content);
        this.mInteractGratitudeFrameButton = (LinearLayout) this.mRootView.findViewById(R.id.interact_gratitude_frame_button);
        this.mInteractGratitudeImage = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_gratitude_image);
        this.mInteractOneClickGratitude = (TextView) this.mRootView.findViewById(R.id.interact_one_click_gratitude);
        this.mInteractGratitudeRight = (ImageView) this.mRootView.findViewById(R.id.interact_gratitude_right);
        this.mInteractGratitudeLoading = (ProgressBar) this.mRootView.findViewById(R.id.interact_gratitude_loading);
        this.mLlOriginalGroup = (LinearLayout) this.mRootView.findViewById(R.id.interact_item_ll_original);
        this.mViewOriginalTip = this.mRootView.findViewById(R.id.interact_item_view_original_tip);
        this.mTvOriginalText = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_original);
        this.mFlOriginalImage = (FrameLayout) this.mRootView.findViewById(R.id.interact_item_fl_original_image);
        this.mIvOriginalImage = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_riv_original_image);
        this.mIvOriginalImageVideoTag = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_original_image_video_tag);
        this.mLlButtomBtnGroup = (LinearLayout) this.mRootView.findViewById(R.id.interact_item_ll_bottom_btn_group);
        this.mLlReplyBtn = (LinearLayout) this.mRootView.findViewById(R.id.interact_item_ll_reply_btn);
        this.mIvReplyBtnIcon = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_reply_icon);
        this.mTvReplyBtnText = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_reply_text);
        this.mLlLikeBtn = (LinearLayout) this.mRootView.findViewById(R.id.interact_item_ll_like_btn);
        this.mIvLikeBtnIcon = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_item_iv_like_icon);
        this.mTvLikeBtnText = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_like_text);
        this.mFLRightGroup = (FrameLayout) this.mRootView.findViewById(R.id.interact_item_fl_right_group);
        this.mFlRightButton = (RelativeLayout) this.mRootView.findViewById(R.id.interact_item_fl_right_button);
        this.mInteractSayHelloImage = (SimpleDraweeView) this.mRootView.findViewById(R.id.interact_say_hello_image);
        this.mTvRightButtonText = (TextView) this.mRootView.findViewById(R.id.interact_item_tv_follow_btn);
        this.mPbRightButtonLoading = (ProgressBar) this.mRootView.findViewById(R.id.interact_item_progressbar_follow_loading);
        initTheme();
        this.mContentGroupWidth = (int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - InteractCardUIUtil.dp2px(this.mContext, 140.0f));
    }

    private void initTheme() {
        int i2;
        int i3;
        SimpleDraweeView simpleDraweeView;
        if (this.mContext != null) {
            boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
            LinearLayout linearLayout = this.mLlInteractItem;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC10));
                this.mLlInteractItem.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent event) {
                        if ((event.getAction() == 1 || event.getAction() == 3) && InteractCardUpgradeView.this.mLlInteractItem != null) {
                            InteractCardUpgradeView.this.mLlInteractItem.setBackgroundColor(InteractCardUpgradeView.this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC10));
                        }
                        if (event.getAction() != 0 || InteractCardUpgradeView.this.mLlInteractItem == null) {
                            return false;
                        }
                        InteractCardUpgradeView.this.mLlInteractItem.setBackgroundColor(InteractCardUpgradeView.this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC72));
                        return false;
                    }
                });
            }
            TextView textView = this.mTvTitle;
            if (textView != null) {
                textView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvTitle, 0, R.dimen.message_dimens_14dp);
            }
            int i4 = 8;
            if (this.mIvAvatarDarkHolder != null) {
                if (TextUtils.equals("visitor", this.mAction) || TextUtils.equals("vote", this.mAction)) {
                    this.mIvAvatarDarkHolder.setVisibility(nightModeSwitcherState ? 0 : 8);
                } else {
                    this.mIvAvatarDarkHolder.setVisibility(8);
                }
            }
            if (!(this.mIvTagIconDarkHolder == null || (simpleDraweeView = this.mIvTagIcon) == null)) {
                int tagIconVisibility = simpleDraweeView.getVisibility();
                SimpleDraweeView simpleDraweeView2 = this.mIvTagIconDarkHolder;
                if (nightModeSwitcherState && tagIconVisibility == 0) {
                    i4 = 0;
                }
                simpleDraweeView2.setVisibility(i4);
            }
            TextView textView2 = this.mTvTitleTag;
            if (textView2 != null) {
                textView2.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
                ((GradientDrawable) this.mTvTitleTag.getBackground()).setColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC34));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvTitleTag, 0, R.dimen.message_dimens_10dp);
            }
            ImageView imageView = this.mIvShieldImage;
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.interaction_message_shield_icon));
                FontSizeViewExtKt.setScaledSizeRes(this.mIvShieldImage, 0, R.dimen.message_dimens_14dp, R.dimen.message_dimens_14dp);
            }
            TextView textView3 = this.mTvContent;
            if (textView3 != null) {
                textView3.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC106));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvContent, 0, R.dimen.message_dimens_12dp);
            }
            TextView textView4 = this.mInteractOneClickGratitude;
            if (textView4 != null) {
                textView4.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mInteractOneClickGratitude, 0, R.dimen.message_dimens_10dp);
            }
            LinearLayout linearLayout2 = this.mInteractGratitudeFrameButton;
            if (linearLayout2 != null) {
                linearLayout2.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.message_interact_thanks_gc_99));
            }
            ProgressBar progressBar = this.mInteractGratitudeLoading;
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.progress_bar_animate_interact));
            }
            ImageView imageView2 = this.mInteractGratitudeRight;
            if (imageView2 != null) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.message_gratitude_right_icon));
            }
            TextView textView5 = this.mTvOriginalText;
            if (textView5 != null) {
                textView5.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC106));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvOriginalText, 0, R.dimen.message_dimens_12dp);
            }
            TextView textView6 = this.mTvReplyBtnText;
            if (textView6 != null) {
                textView6.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC106));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvReplyBtnText, 0, R.dimen.message_dimens_10dp);
            }
            TextView textView7 = this.mTvLikeBtnText;
            if (textView7 != null) {
                textView7.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC106));
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvLikeBtnText, 0, R.dimen.message_dimens_10dp);
            }
            if (this.mTvRightButtonText != null) {
                if (this.hasGreet == 0 && "follow".equals(this.mAction) && ((i3 = this.mFollowRelation) == 1 || i3 == 3)) {
                    this.mTvRightButtonText.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                } else {
                    this.mTvRightButtonText.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.BC60));
                }
                FontSizeTextViewExtKt.setScaledSizeRes(this.mTvRightButtonText, 0, R.dimen.message_dimens_12dp);
            }
            if (this.mFlRightButton != null) {
                if (this.hasGreet == 0 && "follow".equals(this.mAction) && ((i2 = this.mFollowRelation) == 1 || i2 == 3)) {
                    this.mFlRightButton.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.message_interact_thanks_gc_99));
                } else {
                    this.mFlRightButton.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.follow_button_shape_upgrade));
                }
            }
            View view2 = this.mViewOriginalTip;
            if (view2 != null) {
                ((GradientDrawable) view2.getBackground()).setColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC66));
            }
            SimpleDraweeView simpleDraweeView3 = this.mIvReplyBtnIcon;
            if (simpleDraweeView3 != null) {
                FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView3, 0, R.dimen.message_dimens_12dp, R.dimen.message_dimens_12dp);
            }
            SimpleDraweeView simpleDraweeView4 = this.mIvLikeBtnIcon;
            if (simpleDraweeView4 != null) {
                FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView4, 0, R.dimen.message_dimens_12dp, R.dimen.message_dimens_12dp);
            }
        }
    }

    public View getViewInstance() {
        return this;
    }

    public Class<NotificationMsgData> getDataType() {
        return NotificationMsgData.class;
    }

    public void onSetCommonAttrs(PushAttrs attrs) {
        this.mPushAttrs = attrs;
    }

    public void onBindView(int position, NotificationMsgData data, Map<Integer, Object> showedData) {
        this.mTrackParamsMap = InteractionUtils.getMsgs(data);
        this.mData = data;
        this.mUserPaid = "";
        try {
            JSONObject jsonContent = new JSONObject(data.getMsg().getJsonContent());
            if (MessageRuntime.GLOBAL_DEBUG) {
                Log.d(TAG, "onBindView: jsonContent = " + jsonContent);
            }
            this.mAction = jsonContent.optString("action", "");
            int optInt = jsonContent.optInt("template");
            this.mOriginalTemplate = optInt;
            this.mTemplate = MessageType.getMessageType(optInt);
            this.mSchema = jsonContent.optString("schema", "");
            this.mCover = jsonContent.optString("cover", "");
            this.mIsVideo = jsonContent.optBoolean("is_video");
            this.mTime = jsonContent.optLong(FavorModel.MTIME);
            this.mIsAggregated = jsonContent.optBoolean("is_merged");
            this.mAggregatedCount = jsonContent.optInt("fuks_count");
            this.mAggregatedInfo = jsonContent.optJSONObject("aggregate_info");
            JSONArray optJSONArray = jsonContent.optJSONArray("user_info");
            this.mUserInfoArray = optJSONArray;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.mUserInfo = this.mUserInfoArray.optJSONObject(0);
            }
            this.mTextInfo = jsonContent.optJSONObject("text");
            this.mSourceInfo = jsonContent.optJSONObject("source");
            JSONObject ext = jsonContent.optJSONObject("ext_out");
            if (ext != null) {
                this.hasThanks = ext.optInt(IMSendGratitudeMsg.KEY_CONTENT_EXT_HAS_THANKS, 0);
                this.hasGreet = ext.optInt(IMSendGratitudeMsg.KEY_CONTENT_EXT_HAS_GREET, 0);
            }
            this.mBlockInfo = jsonContent.optJSONObject("block_info");
            handleData2AvatarView();
            handleData2TitleView();
            handleData2ContentView();
            handleData2BottomBtn(jsonContent);
            handleData2RightContentDefault();
            handleRedDotUI(this.mViewRedDotTip, this.mData, this.mPushAttrs);
            asyncHandleRelationTagAndBtn();
            handleItemViewClick(jsonContent);
            handleItemLongClickListener(this.mData, this.mLlInteractItem, this.mTvContent, this.mTvOriginalText);
            handleUserIdentity();
            if (showedData.get(Integer.valueOf(position)) == null) {
                showedData.put(Integer.valueOf(position), data);
                InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(this.mAction), "5", "msg_show", this.mTrackParamsMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void asyncHandleRelationTagAndBtn() {
        InteractionUserHelper.getInstance().mThreadExecutor.execute(new Runnable() {
            public void run() {
                if (InteractCardUpgradeView.this.mUserInfo != null && InteractCardUpgradeView.this.mTvTitleTag != null && InteractCardUpgradeView.this.activityNotFinishing()) {
                    InteractCardUpgradeView interactCardUpgradeView = InteractCardUpgradeView.this;
                    int unused = interactCardUpgradeView.mFollowRelation = interactCardUpgradeView.getRealFollowRelation();
                    if (MessageRuntime.GLOBAL_DEBUG) {
                        Log.d(InteractCardUpgradeView.TAG, "mFollowRelation = getRealFollowRelation() = " + InteractCardUpgradeView.this.mFollowRelation);
                    }
                    InteractCardUpgradeView.this.mTvTitleTag.post(new Runnable() {
                        public void run() {
                            InteractCardUpgradeView.this.refreshTitleTag();
                        }
                    });
                } else if (InteractCardUpgradeView.this.mTvTitleTag != null) {
                    InteractCardUpgradeView.this.mTvTitleTag.setVisibility(8);
                }
                if (InteractCardUpgradeView.this.mTvRightButtonText != null && InteractCardUpgradeView.this.activityNotFinishing()) {
                    InteractCardUpgradeView.this.mTvRightButtonText.post(new Runnable() {
                        public void run() {
                            InteractCardUpgradeView.this.handleData2RightContent();
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int getRealFollowRelation() {
        ChatUser user;
        if (this.mUserInfo == null) {
            return 0;
        }
        try {
            if ((ChatMessageDBManager.getInstance(this.mContext).getChatMsgByMsgId(this.mData.getMsg().getMsgId()) instanceof InterActiveMsg) && (user = ChatUserDBManager.getInstance(this.mContext).getChatUserByBuid(Long.parseLong(SocialEncodeUtils.getSocialDecrypt(this.mUserInfo.optString("uk", ""), "baiduuid_")))) != null) {
                int subscribe = user.getSubscribe();
                JSONObject jSONObject = this.mUserInfo;
                if (jSONObject != null) {
                    jSONObject.put("relation_follow", subscribe);
                }
                return user.getSubscribe();
            }
        } catch (Exception e2) {
            if (MessageRuntime.GLOBAL_DEBUG) {
                Log.e(TAG, e2.getMessage());
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = this.mUserInfo;
        if (jSONObject2 == null) {
            return 0;
        }
        return jSONObject2.optInt("relation_follow");
    }

    public void onNightModeChanged() {
        initTheme();
    }

    private void handleData2AvatarView() {
        if (TextUtils.equals("visitor", this.mAction)) {
            this.mIvAvatar.setImageResource(R.drawable.icon_interact_avator_visitor);
        } else if (TextUtils.equals("vote", this.mAction)) {
            this.mIvAvatar.setImageResource(R.drawable.icon_interact_avator_vote);
        } else {
            JSONObject jSONObject = this.mUserInfo;
            if (jSONObject != null) {
                this.mIvAvatar.setImageURI(Uri.parse(jSONObject.optString("portrait", "")));
            }
        }
        RoundingParams avatarParams = ((GenericDraweeHierarchy) this.mIvAvatar.getHierarchy()).getRoundingParams();
        if (avatarParams != null) {
            avatarParams.setBorderColor(getResources().getColor(R.color.message_user_icon_border));
            ((GenericDraweeHierarchy) this.mIvAvatar.getHierarchy()).setRoundingParams(avatarParams);
        }
        RoundingParams originalParams = ((GenericDraweeHierarchy) this.mIvOriginalImage.getHierarchy()).getRoundingParams();
        if (originalParams != null) {
            originalParams.setBorderColor(getResources().getColor(R.color.message_user_icon_border));
            ((GenericDraweeHierarchy) this.mIvOriginalImage.getHierarchy()).setRoundingParams(originalParams);
        }
        handleAvatarTag();
    }

    private void handleData2TitleView() {
        if (!TextUtils.isEmpty(this.mAction)) {
            if (TextUtils.equals("visitor", this.mAction)) {
                this.mTvTitle.setText("主页访客");
                this.mTvTitleTag.setVisibility(8);
            } else if (TextUtils.equals("vote", this.mAction)) {
                this.mTvTitle.setText("我的投票");
                this.mTvTitleTag.setVisibility(8);
            } else if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                JSONObject jSONObject = this.mUserInfo;
                if (jSONObject != null) {
                    this.mTvTitle.setText(jSONObject.optString("nickname", ""));
                }
            } else {
                JSONObject jSONObject2 = this.mAggregatedInfo;
                if (jSONObject2 != null) {
                    this.mTvTitle.setText(jSONObject2.optString("nickname", ""));
                } else {
                    return;
                }
            }
            InteractShieldRelationUtils.settingShieldRelationUI(this.mData, this.mIvShieldImage);
            if (NightModeHelper.getNightModeSwitcherState()) {
                this.mIvShieldImage.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.interaction_message_shield_icon_dark));
            }
        }
    }

    /* access modifiers changed from: private */
    public void refreshTitleTag() {
        if (activityNotFinishing() && this.mTvTitleTag != null && this.mUserInfo != null) {
            if (TextUtils.isEmpty(this.mAction)) {
                this.mTvTitleTag.setVisibility(8);
            } else if (TextUtils.equals("visitor", this.mAction)) {
                this.mTvTitleTag.setVisibility(8);
            } else if (TextUtils.equals("vote", this.mAction)) {
                this.mTvTitleTag.setVisibility(8);
            } else if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                JSONObject jSONObject = this.mUserInfo;
                if (jSONObject == null) {
                    this.mTvTitleTag.setVisibility(8);
                    return;
                }
                int relationPhone = jSONObject.optInt("relation_phone");
                boolean isAuthor = this.mUserInfo.optBoolean(CommentNotifyInAppModel.IS_AUTHOR);
                String relationText = "";
                int i2 = this.mFollowRelation;
                if (i2 == 1) {
                    relationText = RecommendFollowUtils.TEXT_HAD_FOLLOW;
                } else if (i2 == 2) {
                    relationText = "关注了我";
                } else if (i2 == 3) {
                    relationText = "互相关注";
                } else if (relationPhone == 1) {
                    relationText = "通讯录好友";
                } else if (isAuthor) {
                    relationText = "作者";
                }
                if (TextUtils.isEmpty(relationText)) {
                    this.mTvTitleTag.setVisibility(8);
                    return;
                }
                this.mTvTitleTag.setVisibility(0);
                this.mTvTitleTag.setText(relationText);
            } else {
                this.mTvTitleTag.setVisibility(8);
            }
        }
    }

    private void handleAvatarTag() {
        if (TextUtils.isEmpty(this.mAction)) {
            this.mIvTagIcon.setVisibility(8);
            return;
        }
        int resourceId = 0;
        String str = this.mAction;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1741312354:
                if (str.equals("collection")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1268958287:
                if (str.equals("follow")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1118630818:
                if (str.equals("comment_favor")) {
                    c2 = 10;
                    break;
                }
                break;
            case -1107435254:
                if (str.equals("comment_reply")) {
                    c2 = 8;
                    break;
                }
                break;
            case -437385979:
                if (str.equals(ACTION_GENGXINTIXING)) {
                    c2 = 11;
                    break;
                }
                break;
            case -9546681:
                if (str.equals("zan_comment")) {
                    c2 = 3;
                    break;
                }
                break;
            case 64:
                if (str.equals("@")) {
                    c2 = SearchABTestUtils.PREFETCH_FREQ_STRAT_NQE4;
                    break;
                }
                break;
            case 120359:
                if (str.equals("zan")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3625706:
                if (str.equals("vote")) {
                    c2 = 13;
                    break;
                }
                break;
            case 348928242:
                if (str.equals(ACTION_ZAN_COMMENT_REPLY)) {
                    c2 = 4;
                    break;
                }
                break;
            case 466760814:
                if (str.equals("visitor")) {
                    c2 = 0;
                    break;
                }
                break;
            case 899150355:
                if (str.equals(ACTION_COMMENT_AT)) {
                    c2 = 9;
                    break;
                }
                break;
            case 950398559:
                if (str.equals("comment")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1758012246:
                if (str.equals(ACTION_FEED_TRUSTED)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 1:
                resourceId = R.drawable.icon_interact_label_follow;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                resourceId = R.drawable.icon_interact_label_zan;
                break;
            case 6:
                resourceId = R.drawable.icon_interact_label_collection;
                break;
            case 7:
            case 8:
            case 9:
                resourceId = R.drawable.icon_interact_label_comment;
                break;
            case 10:
                resourceId = R.drawable.icon_interact_label_top;
                break;
            case 11:
                resourceId = R.drawable.icon_interact_label_subscription;
                break;
            case 12:
                resourceId = R.drawable.icon_interact_label_aite;
                break;
        }
        if (resourceId != 0) {
            this.mIvTagIcon.setVisibility(0);
            this.mIvTagIcon.setImageResource(resourceId);
            return;
        }
        this.mIvTagIcon.setVisibility(8);
    }

    private void handleData2ContentView() {
        String str;
        int i2;
        String str2;
        String contentText;
        String nicknameFix;
        String contentText2;
        String contentText3;
        this.mInteractGratitudeFrameButton.setVisibility(8);
        if (this.mTextInfo == null) {
            this.mTvContent.setVisibility(8);
            this.mLlOriginalGroup.setVisibility(8);
            return;
        }
        String timeText = MyMessageUtils.formatMessageTime(MessageRuntime.getAppContext(), this.mTime);
        String placeHolder = handleOriginalPortrait();
        String str3 = "等";
        if (TextUtils.equals("visitor", this.mAction)) {
            str2 = "contentEndEllipsizeText:";
            i2 = 1;
            str = TAG;
        } else if (TextUtils.equals("vote", this.mAction)) {
            str2 = "contentEndEllipsizeText:";
            i2 = 1;
            str = TAG;
        } else if (TextUtils.equals("follow", this.mAction)) {
            str2 = "contentEndEllipsizeText:";
            i2 = 1;
            str = TAG;
        } else {
            String level1 = this.mTextInfo.optString("level1", "");
            String level1Prefix = this.mTextInfo.optString("level1_prefix", "");
            JSONObject formatExt1 = this.mTextInfo.optJSONObject("format_ext1");
            String optString = this.mTextInfo.optString("schema1", "");
            String level2 = this.mTextInfo.optString("level2", "");
            String level2Prefix = this.mTextInfo.optString("level2_prefix", "");
            JSONObject formatExt2 = this.mTextInfo.optJSONObject("format_ext2");
            String optString2 = this.mTextInfo.optString("schema2", "");
            if (TextUtils.isEmpty(level2)) {
                this.mLlOriginalGroup.setVisibility(8);
                if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                    contentText3 = level1;
                } else {
                    contentText3 = str3 + this.mAggregatedCount + "个人" + level1;
                }
                JSONObject formatExt22 = formatExt2;
                SpannableStringBuilder contentTail = getTialContent(getRichText(this.mTvContent, placeHolder + contentText3, level1Prefix, formatExt1, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f)), formatExt1, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f));
                Context context = this.mContext;
                TextView textView = this.mTvContent;
                int i3 = this.mContentGroupWidth;
                String level22 = level2;
                Context context2 = context;
                JSONObject formatExt12 = formatExt1;
                String str4 = level1;
                String str5 = TAG;
                String str6 = "contentEndEllipsizeText:";
                CharSequence contentEndEllipsizeText = InteractCardUIUtil.getContentEndEllipsizeText(context2, textView, contentTail, timeText, 2, i3);
                if (MessageRuntime.GLOBAL_DEBUG) {
                    Log.d(str5, str6 + contentEndEllipsizeText);
                }
                if (this.mTvContent != null && activityNotFinishing()) {
                    this.mTvContent.setText(contentEndEllipsizeText);
                    this.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
                }
                JSONObject jSONObject = formatExt12;
                String str7 = level22;
                JSONObject jSONObject2 = formatExt22;
            } else {
                JSONObject formatExt23 = formatExt2;
                String level23 = level2;
                String level12 = level1;
                String str8 = TAG;
                String str9 = "contentEndEllipsizeText:";
                JSONObject formatExt13 = formatExt1;
                this.mLlOriginalGroup.setVisibility(0);
                if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                    contentText2 = level23;
                } else {
                    contentText2 = str3 + this.mAggregatedCount + "个人" + level23;
                }
                JSONObject formatExt24 = formatExt23;
                String str10 = level23;
                SpannableStringBuilder contentRichText = getRichText(this.mTvContent, placeHolder + contentText2, level2Prefix, formatExt24, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f));
                String str11 = str8;
                JSONObject formatExt14 = formatExt13;
                CharSequence contentEndEllipsizeText2 = InteractCardUIUtil.getContentEndEllipsizeText(this.mContext, this.mTvContent, getTialContent(contentRichText, formatExt24, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f)), timeText, 1, this.mContentGroupWidth);
                if (MessageRuntime.GLOBAL_DEBUG) {
                    Log.d(str11, str9 + contentEndEllipsizeText2);
                }
                if (this.mTvContent != null && activityNotFinishing()) {
                    this.mTvContent.setText(contentEndEllipsizeText2);
                    this.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
                }
                JSONObject formatExt15 = formatExt14;
                String str12 = str11;
                JSONObject jSONObject3 = formatExt24;
                SpannableStringBuilder spannableStringBuilder = contentRichText;
                CharSequence endEllipsizeText = InteractCardUIUtil.getEndEllipsizeText(this.mContext, this.mTvOriginalText, getTialContent(getRichText(this.mTvOriginalText, level12, level1Prefix, formatExt15, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f)), formatExt15, (int) (FontSizeHelper.getScaledRatio(0) * 12.0f)), 1, this.mContentGroupWidth);
                if (MessageRuntime.GLOBAL_DEBUG) {
                    Log.d(str12, "endEllipsizeText:" + endEllipsizeText);
                }
                if (this.mTvOriginalText != null && activityNotFinishing()) {
                    this.mTvOriginalText.setText(endEllipsizeText);
                    this.mTvOriginalText.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            if ((TextUtils.equals("zan", this.mAction) || TextUtils.equals("zan_comment", this.mAction) || TextUtils.equals(ACTION_ZAN_COMMENT_REPLY, this.mAction)) && (!this.mIsAggregated || this.mAggregatedCount <= 0)) {
                handleZanThanks();
                return;
            } else {
                this.mInteractGratitudeFrameButton.setVisibility(8);
                return;
            }
        }
        this.mLlOriginalGroup.setVisibility(8);
        String level13 = this.mTextInfo.optString("level1", "");
        if (this.mIsAggregated && this.mAggregatedCount > 0) {
            if (this.mAggregatedInfo == null || TextUtils.equals("follow", this.mAction)) {
                if (this.mAggregatedCount == i2) {
                    str3 = "";
                }
                nicknameFix = str3;
            } else {
                nicknameFix = this.mAggregatedInfo.optString("nickname", "") + str3;
            }
            contentText = nicknameFix + this.mAggregatedCount + "个人" + level13;
        } else if (this.mUserInfo == null || TextUtils.equals("follow", this.mAction)) {
            contentText = level13;
        } else {
            contentText = this.mUserInfo.optString("nickname", "") + level13;
        }
        String str13 = str;
        CharSequence contentEndEllipsizeText3 = InteractCardUIUtil.getContentEndEllipsizeText(this.mContext, this.mTvContent, placeHolder + contentText, timeText, 2, this.mContentGroupWidth);
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(str13, str2 + contentEndEllipsizeText3);
        }
        this.mTvContent.setText(contentEndEllipsizeText3);
        this.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void handleZanThanks() {
        this.mInteractGratitudeFrameButton.setVisibility(0);
        this.mInteractOneClickGratitude.setVisibility(0);
        this.mInteractGratitudeLoading.setVisibility(8);
        if (this.hasThanks == 1) {
            this.mInteractOneClickGratitude.setPadding(DeviceUtil.ScreenInfo.dp2px(this.mContext, 5.0f), 0, 0, 0);
            this.mInteractOneClickGratitude.setText("已感谢，去聊天");
            this.mInteractGratitudeRight.setVisibility(0);
            this.mInteractGratitudeImage.setVisibility(8);
        } else {
            this.mInteractOneClickGratitude.setPadding(0, 0, 0, 0);
            this.mInteractOneClickGratitude.setText("私信感谢");
            this.mInteractGratitudeRight.setVisibility(8);
            this.mInteractGratitudeImage.setVisibility(0);
        }
        this.mInteractGratitudeFrameButton.setOnTouchListener(new InteractCardUpgradeView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$handleZanThanks$0$com-baidu-searchbox-card-InteractCardUpgradeView  reason: not valid java name */
    public /* synthetic */ boolean m16680lambda$handleZanThanks$0$combaidusearchboxcardInteractCardUpgradeView(View v, MotionEvent event) {
        handleOnTouchEvent(event);
        return true;
    }

    private void handleOnTouchEvent(MotionEvent event) {
        if (event != null && !this.isLoading) {
            if (event.getAction() == 1 || event.getAction() == 3) {
                this.mInteractGratitudeFrameButton.setAlpha(1.0f);
                if (event.getAction() == 1) {
                    this.isLoading = true;
                    String uk = this.mUserInfo.optString("uk", "");
                    final String nickname = this.mUserInfo.optString("nickname", "");
                    final String uid = Utility.transBDUK(uk);
                    if (this.hasThanks == 1) {
                        if (TextUtils.isEmpty(this.mUserPaid)) {
                            InteractionUtils.getContactorPauid(this.mContext, uid, new UserIdentityCallback() {
                                public void onSuccess(int userIdentity, String paid) {
                                    InteractionUserHelper.getInstance().updateUserIdentityById(uid, paid);
                                    String unused = InteractCardUpgradeView.this.mUserPaid = paid;
                                    InteractCardUpgradeView interactCardUpgradeView = InteractCardUpgradeView.this;
                                    interactCardUpgradeView.openConversationPage(uid, nickname, interactCardUpgradeView.mUserPaid, "yiganxie");
                                }
                            });
                        } else {
                            openConversationPage(uid, nickname, this.mUserPaid, "yiganxie");
                        }
                        this.isLoading = false;
                    } else if (!RequsetNetworkUtils.isConnected(MessageRuntime.getAppContext())) {
                        UniversalToast.makeText(MessageRuntime.getAppContext(), R.string.push_subscribe_setting_network_error).showToast();
                        this.isLoading = false;
                        return;
                    } else {
                        this.mInteractOneClickGratitude.setVisibility(8);
                        this.mInteractGratitudeRight.setVisibility(8);
                        this.mInteractGratitudeImage.setVisibility(8);
                        this.mInteractGratitudeLoading.setVisibility(0);
                        JSONObject param = new JSONObject();
                        try {
                            param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_ID, this.mData.getMsg().getMsgId());
                            param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_PA_UID, this.mData.getMsg().getContacter());
                            param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_OPERATE_BD_UID, uid);
                        } catch (Exception e2) {
                        }
                        TimeOutRunnable timeOutRunnable = new TimeOutRunnable(this, this.mContext, 0);
                        this.runnable = timeOutRunnable;
                        UiThreadUtils.runOnUiThread(timeOutRunnable, 4000);
                        BIMManager.sendMsgReplaceByServer(this.mContext, param.toString(), 1, new ZanInteractGratitudeCallback(this.mContext, this));
                        InteractionUtils.setClickZone2Map(this.mTrackParamsMap, "ganxie");
                        InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(this.mAction), "5", "msg_click", this.mTrackParamsMap);
                    }
                    hideRedDot(this.mViewRedDotTip, this.mData, this.mPushAttrs, true);
                }
            } else if (event.getAction() == 0) {
                this.mInteractGratitudeFrameButton.setAlpha(0.2f);
            }
        }
    }

    private static class ZanInteractGratitudeCallback implements BIMValueCallBack {
        /* access modifiers changed from: private */
        public Context mContext;
        private WeakReference<InteractCardUpgradeView> mReference;

        private ZanInteractGratitudeCallback(Context context, InteractCardUpgradeView interactCardUpgradeView) {
            this.mReference = new WeakReference<>(interactCardUpgradeView);
            this.mContext = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = (com.baidu.searchbox.card.InteractCardUpgradeView) r0.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(final int r4, final java.lang.String r5, java.lang.Object r6) {
            /*
                r3 = this;
                java.lang.ref.WeakReference<com.baidu.searchbox.card.InteractCardUpgradeView> r0 = r3.mReference
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.Object r0 = r0.get()
                com.baidu.searchbox.card.InteractCardUpgradeView r0 = (com.baidu.searchbox.card.InteractCardUpgradeView) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                com.baidu.searchbox.card.InteractCardUpgradeView$TimeOutRunnable r1 = r0.runnable
                if (r1 == 0) goto L_0x001f
                android.os.Handler r1 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                com.baidu.searchbox.card.InteractCardUpgradeView$TimeOutRunnable r2 = r0.runnable
                r1.removeCallbacks(r2)
            L_0x001f:
                com.baidu.searchbox.card.InteractCardUpgradeView$ZanInteractGratitudeCallback$1 r1 = new com.baidu.searchbox.card.InteractCardUpgradeView$ZanInteractGratitudeCallback$1
                r1.<init>(r0, r5, r4)
                com.baidu.android.util.concurrent.UiThreadUtils.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.card.InteractCardUpgradeView.ZanInteractGratitudeCallback.onResult(int, java.lang.String, java.lang.Object):void");
        }
    }

    private static class SayHelloInteractCallback implements BIMValueCallBack {
        private Context mContext;
        private WeakReference<InteractCardUpgradeView> mReference;

        private SayHelloInteractCallback(Context context, InteractCardUpgradeView interactCardUpgradeView) {
            this.mReference = new WeakReference<>(interactCardUpgradeView);
            this.mContext = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = (com.baidu.searchbox.card.InteractCardUpgradeView) r0.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(final int r4, final java.lang.String r5, java.lang.Object r6) {
            /*
                r3 = this;
                java.lang.ref.WeakReference<com.baidu.searchbox.card.InteractCardUpgradeView> r0 = r3.mReference
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.Object r0 = r0.get()
                com.baidu.searchbox.card.InteractCardUpgradeView r0 = (com.baidu.searchbox.card.InteractCardUpgradeView) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                com.baidu.searchbox.card.InteractCardUpgradeView$TimeOutRunnable r1 = r0.runnable
                if (r1 == 0) goto L_0x001f
                android.os.Handler r1 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                com.baidu.searchbox.card.InteractCardUpgradeView$TimeOutRunnable r2 = r0.runnable
                r1.removeCallbacks(r2)
            L_0x001f:
                com.baidu.searchbox.card.InteractCardUpgradeView$SayHelloInteractCallback$1 r1 = new com.baidu.searchbox.card.InteractCardUpgradeView$SayHelloInteractCallback$1
                r1.<init>(r0, r5, r4)
                com.baidu.android.util.concurrent.UiThreadUtils.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.card.InteractCardUpgradeView.SayHelloInteractCallback.onResult(int, java.lang.String, java.lang.Object):void");
        }
    }

    private String handleOriginalPortrait() {
        float portraitViewWidth;
        StringBuilder placeHolder = new StringBuilder();
        if (!this.mIsAggregated || this.mUserInfoArray == null) {
            this.mHorizontalImgView.setVisibility(8);
            return placeHolder.toString();
        }
        List<Uri> avatarLinksArray = new ArrayList<>();
        for (int i2 = 0; i2 < this.mUserInfoArray.length(); i2++) {
            if (i2 != 0 || TextUtils.equals(this.mAction, "visitor") || TextUtils.equals(this.mAction, "vote")) {
                avatarLinksArray.add(Uri.parse(this.mUserInfoArray.optJSONObject(i2).optString("portrait")));
                if (avatarLinksArray.size() == 3) {
                    break;
                }
            }
        }
        this.mHorizontalImgView.loadImagesUri(avatarLinksArray);
        this.mHorizontalImgView.setVisibility(0);
        String portraitPlaceHolder = "";
        if (avatarLinksArray.size() < 2) {
            this.mHorizontalImgView.setVisibility(8);
            return portraitPlaceHolder;
        }
        if (avatarLinksArray.size() == 2) {
            portraitViewWidth = InteractCardUIUtil.dp2px(this.mContext, 31.0f);
            if (!TextUtils.isEmpty(sPlaceHolderDoublePortrait)) {
                return sPlaceHolderDoublePortrait;
            }
        } else {
            portraitViewWidth = InteractCardUIUtil.dp2px(this.mContext, 44.0f);
            if (!TextUtils.isEmpty(sPlaceHolderThreePortrait)) {
                return sPlaceHolderThreePortrait;
            }
        }
        while (this.mTvContent.getPaint().measureText(portraitPlaceHolder) < portraitViewWidth) {
            try {
                portraitPlaceHolder = portraitPlaceHolder + " ";
            } catch (Exception e2) {
            }
        }
        if (avatarLinksArray.size() == 2) {
            sPlaceHolderDoublePortrait = portraitPlaceHolder;
        } else {
            sPlaceHolderThreePortrait = portraitPlaceHolder;
        }
        return portraitPlaceHolder;
    }

    private SpannableStringBuilder getRichText(TextView textView, String contentText, String contentTextPrefix, JSONObject contentFormatExt, int textSize) {
        String str = contentText;
        SpannableStringBuilder ssb = new SpannableStringBuilder("");
        if (TextUtils.isEmpty(contentText) && contentFormatExt == null) {
            return ssb;
        }
        if (contentFormatExt != null) {
            ForwardCommentInfo pushInfo = ForwardCommentInfo.parse(contentFormatExt);
            Paint paint = new Paint();
            paint.setTextSize(textView.getTextSize());
            if ((2.0f * ((float) textView.getMeasuredWidth())) - (textView.getTextSize() * 8.0f) < paint.measureText(contentText)) {
                return richFormat(textView, contentTextPrefix, contentText, pushInfo, textSize);
            }
            return richFormat(textView, contentTextPrefix, contentText, pushInfo, textSize);
        }
        String str2 = contentTextPrefix;
        TextView textView2 = textView;
        ssb.append(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, this.mContext, contentTextPrefix + contentText, textView));
        return ssb;
    }

    /* access modifiers changed from: protected */
    public SpannableStringBuilder richFormat(TextView textView, String prefix, String text, ForwardCommentInfo pushInfo, int textSize) {
        SpannableString contentBuilder;
        InteractCardRichTextFormatter richTextFormatter = new InteractCardRichTextFormatter(this.mContext);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(prefix)) {
            builder = new SpannableStringBuilder(prefix);
        }
        SpannableString contentBuilder2 = new SpannableString(text);
        richTextFormatter.formatContentForEmotion(contentBuilder2, text, textView, this.mContext);
        if (pushInfo == null) {
            return builder.append(contentBuilder2);
        }
        if (!TextUtils.isEmpty(text) || !TextUtils.isEmpty(prefix)) {
            contentBuilder = contentBuilder2;
        } else {
            contentBuilder = SpannableString.valueOf(" ");
        }
        SpannableString temp = richTextFormatter.formatContentForForwardComment(textView, pushInfo, contentBuilder, textSize, true);
        if (temp != null) {
            return builder.append(temp);
        }
        return builder.append(contentBuilder);
    }

    private SpannableStringBuilder getTialContent(SpannableStringBuilder richText, JSONObject format, int textSize) {
        JSONArray tailLabels;
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(richText == null ? "" : richText);
        try {
            JSONArray tailLabels2 = format.optJSONArray("tail_label");
            if (tailLabels2 == null || tailLabels2.length() == 0) {
                return stringBuilder;
            }
            int i2 = 0;
            while (i2 < tailLabels2.length()) {
                JSONObject jsonObject = (JSONObject) tailLabels2.get(i2);
                if (jsonObject == null) {
                    tailLabels = tailLabels2;
                } else {
                    final int commentType = jsonObject.optInt("comment_type", 0);
                    if (commentType == 310 || commentType == 309) {
                        final String schema = jsonObject.optString("schema", "");
                        String text = jsonObject.optString("text", "");
                        stringBuilder.append(text);
                        Drawable drawable = null;
                        boolean nightMode = NightModeHelper.getNightModeSwitcherState();
                        if (commentType == 309) {
                            drawable = ContextCompat.getDrawable(this.mContext, nightMode ? R.drawable.im_richtext_icon_view_video_night : R.drawable.im_richtext_icon_view_video);
                        } else if (commentType == 310) {
                            drawable = ContextCompat.getDrawable(this.mContext, nightMode ? R.drawable.im_richtext_icon_view_pk_night : R.drawable.im_richtext_icon_view_pk);
                        }
                        if (drawable == null) {
                            tailLabels = tailLabels2;
                        } else {
                            stringBuilder.setSpan(new TextWithCompoundDrawableSpan(FontSizeHelper.getScaledDrawable(0, drawable), DeviceUtils.ScreenInfo.dp2px(this.mContext, 1.0f), DeviceUtils.ScreenInfo.dp2px(this.mContext, 1.0f), DeviceUtils.ScreenInfo.dp2px(this.mContext, 1.0f), textSize, ContextCompat.getColor(this.mContext, R.color.IC252)), stringBuilder.length() - text.length(), stringBuilder.length(), 33);
                            if (!TextUtils.isEmpty(schema)) {
                                tailLabels = tailLabels2;
                                stringBuilder.setSpan(new ClickableSpan() {
                                    public void onClick(View widget) {
                                        int i2 = commentType;
                                        if (i2 == 309) {
                                            InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "video");
                                        } else if (i2 == 310) {
                                            InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "pk");
                                        }
                                        InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                                        Router.invoke(InteractCardUpgradeView.this.mContext, schema);
                                    }
                                }, stringBuilder.length() - text.length(), stringBuilder.length(), 33);
                            } else {
                                tailLabels = tailLabels2;
                            }
                        }
                    } else {
                        tailLabels = tailLabels2;
                    }
                }
                i2++;
                tailLabels2 = tailLabels;
            }
            return stringBuilder;
        } catch (Exception e2) {
            if (MessageRuntime.GLOBAL_DEBUG) {
                android.util.Log.d(TAG, "makeTailLabel fail:" + e2.getMessage());
            }
        }
    }

    private void handleData2BottomBtn(JSONObject jsonContent) {
        this.mIvLikeBtnIcon.setImageResource(R.drawable.icon_interact_item_like);
        this.mIvReplyBtnIcon.setImageResource(R.drawable.icon_interact_item_reply);
        if (TextUtils.isEmpty(this.mAction)) {
            this.mLlButtomBtnGroup.setVisibility(8);
            return;
        }
        JSONObject interact = jsonContent.optJSONObject("interact_ext");
        if (interact == null) {
            this.mLlButtomBtnGroup.setVisibility(8);
            return;
        }
        JSONObject bottomBars = interact.optJSONObject("bottom_bars");
        if (bottomBars == null) {
            this.mLlButtomBtnGroup.setVisibility(8);
            return;
        }
        this.mLlButtomBtnGroup.setVisibility(0);
        JSONObject like = bottomBars.optJSONObject("zan");
        if (like != null) {
            this.mZanStatus = like.optInt("click_status");
            modifyZanStatus(like);
        }
        final JSONObject reply = bottomBars.optJSONObject("reply");
        if (reply != null) {
            if (!TextUtils.isEmpty(reply.optString("scheme", ""))) {
                this.mLlReplyBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "huifu");
                        InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                        InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, true);
                        Router.invoke(InteractCardUpgradeView.this.mContext, reply.optString("scheme", ""));
                    }
                });
            } else {
                this.mLlReplyBtn.setOnClickListener((View.OnClickListener) null);
            }
        }
        this.mLlLikeBtn.setOnTouchListener(this.mOnTouchListener);
        this.mLlReplyBtn.setOnTouchListener(this.mOnTouchListener);
    }

    private void modifyZanStatus(JSONObject like) {
        switch (this.mZanStatus) {
            case 1:
                this.mIvLikeBtnIcon.setImageResource(R.drawable.icon_interact_item_like_checked);
                this.mTvLikeBtnText.setTextColor(this.mContext.getResources().getColor(R.color.like_text_color));
                break;
            default:
                this.mIvLikeBtnIcon.setImageResource(R.drawable.icon_interact_item_like);
                this.mTvLikeBtnText.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC105));
                break;
        }
        final CardNetwork.CardNetworkListener listener = new CardNetwork.CardNetworkListener() {
            public void onSuccess(String result, int i2) {
                if (i2 == 0 || i2 == InteractCardUpgradeView.DYNAMIC_ERRNO) {
                    if (InteractCardUpgradeView.this.mZanStatus == 0) {
                        InteractCardUpgradeView.this.mIvLikeBtnIcon.setImageResource(R.drawable.icon_interact_item_like_checked);
                        int unused = InteractCardUpgradeView.this.mZanStatus = 1;
                        InteractCardUpgradeView.this.mTvLikeBtnText.setTextColor(InteractCardUpgradeView.this.mContext.getResources().getColor(R.color.like_text_color));
                        InteractCardUpgradeView.this.modifyClickStatus(CardDataEventType.LIKE_EVENT, 1);
                        return;
                    }
                    InteractCardUpgradeView.this.mIvLikeBtnIcon.setImageResource(R.drawable.icon_interact_item_like);
                    int unused2 = InteractCardUpgradeView.this.mZanStatus = 0;
                    InteractCardUpgradeView.this.mTvLikeBtnText.setTextColor(InteractCardUpgradeView.this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC105));
                    InteractCardUpgradeView.this.modifyClickStatus(CardDataEventType.LIKE_EVENT, 0);
                } else if (InteractCardUpgradeView.this.mZanStatus == 1) {
                    InteractCardUpgradeView.this.showToast(R.string.undo_like_fail);
                } else {
                    InteractCardUpgradeView.this.showToast(R.string.like_fail);
                }
            }

            public void onFail() {
                if (InteractCardUpgradeView.this.mZanStatus == 1) {
                    InteractCardUpgradeView.this.showToast(R.string.undo_like_fail);
                } else {
                    InteractCardUpgradeView.this.showToast(R.string.like_fail);
                }
            }
        };
        if (TextUtils.equals(this.mAction, "@")) {
            final String nid = like.optString("id", "");
            final JSONObject ext = new JSONObject();
            try {
                ext.put("source", "im");
                ext.put("sfrom", "im");
                ext.put("type", "feed");
                ext.put("operation", "like");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mLlLikeBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String like;
                    InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, false);
                    InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "dianzan");
                    InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                    if (!NetWorkUtils.isNetworkConnected()) {
                        InteractCardUpgradeView.this.showToast(com.baidu.searchbox.account.userinfo.R.string.net_error);
                        return;
                    }
                    if (InteractCardUpgradeView.this.mZanStatus == 0) {
                        like = "1";
                    } else {
                        like = "0";
                    }
                    CardNetwork.dynamicUpRequest(InteractCardUpgradeView.this.mContext, listener, nid, ext.toString(), like);
                }
            });
            return;
        }
        final String topicId = like.optString("topic_id", "");
        final String replyId = like.optString("reply_id", "");
        this.mLlLikeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String undoType;
                InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, false);
                InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "dianzan");
                InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                if (!NetWorkUtils.isNetworkConnected()) {
                    InteractCardUpgradeView.this.showToast(com.baidu.searchbox.account.userinfo.R.string.net_error);
                    return;
                }
                if (InteractCardUpgradeView.this.mZanStatus == 0) {
                    undoType = null;
                } else {
                    undoType = "1";
                }
                Map<String, String> params = new HashMap<>();
                params.put("topic_id", topicId);
                params.put("reply_id", replyId);
                params.put("type", "1");
                params.put("undo_type", undoType);
                params.put("source", "im");
                params.put("from", "im");
                JSONObject strategyInfoJson = new JSONObject();
                try {
                    strategyInfoJson.put("pb", "message_center");
                } catch (JSONException e2) {
                    if (MessageRuntime.GLOBAL_DEBUG) {
                        android.util.Log.e(InteractCardUpgradeView.TAG, "strategyInfo create fail:" + e2.getMessage());
                    }
                }
                params.put("strategy_info", strategyInfoJson.toString());
                CardNetwork.commentUpRequest(InteractCardUpgradeView.this.mContext, listener, params);
            }
        });
    }

    private void handleData2RightContentDefault() {
        if (!TextUtils.isEmpty(this.mAction)) {
            String cover = null;
            JSONObject jSONObject = this.mSourceInfo;
            if (jSONObject != null) {
                cover = jSONObject.optString("cover", "");
                String schema = this.mSourceInfo.optString("schema", "");
            }
            if (this.mIsAggregated && this.mAggregatedCount > 0) {
                setDefaultStyle();
                if ("follow".equals(this.mAction)) {
                    this.mFlRightButton.setVisibility(0);
                    this.mFlOriginalImage.setVisibility(8);
                    this.mTvRightButtonText.setText("去看看");
                    this.mFlRightButton.setOnClickListener(getOnGoLooKClickListener());
                } else if (ACTION_GENGXINTIXING.equals(this.mAction)) {
                    this.mFlRightButton.setVisibility(0);
                    this.mFlOriginalImage.setVisibility(8);
                    this.mTvRightButtonText.setText("去更新");
                    this.mFlRightButton.setOnClickListener(getOnUpdateClickListener());
                } else {
                    this.mFlRightButton.setVisibility(8);
                    this.mFlOriginalImage.setVisibility(0);
                    if (TextUtils.isEmpty(this.mCover)) {
                        this.mIvOriginalImage.setImageURI(cover);
                    } else {
                        this.mIvOriginalImage.setImageURI(this.mCover);
                    }
                    if (this.mIsVideo || MessageType.isVideoMessage(this.mOriginalTemplate, this.mTemplate)) {
                        this.mIvOriginalImageVideoTag.setVisibility(0);
                        this.mIvOriginalImageVideoTag.setImageResource(R.drawable.icon_interact_original_image_video);
                        return;
                    }
                    this.mIvOriginalImageVideoTag.setVisibility(8);
                }
            } else if (!"follow".equals(this.mAction) && !ACTION_GENGXINTIXING.equals(this.mAction)) {
                this.mFlRightButton.setVisibility(8);
                this.mFlOriginalImage.setVisibility(0);
                if (TextUtils.isEmpty(this.mCover)) {
                    this.mIvOriginalImage.setImageURI(cover);
                } else {
                    this.mIvOriginalImage.setImageURI(this.mCover);
                }
                if (this.mIsVideo || MessageType.isVideoMessage(this.mOriginalTemplate, this.mTemplate)) {
                    this.mIvOriginalImageVideoTag.setVisibility(0);
                    this.mIvOriginalImageVideoTag.setImageResource(R.drawable.icon_interact_original_image_video);
                    return;
                }
                this.mIvOriginalImageVideoTag.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleData2RightContent() {
        if (!TextUtils.isEmpty(this.mAction)) {
            String cover = null;
            JSONObject jSONObject = this.mSourceInfo;
            if (jSONObject != null) {
                cover = jSONObject.optString("cover", "");
                String schema = this.mSourceInfo.optString("schema", "");
            }
            setDefaultStyle();
            if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                if ("follow".equals(this.mAction)) {
                    this.mFlRightButton.setVisibility(0);
                    this.mFlOriginalImage.setVisibility(8);
                    int i2 = this.mFollowRelation;
                    if (i2 == 2) {
                        this.mTvRightButtonText.setText(RecommendFollowUtils.TEXT_RE_FOLLOW);
                    } else if (i2 != 1 && i2 != 3) {
                        this.mTvRightButtonText.setText("关注");
                    } else if (this.hasGreet == 1) {
                        this.mTvRightButtonText.setText(RecommendFollowUtils.TEXT_OPEN_CHAT);
                    } else {
                        setNewExpressionStyle();
                        this.mTvRightButtonText.setText(RecommendFollowUtils.TEXT_GREET);
                    }
                    int i3 = this.mFollowRelation;
                    if (i3 == 1 || i3 == 3) {
                        this.mFlRightButton.setOnClickListener(getOnConversationClickListener());
                    } else {
                        this.mFlRightButton.setOnClickListener(getOnFollowClickListener());
                    }
                } else if (ACTION_GENGXINTIXING.equals(this.mAction)) {
                    this.mFlRightButton.setVisibility(0);
                    this.mFlOriginalImage.setVisibility(8);
                    this.mTvRightButtonText.setText("去更新");
                    this.mFlRightButton.setOnClickListener(getOnUpdateClickListener());
                } else {
                    this.mFlRightButton.setVisibility(8);
                    this.mFlOriginalImage.setVisibility(0);
                    if (TextUtils.isEmpty(this.mCover)) {
                        this.mIvOriginalImage.setImageURI(cover);
                    } else {
                        this.mIvOriginalImage.setImageURI(this.mCover);
                    }
                    if (this.mIsVideo || MessageType.isVideoMessage(this.mOriginalTemplate, this.mTemplate)) {
                        this.mIvOriginalImageVideoTag.setVisibility(0);
                        this.mIvOriginalImageVideoTag.setImageResource(R.drawable.icon_interact_original_image_video);
                        return;
                    }
                    this.mIvOriginalImageVideoTag.setVisibility(8);
                }
            } else if ("follow".equals(this.mAction)) {
                this.mFlRightButton.setVisibility(0);
                this.mFlOriginalImage.setVisibility(8);
                this.mTvRightButtonText.setText("去看看");
                this.mFlRightButton.setOnClickListener(getOnGoLooKClickListener());
            } else if (ACTION_GENGXINTIXING.equals(this.mAction)) {
                this.mFlRightButton.setVisibility(0);
                this.mFlOriginalImage.setVisibility(8);
                this.mTvRightButtonText.setText("去更新");
                this.mFlRightButton.setOnClickListener(getOnUpdateClickListener());
            } else {
                this.mFlRightButton.setVisibility(8);
                this.mFlOriginalImage.setVisibility(0);
                if (TextUtils.isEmpty(this.mCover)) {
                    this.mIvOriginalImage.setImageURI(cover);
                } else {
                    this.mIvOriginalImage.setImageURI(this.mCover);
                }
                if (this.mIsVideo || MessageType.isVideoMessage(this.mOriginalTemplate, this.mTemplate)) {
                    this.mIvOriginalImageVideoTag.setVisibility(0);
                    this.mIvOriginalImageVideoTag.setImageResource(R.drawable.icon_interact_original_image_video);
                    return;
                }
                this.mIvOriginalImageVideoTag.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setDefaultStyle() {
        this.mInteractSayHelloImage.setVisibility(8);
        this.mTvRightButtonText.setPadding(0, 0, 0, 0);
        this.mTvRightButtonText.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.BC60));
        this.mTvRightButtonText.getLayoutParams().width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 57.0f);
        this.mFlRightButton.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.follow_button_shape_upgrade));
    }

    /* access modifiers changed from: private */
    public void setNewExpressionStyle() {
        this.mInteractSayHelloImage.setVisibility(0);
        this.mTvRightButtonText.setPadding(DeviceUtil.ScreenInfo.dp2px(this.mContext, 4.0f), 0, DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f), 0);
        this.mTvRightButtonText.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mTvRightButtonText.getLayoutParams().width = -2;
        this.mFlRightButton.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.message_interact_thanks_gc_99));
    }

    /* access modifiers changed from: private */
    public View.OnClickListener getOnConversationClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if (InteractCardUpgradeView.this.mUserInfo != null) {
                    InteractCardUpgradeView.this.sayHelloInteract();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void sayHelloInteract() {
        if (!NetWorkUtils.isNetworkConnected()) {
            showToast(com.baidu.searchbox.account.userinfo.R.string.net_error);
            return;
        }
        this.mFlRightButton.setAlpha(1.0f);
        String uk = this.mUserInfo.optString("uk", "");
        final String nickname = this.mUserInfo.optString("nickname", "");
        final String uid = Utility.transBDUK(uk);
        if (this.hasGreet != 1) {
            this.mFlRightButton.setClickable(false);
            this.mFlRightButton.setEnabled(false);
            this.mPbRightButtonLoading.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.progress_bar_animate_interact));
            this.mPbRightButtonLoading.setVisibility(0);
            this.mTvRightButtonText.setVisibility(8);
            this.mInteractSayHelloImage.setVisibility(8);
            JSONObject param = new JSONObject();
            try {
                param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_ID, this.mData.getMsg().getMsgId());
                param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_PA_UID, this.mData.getMsg().getContacter());
                param.put(IMSendGratitudeMsg.KEY_GRATITUDE_MSG_OPERATE_BD_UID, uid);
            } catch (Exception e2) {
            }
            TimeOutRunnable timeOutRunnable = new TimeOutRunnable(this, this.mContext, 1);
            this.runnable = timeOutRunnable;
            UiThreadUtils.runOnUiThread(timeOutRunnable, 4000);
            BIMManager.sendMsgReplaceByServer(this.mContext, param.toString(), 2, new SayHelloInteractCallback(this.mContext, this));
            InteractionUtils.setClickZone2Map(this.mTrackParamsMap, "button3");
            InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(this.mAction), "5", "msg_click", this.mTrackParamsMap);
        } else if (TextUtils.isEmpty(this.mUserPaid)) {
            InteractionUtils.getContactorPauid(this.mContext, uid, new UserIdentityCallback() {
                public void onSuccess(int userIdentity, String paid) {
                    InteractionUserHelper.getInstance().updateUserIdentityById(uid, paid);
                    String unused = InteractCardUpgradeView.this.mUserPaid = paid;
                    InteractCardUpgradeView interactCardUpgradeView = InteractCardUpgradeView.this;
                    interactCardUpgradeView.openConversationPage(uid, nickname, interactCardUpgradeView.mUserPaid, "button4");
                }
            });
        } else {
            openConversationPage(uid, nickname, this.mUserPaid, "button4");
        }
    }

    private View.OnClickListener getOnFollowClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "button0");
                InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, false);
                InteractCardUpgradeView.this.requestFollow();
            }
        };
    }

    private View.OnClickListener getOnUpdateClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "button2");
                InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, true);
                if (!TextUtils.isEmpty(InteractCardUpgradeView.this.mSchema)) {
                    Router.invoke(InteractCardUpgradeView.this.mContext, InteractCardUpgradeView.this.mSchema);
                } else if (InteractCardUpgradeView.this.mTextInfo != null) {
                    Router.invoke(InteractCardUpgradeView.this.mContext, InteractCardUpgradeView.this.mTextInfo.optString("schema", ""));
                }
            }
        };
    }

    private View.OnClickListener getOnGoLooKClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "button1");
                InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, true);
                if (!TextUtils.isEmpty(InteractCardUpgradeView.this.mSchema)) {
                    Router.invoke(InteractCardUpgradeView.this.mContext, InteractCardUpgradeView.this.mSchema);
                } else if (InteractCardUpgradeView.this.mTextInfo != null) {
                    Router.invoke(InteractCardUpgradeView.this.mContext, InteractCardUpgradeView.this.mTextInfo.optString("schema", ""));
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void openConversationPage(String uid, String nickname, String paid, String zone) {
        InteractionUtils.setClickZone2Map(this.mTrackParamsMap, zone);
        InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(this.mAction), "5", "msg_click", this.mTrackParamsMap);
        if (TextUtils.isEmpty(paid) || TextUtils.equals(InteractionUtils.PAID_NULL, paid)) {
            IMPluginHelper.invokeChat(uid, nickname, 0, "2", new IMPluginHelper.Callback() {
                public void onResult(int statusCode) {
                }
            });
            return;
        }
        CambrianPluginHelper.invokeChat(paid, nickname, "2", (IMPluginHelper.Callback) new IMPluginHelper.Callback() {
            public void onResult(int statusCode) {
            }
        }, (IChatInvokeListener[]) null, uid);
    }

    /* access modifiers changed from: private */
    public void requestFollow() {
        String uk;
        if (!NetWorkUtils.isNetworkConnected()) {
            showToast(com.baidu.searchbox.account.userinfo.R.string.net_error);
            return;
        }
        this.mFlRightButton.setClickable(false);
        this.mFlRightButton.setEnabled(false);
        this.mFlRightButton.setAlpha(1.0f);
        this.mPbRightButtonLoading.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.interact_follow_button_progress_loading));
        this.mPbRightButtonLoading.setVisibility(0);
        this.mTvRightButtonText.setVisibility(8);
        this.mInteractSayHelloImage.setVisibility(8);
        FollowManager followManager = (FollowManager) ServiceManager.getService(FollowManager.SERVICE_REFERENCE);
        if (followManager != null) {
            FollowRequestCallback requestCallback = new FollowRequestCallback() {
                /* JADX WARNING: Removed duplicated region for block: B:21:0x00dc A[Catch:{ JSONException -> 0x0132 }] */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x00ee A[Catch:{ JSONException -> 0x0132 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onSuccess(java.lang.String r14, int r15) {
                    /*
                        r13 = this;
                        com.baidu.searchbox.card.InteractCardUpgradeView r0 = com.baidu.searchbox.card.InteractCardUpgradeView.this
                        android.widget.ProgressBar r0 = r0.mPbRightButtonLoading
                        r1 = 8
                        r0.setVisibility(r1)
                        com.baidu.searchbox.card.InteractCardUpgradeView r0 = com.baidu.searchbox.card.InteractCardUpgradeView.this
                        android.widget.RelativeLayout r0 = r0.mFlRightButton
                        r1 = 1
                        r0.setClickable(r1)
                        com.baidu.searchbox.card.InteractCardUpgradeView r0 = com.baidu.searchbox.card.InteractCardUpgradeView.this
                        android.widget.RelativeLayout r0 = r0.mFlRightButton
                        r0.setEnabled(r1)
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0132 }
                        r0.<init>(r14)     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r2 = "errno"
                        int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r3 = "data"
                        org.json.JSONObject r3 = r0.optJSONObject(r3)     // Catch:{ JSONException -> 0x0132 }
                        if (r2 != 0) goto L_0x011b
                        r4 = 0
                        com.baidu.searchbox.card.InteractCardUpgradeView r6 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        org.json.JSONObject r6 = r6.mUserInfo     // Catch:{ JSONException -> 0x0132 }
                        if (r6 == 0) goto L_0x0057
                        com.baidu.searchbox.card.InteractCardUpgradeView r6 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        org.json.JSONObject r6 = r6.mUserInfo     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r7 = "uk"
                        java.lang.String r8 = ""
                        java.lang.String r6 = r6.optString(r7, r8)     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r7 = "baiduuid_"
                        java.lang.String r6 = com.baidu.searchbox.account.utils.SocialEncodeUtils.getSocialDecrypt(r6, r7)     // Catch:{ JSONException -> 0x0132 }
                        long r6 = java.lang.Long.parseLong(r6)     // Catch:{ JSONException -> 0x0132 }
                        r4 = r6
                        r11 = r4
                        goto L_0x0058
                    L_0x0057:
                        r11 = r4
                    L_0x0058:
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = r4.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        if (r4 == 0) goto L_0x008d
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = r4.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        if (r4 != r1) goto L_0x0069
                        goto L_0x008d
                    L_0x0069:
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = r4.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        r5 = 2
                        r6 = 3
                        if (r4 == r5) goto L_0x007b
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = r4.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        if (r4 != r6) goto L_0x009e
                    L_0x007b:
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int unused = r4.mFollowRelation = r6     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.TextView r4 = r4.mTvTitleTag     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r5 = "互相关注"
                        r4.setText(r5)     // Catch:{ JSONException -> 0x0132 }
                        goto L_0x009e
                    L_0x008d:
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int unused = r4.mFollowRelation = r1     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.TextView r4 = r4.mTvTitleTag     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r5 = "已关注"
                        r4.setText(r5)     // Catch:{ JSONException -> 0x0132 }
                    L_0x009e:
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.model.CardDataEventType r5 = com.baidu.searchbox.card.model.CardDataEventType.FOLLOW_EVENT     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r6 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r6 = r6.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        r4.modifyClickStatus(r5, r6)     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.content.Context r4 = r4.mContext     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r5 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.android.imsdk.notification.NotificationMsgData r5 = r5.mData     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.android.imsdk.chatmessage.messages.ChatMsg r5 = r5.getMsg()     // Catch:{ JSONException -> 0x0132 }
                        long r5 = r5.getMsgId()     // Catch:{ JSONException -> 0x0132 }
                        r9 = 2
                        com.baidu.searchbox.card.InteractCardUpgradeView r7 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r10 = r7.mFollowRelation     // Catch:{ JSONException -> 0x0132 }
                        r7 = r11
                        com.baidu.android.imsdk.box.IMBoxManager.setInterActiveMsgStatus(r4, r5, r7, r9, r10)     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.TextView r4 = r4.mTvRightButtonText     // Catch:{ JSONException -> 0x0132 }
                        r5 = 0
                        r4.setVisibility(r5)     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = r4.hasGreet     // Catch:{ JSONException -> 0x0132 }
                        if (r4 != r1) goto L_0x00ee
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        r1.setDefaultStyle()     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.TextView r1 = r1.mTvRightButtonText     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r4 = "去聊天"
                        r1.setText(r4)     // Catch:{ JSONException -> 0x0132 }
                        goto L_0x00ff
                    L_0x00ee:
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        r1.setNewExpressionStyle()     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.TextView r1 = r1.mTvRightButtonText     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r4 = "打招呼"
                        r1.setText(r4)     // Catch:{ JSONException -> 0x0132 }
                    L_0x00ff:
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.widget.RelativeLayout r1 = r1.mFlRightButton     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r4 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        android.view.View$OnClickListener r4 = r4.getOnConversationClickListener()     // Catch:{ JSONException -> 0x0132 }
                        r1.setOnClickListener(r4)     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        r1.requestUserIdentity()     // Catch:{ JSONException -> 0x0132 }
                        com.baidu.searchbox.card.InteractCardUpgradeView r1 = com.baidu.searchbox.card.InteractCardUpgradeView.this     // Catch:{ JSONException -> 0x0132 }
                        int r4 = com.baidu.searchbox.push.R.string.follow_success     // Catch:{ JSONException -> 0x0132 }
                        r1.showToast(r4)     // Catch:{ JSONException -> 0x0132 }
                        goto L_0x0131
                    L_0x011b:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0132 }
                        r1.<init>()     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r4 = "errno is fail："
                        java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ JSONException -> 0x0132 }
                        java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ JSONException -> 0x0132 }
                        java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0132 }
                        r13.onFailure(r1)     // Catch:{ JSONException -> 0x0132 }
                    L_0x0131:
                        goto L_0x013c
                    L_0x0132:
                        r0 = move-exception
                        r0.printStackTrace()
                        java.lang.String r1 = "json parse fail"
                        r13.onFailure(r1)
                    L_0x013c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.card.InteractCardUpgradeView.AnonymousClass17.onSuccess(java.lang.String, int):void");
                }

                public void onFailure(String result) {
                    InteractCardUpgradeView.this.mFlRightButton.setClickable(true);
                    InteractCardUpgradeView.this.mFlRightButton.setEnabled(true);
                    InteractCardUpgradeView.this.mTvRightButtonText.setVisibility(0);
                    InteractCardUpgradeView.this.mPbRightButtonLoading.setVisibility(8);
                    InteractCardUpgradeView.this.showToast(R.string.follow_fail);
                }
            };
            JSONObject ext = new JSONObject();
            try {
                ext.put("get_is_friend", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONObject jSONObject = this.mUserInfo;
            if (jSONObject != null) {
                uk = jSONObject.optString("uk", "");
            } else {
                uk = "";
            }
            JSONObject strategyInfoJson = new JSONObject();
            try {
                strategyInfoJson.put("pb", "message_center");
            } catch (JSONException e3) {
                if (MessageRuntime.GLOBAL_DEBUG) {
                    android.util.Log.e(TAG, "strategyInfo create fail:" + e3.getMessage());
                }
            }
            FollowManager followManager2 = followManager;
            String str = uk;
            followManager2.singleFollowRequest(this.mContext, true, "ugc", str, "message", "sbox", ext.toString(), strategyInfoJson.toString(), requestCallback);
        }
    }

    protected static void handleRedDotUI(RedDotAnimView redDotAnimView, NotificationMsgData data, PushAttrs attrs) {
        if (redDotAnimView != null) {
            if (data == null || attrs == null) {
                redDotAnimView.setVisibility(4);
                return;
            }
            ChatMsg chatMsg = data.getMsg();
            if (chatMsg == null) {
                redDotAnimView.setVisibility(4);
            } else if (chatMsg.isMsgRead()) {
                redDotAnimView.setVisibility(4);
                PushAttrs.sRedDotAnimPlayedMap.remove(Long.valueOf(chatMsg.getMsgId()));
            } else {
                if (!(PushAttrs.sRedDotAnimPlayedMap.containsKey(Long.valueOf(chatMsg.getMsgId())) ? PushAttrs.sRedDotAnimPlayedMap.get(Long.valueOf(chatMsg.getMsgId())).booleanValue() : false)) {
                    redDotAnimView.startAnim();
                    PushAttrs.sRedDotAnimPlayedMap.put(Long.valueOf(chatMsg.getMsgId()), true);
                } else {
                    redDotAnimView.configFinalAnimStatus();
                }
                redDotAnimView.setVisibility(0);
            }
        }
    }

    private void handleItemViewClick(JSONObject jsonContent) {
        if (this.mLlInteractItem != null) {
            final String schema = getItemSchema();
            View.OnClickListener onClickListener = new View.OnClickListener() {
                public void onClick(View v) {
                    InteractCardUpgradeView.hideRedDot(InteractCardUpgradeView.this.mViewRedDotTip, InteractCardUpgradeView.this.mData, InteractCardUpgradeView.this.mPushAttrs, true);
                    if (v.getId() == R.id.interact_item_fl_avatar_group) {
                        InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "touxiang");
                    } else if (v.getId() == R.id.interact_item_fl_original_image) {
                        InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "youtu");
                    } else {
                        InteractionUtils.setClickZone2Map(InteractCardUpgradeView.this.mTrackParamsMap, "");
                    }
                    InteractionUpgradeUBCUtil.interactItemUBCEvent(InteractionUpgradeParamsUtil.changeAction2Type(InteractCardUpgradeView.this.mAction), "5", "msg_click", InteractCardUpgradeView.this.mTrackParamsMap);
                    Router.invoke(InteractCardUpgradeView.this.mContext, schema);
                }
            };
            this.mLlInteractItem.setOnClickListener(onClickListener);
            this.mFlAvatarGroup.setOnClickListener(onClickListener);
            this.mFlOriginalImage.setOnClickListener(onClickListener);
            this.mTvContent.setOnClickListener(onClickListener);
            this.mTvOriginalText.setOnClickListener(onClickListener);
            this.mFlAvatarGroup.setOnTouchListener(this.mOnTouchListener);
            this.mFlOriginalImage.setOnTouchListener(this.mOnTouchListener);
            this.mFlRightButton.setOnTouchListener(this.mOnTouchListener);
            this.mTvContent.setOnTouchListener(this.mOnTouchListener);
            this.mTvOriginalText.setOnTouchListener(this.mOnTouchListener);
        }
    }

    private String getItemSchema() {
        String schema = this.mSchema;
        if (!TextUtils.isEmpty(schema) && !"null".equalsIgnoreCase(schema)) {
            return schema;
        }
        if ("follow".equals(this.mAction)) {
            if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
                JSONObject jSONObject = this.mUserInfo;
                if (jSONObject != null) {
                    return !TextUtils.isEmpty(jSONObject.optString("homepage", "")) ? this.mUserInfo.optString("homepage", "") : this.mUserInfo.optString("schema", "");
                }
                return null;
            }
            JSONObject jSONObject2 = this.mAggregatedInfo;
            if (jSONObject2 != null) {
                return jSONObject2.optString("schema", "");
            }
            return null;
        } else if (TextUtils.equals(ACTION_GENGXINTIXING, this.mAction)) {
            JSONObject jSONObject3 = this.mTextInfo;
            if (jSONObject3 != null) {
                return jSONObject3.optString("schema", "");
            }
            return null;
        } else {
            int i2 = this.mTemplate;
            if (i2 == 1) {
                JSONObject jSONObject4 = this.mSourceInfo;
                if (jSONObject4 != null) {
                    schema = jSONObject4.optString("schema", "");
                }
                if (!TextUtils.isEmpty(schema)) {
                    return schema;
                }
                JSONObject jSONObject5 = this.mTextInfo;
                if (jSONObject5 != null) {
                    return jSONObject5.optString("schema1", "");
                }
                return null;
            } else if (i2 == 2) {
                JSONObject jSONObject6 = this.mTextInfo;
                if (jSONObject6 != null) {
                    schema = jSONObject6.optString("schema1", "");
                }
                if (!TextUtils.isEmpty(schema)) {
                    return schema;
                }
                JSONObject jSONObject7 = this.mTextInfo;
                if (jSONObject7 != null) {
                    return jSONObject7.optString("schema2", "");
                }
                return null;
            } else if (i2 == 4) {
                JSONObject jSONObject8 = this.mSourceInfo;
                if (jSONObject8 != null) {
                    schema = jSONObject8.optString("schema2", "");
                }
                if (!TextUtils.isEmpty(schema)) {
                    return schema;
                }
                JSONObject jSONObject9 = this.mTextInfo;
                if (jSONObject9 != null) {
                    return jSONObject9.optString("schema1", "");
                }
                return null;
            } else {
                JSONObject jSONObject10 = this.mTextInfo;
                if (jSONObject10 == null) {
                    return null;
                }
                String schema2 = jSONObject10.optString("schema1", "");
                if (TextUtils.isEmpty(schema2)) {
                    return this.mTextInfo.optString("schema", "");
                }
                return schema2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handleItemLongClickListener(final NotificationMsgData data, View... viewArr) {
        if (viewArr != null && viewArr.length > 0) {
            for (View view2 : viewArr) {
                if (view2 != null) {
                    view2.setOnLongClickListener(new View.OnLongClickListener() {
                        public boolean onLongClick(View v) {
                            BottomCommonMenuItem userMenuItem;
                            BottomCommonMenuItem articleMenuItem;
                            String str;
                            String str2;
                            BottomCommonMenuItem typeMenuItem;
                            String str3;
                            String str4;
                            List<BottomCommonMenuItem> items = new ArrayList<>();
                            String str5 = "bjh";
                            if (InteractShieldRelationUtils.checkCanShieldType(InteractCardUpgradeView.this.mData)) {
                                if (InteractShieldRelationUtils.isTypeHadShield(InteractCardUpgradeView.this.mData)) {
                                    String tip = "";
                                    if (TextUtils.equals(InteractCardUpgradeView.this.mAction, "visitor")) {
                                        tip = InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_can_receive_visitor_type_interact);
                                    } else if (TextUtils.equals(InteractCardUpgradeView.this.mAction, InteractCardUpgradeView.ACTION_GENGXINTIXING)) {
                                        tip = InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_can_receive_gengxintixing_type_interact);
                                    }
                                    typeMenuItem = new BottomCommonMenuItem(6, tip, true);
                                    String source = "";
                                    if (TextUtils.equals(InteractCardUpgradeView.this.mAction, "visitor")) {
                                        source = "receive_visitor";
                                    } else if (TextUtils.equals(InteractCardUpgradeView.this.mAction, InteractCardUpgradeView.ACTION_GENGXINTIXING)) {
                                        source = "receive_update";
                                    }
                                    if (MessageUtils.isBusinessAccount()) {
                                        str4 = str5;
                                    } else {
                                        str4 = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, source, str4, "IM", "show");
                                } else {
                                    String tip2 = "";
                                    if (TextUtils.equals(InteractCardUpgradeView.this.mAction, "visitor")) {
                                        tip2 = InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_do_not_receive_visitor_type_interact);
                                    } else if (TextUtils.equals(InteractCardUpgradeView.this.mAction, InteractCardUpgradeView.ACTION_GENGXINTIXING)) {
                                        tip2 = InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_do_not_receive_gengxintixing_type_interact);
                                    }
                                    typeMenuItem = new BottomCommonMenuItem(3, tip2, true);
                                    String source2 = "";
                                    if (TextUtils.equals(InteractCardUpgradeView.this.mAction, "visitor")) {
                                        source2 = "reject_visitor";
                                    } else if (TextUtils.equals(InteractCardUpgradeView.this.mAction, InteractCardUpgradeView.ACTION_GENGXINTIXING)) {
                                        source2 = "reject_update";
                                    }
                                    if (MessageUtils.isBusinessAccount()) {
                                        str3 = str5;
                                    } else {
                                        str3 = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, source2, str3, "IM", "show");
                                }
                                items.add(typeMenuItem);
                            }
                            if (InteractShieldRelationUtils.checkCanShieldArticle(InteractCardUpgradeView.this.mData)) {
                                if (InteractShieldRelationUtils.isArticleHadShield(InteractCardUpgradeView.this.mData)) {
                                    articleMenuItem = new BottomCommonMenuItem(4, InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_can_receive_article_interact), true);
                                    if (MessageUtils.isBusinessAccount()) {
                                        str2 = str5;
                                    } else {
                                        str2 = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, "receive_works", str2, "IM", "show");
                                } else {
                                    articleMenuItem = new BottomCommonMenuItem(1, InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_do_not_receive_article_interact), true);
                                    if (MessageUtils.isBusinessAccount()) {
                                        str = str5;
                                    } else {
                                        str = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, "reject_works", str, "IM", "show");
                                }
                                items.add(articleMenuItem);
                            }
                            if (InteractShieldRelationUtils.checkCanShieldUser(InteractCardUpgradeView.this.mData)) {
                                if (InteractShieldRelationUtils.isUserHadShield(InteractCardUpgradeView.this.mData)) {
                                    userMenuItem = new BottomCommonMenuItem(5, InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_can_receive_user_interact), true);
                                    if (!MessageUtils.isBusinessAccount()) {
                                        str5 = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, "reject_user", str5, "IM", "show");
                                } else {
                                    userMenuItem = new BottomCommonMenuItem(2, InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_do_not_receive_user_interact), true);
                                    if (!MessageUtils.isBusinessAccount()) {
                                        str5 = "c_user";
                                    }
                                    MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, "receive_user", str5, "IM", "show");
                                }
                                items.add(userMenuItem);
                            }
                            items.add(new BottomCommonMenuItem(0, InteractCardUpgradeView.this.getResources().getString(R.string.my_notify_delete), true));
                            new BottomListMenu(InteractCardUpgradeView.this.getContext(), v, (String) null, items, (List<? extends BottomCustomMenuItem>) null, new BottomListMenu.ItemClickListener() {
                                public void onItemClick(int i2) {
                                    if (i2 == 0) {
                                        InteractCardUpgradeView.this.showDelConfirmDialog(data);
                                    } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 4 || i2 == 6) {
                                        InteractCardUpgradeView.this.requestSettingShield(i2);
                                    }
                                }
                            }).showView();
                            return true;
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void showDelConfirmDialog(final NotificationMsgData data) {
        new BdDialog.Builder().setContext(this.mContext).setTitle("温馨提示").setMessage("确定删除该条互动通知").setButton(new BdDialog.BottomItem(this.mContext.getResources().getString(R.string.interaction_message_shield_dialog_cancel), new BdDialog.OnItemClickListener() {
            public void onItemClick(View view2) {
            }
        })).setButton(new BdDialog.BottomItem((CharSequence) this.mContext.getResources().getString(R.string.interaction_message_shield_dialog_confirm), com.baidu.android.common.ui.style.R.color.GC7, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
            public void onItemClick(View view2) {
                InteractCardUpgradeView.this.doDeleteNotifyAction(data);
            }
        })).show();
    }

    /* access modifiers changed from: private */
    public void requestSettingShield(int cmdId) {
        int shieldState;
        int shieldBusiness;
        String interactAction;
        String interactResourceId;
        String interactUid;
        String actionName;
        int i2 = cmdId;
        String actionName2 = "";
        if (this.mContext != null) {
            String interactUid2 = actionName2;
            String interactResourceId2 = actionName2;
            String interactAction2 = actionName2;
            String statisticSource = actionName2;
            try {
                JSONObject jsonContent = new JSONObject(this.mData.getMsg().getJsonContent());
                if (i2 == 1) {
                    statisticSource = "reject_works";
                    interactUid = interactUid2;
                    interactResourceId = InteractShieldRelationUtils.getNid(jsonContent);
                    interactAction = interactAction2;
                    shieldBusiness = 11;
                    shieldState = 1;
                } else if (i2 == 2) {
                    statisticSource = "reject_user";
                    interactUid = InteractShieldRelationUtils.getUid(jsonContent);
                    interactResourceId = interactResourceId2;
                    interactAction = interactAction2;
                    shieldBusiness = 10;
                    shieldState = 1;
                } else if (i2 == 3) {
                    String str = this.mAction;
                    String interactAction3 = str;
                    if (TextUtils.equals(str, "visitor")) {
                        statisticSource = "reject_visitor";
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction3;
                        shieldBusiness = 12;
                        shieldState = 1;
                        interactUid = interactUid2;
                    } else if (TextUtils.equals(this.mAction, ACTION_GENGXINTIXING)) {
                        statisticSource = "reject_update";
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction3;
                        shieldBusiness = 12;
                        shieldState = 1;
                        interactUid = interactUid2;
                    } else {
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction3;
                        shieldBusiness = 12;
                        shieldState = 1;
                        interactUid = interactUid2;
                    }
                } else if (i2 == 4) {
                    statisticSource = "receive_works";
                    interactUid = interactUid2;
                    interactResourceId = InteractShieldRelationUtils.getNid(jsonContent);
                    interactAction = interactAction2;
                    shieldBusiness = 11;
                    shieldState = 0;
                } else if (i2 == 5) {
                    statisticSource = "receive_user";
                    interactUid = InteractShieldRelationUtils.getUid(jsonContent);
                    interactResourceId = interactResourceId2;
                    interactAction = interactAction2;
                    shieldBusiness = 10;
                    shieldState = 0;
                } else if (i2 == 6) {
                    String str2 = this.mAction;
                    String interactAction4 = str2;
                    if (TextUtils.equals(str2, "visitor")) {
                        statisticSource = "receive_visitor";
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction4;
                        shieldBusiness = 12;
                        shieldState = 0;
                        interactUid = interactUid2;
                    } else if (TextUtils.equals(this.mAction, ACTION_GENGXINTIXING)) {
                        statisticSource = "receive_update";
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction4;
                        shieldBusiness = 12;
                        shieldState = 0;
                        interactUid = interactUid2;
                    } else {
                        interactResourceId = interactResourceId2;
                        interactAction = interactAction4;
                        shieldBusiness = 12;
                        shieldState = 0;
                        interactUid = interactUid2;
                    }
                } else {
                    return;
                }
                MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, statisticSource, MessageUtils.isBusinessAccount() ? "bjh" : "c_user", "IM", "click");
                final String finalInteractUid = interactUid;
                final String finalInteractResourceId = interactResourceId;
                CharSequence charSequence = "visitor";
                final String finalInteractAction = interactAction;
                String str3 = actionName2;
                if (i2 == 4 || i2 == 5) {
                    String str4 = statisticSource;
                } else if (i2 == 6) {
                    String str5 = statisticSource;
                } else {
                    if (i2 == 1) {
                        actionName = "将不再继续接收该作品的点赞、评论、收藏等互动通知";
                    } else if (i2 == 2) {
                        actionName = "将不再继续接收\"" + InteractShieldRelationUtils.getNickname(jsonContent) + "\"的点赞、评论、收藏等互动通知";
                    } else {
                        if (TextUtils.equals(this.mAction, charSequence)) {
                            actionName2 = "\"主页访客\"";
                        } else if (TextUtils.equals(this.mAction, ACTION_GENGXINTIXING)) {
                            actionName2 = "\"更新提醒\"";
                        }
                        actionName = "将不再继续接收" + actionName2 + "的相关通知";
                    }
                    final String finalStatisticSource = statisticSource;
                    String str6 = statisticSource;
                    final int i3 = shieldBusiness;
                    final int i4 = shieldState;
                    new BdDialog.Builder().setContext(this.mContext).setTitle("温馨提示").setMessage(actionName).setButton(new BdDialog.BottomItem(this.mContext.getResources().getString(R.string.interaction_message_shield_dialog_cancel), new BdDialog.OnItemClickListener() {
                        public void onItemClick(View view2) {
                        }
                    })).setButton(new BdDialog.BottomItem((CharSequence) this.mContext.getResources().getString(R.string.interaction_message_shield_dialog_confirm), com.baidu.android.common.ui.style.R.color.GC7, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
                        public void onItemClick(View view2) {
                            MessageStatisticUtils.statisticUserShield(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, finalStatisticSource, MessageUtils.isBusinessAccount() ? "bjh" : "c_user", "IM", "confirm_click");
                            InteractCardUpgradeView.this.setInteractShield(i3, i4, finalInteractUid, finalInteractResourceId, finalInteractAction);
                        }
                    })).show();
                    return;
                }
                setInteractShield(shieldBusiness, shieldState, finalInteractUid, finalInteractResourceId, finalInteractAction);
            } catch (Exception e2) {
                if (MessageRuntime.GLOBAL_DEBUG) {
                    Log.e(TAG, "requestSettingShield error: " + e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setInteractShield(final int shieldBusiness, final int shieldState, String interactUid, String interactResourceId, String interactAction) {
        if (!RequsetNetworkUtils.isConnected(MessageRuntime.getAppContext())) {
            UniversalToast.makeText(MessageRuntime.getAppContext(), (CharSequence) this.mContext.getResources().getString(R.string.interaction_message_shield_net_error)).showToast();
            return;
        }
        int i2 = shieldBusiness;
        int i3 = shieldState;
        IMBoxManager.setInteractShield(this.mContext, 0, shieldBusiness, 0, shieldState, interactUid, interactResourceId, interactAction, new IStatusListener() {
            public void onResult(int i2, String s, int i1, long l) {
                if (i2 == 0) {
                    if (shieldState == 0) {
                        UniversalToast.makeText(MessageRuntime.getAppContext(), (CharSequence) InteractCardUpgradeView.this.mContext.getResources().getString(R.string.interaction_message_do_not_shield_success)).showToast();
                    }
                    InteractShieldRelationUtils.refreshShieldStateData(shieldState, shieldBusiness, InteractCardUpgradeView.this.mData);
                    BdEventBus.Companion.getDefault().post(new ShieldStateRefreshEvent());
                    return;
                }
                UniversalToast.makeText(MessageRuntime.getAppContext(), (CharSequence) InteractCardUpgradeView.this.mContext.getResources().getString(R.string.interaction_message_shield_setting_error)).showToast();
            }
        });
    }

    protected static void hideRedDot(RedDotAnimView redDotAnimView, NotificationMsgData data, PushAttrs attrs, boolean jumpToPage) {
        if (redDotAnimView != null) {
            if (data == null || attrs == null) {
                redDotAnimView.setVisibility(4);
                return;
            }
            ChatMsg chatMsg = data.getMsg();
            if (chatMsg == null) {
                redDotAnimView.setVisibility(4);
                return;
            }
            redDotAnimView.setVisibility(4);
            if (jumpToPage) {
                PushAttrs.sJumpClickedRedDotHiddenEvent = true;
            } else {
                PushAttrs.sJumpClickedRedDotHiddenEvent = false;
            }
            chatMsg.setMsgReaded(1);
            ExecutorUtilsExt.postOnSerial(new InteractCardUpgradeView$$ExternalSyntheticLambda1(chatMsg), "set_msg_read");
        }
    }

    static /* synthetic */ void lambda$hideRedDot$1(ChatMsg chatMsg) {
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "hideRedDot set_msg_read");
        }
        if (setMsgHasRead(chatMsg.getMsgId())) {
            ImMsgReceiverListener.handleNotificationMsg();
        }
        BdEventBus.Companion.getDefault().post(new PushNotifyBaseFragment.SingleNotifyMsgRedDotEvent(chatMsg.getMsgId() + ""));
    }

    private static boolean setMsgHasRead(long msgId) {
        return IMBoxManager.setMsgReadByMsgId(AppRuntime.getAppContext(), msgId, 1);
    }

    /* access modifiers changed from: private */
    public void doDeleteNotifyAction(final NotificationMsgData data) {
        PushNotifyUBCUtil.pushDetailUBCEvent(PushNotifyParamsUtil.switchUBCTypeByChatId(this.mContext, data), PushNotifyParamsUtil.switchUBCPageByChatId(data), "5", "press", this.mTrackParamsMap);
        final ChatMsg chatMsg = data == null ? null : data.getMsg();
        if (chatMsg != null) {
            chatMsg.setMsgReaded(1);
            PushAttrs.sJumpClickedRedDotHiddenEvent = false;
            ImMsgReceiverListener.handleNotificationMsg();
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    if (BIMManager.deleteMsgs(InteractCardUpgradeView.this.mContext, chatMsg.getContacter(), new long[]{chatMsg.getMsgId()}, false) < 0) {
                        MessageUtils.showNetOrCommonErrorToast();
                        return;
                    }
                    PushNotifyUBCUtil.pushDetailUBCEvent(PushNotifyParamsUtil.switchUBCTypeByChatId(InteractCardUpgradeView.this.mContext, data), PushNotifyParamsUtil.switchUBCPageByChatId(data), "5", "delete", InteractCardUpgradeView.this.mTrackParamsMap);
                    BdEventBus.Companion.getDefault().post(new PushNotifyBaseFragment.DelNotifyMsgEvent(chatMsg.getMsgId() + ""));
                    ImMsgReceiverListener.handleNotificationMsg();
                }
            }, "NotifyItemDelTask", 1);
        }
    }

    /* access modifiers changed from: private */
    public void modifyClickStatus(CardDataEventType type, int value) {
        JSONObject jSONObject;
        try {
            if (type == CardDataEventType.LIKE_EVENT) {
                BdEventBus.Companion.getDefault().post(new CardDataEvent(type, this.mData.getMsg().getMsgId() + "", value, this.mTag));
            }
            if (type == CardDataEventType.FOLLOW_EVENT && (jSONObject = this.mUserInfo) != null) {
                BdEventBus.Companion.getDefault().post(new CardDataEvent(type, jSONObject.optString("uk", ""), value, this.mTag));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void showToast(int id) {
        UniversalToast.makeText(this.mContext).setText(this.mContext.getResources().getText(id)).showToast();
    }

    /* access modifiers changed from: protected */
    public boolean activityNotFinishing() {
        Context context = this.mContext;
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    private void handleUserIdentity() {
        if (this.mUserInfo == null || !TextUtils.equals("follow", this.mAction)) {
            return;
        }
        if (!this.mIsAggregated || this.mAggregatedCount <= 0) {
            int relationFollow = this.mUserInfo.optInt("relation_follow");
            if (relationFollow == 3 || relationFollow == 1) {
                requestUserIdentity();
            }
        }
    }

    /* access modifiers changed from: private */
    public void requestUserIdentity() {
        JSONObject jSONObject = this.mUserInfo;
        if (jSONObject != null) {
            final String uid = Utility.transBDUK(jSONObject.optString("uk", ""));
            String paid = InteractionUserHelper.getInstance().getUserIdentityById(uid);
            if (!TextUtils.isEmpty(paid)) {
                this.mUserPaid = paid;
            } else {
                InteractionUtils.getContactorPauid(this.mContext, uid, new UserIdentityCallback() {
                    public void onSuccess(int userIdentity, String paid) {
                        InteractionUserHelper.getInstance().updateUserIdentityById(uid, paid);
                        String unused = InteractCardUpgradeView.this.mUserPaid = paid;
                    }
                });
            }
        }
    }
}
