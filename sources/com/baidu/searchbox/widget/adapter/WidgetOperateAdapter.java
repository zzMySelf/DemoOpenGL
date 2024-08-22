package com.baidu.searchbox.widget.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.oem.widget.R;
import com.baidu.searchbox.widget.operate.WidgetOperate;
import com.baidu.searchbox.widget.operate.WidgetOperateController;
import com.baidu.searchbox.widget.operate.WidgetOperatePicData;
import com.baidu.searchbox.widget.template.TemplateCreatorKt;
import com.baidu.searchbox.widget.template.TemplateData;
import com.baidu.searchbox.widget.template.TemplateEnum;
import com.baidu.searchbox.widget.template.TemplateEnumKt;
import com.baidu.searchbox.widget.template.TplEnumKt;
import com.baidu.searchbox.widget.utils.WidgetUiUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B+\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0017J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/widget/adapter/WidgetOperateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/widget/adapter/WidgetOperateHolder;", "dataSource", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/widget/operate/WidgetOperate;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "CLICK_TEMP_TIME_STAMP", "", "addItemTimeStamp", "getDataSource", "()Ljava/util/ArrayList;", "setDataSource", "(Ljava/util/ArrayList;)V", "deleteItemTimeStamp", "tplMapping", "", "", "Lcom/baidu/searchbox/widget/template/TemplateEnum;", "getItemCount", "", "getItemViewType", "position", "initTplMappingRelation", "", "isValidPosition", "", "onBindViewHolder", "holder", "onChildClick", "view", "Landroid/view/View;", "currentClickPosition", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetOperateAdapter.kt */
public final class WidgetOperateAdapter extends RecyclerView.Adapter<WidgetOperateHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EAS_OPEN_URL_PREFIX = "baiduboxapp://v1/easybrowse/open?url=";
    public static final String GUIDE_ADD_WIDGET_URL = "https://mbd.baidu.com/baiduapp/widget/android";
    private long CLICK_TEMP_TIME_STAMP = 500;
    private long addItemTimeStamp;
    private final Context context;
    private ArrayList<WidgetOperate> dataSource;
    private long deleteItemTimeStamp;
    private final Map<String, TemplateEnum> tplMapping = new LinkedHashMap();

    public final ArrayList<WidgetOperate> getDataSource() {
        return this.dataSource;
    }

    public final void setDataSource(ArrayList<WidgetOperate> arrayList) {
        this.dataSource = arrayList;
    }

    public WidgetOperateAdapter(ArrayList<WidgetOperate> dataSource2, Context context2) {
        this.dataSource = dataSource2;
        this.context = context2;
        initTplMappingRelation();
    }

    public WidgetOperateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        return new WidgetOperateHolder(TemplateCreatorKt.createTemplate(TemplateEnumKt.valueOf(viewType)), parent);
    }

    public void onBindViewHolder(WidgetOperateHolder holder, int position) {
        ArrayList it;
        int i2 = position;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getMTemplate() != null && (it = this.dataSource) != null && isValidPosition(i2)) {
            holder.getMTemplate().setOnChildClickListener(new WidgetOperateAdapter$onBindViewHolder$1$1(position, this));
            WidgetOperate widgetOperate = it.get(i2);
            Intrinsics.checkNotNullExpressionValue(widgetOperate, "it[position]");
            WidgetOperate widgetOperate2 = widgetOperate;
            holder.getMTemplate().update(new TemplateData(widgetOperate2.getId(), widgetOperate2.isDefault(), widgetOperate2.getTitle(), widgetOperate2.getSubTitle(), widgetOperate2.getIcon(), widgetOperate2.getTransIcon(), widgetOperate2.getSchema(), widgetOperate2.getPage(), widgetOperate2.getValue(), widgetOperate2.getResId(), (WidgetOperatePicData) null, 1024, (DefaultConstructorMarker) null));
        }
    }

    public int getItemCount() {
        if (AppConfig.isDebug()) {
            StringBuilder append = new StringBuilder().append("getItemCount is ");
            ArrayList<WidgetOperate> arrayList = this.dataSource;
            Log.d(WidgetUiUtils.TAG, append.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null).toString());
        }
        ArrayList<WidgetOperate> arrayList2 = this.dataSource;
        if (arrayList2 != null) {
            return arrayList2.size();
        }
        return 0;
    }

    public int getItemViewType(int position) {
        ArrayList it = this.dataSource;
        if (it == null) {
            return TemplateEnum.WIDGET_OPERATION_DEFAULT_TEXT.ordinal();
        }
        boolean isValidPosition = isValidPosition(position);
        if (isValidPosition) {
            WidgetOperate widgetOperate = it.get(position);
            Intrinsics.checkNotNullExpressionValue(widgetOperate, "it[position]");
            TemplateEnum templateEnum = this.tplMapping.get(widgetOperate.isDefault());
            if (templateEnum != null) {
                return templateEnum.ordinal();
            }
            return TemplateEnum.WIDGET_OPERATION_DEFAULT_TEXT.ordinal();
        } else if (!isValidPosition) {
            return TemplateEnum.WIDGET_OPERATION_DEFAULT_TEXT.ordinal();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isValidPosition(int position) {
        ArrayList it = this.dataSource;
        if (it == null || position < 0 || it.size() <= position) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void onChildClick(View view2, int currentClickPosition) {
        int id = view2.getId();
        if (id == R.id.view_added) {
            if (AppConfig.isDebug()) {
                Log.d(WidgetUiUtils.TAG, "onMoveItem added click  ");
            }
            if (System.currentTimeMillis() - this.addItemTimeStamp > this.CLICK_TEMP_TIME_STAMP) {
                this.addItemTimeStamp = System.currentTimeMillis();
                WidgetOperateController.Companion.getInstance().moveItemByAdd(currentClickPosition, this, this.context);
            }
        } else if (id == R.id.view_deleted) {
            if (AppConfig.isDebug()) {
                Log.d(WidgetUiUtils.TAG, "onMoveItem delete click  ");
            }
            if (System.currentTimeMillis() - this.deleteItemTimeStamp > this.CLICK_TEMP_TIME_STAMP) {
                this.deleteItemTimeStamp = System.currentTimeMillis();
                WidgetOperateController.Companion.getInstance().moveItemByDelete(currentClickPosition, this, this.context);
            }
        } else if (id == R.id.layout_add_launcher) {
            WidgetOperateController.Companion.getInstance().openGuideAddWidget("baiduboxapp://v1/easybrowse/open?url=https://mbd.baidu.com/baiduapp/widget/android");
        }
    }

    private final void initTplMappingRelation() {
        this.tplMapping.put(TplEnumKt.TPL_WIDGET_OPERATE_HEADER_SWIPE_RV, TemplateEnum.WIDGET_HORIZONTAL_SWIPE);
        this.tplMapping.put("1", TemplateEnum.WIDGET_QUICK_ENTRY_ADDED);
        this.tplMapping.put("0", TemplateEnum.WIDGET_QUICK_ENTRY_UN_ADDED);
        this.tplMapping.put(TplEnumKt.TPL_WIDGET_OPERATE_GROUP_TITLE, TemplateEnum.WIDGET_OPERATE_GROUP_TITLE);
        this.tplMapping.put(TplEnumKt.TPL_WIDGET_OPERATE_TITLE, TemplateEnum.WIDGET_OPERATE_TITLE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/widget/adapter/WidgetOperateAdapter$Companion;", "", "()V", "EAS_OPEN_URL_PREFIX", "", "GUIDE_ADD_WIDGET_URL", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WidgetOperateAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
