package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaControllerCompatApi24;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import com.baidu.android.common.others.IStringUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    public static final String TAG = "MediaControllerCompat";
    public final MediaControllerImpl mImpl;
    public final HashSet<Callback> mRegisteredCallbacks = new HashSet<>();
    public final MediaSessionCompat.Token mToken;

    public static abstract class Callback implements IBinder.DeathRecipient {
        public final Object mCallbackObj;
        public MessageHandler mHandler;
        public IMediaControllerCallback mIControllerCallback;

        public class MessageHandler extends Handler {
            public static final int MSG_DESTROYED = 8;
            public static final int MSG_EVENT = 1;
            public static final int MSG_SESSION_READY = 13;
            public static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            public static final int MSG_UPDATE_EXTRAS = 7;
            public static final int MSG_UPDATE_METADATA = 3;
            public static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            public static final int MSG_UPDATE_QUEUE = 5;
            public static final int MSG_UPDATE_QUEUE_TITLE = 6;
            public static final int MSG_UPDATE_REPEAT_MODE = 9;
            public static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            public static final int MSG_UPDATE_VOLUME = 4;
            public boolean mRegistered = false;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.mRegistered) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.ensureClassLoader(data);
                            Callback.this.onSessionEvent((String) message.obj, data);
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.ensureClassLoader(bundle);
                            Callback.this.onExtrasChanged(bundle);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            Callback.this.onSessionReady();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public static class StubApi21 implements MediaControllerCompatApi21.Callback {
            public final WeakReference<Callback> mCallback;

            public StubApi21(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            public void onAudioInfoChanged(int i2, int i3, int i4, int i5, int i6) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(i2, i3, i4, i5, i6));
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            public void onMetadataChanged(Object obj) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null && callback.mIControllerCallback == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            public void onQueueChanged(List<?> list) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            public void onSessionDestroyed() {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback == null) {
                    return;
                }
                if (callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                    callback.onSessionEvent(str, bundle);
                }
            }
        }

        public static class StubCompat extends IMediaControllerCallback.Stub {
            public final WeakReference<Callback> mCallback;

            public StubCompat(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(1, str, bundle);
                }
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(7, bundle, (Bundle) null);
                }
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(5, list, (Bundle) null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(6, charSequence, (Bundle) null);
                }
            }

            public void onRepeatModeChanged(int i2) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(9, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(8, (Object) null, (Bundle) null);
                }
            }

            public void onSessionReady() throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(13, (Object) null, (Bundle) null);
                }
            }

            public void onShuffleModeChanged(int i2) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(12, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, (Bundle) null);
                }
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
                return;
            }
            StubCompat stubCompat = new StubCompat(this);
            this.mIControllerCallback = stubCompat;
            this.mCallbackObj = stubCompat;
        }

        public void binderDied() {
            postToHandler(8, (Object) null, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i2) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i2) {
        }

        public void postToHandler(int i2, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.mHandler;
            if (messageHandler != null) {
                Message obtainMessage = messageHandler.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void setHandler(Handler handler) {
            if (handler == null) {
                MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    messageHandler.mRegistered = false;
                    messageHandler.removeCallbacksAndMessages((Object) null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            MessageHandler messageHandler2 = new MessageHandler(handler.getLooper());
            this.mHandler = messageHandler2;
            messageHandler2.mRegistered = true;
        }
    }

    public static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        public final MediaControllerCompat mMediaController;

        public MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            this.mMediaController = mediaControllerCompat;
        }

        public MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2);

        void adjustVolume(int i2, int i3);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i2, int i3);

        void unregisterCallback(Callback callback);
    }

    @RequiresApi(23)
    public static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi23(transportControls);
            }
            return null;
        }
    }

    @RequiresApi(24)
    public static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi24(transportControls);
            }
            return null;
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        public final int mAudioStream;
        public final int mCurrentVolume;
        public final int mMaxVolume;
        public final int mPlaybackType;
        public final int mVolumeControl;

        public PlaybackInfo(int i2, int i3, int i4, int i5, int i6) {
            this.mPlaybackType = i2;
            this.mAudioStream = i3;
            this.mVolumeControl = i4;
            this.mMaxVolume = i5;
            this.mCurrentVolume = i6;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i2);

        public abstract void setShuffleMode(int i2);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    @RequiresApi(23)
    public static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
        }
    }

    @RequiresApi(24)
    public static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object obj) {
            super(obj);
        }

        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
        }
    }

    public static class TransportControlsBase extends TransportControls {
        public IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (RemoteException unused) {
            }
        }

        public void pause() {
            try {
                this.mBinder.pause();
            } catch (RemoteException unused) {
            }
        }

        public void play() {
            try {
                this.mBinder.play();
            } catch (RemoteException unused) {
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.playFromMediaId(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.playFromSearch(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.playFromUri(uri, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void prepare() {
            try {
                this.mBinder.prepare();
            } catch (RemoteException unused) {
            }
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromMediaId(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromSearch(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.prepareFromUri(uri, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (RemoteException unused) {
            }
        }

        public void seekTo(long j) {
            try {
                this.mBinder.seekTo(j);
            } catch (RemoteException unused) {
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void setCaptioningEnabled(boolean z) {
            try {
                this.mBinder.setCaptioningEnabled(z);
            } catch (RemoteException unused) {
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.mBinder.rate(ratingCompat);
            } catch (RemoteException unused) {
            }
        }

        public void setRepeatMode(int i2) {
            try {
                this.mBinder.setRepeatMode(i2);
            } catch (RemoteException unused) {
            }
        }

        public void setShuffleMode(int i2) {
            try {
                this.mBinder.setShuffleMode(i2);
            } catch (RemoteException unused) {
            }
        }

        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (RemoteException unused) {
            }
        }

        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (RemoteException unused) {
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.mBinder.skipToQueueItem(j);
            } catch (RemoteException unused) {
            }
        }

        public void stop() {
            try {
                this.mBinder.stop();
            } catch (RemoteException unused) {
            }
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(str, bundle);
            try {
                this.mBinder.sendCustomAction(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.mBinder.rateWithExtras(ratingCompat, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        MediaControllerImpl mediaControllerImplApi21;
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.mToken = sessionToken;
            MediaControllerImplBase mediaControllerImplBase = null;
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    mediaControllerImplApi21 = new MediaControllerImplApi24(context, sessionToken);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    mediaControllerImplApi21 = new MediaControllerImplApi23(context, sessionToken);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    mediaControllerImplApi21 = new MediaControllerImplApi21(context, sessionToken);
                } else {
                    mediaControllerImplBase = new MediaControllerImplBase(sessionToken);
                    this.mImpl = mediaControllerImplBase;
                    return;
                }
                mediaControllerImplBase = mediaControllerImplApi21;
            } catch (RemoteException unused) {
            }
            this.mImpl = mediaControllerImplBase;
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        Object mediaController;
        if (activity instanceof ComponentActivity) {
            MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData) ((ComponentActivity) activity).getExtraData(MediaControllerExtraData.class);
            if (mediaControllerExtraData != null) {
                return mediaControllerExtraData.getMediaController();
            }
            return null;
        } else if (Build.VERSION.SDK_INT < 21 || (mediaController = MediaControllerCompatApi21.getMediaController(activity)) == null) {
            return null;
        } else {
            try {
                return new MediaControllerCompat((Context) activity, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(mediaController)));
            } catch (RemoteException unused) {
                return null;
            }
        }
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (mediaControllerCompat != null) {
                obj = MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.setMediaController(activity, obj);
        }
    }

    public static void validateCustomAction(String str, Bundle bundle) {
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1348483723) {
                if (hashCode == 503011406 && str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                    c = 1;
                }
            } else if (str.equals(MediaSessionCompat.ACTION_FOLLOW)) {
                c = 0;
            }
            if (c != 0 && c != 1) {
                return;
            }
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + IStringUtil.CURRENT_PATH);
            }
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public void adjustVolume(int i2, int i3) {
        this.mImpl.adjustVolume(i2, i3);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public void registerCallback(@NonNull Callback callback) {
        registerCallback(callback, (Handler) null);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public void removeQueueItemAt(int i2) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && i2 >= 0 && i2 < queue.size() && (queueItem = queue.get(i2)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public void sendCommand(@NonNull String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendCommand(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int i2, int i3) {
        this.mImpl.setVolumeTo(i2, i3);
    }

    public void unregisterCallback(@NonNull Callback callback) {
        if (callback != null) {
            try {
                this.mRegisteredCallbacks.remove(callback);
                this.mImpl.unregisterCallback(callback);
            } finally {
                callback.setHandler((Handler) null);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, i2);
    }

    public void registerCallback(@NonNull Callback callback, Handler handler) {
        if (callback != null) {
            if (handler == null) {
                handler = new Handler();
            }
            callback.setHandler(handler);
            this.mImpl.registerCallback(callback, handler);
            this.mRegisteredCallbacks.add(callback);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public static class MediaControllerImplBase implements MediaControllerImpl {
        public IMediaSession mBinder;
        public TransportControls mTransportControls;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.addQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException unused) {
            }
        }

        public void adjustVolume(int i2, int i3) {
            try {
                this.mBinder.adjustVolume(i2, i3, (String) null);
            } catch (RemoteException unused) {
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.mBinder.sendMediaButton(keyEvent);
                    return false;
                } catch (RemoteException unused) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }

        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException unused) {
                return 0;
            }
        }

        public Object getMediaController() {
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException unused) {
                return null;
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException unused) {
                return 0;
            }
        }

        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException unused) {
                return null;
            }
        }

        public int getShuffleMode() {
            try {
                return this.mBinder.getShuffleMode();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        public boolean isCaptioningEnabled() {
            try {
                return this.mBinder.isCaptioningEnabled();
            } catch (RemoteException unused) {
                return false;
            }
        }

        public boolean isSessionReady() {
            return true;
        }

        public void registerCallback(Callback callback, Handler handler) {
            if (callback != null) {
                try {
                    this.mBinder.asBinder().linkToDeath(callback, 0);
                    this.mBinder.registerCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                    callback.postToHandler(13, (Object) null, (Bundle) null);
                } catch (RemoteException unused) {
                    callback.postToHandler(8, (Object) null, (Bundle) null);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.removeQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException unused) {
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.mBinder.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException unused) {
            }
        }

        public void setVolumeTo(int i2, int i3) {
            try {
                this.mBinder.setVolumeTo(i2, i3, (String) null);
            } catch (RemoteException unused) {
            }
        }

        public void unregisterCallback(Callback callback) {
            if (callback != null) {
                try {
                    this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                    this.mBinder.asBinder().unlinkToDeath(callback, 0);
                } catch (RemoteException unused) {
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.addQueueItemAt(mediaDescriptionCompat, i2);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException unused) {
            }
        }
    }

    public static class TransportControlsApi21 extends TransportControls {
        public final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            this.mControlsObj = obj;
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
        }

        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
        }

        public void setCaptioningEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
        }

        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void setRepeatMode(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i2);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
        }

        public void setShuffleMode(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i2);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(str, bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
        }
    }

    @RequiresApi(21)
    public static class MediaControllerImplApi21 implements MediaControllerImpl {
        public HashMap<Callback, ExtraCallback> mCallbackMap = new HashMap<>();
        public final Object mControllerObj;
        public final Object mLock = new Object();
        @GuardedBy("mLock")
        public final List<Callback> mPendingCallbacks = new ArrayList();
        public final MediaSessionCompat.Token mSessionToken;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            public WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.mMediaControllerImpl = new WeakReference<>(mediaControllerImplApi21);
            }

            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.mMediaControllerImpl.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.mLock) {
                        mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                        mediaControllerImplApi21.mSessionToken.setSessionToken2Bundle(bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));
                        mediaControllerImplApi21.processPendingCallbacksLocked();
                    }
                }
            }
        }

        public static class ExtraCallback extends Callback.StubCompat {
            public ExtraCallback(Callback callback) {
                super(callback);
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.mSessionToken = token;
            Object fromToken = MediaControllerCompatApi21.fromToken(context, token.getToken());
            this.mControllerObj = fromToken;
            if (fromToken == null) {
                throw new RemoteException();
            } else if (this.mSessionToken.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void adjustVolume(int i2, int i3) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i2, i3);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (playbackInfo != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
            }
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getPlaybackState();
                } catch (RemoteException unused) {
                }
            }
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (queue != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            return null;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public int getRatingType() {
            if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRatingType();
                } catch (RemoteException unused) {
                }
            }
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getRepeatMode();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getShuffleMode();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi21(transportControls);
            }
            return null;
        }

        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return false;
            }
            try {
                return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
            } catch (RemoteException unused) {
                return false;
            }
        }

        public boolean isSessionReady() {
            return this.mSessionToken.getExtraBinder() != null;
        }

        @GuardedBy("mLock")
        public void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) {
                for (Callback next : this.mPendingCallbacks) {
                    ExtraCallback extraCallback = new ExtraCallback(next);
                    this.mCallbackMap.put(next, extraCallback);
                    next.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        next.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException unused) {
                    }
                }
                this.mPendingCallbacks.clear();
            }
        }

        public final void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    ExtraCallback extraCallback = new ExtraCallback(callback);
                    this.mCallbackMap.put(callback, extraCallback);
                    callback.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        callback.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException unused) {
                    }
                } else {
                    callback.mIControllerCallback = null;
                    this.mPendingCallbacks.add(callback);
                }
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
        }

        public void setVolumeTo(int i2, int i3) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i2, i3);
        }

        public final void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        ExtraCallback remove = this.mCallbackMap.remove(callback);
                        if (remove != null) {
                            callback.mIControllerCallback = null;
                            this.mSessionToken.getExtraBinder().unregisterCallbackListener(remove);
                        }
                    } catch (RemoteException unused) {
                    }
                } else {
                    this.mPendingCallbacks.remove(callback);
                }
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i2);
                sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) throws RemoteException {
        if (token != null) {
            this.mToken = token;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                this.mImpl = new MediaControllerImplApi24(context, token);
            } else if (i2 >= 23) {
                this.mImpl = new MediaControllerImplApi23(context, token);
            } else if (i2 >= 21) {
                this.mImpl = new MediaControllerImplApi21(context, token);
            } else {
                this.mImpl = new MediaControllerImplBase(token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }
}
