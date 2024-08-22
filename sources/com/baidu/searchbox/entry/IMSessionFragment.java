package com.baidu.searchbox.entry;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alipay.sdk.m.u.i;
import com.baidu.android.ext.widget.BdListPopupWindow;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.KeyboardUtils;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.lcp.sdk.client.BLCPClient;
import com.baidu.lcp.sdk.client.ConnectState;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.IMSharedPrefsWrapper;
import com.baidu.searchbox.MessageStatisticUtils;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.component.AccountMessageLoginView;
import com.baidu.searchbox.account.component.IAccountComponentCallback;
import com.baidu.searchbox.account.im.SelectFriendListActivity;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.fragment.HomeBaseFragment;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.card.model.CardDataEvent;
import com.baidu.searchbox.card.model.CardDataEventType;
import com.baidu.searchbox.comment.definition.CommentCommonInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.imchathn.event.RemoveUnreadDotEvent;
import com.baidu.searchbox.imsdk.IMStateChangeEvent;
import com.baidu.searchbox.imsdk.ImMsgControl;
import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.leadsetting.LeadSettingUtils;
import com.baidu.searchbox.message.cloudconfig.AIRoleBean;
import com.baidu.searchbox.message.cloudconfig.BannerBean;
import com.baidu.searchbox.message.cloudconfig.ChatCommonInfoBean;
import com.baidu.searchbox.message.cloudconfig.ChatCommonInfoManager;
import com.baidu.searchbox.pad.MessagePadAdapter;
import com.baidu.searchbox.push.ImMsgObservable;
import com.baidu.searchbox.push.MessageStatistic;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.MsgCreatorManager;
import com.baidu.searchbox.push.MyMessageAdapter;
import com.baidu.searchbox.push.MyMessageMainState;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.abtest.ImABTestManager;
import com.baidu.searchbox.push.abtest.WeakRemindManager;
import com.baidu.searchbox.push.database.PushMsgControl;
import com.baidu.searchbox.push.mymessagefragment.IMSessionView;
import com.baidu.searchbox.push.mymessagefragment.params.PushAttrs;
import com.baidu.searchbox.push.mymessagefragment.util.ImChatFragmentPerformanceFlowUtil;
import com.baidu.searchbox.push.mymessagefragment.util.PushNotifyPerformanceFlowUtil;
import com.baidu.searchbox.push.notification.NotificationUtils;
import com.baidu.searchbox.push.set.IMParam;
import com.baidu.searchbox.push.set.MsgSetActivity;
import com.baidu.searchbox.push.set.items.MessageDiscoveryUtils;
import com.baidu.searchbox.push.update.model.LeadSettingModel;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.ubc.Flow;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

