package com.baidu.searchbox.hissug.util.copy;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.behavior.record.api.BehaviorId;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.drag.LaunchDragUBCManager;
import com.baidu.searchbox.hissug.data.utils.HisCopyDirectRegexDataUtilsKt;
import com.baidu.searchbox.hissug.ui.EmptyBoxHisSugView;
import com.baidu.searchbox.hissug.ui.HisCopyDirectVisitView;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0013H\u0002\u001a\b\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002\u001a\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"INTERVAL", "", "REGEX_ADDRESS", "", "REGEX_ALIPAY_SHARE", "REGEX_BANK_CARD", "REGEX_DY_SHARE", "REGEX_IDENTIFY", "REGEX_PHONE", "REGEX_TB_SHARE", "REGEX_TELEPHONE", "SCENE_ID", "TAG", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "latestShowCopyTime", "ruleList", "", "getRuleList", "", "prepareForShowCopyView", "Lcom/baidu/searchbox/hissug/util/copy/PrepareCopyResult;", "recordReadClipBoardBehavior", "", "showCopyView", "rootView", "Landroid/view/View;", "copyDirectViewGetter", "Lcom/baidu/searchbox/hissug/ui/EmptyBoxHisSugView$CopyDirectViewGetter;", "showCopyViewReal", "verifyForbiddenRule", "", "copyText", "lib_hissug_frame_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HisCopyDirectVisitHelper.kt */
public final class HisCopyDirectVisitHelperKt {
    private static final long INTERVAL = 120000;
    private static final String REGEX_ADDRESS = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县|.*?区)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
    private static final String REGEX_ALIPAY_SHARE = "^0 可以加好友，还可以转账\\w+ http:/$";
    private static final String REGEX_BANK_CARD = "^([1-9]{1})(\\d{11}|\\d{15}|\\d{16}|\\d{17}|\\d{18})$";
    private static final String REGEX_DY_SHARE = "^\\d{1}.\\d{2} [a-zA-Z]{3}:/.*douyin.*";
    private static final String REGEX_IDENTIFY = "^((\\d{18})|([0-9x]{18})|([0-9X]{18}))$";
    private static final String REGEX_PHONE = "^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}$";
    private static final String REGEX_TB_SHARE = "^【淘宝】(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|][\\s\\S]*「.*」[\\n\\s*\\r]*点击链接直接打开$";
    private static final String REGEX_TELEPHONE = "^([1][3,4,5,6,7,8,9])\\d{9}$";
    private static final String SCENE_ID = "stext";
    private static final String TAG = "copyViewHelper";
    private static CountDownLatch countDownLatch;
    private static long latestShowCopyTime;
    private static Set<String> ruleList;

    public static final void showCopyView(View rootView, EmptyBoxHisSugView.CopyDirectViewGetter copyDirectViewGetter) {
        if (Build.VERSION.SDK_INT < 29) {
            showCopyViewReal(copyDirectViewGetter);
        } else if (rootView != null) {
            rootView.post(new HisCopyDirectVisitHelperKt$$ExternalSyntheticLambda3(copyDirectViewGetter));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCopyView$lambda-0  reason: not valid java name */
    public static final void m19964showCopyView$lambda0(EmptyBoxHisSugView.CopyDirectViewGetter $copyDirectViewGetter) {
        showCopyViewReal($copyDirectViewGetter);
    }

    private static final void showCopyViewReal(EmptyBoxHisSugView.CopyDirectViewGetter copyDirectViewGetter) {
        Observable.create(new HisCopyDirectVisitHelperKt$$ExternalSyntheticLambda0()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new HisCopyDirectVisitHelperKt$$ExternalSyntheticLambda1(copyDirectViewGetter), (Action1<Throwable>) new HisCopyDirectVisitHelperKt$$ExternalSyntheticLambda2());
    }

    /* access modifiers changed from: private */
    /* renamed from: showCopyViewReal$lambda-1  reason: not valid java name */
    public static final void m19965showCopyViewReal$lambda1(Subscriber it) {
        it.onNext(prepareForShowCopyView());
        it.onCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: showCopyViewReal$lambda-2  reason: not valid java name */
    public static final void m19966showCopyViewReal$lambda2(EmptyBoxHisSugView.CopyDirectViewGetter $copyDirectViewGetter, PrepareCopyResult it) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "receive result: " + it.isShow() + ' ');
        }
        CountDownLatch countDownLatch2 = countDownLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        if (it.isShow()) {
            HisCopyDirectVisitView copyView = $copyDirectViewGetter != null ? $copyDirectViewGetter.getCopyDirectView() : null;
            if (copyView != null) {
                copyView.setData(it.getText(), it.getMode());
            }
            if (copyView != null) {
                copyView.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCopyViewReal$lambda-3  reason: not valid java name */
    public static final void m19967showCopyViewReal$lambda3(Throwable it) {
        CountDownLatch countDownLatch2 = countDownLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        if (AppConfig.isDebug()) {
            it.printStackTrace();
        }
    }

    private static final PrepareCopyResult prepareForShowCopyView() {
        ClipData.Item itemAt;
        CharSequence text;
        ClipDescription description;
        PrepareCopyResult result = new PrepareCopyResult(false, 0, (String) null, 7, (DefaultConstructorMarker) null);
        if (Build.VERSION.SDK_INT < 26) {
            return result;
        }
        Object systemService = AppRuntime.getAppContext().getSystemService(LaunchDragUBCManager.TYPE_CLIPBOARD);
        String copyText = null;
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            return result;
        }
        recordReadClipBoardBehavior();
        if (!clipboardManager.hasPrimaryClip()) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "prepareForShowCopyView: hasPrimaryClip - false");
            }
            return result;
        }
        ClipData clipData = clipboardManager.getPrimaryClip();
        long copyTime = (clipData == null || (description = clipData.getDescription()) == null) ? 0 : description.getTimestamp();
        if (System.currentTimeMillis() - copyTime > INTERVAL) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "prepareForShowCopyView: excess 2 mins");
            }
            return result;
        } else if (copyTime == latestShowCopyTime) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "prepareForShowCopyView: had show before");
            }
            return result;
        } else {
            if ((clipData != null ? clipData.getItemCount() : 0) <= 0) {
                return result;
            }
            if (!(clipData == null || (itemAt = clipData.getItemAt(0)) == null || (text = itemAt.getText()) == null)) {
                copyText = text.toString();
            }
            if (!verifyForbiddenRule(copyText)) {
                return result;
            }
            if (UrlUtils.isUrl(copyText)) {
                result.setMode(2);
            } else {
                result.setMode(1);
            }
            result.setShow(true);
            result.setText(copyText);
            latestShowCopyTime = copyTime;
            return result;
        }
    }

    private static final boolean verifyForbiddenRule(String copyText) {
        Set ruleList2;
        CharSequence charSequence = copyText;
        if ((charSequence == null || charSequence.length() == 0) || (ruleList2 = getRuleList()) == null) {
            return false;
        }
        for (String rule : ruleList2) {
            CharSequence charSequence2 = rule;
            if (!(charSequence2 == null || charSequence2.length() == 0) && Pattern.compile(rule).matcher(copyText).matches()) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "verifyForbiddenRule: " + rule);
                }
                return false;
            }
        }
        return true;
    }

    private static final Set<String> getRuleList() {
        Set<String> set;
        Collection collection = ruleList;
        if (!(collection == null || collection.isEmpty())) {
            return ruleList;
        }
        ruleList = SetsKt.mutableSetOf(REGEX_TELEPHONE, REGEX_PHONE, REGEX_IDENTIFY, REGEX_ADDRESS, REGEX_BANK_CARD, REGEX_ALIPAY_SHARE, REGEX_DY_SHARE, REGEX_TB_SHARE);
        Set it = HisCopyDirectRegexDataUtilsKt.getHisCopyDirectRegexData();
        if (!(it == null || (set = ruleList) == null)) {
            set.addAll(it);
        }
        return ruleList;
    }

    public static final void recordReadClipBoardBehavior() {
        Object service = ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(IBehaviorApi.SERVICE_REFERENCE)");
        ((IBehaviorApi) service).addBehavior(0, BehaviorId.InfoName.CLIPBOARD_ID, SCENE_ID);
    }
}
