package io.flutter.plugins.systemshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.webkit.internal.AssetHelper;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Share {
    public Activity activity;
    public Context context;

    public Share(Context context2, Activity activity2) {
        this.context = context2;
        this.activity = activity2;
    }

    private void clearExternalShareFolder() {
        File externalShareFolder = getExternalShareFolder();
        if (externalShareFolder.exists()) {
            for (File delete : externalShareFolder.listFiles()) {
                delete.delete();
            }
            externalShareFolder.delete();
        }
    }

    public static void copy(File file, File file2) throws IOException {
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

    private File copyToExternalShareFolder(File file) throws IOException {
        File externalShareFolder = getExternalShareFolder();
        if (!externalShareFolder.exists()) {
            externalShareFolder.mkdirs();
        }
        File file2 = new File(externalShareFolder, file.getName());
        copy(file, file2);
        return file2;
    }

    private boolean fileIsOnExternal(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            File externalFilesDir = this.context.getExternalFilesDir((String) null);
            if (externalFilesDir == null || !canonicalPath.startsWith(externalFilesDir.getCanonicalPath())) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private Context getContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        throw new IllegalStateException("Both context and activity are null");
    }

    @NonNull
    private File getExternalShareFolder() {
        return new File(getContext().getExternalCacheDir(), "share");
    }

    @NonNull
    private String getMimeTypeBase(String str) {
        return (str == null || !str.contains("/")) ? "*" : str.substring(0, str.indexOf("/"));
    }

    private ArrayList<Uri> getUrisForPaths(List<String> list) throws IOException {
        ArrayList<Uri> arrayList = new ArrayList<>(list.size());
        for (String file : list) {
            File file2 = new File(file);
            if (!fileIsOnExternal(file2)) {
                file2 = copyToExternalShareFolder(file2);
            }
            Context context2 = getContext();
            arrayList.add(FileProvider.getUriForFile(context2, getContext().getPackageName() + ".flutter.share_provider", file2));
        }
        return arrayList;
    }

    private String reduceMimeTypes(List<String> list) {
        if (list.size() > 1) {
            String str = list.get(0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (!str.equals(str2)) {
                    if (!getMimeTypeBase(str2).equals(getMimeTypeBase(str))) {
                        return "*/*";
                    }
                    str = getMimeTypeBase(str2) + "/*";
                }
            }
            return str;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return "*/*";
        }
    }

    private void startActivity(Intent intent) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivity(intent);
        } else if (this.context != null) {
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } else {
            throw new IllegalStateException("Both context and activity are null");
        }
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public void share(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Non-empty text expected");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    public void shareFiles(List<String> list, List<String> list2, String str, String str2) throws IOException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Non-empty path expected");
        }
        clearExternalShareFolder();
        ArrayList<Uri> urisForPaths = getUrisForPaths(list);
        Intent intent = new Intent();
        if (urisForPaths.isEmpty()) {
            share(str, str2);
            return;
        }
        if (urisForPaths.size() == 1) {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", urisForPaths.get(0));
            intent.setType((list2.isEmpty() || list2.get(0) == null) ? "*/*" : list2.get(0));
        } else {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", urisForPaths);
            intent.setType(reduceMimeTypes(list2));
        }
        if (str != null) {
            intent.putExtra("android.intent.extra.TEXT", str);
        }
        if (str2 != null) {
            intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, str2);
        }
        intent.addFlags(1);
        Intent createChooser = Intent.createChooser(intent, "Share");
        for (ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(createChooser, 65536)) {
            String str3 = resolveInfo.activityInfo.packageName;
            Iterator<Uri> it = urisForPaths.iterator();
            while (it.hasNext()) {
                getContext().grantUriPermission(str3, it.next(), 3);
            }
        }
        startActivity(createChooser);
    }
}
