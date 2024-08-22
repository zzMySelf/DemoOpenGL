package com.baidu.searchbox.live.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.host2live.video.ILiveItem;
import com.baidu.searchbox.live.host2live.video.LiveType;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.shell.list.basic.MixBasicFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixCnyFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixConsultFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixNewMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixShopFakeShell;
import com.baidu.searchbox.live.ubc.LiveComponentLoadLogger;
import com.baidu.searchbox.live.ubc.LoadPlayerRoomEvent;
import com.baidu.searchbox.live.ubc.LoadRoomEventHelper;
import com.baidu.searchbox.live.ubc.LoadRoomPart;
import com.baidu.searchbox.live.ubc.PageInfo;
import com.baidu.searchbox.live.ubc.SchemeType;
import com.baidu.searchbox.live.video.LiveActInterfaceImpl;
import com.baidu.searchbox.live.widget.LiveContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0002BCB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000105J\u0018\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020(2\b\u00108\u001a\u0004\u0018\u000109J\u001a\u0010:\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010&H\u0016J+\u0010<\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u000e\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050>2\u0006\u0010?\u001a\u00020@¢\u0006\u0002\u0010AR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl;", "Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "activity", "Landroid/app/Activity;", "roomScheme", "", "uniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "selectedCallback", "Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;)V", "getActivity", "()Landroid/app/Activity;", "getMixActivity", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "model", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getSelectedCallback", "()Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "shell", "Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", "getShell", "()Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", "shell$delegate", "Lkotlin/Lazy;", "getUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "createItemView", "Landroid/view/View;", "position", "", "parent", "Landroid/view/ViewGroup;", "getSchemeModel", "getSchemeShell", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLiveSelected", "view", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "ILiveItemStateChangCallback", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveItemImpl.kt */
public final class LiveItemImpl implements ILiveItem {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveItemImpl.class), "shell", "getShell()Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;"))};
    public static final String ACTION_ENTER_FUSION_ROOM = "/enterStreamRoom";
    public static final String ACTION_ENTER_VIDEO_ROOM = "/enterRoom";
    public static final String ACTION_ENTER_VIDEO_ROOM_HOST = "live";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Activity activity;
    private final IMixActivityInterface mixActivity;
    private final LiveContainer.LiveItemModel model;
    private final String roomScheme;
    private boolean selected;
    private final ILiveItemStateChangCallback selectedCallback;
    private final Lazy shell$delegate;
    private final MiniUniqueId uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl$ILiveItemStateChangCallback;", "", "onSelectedStateChanged", "", "select", "", "liveItemImpl", "Lcom/baidu/searchbox/live/video/LiveItemImpl;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LiveItemImpl.kt */
    public interface ILiveItemStateChangCallback {
        void onSelectedStateChanged(boolean z, LiveItemImpl liveItemImpl);
    }

    public final MixBasicFakeShell getShell() {
        Lazy lazy = this.shell$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MixBasicFakeShell) lazy.getValue();
    }

    public LiveItemImpl(Activity activity2, String roomScheme2, MiniUniqueId uniqueId2, IMixActivityInterface mixActivity2, ILiveItemStateChangCallback selectedCallback2) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(roomScheme2, "roomScheme");
        Intrinsics.checkParameterIsNotNull(uniqueId2, "uniqueId");
        Intrinsics.checkParameterIsNotNull(mixActivity2, "mixActivity");
        this.activity = activity2;
        this.roomScheme = roomScheme2;
        this.uniqueId = uniqueId2;
        this.mixActivity = mixActivity2;
        this.selectedCallback = selectedCallback2;
        this.shell$delegate = LazyKt.lazy(new LiveItemImpl$shell$2(this));
        this.model = getSchemeModel();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final MiniUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public final IMixActivityInterface getMixActivity() {
        return this.mixActivity;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveItemImpl(android.app.Activity r7, java.lang.String r8, com.baidu.live.arch.utils.MiniUniqueId r9, com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface r10, com.baidu.searchbox.live.video.LiveItemImpl.ILiveItemStateChangCallback r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L_0x000a
            r11 = 0
            r12 = r11
            com.baidu.searchbox.live.video.LiveItemImpl$ILiveItemStateChangCallback r12 = (com.baidu.searchbox.live.video.LiveItemImpl.ILiveItemStateChangCallback) r12
            r5 = r11
            goto L_0x000b
        L_0x000a:
            r5 = r11
        L_0x000b:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.video.LiveItemImpl.<init>(android.app.Activity, java.lang.String, com.baidu.live.arch.utils.MiniUniqueId, com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface, com.baidu.searchbox.live.video.LiveItemImpl$ILiveItemStateChangCallback, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ILiveItemStateChangCallback getSelectedCallback() {
        return this.selectedCallback;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveItemImpl$Companion;", "", "()V", "ACTION_ENTER_FUSION_ROOM", "", "ACTION_ENTER_VIDEO_ROOM", "ACTION_ENTER_VIDEO_ROOM_HOST", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LiveItemImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final LiveContainer.LiveItemModel getModel() {
        return this.model;
    }

    /* access modifiers changed from: private */
    public final MixBasicFakeShell getSchemeShell() {
        int i2;
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        StringBuilder append = new StringBuilder().append("LiveItemImpl getSchemeShell model: ");
        LiveContainer.LiveItemModel liveItemModel = this.model;
        companion.log(append.append(liveItemModel != null ? liveItemModel.getTemplateId() : null).toString());
        LiveContainer.LiveItemModel liveItemModel2 = this.model;
        if (liveItemModel2 == null || (i2 = liveItemModel2.getTemplateId()) == null) {
            i2 = 0;
        }
        if (Intrinsics.areEqual(i2, (Object) 3)) {
            return new MixNewMediaFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        if (Intrinsics.areEqual(i2, (Object) 4)) {
            return new MixShopFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        if (Intrinsics.areEqual(i2, (Object) MixConstants.LIVE_COMPONENT_CONSULT)) {
            return new MixConsultFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        LiveContainer.LiveItemModel liveItemModel3 = this.model;
        if (liveItemModel3 == null || !liveItemModel3.isCnyOpen()) {
            return new MixMediaFakeShell(this.activity, this.uniqueId, this.mixActivity);
        }
        return new MixCnyFakeShell(this.activity, this.uniqueId, this.mixActivity);
    }

    private final LiveContainer.LiveItemModel getSchemeModel() {
        LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: " + this.roomScheme);
        Uri uri = Uri.parse(this.roomScheme);
        if ((uri != null ? uri.getHost() : null) != null && uri.getPath() != null && Intrinsics.areEqual((Object) "live", (Object) uri.getHost()) && (Intrinsics.areEqual((Object) uri.getPath(), (Object) "/enterRoom") || Intrinsics.areEqual((Object) uri.getPath(), (Object) "/enterStreamRoom"))) {
            LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 是直播的，开始解析参数");
            try {
                String params = uri.getQueryParameter("params");
                String str = "";
                if (params == null) {
                    params = str;
                }
                Intrinsics.checkExpressionValueIsNotNull(params, "uri.getQueryParameter(\"params\") ?: \"\"");
                IntentData.SchemeModel model2 = IntentData.Companion.parseSchemeData(params, this.roomScheme);
                LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 是直播的，构建直播 " + model2);
                LiveContainer.LiveItemModel liveItemModel = new LiveContainer.LiveItemModel();
                LiveContainer.LiveItemModel $this$apply = liveItemModel;
                $this$apply.setRoomId(model2.getRoomId());
                $this$apply.setCover(model2.getCover());
                String roomType = model2.getRoomType();
                if (roomType == null) {
                    roomType = "0";
                }
                $this$apply.setLiveType(roomType);
                $this$apply.setScheme(this.roomScheme);
                $this$apply.setPlayUrl(model2.getPlayUrl());
                $this$apply.setStatus(model2.getStatus());
                $this$apply.setFormat(model2.getFormat());
                $this$apply.setScreen(model2.getScreen());
                $this$apply.setTemplate(model2.getTemplate());
                $this$apply.setTemplateId(model2.getTemplateId());
                String title = model2.getTitle();
                if (title != null) {
                    str = title;
                }
                $this$apply.setTitle(str);
                $this$apply.setOtherParams(model2.getOtherParams());
                $this$apply.setAvcUrl(model2.getAvcUrl());
                $this$apply.setHevcUrl(model2.getHevcUrl());
                $this$apply.setRtcUrl(model2.getRtcUrl());
                $this$apply.setRtcHevcUrl(model2.getRtcHevcUrl());
                $this$apply.setQuic(model2.getQuic());
                $this$apply.setHighlightUrl(model2.getHighlightUrl());
                $this$apply.setExt(model2.getExt());
                $this$apply.setSource(model2.getSource());
                $this$apply.setShareTaskInfo(model2.getShareTaskInfo());
                $this$apply.setKabrSpts(model2.getKabrSpts());
                $this$apply.setCommonShareInfo(model2.getCommonShareInfo());
                $this$apply.setMultiRate(model2.getMultiRate());
                $this$apply.setFromIntent(model2.getFromIntent());
                $this$apply.setVrParams(model2.getVrParams());
                $this$apply.setPlayRateSetting(model2.getPlayRateSetting());
                $this$apply.setInterventions(model2.getInterventions());
                $this$apply.setCnyOpen(model2.isCnyOpen());
                return liveItemModel;
            } catch (Exception e2) {
                LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 参数解析异常：" + e2.getMessage());
            }
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl getSchemeModel: scheme 校验不通过，model 构建失败");
        return null;
    }

    public View createItemView(int position, ViewGroup parent) {
        LiveActInterfaceImpl.Companion.log("LiveItemImpl createItemView model: " + this.model);
        if (this.model == null) {
            return null;
        }
        View itemView = getShell().createContainerView();
        LiveActInterfaceImpl.Companion.log("LiveItemImpl createItemView itemView: " + itemView);
        getShell().onLiveBindData(this.model);
        LiveActInterfaceImpl.Companion.log("LiveItemImpl shell onLiveBindData end");
        itemView.addOnAttachStateChangeListener(new LiveItemImpl$createItemView$1(this, itemView));
        LiveActInterfaceImpl.Companion.log("LiveItemImpl createItemView itemView 创建成功，返回");
        return itemView;
    }

    public void onLiveSelected(int position, View view2) {
        String templateId;
        LoadRoomPart.Builder index;
        LoadRoomPart.Builder live_type;
        String str;
        ILiveItemStateChangCallback iLiveItemStateChangCallback = this.selectedCallback;
        if (iLiveItemStateChangCallback != null) {
            iLiveItemStateChangCallback.onSelectedStateChanged(true, this);
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onLiveSelected position: " + position + "， model: " + this.model);
        if (this.selected) {
            LiveActInterfaceImpl.Companion.log("LiveItemImpl onLiveSelected 已是选中状态，不再重复调用到直播间");
            return;
        }
        this.selected = true;
        LiveContainer.LiveItemModel it = this.model;
        if (it != null) {
            String str2 = null;
            LoadRoomPart.Builder appendLoadRoomPartBuilder = LoadRoomEventHelper.INSTANCE.appendLoadRoomPartBuilder(it != null ? it.getRoomId() : null);
            String str3 = "";
            if (appendLoadRoomPartBuilder != null) {
                LoadRoomPart.Builder room_id = appendLoadRoomPartBuilder.room_id(it != null ? it.getRoomId() : null);
                if (!(room_id == null || (index = room_id.index(0)) == null || (live_type = index.live_type(String.valueOf(LiveType.MEDIA.ordinal()))) == null)) {
                    if (it == null || (str = it.getTemplateId()) == null) {
                        str = str3;
                    }
                    live_type.template_id(str);
                }
            }
            PageInfo.Builder appendPageInfo = LoadRoomEventHelper.INSTANCE.appendPageInfo();
            if (appendPageInfo != null) {
                appendPageInfo.setScheme_type(SchemeType.UNKNOWN.ordinal());
            }
            LoadPlayerRoomEvent.Builder appendPlayerRoomEventInfo = LoadRoomEventHelper.INSTANCE.appendPlayerRoomEventInfo();
            if (appendPlayerRoomEventInfo != null) {
                appendPlayerRoomEventInfo.source(it.getSource());
            }
            PageInfo.Builder appendPageInfo2 = LoadRoomEventHelper.INSTANCE.appendPageInfo();
            if (appendPageInfo2 != null) {
                appendPageInfo2.page_start_time(System.currentTimeMillis());
            }
            LiveComponentLoadLogger instance = LiveComponentLoadLogger.Companion.getInstance();
            String roomId = it != null ? it.getRoomId() : null;
            if (!(it == null || (templateId = it.getTemplateId()) == null)) {
                str3 = templateId;
            }
            if (it != null) {
                str2 = it.getSource();
            }
            instance.launchMediaCompLoadFlow(roomId, str3, true, str2);
            getShell().onPageSelected(position, it, true);
            LiveActInterfaceImpl.Companion.log("LiveItemImpl shell onPageSelected end");
        }
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onConfigurationChanged");
        if (newConfig != null) {
            Configuration configuration = newConfig;
            getShell().onConfigurationChanged(newConfig);
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl end");
    }

    public final boolean onKeyDown(int keyCode, KeyEvent event) {
        Boolean result;
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onKeyDown: " + keyCode + ", " + event);
        if (event != null) {
            result = Boolean.valueOf(getShell().onKeyDown(keyCode, event));
        } else {
            result = null;
        }
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onKeyDown: end, " + result);
        return Intrinsics.areEqual((Object) result, (Object) true);
    }

    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onActivityResult " + requestCode + ", " + resultCode);
        getShell().onActivityResult(requestCode, resultCode, data);
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onActivityResult " + requestCode + ", " + resultCode);
    }

    public final void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkParameterIsNotNull(permissions, "permissions");
        Intrinsics.checkParameterIsNotNull(grantResults, "grantResults");
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onRequestPermissionsResult " + requestCode);
        getShell().onRequestPermissionsResult(requestCode, permissions, grantResults);
        LiveActInterfaceImpl.Companion.log("LiveItemImpl onRequestPermissionsResult end");
    }
}
