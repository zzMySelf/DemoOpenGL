package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import java.lang.ref.WeakReference;

public class IndexScroller {
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g = 0;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public int f1145i;
    public int j = -1;
    public boolean k = false;
    public ListView l = null;
    public SectionIndexer m = null;
    public String[] n = null;

    /* renamed from: o  reason: collision with root package name */
    public RectF f1146o;
    public final a t = new a(this);

    public static class a extends Handler {
        public final WeakReference<IndexScroller> a;

        public a(IndexScroller indexScroller) {
            this.a = new WeakReference<>(indexScroller);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            IndexScroller indexScroller = (IndexScroller) this.a.get();
            if (indexScroller != null) {
                int a2 = indexScroller.g;
                if (a2 == 1) {
                    IndexScroller.a(indexScroller, ((double) (1.0f - indexScroller.f)) * 0.2d);
                    if (((double) indexScroller.f) > 0.9d) {
                        float unused = indexScroller.f = 1.0f;
                        indexScroller.a(2);
                    }
                    indexScroller.l.invalidate();
                    indexScroller.a(10);
                } else if (a2 == 2) {
                    indexScroller.a(3);
                } else if (a2 == 3) {
                    IndexScroller.b(indexScroller, ((double) indexScroller.f) * 0.2d);
                    if (((double) indexScroller.f) < 0.1d) {
                        float unused2 = indexScroller.f = 0.0f;
                        indexScroller.a(0);
                    }
                    indexScroller.l.invalidate();
                    indexScroller.a(10);
                }
            }
        }
    }

    public IndexScroller(Context context, ListView listView) {
        this.d = context.getResources().getDisplayMetrics().density;
        this.e = context.getResources().getDisplayMetrics().scaledDensity;
        this.l = listView;
        setAdapter(listView.getAdapter());
        float f2 = this.d;
        this.a = 20.0f * f2;
        this.b = 10.0f * f2;
        this.c = f2 * 5.0f;
    }

    public static /* synthetic */ float a(IndexScroller indexScroller, double d2) {
        float f2 = (float) (((double) indexScroller.f) + d2);
        indexScroller.f = f2;
        return f2;
    }

    public boolean contains(float f2, float f3) {
        RectF rectF = this.f1146o;
        if (f2 >= rectF.left) {
            float f4 = rectF.top;
            return f3 >= f4 && f3 <= f4 + rectF.height();
        }
    }

    public void draw(Canvas canvas) {
        String[] strArr = this.n;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            if (this.j >= 0) {
                Paint paint = new Paint();
                paint.setColor(-16777216);
                paint.setAlpha(96);
                paint.setAntiAlias(true);
                paint.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                Paint paint2 = new Paint();
                paint2.setColor(-1);
                paint2.setAntiAlias(true);
                paint2.setTextSize(this.e * 50.0f);
                float measureText = paint2.measureText(this.n[this.j]);
                float descent = ((this.c * 2.0f) + paint2.descent()) - paint2.ascent();
                int i3 = this.h;
                int i4 = this.f1145i;
                RectF rectF = new RectF((((float) i3) - descent) / 2.0f, (((float) i4) - descent) / 2.0f, ((((float) i3) - descent) / 2.0f) + descent, ((((float) i4) - descent) / 2.0f) + descent);
                float f2 = this.d;
                canvas.drawRoundRect(rectF, f2 * 5.0f, f2 * 5.0f, paint);
                canvas.drawText(this.n[this.j], (rectF.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF.top + this.c) - paint2.ascent()) + 1.0f, paint2);
            }
            Paint paint3 = new Paint();
            paint3.setColor(-16099908);
            paint3.setAntiAlias(true);
            paint3.setTextSize(this.e * 14.0f);
            float height = (this.f1146o.height() - (this.b * 2.0f)) / ((float) this.n.length);
            float descent2 = (height - (paint3.descent() - paint3.ascent())) / 2.0f;
            while (true) {
                String[] strArr2 = this.n;
                if (i2 < strArr2.length) {
                    String str = this.n[i2];
                    RectF rectF2 = this.f1146o;
                    canvas.drawText(str, rectF2.left + ((this.a - paint3.measureText(strArr2[i2])) / 2.0f), (((rectF2.top + this.b) + (((float) i2) * height)) + descent2) - paint3.ascent(), paint3);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void hide() {
        if (this.g == 2) {
            a(3);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.h = i2;
        this.f1145i = i3;
        float f2 = (float) i2;
        float f3 = this.b;
        this.f1146o = new RectF((f2 - f3) - this.a, f3, f2 - f3, ((float) i3) - f3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.k) {
                    this.k = false;
                    this.j = -1;
                }
                if (this.g == 2) {
                    a(3);
                }
            } else if (action == 2 && this.k) {
                if (contains(motionEvent.getX(), motionEvent.getY())) {
                    int a2 = a(motionEvent.getY());
                    this.j = a2;
                    this.l.setSelection(this.m.getPositionForSection(a2));
                }
                return true;
            }
        } else if (contains(motionEvent.getX(), motionEvent.getY())) {
            a(2);
            this.k = true;
            int a3 = a(motionEvent.getY());
            this.j = a3;
            this.l.setSelection(this.m.getPositionForSection(a3));
            return true;
        }
        return false;
    }

    public void setAdapter(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.m = sectionIndexer;
            this.n = (String[]) sectionIndexer.getSections();
        }
    }

    public void show() {
        int i2 = this.g;
        if (i2 == 0) {
            a(1);
        } else if (i2 == 3) {
            a(3);
        }
    }

    public static /* synthetic */ float b(IndexScroller indexScroller, double d2) {
        float f2 = (float) (((double) indexScroller.f) - d2);
        indexScroller.f = f2;
        return f2;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i2 >= 0 && i2 <= 3) {
            this.g = i2;
            if (i2 == 0) {
                this.t.removeMessages(0);
            } else if (i2 == 1) {
                this.f = 0.0f;
                a(0);
            } else if (i2 == 2) {
                this.t.removeMessages(0);
            } else if (i2 == 3) {
                this.f = 1.0f;
                a(3000);
            }
        }
    }

    private int a(float f2) {
        String[] strArr = this.n;
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        RectF rectF = this.f1146o;
        float f3 = rectF.top;
        if (f2 < this.b + f3) {
            return 0;
        }
        float height = f3 + rectF.height();
        float f4 = this.b;
        if (f2 >= height - f4) {
            return this.n.length - 1;
        }
        RectF rectF2 = this.f1146o;
        return (int) (((f2 - rectF2.top) - f4) / ((rectF2.height() - (this.b * 2.0f)) / ((float) this.n.length)));
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        this.t.removeMessages(0);
        this.t.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j2);
    }
}
