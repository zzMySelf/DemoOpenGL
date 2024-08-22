package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.log.sender.upload.BIMUploadConstants;
import com.baidubce.http.Headers;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AsyncUploadTask extends AsyncTask<Void, Integer, Integer> {
    private static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG = AsyncUploadTask.class.getSimpleName();
    private String mAuthorization;
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private IUploadTransferListener mListener;
    private String mRemoteUrl;
    private String mThumbUrl;
    private int mType;
    private String mUrl;
    private String mXbcs;

    public AsyncUploadTask(Context context, int type, String url, String filePath, String contentType, String authorizaion, String xBce, IUploadTransferListener listener) {
        this.mRemoteUrl = "";
        this.mContext = context;
        this.mListener = listener;
        this.mUrl = url;
        this.mType = type;
        this.mFilePath = filePath;
        this.mContentType = contentType;
        this.mAuthorization = authorizaion;
        this.mXbcs = xBce;
    }

    public AsyncUploadTask(Context context, int type, String url, String remoteUrl, String filePath, String contentType, String authorizaion, String xBce, IUploadTransferListener listener) {
        this(context, type, url, filePath, contentType, authorizaion, xBce, listener);
        this.mRemoteUrl = remoteUrl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AsyncUploadTask(Context context, int type, String url, String remoteUrl, String thumbUrl, String filePath, String contentType, String authorizaion, String xBce, IUploadTransferListener listener) {
        this(context, type, url, filePath, contentType, authorizaion, xBce, listener);
        this.mRemoteUrl = remoteUrl;
        this.mThumbUrl = thumbUrl;
    }

    /* access modifiers changed from: protected */
    public Integer doInBackground(Void... params) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return 1002;
        }
        return doUpload();
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... progress) {
        IUploadTransferListener iUploadTransferListener = this.mListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onProgress(progress[0].intValue());
        }
    }

    private Integer doUpload() {
        InputStream inputStream;
        long fileSize = 0;
        try {
            if (Utility.isMediaUri(this.mFilePath)) {
                inputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                if (inputStream != null) {
                    fileSize = (long) inputStream.available();
                }
            } else {
                File f2 = new File(this.mFilePath);
                if (f2.exists()) {
                    if (!f2.isDirectory()) {
                        fileSize = f2.length();
                        inputStream = new FileInputStream(this.mFilePath);
                    }
                }
                return 1007;
            }
            if (inputStream == null) {
                return 1007;
            }
            LogUtils.d(TAG, "upload url is " + this.mUrl);
            HttpURLConnection con = (HttpURLConnection) new URL(this.mUrl).openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            int i2 = 0;
            con.setUseCaches(false);
            con.setRequestMethod("PUT");
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Charset", "utf-8");
            con.setRequestProperty(BIMUploadConstants.CONTENT_TYPE, this.mContentType);
            con.setRequestProperty(Headers.AUTHORIZATION, this.mAuthorization);
            con.setRequestProperty(Headers.BCE_DATE, this.mXbcs);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            byte[] buffer = new byte[8192];
            long len = 0;
            long startTime = System.currentTimeMillis();
            while (true) {
                int read = inputStream.read(buffer);
                int count = read;
                if (read == -1) {
                    break;
                }
                dos.write(buffer, i2, count);
                len += (long) count;
                byte[] buffer2 = buffer;
                LogUtils.d(TAG, "write bytes:" + count + "  total:" + len + "  time:" + (((float) (System.currentTimeMillis() - startTime)) / 1000.0f));
                onProgressUpdate(Integer.valueOf((int) ((100 * len) / fileSize)));
                buffer = buffer2;
                i2 = 0;
                dos = dos;
            }
            DataOutputStream dos2 = dos;
            byte[] bArr = buffer;
            inputStream.close();
            dos2.flush();
            dos2.close();
            int response = con.getResponseCode();
            if (response == 200) {
                LogUtils.i(TAG, "upload success " + response);
                return 0;
            }
            LogUtils.e(TAG, "upload failure " + response);
            return 1008;
        } catch (MalformedURLException e2) {
            Log.e(TAG, "MalformedURLException:" + e2);
            return 1008;
        } catch (ProtocolException e3) {
            Log.e(TAG, "ProtocolException:" + e3);
            return 1008;
        } catch (IOException e4) {
            Log.e(TAG, "IOException:" + e4);
            return 1008;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer result) {
        if (result.equals(0)) {
            notifyFinished();
        } else {
            notifyFailed(result.intValue());
        }
    }

    private void notifyFailed(int errorCode) {
        try {
            IUploadTransferListener iUploadTransferListener = this.mListener;
            if (iUploadTransferListener != null) {
                iUploadTransferListener.onFailed(errorCode, this.mType, this.mFilePath);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "notifyFailed", e2);
        }
    }

    private void notifyFinished() {
        try {
            IUploadTransferListener iUploadTransferListener = this.mListener;
            if (iUploadTransferListener == null) {
                return;
            }
            if (iUploadTransferListener instanceof IUploadTransferMultipleParamListener) {
                ((IUploadTransferMultipleParamListener) iUploadTransferListener).onFinished(this.mType, this.mRemoteUrl, this.mThumbUrl);
            } else {
                iUploadTransferListener.onFinished(this.mType, this.mRemoteUrl);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "notifyFinished", e2);
        }
    }

    public String showTime() {
        return new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }
}
