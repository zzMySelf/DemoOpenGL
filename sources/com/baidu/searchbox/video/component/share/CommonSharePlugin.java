package com.baidu.searchbox.video.component.share;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.rtc.RtcConstant;
import com.baidu.searchbox.video.component.share.mapper.ShareBtnMessageModel2BeanMapper;
import com.baidu.searchbox.video.component.share.mapper.ShareMenuModel2BeanMapper;
import com.baidu.searchbox.video.component.share.mapper.ShareModel2BeanMapper;
import com.baidu.searchbox.video.component.share.service.CommonShareServiceImp;
import com.baidu.searchbox.video.component.share.service.ICommonShareService;
import com.baidu.searchbox.video.detail.export.IVideoShareUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0002JH\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u0004\u0018\u00010\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0004J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u001bJ\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001bH\u0016JJ\u00104\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u00105\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u0002082\u0006\u0010\"\u001a\u00020#H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00069"}, d2 = {"Lcom/baidu/searchbox/video/component/share/CommonSharePlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "itemClickListener", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnItemClickListener;", "getItemClickListener", "()Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnItemClickListener;", "setItemClickListener", "(Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnItemClickListener;)V", "lifeCycleListener", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnLifeCycleListener;", "getLifeCycleListener", "()Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnLifeCycleListener;", "setLifeCycleListener", "(Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$OnLifeCycleListener;)V", "shareListener", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$IVideoOnSocialListener;", "getShareListener", "()Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$IVideoOnSocialListener;", "setShareListener", "(Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$IVideoOnSocialListener;)V", "addModelParams", "Lcom/baidu/searchbox/video/component/share/ShareModel;", "model", "source", "", "buildShareShowPanel", "", "mediaType", "", "realSource", "panelType", "page", "entrance", "isShowGuide", "", "isBtnEnhance", "getShareInfo", "getShareMenuTypeWrappers", "", "Lcom/baidu/searchbox/video/component/share/ShareMenuTypeModel;", "getVideoShareUtils", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils;", "hide", "initItemClickListener", "initLifeCycleListener", "initShareListener", "onAttachToManager", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onRelease", "requestShare", "panelXOffset", "updateShareBean", "bean", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$ShareBean;", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonSharePlugin.kt */
public class CommonSharePlugin extends LiveDataPlugin {
    private IVideoShareUtils.OnItemClickListener itemClickListener;
    private IVideoShareUtils.OnLifeCycleListener lifeCycleListener;
    private IVideoShareUtils.IVideoOnSocialListener shareListener;

    /* access modifiers changed from: protected */
    public final IVideoShareUtils.IVideoOnSocialListener getShareListener() {
        return this.shareListener;
    }

    /* access modifiers changed from: protected */
    public final void setShareListener(IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener) {
        this.shareListener = iVideoOnSocialListener;
    }

    /* access modifiers changed from: protected */
    public final IVideoShareUtils.OnLifeCycleListener getLifeCycleListener() {
        return this.lifeCycleListener;
    }

    /* access modifiers changed from: protected */
    public final void setLifeCycleListener(IVideoShareUtils.OnLifeCycleListener onLifeCycleListener) {
        this.lifeCycleListener = onLifeCycleListener;
    }

    /* access modifiers changed from: protected */
    public final IVideoShareUtils.OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* access modifiers changed from: protected */
    public final void setItemClickListener(IVideoShareUtils.OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public void onAttachToManager() {
        CommonShareState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        getManager().registerServices(ICommonShareService.class, new CommonShareServiceImp(this));
        initShareListener();
        initLifeCycleListener();
        initItemClickListener();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d2 = (CommonShareState) store.subscribe((Class<T>) CommonShareState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getInvokeSharePanel().observe(this, new CommonSharePlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.getHideSharePanel().observe(this, new CommonSharePlugin$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m5244onAttachToManager$lambda2$lambda0(CommonSharePlugin this$0, RequestShareModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestShare(model.getMediaType(), model.getSource(), model.getPanelStyle(), model.getPage(), model.getEntrance(), model.isShowGuide(), model.isBtnEnhance(), model.getPanelXOffset());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m5245onAttachToManager$lambda2$lambda1(CommonSharePlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (newConfig.orientation == 2) {
            hide();
        }
    }

    public void onRelease() {
        super.onRelease();
        getVideoShareUtils().clean();
        this.shareListener = null;
        this.lifeCycleListener = null;
        this.itemClickListener = null;
    }

    private final void requestShare(String mediaType, @ShareSource int source, String panelType, String page, String entrance, boolean isShowGuide, boolean isBtnEnhance, int panelXOffset) {
        AbsState state;
        CommonShareState commonShareState;
        MutableLiveData<ShareModel> shareModel;
        ShareModel model;
        int i2 = source;
        Store<AbsState> store = getStore();
        if (store == null || (state = store.getState()) == null || (commonShareState = (CommonShareState) state.select(CommonShareState.class)) == null || (shareModel = commonShareState.getShareModel()) == null || (model = shareModel.getValue()) == null) {
            int i3 = panelXOffset;
        } else if (!TextUtils.isEmpty(model.getLinkUrl())) {
            String realSource = ShareSource.Companion.parseSource(i2);
            ShareModel newModel = addModelParams(model, i2);
            newModel.setPanelXOffset(panelXOffset);
            buildShareShowPanel(mediaType, newModel, realSource, panelType, page, entrance, isShowGuide, isBtnEnhance);
        } else {
            int i4 = panelXOffset;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.video.component.share.ShareModel addModelParams(com.baidu.searchbox.video.component.share.ShareModel r6, @com.baidu.searchbox.video.component.share.ShareSource int r7) {
        /*
            r5 = this;
            r0 = 16
            if (r7 != r0) goto L_0x0057
            r0 = 0
            com.baidu.searchbox.feed.detail.frame.Store r1 = r5.getStore()     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x0031
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()     // Catch:{ Exception -> 0x003e }
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ Exception -> 0x003e }
            if (r4 == 0) goto L_0x0018
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3     // Catch:{ Exception -> 0x003e }
            goto L_0x0019
        L_0x0018:
            r3 = r0
        L_0x0019:
            if (r3 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r4)     // Catch:{ Exception -> 0x003e }
            goto L_0x0023
        L_0x0022:
            r3 = r0
        L_0x0023:
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0031
            java.lang.String r1 = r3.extLog     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x0031
            org.json.JSONObject r1 = com.baidu.searchbox.video.detail.ext.StringExtKt.toJObj(r1)     // Catch:{ Exception -> 0x003e }
            if (r1 != 0) goto L_0x0036
        L_0x0031:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x003e }
            r1.<init>()     // Catch:{ Exception -> 0x003e }
        L_0x0036:
            java.lang.String r2 = "themeid"
            java.lang.String r0 = r1.optString(r2)     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r1 = move-exception
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x0042:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0051
            int r1 = r1.length()
            if (r1 != 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r1 = 0
            goto L_0x0052
        L_0x0051:
            r1 = 1
        L_0x0052:
            if (r1 != 0) goto L_0x0057
            r6.setThemeId(r0)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.share.CommonSharePlugin.addModelParams(com.baidu.searchbox.video.component.share.ShareModel, int):com.baidu.searchbox.video.component.share.ShareModel");
    }

    public final void hide() {
        getVideoShareUtils().hide();
    }

    /* access modifiers changed from: protected */
    public void buildShareShowPanel(String mediaType, ShareModel model, String realSource, String panelType, String page, String entrance, boolean isShowGuide, boolean isBtnEnhance) {
        ShareModel shareModel = model;
        String str = panelType;
        String str2 = page;
        String str3 = entrance;
        Intrinsics.checkNotNullParameter(mediaType, RtcConstant.RTC_KEY_CALL_MEDIA_TYPE);
        Intrinsics.checkNotNullParameter(shareModel, "model");
        Intrinsics.checkNotNullParameter(realSource, "realSource");
        Intrinsics.checkNotNullParameter(str, "panelType");
        Intrinsics.checkNotNullParameter(str2, "page");
        Intrinsics.checkNotNullParameter(str3, "entrance");
        IVideoShareUtils.ShareBean bean = ShareModel2BeanMapper.INSTANCE.map(shareModel);
        updateShareBean(bean, isShowGuide);
        bean.mPanelStyle = str;
        bean.mPageExt = str2;
        bean.mEntrance = str3;
        List<IVideoShareUtils.ShareMenuTypeWrapper> map = ShareMenuModel2BeanMapper.INSTANCE.map(getShareMenuTypeWrappers());
        IVideoShareUtils videoShareUtils = getVideoShareUtils();
        Context context = getContext();
        String nid = model.getNid();
        String videoInfoExtLog = model.getVideoInfoExtLog();
        IVideoShareUtils.OnItemClickListener onItemClickListener = this.itemClickListener;
        IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener = this.shareListener;
        IVideoShareUtils.IVideoOnSocialListener iVideoOnSocialListener2 = iVideoOnSocialListener;
        IVideoShareUtils.OnItemClickListener onItemClickListener2 = onItemClickListener;
        videoShareUtils.buildShareShowPanel(context, mediaType, bean, realSource, nid, videoInfoExtLog, map, (List<String>) null, onItemClickListener2, iVideoOnSocialListener2, this.lifeCycleListener, isShowGuide, isBtnEnhance);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = (r0 = (com.baidu.searchbox.video.component.share.CommonShareState) (r0 = r0.getState()).select(com.baidu.searchbox.video.component.share.CommonShareState.class)).getHideShareMenuTypeModels();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.baidu.searchbox.video.component.share.ShareMenuTypeModel> getShareMenuTypeWrappers() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r2.getStore()
            if (r0 == 0) goto L_0x002c
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x002c
            java.lang.Class<com.baidu.searchbox.video.component.share.CommonShareState> r1 = com.baidu.searchbox.video.component.share.CommonShareState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.component.share.CommonShareState r0 = (com.baidu.searchbox.video.component.share.CommonShareState) r0
            if (r0 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r0 = r0.getHideShareMenuTypeModels()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r0.getValue()
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 != 0) goto L_0x0057
            com.baidu.searchbox.feed.detail.frame.Store r0 = r2.getStore()
            if (r0 == 0) goto L_0x0057
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0057
            java.lang.Class<com.baidu.searchbox.video.component.share.CommonShareState> r1 = com.baidu.searchbox.video.component.share.CommonShareState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.component.share.CommonShareState r0 = (com.baidu.searchbox.video.component.share.CommonShareState) r0
            if (r0 == 0) goto L_0x0057
            androidx.lifecycle.MutableLiveData r0 = r0.getShareMenuTypeModels()
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0057
            r1 = 0
            return r0
        L_0x0057:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.share.CommonSharePlugin.getShareMenuTypeWrappers():java.util.List");
    }

    public void updateShareBean(IVideoShareUtils.ShareBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
    }

    private final void updateShareBean(IVideoShareUtils.ShareBean bean, boolean isShowGuide) {
        updateShareBean(bean);
        if (isShowGuide && bean.hideSharePanelAnim != 1) {
            bean.hideSharePanelAnim = 1;
        }
    }

    public IVideoShareUtils getVideoShareUtils() {
        IVideoShareUtils videoScene = IVideoShareUtils.Impl.getVideoScene();
        Intrinsics.checkNotNullExpressionValue(videoScene, "getVideoScene()");
        return videoScene;
    }

    public final ShareModel getShareInfo() {
        MutableLiveData<ShareModel> shareModel;
        Store $this$select$iv = getStore();
        if ($this$select$iv == null) {
            return null;
        }
        AbsState state = $this$select$iv.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        CommonShareState commonShareState = (CommonShareState) (commonState != null ? commonState.select(CommonShareState.class) : null);
        if (commonShareState == null || (shareModel = commonShareState.getShareModel()) == null) {
            return null;
        }
        return shareModel.getValue();
    }

    private final void initShareListener() {
        this.shareListener = new CommonSharePlugin$initShareListener$1(this);
    }

    private final void initLifeCycleListener() {
        this.lifeCycleListener = new CommonSharePlugin$initLifeCycleListener$1(this);
    }

    private final void initItemClickListener() {
        this.itemClickListener = new CommonSharePlugin$$ExternalSyntheticLambda2(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: initItemClickListener$lambda-5  reason: not valid java name */
    public static final boolean m5243initItemClickListener$lambda5(CommonSharePlugin this$0, View view2, IVideoShareUtils.ShareMenuMessage message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            ShareBtnMessageModel2BeanMapper shareBtnMessageModel2BeanMapper = ShareBtnMessageModel2BeanMapper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(message, "message");
            store.dispatch(new ShareItemClickAction(view2, shareBtnMessageModel2BeanMapper.map(message)));
        }
        return message != null && Intrinsics.areEqual((Object) "custom", (Object) message.type);
    }
}
