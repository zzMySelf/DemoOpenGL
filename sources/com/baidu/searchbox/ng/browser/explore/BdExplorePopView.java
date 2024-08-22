package com.baidu.searchbox.ng.browser.explore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ng.browser.R;

public class BdExplorePopView extends LinearLayout implements View.OnClickListener, NoProGuard {
    private static final int FAST_CLICK_DELAY_TIME = 1000;
    public static final int SELECTION_MARGIN = 17;
    public static final int SELECTION_PADDING = 22;
    public static final int SELECTION_TOP_DUR = 3000;
    private View mCopyView;
    private long mLastClickTime;
    private BdExplorePopViewListener mListener;
    private int mPopBottomY;
    private int mPopLeftX;
    private int mPopRightX;
    private int mPopTopY;
    private int mPopX;
    private int mPopY;
    private View mSearchView;
    private String mSelection;
    private View mWrongWordReportView;

    public interface BdExplorePopViewListener {
        void doSelectionCancel();

        void doSelectionCopy(String str);

        void doSelectionSearch(String str);

        void doSelectionWrongWordReport(String str);
    }

    public BdExplorePopView(Context aContext) {
        this(aContext, (AttributeSet) null);
    }

    public BdExplorePopView(Context aContext, AttributeSet aAttrs) {
        super(aContext, aAttrs);
        this.mLastClickTime = 0;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.btn_wv_copy);
        this.mCopyView = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.btn_wv_search);
        this.mSearchView = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = findViewById(R.id.btn_wv_wrong_word_report);
        this.mWrongWordReportView = findViewById3;
        findViewById3.setOnClickListener(this);
    }

    public void onClick(View v) {
        BdExplorePopViewListener bdExplorePopViewListener;
        if (System.currentTimeMillis() - this.mLastClickTime >= 1000) {
            this.mLastClickTime = System.currentTimeMillis();
            if (v.equals(this.mCopyView)) {
                BdExplorePopViewListener bdExplorePopViewListener2 = this.mListener;
                if (bdExplorePopViewListener2 != null) {
                    bdExplorePopViewListener2.doSelectionCopy(this.mSelection);
                }
            } else if (v.equals(this.mSearchView)) {
                BdExplorePopViewListener bdExplorePopViewListener3 = this.mListener;
                if (bdExplorePopViewListener3 != null) {
                    bdExplorePopViewListener3.doSelectionSearch(this.mSelection);
                }
            } else if (v.equals(this.mWrongWordReportView) && (bdExplorePopViewListener = this.mListener) != null) {
                bdExplorePopViewListener.doSelectionWrongWordReport(this.mSelection);
            }
        }
    }

    public int getPopX() {
        return this.mPopX;
    }

    public void setPopX(int aPopX) {
        this.mPopX = aPopX;
    }

    public int getPopY() {
        return this.mPopY;
    }

    public void setPopY(int aPopY) {
        this.mPopY = aPopY;
    }

    public int getPopLeftX() {
        return this.mPopLeftX;
    }

    public void setPopLeftX(int aPopLeftX) {
        this.mPopLeftX = aPopLeftX;
    }

    public int getPopRightX() {
        return this.mPopRightX;
    }

    public void setPopRightX(int aPopRightX) {
        this.mPopRightX = aPopRightX;
    }

    public int getPopTopY() {
        return this.mPopTopY;
    }

    public void setPopTopY(int aPopTopY) {
        this.mPopTopY = aPopTopY;
    }

    public int getPopBottomY() {
        return this.mPopBottomY;
    }

    public void setPopBottomY(int aPopBottomY) {
        this.mPopBottomY = aPopBottomY;
    }

    public void setSelection(String aSelection) {
        this.mSelection = aSelection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public void setEventListener(BdExplorePopViewListener aListener) {
        this.mListener = aListener;
    }
}
