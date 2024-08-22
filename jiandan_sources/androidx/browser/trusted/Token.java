package androidx.browser.trusted;

import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;

public final class Token {
    public static final String TAG = "Token";
    @NonNull
    public final TokenContents mContents;

    public Token(@NonNull TokenContents tokenContents) {
        this.mContents = tokenContents;
    }

    @Nullable
    public static Token create(@NonNull String str, @NonNull PackageManager packageManager) {
        List<byte[]> fingerprintsForPackage = PackageIdentityUtils.getFingerprintsForPackage(str, packageManager);
        if (fingerprintsForPackage == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(str, fingerprintsForPackage));
        } catch (IOException unused) {
            return null;
        }
    }

    @NonNull
    public static Token deserialize(@NonNull byte[] bArr) {
        return new Token(TokenContents.deserialize(bArr));
    }

    public boolean matches(@NonNull String str, @NonNull PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(str, packageManager, this.mContents);
    }

    @NonNull
    public byte[] serialize() {
        return this.mContents.serialize();
    }
}
