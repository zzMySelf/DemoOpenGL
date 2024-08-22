package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

@Immutable
public final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    public static final long serialVersionUID = 0;
    public final int bits;
    public final ImmutableSupplier<? extends Checksum> checksumSupplier;
    public final String toString;

    public final class ChecksumHasher extends AbstractByteHasher {
        public final Checksum checksum;

        public HashCode hash() {
            long value = this.checksum.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        public void update(byte b) {
            this.checksum.update(b);
        }

        public ChecksumHasher(Checksum checksum2) {
            this.checksum = (Checksum) Preconditions.checkNotNull(checksum2);
        }

        public void update(byte[] bArr, int i2, int i3) {
            this.checksum.update(bArr, i2, i3);
        }
    }

    public ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i2, String str) {
        this.checksumSupplier = (ImmutableSupplier) Preconditions.checkNotNull(immutableSupplier);
        Preconditions.checkArgument(i2 == 32 || i2 == 64, "bits (%s) must be either 32 or 64", i2);
        this.bits = i2;
        this.toString = (String) Preconditions.checkNotNull(str);
    }

    public int bits() {
        return this.bits;
    }

    public Hasher newHasher() {
        return new ChecksumHasher((Checksum) this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
