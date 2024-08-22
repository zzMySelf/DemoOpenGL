package com.baidu.searchbox.download.center.ui.fusion.template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.fusion.adapter.FileManagerHolder;
import com.baidu.searchbox.download.center.ui.fusion.manager.FileTemplateTipsManager;
import com.baidu.searchbox.download.center.ui.fusion.model.AbsTemplateModel;
import com.baidu.searchbox.download.center.ui.fusion.model.BannerTemplateModel;
import com.baidu.searchbox.download.center.ui.fusion.model.TemplateTipsModel;
import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import com.baidu.searchbox.download.center.ui.fusion.template.base.ITemplate;
import com.baidu.searchbox.download.center.ui.fusion.template.base.TemplateType;
import com.baidu.searchbox.favor.data.FavorModel;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/template/BannerTemplate;", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/ITemplate;", "()V", "imgAspectRatio", "", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "getTemplateType", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/TemplateType;", "update", "", "viewHolder", "Lcom/baidu/searchbox/download/center/ui/fusion/adapter/FileManagerHolder;", "templateModel", "Lcom/baidu/searchbox/download/center/ui/fusion/model/AbsTemplateModel;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerTemplate.kt */
public final class BannerTemplate implements ITemplate {
    private final float imgAspectRatio = 5.34375f;

    public void doUbcStatistic(String itemId, String type, String source, String value, String ext, String ubcId) {
        ITemplate.DefaultImpls.doUbcStatistic(this, itemId, type, source, value, ext, ubcId);
    }

    public void doUbcWithoutFilterStatistic(String type, String source, String value, String ext) {
        ITemplate.DefaultImpls.doUbcWithoutFilterStatistic(this, type, source, value, ext);
    }

    public void update(FileManagerHolder viewHolder, AbsTemplateModel templateModel) {
        String str;
        FileManagerHolder fileManagerHolder = viewHolder;
        AbsTemplateModel absTemplateModel = templateModel;
        Intrinsics.checkNotNullParameter(fileManagerHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(absTemplateModel, "templateModel");
        if (absTemplateModel instanceof BannerTemplateModel) {
            SimpleDraweeView bannerView = (SimpleDraweeView) fileManagerHolder.itemView.findViewById(R.id.templateBannerIcon);
            bannerView.setImageURI(((BannerTemplateModel) absTemplateModel).getIcon());
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) bannerView.getHierarchy();
            if (genericDraweeHierarchy != null) {
                genericDraweeHierarchy.setPlaceholderImage(R.drawable.bg_template_banner);
            }
            bannerView.setOnClickListener(new BannerTemplate$$ExternalSyntheticLambda0(absTemplateModel, bannerView));
            ViewGroup.LayoutParams lp = bannerView.getLayoutParams();
            int width = DeviceUtil.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext()) - DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 18.0f);
            lp.height = (int) (((float) width) / this.imgAspectRatio);
            lp.width = width;
            bannerView.setLayoutParams(lp);
            try {
                TemplateTipsModel tipsInfo = FileTemplateTipsManager.INSTANCE.getTips(templateModel.getId());
                JSONObject extJson = new JSONObject();
                extJson.putOpt("name", templateModel.getId());
                extJson.putOpt("from", DownloadCenterStatistic.INSTANCE.getExtFromBySource());
                ITemplate iTemplate = this;
                String id = templateModel.getId();
                if (tipsInfo == null) {
                    str = "1";
                } else {
                    str = "0";
                }
                ITemplate.DefaultImpls.doUbcStatistic$default(iTemplate, id, str, "page_show", DownloadCenterStatistic.UBC_VALUE_GONGJU, extJson.toString(), (String) null, 32, (Object) null);
            } catch (Exception exception) {
                if (AppConfig.isDebug()) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: update$lambda-0  reason: not valid java name */
    public static final void m17593update$lambda0(AbsTemplateModel $templateModel, SimpleDraweeView $bannerView, View it) {
        Intrinsics.checkNotNullParameter($templateModel, "$templateModel");
        CharSequence scheme = ((BannerTemplateModel) $templateModel).getScheme();
        if (!(scheme == null || scheme.length() == 0)) {
            Router.invoke($bannerView.getContext(), ((BannerTemplateModel) $templateModel).getScheme());
            DownloadCenterStatistic.INSTANCE.bannerClick($templateModel.getId());
        }
    }

    public View createView(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_template_banner, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …te_banner, parent, false)");
        return inflate;
    }

    public TemplateType getTemplateType() {
        return TemplateType.BANNER_TEMPLATE;
    }
}
