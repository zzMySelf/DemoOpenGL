package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.widget.newsfeedback.DislikeType;
import com.baidu.searchbox.lightbrowser.model.FeedItemTag;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;

public class DislikePopupView extends MultiTagsFeedbackPopupView {
    private static final String TAG = "DislikePopupView";
    private static final int[] TAG_ROW_RES = {R.id.dislike_row1, R.id.dislike_row2, R.id.dislike_row3};
    private static final int[] TAG_VIEW_RES = {R.id.dislike_tag_1, R.id.dislike_tag_2, R.id.dislike_tag_3, R.id.dislike_tag_4, R.id.dislike_tag_5, R.id.dislike_tag_6};
    private String mCancelText;
    private boolean mIsDark;
    private Button mOkBtn;
    private final View.OnClickListener mOkClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            DislikePopupView.this.dismiss();
            if (DislikePopupView.this.mCallback != null && DislikePopupView.this.hasSelectedTag()) {
                DislikePopupView.this.mCallback.onUnInterest(DislikeType.NOT_READ_SUCH_CONTENT, (SubTagItem) null);
            }
        }
    };
    private String mOkText;
    /* access modifiers changed from: private */
    public LinearLayout mPopupView;
    private final View.OnClickListener mTagItemClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Object tag = v.getTag();
            if (tag instanceof FeedItemTag) {
                FeedItemTag tagItem = (FeedItemTag) tag;
                tagItem.isSelected = !tagItem.isSelected;
                v.setSelected(tagItem.isSelected);
                DislikePopupView.this.refreshTagsTypeface();
                DislikePopupView.this.refreshOkButtonDisplay();
                if (DislikePopupView.this.mPopupView != null) {
                    DislikePopupView.this.mPopupView.invalidate();
                }
            }
        }
    };

    public DislikePopupView(Context context, boolean isDark, boolean hasReport) {
        super(context, TAG_VIEW_RES, TAG_ROW_RES);
        init();
        this.mIsDark = isDark;
        if (context != null) {
            Resources res = context.getResources();
            this.mOkText = res.getString(R.string.page_dislike_confirm);
            this.mCancelText = res.getString(R.string.page_dislike_cancel);
        }
    }

    private void init() {
        setHeight(-1);
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setAlpha(76);
        setBackgroundDrawable(colorDrawable);
    }

    /* access modifiers changed from: protected */
    public void toggleWindow(boolean dark) {
    }

    public View onCreateContentView(View anchor, LayoutInflater inflater) {
        View content = inflater.inflate(R.layout.page_dislike_pop, (ViewGroup) null);
        if (FeedRuntime.getNightMode()) {
            this.mIsDark = true;
        }
        if (content instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) content;
            this.mPopupView = linearLayout;
            configTagViews(linearLayout);
            this.mOkBtn = (Button) this.mPopupView.findViewById(R.id.dislike_btn_ok);
            initOrRefreshUI();
            this.mOkBtn.setOnClickListener(this.mOkClickListener);
            updateViewDisplay();
        } else if (DEBUG) {
            Log.e(TAG, "inflater ContentView error");
        }
        setupPopupContentViewEvent(this.mPopupView);
        return this.mPopupView;
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener obtainTagViewClickListener(View tagView, int index) {
        return this.mTagItemClickListener;
    }

    /* access modifiers changed from: protected */
    public void setupPopupContentViewEvent(View contentView) {
        if (contentView != null) {
            contentView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return DislikePopupView.this.needDismissSelfOnContentViewTouch(v, event);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean needDismissSelfOnContentViewTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
            case 4:
                View popBody = v.findViewById(R.id.dislike_pop_body);
                int[] location = new int[2];
                popBody.getLocationOnScreen(location);
                float eventRawX = event.getRawX();
                float eventRawY = event.getRawY();
                int bodyLeft = location[0];
                int bodyRight = location[0] + popBody.getMeasuredWidth();
                int bodyTop = location[1];
                int bodyBottom = location[1] + popBody.getMeasuredHeight();
                if (eventRawX < ((float) bodyLeft) || eventRawX > ((float) bodyRight) || eventRawY < ((float) bodyTop) || eventRawY > ((float) bodyBottom)) {
                    dismiss();
                    return true;
                }
        }
        return false;
    }

    private void initOrRefreshUI() {
        if (this.mIsDark) {
            Resources res = this.mPopupView.getResources();
            ((TextView) this.mPopupView.findViewById(R.id.dislike_pop_title)).setTextColor(res.getColor(com.baidu.searchbox.feed.styles.R.color.FC1));
            this.mPopupView.findViewById(R.id.btn_separater).setBackground(res.getDrawable(com.baidu.searchbox.feed.styles.R.color.FC67));
            if (!(this.mTagViewList == null || this.mTagViewList.size() == 0)) {
                for (TextView textView : this.mTagViewList) {
                    textView.setTextColor(res.getColorStateList(R.color.page_dislike_tag_text_color));
                    textView.setBackground(res.getDrawable(R.drawable.page_dislike_item_bg));
                }
            }
            this.mPopupView.findViewById(R.id.dislike_pop_body).setBackground(res.getDrawable(R.drawable.page_dislike_body_bg));
        }
        refreshOkButtonDisplay();
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public int getGravity() {
        return 17;
    }

    public int getHeight() {
        return -2;
    }

    /* access modifiers changed from: protected */
    public Animation prepareAnimation(boolean enter) {
        return createFeedStylePopupAnimation(enter, 0.5f, 0.5f, 300);
    }

    private void updateViewDisplay() {
        forceSetViewWidth();
        refreshOkButtonDisplay();
    }

    /* access modifiers changed from: private */
    public void refreshOkButtonDisplay() {
        int color;
        if (hasSelectedTag()) {
            this.mOkBtn.setText(this.mOkText);
            color = this.mPopupView.getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC108);
        } else {
            this.mOkBtn.setText(this.mCancelText);
            color = this.mPopupView.getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC1);
        }
        this.mOkBtn.setTextColor(FeedTemplateUtil.getTappedColorStateList(color));
    }

    private void forceSetViewWidth() {
        LinearLayout linearLayout;
        View popBody;
        Context ctx = getContext();
        if (ctx != null && (linearLayout = this.mPopupView) != null && (popBody = linearLayout.findViewById(R.id.dislike_pop_body)) != null) {
            DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
            ViewGroup.LayoutParams lp = popBody.getLayoutParams();
            lp.width = (int) (((float) Math.min(dm.widthPixels, dm.heightPixels)) * 0.8f);
            popBody.setLayoutParams(lp);
        }
    }
}
