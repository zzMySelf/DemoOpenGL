package com.baidu.swan.apps.impl.guide;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.paywall.UnitedSchemePaywallDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.action.bookshelf.SwanAppBookshelfApi;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppGuide;
import com.baidu.swan.apps.guide.SwanAppGuideDialogChecker;
import com.baidu.swan.apps.guide.SwanAppGuideDialogManager;
import com.baidu.swan.apps.guide.SwanAppGuideDialogTouchStateListener;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.impl.update.SwanAppFollowGuideListener;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.AlertDialogEvent;
import com.baidu.swan.apps.res.widget.dialog.BaseDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppActivityUtils;
import com.baidu.swan.apps.util.SwanAppRomUtils;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.view.decorate.SwanAppDialogDecorate;
import com.baidu.swan.utils.SwanAppFileUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppGuideImpl implements ISwanAppGuide {
    public static final String ARTICLE = "article";
    public static final String ARTICLE_TAB = "1";
    public static final String AV = "av";
    public static final String AV_TAB = "3";
    private static final String BOOKSHELF_DIALOG_PICTURE = "bookshelf_dialog_picture";
    private static final String BOOKSHELF_DIALOG_TEXT = "bookshelf_dialog_text";
    public static final String BOOKSHELF_TAB_DEFAULT = "0";
    public static final String CARTOON = "cartoon";
    public static final String CARTOON_TAB = "4";
    public static final String CONFIG_JSON_SUFFIX = "json";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String DOC = "doc";
    public static final String DOC_TAB = "2";
    private static final int FAIL_AUTHORIZE_FOLLOW_DIALOG_MAX = 3;
    private static final String FAIL_AUTHORIZE_FOLLOW_GUIDE = "fail_authorize_follow_guide";
    private static final int HAS_INSERTED_BOOKSHLF = 1;
    private static final int HAS_NOT_INSERTED_BOOKSHLF = 0;
    private static final float LOOTTIE_VIEW_ROOT_HEIGHT = 312.3f;
    private static final String TAG = "SwanAppGuideImpl";

    public void downloadGuideRes(String appId) {
        SwanGuideResManager.downloadGuideRes(appId);
    }

    public void showGuideDialog(Activity activity, String aiappGuideUrl, String sourceType, SwanAppGuideDialogChecker checker, SwanAppGuideDialogManager.OnGuideDialogCloseListener listener) {
        Activity activity2 = activity;
        final String str = aiappGuideUrl;
        if (activity2 == null || activity.isFinishing()) {
            String str2 = sourceType;
        } else if (!SwanAppNetworkUtils.isNetworkConnected(activity)) {
            String str3 = sourceType;
        } else {
            GuideDialog dialog = new GuideDialog(activity2, R.style.swan_app_favorite_guide_dialog);
            addCommonWindowConfigToDialog(activity2, dialog);
            dialog.setContentView(R.layout.swan_app_entry_guide_layout);
            View rootView = dialog.findViewById(R.id.root);
            dialog.findViewById(R.id.nightmode_mask).setVisibility(SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState() ? 0 : 8);
            if (!TextUtils.isEmpty(aiappGuideUrl)) {
                if (str.startsWith("http")) {
                    rootView.setBackground(activity.getResources().getDrawable(R.drawable.aiapps_entry_guide_bg));
                    SimpleDraweeView gifView = (SimpleDraweeView) dialog.findViewById(R.id.aiapps_guide_image);
                    gifView.setVisibility(0);
                    dialog.findViewById(R.id.aiapps_split_line).setVisibility(0);
                    gifView.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setUri(str).build());
                } else if (!playLottieAnimation(dialog, rootView, SwanGuideResManager.getFilePath(aiappGuideUrl))) {
                    if (listener != null) {
                        listener.onGuideDialogClose();
                        return;
                    }
                    return;
                }
                TextView bottomButton = (TextView) dialog.findViewById(R.id.aiapps_bottom_button);
                bottomButton.setOnTouchListener(new SwanAppGuideDialogTouchStateListener());
                final String str4 = aiappGuideUrl;
                final String str5 = sourceType;
                final GuideDialog guideDialog = dialog;
                final SwanAppGuideDialogManager.OnGuideDialogCloseListener onGuideDialogCloseListener = listener;
                bottomButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        SwanAppGuideDialogManager.getInstance().reportGuideShow(str4, str5, "click");
                        guideDialog.dismiss();
                        SwanAppGuideDialogManager.OnGuideDialogCloseListener onGuideDialogCloseListener = onGuideDialogCloseListener;
                        if (onGuideDialogCloseListener != null) {
                            onGuideDialogCloseListener.onGuideDialogClose();
                        }
                    }
                });
                final String str6 = sourceType;
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialog) {
                        SwanAppGuideDialogManager.getInstance().reportGuideShow(str, str6, "show");
                    }
                });
                dialog.show();
                if (checker != null) {
                    checker.updateLocalConfig();
                }
                SwanAppGuideDialogManager.getInstance().setHasShowGuideInfo(activity2);
                if (DEBUG) {
                    Log.e(TAG, "dialog has shown");
                }
            } else if (listener != null) {
                listener.onGuideDialogClose();
            }
        }
    }

    public boolean checkShowFavGuide(Activity activity) {
        return false;
    }

    public boolean showToppingGuideIfNeeded(Activity activity) {
        return false;
    }

    private void addCommonWindowConfigToDialog(Activity activity, GuideDialog dialog) {
        SwanAppActivityUtils.copyActivityUiVisibilityFlagToDialog(activity, dialog);
        setDialogWindowMatchParent(dialog.getWindow());
        if (SwanAppRomUtils.isSpecialshapedScreen(activity) && dialog.getWindow() != null && Swan.get().getApp().isSwanGame()) {
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = 1;
            dialog.getWindow().setAttributes(lp);
        }
    }

    public void failAuthUnFollow(SwanApp swanApp) {
        failAuthFollowToast(swanApp, R.string.aiapps_failauth_unfollow);
    }

    public void failAuthFollow(SwanApp swanApp) {
        int count = SwanAppSpHelper.getInstance().getInt(FAIL_AUTHORIZE_FOLLOW_GUIDE, 0) + 1;
        SwanAppSpHelper.getInstance().edit().putInt(FAIL_AUTHORIZE_FOLLOW_GUIDE, count).apply();
        if (count <= 3) {
            failAuthFollowDialog(swanApp);
        } else {
            failAuthFollowToast(swanApp, R.string.aiapps_failauth_follow);
        }
    }

    public void failAuthFollowDialog(SwanApp swanApp) {
        final String picture = SwanAppSpHelper.getInstance().getString(SwanAppFollowGuideListener.AUTH_FOLLOW_DIALOG_PICTURE, "");
        if (!TextUtils.isEmpty(picture)) {
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    SwanAppAlertDialog.Builder builder = new SwanAppAlertDialog.Builder(Swan.get().getActivity());
                    View view2 = LayoutInflater.from(Swan.get().getActivity()).inflate(R.layout.aiapps_failauth_follow_dialog, (ViewGroup) null);
                    ((SimpleDraweeView) view2.findViewById(R.id.fail_auth_follow_guide_dialog)).setImageURI(picture);
                    builder.hideTitle(true).setView(view2).removeCustomPanelMargin(true).setDecorate(new SwanAppDialogDecorate()).setBtnsVisible(false).setDividerVisible(false).setPositiveEnable(false);
                    builder.setButtonListener(view2.findViewById(R.id.aiapps_negative_button), -2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.setDialogLayoutBackgroundResource(R.drawable.aiapps_dialog_bg_transparent);
                    builder.show();
                }
            });
        }
    }

    public void failAuthFollowToast(SwanApp swanApp, int id) {
        UniversalToast.makeText(swanApp.getApplicationContext(), id).setDuration(2).setMaxLines(2).showToast();
    }

    private void setDialogWindowMatchParent(Window dialogWindow) {
        if (dialogWindow != null && dialogWindow.getAttributes() != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = -1;
            lp.height = -1;
            dialogWindow.setAttributes(lp);
        }
    }

    public String getFavorSuccessTip(Context context) {
        return context.getString(com.baidu.swan.apps.R.string.aiapps_fav_success);
    }

    public void addToBookshelfSuccessGuide(final Context context) {
        String bookshelfKey = "bookshelf_insert" + Swan.get().getAppId();
        if (SwanAppSpHelper.getInstance().getInt(bookshelfKey, 0) == 0) {
            guideUserGotoBookshelfDialog(context);
            SwanAppSpHelper.getInstance().putInt(bookshelfKey, 1);
            return;
        }
        final String content = context.getString(R.string.swan_bookshelf_insert_success);
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                UniversalToast.makeText(context, (CharSequence) content).setMaxLines(1).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() {
                    public void onToastClick() {
                        SwanAppGuideImpl.this.launchBookShelf((CallbackHandler) null);
                    }
                }).showClickableToast();
            }
        });
    }

    private void guideUserGotoBookshelfDialog(Context context) {
        String picture = SwanAppSpHelper.getInstance().getString(BOOKSHELF_DIALOG_PICTURE, "");
        String text = SwanAppSpHelper.getInstance().getString(BOOKSHELF_DIALOG_TEXT, "");
        String cancel = context.getString(R.string.swan_app_guide_cancel);
        if (!TextUtils.isEmpty(picture) && !TextUtils.isEmpty(text)) {
            final Context context2 = context;
            final String str = picture;
            final String str2 = text;
            final String str3 = cancel;
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    SwanAppAlertDialog.Builder builder = new SwanAppAlertDialog.Builder(context2);
                    View view2 = LayoutInflater.from(Swan.get().getActivity()).inflate(R.layout.aiapps_bookshelf_insert_dialog, (ViewGroup) null);
                    ((SimpleDraweeView) view2.findViewById(R.id.bookshelf_insert_dialog)).setImageURI(str);
                    builder.hideTitle(true).setView(view2).removeCustomPanelMargin(true).setPositiveTextColor(com.baidu.swan.apps.R.color.aiapps_modal_confirm_color).setDecorate(new SwanAppDialogDecorate()).setPositiveButton((CharSequence) str2, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            SwanAppGuideImpl.this.launchBookShelf((CallbackHandler) null);
                        }
                    }).setNegativeButton((CharSequence) str3, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            });
        }
    }

    public void launchBookShelf(CallbackHandler callbackHandler) {
        SchemeRouter.invokeScheme(Swan.get().getActivity(), buildBookSelfLaunchUri().build(), "inside", callbackHandler);
    }

    private static Uri.Builder buildBookSelfLaunchUri() {
        JSONObject paramsObj = new JSONObject();
        JSONObject sourceObj = new JSONObject();
        try {
            sourceObj.put("source", "swan");
            paramsObj.put("ubc", sourceObj);
            String categoryTab = getBookShelfTab(SwanAppBookshelfApi.category);
            if (!TextUtils.equals(categoryTab, "0")) {
                paramsObj.put("tab", categoryTab);
            }
        } catch (JSONException e2) {
        }
        return new Uri.Builder().scheme(SwanAppRuntime.getConfig().getSchemeHeader()).authority("paywall").appendPath(UnitedSchemePaywallDispatcher.ACTION_OPEN_PAYWALL).appendQueryParameter("params", paramsObj.toString()).appendQueryParameter("callback", "__jsna_3");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getBookShelfTab(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -732377866: goto L_0x0026;
                case 3125: goto L_0x001c;
                case 99640: goto L_0x0012;
                case 554426222: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0030
        L_0x0008:
            java.lang.String r0 = "cartoon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 3
            goto L_0x0031
        L_0x0012:
            java.lang.String r0 = "doc"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0031
        L_0x001c:
            java.lang.String r0 = "av"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x0031
        L_0x0026:
            java.lang.String r0 = "article"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            switch(r0) {
                case 0: goto L_0x0040;
                case 1: goto L_0x003d;
                case 2: goto L_0x003a;
                case 3: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            java.lang.String r0 = "0"
            return r0
        L_0x0037:
            java.lang.String r0 = "4"
            return r0
        L_0x003a:
            java.lang.String r0 = "3"
            return r0
        L_0x003d:
            java.lang.String r0 = "2"
            return r0
        L_0x0040:
            java.lang.String r0 = "1"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.guide.SwanAppGuideImpl.getBookShelfTab(java.lang.String):java.lang.String");
    }

    private boolean playLottieAnimation(BaseDialog dialog, View rootView, String filePath) {
        File jsonFile;
        if (TextUtils.isEmpty(filePath) || (jsonFile = SwanAppFileUtils.getFileBySuffix(filePath, "json")) == null) {
            return false;
        }
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) dialog.findViewById(R.id.aiapps_guide_anim_view);
        lottieAnimationView.setVisibility(0);
        ViewGroup.LayoutParams params = rootView.getLayoutParams();
        params.height = SwanAppUIUtils.dip2px(dialog.getContext(), LOOTTIE_VIEW_ROOT_HEIGHT);
        rootView.setLayoutParams(params);
        try {
            final FileInputStream fis = new FileInputStream(jsonFile);
            lottieAnimationView.setImageAssetDelegate(getImageAssetDelegate(filePath));
            LottieCompositionFactory.fromJsonInputStream(fis, filePath).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition result) {
                    lottieAnimationView.setComposition(result);
                    lottieAnimationView.setRepeatCount(0);
                    lottieAnimationView.playAnimation();
                    SwanAppFileUtils.closeSafely(fis);
                }
            });
            return true;
        } catch (FileNotFoundException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    private ImageAssetDelegate getImageAssetDelegate(final String filePath) {
        return new ImageAssetDelegate() {
            public Bitmap fetchBitmap(LottieImageAsset asset) {
                if (asset == null) {
                    return null;
                }
                String fileName = asset.getFileName();
                if (TextUtils.isEmpty(fileName)) {
                    return null;
                }
                String dirName = asset.getDirName();
                return BitmapFactory.decodeFile(new File(TextUtils.isEmpty(dirName) ? new File(filePath) : new File(filePath, dirName), fileName).getAbsolutePath());
            }
        };
    }

    private static class GuideDialog extends BaseDialog {
        public GuideDialog(Context context, int themeResId) {
            super(context, themeResId);
        }

        public void show() {
            super.show();
            BdEventBus.Companion.getDefault().post(new AlertDialogEvent("show"));
        }

        public void dismiss() {
            super.dismiss();
            BdEventBus.Companion.getDefault().post(new AlertDialogEvent("hide"));
        }
    }
}
