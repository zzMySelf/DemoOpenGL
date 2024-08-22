package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AsyncImageLoader extends AsyncTask<Uri, Integer, Bitmap> {
    private static final String TAG = AsyncImageLoader.class.getSimpleName();
    private Context mContext;
    private IAsyncImageLoaderListener mListener;
    private int mMaxNumOfPixels = 19656;

    public interface IAsyncImageLoaderListener {
        void onComplete(Bitmap bitmap);
    }

    public AsyncImageLoader(Context context, int maxPixels, IAsyncImageLoaderListener listener) {
        this.mContext = context.getApplicationContext();
        this.mListener = listener;
        this.mMaxNumOfPixels = maxPixels;
    }

    /* access modifiers changed from: protected */
    public Bitmap doInBackground(Uri... params) {
        Uri uri;
        InputStream in;
        if (!(params == null || params.length < 1 || (uri = params[0]) == null || (in = getInputStreamFromUri(uri)) == null)) {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, (Rect) null, opts);
            opts.inSampleSize = computeSampleSize(opts, -1, this.mMaxNumOfPixels);
            opts.inJustDecodeBounds = false;
            InputStream in2 = getInputStreamFromUri(uri);
            if (in2 != null) {
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(new FlushedInputStream(in2), (Rect) null, opts);
                    try {
                        in2.close();
                    } catch (IOException e2) {
                        Log.e(TAG, "IO exception");
                        e2.printStackTrace();
                    }
                    return bitmap;
                } catch (OutOfMemoryError err) {
                    Log.e(TAG, "out of memory err no bitmap found");
                    err.printStackTrace();
                }
            }
        }
        return null;
    }

    private InputStream getInputStreamFromUri(Uri uri) {
        try {
            if (uri.getScheme() == null) {
                return new FileInputStream(new File(uri.toString()));
            }
            if (!uri.getScheme().equalsIgnoreCase("http")) {
                if (!uri.getScheme().equalsIgnoreCase("https")) {
                    if ((!uri.getScheme().equalsIgnoreCase("content") && !uri.getScheme().equalsIgnoreCase("file")) || this.mContext == null) {
                        return null;
                    }
                    String strUri = uri.toString();
                    if (!strUri.startsWith("file:///android_asset/")) {
                        return this.mContext.getContentResolver().openInputStream(uri);
                    }
                    return this.mContext.getAssets().open(strUri.substring("file:///android_asset/".length(), strUri.length()));
                }
            }
            return new URL(uri.toString()).openStream();
        } catch (IOException e2) {
            Log.e(TAG, "IOexception");
            e2.printStackTrace();
            return null;
        }
    }

    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);
        if (initialSize > 8) {
            return 8 * ((initialSize + 7) / 8);
        }
        int roundedSize = 1;
        while (roundedSize < initialSize) {
            roundedSize <<= 1;
        }
        return roundedSize;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        double w = (double) options.outWidth;
        double h2 = (double) options.outHeight;
        int lowerBound = maxNumOfPixels == -1 ? 1 : (int) Math.ceil(Math.sqrt((w * h2) / ((double) maxNumOfPixels)));
        int upperBound = minSideLength == -1 ? 128 : (int) Math.min(Math.floor(w / ((double) minSideLength)), Math.floor(h2 / ((double) minSideLength)));
        if (upperBound < lowerBound) {
            return lowerBound;
        }
        if (maxNumOfPixels == -1 && minSideLength == -1) {
            return 1;
        }
        if (minSideLength == -1) {
            return lowerBound;
        }
        return upperBound;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bitmap result) {
        IAsyncImageLoaderListener iAsyncImageLoaderListener = this.mListener;
        if (iAsyncImageLoaderListener != null) {
            iAsyncImageLoaderListener.onComplete(result);
        }
        this.mContext = null;
    }

    private static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream in) {
            super(in);
        }

        public long skip(long byteCount) throws IOException {
            long totalBytesSkipped = 0;
            while (totalBytesSkipped < byteCount) {
                long bytesSkipped = this.in.skip(byteCount - totalBytesSkipped);
                if (bytesSkipped == 0) {
                    if (read() < 0) {
                        break;
                    }
                    bytesSkipped = 1;
                }
                totalBytesSkipped += bytesSkipped;
            }
            return totalBytesSkipped;
        }
    }
}
