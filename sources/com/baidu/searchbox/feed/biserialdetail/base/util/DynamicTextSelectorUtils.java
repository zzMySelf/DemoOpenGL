package com.baidu.searchbox.feed.biserialdetail.base.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.widget.textselect.core.BdTextSelectHelper;
import com.baidu.android.widget.textselect.core.SelectionInfo;
import com.baidu.android.widget.textselect.listener.SelectableTextTouchListener;
import com.baidu.ops.lc.patchupdate.GDiffPatcher;
import com.baidu.searchbox.factory.BuildinFloatMenuResEnum;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.biserialdetail.R;
import com.baidu.searchbox.feed.biserialdetail.model.DynamicDetailFlow;
import com.baidu.searchbox.feed.biserialdetail.ubc.DynamicDetailStatisticsHelper;
import com.baidu.searchbox.feed.model.ShareBaseBean;
import com.baidu.searchbox.feed.ui.textselector.SelectorTextEventKt;
import com.baidu.searchbox.feed.ui.textselector.TextSelectorMenuStatisticsKt;
import com.baidu.searchbox.floatmenu.BdFloatMenuItem;
import com.baidu.searchbox.menuFunc.FloatMenuScene;
import com.baidu.searchbox.menuFunc.param.BaseFloatMenuFuncParam;
import com.baidu.searchbox.textselectmenu.BdTextSelectMenu;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/base/util/DynamicTextSelectorUtils;", "", "()V", "supportTextSelector", "", "textView", "Landroid/widget/TextView;", "touchListener", "Lcom/baidu/android/widget/textselect/listener/SelectableTextTouchListener;", "statisticsHelper", "Lcom/baidu/searchbox/feed/biserialdetail/ubc/DynamicDetailStatisticsHelper;", "model", "Lcom/baidu/searchbox/feed/biserialdetail/model/DynamicDetailFlow$DynamicDetailBaseModel;", "context", "Landroid/content/Context;", "DynamicSelectMenu", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicTextSelectorUtils.kt */
public final class DynamicTextSelectorUtils {
    public static final DynamicTextSelectorUtils INSTANCE = new DynamicTextSelectorUtils();

    private DynamicTextSelectorUtils() {
    }

