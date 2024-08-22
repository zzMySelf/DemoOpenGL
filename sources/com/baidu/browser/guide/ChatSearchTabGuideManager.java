package com.baidu.browser.guide;

import android.view.View;
import com.baidu.android.ext.manage.BasePopTask;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.browser.utils.SearchPreferenceUtils;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J/\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/baidu/browser/guide/ChatSearchTabGuideManager;", "Lcom/baidu/android/ext/manage/PopItem;", "()V", "HAS_SHOW_CHAT_SEARCH_TAB_GUIDE", "", "METHOD_MANE", "bubbleManagerRef", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "hasShowBubbleGuide", "", "Ljava/lang/Boolean;", "dismissBubble", "", "mutexDismiss", "mutexShow", "methodName", "params", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Z", "saveHasShowBubbleGuide", "shouldShowGuide", "showGuideBubble", "anchor", "Landroid/view/View;", "showGuideBubbleMutex", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchTabGuideManager.kt */
public final class ChatSearchTabGuideManager implements PopItem {
    private static final String HAS_SHOW_CHAT_SEARCH_TAB_GUIDE = "hasShowChatSearchTabGuide";
    public static final ChatSearchTabGuideManager INSTANCE = new ChatSearchTabGuideManager();
    private static final String METHOD_MANE = "showTabEntranceGuide";
    private static WeakReference<BubbleTextManager> bubbleManagerRef;
    private static Boolean hasShowBubbleGuide;

    private ChatSearchTabGuideManager() {
    }

    public final void showGuideBubbleMutex(View anchor) {
        if (shouldShowGuide()) {
            BasePopTask basePopTask = new BasePopTask(this, 0, true, false, false, METHOD_MANE, anchor);
            basePopTask.setFinalCheck(new ChatSearchTabGuideManager$$ExternalSyntheticLambda0());
            if (anchor != null) {
                anchor.postDelayed(new ChatSearchTabGuideManager$$ExternalSyntheticLambda1(basePopTask), 250);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showGuideBubbleMutex$lambda-0  reason: not valid java name */
    public static final boolean m12972showGuideBubbleMutex$lambda0() {
        return INSTANCE.shouldShowGuide();
    }

    /* access modifiers changed from: private */
    /* renamed from: showGuideBubbleMutex$lambda-1  reason: not valid java name */
    public static final void m12973showGuideBubbleMutex$lambda1(BasePopTask $task) {
        Intrinsics.checkNotNullParameter($task, "$task");
        $task.execute();
    }

    public void mutexDismiss() {
    }

    public boolean mutexShow(String methodName, Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.length == 0) {
            return false;
        }
        View view2 = params[0];
        View anchor = view2 instanceof View ? view2 : null;
        if (anchor == null || !Intrinsics.areEqual((Object) methodName, (Object) METHOD_MANE)) {
            return false;
        }
        showGuideBubble(anchor);
        return true;
    }

    private final void showGuideBubble(View anchor) {
        BubbleTextManager bubbleManager = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(ChatSearchTabGuideListener.Companion.getGuideString()).setAnchorView(anchor).enableAnimation(true).enableClkDismiss(true).setPaddingBetweenAnchor(-8.0f).setAutoDismissInterval(3000).setShadowIsDeviate(false).setBubbleAlpha(0.9f).setForceShowPosition(BubblePosition.DOWN).build();
        if (bubbleManager != null) {
            bubbleManager.setOnBubbleEventListener(new ChatSearchTabGuideManager$showGuideBubble$1());
        }
        if (bubbleManager != null) {
            bubbleManager.showBubble();
        }
        bubbleManagerRef = new WeakReference<>(bubbleManager);
    }

    public final void dismissBubble() {
        BubbleTextManager bubbleTextManager;
        WeakReference<BubbleTextManager> weakReference = bubbleManagerRef;
        if (weakReference != null && (bubbleTextManager = (BubbleTextManager) weakReference.get()) != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    private final boolean shouldShowGuide() {
        if (hasShowBubbleGuide == null) {
            hasShowBubbleGuide = Boolean.valueOf(SearchPreferenceUtils.getInstance().getBoolean(HAS_SHOW_CHAT_SEARCH_TAB_GUIDE, false));
        }
        Boolean bool = hasShowBubbleGuide;
        Intrinsics.checkNotNull(bool);
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public final void saveHasShowBubbleGuide() {
        hasShowBubbleGuide = true;
        SearchPreferenceUtils.getInstance().putBoolean(HAS_SHOW_CHAT_SEARCH_TAB_GUIDE, true);
    }
}
