package fe.th.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.duxiaoman.imageloader.listener.IImageLoaderListener;
import com.facebook.drawee.view.SimpleDraweeView;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f5107ad = -1;

    /* renamed from: de  reason: collision with root package name */
    public ImageView f5108de;

    /* renamed from: fe  reason: collision with root package name */
    public IImageLoaderListener f5109fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public Context f5110rg;

    /* renamed from: th  reason: collision with root package name */
    public ViewGroup f5111th;

    /* renamed from: fe.th.ad.qw$qw  reason: collision with other inner class name */
    public static class C0221qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f5112ad = -1;

        /* renamed from: de  reason: collision with root package name */
        public Drawable f5113de;

        /* renamed from: fe  reason: collision with root package name */
        public ViewGroup f5114fe;

        /* renamed from: i  reason: collision with root package name */
        public int f5115i;

        /* renamed from: o  reason: collision with root package name */
        public int f5116o;
        public String qw = "";

        /* renamed from: rg  reason: collision with root package name */
        public ImageView f5117rg = null;

        /* renamed from: th  reason: collision with root package name */
        public SimpleDraweeView f5118th;

        /* renamed from: uk  reason: collision with root package name */
        public Context f5119uk;

        /* renamed from: yj  reason: collision with root package name */
        public IImageLoaderListener f5120yj;

        /* renamed from: if  reason: not valid java name */
        public C0221qw m331if(Context context) {
            this.f5119uk = context;
            return this;
        }

        public qw pf() {
            return new qw(this);
        }

        public C0221qw ppp(String str) {
            this.qw = str;
            return this;
        }

        /* renamed from: switch  reason: not valid java name */
        public C0221qw m332switch(ImageView imageView) {
            this.f5117rg = imageView;
            return this;
        }

        public C0221qw when(IImageLoaderListener iImageLoaderListener) {
            this.f5120yj = iImageLoaderListener;
            return this;
        }
    }

    public qw(C0221qw qwVar) {
        this.qw = qwVar.qw;
        this.f5107ad = qwVar.f5112ad;
        this.f5108de = qwVar.f5117rg;
        SimpleDraweeView unused = qwVar.f5118th;
        this.f5109fe = qwVar.f5120yj;
        this.f5110rg = qwVar.f5119uk;
        int unused2 = qwVar.f5115i;
        int unused3 = qwVar.f5116o;
        Drawable unused4 = qwVar.f5113de;
        this.f5111th = qwVar.f5114fe;
    }

    public static C0221qw th() {
        return new C0221qw();
    }

    public ImageView ad() {
        return this.f5108de;
    }

    public IImageLoaderListener de() {
        return this.f5109fe;
    }

    public int fe() {
        return this.f5107ad;
    }

    public Context qw() {
        return this.f5110rg;
    }

    public String rg() {
        return this.qw;
    }
}
