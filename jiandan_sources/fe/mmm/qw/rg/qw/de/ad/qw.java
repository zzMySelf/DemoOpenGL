package fe.mmm.qw.rg.qw.de.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.webkit.internal.AssetHelper;
import com.baidu.aiscan.R;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qw {
    public Context qw;

    public qw(Context context) {
        this.qw = context;
    }

    public static void ad(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }

    public final File de(File file) throws IOException {
        File th2 = th();
        if (!th2.exists()) {
            th2.mkdirs();
        }
        File file2 = new File(th2, file.getName());
        ad(file, file2);
        return file2;
    }

    public final boolean fe(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            File externalFilesDir = this.qw.getExternalFilesDir((String) null);
            if (externalFilesDir == null || !canonicalPath.startsWith(externalFilesDir.getCanonicalPath())) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final String i(List<String> list) {
        if (list.size() > 1) {
            String str = list.get(0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (!str.equals(str2)) {
                    if (!yj(str2).equals(yj(str))) {
                        return "*/*";
                    }
                    str = yj(str2) + "/*";
                }
            }
            return str;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return "*/*";
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1002if(Intent intent) {
        if (this.qw != null) {
            intent.addFlags(268435456);
            this.qw.startActivity(intent);
        }
    }

    public void o(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Non-empty text expected");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        m1002if(Intent.createChooser(intent, this.qw.getString(R.string.share_text)));
    }

    public void pf(List<String> list, List<String> list2, String str, String str2) throws IOException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Non-empty path expected");
        }
        qw();
        ArrayList<Uri> uk2 = uk(list);
        Intent intent = new Intent();
        if (uk2.isEmpty()) {
            o(str, str2);
            return;
        }
        if (uk2.size() == 1) {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uk2.get(0));
            intent.setType((list2.isEmpty() || list2.get(0) == null) ? "*/*" : list2.get(0));
        } else {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", uk2);
            intent.setType(i(list2));
        }
        if (str != null) {
            intent.putExtra("android.intent.extra.TEXT", str);
        }
        if (str2 != null) {
            intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        }
        intent.addFlags(1);
        Intent createChooser = Intent.createChooser(intent, this.qw.getString(R.string.share_file));
        for (ResolveInfo resolveInfo : rg().getPackageManager().queryIntentActivities(createChooser, 65536)) {
            String str3 = resolveInfo.activityInfo.packageName;
            Iterator<Uri> it = uk2.iterator();
            while (it.hasNext()) {
                rg().grantUriPermission(str3, it.next(), 3);
            }
        }
        m1002if(createChooser);
    }

    public final void qw() {
        File th2 = th();
        if (th2.exists()) {
            for (File delete : th2.listFiles()) {
                delete.delete();
            }
            th2.delete();
        }
    }

    public final Context rg() {
        Context context = this.qw;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Both context and activity are null");
    }

    @NonNull
    public final File th() {
        return new File(rg().getExternalCacheDir(), "share");
    }

    public final ArrayList<Uri> uk(List<String> list) throws IOException {
        ArrayList<Uri> arrayList = new ArrayList<>(list.size());
        for (String file : list) {
            File file2 = new File(file);
            if (!fe(file2)) {
                file2 = de(file2);
            }
            Context rg2 = rg();
            arrayList.add(FileProvider.getUriForFile(rg2, rg().getPackageName() + ".nestdiskFileprovider", file2));
        }
        return arrayList;
    }

    @NonNull
    public final String yj(String str) {
        return (str == null || !str.contains("/")) ? "*" : str.substring(0, str.indexOf("/"));
    }
}
