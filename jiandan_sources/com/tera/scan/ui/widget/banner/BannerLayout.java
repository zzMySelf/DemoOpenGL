package com.tera.scan.ui.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.widget.banner.layoutmanager.BannerLayoutManager;
import com.tera.scan.ui.widget.banner.layoutmanager.CenterSnapHelper;

public class BannerLayout extends FrameLayout {
    public static final int WHAT_AUTO_PLAY = 1000;
    public int autoPlayDuration;
    public int bannerSize;
    public float centerScale;
    public int currentIndex;
    public boolean hasInit;
    public boolean isAutoPlaying;
    public boolean isPlaying;
    public int itemSpace;
    public CenterSnapHelper mCenterSnapHelper;
    public boolean mEnableFling;
    public Handler mHandler;
    public BannerIndicator mIndicator;
    public BannerLayoutManager mLayoutManager;
    public RecyclerView.AdapterDataObserver mObserver;
    public RecyclerView mRecyclerView;
    public float moveSpeed;

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageSelected(int i2);
    }

    public class ad extends RecyclerView.AdapterDataObserver {
        public ad() {
        }

        public void onChanged() {
            BannerLayout.this.updateSize();
        }
    }

    public class de extends RecyclerView.OnScrollListener {
        public de() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int currentPosition = BannerLayout.this.mLayoutManager.getCurrentPosition();
            if (BannerLayout.this.currentIndex != currentPosition) {
                int unused = BannerLayout.this.currentIndex = currentPosition;
            }
            if (i2 == 0) {
                BannerLayout.this.setPlaying(true);
            }
            BannerLayout.this.refreshIndicator();
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0) {
                BannerLayout.this.setPlaying(false);
            }
        }
    }

    public class qw implements Handler.Callback {
        public qw() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1000 || BannerLayout.this.currentIndex != BannerLayout.this.mLayoutManager.getCurrentPosition()) {
                return false;
            }
            BannerLayout.access$004(BannerLayout.this);
            BannerLayout.this.mRecyclerView.smoothScrollToPosition(BannerLayout.this.currentIndex);
            BannerLayout bannerLayout = BannerLayout.this;
            bannerLayout.mHandler.sendEmptyMessageDelayed(1000, (long) bannerLayout.autoPlayDuration);
            BannerLayout.this.refreshIndicator();
            return false;
        }
    }

    public BannerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int access$004(BannerLayout bannerLayout) {
        int i2 = bannerLayout.currentIndex + 1;
        bannerLayout.currentIndex = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    public synchronized void refreshIndicator() {
        if (this.mIndicator != null) {
            if (this.bannerSize <= 1) {
                this.mIndicator.setVisibility(8);
            } else {
                this.mIndicator.setVisibility(0);
                this.mIndicator.updatePos(this.currentIndex % this.bannerSize, this.bannerSize);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateSize() {
        int i2;
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        boolean z = false;
        if (adapter == null) {
            i2 = 0;
        } else {
            i2 = adapter.getItemCount();
        }
        this.bannerSize = i2;
        BannerLayoutManager bannerLayoutManager = this.mLayoutManager;
        if (i2 > 1) {
            z = true;
        }
        bannerLayoutManager.setInfinite(z);
        refreshIndicator();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setPlaying(false);
        } else if (action == 1 || action == 3) {
            setPlaying(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getSelectedPosition() {
        BannerLayoutManager bannerLayoutManager = this.mLayoutManager;
        if (bannerLayoutManager == null) {
            return 0;
        }
        return bannerLayoutManager.getCurrentPosition();
    }

    public void initView(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BannerLayout);
        int i2 = 0;
        this.autoPlayDuration = obtainStyledAttributes.getInt(0, 4000);
        this.isAutoPlaying = obtainStyledAttributes.getBoolean(1, true);
        this.itemSpace = obtainStyledAttributes.getInt(4, 20);
        this.centerScale = obtainStyledAttributes.getFloat(2, 1.2f);
        this.moveSpeed = obtainStyledAttributes.getFloat(5, 1.0f);
        this.mEnableFling = obtainStyledAttributes.getBoolean(3, false);
        if (obtainStyledAttributes.getInt(6, 0) == 1) {
            i2 = 1;
        }
        obtainStyledAttributes.recycle();
        this.mRecyclerView = new RecyclerView(context);
        addView(this.mRecyclerView, new FrameLayout.LayoutParams(-1, -1));
        BannerLayoutManager bannerLayoutManager = new BannerLayoutManager(getContext(), i2);
        this.mLayoutManager = bannerLayoutManager;
        bannerLayoutManager.setItemSpace(this.itemSpace);
        this.mLayoutManager.setCenterScale(this.centerScale);
        this.mLayoutManager.setMoveSpeed(this.moveSpeed);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
        this.mCenterSnapHelper = centerSnapHelper;
        centerSnapHelper.attachToRecyclerView(this.mRecyclerView, this.mEnableFling);
        this.mObserver = new ad();
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            setPlaying(true);
        } else {
            setPlaying(false);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.hasInit = false;
        RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
        }
        this.mRecyclerView.setAdapter(adapter);
        adapter.registerAdapterDataObserver(this.mObserver);
        updateSize();
        setPlaying(true);
        this.mRecyclerView.addOnScrollListener(new de());
        this.hasInit = true;
    }

    public void setAutoPlayDuration(int i2) {
        this.autoPlayDuration = i2;
    }

    public void setAutoPlaying(boolean z) {
        this.isAutoPlaying = z;
        setPlaying(z);
    }

    public void setCenterScale(float f) {
        this.centerScale = f;
        this.mLayoutManager.setCenterScale(f);
    }

    public void setIndicator(BannerIndicator bannerIndicator) {
        this.mIndicator = bannerIndicator;
        refreshIndicator();
    }

    public void setItemSpace(int i2) {
        this.itemSpace = i2;
        this.mLayoutManager.setItemSpace(i2);
    }

    public void setMoveSpeed(float f) {
        this.moveSpeed = f;
        this.mLayoutManager.setMoveSpeed(f);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mCenterSnapHelper.setOnPageChangeListener(onPageChangeListener);
    }

    public void setOrientation(int i2) {
        this.mLayoutManager.setOrientation(i2);
    }

    public synchronized void setPlaying(boolean z) {
        if (this.isAutoPlaying && this.hasInit) {
            if (!this.isPlaying && z) {
                this.mHandler.sendEmptyMessageDelayed(1000, (long) this.autoPlayDuration);
                this.isPlaying = true;
            } else if (this.isPlaying && !z) {
                this.mHandler.removeMessages(1000);
                this.isPlaying = false;
            }
        }
    }

    public BannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isPlaying = false;
        this.isAutoPlaying = true;
        this.mHandler = new Handler(new qw());
        initView(context, attributeSet);
    }
}
