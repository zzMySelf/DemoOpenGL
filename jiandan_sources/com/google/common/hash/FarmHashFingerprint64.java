package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

public final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    public static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    public static final long K0 = -4348849565147123417L;
    public static final long K1 = -5435081209227447693L;
    public static final long K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i2, int i3) {
        if (i3 <= 32) {
            if (i3 <= 16) {
                return hashLength0to16(bArr, i2, i3);
            }
            return hashLength17to32(bArr, i2, i3);
        } else if (i3 <= 64) {
            return hashLength33To64(bArr, i2, i3);
        } else {
            return hashLength65Plus(bArr, i2, i3);
        }
    }

    public static long hashLength0to16(byte[] bArr, int i2, int i3) {
        if (i3 >= 8) {
            long j = ((long) (i3 * 2)) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i2) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i2 + i3) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j) + load64, (Long.rotateRight(load64, 25) + load642) * j, j);
        } else if (i3 >= 4) {
            return hashLength16(((long) i3) + ((((long) LittleEndianByteArray.load32(bArr, i2)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bArr, (i2 + i3) - 4)) & 4294967295L, ((long) (i3 * 2)) + K2);
        } else if (i3 <= 0) {
            return K2;
        } else {
            return shiftMix((((long) ((bArr[i2] & 255) + ((bArr[(i3 >> 1) + i2] & 255) << 8))) * K2) ^ (((long) (i3 + ((bArr[i2 + (i3 - 1)] & 255) << 2))) * K0)) * K2;
        }
    }

    public static long hashLength16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long hashLength17to32(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        long j = ((long) (i3 * 2)) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i2) * K1;
        long load642 = LittleEndianByteArray.load64(bArr2, i2 + 8);
        int i4 = i2 + i3;
        long load643 = LittleEndianByteArray.load64(bArr2, i4 - 8) * j;
        return hashLength16((LittleEndianByteArray.load64(bArr2, i4 - 16) * K2) + Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30), load64 + Long.rotateRight(load642 + K2, 18) + load643, j);
    }

    public static long hashLength33To64(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        long j = ((long) (i3 * 2)) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i2) * K2;
        long load642 = LittleEndianByteArray.load64(bArr2, i2 + 8);
        int i4 = i2 + i3;
        long load643 = LittleEndianByteArray.load64(bArr2, i4 - 8) * j;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr2, i4 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 + K2, 18) + load64, j);
        long load644 = LittleEndianByteArray.load64(bArr2, i2 + 16) * j;
        long load645 = LittleEndianByteArray.load64(bArr2, i2 + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr2, i4 - 32)) * j;
        return hashLength16(((hashLength16 + LittleEndianByteArray.load64(bArr2, i4 - 24)) * j) + Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30), load644 + Long.rotateRight(load645 + load64, 18) + load646, j);
    }

    public static long hashLength65Plus(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        long shiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long load64 = 95310865018149119L + LittleEndianByteArray.load64(bArr, i2);
        int i4 = i3 - 1;
        int i5 = i2 + ((i4 / 64) * 64);
        int i6 = i4 & 63;
        int i7 = (i5 + i6) - 63;
        long j = 2480279821605975764L;
        int i8 = i2;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j + jArr[0] + LittleEndianByteArray.load64(bArr2, i8 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j + jArr[1] + LittleEndianByteArray.load64(bArr2, i8 + 48), 42) * K1;
            long j2 = rotateRight ^ jArr2[1];
            long load642 = rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i8 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i8, jArr[1] * K1, j2 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i8 + 32, rotateRight3 + jArr2[1], load642 + LittleEndianByteArray.load64(bArr2, i8 + 16), jArr2);
            i8 += 64;
            if (i8 == i5) {
                long j3 = ((j2 & 255) << 1) + K1;
                jArr2[0] = jArr2[0] + ((long) i6);
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight4 = (Long.rotateRight(((rotateRight3 + load642) + jArr[0]) + LittleEndianByteArray.load64(bArr2, i7 + 8), 37) * j3) ^ (jArr2[1] * 9);
                long rotateRight5 = (Long.rotateRight(load642 + jArr[1] + LittleEndianByteArray.load64(bArr2, i7 + 48), 42) * j3) + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr2, i7 + 40);
                long rotateRight6 = Long.rotateRight(j2 + jArr2[0], 33) * j3;
                byte[] bArr3 = bArr;
                weakHashLength32WithSeeds(bArr3, i7, jArr[1] * j3, rotateRight4 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr3, i7 + 32, rotateRight6 + jArr2[1], LittleEndianByteArray.load64(bArr2, i7 + 16) + rotateRight5, jArr2);
                long j4 = j3;
                return hashLength16(hashLength16(jArr[0], jArr2[0], j4) + (shiftMix(rotateRight5) * K0) + rotateRight4, hashLength16(jArr[1], jArr2[1], j4) + rotateRight6, j4);
            }
            shiftMix = j2;
            j = load642;
            load64 = rotateRight3;
        }
    }

    public static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    public static void weakHashLength32WithSeeds(byte[] bArr, int i2, long j, long j2, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i2);
        long load642 = LittleEndianByteArray.load64(bArr, i2 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i2 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i2 + 24);
        long j3 = j + load64;
        long j4 = load642 + j3 + load643;
        jArr[0] = j4 + load644;
        jArr[1] = Long.rotateRight(j2 + j3 + load644, 21) + Long.rotateRight(j4, 44) + j3;
    }

    public int bits() {
        return 64;
    }

    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i2, i3));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
