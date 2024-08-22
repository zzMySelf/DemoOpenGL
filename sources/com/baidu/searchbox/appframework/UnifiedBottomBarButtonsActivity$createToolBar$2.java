package com.baidu.searchbox.appframework;

import android.content.Context;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.base.OnBottomBarElementClickListener;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/appframework/UnifiedBottomBarButtonsActivity$createToolBar$2", "Lcom/baidu/searchbox/unifiedtoolbar/base/OnBottomBarElementClickListener;", "onBottomBarElementClick", "", "context", "Lcom/baidu/searchbox/unifiedtoolbar/base/BarElementClickContext;", "lib-appframework-demo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnifiedBottomBarButtonsActivity.kt */
public final class UnifiedBottomBarButtonsActivity$createToolBar$2 implements OnBottomBarElementClickListener {
    final /* synthetic */ UnifiedBottomBar $bar;
    final /* synthetic */ int $buttonsSize;
    final /* synthetic */ UnifiedBottomBarButtonsActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnifiedBottomBarButtonsActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomBarElementID.values().length];
            iArr[BottomBarElementID.ELEMENT_ID_BACK.ordinal()] = 1;
            iArr[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1.ordinal()] = 2;
            iArr[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2.ordinal()] = 3;
            iArr[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_3.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    UnifiedBottomBarButtonsActivity$createToolBar$2(UnifiedBottomBarButtonsActivity $receiver, int $buttonsSize2, UnifiedBottomBar $bar2) {
        this.this$0 = $receiver;
        this.$buttonsSize = $buttonsSize2;
        this.$bar = $bar2;
    }

    public boolean onBottomBarElementClick(BarElementClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.$EnumSwitchMapping$0[context.getElementId().ordinal()]) {
            case 1:
                UniversalToast.makeText((Context) this.this$0, (CharSequence) "返回被点击").setLocation(ToastLocation.BOTTOM).show();
                return false;
            case 2:
                UniversalToast.makeText((Context) this.this$0, (CharSequence) String.valueOf(context.getElementId())).setLocation(ToastLocation.BOTTOM).show();
                return true;
            case 3:
                UniversalToast.makeText((Context) this.this$0, (CharSequence) String.valueOf(context.getElementId())).setLocation(ToastLocation.BOTTOM).show();
                if (this.$buttonsSize == 3) {
                    this.$bar.startFuncButtonLoading(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2);
                    UnifiedBottomBar.setElementEnabled$default(this.$bar, BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2, false, false, false, 12, (Object) null);
                    UnifiedBottomBar unifiedBottomBar = this.$bar;
                    unifiedBottomBar.postDelayed(new UnifiedBottomBarButtonsActivity$createToolBar$2$$ExternalSyntheticLambda0(unifiedBottomBar), 1500);
                }
                return true;
            case 4:
                UniversalToast.makeText((Context) this.this$0, (CharSequence) String.valueOf(context.getElementId())).setLocation(ToastLocation.BOTTOM).show();
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBottomBarElementClick$lambda-0  reason: not valid java name */
    public static final void m15959onBottomBarElementClick$lambda0(UnifiedBottomBar $bar2) {
        Intrinsics.checkNotNullParameter($bar2, "$bar");
        $bar2.cancelFuncButtonLoading(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2);
        UnifiedBottomBar.setElementEnabled$default($bar2, BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2, true, false, false, 12, (Object) null);
    }
}
