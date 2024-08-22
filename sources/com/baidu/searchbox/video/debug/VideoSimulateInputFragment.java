package com.baidu.searchbox.video.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/debug/VideoSimulateInputFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "video-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSimulateActivity.kt */
public final class VideoSimulateInputFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.video_debug_simulate_input_fragment, container, false);
        ((TextView) view2.findViewById(R.id.commit_button)).setOnClickListener(new VideoSimulateInputFragment$$ExternalSyntheticLambda0((EditText) view2.findViewById(R.id.input_cuid), this));
        return view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m5302onCreateView$lambda0(EditText $inputText, VideoSimulateInputFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ($inputText.getText().toString().length() > 0) {
            DIFactory.INSTANCE.getConfig().setSimulateCUID($inputText.getText().toString());
            DIFactory.INSTANCE.getConfig().setSimulateStatus("3");
            Toast.makeText(this$0.getContext(), "设置成功，重启设备后生效！", 0).show();
            this$0.requireActivity().getSupportFragmentManager().popBackStack();
            return;
        }
        Toast.makeText(this$0.getContext(), "CUID错误，请重新输入！", 0).show();
    }
}
