package com.baidubce.util;

import com.baidu.apollon.restnet.http.b;
import com.baidubce.BceErrorResponse;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.model.User;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BucketSummary;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.Grant;
import com.baidubce.services.bos.model.Grantee;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.MultipartUploadSummary;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PartSummary;
import com.baidubce.services.bos.model.Permission;
import com.baidubce.services.sts.StsClient;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    /* renamed from: com.baidubce.util.JsonUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidubce$services$bos$model$Permission;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidubce.services.bos.model.Permission[] r0 = com.baidubce.services.bos.model.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidubce$services$bos$model$Permission = r0
                com.baidubce.services.bos.model.Permission r1 = com.baidubce.services.bos.model.Permission.FULL_CONTROL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidubce$services$bos$model$Permission     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidubce.services.bos.model.Permission r1 = com.baidubce.services.bos.model.Permission.READ     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidubce$services$bos$model$Permission     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidubce.services.bos.model.Permission r1 = com.baidubce.services.bos.model.Permission.WRITE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidubce.util.JsonUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static void load(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        load(bceHttpResponse.getContent(), abstractBceResponse);
    }

    public static BceErrorResponse loadError(InputStream inputStream) throws IOException, JSONException {
        BceErrorResponse bceErrorResponse = new BceErrorResponse();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            str = str + readLine;
        }
        if (str.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        bceErrorResponse.setCode(jSONObject.getString("code"));
        bceErrorResponse.setMessage(jSONObject.getString("message"));
        bceErrorResponse.setRequestId(jSONObject.getString("requestId"));
        return bceErrorResponse;
    }

    public static void loadFromString(String str, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        AbstractBceResponse abstractBceResponse2 = abstractBceResponse;
        Class<String> cls = String.class;
        JSONObject jSONObject = new JSONObject(str);
        if (abstractBceResponse.getClass() == ListBucketsResponse.class) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("owner"));
            User user = new User();
            user.setDisplayName(jSONObject2.getString("displayName"));
            user.setId(jSONObject2.getString("id"));
            JSONArray jSONArray = jSONObject.getJSONArray("buckets");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                BucketSummary bucketSummary = new BucketSummary();
                bucketSummary.setName(optJSONObject.getString("name"));
                bucketSummary.setLocation(optJSONObject.getString(b.c.j));
                bucketSummary.setCreationDate(DateUtils.parseAlternateIso8601Date(optJSONObject.getString("creationDate")));
                arrayList.add(bucketSummary);
            }
            abstractBceResponse.getClass().getMethod("setOwner", new Class[]{User.class}).invoke(abstractBceResponse2, new Object[]{user});
            abstractBceResponse.getClass().getMethod("setBuckets", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList});
            return;
        }
        String str2 = "setOwner";
        String str3 = "displayName";
        String str4 = "id";
        String str5 = "owner";
        if (abstractBceResponse.getClass() == ListObjectsResponse.class) {
            String str6 = "storageClass";
            abstractBceResponse.getClass().getMethod("setBucketName", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("name")});
            abstractBceResponse.getClass().getMethod("setMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("marker")});
            if (jSONObject.has("nextMarker")) {
                abstractBceResponse.getClass().getMethod("setNextMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("nextMarker")});
            }
            abstractBceResponse.getClass().getMethod("setMaxKeys", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{Integer.valueOf(jSONObject.getInt("maxKeys"))});
            if (jSONObject.has("prefix")) {
                abstractBceResponse.getClass().getMethod("setPrefix", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("prefix")});
            }
            if (jSONObject.has("delimiter")) {
                abstractBceResponse.getClass().getMethod("setDelimiter", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("delimiter")});
            }
            abstractBceResponse.getClass().getMethod("setTruncated", new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{Boolean.valueOf(jSONObject.getBoolean("isTruncated"))});
            if (jSONObject.has("commonPrefixes")) {
                Method method = abstractBceResponse.getClass().getMethod("setCommonPrefixes", new Class[]{List.class});
                JSONArray jSONArray2 = jSONObject.getJSONArray("commonPrefixes");
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList2.add(jSONArray2.optJSONObject(i3).getString("prefix"));
                }
                method.invoke(abstractBceResponse2, new Object[]{arrayList2});
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("contents");
            if (jSONArray3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject optJSONObject2 = jSONArray3.optJSONObject(i4);
                    BosObjectSummary bosObjectSummary = new BosObjectSummary();
                    bosObjectSummary.setETag(optJSONObject2.getString("eTag"));
                    bosObjectSummary.setKey(optJSONObject2.getString("key"));
                    bosObjectSummary.setSize(optJSONObject2.getLong("size"));
                    bosObjectSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject2.getString("lastModified")));
                    bosObjectSummary.setStorageClass(optJSONObject2.getString(str6));
                    JSONObject jSONObject3 = optJSONObject2.getJSONObject(str5);
                    User user2 = new User();
                    user2.setId(jSONObject3.getString(str4));
                    user2.setDisplayName(jSONObject3.getString(str3));
                    bosObjectSummary.setOwner(user2);
                    arrayList3.add(bosObjectSummary);
                }
                abstractBceResponse.getClass().getMethod("setContents", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList3});
                return;
            }
            return;
        }
        String str7 = str4;
        String str8 = str5;
        String str9 = "storageClass";
        if (abstractBceResponse.getClass() == GetBucketAclResponse.class) {
            JSONObject jSONObject4 = new JSONObject(jSONObject.getString(str8));
            Grantee grantee = new Grantee();
            grantee.setId(jSONObject4.getString(str7));
            abstractBceResponse.getClass().getMethod(str2, new Class[]{Grantee.class}).invoke(abstractBceResponse2, new Object[]{grantee});
            JSONArray jSONArray4 = jSONObject.getJSONArray("accessControlList");
            ArrayList arrayList4 = new ArrayList();
            for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                JSONObject jSONObject5 = new JSONObject(jSONArray4.optJSONObject(i5).toString());
                JSONArray jSONArray5 = jSONObject5.getJSONArray("grantee");
                for (int i6 = 0; i6 < jSONArray5.length(); i6++) {
                    JSONObject optJSONObject3 = jSONArray5.optJSONObject(i6);
                    Grantee grantee2 = new Grantee();
                    grantee2.setId(optJSONObject3.getString(str7));
                    arrayList5.add(grantee2);
                }
                JSONArray jSONArray6 = jSONObject5.getJSONArray("permission");
                for (int i7 = 0; i7 < jSONArray6.length(); i7++) {
                    int i8 = AnonymousClass1.$SwitchMap$com$baidubce$services$bos$model$Permission[Permission.valueOf(jSONArray6.get(i7).toString()).ordinal()];
                    if (i8 == 1) {
                        arrayList6.add(Permission.FULL_CONTROL);
                    } else if (i8 == 2) {
                        arrayList6.add(Permission.READ);
                    } else if (i8 == 3) {
                        arrayList6.add(Permission.WRITE);
                    }
                }
                arrayList4.add(new Grant(arrayList5, arrayList6));
            }
            abstractBceResponse.getClass().getMethod("setAccessControlList", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList4});
            return;
        }
        String str10 = str2;
        String str11 = str7;
        if (abstractBceResponse.getClass() == CopyObjectResponse.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get("lastModified")))});
            abstractBceResponse.getClass().getMethod("setETag", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("eTag")});
        } else if (abstractBceResponse.getClass() == CopyObjectResponseWithExceptionInfo.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get("lastModified")))});
            abstractBceResponse.getClass().getMethod("setETag", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("eTag")});
        } else {
            String str12 = "lastModified";
            String str13 = str8;
            String str14 = "commonPrefixes";
            if (abstractBceResponse.getClass() == InitiateMultipartUploadResponse.class) {
                abstractBceResponse.getClass().getMethod("setBucketName", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("bucket")});
                abstractBceResponse.getClass().getMethod("setKey", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("key")});
                abstractBceResponse.getClass().getMethod("setUploadId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("uploadId")});
            } else if (abstractBceResponse.getClass() == CompleteMultipartUploadResponse.class) {
                abstractBceResponse.getClass().getMethod("setBucketName", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("bucket")});
                abstractBceResponse.getClass().getMethod("setKey", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("key")});
                abstractBceResponse.getClass().getMethod("setLocation", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(b.c.j)});
                abstractBceResponse.getClass().getMethod("setETag", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("eTag")});
            } else if (abstractBceResponse.getClass() == ListMultipartUploadsResponse.class) {
                abstractBceResponse.getClass().getMethod("setBucketName", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("bucket")});
                if (jSONObject.has("keyMarker")) {
                    abstractBceResponse.getClass().getMethod("setKeyMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("keyMarker")});
                }
                if (jSONObject.has("nextKeyMarker")) {
                    abstractBceResponse.getClass().getMethod("setNextKeyMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("nextKeyMarker")});
                }
                abstractBceResponse.getClass().getMethod("setMaxUploads", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("maxUploads")});
                abstractBceResponse.getClass().getMethod("setPrefix", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("prefix")});
                if (jSONObject.has("delimiter")) {
                    abstractBceResponse.getClass().getMethod("setDelimiter", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("delimiter")});
                }
                abstractBceResponse.getClass().getMethod("setTruncated", new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("isTruncated")});
                String str15 = str14;
                if (jSONObject.has(str15)) {
                    Method method2 = abstractBceResponse.getClass().getMethod("setCommonPrefixes", new Class[]{List.class});
                    JSONArray jSONArray7 = jSONObject.getJSONArray(str15);
                    ArrayList arrayList7 = new ArrayList();
                    for (int i9 = 0; i9 < jSONArray7.length(); i9++) {
                        arrayList7.add(jSONArray7.optJSONObject(i9).getString("prefix"));
                    }
                    method2.invoke(abstractBceResponse2, new Object[]{arrayList7});
                }
                ArrayList arrayList8 = new ArrayList();
                JSONArray jSONArray8 = jSONObject.getJSONArray("uploads");
                for (int i10 = 0; i10 < jSONArray8.length(); i10++) {
                    JSONObject optJSONObject4 = jSONArray8.optJSONObject(i10);
                    MultipartUploadSummary multipartUploadSummary = new MultipartUploadSummary();
                    multipartUploadSummary.setUploadId(optJSONObject4.getString("uploadId"));
                    multipartUploadSummary.setKey(optJSONObject4.getString("key"));
                    multipartUploadSummary.setInitiated(DateUtils.parseAlternateIso8601Date(optJSONObject4.getString("initiated")));
                    multipartUploadSummary.setStorageClass(optJSONObject4.getString(str9));
                    JSONObject jSONObject6 = optJSONObject4.getJSONObject(str13);
                    User user3 = new User();
                    user3.setId(jSONObject6.getString(str11));
                    user3.setDisplayName(jSONObject6.getString(str3));
                    multipartUploadSummary.setOwner(user3);
                    arrayList8.add(multipartUploadSummary);
                }
                abstractBceResponse.getClass().getMethod("setMultipartUploads", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList8});
            } else {
                String str16 = str3;
                String str17 = str11;
                String str18 = str9;
                String str19 = str13;
                String str20 = "eTag";
                if (abstractBceResponse.getClass() == ListPartsResponse.class) {
                    String str21 = str17;
                    abstractBceResponse.getClass().getMethod("setBucketName", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("bucket")});
                    abstractBceResponse.getClass().getMethod("setKey", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("key")});
                    abstractBceResponse.getClass().getMethod("setUploadId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("uploadId")});
                    abstractBceResponse.getClass().getMethod("setInitiated", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(jSONObject.getString("initiated"))});
                    abstractBceResponse.getClass().getMethod("setStorageClass", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str18)});
                    abstractBceResponse.getClass().getMethod("setPartNumberMarker", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("partNumberMarker")});
                    abstractBceResponse.getClass().getMethod("setNextPartNumberMarker", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("nextPartNumberMarker")});
                    abstractBceResponse.getClass().getMethod("setMaxParts", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{Integer.valueOf(jSONObject.getInt("maxParts"))});
                    abstractBceResponse.getClass().getMethod("setTruncated", new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("isTruncated")});
                    JSONObject jSONObject7 = new JSONObject(jSONObject.getString(str19));
                    User user4 = new User();
                    user4.setDisplayName(jSONObject7.getString(str16));
                    user4.setId(jSONObject7.getString(str21));
                    abstractBceResponse.getClass().getMethod(str10, new Class[]{User.class}).invoke(abstractBceResponse2, new Object[]{user4});
                    ArrayList arrayList9 = new ArrayList();
                    JSONArray jSONArray9 = jSONObject.getJSONArray("parts");
                    for (int i11 = 0; i11 < jSONArray9.length(); i11++) {
                        JSONObject optJSONObject5 = jSONArray9.optJSONObject(i11);
                        PartSummary partSummary = new PartSummary();
                        partSummary.setPartNumber(optJSONObject5.getInt("partNumber"));
                        partSummary.setETag(optJSONObject5.getString(str20));
                        partSummary.setSize((long) optJSONObject5.getInt("size"));
                        partSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject5.getString(str12)));
                        arrayList9.add(partSummary);
                    }
                    abstractBceResponse.getClass().getMethod("setParts", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList9});
                } else if (abstractBceResponse.getClass() == GetSessionTokenResponse.class) {
                    abstractBceResponse.getClass().getMethod("setAccessKeyId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("accessKeyId")});
                    abstractBceResponse.getClass().getMethod("setSecretAccessKey", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("secretAccessKey")});
                    abstractBceResponse.getClass().getMethod("setSessionToken", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(StsClient.GET_SESSION_TOKEN_PATH)});
                    abstractBceResponse.getClass().getMethod("setExpiration", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(jSONObject.getString("expiration"))});
                } else if (abstractBceResponse.getClass() == GetBucketLocationResponse.class) {
                    abstractBceResponse.getClass().getMethod("setLocationConstraint", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("locationConstraint")});
                }
            }
        }
    }

    public static String setAclJson(List<Grant> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Grant next : list) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (Permission permission : next.getPermission()) {
                jSONArray2.put(permission.toString());
            }
            jSONObject2.put("permission", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Grantee id : next.getGrantee()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", id.getId());
                jSONArray3.put(jSONObject3);
            }
            jSONObject2.put("grantee", jSONArray3);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("accessControlList", jSONArray);
        return jSONObject.toString();
    }

    public static String setPartETag(List<PartETag> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (PartETag next : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eTag", next.getETag());
            jSONObject2.put("partNumber", next.getPartNumber());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("parts", jSONArray);
        return jSONObject.toString();
    }

    public static void load(InputStream inputStream, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = str + readLine;
                } else {
                    inputStream.close();
                    loadFromString(str, abstractBceResponse);
                    return;
                }
            }
        }
    }
}
