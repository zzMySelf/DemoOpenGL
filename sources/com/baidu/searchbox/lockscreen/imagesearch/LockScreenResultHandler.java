package com.baidu.searchbox.lockscreen.imagesearch;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.idl.barcode.BarcodeResult;
import com.baidu.searchbox.lockscreen.LockScreenDismissActivity;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.imagesearch.UnlockActivityDialog;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.voicesearch.LockScreenVoiceSearchDetailActivity;
import com.baidu.searchbox.services.scancode.CodeResult;
import com.baidu.searchbox.services.scancode.result.ParsedResult;
import com.baidu.searchbox.services.scancode.result.ParsedResultType;
import com.baidu.searchbox.services.scancode.result.URIParsedResult;
import org.json.JSONException;
import org.json.JSONObject;

public class LockScreenResultHandler {
    private static final boolean DEBUG = LockScreenUtil.GLOBAL_DEBUG;
    public static final String HANDLE_FROM = "lockscreen";
    private static final String PARAM_URL = "url";
    private static final String TAG = LockScreenResultHandler.class.getSimpleName();

    private interface UnlockDialogListener {
        void onNegativeButtonClick();

        void onPositiveButtonClick();
    }

    public static boolean invokeCommand(Context activity, String command) {
        if (activity == null || TextUtils.isEmpty(command)) {
            return false;
        }
        try {
            String url = new JSONObject(command).optString("url");
            if (UrlUtil.isUrl(url)) {
                return LockScreenVoiceSearchDetailActivity.startActivityWithUrl(activity, url);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static void handleBarcodeResult(final Context context, final BarcodeResult barcodeResult) {
        ParsedResult parsedResult;
        if (context != null && barcodeResult != null && (parsedResult = new CodeResult(barcodeResult).getParsedResult()) != null) {
            switch (AnonymousClass5.$SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[parsedResult.getType().ordinal()]) {
                case 1:
                    if (handleSpecialScheme(context, ((URIParsedResult) parsedResult).getURI())) {
                        return;
                    }
                    break;
            }
            showUnlockSuggestDialog(context, new UnlockDialogListener() {
                public void onPositiveButtonClick() {
                    LockScreenUtil.dismissLockScreenView(context, new LockScreenDismissActivity.DissmissCallBack() {
                        public void callBack() {
                            LockScreenRuntime.getLockScreenContext().handleBarcodeResult(context, barcodeResult);
                        }
                    });
                }

                public void onNegativeButtonClick() {
                }
            });
        }
    }

    /* renamed from: com.baidu.searchbox.lockscreen.imagesearch.LockScreenResultHandler$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType;

        static {
            int[] iArr = new int[ParsedResultType.values().length];
            $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType = iArr;
            try {
                iArr[ParsedResultType.URI.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static boolean handleSpecialScheme(final Context context, final String uri) {
        if (context == null || TextUtils.isEmpty(uri)) {
            return false;
        }
        boolean isHandled = false;
        if (UrlUtil.isUrl(uri)) {
            isHandled = LockScreenVoiceSearchDetailActivity.startActivityWithUrl(context, uri);
        }
        if (isHandled) {
            return true;
        }
        showUnlockSuggestDialog(context, new UnlockDialogListener() {
            public void onPositiveButtonClick() {
                LockScreenUtil.dismissLockScreenView(context, new LockScreenDismissActivity.DissmissCallBack() {
                    public void callBack() {
                        LockScreenRuntime.getLockScreenContext().handleSpecialScheme(context, uri);
                    }
                });
            }

            public void onNegativeButtonClick() {
            }
        });
        return true;
    }

    private static void showUnlockSuggestDialog(Context context, final UnlockDialogListener listener) {
        new UnlockActivityDialog.Builder().setPositiveButton(R.string.lockscreen_unlock_positive, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                UnlockDialogListener unlockDialogListener = UnlockDialogListener.this;
                if (unlockDialogListener != null) {
                    unlockDialogListener.onPositiveButtonClick();
                }
            }
        }).setNegativeButton(R.string.lockscreen_unlock_negative, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                UnlockDialogListener unlockDialogListener = UnlockDialogListener.this;
                if (unlockDialogListener != null) {
                    unlockDialogListener.onNegativeButtonClick();
                }
            }
        }).show();
    }
}
