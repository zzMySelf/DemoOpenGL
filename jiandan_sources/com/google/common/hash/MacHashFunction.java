package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@Immutable
public final class MacHashFunction extends AbstractHashFunction {
    public final int bits = (this.prototype.getMacLength() * 8);
    public final Key key;
    public final Mac prototype;
    public final boolean supportsClone = supportsClone(this.prototype);
    public final String toString;

    public static final class MacHasher extends AbstractByteHasher {
        public boolean done;
        public final Mac mac;

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        public HashCode hash() {
            checkNotDone();
            this.done = true;
            return HashCode.fromBytesNoCopy(this.mac.doFinal());
        }

        public void update(byte b) {
            checkNotDone();
            this.mac.update(b);
        }

        public MacHasher(Mac mac2) {
            this.mac = mac2;
        }

        public void update(byte[] bArr) {
            checkNotDone();
            this.mac.update(bArr);
        }

        public void update(byte[] bArr, int i2, int i3) {
            checkNotDone();
            this.mac.update(bArr, i2, i3);
        }

        public void update(ByteBuffer byteBuffer) {
            checkNotDone();
            Preconditions.checkNotNull(byteBuffer);
            this.mac.update(byteBuffer);
        }
    }

    public MacHashFunction(String str, Key key2, String str2) {
        this.prototype = getMac(str, key2);
        this.key = (Key) Preconditions.checkNotNull(key2);
        this.toString = (String) Preconditions.checkNotNull(str2);
    }

    public static Mac getMac(String str, Key key2) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key2);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean supportsClone(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public int bits() {
        return this.bits;
    }

    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new MacHasher((Mac) this.prototype.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key));
    }

    public String toString() {
        return this.toString;
    }
}
