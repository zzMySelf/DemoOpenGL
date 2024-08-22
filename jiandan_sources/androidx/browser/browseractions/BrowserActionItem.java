package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@Deprecated
public class BrowserActionItem {
    @Nullable
    public final PendingIntent mAction;
    @DrawableRes
    public int mIconId;
    @Nullable
    public Uri mIconUri;
    @Nullable
    public Runnable mRunnableAction;
    public final String mTitle;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i2) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i2;
    }

    @NonNull
    public PendingIntent getAction() {
        PendingIntent pendingIntent = this.mAction;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    public int getIconId() {
        return this.mIconId;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Uri getIconUri() {
        return this.mIconUri;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Runnable getRunnableAction() {
        return this.mRunnableAction;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @NonNull Uri uri) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconUri = uri;
    }

    public BrowserActionItem(@NonNull String str, @NonNull Runnable runnable) {
        this.mTitle = str;
        this.mAction = null;
        this.mRunnableAction = runnable;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
