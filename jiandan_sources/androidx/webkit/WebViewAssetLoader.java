package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    public static final String TAG = "WebViewAssetLoader";
    public final List<PathMatcher> mMatchers;

    public static final class Builder {
        @NonNull
        public List<PathMatcher> mBuilderMatcherList = new ArrayList();
        public String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
        public boolean mHttpAllowed = false;

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            this.mBuilderMatcherList.add(new PathMatcher(this.mDomain, str, this.mHttpAllowed, pathHandler));
            return this;
        }

        @NonNull
        public WebViewAssetLoader build() {
            return new WebViewAssetLoader(this.mBuilderMatcherList);
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            this.mDomain = str;
            return this;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z) {
            this.mHttpAllowed = z;
            return this;
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
        public static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
        @NonNull
        public final File mDirectory;

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            try {
                this.mDirectory = new File(AssetHelper.getCanonicalDirPath(file));
                if (!isAllowedInternalStorageDir(context)) {
                    throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e);
            }
        }

        private boolean isAllowedInternalStorageDir(@NonNull Context context) throws IOException {
            String canonicalDirPath = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String canonicalDirPath2 = AssetHelper.getCanonicalDirPath(context.getCacheDir());
            String canonicalDirPath3 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(context));
            if ((!canonicalDirPath.startsWith(canonicalDirPath2) && !canonicalDirPath.startsWith(canonicalDirPath3)) || canonicalDirPath.equals(canonicalDirPath2) || canonicalDirPath.equals(canonicalDirPath3)) {
                return false;
            }
            for (String str : FORBIDDEN_DATA_DIRS) {
                if (canonicalDirPath.startsWith(canonicalDirPath3 + str)) {
                    return false;
                }
            }
            return true;
        }

        @WorkerThread
        @NonNull
        public WebResourceResponse handle(@NonNull String str) {
            try {
                File canonicalFileIfChild = AssetHelper.getCanonicalFileIfChild(this.mDirectory, str);
                if (canonicalFileIfChild != null) {
                    return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, AssetHelper.openFile(canonicalFileIfChild));
                }
                String.format("The requested file: %s is outside the mounted directory: %s", new Object[]{str, this.mDirectory});
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException unused) {
                "Error opening the requested path: " + str;
            }
        }
    }

    public interface PathHandler {
        @WorkerThread
        @Nullable
        WebResourceResponse handle(@NonNull String str);
    }

    @VisibleForTesting
    public static class PathMatcher {
        public static final String HTTPS_SCHEME = "https";
        public static final String HTTP_SCHEME = "http";
        @NonNull
        public final String mAuthority;
        @NonNull
        public final PathHandler mHandler;
        public final boolean mHttpEnabled;
        @NonNull
        public final String mPath;

        public PathMatcher(@NonNull String str, @NonNull String str2, boolean z, @NonNull PathHandler pathHandler) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            } else if (str2.endsWith("/")) {
                this.mAuthority = str;
                this.mPath = str2;
                this.mHttpEnabled = z;
                this.mHandler = pathHandler;
            } else {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
        }

        @WorkerThread
        @NonNull
        public String getSuffixPath(@NonNull String str) {
            return str.replaceFirst(this.mPath, "");
        }

        @WorkerThread
        @Nullable
        public PathHandler match(@NonNull Uri uri) {
            if (uri.getScheme().equals("http") && !this.mHttpEnabled) {
                return null;
            }
            if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.mAuthority) && uri.getPath().startsWith(this.mPath)) {
                return this.mHandler;
            }
            return null;
        }
    }

    public WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        this.mMatchers = list;
    }

    @WorkerThread
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        WebResourceResponse handle;
        for (PathMatcher next : this.mMatchers) {
            PathHandler match = next.match(uri);
            if (match != null && (handle = match.handle(next.getSuffixPath(uri.getPath()))) != null) {
                return handle;
            }
        }
        return null;
    }

    public static final class AssetsPathHandler implements PathHandler {
        public AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        @Nullable
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openAsset(str));
            } catch (IOException unused) {
                "Error opening asset path: " + str;
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }

        @VisibleForTesting
        public AssetsPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    public static final class ResourcesPathHandler implements PathHandler {
        public AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        @Nullable
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openResource(str));
            } catch (Resources.NotFoundException unused) {
                "Resource not found from the path: " + str;
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException unused2) {
                "Error opening resource from the path: " + str;
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }

        @VisibleForTesting
        public ResourcesPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }
}
