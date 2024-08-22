package com.baidu.searchbox.introduction.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.bdpfont.utils.BDPFont;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.homeintroduction.R;
import com.baidu.searchbox.introduction.data.TaskGuideData;
import com.baidu.searchbox.introduction.inter.ITaskGuideUIClickListener;
import com.baidu.searchbox.ui.BdBaseImageView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001bH\u0016J\b\u00106\u001a\u000202H\u0016J\b\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u000202H\u0002J\b\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u000202H\u0016J\u0010\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u001bH\u0016J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0002J\u0012\u0010A\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010C\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010D\u001a\u000202H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n ,*\u0004\u0018\u00010+0+X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/introduction/ui/GuideInfoUpgradeStyleUITemplate;", "Lcom/baidu/searchbox/introduction/ui/TaskGuideUITemplate;", "taskGuideData", "Lcom/baidu/searchbox/introduction/data/TaskGuideData;", "(Lcom/baidu/searchbox/introduction/data/TaskGuideData;)V", "loginManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "getLoginManager", "()Lcom/baidu/searchbox/account/BoxAccountManager;", "loginManager$delegate", "Lkotlin/Lazy;", "mBgLayout", "Landroid/view/ViewGroup;", "mButtonCircle", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "mButtonConfirmBg", "mButtonFinger", "mButtonLayout", "Landroid/widget/FrameLayout;", "mButtonText", "Landroid/widget/TextView;", "mImgExpectTag", "mImgGuideBg", "mLoadingLayout", "mLoadingProgress", "Landroid/widget/ProgressBar;", "mLoadingState", "", "getMLoadingState", "()Z", "setMLoadingState", "(Z)V", "mLoadingText", "mOnClickListener", "Lcom/baidu/searchbox/introduction/inter/ITaskGuideUIClickListener;", "mRootView", "mSmallTag", "mTipsLayout", "mTvAmount", "mTvExpectAmount", "mTvExpectUnit", "mTvSmallUnit", "resource", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getTaskGuideData", "()Lcom/baidu/searchbox/introduction/data/TaskGuideData;", "createTemplateView", "outView", "initView", "", "view", "Landroid/view/View;", "isLoadingState", "onRelease", "playShowAnim", "setBgResource", "bgImage", "setButtonShow", "setClickEvent", "setFrameVisible", "setLoadingShow", "show", "setMoneyAndUnitTagView", "setUpViews", "setViewOnClickListener", "onClickListener", "updateData", "updateResource", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideInfoUpgradeStyleUITemplate.kt */
public final class GuideInfoUpgradeStyleUITemplate extends TaskGuideUITemplate {
    private final Lazy loginManager$delegate = LazyKt.lazy(GuideInfoUpgradeStyleUITemplate$loginManager$2.INSTANCE);
    private ViewGroup mBgLayout;
    private BdBaseImageView mButtonCircle;
    private BdBaseImageView mButtonConfirmBg;
    private BdBaseImageView mButtonFinger;
    private FrameLayout mButtonLayout;
    private TextView mButtonText;
    private BdBaseImageView mImgExpectTag;
    private BdBaseImageView mImgGuideBg;
    private ViewGroup mLoadingLayout;
    private ProgressBar mLoadingProgress;
    private boolean mLoadingState;
    private TextView mLoadingText;
    private ITaskGuideUIClickListener mOnClickListener;
    private ViewGroup mRootView;
    private BdBaseImageView mSmallTag;
    private ViewGroup mTipsLayout;
    private TextView mTvAmount;
    private TextView mTvExpectAmount;
    private TextView mTvExpectUnit;
    private TextView mTvSmallUnit;
    private final Resources resource = AppRuntime.getAppContext().getResources();
    private final TaskGuideData taskGuideData;

    public GuideInfoUpgradeStyleUITemplate(TaskGuideData taskGuideData2) {
        Intrinsics.checkNotNullParameter(taskGuideData2, "taskGuideData");
        this.taskGuideData = taskGuideData2;
    }

    public final TaskGuideData getTaskGuideData() {
        return this.taskGuideData;
    }

