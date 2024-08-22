package com.baidu.searchbox.discovery.picture.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.ext.widget.menu.BdContextMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.lib_atlas_base.R;
import com.baidu.searchbox.discovery.picture.IActionProxy;
import com.baidu.searchbox.discovery.picture.LongPressUBC;
import com.baidu.searchbox.discovery.picture.PermissionDialogController;
import com.baidu.searchbox.discovery.picture.PictureStatisticConstants;
import com.baidu.searchbox.discovery.picture.ioc.IBarCode;
import com.baidu.searchbox.discovery.picture.ioc.IPictureYun;
import com.baidu.searchbox.discovery.picture.runtime.PictureRuntime;
import com.baidu.searchbox.discovery.picture.utils.Utils;
import com.baidu.searchbox.imagesearch.params.ImageSearchCallback;
import com.baidu.searchbox.imagesearch.params.ImageSearchParams;
import com.baidu.searchbox.imagesearch.pyramid.ImageSearchInterface;
import com.baidu.searchbox.picture.component.BaseBrowseView;
import com.baidu.searchbox.picture.component.HugePhotoDraweeView;
import com.baidu.searchbox.picture.contract.IViewer;
import com.baidu.searchbox.picture.utils.FrescoUtils;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.statistics.SharePageEnum;
import com.baidu.searchbox.socialshare.utils.ShareUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class LightPictureContextMenu implements ImageSearchCallback {
    private static final boolean DEBUG = PictureRuntime.GLOBAL_DEBUG;
    private static final int MENU_RECOGNIZE_BARCODE = 5;
    private static final int MENU_SAVE_BDYUN_ID = 3;
    private static final int MENU_SAVE_ID = 1;
    private static final int MENU_SEARCH_IMG = 4;
    private static final int MENU_SHARE_ID = 2;
    public static final int REQUEST_CODE_PERMISSION_STORAGE = 2001;
    public static final String REQUEST_PERMISSION_STORAGE_STAT_SOURCE = "light_picture_download_pic_menu";
    private static final String TAG = "LightPictureContextMenu";
    /* access modifiers changed from: private */
    public BarCodeModel mBarCodeModel;
    /* access modifiers changed from: private */
    public BaseBrowseView mBaseBrowseView;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public BdContextMenu mContextMenu;
    /* access modifiers changed from: private */
    public boolean mIsFromSwan;
    /* access modifiers changed from: private */
    public final PermissionDialogController mPermissionDialogController;
    private String mSearchImgResultUrl;
    private boolean mShowDownloadButton = true;
    private boolean mShowImgSearch = true;
    private boolean mShowNetPan = true;
    /* access modifiers changed from: private */
    public String mUrl;

    public static class BarCodeModel {
        public String barcodeFormat;
        public String codeText;
        public String codeType;
        public String resultPageUrl;
        public String resultType;
    }

    public LightPictureContextMenu(IViewer viewer) {
        Activity hostContext = viewer.getHostContext();
        this.mContext = hostContext;
        this.mPermissionDialogController = new PermissionDialogController(hostContext, new IActionProxy() {
            public void action(int actionCode) {
                Utils.downloadPicture(LightPictureContextMenu.this.mContext, LightPictureContextMenu.this.mUrl, LightPictureContextMenu.this.mIsFromSwan);
            }
        });
    }

    public void showContextMenu(BaseBrowseView view2, String url, boolean isFromSwan) {
        createAndShowMenu(view2, url, isFromSwan);
    }

    public void showContextMenu(BaseBrowseView view2, String url, boolean isFromSwan, boolean showDownloadButton, boolean showNetPan, boolean showImgSearch) {
        this.mShowDownloadButton = showDownloadButton;
        this.mShowNetPan = showNetPan;
        this.mShowImgSearch = showImgSearch;
        createAndShowMenu(view2, url, isFromSwan);
    }

    private void createAndShowMenu(BaseBrowseView browseView, final String url, boolean isFromSwan) {
        if (browseView != null) {
            this.mUrl = url;
            this.mIsFromSwan = isFromSwan;
            final String ubcSource = isFromSwan ? PictureStatisticConstants.SWAN_PICTURE : "picture";
            this.mBaseBrowseView = browseView;
            final HugePhotoDraweeView hugePhotoDraweeView = browseView.getHugePhotoDraweeView();
            if (hugePhotoDraweeView != null) {
                this.mContextMenu = new BdContextMenu(hugePhotoDraweeView);
                if (!TextUtils.isEmpty(url)) {
                    String localPath = FrescoUtils.getFrescoCachedPath(url, this.mContext);
                    ImageSearchInterface imageSearchInterface = (ImageSearchInterface) ServiceManager.getService(ImageSearchInterface.SERVICE_REFERENCE);
                    if (imageSearchInterface != null) {
                        imageSearchInterface.startImageSearch(this.mContext, new ImageSearchParams.Builder().imgUrl(TextUtils.isEmpty(localPath) ? url : Uri.fromFile(new File(localPath)).toString()).pageUrl("").imgSearchCallback(this).imgSearchSource(ImageSearchParams.ImageSearchSource.FEED_NEWS).build());
                    } else {
                        return;
                    }
                }
                this.mContextMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener() {
                    public void onClick(BdMenuItem item) {
                        ImageSearchParams.ImageSearchSource imageSearchSource;
                        switch (item.getItemId()) {
                            case 1:
                                if (TextUtils.isEmpty(url)) {
                                    UniversalToast.makeText(LightPictureContextMenu.this.mContext, (CharSequence) LightPictureContextMenu.this.mContext.getResources().getString(R.string.picture_save_fail)).setDuration(2).show();
                                } else {
                                    LightPictureContextMenu.this.mPermissionDialogController.permissionAction(LightPictureContextMenu.REQUEST_PERMISSION_STORAGE_STAT_SOURCE, 2001);
                                }
                                LongPressUBC.click(ubcSource, "picture", "save");
                                break;
                            case 2:
                                LightPictureContextMenu.this.shareImageCLick(hugePhotoDraweeView, url);
                                LongPressUBC.click(ubcSource, "picture", "share");
                                break;
                            case 3:
                                IPictureYun.Impl.get().doImageSaveJob(LightPictureContextMenu.this.mContext, url);
                                LongPressUBC.click(ubcSource, "picture", "savepan");
                                break;
                            case 4:
                                LightPictureContextMenu lightPictureContextMenu = LightPictureContextMenu.this;
                                String str = url;
                                if (lightPictureContextMenu.mIsFromSwan) {
                                    imageSearchSource = ImageSearchParams.ImageSearchSource.SWAN;
                                } else {
                                    imageSearchSource = ImageSearchParams.ImageSearchSource.FEED_NEWS;
                                }
                                lightPictureContextMenu.onSearchImgMenuClick(str, imageSearchSource);
                                LongPressUBC.click(ubcSource, "picture", "identify");
                                break;
                            case 5:
                                IBarCode.Impl.get().handleBarcodeClick(LightPictureContextMenu.this.mContext, LightPictureContextMenu.this.mBarCodeModel.barcodeFormat, LightPictureContextMenu.this.mBarCodeModel.codeType, LightPictureContextMenu.this.mBarCodeModel.resultType, LightPictureContextMenu.this.mBarCodeModel.codeText, LightPictureContextMenu.this.mBarCodeModel.resultPageUrl);
                                LongPressUBC.click(ubcSource, "picture", "qr");
                                break;
                        }
                        LightPictureContextMenu.this.mContextMenu.dismiss();
                    }
                });
                addMenuItem();
                this.mContextMenu.show();
                LongPressUBC.show(ubcSource, "picture", "all");
            } else if (DEBUG) {
                Log.d(TAG, "createAndShowMenu:  hugePhotoDraweeView is null ");
            }
        }
    }

    private void addMenuItem() {
        if (this.mShowImgSearch) {
            this.mContextMenu.add(4, com.baidu.android.common.ui.style.R.string.contextmenu_search_img);
        }
        if (this.mShowNetPan) {
            this.mContextMenu.add(3, com.baidu.android.common.ui.style.R.string.browser_menu_save_image_net);
        }
        if (!Utils.isLocalImage(this.mUrl) && this.mShowDownloadButton) {
            this.mContextMenu.add(1, com.baidu.android.common.ui.style.R.string.browser_menu_save_image);
        }
        this.mContextMenu.add(2, com.baidu.searchbox.common.atlas.R.string.browser_menu_share_image);
    }

    /* access modifiers changed from: private */
    public void shareImageCLick(final HugePhotoDraweeView draweeView, final String url) {
        if (draweeView != null && this.mBaseBrowseView != null) {
            draweeView.post(new Runnable() {
                public void run() {
                    LightPictureContextMenu lightPictureContextMenu = LightPictureContextMenu.this;
                    lightPictureContextMenu.onShareClick(url, lightPictureContextMenu.mBaseBrowseView.getBitmap(), "", draweeView);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onShareClick(String imgUrl, Bitmap captureBitmap, String titleStr, HugePhotoDraweeView draweeView) {
        Context context = this.mContext;
        if (context != null) {
            Bitmap capture = captureBitmap;
            View view2 = draweeView;
            if (view2 == null) {
                view2 = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
            }
            if (capture == null || capture.isRecycled()) {
                capture = ShareUtils.getScreenShot(view2);
            }
            String text = this.mContext.getResources().getString(com.baidu.searchbox.common.atlas.R.string.discovery_beauty);
            if (!TextUtils.isEmpty(titleStr)) {
                text = text + titleStr;
            }
            int i2 = 1;
            BaiduShareContent.Builder imageBitmap = new BaiduShareContent.Builder().setContent(ShareUtils.getShareContent(this.mContext, titleStr, text, false)).setLinkUrl(imgUrl).setImageBitmap(capture, true);
            if (capture != null) {
                i2 = 3;
            }
            BDShare.getInstance().share(this.mContext, (View) null, imageBitmap.setShareType(i2).setSourcePage(SharePageEnum.OTHER).setSource("image").create());
        }
    }

    public void onSearchImgMenuClick(String url, ImageSearchParams.ImageSearchSource source) {
        if (TextUtils.isEmpty(url)) {
            UniversalToast.makeText(this.mContext, com.baidu.searchbox.common.atlas.R.string.img_url_is_empty).setDuration(2).show();
        } else if (Utils.isLocalImage(url)) {
            IBarCode.Impl.get().startImgSearchPlugin(this.mContext, url);
        } else {
            ImageSearchInterface imageSearchInterface = (ImageSearchInterface) ServiceManager.getService(ImageSearchInterface.SERVICE_REFERENCE);
            if (imageSearchInterface != null) {
                if (!imageSearchInterface.loadImgSearchResult(this.mContext, TextUtils.equals(this.mUrl, url) ? this.mSearchImgResultUrl : "", url, source)) {
                    UniversalToast.makeText(this.mContext, com.baidu.searchbox.common.atlas.R.string.search_img_failed).setDuration(2).show();
                }
            }
        }
    }

    public void onSearchSuccess(String result) {
        parseResult(result);
    }

    private void parseResult(String result) {
        try {
            JSONObject content = new JSONObject(result);
            JSONObject imageResult = content.optJSONObject("imageResult");
            if (imageResult != null) {
                this.mSearchImgResultUrl = imageResult.optString("result");
            }
            JSONObject barcodeResult = content.optJSONObject("barcodeResult");
            if (barcodeResult != null) {
                BarCodeModel barCodeModel = new BarCodeModel();
                this.mBarCodeModel = barCodeModel;
                barCodeModel.codeType = barcodeResult.optString("codeType");
                this.mBarCodeModel.barcodeFormat = barcodeResult.optString("barcodeFormat");
                this.mBarCodeModel.resultType = barcodeResult.optString("resultType");
                this.mBarCodeModel.codeText = barcodeResult.optString("text");
                this.mBarCodeModel.resultPageUrl = barcodeResult.optString("resultPageUrl");
                if (!TextUtils.isEmpty(this.mBarCodeModel.codeType) && !TextUtils.isEmpty(this.mBarCodeModel.codeText)) {
                    addBarCodeItem();
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void addBarCodeItem() {
        BdContextMenu bdContextMenu = this.mContextMenu;
        if (bdContextMenu != null) {
            bdContextMenu.clear();
            this.mContextMenu.add(5, com.baidu.searchbox.common.atlas.R.string.menu_recognize_barcode);
            addMenuItem();
            this.mContextMenu.updateMenu();
            LongPressUBC.show("picture", "picture", "qr");
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.mPermissionDialogController.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.mPermissionDialogController.onActivityResult(requestCode, resultCode, data);
    }
}
