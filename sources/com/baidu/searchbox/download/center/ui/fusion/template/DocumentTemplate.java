package com.baidu.searchbox.download.center.ui.fusion.template;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.download.center.ui.fusion.adapter.FileManagerHolder;
import com.baidu.searchbox.download.center.ui.fusion.model.AbsTemplateModel;
import com.baidu.searchbox.download.center.ui.fusion.model.TabTemplateModel;
import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import com.baidu.searchbox.download.center.ui.fusion.template.base.ITemplate;
import com.baidu.searchbox.download.center.ui.fusion.template.base.TemplateType;
import com.baidu.searchbox.download.center.ui.fusion.view.ViewTypeConstants;
import com.baidu.searchbox.download.center.ui.fusion.viewholder.TemplateViewHolder;
import com.baidu.searchbox.download.center.ui.fusion.viewholder.ViewHolderFactory;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/template/DocumentTemplate;", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/ITemplate;", "()V", "mViewHolder", "Lcom/baidu/searchbox/download/center/ui/fusion/viewholder/TemplateViewHolder;", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "getTemplateType", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/TemplateType;", "update", "", "viewHolder", "Lcom/baidu/searchbox/download/center/ui/fusion/adapter/FileManagerHolder;", "templateModel", "Lcom/baidu/searchbox/download/center/ui/fusion/model/AbsTemplateModel;", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentTemplate.kt */
public final class DocumentTemplate implements ITemplate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DOCUMENT_UBC_FROM = "file";
    public static final String DOCUMENT_UBC_ID = "4997";
    public static final String DOCUMENT_UBC_PAGE_CLICK = "tab_click";
    public static final String DOCUMENT_UBC_PAGE_MORE = "more";
    public static final String DOCUMENT_UBC_PAGE_SLIDE = "slide_more";
    public static final String DOCUMENT_UBC_SOURCE_CLICK = "page_click";
    public static final String DOCUMENT_UBC_SOURCE_SHOW = "page_show";
    private TemplateViewHolder mViewHolder;

    public void doUbcStatistic(String itemId, String type, String source, String value, String ext, String ubcId) {
        ITemplate.DefaultImpls.doUbcStatistic(this, itemId, type, source, value, ext, ubcId);
    }

    public void doUbcWithoutFilterStatistic(String type, String source, String value, String ext) {
        ITemplate.DefaultImpls.doUbcWithoutFilterStatistic(this, type, source, value, ext);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/template/DocumentTemplate$Companion;", "", "()V", "DOCUMENT_UBC_FROM", "", "DOCUMENT_UBC_ID", "DOCUMENT_UBC_PAGE_CLICK", "DOCUMENT_UBC_PAGE_MORE", "DOCUMENT_UBC_PAGE_SLIDE", "DOCUMENT_UBC_SOURCE_CLICK", "DOCUMENT_UBC_SOURCE_SHOW", "doDocumentUBCStatistic", "", "type", "source", "page", "value", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DocumentTemplate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void doDocumentUBCStatistic(String type, String source, String page, String value) {
            DownloadCenterStatistic downloadCenterStatistic = DownloadCenterStatistic.INSTANCE;
            JSONObject $this$doDocumentUBCStatistic_u24lambda_u2d0 = new JSONObject();
            $this$doDocumentUBCStatistic_u24lambda_u2d0.putOpt("from", DownloadCenterStatistic.INSTANCE.getExtFromBySource());
            downloadCenterStatistic.downloadCenterStatistic("file", type, source, page, value, $this$doDocumentUBCStatistic_u24lambda_u2d0.toString(), "4997");
        }
    }

    public void update(FileManagerHolder viewHolder, AbsTemplateModel templateModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(templateModel, "templateModel");
        TemplateViewHolder templateViewHolder = this.mViewHolder;
        if (templateViewHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewHolder");
            templateViewHolder = null;
        }
        templateViewHolder.populate((TabTemplateModel) templateModel);
        ArrayList tabModelList = ((TabTemplateModel) templateModel).getTabTemplateDataList();
        if (tabModelList != null && tabModelList.size() > 0) {
            TabTemplateModel.TabTemplateInstanceModel tabTemplateInstanceModel = tabModelList.get(0);
            Intrinsics.checkNotNullExpressionValue(tabTemplateInstanceModel, "tabModelList.get(0)");
            TabTemplateModel.TabTemplateInstanceModel tabModel = tabTemplateInstanceModel;
            String id = tabModel.getId();
            String tabUbcType = tabModel.getTabUbcType();
            String tabUbcValue = tabModel.getTabUbcValue();
            JSONObject $this$update_u24lambda_u2d0 = new JSONObject();
            $this$update_u24lambda_u2d0.putOpt("from", DownloadCenterStatistic.INSTANCE.getExtFromBySource());
            doUbcStatistic(id, tabUbcType, "page_show", tabUbcValue, $this$update_u24lambda_u2d0.toString(), "4997");
        }
    }

    public View createView(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        TemplateViewHolder templateViewHolder = (TemplateViewHolder) new ViewHolderFactory().createViewHolder(parent.getContext(), parent, ViewTypeConstants.MODULE_DOCUMENT_VIEW_TYPE, new DocumentTemplate$createView$listener$1());
        this.mViewHolder = templateViewHolder;
        if (templateViewHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewHolder");
            templateViewHolder = null;
        }
        View view2 = templateViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "mViewHolder.itemView");
        return view2;
    }

    public TemplateType getTemplateType() {
        return TemplateType.DOCUMENT_TEMPLATE;
    }
}
