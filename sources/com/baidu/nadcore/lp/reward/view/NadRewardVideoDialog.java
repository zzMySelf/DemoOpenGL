package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.baidu.nadcore.business.R;
import com.baidu.nadcore.cmd.SchemeRouter;
import com.baidu.nadcore.load.AdLoadRuntime;
import com.baidu.nadcore.lp.reward.data.NadDialogButtonData;
import com.baidu.nadcore.lp.reward.data.NadRewardDialogData;
import com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime;
import com.baidu.nadcore.lp.reward.util.NadRewardRouteUtil;
import com.baidu.nadcore.model.RewardLpConst;
import com.baidu.nadcore.stats.Als;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.util.Base64Encoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u00072\b\b\u0002\u0010P\u001a\u00020D2\b\b\u0002\u0010Q\u001a\u00020D2\b\b\u0002\u0010R\u001a\u00020DJ\b\u0010S\u001a\u00020\bH\u0016J\b\u0010T\u001a\u00020\u0007H\u0002J\u0012\u0010U\u001a\u00020D2\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020$J\b\u0010Y\u001a\u00020\bH\u0016J\"\u0010Z\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u0007J\u0010\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0007H\u0002J\u0012\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010b\u001a\u00020c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J$\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010i\u001a\u00020\bH\u0016J\u000e\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010l\u001a\u00020\b2\u0006\u0010k\u001a\u00020*J\u001c\u0010m\u001a\u00020\b2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0018\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u0010p\u001a\u00020\bH\u0016J\u0014\u0010q\u001a\u00020\b2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\b0\u001cJ\u000e\u0010r\u001a\u00020\b2\u0006\u0010k\u001a\u00020*J\u0014\u0010s\u001a\u00020\b2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u001cJ\u0014\u0010u\u001a\u00020\b2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u001cJ\u001a\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010z\u001a\u00020\b2\b\u0010{\u001a\u0004\u0018\u00010|J\b\u0010}\u001a\u00020\bH\u0002J\u001e\u0010~\u001a\u00020\b*\u00020J2\u0006\u0010g\u001a\u000202\b\u0010\u0001\u001a\u00030\u0001H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u0016\u0010?\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001a\u0010C\u001a\u00020DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "afterClickListener", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", "convertClickListener", "Lkotlin/Function1;", "", "", "dialogBgLottie", "Lcom/airbnb/lottie/LottieAnimationView;", "getDialogBgLottie", "()Lcom/airbnb/lottie/LottieAnimationView;", "setDialogBgLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "dialogContent", "Landroid/view/View;", "getDialogContent", "()Landroid/view/View;", "setDialogContent", "(Landroid/view/View;)V", "dialogData", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "getDialogData", "()Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "setDialogData", "(Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;)V", "dialogDismissListener", "Lkotlin/Function0;", "dialogStub", "Landroid/view/ViewStub;", "getDialogStub", "()Landroid/view/ViewStub;", "setDialogStub", "(Landroid/view/ViewStub;)V", "dialogTopImg", "Lcom/baidu/nadcore/widget/AdImageView;", "getDialogTopImg", "()Lcom/baidu/nadcore/widget/AdImageView;", "setDialogTopImg", "(Lcom/baidu/nadcore/widget/AdImageView;)V", "downloadBtnClickListener", "Landroid/view/View$OnClickListener;", "ext", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "leaveBtnClickListener", "getLeaveBtnClickListener", "()Landroid/view/View$OnClickListener;", "setLeaveBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "lottieBtnClickListener", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "rootContainerView", "getRootContainerView", "setRootContainerView", "suspendRightAnsListener", "topImg", "getTopImg", "setTopImg", "upperLimit", "", "getUpperLimit", "()Z", "setUpperLimit", "(Z)V", "buildButton", "Landroid/widget/TextView;", "buttonData", "Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "type", "area", "btnIndex", "shouldCharge", "closeDialog", "isLottieDialogMainBtn", "dismiss", "getTaskCenterPolicy", "handleLocalCmd", "btnCmd", "initCloseIcon", "icon", "initCommonView", "logWelfareDialog", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onConvertClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setAfterClickListener", "listener", "setCloseBtnClickListener", "setConvertClickListener", "setData", "rewardDataJson", "setDialogContentView", "setDialogDismissListener", "setDownloadBtnClickListener", "setLottieBtnClkListener", "callback", "setSuspendRightAnsListener", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "startBgLottie", "context", "Landroid/content/Context;", "stopAnimation", "setBottomBtnStyle", "Landroid/widget/FrameLayout;", "bottomTextSize", "", "DialogClickListener", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardVideoDialog.kt */
public class NadRewardVideoDialog extends DialogFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private DialogClickListener afterClickListener;
    private Function1<? super String, Unit> convertClickListener;
    public LottieAnimationView dialogBgLottie;
    public View dialogContent;
    private NadRewardDialogData dialogData;
    private Function0<Unit> dialogDismissListener;
    public ViewStub dialogStub;
    public AdImageView dialogTopImg;
    private View.OnClickListener downloadBtnClickListener;
    private String ext = "";
    private View.OnClickListener leaveBtnClickListener;
    private Function0<Unit> lottieBtnClickListener;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    public View rootContainerView;
    private Function0<Unit> suspendRightAnsListener;
    public AdImageView topImg;
    private boolean upperLimit;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", "", "chargeClick", "", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadRewardVideoDialog.kt */
    public interface DialogClickListener {
        void chargeClick();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View view3 = getView();
        if (view3 == null || (findViewById = view3.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final View getRootContainerView() {
        View view2 = this.rootContainerView;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootContainerView");
        return null;
    }

    public final void setRootContainerView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.rootContainerView = view2;
    }

    public final AdImageView getTopImg() {
        AdImageView adImageView = this.topImg;
        if (adImageView != null) {
            return adImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topImg");
        return null;
    }

    public final void setTopImg(AdImageView adImageView) {
        Intrinsics.checkNotNullParameter(adImageView, "<set-?>");
        this.topImg = adImageView;
    }

    public final AdImageView getDialogTopImg() {
        AdImageView adImageView = this.dialogTopImg;
        if (adImageView != null) {
            return adImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogTopImg");
        return null;
    }

    public final void setDialogTopImg(AdImageView adImageView) {
        Intrinsics.checkNotNullParameter(adImageView, "<set-?>");
        this.dialogTopImg = adImageView;
    }

    public final LottieAnimationView getDialogBgLottie() {
        LottieAnimationView lottieAnimationView = this.dialogBgLottie;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogBgLottie");
        return null;
    }

    public final void setDialogBgLottie(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.dialogBgLottie = lottieAnimationView;
    }

    public final ViewStub getDialogStub() {
        ViewStub viewStub = this.dialogStub;
        if (viewStub != null) {
            return viewStub;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
        return null;
    }

    public final void setDialogStub(ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "<set-?>");
        this.dialogStub = viewStub;
    }

    public final View getDialogContent() {
        View view2 = this.dialogContent;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
        return null;
    }

    public final void setDialogContent(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.dialogContent = view2;
    }

    public final View.OnClickListener getLeaveBtnClickListener() {
        return this.leaveBtnClickListener;
    }

    public final void setLeaveBtnClickListener(View.OnClickListener onClickListener) {
        this.leaveBtnClickListener = onClickListener;
    }

    public final NadRewardDialogData getDialogData() {
        return this.dialogData;
    }

    public final void setDialogData(NadRewardDialogData nadRewardDialogData) {
        this.dialogData = nadRewardDialogData;
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public final void setMainHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mainHandler = handler;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext = str;
    }

    public final boolean getUpperLimit() {
        return this.upperLimit;
    }

    public final void setUpperLimit(boolean z) {
        this.upperLimit = z;
    }

    public void setData(String rewardDataJson, String ext2) {
        Intrinsics.checkNotNullParameter(rewardDataJson, "rewardDataJson");
        Intrinsics.checkNotNullParameter(ext2, "ext");
        NadRewardDialogData nadRewardDialogData = new NadRewardDialogData(rewardDataJson);
        this.dialogData = nadRewardDialogData;
        this.ext = ext2;
        Intrinsics.checkNotNull(nadRewardDialogData);
        this.upperLimit = nadRewardDialogData.getUpperLimit();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.nad_reward_video_dialog_style);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialog, "super.onCreateDialog(savedInstanceState)");
        Window window = dialog.getWindow();
        WindowManager.LayoutParams windowParams = window != null ? window.getAttributes() : null;
        if (windowParams != null) {
            windowParams.gravity = 17;
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(windowParams);
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean z = true;
        View rootView = inflater.inflate(NadRewardVideoLpRuntime.getUIProvider().getDialogUI(), container, true);
        View findViewById = rootView.findViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.root_view)");
        setRootContainerView(findViewById);
        View findViewById2 = rootView.findViewById(R.id.top_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.top_img)");
        setTopImg((AdImageView) findViewById2);
        View findViewById3 = rootView.findViewById(R.id.dialog_top_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.dialog_top_img)");
        setDialogTopImg((AdImageView) findViewById3);
        View findViewById4 = rootView.findViewById(R.id.dialog_bg_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.dialog_bg_lottie)");
        setDialogBgLottie((LottieAnimationView) findViewById4);
        View findViewById5 = rootView.findViewById(R.id.dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.dialog_content)");
        setDialogStub((ViewStub) findViewById5);
        if (this.ext.length() != 0) {
            z = false;
        }
        if (z || this.dialogData == null) {
            dismiss();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        setDialogContentView();
        initCommonView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    public void initCommonView() {
        AdImageView adImageView;
        NadRewardDialogData data = this.dialogData;
        if (data != null) {
            View $this$checkVisible$iv = getTopImg();
            CharSequence topImg2 = data.getTopImg();
            AdImageView adImageView2 = null;
            if (!(topImg2 == null || topImg2.length() == 0)) {
                $this$checkVisible$iv.setVisibility(0);
                adImageView = $this$checkVisible$iv;
            } else {
                $this$checkVisible$iv.setVisibility(8);
                View view2 = null;
                adImageView = null;
            }
            AdImageView adImageView3 = adImageView;
            if (adImageView3 != null) {
                adImageView3.displayImage(data.getTopImg());
            }
            View $this$checkVisible$iv2 = getDialogTopImg();
            CharSequence dialogTopImg2 = data.getDialogTopImg();
            if (!(dialogTopImg2 == null || dialogTopImg2.length() == 0)) {
                $this$checkVisible$iv2.setVisibility(0);
                adImageView2 = $this$checkVisible$iv2;
            } else {
                $this$checkVisible$iv2.setVisibility(8);
                View view3 = null;
            }
            AdImageView adImageView4 = adImageView2;
            if (adImageView4 != null) {
                adImageView4.displayImage(data.getDialogTopImg());
            }
            View dialogContent2 = getDialogContent();
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable $this$initCommonView_u24lambda_u2d2 = gradientDrawable;
            $this$initCommonView_u24lambda_u2d2.setOrientation(GradientDrawable.Orientation.TL_BR);
            $this$initCommonView_u24lambda_u2d2.setCornerRadius((float) DeviceUtils.ScreenInfo.dp2px(getContext(), 18.0f));
            $this$initCommonView_u24lambda_u2d2.setColors(new int[]{data.getBgStartColor(), data.getBgEndColor()});
            $this$initCommonView_u24lambda_u2d2.setStroke(DeviceUtils.ScreenInfo.dp2px(getContext(), 2.0f), data.getBorderColor());
            dialogContent2.setBackground(gradientDrawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x01ae, code lost:
        r1 = r0.getMainBtn();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDialogContentView() {
        /*
            r34 = this;
            r10 = r34
            android.view.ViewStub r0 = r34.getDialogStub()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogContentUI()
            r0.setLayoutResource(r1)
            android.view.ViewStub r0 = r34.getDialogStub()
            android.view.View r0 = r0.inflate()
            java.lang.String r1 = "dialogStub.inflate()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10.setDialogContent(r0)
            android.content.res.Resources r0 = r34.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogConvertBtnTextSize()
            float r11 = r0.getDimension(r1)
            android.content.res.Resources r0 = r34.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogMainBtnTextSize()
            float r12 = r0.getDimension(r1)
            android.content.res.Resources r0 = r34.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogMainBtnHeight()
            float r13 = r0.getDimension(r1)
            android.content.res.Resources r0 = r34.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogMainBtnWidth()
            float r14 = r0.getDimension(r1)
            android.content.res.Resources r0 = r34.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r1 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r1 = r1.getDialogBottomBtnTextSize()
            float r15 = r0.getDimension(r1)
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.close_img
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.close_img)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9 = r0
            com.baidu.nadcore.widget.AdImageView r9 = (com.baidu.nadcore.widget.AdImageView) r9
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.avatar
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.avatar)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r16 = r0
            com.baidu.nadcore.widget.AdImageView r16 = (com.baidu.nadcore.widget.AdImageView) r16
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.title
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.sub_title
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.sub_title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r18 = r0
            android.widget.TextView r18 = (android.widget.TextView) r18
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.button_container
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.button_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8 = r0
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.bottom_btn_container
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewBy….id.bottom_btn_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r7 = r0
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.left_container
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.left_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6 = r0
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.right_container
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.right_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            android.view.View r0 = r34.getDialogContent()
            int r1 = com.baidu.nadcore.business.R.id.bottom_divider
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "dialogContent.findViewById(R.id.bottom_divider)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r19 = r0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            r20 = 1
            r4 = 0
            r21 = 0
            if (r0 == 0) goto L_0x019c
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r1 = r0.getConvertBtn()
            if (r1 == 0) goto L_0x019c
            r22 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isDownloadAd()
            r23 = r0 ^ 1
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isDownloadAd()
            if (r0 == 0) goto L_0x0142
            com.baidu.nadcore.stats.request.ClogBuilder$LogType r0 = com.baidu.nadcore.stats.request.ClogBuilder.LogType.FREE_CLICK
            java.lang.String r0 = r0.type
            r2 = r0
            goto L_0x0147
        L_0x0142:
            com.baidu.nadcore.stats.request.ClogBuilder$LogType r0 = com.baidu.nadcore.stats.request.ClogBuilder.LogType.CLICK
            java.lang.String r0 = r0.type
            r2 = r0
        L_0x0147:
            com.baidu.nadcore.stats.request.ClogBuilder$Area r0 = com.baidu.nadcore.stats.request.ClogBuilder.Area.AD_BTN_DETAIL
            java.lang.String r3 = r0.type
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isDownloadAd()
            if (r0 != 0) goto L_0x0166
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isOldImageStyle()
            if (r0 == 0) goto L_0x0163
            goto L_0x0166
        L_0x0163:
            r24 = r4
            goto L_0x0168
        L_0x0166:
            r24 = r20
        L_0x0168:
            java.lang.String r0 = "if (dialogData!!.isDownl…CK.type\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r25 = 0
            r26 = 0
            r27 = 72
            r28 = 0
            r0 = r34
            r4 = r25
            r29 = r5
            r5 = r23
            r30 = r6
            r6 = r24
            r31 = r7
            r7 = r26
            r32 = r8
            r8 = r27
            r33 = r9
            r9 = r28
            android.widget.TextView r0 = buildButton$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x01a8
        L_0x019c:
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r8
            r33 = r9
            r0 = r21
        L_0x01a8:
            r22 = r0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            if (r0 == 0) goto L_0x01c7
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r1 = r0.getMainBtn()
            if (r1 == 0) goto L_0x01c7
            r23 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 118(0x76, float:1.65E-43)
            r9 = 0
            java.lang.String r4 = "1"
            r0 = r34
            android.widget.TextView r0 = buildButton$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x01c9
        L_0x01c7:
            r0 = r21
        L_0x01c9:
            r23 = r0
            boolean r0 = r10.upperLimit
            if (r0 != 0) goto L_0x0217
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            if (r0 == 0) goto L_0x01f6
            java.lang.String r0 = r0.getTaskCenterPolicyStr()
            if (r0 == 0) goto L_0x01f6
            r1 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r2 = r10.dialogData
            if (r2 == 0) goto L_0x01f6
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r2 = r2.getBottomRightBtn()
            if (r2 == 0) goto L_0x01f6
            java.lang.String r3 = r2.getBtnCmd()
            if (r3 == 0) goto L_0x01f6
            java.lang.String r5 = r34.getTaskCenterPolicy()
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = "__TASKCENTERPOLICY__"
            kotlin.text.StringsKt.replace$default((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
        L_0x01f6:
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            if (r0 == 0) goto L_0x0214
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r1 = r0.getBottomRightBtn()
            if (r1 == 0) goto L_0x0214
            r24 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 118(0x76, float:1.65E-43)
            r9 = 0
            java.lang.String r4 = "2"
            r0 = r34
            android.widget.TextView r0 = buildButton$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x021d
        L_0x0214:
            r0 = r21
            goto L_0x021d
        L_0x0217:
            r0 = r21
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0 = r21
        L_0x021d:
            r24 = r0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r0 = r10.dialogData
            if (r0 == 0) goto L_0x0243
            com.baidu.nadcore.lp.reward.data.NadDialogButtonData r1 = r0.getBottomLeftBtn()
            if (r1 == 0) goto L_0x0243
            r25 = 0
            r2 = 0
            com.baidu.nadcore.stats.request.ClogBuilder$Area r0 = com.baidu.nadcore.stats.request.ClogBuilder.Area.AD_LEAVE
            java.lang.String r3 = r0.type
            java.lang.String r0 = "AD_LEAVE.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 122(0x7a, float:1.71E-43)
            r9 = 0
            r0 = r34
            android.widget.TextView r0 = buildButton$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0245
        L_0x0243:
            r0 = r21
        L_0x0245:
            r1 = r16
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            r3 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r4 = r10.dialogData
            if (r4 == 0) goto L_0x0255
            java.lang.String r4 = r4.getAvatar()
            goto L_0x0257
        L_0x0255:
            r4 = r21
        L_0x0257:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0264
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0262
            goto L_0x0264
        L_0x0262:
            r4 = 0
            goto L_0x0266
        L_0x0264:
            r4 = r20
        L_0x0266:
            r4 = r4 ^ 1
            r3 = 8
            if (r4 == 0) goto L_0x0272
            r4 = 0
            r1.setVisibility(r4)
            r5 = r1
            goto L_0x027c
        L_0x0272:
            r4 = 0
            r1.setVisibility(r3)
            r5 = r21
            android.view.View r5 = (android.view.View) r5
            r5 = r21
        L_0x027c:
            com.baidu.nadcore.widget.AdImageView r5 = (com.baidu.nadcore.widget.AdImageView) r5
            if (r5 == 0) goto L_0x029b
            r1 = r5
            r2 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r5 = r10.dialogData
            if (r5 == 0) goto L_0x028d
            java.lang.String r5 = r5.getAvatar()
            goto L_0x028f
        L_0x028d:
            r5 = r21
        L_0x028f:
            r1.displayImage(r5)
            com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda3 r5 = new com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda3
            r5.<init>(r10)
            r1.setOnClickListener(r5)
        L_0x029b:
            r1 = r17
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            r5 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r6 = r10.dialogData
            if (r6 == 0) goto L_0x02ac
            java.lang.String r6 = r6.getTitle()
            goto L_0x02ae
        L_0x02ac:
            r6 = r21
        L_0x02ae:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x02bb
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x02b9
            goto L_0x02bb
        L_0x02b9:
            r6 = r4
            goto L_0x02bd
        L_0x02bb:
            r6 = r20
        L_0x02bd:
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x02c6
            r1.setVisibility(r4)
            r5 = r1
            goto L_0x02cf
        L_0x02c6:
            r1.setVisibility(r3)
            r5 = r21
            android.view.View r5 = (android.view.View) r5
            r5 = r21
        L_0x02cf:
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x02f0
            r1 = r5
            r2 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r5 = r10.dialogData
            if (r5 == 0) goto L_0x02e0
            java.lang.String r5 = r5.getTitle()
            goto L_0x02e2
        L_0x02e0:
            r5 = r21
        L_0x02e2:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda4 r5 = new com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda4
            r5.<init>(r10)
            r1.setOnClickListener(r5)
        L_0x02f0:
            r1 = r18
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            r5 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r6 = r10.dialogData
            if (r6 == 0) goto L_0x0301
            java.lang.String r6 = r6.getSubTitle()
            goto L_0x0303
        L_0x0301:
            r6 = r21
        L_0x0303:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0310
            int r6 = r6.length()
            if (r6 != 0) goto L_0x030e
            goto L_0x0310
        L_0x030e:
            r6 = r4
            goto L_0x0312
        L_0x0310:
            r6 = r20
        L_0x0312:
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x031b
            r1.setVisibility(r4)
            r5 = r1
            goto L_0x0324
        L_0x031b:
            r1.setVisibility(r3)
            r5 = r21
            android.view.View r5 = (android.view.View) r5
            r5 = r21
        L_0x0324:
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0345
            r1 = r5
            r2 = 0
            com.baidu.nadcore.lp.reward.data.NadRewardDialogData r5 = r10.dialogData
            if (r5 == 0) goto L_0x0335
            java.lang.String r5 = r5.getSubTitle()
            goto L_0x0337
        L_0x0335:
            r5 = r21
        L_0x0337:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda5 r5 = new com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog$$ExternalSyntheticLambda5
            r5.<init>(r10)
            r1.setOnClickListener(r5)
        L_0x0345:
            r1 = 17
            if (r23 == 0) goto L_0x0386
            r2 = r23
            r5 = 0
            android.graphics.Typeface r6 = android.graphics.Typeface.defaultFromStyle(r20)
            r2.setTypeface(r6)
            r2.setTextSize(r4, r12)
            r2.setGravity(r1)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r7 = -1
            r6.<init>(r7, r7)
            android.content.res.Resources r7 = r2.getResources()
            com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r8 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
            int r8 = r8.getDialogMainBtnTopMargin()
            int r7 = r7.getDimensionPixelSize(r8)
            r6.topMargin = r7
            int r7 = (int) r13
            r6.height = r7
            int r7 = (int) r14
            r6.width = r7
            r7 = r2
            android.view.View r7 = (android.view.View) r7
            r8 = r6
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r9 = r32
            r9.addView(r7, r4, r8)
            goto L_0x0388
        L_0x0386:
            r9 = r32
        L_0x0388:
            if (r22 == 0) goto L_0x03ab
            r2 = r22
            r5 = 0
            android.graphics.Typeface r6 = android.graphics.Typeface.defaultFromStyle(r20)
            r2.setTypeface(r6)
            r2.setTextSize(r4, r11)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            r6.gravity = r1
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            r7 = r6
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r9.addView(r1, r4, r7)
        L_0x03ab:
            r1 = r19
            r2 = 0
            r5 = 0
            if (r24 == 0) goto L_0x03b2
            goto L_0x03b4
        L_0x03b2:
            r20 = r4
        L_0x03b4:
            if (r20 == 0) goto L_0x03ba
            r1.setVisibility(r4)
            goto L_0x03bf
        L_0x03ba:
            r1.setVisibility(r3)
            android.view.View r21 = (android.view.View) r21
        L_0x03bf:
            if (r0 == 0) goto L_0x03d0
            r1 = r0
            r2 = 0
            r3 = r30
            r10.setBottomBtnStyle(r1, r3, r15)
            r5 = r31
            r5.setVisibility(r4)
            goto L_0x03d4
        L_0x03d0:
            r3 = r30
            r5 = r31
        L_0x03d4:
            if (r24 == 0) goto L_0x03e4
            r1 = r24
            r2 = 0
            r6 = r29
            r10.setBottomBtnStyle(r1, r6, r15)
            r5.setVisibility(r4)
            goto L_0x03e6
        L_0x03e4:
            r6 = r29
        L_0x03e6:
            r1 = r33
            r10.initCloseIcon(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.setDialogContentView():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setDialogContentView$lambda-10$lambda-9  reason: not valid java name */
    public static final void m14146setDialogContentView$lambda10$lambda9(NadRewardVideoDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = ClogBuilder.Area.AVATAR.type;
        Intrinsics.checkNotNullExpressionValue(str, "AVATAR.type");
        this$0.onConvertClick(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDialogContentView$lambda-13$lambda-12  reason: not valid java name */
    public static final void m14147setDialogContentView$lambda13$lambda12(NadRewardVideoDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = ClogBuilder.Area.NAME.type;
        Intrinsics.checkNotNullExpressionValue(str, "NAME.type");
        this$0.onConvertClick(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDialogContentView$lambda-16$lambda-15  reason: not valid java name */
    public static final void m14148setDialogContentView$lambda16$lambda15(NadRewardVideoDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = ClogBuilder.Area.TITTLE.type;
        Intrinsics.checkNotNullExpressionValue(str, "TITTLE.type");
        this$0.onConvertClick(str);
    }

    private final void setBottomBtnStyle(TextView $this$setBottomBtnStyle, FrameLayout container, float bottomTextSize) {
        TextView $this$setBottomBtnStyle_u24lambda_u2d22 = $this$setBottomBtnStyle;
        $this$setBottomBtnStyle_u24lambda_u2d22.setTypeface(Typeface.defaultFromStyle(1));
        $this$setBottomBtnStyle_u24lambda_u2d22.setTextSize(0, bottomTextSize);
        $this$setBottomBtnStyle_u24lambda_u2d22.setGravity(17);
        ViewParent parent = $this$setBottomBtnStyle_u24lambda_u2d22.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView($this$setBottomBtnStyle_u24lambda_u2d22);
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 17;
        container.addView($this$setBottomBtnStyle_u24lambda_u2d22, params);
        container.setVisibility(0);
    }

    private final void onConvertClick(String area) {
        View.OnClickListener onClickListener;
        String str = ClogBuilder.LogType.CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str, "CLICK.type");
        logWelfareDialog$default(this, str, area, (String) null, 4, (Object) null);
        DialogClickListener dialogClickListener = this.afterClickListener;
        if (dialogClickListener != null) {
            dialogClickListener.chargeClick();
        }
        NadRewardDialogData nadRewardDialogData = this.dialogData;
        boolean z = true;
        if (nadRewardDialogData != null && nadRewardDialogData.isOldImageStyle()) {
            NadRewardDialogData nadRewardDialogData2 = this.dialogData;
            if (nadRewardDialogData2 == null || !nadRewardDialogData2.isDownloadAd()) {
                z = false;
            }
            if (z && (onClickListener = this.downloadBtnClickListener) != null) {
                onClickListener.onClick(getView());
            }
            dismiss();
            return;
        }
        Function1<? super String, Unit> function1 = this.convertClickListener;
        if (function1 != null) {
            NadRewardDialogData nadRewardDialogData3 = this.dialogData;
            function1.invoke(nadRewardDialogData3 != null ? nadRewardDialogData3.getConvertCmd() : null);
        }
    }

    public final void initCloseIcon(AdImageView icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        AdImageView $this$initCloseIcon_u24lambda_u2d24 = icon;
        NadRewardDialogData nadRewardDialogData = this.dialogData;
        String str = null;
        CharSequence closeImg = nadRewardDialogData != null ? nadRewardDialogData.getCloseImg() : null;
        if (closeImg == null || StringsKt.isBlank(closeImg)) {
            $this$initCloseIcon_u24lambda_u2d24.setImageDrawable(ContextCompat.getDrawable($this$initCloseIcon_u24lambda_u2d24.getContext(), R.drawable.nad_reward_video_lp_close_btn));
        } else {
            NadRewardDialogData nadRewardDialogData2 = this.dialogData;
            if (nadRewardDialogData2 != null) {
                str = nadRewardDialogData2.getCloseImg();
            }
            $this$initCloseIcon_u24lambda_u2d24.displayImage(str);
        }
        $this$initCloseIcon_u24lambda_u2d24.setOnClickListener(new NadRewardVideoDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initCloseIcon$lambda-24$lambda-23  reason: not valid java name */
    public static final void m14145initCloseIcon$lambda24$lambda23(NadRewardVideoDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = ClogBuilder.LogType.FREE_CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str, "FREE_CLICK.type");
        logWelfareDialog$default(this$0, str, "close", (String) null, 4, (Object) null);
        this$0.dismiss();
    }

    public static /* synthetic */ TextView buildButton$default(NadRewardVideoDialog nadRewardVideoDialog, NadDialogButtonData nadDialogButtonData, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        String str4;
        String str5;
        boolean z4;
        boolean z5;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str4 = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str4, "FREE_CLICK.type");
            } else {
                str4 = str;
            }
            String str6 = "";
            if ((i2 & 4) != 0) {
                str5 = str6;
            } else {
                str5 = str2;
            }
            if ((i2 & 8) == 0) {
                str6 = str3;
            }
            boolean z6 = false;
            if ((i2 & 16) != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if ((i2 & 32) != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if ((i2 & 64) == 0) {
                z6 = z3;
            }
            return nadRewardVideoDialog.buildButton(nadDialogButtonData, str4, str5, str6, z4, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildButton");
    }

    public final TextView buildButton(NadDialogButtonData buttonData, String type, String area, String btnIndex, boolean shouldCharge, boolean closeDialog, boolean isLottieDialogMainBtn) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, MessageManifest.Advert.Key.AREA);
        Intrinsics.checkNotNullParameter(btnIndex, "btnIndex");
        TextView button = new TextView(getContext());
        View $this$setBgFromUrl$iv = button;
        String url$iv = buttonData.getBtnBackground();
        Context $this$loadDrawableFromUrl_u24default$iv$iv = $this$setBgFromUrl$iv.getContext();
        Intrinsics.checkNotNullExpressionValue($this$loadDrawableFromUrl_u24default$iv$iv, "context");
        CharSequence charSequence = url$iv;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            AdLoadRuntime.image().loadImage(url$iv, new NadRewardVideoDialog$buildButton$$inlined$setBgFromUrl$1($this$loadDrawableFromUrl_u24default$iv$iv, $this$setBgFromUrl$iv));
        }
        if (!TextUtils.isEmpty(buttonData.getTextColor())) {
            button.setTextColor(Color.parseColor(buttonData.getTextColor()));
        }
        Context localContext = getContext();
        if (buttonData.getBtnIcon().length() > 0) {
            if (localContext != null) {
                drawable = ContextCompat.getDrawable(localContext, R.drawable.nad_reward_dialog_convert_btn_default);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, ExtensionsKt.px(10, localContext), ExtensionsKt.px(10, localContext));
            }
            button.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            if (localContext != null) {
                button.setCompoundDrawablePadding(ExtensionsKt.px(2, localContext));
            }
        }
        if (localContext != null) {
            String url$iv2 = buttonData.getBtnIcon();
            Context $this$loadDrawableFromUrl_u24default$iv = localContext;
            CharSequence charSequence2 = url$iv2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                AdLoadRuntime.image().loadImage(url$iv2, new NadRewardVideoDialog$buildButton$$inlined$loadDrawableFromUrl$default$1($this$loadDrawableFromUrl_u24default$iv, localContext, button));
            }
        }
        button.setText(buttonData.getBtnText());
        button.setIncludeFontPadding(false);
        button.setOnClickListener(new NadRewardVideoDialog$$ExternalSyntheticLambda6(this, type, area, btnIndex, buttonData, shouldCharge, closeDialog));
        if (isLottieDialogMainBtn) {
            Function0<Unit> function0 = this.lottieBtnClickListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return button;
    }

    /* access modifiers changed from: private */
    /* renamed from: buildButton$lambda-28  reason: not valid java name */
    public static final void m14144buildButton$lambda28(NadRewardVideoDialog this$0, String $type, String $area, String $btnIndex, NadDialogButtonData $buttonData, boolean $shouldCharge, boolean $closeDialog, View it) {
        DialogClickListener dialogClickListener;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($type, "$type");
        Intrinsics.checkNotNullParameter($area, "$area");
        Intrinsics.checkNotNullParameter($btnIndex, "$btnIndex");
        Intrinsics.checkNotNullParameter($buttonData, "$buttonData");
        this$0.logWelfareDialog($type, $area, $btnIndex);
        if (!this$0.handleLocalCmd($buttonData.getBtnCmd())) {
            if (NadRewardRouteUtil.INSTANCE.checkRewardPanelPop($buttonData.getBtnCmd())) {
                Function1<? super String, Unit> function1 = this$0.convertClickListener;
                if (function1 != null) {
                    if (NadRewardRouteUtil.INSTANCE.hitFormSwitch()) {
                        str = $buttonData.getBtnCmd();
                    } else {
                        NadRewardDialogData nadRewardDialogData = this$0.dialogData;
                        str = nadRewardDialogData != null ? nadRewardDialogData.getConvertCmd() : null;
                    }
                    function1.invoke(str);
                }
            } else {
                SchemeRouter.invoke($buttonData.getBtnCmd(), this$0.getContext());
            }
        }
        if ($shouldCharge && (dialogClickListener = this$0.afterClickListener) != null) {
            dialogClickListener.chargeClick();
        }
        if ($closeDialog) {
            this$0.dismiss();
        }
    }

    private final boolean handleLocalCmd(String btnCmd) {
        if (TextUtils.isEmpty(btnCmd)) {
            return true;
        }
        if (btnCmd != null) {
            String str = null;
            switch (btnCmd.hashCode()) {
                case -1077350185:
                    if (btnCmd.equals(RewardLpConst.KEY_QUIT)) {
                        View.OnClickListener onClickListener = this.leaveBtnClickListener;
                        if (onClickListener == null) {
                            return true;
                        }
                        onClickListener.onClick(getView());
                        return true;
                    }
                    break;
                case 72359676:
                    if (btnCmd.equals("__RIGHT__")) {
                        Context context = getContext();
                        NadRewardDialogData nadRewardDialogData = this.dialogData;
                        if (nadRewardDialogData != null) {
                            str = nadRewardDialogData.getRightAnswerToast();
                        }
                        Toast.makeText(context, str, 0).show();
                        Function0<Unit> function0 = this.suspendRightAnsListener;
                        if (function0 == null) {
                            return true;
                        }
                        function0.invoke();
                        return true;
                    }
                    break;
                case 446830939:
                    if (btnCmd.equals(RewardLpConst.KEY_CONTINUE_PLAY)) {
                        return true;
                    }
                    break;
                case 480127565:
                    if (btnCmd.equals("__WRONG__")) {
                        Context context2 = getContext();
                        NadRewardDialogData nadRewardDialogData2 = this.dialogData;
                        if (nadRewardDialogData2 != null) {
                            str = nadRewardDialogData2.getWrongAnswerToast();
                        }
                        Toast.makeText(context2, str, 0).show();
                        return true;
                    }
                    break;
                case 1522490442:
                    if (btnCmd.equals(RewardLpConst.KEY_START_DOWNLOAD)) {
                        View.OnClickListener onClickListener2 = this.downloadBtnClickListener;
                        if (onClickListener2 == null) {
                            return true;
                        }
                        onClickListener2.onClick(getView());
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public void dismiss() {
        try {
            Dialog dialog = getDialog();
            boolean z = true;
            if (dialog == null || !dialog.isShowing()) {
                z = false;
            }
            if (z) {
                dismissAllowingStateLoss();
            }
        } catch (IllegalArgumentException e2) {
        }
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        String str = ClogBuilder.LogType.FREE_CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str, "FREE_CLICK.type");
        logWelfareDialog$default(this, str, "blank", (String) null, 4, (Object) null);
    }

    public void onDetach() {
        super.onDetach();
        Function0<Unit> function0 = this.dialogDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.mainHandler.removeCallbacksAndMessages((Object) null);
        stopAnimation();
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        try {
            super.show(manager, tag);
        } catch (Exception e2) {
            dismiss();
        }
        String str = ClogBuilder.LogType.FREE_SHOW.type;
        Intrinsics.checkNotNullExpressionValue(str, "FREE_SHOW.type");
        logWelfareDialog$default(this, str, (String) null, (String) null, 6, (Object) null);
    }

    public final void setCloseBtnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.leaveBtnClickListener = listener;
    }

    public final void setDialogDismissListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dialogDismissListener = listener;
    }

    public final void setDownloadBtnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.downloadBtnClickListener = listener;
    }

    public final void setAfterClickListener(DialogClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.afterClickListener = listener;
    }

    public final void setConvertClickListener(Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.convertClickListener = listener;
    }

    public final void setSuspendRightAnsListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.suspendRightAnsListener = callback;
    }

    public final void setLottieBtnClkListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.lottieBtnClickListener = callback;
    }

    public static /* synthetic */ void logWelfareDialog$default(NadRewardVideoDialog nadRewardVideoDialog, String str, String str2, String str3, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = "";
            }
            if ((i2 & 4) != 0) {
                str3 = "";
            }
            nadRewardVideoDialog.logWelfareDialog(str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logWelfareDialog");
    }

    public final void logWelfareDialog(String type, String area, String btnIndex) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, MessageManifest.Advert.Key.AREA);
        Intrinsics.checkNotNullParameter(btnIndex, "btnIndex");
        if (!(this.ext.length() == 0) && this.dialogData != null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            ClogBuilder $this$logWelfareDialog_u24lambda_u2d29 = clogBuilder;
            $this$logWelfareDialog_u24lambda_u2d29.setPage(ClogBuilder.Page.WELFAREPANEL);
            $this$logWelfareDialog_u24lambda_u2d29.setType(type);
            $this$logWelfareDialog_u24lambda_u2d29.setExtraParam(this.ext);
            $this$logWelfareDialog_u24lambda_u2d29.setArea(area);
            $this$logWelfareDialog_u24lambda_u2d29.setExt1(btnIndex);
            NadRewardDialogData nadRewardDialogData = this.dialogData;
            $this$logWelfareDialog_u24lambda_u2d29.setExt2(String.valueOf(nadRewardDialogData != null ? nadRewardDialogData.getDialogType() : null));
            Als.send(clogBuilder);
        }
    }

    public final void startBgLottie(Context context) {
        if (context != null) {
            stopAnimation();
            NadRewardDialogData nadRewardDialogData = this.dialogData;
            String it = nadRewardDialogData != null ? nadRewardDialogData.getBgLottieUrl() : null;
            LottieCompositionFactory.fromUrl(context, it, String.valueOf(it != null ? it.hashCode() : 0)).addListener(new NadRewardVideoDialog$$ExternalSyntheticLambda1(this)).addFailureListener(new NadRewardVideoDialog$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startBgLottie$lambda-32$lambda-30  reason: not valid java name */
    public static final void m14149startBgLottie$lambda32$lambda30(NadRewardVideoDialog this$0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDialogBgLottie().setComposition(lottieComposition);
        this$0.getDialogBgLottie().playAnimation();
        this$0.getDialogBgLottie().setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: startBgLottie$lambda-32$lambda-31  reason: not valid java name */
    public static final void m14150startBgLottie$lambda32$lambda31(NadRewardVideoDialog this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDialogBgLottie().setVisibility(8);
    }

    private final void stopAnimation() {
        getDialogBgLottie().cancelAnimation();
        getDialogBgLottie().setVisibility(8);
    }

    private final String getTaskCenterPolicy() {
        String it;
        NadRewardDialogData nadRewardDialogData;
        String taskCenterPolicyStr;
        NadRewardDialogData nadRewardDialogData2 = this.dialogData;
        String str = null;
        if (!(nadRewardDialogData2 == null || (it = nadRewardDialogData2.getInvokeCmdCoin()) == null || (nadRewardDialogData = this.dialogData) == null || (taskCenterPolicyStr = nadRewardDialogData.getTaskCenterPolicyStr()) == null)) {
            str = StringsKt.replace$default(taskCenterPolicyStr, "__INVOKECOIN__", it, false, 4, (Object) null);
        }
        String taskCenterPolicyStr2 = str;
        CharSequence charSequence = taskCenterPolicyStr2;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        byte[] byteArray = taskCenterPolicyStr2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(byteArray, "this as java.lang.String).getBytes(charset)");
        return Base64Encoder.B64Encode(byteArray).toString();
    }
}
