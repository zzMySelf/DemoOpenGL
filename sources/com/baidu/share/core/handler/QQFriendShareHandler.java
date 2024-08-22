package com.baidu.share.core.handler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.share.common.imgloader.ImageLoaderListener;
import com.baidu.share.common.imgloader.ImageManager;
import com.baidu.share.common.util.Utils;
import com.baidu.share.core.BdShareConstants;
import com.baidu.share.core.bean.BdImageObject;
import com.baidu.share.core.bean.BdUrlObject;
import com.baidu.share.core.bean.ShareContent;
import com.baidu.share.core.bean.ShareType;
import com.baidu.share.core.handler.transactivity.QQShareTransActivity;
import com.baidu.share.widget.ShareRuntime;
import com.tencent.tauth.Tencent;
import java.io.File;

public class QQFriendShareHandler extends BdShareBaseHandler {
    public QQFriendShareHandler(Context context, String clientId) {
        super(context, clientId);
        this.mNeedImgFilePath = true;
    }

    /* access modifiers changed from: protected */
    public void continueShare(ShareContent content) {
        if (!Tencent.isSupportShareToQQ(this.mContext.getApplicationContext())) {
            errorCallback(4609);
        } else {
            preProcess(content);
        }
    }

    public boolean validate(ShareContent content) {
        if (!validateContent(content)) {
            return false;
        }
        ShareType type = content.getMediaObject().type();
        if (type == ShareType.VIDEO) {
            errorCallback(4610);
            return false;
        } else if (type != ShareType.TEXT) {
            return true;
        } else {
            errorCallback(4611);
            return false;
        }
    }

    private void preProcess(final ShareContent content) {
        if (content.getMediaObject().type() == ShareType.IMAGE) {
            final BdImageObject imageObject = (BdImageObject) content.getMediaObject();
            Uri uri = imageObject.getImageUri();
            if (uri == null) {
                byte[] imageData = imageObject.getImageData();
                if (imageData == null) {
                    errorCallback(4097);
                    return;
                }
                imageObject.setImageUri(Uri.fromFile(new File(ImageManager.getInstance().saveImage2Disk(imageData, ImageManager.ORIGINAL_NAME))));
                doShare(content);
            } else if (!Utils.isUrl(uri)) {
                doShare(content);
            } else if (!Utils.isFileUrl(uri) || new File(uri.getPath()).length() >= 5242880) {
                ImageManager.getInstance().setGetFilePath(this.mNeedImgFilePath);
                ImageManager.getInstance().loadImage(this.mContext.getApplicationContext(), uri, this.mResizeOptions, new ImageLoaderListener() {
                    public void onComplete(Bitmap bitmap, String imagePath) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            QQFriendShareHandler.this.errorCallback(4098);
                            return;
                        }
                        String path = imagePath;
                        if (TextUtils.isEmpty(path)) {
                            path = ImageManager.getInstance().saveImage2Disk(bitmap, ImageManager.ORIGINAL_NAME);
                        }
                        imageObject.setImageUri(Uri.fromFile(new File(path)));
                        QQFriendShareHandler.this.doShare(content);
                    }
                });
            } else {
                doShare(content);
            }
        } else {
            doShare(content);
        }
    }

    /* access modifiers changed from: private */
    public void doShare(ShareContent content) {
        ShareRuntime.getShareBusinessIoc().removeLoadingView();
        Bundle params = makeQQFriendParams(content);
        if (params == null) {
            errorCallback(-1, "QQFriendParams is null");
            return;
        }
        try {
            Intent intent = new Intent(this.mContext, QQShareTransActivity.class);
            intent.setFlags(268435456);
            intent.putExtras(params);
            this.mContext.startActivity(intent);
        } catch (Exception e2) {
            if (ShareRuntime.isDebug()) {
                e2.printStackTrace();
            }
            errorCallback(-1, "start QQShareTransActivity fail");
        }
    }

    private Bundle makeQQFriendParams(ShareContent content) {
        Bundle params = new Bundle();
        params.putString("client_id", this.mClientId);
        params.putString(BdShareConstants.CALLBACK_TRANSACTION, this.mTransaction);
        params.putString("source", content.getSource());
        String title = content.getTitle();
        String summary = content.getContent();
        params.putString("title", title);
        params.putString("summary", summary);
        switch (AnonymousClass2.$SwitchMap$com$baidu$share$core$bean$ShareType[content.getMediaObject().type().ordinal()]) {
            case 1:
                params.putInt("req_type", 1);
                params.putString("targetUrl", ((BdUrlObject) content.getMediaObject()).getUrl());
                Uri thumbUri = content.getThumbUri();
                if (thumbUri != null) {
                    params.putString("imageUrl", thumbUri.getPath());
                    break;
                } else {
                    errorCallback(4097);
                    return null;
                }
            case 2:
                params.putInt("req_type", 5);
                params.putString("imageLocalUrl", ((BdImageObject) content.getMediaObject()).getImageUri().getPath());
                break;
            default:
                return null;
        }
        return params;
    }

    /* renamed from: com.baidu.share.core.handler.QQFriendShareHandler$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$share$core$bean$ShareType;

        static {
            int[] iArr = new int[ShareType.values().length];
            $SwitchMap$com$baidu$share$core$bean$ShareType = iArr;
            try {
                iArr[ShareType.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$share$core$bean$ShareType[ShareType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
