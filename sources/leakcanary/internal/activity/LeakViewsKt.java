package leakcanary.internal.activity;

import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.baidu.searchbox.drag.LaunchDragUBCManager;
import com.squareup.leakcanary.core.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.navigation.ViewsKt;
import shark.HeapAnalysisFailure;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"NEW_ISSUE_URL", "", "STACKOVERFLOW_QUESTION_URL", "share", "", "Landroid/view/View;", "content", "shareHeapDump", "heapDumpFile", "Ljava/io/File;", "shareToGitHubIssue", "failure", "Lshark/HeapAnalysisFailure;", "shareToStackOverflow", "startShareIntentChooser", "uri", "Landroid/net/Uri;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: LeakViews.kt */
public final class LeakViewsKt {
    private static final String NEW_ISSUE_URL = "https://github.com/square/leakcanary/issues/new?labels=type%3A+bug&template=2-bug.md";
    private static final String STACKOVERFLOW_QUESTION_URL = "http://stackoverflow.com/questions/ask?guided=false&tags=leakcanary";

    public static final void share(View $this$share, String content) {
        Intrinsics.checkParameterIsNotNull($this$share, "$this$share");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", content);
        ViewsKt.getActivity($this$share).startActivity(Intent.createChooser(intent, $this$share.getResources().getString(R.string.leak_canary_share_with)));
    }

    public static final void shareHeapDump(View $this$shareHeapDump, File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull($this$shareHeapDump, "$this$shareHeapDump");
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        AsyncTask.SERIAL_EXECUTOR.execute(new LeakViewsKt$shareHeapDump$1($this$shareHeapDump, heapDumpFile));
    }

    /* access modifiers changed from: private */
    public static final void startShareIntentChooser(View $this$startShareIntentChooser, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/octet-stream");
        intent.putExtra("android.intent.extra.STREAM", uri);
        ViewsKt.getActivity($this$startShareIntentChooser).startActivity(Intent.createChooser(intent, $this$startShareIntentChooser.getResources().getString(R.string.leak_canary_share_with)));
    }

    public static final void shareToStackOverflow(View $this$shareToStackOverflow, String content) {
        Intrinsics.checkParameterIsNotNull($this$shareToStackOverflow, "$this$shareToStackOverflow");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Object systemService = $this$shareToStackOverflow.getContext().getSystemService(LaunchDragUBCManager.TYPE_CLIPBOARD);
        if (systemService != null) {
            AsyncTask.execute(new LeakViewsKt$shareToStackOverflow$1($this$shareToStackOverflow, (ClipboardManager) systemService, content));
            Toast.makeText($this$shareToStackOverflow.getContext(), R.string.leak_canary_leak_copied, 1).show();
            try {
                ViewsKt.getActivity($this$shareToStackOverflow).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(STACKOVERFLOW_QUESTION_URL)));
            } catch (ActivityNotFoundException e2) {
                Toast.makeText($this$shareToStackOverflow.getContext(), R.string.leak_canary_leak_missing_browser_error, 1).show();
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
    }

    public static final void shareToGitHubIssue(View $this$shareToGitHubIssue, HeapAnalysisFailure failure) {
        Intrinsics.checkParameterIsNotNull($this$shareToGitHubIssue, "$this$shareToGitHubIssue");
        Intrinsics.checkParameterIsNotNull(failure, "failure");
        Object systemService = $this$shareToGitHubIssue.getContext().getSystemService(LaunchDragUBCManager.TYPE_CLIPBOARD);
        if (systemService != null) {
            AsyncTask.execute(new LeakViewsKt$shareToGitHubIssue$1($this$shareToGitHubIssue, (ClipboardManager) systemService, failure));
            Toast.makeText($this$shareToGitHubIssue.getContext(), R.string.leak_canary_failure_copied, 1).show();
            try {
                ViewsKt.getActivity($this$shareToGitHubIssue).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(NEW_ISSUE_URL)));
            } catch (ActivityNotFoundException e2) {
                Toast.makeText($this$shareToGitHubIssue.getContext(), R.string.leak_canary_leak_missing_browser_error, 1).show();
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
    }
}
