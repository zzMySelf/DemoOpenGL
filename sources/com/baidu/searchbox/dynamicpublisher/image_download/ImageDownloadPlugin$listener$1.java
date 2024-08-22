package com.baidu.searchbox.dynamicpublisher.image_download;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.searchbox.ugc.download.ADownLoadStatusListener;
import com.baidu.searchbox.ugc.model.ImageStruct;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ+\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ5\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ+\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u0011"}, d2 = {"com/baidu/searchbox/dynamicpublisher/image_download/ImageDownloadPlugin$listener$1", "Lcom/baidu/searchbox/ugc/download/ADownLoadStatusListener;", "canceled", "", "id", "", "url", "", "uri", "Landroid/net/Uri;", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;)V", "completed", "onError", "exception", "Ljava/lang/Exception;", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Exception;)V", "started", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageDownloadPlugin.kt */
public final class ImageDownloadPlugin$listener$1 extends ADownLoadStatusListener {
    final /* synthetic */ ImageDownloadPlugin this$0;

    ImageDownloadPlugin$listener$1(ImageDownloadPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void started(Integer id, String url, Uri uri) {
        ImageStruct image = this.this$0.findImageStructByUrl(url);
        if (image != null) {
            this.this$0.downloadImageMap.put(image, 1);
            this.this$0.dispatchImageDownloadState(image, 1);
        }
    }

    public void completed(Integer id, String url, Uri uri) {
        ImageDownloadManager.INSTANCE.removeDownloadTask(url);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new ImageDownloadPlugin$listener$1$completed$1(this.this$0, url, (Continuation<? super ImageDownloadPlugin$listener$1$completed$1>) null), 2, (Object) null);
    }

    public void canceled(Integer id, String url, Uri uri) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new ImageDownloadPlugin$listener$1$canceled$1(this.this$0, url, (Continuation<? super ImageDownloadPlugin$listener$1$canceled$1>) null), 2, (Object) null);
    }

    public void onError(Integer id, String url, Uri uri, Exception exception) {
        super.onError(id, url, uri, exception);
        ImageDownloadManager.INSTANCE.removeDownloadTask(url);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new ImageDownloadPlugin$listener$1$onError$1(this.this$0, url, (Continuation<? super ImageDownloadPlugin$listener$1$onError$1>) null), 2, (Object) null);
    }
}
