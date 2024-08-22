package com.baidu.searchbox.ugc.utils;

import com.baidu.searchbox.ugc.model.ImageStruct;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/ugc/utils/ImageStructDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "lib-publisher-utils_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageStructDeserializer.kt */
public final class ImageStructDeserializer implements JsonDeserializer<ImageStruct> {
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0183, code lost:
        if (r13 != null) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = r6.get("url");
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0128 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x012d A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013b A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0140 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x014f A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0158 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0198 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0199 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a7 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01ac A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01e7 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01e8 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x01f5 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x01fa A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0207 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x020c A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0219 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x021e A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x022b A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0230 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x023e A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0243 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0250 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0255 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0116 A[Catch:{ all -> 0x009c, all -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.ugc.model.ImageStruct deserialize(com.google.gson.JsonElement r18, java.lang.reflect.Type r19, com.google.gson.JsonDeserializationContext r20) {
        /*
            r17 = this;
            com.baidu.searchbox.ugc.model.ImageStruct r0 = new com.baidu.searchbox.ugc.model.ImageStruct
            java.lang.String r1 = ""
            r0.<init>((java.lang.String) r1)
            r2 = r0
            r3 = 1
            r4 = 0
            r5 = 0
            if (r18 == 0) goto L_0x0016
            com.google.gson.JsonObject r0 = r18.getAsJsonObject()     // Catch:{ all -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            goto L_0x0269
        L_0x0016:
            r0 = r5
        L_0x0017:
            r6 = r0
            if (r6 == 0) goto L_0x0028
            java.lang.String r0 = "url"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0029
        L_0x0028:
            r0 = r5
        L_0x0029:
            r7 = r0
            if (r6 == 0) goto L_0x003a
            java.lang.String r0 = "width"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x003b
        L_0x003a:
            r0 = r5
        L_0x003b:
            r8 = r0
            if (r6 == 0) goto L_0x004b
            java.lang.String r0 = "height"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x004c
        L_0x004b:
            r0 = r5
        L_0x004c:
            r9 = r0
            if (r6 == 0) goto L_0x005d
            java.lang.String r0 = "size"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x005e
        L_0x005d:
            r0 = r5
        L_0x005e:
            r10 = r0
            if (r6 == 0) goto L_0x006f
            java.lang.String r0 = "thumbnail"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x006f
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0070
        L_0x006f:
            r0 = r5
        L_0x0070:
            r11 = r0
            if (r6 == 0) goto L_0x0084
            java.lang.String r0 = "img_type"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0084
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x0013 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0085
        L_0x0084:
            r0 = r5
        L_0x0085:
            r12 = r0
            if (r7 != 0) goto L_0x008a
            r0 = r1
            goto L_0x008b
        L_0x008a:
            r0 = r7
        L_0x008b:
            r2.httpUrl = r0     // Catch:{ all -> 0x0013 }
            java.lang.String r13 = "0"
            if (r8 != 0) goto L_0x0094
            r0 = r13
            goto L_0x0095
        L_0x0094:
            r0 = r8
        L_0x0095:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x009c }
            r2.width = r0     // Catch:{ all -> 0x009c }
            goto L_0x00a4
        L_0x009c:
            r0 = move-exception
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ all -> 0x0013 }
            r14[r4] = r0     // Catch:{ all -> 0x0013 }
            com.baidu.searchbox.ugc.utils.LogUtil.e(r14)     // Catch:{ all -> 0x0013 }
        L_0x00a4:
            if (r9 != 0) goto L_0x00a9
            r0 = r13
            goto L_0x00aa
        L_0x00a9:
            r0 = r9
        L_0x00aa:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x00b1 }
            r2.height = r0     // Catch:{ all -> 0x00b1 }
            goto L_0x00b9
        L_0x00b1:
            r0 = move-exception
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ all -> 0x0013 }
            r14[r4] = r0     // Catch:{ all -> 0x0013 }
            com.baidu.searchbox.ugc.utils.LogUtil.e(r14)     // Catch:{ all -> 0x0013 }
        L_0x00b9:
            if (r10 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r13 = r10
        L_0x00be:
            long r13 = java.lang.Long.parseLong(r13)     // Catch:{ all -> 0x00c5 }
            r2.size = r13     // Catch:{ all -> 0x00c5 }
            goto L_0x00cd
        L_0x00c5:
            r0 = move-exception
            java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch:{ all -> 0x0013 }
            r13[r4] = r0     // Catch:{ all -> 0x0013 }
            com.baidu.searchbox.ugc.utils.LogUtil.e(r13)     // Catch:{ all -> 0x0013 }
        L_0x00cd:
            if (r11 != 0) goto L_0x00d1
            r0 = r1
            goto L_0x00d2
        L_0x00d1:
            r0 = r11
        L_0x00d2:
            r2.httpThumbnail = r0     // Catch:{ all -> 0x0013 }
            if (r12 == 0) goto L_0x00db
            int r0 = r12.intValue()     // Catch:{ all -> 0x0013 }
            goto L_0x00dc
        L_0x00db:
            r0 = r4
        L_0x00dc:
            r2.imgType = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x00ee
            java.lang.String r0 = "tag"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x00ef
        L_0x00ee:
            r0 = r5
        L_0x00ef:
            r2.tag = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0101
            java.lang.String r0 = "uriStr"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0102
        L_0x0101:
            r0 = r5
        L_0x0102:
            r2.uriStr = r0     // Catch:{ all -> 0x0013 }
            java.lang.String r0 = r2.uriStr     // Catch:{ all -> 0x0013 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0113
            int r0 = r0.length()     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0111
            goto L_0x0113
        L_0x0111:
            r0 = r4
            goto L_0x0114
        L_0x0113:
            r0 = r3
        L_0x0114:
            if (r0 != 0) goto L_0x011e
            java.lang.String r0 = r2.uriStr     // Catch:{ all -> 0x0013 }
            android.net.Uri r0 = com.baidu.searchbox.ugc.utils.UgcUriUtils.getUri(r0)     // Catch:{ all -> 0x0013 }
            r2.contentUri = r0     // Catch:{ all -> 0x0013 }
        L_0x011e:
            if (r6 == 0) goto L_0x012d
            java.lang.String r0 = "addedDate"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x012d
            long r13 = r0.getAsLong()     // Catch:{ all -> 0x0013 }
            goto L_0x012f
        L_0x012d:
            r13 = 0
        L_0x012f:
            r2.addedDate = r13     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0140
            java.lang.String r0 = "mimeType"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0140
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0141
        L_0x0140:
            r0 = r5
        L_0x0141:
            r2.mimeType = r0     // Catch:{ all -> 0x0013 }
            r13 = 0
            if (r6 == 0) goto L_0x0158
            java.lang.String r0 = "latitude"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0158
            double r15 = r0.getAsDouble()     // Catch:{ all -> 0x0013 }
            java.lang.Double r0 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0013 }
            goto L_0x015c
        L_0x0158:
            java.lang.Double r0 = java.lang.Double.valueOf(r13)     // Catch:{ all -> 0x0013 }
        L_0x015c:
            r2.latitude = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x016c
            java.lang.String r0 = "longitude"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x016c
            double r13 = r0.getAsDouble()     // Catch:{ all -> 0x0013 }
        L_0x016c:
            java.lang.Double r0 = java.lang.Double.valueOf(r13)     // Catch:{ all -> 0x0013 }
            r2.longitude = r0     // Catch:{ all -> 0x0013 }
            java.lang.String r0 = "-1"
            if (r6 == 0) goto L_0x0185
            java.lang.String r13 = "qualityScore"
            com.google.gson.JsonElement r13 = r6.get(r13)     // Catch:{ all -> 0x0013 }
            if (r13 == 0) goto L_0x0185
            java.lang.String r13 = r13.getAsString()     // Catch:{ all -> 0x0013 }
            if (r13 != 0) goto L_0x0186
        L_0x0185:
            r13 = r0
        L_0x0186:
            r2.qualityScore = r13     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x019a
            java.lang.String r13 = "isFuzzy"
            com.google.gson.JsonElement r13 = r6.get(r13)     // Catch:{ all -> 0x0013 }
            if (r13 == 0) goto L_0x019a
            java.lang.String r13 = r13.getAsString()     // Catch:{ all -> 0x0013 }
            if (r13 != 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r0 = r13
        L_0x019a:
            r2.isFuzzy = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x01ac
            java.lang.String r0 = "status"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x01ac
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x0013 }
            goto L_0x01ad
        L_0x01ac:
            r0 = r4
        L_0x01ad:
            r2.status = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x01c0
            java.lang.String r0 = "text"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x01c0
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x01c1
        L_0x01c0:
            r0 = r1
        L_0x01c1:
            r2.text = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x01d3
            java.lang.String r0 = "bgColor"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x01d3
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x01d4
        L_0x01d3:
            r0 = r1
        L_0x01d4:
            r2.bgColor = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x01e9
            java.lang.String r0 = "textColor"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x01e9
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x01e8
            goto L_0x01e9
        L_0x01e8:
            r1 = r0
        L_0x01e9:
            r2.textColor = r1     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x01fa
            java.lang.String r0 = "isOriginal"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x01fa
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x0013 }
            goto L_0x01fb
        L_0x01fa:
            r0 = r4
        L_0x01fb:
            r2.isOriginal = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x020c
            java.lang.String r0 = "draftPath"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x020c
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x020d
        L_0x020c:
            r0 = r5
        L_0x020d:
            r2.draftPath = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x021e
            java.lang.String r0 = "originalPath"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x021e
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x021f
        L_0x021e:
            r0 = r5
        L_0x021f:
            r2.originalPath = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0230
            java.lang.String r0 = "aiAnchorPointId"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0230
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0231
        L_0x0230:
            r0 = r5
        L_0x0231:
            r2.aiAnchorPointId = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0243
            java.lang.String r0 = "taskId"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0243
            java.lang.String r0 = r0.getAsString()     // Catch:{ all -> 0x0013 }
            goto L_0x0244
        L_0x0243:
            r0 = r5
        L_0x0244:
            r2.taskId = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0255
            java.lang.String r0 = "aiCreativeImageResult"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0255
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x0013 }
            goto L_0x0256
        L_0x0255:
            r0 = r4
        L_0x0256:
            r2.aiCreativeImageResult = r0     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x0266
            java.lang.String r0 = "aiGenimageResult"
            com.google.gson.JsonElement r0 = r6.get(r0)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0266
            java.lang.String r5 = r0.getAsString()     // Catch:{ all -> 0x0013 }
        L_0x0266:
            r2.aiGenimageResult = r5     // Catch:{ all -> 0x0013 }
            goto L_0x0270
        L_0x0269:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r4] = r0
            com.baidu.searchbox.ugc.utils.LogUtil.e(r1)
        L_0x0270:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ugc.utils.ImageStructDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.baidu.searchbox.ugc.model.ImageStruct");
    }
}
