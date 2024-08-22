package com.baidu.searchbox.audio.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.audio.R;

public class EpisodeListFreeFlagView extends FrameLayout {
    private int flag;
    private View mFreeStatusBg;
    private TextView mFreeStatusText;
    private ImageView mLockStatusIv;

    public EpisodeListFreeFlagView(Context context) {
        this(context, (AttributeSet) null);
    }

    public EpisodeListFreeFlagView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EpisodeListFreeFlagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.flag = 2;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.episode_list_free_flag_view, this);
        this.mFreeStatusBg = findViewById(R.id.ll_episodes_item_free);
        this.mFreeStatusText = (TextView) findViewById(R.id.tv_episodes_item_free);
        ImageView imageView = (ImageView) findViewById(R.id.iv_episodes_item_lock);
        this.mLockStatusIv = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }

    public void setEpisodeFreeStatus(int status) {
        this.flag = status;
        if (status == 2) {
            this.mFreeStatusBg.setVisibility(8);
            this.mLockStatusIv.setVisibility(0);
            this.mLockStatusIv.setImageResource(R.drawable.audio_channel_episode_lock);
        } else if (status == 3) {
            this.mLockStatusIv.setVisibility(8);
            this.mFreeStatusBg.setVisibility(0);
            this.mFreeStatusBg.setBackground(getResources().getDrawable(R.drawable.episode_item_free_bg));
            this.mFreeStatusText.setTextColor(getResources().getColor(R.color.episode_item_free_text_color));
        } else {
            setVisibility(8);
        }
    }

    private void updateUI() {
        setEpisodeFreeStatus(this.flag);
    }
}
