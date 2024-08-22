package com.baidu.searchbox.bigimage.monetize;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bigimage.monetize.model.BigImageAdModel;
import com.baidu.searchbox.bigimage.monetize.repo.AlsLogger;
import com.baidu.searchbox.bigimage.monetize.repo.AlsLoggerKt;
import com.baidu.searchbox.bigimage.monetize.repo.BigImageAdRepo;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\b\u0010\u0010\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/bigimage/monetize/BaseBigImageAdViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "buttonText", "Landroidx/lifecycle/MutableLiveData;", "", "getButtonText", "()Landroidx/lifecycle/MutableLiveData;", "downloadApp", "getDownloadApp", "imageUrl", "getImageUrl", "introText", "getIntroText", "launchLandingPage", "getLaunchLandingPage", "model", "Lcom/baidu/searchbox/bigimage/monetize/model/BigImageAdModel;", "repo", "Lcom/baidu/searchbox/bigimage/monetize/repo/BigImageAdRepo;", "getRepo", "()Lcom/baidu/searchbox/bigimage/monetize/repo/BigImageAdRepo;", "setRepo", "(Lcom/baidu/searchbox/bigimage/monetize/repo/BigImageAdRepo;)V", "titleText", "getTitleText", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "clickAd", "", "clickAdButton", "setModel", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseBigImageAdViewModel.kt */
public abstract class BaseBigImageAdViewModel extends BaseViewModel {
    private final MutableLiveData<String> buttonText = new MutableLiveData<>();
    private final MutableLiveData<String> downloadApp = new MutableLiveData<>();
    private final MutableLiveData<String> imageUrl = new MutableLiveData<>();
    private final MutableLiveData<String> introText = new MutableLiveData<>();
    private final MutableLiveData<String> launchLandingPage = new MutableLiveData<>();
    private BigImageAdModel model;
    private BigImageAdRepo repo;
    private final MutableLiveData<String> titleText = new MutableLiveData<>();
    private UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseBigImageAdViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final void setToken(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public final MutableLiveData<String> getTitleText() {
        return this.titleText;
    }

    public final MutableLiveData<String> getIntroText() {
        return this.introText;
    }

    public final MutableLiveData<String> getButtonText() {
        return this.buttonText;
    }

    public final MutableLiveData<String> getImageUrl() {
        return this.imageUrl;
    }

    public final MutableLiveData<String> getDownloadApp() {
        return this.downloadApp;
    }

    public final MutableLiveData<String> getLaunchLandingPage() {
        return this.launchLandingPage;
    }

    public final BigImageAdRepo getRepo() {
        return this.repo;
    }

    public final void setRepo(BigImageAdRepo bigImageAdRepo) {
        this.repo = bigImageAdRepo;
    }

    public final void clickAd() {
        BigImageAdModel $this$clickAd_u24lambda_u2d0 = this.model;
        if ($this$clickAd_u24lambda_u2d0 != null) {
            AlsLogger.INSTANCE.log($this$clickAd_u24lambda_u2d0, "2", "");
            launchLandingPage();
        }
    }

    public final void clickAdButton() {
        BigImageAdModel $this$clickAdButton_u24lambda_u2d1 = this.model;
        if ($this$clickAdButton_u24lambda_u2d1 != null) {
            if ($this$clickAdButton_u24lambda_u2d1.isLink()) {
                AlsLogger.INSTANCE.log($this$clickAdButton_u24lambda_u2d1, "2", "button");
            } else {
                AlsLogger.INSTANCE.log($this$clickAdButton_u24lambda_u2d1, "701", AlsLoggerKt.DA_AREA_DOWNLOAD_BTN);
            }
            launchLandingPage();
        }
    }

    private final void launchLandingPage() {
        BigImageAdRepo bigImageAdRepo;
        BigImageAdModel $this$launchLandingPage_u24lambda_u2d2 = this.model;
        if ($this$launchLandingPage_u24lambda_u2d2 != null && !TextUtils.isEmpty($this$launchLandingPage_u24lambda_u2d2.getLandingUrl())) {
            this.launchLandingPage.setValue($this$launchLandingPage_u24lambda_u2d2.getLandingUrl());
            if ($this$launchLandingPage_u24lambda_u2d2.isDownload()) {
                if (($this$launchLandingPage_u24lambda_u2d2.getParallelChargeUrl().length() > 0) && (bigImageAdRepo = this.repo) != null) {
                    bigImageAdRepo.statAdExpose($this$launchLandingPage_u24lambda_u2d2.getParallelChargeUrl());
                }
            }
        }
    }

    public void setModel(BigImageAdModel model2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        this.model = model2;
        this.titleText.setValue(model2.getTitle());
        this.introText.setValue(model2.getIntro());
        this.buttonText.setValue(model2.isDownload() ? "立即下载" : "立即查看");
        this.imageUrl.setValue(model2.getImageUrl());
    }
}
