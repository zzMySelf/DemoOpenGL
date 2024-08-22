package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AsyncImageLoader extends AsyncTask<Uri, Integer, Bitmap> {
    public static final String TAG = AsyncImageLoader.class.getSimpleName();
    public Context mContext;
    public IAsyncImageLoaderListener mListener;
    public int mMaxNumOfPixels = 19656;

    public static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.in.skip(j - j2);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    public interface IAsyncImageLoaderListener {
        void onComplete(Bitmap bitmap);
    }

    public AsyncImageLoader(Context context, int i2, IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.mContext = context.getApplicationContext();
        this.mListener = iAsyncImageLoaderListener;
        this.mMaxNumOfPixels = i2;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i3 == -1) {
            i4 = 1;
        } else {
            i4 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i3)));
        }
        if (i2 == -1) {
            i5 = 128;
        } else {
            double d3 = (double) i2;
            i5 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i5 < i4) {
            return i4;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? i4 : i5;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i2, i3);
        if (computeInitialSampleSize > 8) {
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < computeInitialSampleSize) {
            i4 <<= 1;
        }
        return i4;
    }

    private InputStream getInputStreamFromUri(Uri uri) {
        InputStream openStream;
        try {
            if (uri.getScheme() == null) {
                openStream = new FileInputStream(new File(uri.toString()));
            } else {
                if (!uri.getScheme().equalsIgnoreCase("http")) {
                    if (!uri.getScheme().equalsIgnoreCase("https")) {
                        if ((!uri.getScheme().equalsIgnoreCase("content") && !uri.getScheme().equalsIgnoreCase("file")) || this.mContext == null) {
                            return null;
                        }
                        String uri2 = uri.toString();
                        if (uri2.startsWith("file:///android_asset/")) {
                            openStream = this.mContext.getAssets().open(uri2.substring(22, uri2.length()));
                        } else {
                            openStream = this.mContext.getContentResolver().openInputStream(uri);
                        }
                    }
                }
                openStream = new URL(uri.toString()).openStream();
            }
            return openStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bitmap doInBackground(Uri... uriArr) {
        Uri uri;
        InputStream inputStreamFromUri;
        if (!(uriArr == null || uriArr.length < 1 || (uri = uriArr[0]) == null || (inputStreamFromUri = getInputStreamFromUri(uri)) == null)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamFromUri, (Rect) null, options);
            options.inSampleSize = computeSampleSize(options, -1, this.mMaxNumOfPixels);
            options.inJustDecodeBounds = false;
            InputStream inputStreamFromUri2 = getInputStreamFromUri(uri);
            if (inputStreamFromUri2 != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(new FlushedInputStream(inputStreamFromUri2), (Rect) null, options);
                    try {
                        inputStreamFromUri2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return decodeStream;
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public void onPostExecute(Bitmap bitmap) {
        IAsyncImageLoaderListener iAsyncImageLoaderListener = this.mListener;
        if (iAsyncImageLoaderListener != null) {
            iAsyncImageLoaderListener.onComplete(bitmap);
        }
        this.mContext = null;
    }
}
