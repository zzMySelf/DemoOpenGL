package com.baidu.searchbox.widget.operate;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.oem.widget.R;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\b\u001a\u00020\u0003\u001a\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001c\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"TAG", "", "buildWidgetLearnOperateListArray", "Lcom/baidu/searchbox/widget/operate/WidgetOperateListArray;", "operateList", "Lcom/baidu/searchbox/widget/operate/WidgetOperateList;", "buildWidgetOperateListArray", "buildWidgetOperateShowingListArray", "widgetOperateListArray", "getWidgetOperateShowingList", "widgetOperateList", "hasEdit", "", "operateIndex", "", "isWidgetOperateDataChanged", "oldWidgetOperateListArray", "newWidgetOperateListArray", "isWidgetOperateDataHasEdited", "widgetType", "setWidgetOperateDataHasEdit", "", "index", "updateDataWhenCloudConfigChange", "updatewidgetOperateList", "updateWidgetOperateList", "oldWidgetOperateList", "lib-widget_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetOperateDataUtils.kt */
public final class WidgetOperateDataUtilsKt {
    private static final String TAG = "WidgetOperateUtils";

    private static final WidgetOperateList updateWidgetOperateList(WidgetOperateList oldWidgetOperateList, WidgetOperateList updateWidgetOperateList) {
        ArrayList<WidgetOperate> cates;
        ArrayList<WidgetOperate> cates2;
        if (oldWidgetOperateList == null || updateWidgetOperateList == null) {
            return null;
        }
        WidgetOperateList oldWidgetOperateListCopy = oldWidgetOperateList.copy();
        WidgetOperateList updateWidgetOperateListCopy = updateWidgetOperateList.copy();
        ArrayList $this$updateWidgetOperateList_u24lambda_u2d0 = oldWidgetOperateList.getCates();
        if ($this$updateWidgetOperateList_u24lambda_u2d0 != null) {
            Iterator<WidgetOperate> it = $this$updateWidgetOperateList_u24lambda_u2d0.iterator();
            while (it.hasNext()) {
                WidgetOperate oldItem = it.next();
                if (oldItem != null) {
                    if (TextUtils.equals(oldItem.isDefault(), "1")) {
                        if (!(updateWidgetOperateListCopy == null || updateWidgetOperateListCopy.isContains(oldItem) || (cates2 = oldWidgetOperateListCopy.getCates()) == null)) {
                            cates2.remove(oldItem);
                        }
                    } else if (TextUtils.equals(oldItem.isDefault(), "0") && (cates = oldWidgetOperateListCopy.getCates()) != null) {
                        cates.remove(oldItem);
                    }
                }
            }
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "updateWidgetOperateList: oldWidgetOperateListCopy = " + oldWidgetOperateListCopy);
        }
        updateWidgetOperateListCopy.reset();
        ArrayList $this$updateWidgetOperateList_u24lambda_u2d1 = oldWidgetOperateListCopy.getCates();
        if ($this$updateWidgetOperateList_u24lambda_u2d1 != null && (!$this$updateWidgetOperateList_u24lambda_u2d1.isEmpty())) {
            Iterator<WidgetOperate> it2 = $this$updateWidgetOperateList_u24lambda_u2d1.iterator();
            while (it2.hasNext()) {
                WidgetOperate oldItem2 = it2.next();
                if (oldItem2 != null) {
                    updateWidgetOperateListCopy.removeItemById(oldItem2.getId());
                }
            }
            ArrayList<WidgetOperate> cates3 = updateWidgetOperateListCopy.getCates();
            if (cates3 != null) {
                cates3.addAll(0, $this$updateWidgetOperateList_u24lambda_u2d1);
            }
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "updateWidgetOperateList: updateWidgetOperateListCopy = " + updateWidgetOperateListCopy);
        }
        ArrayList $this$updateWidgetOperateList_u24lambda_u2d2 = updateWidgetOperateListCopy.getCates();
        if ($this$updateWidgetOperateList_u24lambda_u2d2 == null || !(!$this$updateWidgetOperateList_u24lambda_u2d2.isEmpty())) {
            return null;
        }
        return updateWidgetOperateListCopy;
    }

    public static final WidgetOperateListArray updateDataWhenCloudConfigChange(WidgetOperateListArray widgetOperateListArray, WidgetOperateList updatewidgetOperateList) {
        List $this$updateDataWhenCloudConfigChange_u24lambda_u2d3;
        String keyValue;
        WidgetOperateList widgetOperateList;
        Intrinsics.checkNotNullParameter(widgetOperateListArray, "widgetOperateListArray");
        Intrinsics.checkNotNullParameter(updatewidgetOperateList, "updatewidgetOperateList");
        if (!widgetOperateListArray.isValid() || ($this$updateDataWhenCloudConfigChange_u24lambda_u2d3 = widgetOperateListArray.getCatesList()) == null) {
            return null;
        }
        ArrayList newCatesList = new ArrayList();
        int size = $this$updateDataWhenCloudConfigChange_u24lambda_u2d3.size();
        for (int index = 0; index < size; index++) {
            WidgetOperateList oldWidgetOperateList = $this$updateDataWhenCloudConfigChange_u24lambda_u2d3.get(index);
            if (!Intrinsics.areEqual((Object) oldWidgetOperateList.getWidgetType(), (Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE)) {
                switch (index) {
                    case 0:
                        keyValue = WidgetOperateConstantsKt.HAS_EDIT_WIDGET_OPERATE;
                        break;
                    case 1:
                        keyValue = WidgetOperateConstantsKt.HAS_EDIT_TRANS_WIDGET_OPERATE;
                        break;
                    case 2:
                        keyValue = WidgetOperateConstantsKt.HAS_EDIT_QUICK_SEARCH_WIDGET_OPERATE;
                        break;
                    default:
                        keyValue = "";
                        break;
                }
            } else {
                keyValue = WidgetOperateConstantsKt.HAS_EDIT_LEARN_WIDGET_OPERATE;
            }
            if (keyValue.length() > 0) {
                if (WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(keyValue, false)) {
                    widgetOperateList = updateWidgetOperateList(oldWidgetOperateList, updatewidgetOperateList);
                } else {
                    widgetOperateList = updatewidgetOperateList;
                }
                WidgetOperateList newWidgetOperateList = widgetOperateList;
                if (newWidgetOperateList != null) {
                    newCatesList.add(newWidgetOperateList);
                }
            }
        }
        return new WidgetOperateListArray(newCatesList);
    }

    public static final boolean isWidgetOperateDataChanged(WidgetOperateListArray oldWidgetOperateListArray, WidgetOperateListArray newWidgetOperateListArray) {
        List $this$isWidgetOperateDataChanged_u24lambda_u2d4;
        boolean hasChanged = false;
        if (!(oldWidgetOperateListArray == null || newWidgetOperateListArray == null || oldWidgetOperateListArray.getCatesList() == null || newWidgetOperateListArray.getCatesList() == null)) {
            List<WidgetOperateList> catesList = oldWidgetOperateListArray.getCatesList();
            Intrinsics.checkNotNull(catesList);
            int size = catesList.size();
            List<WidgetOperateList> catesList2 = newWidgetOperateListArray.getCatesList();
            Intrinsics.checkNotNull(catesList2);
            if (size == catesList2.size() && ($this$isWidgetOperateDataChanged_u24lambda_u2d4 = oldWidgetOperateListArray.getCatesList()) != null && (!$this$isWidgetOperateDataChanged_u24lambda_u2d4.isEmpty())) {
                int size2 = $this$isWidgetOperateDataChanged_u24lambda_u2d4.size();
                for (int index = 0; index < size2; index++) {
                    WidgetOperateList oldItem = $this$isWidgetOperateDataChanged_u24lambda_u2d4.get(index);
                    WidgetOperateList newItem = newWidgetOperateListArray.getWidgetOperateList(index);
                    if (!(oldItem == null || newItem == null || !oldItem.isChanged(newItem))) {
                        String tempWidgetType = newItem.getWidgetType();
                        if (tempWidgetType == null) {
                            tempWidgetType = "";
                        }
                        if (isWidgetOperateDataHasEdited(tempWidgetType)) {
                            return true;
                        }
                        setWidgetOperateDataHasEdit(index, tempWidgetType);
                        if (!hasChanged) {
                            hasChanged = true;
                        }
                    }
                }
            }
        }
        return hasChanged;
    }

    private static final void setWidgetOperateDataHasEdit(int index, String widgetType) {
        if (!Intrinsics.areEqual((Object) widgetType, (Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE)) {
            switch (index) {
                case 0:
                    if (!WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_WIDGET_OPERATE, false)) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "setWidgetOperateDataHasEdit: 4 * 1 widget operation has edited");
                        }
                        WidgetSharePreferenceUtils.Companion.getInstance().putBoolean(WidgetOperateConstantsKt.HAS_EDIT_WIDGET_OPERATE, true);
                        return;
                    }
                    return;
                case 1:
                    if (!WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_TRANS_WIDGET_OPERATE, false)) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "setWidgetOperateDataHasEdit: 4 * 1 trans widget operation has edited");
                        }
                        WidgetSharePreferenceUtils.Companion.getInstance().putBoolean(WidgetOperateConstantsKt.HAS_EDIT_TRANS_WIDGET_OPERATE, true);
                        return;
                    }
                    return;
                case 2:
                    if (!WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_QUICK_SEARCH_WIDGET_OPERATE, false)) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "setWidgetOperateDataHasEdit: 4 * 2 widget operation has edited");
                        }
                        WidgetSharePreferenceUtils.Companion.getInstance().putBoolean(WidgetOperateConstantsKt.HAS_EDIT_QUICK_SEARCH_WIDGET_OPERATE, true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (!WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_LEARN_WIDGET_OPERATE, false)) {
            WidgetSharePreferenceUtils.Companion.getInstance().putBoolean(WidgetOperateConstantsKt.HAS_EDIT_LEARN_WIDGET_OPERATE, true);
        }
    }

    private static final boolean isWidgetOperateDataHasEdited(String widgetType) {
        if (Intrinsics.areEqual((Object) widgetType, (Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE)) {
            return WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_LEARN_WIDGET_OPERATE, false);
        }
        if (!WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_WIDGET_OPERATE, false) || !WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_TRANS_WIDGET_OPERATE, false) || !WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(WidgetOperateConstantsKt.HAS_EDIT_QUICK_SEARCH_WIDGET_OPERATE, false)) {
            return false;
        }
        return true;
    }

    public static final WidgetOperateListArray buildWidgetOperateListArray(WidgetOperateList operateList) {
        Intrinsics.checkNotNullParameter(operateList, "operateList");
        String operateListArrayData = WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetOperateConstantsKt.WIDGET_OPERATE_LIST_KEY, "");
        if (TextUtils.isEmpty(operateListArrayData)) {
            ArrayList catesList = new ArrayList();
            catesList.add(operateList);
            catesList.add(operateList);
            catesList.add(operateList);
            return new WidgetOperateListArray(catesList);
        }
        WidgetOperateListArray tempOperateListArray = (WidgetOperateListArray) new Gson().fromJson(operateListArrayData, WidgetOperateListArray.class);
        Intrinsics.checkNotNullExpressionValue(tempOperateListArray, "tempOperateListArray");
        return updateDataWhenCloudConfigChange(tempOperateListArray, operateList);
    }

    public static final WidgetOperateListArray buildWidgetLearnOperateListArray(WidgetOperateList operateList) {
        Intrinsics.checkNotNullParameter(operateList, "operateList");
        String operateListArrayData = WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetOperateConstantsKt.WIDGET_LEARN_OPERATE_LIST_KEY, "");
        if (TextUtils.isEmpty(operateListArrayData)) {
            ArrayList catesList = new ArrayList();
            operateList.setWidgetType(WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE);
            catesList.add(operateList);
            return new WidgetOperateListArray(catesList);
        }
        WidgetOperateListArray tempOperateListArray = (WidgetOperateListArray) new Gson().fromJson(operateListArrayData, WidgetOperateListArray.class);
        Intrinsics.checkNotNullExpressionValue(tempOperateListArray, "tempOperateListArray");
        return updateDataWhenCloudConfigChange(tempOperateListArray, operateList);
    }

    public static final WidgetOperateListArray buildWidgetOperateShowingListArray(WidgetOperateListArray widgetOperateListArray) {
        String keyHasEdit;
        Intrinsics.checkNotNullParameter(widgetOperateListArray, "widgetOperateListArray");
        if (!widgetOperateListArray.isValid()) {
            return null;
        }
        ArrayList catesList = new ArrayList();
        List $this$buildWidgetOperateShowingListArray_u24lambda_u2d5 = widgetOperateListArray.getCatesList();
        if ($this$buildWidgetOperateShowingListArray_u24lambda_u2d5 != null) {
            int size = $this$buildWidgetOperateShowingListArray_u24lambda_u2d5.size();
            for (int index = 0; index < size; index++) {
                WidgetOperateList widgetOperateList = $this$buildWidgetOperateShowingListArray_u24lambda_u2d5.get(index);
                if (!Intrinsics.areEqual((Object) widgetOperateList.getWidgetType(), (Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE)) {
                    switch (index) {
                        case 0:
                            keyHasEdit = WidgetOperateConstantsKt.HAS_EDIT_WIDGET_OPERATE;
                            break;
                        case 1:
                            keyHasEdit = WidgetOperateConstantsKt.HAS_EDIT_TRANS_WIDGET_OPERATE;
                            break;
                        default:
                            keyHasEdit = WidgetOperateConstantsKt.HAS_EDIT_QUICK_SEARCH_WIDGET_OPERATE;
                            break;
                    }
                } else {
                    keyHasEdit = WidgetOperateConstantsKt.HAS_EDIT_LEARN_WIDGET_OPERATE;
                }
                WidgetOperateList widgetOperateShowingList = getWidgetOperateShowingList(widgetOperateList, WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(keyHasEdit, false), index);
                if (widgetOperateShowingList == null) {
                    return null;
                }
                catesList.add(widgetOperateShowingList);
            }
        }
        return new WidgetOperateListArray(catesList);
    }

    private static final WidgetOperateList getWidgetOperateShowingList(WidgetOperateList widgetOperateList, boolean hasEdit, int operateIndex) {
        Resources resources;
        String title;
        int resId;
        ArrayList cates = new ArrayList();
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (resources = appContext.getResources()) == null || (title = resources.getString(R.string.widget_operate_title_zidingyi)) == null) {
            return null;
        }
        String widgetType = widgetOperateList.getWidgetType();
        if (widgetType == null) {
            widgetType = "";
        }
        if (!Intrinsics.areEqual((Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE, (Object) widgetType)) {
            switch (operateIndex) {
                case 0:
                    resId = R.drawable.widget_zidingyi;
                    break;
                case 1:
                    resId = R.drawable.trans_widget_zidingyi;
                    break;
                case 2:
                    resId = R.drawable.quick_search_widget_zidingyi;
                    break;
                default:
                    resId = 0;
                    break;
            }
        } else {
            resId = R.drawable.widget_zidingyi;
        }
        int realIndex = Intrinsics.areEqual((Object) WidgetOperateConstantsKt.LEARN_WIDGET_OPERATE_TYPE, (Object) widgetType) ? 3 : operateIndex;
        WidgetDebugKt.printLog(WidgetDebugKt.TAG_LEARN_WIDGET, (Function0<String>) new WidgetOperateDataUtilsKt$getWidgetOperateShowingList$1(realIndex));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String scheme = String.format(WidgetOperateConstantsKt.SCHEME_OPEN_OPERATE_SETTINGS, Arrays.copyOf(new Object[]{Integer.valueOf(realIndex)}, 1));
        Intrinsics.checkNotNullExpressionValue(scheme, "format(format, *args)");
        WidgetOperate customOperate = new WidgetOperate(WidgetOperateConstantsKt.VALUE_ZIDINGYI, (String) null, title, (String) null, (String) null, (String) null, scheme, "op", WidgetOperateConstantsKt.VALUE_ZIDINGYI, resId, 58, (DefaultConstructorMarker) null);
        ArrayList $this$getWidgetOperateShowingList_u24lambda_u2d6 = widgetOperateList.getCates();
        if ($this$getWidgetOperateShowingList_u24lambda_u2d6 != null && $this$getWidgetOperateShowingList_u24lambda_u2d6.size() > 2) {
            for (int index = 0; index < 3; index++) {
                WidgetOperate widgetOperate = $this$getWidgetOperateShowingList_u24lambda_u2d6.get(index);
                Intrinsics.checkNotNullExpressionValue(widgetOperate, "get(index)");
                WidgetOperate item = widgetOperate;
                if (!hasEdit) {
                    switch (index) {
                        case 0:
                        case 1:
                            if (TextUtils.equals(item.isDefault(), "0")) {
                                item.setDefault("1");
                            }
                            cates.add(item);
                            break;
                        default:
                            cates.add(customOperate);
                            break;
                    }
                } else if (Intrinsics.areEqual((Object) item.isDefault(), (Object) "1")) {
                    cates.add(item);
                } else {
                    cates.add(customOperate);
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "getWidgetOperateShowingList: cates.get(" + index + ") = " + cates.get(index));
                }
            }
        }
        if (cates.isEmpty()) {
            return null;
        }
        return new WidgetOperateList(cates, widgetOperateList.getDayPic(), widgetOperateList.getNightPic(), widgetOperateList.getWidgetType());
    }
}
