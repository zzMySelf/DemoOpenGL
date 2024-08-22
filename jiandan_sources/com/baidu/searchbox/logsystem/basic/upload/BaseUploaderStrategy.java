package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.fe.ddd.when.fe.fe;
import fe.fe.ddd.when.fe.rg;
import java.util.List;
import java.util.Set;

public abstract class BaseUploaderStrategy implements UploadInterface {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f1055ad = true;

    /* renamed from: de  reason: collision with root package name */
    public UploadListener f1056de = null;
    public boolean qw = true;

    public interface UploadListener {
        void ad(@Nullable rg rgVar);

        void qw(@Nullable rg rgVar);
    }

    public BaseUploaderStrategy() {
    }

    public void ad(Context context) {
    }

    public void de(Context context, @NonNull rg rgVar, @Nullable List<fe> list, @Nullable Set<fe> set, @Nullable List<fe> list2) {
    }

    public boolean qw() {
        return true;
    }

    public BaseUploaderStrategy(boolean z, boolean z2, @Nullable UploadListener uploadListener) {
        this.qw = z;
        this.f1055ad = z2;
        this.f1056de = uploadListener;
    }
}
