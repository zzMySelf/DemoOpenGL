package com.baidu.searchbox.menuFunc;

import android.content.Context;
import android.net.Uri;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.factory.BuildinFloatMenuResEnum;
import com.baidu.searchbox.floatmenu.BdFloatMenuItem;
import com.baidu.searchbox.floatmenu.access.R;
import com.baidu.searchbox.menuFunc.param.BaseFloatMenuFuncParam;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/menuFunc/MenuFunctionProcessor;", "", "()V", "addExtParam", "", "targetUrl", "extParam", "", "processCopy", "", "context", "Landroid/content/Context;", "funcParam", "Lcom/baidu/searchbox/menuFunc/param/BaseFloatMenuFuncParam;", "processMenuClick", "menuItem", "Lcom/baidu/searchbox/floatmenu/BdFloatMenuItem;", "processSearch", "lib-floatmenu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MenuFunctionProcessor.kt */
public final class MenuFunctionProcessor {
    public static final MenuFunctionProcessor INSTANCE = new MenuFunctionProcessor();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MenuFunctionProcessor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BuildinFloatMenuResEnum.values().length];
            iArr[BuildinFloatMenuResEnum.FLOAT_MENU_COPY.ordinal()] = 1;
            iArr[BuildinFloatMenuResEnum.FLOAT_MENU_SEARCH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MenuFunctionProcessor() {
    }

    public final void processMenuClick(Context context, BdFloatMenuItem menuItem, BaseFloatMenuFuncParam funcParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(funcParam, "funcParam");
        BuildinFloatMenuResEnum menuResEnum = BuildinFloatMenuResEnum.Companion.valueOf(menuItem.getMId());
        if (menuItem.getMIsBuidinMenuItem()) {
            switch (menuResEnum == null ? -1 : WhenMappings.$EnumSwitchMapping$0[menuResEnum.ordinal()]) {
                case 1:
                    INSTANCE.processCopy(context, funcParam);
                    return;
                case 2:
                    INSTANCE.processSearch(context, funcParam);
                    return;
                default:
                    return;
            }
        }
    }

    public final void processSearch(Context context, BaseFloatMenuFuncParam funcParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(funcParam, "funcParam");
        CharSequence mainParam = funcParam.getMainParam();
        if (mainParam == null || StringsKt.isBlank(mainParam)) {
            UniversalToast.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.select_text_before_search)).show();
            return;
        }
        String str = "baiduboxapp://browser/search?query=" + Uri.encode(funcParam.getMainParam());
        Map extParam = funcParam.getExt();
        if (extParam != null) {
            str = INSTANCE.addExtParam(str, extParam);
        }
        SchemeRouter.invokeSchemeForInner(context, Uri.parse(str));
    }

    private final String addExtParam(String targetUrl, Map<String, String> extParam) {
        String ret = targetUrl;
        Map paramMap = new LinkedHashMap();
        for (Map.Entry entry : extParam.entrySet()) {
            CharSequence charSequence = (CharSequence) entry.getKey();
            boolean z = false;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                CharSequence charSequence2 = (CharSequence) entry.getValue();
                if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                    z = true;
                }
                if (!z) {
                    paramMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (paramMap.isEmpty()) {
            return ret;
        }
        String ret2 = UrlUtils.appendParams(ret, paramMap);
        Intrinsics.checkNotNullExpressionValue(ret2, "appendParams(ret, paramMap)");
        return ret2;
    }

    public final void processCopy(Context context, BaseFloatMenuFuncParam funcParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(funcParam, "funcParam");
        if (funcParam.getMainParam() != null) {
            WrappedClipboardManager.newInstance(context).setText(funcParam.getMainParam());
            if (!DeviceUtils.OSInfo.hasTiramisu() || !DeviceUtils.isSupportPreviewWhenClipCopy()) {
                UniversalToast.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.text_copy_finished)).show();
            }
        }
    }
}
