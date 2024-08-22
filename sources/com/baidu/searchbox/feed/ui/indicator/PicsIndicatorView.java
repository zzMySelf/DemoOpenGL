package com.baidu.searchbox.feed.ui.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.feed.ui.R;
import com.baidu.searchbox.feed.ui.indicator.Dot;
import java.util.ArrayList;
import java.util.List;

public class PicsIndicatorView extends View {
    private static final int DEFAULT_VISIBLE_DOTS_COUNT = 5;
    private static final int MIN_VISIBLE_DOT_COUNT = 5;
    private static final int PAGE_COUNT = 6;
    private int activeDotSize;
    private Paint activePaint = new Paint(1);
    private AttributeSet attributeSet;
    /* access modifiers changed from: private */
    public int currentPage = 0;
    /* access modifiers changed from: private */
    public int dotMargin;
    /* access modifiers changed from: private */
    public List<Dot> dotsList = new ArrayList();
    /* access modifiers changed from: private */
    public int firstIndicatorPos;
    private int inactiveDotSize;
    private Paint inactivePaint = new Paint(1);
    private int index = 0;
    private ViewPager mAttachedVp;
    /* access modifiers changed from: private */
    public int noOfPages;
    private int posY = 0;
    private int previousPage = 0;
    private int smallDotSize;
    private int startPosX;
    private ValueAnimator translationAnim;
    private int visibleDotCounts = 5;

    public interface TranslationAnimationListener {
        void onAnimationEnd();
    }

    public PicsIndicatorView(Context context) {
        super(context);
        setup(context, (AttributeSet) null);
    }

