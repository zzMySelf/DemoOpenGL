package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.google.common.base.Ascii;
import java.util.Locale;

public abstract class TrustedWebActivityService extends Service {
    @SuppressLint({"ActionValue", "ServiceName"})
    public static final String ACTION_TRUSTED_WEB_ACTIVITY_SERVICE = "android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE";
    public static final String KEY_SMALL_ICON_BITMAP = "android.support.customtabs.trusted.SMALL_ICON_BITMAP";
    public static final String KEY_SUCCESS = "androidx.browser.trusted.SUCCESS";
    public static final String META_DATA_NAME_SMALL_ICON = "android.support.customtabs.trusted.SMALL_ICON";
    public static final int SMALL_ICON_NOT_SET = -1;
    public final ITrustedWebActivityService.Stub mBinder = new ITrustedWebActivityService.Stub() {
        private void checkCaller() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.mVerifiedUid == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                int i2 = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token load = TrustedWebActivityService.this.getTokenStore().load();
                PackageManager packageManager = TrustedWebActivityService.this.getPackageManager();
                if (load != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (load.matches(packagesForUid[i2], packageManager)) {
                            TrustedWebActivityService.this.mVerifiedUid = Binder.getCallingUid();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (TrustedWebActivityService.this.mVerifiedUid != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        public Bundle areNotificationsEnabled(Bundle bundle) {
            checkCaller();
            return new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.onAreNotificationsEnabled(TrustedWebActivityServiceConnection.NotificationsEnabledArgs.fromBundle(bundle).channelName)).toBundle();
        }

        public void cancelNotification(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceConnection.CancelNotificationArgs fromBundle = TrustedWebActivityServiceConnection.CancelNotificationArgs.fromBundle(bundle);
            TrustedWebActivityService.this.onCancelNotification(fromBundle.platformTag, fromBundle.platformId);
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            checkCaller();
            return TrustedWebActivityService.this.onExtraCommand(str, bundle, TrustedWebActivityCallbackRemote.fromBinder(iBinder));
        }

        public Bundle getActiveNotifications() {
            checkCaller();
            return new TrustedWebActivityServiceConnection.ActiveNotificationsArgs(TrustedWebActivityService.this.onGetActiveNotifications()).toBundle();
        }

        public Bundle getSmallIconBitmap() {
            checkCaller();
            return TrustedWebActivityService.this.onGetSmallIconBitmap();
        }

        public int getSmallIconId() {
            checkCaller();
            return TrustedWebActivityService.this.onGetSmallIconId();
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceConnection.NotifyNotificationArgs fromBundle = TrustedWebActivityServiceConnection.NotifyNotificationArgs.fromBundle(bundle);
            return new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.onNotifyNotificationWithChannel(fromBundle.platformTag, fromBundle.platformId, fromBundle.notification, fromBundle.channelName)).toBundle();
        }
    };
    public NotificationManager mNotificationManager;
    public int mVerifiedUid = -1;

    public static String channelNameToId(String str) {
        return str.toLowerCase(Locale.ROOT).replace(Ascii.CASE_MASK, '_') + "_channel_id";
    }

    private void ensureOnCreateCalled() {
        if (this.mNotificationManager == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    @BinderThread
    @NonNull
    public abstract TokenStore getTokenStore();

    @BinderThread
    public boolean onAreNotificationsEnabled(@NonNull String str) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return NotificationApiHelperForO.isChannelEnabled(this.mNotificationManager, channelNameToId(str));
    }

    @MainThread
    @Nullable
    public final IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }

    @BinderThread
    public void onCancelNotification(@NonNull String str, int i2) {
        ensureOnCreateCalled();
        this.mNotificationManager.cancel(str, i2);
    }

    @CallSuper
    @MainThread
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @BinderThread
    @Nullable
    public Bundle onExtraCommand(@NonNull String str, @NonNull Bundle bundle, @Nullable TrustedWebActivityCallbackRemote trustedWebActivityCallbackRemote) {
        return null;
    }

    @BinderThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] onGetActiveNotifications() {
        ensureOnCreateCalled();
        if (Build.VERSION.SDK_INT >= 23) {
            return NotificationApiHelperForM.getActiveNotifications(this.mNotificationManager);
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    @BinderThread
    @NonNull
    public Bundle onGetSmallIconBitmap() {
        int onGetSmallIconId = onGetSmallIconId();
        Bundle bundle = new Bundle();
        if (onGetSmallIconId == -1) {
            return bundle;
        }
        bundle.putParcelable(KEY_SMALL_ICON_BITMAP, BitmapFactory.decodeResource(getResources(), onGetSmallIconId));
        return bundle;
    }

    @BinderThread
    public int onGetSmallIconId() {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
            if (serviceInfo.metaData == null) {
                return -1;
            }
            return serviceInfo.metaData.getInt(META_DATA_NAME_SMALL_ICON, -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @BinderThread
    public boolean onNotifyNotificationWithChannel(@NonNull String str, int i2, @NonNull Notification notification, @NonNull String str2) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String channelNameToId = channelNameToId(str2);
            notification = NotificationApiHelperForO.copyNotificationOntoChannel(this, this.mNotificationManager, notification, channelNameToId, str2);
            if (!NotificationApiHelperForO.isChannelEnabled(this.mNotificationManager, channelNameToId)) {
                return false;
            }
        }
        this.mNotificationManager.notify(str, i2, notification);
        return true;
    }

    @MainThread
    public final boolean onUnbind(@Nullable Intent intent) {
        this.mVerifiedUid = -1;
        return super.onUnbind(intent);
    }
}
