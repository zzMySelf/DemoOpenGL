package com.baidu.searchbox.player.element;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.video.videoplayer.widget.ImageTextView;
import com.baidu.searchbox.videoplayer.business.R;

public class ReplayBtnElement extends ControlLayerElement implements View.OnClickListener {
    protected FrameLayout mBackground;

    public void initElement() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mBackground = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ImageTextView imageTextView = new ImageTextView(getContext());
        imageTextView.setIconAndTitle(R.drawable.videoplayer_new_player_replay_button_selector, R.string.player_common_replay);
        imageTextView.setTextColor(R.drawable.videoplayer_quick_share_item);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mBackground.addView(imageTextView, layoutParams);
        imageTextView.setOnClickListener(this);
        this.mBackground.setBackgroundColor(getContext().getResources().getColor(R.color.bd_full_end_bgd));
        this.mBackground.setVisibility(8);
        this.mBackground.setClickable(true);
    }

    public void onEventNotify(VideoEvent event) {
        super.onEventNotify(event);
        if ("player_event_on_complete".equals(event.getAction())) {
            this.mBackground.setVisibility(0);
        }
    }

    public View getContentView() {
        return this.mBackground;
    }

    public void onClick(View v) {
        getVideoPlayer().resumePlayer(true);
        this.mBackground.setVisibility(8);
    }
}
