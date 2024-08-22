package com.baidubce.services.bos;

import android.annotation.SuppressLint;
import com.alipay.sdk.m.s.a;
import com.baidu.apollon.restnet.http.b;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.Headers;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.BosMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.internal.RestartableNonResettableInputStream;
import com.baidubce.internal.RestartableResettableInputStream;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.User;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.model.AbortMultipartUploadRequest;
import com.baidubce.services.bos.model.AppendObjectRequest;
import com.baidubce.services.bos.model.AppendObjectResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BosResponse;
import com.baidubce.services.bos.model.CannedAccessControlList;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectRequest;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.CreateBucketRequest;
import com.baidubce.services.bos.model.CreateBucketResponse;
import com.baidubce.services.bos.model.DeleteBucketRequest;
import com.baidubce.services.bos.model.DeleteObjectRequest;
import com.baidubce.services.bos.model.DoesBucketExistRequest;
import com.baidubce.services.bos.model.GeneratePresignedUrlRequest;
import com.baidubce.services.bos.model.GenericBucketRequest;
import com.baidubce.services.bos.model.GenericObjectRequest;
import com.baidubce.services.bos.model.GetBosAccountOwnerRequest;
import com.baidubce.services.bos.model.GetBucketAclRequest;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationRequest;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.GetObjectMetadataRequest;
import com.baidubce.services.bos.model.GetObjectRequest;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.InitiateMultipartUploadRequest;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsRequest;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsRequest;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsRequest;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsRequest;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.baidubce.services.bos.model.ResponseHeaderOverrides;
import com.baidubce.services.bos.model.SetBucketAclRequest;
import com.baidubce.services.bos.model.UploadPartRequest;
import com.baidubce.services.bos.model.UploadPartResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

@SuppressLint({"NewApi"})
public class BosClient extends AbstractBceClient {
    public static final String STORAGE_CLASS_COLD = "COLD";
    public static final String STORAGE_CLASS_STANDARD = "STANDARD";
    public static final String STORAGE_CLASS_STANDARD_IA = "STANDARD_IA";
    public static final HttpResponseHandler[] bos_handlers = {new BceMetadataResponseHandler(), new BosMetadataResponseHandler(), new BceErrorResponseHandler(), new BosObjectResponseHandler(), new BceJsonResponseHandler()};

    public BosClient() {
        this(new BosClientConfiguration());
    }

