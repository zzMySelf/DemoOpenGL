package e;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import g.a;
import g.b;
import g.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class e extends AsyncTask<WeiboMultiMessage, Void, d> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f7736a;

    /* renamed from: b  reason: collision with root package name */
    public c f7737b;

    public e(Context context, a aVar) {
        this.f7736a = new WeakReference<>(context);
        this.f7737b = aVar;
    }

    public final Object doInBackground(Object[] objArr) {
        WeiboMultiMessage weiboMultiMessage;
        String str;
        Uri uri;
        WeiboMultiMessage[] weiboMultiMessageArr = (WeiboMultiMessage[]) objArr;
        Context context = this.f7736a.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        a.C0112a a2 = a.a(context);
        if (a2 != null) {
            str = a2.f7763a;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        d dVar = new d();
        try {
            if (!(weiboMultiMessage.imageObject == null || weiboMultiMessage.multiImageObject == null)) {
                weiboMultiMessage.imageObject = null;
            }
            if (!(weiboMultiMessage.videoSourceObject == null || (weiboMultiMessage.imageObject == null && weiboMultiMessage.multiImageObject == null))) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    if (next != null && b.c(context, next)) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            arrayList.add(next);
                            context.grantUriPermission(str, next, 1);
                        } else {
                            String a3 = b.a(context, next, 1);
                            if (!TextUtils.isEmpty(a3)) {
                                arrayList.add(Uri.fromFile(new File(a3)));
                            } else {
                                throw new IllegalArgumentException("image's path is null");
                            }
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (!(videoSourceObject == null || (uri = videoSourceObject.videoPath) == null || !b.d(context, uri))) {
                if (Build.VERSION.SDK_INT >= 24) {
                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2.videoPath = uri;
                    videoSourceObject2.during = b.a(b.b(context, uri));
                    context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                } else {
                    String a4 = b.a(context, uri, 0);
                    c.a("WBShareTag", "prepare video resource and video'path is" + a4);
                    if (!TextUtils.isEmpty(a4)) {
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(a4));
                        weiboMultiMessage.videoSourceObject.during = b.a(a4);
                    } else {
                        throw new IllegalArgumentException("video's path is null");
                    }
                }
            }
            dVar.f7734b = weiboMultiMessage;
            dVar.f7733a = true;
        } catch (Throwable th2) {
            dVar.f7733a = false;
            String message = th2.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th2.toString();
            }
            dVar.f7735c = message;
            c.b("WBShareTag", "prepare resource error is :" + message);
        }
        return dVar;
    }

    public final void onPostExecute(Object obj) {
        d dVar = (d) obj;
        super.onPostExecute(dVar);
        c cVar = this.f7737b;
        if (cVar != null) {
            a aVar = (a) cVar;
            aVar.f7732a.f5611b.setVisibility(4);
            if (dVar == null) {
                aVar.f7732a.a("Trans result is null.");
            } else if (dVar.f7733a) {
                aVar.f7732a.a(dVar.f7734b);
            } else if (TextUtils.isEmpty(dVar.f7735c)) {
                aVar.f7732a.a("Trans resource fail.");
            } else {
                aVar.f7732a.a(dVar.f7735c);
            }
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
