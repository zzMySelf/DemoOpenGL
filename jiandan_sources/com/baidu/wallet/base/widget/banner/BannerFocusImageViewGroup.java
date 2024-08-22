package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.base.widget.banner.FocusImageCellLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BannerFocusImageViewGroup extends ViewGroup implements FocusImageCellLayout.FocusImageEvent {
    public static final int FOCUS_IMAGE_MAX = 10;
    public static ArrayList<FoucsImageItem> H = new ArrayList<>(15);
    public static final float N = 1.0E-7f;
    public static final int TOKEN_IS_EXPIRED = 112;
    public static final int a = 1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 200;
    public static final int e = -1;
    public static final int f = -999;
    public static int g = 3000;
    public static final int h = 100;

    /* renamed from: i  reason: collision with root package name */
    public static final int f1158i = 5;
    public static final float j = 0.23f;
    public static final float k = 1.0E9f;
    public static final float l = 0.75f;
    public static final float m = 2500.0f;
    public static final float n = ((float) (0.016d / Math.log(0.75d)));
    public float A;
    public Context B;
    public VelocityTracker C;
    public CurrFocusImagePos D;
    public Scroller E;
    public FocusImageCellLayout[] F;
    public a G;
    public String I;
    public BannerBaseItemInfo[] J;
    public AttributeSet K;
    public int L;
    public int M;
    public String O;
    public List<String> P;

    /* renamed from: o  reason: collision with root package name */
    public int f1159o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public float y;
    public float z;

    public interface CurrFocusImagePos {
        void setCurrPos(int i2, int i3);
    }

    public interface FoucsImageEvent {
        void submitPage(Bundle bundle);
    }

    public static class a extends Handler {
        public static final int a = 1;
        public static final int b = 2;
        public WeakReference<BannerFocusImageViewGroup> c;
        public int d = 0;

        public a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
            this.c = new WeakReference<>(bannerFocusImageViewGroup);
        }

        public void a(int i2) {
            this.d = i2;
        }

        public void handleMessage(Message message) {
            BannerFocusImageViewGroup bannerFocusImageViewGroup = (BannerFocusImageViewGroup) this.c.get();
            if (message != null && bannerFocusImageViewGroup != null) {
                int i2 = message.what;
                boolean z = true;
                if (i2 == 1) {
                    Rect rect = new Rect();
                    bannerFocusImageViewGroup.getGlobalVisibleRect(rect);
                    if (this.d == rect.left) {
                        bannerFocusImageViewGroup.moveToNext();
                    }
                    sendMessageDelayed(obtainMessage(1), (long) BannerFocusImageViewGroup.g);
                } else if (i2 == 2) {
                    boolean z2 = false;
                    if (BannerFocusImageViewGroup.a(bannerFocusImageViewGroup) > 5) {
                        int unused = bannerFocusImageViewGroup.v = 0;
                        removeMessages(2);
                        return;
                    }
                    if (bannerFocusImageViewGroup.u < 1) {
                        z = false;
                    }
                    Iterator it = BannerFocusImageViewGroup.H.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (TextUtils.isEmpty(((FoucsImageItem) it.next()).c)) {
                                break;
                            }
                        } else {
                            z2 = z;
                            break;
                        }
                    }
                    if (z2) {
                        removeMessages(2);
                    } else {
                        sendMessageDelayed(obtainMessage(2), (long) BannerFocusImageViewGroup.g);
                    }
                }
            }
        }
    }

    public BannerFocusImageViewGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    private void e() {
        int width = getWidth();
        if (width != 0) {
            a(Math.max((int) Math.floor((double) ((getScrollX() + (width >> 1)) / width)), this.s + 1), 100, true);
        }
    }

    private void f() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.J;
        if (bannerBaseItemInfoArr != null) {
            this.M = bannerBaseItemInfoArr.length;
            for (int i2 = 0; i2 < Math.min(this.J.length, 10); i2++) {
                FocusImageCellLayout[] focusImageCellLayoutArr = this.F;
                if (focusImageCellLayoutArr[i2] == null) {
                    focusImageCellLayoutArr[i2] = new FocusImageCellLayout(this.B, (AttributeSet) null);
                    addView(this.F[i2], new ViewGroup.LayoutParams(-1, -1));
                    this.F[i2].getFocusView().setImageResource(ResUtils.color(this.B, "wallet_base_pressedColor"));
                    this.F[i2].getFocusView().setScaleType(ImageView.ScaleType.FIT_XY);
                }
                NetImageView focusView = this.F[i2].getFocusView();
                focusView.setImageUrl(this.I + this.J[i2].getPicAddr());
                this.F[i2].setTag(ResUtils.id(this.B, "tag_pos"), Integer.valueOf(i2));
                final BannerBaseItemInfo bannerBaseItemInfo = this.J[i2];
                this.F[i2].setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View view) {
                        BannerBaseItemInfo bannerBaseItemInfo;
                        view.setClickable(false);
                        BannerFocusImageViewGroup.this.G.postDelayed(new Runnable() {
                            public void run() {
                                view.setClickable(true);
                            }
                        }, 600);
                        if (!(BannerFocusImageViewGroup.this.B == null || (bannerBaseItemInfo = bannerBaseItemInfo) == null || TextUtils.isEmpty(bannerBaseItemInfo.getName()))) {
                            BannerFocusImageViewGroup.this.triggerOnEvent(bannerBaseItemInfo.getName());
                        }
                        BannerFocusImageViewGroup.this.jump(bannerBaseItemInfo);
                    }
                });
            }
            if (!this.G.hasMessages(1)) {
                a aVar = this.G;
                aVar.sendMessageDelayed(aVar.obtainMessage(1), (long) g);
            }
        }
    }

    public void computeScroll() {
        if (!this.E.computeScrollOffset() || this.M <= 1) {
            int i2 = this.r;
            if (i2 != -999 && this.M > 1) {
                if (i2 == -1) {
                    int childCount = getChildCount() - 1;
                    this.s = childCount;
                    scrollTo(childCount * getWidth(), getScrollY());
                } else if (i2 == getChildCount()) {
                    this.s = 0;
                    scrollTo(0, getScrollY());
                } else {
                    this.s = Math.max(0, Math.min(this.r, getChildCount() - 1));
                }
                this.r = f;
            } else if (this.t == 1 && this.M > 1) {
                super.scrollTo(getScrollX() + ((int) ((this.z - ((float) getScrollX())) * ((float) Math.exp((double) (((((float) System.nanoTime()) / 1.0E9f) - this.A) / n))))), getScrollY());
            }
        } else {
            this.z = (float) this.E.getCurrX();
            scrollTo(this.E.getCurrX(), this.E.getCurrY());
            postInvalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        int i2;
        int i3 = 0;
        boolean z2 = true;
        if (this.t != 1 && this.r == -999) {
            drawChild(canvas, getChildAt(this.s), getDrawingTime());
            return;
        }
        long drawingTime = getDrawingTime();
        int width = getWidth();
        float scrollX = ((float) getScrollX()) / ((float) width);
        int childCount = getChildCount();
        if (scrollX < 0.0f) {
            i2 = childCount - 1;
            z2 = false;
        } else {
            int min = Math.min((int) scrollX, childCount - 1);
            i2 = min;
            i3 = (min + 1) % childCount;
        }
        if (a(i2)) {
            if (i3 != 0 || z2) {
                drawChild(canvas, getChildAt(i2), drawingTime);
            } else {
                int i4 = childCount * width;
                canvas.translate((float) (-i4), 0.0f);
                drawChild(canvas, getChildAt(i2), drawingTime);
                canvas.translate((float) i4, 0.0f);
            }
        }
        if (!a(scrollX, i2) && a(i3)) {
            if (i3 != 0 || !z2) {
                drawChild(canvas, getChildAt(i3), drawingTime);
                return;
            }
            int i5 = childCount * width;
            canvas.translate((float) i5, 0.0f);
            drawChild(canvas, getChildAt(i3), drawingTime);
            canvas.translate((float) (-i5), 0.0f);
        }
    }

    public int getCurrentScreen() {
        int i2 = this.s;
        if (i2 < 0) {
            this.s = 0;
        } else if (i2 >= 1) {
            this.s = 0;
        }
        return this.s;
    }

    public void jump(BannerBaseItemInfo bannerBaseItemInfo) {
        SDKJumpManager.getInstance().doSDKJump(getContext(), bannerBaseItemInfo.getName(), bannerBaseItemInfo.getType(), bannerBaseItemInfo.getLinkAddr(), bannerBaseItemInfo.getPrevlogin(), (SDKJumpManager.OnJumpListener) null);
    }

    public void moveToNext() {
        if (this.E.isFinished()) {
            e();
            invalidate();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G.removeMessages(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != 3) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.a((android.view.MotionEvent) r6)
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0061
            r3 = -1
            if (r0 == r2) goto L_0x004d
            r4 = 2
            if (r0 == r4) goto L_0x0018
            r6 = 3
            if (r0 == r6) goto L_0x004d
            goto L_0x008a
        L_0x0018:
            int r0 = r5.p
            int r0 = r6.findPointerIndex(r0)
            if (r0 != r3) goto L_0x0021
            goto L_0x008a
        L_0x0021:
            float r6 = r6.getX(r0)
            float r0 = r5.y
            float r0 = r6 - r0
            float r0 = java.lang.Math.abs(r0)
            int r0 = (int) r0
            int r3 = r5.f1159o
            int r3 = r3 >> r4
            if (r0 < r3) goto L_0x008a
            r5.requestDisallowInterceptTouchEvent(r2)
            r5.t = r2
            r5.y = r6
            int r6 = r5.getScrollX()
            float r6 = (float) r6
            r5.z = r6
            long r3 = java.lang.System.nanoTime()
            float r6 = (float) r3
            r0 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r6 = r6 / r0
            r5.A = r6
            goto L_0x008a
        L_0x004d:
            r5.t = r1
            r5.p = r3
            r5.d()
            com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup$a r6 = r5.G
            android.os.Message r0 = r6.obtainMessage(r2)
            int r3 = g
            long r3 = (long) r3
            r6.sendMessageDelayed(r0, r3)
            goto L_0x008a
        L_0x0061:
            float r0 = r6.getX()
            r5.y = r0
            int r6 = r6.getPointerId(r1)
            r5.p = r6
            int r6 = r5.M
            if (r6 != r2) goto L_0x0074
            r5.t = r1
            goto L_0x007d
        L_0x0074:
            android.widget.Scroller r6 = r5.E
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r2
            r5.t = r6
        L_0x007d:
            com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup$a r6 = r5.G
            boolean r6 = r6.hasMessages(r2)
            if (r6 == 0) goto L_0x008a
            com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup$a r6 = r5.G
            r6.removeMessages(r2)
        L_0x008a:
            int r6 = r5.t
            if (r6 == 0) goto L_0x008f
            r1 = 1
        L_0x008f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i6;
                childAt.layout(i6, 0, measuredWidth, childAt.getMeasuredHeight());
                i6 = measuredWidth;
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i7 = layoutParams.width;
            if (i7 > 0) {
                i4 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else if (i7 == -1) {
                i4 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            } else {
                i4 = i7 == -2 ? View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE) : 0;
            }
            int i8 = layoutParams.height;
            if (i8 > 0) {
                i5 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
            } else if (i8 == -1) {
                i5 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            } else {
                i5 = i8 == -2 ? View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE) : 0;
            }
            childAt.measure(i4, i5);
        }
        if (this.x) {
            scrollTo(this.s * size, 0);
            this.x = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 != 3) goto L_0x0148;
     */
    @android.annotation.TargetApi(8)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r7.M
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0007
            return r1
        L_0x0007:
            r7.requestDisallowInterceptTouchEvent(r2)
            r7.a((android.view.MotionEvent) r8)
            int r0 = r8.getAction()
            if (r0 == 0) goto L_0x012f
            r3 = -1
            if (r0 == r2) goto L_0x009a
            r4 = 2
            if (r0 == r4) goto L_0x001e
            r8 = 3
            if (r0 == r8) goto L_0x009a
            goto L_0x0148
        L_0x001e:
            r7.t = r2
            int r0 = r7.getScrollX()
            float r0 = (float) r0
            r7.z = r0
            int r0 = r7.p
            int r0 = r8.findPointerIndex(r0)
            if (r0 != r3) goto L_0x0031
            goto L_0x0148
        L_0x0031:
            float r8 = r8.getX()
            float r0 = r7.y
            float r0 = r0 - r8
            r7.y = r8
            r8 = 1315859240(0x4e6e6b28, float:1.0E9)
            r1 = 0
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x006d
            float r3 = r7.z
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x005d
            float r1 = -r3
            float r0 = java.lang.Math.max(r1, r0)
            float r3 = r3 + r0
            r7.z = r3
            long r0 = java.lang.System.nanoTime()
            float r0 = (float) r0
            float r0 = r0 / r8
            r7.A = r0
            r7.invalidate()
            goto L_0x0148
        L_0x005d:
            float r3 = r3 + r0
            r7.z = r3
            long r0 = java.lang.System.nanoTime()
            float r0 = (float) r0
            float r0 = r0 / r8
            r7.A = r0
            r7.invalidate()
            goto L_0x0148
        L_0x006d:
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0148
            int r3 = r7.getChildCount()
            int r3 = r3 - r2
            android.view.View r3 = r7.getChildAt(r3)
            int r3 = r3.getRight()
            float r3 = (float) r3
            float r4 = r7.z
            float r3 = r3 - r4
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0148
            float r0 = java.lang.Math.min(r3, r0)
            float r4 = r4 + r0
            r7.z = r4
            long r0 = java.lang.System.nanoTime()
            float r0 = (float) r0
            float r0 = r0 / r8
            r7.A = r0
            r7.invalidate()
            goto L_0x0148
        L_0x009a:
            int r8 = r7.t
            if (r8 != r2) goto L_0x010f
            android.view.VelocityTracker r8 = r7.C
            r0 = 1000(0x3e8, float:1.401E-42)
            int r4 = r7.q
            float r4 = (float) r4
            r8.computeCurrentVelocity(r0, r4)
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 7
            if (r8 <= r0) goto L_0x00b6
            android.view.VelocityTracker r8 = r7.C
            int r0 = r7.p
            float r8 = r8.getXVelocity(r0)
            goto L_0x00bc
        L_0x00b6:
            android.view.VelocityTracker r8 = r7.C
            float r8 = r8.getXVelocity()
        L_0x00bc:
            int r8 = (int) r8
            int r0 = r7.getWidth()
            int r4 = r7.getScrollX()
            int r5 = r0 >> 1
            int r4 = r4 + r5
            int r4 = r4 / r0
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            int r5 = r7.getScrollX()
            float r5 = (float) r5
            float r0 = (float) r0
            float r5 = r5 / r0
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 <= r0) goto L_0x00ed
            int r0 = r7.s
            if (r0 <= r3) goto L_0x00ed
            float r6 = (float) r4
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e5
            int r0 = r0 + -1
        L_0x00e5:
            int r0 = java.lang.Math.min(r4, r0)
            r7.a(r0, r8, r2)
            goto L_0x010f
        L_0x00ed:
            r0 = -200(0xffffffffffffff38, float:NaN)
            if (r8 >= r0) goto L_0x010c
            int r0 = r7.s
            int r6 = r7.getChildCount()
            if (r0 >= r6) goto L_0x010c
            float r0 = (float) r4
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0102
            int r0 = r7.s
            int r0 = r0 + r2
            goto L_0x0104
        L_0x0102:
            int r0 = r7.s
        L_0x0104:
            int r0 = java.lang.Math.max(r4, r0)
            r7.a(r0, r8, r2)
            goto L_0x010f
        L_0x010c:
            r7.a(r4, r1, r2)
        L_0x010f:
            r7.t = r1
            r7.p = r3
            r7.d()
            com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup$a r8 = r7.G
            boolean r8 = r8.hasMessages(r2)
            if (r8 != 0) goto L_0x0148
            int r8 = r7.M
            if (r8 <= r2) goto L_0x0148
            com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup$a r8 = r7.G
            android.os.Message r0 = r8.obtainMessage(r2)
            int r1 = g
            long r3 = (long) r1
            r8.sendMessageDelayed(r0, r3)
            goto L_0x0148
        L_0x012f:
            android.widget.Scroller r0 = r7.E
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x013c
            android.widget.Scroller r0 = r7.E
            r0.abortAnimation()
        L_0x013c:
            float r0 = r8.getX()
            r7.y = r0
            int r8 = r8.getPointerId(r1)
            r7.p = r8
        L_0x0148:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChildLeft(int i2) {
        a aVar = this.G;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setCurrFocusImagePos(CurrFocusImagePos currFocusImagePos) {
        this.D = currFocusImagePos;
        if (currFocusImagePos != null) {
            currFocusImagePos.setCurrPos(this.s, this.M);
        }
    }

    public void setDelayTimer(int i2) {
        g = i2;
    }

    public void setFocusConfigInfo(BannerBaseItemInfo[] bannerBaseItemInfoArr, String str) {
        this.J = bannerBaseItemInfoArr;
        this.I = str;
        f();
    }

    public void setMaiDianDataKey(String str) {
        this.O = str;
    }

    public void setMaindian_public_value(List<String> list) {
        this.P = list;
    }

    public void setPotDot(int i2) {
        int i3 = this.r;
        if (i3 == -1) {
            this.w = getChildCount() - 1;
        } else if (i3 == getChildCount()) {
            this.w = 0;
        } else {
            this.w = Math.max(0, Math.min(this.r, getChildCount() - 1));
        }
        if (this.D != null && getChildAt(this.w) != null && ((Integer) getChildAt(this.w).getTag(ResUtils.id(this.B, "tag_pos"))) != null) {
            this.D.setCurrPos(((Integer) getChildAt(this.w).getTag(ResUtils.id(this.B, "tag_pos"))).intValue(), i2);
        }
    }

    public void submitPage(int i2) {
    }

    public void triggerOnEvent(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(this.O) && (list = this.P) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{str}));
            arrayList.addAll(this.P);
            DXMSdkSAUtils.onEventWithValues(this.O, arrayList);
        }
    }

    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
        int i2 = bannerFocusImageViewGroup.v;
        bannerFocusImageViewGroup.v = i2 + 1;
        return i2;
    }

    private void c() {
        if (this.L < 1) {
            CurrFocusImagePos currFocusImagePos = this.D;
            if (currFocusImagePos != null) {
                currFocusImagePos.setCurrPos(0, this.M);
            }
            removeAllViews();
            for (int i2 = 0; i2 < 1; i2++) {
                FocusImageCellLayout[] focusImageCellLayoutArr = this.F;
                if (focusImageCellLayoutArr[i2] == null) {
                    focusImageCellLayoutArr[i2] = new FocusImageCellLayout(this.B, (AttributeSet) null);
                    this.F[i2].getFocusView().setImageResource(ResUtils.color(this.B, "wallet_base_pressedColor"));
                    this.F[i2].getFocusView().setScaleType(ImageView.ScaleType.FIT_XY);
                    addView(this.F[i2], new ViewGroup.LayoutParams(-1, -1));
                    this.F[i2].setTag(ResUtils.id(this.B, "tag_pos"), Integer.valueOf(i2));
                }
            }
        }
    }

    private void d() {
        VelocityTracker velocityTracker = this.C;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.C = null;
        }
    }

    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = -1;
        this.r = f;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = true;
        this.L = 0;
        this.M = 1;
        a(context, attributeSet);
        this.K = attributeSet;
    }

    private void a(MotionEvent motionEvent) {
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
    }

    public static class FoucsImageItem {
        public int a;
        public String b;
        public String c;

        public FoucsImageItem() {
            this.a = 0;
            this.b = "";
            this.c = "";
            this.a = 0;
            this.b = "";
            this.c = "";
        }

        public String getImageUrl() {
            return this.c;
        }

        public String getPageID() {
            return this.b;
        }

        public int getPageType() {
            return this.a;
        }

        public void setImageUrl(String str) {
            this.c = str;
        }

        public void setPageID(String str) {
            this.b = str;
        }

        public void setPageTpye(int i2) {
            this.a = i2;
        }

        public FoucsImageItem(String str, int i2, String str2) {
            this.a = 0;
            this.b = "";
            this.c = "";
            this.b = str;
            this.a = i2;
            this.c = str2;
        }
    }

    private boolean a(float f2, int i2) {
        return Math.abs(f2 - ((float) i2)) < 1.0E-7f;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.B = context;
        this.s = 0;
        this.F = new FocusImageCellLayout[10];
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1159o = viewConfiguration.getScaledTouchSlop();
        this.q = viewConfiguration.getScaledMaximumFlingVelocity();
        Scroller scroller = new Scroller(getContext());
        this.E = scroller;
        scroller.abortAnimation();
        this.G = new a(this);
        c();
    }

    private boolean a(int i2) {
        return i2 >= 0 && i2 < getChildCount();
    }

    private void a(int i2, int i3, boolean z2) {
        int i4;
        int i5;
        int max = Math.max(-1, Math.min(i2, getChildCount()));
        this.r = max;
        View focusedChild = getFocusedChild();
        if (!(focusedChild == null || max == (i5 = this.s) || focusedChild != getChildAt(i5))) {
            focusedChild.clearFocus();
        }
        int max2 = Math.max(1, Math.abs(max - this.s));
        int width = (max * getWidth()) - getScrollX();
        int i6 = (max2 + 1) * 60;
        if (!this.E.isFinished()) {
            this.E.abortAnimation();
        }
        int abs = Math.abs(i3);
        if (abs > 0) {
            float f2 = (float) i6;
            i4 = (int) (f2 + ((f2 / (((float) abs) / 2500.0f)) * 0.23f));
        } else {
            i4 = i6 + 100;
        }
        this.E.startScroll(getScrollX(), 0, width, 0, i4);
        invalidate();
        setPotDot(this.M);
    }
}
