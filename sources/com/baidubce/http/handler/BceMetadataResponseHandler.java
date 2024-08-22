package com.baidubce.http.handler;

import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JoinerUtils;

public class BceMetadataResponseHandler implements HttpResponseHandler {
    public boolean handle(BceHttpResponse httpResponse, AbstractBceResponse response) throws Exception {
        BceResponseMetadata metadata = response.getMetadata();
        metadata.setBceRequestId(httpResponse.getHeader(Headers.BCE_REQUEST_ID));
        metadata.setBceContentSha256(httpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
        metadata.setContentDisposition(httpResponse.getHeader("Content-Disposition"));
        metadata.setContentEncoding(httpResponse.getHeader("Content-Encoding"));
        metadata.setContentLength(httpResponse.getHeaderAsLong("Content-Length"));
        metadata.setContentMd5(httpResponse.getHeader(Headers.CONTENT_MD5));
        metadata.setContentRange(httpResponse.getHeader("Content-Range"));
        metadata.setContentType(httpResponse.getHeader("Content-Type"));
        metadata.setDate(httpResponse.getHeaderAsRfc822Date("Date"));
        metadata.setTransferEncoding(httpResponse.getHeader("Transfer-Encoding"));
        metadata.setLocation(httpResponse.getHeader("Location"));
        String eTag = httpResponse.getHeader("ETag");
        if (eTag != null) {
            metadata.setETag(JoinerUtils.cut("\"", eTag));
        }
        metadata.setExpires(httpResponse.getHeaderAsRfc822Date("Expires"));
        metadata.setLastModified(httpResponse.getHeaderAsRfc822Date("Last-Modified"));
        metadata.setServer(httpResponse.getHeader(Headers.SERVER));
        return false;
    }
}
