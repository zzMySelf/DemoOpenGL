package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.FormBody;
import com.baidu.searchbox.network.outback.core.Request;
import java.util.Map;

public class PostFormRequest extends Request {
    private PostFormRequest(PostFormRequestBuilder builder) {
        super(builder);
    }

    public static class PostFormRequestBuilder extends Request.Builder<PostFormRequestBuilder> {
        private FormBody.Builder bodyBuilder = new FormBody.Builder();

        public PostFormRequestBuilder(Map<String, CallFactory> callFactoryMap) {
            super(callFactoryMap);
        }

        public PostFormRequestBuilder(PostFormRequest postFormRequest) {
            super((Request) postFormRequest);
        }

        public PostFormRequestBuilder params(Map<String, String> params) {
            this.bodyBuilder = new FormBody.Builder();
            for (String key : params.keySet()) {
                this.bodyBuilder.add(key, params.get(key));
            }
            return this;
        }

        public PostFormRequestBuilder addParams(Map<String, String> params) {
            for (String key : params.keySet()) {
                addParam(key, params.get(key));
            }
            return this;
        }

        public PostFormRequestBuilder addParam(String key, String value) {
            this.bodyBuilder.add(key, value);
            return this;
        }

        public PostFormRequest build() {
            if (this.body != null) {
                int size = ((FormBody) this.body).size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.bodyBuilder.addEncoded(((FormBody) this.body).name(i2), ((FormBody) this.body).value(i2));
                }
            }
            return new PostFormRequest((PostFormRequestBuilder) post(this.bodyBuilder.build()));
        }
    }
}
