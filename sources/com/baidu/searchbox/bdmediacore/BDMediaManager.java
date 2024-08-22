package com.baidu.searchbox.bdmediacore;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.bdmediacore.callback.PlaybackManager;
import com.baidu.searchbox.bdmediacore.controller.MediaControllerCallBack;
import com.baidu.searchbox.bdmediacore.controller.MediaParams;
import com.baidu.searchbox.bdmediacore.interfaces.IBDMediaCallBack;
import com.baidu.searchbox.bdmediacore.interfaces.IBDMediaDataProvider;
import com.baidu.searchbox.bdmediacore.models.MediaActions;
import com.baidu.searchbox.bdmediacore.statistic.MediaHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.MiniPlayerView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class BDMediaManager {
    private static final boolean DEBUG = MediaRuntime.DEBUG;
    private static final String MEDIA_SESSION_PREFIX = "MediaSession-";
    private static final String TAG = "BDMEDIA-facade";
    private String mActiveBizName;
    private final ConcurrentHashMap<String, MediaControllerCallBack> mControllerCallbacks;
    private final ConcurrentHashMap<String, MediaSessionCompat> mMediaSessions;
    private final ConcurrentHashMap<String, PlaybackManager> mPlaybackManagers;

    private BDMediaManager() {
        this.mMediaSessions = new ConcurrentHashMap<>();
        this.mPlaybackManagers = new ConcurrentHashMap<>();
        this.mControllerCallbacks = new ConcurrentHashMap<>();
    }

    public MediaControllerCallBack getControllerCallback(String bizName) {
        if (TextUtils.isEmpty(bizName)) {
            return null;
        }
        return this.mControllerCallbacks.get(bizName);
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final BDMediaManager INSTANCE = new BDMediaManager();

        private Holder() {
        }
    }

    public static BDMediaManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(String bizName, IBDMediaCallBack bizCallBack, IBDMediaDataProvider dataProvider) {
        if (!TextUtils.isEmpty(bizName)) {
            if (DEBUG) {
                Log.d(TAG, bizName + " --init");
            }
            MediaSessionCompat mediaSession = this.mMediaSessions.get(bizName);
            if (mediaSession == null) {
                mediaSession = new MediaSessionCompat(AppRuntime.getAppContext(), MEDIA_SESSION_PREFIX + bizName);
                mediaSession.setFlags(3);
                this.mMediaSessions.put(bizName, mediaSession);
            }
            PlaybackManager playbackManager = this.mPlaybackManagers.get(bizName);
            if (playbackManager == null) {
                playbackManager = new PlaybackManager(bizName, dataProvider);
                this.mPlaybackManagers.put(bizName, playbackManager);
            }
            mediaSession.setCallback(playbackManager.getMediaSessionCallback());
            MediaControllerCallBack mediaControllerCallBack = this.mControllerCallbacks.get(bizName);
            if (mediaControllerCallBack == null) {
                mediaControllerCallBack = new MediaControllerCallBack(bizName, bizCallBack);
                this.mControllerCallbacks.put(bizName, mediaControllerCallBack);
            }
            mediaSession.getController().registerCallback(mediaControllerCallBack);
        }
    }

    public void prepare(String bizName) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            this.mActiveBizName = bizName;
            session.setActive(true);
            session.getController().getTransportControls().prepare();
        }
    }

    public void playFirst(String bizName, Bundle extras) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            this.mActiveBizName = bizName;
            session.setExtras(extras);
            session.getController().getTransportControls().play();
            MediaHelper.playSpeechP2Start();
        }
    }

    public void playFromMediaId(String bizName, Bundle extras) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            if (DEBUG) {
                Log.d(TAG, "playFromMediaId: " + bizName + " -- " + session.isActive());
            }
            this.mActiveBizName = bizName;
            session.getController().getTransportControls().playFromMediaId(extras.getString(MediaParams.KEY_DATA_ID), extras);
            MediaHelper.playSpeechP2Start();
        }
    }

    public void pause(String bizName, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            session.setExtras(bundle);
            session.getController().getTransportControls().pause();
        }
    }

    public void resume(String bizName) {
        MediaSessionCompat session;
        PlaybackStateCompat state;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null && (state = session.getController().getPlaybackState()) != null) {
            if (state.getState() == 2 || MiniPlayerView.getInstance().isPrepared()) {
                session.getController().getTransportControls().play();
            }
        }
    }

    public void stop(String bizName, boolean notifyUI, int reason, boolean deactivateSession) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            Bundle extras = new Bundle();
            extras.putBoolean(MediaParams.KEY_NOTIFY_UI, notifyUI);
            extras.putInt(MediaParams.KEY_STOP_REASON, reason);
            extras.putBoolean(MediaParams.KEY_DEACTIVATE_SESSION, deactivateSession);
            setSessionExtrasLocked(session, extras);
            session.getController().getTransportControls().stop();
        }
    }

    public void skipToPrevious(String bizName, Bundle extras) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null && session.isActive()) {
            setSessionExtrasLocked(session, extras);
            session.getController().getTransportControls().skipToPrevious();
            MediaHelper.playSpeechP2Start();
        }
    }

    public void skipToNext(String bizName, Bundle extras) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null && session.isActive()) {
            setSessionExtrasLocked(session, extras);
            session.getController().getTransportControls().skipToNext();
            MediaHelper.playSpeechP2Start();
        }
    }

    public void skipToTempData(String bizName, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            session.setExtras(bundle);
            sendCustomEventLocked(session, MediaActions.ACTION_PLAY_MOCKFEED, bundle);
        }
    }

    public void deleteData(String bizName, Bundle bundle, MediaMetadataCompat metadataCompat) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            MediaActions mediaActions = new MediaActions(bundle);
            mediaActions.putMetadata(metadataCompat);
            sendCustomEventLocked(session, MediaActions.ACTION_DELETE_SKIPTO, mediaActions.getActionData());
        }
    }

    public void refreshData(String bizName, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            bundle.putString(MediaParams.KEY_BIZ_NAME, bizName);
            setSessionExtrasLocked(session, bundle);
            sendCustomEventLocked(session, MediaActions.ACTION_REFRESH, bundle);
        }
    }

    public MediaSessionCompat getSession(String bizName) {
        if (TextUtils.isEmpty(bizName)) {
            return null;
        }
        return this.mMediaSessions.get(bizName);
    }

    private MediaSessionCompat getActiveSession() {
        return getSession(this.mActiveBizName);
    }

    public String getActiveBizName() {
        return this.mActiveBizName;
    }

    public PlaybackManager getPlaybackManager(String bizName) {
        if (TextUtils.isEmpty(bizName)) {
            return null;
        }
        return this.mPlaybackManagers.get(bizName);
    }

    public boolean isPause() {
        PlaybackManager pb;
        if (getActiveSession() == null || (pb = this.mPlaybackManagers.get(getActiveBizName())) == null || pb.getPlayback().getState() != 2) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        PlaybackManager pb;
        if (getActiveSession() == null || (pb = this.mPlaybackManagers.get(getActiveBizName())) == null || pb.getPlayback().getState() != 3) {
            return false;
        }
        return true;
    }

    private void setSessionExtrasLocked(MediaSessionCompat session, Bundle bundle) {
        synchronized (this) {
            session.setExtras(bundle);
        }
    }

    public void seekTo(String bizName, long progress, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            bundle.putString(MediaParams.KEY_BIZ_NAME, bizName);
            session.setExtras(bundle);
            session.getController().getTransportControls().seekTo(progress);
        }
    }

    public void changeCustomAttrs(String bizName, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            bundle.putString(MediaParams.KEY_BIZ_NAME, bizName);
            session.setExtras(bundle);
            sendCustomEventLocked(session, MediaActions.ACTION_CHANGE_PLAYER_ATTRS, bundle);
        }
    }

    public void doCustomActions(String bizName, Bundle bundle) {
        MediaSessionCompat session;
        if (!TextUtils.isEmpty(bizName) && (session = this.mMediaSessions.get(bizName)) != null) {
            bundle.putString(MediaParams.KEY_BIZ_NAME, bizName);
            session.setExtras(bundle);
            sendCustomEventLocked(session, MediaActions.ACTION_PLAYER_CUSTOMER, bundle);
        }
    }

    public void lightRelease(String bizName) {
        if (!TextUtils.isEmpty(bizName)) {
            if (DEBUG) {
                Log.d(TAG, bizName + " -- lightRelease");
            }
            PlaybackManager playbackManager = this.mPlaybackManagers.remove(bizName);
            if (playbackManager != null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaParams.KEY_DATA_ID, createNidPosJson(playbackManager.getCurrentMediaId()));
                this.mControllerCallbacks.get(bizName).onPlaybackStateChanged(new PlaybackStateCompat.Builder().setState(2, 1, (float) SystemClock.elapsedRealtime()).setExtras(bundle).build());
                playbackManager.getPlayback().pause();
                playbackManager.releaseResources(false);
            }
            MediaSessionCompat mediaSession = this.mMediaSessions.get(bizName);
            if (mediaSession != null) {
                mediaSession.setActive(false);
                mediaSession.getController().unregisterCallback(this.mControllerCallbacks.get(bizName));
                mediaSession.setCallback((MediaSessionCompat.Callback) null);
            }
            if (TextUtils.equals(this.mActiveBizName, bizName)) {
                this.mActiveBizName = null;
            }
        }
    }

    private String createNidPosJson(String nid) {
        JSONObject json = new JSONObject();
        try {
            json.put("nid", nid);
            json.put("pos", -1);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return json.toString();
    }

    public void release(String bizName) {
        if (!TextUtils.isEmpty(bizName)) {
            if (DEBUG) {
                Log.d(TAG, bizName + " --release");
            }
            MediaSessionCompat mediaSession = this.mMediaSessions.get(bizName);
            if (mediaSession != null) {
                mediaSession.setActive(false);
                MediaControllerCallBack callback = this.mControllerCallbacks.remove(bizName);
                if (callback != null) {
                    callback.release();
                    mediaSession.getController().unregisterCallback(callback);
                }
                PlaybackManager playbackManager = this.mPlaybackManagers.remove(bizName);
                if (playbackManager != null) {
                    playbackManager.releaseResources(this.mPlaybackManagers.isEmpty());
                }
                mediaSession.setCallback((MediaSessionCompat.Callback) null);
                mediaSession.release();
                this.mMediaSessions.remove(bizName);
            }
            if (TextUtils.equals(this.mActiveBizName, bizName)) {
                this.mActiveBizName = null;
            }
        }
    }

    private void sendCustomEventLocked(MediaSessionCompat session, String action, Bundle params) {
        synchronized (this) {
            if (session != null) {
                session.getController().getTransportControls().sendCustomAction(action, params);
            }
        }
    }
}