    public PicsIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
        this.attributeSet = attrs;
    }

    public PicsIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs);
        this.attributeSet = attrs;
    }

    public PicsIndicatorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup(context, attrs);
        this.attributeSet = attrs;
    }

    private void setup(Context context, AttributeSet attributeSet2) {
        Resources resources = getResources();
        if (attributeSet2 != null) {
            TypedArray ta = context.obtainStyledAttributes(attributeSet2, R.styleable.PicsIndicatorView);
            this.activePaint.setStyle(Paint.Style.FILL);
            this.activePaint.setColor(ta.getColor(R.styleable.PicsIndicatorView_dot_activeColor, resources.getColor(com.baidu.android.common.ui.style.R.color.GC7)));
            this.inactivePaint.setStyle(Paint.Style.FILL);
            this.inactivePaint.setColor(ta.getColor(R.styleable.PicsIndicatorView_dot_inactiveColor, resources.getColor(com.baidu.searchbox.feed.styles.R.color.FC125)));
            this.activeDotSize = ta.getDimensionPixelSize(R.styleable.PicsIndicatorView_dot_activeSize, resources.getDimensionPixelSize(R.dimen.dot_active_size));
            this.inactiveDotSize = ta.getDimensionPixelSize(R.styleable.PicsIndicatorView_dot_inactiveSize, resources.getDimensionPixelSize(R.dimen.dot_inactive_size));
            this.smallDotSize = ta.getDimensionPixelSize(R.styleable.PicsIndicatorView_dot_smallSize, resources.getDimensionPixelSize(R.dimen.dot_small_size));
            this.dotMargin = ta.getDimensionPixelSize(R.styleable.PicsIndicatorView_dot_margin, resources.getDimensionPixelSize(R.dimen.dot_margin));
            setVisibleDotCounts(ta.getInteger(R.styleable.PicsIndicatorView_dots_visible, 5));
            ta.recycle();
        }
        this.posY = this.activeDotSize / 2;
        initCircles();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        int i2 = this.dotMargin;
        int size = (w / 2) - (((this.dotsList.size() - 1) * i2) / 2);
        this.firstIndicatorPos = size;
        setStartPosX(size - i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height;
        int desiredHeight = this.activeDotSize;
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int width = widthSize;
        if (heightMode == 1073741824) {
            height = heightSize;
        } else if (heightMode == Integer.MIN_VALUE) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        setMeasuredDimension(width, height + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircles(canvas);
    }

    public void attachViewPager(ViewPager vp) {
        if (vp != null) {
            this.mAttachedVp = vp;
            vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    PicsIndicatorView.this.onPageChange(position);
                }

                public void onPageScrollStateChanged(int state) {
                }
            });
        }
    }

    private void initCircles() {
        Dot.State state;
        int i2;
        int i3;
        int viewCount = Math.min(getNoOfPages(), getVisibleDotCounts());
        if (viewCount >= 1) {
            setStartPosX(this.firstIndicatorPos - this.dotMargin);
            this.dotsList = new ArrayList(viewCount);
            int i4 = 0;
            while (i4 < viewCount) {
                Dot dot = new Dot();
                int i5 = this.noOfPages;
                if (i5 > this.visibleDotCounts) {
                    state = (i5 != 6 || !((i3 = this.index) == 4 || i3 == 5) || i3 >= i5) ? (i5 <= 6 || (i2 = this.index) < 4 || i2 > i5 + -3) ? i4 == getVisibleDotCounts() - 1 ? Dot.State.SMALL : i4 == this.index ? Dot.State.ACTIVE : Dot.State.INACTIVE : (i4 == 0 || i4 == getVisibleDotCounts() - 1) ? Dot.State.SMALL : i4 == getVisibleDotCounts() + -2 ? Dot.State.ACTIVE : Dot.State.INACTIVE : i4 == 0 ? Dot.State.SMALL : i4 == i3 + -1 ? Dot.State.ACTIVE : Dot.State.INACTIVE;
                } else {
                    state = i4 == this.index ? Dot.State.ACTIVE : Dot.State.INACTIVE;
                }
                dot.setState(state);
                this.dotsList.add(dot);
                i4++;
            }
            invalidate();
        }
    }

    private void drawCircles(Canvas canvas) {
        int radius;
        int posX = getStartPosX();
        if (this.dotsList.size() > getVisibleDotCounts()) {
            List<Dot> list = this.dotsList;
            list.remove(list.size() - 2);
        }
        for (int i2 = 0; i2 < this.dotsList.size(); i2++) {
            Paint paint = this.inactivePaint;
            switch (AnonymousClass6.$SwitchMap$com$baidu$searchbox$feed$ui$indicator$Dot$State[this.dotsList.get(i2).getState().ordinal()]) {
                case 1:
                    paint = this.activePaint;
                    radius = getActiveDotRadius();
                    posX += this.dotMargin;
                    break;
                case 2:
                    radius = getInactiveDotRadius();
                    posX += this.dotMargin;
                    break;
                case 3:
                    radius = getSmallDotRadius();
                    posX += this.dotMargin;
                    break;
                default:
                    radius = 0;
                    posX = 0;
                    break;
            }
            canvas.drawCircle((float) posX, (float) (this.posY + getPaddingTop()), (float) radius, paint);
        }
    }

    /* renamed from: com.baidu.searchbox.feed.ui.indicator.PicsIndicatorView$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$feed$ui$indicator$Dot$State;

        static {
            int[] iArr = new int[Dot.State.values().length];
            $SwitchMap$com$baidu$searchbox$feed$ui$indicator$Dot$State = iArr;
            try {
                iArr[Dot.State.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$ui$indicator$Dot$State[Dot.State.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$ui$indicator$Dot$State[Dot.State.SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private ValueAnimator getTranslationAnimation(int from, int to, final TranslationAnimationListener listener) {
        ValueAnimator valueAnimator = this.translationAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{from, to});
        this.translationAnim = ofInt;
        ofInt.setDuration(120);
        this.translationAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.translationAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (PicsIndicatorView.this.getStartPosX() != val) {
                    PicsIndicatorView.this.setStartPosX(val);
                    PicsIndicatorView.this.invalidate();
                }
            }
        });
        this.translationAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TranslationAnimationListener translationAnimationListener = listener;
                if (translationAnimationListener != null) {
                    translationAnimationListener.onAnimationEnd();
                }
            }
        });
        return this.translationAnim;
    }

    public void setNoOfPages(int noOfPages2) {
        setVisibility(noOfPages2 <= 1 ? 8 : 0);
        if (noOfPages2 > 1) {
            this.noOfPages = noOfPages2;
            recreate();
        }
    }

    public int getNoOfPages() {
        return this.noOfPages;
    }

    public void setVisibleDotCounts(int visibleDotCounts2) {
        if (visibleDotCounts2 >= 5) {
            this.visibleDotCounts = visibleDotCounts2;
            recreate();
        }
    }

    private void recreate() {
        initCircles();
        requestLayout();
        invalidate();
    }

    public void nightModeChanged() {
        if (this.attributeSet != null) {
            TypedArray ta = getContext().obtainStyledAttributes(this.attributeSet, R.styleable.PicsIndicatorView);
            this.activePaint.setColor(ta.getColor(R.styleable.PicsIndicatorView_dot_activeColor, getResources().getColor(com.baidu.android.common.ui.style.R.color.GC7)));
            this.inactivePaint.setColor(ta.getColor(R.styleable.PicsIndicatorView_dot_inactiveColor, getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC125)));
            ta.recycle();
            invalidate();
        }
    }

    public void nightModeChanged(int activeColor, int inactiveColor) {
        this.activePaint.setColor(activeColor);
        this.inactivePaint.setColor(inactiveColor);
        invalidate();
    }

    public int getVisibleDotCounts() {
        return this.visibleDotCounts;
    }

    public void setStartPosX(int startPosX2) {
        this.startPosX = startPosX2;
    }

    public int getStartPosX() {
        return this.startPosX;
    }

    private int getActiveDotRadius() {
        return this.activeDotSize / 2;
    }

    private int getInactiveDotRadius() {
        return this.inactiveDotSize / 2;
    }

    private int getSmallDotRadius() {
        return this.smallDotSize / 2;
    }

    public void onPageChange(int pagePos) {
        this.currentPage = pagePos;
        if (pagePos != this.previousPage && pagePos >= 0) {
            updateDots();
            this.previousPage = this.currentPage;
        }
    }

    public void setIndex(int index2) {
        this.index = index2;
    }

    public void resetPreviousPage() {
        this.previousPage = 0;
    }

    private void updateDots() {
        if (this.noOfPages <= this.visibleDotCounts) {
            setupNormalDots();
            return;
        }
        int i2 = 0;
        while (i2 < this.dotsList.size()) {
            Dot currentDot = this.dotsList.get(i2);
            if (currentDot.getState().equals(Dot.State.ACTIVE)) {
                currentDot.setState(Dot.State.INACTIVE);
                if (this.currentPage > this.previousPage) {
                    setupFlexibleCirclesRight(i2);
                    return;
                } else {
                    setupFlexibleCirclesLeft(i2);
                    return;
                }
            } else {
                i2++;
            }
        }
    }

    private void setupNormalDots() {
        if (this.currentPage < this.dotsList.size() && this.previousPage < this.dotsList.size()) {
            for (int index2 = 0; index2 < this.dotsList.size(); index2++) {
                Dot dot = this.dotsList.get(index2);
                if (index2 == this.currentPage) {
                    dot.setState(Dot.State.ACTIVE);
                } else {
                    dot.setState(Dot.State.INACTIVE);
                }
            }
            invalidate();
        }
    }

    private void setupFlexibleCirclesRight(int position) {
        if (position < getVisibleDotCounts() - 2) {
            this.dotsList.get(position + 1).setState(Dot.State.ACTIVE);
            invalidate();
        } else if (this.currentPage == getNoOfPages() - 1) {
            List<Dot> list = this.dotsList;
            list.get(list.size() - 1).setState(Dot.State.ACTIVE);
            invalidate();
        } else {
            removeAddRight(position);
        }
    }

    private void removeAddRight(final int position) {
        this.dotsList.remove(0);
        int i2 = this.firstIndicatorPos;
        getTranslationAnimation(i2, i2 - this.dotMargin, new TranslationAnimationListener() {
            public void onAnimationEnd() {
                ((Dot) PicsIndicatorView.this.dotsList.get(0)).setState(Dot.State.SMALL);
                Dot newDot = new Dot();
                newDot.setState(Dot.State.ACTIVE);
                if (position < PicsIndicatorView.this.dotsList.size()) {
                    PicsIndicatorView.this.dotsList.add(position, newDot);
                }
                if (PicsIndicatorView.this.currentPage + 1 == PicsIndicatorView.this.noOfPages - 1) {
                    ((Dot) PicsIndicatorView.this.dotsList.get(PicsIndicatorView.this.dotsList.size() - 1)).setState(Dot.State.INACTIVE);
                }
                PicsIndicatorView.this.invalidate();
            }
        }).start();
    }

    private void setupFlexibleCirclesLeft(int position) {
        if (position > 1) {
            this.dotsList.get(position - 1).setState(Dot.State.ACTIVE);
            invalidate();
        } else if (this.currentPage == 0) {
            this.dotsList.get(0).setState(Dot.State.ACTIVE);
            invalidate();
        } else {
            removeAddLeft(position);
        }
    }

    private void removeAddLeft(final int position) {
        List<Dot> list = this.dotsList;
        list.remove(list.size() - 1);
        setStartPosX(this.firstIndicatorPos - this.dotMargin);
        int i2 = this.firstIndicatorPos;
        getTranslationAnimation(i2 - this.dotMargin, i2, new TranslationAnimationListener() {
            public void onAnimationEnd() {
                ((Dot) PicsIndicatorView.this.dotsList.get(PicsIndicatorView.this.dotsList.size() - 1)).setState(Dot.State.SMALL);
                Dot newDot = new Dot();
                newDot.setState(Dot.State.ACTIVE);
                PicsIndicatorView.this.dotsList.add(position, newDot);
                PicsIndicatorView picsIndicatorView = PicsIndicatorView.this;
                picsIndicatorView.setStartPosX(picsIndicatorView.firstIndicatorPos - PicsIndicatorView.this.dotMargin);
                if (PicsIndicatorView.this.currentPage - 1 == 0) {
                    ((Dot) PicsIndicatorView.this.dotsList.get(0)).setState(Dot.State.INACTIVE);
                }
                PicsIndicatorView.this.invalidate();
            }
        }).start();
    }
}