    private void addResponseHeaderParameters(InternalRequest internalRequest, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.getCacheControl() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, responseHeaderOverrides.getCacheControl());
            }
            if (responseHeaderOverrides.getContentDisposition() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, responseHeaderOverrides.getContentDisposition());
            }
            if (responseHeaderOverrides.getContentEncoding() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, responseHeaderOverrides.getContentEncoding());
            }
            if (responseHeaderOverrides.getContentLanguage() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, responseHeaderOverrides.getContentLanguage());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.getExpires() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES, responseHeaderOverrides.getExpires());
            }
        }
    }

    private void assertStringNotNullOrEmpty(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException(str2);
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    private URL convertRequestToUrl(InternalRequest<AbstractBceRequest> internalRequest) {
        String str;
        String str2;
        String normalizePath = HttpUtils.normalizePath(internalRequest.getUri().getPath());
        boolean z = true;
        if (normalizePath.startsWith("/")) {
            normalizePath = normalizePath.substring(1);
        }
        String str3 = getEndpoint() + ("/" + normalizePath).replaceAll("(?<=/)/", "%2F");
        for (String next : internalRequest.getParameters().keySet()) {
            if (z) {
                str2 = str3 + "?";
                z = false;
            } else {
                str2 = str3 + a.n;
            }
            str3 = str2 + next + "=" + HttpUtils.normalize(internalRequest.getParameters().get(next));
        }
        String str4 = internalRequest.getHeaders().get("Authorization");
        if (str4 != null) {
            if (z) {
                str = str3 + "?";
            } else {
                str = str3 + a.n;
            }
            str3 = str + "authorization=" + HttpUtils.normalize(str4);
        }
        try {
            return new URL(str3);
        } catch (MalformedURLException e) {
            throw new BceClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }

    private <T extends AbstractBceRequest> InternalRequest createRequest(T t, HttpMethodName httpMethodName) {
        String str = null;
        String bucketName = t instanceof GenericBucketRequest ? ((GenericBucketRequest) t).getBucketName() : null;
        if (t instanceof GenericObjectRequest) {
            str = ((GenericObjectRequest) t).getKey();
        }
        InternalRequest internalRequest = new InternalRequest(httpMethodName, HttpUtils.appendUri(getEndpoint(), "v1", bucketName, str));
        internalRequest.setCredentials(t.getRequestCredentials());
        internalRequest.setRequest(t);
        return internalRequest;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fd A[SYNTHETIC, Splitter:B:62:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadObjectToFile(com.baidubce.services.bos.model.BosObject r9, java.io.File r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Couldn't get object content"
            java.lang.String r1 = "Couldn't close the output stream"
            java.io.File r2 = r10.getParentFile()
            if (r2 == 0) goto L_0x0013
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0013
            r2.mkdirs()
        L_0x0013:
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00d1 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00d1 }
            r4.<init>(r10)     // Catch:{ IOException -> 0x00d1 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00d1 }
            int r4 = r8.getStreamBufferSize()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
        L_0x0024:
            com.baidubce.services.bos.BosObjectInputStream r5 = r9.getObjectContent()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            int r5 = r5.read(r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r6 = -1
            r7 = 0
            if (r5 <= r6) goto L_0x0034
            r3.write(r4, r7, r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            goto L_0x0024
        L_0x0034:
            r3.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r3 = move-exception
            java.lang.Throwable r3 = r3.getCause()
            com.baidubce.util.BLog.error((java.lang.String) r1, (java.lang.Throwable) r3)
        L_0x0040:
            com.baidubce.services.bos.BosObjectInputStream r1 = r9.getObjectContent()     // Catch:{ Exception -> 0x0048 }
            r1.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0050
        L_0x0048:
            r1 = move-exception
            java.lang.Throwable r1 = r1.getCause()
            com.baidubce.util.BLog.error((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0050:
            if (r11 == 0) goto L_0x00c8
            com.baidubce.services.bos.model.ObjectMetadata r9 = r9.getObjectMetadata()
            java.lang.String r11 = r9.getBceContentSha256()     // Catch:{ Exception -> 0x0094 }
            if (r11 == 0) goto L_0x0074
            java.lang.String r9 = r9.getBceContentSha256()     // Catch:{ Exception -> 0x0094 }
            char[] r9 = r9.toCharArray()     // Catch:{ Exception -> 0x0094 }
            byte[] r9 = com.baidubce.util.ConvertUtils.decodeHex(r9)     // Catch:{ Exception -> 0x0094 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0072 }
            byte[] r11 = com.baidubce.util.HashUtils.computeSha256Hash(r11)     // Catch:{ Exception -> 0x0072 }
            goto L_0x009c
        L_0x0072:
            r11 = move-exception
            goto L_0x0096
        L_0x0074:
            java.lang.String r11 = r9.getContentMd5()     // Catch:{ Exception -> 0x0094 }
            if (r11 == 0) goto L_0x0092
            java.lang.String r9 = r9.getContentMd5()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r11 = "UTF-8"
            byte[] r9 = r9.getBytes(r11)     // Catch:{ Exception -> 0x0094 }
            byte[] r9 = android.util.Base64.decode(r9, r7)     // Catch:{ Exception -> 0x0094 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0072 }
            byte[] r11 = com.baidubce.util.HashUtils.computeMd5Hash(r11)     // Catch:{ Exception -> 0x0072 }
            goto L_0x009c
        L_0x0092:
            r11 = r2
            goto L_0x009d
        L_0x0094:
            r11 = move-exception
            r9 = r2
        L_0x0096:
            java.lang.String r0 = "Unable to verify the integrity of the downloaded file"
            com.baidubce.util.BLog.error((java.lang.String) r0, (java.lang.Throwable) r11)
            r11 = r2
        L_0x009c:
            r2 = r9
        L_0x009d:
            if (r2 == 0) goto L_0x00c8
            if (r11 == 0) goto L_0x00c8
            boolean r9 = java.util.Arrays.equals(r11, r2)
            if (r9 == 0) goto L_0x00a8
            goto L_0x00c8
        L_0x00a8:
            com.baidubce.BceClientException r9 = new com.baidubce.BceClientException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Integrity verification failed! Client calculated content hash didn't match hash from server. The data stored in '"
            r11.append(r0)
            java.lang.String r10 = r10.getAbsolutePath()
            r11.append(r10)
            java.lang.String r10 = "' may be corrupt."
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c8:
            return
        L_0x00c9:
            r10 = move-exception
            r2 = r3
            goto L_0x00fb
        L_0x00cc:
            r10 = move-exception
            r2 = r3
            goto L_0x00d2
        L_0x00cf:
            r10 = move-exception
            goto L_0x00fb
        L_0x00d1:
            r10 = move-exception
        L_0x00d2:
            com.baidubce.services.bos.BosObjectInputStream r11 = r9.getObjectContent()     // Catch:{ IOException -> 0x00da }
            r11.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00e0
        L_0x00da:
            r11 = move-exception
            java.lang.String r3 = "Couldn't abort stream"
            com.baidubce.util.BLog.error((java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x00cf }
        L_0x00e0:
            com.baidubce.BceClientException r11 = new com.baidubce.BceClientException     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r3.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r4 = "Unable to write to disk:"
            r3.append(r4)     // Catch:{ all -> 0x00cf }
            java.lang.String r4 = r10.getMessage()     // Catch:{ all -> 0x00cf }
            r3.append(r4)     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cf }
            r11.<init>(r3, r10)     // Catch:{ all -> 0x00cf }
            throw r11     // Catch:{ all -> 0x00cf }
        L_0x00fb:
            if (r2 == 0) goto L_0x0109
            r2.close()     // Catch:{ Exception -> 0x0101 }
            goto L_0x0109
        L_0x0101:
            r11 = move-exception
            java.lang.Throwable r11 = r11.getCause()
            com.baidubce.util.BLog.error((java.lang.String) r1, (java.lang.Throwable) r11)
        L_0x0109:
            com.baidubce.services.bos.BosObjectInputStream r9 = r9.getObjectContent()     // Catch:{ Exception -> 0x0111 }
            r9.close()     // Catch:{ Exception -> 0x0111 }
            goto L_0x0119
        L_0x0111:
            r9 = move-exception
            java.lang.Throwable r9 = r9.getCause()
            com.baidubce.util.BLog.error((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0119:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.downloadObjectToFile(com.baidubce.services.bos.model.BosObject, java.io.File, boolean):void");
    }

    private int getStreamBufferSize() {
        return ((BosClientConfiguration) this.config).getStreamBufferSize();
    }

    public static void populateRequestMetadata(InternalRequest internalRequest, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentType() != null) {
            internalRequest.addHeader("Content-Type", objectMetadata.getContentType());
        }
        if (objectMetadata.getContentMd5() != null) {
            internalRequest.addHeader("Content-MD5", objectMetadata.getContentMd5());
        }
        if (objectMetadata.getContentEncoding() != null) {
            internalRequest.addHeader("Content-Encoding", HttpUtils.normalize(objectMetadata.getContentEncoding()));
        }
        if (objectMetadata.getBceContentSha256() != null) {
            internalRequest.addHeader(Headers.BCE_CONTENT_SHA256, objectMetadata.getBceContentSha256());
        }
        if (objectMetadata.getContentDisposition() != null) {
            internalRequest.addHeader("Content-Disposition", HttpUtils.normalize(objectMetadata.getContentDisposition()));
        }
        if (objectMetadata.getETag() != null) {
            internalRequest.addHeader("ETag", objectMetadata.getETag());
        }
        if (objectMetadata.getExpires() != null) {
            internalRequest.addHeader("Expires", objectMetadata.getExpires());
        }
        if (objectMetadata.getCacheControl() != null) {
            internalRequest.addHeader("Cache-Control", objectMetadata.getCacheControl());
        }
        if (objectMetadata.getStorageClass() != null) {
            internalRequest.addHeader(Headers.BCE_STORAGE_CLASS, objectMetadata.getStorageClass());
        }
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null) {
            for (Map.Entry next : userMetadata.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    String str2 = (String) next.getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str.length() + str2.length() <= 32768) {
                        internalRequest.addHeader(Headers.BCE_USER_METADATA_PREFIX + HttpUtils.normalize(str.trim()), HttpUtils.normalize(str2));
                    } else {
                        throw new BceClientException("MetadataTooLarge");
                    }
                }
            }
        }
    }

    private List<byte[]> readAll(InputStream inputStream, ObjectMetadata objectMetadata) {
        ArrayList arrayList = new ArrayList();
        int streamBufferSize = getStreamBufferSize();
        long j = 0;
        while (true) {
            byte[] bArr = new byte[streamBufferSize];
            arrayList.add(bArr);
            int i2 = 0;
            while (true) {
                if (i2 < streamBufferSize) {
                    try {
                        int read = inputStream.read(bArr, i2, streamBufferSize - i2);
                        if (read < 0) {
                            objectMetadata.setContentLength(j);
                            return arrayList;
                        }
                        j += (long) read;
                        i2 += read;
                    } catch (IOException e) {
                        throw new BceClientException("Fail to read data:" + e.getMessage(), e);
                    }
                }
            }
        }
    }

    private void setZeroContentLength(InternalRequest internalRequest) {
        internalRequest.addHeader("Content-Length", String.valueOf(0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC, Splitter:B:31:0x0082] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidubce.services.bos.model.BosResponse uploadObject(com.baidubce.services.bos.model.PutObjectRequest r12, com.baidubce.internal.InternalRequest r13) {
        /*
            r11 = this;
            java.lang.String r0 = "The inputStream accured error"
            java.lang.String r1 = "Fail to close input stream"
            com.baidubce.services.bos.model.ObjectMetadata r2 = r12.getObjectMetadata()
            java.io.InputStream r3 = r12.getInputStream()
            java.io.File r4 = r12.getFile()
            r5 = 0
            if (r4 == 0) goto L_0x00b3
            java.io.File r3 = r12.getFile()
            long r7 = r3.length()
            r9 = 5368709120(0x140000000, double:2.6524947387E-314)
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x009c
            long r7 = r2.getContentLength()
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0034
            long r4 = r3.length()
            r2.setContentLength(r4)
        L_0x0034:
            java.lang.String r4 = r2.getContentType()
            if (r4 != 0) goto L_0x0045
            com.baidubce.util.Mimetypes r4 = com.baidubce.util.Mimetypes.getInstance()
            java.lang.String r4 = r4.getMimetype((java.io.File) r3)
            r2.setContentType(r4)
        L_0x0045:
            long r4 = r2.getContentLength()
            long r6 = r3.length()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x008a
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0077 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            byte[] r6 = com.baidubce.util.HashUtils.computeSha256Hash(r5)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            char[] r6 = com.baidubce.util.ConvertUtils.encodeHex(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r2.setBceContentSha256(r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r5.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x008a
        L_0x006b:
            com.baidubce.util.BLog.error(r0)
            goto L_0x008a
        L_0x006f:
            r12 = move-exception
            r4 = r5
            goto L_0x0080
        L_0x0072:
            r12 = move-exception
            r4 = r5
            goto L_0x0078
        L_0x0075:
            r12 = move-exception
            goto L_0x0080
        L_0x0077:
            r12 = move-exception
        L_0x0078:
            com.baidubce.BceClientException r13 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "Unable to calculate SHA-256 hash"
            r13.<init>(r1, r12)     // Catch:{ all -> 0x0075 }
            throw r13     // Catch:{ all -> 0x0075 }
        L_0x0080:
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0089
        L_0x0086:
            com.baidubce.util.BLog.error(r0)
        L_0x0089:
            throw r12
        L_0x008a:
            com.baidubce.internal.RestartableFileInputStream r0 = new com.baidubce.internal.RestartableFileInputStream     // Catch:{ FileNotFoundException -> 0x0093 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0093 }
            r13.setContent(r0)     // Catch:{ FileNotFoundException -> 0x0093 }
            goto L_0x00fc
        L_0x0093:
            r12 = move-exception
            com.baidubce.BceClientException r13 = new com.baidubce.BceClientException
            java.lang.String r0 = "Unable to find file to upload"
            r13.<init>(r0, r12)
            throw r13
        L_0x009c:
            com.baidubce.BceServiceException r12 = new com.baidubce.BceServiceException
            java.lang.String r13 = "Your proposed upload exceeds the maximum allowed object size."
            r12.<init>(r13)
            r13 = 400(0x190, float:5.6E-43)
            r12.setStatusCode(r13)
            java.lang.String r13 = "EntityTooLarge"
            r12.setErrorCode(r13)
            com.baidubce.BceServiceException$ErrorType r13 = com.baidubce.BceServiceException.ErrorType.Client
            r12.setErrorType(r13)
            throw r12
        L_0x00b3:
            java.lang.String r0 = "Either file or inputStream should be set."
            com.baidubce.util.CheckUtils.isNotNull(r3, r0)
            long r7 = r2.getContentLength()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d6
            java.lang.String r0 = "No content length specified for stream data. Trying to read them all into memory."
            com.baidubce.util.BLog.warn(r0)
            java.util.List r0 = r11.readAll(r3, r2)
            com.baidubce.internal.RestartableMultiByteArrayInputStream r3 = new com.baidubce.internal.RestartableMultiByteArrayInputStream
            long r4 = r2.getContentLength()
            r3.<init>(r0, r4)
            r13.setContent(r3)
            goto L_0x00e7
        L_0x00d6:
            boolean r0 = r3 instanceof com.baidubce.internal.RestartableInputStream
            if (r0 == 0) goto L_0x00e0
            com.baidubce.internal.RestartableInputStream r3 = (com.baidubce.internal.RestartableInputStream) r3
            r13.setContent(r3)
            goto L_0x00e7
        L_0x00e0:
            com.baidubce.internal.RestartableInputStream r0 = r11.wrapRestartableInputStream(r3)
            r13.setContent(r0)
        L_0x00e7:
            java.lang.String r0 = r2.getContentType()
            if (r0 != 0) goto L_0x00fc
            com.baidubce.util.Mimetypes r0 = com.baidubce.util.Mimetypes.getInstance()
            java.lang.String r3 = r12.getKey()
            java.lang.String r0 = r0.getMimetype((java.lang.String) r3)
            r2.setContentType(r0)
        L_0x00fc:
            java.lang.String r0 = r12.getStorageClass()
            if (r0 == 0) goto L_0x0109
            java.lang.String r0 = r12.getStorageClass()
            r2.setStorageClass(r0)
        L_0x0109:
            long r3 = r2.getContentLength()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "Content-Length"
            r13.addHeader(r3, r0)
            populateRequestMetadata(r13, r2)
            java.lang.Class<com.baidubce.services.bos.model.BosResponse> r0 = com.baidubce.services.bos.model.BosResponse.class
            com.baidubce.services.bos.callback.BosProgressCallback r12 = r12.getProgressCallback()     // Catch:{ all -> 0x0132 }
            com.baidubce.model.AbstractBceResponse r12 = r11.invokeHttpClient(r13, r0, r12)     // Catch:{ all -> 0x0132 }
            com.baidubce.services.bos.model.BosResponse r12 = (com.baidubce.services.bos.model.BosResponse) r12     // Catch:{ all -> 0x0132 }
            com.baidubce.internal.RestartableInputStream r13 = r13.getContent()     // Catch:{ Exception -> 0x012d }
            r13.close()     // Catch:{ Exception -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r13 = move-exception
            com.baidubce.util.BLog.error((java.lang.String) r1, (java.lang.Throwable) r13)
        L_0x0131:
            return r12
        L_0x0132:
            r12 = move-exception
            com.baidubce.internal.RestartableInputStream r13 = r13.getContent()     // Catch:{ Exception -> 0x013b }
            r13.close()     // Catch:{ Exception -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r13 = move-exception
            com.baidubce.util.BLog.error((java.lang.String) r1, (java.lang.Throwable) r13)
        L_0x013f:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.uploadObject(com.baidubce.services.bos.model.PutObjectRequest, com.baidubce.internal.InternalRequest):com.baidubce.services.bos.model.BosResponse");
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, getStreamBufferSize());
    }

    public void abortMultipartUpload(String str, String str2, String str3) {
        abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
    }

    public AppendObjectResponse appendObject(String str, String str2, File file) {
        return appendObject(new AppendObjectRequest(str, str2, file));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list));
    }

    public CopyObjectResponse copyObject(String str, String str2, String str3, String str4) {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CreateBucketResponse createBucket(String str) {
        return createBucket(new CreateBucketRequest(str));
    }

    public void deleteBucket(String str) {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteObject(String str, String str2) {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public boolean doesBucketExist(String str) {
        return doesBucketExist(new DoesBucketExistRequest(str));
    }

    public URL generatePresignedUrl(String str, String str2, int i2) {
        return generatePresignedUrl(str, str2, i2, HttpMethodName.GET);
    }

    public User getBosAccountOwner() {
        return getBosAccountOwner(new GetBosAccountOwnerRequest());
    }

    public GetBucketAclResponse getBucketAcl(String str) {
        return getBucketAcl(new GetBucketAclRequest(str));
    }

    public GetBucketLocationResponse getBucketLocation(String str) {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public BosObject getObject(String str, String str2) {
        return getObject(new GetObjectRequest(str, str2));
    }

    public byte[] getObjectContent(String str, String str2) {
        return getObjectContent(new GetObjectRequest(str, str2));
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(String str, String str2) {
        return initiateMultipartUpload(new InitiateMultipartUploadRequest(str, str2));
    }

    public ListBucketsResponse listBuckets() {
        return listBuckets(new ListBucketsRequest());
    }

    public ListMultipartUploadsResponse listMultipartUploads(String str) {
        return listMultipartUploads(new ListMultipartUploadsRequest(str));
    }

    public ListObjectsResponse listNextBatchOfObjects(ListObjectsResponse listObjectsResponse) {
        CheckUtils.isNotNull(listObjectsResponse, "previousResponse should not be null.");
        if (listObjectsResponse.isTruncated()) {
            return listObjects(new ListObjectsRequest(listObjectsResponse.getBucketName()).withPrefix(listObjectsResponse.getPrefix()).withMarker(listObjectsResponse.getNextMarker()).withDelimiter(listObjectsResponse.getDelimiter()).withMaxKeys(listObjectsResponse.getMaxKeys()));
        }
        ListObjectsResponse listObjectsResponse2 = new ListObjectsResponse();
        listObjectsResponse2.setBucketName(listObjectsResponse.getBucketName());
        listObjectsResponse2.setDelimiter(listObjectsResponse.getDelimiter());
        listObjectsResponse2.setMarker(listObjectsResponse.getNextMarker());
        listObjectsResponse2.setMaxKeys(listObjectsResponse.getMaxKeys());
        listObjectsResponse2.setPrefix(listObjectsResponse.getPrefix());
        listObjectsResponse2.setTruncated(false);
        return listObjectsResponse2;
    }

    public ListObjectsResponse listObjects(String str) {
        return listObjects(new ListObjectsRequest(str));
    }

    public ListPartsResponse listParts(String str, String str2, String str3) {
        return listParts(new ListPartsRequest(str, str2, str3));
    }

    public PutObjectResponse putObject(String str, String str2, File file) {
        return putObject(new PutObjectRequest(str, str2, file));
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws JSONException {
        setBucketAcl(new SetBucketAclRequest(str, cannedAccessControlList));
    }

    @Deprecated
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, BosProgressCallback bosProgressCallback) {
        uploadPartRequest.setProgressCallback(bosProgressCallback);
        return uploadPart(uploadPartRequest);
    }

    public BosClient(BosClientConfiguration bosClientConfiguration) {
        super(bosClientConfiguration, bos_handlers);
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        CheckUtils.isNotNull(abortMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, file, objectMetadata));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list, objectMetadata));
    }

    public CreateBucketResponse createBucket(CreateBucketRequest createBucketRequest) {
        CheckUtils.isNotNull(createBucketRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(createBucketRequest, HttpMethodName.PUT);
        setZeroContentLength(createRequest);
        CreateBucketResponse createBucketResponse = new CreateBucketResponse();
        createBucketResponse.setName(createBucketRequest.getBucketName());
        createBucketResponse.setLocation(((BosResponse) invokeHttpClient(createRequest, BosResponse.class)).getMetadata().getLocation());
        return createBucketResponse;
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        CheckUtils.isNotNull(deleteBucketRequest, "request should not be null.");
        invokeHttpClient(createRequest(deleteBucketRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) {
        CheckUtils.isNotNull(deleteObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(deleteObjectRequest.getKey(), "object key should not be null or empty");
        invokeHttpClient(createRequest(deleteObjectRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public boolean doesBucketExist(DoesBucketExistRequest doesBucketExistRequest) {
        CheckUtils.isNotNull(doesBucketExistRequest, "request should not be null.");
        try {
            invokeHttpClient(createRequest(doesBucketExistRequest, HttpMethodName.HEAD), BosResponse.class);
            return true;
        } catch (BceServiceException e) {
            if (e.getStatusCode() == 403) {
                return true;
            }
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public URL generatePresignedUrl(String str, String str2, int i2, HttpMethodName httpMethodName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethodName);
        generatePresignedUrlRequest.setExpiration(i2);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public User getBosAccountOwner(GetBosAccountOwnerRequest getBosAccountOwnerRequest) {
        CheckUtils.isNotNull(getBosAccountOwnerRequest, "request should not be null.");
        return ((ListBucketsResponse) invokeHttpClient(createRequest(getBosAccountOwnerRequest, HttpMethodName.GET), ListBucketsResponse.class)).getOwner();
    }

    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) {
        CheckUtils.isNotNull(getBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketAclRequest, HttpMethodName.GET);
        createRequest.addParameter("acl", (String) null);
        GetBucketAclResponse getBucketAclResponse = (GetBucketAclResponse) invokeHttpClient(createRequest, GetBucketAclResponse.class);
        if (getBucketAclResponse.getVersion() <= 1) {
            return getBucketAclResponse;
        }
        throw new BceClientException("Unsupported acl version.");
    }

    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) {
        CheckUtils.isNotNull(getBucketLocationRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter(b.c.j, (String) null);
        return (GetBucketLocationResponse) invokeHttpClient(createRequest, GetBucketLocationResponse.class);
    }

    public ObjectMetadata getObject(String str, String str2, File file) {
        return getObject(new GetObjectRequest(str, str2), file);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getObjectContent(com.baidubce.services.bos.model.GetObjectRequest r5) {
        /*
            r4 = this;
            com.baidubce.services.bos.model.BosObject r5 = r4.getObject(r5)
            com.baidubce.services.bos.BosObjectInputStream r5 = r5.getObjectContent()
            byte[] r0 = com.baidubce.util.ConvertUtils.inputStreamToByte(r5)     // Catch:{ IOException -> 0x0012 }
            r5.close()     // Catch:{ IOException -> 0x000f }
        L_0x000f:
            return r0
        L_0x0010:
            r0 = move-exception
            goto L_0x0031
        L_0x0012:
            r0 = move-exception
            r5.close()     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            com.baidubce.BceClientException r1 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r2.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "Fail read object content:"
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0010 }
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0010 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0010 }
            throw r1     // Catch:{ all -> 0x0010 }
        L_0x0031:
            r5.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.getObjectContent(com.baidubce.services.bos.model.GetObjectRequest):byte[]");
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        CheckUtils.isNotNull(getObjectMetadataRequest, "request should not be null.");
        return ((GetObjectResponse) invokeHttpClient(createRequest(getObjectMetadataRequest, HttpMethodName.HEAD), GetObjectResponse.class)).getObject().getObjectMetadata();
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        CheckUtils.isNotNull(initiateMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploads", (String) null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass());
        }
        setZeroContentLength(createRequest);
        if (initiateMultipartUploadRequest.getObjectMetadata() != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.getObjectMetadata());
        }
        return (InitiateMultipartUploadResponse) invokeHttpClient(createRequest, InitiateMultipartUploadResponse.class);
    }

    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) {
        CheckUtils.isNotNull(listBucketsRequest, "request should not be null.");
        return (ListBucketsResponse) invokeHttpClient(createRequest(listBucketsRequest, HttpMethodName.GET), ListBucketsResponse.class);
    }

    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        CheckUtils.isNotNull(listMultipartUploadsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listMultipartUploadsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploads", (String) null);
        String keyMarker = listMultipartUploadsRequest.getKeyMarker();
        if (keyMarker != null) {
            createRequest.addParameter("keyMarker", keyMarker);
        }
        int maxUploads = listMultipartUploadsRequest.getMaxUploads();
        if (maxUploads >= 0) {
            createRequest.addParameter("maxUploads", String.valueOf(maxUploads));
        }
        String delimiter = listMultipartUploadsRequest.getDelimiter();
        if (delimiter != null) {
            createRequest.addParameter("delimiter", delimiter);
        }
        String prefix = listMultipartUploadsRequest.getPrefix();
        if (prefix != null) {
            createRequest.addParameter("prefix", prefix);
        }
        ListMultipartUploadsResponse listMultipartUploadsResponse = (ListMultipartUploadsResponse) invokeHttpClient(createRequest, ListMultipartUploadsResponse.class);
        listMultipartUploadsResponse.setBucketName(listMultipartUploadsRequest.getBucketName());
        return listMultipartUploadsResponse;
    }

    public ListObjectsResponse listObjects(String str, String str2) {
        return listObjects(new ListObjectsRequest(str, str2));
    }

    public ListPartsResponse listParts(ListPartsRequest listPartsRequest) {
        CheckUtils.isNotNull(listPartsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listPartsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploadId", listPartsRequest.getUploadId());
        int maxParts = listPartsRequest.getMaxParts();
        if (maxParts >= 0) {
            createRequest.addParameter("maxParts", String.valueOf(maxParts));
        }
        createRequest.addParameter("partNumberMarker", String.valueOf(listPartsRequest.getPartNumberMarker()));
        ListPartsResponse listPartsResponse = (ListPartsResponse) invokeHttpClient(createRequest, ListPartsResponse.class);
        listPartsResponse.setBucketName(listPartsRequest.getBucketName());
        return listPartsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, file, objectMetadata));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws JSONException {
        CheckUtils.isNotNull(setBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(setBucketAclRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", (String) null);
        if (setBucketAclRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.BCE_ACL, setBucketAclRequest.getCannedAcl().toString());
            setZeroContentLength(createRequest);
        } else if (setBucketAclRequest.getAccessControlList() != null) {
            try {
                byte[] bytes = JsonUtils.setAclJson(setBucketAclRequest.getAccessControlList()).getBytes("UTF-8");
                createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
                createRequest.addHeader("Content-Type", "application/json");
                createRequest.setContent(RestartableInputStream.wrap(bytes));
            } catch (UnsupportedEncodingException e) {
                throw new BceClientException("Fail to get UTF-8 bytes:" + e.getMessage(), e);
            }
        } else {
            CheckUtils.isNotNull(null, "request.acl should not be null.");
        }
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes.", e);
        }
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws JSONException {
        CheckUtils.isNotNull(completeMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(completeMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploadId", completeMultipartUploadRequest.getUploadId());
        ObjectMetadata objectMetadata = completeMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata != null) {
            populateRequestMetadata(createRequest, objectMetadata);
        }
        try {
            byte[] bytes = JsonUtils.setPartETag(completeMultipartUploadRequest.getPartETags()).getBytes("UTF-8");
            createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
            createRequest.addHeader("Content-Type", "application/json");
            createRequest.setContent(RestartableInputStream.wrap(bytes));
            CompleteMultipartUploadResponse completeMultipartUploadResponse = (CompleteMultipartUploadResponse) invokeHttpClient(createRequest, CompleteMultipartUploadResponse.class);
            completeMultipartUploadResponse.setBucketName(completeMultipartUploadRequest.getBucketName());
            return completeMultipartUploadResponse;
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get UTF-8 bytes:" + e.getMessage(), e);
        }
    }

    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) {
        CheckUtils.isNotNull(copyObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(copyObjectRequest.getSourceKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(copyObjectRequest, HttpMethodName.PUT);
        createRequest.addHeader(Headers.BCE_COPY_SOURCE, HttpUtils.normalizePath("/" + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey()));
        if (copyObjectRequest.getETag() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MATCH, "\"" + copyObjectRequest.getETag() + "\"");
        }
        if (copyObjectRequest.getNoneMatchETagConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_NONE_MATCH, "\"" + copyObjectRequest.getNoneMatchETagConstraint() + "\"");
        }
        if (copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        }
        if (copyObjectRequest.getModifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            createRequest.addHeader(Headers.BCE_COPY_METADATA_DIRECTIVE, "replace");
            populateRequestMetadata(createRequest, newObjectMetadata);
        } else {
            createRequest.addHeader(Headers.BCE_COPY_METADATA_DIRECTIVE, "copy");
        }
        setZeroContentLength(createRequest);
        CopyObjectResponseWithExceptionInfo copyObjectResponseWithExceptionInfo = (CopyObjectResponseWithExceptionInfo) invokeHttpClient(createRequest, CopyObjectResponseWithExceptionInfo.class);
        if (copyObjectResponseWithExceptionInfo.getETag() != null || copyObjectResponseWithExceptionInfo.getLastModified() != null || copyObjectResponseWithExceptionInfo.getMessage() == null) {
            return copyObjectResponseWithExceptionInfo;
        }
        BceServiceException bceServiceException = new BceServiceException(copyObjectResponseWithExceptionInfo.getMessage());
        bceServiceException.setErrorCode(copyObjectResponseWithExceptionInfo.getCode());
        bceServiceException.setRequestId(copyObjectResponseWithExceptionInfo.getRequestId());
        if (bceServiceException.getErrorCode() == "InternalError") {
            bceServiceException.setErrorType(BceServiceException.ErrorType.Service);
        } else {
            bceServiceException.setErrorType(BceServiceException.ErrorType.Client);
        }
        bceServiceException.setStatusCode(500);
        throw bceServiceException;
    }

    public BosObject getObject(GetObjectRequest getObjectRequest) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getObjectRequest, HttpMethodName.GET);
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            createRequest.addHeader("Range", "bytes=" + range[0] + "-" + range[1]);
        }
        BosObject object = ((GetObjectResponse) invokeHttpClient(createRequest, GetObjectResponse.class)).getObject();
        object.setBucketName(getObjectRequest.getBucketName());
        object.setKey(getObjectRequest.getKey());
        return object;
    }

    public ListObjectsResponse listObjects(ListObjectsRequest listObjectsRequest) {
        CheckUtils.isNotNull(listObjectsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listObjectsRequest, HttpMethodName.GET);
        if (listObjectsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            createRequest.addParameter("marker", listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() >= 0) {
            createRequest.addParameter("maxKeys", String.valueOf(listObjectsRequest.getMaxKeys()));
        }
        ListObjectsResponse listObjectsResponse = (ListObjectsResponse) invokeHttpClient(createRequest, ListObjectsResponse.class);
        listObjectsResponse.setBucketName(listObjectsRequest.getBucketName());
        for (BosObjectSummary bucketName : listObjectsResponse.getContents()) {
            bucketName.setBucketName(listObjectsRequest.getBucketName());
        }
        return listObjectsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, String str3) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes:" + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidubce.services.bos.model.UploadPartResponse uploadPart(com.baidubce.services.bos.model.UploadPartRequest r6) {
        /*
            r5 = this;
            java.lang.String r0 = "request should not be null."
            com.baidubce.util.CheckUtils.isNotNull(r6, r0)
            long r0 = r6.getPartSize()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "partSize should not be null"
            com.baidubce.util.CheckUtils.isNotNull(r0, r1)
            int r0 = r6.getPartNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "partNumber should not be null"
            com.baidubce.util.CheckUtils.isNotNull(r0, r1)
            long r0 = r6.getPartSize()
            r2 = 5368709120(0x140000000, double:2.6524947387E-314)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00ee
            com.baidubce.http.HttpMethodName r0 = com.baidubce.http.HttpMethodName.PUT
            com.baidubce.internal.InternalRequest r0 = r5.createRequest(r6, r0)
            java.lang.String r1 = r6.getUploadId()
            java.lang.String r2 = "uploadId"
            r0.addParameter(r2, r1)
            int r1 = r6.getPartNumber()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "partNumber"
            r0.addParameter(r2, r1)
            long r1 = r6.getPartSize()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Content-Length"
            r0.addHeader(r2, r1)
            java.io.InputStream r1 = r6.getInputStream()
            r2 = 0
            java.lang.String r3 = r6.getMd5Digest()
            if (r3 != 0) goto L_0x006e
            com.baidubce.util.MD5DigestCalculatingInputStream r3 = new com.baidubce.util.MD5DigestCalculatingInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0068 }
            r3.<init>(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0068 }
            r1 = r3
            r2 = r1
            goto L_0x006e
        L_0x0068:
            r3 = move-exception
            java.lang.String r4 = "Unable to verify data integrity."
            com.baidubce.util.BLog.error((java.lang.String) r4, (java.lang.Throwable) r3)
        L_0x006e:
            long r3 = r6.getPartSize()     // Catch:{ all -> 0x00e7 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00e7 }
            com.baidubce.internal.RestartableInputStream r3 = r5.wrapRestartableInputStream(r1, r3)     // Catch:{ all -> 0x00e7 }
            r0.setContent(r3)     // Catch:{ all -> 0x00e7 }
            java.lang.Class<com.baidubce.services.bos.model.BosResponse> r3 = com.baidubce.services.bos.model.BosResponse.class
            com.baidubce.services.bos.callback.BosProgressCallback r4 = r6.getProgressCallback()     // Catch:{ all -> 0x00e7 }
            com.baidubce.model.AbstractBceResponse r0 = r5.invokeHttpClient(r0, r3, r4)     // Catch:{ all -> 0x00e7 }
            com.baidubce.services.bos.model.BosResponse r0 = (com.baidubce.services.bos.model.BosResponse) r0     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x00ca
            byte[] r2 = r2.getMd5Digest()     // Catch:{ all -> 0x00e7 }
            com.baidubce.services.bos.model.BosResponseMetadata r3 = r0.getMetadata()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r3 = r3.getETag()     // Catch:{ Exception -> 0x00ae }
            char[] r3 = r3.toCharArray()     // Catch:{ Exception -> 0x00ae }
            byte[] r3 = com.baidubce.util.ConvertUtils.decodeHex(r3)     // Catch:{ Exception -> 0x00ae }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x00a6
            goto L_0x00ca
        L_0x00a6:
            com.baidubce.BceClientException r6 = new com.baidubce.BceClientException     // Catch:{ all -> 0x00e7 }
            java.lang.String r0 = "Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Baidu BOS.  You may need to delete the data stored in Baidu BOS."
            r6.<init>(r0)     // Catch:{ all -> 0x00e7 }
            throw r6     // Catch:{ all -> 0x00e7 }
        L_0x00ae:
            r6 = move-exception
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException     // Catch:{ all -> 0x00e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e7 }
            r2.<init>()     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = "Unable to verify integrity of data upload:"
            r2.append(r3)     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x00e7 }
            r2.append(r3)     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e7 }
            r0.<init>(r2, r6)     // Catch:{ all -> 0x00e7 }
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x00ca:
            com.baidubce.services.bos.model.UploadPartResponse r2 = new com.baidubce.services.bos.model.UploadPartResponse     // Catch:{ all -> 0x00e7 }
            r2.<init>()     // Catch:{ all -> 0x00e7 }
            com.baidubce.services.bos.model.BosResponseMetadata r0 = r0.getMetadata()     // Catch:{ all -> 0x00e7 }
            java.lang.String r0 = r0.getETag()     // Catch:{ all -> 0x00e7 }
            r2.setETag(r0)     // Catch:{ all -> 0x00e7 }
            int r6 = r6.getPartNumber()     // Catch:{ all -> 0x00e7 }
            r2.setPartNumber(r6)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00e6
            r1.close()     // Catch:{ Exception -> 0x00e6 }
        L_0x00e6:
            return r2
        L_0x00e7:
            r6 = move-exception
            if (r1 == 0) goto L_0x00ed
            r1.close()     // Catch:{ Exception -> 0x00ed }
        L_0x00ed:
            throw r6
        L_0x00ee:
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "PartNumber "
            r1.append(r2)
            int r6 = r6.getPartNumber()
            r1.append(r6)
            java.lang.String r6 = " : Part Size should not be more than 5GB."
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.uploadPart(com.baidubce.services.bos.model.UploadPartRequest):com.baidubce.services.bos.model.UploadPartResponse");
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream, Long l) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, l.longValue() > ((long) getStreamBufferSize()) ? getStreamBufferSize() : l.intValue());
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes.", e);
        }
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        CheckUtils.isNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        InternalRequest internalRequest = new InternalRequest(HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString()), HttpUtils.appendUri(getEndpoint(), "v1", generatePresignedUrlRequest.getBucketName(), generatePresignedUrlRequest.getKey()));
        internalRequest.setCredentials(generatePresignedUrlRequest.getRequestCredentials());
        SignOptions signOptions = new SignOptions();
        signOptions.setExpirationInSeconds(generatePresignedUrlRequest.getExpiration());
        for (Map.Entry next : generatePresignedUrlRequest.getRequestHeaders().entrySet()) {
            if (next.getValue() == null) {
                internalRequest.addHeader((String) next.getKey(), "");
            } else {
                internalRequest.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
        for (Map.Entry next2 : generatePresignedUrlRequest.getRequestParameters().entrySet()) {
            if (next2.getValue() == null) {
                internalRequest.addParameter((String) next2.getKey(), "");
            } else {
                internalRequest.addParameter((String) next2.getKey(), (String) next2.getValue());
            }
        }
        if (generatePresignedUrlRequest.getContentType() != null) {
            internalRequest.addHeader("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMd5() != null) {
            internalRequest.addHeader("Content-MD5", generatePresignedUrlRequest.getContentMd5());
        }
        addResponseHeaderParameters(internalRequest, generatePresignedUrlRequest.getResponseHeaders());
        new BceV1Signer().sign(internalRequest, this.config.getCredentials(), signOptions);
        return convertRequestToUrl(internalRequest);
    }

    public PutObjectResponse putObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes:" + e.getMessage(), e);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr) {
        return appendObject(str, str2, bArr, new ObjectMetadata());
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr) {
        return putObject(str, str2, bArr, new ObjectMetadata());
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength((long) bArr.length);
        }
        return appendObject(new AppendObjectRequest(str, str2, (InputStream) RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength((long) bArr.length);
        }
        return putObject(new PutObjectRequest(str, str2, (InputStream) RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        CheckUtils.isNotNull(file, "destinationFile should not be null.");
        BosObject object = getObject(getObjectRequest);
        downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
        return object.getObjectMetadata();
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream) {
        return putObject(new PutObjectRequest(str, str2, inputStream));
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
        CheckUtils.isNotNull(putObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(putObjectRequest.getKey(), "object key should not be null or empty");
        BosResponse uploadObject = uploadObject(putObjectRequest, createRequest(putObjectRequest, HttpMethodName.PUT));
        PutObjectResponse putObjectResponse = new PutObjectResponse();
        putObjectResponse.setETag(uploadObject.getMetadata().getETag());
        return putObjectResponse;
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream));
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
        CheckUtils.isNotNull(appendObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(appendObjectRequest.getKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(appendObjectRequest, HttpMethodName.POST);
        createRequest.addParameter("append", (String) null);
        if (appendObjectRequest.getOffset() != null) {
            createRequest.addParameter("offset", appendObjectRequest.getOffset().toString());
        }
        BosResponse uploadObject = uploadObject(appendObjectRequest, createRequest);
        AppendObjectResponse appendObjectResponse = new AppendObjectResponse();
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        appendObjectResponse.setContentMd5(uploadObject.getMetadata().getContentMd5());
        appendObjectResponse.setETag(uploadObject.getMetadata().getETag());
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        return appendObjectResponse;
    }

    @Deprecated
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, BosProgressCallback bosProgressCallback) {
        putObjectRequest.setProgressCallback(bosProgressCallback);
        return putObject(putObjectRequest);
    }
}
