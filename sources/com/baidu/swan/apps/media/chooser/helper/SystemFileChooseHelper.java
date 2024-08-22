package com.baidu.swan.apps.media.chooser.helper;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppImageUtils;
import com.baidu.swan.apps.util.SwanAppThreadUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/swan/apps/media/chooser/helper/SystemFileChooseHelper;", "", "()V", "DEBUG", "", "DEFAULT_BINARY_MIME", "", "ERROR_MSG_COPY_ERROR", "ERROR_MSG_USER_CANCEL", "ERR_CODE_COPY_ERROR", "", "ERR_CODE_USER_CANCEL", "FILE_DISPLAY_NAME", "IMAGE_MIME", "TAG", "chooseFile", "", "callback", "Lcom/baidu/swan/apps/util/typedbox/TypedCallback;", "Lcom/baidu/swan/apps/media/chooser/helper/SystemFileChooseHelper$FileChooseModel;", "chooseFileByIntent", "intent", "Landroid/content/Intent;", "chooseImage", "getFileDisplayName", "resolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "saveFileListFromIntent", "data", "FileChooseModel", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SystemFileChooseHelper.kt */
public final class SystemFileChooseHelper {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DEFAULT_BINARY_MIME = "*/*";
    public static final String ERROR_MSG_COPY_ERROR = "选择文件失败：文件读写失败";
    public static final String ERROR_MSG_USER_CANCEL = "选择文件失败：用户取消操作";
    public static final int ERR_CODE_COPY_ERROR = 1003;
    public static final int ERR_CODE_USER_CANCEL = 1002;
    private static final String FILE_DISPLAY_NAME = "_display_name";
    private static final String IMAGE_MIME = "image/*";
    public static final SystemFileChooseHelper INSTANCE = new SystemFileChooseHelper();
    private static final String TAG = "SystemFileChooseHelper";

    private SystemFileChooseHelper() {
    }

    public final void chooseImage(TypedCallback<FileChooseModel> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        chooseFileByIntent(intent, callback);
    }

    public final void chooseFile(TypedCallback<FileChooseModel> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType(DEFAULT_BINARY_MIME);
        chooseFileByIntent(intent, callback);
    }