public class IMSessionFragment extends HomeBaseFragment implements IMSessionView.DependEnvironment {
    private static final int CODE_LOGIN_SUCCESS = 0;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    private static final int EXPAND_WIDTH = 12;
    private static final String IM_CHAT_MESSAGES = "消息";
    public static final String KEY_ARGUMENT_IS_HOME_PAGE = "bar_page";
    public static final String KEY_INVOKE_EXT = "ext";
    public static final String KEY_IS_BAR_FRAGMENT = "bar_fragment";
    private static final int SETTING_LAYOUT_HEIGHT = 81;
    private static final String SETTING_MSG_GROUP_DISCOVERY = "发现群";
    private static final String SETTING_MSG_SETTING = "消息设置";
    private static final String SETTING_MSG_UFO = "帮助反馈";
    private static final String SETTING_START_CHAT = "发起群聊";
    private static final String SETTING_START_CONSULT = "发起咨询";
    public static final String SOURCE = "source";
    public static final String SOURCE_IM_CHAT = "im_win";
    public static final String SUB_TAB = "subTab";
    /* access modifiers changed from: private */
    public static final String TAG = IMSessionFragment.class.getSimpleName();
    public static final int TWO_WEEK = 1209600000;
    public static final String UFO_OL_DEFULT_URL = "https://ufosdk.baidu.com/bailing/getEntryPath/9LC8KnhMN3dMSBnQV6zwwxxjSjoNCIoNz1SUeb3Uuyk=?from=BAIDUIM&paId=";
    public static final String UFO_OL_URL = "https://ufosdk.baidu.com/bailing/getEntryPath/9LC8KnhMN3dMSBnQV6zww8MQxPuKn-LBXajeJdXIym0=?from=BAIDUIM&paId=";
    public static final String UFO_PAID = "17592337567454";
    public static final String UFO_RD_DEFULT_URL = "http://fengling-4.bcc-bdbl.baidu.com:8095/bailing/getEntryPath/bBpEy4dHOnim2cTKJrDwdg==?from=BAIDUIM&paId=";
    public static final String UFO_RD_URL = "http://fengling-4.bcc-bdbl.baidu.com:8095/bailing/getEntryPath/fBlGcoflO7hEvOxV-QoWdA==?from=BAIDUIM&paId=";
    public static Flow mScreenStatisFlow;
    /* access modifiers changed from: private */
    public static IMSharedPrefsWrapper sImPref = IMSharedPrefsWrapper.getInstance();
    private BroadcastReceiver iConnectListener = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && ConnectState.LCP_CONNECTION_BROADCAST.equals(intent.getAction())) {
                if (IMSessionFragment.DEBUG) {
                    Log.d(IMSessionFragment.TAG, "iConnectListener status ：" + intent.getIntExtra(ConnectState.LCP_CONNECTION_STATE, -1));
                }
                IMSessionFragment.this.updateImChatUnreadCount();
            }
        }
    };
    private ImageView mActionBarRightImg;
    private LinearLayout mActionBarRightZone;
    private BadgeView mBadgeView;
    ChatCommonInfoManager.ChatCommonInfoListener mChatCommonInfoListener = new ChatCommonInfoManager.ChatCommonInfoListener() {
        public void onSuccess(ChatCommonInfoBean chatCommonInfoBean) {
            if (chatCommonInfoBean != null) {
                UiThreadUtils.runOnUiThread(new IMSessionFragment$5$$ExternalSyntheticLambda0(this, chatCommonInfoBean));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onSuccess$0$com-baidu-searchbox-entry-IMSessionFragment$5  reason: not valid java name */
        public /* synthetic */ void m18357lambda$onSuccess$0$combaidusearchboxentryIMSessionFragment$5(ChatCommonInfoBean chatCommonInfoBean) {
            if (IMSessionFragment.this.mImSessionView != null) {
                ArrayList<AIRoleBean> aiRoles = chatCommonInfoBean.getAIRoles();
                BannerBean bannerBean = chatCommonInfoBean.getBannerBean();
                if (aiRoles != null && aiRoles.size() > 1) {
                    IMSessionFragment.this.mImSessionView.showAIRoleBanner(aiRoles);
                } else if (bannerBean != null) {
                    IMSessionFragment.this.mImSessionView.showBanner(bannerBean);
                }
            }
        }
    };
    private Observer mImMsgOberver = new Observer() {
        public void update(Observable o, Object arg) {
            IMSessionFragment.this.updateImChatUnreadCount();
        }
    };
    public IMSessionView mImSessionView;
    private boolean mInited = false;
    private String mInvokeExt = "";
    private boolean mIsOnResume;
    private BoxAccountManager mLoginManager;
    private IAccountStatusChangedListener mLoginStatusChangeListener = new IAccountStatusChangedListener() {
        public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
            if (IMSessionFragment.DEBUG) {
                Log.e(IMSessionFragment.TAG, "登录状态改变: oldStatus = " + oldStatus + "，newStatus = " + newStatus);
            }
            IMSessionFragment.this.resetSettingLayout();
            KeyboardUtils.forceHiddenSoftInput(IMSessionFragment.this.mActivity, IMSessionFragment.this.mActivity.getWindow().getDecorView().getWindowToken());
            int i2 = 8;
            if (IMSessionFragment.this.mQuickLoginView != null) {
                IMSessionFragment.this.mQuickLoginView.setVisibility(IMSessionFragment.this.isUserLogin() ? 8 : 0);
            } else if (IMSessionFragment.DEBUG) {
                Log.e(IMSessionFragment.TAG, "mQuickLoginView is null");
            }
            if (IMSessionFragment.this.mImSessionView != null) {
                IMSessionView iMSessionView = IMSessionFragment.this.mImSessionView;
                if (IMSessionFragment.this.isUserLogin()) {
                    i2 = 0;
                }
                iMSessionView.setVisibility(i2);
                IMSessionFragment.this.mImSessionView.onUserLoginStateChanged(IMSessionFragment.this.isUserLogin());
            }
            IMSessionFragment iMSessionFragment = IMSessionFragment.this;
            iMSessionFragment.updateActionBarUIByLoginStatus(iMSessionFragment.isUserLogin());
            if (IMSessionFragment.this.isUserLogin()) {
                UiThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        ChatCommonInfoManager.getInstance().fetchChatCommonInfoFromServer(IMSessionFragment.this.mChatCommonInfoListener);
                    }
                }, 1000);
            }
        }
    };
    private ImageView mNetConnectingImage;
    private final View.OnClickListener mOneClickClearListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (((int) ImMsgControl.getInstance(MessageRuntime.getAppContext()).getImChatUnreadCount(0)) == 0 && WeakRemindManager.getWeakType() == 0) {
                UniversalToast.makeText(IMSessionFragment.this.getContext(), R.string.message_no_unread_msg_now).show();
            } else if (IMSessionFragment.this.mImSessionView != null) {
                IMSessionFragment.this.mImSessionView.setAllReadConfirmDialog();
            }
            MessageStatistic.statisticSetAllRead("msg", "click");
        }
    };
    private int mPushUnreadCount = 0;
    /* access modifiers changed from: private */
    public View mQuickLoginView;
    private ImageView mRightUnreadClearTipView;
    private View mRootView;
    private final String mScheme = "baiduboxapp://swan/vhgNHTCH2cGrbIAdolbmsoRYUtvV2ntj/pages/ask/ask?fr=pay_zd_bdmsgcenter_order";
    public String mSource = "";
    /* access modifiers changed from: private */
    public ViewGroup mSystemNotifySwitchLayout;
    private BadgeView mTitleBadgeView;
    private TextView mTvImTitleView;
    private TextView mTvImUnreadCountView;
    private ImageView mUnreadClearTipView;
    private FrameLayout mViewContainer;
    public int screenMaxItemCount;
    private BroadcastReceiver statusReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject dataObject = new JSONObject(intent.getStringExtra("data"));
                int status = dataObject.optInt("status");
                CardDataEvent cardDataEvent = new CardDataEvent(CardDataEventType.LIKE_EVENT, dataObject.optString("reply_id"), status, hashCode());
                cardDataEvent.setNeedRefresh(true);
                BdEventBus.Companion.getDefault().post(cardDataEvent);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    };
    public int viewPagerHeight;

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public static Fragment newInstance(String source, String invokeExt, boolean isHomePage, Flow flow) {
        mScreenStatisFlow = flow;
        IMSessionFragment imSessionFragment = new IMSessionFragment();
        Bundle arguments = new Bundle();
        arguments.putString("source", source);
        arguments.putString("ext", invokeExt);
        arguments.putBoolean(KEY_ARGUMENT_IS_HOME_PAGE, isHomePage);
        imSessionFragment.setArguments(arguments);
        return imSessionFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "onCreate");
        }
        Flow flow = mScreenStatisFlow;
        if (flow != null) {
            MessageStatisticUtils.addEvent(flow, MessageStatisticUtils.SCREEN_FLOW_FRAGMENT_BEGIN, "");
        }
        boolean isHomePage = true;
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            this.mSource = bundle.getString("source");
            this.mInvokeExt = bundle.getString("ext");
            isHomePage = bundle.getBoolean(KEY_ARGUMENT_IS_HOME_PAGE);
            if (z) {
                Log.d(TAG, "arguments source:" + this.mSource + "; ext:" + this.mInvokeExt);
            }
        }
        this.mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        setHomeFragment(isHomePage);
        super.onCreate(savedInstanceState);
        MsgCreatorManager.getInstance().clearPaInfoMap();
        registerListener();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectState.LCP_CONNECTION_BROADCAST);
        LocalBroadcastManager.getInstance(MessageRuntime.getAppContext()).registerReceiver(this.iConnectListener, filter);
        PushNotifyPerformanceFlowUtil.instanceFlow();
        PushNotifyPerformanceFlowUtil.addEvent("P0");
        ImChatFragmentPerformanceFlowUtil.instanceFlow();
        ImChatFragmentPerformanceFlowUtil.addEvent("P0");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onCreateView");
        }
        if (this.mRootView == null) {
            this.mRootView = inflater.inflate(R.layout.message_center_layout, container, false);
        }
        if (immersionEnabled()) {
            return initImmersionAndApply(this.mRootView, true);
        }
        return this.mRootView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        applyImmersion();
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        super.onViewCreated(view2, savedInstanceState);
        if (DEBUG) {
            Log.d(TAG, "onViewCreated");
        }
        if (!this.mInited) {
            this.mViewContainer = (FrameLayout) this.mRootView.findViewById(R.id.fragment_container);
            MessagePadAdapter.setPaddingStartAndEnd(getActivity(), this.mViewContainer, 125, 125);
            initIMSessionView(savedInstanceState, view2);
            initLoginView();
            this.mInited = true;
        }
    }

    public void onStart() {
        super.onStart();
        if (DEBUG) {
            Log.d(TAG, "onStart");
        }
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onStart();
        }
        MessageUtils.setMsgMainForgroundState(true);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (DEBUG) {
            Log.d(TAG, "setUserVisibleHint setUserVisibleHint:" + isVisibleToUser + ";mIsOnResume:" + this.mIsOnResume);
        }
        if (this.mIsOnResume && isVisibleToUser) {
            applyImmersion();
        }
    }

    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d(TAG, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        }
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onResume();
        }
        View view2 = this.mQuickLoginView;
        if (view2 != null) {
            view2.setVisibility(isUserLogin() ? 8 : 0);
        }
        PushMsgControl.getInstance(MessageRuntime.getAppContext()).clickMyMessageItem();
        this.mIsOnResume = true;
        showLeadSettingDialog();
        MessageUtils.setMsgMainForgroundState(true);
        ChatCommonInfoManager.getInstance().fetchChatCommonInfoFromServer(this.mChatCommonInfoListener);
        IMBoxManager.updateAiUsersFromMsgCenter(getContext().getApplicationContext());
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MessagePadAdapter.setPaddingStartAndEnd(getActivity(), this.mViewContainer, 125, 125);
    }

    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d(TAG, "onPause");
        }
        UniversalToast.cancelToast();
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onPause();
        }
        this.mIsOnResume = false;
        if (isNotifySwitchViewVisible()) {
            hideSystemNotifySwitch();
        }
    }

    public void onStop() {
        super.onStop();
        if (DEBUG) {
            Log.d(TAG, "onStop");
        }
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onStop();
            this.mImSessionView.onHandlerFlow(false);
        }
        MessageUtils.setMsgMainForgroundState(false);
    }

    public void onDestroy() {
        View viewContainer;
        ImageView closeView;
        super.onDestroy();
        if (DEBUG) {
            Log.d(TAG, "onDestroy");
        }
        unregisterListener();
        PushAttrs.resetStaticData();
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onDestroy();
            this.mImSessionView = null;
        }
        View view2 = this.mQuickLoginView;
        if (view2 instanceof AccountMessageLoginView) {
            ((AccountMessageLoginView) view2).destroy();
        }
        ViewGroup viewGroup = this.mSystemNotifySwitchLayout;
        if (!(viewGroup == null || (closeView = (ImageView) viewGroup.findViewById(R.id.system_off_delete)) == null)) {
            closeView.removeCallbacks((Runnable) null);
        }
        View view3 = this.mRootView;
        if (!(view3 == null || (viewContainer = view3.findViewById(R.id.fragment_container)) == null)) {
            viewContainer.removeCallbacks((Runnable) null);
        }
        ChatCommonInfoManager.getInstance().removeChatCommonInfoListener();
        LeadSettingUtils.dismissLeadSettingDialog();
    }

    public void onNightModeChanged(boolean isNightMode) {
        try {
            super.onNightModeChanged(isNightMode);
            matchTheme();
            IMSessionView iMSessionView = this.mImSessionView;
            if (iMSessionView != null) {
                iMSessionView.onNightModeChanged();
            }
            View view2 = this.mQuickLoginView;
            if (view2 instanceof AccountMessageLoginView) {
                ((AccountMessageLoginView) view2).onNightModeChanged();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "Exception: " + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateActionBarUIByLoginStatus(boolean newStatus) {
        LinearLayout linearLayout = this.mActionBarRightZone;
        int i2 = 0;
        if (linearLayout != null) {
            linearLayout.setVisibility(newStatus ? 0 : 8);
        }
        if (isTopBackShow()) {
            ImageView imageView = this.mRightUnreadClearTipView;
            if (imageView != null) {
                if (!newStatus) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mUnreadClearTipView;
        if (imageView2 != null) {
            if (!newStatus) {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void applyImmersion() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "applyImmersion");
        }
        if (immersionEnabled()) {
            if (z) {
                Log.d(TAG, "applyImmersion immersionEnabled");
            }
            Activity activity = getActivity();
            if (activity != null) {
                if (this.mImmersionHelper == null) {
                    this.mImmersionHelper = new ImmersionHelper(activity);
                }
                ImmersionHelper.ImmersionConfig config = this.mImmersionHelper.getConfig();
                config.setUseLightStatusBar(!NightModeHelper.getNightModeSwitcherState());
                config.setIsShowStatusBar(true);
                this.mImmersionHelper.setImmersion();
            } else if (z) {
                Log.d(TAG, WealthVideoYalogConstantKt.YALOG_VALUE_ERROR_MSG_ACTIVITY_NULL);
            }
        }
    }

    private void initIMSessionView(Bundle savedInstanceState, View rootView) {
        ViewGroup container = (ViewGroup) rootView.findViewById(R.id.fragment_container);
        Flow flow = mScreenStatisFlow;
        if (flow != null) {
            MessageStatisticUtils.addEvent(flow, MessageStatisticUtils.SCREEN_FLOW_FRAGMENT_END, "");
        }
        if (this.mImSessionView == null) {
            this.mImSessionView = new IMSessionView(mScreenStatisFlow, this, container);
            if (!TextUtils.isEmpty(this.mInvokeExt)) {
                this.mImSessionView.setInvokeExt(this.mInvokeExt);
            }
            addActionBar(rootView);
            this.mImSessionView.onCreate(savedInstanceState);
        }
        this.mImSessionView.onFirstVisible();
        onFontSizeChange();
        matchTheme();
    }

    private void initLoginView() {
        View view2;
        try {
            FrameLayout frameLayout = this.mViewContainer;
            if (!(frameLayout == null || (view2 = this.mQuickLoginView) == null)) {
                frameLayout.removeView(view2);
                this.mQuickLoginView.setVisibility(8);
                this.mQuickLoginView = null;
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "initLoginView error:" + e2.getMessage());
            }
        }
        MessageStatisticUtils.addEvent(mScreenStatisFlow, MessageStatisticUtils.SCREEN_FLOW_PASS_BEGIN, "");
        this.mLoginManager.getQuickLoginView(this.mActivity, 3, AccountComponentConfig.getQuickLoginParamsBuilder().setLoginSrc("im_bar").setMainTitleText(getString(R.string.account_login_main_title_im)).setOneKeyLoginText(getString(R.string.account_login_main_title_im)).setShareLoginText(getString(R.string.account_login_main_title_im)).setFunctionIconDrawable(getResources().getDrawable(R.drawable.account_message_function_icon)).setFunctionIconNightDrawable(getResources().getDrawable(R.drawable.account_message_function_icon_night)).setSupportGuest(false).build(), new AccountComponentCallback(this));
    }

    /* access modifiers changed from: private */
    public void onLoginViewComponentReady(View loginView) {
        if (this.mQuickLoginView != loginView) {
            this.mQuickLoginView = loginView;
        }
        FrameLayout frameLayout = this.mViewContainer;
        if (frameLayout != null) {
            frameLayout.addView(this.mQuickLoginView);
        }
        View view2 = this.mQuickLoginView;
        int i2 = 8;
        if (view2 != null) {
            view2.setVisibility(isUserLogin() ? 8 : 0);
        }
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            if (isUserLogin()) {
                i2 = 0;
            }
            iMSessionView.setVisibility(i2);
        }
    }

    /* access modifiers changed from: private */
    public void onLoginViewCallbackResult(int resultCode) {
        MessageStatisticUtils.addEvent(mScreenStatisFlow, MessageStatisticUtils.SCREEN_FLOW_PASS_END, resultCode == 0 ? "success" : "fail");
        if (resultCode == 0) {
            MessageStatisticUtils.addEvent(mScreenStatisFlow, MessageStatisticUtils.SCREEN_FLOW_PASS_END, "ready");
        }
    }

    private void registerListener() {
        BdEventBus.Companion.getDefault().register(this, IMStateChangeEvent.class, new Action<IMStateChangeEvent>() {
            public void call(IMStateChangeEvent event) {
                if (IMSessionFragment.DEBUG) {
                    Log.e(IMSessionFragment.TAG, "IMStateChangeEvent:" + event.loginState);
                }
                if (IMSessionFragment.this.mImSessionView != null) {
                    IMSessionFragment.this.mImSessionView.onEvent(event);
                }
            }
        });
        BdEventBus.Companion.getDefault().register(this, RemoveUnreadDotEvent.class, new Action<RemoveUnreadDotEvent>() {
            public void call(RemoveUnreadDotEvent event) {
                if (IMSessionFragment.DEBUG) {
                    Log.e(IMSessionFragment.TAG, "RemoveUnreadDotEvent save");
                }
                if (IMSessionFragment.this.mImSessionView != null) {
                    IMSessionFragment.this.mImSessionView.removeUnreadDot();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CommentCommonInterface.COMMENT_PRAISE_STATUS);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.statusReceiver, intentFilter);
        BoxAccountManager boxAccountManager = this.mLoginManager;
        if (boxAccountManager != null) {
            boxAccountManager.addLoginStatusChangedListener(this.mLoginStatusChangeListener);
        }
    }

    private void unregisterListener() {
        BdEventBus.Companion.getDefault().unregister(this);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.statusReceiver);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.iConnectListener);
        ImMsgObservable.getInstance().getDataObservable().deleteObserver(this.mImMsgOberver);
        BoxAccountManager boxAccountManager = this.mLoginManager;
        if (boxAccountManager != null) {
            boxAccountManager.removeLoginStatusChangedListener(this.mLoginStatusChangeListener);
        }
    }

    private void showLeadSettingDialog() {
        LeadSettingModel settingModel = new LeadSettingModel();
        settingModel.setSource("im_win");
        LeadSettingUtils.openLeadSettingDialog(getActivity(), settingModel, false, new NotificationUtils.ShowDialogCallBack() {
            public void onResult(String result) {
                if ((TextUtils.isEmpty(result) || (!TextUtils.isEmpty(result) && TextUtils.equals(result, "0"))) && !LeadSettingUtils.isLeadSettingDialogShowing() && IMSessionFragment.this.isAlive() && !IMSessionFragment.this.showSystemNotifySwitch()) {
                    IMSessionFragment.this.mImSessionView.showInteractSubscribeWithNoGuide();
                }
            }
        }, new NotificationUtils.BtnClickCallBack() {
            public void onResult(boolean canceled) {
                if (canceled && IMSessionFragment.this.isAlive()) {
                    IMSessionFragment.this.showSystemNotifySwitch();
                }
            }
        });
        showMenuDot();
    }

    private boolean isNotifySwitchViewVisible() {
        ViewGroup viewGroup = this.mSystemNotifySwitchLayout;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public boolean showSystemNotifySwitch() {
        if (!ImABTestManager.isPushTipEnable()) {
            return false;
        }
        if (NotificationUtils.isNotificationEnabled(MessageRuntime.getAppContext()) || !isUserLogin()) {
            ViewGroup viewGroup = this.mSystemNotifySwitchLayout;
            if (viewGroup == null) {
                return false;
            }
            viewGroup.setVisibility(8);
            return false;
        }
        long lastTime = sImPref.getLong(NotificationUtils.KEY_MSG_SYSTEM_NOTIFY_OFF_TIP_TIME, 0);
        final long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= 1209600000) {
            ViewGroup viewGroup2 = this.mSystemNotifySwitchLayout;
            if (viewGroup2 == null) {
                ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.message_system_off_layout);
                if (viewStub == null) {
                    return false;
                }
                ViewGroup viewGroup3 = (ViewGroup) viewStub.inflate();
                this.mSystemNotifySwitchLayout = viewGroup3;
                Button openButton = (Button) viewGroup3.findViewById(R.id.system_off_open);
                TextView tipText = (TextView) this.mSystemNotifySwitchLayout.findViewById(R.id.system_off_tip);
                final ImageView closeView = (ImageView) this.mSystemNotifySwitchLayout.findViewById(R.id.system_off_delete);
                closeView.post(new Runnable() {
                    public void run() {
                        Rect bounds = new Rect();
                        closeView.getHitRect(bounds);
                        bounds.left -= 12;
                        bounds.top -= 12;
                        bounds.right += 12;
                        bounds.bottom += 12;
                        IMSessionFragment.this.mSystemNotifySwitchLayout.setTouchDelegate(new TouchDelegate(bounds, closeView));
                    }
                });
                closeView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (IMSessionFragment.this.mSystemNotifySwitchLayout != null) {
                            IMSessionFragment.this.mSystemNotifySwitchLayout.startAnimation(AnimationUtils.loadAnimation(IMSessionFragment.this.getContext(), R.anim.message_system_off_layout_exit));
                            IMSessionFragment.this.mSystemNotifySwitchLayout.setVisibility(8);
                            IMSessionFragment.sImPref.putLong(NotificationUtils.KEY_MSG_SYSTEM_NOTIFY_OFF_TIP_TIME, currentTime);
                            MessageStatistic.statisticMyMessageNotifyOpenTip(MessageStatistic.UBC_VALUE_MYMESSAGE_CANCEL_CLK);
                        }
                    }
                });
                openButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (MessageRuntime.GLOBAL_DEBUG) {
                            Log.d(IMSessionFragment.TAG, "openNotificationSettingPages");
                        }
                        NotificationUtils.openNotificationSettingPages(IMSessionFragment.this.getActivity());
                        MessageStatistic.statisticMyMessageNotifyOpenTip(MessageStatistic.UBC_VALUE_MYMESSAGE_OPEN_CLK);
                    }
                });
                Resources resources = getResources();
                this.mSystemNotifySwitchLayout.setBackgroundDrawable(resources.getDrawable(R.drawable.message_system_off_new_bg));
                tipText.setText(getString(R.string.message_system_off_tip));
                tipText.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC6));
                closeView.setBackgroundDrawable(resources.getDrawable(R.drawable.system_off_close_bg_selector));
                openButton.setText(getString(R.string.message_system_off_open));
                openButton.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC67));
                openButton.setBackground(resources.getDrawable(R.drawable.system_off_open_bg));
                this.mSystemNotifySwitchLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.message_system_off_layout_enter));
                MessageStatistic.statisticMyMessageNotifyOpenTip(MessageStatistic.UBC_VALUE_MYMESSAGE_TIP_SHOW);
            } else {
                viewGroup2.setVisibility(0);
            }
            return true;
        }
        ViewGroup viewGroup4 = this.mSystemNotifySwitchLayout;
        if (viewGroup4 == null) {
            return false;
        }
        viewGroup4.setVisibility(8);
        return false;
    }

    private void hideSystemNotifySwitch() {
        ViewGroup viewGroup = this.mSystemNotifySwitchLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void goGlobalIMSetActivity() {
        Intent intent = new Intent();
        intent.setClass(getContext(), MsgSetActivity.class);
        Bundle params = new Bundle();
        params.putInt(IMParam.SetParamKey.KEY_TYPE, 0);
        params.putString(IMParam.SetParamKey.KEY_MSG_SET_FROM, IMParam.VALUE_MSG_SET_FROM);
        intent.putExtras(params);
        ActivityUtils.startActivitySafely((Context) getActivity(), intent, false);
        BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
    }

    private void addActionBar(View rootView) {
        View actionbarView = LayoutInflater.from(getContext()).inflate(R.layout.message_center_actionbar_layout, (ViewGroup) null);
        this.mTvImTitleView = (TextView) actionbarView.findViewById(R.id.message_title);
        this.mTvImUnreadCountView = (TextView) actionbarView.findViewById(R.id.message_count);
        this.mUnreadClearTipView = (ImageView) actionbarView.findViewById(R.id.button_erase_unread_messages);
        this.mRightUnreadClearTipView = (ImageView) actionbarView.findViewById(R.id.button_erase_unread_messages_right);
        this.mActionBarRightZone = (LinearLayout) actionbarView.findViewById(R.id.actionbar_right_img_zone);
        this.mActionBarRightImg = (ImageView) actionbarView.findViewById(R.id.img_actionbar_right);
        this.mUnreadClearTipView.setOnClickListener(this.mOneClickClearListener);
        this.mRightUnreadClearTipView.setOnClickListener(this.mOneClickClearListener);
        this.mNetConnectingImage = (ImageView) actionbarView.findViewById(R.id.message_connecting);
        this.mTitleBadgeView = new BadgeView(getContext());
        this.mTvImTitleView.setText("消息");
        LinearLayout.LayoutParams paramsUnRead = new LinearLayout.LayoutParams(-2, -2);
        paramsUnRead.gravity = 48;
        paramsUnRead.topMargin = getResources().getDimensionPixelOffset(R.dimen.in_app_subscribe_update_window_desc_margin_top);
        ((LinearLayout) actionbarView.findViewById(R.id.title_layout)).addView(this.mTitleBadgeView, paramsUnRead);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
        params.gravity = 17;
        params.height = getResources().getDimensionPixelOffset(R.dimen.message_dimens_38dp);
        ((FrameLayout) rootView.findViewById(R.id.lyt_action_bar)).addView(actionbarView, params);
        initActionbar(rootView);
        initBackView();
    }

    private void initBackView() {
        UnifiedTopBarButton backBtn = (UnifiedTopBarButton) this.mRootView.findViewById(R.id.bd_im_back);
        int i2 = 0;
        if (isTopBackShow()) {
            backBtn.setVisibility(0);
            Map<String, Object> ext = new HashMap<>();
            ext.put(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, "im_list");
            backBtn.ubcBackButtonShow("base", "im", ext);
            this.mUnreadClearTipView.setVisibility(8);
            ImageView imageView = this.mRightUnreadClearTipView;
            if (!isUserLogin()) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            return;
        }
        backBtn.setVisibility(8);
        ImageView imageView2 = this.mUnreadClearTipView;
        if (!isUserLogin()) {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
        this.mRightUnreadClearTipView.setVisibility(8);
        boolean isLocatedHomeBar = false;
        if (HomeFourthTabTypeUtils.INSTANCE != null) {
            isLocatedHomeBar = MessageHomeBarManager.INSTANCE.isHomeBar();
        }
        if (!isLocatedHomeBar && (getActivity() instanceof MyMessageMainState)) {
            MessageStatisticUtils.showStatisticUnifiedBackBar((MyMessageMainState) getActivity(), "im_list");
        }
    }

    private void initActionbar(View rootView) {
        final View viewContainer = rootView.findViewById(R.id.fragment_container);
        viewContainer.post(new Runnable() {
            public void run() {
                if (IMSessionFragment.this.getContext() != null) {
                    IMSessionFragment.this.viewPagerHeight = viewContainer.getHeight();
                    int itemHeight = (int) IMSessionFragment.this.getResources().getDimension(R.dimen.message_item_height);
                    IMSessionFragment iMSessionFragment = IMSessionFragment.this;
                    iMSessionFragment.screenMaxItemCount = iMSessionFragment.viewPagerHeight / itemHeight;
                    if (IMSessionFragment.DEBUG) {
                        Log.d(IMSessionFragment.TAG, "viewPagerHeight=" + IMSessionFragment.this.viewPagerHeight + ";itemHeight=" + itemHeight + ";screenMaxItemCount=" + IMSessionFragment.this.screenMaxItemCount);
                    }
                }
            }
        });
        setSettingLayout();
        MessageStatistic.statisticTabShow(MessageStatistic.PAGE_MYMESSAGE_INTERACT_MSG);
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onHandlerFlow(true);
        }
        updateImChatUnreadCount();
        ImMsgObservable.getInstance().getDataObservable().addObserver(this.mImMsgOberver);
        updateActionBarUIByLoginStatus(isUserLogin());
    }

    /* access modifiers changed from: private */
    public void updateImChatUnreadCount() {
        UiThreadUtil.runOnUiThread(new IMSessionFragment$$ExternalSyntheticLambda0(this), 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateImChatUnreadCount$0$com-baidu-searchbox-entry-IMSessionFragment  reason: not valid java name */
    public /* synthetic */ void m18356lambda$updateImChatUnreadCount$0$combaidusearchboxentryIMSessionFragment() {
        int i2;
        try {
            int i3 = 0;
            if (isTopBackShow()) {
                ImageView imageView = this.mRightUnreadClearTipView;
                if (imageView != null) {
                    if (MessageUtils.isAccountLogin()) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    imageView.setVisibility(i2);
                }
            } else {
                ImageView imageView2 = this.mUnreadClearTipView;
                if (imageView2 != null) {
                    imageView2.setVisibility(MessageUtils.isAccountLogin() ? 0 : 8);
                }
            }
            IMSessionView iMSessionView = this.mImSessionView;
            if (iMSessionView != null) {
                iMSessionView.updateNetTips();
            }
            if (RequsetNetworkUtils.isConnected(MessageRuntime.getAppContext())) {
                if (BLCPClient.getLcpConnectState() != -1) {
                    if (BLCPClient.getLcpConnectState() == -2) {
                        BadgeView badgeView = this.mTitleBadgeView;
                        if (badgeView != null) {
                            badgeView.setVisibility(8);
                        }
                        TextView textView = this.mTvImUnreadCountView;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        ImageView imageView3 = this.mNetConnectingImage;
                        if (imageView3 != null) {
                            imageView3.setVisibility(0);
                            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                            rotateAnimation.setInterpolator(new LinearInterpolator());
                            rotateAnimation.setDuration(2000);
                            rotateAnimation.setRepeatCount(-1);
                            this.mNetConnectingImage.startAnimation(rotateAnimation);
                        }
                        TextView textView2 = this.mTvImTitleView;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                            this.mTvImTitleView.setText(R.string.net_title_connecting);
                            return;
                        }
                        return;
                    }
                    TextView textView3 = this.mTvImTitleView;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                        this.mTvImTitleView.setText("消息");
                    }
                    ImageView imageView4 = this.mNetConnectingImage;
                    if (imageView4 != null) {
                        imageView4.setVisibility(8);
                        this.mNetConnectingImage.clearAnimation();
                    }
                    int currentUnreadCount = (int) ImMsgControl.getInstance(MessageRuntime.getAppContext()).getImChatUnreadCount(0);
                    if (currentUnreadCount == -1) {
                        BadgeView badgeView2 = this.mTitleBadgeView;
                        if (badgeView2 != null) {
                            badgeView2.setVisibility(0);
                            this.mTitleBadgeView.setType(BadgeView.Type.DOT);
                        }
                        TextView textView4 = this.mTvImUnreadCountView;
                        if (textView4 != null) {
                            textView4.setVisibility(8);
                        }
                    } else if (currentUnreadCount > 0) {
                        String countStr = currentUnreadCount > 99 ? "(99+)" : FileViewerActivity.LEFT_BRACKET + currentUnreadCount + ")";
                        BadgeView badgeView3 = this.mTitleBadgeView;
                        if (badgeView3 != null) {
                            badgeView3.setVisibility(8);
                        }
                        TextView textView5 = this.mTvImUnreadCountView;
                        if (textView5 != null) {
                            textView5.setText(countStr);
                            TextView textView6 = this.mTvImUnreadCountView;
                            if (!MessageUtils.isAccountLogin()) {
                                i3 = 8;
                            }
                            textView6.setVisibility(i3);
                        }
                    } else {
                        BadgeView badgeView4 = this.mTitleBadgeView;
                        if (badgeView4 != null) {
                            badgeView4.setVisibility(8);
                        }
                        TextView textView7 = this.mTvImUnreadCountView;
                        if (textView7 != null) {
                            textView7.setVisibility(8);
                        }
                    }
                    return;
                }
            }
            BadgeView badgeView5 = this.mTitleBadgeView;
            if (badgeView5 != null) {
                badgeView5.setVisibility(8);
            }
            TextView textView8 = this.mTvImUnreadCountView;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            ImageView imageView5 = this.mNetConnectingImage;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
                this.mNetConnectingImage.clearAnimation();
            }
            TextView textView9 = this.mTvImTitleView;
            if (textView9 != null) {
                textView9.setVisibility(0);
                this.mTvImTitleView.setText(R.string.net_title_no_connected);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, e2.getMessage());
            }
        }
    }

    private boolean hasPushUnread() {
        return this.mPushUnreadCount == -1 && MessageUtils.isBusinessAccount();
    }

    /* access modifiers changed from: private */
    public void showMoreSettingLayout() {
        String moreStatisticType;
        final String startConsultStatisticType;
        final String startUfoShowType;
        boolean ufoShowDot = !sImPref.getBoolean(MyMessageAdapter.PREF_UFO_PAGE_SHOWN, false);
        boolean discoveryShowDot = !sImPref.getBoolean("message_discovery_page_shown", false);
        boolean startConsultShowDot = !sImPref.getBoolean(MyMessageAdapter.PREF_START_CONSULT_PAGE_SHOWN, false);
        String str = "no_red";
        if (ufoShowDot || discoveryShowDot || startConsultShowDot) {
            moreStatisticType = "red";
        } else {
            moreStatisticType = str;
        }
        MessageStatisticUtils.moreMenuAndItemMessageListStatistic(moreStatisticType, "more_click");
        List<BdListPopupWindow.ListItemData> list = new ArrayList<>();
        if (ImMsgControl.getUFOMenuSwitch()) {
            BdListPopupWindow.ListItemData startUfoItem = new BdListPopupWindow.ListItemData(SETTING_MSG_UFO, R.drawable.message_start_ufo);
            if (ufoShowDot) {
                startUfoShowType = "red";
            } else {
                startUfoShowType = str;
            }
            if (ufoShowDot) {
                startUfoItem.setShowDot(true);
            }
            startUfoItem.setItemClickListener(new BdListPopupWindow.ItemClickListener() {
                public void onClick(int i2) {
                    String defultUrl;
                    String url;
                    IMSessionFragment.sImPref.putBoolean(MyMessageAdapter.PREF_UFO_PAGE_SHOWN, true);
                    if (Constants.getEnv(MessageRuntime.getAppContext()) == 0) {
                        url = "https://ufosdk.baidu.com/bailing/getEntryPath/9LC8KnhMN3dMSBnQV6zww8MQxPuKn-LBXajeJdXIym0=?from=BAIDUIM&paId=17592337567454\"";
                        defultUrl = "https://ufosdk.baidu.com/bailing/getEntryPath/9LC8KnhMN3dMSBnQV6zwwxxjSjoNCIoNz1SUeb3Uuyk=?from=BAIDUIM&paId=17592337567454\"";
                    } else {
                        url = "http://fengling-4.bcc-bdbl.baidu.com:8095/bailing/getEntryPath/fBlGcoflO7hEvOxV-QoWdA==?from=BAIDUIM&paId=17592337567454\"";
                        defultUrl = "http://fengling-4.bcc-bdbl.baidu.com:8095/bailing/getEntryPath/bBpEy4dHOnim2cTKJrDwdg==?from=BAIDUIM&paId=17592337567454\"";
                    }
                    String ufoUrl = "{\"defaultUrl\":\"" + defultUrl + ",\"digital\":\"1\",\"type\":\"normal\",\"url\":\"" + url + i.f2534d;
                    if (IMSessionFragment.DEBUG) {
                        Log.d(IMSessionFragment.TAG, "ufoUrl:" + ufoUrl);
                    }
                    try {
                        String ufoUrl2 = "baiduboxapp://feedback/invokeBrowser?params=" + URLEncoder.encode(String.format(ufoUrl, new Object[0]), "UTF-8") + "&callback=__boxx_1";
                        if (IMSessionFragment.DEBUG) {
                            Log.d(IMSessionFragment.TAG, "ufoUrl encode：" + ufoUrl2);
                        }
                        if (MessageUtils.isSchemeAvailable(MessageRuntime.getAppContext(), ufoUrl2)) {
                            MessageUtils.invokeScheme(MessageRuntime.getAppContext(), ufoUrl2);
                        }
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    MessageStatisticUtils.moreMenuAndItemMessageListStatistic(startUfoShowType, MessageStatisticUtils.DISCOVERY_VALUE_UFO_CLICK);
                }
            });
            MessageStatisticUtils.moreMenuAndItemMessageListStatistic(startUfoShowType, MessageStatisticUtils.DISCOVERY_VALUE_UFO_SHOW);
            list.add(startUfoItem);
        }
        if (ImMsgControl.getStartConsultChatSwitch()) {
            BdListPopupWindow.ListItemData startConsultItem = new BdListPopupWindow.ListItemData(SETTING_START_CONSULT, R.drawable.message_start_consult);
            if (startConsultShowDot) {
                startConsultItem.setShowDot(true);
            }
            if (startConsultShowDot) {
                startConsultStatisticType = "red";
            } else {
                startConsultStatisticType = str;
            }
            startConsultItem.setItemClickListener(new BdListPopupWindow.ItemClickListener() {
                public void onClick(int i2) {
                    IMSessionFragment.sImPref.putBoolean(MyMessageAdapter.PREF_START_CONSULT_PAGE_SHOWN, true);
                    if (!TextUtils.isEmpty("baiduboxapp://swan/vhgNHTCH2cGrbIAdolbmsoRYUtvV2ntj/pages/ask/ask?fr=pay_zd_bdmsgcenter_order")) {
                        BaseRouter.invokeScheme(MessageRuntime.getAppContext(), Uri.parse("baiduboxapp://swan/vhgNHTCH2cGrbIAdolbmsoRYUtvV2ntj/pages/ask/ask?fr=pay_zd_bdmsgcenter_order"), "inside");
                    }
                    MessageStatisticUtils.moreMenuAndItemMessageListStatistic(startConsultStatisticType, MessageStatisticUtils.DISCOVERY_VALUE_ASK_CLICK);
                }
            });
            MessageStatisticUtils.moreMenuAndItemMessageListStatistic(startConsultStatisticType, MessageStatisticUtils.DISCOVERY_VALUE_ASK_SHOW);
            list.add(startConsultItem);
        }
        if (ImMsgControl.getStartGroupChatSwitch()) {
            BdListPopupWindow.ListItemData startGroupItem = new BdListPopupWindow.ListItemData(SETTING_START_CHAT, R.drawable.message_start_chat);
            startGroupItem.setItemClickListener(new BdListPopupWindow.ItemClickListener() {
                public void onClick(int i2) {
                    IMSessionFragment.this.startSelectFriendListActivity();
                    MessageStatistic.messageCenterMoreOperateStatistic(MessageStatistic.PAGE_MORE_START_GROUP);
                }
            });
            list.add(startGroupItem);
        }
        if (ImMsgControl.getDiscoveryGroupMenuSwitch()) {
            BdListPopupWindow.ListItemData msgDiscoveryItem = new BdListPopupWindow.ListItemData(SETTING_MSG_GROUP_DISCOVERY, R.drawable.message_center_discovery_fans_group);
            if (discoveryShowDot) {
                msgDiscoveryItem.setShowDot(true);
            }
            if (discoveryShowDot) {
                str = "red";
            }
            final String discoveryStatisticType = str;
            list.add(msgDiscoveryItem);
            msgDiscoveryItem.setItemClickListener(new BdListPopupWindow.ItemClickListener() {
                public void onClick(int i2) {
                    IMSessionFragment.sImPref.putBoolean("message_discovery_page_shown", true);
                    MessageDiscoveryUtils.startDiscoveryFansGroupPage(IMSessionFragment.this.getContext().getApplicationContext());
                    MessageStatisticUtils.moreMenuAndItemMessageListStatistic(discoveryStatisticType, "findqun_click");
                }
            });
            MessageStatisticUtils.moreMenuAndItemMessageListStatistic(discoveryStatisticType, "findqun_show");
        }
        BdListPopupWindow.ListItemData msgSettingItem = new BdListPopupWindow.ListItemData(SETTING_MSG_SETTING, R.drawable.message_center_business_setting);
        msgSettingItem.setItemClickListener(new BdListPopupWindow.ItemClickListener() {
            public void onClick(int i2) {
                IMSessionFragment.this.goGlobalIMSetActivity();
                MessageStatistic.messageCenterMoreOperateStatistic("msg_setting");
            }
        });
        list.add(msgSettingItem);
        BdListPopupWindow moreSettingPopupView = new BdListPopupWindow(getContext(), list, false);
        if (!isDetached()) {
            moreSettingPopupView.showAtAnchorView(this.mActionBarRightImg);
        }
    }

    private void showMenuDot() {
        boolean discoveryShown = sImPref.getBoolean("message_discovery_page_shown", false);
        boolean startConsultShown = sImPref.getBoolean(MyMessageAdapter.PREF_START_CONSULT_PAGE_SHOWN, false);
        boolean startUfoShown = sImPref.getBoolean(MyMessageAdapter.PREF_UFO_PAGE_SHOWN, false);
        if (this.mActionBarRightZone != null) {
            if (this.mBadgeView == null) {
                BadgeView badgeView = new BadgeView(getContext());
                this.mBadgeView = badgeView;
                badgeView.setType(BadgeView.Type.DOT);
                LinearLayout linearLayout = this.mActionBarRightZone;
                LinearLayout.LayoutParams moreParams = new LinearLayout.LayoutParams(-2, -1);
                moreParams.gravity = 48;
                moreParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.in_app_subscribe_update_window_desc_margin_top);
                linearLayout.addView(this.mBadgeView, moreParams);
            }
            if (((discoveryShown || !ImMsgControl.getDiscoveryGroupMenuSwitch()) && (startConsultShown || !ImMsgControl.getStartConsultChatSwitch()) && (startUfoShown || !ImMsgControl.getUFOMenuSwitch())) && !hasPushUnread()) {
                BadgeView badgeView2 = this.mBadgeView;
                if (badgeView2 != null && badgeView2.getVisibility() == 0) {
                    this.mBadgeView.setVisibility(8);
                }
                MessageStatisticUtils.moreMenuAndItemMessageListStatistic("no_red", MessageStatisticUtils.DISCOVERY_VALUE_MORE_SHOW);
            } else if (true ^ shouldShowSettingImage()) {
                BadgeView badgeView3 = this.mBadgeView;
                if (badgeView3 != null && badgeView3.getVisibility() == 8) {
                    this.mBadgeView.setVisibility(0);
                }
                MessageStatisticUtils.moreMenuAndItemMessageListStatistic("red", MessageStatisticUtils.DISCOVERY_VALUE_MORE_SHOW);
            } else {
                BadgeView badgeView4 = this.mBadgeView;
                if (badgeView4 != null && badgeView4.getVisibility() == 0) {
                    this.mBadgeView.setVisibility(8);
                    MessageStatisticUtils.moreMenuAndItemMessageListStatistic("no_red", MessageStatisticUtils.DISCOVERY_VALUE_MORE_SHOW);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void startSelectFriendListActivity() {
        Intent intent = SelectFriendListActivity.generateIntent(1, (String) null, SelectFriendListActivity.SOURCE_MESSAGE_CENTER);
        BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_bottom, com.baidu.android.common.ui.style.R.anim.hold, com.baidu.android.common.ui.style.R.anim.hold, com.baidu.android.common.ui.style.R.anim.slide_out_to_bottom);
        ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
    }

    private boolean shouldShowSettingImage() {
        return !MessageUtils.isAccountLogin();
    }

    /* access modifiers changed from: private */
    public void resetSettingLayout() {
        setSettingLayout();
        showMenuDot();
    }

    private void setSettingLayout() {
        if (this.mActionBarRightImg != null) {
            if (shouldShowSettingImage()) {
                FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mActionBarRightImg, 0, R.drawable.message_center_business_setting_selector);
                this.mActionBarRightImg.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        IMSessionFragment.this.goGlobalIMSetActivity();
                        MessageStatistic.statisticMyMessageSet();
                    }
                });
                return;
            }
            FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mActionBarRightImg, 0, R.drawable.message_center_setting_selector);
            this.mActionBarRightImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    IMSessionFragment.this.showMoreSettingLayout();
                    MessageStatistic.messageCenterMoreOperateStatistic("more");
                }
            });
            showGuideBubble();
        }
    }

    private void showGuideBubble() {
        boolean isGuideBubbleShow = sImPref.getBoolean(MyMessageAdapter.PREF_MESSAGE_MORE_MENU_GUIDE_BUBBLE, false);
        boolean isUfouideBubbleShow = sImPref.getBoolean(MyMessageAdapter.PREF_MESSAGE_MORE_MENU_UFO_GUIDE_BUBBLE, false);
        boolean showBubble = false;
        String bubbleText = "";
        if (!isUfouideBubbleShow) {
            if (ImMsgControl.getUFOMenuSwitch()) {
                showBubble = true;
                bubbleText = getString(R.string.message_start_ufo_guide_bubble);
            }
        } else if (!isGuideBubbleShow && ImMsgControl.getStartConsultChatSwitch()) {
            showBubble = true;
            bubbleText = getString(R.string.message_start_consult_guide_bubble);
        }
        if (showBubble) {
            int bgColor = getActivity().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC28);
            BubbleTextManager bubbleManager = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setAnchorView((View) this.mActionBarRightImg).setText(bubbleText).setBackgroundColor(bgColor, bgColor).enableClkDismiss(true).setForceShowPosition(BubblePosition.DOWN).setAutoDismissInterval(5000).setPaddingBetweenAnchor((float) UIUtils.dip2px(getContext(), 1.0f)).build();
            if (bubbleManager != null) {
                bubbleManager.showBubble();
                if (!isUfouideBubbleShow) {
                    sImPref.putBoolean(MyMessageAdapter.PREF_MESSAGE_MORE_MENU_UFO_GUIDE_BUBBLE, true);
                } else if (!isGuideBubbleShow) {
                    sImPref.putBoolean(MyMessageAdapter.PREF_MESSAGE_MORE_MENU_GUIDE_BUBBLE, true);
                }
            }
        }
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        if (DEBUG) {
            Log.d(TAG, "onFontSizeChange");
        }
        TextView textView = this.mTvImTitleView;
        if (textView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.message_session_list_page_title_size);
        }
        TextView textView2 = this.mTvImUnreadCountView;
        if (textView2 != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.message_session_list_page_title_size);
        }
        ImageView imageView = this.mUnreadClearTipView;
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes(imageView, 0, R.dimen.message_session_list_clean_icon_w, R.dimen.message_session_list_clean_icon_w);
        }
        ImageView imageView2 = this.mRightUnreadClearTipView;
        if (imageView2 != null) {
            FontSizeViewExtKt.setScaledSizeRes(imageView2, 0, R.dimen.message_session_list_clean_icon_w, R.dimen.message_session_list_clean_icon_w);
        }
        IMSessionView iMSessionView = this.mImSessionView;
        if (iMSessionView != null) {
            iMSessionView.onFontSizeChange();
        }
    }

    public String getPageSource() {
        return this.mSource;
    }

    public int getViewPageHeight() {
        return this.viewPagerHeight;
    }

    public int getScreenMaxItemCount() {
        return this.screenMaxItemCount;
    }

    public boolean isAlive() {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
            return true;
        } else if (activity.isFinishing()) {
            return false;
        } else {
            return !isDetached();
        }
    }

    public boolean isUserLogin() {
        BoxAccountManager boxAccountManager = this.mLoginManager;
        return boxAccountManager != null && boxAccountManager.isLogin(2);
    }

    public static void messageListUnreadNum() {
        MessageStatistic.messageListUnreadNum((int) ImMsgControl.getInstance(MessageRuntime.getAppContext()).getImChatUnreadCount(0));
    }

    private void matchTheme() {
        TextView actionBarBottomDivider;
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setBackgroundColor(ContextCompat.getColor(MessageRuntime.getAppContext(), R.color.message_list_bg));
        }
        TextView textView = this.mTvImTitleView;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(MessageRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC1));
        }
        TextView textView2 = this.mTvImUnreadCountView;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(MessageRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC1));
        }
        ImageView imageView = this.mNetConnectingImage;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.bd_net_connecting));
        }
        ImageView imageView2 = this.mUnreadClearTipView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.bd_im_clear));
        }
        ImageView imageView3 = this.mRightUnreadClearTipView;
        if (imageView3 != null) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.bd_im_clear));
        }
        if (this.mActionBarRightImg != null) {
            if (shouldShowSettingImage()) {
                FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mActionBarRightImg, 0, R.drawable.message_center_business_setting_selector);
            } else {
                FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mActionBarRightImg, 0, R.drawable.message_center_setting_selector);
            }
        }
        View view3 = this.mRootView;
        if (!(view3 == null || (actionBarBottomDivider = (TextView) view3.findViewById(R.id.action_bar_bottom_divider)) == null)) {
            actionBarBottomDivider.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC34));
            actionBarBottomDivider.setVisibility(8);
        }
        ViewGroup viewGroup = this.mSystemNotifySwitchLayout;
        if (viewGroup != null) {
            Button openButton = (Button) viewGroup.findViewById(R.id.system_off_open);
            this.mSystemNotifySwitchLayout.setBackgroundDrawable(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.message_system_off_new_bg));
            ((TextView) this.mSystemNotifySwitchLayout.findViewById(R.id.system_off_tip)).setTextColor(ContextCompat.getColor(MessageRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC6));
            ((ImageView) this.mSystemNotifySwitchLayout.findViewById(R.id.system_off_delete)).setBackgroundDrawable(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.system_off_close_bg_selector));
            openButton.setTextColor(ContextCompat.getColor(MessageRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC67));
            openButton.setBackground(ContextCompat.getDrawable(MessageRuntime.getAppContext(), R.drawable.system_off_open_bg));
        }
    }

    private boolean isTopBackShow() {
        boolean isLocatedHomeBar = false;
        if (HomeFourthTabTypeUtils.INSTANCE != null) {
            isLocatedHomeBar = MessageHomeBarManager.INSTANCE.isHomeBar();
        }
        return UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment() && !isLocatedHomeBar;
    }

    private static class AccountComponentCallback implements IAccountComponentCallback {
        private final WeakReference<IMSessionFragment> mWeakFragmentRef;

        AccountComponentCallback(IMSessionFragment imSessionFragment) {
            this.mWeakFragmentRef = new WeakReference<>(imSessionFragment);
        }

        public void onComponentReady(View view2, int loginStyle) {
            IMSessionFragment fragment;
            if (IMSessionFragment.DEBUG) {
                Log.d(IMSessionFragment.TAG, "登录组件准备完成:" + (view2 == null));
            }
            if (view2 != null && (fragment = (IMSessionFragment) this.mWeakFragmentRef.get()) != null) {
                fragment.onLoginViewComponentReady(view2);
            }
        }

        public void onLoginResult(int resultCode) {
            if (IMSessionFragment.DEBUG) {
                Log.d(IMSessionFragment.TAG, "登录结果:" + resultCode);
            }
            IMSessionFragment fragment = (IMSessionFragment) this.mWeakFragmentRef.get();
            if (fragment != null) {
                fragment.onLoginViewCallbackResult(resultCode);
            }
        }

        public void onButtonClick(int buttonType) {
        }
    }
}
