package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface Key {
    public static final Charset qw = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void qw(@NonNull MessageDigest messageDigest);
}
