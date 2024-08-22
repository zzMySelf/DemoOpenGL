package com.baidu.wallet.core;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.m.x.d;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.FragmentResultReceiver;
import com.baidu.wallet.core.utils.FragmentUtils;
import java.util.Arrays;

public class BaseFragment extends SDKBaseFragment implements FragmentResultReceiver.a, NoProguard {
    public static final boolean DEBUG = false;
    public static final String EXTRA_FRAGMENT_RESULT_RECEIVER = "fragment result receiver";
    public static final String EXTRA_REQUEST_CODE = "request code";
    public static final String EXTRA_RESULT_CODE = "result code";
    public static final int MSG_RESPONSE_FAILURE = 2;
    public static final int MSG_RESPONSE_SUCCESS = 1;
    public static final String TAG_BASE = "BaseFragment";
    public BaseActivity mAct;
    public boolean mDestroyAct = true;
    public ResultReceiver mReceiver = null;
    public int mRequestId = -1;
    public long mTimeVal;

    public static String getClassFileLineMethod(String str) {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(str);
            sb.append(": ");
        }
        sb.append("[");
        sb.append(stackTraceElement.getFileName());
        sb.append(" | ");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(" | ");
        sb.append(stackTraceElement.getMethodName());
        sb.append("()");
        sb.append("]");
        return sb.toString();
    }

    public static void logFragmentStack(FragmentManager fragmentManager) {
    }

    public void finish() {
        finish(this.mDestroyAct);
    }

    public boolean getDestroyActFlag() {
        return this.mDestroyAct;
    }

    public void onCreate(Bundle bundle) {
        this.mTimeVal = System.currentTimeMillis();
        super.onCreate(bundle);
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "push"}));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("fragment result receiver") && arguments.containsKey("request code")) {
            this.mReceiver = (ResultReceiver) getArguments().getParcelable("fragment result receiver");
            this.mRequestId = getArguments().getInt("request code");
        }
        return onCreateView;
    }

    public void onDestroy() {
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), d.u}));
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        ResultReceiver resultReceiver = this.mReceiver;
        if (resultReceiver != null && (resultReceiver instanceof FragmentResultReceiver)) {
            ((FragmentResultReceiver) resultReceiver).a();
        }
        super.onDestroyView();
    }

    public void onDetach() {
        this.mAct = null;
        super.onDetach();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public void onPause() {
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "out"}));
        }
        super.onPause();
    }

    public void onReceiveResult(int i2, Bundle bundle) {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onResume() {
        super.onResume();
        if (this.mAct == null) {
            return;
        }
        if (0 != this.mTimeVal) {
            System.currentTimeMillis();
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "in", String.valueOf(this.mTimeVal)}));
            this.mTimeVal = 0;
            return;
        }
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "in", String.valueOf(0)}));
    }

    public void popBackFragment(int i2, boolean z) {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = this.mAct;
        if (baseActivity != null && baseActivity.getActivity() != null && (supportFragmentManager = ((FragmentActivity) this.mAct.getActivity()).getSupportFragmentManager()) != null) {
            logFragmentStack(supportFragmentManager);
            while (i2 > 0 && this.mAct != null) {
                if (FragmentUtils.popBackStackImmediate(supportFragmentManager)) {
                    i2--;
                } else if (z) {
                    this.mAct.finish();
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mAct = baseActivity;
    }

    public void setResult(Bundle bundle) {
        ResultReceiver resultReceiver = this.mReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(this.mRequestId, bundle);
        }
    }

    public void setUnDestroyActFlag() {
        this.mDestroyAct = false;
    }

    public void finish(boolean z) {
        popBackFragment(1, z);
    }
}
