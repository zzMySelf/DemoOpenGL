package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    @VisibleForTesting
    public static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    @VisibleForTesting
    public static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    @VisibleForTesting
    public static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    @VisibleForTesting
    public static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    @VisibleForTesting
    public static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    @VisibleForTesting
    public static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    @VisibleForTesting
    public static final int REQUEST_EXTERNAL_IMAGE_STORAGE_PERMISSION = 2344;
    @VisibleForTesting
    public static final int REQUEST_EXTERNAL_VIDEO_STORAGE_PERMISSION = 2354;
    public final Activity activity;
    public final ImagePickerCache cache;
    public CameraDevice cameraDevice;
    public final File externalFilesDirectory;
    @VisibleForTesting
    public final String fileProviderName;
    public final FileUriResolver fileUriResolver;
    public final FileUtils fileUtils;
    public final ImageResizer imageResizer;
    public final IntentResolver intentResolver;
    public MethodCall methodCall;
    public Uri pendingCameraMediaUri;
    public MethodChannel.Result pendingResult;
    public final PermissionManager permissionManager;

    public interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    public interface IntentResolver {
        boolean resolveActivity(Intent intent);
    }

    public interface OnPathReadyListener {
        void onPathReady(String str);
    }

    public interface PermissionManager {
        void askForPermission(String str, int i2);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(final Activity activity2, File file, ImageResizer imageResizer2, ImagePickerCache imagePickerCache) {
        this(activity2, file, imageResizer2, (MethodChannel.Result) null, (MethodCall) null, imagePickerCache, new PermissionManager() {
            public void askForPermission(String str, int i2) {
                Activity activity = activity2;
                if (activity != null) {
                    ActivityCompat.requestPermissions(activity, new String[]{str}, i2);
                }
            }

            public boolean isPermissionGranted(String str) {
                Activity activity = activity2;
                if (activity != null && ContextCompat.checkSelfPermission(activity, str) == 0) {
                    return true;
                }
                return false;
            }

            public boolean needRequestCameraPermission() {
                Activity activity = activity2;
                if (activity == null) {
                    return false;
                }
                return ImagePickerUtils.needRequestCameraPermission(activity);
            }
        }, new IntentResolver() {
            public boolean resolveActivity(Intent intent) {
                Activity activity = activity2;
                if (activity == null || intent.resolveActivity(activity.getPackageManager()) == null) {
                    return false;
                }
                return true;
            }
        }, new FileUriResolver() {
            public void getFullImagePath(Uri uri, final OnPathReadyListener onPathReadyListener) {
                Activity activity = activity2;
                if (activity != null) {
                    String[] strArr = new String[1];
                    strArr[0] = uri != null ? uri.getPath() : "";
                    MediaScannerConnection.scanFile(activity, strArr, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String str, Uri uri) {
                            onPathReadyListener.onPathReady(str);
                        }
                    });
                }
            }

            public Uri resolveFileProviderUriForFile(String str, File file) {
                Activity activity = activity2;
                if (activity == null) {
                    return null;
                }
                return FileProvider.getUriForFile(activity, str, file);
            }
        }, new FileUtils());
    }

    private void clearMethodCallAndResult() {
        this.methodCall = null;
        this.pendingResult = null;
    }

    private File createTemporaryWritableFile(String str) {
        try {
            return File.createTempFile(UUID.randomUUID().toString().replace("-", ""), str, this.externalFilesDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private void finishWithAlreadyActiveError(MethodChannel.Result result) {
        result.error("already_active", "Image picker is already active", (Object) null);
    }

    private void finishWithError(String str, String str2) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            ImagePickerCache imagePickerCache = this.cache;
            if (imagePickerCache != null) {
                imagePickerCache.saveResult((String) null, str, str2);
                return;
            }
            return;
        }
        result.error(str, str2, (Object) null);
        clearMethodCallAndResult();
    }

    private void finishWithSuccess(String str) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            this.cache.saveResult(str, (String) null, (String) null);
            return;
        }
        result.success(str);
        clearMethodCallAndResult();
    }

    private void grantUriPermissions(Intent intent, Uri uri) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            for (ResolveInfo resolveInfo : activity2.getPackageManager().queryIntentActivities(intent, 65536)) {
                this.activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
            }
        }
    }

    private void handleCaptureImageResult(int i2) {
        FileUriResolver fileUriResolver2;
        ImagePickerCache imagePickerCache;
        if (i2 != -1 || (fileUriResolver2 = this.fileUriResolver) == null || (imagePickerCache = this.cache) == null) {
            finishWithSuccess((String) null);
            return;
        }
        Uri uri = this.pendingCameraMediaUri;
        if (uri == null) {
            uri = Uri.parse(imagePickerCache.retrievePendingCameraMediaUriPath());
        }
        fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
            public void onPathReady(String str) {
                ImagePickerDelegate.this.handleImageResult(str, true);
            }
        });
    }

    private void handleCaptureVideoResult(int i2) {
        ImagePickerCache imagePickerCache;
        FileUriResolver fileUriResolver2;
        if (i2 != -1 || (imagePickerCache = this.cache) == null || (fileUriResolver2 = this.fileUriResolver) == null) {
            finishWithSuccess((String) null);
            return;
        }
        Uri uri = this.pendingCameraMediaUri;
        if (uri == null) {
            uri = Uri.parse(imagePickerCache.retrievePendingCameraMediaUriPath());
        }
        fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
            public void onPathReady(String str) {
                ImagePickerDelegate.this.handleVideoResult(str);
            }
        });
    }

    private void handleChooseImageResult(int i2, Intent intent) {
        Activity activity2;
        FileUtils fileUtils2;
        if (i2 != -1 || intent == null || (activity2 = this.activity) == null || (fileUtils2 = this.fileUtils) == null) {
            finishWithSuccess((String) null);
        } else {
            handleImageResult(fileUtils2.getPathFromUri(activity2, intent.getData()), false);
        }
    }

    private void handleChooseVideoResult(int i2, Intent intent) {
        Activity activity2;
        FileUtils fileUtils2;
        if (i2 != -1 || intent == null || (activity2 = this.activity) == null || (fileUtils2 = this.fileUtils) == null) {
            finishWithSuccess((String) null);
        } else {
            handleVideoResult(fileUtils2.getPathFromUri(activity2, intent.getData()));
        }
    }

    /* access modifiers changed from: private */
    public void handleImageResult(String str, boolean z) {
        int i2;
        String str2;
        MethodCall methodCall2 = this.methodCall;
        if (methodCall2 == null || this.imageResizer == null) {
            finishWithSuccess(str);
            return;
        }
        Integer num = (Integer) methodCall2.argument("minLength");
        Integer num2 = (Integer) this.methodCall.argument("maxLength");
        Double d = (Double) this.methodCall.argument(ImagePickerCache.MAP_KEY_MAX_WIDTH);
        Double d2 = (Double) this.methodCall.argument(ImagePickerCache.MAP_KEY_MAX_HEIGHT);
        if (this.methodCall.argument(ImagePickerCache.MAP_KEY_IMAGE_QUALITY) == null) {
            i2 = 100;
        } else {
            i2 = ((Integer) this.methodCall.argument(ImagePickerCache.MAP_KEY_IMAGE_QUALITY)).intValue();
        }
        if (num == null || num2 == null) {
            str2 = this.imageResizer.resizeImageIfNeeded(str, d, d2, Integer.valueOf(i2));
        } else {
            str2 = this.imageResizer.resizeImageWithLengthLimitIfNeeded(str, num.intValue(), num2.intValue(), i2);
        }
        finishWithSuccess(str2);
        if (str2 != null && !str2.equals(str) && z) {
            new File(str).delete();
        }
    }

    /* access modifiers changed from: private */
    public void handleVideoResult(String str) {
        finishWithSuccess(str);
    }

    private void launchPickImageFromGalleryIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivityForResult(intent, REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY);
        }
    }

    private void launchPickVideoFromGalleryIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivityForResult(intent, REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY);
        }
    }

    private void launchTakeImageWithCameraIntent() {
        if (this.intentResolver != null && this.fileUriResolver != null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (this.cameraDevice == CameraDevice.FRONT) {
                useFrontCamera(intent);
            }
            if (!this.intentResolver.resolveActivity(intent)) {
                finishWithError("no_available_camera", "No cameras available for taking pictures.");
                return;
            }
            File createTemporaryWritableImageFile = createTemporaryWritableImageFile();
            this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableImageFile.getAbsolutePath());
            Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, createTemporaryWritableImageFile);
            intent.putExtra("output", resolveFileProviderUriForFile);
            grantUriPermissions(intent, resolveFileProviderUriForFile);
            Activity activity2 = this.activity;
            if (activity2 != null) {
                activity2.startActivityForResult(intent, REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA);
            }
        }
    }

    private void launchTakeVideoWithCameraIntent() {
        if (this.intentResolver != null && this.pendingCameraMediaUri != null && this.activity != null && this.fileUriResolver != null) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            MethodCall methodCall2 = this.methodCall;
            if (!(methodCall2 == null || methodCall2.argument("maxDuration") == null)) {
                intent.putExtra("android.intent.extra.durationLimit", ((Integer) this.methodCall.argument("maxDuration")).intValue());
            }
            if (this.cameraDevice == CameraDevice.FRONT) {
                useFrontCamera(intent);
            }
            if (!this.intentResolver.resolveActivity(intent)) {
                finishWithError("no_available_camera", "No cameras available for taking pictures.");
                return;
            }
            File createTemporaryWritableVideoFile = createTemporaryWritableVideoFile();
            this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableVideoFile.getAbsolutePath());
            Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, createTemporaryWritableVideoFile);
            intent.putExtra("output", resolveFileProviderUriForFile);
            grantUriPermissions(intent, resolveFileProviderUriForFile);
            this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA);
        }
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager2 = this.permissionManager;
        if (permissionManager2 == null) {
            return false;
        }
        return permissionManager2.needRequestCameraPermission();
    }

    private boolean setPendingMethodCallAndResult(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.methodCall = methodCall2;
        this.pendingResult = result;
        ImagePickerCache imagePickerCache = this.cache;
        if (imagePickerCache == null) {
            return true;
        }
        imagePickerCache.clear();
        return true;
    }

    private void useFrontCamera(Intent intent) {
        if (Build.VERSION.SDK_INT >= 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                return;
            }
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }

    public void chooseImageFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.permissionManager == null || !setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!this.permissionManager.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionManager.askForPermission("android.permission.READ_EXTERNAL_STORAGE", REQUEST_EXTERNAL_IMAGE_STORAGE_PERMISSION);
        } else {
            launchPickImageFromGalleryIntent();
        }
    }

    public void chooseVideoFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.permissionManager == null || !setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!this.permissionManager.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionManager.askForPermission("android.permission.READ_EXTERNAL_STORAGE", REQUEST_EXTERNAL_VIDEO_STORAGE_PERMISSION);
        } else {
            launchPickVideoFromGalleryIntent();
        }
    }

    public CameraDevice getCameraDevice() {
        return this.cameraDevice;
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 2342) {
            handleChooseImageResult(i3, intent);
            return true;
        } else if (i2 == 2343) {
            handleCaptureImageResult(i3);
            return true;
        } else if (i2 == 2352) {
            handleChooseVideoResult(i3, intent);
            return true;
        } else if (i2 != 2353) {
            return false;
        } else {
            handleCaptureVideoResult(i3);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r6 != 2355) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onRequestPermissionsResult(int r6, java.lang.String[] r7, int[] r8) {
        /*
            r5 = this;
            int r7 = r8.length
            r0 = 1
            r1 = 0
            if (r7 <= 0) goto L_0x000b
            r7 = r8[r1]
            if (r7 != 0) goto L_0x000b
            r7 = 1
            goto L_0x000c
        L_0x000b:
            r7 = 0
        L_0x000c:
            r8 = 2355(0x933, float:3.3E-42)
            r2 = 2354(0x932, float:3.299E-42)
            r3 = 2345(0x929, float:3.286E-42)
            r4 = 2344(0x928, float:3.285E-42)
            if (r6 == r4) goto L_0x002f
            if (r6 == r3) goto L_0x0029
            if (r6 == r2) goto L_0x0023
            if (r6 == r8) goto L_0x001d
            return r1
        L_0x001d:
            if (r7 == 0) goto L_0x0034
            r5.launchTakeVideoWithCameraIntent()
            goto L_0x0034
        L_0x0023:
            if (r7 == 0) goto L_0x0034
            r5.launchPickVideoFromGalleryIntent()
            goto L_0x0034
        L_0x0029:
            if (r7 == 0) goto L_0x0034
            r5.launchTakeImageWithCameraIntent()
            goto L_0x0034
        L_0x002f:
            if (r7 == 0) goto L_0x0034
            r5.launchPickImageFromGalleryIntent()
        L_0x0034:
            if (r7 != 0) goto L_0x004e
            if (r6 == r4) goto L_0x0047
            if (r6 == r3) goto L_0x003f
            if (r6 == r2) goto L_0x0047
            if (r6 == r8) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            java.lang.String r6 = "camera_access_denied"
            java.lang.String r7 = "The user did not allow camera access."
            r5.finishWithError(r6, r7)
            goto L_0x004e
        L_0x0047:
            java.lang.String r6 = "photo_access_denied"
            java.lang.String r7 = "The user did not allow photo access."
            r5.finishWithError(r6, r7)
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.onRequestPermissionsResult(int, java.lang.String[], int[]):boolean");
    }

    public void retrieveLostImage(MethodChannel.Result result) {
        int i2;
        ImagePickerCache imagePickerCache = this.cache;
        if (imagePickerCache != null) {
            Map<String, Object> cacheMap = imagePickerCache.getCacheMap();
            String str = (String) cacheMap.get("path");
            if (str != null) {
                Double d = (Double) cacheMap.get(ImagePickerCache.MAP_KEY_MAX_WIDTH);
                Double d2 = (Double) cacheMap.get(ImagePickerCache.MAP_KEY_MAX_HEIGHT);
                if (cacheMap.get(ImagePickerCache.MAP_KEY_IMAGE_QUALITY) == null) {
                    i2 = 100;
                } else {
                    i2 = ((Integer) cacheMap.get(ImagePickerCache.MAP_KEY_IMAGE_QUALITY)).intValue();
                }
                cacheMap.put("path", this.imageResizer.resizeImageIfNeeded(str, d, d2, Integer.valueOf(i2)));
            }
            if (cacheMap.isEmpty()) {
                result.success((Object) null);
            } else {
                result.success(cacheMap);
            }
            this.cache.clear();
        }
    }

    public void saveStateBeforeResult() {
        ImagePickerCache imagePickerCache;
        MethodCall methodCall2 = this.methodCall;
        if (methodCall2 != null && (imagePickerCache = this.cache) != null && this.pendingCameraMediaUri != null) {
            imagePickerCache.saveTypeWithMethodCallName(methodCall2.method);
            this.cache.saveDimensionWithMethodCall(this.methodCall);
            Uri uri = this.pendingCameraMediaUri;
            if (uri != null) {
                this.cache.savePendingCameraMediaUriPath(uri);
            }
        }
    }

    public void setCameraDevice(CameraDevice cameraDevice2) {
        this.cameraDevice = cameraDevice2;
    }

    public void takeImageWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.permissionManager == null || !setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeImageWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        }
    }

    public void takeVideoWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.permissionManager == null || !setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeVideoWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        }
    }

    @VisibleForTesting
    public ImagePickerDelegate(Activity activity2, File file, ImageResizer imageResizer2, MethodChannel.Result result, MethodCall methodCall2, ImagePickerCache imagePickerCache, PermissionManager permissionManager2, IntentResolver intentResolver2, FileUriResolver fileUriResolver2, FileUtils fileUtils2) {
        this.activity = activity2;
        this.externalFilesDirectory = file;
        this.imageResizer = imageResizer2;
        this.fileProviderName = activity2.getPackageName() + ".flutter.image_provider";
        this.pendingResult = result;
        this.methodCall = methodCall2;
        this.permissionManager = permissionManager2;
        this.intentResolver = intentResolver2;
        this.fileUriResolver = fileUriResolver2;
        this.fileUtils = fileUtils2;
        this.cache = imagePickerCache;
    }
}
