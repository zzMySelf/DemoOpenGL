package com.baidu.browser.tabna.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.baidu.browser.tabna.R;
import com.baidu.browser.tabna.model.EmptyPageModel;

public class NoResultView extends ConstraintLayout {
    /* access modifiers changed from: private */
    public EmptyPageModel mCurModel;
    private View mDivider;
    private ImageView mImage;
    /* access modifiers changed from: private */
    public OnLoadUrlListener mLoadUrlListener;
    private TextView mQuerySuggest;
    private TextView mQueryText;
    private TextView mText;
    private final String mTitle;

    public interface OnLoadUrlListener {
        void onLoadUrl(String str);
    }

    public NoResultView(Context context, String title) {
        super(context);
        this.mTitle = title;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.browser_na_no_result, this);
        this.mImage = (ImageView) findViewById(R.id.no_result_image);
        this.mText = (TextView) findViewById(R.id.no_result_text);
        this.mQuerySuggest = (TextView) findViewById(R.id.no_result_suggest);
        this.mQueryText = (TextView) findViewById(R.id.no_result_suggest_query);
        this.mDivider = findViewById(R.id.no_result_divider);
        this.mQueryText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                if (NoResultView.this.mCurModel != null && !TextUtils.isEmpty(NoResultView.this.mCurModel.scheme) && NoResultView.this.mLoadUrlListener != null) {
                    NoResultView.this.mLoadUrlListener.onLoadUrl(NoResultView.this.mCurModel.scheme);
                }
            }
        });
        onNightModeChanged();
    }

    public void setGuideLineEnd(int marginEnd) {
        ((Guideline) findViewById(R.id.no_result_bottom)).setGuidelineEnd(marginEnd);
    }

    public void setDividerVisibility(int visibility) {
        this.mDivider.setVisibility(visibility);
    }

    public void onNightModeChanged() {
        setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC9));
        this.mImage.setImageResource(R.drawable.browser_na_no_result);
        this.mText.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mQuerySuggest.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
        this.mQueryText.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC7));
        this.mDivider.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC33));
    }

    public void update(EmptyPageModel model) {
        this.mCurModel = model;
        if (model == null || TextUtils.isEmpty(model.text)) {
            this.mText.setText(String.format(getResources().getString(R.string.na_no_result_default_text), new Object[]{this.mTitle}));
        } else {
            this.mText.setText(model.text);
        }
        if (model == null || TextUtils.isEmpty(model.query)) {
            this.mQueryText.setVisibility(8);
            return;
        }
        this.mQueryText.setText(model.query);
        this.mQueryText.setVisibility(0);
    }

    public void setTitleTextColor(int color) {
        TextView textView = this.mText;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setImageAlpha(int alpha) {
        ImageView imageView = this.mImage;
        if (imageView != null) {
            imageView.setImageAlpha(alpha);
        }
    }

    public void setQueryTextColor(int color) {
        TextView textView = this.mQueryText;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setQuerySuggestTextColor(int color) {
        TextView textView = this.mQuerySuggest;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setLoadUrlListener(OnLoadUrlListener loadUrlListener) {
        this.mLoadUrlListener = loadUrlListener;
    }
}
