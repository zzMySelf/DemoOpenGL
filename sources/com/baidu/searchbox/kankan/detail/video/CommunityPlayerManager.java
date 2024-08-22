package com.baidu.searchbox.kankan.detail.video;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.kankan.detail.video.player.CommunityVideoPlayer;

public class CommunityPlayerManager {
    public static final int LAND_PAGE = 1;
    public static final int LIST_NONE = -1;
    public static final int LIST_PAGE = 0;
    private static boolean sIsVideoMute = true;
    private static volatile CommunityPlayerManager sManager;
    private String mPage;
    private CommunityVideoPlayer mVideoPlayer;

    private CommunityPlayerManager() {
    }

    public static CommunityPlayerManager getInstance() {
        if (sManager == null) {
            synchronized (CommunityPlayerManager.class) {
                if (sManager == null) {
                    sManager = new CommunityPlayerManager();
                }
            }
        }
        return sManager;
    }

    public CommunityVideoPlayer getCommunityVideoPlayer(int page) {
        if (this.mVideoPlayer == null) {
            this.mVideoPlayer = new CommunityVideoPlayer(AppRuntime.getAppContext(), "");
        }
        this.mVideoPlayer.switchToPage(page);
        return this.mVideoPlayer;
    }

    public CommunityVideoPlayer getCurVideoPlayer() {
        return this.mVideoPlayer;
    }

    public void releaseVideoPlayer() {
        CommunityVideoPlayer communityVideoPlayer = this.mVideoPlayer;
        if (communityVideoPlayer != null) {
            communityVideoPlayer.release();
            this.mVideoPlayer = null;
        }
    }

    public String getPage() {
        return this.mPage;
    }

    public void setPage(String page) {
        this.mPage = page;
    }

    public int getVideoInPage() {
        CommunityVideoPlayer communityVideoPlayer = this.mVideoPlayer;
        if (communityVideoPlayer == null) {
            return -1;
        }
        return communityVideoPlayer.getPage();
    }

    public static boolean isVideoMute() {
        return sIsVideoMute;
    }

    public static void setVideoMute(boolean isVideoMute) {
        sIsVideoMute = isVideoMute;
    }
}
