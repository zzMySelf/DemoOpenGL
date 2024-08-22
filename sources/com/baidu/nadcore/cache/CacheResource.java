package com.baidu.nadcore.cache;

import android.graphics.Bitmap;
import com.baidu.nadcore.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class CacheResource<T> {
    private T resource;

    public CacheResource(T res) {
        this.resource = res;
    }

    public Class<?> getResourceClass() {
        return this.resource.getClass();
    }

    public T get() {
        return this.resource;
    }

    public int size() {
        T t = this.resource;
        if (t instanceof Bitmap) {
            return ((Bitmap) t).getByteCount();
        }
        if (t instanceof File) {
            return (int) ((File) t).length();
        }
        if (t instanceof byte[]) {
            return ((byte[]) t).length;
        }
        return 1;
    }

    public boolean recycle() {
        boolean result = true;
        T t = this.resource;
        if (t instanceof Bitmap) {
            if (!((Bitmap) t).isRecycled()) {
                ((Bitmap) this.resource).recycle();
            }
        } else if (t instanceof File) {
            result = ((File) t).delete();
        }
        this.resource = null;
        return result;
    }

    public byte[] getByte() {
        ByteArrayOutputStream output = this.resource;
        if (output instanceof Bitmap) {
            ByteArrayOutputStream output2 = new ByteArrayOutputStream();
            ((Bitmap) this.resource).compress(Bitmap.CompressFormat.PNG, 100, output2);
            return output2.toByteArray();
        } else if (output instanceof File) {
            return FileUtils.readFileToByteArray((File) output);
        } else {
            if (output instanceof byte[]) {
                return (byte[]) output;
            }
            return null;
        }
    }

    public boolean isExpired(long expireTime) {
        if (!(this.resource instanceof File) || System.currentTimeMillis() - ((File) this.resource).lastModified() <= expireTime) {
            return false;
        }
        return true;
    }
}
