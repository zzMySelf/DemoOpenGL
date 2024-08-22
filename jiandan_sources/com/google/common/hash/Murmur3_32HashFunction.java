package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    public static final int C1 = -862048943;
    public static final int C2 = 461845907;
    public static final int CHUNK_SIZE = 4;
    public static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    public static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    public static final long serialVersionUID = 0;
    public final int seed;

    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        public long buffer;
        public int h1;
        public boolean isDone = false;
        public int length = 0;
        public int shift;

        public Murmur3_32Hasher(int i2) {
            this.h1 = i2;
        }

        private void update(int i2, long j) {
            long j2 = this.buffer;
            int i3 = this.shift;
            long j3 = ((j & 4294967295L) << i3) | j2;
            this.buffer = j3;
            int i4 = i3 + (i2 * 8);
            this.shift = i4;
            this.length += i2;
            if (i4 >= 32) {
                this.h1 = Murmur3_32HashFunction.mixH1(this.h1, Murmur3_32HashFunction.mixK1((int) j3));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int access$000 = this.h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.h1 = access$000;
            return Murmur3_32HashFunction.fmix(access$000, this.length);
        }

        public Hasher putByte(byte b) {
            update(1, (long) (b & 255));
            return this;
        }

        public Hasher putChar(char c) {
            update(2, (long) c);
            return this;
        }

        public Hasher putInt(int i2) {
            update(4, (long) i2);
            return this;
        }

        public Hasher putLong(long j) {
            update(4, (long) ((int) j));
            update(4, j >>> 32);
            return this;
        }

        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length2 = charSequence.length();
            int i2 = 0;
            while (true) {
                int i3 = i2 + 4;
                if (i3 > length2) {
                    break;
                }
                char charAt = charSequence.charAt(i2);
                char charAt2 = charSequence.charAt(i2 + 1);
                char charAt3 = charSequence.charAt(i2 + 2);
                char charAt4 = charSequence.charAt(i2 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (long) ((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i2 = i3;
            }
            while (i2 < length2) {
                char charAt5 = charSequence.charAt(i2);
                if (charAt5 < 128) {
                    update(1, (long) charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i2);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i2, length2).toString().getBytes(charset));
                        return this;
                    }
                    i2++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i2++;
            }
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (true) {
                int i5 = i4 + 4;
                if (i5 > i3) {
                    break;
                }
                update(4, (long) Murmur3_32HashFunction.getIntLittleEndian(bArr, i4 + i2));
                i4 = i5;
            }
            while (i4 < i3) {
                putByte(bArr[i2 + i4]);
                i4++;
            }
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i2) {
        this.seed = i2;
    }

    public static long charToThreeUtf8Bytes(char c) {
        return (long) ((((c & '?') | 128) << 16) | (((c >>> 12) | 480) & 255) | ((((c >>> 6) & 63) | 128) << 8));
    }

    public static long charToTwoUtf8Bytes(char c) {
        return (long) ((((c & '?') | 128) << 8) | (((c >>> 6) | 960) & 255));
    }

    public static long codePointToFourUtf8Bytes(int i2) {
        return ((((long) (i2 >>> 18)) | 240) & 255) | ((((long) ((i2 >>> 12) & 63)) | 128) << 8) | ((((long) ((i2 >>> 6) & 63)) | 128) << 16) | ((((long) (i2 & 63)) | 128) << 24);
    }

    public static HashCode fmix(int i2, int i3) {
        int i4 = i2 ^ i3;
        int i5 = (i4 ^ (i4 >>> 16)) * -2048144789;
        int i6 = (i5 ^ (i5 >>> 13)) * -1028477387;
        return HashCode.fromInt(i6 ^ (i6 >>> 16));
    }

    public static int getIntLittleEndian(byte[] bArr, int i2) {
        return Ints.fromBytes(bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]);
    }

    public static int mixH1(int i2, int i3) {
        return (Integer.rotateLeft(i2 ^ i3, 13) * 5) - 430675100;
    }

    public static int mixK1(int i2) {
        return Integer.rotateLeft(i2 * -862048943, 15) * 461845907;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction) || this.seed != ((Murmur3_32HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        int i4 = this.seed;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 4;
            if (i7 > i3) {
                break;
            }
            i4 = mixH1(i4, mixK1(getIntLittleEndian(bArr, i6 + i2)));
            i6 = i7;
        }
        int i8 = i6;
        int i9 = 0;
        while (i8 < i3) {
            i5 ^= UnsignedBytes.toInt(bArr[i2 + i8]) << i9;
            i8++;
            i9 += 8;
        }
        return fmix(mixK1(i5) ^ i4, i3);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    public HashCode hashInt(int i2) {
        return fmix(mixH1(this.seed, mixK1(i2)), 4);
    }

    public HashCode hashLong(long j) {
        int i2 = (int) (j >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1(i2)), 8);
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        int i2;
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 4;
            if (i7 > length) {
                break;
            }
            char charAt = charSequence.charAt(i5);
            char charAt2 = charSequence.charAt(i5 + 1);
            char charAt3 = charSequence.charAt(i5 + 2);
            char charAt4 = charSequence.charAt(i5 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i3 = mixH1(i3, mixK1((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i6 = i2 + 4;
            i5 = i7;
        }
        long j = 0;
        while (i5 < length) {
            char charAt5 = charSequence.charAt(i5);
            if (charAt5 < 128) {
                j |= ((long) charAt5) << i4;
                i4 += 8;
                i2++;
            } else if (charAt5 < 2048) {
                j |= charToTwoUtf8Bytes(charAt5) << i4;
                i4 += 16;
                i2 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j |= charToThreeUtf8Bytes(charAt5) << i4;
                i4 += 24;
                i2 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i5);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i5++;
                j |= codePointToFourUtf8Bytes(codePointAt) << i4;
                i2 += 4;
            }
            if (i4 >= 32) {
                i3 = mixH1(i3, mixK1((int) j));
                j >>>= 32;
                i4 -= 32;
            }
            i5++;
        }
        return fmix(mixK1((int) j) ^ i3, i2);
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i2 = this.seed;
        for (int i3 = 1; i3 < charSequence.length(); i3 += 2) {
            i2 = mixH1(i2, mixK1(charSequence.charAt(i3 - 1) | (charSequence.charAt(i3) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i2 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i2, charSequence.length() * 2);
    }

    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
