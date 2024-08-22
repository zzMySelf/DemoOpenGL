package com.baidu.searchbox.paywall.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.kmm.paywall.recommend.PaywallPopModel;
import com.baidu.searchbox.kmm.paywall.recommend.PaywallRecommendKt;
import com.baidu.searchbox.paywall.PaywallConstants;
import com.baidu.searchbox.paywall.PaywallSharedPrefsWrapper;
import com.baidu.searchbox.paywall.PaywallTabActivity;
import com.baidu.searchbox.paywall.dialog.PaywallRecommendDialog;
import com.baidu.searchbox.paywall.dialog.PaywallUpdateNotifyDialog;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u001c\u0010'\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/paywall/manager/RecommendDialogManager;", "", "()V", "DEBUG", "", "HAS_SHOW_RECOMMEND_DIALOG", "", "KET_HAS_SHOW_RECOMMEND_DIALOG", "KET_SCHEME_PARAM", "TAG", "dialog", "Lcom/baidu/searchbox/paywall/dialog/PaywallRecommendDialog;", "isNovelTab", "()Z", "setNovelTab", "(Z)V", "mPaywallUpdateNotifyDialog", "Lcom/baidu/searchbox/paywall/dialog/PaywallUpdateNotifyDialog;", "notifyDialogDayImage", "Landroid/graphics/drawable/Drawable;", "getNotifyDialogDayImage", "()Landroid/graphics/drawable/Drawable;", "setNotifyDialogDayImage", "(Landroid/graphics/drawable/Drawable;)V", "notifyDialogNightImage", "getNotifyDialogNightImage", "setNotifyDialogNightImage", "canShowDialog", "popModel", "Lcom/baidu/searchbox/kmm/paywall/recommend/PaywallPopModel;", "downloadImageUrl", "url", "handleNovelScheme", "originScheme", "releaseDialog", "", "showNotifyDialog", "context", "Landroid/content/Context;", "showRecommendDialog", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendDialogManager.kt */
public final class RecommendDialogManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String HAS_SHOW_RECOMMEND_DIALOG = "1";
    public static final RecommendDialogManager INSTANCE = new RecommendDialogManager();
    private static final String KET_HAS_SHOW_RECOMMEND_DIALOG = "noActivityAlert";
    private static final String KET_SCHEME_PARAM = "param";
    private static final String TAG = "RecommendDialogManager";
    private static PaywallRecommendDialog dialog;
    private static boolean isNovelTab = true;
    private static PaywallUpdateNotifyDialog mPaywallUpdateNotifyDialog;
    private static Drawable notifyDialogDayImage;
    private static Drawable notifyDialogNightImage;

    private RecommendDialogManager() {
    }

    public final boolean isNovelTab() {
        return isNovelTab;
    }

    public final void setNovelTab(boolean z) {
        isNovelTab = z;
    }

    public final Drawable getNotifyDialogDayImage() {
        return notifyDialogDayImage;
    }

    public final void setNotifyDialogDayImage(Drawable drawable) {
        notifyDialogDayImage = drawable;
    }

    public final Drawable getNotifyDialogNightImage() {
        return notifyDialogNightImage;
    }

    public final void setNotifyDialogNightImage(Drawable drawable) {
        notifyDialogNightImage = drawable;
    }

    public final void showRecommendDialog(WeakReference<Activity> weakActivity, PaywallPopModel popModel) {
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        Intrinsics.checkNotNullParameter(popModel, "popModel");
        if (canShowDialog(popModel)) {
            dialog = new PaywallRecommendDialog();
            ExecutorUtilsExt.postOnElastic(new RecommendDialogManager$$ExternalSyntheticLambda2(popModel, weakActivity), "downloadRecommendResource", 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showRecommendDialog$lambda-1  reason: not valid java name */
    public static final void m1923showRecommendDialog$lambda1(PaywallPopModel $popModel, WeakReference $weakActivity) {
        Intrinsics.checkNotNullParameter($popModel, "$popModel");
        Intrinsics.checkNotNullParameter($weakActivity, "$weakActivity");
        PaywallRecommendDialog paywallRecommendDialog = dialog;
        if (paywallRecommendDialog != null) {
            paywallRecommendDialog.setDayImage(INSTANCE.downloadImageUrl($popModel.getLightImageURL()));
        }
        PaywallRecommendDialog paywallRecommendDialog2 = dialog;
        if (paywallRecommendDialog2 != null) {
            paywallRecommendDialog2.setNightImage(INSTANCE.downloadImageUrl($popModel.getNightImageURL()));
        }
        PaywallRecommendDialog paywallRecommendDialog3 = dialog;
        Drawable drawable = null;
        if ((paywallRecommendDialog3 != null ? paywallRecommendDialog3.getDayImage() : null) != null) {
            PaywallRecommendDialog paywallRecommendDialog4 = dialog;
            if (paywallRecommendDialog4 != null) {
                drawable = paywallRecommendDialog4.getNightImage();
            }
            if (drawable != null) {
                UiThreadUtils.runOnUiThread(new RecommendDialogManager$$ExternalSyntheticLambda1($weakActivity, $popModel));
                return;
            }
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "无弹窗图片");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showRecommendDialog$lambda-1$lambda-0  reason: not valid java name */
    public static final void m1924showRecommendDialog$lambda1$lambda0(WeakReference $weakActivity, PaywallPopModel $popModel) {
        Intrinsics.checkNotNullParameter($weakActivity, "$weakActivity");
        Intrinsics.checkNotNullParameter($popModel, "$popModel");
        if (AppConfig.isDebug()) {
            Log.d(TAG, "切主线程展示弹窗");
        }
        PaywallRecommendDialog paywallRecommendDialog = dialog;
        if (paywallRecommendDialog != null) {
            paywallRecommendDialog.show($weakActivity, $popModel);
        }
    }

    public final void showNotifyDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (activity != null && (activity instanceof PaywallTabActivity) && !((PaywallTabActivity) activity).isFinishing() && !((PaywallTabActivity) activity).isDestroyed() && ((PaywallTabActivity) activity).getWindow() != null) {
            if (mPaywallUpdateNotifyDialog == null) {
                mPaywallUpdateNotifyDialog = new PaywallUpdateNotifyDialog(activity);
            }
            PaywallUpdateNotifyDialog paywallUpdateNotifyDialog = mPaywallUpdateNotifyDialog;
            if (paywallUpdateNotifyDialog != null) {
                paywallUpdateNotifyDialog.setMNotifyBgDayImage(notifyDialogDayImage);
            }
            PaywallUpdateNotifyDialog paywallUpdateNotifyDialog2 = mPaywallUpdateNotifyDialog;
            if (paywallUpdateNotifyDialog2 != null) {
                paywallUpdateNotifyDialog2.setMNotifyBgNightImage(notifyDialogNightImage);
            }
            PaywallUpdateNotifyDialog paywallUpdateNotifyDialog3 = mPaywallUpdateNotifyDialog;
            if (paywallUpdateNotifyDialog3 != null) {
                paywallUpdateNotifyDialog3.show();
            }
        }
        ExecutorUtilsExt.postOnElastic(new RecommendDialogManager$$ExternalSyntheticLambda0(), "showNotifyDialog", 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotifyDialog$lambda-3  reason: not valid java name */
    public static final void m1921showNotifyDialog$lambda3() {
        String dialogBgDayUrl = PaywallSharedPrefsWrapper.Companion.getINSTANCE().getString(PaywallConstants.SP_KEY_SHELF_UPDATE_NOTIFY_DIALOG_DAY_BG, PaywallConstants.DEFAULT_SHELF_UPDATE_NOTIFY_DIALOG_DAY_BG);
        String dialogBgNightUrl = PaywallSharedPrefsWrapper.Companion.getINSTANCE().getString(PaywallConstants.SP_KEY_SHELF_UPDATE_NOTIFY_DIALOG_NIGHT_BG, PaywallConstants.DEFAULT_SHELF_UPDATE_NOTIFY_DIALOG_NIGHT_BG);
        RecommendDialogManager recommendDialogManager = INSTANCE;
        Drawable drawable = notifyDialogDayImage;
        if (drawable == null || notifyDialogNightImage == null) {
            if (drawable == null) {
                notifyDialogDayImage = recommendDialogManager.downloadImageUrl(dialogBgDayUrl);
            }
            if (notifyDialogNightImage == null) {
                notifyDialogNightImage = recommendDialogManager.downloadImageUrl(dialogBgNightUrl);
            }
            UiThreadUtils.runOnUiThread(new RecommendDialogManager$$ExternalSyntheticLambda3());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotifyDialog$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1922showNotifyDialog$lambda3$lambda2() {
        PaywallUpdateNotifyDialog paywallUpdateNotifyDialog = mPaywallUpdateNotifyDialog;
        if (paywallUpdateNotifyDialog != null) {
            paywallUpdateNotifyDialog.setMNotifyBgDayImage(notifyDialogDayImage);
        }
        PaywallUpdateNotifyDialog paywallUpdateNotifyDialog2 = mPaywallUpdateNotifyDialog;
        if (paywallUpdateNotifyDialog2 != null) {
            paywallUpdateNotifyDialog2.setMNotifyBgNightImage(notifyDialogNightImage);
        }
        PaywallUpdateNotifyDialog paywallUpdateNotifyDialog3 = mPaywallUpdateNotifyDialog;
        if (paywallUpdateNotifyDialog3 != null) {
            paywallUpdateNotifyDialog3.showNotifyImageBackground();
        }
    }

    public final void releaseDialog() {
        PaywallRecommendDialog paywallRecommendDialog = dialog;
        if (paywallRecommendDialog != null) {
            paywallRecommendDialog.dismissDialog();
        }
        mPaywallUpdateNotifyDialog = null;
    }

    public final String handleNovelScheme(String originScheme) {
        Set oldParamKeys;
        JSONObject extraJson;
        CharSequence charSequence = originScheme;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return originScheme;
        }
        try {
            Uri originUri = Uri.parse(originScheme);
            if (originUri == null || (oldParamKeys = originUri.getQueryParameterNames()) == null) {
                return originScheme;
            }
            Uri.Builder buildUpon = originUri.buildUpon();
            Uri.Builder newUriBuilder = buildUpon != null ? buildUpon.clearQuery() : null;
            if (newUriBuilder == null) {
                return originScheme;
            }
            for (String paramKey : oldParamKeys) {
                if (!Intrinsics.areEqual((Object) paramKey, (Object) "param")) {
                    if (paramKey != null) {
                        String str = paramKey;
                        newUriBuilder.appendQueryParameter(paramKey, originUri.getQueryParameter(paramKey));
                    }
                }
            }
            String originParam = originUri.getQueryParameter("param");
            if (originParam != null) {
                if (originParam.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                extraJson = new JSONObject(originParam);
            } else {
                extraJson = new JSONObject();
            }
            if (extraJson.has(KET_HAS_SHOW_RECOMMEND_DIALOG)) {
                extraJson.remove(KET_HAS_SHOW_RECOMMEND_DIALOG);
            }
            if (PaywallRecommendKt.isNovelRecommendDialogShowInInterval()) {
                extraJson.put(KET_HAS_SHOW_RECOMMEND_DIALOG, "1");
            }
            newUriBuilder.appendQueryParameter("param", extraJson.toString());
            return newUriBuilder.build().toString();
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return originScheme;
        }
    }

    private final boolean canShowDialog(PaywallPopModel popModel) {
        String failReason;
        PaywallRecommendDialog paywallRecommendDialog = dialog;
        if (paywallRecommendDialog != null && paywallRecommendDialog.isShowing()) {
            failReason = "it is displaying";
        } else {
            CharSequence url = popModel.getUrl();
            if (!(url == null || url.length() == 0)) {
                CharSequence lightImageURL = popModel.getLightImageURL();
                if (!(lightImageURL == null || lightImageURL.length() == 0)) {
                    CharSequence nightImageURL = popModel.getNightImageURL();
                    if (!(nightImageURL == null || nightImageURL.length() == 0)) {
                        if (!isNovelTab) {
                            failReason = "current tab is not novel";
                        } else {
                            failReason = null;
                            String str = null;
                        }
                    }
                }
            }
            failReason = "pop model is invalid";
        }
        CharSequence charSequence = failReason;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "Cannot show recommend dialog since " + failReason);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ab, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d7, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d9, code lost:
        r3.printStackTrace();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable downloadImageUrl(java.lang.String r11) {
        /*
            r10 = this;
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            boolean r0 = com.baidu.searchbox.http.ConnectManager.isNetworkConnected(r0)
            if (r0 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            r2 = 0
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x00b0 }
            com.baidu.searchbox.http.HttpManager r3 = com.baidu.searchbox.http.HttpManager.getDefault(r3)     // Catch:{ Exception -> 0x00b0 }
            if (r3 == 0) goto L_0x003e
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r3 = r3.getRequest()     // Catch:{ Exception -> 0x00b0 }
            if (r3 == 0) goto L_0x003e
            com.baidu.searchbox.http.request.HttpRequestBuilder r3 = r3.url(r11)     // Catch:{ Exception -> 0x00b0 }
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r3 = (com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder) r3     // Catch:{ Exception -> 0x00b0 }
            if (r3 == 0) goto L_0x003e
            com.baidu.searchbox.http.request.GetRequest r3 = r3.build()     // Catch:{ Exception -> 0x00b0 }
            if (r3 == 0) goto L_0x003e
            okhttp3.Response r3 = r3.executeSync()     // Catch:{ Exception -> 0x00b0 }
            goto L_0x003f
        L_0x003e:
            r3 = r1
        L_0x003f:
            r2 = r3
            if (r2 == 0) goto L_0x0093
            r3 = r2
            r4 = 0
            int r5 = r2.code()     // Catch:{ Exception -> 0x00b0 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x0092
            okhttp3.ResponseBody r5 = r2.body()     // Catch:{ Exception -> 0x00b0 }
            if (r5 == 0) goto L_0x0092
            r6 = 0
            java.io.InputStream r7 = r5.byteStream()     // Catch:{ Exception -> 0x00b0 }
            r0 = r7
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x00b0 }
            if (r7 != 0) goto L_0x0070
            if (r2 == 0) goto L_0x006a
            okhttp3.ResponseBody r3 = r2.body()
            if (r3 == 0) goto L_0x006a
            r3.close()
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()
        L_0x006f:
            return r1
        L_0x0070:
            java.lang.String r8 = "BitmapFactory.decodeStre…putStream) ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ Exception -> 0x00b0 }
            android.graphics.drawable.BitmapDrawable r8 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x00b0 }
            android.content.res.Resources r9 = android.content.res.Resources.getSystem()     // Catch:{ Exception -> 0x00b0 }
            r8.<init>(r9, r7)     // Catch:{ Exception -> 0x00b0 }
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Exception -> 0x00b0 }
            if (r2 == 0) goto L_0x008c
            okhttp3.ResponseBody r1 = r2.body()
            if (r1 == 0) goto L_0x008c
            r1.close()
        L_0x008c:
            if (r0 == 0) goto L_0x0091
            r0.close()
        L_0x0091:
            return r8
        L_0x0092:
        L_0x0093:
            if (r2 == 0) goto L_0x00a3
            okhttp3.ResponseBody r3 = r2.body()     // Catch:{ Exception -> 0x00a1 }
            if (r3 == 0) goto L_0x00a3
            r3.close()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r3 = move-exception
            goto L_0x00a7
        L_0x00a3:
            r3 = r0
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00dc
        L_0x00a7:
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x00dc
            goto L_0x00d9
        L_0x00ae:
            r1 = move-exception
            goto L_0x00de
        L_0x00b0:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x00ba
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
        L_0x00ba:
            r3 = r2
            okhttp3.Response r3 = (okhttp3.Response) r3     // Catch:{ Exception -> 0x00d2 }
            if (r3 == 0) goto L_0x00c9
            okhttp3.ResponseBody r3 = r3.body()     // Catch:{ Exception -> 0x00d2 }
            if (r3 == 0) goto L_0x00c9
            r3.close()     // Catch:{ Exception -> 0x00d2 }
        L_0x00c9:
            r3 = r0
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ Exception -> 0x00d2 }
            if (r3 == 0) goto L_0x00dc
            r3.close()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00dc
        L_0x00d2:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x00dc
        L_0x00d9:
            r3.printStackTrace()
        L_0x00dc:
            return r1
        L_0x00de:
            r3 = r2
            okhttp3.Response r3 = (okhttp3.Response) r3     // Catch:{ Exception -> 0x00f6 }
            if (r3 == 0) goto L_0x00ed
            okhttp3.ResponseBody r3 = r3.body()     // Catch:{ Exception -> 0x00f6 }
            if (r3 == 0) goto L_0x00ed
            r3.close()     // Catch:{ Exception -> 0x00f6 }
        L_0x00ed:
            r3 = r0
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ Exception -> 0x00f6 }
            if (r3 == 0) goto L_0x0100
            r3.close()     // Catch:{ Exception -> 0x00f6 }
            goto L_0x0100
        L_0x00f6:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x0100
            r3.printStackTrace()
        L_0x0100:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.paywall.manager.RecommendDialogManager.downloadImageUrl(java.lang.String):android.graphics.drawable.Drawable");
    }
}
