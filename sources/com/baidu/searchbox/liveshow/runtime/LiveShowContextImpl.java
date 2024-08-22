package com.baidu.searchbox.liveshow.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.CodeScannerActivity;
import com.baidu.searchbox.SearchboxApplication;
import com.baidu.searchbox.account.data.SocialityHttpMethodUtils;
import com.baidu.searchbox.account.userinfo.AccountUserInfoManager;
import com.baidu.searchbox.account.userinfo.data.AccountOtherUserInfoResult;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.comment.definition.IBaseDataResponseListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.database.OEMConfiguartion;
import com.baidu.searchbox.downloads.DownloadDialogUtil;
import com.baidu.searchbox.follow.Relation;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.liveshow.domain.UserInfoBean;
import com.baidu.searchbox.liveshow.scheme.UnitedSchemeLiveDispatcher;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.search.pyramid.RestoreFeatureInterface;
import com.baidu.searchbox.util.Utility;
import com.baidu.searchbox.util.UtilityCanBeProguard;
import com.baidu.searchbox.video.util.VideoUtils;
import rx.Subscriber;

public class LiveShowContextImpl implements ILiveShowContext {
    public String parseFilePath(Intent data) {
        return Utility.parseFilePath(data);
    }

    public Uri getUri(String url) {
        return UtilityCanBeProguard.getUri(url);
    }

    public void launchForCropPicture(Activity activity, int requestCode, Uri uri, String key, String url, boolean fixedAspectRatio, int aspectRatioX, int aspectRatioY) {
        CodeScannerActivity.launchForCropPicture(activity, requestCode, "0", uri, key, url, fixedAspectRatio, aspectRatioX, aspectRatioY);
    }

    public String createScheme(String roomId, String source) {
        return UnitedSchemeLiveDispatcher.createScheme(roomId, source);
    }

    public String getAccountUid(Context context) {
        return Utility.getAccountUid(context);
    }

    public Drawable getNormalDrawable(int resId) {
        return ((SearchboxApplication) AppRuntime.getAppContext().getApplicationContext()).getSuperResources().getDrawable(resId);
    }

    public boolean videoPluginHandledKeyDown(int keyCode) {
        return VideoUtils.videoPluginHandledKeyDown(keyCode);
    }

    public boolean isGoogleMarket() {
        return OEMConfiguartion.getInstance(AppRuntime.getAppContext()).isGoogleMarket();
    }

    public void show(Context context, String url, String contentDisposition, String mimeType, String referer, String userAgent, long contentLength) {
        DownloadDialogUtil.show(context, url, contentDisposition, mimeType, "", referer, userAgent, contentLength);
    }

    public CookieManager getCookieManager(boolean needSync, boolean needSaveBduss) {
        return new SearchBoxCookieManager(needSync, needSaveBduss);
    }

    public String getSocialEncryption(String plaintext) {
        return SocialEncodeUtils.getSocialEncryption(plaintext, "baiduuid_");
    }

    public void followUser(Context context, String uk, String remark, boolean isAsyn, IBaseDataResponseListener listener) {
        SocialityHttpMethodUtils.followUser(context, uk, remark, isAsyn, listener);
    }

    public void unfollowUser(Context context, String uk, boolean isAsyn, IBaseDataResponseListener listener) {
        SocialityHttpMethodUtils.unfollowUser(context, uk, false, listener);
    }

    public void subscriberUserinfo(final Subscriber<? super UserInfoBean> subscriber, String uid) {
        AccountUserInfoManager.getOtherUserInfoFromServer(uid, new AccountUserInfoManager.GetOtherUserInfoListener() {
            public void onGetOtherUserInfo(int error, AccountOtherUserInfoResult result) {
                UserInfoBean userInfoBean = new UserInfoBean();
                userInfoBean.mDisplayName = result.getDisplayName();
                userInfoBean.mGender = result.getGender();
                userInfoBean.mSignature = result.getSignature();
                userInfoBean.mAvatar = result.getAvatar();
                userInfoBean.mFansNum = result.getFansNum();
                userInfoBean.mFollowNum = result.getmFollowNum();
                if (result.getRelation() == Relation.FOLLOWED || result.getRelation() == Relation.FOLLOW_EACH_OTHER) {
                    userInfoBean.mHasFollowed = true;
                }
                subscriber.onNext(userInfoBean);
                subscriber.onCompleted();
            }
        }, false);
    }

    public Intent getUserInfoIntent(String uid) {
        return AccountUserInfoManager.getUserInfoIntent(uid, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, AccountUserInfoManager.UserInfoSrc.KEY_LIVE_SHOW);
    }

    public void saveIntent(String source, Intent intent) {
        ((RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE)).saveIntent(source, intent);
    }

    public boolean meetAllConditions(boolean save) {
        return ((RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE)).meetAllConditions(save);
    }

    public boolean deleteBundleFile() {
        return ((RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE)).deleteBundleFile();
    }
}
