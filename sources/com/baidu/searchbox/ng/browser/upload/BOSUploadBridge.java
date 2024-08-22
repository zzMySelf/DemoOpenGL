package com.baidu.searchbox.ng.browser.upload;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import com.baidu.browser.sailor.ISailorUploadInterface;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.webkit.sdk.BOSResponseEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BOSUploadBridge implements ISailorUploadInterface {
    private byte[] barray;
    private String bizType;
    private String fileId;
    private String md5;

    public void init(Picture picture, String bizType2) {
        int width = picture.getWidth();
        int height = picture.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(540, 900, Bitmap.Config.RGB_565);
        Matrix mDrawMatrix = new Matrix();
        RectF mTempSrc = new RectF();
        RectF mTempDst = new RectF();
        Canvas mBmpCanvas = new Canvas(bitmap);
        mDrawMatrix.reset();
        mTempSrc.set(0.0f, 0.0f, (float) width, (float) height);
        mTempDst.set(0.0f, 0.0f, (float) 540, (float) 900);
        mDrawMatrix.setRectToRect(mTempSrc, mTempDst, Matrix.ScaleToFit.FILL);
        mBmpCanvas.concat(mDrawMatrix);
        picture.draw(mBmpCanvas);
        this.barray = getBitmapByte(bitmap);
        MessageDigest md52 = null;
        try {
            md52 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        if (md52 != null) {
            this.md5 = byteArr2HexStr(md52.digest(this.barray));
        }
        this.bizType = bizType2;
        this.fileId = BOSUploader.getInstance().createObjectKey(bizType2, this.md5);
    }

    public BOSResponseEntity upload() {
        com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity response = BOSUploader.getInstance().uploadByteSync(this.bizType, this.md5, this.barray);
        return new BOSResponseEntity(response.isSuccess(), response.getMessage(), response.getErrorCode());
    }

    public String getFileId() {
        return this.fileId;
    }

    private byte[] getBitmapByte(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        try {
            out.flush();
            out.close();
        } catch (IOException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return out.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String byteArr2HexStr(byte[] r7) {
        /*
            r6 = this;
            int r0 = r7.length
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            int r2 = r0 * 2
            r1.<init>(r2)
            r2 = 0
        L_0x0009:
            if (r2 >= r0) goto L_0x0025
            byte r3 = r7[r2]
        L_0x000d:
            if (r3 >= 0) goto L_0x0012
            int r3 = r3 + 256
            goto L_0x000d
        L_0x0012:
            r4 = 16
            if (r3 >= r4) goto L_0x001b
            java.lang.String r5 = "0"
            r1.append(r5)
        L_0x001b:
            java.lang.String r4 = java.lang.Integer.toString(r3, r4)
            r1.append(r4)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0025:
            java.lang.String r2 = r1.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ng.browser.upload.BOSUploadBridge.byteArr2HexStr(byte[]):java.lang.String");
    }
}
