package com.baidu.searchbox.video.feedflow.detail.ocrsummary.utils;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.widget.textselect.core.BdTextSelectHelper;
import com.baidu.android.widget.textselect.core.SelectionInfo;
import com.baidu.android.widget.textselect.listener.LimitRegionProvider;
import com.baidu.android.widget.textselect.listener.TextSelectStateChangedListener;
import com.baidu.ops.lc.patchupdate.GDiffPatcher;
import com.baidu.searchbox.factory.BuildinFloatMenuResEnum;
import com.baidu.searchbox.floatmenu.BdFloatMenuItem;
import com.baidu.searchbox.menuFunc.FloatMenuScene;
import com.baidu.searchbox.menuFunc.param.BaseFloatMenuFuncParam;
import com.baidu.searchbox.textselectmenu.BdTextSelectMenu;
import com.baidu.searchbox.ui.span.BdLinkTouchMovementMethod;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.ocrinterface.ItemViewClickListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/utils/OcrTextSelectorHelper;", "", "textView", "Landroid/widget/TextView;", "listener", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/ocrinterface/ItemViewClickListener;", "(Landroid/widget/TextView;Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/ocrinterface/ItemViewClickListener;)V", "getListener", "()Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/ocrinterface/ItemViewClickListener;", "selectHelper", "Lcom/baidu/android/widget/textselect/core/BdTextSelectHelper;", "getTextView", "()Landroid/widget/TextView;", "reset", "", "SelectMenu", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrTextSelectorHelper.kt */
public final class OcrTextSelectorHelper {
    private final ItemViewClickListener listener;
    private BdTextSelectHelper selectHelper;
    private final TextView textView;

    public OcrTextSelectorHelper(TextView textView2, ItemViewClickListener listener2) {
        Intrinsics.checkNotNullParameter(textView2, "textView");
        this.textView = textView2;
        this.listener = listener2;
        BdTextSelectHelper bdTextSelectHelper = new BdTextSelectHelper(textView2, 0, 0, 0, 0.0f, false, false, (View) null, GDiffPatcher.COPY_INT_INT, (DefaultConstructorMarker) null);
        this.selectHelper = bdTextSelectHelper;
        bdTextSelectHelper.setSelectTextWhenLongClick(true);
        this.selectHelper.setAutoHookLongClick(true);
        this.selectHelper.setCanTextScroll(true);
        new SelectMenu().bindTextSelectHelper(this.selectHelper);
        this.selectHelper.setSelectStateChangeListener(new TextSelectStateChangedListener() {
            public void onSelectStateChanged(TextView textView, boolean isSelecting) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                if (isSelecting) {
                    BdLinkTouchMovementMethod.getInstance().clearSpanUiStatus(textView);
                }
            }

            public void onSelectionChanged(TextView textView, int start, int end, CharSequence content) {
                Intrinsics.checkNotNullParameter(textView, "textView");
            }
        });
        this.selectHelper.setLimitRegionProvider(new LimitRegionProvider(this) {
            final /* synthetic */ OcrTextSelectorHelper this$0;

            {
                this.this$0 = $receiver;
            }

            public Rect getLimitRegion(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                ItemViewClickListener listener = this.this$0.getListener();
                if (listener != null) {
                    return listener.getContentRect();
                }
                return null;
            }
        });
    }

    public final ItemViewClickListener getListener() {
        return this.listener;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void reset() {
        BdTextSelectHelper.cancelSelect$default(this.selectHelper, false, 1, (Object) null);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/utils/OcrTextSelectorHelper$SelectMenu;", "Lcom/baidu/searchbox/textselectmenu/BdTextSelectMenu;", "()V", "buildMenuItems", "", "Lcom/baidu/searchbox/floatmenu/BdFloatMenuItem;", "requestTag", "", "menuScene", "Lcom/baidu/searchbox/menuFunc/FloatMenuScene;", "getBusinessTag", "", "getFuncParam", "Lcom/baidu/searchbox/menuFunc/param/BaseFloatMenuFuncParam;", "itemEnum", "Lcom/baidu/searchbox/factory/BuildinFloatMenuResEnum;", "getMenuScene", "onMenuItemClicked", "", "anchor", "Landroid/view/View;", "menuItem", "onMenuStateChanged", "", "isShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OcrTextSelectorHelper.kt */
    public static final class SelectMenu extends BdTextSelectMenu {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: OcrTextSelectorHelper.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[BuildinFloatMenuResEnum.values().length];
                iArr[BuildinFloatMenuResEnum.FLOAT_MENU_COPY.ordinal()] = 1;
                iArr[BuildinFloatMenuResEnum.FLOAT_MENU_SEARCH.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public String getBusinessTag() {
            return "";
        }

        public List<BdFloatMenuItem> buildMenuItems(int requestTag, FloatMenuScene menuScene) {
            return null;
        }

        public void onMenuStateChanged(View anchor, boolean isShow) {
            Intrinsics.checkNotNullParameter(anchor, "anchor");
        }

        public boolean onMenuItemClicked(View anchor, BdFloatMenuItem menuItem) {
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            return false;
        }

        public BaseFloatMenuFuncParam getFuncParam(BuildinFloatMenuResEnum itemEnum) {
            Intrinsics.checkNotNullParameter(itemEnum, "itemEnum");
            BaseFloatMenuFuncParam baseFloatMenuFuncParam = null;
            BdTextSelectHelper helper = getMTextSelectHelper();
            if (helper != null) {
                SelectionInfo selection = helper.getMSelectionInfo();
                baseFloatMenuFuncParam = new BaseFloatMenuFuncParam();
                switch (WhenMappings.$EnumSwitchMapping$0[itemEnum.ordinal()]) {
                    case 1:
                        baseFloatMenuFuncParam.setMainParam(String.valueOf(selection.getSelectionContent()));
                        break;
                    case 2:
                        baseFloatMenuFuncParam.setMainParam(String.valueOf(selection.getSelectionContent()));
                        break;
                }
            }
            return baseFloatMenuFuncParam;
        }

        public FloatMenuScene getMenuScene() {
            return FloatMenuScene.COPY_AND_SEAECH;
        }
    }
}
