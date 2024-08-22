package com.baidu.searchbox.video.detail.dependency.impl.share;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.music.ext.repo.MusicApiServiceKt;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.OnChildItemClickListener;
import com.baidu.searchbox.socialshare.OnLifeCycleListener;
import com.baidu.searchbox.socialshare.OnSocialListener;
import com.baidu.searchbox.socialshare.bean.BDMenuActionMessage;
import com.baidu.searchbox.socialshare.bean.BDMenuItem;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.statistics.SocialShareStatisticHelper;
import com.baidu.searchbox.socialshare.utils.ShareUtils;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoShareUtils;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentExtKt;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoShareUtilsImpl implements IVideoShareUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "VideoShareUtilsImpl";
    private OnChildItemClickListener mItemClickListener;
    private OnLifeCycleListener mLifeCycleListener;
    private OnSocialListener mShareListener;

    private static class Holder {
        /* access modifiers changed from: private */
        public static VideoShareUtilsImpl INSTANCE = new VideoShareUtilsImpl();

        private Holder() {
        }
    }

    public static VideoShareUtilsImpl getInstance() {
        return Holder.INSTANCE;
    }

    public void buildShareShowPanel(Context context, String mediaType, IVideoShareUtils.ShareBean info, String realSource, String nid, String strategyInfo, List<IVideoShareUtils.ShareMenuTypeWrapper> menuTypeWrappers, List<String> removeMenus, IVideoShareUtils.OnItemClickListener onChildItemClickListener, IVideoShareUtils.IVideoOnSocialListener shareListener, IVideoShareUtils.OnLifeCycleListener lifeCycleListener, boolean isShowGuide, boolean isBtnEnhance) {
        BaiduShareContent shareContent = buildBaiduShareContent(mediaType, info, realSource, nid, strategyInfo, menuTypeWrappers, removeMenus, isShowGuide, isBtnEnhance);
        BDShare bdShare = BDShare.getInstance();
        final IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener = shareListener;
        this.mShareListener = new OnSocialListener() {
            public void onStart() {
            }

            public void onCancel() {
            }

            public void onSuccess(JSONObject jsonObject) {
                IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener = iVideoOnSocialListener;
                if (iVideoOnSocialListener != null) {
                    iVideoOnSocialListener.onSuccess(jsonObject);
                }
            }

            public void onFail(int i2, String s) {
                IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener = iVideoOnSocialListener;
                if (iVideoOnSocialListener != null) {
                    iVideoOnSocialListener.onFail(i2, s);
                }
            }
        };
        final IVideoShareUtils.OnLifeCycleListener onLifeCycleListener = lifeCycleListener;
        this.mLifeCycleListener = new OnLifeCycleListener() {
            public void onShow() {
                IVideoShareUtils.OnLifeCycleListener onLifeCycleListener = onLifeCycleListener;
                if (onLifeCycleListener != null) {
                    onLifeCycleListener.onShow();
                }
            }

            public void onDismiss() {
                IVideoShareUtils.OnLifeCycleListener onLifeCycleListener = onLifeCycleListener;
                if (onLifeCycleListener != null) {
                    onLifeCycleListener.onDismiss();
                }
            }
        };
        final IVideoShareUtils.OnItemClickListener onItemClickListener = onChildItemClickListener;
        AnonymousClass3 r2 = new OnChildItemClickListener() {
            public boolean onClick(View view2, BDMenuActionMessage bdMenuActionMessage) {
                if (onItemClickListener == null || bdMenuActionMessage == null || !(bdMenuActionMessage.obj instanceof BDMenuItem)) {
                    return false;
                }
                IVideoShareUtils.ShareMenuMessage message = new IVideoShareUtils.ShareMenuMessage();
                message.name = ((BDMenuItem) bdMenuActionMessage.obj).getText();
                message.type = ((BDMenuItem) bdMenuActionMessage.obj).getType();
                return onItemClickListener.onClick(view2, message);
            }
        };
        this.mItemClickListener = r2;
        bdShare.setOnChildItemClickListener(r2);
        bdShare.setOnSocialListener(this.mShareListener);
        bdShare.setOnLifeCycleListener(this.mLifeCycleListener);
        Context context2 = context;
        bdShare.share(context, (View) null, shareContent);
    }

    public void buildShareShowPanel(Context context, String mediaType, IVideoShareUtils.ShareBean info, String realSource, String nid, IVideoShareUtils.IVideoOnSocialListener shareListener, IVideoShareUtils.OnLifeCycleListener lifeCycleListener) {
        buildShareShowPanel(context, mediaType, info, realSource, nid, (String) null, (List<IVideoShareUtils.ShareMenuTypeWrapper>) null, (List<String>) null, (IVideoShareUtils.OnItemClickListener) null, shareListener, lifeCycleListener, false, false);
    }

    public void buildShareShowPanel(Context context, String mediaType, IVideoShareUtils.ShareBean info, String realSource, String nid, IVideoShareUtils.IVideoOnSocialListener shareListener) {
        buildShareShowPanel(context, mediaType, info, realSource, nid, shareListener, (IVideoShareUtils.OnLifeCycleListener) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediaType(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1195302015: goto L_0x0026;
                case -973170826: goto L_0x001c;
                case 361910168: goto L_0x0012;
                case 1536737232: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0030
        L_0x0008:
            java.lang.String r0 = "com.sina.weibo"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x0031
        L_0x0012:
            java.lang.String r0 = "com.tencent.mobileqq"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0031
        L_0x001c:
            java.lang.String r0 = "com.tencent.mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0031
        L_0x0026:
            java.lang.String r0 = "com.baidu.hi"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 3
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            switch(r0) {
                case 0: goto L_0x0040;
                case 1: goto L_0x003d;
                case 2: goto L_0x003a;
                case 3: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            java.lang.String r0 = "all"
            return r0
        L_0x0037:
            java.lang.String r0 = com.baidu.searchbox.socialshare.bean.MediaType.BAIDUHI
            return r0
        L_0x003a:
            java.lang.String r0 = com.baidu.searchbox.socialshare.bean.MediaType.SINAWEIBO
            return r0
        L_0x003d:
            java.lang.String r0 = com.baidu.searchbox.socialshare.bean.MediaType.QQFRIEND
            return r0
        L_0x0040:
            java.lang.String r0 = com.baidu.searchbox.socialshare.bean.MediaType.WXFRIEND
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.detail.dependency.impl.share.VideoShareUtilsImpl.getMediaType(java.lang.String):java.lang.String");
    }

    public void clean() {
        BDShare.clean();
        this.mLifeCycleListener = null;
        this.mShareListener = null;
        this.mItemClickListener = null;
    }

    public void hide() {
        BDShare.getInstance().hide();
    }

    public boolean isShowing() {
        return BDShare.getInstance().isShowing();
    }

    private int wrapSupportShareTypeOrDefault(int type) {
        if (type == 1) {
            return type;
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    public BaiduShareContent buildBaiduShareContent(String mediaType, IVideoShareUtils.ShareBean info, String realSource, String nid, String strategyInfo, List<IVideoShareUtils.ShareMenuTypeWrapper> menuTypeWrappers, List<String> removeMenus, boolean isShowGuide, boolean isBtnEnhance) {
        IVideoShareUtils.ShareBean shareBean = info;
        String str = nid;
        List<String> list = removeMenus;
        JSONObject categoryInfoJson = new JSONObject();
        JSONObject categoryDataJson = new JSONObject();
        JSONObject userInfo = new JSONObject();
        boolean z = true;
        try {
            categoryInfoJson.put("nid", str);
            String str2 = "0";
            String qianghua = str2;
            if (isShowGuide) {
                qianghua = "1";
            }
            JSONObject videoExt = new JSONObject();
            videoExt.put("qianghua", qianghua);
            if (isBtnEnhance) {
                str2 = "1";
            }
            videoExt.put("btn", str2);
            categoryInfoJson.put(MusicApiServiceKt.VIDEO_PARAMS_EXT, videoExt);
            if (!TextUtils.isEmpty(shareBean.mThemeId)) {
                categoryInfoJson.put(CommentExtKt.VIDEO_FLOW_UBC_THEME_ID, shareBean.mThemeId);
            }
            if (shareBean.isCommentVideo) {
                categoryInfoJson.put("is_video", 1);
            }
            categoryDataJson.put("business_type", "video");
            if (!TextUtils.isEmpty(shareBean.mForward)) {
                categoryDataJson.put("ugc_scheme", shareBean.mForward);
            }
            userInfo.put("nid", str);
            if (!TextUtils.isEmpty(shareBean.mPage)) {
                userInfo.put("page", shareBean.mPage);
            }
            if (!TextUtils.isEmpty(shareBean.mCollId)) {
                userInfo.put("collId", shareBean.mCollId);
            }
            if (!TextUtils.isEmpty(shareBean.mExtLog)) {
                userInfo.put(IntentData.Protocol.KEY_EXT_LOG, shareBean.mExtLog);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.w(TAG, Log.getStackTraceString(e2));
            }
        }
        BaiduShareContent.Builder hotResourceAnimeConfig = new BaiduShareContent.Builder().setTitle(shareBean.mTitle).setContent(ShareUtils.getShareContent(AppRuntime.getAppContext(), shareBean.mTitle, shareBean.mContent, false)).setLinkUrl(shareBean.mLinkUrl).setShareType(wrapSupportShareTypeOrDefault(shareBean.mType)).setVideoUrl(shareBean.mLinkUrl).setIconUrl(shareBean.mIconUrl).setMediaType(mediaType).setSourcePage(SocialShareStatisticHelper.getShareSourceFramwork(realSource)).setSource(SocialShareStatisticHelper.getShareSource(realSource)).setCategoryInfo(categoryInfoJson.toString()).setPanelStyle(shareBean.mPanelStyle).setPanelXOffset(shareBean.panelXOffset).setCategoryData(categoryDataJson.toString()).setUserInfo(userInfo.toString()).setStrategyInfo(strategyInfo).setShareExtPage(shareBean.mPageExt).setShareEntrance(shareBean.mEntrance).setHotResourceAnimeConfig(shareBean.mHotResourceShareAnimConfig);
        if (shareBean.hideSharePanelAnim != 1) {
            z = false;
        }
        BaiduShareContent.Builder baiduShareContentBuilder = hotResourceAnimeConfig.setHideSharePanelAnim(z);
        if (list != null && removeMenus.size() > 0) {
            baiduShareContentBuilder.addRemoveMenuItem(list);
        }
        if (menuTypeWrappers != null && menuTypeWrappers.size() > 0) {
            for (IVideoShareUtils.ShareMenuTypeWrapper item : menuTypeWrappers) {
                baiduShareContentBuilder.addBDMenuItem(item.resId, item.name, item.position, item.showTips);
            }
        }
        return baiduShareContentBuilder.create();
    }

    /* access modifiers changed from: protected */
    public BaiduShareContent buildBaiduShareContent(String mediaType, IVideoShareUtils.ShareBean info, String realSource, String nid) {
        return buildBaiduShareContent(mediaType, info, realSource, nid, (String) null, (List<IVideoShareUtils.ShareMenuTypeWrapper>) null, (List<String>) null, false, false);
    }
}
