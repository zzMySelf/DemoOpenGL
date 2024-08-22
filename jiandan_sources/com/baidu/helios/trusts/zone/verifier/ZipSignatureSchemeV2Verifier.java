package com.baidu.helios.trusts.zone.verifier;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ZipSignatureSchemeV2Verifier {

    public static class SignatureNotFoundException extends Exception {
        public static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static class VerbatimX509Certificate extends WrappedX509Certificate {
        public byte[] encodedVerbatim;

        public VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.encodedVerbatim = bArr;
        }

        public byte[] getEncoded() throws CertificateEncodingException {
            return this.encodedVerbatim;
        }
    }

    public static class WrappedX509Certificate extends X509Certificate {
        public final X509Certificate wrapped;

        public WrappedX509Certificate(X509Certificate x509Certificate) {
            this.wrapped = x509Certificate;
        }

        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity();
        }

        public int getBasicConstraints() {
            return this.wrapped.getBasicConstraints();
        }

        public Set<String> getCriticalExtensionOIDs() {
            return this.wrapped.getCriticalExtensionOIDs();
        }

        public byte[] getEncoded() throws CertificateEncodingException {
            return this.wrapped.getEncoded();
        }

        public byte[] getExtensionValue(String str) {
            return this.wrapped.getExtensionValue(str);
        }

        public Principal getIssuerDN() {
            return this.wrapped.getIssuerDN();
        }

        public boolean[] getIssuerUniqueID() {
            return this.wrapped.getIssuerUniqueID();
        }

        public boolean[] getKeyUsage() {
            return this.wrapped.getKeyUsage();
        }

        public Set<String> getNonCriticalExtensionOIDs() {
            return this.wrapped.getNonCriticalExtensionOIDs();
        }

        public Date getNotAfter() {
            return this.wrapped.getNotAfter();
        }

        public Date getNotBefore() {
            return this.wrapped.getNotBefore();
        }

        public PublicKey getPublicKey() {
            return this.wrapped.getPublicKey();
        }

        public BigInteger getSerialNumber() {
            return this.wrapped.getSerialNumber();
        }

        public String getSigAlgName() {
            return this.wrapped.getSigAlgName();
        }

        public String getSigAlgOID() {
            return this.wrapped.getSigAlgOID();
        }

        public byte[] getSigAlgParams() {
            return this.wrapped.getSigAlgParams();
        }

        public byte[] getSignature() {
            return this.wrapped.getSignature();
        }

        public Principal getSubjectDN() {
            return this.wrapped.getSubjectDN();
        }

        public boolean[] getSubjectUniqueID() {
            return this.wrapped.getSubjectUniqueID();
        }

        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return this.wrapped.getTBSCertificate();
        }

        public int getVersion() {
            return this.wrapped.getVersion();
        }

        public boolean hasUnsupportedCriticalExtension() {
            return this.wrapped.hasUnsupportedCriticalExtension();
        }

        public String toString() {
            return this.wrapped.toString();
        }

        public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(publicKey);
        }

        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity(date);
        }

        public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(publicKey, str);
        }
    }

    public static final class ad implements de {
        public final ByteBuffer qw;

        public ad(ByteBuffer byteBuffer) {
            this.qw = byteBuffer.slice();
        }

        public void qw(MessageDigest[] messageDigestArr, long j, int i2) throws IOException {
            ByteBuffer slice;
            synchronized (this.qw) {
                int i3 = (int) j;
                this.qw.position(i3);
                this.qw.limit(i3 + i2);
                slice = this.qw.slice();
            }
            for (MessageDigest update : messageDigestArr) {
                slice.position(0);
                update.update(slice);
            }
        }

        public long size() {
            return (long) this.qw.capacity();
        }
    }

    public interface de {
        void qw(MessageDigest[] messageDigestArr, long j, int i2) throws IOException;

        long size();
    }

    public static final class fe implements de {

        /* renamed from: ad  reason: collision with root package name */
        public final long f860ad;

        /* renamed from: de  reason: collision with root package name */
        public final long f861de;
        public final FileChannel qw;

        public fe(FileChannel fileChannel, long j, long j2) {
            this.qw = fileChannel;
            this.f860ad = j;
            this.f861de = j2;
        }

        public void qw(MessageDigest[] messageDigestArr, long j, int i2) throws IOException {
            MappedByteBuffer map = this.qw.map(FileChannel.MapMode.READ_ONLY, this.f860ad + j, (long) i2);
            for (MessageDigest update : messageDigestArr) {
                map.position(0);
                update.update(map);
            }
        }

        public long size() {
            return this.f861de;
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public final long f862ad;

        /* renamed from: de  reason: collision with root package name */
        public final long f863de;

        /* renamed from: fe  reason: collision with root package name */
        public final long f864fe;
        public final ByteBuffer qw;

        /* renamed from: rg  reason: collision with root package name */
        public final ByteBuffer f865rg;

        public rg(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.qw = byteBuffer;
            this.f862ad = j;
            this.f863de = j2;
            this.f864fe = j3;
            this.f865rg = byteBuffer2;
        }
    }

    public static X509Certificate[][] aaa(File file) throws SignatureNotFoundException, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return qqq(randomAccessFile);
        } finally {
            fe.fe.pf.yj.fe.de.de.de(randomAccessFile);
        }
    }

    public static int ad(int i2, int i3) {
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i2);
            } else if (i3 == 1) {
                return 1;
            } else {
                if (i3 == 2) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
            }
        } else if (i3 == 1) {
            return 0;
        } else {
            if (i3 == 2) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
        }
    }

    public static byte[] ddd(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IOException("Negative length");
        } else if (i2 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
        }
    }

    public static int de(int i2, int i3) {
        return ad(ppp(i2), ppp(i3));
    }

    public static X509Certificate[][] eee(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, rg rgVar) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer when = when(rgVar.qw);
                int i2 = 0;
                while (when.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(tt(when(when), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    }
                }
                if (i2 < 1) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    rrr(hashMap, randomAccessFile, fileDescriptor, rgVar.f862ad, rgVar.f863de, rgVar.f864fe, rgVar.f865rg);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    public static byte[][] fe(int[] iArr, de[] deVarArr) throws DigestException {
        int[] iArr2 = iArr;
        de[] deVarArr2 = deVarArr;
        long j = 0;
        long j2 = 0;
        for (de size : deVarArr2) {
            j2 += o(size.size());
        }
        if (j2 < 2097151) {
            int i2 = (int) j2;
            byte[][] bArr = new byte[iArr2.length][];
            for (int i3 = 0; i3 < iArr2.length; i3++) {
                byte[] bArr2 = new byte[((m25if(iArr2[i3]) * i2) + 5)];
                bArr2[0] = 90;
                nn(i2, bArr2, 1);
                bArr[i3] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr2.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i4 = 0;
            while (i4 < iArr2.length) {
                String pf2 = pf(iArr2[i4]);
                try {
                    messageDigestArr[i4] = MessageDigest.getInstance(pf2);
                    i4++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(pf2 + " digest not supported", e);
                }
            }
            int length2 = deVarArr2.length;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length2) {
                de deVar = deVarArr2[i5];
                int i8 = length2;
                int i9 = i5;
                long size2 = deVar.size();
                long j3 = j;
                while (size2 > j) {
                    int min = (int) Math.min(size2, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                    nn(min, bArr3, 1);
                    int i10 = 0;
                    while (i10 < length) {
                        messageDigestArr[i10].update(bArr3);
                        i10++;
                        de[] deVarArr3 = deVarArr;
                    }
                    try {
                        deVar.qw(messageDigestArr, j3, min);
                        int i11 = 0;
                        while (i11 < iArr2.length) {
                            int i12 = iArr2[i11];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i11];
                            int i13 = m25if(i12);
                            de deVar2 = deVar;
                            MessageDigest messageDigest = messageDigestArr[i11];
                            int i14 = length;
                            int digest = messageDigest.digest(bArr5, (i6 * i13) + 5, i13);
                            if (digest == i13) {
                                i11++;
                                bArr3 = bArr4;
                                deVar = deVar2;
                                length = i14;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        de deVar3 = deVar;
                        int i15 = length;
                        long j4 = (long) min;
                        j3 += j4;
                        size2 -= j4;
                        i6++;
                        de[] deVarArr4 = deVarArr;
                        bArr3 = bArr3;
                        j = 0;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i6 + " of section #" + i7, e2);
                    }
                }
                byte[] bArr6 = bArr3;
                int i16 = length;
                i7++;
                i5 = i9 + 1;
                deVarArr2 = deVarArr;
                length2 = i8;
                j = 0;
            }
            byte[][] bArr7 = new byte[iArr2.length][];
            int i17 = 0;
            while (i17 < iArr2.length) {
                int i18 = iArr2[i17];
                byte[] bArr8 = bArr[i17];
                String pf3 = pf(i18);
                try {
                    bArr7[i17] = MessageDigest.getInstance(pf3).digest(bArr8);
                    i17++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(pf3 + " digest not supported", e3);
                }
            }
            return bArr7;
        }
        throw new DigestException("Too many chunks: " + j2);
    }

    public static String ggg(int i2) {
        if (i2 == 513 || i2 == 514) {
            return "EC";
        }
        if (i2 == 769) {
            return "DSA";
        }
        switch (i2) {
            case 257:
            case PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD /*258*/:
            case PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD /*259*/:
            case PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD /*260*/:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i2 & -1)));
        }
    }

    public static long i(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
        long yj2 = fe.fe.pf.pf.qw.fe.qw.yj(byteBuffer);
        if (yj2 >= j) {
            throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + yj2 + ". ZIP End of Central Directory offset: " + j);
        } else if (fe.fe.pf.pf.qw.fe.qw.uk(byteBuffer) + yj2 == j) {
            return yj2;
        } else {
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static int m25if(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    /* JADX INFO: finally extract failed */
    public static ByteBuffer mmm(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: " + i2);
        } else if (i3 >= i2) {
            int capacity = byteBuffer.capacity();
            if (i3 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i3);
                    byteBuffer.position(i2);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    return slice;
                } catch (Throwable th2) {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    throw th2;
                }
            } else {
                throw new IllegalArgumentException("end > capacity: " + i3 + " > " + capacity);
            }
        } else {
            throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
        }
    }

    public static void nn(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >>> 24) & 255);
    }

    public static final long o(long j) {
        return ((j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static String pf(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    public static int ppp(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        switch (i2) {
            case 257:
            case PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD /*259*/:
                return 1;
            case PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD /*258*/:
            case PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD /*260*/:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i2 & -1)));
        }
    }

    public static X509Certificate[][] qqq(RandomAccessFile randomAccessFile) throws SignatureNotFoundException, SecurityException, IOException {
        return eee(randomAccessFile, randomAccessFile.getFD(), yj(randomAccessFile));
    }

    public static void qw(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static ByteBuffer rg(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        qw(byteBuffer);
        ByteBuffer mmm = mmm(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (mmm.hasRemaining()) {
            i2++;
            if (mmm.remaining() >= 8) {
                long j = mmm.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
                int i3 = (int) j;
                int position = mmm.position() + i3;
                if (i3 > mmm.remaining()) {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + mmm.remaining());
                } else if (mmm.getInt() == 1896449818) {
                    return uk(mmm, i3 - 4);
                } else {
                    mmm.position(position);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
        }
        throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$de[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void rrr(java.util.Map<java.lang.Integer, byte[]> r12, java.io.RandomAccessFile r13, java.io.FileDescriptor r14, long r15, long r17, long r19, java.nio.ByteBuffer r21) throws java.lang.SecurityException {
        /*
            r0 = r13
            r7 = r15
            r9 = r17
            java.lang.String r1 = "Failed to get apk contents"
            boolean r2 = r12.isEmpty()
            if (r2 != 0) goto L_0x0106
            r2 = 1048576(0x100000, double:5.180654E-318)
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x002f
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe r11 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe
            java.nio.channels.FileChannel r2 = r13.getChannel()
            r3 = 0
            r1 = r11
            r5 = r15
            r1.<init>(r2, r3, r5)
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe r6 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$fe
            java.nio.channels.FileChannel r1 = r13.getChannel()
            long r4 = r19 - r9
            r0 = r6
            r2 = r17
            r0.<init>(r1, r2, r4)
            goto L_0x0075
        L_0x002f:
            int r2 = (int) r7
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            r2.order(r3)
            r3 = 0
            r13.seek(r3)     // Catch:{ IOException -> 0x00ff }
            byte[] r3 = r2.array()     // Catch:{ IOException -> 0x00ff }
            int r4 = r2.arrayOffset()     // Catch:{ IOException -> 0x00ff }
            int r5 = r2.capacity()     // Catch:{ IOException -> 0x00ff }
            r13.readFully(r3, r4, r5)     // Catch:{ IOException -> 0x00ff }
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad r11 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad
            r11.<init>(r2)
            long r2 = r19 - r9
            int r3 = (int) r2
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            r2.order(r3)
            r13.seek(r9)     // Catch:{ IOException -> 0x00f8 }
            byte[] r3 = r2.array()     // Catch:{ IOException -> 0x00f8 }
            int r4 = r2.arrayOffset()     // Catch:{ IOException -> 0x00f8 }
            int r5 = r2.capacity()     // Catch:{ IOException -> 0x00f8 }
            r13.readFully(r3, r4, r5)     // Catch:{ IOException -> 0x00f8 }
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad r6 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad
            r6.<init>(r2)
        L_0x0075:
            java.nio.ByteBuffer r0 = r21.duplicate()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            r0.order(r1)
            fe.fe.pf.pf.qw.fe.qw.pf(r0, r7)
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad r1 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$ad
            r1.<init>(r0)
            int r0 = r12.size()
            int[] r2 = new int[r0]
            java.util.Set r3 = r12.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = 0
        L_0x0096:
            boolean r7 = r3.hasNext()
            r8 = 1
            if (r7 == 0) goto L_0x00ab
            java.lang.Object r7 = r3.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r2[r5] = r7
            int r5 = r5 + r8
            goto L_0x0096
        L_0x00ab:
            r3 = 3
            com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier$de[] r3 = new com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.de[r3]     // Catch:{ DigestException -> 0x00ef }
            r3[r4] = r11     // Catch:{ DigestException -> 0x00ef }
            r3[r8] = r6     // Catch:{ DigestException -> 0x00ef }
            r5 = 2
            r3[r5] = r1     // Catch:{ DigestException -> 0x00ef }
            byte[][] r1 = fe(r2, r3)     // Catch:{ DigestException -> 0x00ef }
        L_0x00b9:
            if (r4 >= r0) goto L_0x00ee
            r3 = r2[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r6 = r12
            java.lang.Object r5 = r12.get(r5)
            byte[] r5 = (byte[]) r5
            r7 = r1[r4]
            boolean r5 = java.security.MessageDigest.isEqual(r5, r7)
            if (r5 == 0) goto L_0x00d3
            int r4 = r4 + 1
            goto L_0x00b9
        L_0x00d3:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = pf(r3)
            r1.append(r2)
            java.lang.String r2 = " digest of contents did not verify"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ee:
            return
        L_0x00ef:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.String r2 = "Failed to compute digest(s) of contents"
            r1.<init>(r2, r0)
            throw r1
        L_0x00f8:
            r0 = move-exception
            java.lang.SecurityException r2 = new java.lang.SecurityException
            r2.<init>(r1, r0)
            throw r2
        L_0x00ff:
            r0 = move-exception
            java.lang.SecurityException r2 = new java.lang.SecurityException
            r2.<init>(r1, r0)
            throw r2
        L_0x0106:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No digests provided"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.rrr(java.util.Map, java.io.RandomAccessFile, java.io.FileDescriptor, long, long, long, java.nio.ByteBuffer):void");
    }

    /* renamed from: switch  reason: not valid java name */
    public static Pair<ByteBuffer, Long> m26switch(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> de2 = fe.fe.pf.pf.qw.fe.qw.de(randomAccessFile);
        if (de2 != null) {
            return de2;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static Pair<ByteBuffer, Long> th(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
        if (j >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j - ((long) allocate.capacity()));
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j2 = allocate.getLong(0);
                if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                    throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
                }
                int i2 = (int) (8 + j2);
                long j3 = j - ((long) i2);
                if (j3 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j4 = allocate2.getLong(0);
                    if (j4 == j2) {
                        return Pair.create(allocate2, Long.valueOf(j3));
                    }
                    throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                }
                throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
    }

    public static X509Certificate[] tt(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        ByteBuffer when = when(byteBuffer);
        ByteBuffer when2 = when(byteBuffer);
        byte[] ddd = ddd(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i2 = -1;
        int i3 = 0;
        while (when2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer when3 = when(when2);
                if (when3.remaining() >= 8) {
                    int i4 = when3.getInt();
                    arrayList.add(Integer.valueOf(i4));
                    if (xxx(i4)) {
                        if (i2 == -1 || de(i4, i2) > 0) {
                            bArr2 = ddd(when3);
                            i2 = i4;
                        }
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i3, e);
            }
        }
        if (i2 != -1) {
            String ggg = ggg(i2);
            Pair<String, ? extends AlgorithmParameterSpec> vvv = vvv(i2);
            String str = (String) vvv.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) vvv.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(ggg).generatePublic(new X509EncodedKeySpec(ddd));
                Signature instance = Signature.getInstance(str);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(when);
                if (instance.verify(bArr2)) {
                    when.clear();
                    ByteBuffer when4 = when(when);
                    ArrayList arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (when4.hasRemaining()) {
                        i5++;
                        try {
                            ByteBuffer when5 = when(when4);
                            if (when5.remaining() >= 8) {
                                int i6 = when5.getInt();
                                arrayList2.add(Integer.valueOf(i6));
                                if (i6 == i2) {
                                    bArr = ddd(when5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException("Failed to parse digest record #" + i5, e2);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int ppp = ppp(i2);
                        byte[] put = map.put(Integer.valueOf(ppp), bArr);
                        if (put == null || MessageDigest.isEqual(put, bArr)) {
                            ByteBuffer when6 = when(when);
                            ArrayList arrayList3 = new ArrayList();
                            int i7 = 0;
                            while (when6.hasRemaining()) {
                                i7++;
                                byte[] ddd2 = ddd(when6);
                                try {
                                    arrayList3.add(new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(ddd2)), ddd2));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #" + i7, e3);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(ddd, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(pf(ppp) + " contents digest does not match the digest specified by a preceding signer");
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(str + " signature did not verify");
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                throw new SecurityException("Failed to verify " + str + " signature", e4);
            }
        } else if (i3 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    public static ByteBuffer uk(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        if (i2 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i3 = i2 + position;
            if (i3 < position || i3 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i3);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i3);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            throw new IllegalArgumentException("size: " + i2);
        }
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> vvv(int i2) {
        if (i2 == 513) {
            return Pair.create("SHA256withECDSA", (Object) null);
        }
        if (i2 == 514) {
            return Pair.create("SHA512withECDSA", (Object) null);
        }
        if (i2 == 769) {
            return Pair.create("SHA256withDSA", (Object) null);
        }
        switch (i2) {
            case 257:
                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD /*258*/:
                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD /*259*/:
                return Pair.create("SHA256withRSA", (Object) null);
            case PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD /*260*/:
                return Pair.create("SHA512withRSA", (Object) null);
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i2 & -1)));
        }
    }

    public static ByteBuffer when(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i2 <= byteBuffer.remaining()) {
                return uk(byteBuffer, i2);
            } else {
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
        } else {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
    }

    public static boolean xxx(int i2) {
        if (i2 == 513 || i2 == 514 || i2 == 769) {
            return true;
        }
        switch (i2) {
            case 257:
            case PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD /*258*/:
            case PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD /*259*/:
            case PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD /*260*/:
                return true;
            default:
                return false;
        }
    }

    public static rg yj(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> pair = m26switch(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) pair.first;
        long longValue = ((Long) pair.second).longValue();
        if (!fe.fe.pf.pf.qw.fe.qw.i(randomAccessFile, longValue)) {
            long i2 = i(byteBuffer, longValue);
            Pair<ByteBuffer, Long> th2 = th(randomAccessFile, i2);
            return new rg(rg((ByteBuffer) th2.first), ((Long) th2.second).longValue(), i2, longValue, byteBuffer);
        }
        throw new SignatureNotFoundException("ZIP64 APK not supported");
    }
}
