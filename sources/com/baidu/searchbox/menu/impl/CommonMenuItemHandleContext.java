package com.baidu.searchbox.menu.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.menu.MenuNewType;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.MainActivity;
import com.baidu.searchbox.MessageCenterService;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.SearchBoxSettingsActivity;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.bookmark.BookmarkUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.ui.fusion.FileManagerActivity;
import com.baidu.searchbox.feed.abtest.update.FeedUpdateConfig;
import com.baidu.searchbox.feed.util.FeedSchemeUtil;
import com.baidu.searchbox.home.tabs.update.HomeDefaultTabListener;
import com.baidu.searchbox.imsdk.ImMsgControl;
import com.baidu.searchbox.menu.data.CommonMenuUtils;
import com.baidu.searchbox.menu.data.ioc.CommonMenuItemNewTipCallback;
import com.baidu.searchbox.menu.data.ioc.ICommonMenuItemHandleContext;
import com.baidu.searchbox.newtips.NewTipsDataManager;
import com.baidu.searchbox.newtips.type.NewTipsNodeID;
import com.baidu.searchbox.newtips.type.NewTipsSourceID;
import com.baidu.searchbox.push.MyMessageMainState;
import com.baidu.searchbox.settings.SettingsFunManager;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.voice.pyramid.VoicePanelInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonMenuItemHandleContext implements ICommonMenuItemHandleContext {
    private static final String EXTRA_FEED_PARAMS = "params";
    private static final String FEED_TAB = "Feed";
    private static final int IM_FUSION_MESSAGE_FRAGMENT_ID = 2;
    private static final String TAG = "CommonMenuItemHandleCon";
    private BoxAccountManager accountManager = null;
    private final String mNetDiskScheme = "baiduboxapp://netdisk/gotoHomePage?params=%7B%22rtab%22%3A%220%22%2C%22isFold%22%3A%220%22%2C%22downgradeScheme%22%3A%22baiduboxapp%3A%2F%2Fswan%2FOyIvf6LYVhKkbIHS1USP7xnSKYxc36SH%2Fpages%2Fhome%2Findex%3Ffrom%3D1026350x_1026350y%26_baiduboxapp%3D%257B%2522from%2522%253A%25221201001310003000%2522%252C%2522ext%2522%253A%257B%257D%257D%26callback%3D_bdbox_js_275%26upgrade%3D0%22%2C%22ubcSource%22%3A%22caidan%22%7D";

    public void changeDayNightModeWithToast(Context context) {
        boolean isNightMode = NightModeHelper.getNightModeSwitcherState();
        NightModeHelper.setNightModeSwitcherState(!isNightMode);
        if (isNightMode) {
            UniversalToast.makeText(context, R.string.browser_menu_toast_day_mode).setHighlightDrawable(R.drawable.common_menu_item_day_mode_toast_icon).setDuration(2).showHighlightToast();
        } else {
            UniversalToast.makeText(context, R.string.browser_menu_toast_night_mode).setHighlightDrawable(R.drawable.common_menu_item_night_mode_toast_icon).setDuration(2).showHighlightToast();
        }
    }

    public void gotoHomePage(Context context) {
        if (FeedUpdateConfig.INSTANCE.isBackToHomeDefault()) {
            gotoHomePageOnline(context);
        } else {
            gotoHomePageAbtest();
        }
        VoicePanelInterface voicePanelInterface = (VoicePanelInterface) ServiceManager.getService(VoicePanelInterface.SERVICE_REFERENCE);
        if (voicePanelInterface != null) {
            voicePanelInterface.closeAllVoiceScreen();
        }
    }

    public void gotoHomePageOnline(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction("com.baidu.searchbox.action.HOME_TAB");
        intent.putExtra("goTop", true);
        context.startActivity(intent);
    }

    public void gotoHomePageAbtest() {
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.HOME");
        JSONObject paramsJson = new JSONObject();
        try {
            paramsJson.put("invoke_from", FeedSchemeUtil.VALUE_INVOKE_FROM_BACK_TO_HOME);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        intent.putExtra("params", paramsJson.toString());
        String launchTabTag = null;
        if (DefaultSharedPrefsWrapper.getInstance().getString(HomeDefaultTabListener.BACK_TO_BAR_SWITCH, "0").equals("1")) {
            launchTabTag = SettingsFunManager.Companion.getLaunchDefaultTab();
        }
        if (TextUtils.isEmpty(launchTabTag)) {
            launchTabTag = "Feed";
        }
        intent.putExtra("extra_target_tab", launchTabTag);
        intent.setComponent(new ComponentName(AppRuntime.getAppContext(), MainActivity.class));
        ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
    }

    public void gotoStarPage(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("source", "from_light");
        BookmarkUtil.startUserAssetsCenterNeedLogin(context, "favor", bundle);
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void gotoHistoryPage(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("source", "from_light");
        BookmarkUtil.startUserAssetsCenter(context, "history", bundle);
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void gotoSettingPage(Context context) {
        ActivityUtils.startActivitySafely(context, new Intent(context, SearchBoxSettingsActivity.class));
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void gotoDownloadPage(Context context) {
        Intent intent = new Intent(context, FileManagerActivity.class);
        intent.putExtra("source", 1);
        ActivityUtils.startActivitySafely(context, intent);
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void gotoNotificationMessagePage(Context context) {
        Intent intent = new Intent(context, MyMessageMainState.class);
        intent.putExtra(MyMessageMainState.SHOW_TAB_NUMBER, 0);
        intent.putExtra("source", "6");
        ActivityUtils.startActivitySafely(context, intent);
    }

    public void gotoPersonalMessagePage(Context context) {
        Intent intent = new Intent(context, MyMessageMainState.class);
        intent.putExtra(MyMessageMainState.SHOW_TAB_NUMBER, 1);
        intent.putExtra("source", "6");
        ActivityUtils.startActivitySafely(context, intent);
    }

    public void gotoMessagePage(Context context) {
        Intent intent = new Intent(context, MyMessageMainState.class);
        intent.putExtra(MyMessageMainState.SHOW_TAB_NUMBER, 2);
        intent.putExtra("source", "6");
        ActivityUtils.startActivitySafely(context, intent);
    }

    public void requestDownloadNewTip(CommonMenuItemNewTipCallback callback) {
        if (callback != null) {
            boolean isDownloadNew = NewTipsDataManager.isNodeNew(NewTipsSourceID.Downloading, NewTipsNodeID.BrowserMenuItem);
            if (!isDownloadNew) {
                isDownloadNew = NewTipsDataManager.isNodeNew(NewTipsSourceID.DownloadUnread, NewTipsNodeID.BrowserMenuItem);
            }
            callback.onNewTipResult(isDownloadNew ? MenuNewType.DOT_TIP : MenuNewType.NO_TIP, (String) null);
        }
    }

    public void setDownloadTipsRead() {
        NewTipsDataManager.setNodeNew(NewTipsSourceID.Downloading, NewTipsNodeID.BrowserMenuItem, false);
        NewTipsDataManager.setNodeNew(NewTipsSourceID.DownloadUnread, NewTipsNodeID.BrowserMenuItem, false);
        NewTipsDataManager.setNodeNew(NewTipsSourceID.Downloading, NewTipsNodeID.BrowserMenu, false);
        NewTipsDataManager.setNodeNew(NewTipsSourceID.DownloadUnread, NewTipsNodeID.BrowserMenu, false);
    }

    public long getImChatMsgCount() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).getImChatUnreadCount();
    }

    public boolean hasImChatRedDotUnreadCount() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).hasImChatRedDotUnreadCount();
    }

    public boolean getImChatHasNewMsg() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).getImChatHasNewMsg();
    }

    public int getImNotificationMsgCount() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).getNotificationUnreadCount();
    }

    public boolean getImNotificationHasNewMsg() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).getImNotificationHasNewMsg();
    }

    public long getMessageCount() {
        return MessageCenterService.getMessageCenterUnreadCount(4);
    }

    public void dealNetDiskClick(Context context) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "dealNetDiskClick: ");
        }
        processNetDisk(context);
        CommonMenuUtils.INSTANCE.updateNetDiskRedDot();
    }

    private void processNetDisk(Context context) {
        if (this.accountManager == null && (ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE) instanceof BoxAccountManager)) {
            this.accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        }
        BoxAccountManager boxAccountManager = this.accountManager;
        if (boxAccountManager == null) {
            if (AppConfig.isDebug()) {
                Log.e(TAG, "processNetDisk: accountManager == null");
            }
        } else if (boxAccountManager.isLogin(2)) {
            Router.invoke(context, "baiduboxapp://netdisk/gotoHomePage?params=%7B%22rtab%22%3A%220%22%2C%22isFold%22%3A%220%22%2C%22downgradeScheme%22%3A%22baiduboxapp%3A%2F%2Fswan%2FOyIvf6LYVhKkbIHS1USP7xnSKYxc36SH%2Fpages%2Fhome%2Findex%3Ffrom%3D1026350x_1026350y%26_baiduboxapp%3D%257B%2522from%2522%253A%25221201001310003000%2522%252C%2522ext%2522%253A%257B%257D%257D%26callback%3D_bdbox_js_275%26upgrade%3D0%22%2C%22ubcSource%22%3A%22caidan%22%7D");
        } else {
            this.accountManager.combineLogin(context, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "caidan_wangpan")).setVoiceLogin(true).setLoginMode(5).build(), 2, new CommonMenuItemHandleContext$$ExternalSyntheticLambda0(this, context));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processNetDisk$0$com-baidu-searchbox-menu-impl-CommonMenuItemHandleContext  reason: not valid java name */
    public /* synthetic */ void m430lambda$processNetDisk$0$combaidusearchboxmenuimplCommonMenuItemHandleContext(Context context, int resultCode) {
        if (this.accountManager.isLogin(2)) {
            Router.invoke(context, "baiduboxapp://netdisk/gotoHomePage?params=%7B%22rtab%22%3A%220%22%2C%22isFold%22%3A%220%22%2C%22downgradeScheme%22%3A%22baiduboxapp%3A%2F%2Fswan%2FOyIvf6LYVhKkbIHS1USP7xnSKYxc36SH%2Fpages%2Fhome%2Findex%3Ffrom%3D1026350x_1026350y%26_baiduboxapp%3D%257B%2522from%2522%253A%25221201001310003000%2522%252C%2522ext%2522%253A%257B%257D%257D%26callback%3D_bdbox_js_275%26upgrade%3D0%22%2C%22ubcSource%22%3A%22caidan%22%7D");
        }
    }
}
