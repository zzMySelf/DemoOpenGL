package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    public static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    public static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    public static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    public static Field sContextField;
    @GuardedBy("sGnssStatusListeners")
    public static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    @RequiresApi(28)
    public static class Api28Impl {
        @DoNotInline
        public static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
            locationManager.getCurrentLocation(str, cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, new java.util.function.Consumer<Location>() {
                public void accept(Location location) {
                    Consumer.this.accept(location);
                }
            });
        }
    }

    public static final class CancellableLocationListener implements LocationListener {
        public Consumer<Location> mConsumer;
        public final Executor mExecutor;
        public final LocationManager mLocationManager;
        public final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        @Nullable
        public Runnable mTimeoutRunnable;
        @GuardedBy("this")
        public boolean mTriggered;

        public CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    cleanup();
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable final Location location) {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    final Consumer<Location> consumer = this.mConsumer;
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            consumer.accept(location);
                        }
                    });
                    cleanup();
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(@NonNull String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }

        public void startTimeout(long j) {
            synchronized (this) {
                if (!this.mTriggered) {
                    AnonymousClass1 r0 = new Runnable() {
                        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                        public void run() {
                            CancellableLocationListener cancellableLocationListener = CancellableLocationListener.this;
                            cancellableLocationListener.mTimeoutRunnable = null;
                            cancellableLocationListener.onLocationChanged((Location) null);
                        }
                    };
                    this.mTimeoutRunnable = r0;
                    this.mTimeoutHandler.postDelayed(r0, j);
                }
            }
        }
    }

    @RequiresApi(30)
    public static class GnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void onFirstFix(int i2) {
            this.mCallback.onFirstFix(i2);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    public static class GpsStatusTransport implements GpsStatus.Listener {
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;
        public final LocationManager mLocationManager;

        public GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i2) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor != null) {
                if (i2 == 1) {
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStarted();
                            }
                        }
                    });
                } else if (i2 == 2) {
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStopped();
                            }
                        }
                    });
                } else if (i2 == 3) {
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                        executor.execute(new Runnable() {
                            public void run() {
                                if (GpsStatusTransport.this.mExecutor == executor) {
                                    GpsStatusTransport.this.mCallback.onFirstFix(timeToFirstFix);
                                }
                            }
                        });
                    }
                } else if (i2 == 4 && (gpsStatus = this.mLocationManager.getGpsStatus((GpsStatus) null)) != null) {
                    final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(wrap);
                            }
                        }
                    });
                }
            }
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    public static final class InlineHandlerExecutor implements Executor {
        public final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    @RequiresApi(24)
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void onFirstFix(final int i2) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onFirstFix(i2);
                        }
                    }
                });
            }
        }

        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
                        }
                    }
                });
            }
        }

        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStarted();
                        }
                    }
                });
            }
        }

        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStopped();
                        }
                    }
                });
            }
        }

        public void register(Executor executor) {
            boolean z = true;
            Preconditions.checkArgument(executor != null, "invalid null executor");
            if (this.mExecutor != null) {
                z = false;
            }
            Preconditions.checkState(z);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) >= 10000) {
            final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                    public void onCancel() {
                        CancellableLocationListener.this.cancel();
                    }
                });
            }
            cancellableLocationListener.startTimeout(30000);
            return;
        }
        executor.execute(new Runnable() {
            public void run() {
                Consumer.this.accept(lastKnownLocation);
            }
        });
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (i2 <= 19) {
            try {
                if (sContextField == null) {
                    Field declaredField = LocationManager.class.getDeclaredField("mContext");
                    sContextField = declaredField;
                    declaredField.setAccessible(true);
                }
                Context context = (Context) sContextField.get(locationManager);
                if (context != null) {
                    if (Build.VERSION.SDK_INT != 19) {
                        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                    }
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
                        return true;
                    }
                    return false;
                }
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            }
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new InlineHandlerExecutor(handler), callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            synchronized (sGnssStatusListeners) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) sGnssStatusListeners.remove(callback);
                if (gnssStatusTransport != null) {
                    locationManager.unregisterGnssStatusCallback(gnssStatusTransport);
                }
            }
        } else if (i2 >= 24) {
            synchronized (sGnssStatusListeners) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) sGnssStatusListeners.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
        } else {
            synchronized (sGnssStatusListeners) {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) sGnssStatusListeners.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00cd, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d8, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00e2 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0133 A[SYNTHETIC, Splitter:B:103:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0114 A[Catch:{ ExecutionException -> 0x010a, TimeoutException -> 0x00f1, all -> 0x00ee, all -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0129 A[Catch:{ ExecutionException -> 0x010a, TimeoutException -> 0x00f1, all -> 0x00ee, all -> 0x0130 }] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean registerGnssStatusCallback(final android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 30
            if (r0 < r3) goto L_0x002c
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r3 = sGnssStatusListeners
            monitor-enter(r3)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r10 = sGnssStatusListeners     // Catch:{ all -> 0x0029 }
            java.lang.Object r10 = r10.get(r12)     // Catch:{ all -> 0x0029 }
            androidx.core.location.LocationManagerCompat$GnssStatusTransport r10 = (androidx.core.location.LocationManagerCompat.GnssStatusTransport) r10     // Catch:{ all -> 0x0029 }
            if (r10 != 0) goto L_0x001a
            androidx.core.location.LocationManagerCompat$GnssStatusTransport r10 = new androidx.core.location.LocationManagerCompat$GnssStatusTransport     // Catch:{ all -> 0x0029 }
            r10.<init>(r12)     // Catch:{ all -> 0x0029 }
        L_0x001a:
            boolean r9 = r9.registerGnssStatusCallback(r11, r10)     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x0027
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r9 = sGnssStatusListeners     // Catch:{ all -> 0x0029 }
            r9.put(r12, r10)     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return r1
        L_0x0027:
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return r2
        L_0x0029:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            throw r9
        L_0x002c:
            r3 = 24
            if (r0 < r3) goto L_0x0063
            if (r10 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            androidx.core.util.Preconditions.checkArgument(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r0 = sGnssStatusListeners
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r3 = sGnssStatusListeners     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ all -> 0x0060 }
            androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport r3 = (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport) r3     // Catch:{ all -> 0x0060 }
            if (r3 != 0) goto L_0x004b
            androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport r3 = new androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport     // Catch:{ all -> 0x0060 }
            r3.<init>(r12)     // Catch:{ all -> 0x0060 }
            goto L_0x004e
        L_0x004b:
            r3.unregister()     // Catch:{ all -> 0x0060 }
        L_0x004e:
            r3.register(r11)     // Catch:{ all -> 0x0060 }
            boolean r9 = r9.registerGnssStatusCallback(r3, r10)     // Catch:{ all -> 0x0060 }
            if (r9 == 0) goto L_0x005e
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r9 = sGnssStatusListeners     // Catch:{ all -> 0x0060 }
            r9.put(r12, r3)     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return r1
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return r2
        L_0x0060:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r9
        L_0x0063:
            if (r10 == 0) goto L_0x0067
            r0 = 1
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            androidx.core.util.Preconditions.checkArgument(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r0 = sGnssStatusListeners
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r3 = sGnssStatusListeners     // Catch:{ all -> 0x0152 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ all -> 0x0152 }
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) r3     // Catch:{ all -> 0x0152 }
            if (r3 != 0) goto L_0x007e
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = new androidx.core.location.LocationManagerCompat$GpsStatusTransport     // Catch:{ all -> 0x0152 }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x0152 }
            goto L_0x0081
        L_0x007e:
            r3.unregister()     // Catch:{ all -> 0x0152 }
        L_0x0081:
            r3.register(r11)     // Catch:{ all -> 0x0152 }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0152 }
            androidx.core.location.LocationManagerCompat$3 r4 = new androidx.core.location.LocationManagerCompat$3     // Catch:{ all -> 0x0152 }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x0152 }
            r11.<init>(r4)     // Catch:{ all -> 0x0152 }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0152 }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x0152 }
            if (r9 != r4) goto L_0x009c
            r11.run()     // Catch:{ all -> 0x0152 }
            goto L_0x00a2
        L_0x009c:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x0152 }
            if (r9 == 0) goto L_0x013b
        L_0x00a2:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x010a, TimeoutException -> 0x00f1, all -> 0x00ee }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x010a, TimeoutException -> 0x00f1, all -> 0x00ee }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x010a, TimeoutException -> 0x00f1, all -> 0x00ee }
            long r6 = r6 + r4
            r9 = 0
        L_0x00b0:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            if (r4 == 0) goto L_0x00ce
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r4 = sGnssStatusListeners     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x00e2, ExecutionException -> 0x00df, TimeoutException -> 0x00dc, all -> 0x00d9 }
            if (r9 == 0) goto L_0x00cc
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0152 }
            r9.interrupt()     // Catch:{ all -> 0x0152 }
        L_0x00cc:
            monitor-exit(r0)     // Catch:{ all -> 0x0152 }
            return r1
        L_0x00ce:
            if (r9 == 0) goto L_0x00d7
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0152 }
            r9.interrupt()     // Catch:{ all -> 0x0152 }
        L_0x00d7:
            monitor-exit(r0)     // Catch:{ all -> 0x0152 }
            return r2
        L_0x00d9:
            r10 = move-exception
            r1 = r9
            goto L_0x0131
        L_0x00dc:
            r11 = move-exception
            r1 = r9
            goto L_0x00f3
        L_0x00df:
            r10 = move-exception
            r1 = r9
            goto L_0x010c
        L_0x00e2:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00ec, TimeoutException -> 0x00ea }
            long r4 = r6 - r4
            r9 = 1
            goto L_0x00b0
        L_0x00ea:
            r11 = move-exception
            goto L_0x00f3
        L_0x00ec:
            r10 = move-exception
            goto L_0x010c
        L_0x00ee:
            r10 = move-exception
            r1 = 0
            goto L_0x0131
        L_0x00f1:
            r11 = move-exception
            r1 = 0
        L_0x00f3:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r12.<init>()     // Catch:{ all -> 0x0130 }
            r12.append(r10)     // Catch:{ all -> 0x0130 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x0130 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x0130 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0130 }
            throw r9     // Catch:{ all -> 0x0130 }
        L_0x010a:
            r10 = move-exception
            r1 = 0
        L_0x010c:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0130 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0130 }
            if (r9 != 0) goto L_0x0129
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0130 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x0130 }
            if (r9 == 0) goto L_0x0123
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0130 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x0130 }
            throw r9     // Catch:{ all -> 0x0130 }
        L_0x0123:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0130 }
            r9.<init>(r10)     // Catch:{ all -> 0x0130 }
            throw r9     // Catch:{ all -> 0x0130 }
        L_0x0129:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0130 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x0130 }
            throw r9     // Catch:{ all -> 0x0130 }
        L_0x0130:
            r10 = move-exception
        L_0x0131:
            if (r1 == 0) goto L_0x013a
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0152 }
            r9.interrupt()     // Catch:{ all -> 0x0152 }
        L_0x013a:
            throw r10     // Catch:{ all -> 0x0152 }
        L_0x013b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0152 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r11.<init>()     // Catch:{ all -> 0x0152 }
            r11.append(r10)     // Catch:{ all -> 0x0152 }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x0152 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0152 }
            r9.<init>(r10)     // Catch:{ all -> 0x0152 }
            throw r9     // Catch:{ all -> 0x0152 }
        L_0x0152:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0152 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }
}
