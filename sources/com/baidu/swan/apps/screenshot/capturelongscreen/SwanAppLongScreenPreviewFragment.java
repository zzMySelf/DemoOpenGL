package com.baidu.swan.apps.screenshot.capturelongscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.baidu.searchbox.rtc.RtcConstant;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.api.module.interaction.ToastApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.embed.page.PageContainerType;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.ioc.interfaces.ISwanAppSocialShare;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.screenshot.capturelongscreen.SwanAppShareItem;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class SwanAppLongScreenPreviewFragment extends SwanAppBaseFragment implements View.OnClickListener {
    private static final String IO_NAME_DECODE_BITMAP = "decodeLongImgBitmap";
    private static final String IO_NAME_SAVE_BITMAP = "saveLongScreenBitmap";
    private static final int MAX_SHOWING_TIME = 2;
    private static final String MSG_SAVING_IMG = "图片保存中";
    public static final String SHARE_TYPE_LONG_IMG = "longImage";
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public String mImagePath = null;
    private ImageView mImageView;
    /* access modifiers changed from: private */
    public Bitmap mLongScreenImg = null;
    private JSONArray mPannelsArray = new JSONArray();
    /* access modifiers changed from: private */
    public ISwanAppSocialShare.OnShareListener mScreenShareCallback;

    private SwanAppLongScreenPreviewFragment(PageContainerType containerType) {
        super(containerType);
    }

    public static SwanAppLongScreenPreviewFragment newInstance(PageContainerType containerType) {
        return new SwanAppLongScreenPreviewFragment(containerType);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.swan_app_preview_image, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        rootView.findViewById(R.id.share_mask).setOnClickListener(this);
        ((Button) rootView.findViewById(R.id.close_preview)).setOnClickListener(this);
        SwanAppShareLayout mShareItemsLayout = (SwanAppShareLayout) rootView.findViewById(R.id.image_share_bar);
        mShareItemsLayout.init(this.mPannelsArray);
        mShareItemsLayout.setShareItemClickListener(new OnSwanAppShareItemClickListener() {
            public boolean onClick(SwanAppShareItem item) {
                return SwanAppLongScreenPreviewFragment.this.handleItemClick(item);
            }
        });
        ((ScrollView) rootView.findViewById(R.id.image_scroll_view)).setVerticalScrollBarEnabled(false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.preview_image);
        this.mImageView = imageView;
        Bitmap bitmap = this.mLongScreenImg;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void setPreviewImage(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null && (imageView = this.mImageView) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void startFragment(ISwanAppSocialShare.OnShareListener shareCallback, String imageUrl, JSONArray pannels) {
        this.mImagePath = imageUrl;
        this.mContext = SwanAppRuntime.getAppContext();
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager != null && !TextUtils.isEmpty(this.mImagePath)) {
            this.mScreenShareCallback = shareCallback;
            this.mPannelsArray = pannels;
            manager.createTransaction("navigateTo").setCustomAnimations(ISwanPageManager.ANIM_ENTER, ISwanPageManager.ANIM_HOLD).pushFragment(this).commitNow();
            SwanAppExecutorUtils.postOnIO(new Runnable() {
                public void run() {
                    final Bitmap bitmap = BitmapFactory.decodeFile(SwanAppLongScreenPreviewFragment.this.mImagePath);
                    SwanAppUtils.postOnUi(new Runnable() {
                        public void run() {
                            if (bitmap == null) {
                                SwanAppLongScreenPreviewFragment.this.mScreenShareCallback.onShareFailed();
                                SwanAppLongScreenPreviewFragment.this.exitFragment();
                                return;
                            }
                            Bitmap unused = SwanAppLongScreenPreviewFragment.this.mLongScreenImg = bitmap;
                            SwanAppLongScreenPreviewFragment.this.setPreviewImage(bitmap);
                        }
                    });
                }
            }, IO_NAME_DECODE_BITMAP);
        }
    }

    /* access modifiers changed from: private */
    public boolean handleItemClick(SwanAppShareItem item) {
        if (item == null) {
            return false;
        }
        switch (AnonymousClass7.$SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.getEnumById(item.getId()).ordinal()]) {
            case 1:
                SwanAppUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        UniversalToast.makeText(SwanAppLongScreenPreviewFragment.this.mContext, (CharSequence) ToastApi.getSubStringCN(SwanAppLongScreenPreviewFragment.MSG_SAVING_IMG, 14)).setDuration(2).setShowMask(true).showHighLoadingToast();
                    }
                });
                SwanAppExecutorUtils.postOnIO(new Runnable() {
                    public void run() {
                        SwanAppLongScreenShotUtils.saveImageToAlbum(new File(SwanAppLongScreenPreviewFragment.this.mImagePath), new TypedCallback<SwanApiResult>() {
                            public void onCallback(SwanApiResult result) {
                                if (result.status == 0) {
                                    SwanAppLongScreenPreviewFragment.this.mScreenShareCallback.onShareSuccess();
                                } else {
                                    SwanAppLongScreenPreviewFragment.this.mScreenShareCallback.onShareFailed();
                                }
                                SwanAppLongScreenPreviewFragment.this.exitFragment();
                            }
                        });
                    }
                }, IO_NAME_SAVE_BITMAP);
                return true;
            case 2:
                shareLongScreenImage(SwanAppShareItem.ShareItem.WXTIMELINE.getName());
                return true;
            case 3:
                shareLongScreenImage(SwanAppShareItem.ShareItem.WXFRIEND.getName());
                return true;
            case 4:
                shareLongScreenImage(SwanAppShareItem.ShareItem.QQFRIEND.getName());
                return true;
            case 5:
                shareLongScreenImage(SwanAppShareItem.ShareItem.QZONE.getName());
                return true;
            case 6:
                shareLongScreenImage(SwanAppShareItem.ShareItem.BAIDUHI.getName());
                return true;
            case 7:
                shareLongScreenImage(SwanAppShareItem.ShareItem.SINAWEIBO.getName());
                return true;
            default:
                this.mScreenShareCallback.onShareFailed();
                return true;
        }
    }

    /* renamed from: com.baidu.swan.apps.screenshot.capturelongscreen.SwanAppLongScreenPreviewFragment$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem;

        static {
            int[] iArr = new int[SwanAppShareItem.ShareItem.values().length];
            $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem = iArr;
            try {
                iArr[SwanAppShareItem.ShareItem.SAVEIMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.WXTIMELINE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.WXFRIEND.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.QQFRIEND.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.QZONE.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.BAIDUHI.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$screenshot$capturelongscreen$SwanAppShareItem$ShareItem[SwanAppShareItem.ShareItem.SINAWEIBO.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private void shareLongScreenImage(String mediaType) {
        JSONObject shareParams = new JSONObject();
        SwanAppJSONUtils.setValue(shareParams, "type", "image");
        SwanAppJSONUtils.setValue(shareParams, "imageUrl", Uri.fromFile(new File(this.mImagePath)));
        SwanAppJSONUtils.setValue(shareParams, RtcConstant.RTC_KEY_CALL_MEDIA_TYPE, mediaType);
        SwanAppRuntime.getSocialShareRuntime().share(this.mActivity, shareParams, new ISwanAppSocialShare.OnShareListener() {
            public void onShareSuccess() {
                SwanAppLongScreenPreviewFragment.this.mScreenShareCallback.onShareSuccess();
            }

            public void onShareFailed() {
                SwanAppLongScreenPreviewFragment.this.mScreenShareCallback.onShareFailed();
            }
        });
        exitFragment();
    }

    /* access modifiers changed from: private */
    public void exitFragment() {
        SwanAppUtils.postOnUi(new Runnable() {
            public void run() {
                ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
                if (manager != null) {
                    manager.createTransaction().popFragment().commit();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActionBarSettingPressed() {
    }

    /* access modifiers changed from: protected */
    public boolean isShowFloatButton() {
        return false;
    }

    public boolean isTabFragment() {
        return false;
    }

    public boolean handleBackPressed() {
        this.mScreenShareCallback.onShareFailed();
        return false;
    }

    /* access modifiers changed from: protected */
    public void initToolMenu() {
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.share_mask || id == R.id.close_preview) {
            exitFragment();
            this.mScreenShareCallback.onShareFailed();
        }
    }
}