    private final void chooseFileByIntent(Intent intent, TypedCallback<FileChooseModel> callback) {
        ISwanFrameContainer swanFrameContainer = Swan.get().getSwanFrameContainer();
        ActivityResultDispatcher dispatcher = swanFrameContainer != null ? swanFrameContainer.getResultDispatcher() : null;
        if (dispatcher == null) {
            callback.onCallback(new FileChooseModel(1001, (String) null, (String) null, (File) null, 14, (DefaultConstructorMarker) null));
            return;
        }
        dispatcher.addConsumer(new SystemFileChooseHelper$$ExternalSyntheticLambda1(callback));
        SwanAppController.getInstance().requestCollectionPolicyStopFlag();
        try {
            dispatcher.startActivityForResult(intent);
        } catch (Exception e2) {
            SwanAppController.getInstance().requestCollectionPolicyContinueFlag();
            callback.onCallback(new FileChooseModel(1001, (String) null, (String) null, (File) null, 14, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: chooseFileByIntent$lambda-1  reason: not valid java name */
    public static final boolean m8035chooseFileByIntent$lambda1(TypedCallback $callback, ActivityResultDispatcher activityResultDispatcher, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        SwanAppController.getInstance().requestCollectionPolicyContinueFlag();
        if (resultCode != -1 || data == null) {
            $callback.onCallback(new FileChooseModel(1002, ERROR_MSG_USER_CANCEL, (String) null, (File) null, 12, (DefaultConstructorMarker) null));
        } else {
            SwanAppThreadUtils.postOnElastic(new SystemFileChooseHelper$$ExternalSyntheticLambda0($callback, data), TAG, 1);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: chooseFileByIntent$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8036chooseFileByIntent$lambda1$lambda0(TypedCallback $callback, Intent $data) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        $callback.onCallback(INSTANCE.saveFileListFromIntent($data));
    }

    /* Debug info: failed to restart local var, previous not found, register: 22 */
    /* JADX INFO: finally extract failed */
    private final FileChooseModel saveFileListFromIntent(Intent data) {
        String name;
        Throwable th2;
        if (data != null) {
            Uri data2 = data.getData();
            if (data2 != null) {
                Uri uri = data2;
                ContentResolver resolver = SwanAppRuntime.getAppContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(resolver, "resolver");
                String name2 = getFileDisplayName(resolver, uri);
                CharSequence charSequence = name2;
                if ((charSequence == null || charSequence.length() == 0) || SwanAppFileUtils.isInvalidPath(name2)) {
                    name = String.valueOf(System.currentTimeMillis());
                } else {
                    name = name2;
                }
                File tempFile = SwanAppImageUtils.getTempFile(SwanAppController.getInstance().getSwanFilePaths().getTmpDirectory(), name);
                try {
                    InputStream openInputStream = resolver.openInputStream(uri);
                    if (openInputStream != null) {
                        Closeable closeable = openInputStream;
                        try {
                            InputStream fileInputStream = (InputStream) closeable;
                            Closeable fileOutputStream = new FileOutputStream(tempFile);
                            try {
                                long copyStream = SwanAppFileUtils.copyStream(fileInputStream, (FileOutputStream) fileOutputStream);
                                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                Long.valueOf(copyStream);
                                CloseableKt.closeFinally(closeable, (Throwable) null);
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                CloseableKt.closeFinally(fileOutputStream, th2);
                                throw th4;
                            }
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                Throwable th8 = th7;
                                CloseableKt.closeFinally(closeable, th6);
                                throw th8;
                            }
                        }
                    }
                    if (DEBUG) {
                        Log.d(TAG, "chooseFile:" + tempFile.getAbsolutePath());
                    }
                    if (!tempFile.exists()) {
                        return new FileChooseModel(1003, ERROR_MSG_COPY_ERROR, (String) null, (File) null, 12, (DefaultConstructorMarker) null);
                    }
                    return new FileChooseModel(0, "", name, tempFile);
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    return new FileChooseModel(1003, ERROR_MSG_COPY_ERROR, (String) null, (File) null, 12, (DefaultConstructorMarker) null);
                }
            }
        }
        return new FileChooseModel(1002, ERROR_MSG_USER_CANCEL, (String) null, (File) null, 12, (DefaultConstructorMarker) null);
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFileDisplayName(android.content.ContentResolver r9, android.net.Uri r10) {
        /*
            r8 = this;
            java.lang.String r0 = "_display_name"
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0038 }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0038 }
            if (r2 == 0) goto L_0x0040
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x0038 }
            r3 = r2
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x0031 }
            r4 = 0
            boolean r5 = r3.moveToFirst()     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x002a
            int r0 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x0031 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0031 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ Exception -> 0x0038 }
            return r0
        L_0x002a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0031 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0040
        L_0x0031:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ Exception -> 0x0038 }
            throw r3     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x0040
            r0.printStackTrace()
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.chooser.helper.SystemFileChooseHelper.getFileDisplayName(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0017J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/baidu/swan/apps/media/chooser/helper/SystemFileChooseHelper$FileChooseModel;", "", "errorCode", "", "errorMessage", "", "fileName", "file", "Ljava/io/File;", "(ILjava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "getFileName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isSuccess", "toString", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SystemFileChooseHelper.kt */
    public static final class FileChooseModel {
        private final int errorCode;
        private final String errorMessage;
        private final File file;
        private final String fileName;

        public static /* synthetic */ FileChooseModel copy$default(FileChooseModel fileChooseModel, int i2, String str, String str2, File file2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = fileChooseModel.errorCode;
            }
            if ((i3 & 2) != 0) {
                str = fileChooseModel.errorMessage;
            }
            if ((i3 & 4) != 0) {
                str2 = fileChooseModel.fileName;
            }
            if ((i3 & 8) != 0) {
                file2 = fileChooseModel.file;
            }
            return fileChooseModel.copy(i2, str, str2, file2);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.errorMessage;
        }

        public final String component3() {
            return this.fileName;
        }

        public final File component4() {
            return this.file;
        }

        public final FileChooseModel copy(int i2, String str, String str2, File file2) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new FileChooseModel(i2, str, str2, file2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileChooseModel)) {
                return false;
            }
            FileChooseModel fileChooseModel = (FileChooseModel) obj;
            return this.errorCode == fileChooseModel.errorCode && Intrinsics.areEqual((Object) this.errorMessage, (Object) fileChooseModel.errorMessage) && Intrinsics.areEqual((Object) this.fileName, (Object) fileChooseModel.fileName) && Intrinsics.areEqual((Object) this.file, (Object) fileChooseModel.file);
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.errorCode) * 31) + this.errorMessage.hashCode()) * 31;
            String str = this.fileName;
            int i2 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            File file2 = this.file;
            if (file2 != null) {
                i2 = file2.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "FileChooseModel(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", fileName=" + this.fileName + ", file=" + this.file + ')';
        }

        public FileChooseModel(int errorCode2, String errorMessage2, String fileName2, File file2) {
            Intrinsics.checkNotNullParameter(errorMessage2, "errorMessage");
            this.errorCode = errorCode2;
            this.errorMessage = errorMessage2;
            this.fileName = fileName2;
            this.file = file2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FileChooseModel(int i2, String str, String str2, File file2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : file2);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final File getFile() {
            return this.file;
        }

        public final boolean isSuccess() {
            return this.errorCode == 0;
        }
    }
}
