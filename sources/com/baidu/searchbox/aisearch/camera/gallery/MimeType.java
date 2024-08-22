package com.baidu.searchbox.aisearch.camera.gallery;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.rtc.nps.plugin.data.RtcParameterSettings;
import com.baidu.searchbox.aisearch.camera.gallery.cursorloader.utils.PhotoMetadataUtilsKt;
import com.baidu.searchbox.ugc.media.MimeType;
import com.baidu.searchbox.ugc.videoupload.VideoUploadConstant;
import com.baidu.swan.apps.canvas.model.CanvasToTempFileModel;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/MimeType;", "", "mMimeTypeName", "", "mExtensions", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;)V", "checkType", "", "resolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "toString", "JPEG", "PNG", "GIF", "BMP", "WEBP", "MPEG", "MP4", "QUICKTIME", "THREEGPP", "THREEGPP2", "MKV", "WEBM", "TS", "AVI", "Companion", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MimeType.kt */
public enum MimeType {
    JPEG("image/jpeg", MimeTypeKt.arraySetOf("jpg", RtcParameterSettings.VideoCodecId.JPEG)),
    PNG(MimeType.Image.PNG, MimeTypeKt.arraySetOf(CanvasToTempFileModel.IMAGE_EXT_PNG)),
    GIF("image/gif", MimeTypeKt.arraySetOf("gif")),
    BMP("image/x-ms-bmp", MimeTypeKt.arraySetOf("bmp")),
    WEBP(MimeType.Image.WEBP, MimeTypeKt.arraySetOf(WebpUtils.TYPE_IMG_WEBP)),
    MPEG(MimeType.Video.MPEG, MimeTypeKt.arraySetOf("mpeg", "mpg")),
    MP4("video/mp4", MimeTypeKt.arraySetOf("mp4", "m4v")),
    QUICKTIME("video/quicktime", MimeTypeKt.arraySetOf("mov")),
    THREEGPP("video/3gpp", MimeTypeKt.arraySetOf("3gp", "3gpp")),
    THREEGPP2("video/3gpp2", MimeTypeKt.arraySetOf("3g2", "3gpp2")),
    MKV(MimeType.Video.MKV, MimeTypeKt.arraySetOf("mkv")),
    WEBM(VideoUploadConstant.CONTAINER_TYPE_WEBM, MimeTypeKt.arraySetOf("webm")),
    TS("video/mp2ts", MimeTypeKt.arraySetOf("ts")),
    AVI(MimeType.Video.AVI, MimeTypeKt.arraySetOf("avi"));
    
    public static final Companion Companion = null;
    private final Set<String> mExtensions;
    private final String mMimeTypeName;

    private MimeType(String mMimeTypeName2, Set<String> mExtensions2) {
        this.mMimeTypeName = mMimeTypeName2;
        this.mExtensions = mExtensions2;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public String toString() {
        return this.mMimeTypeName;
    }

    public final boolean checkType(ContentResolver resolver, Uri uri) {
        String str;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        MimeTypeMap map = MimeTypeMap.getSingleton();
        if (uri == null) {
            return false;
        }
        String type = map.getExtensionFromMimeType(resolver.getType(uri));
        String path = null;
        boolean pathParsed = false;
        for (String extension : this.mExtensions) {
            if (Intrinsics.areEqual((Object) extension, (Object) type)) {
                return true;
            }
            if (!pathParsed) {
                path = PhotoMetadataUtilsKt.getPath(resolver, uri);
                if (!TextUtils.isEmpty(path)) {
                    if (path != null) {
                        Locale locale = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(locale, "US");
                        str = path.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
                    } else {
                        str = null;
                    }
                    path = str;
                }
                pathParsed = true;
            }
            if (path != null && StringsKt.endsWith$default(path, extension, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J3\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u000e\"\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\u0004J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/MimeType$Companion;", "", "()V", "isGif", "", "mimeType", "", "isImage", "isVideo", "of", "", "Lcom/baidu/searchbox/aisearch/camera/gallery/MimeType;", "type", "rest", "", "(Lcom/baidu/searchbox/aisearch/camera/gallery/MimeType;[Lcom/baidu/searchbox/aisearch/camera/gallery/MimeType;)Ljava/util/Set;", "ofAll", "ofGif", "ofImage", "onlyGif", "ofVideo", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MimeType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<MimeType> ofAll() {
            EnumSet<E> allOf = EnumSet.allOf(MimeType.class);
            Intrinsics.checkNotNullExpressionValue(allOf, "allOf(MimeType::class.java)");
            return allOf;
        }

        public final Set<MimeType> of(MimeType type, MimeType... rest) {
            Intrinsics.checkNotNullParameter(rest, "rest");
            EnumSet of = EnumSet.of(type, (Enum[]) Arrays.copyOf(rest, rest.length));
            Intrinsics.checkNotNullExpressionValue(of, "of(type, *rest)");
            return of;
        }

        public final Set<MimeType> ofImage() {
            EnumSet of = EnumSet.of(MimeType.JPEG, MimeType.PNG, MimeType.GIF, MimeType.BMP, MimeType.WEBP);
            Intrinsics.checkNotNullExpressionValue(of, "of(JPEG, PNG, GIF, BMP, WEBP)");
            return of;
        }

        public final Set<MimeType> ofImage(boolean onlyGif) {
            EnumSet of = EnumSet.of(MimeType.GIF);
            Intrinsics.checkNotNullExpressionValue(of, "of(GIF)");
            return of;
        }

        public final Set<MimeType> ofGif() {
            return ofImage(true);
        }

        public final Set<MimeType> ofVideo() {
            EnumSet of = EnumSet.of(MimeType.MPEG, (Enum[]) new MimeType[]{MimeType.MP4, MimeType.QUICKTIME, MimeType.THREEGPP, MimeType.THREEGPP2, MimeType.MKV, MimeType.WEBM, MimeType.TS, MimeType.AVI});
            Intrinsics.checkNotNullExpressionValue(of, "of(MPEG, MP4, QUICKTIME,…GPP2, MKV, WEBM, TS, AVI)");
            return of;
        }

        public final boolean isImage(String mimeType) {
            if (mimeType != null) {
                return StringsKt.startsWith$default(mimeType, "image", false, 2, (Object) null);
            }
            return false;
        }

        public final boolean isVideo(String mimeType) {
            if (mimeType != null) {
                return StringsKt.startsWith$default(mimeType, "video", false, 2, (Object) null);
            }
            return false;
        }

        public final boolean isGif(String mimeType) {
            if (mimeType == null) {
                return false;
            }
            return Intrinsics.areEqual((Object) mimeType, (Object) MimeType.GIF.toString());
        }
    }
}
