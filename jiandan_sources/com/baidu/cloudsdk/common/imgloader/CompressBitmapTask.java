package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CompressBitmapTask extends AsyncTask<Uri, Integer, ByteArrayOutputStream> {
    public Context mContext;
    public ICompressBitmapListener mListener;

    public interface ICompressBitmapListener {
        void onComplete(ByteArrayOutputStream byteArrayOutputStream);
    }

    public CompressBitmapTask(Context context, ICompressBitmapListener iCompressBitmapListener) {
        this.mContext = context;
        this.mListener = iCompressBitmapListener;
    }

    private InputStream getInputStreamFromUri(Uri uri) {
        InputStream openInputStream;
        try {
            if (uri.getScheme() == null) {
                openInputStream = new FileInputStream(new File(uri.toString()));
            } else if ((!uri.getScheme().equalsIgnoreCase("content") && !uri.getScheme().equalsIgnoreCase("file")) || this.mContext == null) {
                return null;
            } else {
                openInputStream = this.mContext.getContentResolver().openInputStream(uri);
            }
            return openInputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ByteArrayOutputStream doInBackground(Uri... uriArr) {
        InputStream inputStreamFromUri;
        if (uriArr[0] == null || (inputStreamFromUri = getInputStreamFromUri(uriArr[0])) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStreamFromUri.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStreamFromUri.close();
        return byteArrayOutputStream;
    }

    public void onPostExecute(ByteArrayOutputStream byteArrayOutputStream) {
        ICompressBitmapListener iCompressBitmapListener = this.mListener;
        if (iCompressBitmapListener != null) {
            iCompressBitmapListener.onComplete(byteArrayOutputStream);
        }
    }
}
