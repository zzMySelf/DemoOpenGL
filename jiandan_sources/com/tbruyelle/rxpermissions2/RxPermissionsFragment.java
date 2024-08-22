package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import fe.ddd.qw.qw;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

public class RxPermissionsFragment extends Fragment {
    public static final int PERMISSIONS_REQUEST_CODE = 42;
    public boolean mLogging;
    public Map<String, PublishSubject<qw>> mSubjects = new HashMap();

    public boolean containsByPermission(@NonNull String str) {
        return this.mSubjects.containsKey(str);
    }

    public PublishSubject<qw> getSubjectByPermission(@NonNull String str) {
        return this.mSubjects.get(str);
    }

    @TargetApi(23)
    public boolean isGranted(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkSelfPermission(str) == 0;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    @TargetApi(23)
    public boolean isRevoked(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public void log(String str) {
        if (this.mLogging) {
            String str2 = RxPermissions.qw;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                zArr[i3] = shouldShowRequestPermissionRationale(strArr[i3]);
            }
            onRequestPermissionsResult(strArr, iArr, zArr);
        }
    }

    @TargetApi(23)
    public void requestPermissions(@NonNull String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void setLogging(boolean z) {
        this.mLogging = z;
    }

    public void setSubjectForPermission(@NonNull String str, @NonNull PublishSubject<qw> publishSubject) {
        this.mSubjects.put(str, publishSubject);
    }

    public void onRequestPermissionsResult(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            log("onRequestPermissionsResult  " + strArr[i2]);
            PublishSubject publishSubject = this.mSubjects.get(strArr[i2]);
            if (publishSubject == null) {
                String str = RxPermissions.qw;
                return;
            }
            this.mSubjects.remove(strArr[i2]);
            publishSubject.onNext(new qw(strArr[i2], iArr[i2] == 0, zArr[i2]));
            publishSubject.onComplete();
        }
    }
}
