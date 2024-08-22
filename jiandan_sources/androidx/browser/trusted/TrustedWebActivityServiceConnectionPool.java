package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import de.qw.ad.de;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class TrustedWebActivityServiceConnectionPool {
    public static final String TAG = "TWAConnectionPool";
    public final Map<Uri, ConnectionHolder> mConnections = new HashMap();
    public final Context mContext;

    public static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {
        public final Context mAppContext;
        public final ConnectionHolder mConnection;
        public final Intent mIntent;

        public BindToServiceAsyncTask(Context context, Intent intent, ConnectionHolder connectionHolder) {
            this.mAppContext = context.getApplicationContext();
            this.mIntent = intent;
            this.mConnection = connectionHolder;
        }

        @Nullable
        public Exception doInBackground(Void... voidArr) {
            try {
                if (this.mAppContext.bindService(this.mIntent, this.mConnection, 4097)) {
                    return null;
                }
                this.mAppContext.unbindService(this.mConnection);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                return e;
            }
        }

        public void onPostExecute(Exception exc) {
            if (exc != null) {
                this.mConnection.cancel(exc);
            }
        }
    }

    public TrustedWebActivityServiceConnectionPool(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    @NonNull
    public static TrustedWebActivityServiceConnectionPool create(@NonNull Context context) {
        return new TrustedWebActivityServiceConnectionPool(context);
    }

    @Nullable
    private Intent createServiceIntent(Context context, Uri uri, Set<Token> set, boolean z) {
        if (set == null || set.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        String str = null;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            String str2 = resolveInfo.activityInfo.packageName;
            Iterator<Token> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().matches(str2, context.getPackageManager())) {
                        str = str2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (str == null) {
            if (z) {
                "No TWA candidates for " + uri + " have been registered.";
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str);
        intent2.setAction(TrustedWebActivityService.ACTION_TRUSTED_WEB_ACTIVITY_SERVICE);
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 131072);
        if (resolveService == null) {
            if (z) {
                "Could not find TWAService for " + str;
            }
            return null;
        }
        if (z) {
            "Found " + resolveService.serviceInfo.name + " to handle request for " + uri;
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str, resolveService.serviceInfo.name));
        return intent3;
    }

    @MainThread
    @NonNull
    public ListenableFuture<TrustedWebActivityServiceConnection> connect(@NonNull Uri uri, @NonNull Set<Token> set, @NonNull Executor executor) {
        ConnectionHolder connectionHolder = this.mConnections.get(uri);
        if (connectionHolder != null) {
            return connectionHolder.getServiceWrapper();
        }
        Intent createServiceIntent = createServiceIntent(this.mContext, uri, set, true);
        if (createServiceIntent == null) {
            return FutureUtils.immediateFailedFuture(new IllegalArgumentException("No service exists for scope"));
        }
        ConnectionHolder connectionHolder2 = new ConnectionHolder(new de(this, uri));
        this.mConnections.put(uri, connectionHolder2);
        new BindToServiceAsyncTask(this.mContext, createServiceIntent, connectionHolder2).executeOnExecutor(executor, new Void[0]);
        return connectionHolder2.getServiceWrapper();
    }

    public /* synthetic */ void qw(Uri uri) {
        this.mConnections.remove(uri);
    }

    @MainThread
    public boolean serviceExistsForScope(@NonNull Uri uri, @NonNull Set<Token> set) {
        if (this.mConnections.get(uri) == null && createServiceIntent(this.mContext, uri, set, false) == null) {
            return false;
        }
        return true;
    }

    public void unbindAllConnections() {
        for (ConnectionHolder unbindService : this.mConnections.values()) {
            this.mContext.unbindService(unbindService);
        }
        this.mConnections.clear();
    }
}
