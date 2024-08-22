package com.baidu.mms.voicesearch.voice.view.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.SwitchBaseView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting.VoiceAssistantSettingBaseItemView;
import com.baidu.mms.voicesearch.voice.bean.dao.VoiceAssistantBean;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.view.guide.AssistantGuideItemView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00140\u001eJ\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0011J\"\u0010!\u001a\u00020\u00172\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010#2\u0006\u0010$\u001a\u00020\nH\u0016J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u000eR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00140\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0014`\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideSwitchView;", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/SwitchBaseView;", "Lcom/baidu/mms/voicesearch/voice/bean/dao/VoiceAssistantBean;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "controllerRef", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/VoiceAssistantController;", "initIndex", "itemCheckedCallBack", "Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideItemView$AssistantCheckedCallBack;", "mViewMap", "Ljava/util/HashMap;", "Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideItemView;", "Lkotlin/collections/HashMap;", "addNewViewToParent", "", "index", "isFirst", "", "isLast", "getController", "getViewMap", "", "setAssistantCheckedCallBack", "callBack", "setData", "data", "", "offset", "setInitIndex", "setVoiceAssistantController", "controller", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantGuideSwitchView.kt */
public final class AssistantGuideSwitchView extends SwitchBaseView<VoiceAssistantBean> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private WeakReference<VoiceAssistantController> controllerRef;
    private int initIndex;
    private AssistantGuideItemView.AssistantCheckedCallBack itemCheckedCallBack;
    private HashMap<Integer, AssistantGuideItemView> mViewMap;

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

    public AssistantGuideSwitchView(Context context) {
        super(context);
        this.mViewMap = new HashMap<>();
    }

    public AssistantGuideSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mViewMap = new HashMap<>();
    }

    public AssistantGuideSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mViewMap = new HashMap<>();
    }

    public void setData(List<VoiceAssistantBean> data, int offset) {
        super.setData(data, offset);
        if (data != null && !data.isEmpty()) {
            int size = data.size();
            for (int i2 = 0; i2 < size; i2++) {
                View item = getChildAt(i2);
                if (item instanceof AssistantGuideItemView) {
                    item.setOnClickListener(new AssistantGuideSwitchView$$ExternalSyntheticLambda0(this, item));
                }
            }
            post(new AssistantGuideSwitchView$$ExternalSyntheticLambda1(this));
            setOnClickListener(new AssistantGuideSwitchView$$ExternalSyntheticLambda2());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-0  reason: not valid java name */
    public static final void m14030setData$lambda0(AssistantGuideSwitchView this$0, View $item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.getTag() instanceof Integer) {
            Object tag = it.getTag();
            if (tag != null) {
                this$0.switchToFirst(((Integer) tag).intValue(), true);
                Intrinsics.checkNotNullExpressionValue($item, "item");
                VoiceAssistantSettingBaseItemView.setChecked$default((VoiceAssistantSettingBaseItemView) $item, true, false, 2, (Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-1  reason: not valid java name */
    public static final void m14031setData$lambda1(AssistantGuideSwitchView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateLength((int) Tools.dip2px(7.0f), 0);
        this$0.switchToFirst(this$0.initIndex, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-2  reason: not valid java name */
    public static final void m14032setData$lambda2(View it) {
    }

    /* access modifiers changed from: protected */
    public void addNewViewToParent(int index, boolean isFirst, boolean isLast) {
        super.addNewViewToParent(index, isFirst, isLast);
        AssistantGuideItemView childView = new AssistantGuideItemView(getContext());
        LinearLayout.LayoutParams childViewLp = new LinearLayout.LayoutParams((int) Tools.dip2px(85.0f), (int) Tools.dip2px(67.0f));
        if (!isLast) {
            childViewLp.rightMargin = (int) Tools.dip2px(7.0f);
        }
        if (isFirst) {
            childViewLp.leftMargin = 0;
        }
        if (isLast) {
            childViewLp.rightMargin = 0;
        }
        childView.setTag(Integer.valueOf(index));
        childView.setAssistantCheckedCallBack(this.itemCheckedCallBack);
        VoiceAssistantController controller = getController();
        if (controller != null) {
            controller.addToObserver(childView);
        }
        childView.setVoiceAssistantController(getController());
        childView.initData((VoiceAssistantBean) getItem(index));
        Map map = this.mViewMap;
        VoiceAssistantBean voiceAssistantBean = (VoiceAssistantBean) getItem(index);
        map.put(voiceAssistantBean != null ? Integer.valueOf(voiceAssistantBean.getId()) : null, childView);
        addView(childView, index, childViewLp);
    }

    private final VoiceAssistantController getController() {
        WeakReference<VoiceAssistantController> weakReference = this.controllerRef;
        if (weakReference != null) {
            return (VoiceAssistantController) weakReference.get();
        }
        return null;
    }

    public final void setInitIndex(int index) {
        this.initIndex = index;
    }

    public final void setAssistantCheckedCallBack(AssistantGuideItemView.AssistantCheckedCallBack callBack) {
        this.itemCheckedCallBack = callBack;
    }

    public final void setVoiceAssistantController(VoiceAssistantController controller) {
        this.controllerRef = new WeakReference<>(controller);
    }

    public final Map<Integer, AssistantGuideItemView> getViewMap() {
        return this.mViewMap;
    }
}