    public final boolean getMLoadingState() {
        return this.mLoadingState;
    }

    public final void setMLoadingState(boolean z) {
        this.mLoadingState = z;
    }

    private final BoxAccountManager getLoginManager() {
        return (BoxAccountManager) this.loginManager$delegate.getValue();
    }

    public ViewGroup createTemplateView(ViewGroup outView) {
        Intrinsics.checkNotNullParameter(outView, "outView");
        View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.task_guide_root_upgrade_newstyle_layout, outView, false);
        if (inflate != null) {
            ViewGroup viewGroup = (ViewGroup) inflate;
            this.mRootView = viewGroup;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            setRootMaxWidth(viewGroup);
            ViewGroup viewGroup2 = this.mRootView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup2 = null;
            }
            initView(viewGroup2);
            setUpViews();
            updateResource();
            setClickEvent();
            ViewGroup viewGroup3 = this.mRootView;
            if (viewGroup3 != null) {
                return viewGroup3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final void initView(View view2) {
        this.mImgGuideBg = (BdBaseImageView) view2.findViewById(R.id.img_guide_bg);
        TextView textView = (TextView) view2.findViewById(R.id.tv_amount);
        this.mTvAmount = textView;
        if (textView != null) {
            textView.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        }
        this.mTvSmallUnit = (TextView) view2.findViewById(R.id.tv_small_unit);
        this.mSmallTag = (BdBaseImageView) view2.findViewById(R.id.img_small_tag);
        TextView textView2 = (TextView) view2.findViewById(R.id.tv_expect_amount);
        this.mTvExpectAmount = textView2;
        if (textView2 != null) {
            textView2.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        }
        this.mTvExpectUnit = (TextView) view2.findViewById(R.id.tv_big_unit);
        this.mImgExpectTag = (BdBaseImageView) view2.findViewById(R.id.img_big_tag);
        this.mButtonConfirmBg = (BdBaseImageView) view2.findViewById(R.id.button_bg);
        this.mButtonCircle = (BdBaseImageView) view2.findViewById(R.id.button_circle);
        this.mButtonLayout = (FrameLayout) view2.findViewById(R.id.button_layout);
        this.mButtonFinger = (BdBaseImageView) view2.findViewById(R.id.button_finger);
        this.mTipsLayout = (ViewGroup) view2.findViewById(R.id.tipsLayout);
        this.mBgLayout = (ViewGroup) view2.findViewById(R.id.bg_layout);
        this.mButtonText = (TextView) view2.findViewById(R.id.button_text);
        this.mLoadingLayout = (ViewGroup) view2.findViewById(R.id.loading_layout);
        this.mLoadingProgress = (ProgressBar) view2.findViewById(R.id.loading_progress);
        this.mLoadingText = (TextView) view2.findViewById(R.id.loading_text);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        viewGroup.setVisibility(4);
        ViewGroup viewGroup2 = this.mBgLayout;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(4);
        }
        ViewGroup viewGroup3 = this.mTipsLayout;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(4);
        }
        BdBaseImageView bdBaseImageView = this.mButtonCircle;
        if (bdBaseImageView != null) {
            bdBaseImageView.setVisibility(4);
        }
        ViewGroup viewGroup4 = this.mLoadingLayout;
        if (viewGroup4 != null) {
            viewGroup4.setVisibility(8);
        }
    }

    private final void setButtonShow() {
        CharSequence charSequence;
        BdBaseImageView bdBaseImageView = this.mButtonConfirmBg;
        Bitmap bitmap = null;
        if (bdBaseImageView != null) {
            TaskGuideData.Tpl tplData = this.taskGuideData.getTplData();
            bdBaseImageView.setImageBitmap(tplData != null ? tplData.getResourceButtonBitmap() : null);
        }
        TextView textView = this.mButtonText;
        if (textView != null) {
            BoxAccountManager loginManager = getLoginManager();
            boolean z = true;
            if (loginManager == null || !loginManager.isLogin(2)) {
                z = false;
            }
            if (z) {
                TaskGuideData.Tpl tplData2 = this.taskGuideData.getTplData();
                if (TextUtils.isEmpty(tplData2 != null ? tplData2.getBtnLoginText() : null)) {
                    charSequence = AppRuntime.getAppContext().getResources().getText(R.string.task_guide_upgrade_new_style_login);
                } else {
                    TaskGuideData.Tpl tplData3 = this.taskGuideData.getTplData();
                    charSequence = tplData3 != null ? tplData3.getBtnLoginText() : null;
                }
            } else {
                TaskGuideData.Tpl tplData4 = this.taskGuideData.getTplData();
                if (TextUtils.isEmpty(tplData4 != null ? tplData4.getBtnNoLoginText() : null)) {
                    charSequence = AppRuntime.getAppContext().getResources().getText(R.string.task_guide_upgrade_new_style_no_login);
                } else {
                    TaskGuideData.Tpl tplData5 = this.taskGuideData.getTplData();
                    charSequence = tplData5 != null ? tplData5.getBtnNoLoginText() : null;
                }
            }
            textView.setText(charSequence);
        }
        TaskGuideData.Tpl tplData6 = this.taskGuideData.getTplData();
        if ((tplData6 != null ? tplData6.getResourceButtonCircleIcon() : null) != null) {
            TaskGuideData.Tpl tplData7 = this.taskGuideData.getTplData();
            if ((tplData7 != null ? tplData7.getResourceButtonFingerIcon() : null) != null) {
                BdBaseImageView bdBaseImageView2 = this.mButtonCircle;
                if (bdBaseImageView2 != null) {
                    TaskGuideData.Tpl tplData8 = this.taskGuideData.getTplData();
                    bdBaseImageView2.setImageBitmap(tplData8 != null ? tplData8.getResourceButtonCircleIcon() : null);
                }
                BdBaseImageView bdBaseImageView3 = this.mButtonFinger;
                if (bdBaseImageView3 != null) {
                    TaskGuideData.Tpl tplData9 = this.taskGuideData.getTplData();
                    if (tplData9 != null) {
                        bitmap = tplData9.getResourceButtonFingerIcon();
                    }
                    bdBaseImageView3.setImageBitmap(bitmap);
                }
            }
        }
    }

    private final void setUpViews() {
        BdBaseImageView it = this.mImgGuideBg;
        if (it != null) {
            setBgResource(it);
        }
        setButtonShow();
        setMoneyAndUnitTagView();
    }

    private final void setBgResource(BdBaseImageView bgImage) {
        TaskGuideData.Tpl tplData = this.taskGuideData.getTplData();
        bgImage.setImageBitmap(tplData != null ? tplData.getResourceBgBitmap() : null);
    }

    private final void setMoneyAndUnitTagView() {
        TextView textView = this.mTvAmount;
        Bitmap bitmap = null;
        if (textView != null) {
            TaskGuideData.Tpl tplData = this.taskGuideData.getTplData();
            textView.setText(tplData != null ? tplData.getAmount() : null);
        }
        TextView textView2 = this.mTvSmallUnit;
        if (textView2 != null) {
            textView2.setText(AppRuntime.getAppContext().getResources().getString(R.string.money_unit_yuan));
        }
        BdBaseImageView bdBaseImageView = this.mSmallTag;
        if (bdBaseImageView != null) {
            TaskGuideData.Tpl tplData2 = this.taskGuideData.getTplData();
            bdBaseImageView.setImageBitmap(tplData2 != null ? tplData2.getResourceAmountIcon() : null);
        }
        TextView textView3 = this.mTvExpectAmount;
        if (textView3 != null) {
            TaskGuideData.Tpl tplData3 = this.taskGuideData.getTplData();
            textView3.setText(tplData3 != null ? tplData3.getTotalAmount() : null);
        }
        TextView textView4 = this.mTvExpectUnit;
        if (textView4 != null) {
            textView4.setText(AppRuntime.getAppContext().getResources().getString(R.string.money_unit_yuan));
        }
        BdBaseImageView bdBaseImageView2 = this.mImgExpectTag;
        if (bdBaseImageView2 != null) {
            TaskGuideData.Tpl tplData4 = this.taskGuideData.getTplData();
            if (tplData4 != null) {
                bitmap = tplData4.getResourceTotalAmountIcon();
            }
            bdBaseImageView2.setImageBitmap(bitmap);
        }
    }

    private final void updateResource() {
        TextView it = this.mButtonText;
        if (it != null) {
            setTextStyleBold(it);
            it.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC84));
        }
        TextView textView = this.mTvAmount;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC8));
        }
        TextView textView2 = this.mTvSmallUnit;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC8));
        }
        TextView textView3 = this.mTvExpectAmount;
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC8));
        }
        TextView textView4 = this.mTvExpectUnit;
        if (textView4 != null) {
            textView4.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC8));
        }
    }

    public void onRelease() {
    }

    public void updateData(TaskGuideData taskGuideData2) {
        Intrinsics.checkNotNullParameter(taskGuideData2, "taskGuideData");
        BdBaseImageView bdBaseImageView = this.mButtonConfirmBg;
        if (bdBaseImageView != null) {
            bdBaseImageView.setVisibility(4);
        }
        BdBaseImageView bdBaseImageView2 = this.mImgGuideBg;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.setVisibility(4);
        }
        BdBaseImageView bdBaseImageView3 = this.mButtonCircle;
        if (bdBaseImageView3 != null) {
            bdBaseImageView3.setVisibility(4);
        }
        BdBaseImageView bdBaseImageView4 = this.mButtonFinger;
        if (bdBaseImageView4 != null) {
            bdBaseImageView4.setVisibility(4);
        }
        BdBaseImageView bdBaseImageView5 = this.mButtonConfirmBg;
        Bitmap bitmap = null;
        if (bdBaseImageView5 != null) {
            TaskGuideData.Tpl tplData = taskGuideData2.getTplData();
            bdBaseImageView5.setImageBitmap(tplData != null ? tplData.getResourceButtonBitmap() : null);
        }
        TaskGuideData.Tpl tplData2 = taskGuideData2.getTplData();
        if ((tplData2 != null ? tplData2.getResourceButtonCircleIcon() : null) != null) {
            TaskGuideData.Tpl tplData3 = taskGuideData2.getTplData();
            if ((tplData3 != null ? tplData3.getResourceButtonFingerIcon() : null) != null) {
                BdBaseImageView bdBaseImageView6 = this.mButtonCircle;
                if (bdBaseImageView6 != null) {
                    TaskGuideData.Tpl tplData4 = taskGuideData2.getTplData();
                    bdBaseImageView6.setImageBitmap(tplData4 != null ? tplData4.getResourceButtonCircleIcon() : null);
                }
                BdBaseImageView bdBaseImageView7 = this.mButtonFinger;
                if (bdBaseImageView7 != null) {
                    TaskGuideData.Tpl tplData5 = taskGuideData2.getTplData();
                    if (tplData5 != null) {
                        bitmap = tplData5.getResourceButtonFingerIcon();
                    }
                    bdBaseImageView7.setImageBitmap(bitmap);
                }
            }
        }
    }

    public void playShowAnim() {
        ViewGroup bgLayout;
        ViewGroup tipsLayout;
        BdBaseImageView imgBg = this.mImgGuideBg;
        if (imgBg != null && (bgLayout = this.mBgLayout) != null && (tipsLayout = this.mTipsLayout) != null) {
            UiThreadUtils.getMainHandler().postDelayed(new GuideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda3(this, imgBg, bgLayout, tipsLayout), 220);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playShowAnim$lambda-9$lambda-8$lambda-7$lambda-6  reason: not valid java name */
    public static final void m20529playShowAnim$lambda9$lambda8$lambda7$lambda6(GuideInfoUpgradeStyleUITemplate this$0, BdBaseImageView $imgBg, ViewGroup $bgLayout, ViewGroup $tipsLayout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($imgBg, "$imgBg");
        Intrinsics.checkNotNullParameter($bgLayout, "$bgLayout");
        Intrinsics.checkNotNullParameter($tipsLayout, "$tipsLayout");
        ViewGroup viewGroup = this$0.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        this$0.showAllInfoAnimNewStyle($imgBg, $bgLayout, $tipsLayout, ((float) $bgLayout.getWidth()) * 0.5f, ((float) $bgLayout.getHeight()) * 0.5f);
        UiThreadUtils.getMainHandler().postDelayed(new GuideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda2(this$0), 600);
    }

    /* access modifiers changed from: private */
    /* renamed from: playShowAnim$lambda-9$lambda-8$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final void m20530playShowAnim$lambda9$lambda8$lambda7$lambda6$lambda5(GuideInfoUpgradeStyleUITemplate this$0) {
        BdBaseImageView circleImageView;
        BdBaseImageView fingerImageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BdBaseImageView bdBaseImageView = this$0.mButtonCircle;
        if (bdBaseImageView != null) {
            bdBaseImageView.setVisibility(0);
        }
        BdBaseImageView bdBaseImageView2 = this$0.mButtonConfirmBg;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.setVisibility(0);
        }
        BdBaseImageView bdBaseImageView3 = this$0.mButtonFinger;
        if (bdBaseImageView3 != null) {
            bdBaseImageView3.setVisibility(0);
        }
        FrameLayout shimmerLayout = this$0.mButtonLayout;
        if (shimmerLayout != null && (circleImageView = this$0.mButtonCircle) != null && (fingerImageView = this$0.mButtonFinger) != null) {
            this$0.startButtonAnimationNewStyle(shimmerLayout, circleImageView, fingerImageView);
        }
    }

    public boolean isLoadingState() {
        return this.mLoadingState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLoadingShow(boolean r14) {
        /*
            r13 = this;
            android.widget.FrameLayout r0 = r13.mButtonLayout
            if (r0 == 0) goto L_0x00e2
            r1 = 0
            com.baidu.searchbox.ui.BdBaseImageView r2 = r13.mButtonCircle
            if (r2 == 0) goto L_0x00e1
            r3 = 0
            com.baidu.searchbox.ui.BdBaseImageView r4 = r13.mButtonFinger
            if (r4 == 0) goto L_0x00e1
            r5 = 0
            r13.mLoadingState = r14
            r6 = 8
            r7 = 0
            if (r14 != 0) goto L_0x0031
            android.view.ViewGroup r8 = r13.mLoadingLayout
            if (r8 != 0) goto L_0x001b
            goto L_0x001e
        L_0x001b:
            r8.setVisibility(r6)
        L_0x001e:
            android.widget.TextView r6 = r13.mButtonText
            if (r6 != 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r6.setVisibility(r7)
        L_0x0026:
            r6 = r0
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r13.startButtonAnimationNewStyle(r6, r2, r4)
            goto L_0x00cd
        L_0x0031:
            android.view.ViewGroup r8 = r13.mLoadingLayout
            if (r8 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            r8.setVisibility(r7)
        L_0x0039:
            android.widget.TextView r8 = r13.mButtonText
            if (r8 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r8.setVisibility(r6)
        L_0x0041:
            r6 = r0
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r13.clearButtonAnimationNewStyle(r6, r2, r4)
            android.content.res.Resources r6 = r13.resource
            int r8 = com.baidu.searchbox.homeintroduction.R.color.task_guide_button_color_new
            r9 = 0
            int r6 = androidx.core.content.res.ResourcesCompat.getColor(r6, r8, r9)
            boolean r8 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r8 == 0) goto L_0x0067
            com.baidu.searchbox.introduction.data.TaskGuideData r8 = r13.taskGuideData
            com.baidu.searchbox.introduction.data.TaskGuideData$Tpl r8 = r8.getTplData()
            if (r8 == 0) goto L_0x0074
            java.lang.String r8 = r8.getLoadingNightColor()
            goto L_0x0075
        L_0x0067:
            com.baidu.searchbox.introduction.data.TaskGuideData r8 = r13.taskGuideData
            com.baidu.searchbox.introduction.data.TaskGuideData$Tpl r8 = r8.getTplData()
            if (r8 == 0) goto L_0x0074
            java.lang.String r8 = r8.getLoadingColor()
            goto L_0x0075
        L_0x0074:
            r8 = r9
        L_0x0075:
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0095
            r10 = -1
            int r11 = android.graphics.Color.parseColor(r8)     // Catch:{ Exception -> 0x0087 }
            r10 = r11
            goto L_0x0091
        L_0x0087:
            r11 = move-exception
            boolean r12 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r12 == 0) goto L_0x0091
            r11.printStackTrace()
        L_0x0091:
            r11 = -1
            if (r10 == r11) goto L_0x0095
            r6 = r10
        L_0x0095:
            android.widget.TextView r10 = r13.mLoadingText
            if (r10 == 0) goto L_0x009c
            r10.setTextColor(r6)
        L_0x009c:
            int r10 = android.graphics.Color.red(r6)
            int r11 = android.graphics.Color.green(r6)
            int r12 = android.graphics.Color.blue(r6)
            int r10 = android.graphics.Color.argb(r7, r10, r11, r12)
            android.widget.ProgressBar r11 = r13.mLoadingProgress
            if (r11 == 0) goto L_0x00b5
            android.graphics.drawable.Drawable r9 = r11.getIndeterminateDrawable()
        L_0x00b5:
            if (r9 == 0) goto L_0x00d8
            android.graphics.drawable.RotateDrawable r9 = (android.graphics.drawable.RotateDrawable) r9
            android.graphics.drawable.Drawable r9 = r9.getDrawable()
            if (r9 == 0) goto L_0x00cf
            android.graphics.drawable.GradientDrawable r9 = (android.graphics.drawable.GradientDrawable) r9
            r11 = 2
            int[] r11 = new int[r11]
            r11[r7] = r10
            r7 = 1
            r11[r7] = r6
            r9.setColors(r11)
        L_0x00cd:
            goto L_0x00e1
        L_0x00cf:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r7.<init>(r9)
            throw r7
        L_0x00d8:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable"
            r7.<init>(r9)
            throw r7
        L_0x00e1:
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.introduction.ui.GuideInfoUpgradeStyleUITemplate.setLoadingShow(boolean):void");
    }

    public void setFrameVisible() {
    }

    public void setViewOnClickListener(ITaskGuideUIClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    private final void setClickEvent() {
        ViewGroup viewGroup;
        TaskGuideData.Tpl tplData = this.taskGuideData.getTplData();
        if (Intrinsics.areEqual((Object) tplData != null ? tplData.getClickArea() : null, (Object) "button")) {
            BdBaseImageView bdBaseImageView = this.mButtonConfirmBg;
            if (bdBaseImageView != null) {
                bdBaseImageView.setOnClickListener(new GuideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda0(this));
                return;
            }
            return;
        }
        TaskGuideUITemplate taskGuideUITemplate = this;
        GuideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda1 guideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda1 = new GuideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda1(this);
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        } else {
            viewGroup = viewGroup2;
        }
        TaskGuideUITemplate.setCommonClickEvent$default(taskGuideUITemplate, guideInfoUpgradeStyleUITemplate$$ExternalSyntheticLambda1, viewGroup, (Integer) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickEvent$lambda-13  reason: not valid java name */
    public static final void m20531setClickEvent$lambda13(GuideInfoUpgradeStyleUITemplate this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskGuideData taskGuideData2 = this$0.taskGuideData;
        ITaskGuideUIClickListener iTaskGuideUIClickListener = this$0.mOnClickListener;
        if (iTaskGuideUIClickListener != null) {
            iTaskGuideUIClickListener.onClick(taskGuideData2, this$0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickEvent$lambda-14  reason: not valid java name */
    public static final void m20532setClickEvent$lambda14(GuideInfoUpgradeStyleUITemplate this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITaskGuideUIClickListener iTaskGuideUIClickListener = this$0.mOnClickListener;
        if (iTaskGuideUIClickListener != null) {
            iTaskGuideUIClickListener.onClick(this$0.taskGuideData, this$0);
        }
    }
}
