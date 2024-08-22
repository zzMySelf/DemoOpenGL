package com.baidubce.services.bos;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.util.BLog;
import com.baidubce.util.JoinerUtils;
import com.baidubce.util.LengthCheckInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Map;

public class BosObjectResponseHandler implements HttpResponseHandler {
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        int lastIndexOf;
        if (!(abstractBceResponse instanceof GetObjectResponse)) {
            return false;
        }
        BosObject bosObject = new BosObject();
        ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
        objectMetadata.setContentLength(bceHttpResponse.getHeaderAsLong("Content-Length"));
        objectMetadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
        objectMetadata.setContentEncoding(bceHttpResponse.getHeader("Content-Encoding"));
        objectMetadata.setContentMd5(bceHttpResponse.getHeader("Content-MD5"));
        objectMetadata.setExpires(bceHttpResponse.getHeader("Expires"));
        objectMetadata.setObjectType(bceHttpResponse.getHeader(Headers.BCE_OBJECT_TYPE));
        objectMetadata.setAppendOffset(bceHttpResponse.getHeaderAsLong(Headers.BCE_NEXT_APPEND_OFFSET));
        objectMetadata.setContentDisposition(bceHttpResponse.getHeader("Content-Disposition"));
        objectMetadata.setCacheControl(bceHttpResponse.getHeader("Cache-Control"));
        String header = bceHttpResponse.getHeader(Headers.BCE_STORAGE_CLASS);
        if (header == null) {
            header = BosClient.STORAGE_CLASS_STANDARD;
        }
        objectMetadata.setStorageClass(header);
        String header2 = bceHttpResponse.getHeader("ETag");
        if (header2 != null) {
            objectMetadata.setETag(JoinerUtils.cut("\"", header2));
        }
        objectMetadata.setContentLength(objectMetadata.getContentLength());
        String header3 = bceHttpResponse.getHeader("Content-Range");
        objectMetadata.setContentRange(header3);
        if (header3 != null && (lastIndexOf = header3.lastIndexOf(47)) >= 0) {
            try {
                objectMetadata.setInstanceLength(Long.parseLong(header3.substring(lastIndexOf + 1)));
            } catch (NumberFormatException e) {
                BLog.error("Fail to parse length from Content-Range: " + header3, (Throwable) e);
            }
        }
        objectMetadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date("Last-Modified"));
        objectMetadata.setBceContentSha256(bceHttpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
        for (Map.Entry next : bceHttpResponse.getHeaders().entrySet()) {
            String str = (String) next.getKey();
            if (str.startsWith(Headers.BCE_USER_METADATA_PREFIX)) {
                objectMetadata.addUserMetadata(URLDecoder.decode(str.substring(11), "UTF-8"), URLDecoder.decode((String) next.getValue(), "UTF-8"));
            }
        }
        InputStream content = bceHttpResponse.getContent();
        if (content != null) {
            if (objectMetadata.getContentLength() >= 0) {
                content = new LengthCheckInputStream(content, objectMetadata.getContentLength(), true);
            }
            bosObject.setObjectContent(new BosObjectInputStream(content, bceHttpResponse.getHttpResponse()));
        }
        ((GetObjectResponse) abstractBceResponse).setObject(bosObject);
        return true;
    }
}
