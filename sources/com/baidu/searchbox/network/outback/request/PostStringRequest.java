package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.util.Map;

public class PostStringRequest extends Request {
    private PostStringRequest(PostStringRequestBuilder builder) {
        super(builder);
    }

    public static class PostStringRequestBuilder extends Request.Builder<PostStringRequestBuilder> {
        private static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");
        private String content;
        private MediaType mediaType;

        public PostStringRequestBuilder(Map<String, CallFactory> callFactoryMap) {
            super(callFactoryMap);
        }

        public PostStringRequestBuilder(PostStringRequest postStringRequest) {
            super((Request) postStringRequest);
        }

        public PostStringRequestBuilder content(String content2) {
            this.content = content2;
            return this;
        }

        public PostStringRequestBuilder mediaType(MediaType mediaType2) {
            this.mediaType = mediaType2;
            return this;
        }

        public PostStringRequestBuilder mediaType(String mediaType2) {
            this.mediaType = MediaType.parse(mediaType2);
            return this;
        }

        public PostStringRequest build() {
            RequestBody requestBody;
            if (this.mediaType == null) {
                this.mediaType = MEDIA_TYPE_PLAIN;
            }
            if (!Util.isTextEmpty(this.content)) {
                requestBody = RequestBody.create(this.mediaType, this.content);
            } else if (this.body != null) {
                requestBody = this.body;
            } else {
                requestBody = RequestBody.create((MediaType) null, new byte[0]);
            }
            return new PostStringRequest((PostStringRequestBuilder) post(requestBody));
        }
    }
}
