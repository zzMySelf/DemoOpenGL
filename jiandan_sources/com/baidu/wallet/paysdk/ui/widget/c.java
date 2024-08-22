package com.baidu.wallet.paysdk.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

public class c extends AnimationDrawable {
    public a a;
    public Handler b = new Handler();
    public long c;
    public AnimationDrawable d;

    public interface a {
        void a();

        void b();
    }

    public c(AnimationDrawable animationDrawable) {
        if (animationDrawable != null) {
            this.d = animationDrawable;
            this.c = 0;
            for (int i2 = 0; i2 < animationDrawable.getNumberOfFrames(); i2++) {
                this.c += (long) animationDrawable.getDuration(i2);
            }
        }
    }

    public void start() {
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.start();
            if (this.b == null) {
                this.b = new Handler();
            }
            this.b.post(new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.a();
                    }
                }
            });
            this.b.postDelayed(new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.b();
                    }
                }
            }, this.c);
        }
    }

    public void a() {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.b = null;
        }
        this.a = null;
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }
}
