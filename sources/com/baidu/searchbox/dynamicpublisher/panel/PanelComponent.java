package com.baidu.searchbox.dynamicpublisher.panel;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.dynamicpublisher.aipanel.AiPanelAction;
import com.baidu.searchbox.dynamicpublisher.aipanel.service.IAiTextService;
import com.baidu.searchbox.dynamicpublisher.container.ILayoutManagerService;
import com.baidu.searchbox.dynamicpublisher.panel.PanelAction;
import com.baidu.searchbox.dynamicpublisher.panel.model.TextTplDetailModel;
import com.baidu.searchbox.dynamicpublisher.panel.util.StringUtil;
import com.baidu.searchbox.dynamicpublisher.text.EmojiconEditText;
import com.baidu.searchbox.dynamicpublisher.text.service.ITextService;
import com.baidu.searchbox.dynamicpublisher.toolbar.ToolbarAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.event.CombinePublisherEvent;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\u0017\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/panel/PanelComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "currentFragmentSimpleName", "", "dynamicContent", "getDynamicContent", "()Ljava/lang/String;", "dynamicContent$delegate", "Lkotlin/Lazy;", "isClickedTemplate", "", "()Z", "setClickedTemplate", "(Z)V", "mUgcPanelSwitcher", "Lcom/baidu/searchbox/dynamicpublisher/panel/UgcPanelSwitcher;", "getMUgcPanelSwitcher", "()Lcom/baidu/searchbox/dynamicpublisher/panel/UgcPanelSwitcher;", "setMUgcPanelSwitcher", "(Lcom/baidu/searchbox/dynamicpublisher/panel/UgcPanelSwitcher;)V", "sourceFrom", "getSourceFrom", "sourceFrom$delegate", "createView", "Landroid/view/View;", "handleTextTplClick", "", "id", "models", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/dynamicpublisher/panel/model/TextTplDetailModel;", "Lkotlin/collections/ArrayList;", "initHalfPhotoPlace", "onAttachToManager", "onPause", "onRelease", "onResume", "openAi", "type", "", "(Ljava/lang/Integer;)V", "panelInitAction", "Companion", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PanelComponent.kt */
public class PanelComponent extends LiveDataComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String combineDynamicFragment = "CombineDynamicFragment";
    public static final String combineLiveFragment = "CombineLiveFragment";
    public static final String combineVideoFragment = "CombineVideoFragment";
    public static final String mvpPublisherFragment = "MvpPublisherFragment";
    public static final String publishSameFragment = "PublishSameFragment";
    /* access modifiers changed from: private */
    public String currentFragmentSimpleName = combineDynamicFragment;
    private final Lazy dynamicContent$delegate = LazyKt.lazy(new PanelComponent$dynamicContent$2(this));
    private boolean isClickedTemplate;
    private UgcPanelSwitcher mUgcPanelSwitcher;
    private final Lazy sourceFrom$delegate = LazyKt.lazy(new PanelComponent$sourceFrom$2(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/panel/PanelComponent$Companion;", "", "()V", "combineDynamicFragment", "", "combineLiveFragment", "combineVideoFragment", "mvpPublisherFragment", "publishSameFragment", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PanelComponent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final UgcPanelSwitcher getMUgcPanelSwitcher() {
        return this.mUgcPanelSwitcher;
    }

    /* access modifiers changed from: protected */
    public final void setMUgcPanelSwitcher(UgcPanelSwitcher ugcPanelSwitcher) {
        this.mUgcPanelSwitcher = ugcPanelSwitcher;
    }

    /* access modifiers changed from: protected */
    public final boolean isClickedTemplate() {
        return this.isClickedTemplate;
    }

    /* access modifiers changed from: protected */
    public final void setClickedTemplate(boolean z) {
        this.isClickedTemplate = z;
    }

    private final String getDynamicContent() {
        return (String) this.dynamicContent$delegate.getValue();
    }

    private final String getSourceFrom() {
        return (String) this.sourceFrom$delegate.getValue();
    }

    public View createView() {
        View inflate = View.inflate(getContext(), R.layout.dynamic_publisher_panel_inner_layout, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…panel_inner_layout, null)");
        return inflate;
    }

    public void onAttachToManager() {
        UgcPanelState $this$onAttachToManager_u24lambda_u2d7;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d7 = (UgcPanelState) store.subscribe((Class<T>) UgcPanelState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d7.getPanelInit().observe(this, new PanelComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d7.getPanelSwitch().observe(this, new PanelComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d7.getCollection().observe(this, new PanelComponent$$ExternalSyntheticLambda2(this));
        }
        BdEventBus.Companion.getDefault().register(this, CombinePublisherEvent.class, 1, new PanelComponent$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-3  reason: not valid java name */
    public static final void m18134onAttachToManager$lambda7$lambda3(PanelComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() instanceof Activity) {
            ViewGroup rootView = (ViewGroup) ((Activity) this$0.getContext()).findViewById(16908290);
            ILayoutManagerService iLayoutManagerService = (ILayoutManagerService) this$0.getManager().getService(ILayoutManagerService.class);
            EmojiconEditText focusView = null;
            SPSwitchPanelLinearLayout panelParentView = iLayoutManagerService != null ? iLayoutManagerService.getPanelContainer() : null;
            if (panelParentView != null) {
                SPSwitchPanelLinearLayout it2 = panelParentView;
                if (rootView != null) {
                    this$0.mUgcPanelSwitcher = new UgcPanelSwitcher((Activity) this$0.getContext(), rootView, it2);
                }
            }
            ITextService iTextService = (ITextService) this$0.getManager().getService(ITextService.class);
            if (iTextService != null) {
                focusView = iTextService.getEmojiconEditText();
            }
            if (focusView != null) {
                EmojiconEditText it3 = focusView;
                UgcPanelSwitcher ugcPanelSwitcher = this$0.mUgcPanelSwitcher;
                if (ugcPanelSwitcher != null) {
                    ugcPanelSwitcher.configEmotionPanel(it3, new PanelComponent$$ExternalSyntheticLambda4());
                }
            }
        }
        UgcPanelSwitcher ugcPanelSwitcher2 = this$0.mUgcPanelSwitcher;
        if (ugcPanelSwitcher2 != null) {
            ugcPanelSwitcher2.configTextTplPanel(new PanelComponent$onAttachToManager$1$1$3(this$0));
        }
        UgcPanelSwitcher ugcPanelSwitcher3 = this$0.mUgcPanelSwitcher;
        if (ugcPanelSwitcher3 != null) {
            ugcPanelSwitcher3.setPanelStateListener(new PanelComponent$onAttachToManager$1$1$4(this$0));
        }
        if (!this$0.initHalfPhotoPlace() || !Intrinsics.areEqual((Object) this$0.getSourceFrom(), (Object) UgcConstant.SOURCE_FROM_COMMENT_AI)) {
            this$0.panelInitAction();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m18135onAttachToManager$lambda7$lambda3$lambda2$lambda1(EmotionType emotionType, int i2, String emoId, String str) {
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-5  reason: not valid java name */
    public static final void m18136onAttachToManager$lambda7$lambda5(PanelComponent this$0, Integer type) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((type != null && type.intValue() == 5) || ((type != null && type.intValue() == 6) || ((type != null && type.intValue() == 7) || (type != null && type.intValue() == 8)))) {
            this$0.openAi(type);
            return;
        }
        ITextService iTextService = (ITextService) this$0.getManager().getService(ITextService.class);
        EmojiconEditText focusView = iTextService != null ? iTextService.getEmojiconEditText() : null;
        if (focusView != null) {
            EmojiconEditText view2 = focusView;
            UgcPanelSwitcher ugcPanelSwitcher = this$0.mUgcPanelSwitcher;
            if (ugcPanelSwitcher != null) {
                Intrinsics.checkNotNullExpressionValue(type, "type");
                ugcPanelSwitcher.switchPanel(type.intValue(), view2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-6  reason: not valid java name */
    public static final void m18137onAttachToManager$lambda7$lambda6(PanelComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            store.dispatch(new PanelAction.SendData(this$0.isClickedTemplate));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8  reason: not valid java name */
    public static final void m18138onAttachToManager$lambda8(PanelComponent this$0, CombinePublisherEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (22 == it.eventType) {
            String str = it.fragmentName;
            Intrinsics.checkNotNullExpressionValue(str, "it.fragmentName");
            this$0.currentFragmentSimpleName = str;
        }
    }

    public void panelInitAction() {
    }

    private final void openAi(Integer type) {
        String str;
        Store<AbsState> store;
        EditText focusView = null;
        IAiTextService iAiTextService = (IAiTextService) getManager().getService(IAiTextService.class);
        EmojiconEditText dynamicView = null;
        EditText aiEditText = iAiTextService != null ? iAiTextService.getAiEditText() : null;
        boolean rewritingAndContinuation = false;
        int i2 = 5;
        if (((type != null && type.intValue() == 5) || (type != null && type.intValue() == 7)) && (store = getStore()) != null) {
            store.dispatch(new ToolbarAction.ChangeToolbarVisible(false));
        }
        ITextService iTextService = (ITextService) getManager().getService(ITextService.class);
        if (iTextService != null) {
            dynamicView = iTextService.getEmojiconEditText();
        }
        if (dynamicView != null) {
            EmojiconEditText emojiconEditText = dynamicView;
            String content = String.valueOf(dynamicView.getText());
            String str2 = "";
            if (!TextUtils.isEmpty(content)) {
                str = StringUtil.INSTANCE.filterStr(StringUtil.INSTANCE.filterGroup(StringUtil.INSTANCE.filterAt(StringUtil.INSTANCE.filterEmoji(content))));
            } else {
                str = str2;
            }
            String content2 = str;
            focusView = aiEditText;
            if ((type != null && type.intValue() == 5) || (type != null && type.intValue() == 6)) {
                int length = StringsKt.trim((CharSequence) content2).toString().length();
                if (6 <= length && length < 1000) {
                    rewritingAndContinuation = true;
                }
                focusView = rewritingAndContinuation ? dynamicView : aiEditText;
                Store<AbsState> store2 = getStore();
                if (store2 != null) {
                    if (rewritingAndContinuation) {
                        str2 = content2;
                    }
                    store2.dispatch(new AiPanelAction.SwitchPanel(str2));
                }
            }
        }
        if ((type == null || type.intValue() != 5) && (type == null || type.intValue() != 7)) {
            i2 = 6;
        }
        int targetType = i2;
        if (focusView != null) {
            EditText view2 = focusView;
            UgcPanelSwitcher ugcPanelSwitcher = this.mUgcPanelSwitcher;
            if (ugcPanelSwitcher != null) {
                ugcPanelSwitcher.switchPanel(targetType, view2);
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        EmojiconEditText focusView;
        UgcPanelSwitcher ugcPanelSwitcher;
        super.onPause();
        ITextService iTextService = (ITextService) getManager().getService(ITextService.class);
        if (iTextService != null && (focusView = iTextService.getEmojiconEditText()) != null && (ugcPanelSwitcher = this.mUgcPanelSwitcher) != null) {
            ugcPanelSwitcher.switchPanel(0, focusView);
        }
    }

    public void onRelease() {
        super.onRelease();
        UgcPanelSwitcher ugcPanelSwitcher = this.mUgcPanelSwitcher;
        if (ugcPanelSwitcher != null) {
            ugcPanelSwitcher.releaseEmotionPanel();
        }
        BdEventBus.Companion.getDefault().unregister(this);
    }

    /* access modifiers changed from: private */
    public final void handleTextTplClick(String id, ArrayList<TextTplDetailModel> models) {
        EmojiconEditText it;
        UgcPanelSwitcher ugcPanelSwitcher;
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new PanelAction.ClickTextTplPanel(id, models));
        }
        ITextService iTextService = (ITextService) getManager().getService(ITextService.class);
        if (iTextService != null && (it = iTextService.getEmojiconEditText()) != null && (ugcPanelSwitcher = this.mUgcPanelSwitcher) != null) {
            ugcPanelSwitcher.switchPanel(2, it);
        }
    }

    private final boolean initHalfPhotoPlace() {
        String str;
        if (!TextUtils.isEmpty(getDynamicContent())) {
            str = StringUtil.INSTANCE.filterStr(StringUtil.INSTANCE.filterGroup(StringUtil.INSTANCE.filterAt(StringUtil.INSTANCE.filterEmoji(getDynamicContent()))));
        } else {
            str = "";
        }
        return StringsKt.trim((CharSequence) str).toString().length() > 5;
    }
}
