package com.baidu.searchbox.introduction.ui;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.introduction.data.GuideData;
import com.baidu.searchbox.introduction.data.ITplData;
import com.baidu.searchbox.music.data.MusicParser;
import com.baidu.searchbox.widget.guide.WidgetGuideDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010<\u001a\u00020=R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u001eR\u001c\u0010+\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u001eR\u001c\u0010\u0004\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/¨\u0006>"}, d2 = {"Lcom/baidu/searchbox/introduction/ui/BaseIntroductionDialog;", "T", "Lcom/baidu/searchbox/introduction/data/ITplData;", "", "tplData", "guideData", "Lcom/baidu/searchbox/introduction/data/GuideData;", "(Lcom/baidu/searchbox/introduction/data/ITplData;Lcom/baidu/searchbox/introduction/data/GuideData;)V", "DEBUG", "", "getDEBUG", "()Z", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getGuideData", "()Lcom/baidu/searchbox/introduction/data/GuideData;", "setGuideData", "(Lcom/baidu/searchbox/introduction/data/GuideData;)V", "mDialogInterface", "Landroid/content/DialogInterface;", "getMDialogInterface", "()Landroid/content/DialogInterface;", "setMDialogInterface", "(Landroid/content/DialogInterface;)V", "mFrom", "getMFrom", "setMFrom", "(Ljava/lang/String;)V", "mKey", "getMKey", "setMKey", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mSource", "getMSource", "setMSource", "mTplData", "getMTplData", "()Lcom/baidu/searchbox/introduction/data/ITplData;", "setMTplData", "(Lcom/baidu/searchbox/introduction/data/ITplData;)V", "Lcom/baidu/searchbox/introduction/data/ITplData;", "mTplId", "", "getMTplId", "()I", "setMTplId", "(I)V", "mUserType", "getMUserType", "setMUserType", "getTplData", "setTplData", "closeDialog", "", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseIntroductionDialog.kt */
public abstract class BaseIntroductionDialog<T extends ITplData> {
    private final boolean DEBUG = AppConfig.isDebug();
    private final String TAG = BaseIntroductionDialog.class.getSimpleName();
    private GuideData guideData;
    private DialogInterface mDialogInterface;
    private String mFrom;
    private String mKey;
    protected View mRootView;
    private String mSource;
    private T mTplData = this.tplData;
    private int mTplId;
    private String mUserType;
    private T tplData;

    public BaseIntroductionDialog(T tplData2, GuideData guideData2) {
        Intrinsics.checkNotNullParameter(tplData2, MusicParser.TPL_DATA);
        Intrinsics.checkNotNullParameter(guideData2, WidgetGuideDataManager.KEY_GUIDE_DATA);
        this.tplData = tplData2;
        this.guideData = guideData2;
        if (TextUtils.equals(this.guideData.page, "index")) {
            this.mFrom = "home";
        }
        if (TextUtils.isEmpty(this.mSource)) {
            this.mSource = "default";
        }
        if (TextUtils.isEmpty(this.mUserType)) {
            this.mUserType = "0";
        }
        this.mTplId = this.guideData.tplId;
        this.mKey = this.guideData.key;
    }

    /* access modifiers changed from: protected */
    public final T getTplData() {
        return this.tplData;
    }

    /* access modifiers changed from: protected */
    public final void setTplData(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.tplData = t;
    }

    /* access modifiers changed from: protected */
    public final GuideData getGuideData() {
        return this.guideData;
    }

    /* access modifiers changed from: protected */
    public final void setGuideData(GuideData guideData2) {
        Intrinsics.checkNotNullParameter(guideData2, "<set-?>");
        this.guideData = guideData2;
    }

    /* access modifiers changed from: protected */
    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    /* access modifiers changed from: protected */
    public final String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public final String getMFrom() {
        return this.mFrom;
    }

    /* access modifiers changed from: protected */
    public final void setMFrom(String str) {
        this.mFrom = str;
    }

    /* access modifiers changed from: protected */
    public final String getMKey() {
        return this.mKey;
    }

    /* access modifiers changed from: protected */
    public final void setMKey(String str) {
        this.mKey = str;
    }

    /* access modifiers changed from: protected */
    public final String getMSource() {
        return this.mSource;
    }

    /* access modifiers changed from: protected */
    public final void setMSource(String str) {
        this.mSource = str;
    }

    /* access modifiers changed from: protected */
    public final String getMUserType() {
        return this.mUserType;
    }

    /* access modifiers changed from: protected */
    public final void setMUserType(String str) {
        this.mUserType = str;
    }

    /* access modifiers changed from: protected */
    public final T getMTplData() {
        return this.mTplData;
    }

    /* access modifiers changed from: protected */
    public final void setMTplData(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.mTplData = t;
    }

    /* access modifiers changed from: protected */
    public final int getMTplId() {
        return this.mTplId;
    }

    /* access modifiers changed from: protected */
    public final void setMTplId(int i2) {
        this.mTplId = i2;
    }

    /* access modifiers changed from: protected */
    public final View getMRootView() {
        View view2 = this.mRootView;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMRootView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.mRootView = view2;
    }

    /* access modifiers changed from: protected */
    public final DialogInterface getMDialogInterface() {
        return this.mDialogInterface;
    }

    /* access modifiers changed from: protected */
    public final void setMDialogInterface(DialogInterface dialogInterface) {
        this.mDialogInterface = dialogInterface;
    }

    public final void closeDialog() {
        DialogInterface dialogInterface = this.mDialogInterface;
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.mDialogInterface = null;
    }
}