    public final void supportTextSelector(TextView textView, SelectableTextTouchListener touchListener, DynamicDetailStatisticsHelper statisticsHelper, DynamicDetailFlow.DynamicDetailBaseModel model, Context context) {
        SelectableTextTouchListener selectableTextTouchListener = touchListener;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(selectableTextTouchListener, "touchListener");
        Intrinsics.checkNotNullParameter(context2, "context");
        BdTextSelectHelper bdTextSelectHelper = new BdTextSelectHelper(textView, 0, 0, 0, 0.0f, false, false, (View) null, GDiffPatcher.COPY_INT_INT, (DefaultConstructorMarker) null);
        bdTextSelectHelper.setSelectTextWhenLongClick(true);
        bdTextSelectHelper.setAutoHookLongClick(true);
        bdTextSelectHelper.setSelectableTextTouchListener(selectableTextTouchListener);
        bdTextSelectHelper.setSelectStateChangeListener(new DynamicTextSelectorUtils$supportTextSelector$1$1());
        new DynamicSelectMenu(context2, statisticsHelper, model).bindTextSelectHelper(bdTextSelectHelper);
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u001fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/base/util/DynamicTextSelectorUtils$DynamicSelectMenu;", "Lcom/baidu/searchbox/textselectmenu/BdTextSelectMenu;", "context", "Landroid/content/Context;", "statisticsHelper", "Lcom/baidu/searchbox/feed/biserialdetail/ubc/DynamicDetailStatisticsHelper;", "model", "Lcom/baidu/searchbox/feed/biserialdetail/model/DynamicDetailFlow$DynamicDetailBaseModel;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/biserialdetail/ubc/DynamicDetailStatisticsHelper;Lcom/baidu/searchbox/feed/biserialdetail/model/DynamicDetailFlow$DynamicDetailBaseModel;)V", "getContext", "()Landroid/content/Context;", "getModel", "()Lcom/baidu/searchbox/feed/biserialdetail/model/DynamicDetailFlow$DynamicDetailBaseModel;", "getStatisticsHelper", "()Lcom/baidu/searchbox/feed/biserialdetail/ubc/DynamicDetailStatisticsHelper;", "buildMenuItems", "", "Lcom/baidu/searchbox/floatmenu/BdFloatMenuItem;", "requestTag", "", "menuScene", "Lcom/baidu/searchbox/menuFunc/FloatMenuScene;", "getBusinessTag", "", "getFuncParam", "Lcom/baidu/searchbox/menuFunc/param/BaseFloatMenuFuncParam;", "itemEnum", "Lcom/baidu/searchbox/factory/BuildinFloatMenuResEnum;", "getMenuScene", "menuUbcPage", "onMenuItemClicked", "", "anchor", "Landroid/view/View;", "menuItem", "onMenuStateChanged", "", "isShow", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicTextSelectorUtils.kt */
    public static final class DynamicSelectMenu extends BdTextSelectMenu {
        private final Context context;
        private final DynamicDetailFlow.DynamicDetailBaseModel model;
        private final DynamicDetailStatisticsHelper statisticsHelper;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DynamicTextSelectorUtils.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[BuildinFloatMenuResEnum.values().length];
                iArr[BuildinFloatMenuResEnum.FLOAT_MENU_COPY.ordinal()] = 1;
                iArr[BuildinFloatMenuResEnum.FLOAT_MENU_SEARCH.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final Context getContext() {
            return this.context;
        }

        public final DynamicDetailStatisticsHelper getStatisticsHelper() {
            return this.statisticsHelper;
        }

        public final DynamicDetailFlow.DynamicDetailBaseModel getModel() {
            return this.model;
        }

        public DynamicSelectMenu(Context context2, DynamicDetailStatisticsHelper statisticsHelper2, DynamicDetailFlow.DynamicDetailBaseModel model2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            this.statisticsHelper = statisticsHelper2;
            this.model = model2;
        }

        public String getBusinessTag() {
            return "dt_landing";
        }

        public String menuUbcPage() {
            return "text";
        }

        public List<BdFloatMenuItem> buildMenuItems(int requestTag, FloatMenuScene menuScene) {
            return null;
        }

        public void onMenuStateChanged(View anchor, boolean isShow) {
            Intrinsics.checkNotNullParameter(anchor, "anchor");
        }

        public boolean onMenuItemClicked(View anchor, BdFloatMenuItem menuItem) {
            String selectTxt;
            SelectionInfo mSelectionInfo;
            CharSequence selectionContent;
            String obj;
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            BdTextSelectHelper mTextSelectHelper = getMTextSelectHelper();
            String str = null;
            if (mTextSelectHelper == null || (mSelectionInfo = mTextSelectHelper.getMSelectionInfo()) == null || (selectionContent = mSelectionInfo.getSelectionContent()) == null || (obj = selectionContent.toString()) == null) {
                selectTxt = null;
            } else {
                selectTxt = StringsKt.replace$default(obj, "\n", "", false, 4, (Object) null);
            }
            int mId = menuItem.getMId();
            if (mId == BuildinFloatMenuResEnum.FLOAT_MENU_SHARE.getMenuId()) {
                Context context2 = this.context;
                DynamicDetailFlow.DynamicDetailBaseModel dynamicDetailBaseModel = this.model;
                ShareBaseBean shareInfo = dynamicDetailBaseModel != null ? dynamicDetailBaseModel.getShareInfo() : null;
                DynamicDetailFlow.DynamicDetailBaseModel dynamicDetailBaseModel2 = this.model;
                if (dynamicDetailBaseModel2 != null) {
                    str = dynamicDetailBaseModel2.getNid();
                }
                String string = FeedRuntime.getAppContext().getResources().getString(R.string.text_selector_share_desc);
                Intrinsics.checkNotNullExpressionValue(string, "getAppContext().resource…text_selector_share_desc)");
                SelectorTextEventKt.shareEvent(context2, shareInfo, str, selectTxt, string);
                TextSelectorMenuStatisticsKt.textSelectorItemStatistics("find_news_landing", "click", TextSelectorMenuStatisticsKt.SHARE_VALUE);
                return true;
            } else if (mId != BuildinFloatMenuResEnum.FLOAT_MENU_WRONG_CHAR_FEEDBACK.getMenuId()) {
                return false;
            } else {
                Context context3 = this.context;
                DynamicDetailFlow.DynamicDetailBaseModel dynamicDetailBaseModel3 = this.model;
                if (dynamicDetailBaseModel3 != null) {
                    str = dynamicDetailBaseModel3.getNid();
                }
                SelectorTextEventKt.wrongWordEvent(context3, selectTxt, str);
                TextSelectorMenuStatisticsKt.textSelectorItemStatistics("find_news_landing", "click", "wrongwords");
                return true;
            }
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
                        Map extParam = new LinkedHashMap();
                        extParam.put("upgrade", "1");
                        extParam.put("simple", "1");
                        extParam.put("append", "1");
                        extParam.put("sa", "olps_txt");
                        baseFloatMenuFuncParam.setExt(extParam);
                        break;
                }
            }
            return baseFloatMenuFuncParam;
        }

        public FloatMenuScene getMenuScene() {
            if (!FeedAbtestManager.isDynamicTextSelectorSwitch()) {
                return FloatMenuScene.COPY_AND_SEAECH;
            }
            TextSelectorMenuStatisticsKt.textSelectorItemStatistics("find_news_landing", "show", TextSelectorMenuStatisticsKt.SHARE_VALUE);
            TextSelectorMenuStatisticsKt.textSelectorItemStatistics("find_news_landing", "show", "wrongwords");
            return FloatMenuScene.COPY_SEARCH_SHARE_WRONG_WORD_FEEDBACK;
        }
    }
}
