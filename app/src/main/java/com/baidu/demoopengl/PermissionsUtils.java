package com.baidu.demoopengl;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

import androidx.core.app.ActivityCompat;

/**
 * Day：2023/6/7 10:03
 *
 * @author zhangyelei
 */
public class PermissionsUtils {
    /**
     * 检查权限是否为媒体读取权限，兼容target33 只检查 READ
     * <p>
     * READ_EXTERNAL_STORAGE 需要替换为三个子项，权限颗粒度更细
     */
    public static boolean isReadMediaPermission(Context context, String permission) {
        if (context == null || permission == null) {
            return false;
        }

        boolean result;
        if (checkVersionThanTiramisu(context)) {
            result = TextUtils.equals(permission, Manifest.permission.READ_MEDIA_AUDIO)
                    || TextUtils.equals(permission, Manifest.permission.READ_MEDIA_VIDEO)
                    || TextUtils.equals(permission, Manifest.permission.READ_MEDIA_IMAGES);
        } else {
            result = TextUtils.equals(permission, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        return result;
    }

    /**
     * 检查权限是否为媒体读取权限，兼容target33
     * <p>
     * READ_EXTERNAL_STORAGE 需要替换为三个子项，权限颗粒度更细
     */
    public static boolean isReadMediaPermissionCompat(Context context, String permission) {
        if (context == null || permission == null) {
            return false;
        }

        boolean result;
        if (checkVersionThanTiramisu(context)) {
            result = TextUtils.equals(permission, Manifest.permission.READ_MEDIA_AUDIO)
                    || TextUtils.equals(permission, Manifest.permission.READ_MEDIA_VIDEO)
                    || TextUtils.equals(permission, Manifest.permission.READ_MEDIA_IMAGES);
        } else if (PermissionsUtils.checkVersionThanR(context)) {
            // 版本大于30 Android11 Android12
            result = TextUtils.equals(permission, Manifest.permission.READ_EXTERNAL_STORAGE);
        } else {
            result = TextUtils.equals(permission, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        return result;
    }

    /**
     * 判断Android 版本大于14
     */
    public static boolean checkVersionThanUpsideDownCake() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE;
    }

    /**
     * 判断自身库targetSdkVersion以及宿主App的targetSdkVersion 大于等于33 Android13
     */
    public static boolean checkVersionThanTiramisu(Context context) {
        return context != null
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
                && context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.TIRAMISU;
    }

    /**
     * 判断自身库targetSdkVersion以及宿主App的targetSdkVersion 大于等于30 Android11
     */
    public static boolean checkVersionThanR(Context context) {
        return context != null
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R
                && context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.R;
    }

    /**
     * 获取媒体读取权限，兼容target33
     */
    public static String[] getCompatReadPermissions(Context context) {
        if (context == null) {
            return new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        }

        String[] result;
        if (checkVersionThanTiramisu(context)) {
            result = new String[]{Manifest.permission.READ_MEDIA_AUDIO,
                    Manifest.permission.READ_MEDIA_VIDEO,
                    Manifest.permission.READ_MEDIA_IMAGES};
        } else {
            result = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        }
        return result;
    }

    /**
     * @param context               上下文
     * @param storagePermissionType 读取权限的类型
     * @return 根据版本以及类型返回单个或者组合权限
     */
    public static String[] getCompatStoragePermissions(
            Context context,
            StoragePermissionType storagePermissionType) {
        String[] permissions;
        if (PermissionsUtils.checkVersionThanTiramisu(context)) {
            // 版本大于33 Android13
            if (storagePermissionType == null) {
                storagePermissionType = StoragePermissionType.ALL;
            }
            switch (storagePermissionType) {
                case IMAGES: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_IMAGES};
                    break;
                }
                case VIDEO: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_VIDEO};
                    break;
                }
                case AUDIO: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_AUDIO};
                    break;
                }
                case IMAGES_AND_VIDEO: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_VIDEO};
                    break;
                }
                case IMAGES_AND_AUDIO: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_AUDIO};
                    break;
                }
                case VIDEO_AND_AUDIO: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_VIDEO,
                            Manifest.permission.READ_MEDIA_AUDIO};
                    break;
                }
                case ALL: {
                    permissions = new String[]{Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_VIDEO,
                            Manifest.permission.READ_MEDIA_AUDIO};
                    break;
                }
                default:
                    permissions = new String[]{Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_VIDEO};
                    break;
            }
        } else if (PermissionsUtils.checkVersionThanR(context)) {
            // 版本大于30 Android11 Android12
            permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        } else {
            permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        }
        return permissions;
    }

    /**
     * 判断单个权限是否授权
     */
    public static boolean permissionGranted(Context context, String permission) {
        if (context == null || permission == null) {
            return false;
        }

        return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * @param context               上下文
     * @param storagePermissionType 读取权限的类型
     * @return 根据版本以及权限类型，判断是否有权限 true:有权限  false:无权限
     */
    public static boolean checkCompatStoragePermissionGranted(
            Context context,
            StoragePermissionType storagePermissionType) {
        boolean isPermissionGranted =  false;

        boolean isMediaPermission = storagePermissionType == StoragePermissionType.IMAGES
                || storagePermissionType == StoragePermissionType.VIDEO
                || storagePermissionType == StoragePermissionType.IMAGES_AND_VIDEO;
        // 判断是否为照片视频权限请求 并且版本大于Android14
        if (isMediaPermission && checkVersionThanUpsideDownCake()) {
            switch (storagePermissionType) {
                case IMAGES: {
                    // 先校验完整权限，如果拒绝再校验部分权限
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    if (!isImageGranted) {
                        isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
                    }
                    isPermissionGranted = isImageGranted;
                    break;
                }
                case VIDEO: {
                    // 先校验完整权限，如果拒绝再校验部分权限
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    if (!isVideoGranted) {
                        isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
                    }
                    isPermissionGranted = isVideoGranted;
                    break;
                }
                case IMAGES_AND_VIDEO: {
                    // 图片和视频必须全部同意， 或者部分同意
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    boolean isUserSelectedGranted = permissionGranted(context,
                            Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
                    isPermissionGranted = (isImageGranted && isVideoGranted) || isUserSelectedGranted;
                    break;
                }
            }
        } else if (PermissionsUtils.checkVersionThanTiramisu(context)) {
            // 版本大于33 Android13
            if (storagePermissionType == null) {
                storagePermissionType = StoragePermissionType.ALL;
            }
            switch (storagePermissionType) {
                case IMAGES: {
                    isPermissionGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    break;
                }
                case VIDEO: {
                    isPermissionGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    break;
                }
                case AUDIO: {
                    isPermissionGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_AUDIO);
                    break;
                }
                case IMAGES_AND_VIDEO: {
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    isPermissionGranted = isImageGranted && isVideoGranted;
                    break;
                }
                case IMAGES_AND_AUDIO: {
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    boolean isAudioGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_AUDIO);
                    isPermissionGranted = isImageGranted && isAudioGranted;
                    break;
                }
                case VIDEO_AND_AUDIO: {
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    boolean isAudioGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_AUDIO);
                    isPermissionGranted = isVideoGranted && isAudioGranted;
                    break;
                }
                case ALL: {
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    boolean isAudioGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_AUDIO);
                    isPermissionGranted = isImageGranted && isVideoGranted && isAudioGranted;
                    break;
                }
                default:
                    boolean isImageGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
                    boolean isVideoGranted = permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
                    isPermissionGranted = isImageGranted && isVideoGranted;
                    break;
            }
        } else if (PermissionsUtils.checkVersionThanR(context)) {
            // 版本大于30 Android11 Android12
            isPermissionGranted = permissionGranted(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        } else {
            isPermissionGranted = permissionGranted(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        return isPermissionGranted;
    }

    /**
     * 判断 媒体权限是否通过 兼容Android14
     */
    public static boolean checkReadMediaPermissionGranted(Context context, String permission) {
        if (context == null || TextUtils.isEmpty(permission)) {
            return false;
        }
        // step1 如果不是媒体权限 直接返回系统权限判断
        boolean isReadMedia = isReadMediaPermission(context, permission);
        if (!isReadMedia) {
            return permissionGranted(context, permission);
        }
        // step2 如果不是Android14 直接返回系统权限判断
        boolean isAndroid14 = checkVersionThanUpsideDownCake();
        if (!isAndroid14) {
            return permissionGranted(context, permission);
        }
        // step2 如果完整的权限通过了，则直接返回
        boolean parentGranted = permissionGranted(context, permission);
        if (parentGranted) {
            return true;
        }
        // 已经通过版本判断 直接校验
        return permissionGranted(context, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
    }

    /**
     * 判断用户是不是 只允许选择部分图片 只有Android 14版本以上才有
     */
    public static boolean isOnlyReadUserSelectedImage(Context context) {
        if (context == null) {
            return false;
        }

        boolean isAndroid14 = PermissionsUtils.checkVersionThanUpsideDownCake();
        if (!isAndroid14) {
            return false;
        }

        boolean isImageGranted = PermissionsUtils.permissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES);
        if (isImageGranted) {
            return false;
        }
        return PermissionsUtils.permissionGranted(context, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
    }

    /**
     * 判断用户是不是 只允许选择部分视频 只有Android 14版本以上才有
     */
    public static boolean isOnlyReadUserSelectedVideo(Context context) {
        if (context == null) {
            return false;
        }

        boolean isAndroid14 = PermissionsUtils.checkVersionThanUpsideDownCake();
        if (!isAndroid14) {
            return false;
        }

        boolean isVideoGranted = PermissionsUtils.permissionGranted(context, Manifest.permission.READ_MEDIA_VIDEO);
        if (isVideoGranted) {
            return false;
        }
        return PermissionsUtils.permissionGranted(context, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED);
    }
}

