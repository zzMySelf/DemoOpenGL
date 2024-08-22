package com.baidu.searchbox.imagesearch.host.entry.ai.edit;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageUploadChunkTask$uploadFinRequest$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageAIEditResult;", "onFail", "", "exception", "Ljava/lang/Exception;", "onSuccess", "response", "statusCode", "", "parseResponse", "Lokhttp3/Response;", "lib-entry_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageUploadChunkTask.kt */
public final class ImageUploadChunkTask$uploadFinRequest$1 extends ResponseCallback<ImageAIEditResult> {
    final /* synthetic */ ImageUploadChunkTask this$0;

    ImageUploadChunkTask$uploadFinRequest$1(ImageUploadChunkTask $receiver) {
        this.this$0 = $receiver;
    }

    public ImageAIEditResult parseResponse(Response response, int statusCode) {
        ResponseBody body;
        String it;
        boolean z = true;
        if (response == null || !response.isSuccessful()) {
            z = false;
        }
        if (!z || (body = response.body()) == null || (it = body.string()) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            ImageUploadChunkTask$uploadFinRequest$1 imageUploadChunkTask$uploadFinRequest$1 = this;
            return ImageAIEditResult.Companion.fromJson(new JSONObject(it));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8970boximpl(Result.m8971constructorimpl(ResultKt.createFailure(th2)));
            return null;
        }
    }

    public void onSuccess(ImageAIEditResult response, int statusCode) {
        ImageUploadChunkTask imageUploadChunkTask = this.this$0;
        imageUploadChunkTask.taskCallback(imageUploadChunkTask.callback, response == null ? ImageAIEditRepository.Companion.getAI_EDIT_HTTP_FAIL_RESULT() : response);
    }

    public void onFail(Exception exception) {
        ImageUploadChunkTask imageUploadChunkTask = this.this$0;
        imageUploadChunkTask.taskCallback(imageUploadChunkTask.callback, ImageAIEditRepository.Companion.getAI_EDIT_HTTP_FAIL_RESULT());
    }
}
