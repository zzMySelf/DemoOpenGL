package androidx.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.renderscript.Element;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RenderScript {
    public static final String CACHE_PATH = "com.android.renderscript.cache";
    public static final int CREATE_FLAG_NONE = 0;
    public static final boolean DEBUG = false;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "RenderScript_jni";
    public static final int SUPPORT_LIB_API = 23;
    public static final int SUPPORT_LIB_VERSION = 2301;
    public static Object lock = new Object();
    public static String mBlackList = "";
    public static String mCachePath;
    public static ArrayList<RenderScript> mProcessContextList = new ArrayList<>();
    public static Method registerNativeAllocation;
    public static Method registerNativeFree;
    public static boolean sInitialized;
    public static int sNative = -1;
    public static int sPointerSize;
    public static Object sRuntime;
    public static int sSdkVersion = -1;
    public static boolean sUseGCHooks;
    public static boolean useIOlib = false;
    public static boolean useNative;
    public Context mApplicationContext;
    public long mContext;
    public int mContextFlags = 0;
    public int mContextSdkVersion = 0;
    public ContextType mContextType = ContextType.NORMAL;
    public boolean mDestroyed = false;
    public int mDispatchAPILevel = 0;
    public Element mElement_ALLOCATION;
    public Element mElement_A_8;
    public Element mElement_BOOLEAN;
    public Element mElement_CHAR_2;
    public Element mElement_CHAR_3;
    public Element mElement_CHAR_4;
    public Element mElement_DOUBLE_2;
    public Element mElement_DOUBLE_3;
    public Element mElement_DOUBLE_4;
    public Element mElement_ELEMENT;
    public Element mElement_F32;
    public Element mElement_F64;
    public Element mElement_FLOAT_2;
    public Element mElement_FLOAT_3;
    public Element mElement_FLOAT_4;
    public Element mElement_I16;
    public Element mElement_I32;
    public Element mElement_I64;
    public Element mElement_I8;
    public Element mElement_INT_2;
    public Element mElement_INT_3;
    public Element mElement_INT_4;
    public Element mElement_LONG_2;
    public Element mElement_LONG_3;
    public Element mElement_LONG_4;
    public Element mElement_MATRIX_2X2;
    public Element mElement_MATRIX_3X3;
    public Element mElement_MATRIX_4X4;
    public Element mElement_RGBA_4444;
    public Element mElement_RGBA_5551;
    public Element mElement_RGBA_8888;
    public Element mElement_RGB_565;
    public Element mElement_RGB_888;
    public Element mElement_SAMPLER;
    public Element mElement_SCRIPT;
    public Element mElement_SHORT_2;
    public Element mElement_SHORT_3;
    public Element mElement_SHORT_4;
    public Element mElement_TYPE;
    public Element mElement_U16;
    public Element mElement_U32;
    public Element mElement_U64;
    public Element mElement_U8;
    public Element mElement_UCHAR_2;
    public Element mElement_UCHAR_3;
    public Element mElement_UCHAR_4;
    public Element mElement_UINT_2;
    public Element mElement_UINT_3;
    public Element mElement_UINT_4;
    public Element mElement_ULONG_2;
    public Element mElement_ULONG_3;
    public Element mElement_ULONG_4;
    public Element mElement_USHORT_2;
    public Element mElement_USHORT_3;
    public Element mElement_USHORT_4;
    public boolean mEnableMultiInput = false;
    public RSErrorHandler mErrorCallback = null;
    public long mIncCon;
    public boolean mIncLoaded;
    public boolean mIsProcessContext = false;
    public RSMessageHandler mMessageCallback = null;
    public MessageThread mMessageThread;
    public String mNativeLibDir;
    public ReentrantReadWriteLock mRWLock;
    public Sampler mSampler_CLAMP_LINEAR;
    public Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    public Sampler mSampler_CLAMP_NEAREST;
    public Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    public Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    public Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    public Sampler mSampler_WRAP_LINEAR;
    public Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    public Sampler mSampler_WRAP_NEAREST;

    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        public int mID;

        /* access modifiers changed from: public */
        ContextType(int i2) {
            this.mID = i2;
        }
    }

    public static class MessageThread extends Thread {
        public static final int RS_ERROR_FATAL_DEBUG = 2048;
        public static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        public static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        public static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        public static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        public static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        public static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        public int[] mAuxData = new int[2];
        public RenderScript mRS;
        public boolean mRun = true;

        public MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRS = renderScript;
        }

        public void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.mRS;
            renderScript.nContextInitToClient(renderScript.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.mRS;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
                int[] iArr2 = this.mAuxData;
                int i2 = iArr2[1];
                int i3 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i2 >> 2) >= iArr.length) {
                        iArr = new int[((i2 + 3) >> 2)];
                    }
                    RenderScript renderScript3 = this.mRS;
                    if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) == 4) {
                        RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                        if (rSMessageHandler != null) {
                            rSMessageHandler.mData = iArr;
                            rSMessageHandler.mID = i3;
                            rSMessageHandler.mLength = i2;
                            rSMessageHandler.run();
                        } else {
                            throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                        }
                    } else {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.mRS;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                    if (i3 < 4096) {
                        if (i3 >= 2048) {
                            RenderScript renderScript5 = this.mRS;
                            if (renderScript5.mContextType == ContextType.DEBUG) {
                                if (renderScript5.mErrorCallback == null) {
                                }
                            }
                        }
                        RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                        if (rSErrorHandler != null) {
                            rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                            rSErrorHandler.mErrorNum = i3;
                            rSErrorHandler.run();
                        } else {
                            "non fatal RS error, " + nContextGetErrorMessage;
                        }
                    }
                    "fatal RS error, " + nContextGetErrorMessage;
                    throw new RSRuntimeException("Fatal error " + i3 + ", details: " + nContextGetErrorMessage);
                } else {
                    try {
                        Thread.sleep(1, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        public int mID;

        /* access modifiers changed from: public */
        Priority(int i2) {
            this.mID = i2;
        }
    }

    public static class RSErrorHandler implements Runnable {
        public String mErrorMessage;
        public int mErrorNum;

        public void run() {
        }
    }

    public static class RSMessageHandler implements Runnable {
        public int[] mData;
        public int mID;
        public int mLength;

        public void run() {
        }
    }

    public RenderScript(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.mApplicationContext = applicationContext;
            this.mNativeLibDir = applicationContext.getApplicationInfo().nativeLibraryDir;
        }
        this.mIncCon = 0;
        this.mIncLoaded = false;
        this.mRWLock = new ReentrantReadWriteLock();
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript createMultiContext(Context context, ContextType contextType, int i2, int i3) {
        return internalCreate(context, i3, contextType, i2);
    }

    public static void forceCompat() {
        sNative = 0;
    }

    public static int getPointerSize() {
        synchronized (lock) {
            if (!sInitialized) {
                throw new RSInvalidStateException("Calling getPointerSize() before any RenderScript instantiated");
            }
        }
        return sPointerSize;
    }

    private void helpDestroy() {
        boolean z;
        boolean z2;
        synchronized (this) {
            z = false;
            if (!this.mDestroyed) {
                this.mDestroyed = true;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            nContextFinish();
            if (this.mIncCon != 0) {
                nIncContextFinish();
                nIncContextDestroy();
                this.mIncCon = 0;
            }
            nContextDeinitToClient(this.mContext);
            MessageThread messageThread = this.mMessageThread;
            messageThread.mRun = false;
            messageThread.interrupt();
            boolean z3 = false;
            while (!z) {
                try {
                    this.mMessageThread.join();
                    z = true;
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
            nContextDestroy();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|12|13|14|15|16|(1:21)(1:20)|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.renderscript.RenderScript internalCreate(android.content.Context r10, int r11, androidx.renderscript.RenderScript.ContextType r12, int r13) {
        /*
            androidx.renderscript.RenderScript r7 = new androidx.renderscript.RenderScript
            r7.<init>(r10)
            int r0 = sSdkVersion
            r1 = -1
            if (r0 != r1) goto L_0x000d
            sSdkVersion = r11
            goto L_0x000f
        L_0x000d:
            if (r0 != r11) goto L_0x01b3
        L_0x000f:
            int r0 = sSdkVersion
            boolean r10 = setupNative(r0, r10)
            useNative = r10
            java.lang.Object r10 = lock
            monitor-enter(r10)
            boolean r0 = sInitialized     // Catch:{ all -> 0x01b0 }
            r1 = 0
            r2 = 2301(0x8fd, float:3.224E-42)
            r3 = 23
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L_0x00b9
            java.lang.String r0 = "dalvik.system.VMRuntime"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.String r6 = "getRuntime"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x005a }
            java.lang.reflect.Method r6 = r0.getDeclaredMethod(r6, r8)     // Catch:{ Exception -> 0x005a }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x005a }
            java.lang.Object r6 = r6.invoke(r1, r8)     // Catch:{ Exception -> 0x005a }
            sRuntime = r6     // Catch:{ Exception -> 0x005a }
            java.lang.String r6 = "registerNativeAllocation"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x005a }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x005a }
            r8[r5] = r9     // Catch:{ Exception -> 0x005a }
            java.lang.reflect.Method r6 = r0.getDeclaredMethod(r6, r8)     // Catch:{ Exception -> 0x005a }
            registerNativeAllocation = r6     // Catch:{ Exception -> 0x005a }
            java.lang.String r6 = "registerNativeFree"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x005a }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x005a }
            r8[r5] = r9     // Catch:{ Exception -> 0x005a }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r6, r8)     // Catch:{ Exception -> 0x005a }
            registerNativeFree = r0     // Catch:{ Exception -> 0x005a }
            sUseGCHooks = r4     // Catch:{ Exception -> 0x005a }
            goto L_0x005c
        L_0x005a:
            sUseGCHooks = r5     // Catch:{ all -> 0x01b0 }
        L_0x005c:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            if (r0 >= r3) goto L_0x007b
            java.lang.String r0 = r7.mNativeLibDir     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            if (r0 == 0) goto L_0x007b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            r0.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.String r6 = r7.mNativeLibDir     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            r0.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.String r6 = "/librsjni_androidx.so"
            r0.append(r6)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.System.load(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            goto L_0x0080
        L_0x007b:
            java.lang.String r0 = "rsjni_androidx"
            java.lang.System.loadLibrary(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
        L_0x0080:
            sInitialized = r4     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            int r0 = rsnSystemGetPointerSize()     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            sPointerSize = r0     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            goto L_0x00b9
        L_0x0089:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r12.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r13 = "Error loading RS jni library: "
            r12.append(r13)     // Catch:{ all -> 0x01b0 }
            r12.append(r11)     // Catch:{ all -> 0x01b0 }
            r12.toString()     // Catch:{ all -> 0x01b0 }
            androidx.renderscript.RSRuntimeException r12 = new androidx.renderscript.RSRuntimeException     // Catch:{ all -> 0x01b0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r13.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r0 = "Error loading RS jni library: "
            r13.append(r0)     // Catch:{ all -> 0x01b0 }
            r13.append(r11)     // Catch:{ all -> 0x01b0 }
            java.lang.String r11 = " Support lib API: "
            r13.append(r11)     // Catch:{ all -> 0x01b0 }
            r13.append(r2)     // Catch:{ all -> 0x01b0 }
            java.lang.String r11 = r13.toString()     // Catch:{ all -> 0x01b0 }
            r12.<init>(r11)     // Catch:{ all -> 0x01b0 }
            throw r12     // Catch:{ all -> 0x01b0 }
        L_0x00b9:
            monitor-exit(r10)     // Catch:{ all -> 0x01b0 }
            boolean r10 = useNative
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 14
            if (r10 < r0) goto L_0x00c4
            useIOlib = r4
        L_0x00c4:
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r11 >= r10) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r10 = r11
        L_0x00ca:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x00e5
            java.lang.String r0 = r7.mNativeLibDir
            if (r0 == 0) goto L_0x00e5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.mNativeLibDir
            r0.append(r1)
            java.lang.String r1 = "/libRSSupport.so"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
        L_0x00e5:
            boolean r0 = useNative
            boolean r0 = r7.nLoadSO(r0, r10, r1)
            if (r0 != 0) goto L_0x014b
            boolean r0 = useNative
            if (r0 == 0) goto L_0x00f3
            useNative = r5
        L_0x00f3:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            if (r0 >= r3) goto L_0x00ff
            java.lang.String r0 = r7.mNativeLibDir     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            if (r0 == 0) goto L_0x00ff
            java.lang.System.load(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            goto L_0x0104
        L_0x00ff:
            java.lang.String r0 = "RSSupport"
            java.lang.System.loadLibrary(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
        L_0x0104:
            boolean r0 = r7.nLoadSO(r5, r10, r1)
            if (r0 == 0) goto L_0x010b
            goto L_0x014b
        L_0x010b:
            androidx.renderscript.RSRuntimeException r10 = new androidx.renderscript.RSRuntimeException
            java.lang.String r11 = "Error loading libRSSupport library, Support lib version: 2301"
            r10.<init>(r11)
            throw r10
        L_0x0113:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Error loading RS Compat library: "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r12 = " Support lib version: "
            r11.append(r12)
            r11.append(r2)
            r11.toString()
            androidx.renderscript.RSRuntimeException r11 = new androidx.renderscript.RSRuntimeException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Error loading RS Compat library: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = " Support lib version: "
            r12.append(r10)
            r12.append(r2)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x014b:
            boolean r0 = useIOlib
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = "RSSupportIO"
            java.lang.System.loadLibrary(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0155 }
            goto L_0x0157
        L_0x0155:
            useIOlib = r5
        L_0x0157:
            boolean r0 = useIOlib
            if (r0 == 0) goto L_0x0161
            boolean r0 = r7.nLoadIOSO()
            if (r0 != 0) goto L_0x0163
        L_0x0161:
            useIOlib = r5
        L_0x0163:
            if (r10 < r3) goto L_0x017e
            r7.mEnableMultiInput = r4
            java.lang.String r0 = "blasV8"
            java.lang.System.loadLibrary(r0)     // Catch:{ UnsatisfiedLinkError -> 0x016d }
            goto L_0x017e
        L_0x016d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to load BLAS lib, ONLY BNNM will be supported: "
            r1.append(r2)
            r1.append(r0)
            r1.toString()
        L_0x017e:
            long r1 = r7.nDeviceCreate()
            r3 = 0
            int r5 = r12.mID
            java.lang.String r6 = r7.mNativeLibDir
            r0 = r7
            r4 = r11
            long r0 = r0.nContextCreate(r1, r3, r4, r5, r6)
            r7.mContext = r0
            r7.mContextType = r12
            r7.mContextFlags = r13
            r7.mContextSdkVersion = r11
            r7.mDispatchAPILevel = r10
            r10 = 0
            int r12 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x01a8
            androidx.renderscript.RenderScript$MessageThread r10 = new androidx.renderscript.RenderScript$MessageThread
            r10.<init>(r7)
            r7.mMessageThread = r10
            r10.start()
            return r7
        L_0x01a8:
            androidx.renderscript.RSDriverException r10 = new androidx.renderscript.RSDriverException
            java.lang.String r11 = "Failed to create RS context."
            r10.<init>(r11)
            throw r10
        L_0x01b0:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x01b0 }
            throw r11
        L_0x01b3:
            androidx.renderscript.RSRuntimeException r10 = new androidx.renderscript.RSRuntimeException
            java.lang.String r11 = "Can't have two contexts with different SDK versions in support lib"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.renderscript.RenderScript.internalCreate(android.content.Context, int, androidx.renderscript.RenderScript$ContextType, int):androidx.renderscript.RenderScript");
    }

    public static void releaseAllContexts() {
        ArrayList<RenderScript> arrayList;
        synchronized (mProcessContextList) {
            arrayList = mProcessContextList;
            mProcessContextList = new ArrayList<>();
        }
        Iterator<RenderScript> it = arrayList.iterator();
        while (it.hasNext()) {
            RenderScript next = it.next();
            next.mIsProcessContext = false;
            next.destroy();
        }
        arrayList.clear();
    }

    public static native int rsnSystemGetPointerSize();

    public static void setBlackList(String str) {
        if (str != null) {
            mBlackList = str;
        }
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    public static boolean setupNative(int i2, Context context) {
        int i3;
        long j;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < i2 && i4 < 21) {
            sNative = 0;
        }
        if (sNative == -1) {
            try {
                i3 = ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke((Object) null, new Object[]{"debug.rs.forcecompat", new Integer(0)})).intValue();
            } catch (Exception unused) {
                i3 = 0;
            }
            if (Build.VERSION.SDK_INT < 19 || i3 != 0) {
                sNative = 0;
            } else {
                sNative = 1;
            }
            if (sNative == 1) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    try {
                        j = ((Long) Class.forName("android.renderscript.RenderScript").getDeclaredMethod("getMinorID", new Class[0]).invoke((Object) null, new Object[0])).longValue();
                    } catch (Exception unused2) {
                        j = 0;
                    }
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        if (bundle.getBoolean("androidx.renderscript.EnableAsyncTeardown") && j == 0) {
                            sNative = 0;
                        }
                        if (applicationInfo.metaData.getBoolean("androidx.renderscript.EnableBlurWorkaround") && Build.VERSION.SDK_INT <= 19) {
                            sNative = 0;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    return true;
                }
            }
        }
        if (sNative != 1) {
            return false;
        }
        if (mBlackList.length() > 0) {
            if (mBlackList.contains('(' + Build.MANUFACTURER + ':' + Build.PRODUCT + ':' + Build.MODEL + ')')) {
                sNative = 0;
                return false;
            }
        }
        return true;
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        if (!this.mIsProcessContext) {
            validate();
            helpDestroy();
        }
    }

    public void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public int getDispatchAPILevel() {
        return this.mDispatchAPILevel;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    public boolean isAlive() {
        return this.mContext != 0;
    }

    public boolean isUseNative() {
        return useNative;
    }

    public synchronized void nAllocationCopyFromBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, j, bitmap);
    }

    public synchronized void nAllocationCopyToBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, j, bitmap);
    }

    public synchronized long nAllocationCreateBitmapBackedAllocation(long j, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, j, i2, bitmap, i3);
    }

    public synchronized long nAllocationCreateBitmapRef(long j, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, j, bitmap);
    }

    public synchronized long nAllocationCreateFromAssetStream(int i2, int i3, int i4) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i2, i3, i4);
    }

    public synchronized long nAllocationCreateFromBitmap(long j, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, j, i2, bitmap, i3);
    }

    public synchronized long nAllocationCreateTyped(long j, int i2, int i3, long j2) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, j, i2, i3, j2);
    }

    public synchronized long nAllocationCubeCreateFromBitmap(long j, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, j, i2, bitmap, i3);
    }

    public synchronized void nAllocationData1D(long j, int i2, int i3, int i4, Object obj, int i5, Element.DataType dataType, int i6, boolean z) {
        synchronized (this) {
            validate();
            rsnAllocationData1D(this.mContext, j, i2, i3, i4, obj, i5, dataType.mID, i6, z);
        }
    }

    public synchronized void nAllocationData2D(long j, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, int i9, int i10, int i11) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i2, i3, i4, i5, i6, i7, j2, i8, i9, i10, i11);
        }
    }

    public synchronized void nAllocationData3D(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, int i10, int i11, int i12) {
        synchronized (this) {
            validate();
            rsnAllocationData3D(this.mContext, j, i2, i3, i4, i5, i6, i7, i8, j2, i9, i10, i11, i12);
        }
    }

    public synchronized void nAllocationElementData1D(long j, int i2, int i3, int i4, byte[] bArr, int i5) {
        synchronized (this) {
            validate();
            rsnAllocationElementData1D(this.mContext, j, i2, i3, i4, bArr, i5);
        }
    }

    public synchronized void nAllocationGenerateMipmaps(long j) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, j);
    }

    public synchronized ByteBuffer nAllocationGetByteBuffer(long j, int i2, int i3, int i4) {
        validate();
        return rsnAllocationGetByteBuffer(this.mContext, j, i2, i3, i4);
    }

    public synchronized long nAllocationGetStride(long j) {
        validate();
        return rsnAllocationGetStride(this.mContext, j);
    }

    public synchronized long nAllocationGetType(long j) {
        validate();
        return rsnAllocationGetType(this.mContext, j);
    }

    public synchronized void nAllocationIoReceive(long j) {
        validate();
        rsnAllocationIoReceive(this.mContext, j);
    }

    public synchronized void nAllocationIoSend(long j) {
        validate();
        rsnAllocationIoSend(this.mContext, j);
    }

    public synchronized void nAllocationRead(long j, Object obj, Element.DataType dataType, int i2, boolean z) {
        validate();
        rsnAllocationRead(this.mContext, j, obj, dataType.mID, i2, z);
    }

    public synchronized void nAllocationRead1D(long j, int i2, int i3, int i4, Object obj, int i5, Element.DataType dataType, int i6, boolean z) {
        synchronized (this) {
            validate();
            rsnAllocationRead1D(this.mContext, j, i2, i3, i4, obj, i5, dataType.mID, i6, z);
        }
    }

    public synchronized void nAllocationRead2D(long j, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, Element.DataType dataType, int i9, boolean z) {
        synchronized (this) {
            validate();
            rsnAllocationRead2D(this.mContext, j, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID, i9, z);
        }
    }

    public synchronized void nAllocationResize1D(long j, int i2) {
        validate();
        rsnAllocationResize1D(this.mContext, j, i2);
    }

    public synchronized void nAllocationResize2D(long j, int i2, int i3) {
        validate();
        rsnAllocationResize2D(this.mContext, j, i2, i3);
    }

    public synchronized void nAllocationSetSurface(long j, Surface surface) {
        validate();
        rsnAllocationSetSurface(this.mContext, j, surface);
    }

    public synchronized void nAllocationSyncAll(long j, int i2) {
        validate();
        rsnAllocationSyncAll(this.mContext, j, i2);
    }

    public synchronized long nClosureCreate(long j, long j2, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4) {
        long rsnClosureCreate;
        synchronized (this) {
            validate();
            rsnClosureCreate = rsnClosureCreate(this.mContext, j, j2, jArr, jArr2, iArr, jArr3, jArr4);
            if (rsnClosureCreate == 0) {
                throw new RSRuntimeException("Failed creating closure.");
            }
        }
        return rsnClosureCreate;
    }

    public synchronized void nClosureSetArg(long j, int i2, long j2, int i3) {
        validate();
        rsnClosureSetArg(this.mContext, j, i2, j2, i3);
    }

    public synchronized void nClosureSetGlobal(long j, long j2, long j3, int i2) {
        synchronized (this) {
            validate();
            rsnClosureSetGlobal(this.mContext, j, j2, j3, i2);
        }
    }

    public synchronized long nContextCreate(long j, int i2, int i3, int i4, String str) {
        return rsnContextCreate(j, i2, i3, i4, str);
    }

    public native void nContextDeinitToClient(long j);

    public synchronized void nContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mContext;
        this.mContext = 0;
        writeLock.unlock();
        rsnContextDestroy(j);
    }

    public synchronized void nContextDump(int i2) {
        validate();
        rsnContextDump(this.mContext, i2);
    }

    public synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    public native String nContextGetErrorMessage(long j);

    public native int nContextGetUserMessage(long j, int[] iArr);

    public native void nContextInitToClient(long j);

    public native int nContextPeekMessage(long j, int[] iArr);

    public synchronized void nContextSendMessage(int i2, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i2, iArr);
    }

    public synchronized void nContextSetPriority(int i2) {
        validate();
        rsnContextSetPriority(this.mContext, i2);
    }

    public native long nDeviceCreate();

    public native void nDeviceDestroy(long j);

    public native void nDeviceSetConfig(long j, int i2, int i3);

    public synchronized long nElementCreate(long j, int i2, boolean z, int i3) {
        validate();
        return rsnElementCreate(this.mContext, j, i2, z, i3);
    }

    public synchronized long nElementCreate2(long[] jArr, String[] strArr, int[] iArr) {
        validate();
        return rsnElementCreate2(this.mContext, jArr, strArr, iArr);
    }

    public synchronized void nElementGetNativeData(long j, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, j, iArr);
    }

    public synchronized void nElementGetSubElements(long j, long[] jArr, String[] strArr, int[] iArr) {
        validate();
        rsnElementGetSubElements(this.mContext, j, jArr, strArr, iArr);
    }

    public synchronized long nIncAllocationCreateTyped(long j, long j2, int i2) {
        validate();
        return rsnIncAllocationCreateTyped(this.mContext, this.mIncCon, j, j2, i2);
    }

    public synchronized long nIncContextCreate(long j, int i2, int i3, int i4) {
        return rsnIncContextCreate(j, i2, i3, i4);
    }

    public synchronized void nIncContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mIncCon;
        this.mIncCon = 0;
        writeLock.unlock();
        rsnIncContextDestroy(j);
    }

    public synchronized void nIncContextFinish() {
        validate();
        rsnIncContextFinish(this.mIncCon);
    }

    public native long nIncDeviceCreate();

    public native void nIncDeviceDestroy(long j);

    public synchronized long nIncElementCreate(long j, int i2, boolean z, int i3) {
        validate();
        return rsnIncElementCreate(this.mIncCon, j, i2, z, i3);
    }

    public native boolean nIncLoadSO(int i2, String str);

    public void nIncObjDestroy(long j) {
        long j2 = this.mIncCon;
        if (j2 != 0) {
            rsnIncObjDestroy(j2, j);
        }
    }

    public synchronized long nIncTypeCreate(long j, int i2, int i3, int i4, boolean z, boolean z2, int i5) {
        long rsnIncTypeCreate;
        synchronized (this) {
            validate();
            rsnIncTypeCreate = rsnIncTypeCreate(this.mIncCon, j, i2, i3, i4, z, z2, i5);
        }
        return rsnIncTypeCreate;
    }

    public synchronized long nInvokeClosureCreate(long j, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr) {
        long rsnInvokeClosureCreate;
        validate();
        rsnInvokeClosureCreate = rsnInvokeClosureCreate(this.mContext, j, bArr, jArr, jArr2, iArr);
        if (rsnInvokeClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnInvokeClosureCreate;
    }

    public native boolean nLoadIOSO();

    public native boolean nLoadSO(boolean z, int i2, String str);

    public void nObjDestroy(long j) {
        long j2 = this.mContext;
        if (j2 != 0) {
            rsnObjDestroy(j2, j);
        }
    }

    public synchronized long nSamplerCreate(int i2, int i3, int i4, int i5, int i6, float f) {
        validate();
        return rsnSamplerCreate(this.mContext, i2, i3, i4, i5, i6, f);
    }

    public synchronized void nScriptBindAllocation(long j, long j2, int i2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptBindAllocation(j3, j, j2, i2, z);
    }

    public synchronized long nScriptCCreate(String str, String str2, byte[] bArr, int i2) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i2);
    }

    public synchronized long nScriptFieldIDCreate(long j, int i2, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptFieldIDCreate(j2, j, i2, z);
    }

    public synchronized void nScriptForEach(long j, int i2, long j2, long j3, byte[] bArr, boolean z) {
        synchronized (this) {
            validate();
            if (bArr == null) {
                rsnScriptForEach(this.mContext, this.mIncCon, j, i2, j2, j3, z);
            } else {
                rsnScriptForEach(this.mContext, this.mIncCon, j, i2, j2, j3, bArr, z);
            }
        }
    }

    public synchronized void nScriptForEachClipped(long j, int i2, long j2, long j3, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        synchronized (this) {
            validate();
            if (bArr == null) {
                rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i2, j2, j3, i3, i4, i5, i6, i7, i8, z);
            } else {
                rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i2, j2, j3, bArr, i3, i4, i5, i6, i7, i8, z);
            }
        }
    }

    public synchronized long nScriptGroup2Create(String str, String str2, long[] jArr) {
        validate();
        return rsnScriptGroup2Create(this.mContext, str, str2, jArr);
    }

    public synchronized void nScriptGroup2Execute(long j) {
        validate();
        rsnScriptGroup2Execute(this.mContext, j);
    }

    public synchronized long nScriptGroupCreate(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, jArr, jArr2, jArr3, jArr4, jArr5);
    }

    public synchronized void nScriptGroupExecute(long j) {
        validate();
        rsnScriptGroupExecute(this.mContext, j);
    }

    public synchronized void nScriptGroupSetInput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetInput(this.mContext, j, j2, j3);
    }

    public synchronized void nScriptGroupSetOutput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, j, j2, j3);
    }

    public synchronized void nScriptIntrinsicBLAS_BNNM(long j, int i2, int i3, int i4, long j2, int i5, long j3, int i6, long j4, int i7, int i8, boolean z) {
        synchronized (this) {
            validate();
            rsnScriptIntrinsicBLAS_BNNM(this.mContext, this.mIncCon, j, i2, i3, i4, j2, i5, j3, i6, j4, i7, i8, z);
        }
    }

    public synchronized void nScriptIntrinsicBLAS_Complex(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, float f2, long j2, long j3, float f3, float f4, long j4, int i11, int i12, int i13, int i14, boolean z) {
        synchronized (this) {
            validate();
            rsnScriptIntrinsicBLAS_Complex(this.mContext, this.mIncCon, j, i2, i3, i4, i5, i6, i7, i8, i9, i10, f, f2, j2, j3, f3, f4, j4, i11, i12, i13, i14, z);
        }
    }

    public synchronized void nScriptIntrinsicBLAS_Double(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, double d, long j2, long j3, double d2, long j4, int i11, int i12, int i13, int i14, boolean z) {
        synchronized (this) {
            validate();
            rsnScriptIntrinsicBLAS_Double(this.mContext, this.mIncCon, j, i2, i3, i4, i5, i6, i7, i8, i9, i10, d, j2, j3, d2, j4, i11, i12, i13, i14, z);
        }
    }

    public synchronized void nScriptIntrinsicBLAS_Single(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, long j2, long j3, float f2, long j4, int i11, int i12, int i13, int i14, boolean z) {
        synchronized (this) {
            validate();
            rsnScriptIntrinsicBLAS_Single(this.mContext, this.mIncCon, j, i2, i3, i4, i5, i6, i7, i8, i9, i10, f, j2, j3, f2, j4, i11, i12, i13, i14, z);
        }
    }

    public synchronized void nScriptIntrinsicBLAS_Z(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, double d, double d2, long j2, long j3, double d3, double d4, long j4, int i11, int i12, int i13, int i14, boolean z) {
        synchronized (this) {
            validate();
            rsnScriptIntrinsicBLAS_Z(this.mContext, this.mIncCon, j, i2, i3, i4, i5, i6, i7, i8, i9, i10, d, d2, j2, j3, d3, d4, j4, i11, i12, i13, i14, z);
        }
    }

    public synchronized long nScriptIntrinsicCreate(int i2, long j, boolean z) {
        validate();
        if (!z) {
            return rsnScriptIntrinsicCreate(this.mContext, i2, j, z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!this.mIncLoaded) {
                try {
                    System.loadLibrary("RSSupport");
                    if (nIncLoadSO(23, this.mNativeLibDir + "/libRSSupport.so")) {
                        this.mIncLoaded = true;
                    } else {
                        throw new RSRuntimeException("Error loading libRSSupport library for Incremental Intrinsic Support");
                    }
                } catch (UnsatisfiedLinkError e) {
                    "Error loading RS Compat library for Incremental Intrinsic Support: " + e;
                    throw new RSRuntimeException("Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                }
            }
            if (this.mIncCon == 0) {
                this.mIncCon = nIncContextCreate(nIncDeviceCreate(), 0, 0, 0);
            }
            return rsnScriptIntrinsicCreate(this.mIncCon, i2, j, z);
        } else {
            throw new RSRuntimeException("Incremental Intrinsics are not supported before Lollipop (API 21)");
        }
    }

    public synchronized void nScriptInvoke(long j, int i2, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvoke(j2, j, i2, z);
    }

    public synchronized long nScriptInvokeIDCreate(long j, int i2) {
        validate();
        return rsnScriptInvokeIDCreate(this.mContext, j, i2);
    }

    public synchronized void nScriptInvokeV(long j, int i2, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvokeV(j2, j, i2, bArr, z);
    }

    public synchronized long nScriptKernelIDCreate(long j, int i2, int i3, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptKernelIDCreate(j2, j, i2, i3, z);
    }

    public synchronized void nScriptReduce(long j, int i2, long[] jArr, long j2, int[] iArr) {
        synchronized (this) {
            validate();
            rsnScriptReduce(this.mContext, j, i2, jArr, j2, iArr);
        }
    }

    public synchronized void nScriptSetTimeZone(long j, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetTimeZone(j2, j, bArr, z);
    }

    public synchronized void nScriptSetVarD(long j, int i2, double d, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarD(j2, j, i2, d, z);
    }

    public synchronized void nScriptSetVarF(long j, int i2, float f, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarF(j2, j, i2, f, z);
    }

    public synchronized void nScriptSetVarI(long j, int i2, int i3, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarI(j2, j, i2, i3, z);
    }

    public synchronized void nScriptSetVarJ(long j, int i2, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarJ(j3, j, i2, j2, z);
    }

    public synchronized void nScriptSetVarObj(long j, int i2, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarObj(j3, j, i2, j2, z);
    }

    public synchronized void nScriptSetVarV(long j, int i2, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarV(j2, j, i2, bArr, z);
    }

    public synchronized void nScriptSetVarVE(long j, int i2, byte[] bArr, long j2, int[] iArr, boolean z) {
        synchronized (this) {
            validate();
            long j3 = this.mContext;
            if (z) {
                j3 = this.mIncCon;
            }
            rsnScriptSetVarVE(j3, j, i2, bArr, j2, iArr, z);
        }
    }

    public synchronized long nTypeCreate(long j, int i2, int i3, int i4, boolean z, boolean z2, int i5) {
        long rsnTypeCreate;
        synchronized (this) {
            validate();
            rsnTypeCreate = rsnTypeCreate(this.mContext, j, i2, i3, i4, z, z2, i5);
        }
        return rsnTypeCreate;
    }

    public synchronized void nTypeGetNativeData(long j, long[] jArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, j, jArr);
    }

    public native void rsnAllocationCopyFromBitmap(long j, long j2, Bitmap bitmap);

    public native void rsnAllocationCopyToBitmap(long j, long j2, Bitmap bitmap);

    public native long rsnAllocationCreateBitmapBackedAllocation(long j, long j2, int i2, Bitmap bitmap, int i3);

    public native long rsnAllocationCreateBitmapRef(long j, long j2, Bitmap bitmap);

    public native long rsnAllocationCreateFromAssetStream(long j, int i2, int i3, int i4);

    public native long rsnAllocationCreateFromBitmap(long j, long j2, int i2, Bitmap bitmap, int i3);

    public native long rsnAllocationCreateTyped(long j, long j2, int i2, int i3, long j3);

    public native long rsnAllocationCubeCreateFromBitmap(long j, long j2, int i2, Bitmap bitmap, int i3);

    public native void rsnAllocationData1D(long j, long j2, int i2, int i3, int i4, Object obj, int i5, int i6, int i7, boolean z);

    public native void rsnAllocationData2D(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, int i9, int i10, int i11);

    public native void rsnAllocationData2D(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9, int i10, boolean z);

    public native void rsnAllocationData2D(long j, long j2, int i2, int i3, int i4, int i5, Bitmap bitmap);

    public native void rsnAllocationData3D(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j3, int i9, int i10, int i11, int i12);

    public native void rsnAllocationData3D(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj, int i9, int i10, int i11, boolean z);

    public native void rsnAllocationElementData1D(long j, long j2, int i2, int i3, int i4, byte[] bArr, int i5);

    public native void rsnAllocationGenerateMipmaps(long j, long j2);

    public native ByteBuffer rsnAllocationGetByteBuffer(long j, long j2, int i2, int i3, int i4);

    public native long rsnAllocationGetStride(long j, long j2);

    public native long rsnAllocationGetType(long j, long j2);

    public native void rsnAllocationIoReceive(long j, long j2);

    public native void rsnAllocationIoSend(long j, long j2);

    public native void rsnAllocationRead(long j, long j2, Object obj, int i2, int i3, boolean z);

    public native void rsnAllocationRead1D(long j, long j2, int i2, int i3, int i4, Object obj, int i5, int i6, int i7, boolean z);

    public native void rsnAllocationRead2D(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9, int i10, boolean z);

    public native void rsnAllocationResize1D(long j, long j2, int i2);

    public native void rsnAllocationResize2D(long j, long j2, int i2, int i3);

    public native void rsnAllocationSetSurface(long j, long j2, Surface surface);

    public native void rsnAllocationSyncAll(long j, long j2, int i2);

    public native long rsnClosureCreate(long j, long j2, long j3, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4);

    public native void rsnClosureSetArg(long j, long j2, int i2, long j3, int i3);

    public native void rsnClosureSetGlobal(long j, long j2, long j3, long j4, int i2);

    public native long rsnContextCreate(long j, int i2, int i3, int i4, String str);

    public native void rsnContextDestroy(long j);

    public native void rsnContextDump(long j, int i2);

    public native void rsnContextFinish(long j);

    public native void rsnContextSendMessage(long j, int i2, int[] iArr);

    public native void rsnContextSetPriority(long j, int i2);

    public native long rsnElementCreate(long j, long j2, int i2, boolean z, int i3);

    public native long rsnElementCreate2(long j, long[] jArr, String[] strArr, int[] iArr);

    public native void rsnElementGetNativeData(long j, long j2, int[] iArr);

    public native void rsnElementGetSubElements(long j, long j2, long[] jArr, String[] strArr, int[] iArr);

    public native long rsnIncAllocationCreateTyped(long j, long j2, long j3, long j4, int i2);

    public native long rsnIncContextCreate(long j, int i2, int i3, int i4);

    public native void rsnIncContextDestroy(long j);

    public native void rsnIncContextFinish(long j);

    public native long rsnIncElementCreate(long j, long j2, int i2, boolean z, int i3);

    public native void rsnIncObjDestroy(long j, long j2);

    public native long rsnIncTypeCreate(long j, long j2, int i2, int i3, int i4, boolean z, boolean z2, int i5);

    public native long rsnInvokeClosureCreate(long j, long j2, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr);

    public native void rsnObjDestroy(long j, long j2);

    public native long rsnSamplerCreate(long j, int i2, int i3, int i4, int i5, int i6, float f);

    public native void rsnScriptBindAllocation(long j, long j2, long j3, int i2, boolean z);

    public native long rsnScriptCCreate(long j, String str, String str2, byte[] bArr, int i2);

    public native long rsnScriptFieldIDCreate(long j, long j2, int i2, boolean z);

    public native void rsnScriptForEach(long j, long j2, int i2, long[] jArr, long j3, byte[] bArr, int[] iArr);

    public native void rsnScriptForEach(long j, long j2, long j3, int i2, long j4, long j5, boolean z);

    public native void rsnScriptForEach(long j, long j2, long j3, int i2, long j4, long j5, byte[] bArr, boolean z);

    public native void rsnScriptForEachClipped(long j, long j2, long j3, int i2, long j4, long j5, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    public native void rsnScriptForEachClipped(long j, long j2, long j3, int i2, long j4, long j5, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    public native long rsnScriptGroup2Create(long j, String str, String str2, long[] jArr);

    public native void rsnScriptGroup2Execute(long j, long j2);

    public native long rsnScriptGroupCreate(long j, long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5);

    public native void rsnScriptGroupExecute(long j, long j2);

    public native void rsnScriptGroupSetInput(long j, long j2, long j3, long j4);

    public native void rsnScriptGroupSetOutput(long j, long j2, long j3, long j4);

    public native void rsnScriptIntrinsicBLAS_BNNM(long j, long j2, long j3, int i2, int i3, int i4, long j4, int i5, long j5, int i6, long j6, int i7, int i8, boolean z);

    public native void rsnScriptIntrinsicBLAS_Complex(long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, float f2, long j4, long j5, float f3, float f4, long j6, int i11, int i12, int i13, int i14, boolean z);

    public native void rsnScriptIntrinsicBLAS_Double(long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, double d, long j4, long j5, double d2, long j6, int i11, int i12, int i13, int i14, boolean z);

    public native void rsnScriptIntrinsicBLAS_Single(long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, long j4, long j5, float f2, long j6, int i11, int i12, int i13, int i14, boolean z);

    public native void rsnScriptIntrinsicBLAS_Z(long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, double d, double d2, long j4, long j5, double d3, double d4, long j6, int i11, int i12, int i13, int i14, boolean z);

    public native long rsnScriptIntrinsicCreate(long j, int i2, long j2, boolean z);

    public native void rsnScriptInvoke(long j, long j2, int i2, boolean z);

    public native long rsnScriptInvokeIDCreate(long j, long j2, int i2);

    public native void rsnScriptInvokeV(long j, long j2, int i2, byte[] bArr, boolean z);

    public native long rsnScriptKernelIDCreate(long j, long j2, int i2, int i3, boolean z);

    public native void rsnScriptReduce(long j, long j2, int i2, long[] jArr, long j3, int[] iArr);

    public native void rsnScriptSetTimeZone(long j, long j2, byte[] bArr, boolean z);

    public native void rsnScriptSetVarD(long j, long j2, int i2, double d, boolean z);

    public native void rsnScriptSetVarF(long j, long j2, int i2, float f, boolean z);

    public native void rsnScriptSetVarI(long j, long j2, int i2, int i3, boolean z);

    public native void rsnScriptSetVarJ(long j, long j2, int i2, long j3, boolean z);

    public native void rsnScriptSetVarObj(long j, long j2, int i2, long j3, boolean z);

    public native void rsnScriptSetVarV(long j, long j2, int i2, byte[] bArr, boolean z);

    public native void rsnScriptSetVarVE(long j, long j2, int i2, byte[] bArr, long j3, int[] iArr, boolean z);

    public native long rsnTypeCreate(long j, long j2, int i2, int i3, int i4, boolean z, boolean z2, int i5);

    public native void rsnTypeGetNativeData(long j, long j2, long[] jArr);

    public long safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0;
    }

    public void sendMessage(int i2, int[] iArr) {
        nContextSendMessage(i2, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    public boolean usingIO() {
        return useIOlib;
    }

    public void validate() {
        if (this.mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    public void validateObject(BaseObj baseObj) {
        if (baseObj != null && baseObj.mRS != this) {
            throw new RSIllegalArgumentException("Attempting to use an object across contexts.");
        }
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, contextType, 0);
    }

    public static RenderScript create(Context context, ContextType contextType, int i2) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, i2);
    }

    public synchronized void nAllocationData2D(long j, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, Element.DataType dataType, int i9, boolean z) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID, i9, z);
        }
    }

    public synchronized void nAllocationData3D(long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj, int i9, Element.DataType dataType, int i10, boolean z) {
        synchronized (this) {
            validate();
            rsnAllocationData3D(this.mContext, j, i2, i3, i4, i5, i6, i7, i8, obj, i9, dataType.mID, i10, z);
        }
    }

    public static RenderScript create(Context context, int i2) {
        return create(context, i2, ContextType.NORMAL, 0);
    }

    public synchronized void nScriptForEach(long j, int i2, long[] jArr, long j2, byte[] bArr, int[] iArr) {
        synchronized (this) {
            if (this.mEnableMultiInput) {
                validate();
                rsnScriptForEach(this.mContext, j, i2, jArr, j2, bArr, iArr);
            } else {
                throw new RSRuntimeException("Multi-input kernels are not supported before API 23)");
            }
        }
    }

    public static RenderScript create(Context context, int i2, ContextType contextType) {
        return create(context, i2, contextType, 0);
    }

    public static RenderScript create(Context context, int i2, ContextType contextType, int i3) {
        synchronized (mProcessContextList) {
            Iterator<RenderScript> it = mProcessContextList.iterator();
            while (it.hasNext()) {
                RenderScript next = it.next();
                if (next.mContextType == contextType && next.mContextFlags == i3 && next.mContextSdkVersion == i2) {
                    return next;
                }
            }
            RenderScript internalCreate = internalCreate(context, i2, contextType, i3);
            internalCreate.mIsProcessContext = true;
            mProcessContextList.add(internalCreate);
            return internalCreate;
        }
    }

    public synchronized void nAllocationData2D(long j, int i2, int i3, int i4, int i5, Bitmap bitmap) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i2, i3, i4, i5, bitmap);
        }
    }
}
