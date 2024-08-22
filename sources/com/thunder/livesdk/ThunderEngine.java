package com.thunder.livesdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.thunder.livesdk.ThunderEventHandler;
import com.thunder.livesdk.ThunderNotification;
import com.thunder.livesdk.ThunderRtcConstant;
import com.thunder.livesdk.audio.IAudioEncodedFrameObserver;
import com.thunder.livesdk.audio.IAudioFrameObserver;
import com.thunder.livesdk.helper.ThunderHttpsRequestHandler;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.helper.ThunderSoLoader;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.system.ThunderForeBackgroundListener;
import com.thunder.livesdk.system.ThunderNetStateService;
import com.thunder.livesdk.video.ICameraEncodedFrameObserver;
import com.thunder.livesdk.video.IVideoCaptureFrameObserver;
import com.thunder.livesdk.video.IVideoCaptureObserver;
import com.thunder.livesdk.video.IVideoDecodeObserver;
import com.thunder.livesdk.video.IVideoEncodedFrameObserver;
import com.thunder.livesdk.video.ThunderVideoCaptureObserver;
import com.thunder.livesdk.video.ThunderVideoPublishEngineImp;
import com.thunder.livesdk.video.VideoFrameTextrue;
import com.thunder.livesdk.video.VideoFrameYuvCapture;
import com.thunder.livesdk.video.VideoTextureFrameObserver;
import com.yy.mediaframework.model.Rect;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentSkipListSet;

public class ThunderEngine {
    private static HashSet<String> mAppidSet = new HashSet<>();
    private static TimerTask mDestroyTask = null;
    private static Timer mDestroyTimer = null;
    private static ThunderForeBackgroundListener mForeBackgroundListener = null;
    private static NotificationHandler mHandler = null;
    /* access modifiers changed from: private */
    public static ThunderHttpsRequestHandler mHttpsRequestHandler;
    private static boolean mIsInited = false;
    private static volatile boolean mIsLoadLibrarySuccess = false;
    private static IThunderLogCallback mLogCallback = null;
    private static String mLogDir = null;
    private static ThunderNative.NotificationDispatcher mNotificationDispatcher = null;
    private static ThunderPublisher mPublisher = null;
    /* access modifiers changed from: private */
    public static ThunderEventHandler mRtcEventHandler;
    /* access modifiers changed from: private */
    public static IThunderAudioEchoTestHandler mThunderAudioEchoTestHandler = null;
    /* access modifiers changed from: private */
    public static IThunderMediaExtraInfoCallback mThunderMediaExtraInfoCallback = null;
    private static volatile long m_appId = 0;
    /* access modifiers changed from: private */
    public static int s_audioPlaySpectrumCount = 0;
    /* access modifiers changed from: private */
    public static int s_captureVolumeNotifyCount = 0;
    /* access modifiers changed from: private */
    public static int s_playDataNotifyCount = 0;
    /* access modifiers changed from: private */
    public static int s_playVolumeNotifyCount = 0;
    private Set<ThunderAudioFilePlayer> mAudioFilePlayerSet;
    private ExternalVideoSource mExternalVideoSource;
    private ThunderEngineConfig mLastEngineConfig;
    /* access modifiers changed from: private */
    public ThunderNetStateService mNetStateService;

    static /* synthetic */ int access$104() {
        int i2 = s_captureVolumeNotifyCount + 1;
        s_captureVolumeNotifyCount = i2;
        return i2;
    }

    static /* synthetic */ int access$204() {
        int i2 = s_playVolumeNotifyCount + 1;
        s_playVolumeNotifyCount = i2;
        return i2;
    }

    static /* synthetic */ int access$304() {
        int i2 = s_playDataNotifyCount + 1;
        s_playDataNotifyCount = i2;
        return i2;
    }

    static /* synthetic */ int access$404() {
        int i2 = s_audioPlaySpectrumCount + 1;
        s_audioPlaySpectrumCount = i2;
        return i2;
    }

    private static class NotificationHandler extends Handler {
        private static final String TAG = "ThunderNotification";
        private final WeakReference<ThunderEngine> mThunderEngine;

        public NotificationHandler(ThunderEngine rtc) {
            this.mThunderEngine = new WeakReference<>(rtc);
        }

        public NotificationHandler(ThunderEngine rtc, Looper loop) {
            super(loop);
            this.mThunderEngine = new WeakReference<>(rtc);
        }

        public void handleMessage(Message msg) {
            Message message = msg;
            if (((ThunderEngine) this.mThunderEngine.get()) == null || ThunderEngine.mRtcEventHandler == null) {
                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "thunderEngine or handler is null");
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        ThunderNotification.ThunderFirstVideoFrameSend notify = (ThunderNotification.ThunderFirstVideoFrameSend) message.obj;
                        ThunderEngine.mRtcEventHandler.onFirstLocalVideoFrameSent(notify.getElapsedTime());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.FirstVideoFrameSend elapsedTime %d", Integer.valueOf(notify.getElapsedTime()));
                        return;
                    case 1:
                        ThunderNotification.ThunderFirstAudioFrameSend notify2 = (ThunderNotification.ThunderFirstAudioFrameSend) message.obj;
                        ThunderEngine.mRtcEventHandler.onFirstLocalAudioFrameSent(notify2.getElapsedTime());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.FirstAudioFrameSend elapsedTime %d", Integer.valueOf(notify2.getElapsedTime()));
                        return;
                    case 2:
                        ThunderNotification.ThunderJoinRoomSuccess notify3 = (ThunderNotification.ThunderJoinRoomSuccess) message.obj;
                        ThunderEngine.mRtcEventHandler.onJoinRoomSuccess(notify3.getmRoomName(), notify3.getmUid(), notify3.getmElapsedTime());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.JoinRoomSucces room %s, uid %s,elapsedTime %d", notify3.getmRoomName(), notify3.getmUid(), Integer.valueOf(notify3.getmElapsedTime()));
                        return;
                    case 3:
                        ThunderNotification.ThunderLeaveRoom thunderLeaveRoom = (ThunderNotification.ThunderLeaveRoom) message.obj;
                        ThunderEventHandler.RoomStats roomStats = new ThunderEventHandler.RoomStats();
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LeaveRoom");
                        ThunderEngine.mRtcEventHandler.onLeaveRoom(roomStats);
                        return;
                    case 4:
                        ThunderNotification.ThunderRemoteVideoPlay notify4 = (ThunderNotification.ThunderRemoteVideoPlay) message.obj;
                        ThunderEngine.mRtcEventHandler.onRemoteVideoPlay(notify4.getmUid(), notify4.getmWith(), notify4.getmHeigh(), notify4.getmElapsedTime());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteVideoPlay uid %s, with %d, heigh %d, elapsedTime %d", notify4.getmUid(), Integer.valueOf(notify4.getmWith()), Integer.valueOf(notify4.getmHeigh()), Integer.valueOf(notify4.getmElapsedTime()));
                        return;
                    case 5:
                        ThunderNotification.ThunderBizAuthStreamRes notify5 = (ThunderNotification.ThunderBizAuthStreamRes) message.obj;
                        ThunderEngine.mRtcEventHandler.onBizAuthResult(notify5.isbPublish(), notify5.getmResult());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.BizAuthRes bPublish %b, result %d", Boolean.valueOf(notify5.isbPublish()), Integer.valueOf(notify5.getmResult()));
                        ThunderEngine.mRtcEventHandler.onBizAuthStreamResult(notify5.isbPublish(), notify5.getmStreamType(), notify5.getmResult());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.BizAuthStreamRes bPublish %b, type %d, result %d", Boolean.valueOf(notify5.isbPublish()), Integer.valueOf(notify5.getmStreamType()), Integer.valueOf(notify5.getmResult()));
                        return;
                    case 6:
                        ThunderNotification.ThunderSdkAuthRes notify6 = (ThunderNotification.ThunderSdkAuthRes) message.obj;
                        ThunderEngine.mRtcEventHandler.onSdkAuthResult(notify6.getmResult());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.SdkAuthRes result %d", Integer.valueOf(notify6.getmResult()));
                        return;
                    case 7:
                        ThunderNotification.ThunderUserBanned notify7 = (ThunderNotification.ThunderUserBanned) message.obj;
                        ThunderEngine.mRtcEventHandler.onUserBanned(notify7.isbBanned());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.UserBanned bBanned %b", Boolean.valueOf(notify7.isbBanned()));
                        return;
                    case 8:
                        ThunderNotification.ThunderTokenRequest thunderTokenRequest = (ThunderNotification.ThunderTokenRequest) message.obj;
                        ThunderEngine.mRtcEventHandler.onTokenRequested();
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.TokenRequest");
                        return;
                    case 9:
                        ThunderNotification.ThunderTokenWillExpire notify8 = (ThunderNotification.ThunderTokenWillExpire) message.obj;
                        ThunderEngine.mRtcEventHandler.onTokenWillExpire(notify8.getToken().getBytes());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.TokenWillExpire %s", notify8.getToken());
                        return;
                    case 10:
                        ThunderNotification.ThunderAudioCaptureVolume notify9 = (ThunderNotification.ThunderAudioCaptureVolume) message.obj;
                        ThunderEngine.mRtcEventHandler.onCaptureVolumeIndication(notify9.getmVolume(), notify9.getmCpt(), notify9.getmMicVolume());
                        if (ThunderEngine.s_captureVolumeNotifyCount % 200 == 0) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioCaptureVolume totalVolume %d, cpt %d, micVolume %d", Integer.valueOf(notify9.getmVolume()), Integer.valueOf(notify9.getmCpt()), Integer.valueOf(notify9.getmMicVolume()));
                        }
                        ThunderEngine.access$104();
                        return;
                    case 11:
                        ThunderNotification.ThunderAudioPlayVolume notify10 = (ThunderNotification.ThunderAudioPlayVolume) message.obj;
                        HashSet<ThunderEventHandler.AudioVolumeInfo> audioPlayVolumes = notify10.getVolumes();
                        if (audioPlayVolumes != null) {
                            if (!audioPlayVolumes.isEmpty()) {
                                ThunderEngine.mRtcEventHandler.onPlayVolumeIndication((ThunderEventHandler.AudioVolumeInfo[]) audioPlayVolumes.toArray(new ThunderEventHandler.AudioVolumeInfo[audioPlayVolumes.size()]), notify10.getTotalVolume());
                                if (ThunderEngine.s_playVolumeNotifyCount % 200 == 0) {
                                    ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioPlayVolume size %d totalVolume %d", Integer.valueOf(notify10.getVolumes().size()), Integer.valueOf(notify10.getTotalVolume()));
                                }
                                ThunderEngine.access$204();
                                return;
                            }
                        }
                        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioPlayVolume size %d totalVolume %d", 0, Integer.valueOf(notify10.getTotalVolume()));
                        return;
                    case 12:
                        ThunderNotification.ThunderAudioPlayData notify11 = (ThunderNotification.ThunderAudioPlayData) message.obj;
                        ThunderEngine.mRtcEventHandler.onAudioPlayData(notify11.getData(), (long) notify11.getCpt(), (long) notify11.getPts(), notify11.getUid(), 0);
                        if (ThunderEngine.s_playDataNotifyCount % 500 == 0) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioPlayData cpt %d, pts %d, uid %s, duration %d", Integer.valueOf(notify11.getCpt()), Integer.valueOf(notify11.getPts()), notify11.getUid(), 0);
                        }
                        ThunderEngine.access$304();
                        return;
                    case 13:
                        ThunderEngine.mRtcEventHandler.onAudioPlaySpectrumData(((ThunderNotification.ThunderAudioPlaySpectrumData) message.obj).getData());
                        if (ThunderEngine.s_audioPlaySpectrumCount % 500 == 0) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioPlaySpectrumData");
                        }
                        ThunderEngine.access$404();
                        return;
                    case 15:
                        ThunderNotification.ThunderUserAppMsgData notify12 = (ThunderNotification.ThunderUserAppMsgData) message.obj;
                        ThunderEngine.mRtcEventHandler.onRecvUserAppMsgData(notify12.getMsgData().getBytes(), notify12.getUid());
                        return;
                    case 16:
                        ThunderNotification.ThunderAppMsgDataFailStatus notify13 = (ThunderNotification.ThunderAppMsgDataFailStatus) message.obj;
                        ThunderEngine.mRtcEventHandler.onSendAppMsgDataFailedStatus(notify13.getStatus());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AppMsgDataFailStatus status %d", Integer.valueOf(notify13.getStatus()));
                        return;
                    case 18:
                        ThunderNotification.ThunderHttpsRequest notify14 = (ThunderNotification.ThunderHttpsRequest) message.obj;
                        if (ThunderEngine.mHttpsRequestHandler != null) {
                            if (1 == notify14.getTarget()) {
                                ThunderEngine.mHttpsRequestHandler.send(notify14.getUrl(), notify14.getTarget());
                            } else {
                                ThunderEngine.mHttpsRequestHandler.sendSync(notify14.getUrl(), notify14.getTarget(), notify14.getMethod(), notify14.getBody(), notify14.getHeader());
                            }
                        }
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.HttpsRequest, url %s, target %d", notify14.getUrl(), Integer.valueOf(notify14.getTarget()));
                        return;
                    case 19:
                        ThunderNotification.ThunderRemoteVideoStopped notify15 = (ThunderNotification.ThunderRemoteVideoStopped) message.obj;
                        ThunderEngine.mRtcEventHandler.onRemoteVideoArrived(notify15.getRoomId(), notify15.getUid(), !notify15.isbStop());
                        Object[] objArr = new Object[3];
                        objArr[0] = notify15.getRoomId();
                        objArr[1] = notify15.getUid();
                        objArr[2] = Boolean.valueOf(!notify15.isbStop());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteVideoArrived roomId %s, uid %s, arrive %b", objArr);
                        return;
                    case 20:
                        ThunderNotification.ThunderRemoteAudioStopped notify16 = (ThunderNotification.ThunderRemoteAudioStopped) message.obj;
                        ThunderEngine.mRtcEventHandler.onRemoteAudioArrived(notify16.getRoomId(), notify16.getUid(), !notify16.isbStop());
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = notify16.getRoomId();
                        objArr2[1] = notify16.getUid();
                        objArr2[2] = Boolean.valueOf(!notify16.isbStop());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteAudioArrived roomId %s, uid %s, arrive %b", objArr2);
                        return;
                    case 21:
                        ThunderNotification.ThunderVideoSizeChange notify17 = (ThunderNotification.ThunderVideoSizeChange) message.obj;
                        ThunderEngine.mRtcEventHandler.onVideoSizeChanged(notify17.getUid(), notify17.getWidth(), notify17.getHeight(), 0);
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.VideoSizeChange uid %s, w %d, h %d", notify17.getUid(), Integer.valueOf(notify17.getWidth()), Integer.valueOf(notify17.getHeight()));
                        return;
                    case 22:
                        ThunderNotification.ThunderConnectionStatus notify18 = (ThunderNotification.ThunderConnectionStatus) message.obj;
                        ThunderEngine.mRtcEventHandler.onConnectionStatus(notify18.getStatus());
                        if (notify18.getStatus() == 1) {
                            SingleonHolder.INSTANCE.mNetStateService.checkNetInfo();
                            return;
                        }
                        return;
                    case 23:
                        ThunderNotification.ThunderConnectionLost thunderConnectionLost = (ThunderNotification.ThunderConnectionLost) message.obj;
                        ThunderEngine.mRtcEventHandler.onConnectionLost();
                        return;
                    case 24:
                        ThunderEngine.mRtcEventHandler.onRoomStats((ThunderNotification.RoomStats) message.obj);
                        return;
                    case 25:
                        ThunderNotification.ThunderNetworkStateChange notify19 = (ThunderNotification.ThunderNetworkStateChange) message.obj;
                        ThunderEngine.mRtcEventHandler.onNetworkTypeChanged(notify19.getStatus());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.NetworkStateChange status %d", Integer.valueOf(notify19.getStatus()));
                        return;
                    case 26:
                        ThunderNotification.ThunderPublishStreamToCdnStatus notify20 = (ThunderNotification.ThunderPublishStreamToCdnStatus) message.obj;
                        ThunderEngine.mRtcEventHandler.onPublishStreamToCDNStatus(notify20.getUrl(), notify20.getErrorCode());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.PublishStreamToCdnStatus url %s, errorCode %d", notify20.getUrl(), Integer.valueOf(notify20.getErrorCode()));
                        return;
                    case 27:
                        ThunderNotification.ThunderUserJoined notify21 = (ThunderNotification.ThunderUserJoined) message.obj;
                        ThunderEngine.mRtcEventHandler.onUserJoined(notify21.getUid(), notify21.getUserName(), notify21.getElapsedTime());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.UserJoined uid %s userName %s", notify21.getUid(), notify21.getUserName());
                        return;
                    case 28:
                        ThunderNotification.ThunderUserOffline notify22 = (ThunderNotification.ThunderUserOffline) message.obj;
                        ThunderEngine.mRtcEventHandler.onUserOffline(notify22.getUid(), notify22.getUserName(), notify22.getReason());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.UserOffline uid %s userName %s reason %d", notify22.getUid(), notify22.getUserName(), Integer.valueOf(notify22.getReason()));
                        return;
                    case 29:
                        ThunderNotification.ThunderNetworkQuality notify23 = (ThunderNotification.ThunderNetworkQuality) message.obj;
                        ThunderEngine.mRtcEventHandler.onNetworkQuality(notify23.getUid(), notify23.getTxQuality(), notify23.getRxQuality());
                        return;
                    case 30:
                        ThunderNotification.ThunderAudioExtraInfo notify24 = (ThunderNotification.ThunderAudioExtraInfo) message.obj;
                        if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                            ByteBuffer extraInfo = ByteBuffer.wrap(notify24.getExtraInfo());
                            ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMediaExtraInfo(notify24.getUid(), extraInfo, extraInfo.remaining());
                            return;
                        }
                        return;
                    case 31:
                        ThunderNotification.ThunderAudioExtraFailStatus notify25 = (ThunderNotification.ThunderAudioExtraFailStatus) message.obj;
                        if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                            ThunderEngine.mThunderMediaExtraInfoCallback.onSendMediaExtraInfoFailedStatus(notify25.getStatus());
                        }
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioExtraFailStatus status %d", Integer.valueOf(notify25.getStatus()));
                        return;
                    case 32:
                        if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                            ThunderNotification.ThunderVideoExtraInfo notify26 = (ThunderNotification.ThunderVideoExtraInfo) message.obj;
                            ByteBuffer extraInfo2 = ByteBuffer.wrap(notify26.getExtraInfo());
                            ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMediaExtraInfo(notify26.getUid(), extraInfo2, extraInfo2.remaining());
                            return;
                        }
                        return;
                    case 33:
                        if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                            ThunderNotification.ThunderMixVideoExtraInfo notify27 = (ThunderNotification.ThunderMixVideoExtraInfo) message.obj;
                            ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMixVideoInfo(notify27.getmUid(), notify27.getMixExtraInfos());
                            return;
                        }
                        return;
                    case 34:
                        if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                            ThunderNotification.ThunderMixAudioExtraInfo notify28 = (ThunderNotification.ThunderMixAudioExtraInfo) message.obj;
                            ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMixAudioInfo(notify28.getmUid(), notify28.getMixAudioExtraInfos());
                            return;
                        }
                        return;
                    case 35:
                        ThunderEngine.mRtcEventHandler.onAudioCaptureStatus(((ThunderNotification.ThunderAudioCaptureStatus) message.obj).getStatus());
                        return;
                    case 36:
                        ThunderEngine.mRtcEventHandler.onVideoCaptureStatus(((ThunderNotification.ThunderVideoCaptureStatus) message.obj).getStatus());
                        return;
                    case 37:
                        ThunderNotification.ThunderLocalVideoStats info = (ThunderNotification.ThunderLocalVideoStats) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.LocalVideoStats stats = new ThunderEventHandler.LocalVideoStats();
                            stats.sentBitrate = info.getSendBitrate();
                            stats.sentFrameRate = info.getSendFrameRate();
                            stats.renderOutputFrameRate = info.getRenderOutputFrameRate();
                            stats.targetBitRate = info.getTargetBitrate();
                            stats.targetFrameRate = info.getTargetFrameRate();
                            stats.qualityAdaptIndication = info.getQualityAdaptIndicat();
                            stats.encoderOutputFrameRate = info.getEncodeFrameRate();
                            stats.encodedBitrate = info.getBitrate();
                            stats.encodedFrameWidth = info.getWidth();
                            stats.encodedFrameHeight = info.getHeight();
                            stats.encodedFrameCount = info.getEncodedFrameCount();
                            stats.encodedType = info.getEncodedType();
                            stats.codecType = info.getCodec();
                            stats.configBitRate = info.getConfigBitRate();
                            stats.configFrameRate = info.getConfigFrameRate();
                            stats.configWidth = info.getConfigWidth();
                            stats.configHeight = info.getConfigHeight();
                            ThunderEngine.mRtcEventHandler.onLocalVideoStats(stats);
                            return;
                        }
                        return;
                    case 38:
                        ThunderNotification.RemoteVideoStats info2 = (ThunderNotification.RemoteVideoStats) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.RemoteVideoStats stats2 = new ThunderEventHandler.RemoteVideoStats();
                            stats2.delay = info2.getDelay();
                            stats2.width = info2.getWidth();
                            stats2.height = info2.getHeight();
                            stats2.receivedBitrate = info2.getReceivedBitrate();
                            stats2.decoderOutputFrameRate = info2.getDecoderFrameRate();
                            stats2.rendererOutputFrameRate = info2.getRenderFrameRate();
                            stats2.packetLossRate = info2.getPacketLossRate();
                            stats2.rxStreamType = info2.getRxStreamType();
                            stats2.totalFrozenTime = info2.getFrozenTime();
                            stats2.frozenRate = info2.getFrozenRate();
                            stats2.codecType = info2.getCodecType();
                            stats2.decodedType = info2.getDecodedType();
                            ThunderEngine.mRtcEventHandler.onRemoteVideoStatsOfUid(info2.getUid(), stats2);
                            return;
                        }
                        return;
                    case 39:
                        ThunderNotification.ThunderLocalAudioStats info3 = (ThunderNotification.ThunderLocalAudioStats) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, String.format(Locale.ENGLISH, "ThunderNotification.LocalAudioStats encodedBitrate=%d channels=%d sendSampleRate=%d sendBitRate=%d enableVad=%d", new Object[]{Integer.valueOf(info3.getEncodedBitrate()), Integer.valueOf(info3.getNumChannels()), Integer.valueOf(info3.getSampleRate()), Integer.valueOf(info3.getSendBitRate()), Integer.valueOf(info3.getEnableVad())}));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.LocalAudioStats stats3 = new ThunderEventHandler.LocalAudioStats();
                            stats3.encodedBitrate = info3.getEncodedBitrate();
                            stats3.numChannels = info3.getNumChannels();
                            stats3.sendSampleRate = info3.getSampleRate();
                            stats3.sendBitrate = info3.getSendBitRate();
                            stats3.enableVad = info3.getEnableVad();
                            ThunderEngine.mRtcEventHandler.onLocalAudioStats(stats3);
                            return;
                        }
                        return;
                    case 40:
                        ThunderNotification.RemoteAudioStats info4 = (ThunderNotification.RemoteAudioStats) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.RemoteAudioStats stats4 = new ThunderEventHandler.RemoteAudioStats();
                            stats4.quality = info4.getQuality();
                            stats4.networkTransportDelay = info4.getNetworkTransportDelay();
                            stats4.jitterBufferDelay = info4.getJitterBufferDelay();
                            stats4.totalDelay = info4.getTotalDelay();
                            stats4.frameLossRate = info4.getFrameLossRate();
                            stats4.numChannels = info4.getNumChannels();
                            stats4.receivedSampleRate = info4.getReceivedSampleRate();
                            stats4.receivedBitrate = info4.getReceivedBitrate();
                            stats4.totalFrozenTime = info4.getFrozenTime();
                            stats4.frozenRate = info4.getFrozenRate();
                            ThunderEngine.mRtcEventHandler.onRemoteAudioStatsOfUid(info4.getUid(), stats4);
                            return;
                        }
                        return;
                    case 41:
                        ThunderNotification.ThunderRemoteAudioStateChanged info5 = (ThunderNotification.ThunderRemoteAudioStateChanged) message.obj;
                        if (!(ThunderEngine.mRtcEventHandler == null || info5 == null)) {
                            ThunderEngine.mRtcEventHandler.onRemoteAudioStateChangedOfUid(info5.getUid(), info5.getState(), info5.getReason(), info5.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteAudioStateChanged uid %s, state %d, reason %d, elapsedTime %d", info5.getUid(), Integer.valueOf(info5.getState()), Integer.valueOf(info5.getReason()), Integer.valueOf(info5.getElapsedTime()));
                        }
                        return;
                    case 42:
                        ThunderNotification.ThunderRemoteAudioPlay info6 = (ThunderNotification.ThunderRemoteAudioPlay) message.obj;
                        if (!(ThunderEngine.mRtcEventHandler == null || info6 == null)) {
                            ThunderEngine.mRtcEventHandler.onRemoteAudioPlay(info6.getUid(), info6.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteAudioPlay uid %s, elapsedTime %d", info6.getUid(), Integer.valueOf(info6.getElapsedTime()));
                        }
                        return;
                    case 43:
                        ThunderNotification.ThunderRemoteVideoStateChanged info7 = (ThunderNotification.ThunderRemoteVideoStateChanged) message.obj;
                        if (!(ThunderEngine.mRtcEventHandler == null || info7 == null)) {
                            ThunderEngine.mRtcEventHandler.onRemoteVideoStateChangedOfUid(info7.getUid(), info7.getState(), info7.getReason(), info7.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.RemoteVideoStateChanged uid %s, state %d, reason %d, elapsedTime %d", info7.getUid(), Integer.valueOf(info7.getState()), Integer.valueOf(info7.getReason()), Integer.valueOf(info7.getElapsedTime()));
                        }
                        return;
                    case 44:
                        ThunderNotification.LocalAudioStatusChanged info8 = (ThunderNotification.LocalAudioStatusChanged) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalAudioStatusChanged status=%d errorReason=%d", Integer.valueOf(info8.getLocalAudioStreamStatus()), Integer.valueOf(info8.getLocalAudioStreamErrorReason()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.LocalAudioStatusChanged stats5 = new ThunderEventHandler.LocalAudioStatusChanged();
                            stats5.status = info8.getLocalAudioStreamStatus();
                            stats5.errorReason = info8.getLocalAudioStreamErrorReason();
                            ThunderEngine.mRtcEventHandler.onLocalAudioStatusChanged(stats5.status, stats5.errorReason);
                            return;
                        }
                        return;
                    case 45:
                        ThunderNotification.ThunderDeviceStats info9 = (ThunderNotification.ThunderDeviceStats) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEventHandler.DeviceStats stats6 = new ThunderEventHandler.DeviceStats();
                            stats6.cpuTotalUsage = info9.getCpuTotalUsage();
                            stats6.cpuAppUsage = info9.getCpuAppUsage();
                            stats6.memoryAppUsage = info9.getMemoryAppUsage();
                            stats6.memoryTotalUsage = info9.getMemoryTotalUsage();
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.DeviceStats cpuTotalUsage=%f cpuAppUsage=%f memoryAppUsage=%f memoryTotalUsage=%f", Double.valueOf(stats6.cpuTotalUsage), Double.valueOf(stats6.cpuAppUsage), Double.valueOf(stats6.memoryAppUsage), Double.valueOf(stats6.memoryTotalUsage));
                            ThunderEngine.mRtcEventHandler.onDeviceStats(stats6);
                            return;
                        }
                        return;
                    case 46:
                        ThunderNotification.LocalVideoStatusChanged info10 = (ThunderNotification.LocalVideoStatusChanged) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalVideoStatusChanged status=%d errorReason=%d", Integer.valueOf(info10.getLocalVideoStreamStatus()), Integer.valueOf(info10.getLocalVideoStreamError()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onLocalVideoStatusChanged(info10.getLocalVideoStreamStatus(), info10.getLocalVideoStreamError());
                            return;
                        }
                        return;
                    case 47:
                        ThunderNotification.ThunderAudioRouteChanged info11 = (ThunderNotification.ThunderAudioRouteChanged) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioRouteChanged Routing = %d", Integer.valueOf(info11.getRouting()));
                            ThunderEngine.mRtcEventHandler.onAudioRouteChanged(info11.getRouting());
                            return;
                        }
                        return;
                    case 48:
                        ThunderNotification.ThunderHowlingDetectResult info12 = (ThunderNotification.ThunderHowlingDetectResult) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.HowlingDetectResult value = %b", Boolean.valueOf(info12.getValue()));
                            ThunderEngine.mRtcEventHandler.onHowlingDetectResult(info12.getValue());
                            return;
                        }
                        return;
                    case 49:
                        ThunderNotification.ThunderEchoDetectResult info13 = (ThunderNotification.ThunderEchoDetectResult) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.EchoDetectResult value = %b", Boolean.valueOf(info13.getValue()));
                            ThunderEngine.mRtcEventHandler.onEchoDetectResult(info13.getValue());
                            return;
                        }
                        return;
                    case 50:
                        ThunderNotification.ThunderAudioInputDeviceTestVolume info14 = (ThunderNotification.ThunderAudioInputDeviceTestVolume) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onAudioInputDeviceTestVolume(info14.getVolume());
                            return;
                        }
                        return;
                    case 51:
                        ThunderNotification.ThunderAudioOutputDeviceTestVolume info15 = (ThunderNotification.ThunderAudioOutputDeviceTestVolume) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onAudioOutputDeviceTestVolume(info15.getVolume());
                            return;
                        }
                        return;
                    case 52:
                        ThunderNotification.ThunderVideoCaptureFocusChanged info16 = (ThunderNotification.ThunderVideoCaptureFocusChanged) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.VideoCaptureFocusChanged posX = %d, poxY = %d, w = %d, h = %d", Integer.valueOf(info16.getPosX()), Integer.valueOf(info16.getPosY()), Integer.valueOf(info16.getWidth()), Integer.valueOf(info16.getHeight()));
                            ThunderEngine.mRtcEventHandler.onCameraFocusAreaChanged(new Rect((float) info16.getPosX(), (float) info16.getPosY(), (float) (info16.getPosX() + info16.getWidth()), (float) (info16.getPosY() - info16.getHeight())));
                            return;
                        }
                        return;
                    case 53:
                        ThunderNotification.ThunderVideoCaptureExposureChanged info17 = (ThunderNotification.ThunderVideoCaptureExposureChanged) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.VideoCaptureExposureChanged posX = %d, poxY = %d, w = %d, h = %d", Integer.valueOf(info17.getPosX()), Integer.valueOf(info17.getPosY()), Integer.valueOf(info17.getWidth()), Integer.valueOf(info17.getHeight()));
                            ThunderEngine.mRtcEventHandler.onCameraExposureAreaChanged(new Rect((float) info17.getPosX(), (float) info17.getPosY(), (float) (info17.getPosX() + info17.getWidth()), (float) (info17.getPosY() - info17.getHeight())));
                            return;
                        }
                        return;
                    case 54:
                        ThunderNotification.ThunderPrivateCallBack info18 = (ThunderNotification.ThunderPrivateCallBack) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.PrivateCallBack key:%d jsonStr:%s", Integer.valueOf(info18.getmKey()), info18.getmJsonStr());
                            }
                            ThunderEngine.mRtcEventHandler.onParamsCallback(info18.getmKey(), info18.getmJsonStr());
                            return;
                        }
                        return;
                    case 55:
                        ThunderNotification.ThunderAudioRecordState info19 = (ThunderNotification.ThunderAudioRecordState) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onAudioRecordState(info19.getErrorCode(), info19.getDuration());
                            return;
                        }
                        return;
                    case 56:
                        ThunderNotification.ThunderUserRoleChanged info20 = (ThunderNotification.ThunderUserRoleChanged) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            int oldRole = info20.getOldRole();
                            int newRole = info20.getNewRole();
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.UserRoleChanged oldRole=%d newRole=%d", Integer.valueOf(oldRole), Integer.valueOf(newRole));
                            ThunderEngine.mRtcEventHandler.onUserRoleChanged(oldRole, newRole);
                            return;
                        }
                        return;
                    case 57:
                        ThunderNotification.ThunderLocalSpeakingState info21 = (ThunderNotification.ThunderLocalSpeakingState) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onLocalSpeakingState(info21.getState());
                            return;
                        }
                        return;
                    case 61:
                        ThunderNotification.LocalAudioPublishStatus info22 = (ThunderNotification.LocalAudioPublishStatus) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalAudioPublishStatus status=%d", Integer.valueOf(info22.getLocalAudioPublishStatus()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onLocalAudioPublishStatus(info22.getLocalAudioPublishStatus());
                            return;
                        }
                        return;
                    case 62:
                        ThunderNotification.LocalVideoPublishStatus info23 = (ThunderNotification.LocalVideoPublishStatus) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalVideoPublishStatus %d", Integer.valueOf(info23.getLocalVideoPublishStatus()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onLocalVideoPublishStatus(info23.getLocalVideoPublishStatus());
                            return;
                        }
                        return;
                    case 63:
                        ThunderNotification.ThunderVideoWeakNetChange notify29 = (ThunderNotification.ThunderVideoWeakNetChange) message.obj;
                        ThunderEngine.mRtcEventHandler.onLocalVideoWeaknetConfigChanged(new ThunderEventHandler.ThunderVideoWeaknetConfig(notify29.getIndex(), notify29.getWidth(), notify29.getHeight(), notify29.getFrameRate(), notify29.getBitRate()));
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.VideoWeakNetChange uid %s, index %d, w %d, h %d, fps %d, bitRate %d", notify29.getUid(), Integer.valueOf(notify29.getIndex()), Integer.valueOf(notify29.getWidth()), Integer.valueOf(notify29.getHeight()), Integer.valueOf(notify29.getFrameRate()), Integer.valueOf(notify29.getBitRate()));
                        return;
                    case 64:
                        ThunderNotification.ThunderAudioPlayFileStateChange notify30 = (ThunderNotification.ThunderAudioPlayFileStateChange) message.obj;
                        ThunderEngine.mRtcEventHandler.OnPlayFileStateChange(notify30.getStatusCode());
                        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.FirstAudioFrameSend elapsedTime %d", Integer.valueOf(notify30.getStatusCode()));
                        Log.e(TAG, "java recv kThunderNotification_PlayFileStateChange");
                        return;
                    case 65:
                        ThunderNotification.ThunderMusicDetectResult info24 = (ThunderNotification.ThunderMusicDetectResult) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.MusicDetectResult value = %b", Boolean.valueOf(info24.getValue()));
                            ThunderEngine.mRtcEventHandler.onMusicDetectResult(info24.getValue());
                            return;
                        }
                        return;
                    case 80:
                        ThunderProbeResult result = (ThunderProbeResult) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.onLastmileProbeResult");
                            }
                            ThunderEngine.mRtcEventHandler.onLastmileProbeResult(result);
                            return;
                        }
                        return;
                    case 81:
                        ThunderNotification.ThunderLastmileProbeStatusChanged result2 = (ThunderNotification.ThunderLastmileProbeStatusChanged) message.obj;
                        ThunderRtcConstant.ThunderLastmileProbeStatus oldValue = ThunderRtcConstant.ThunderLastmileProbeStatus.parseInt(result2.getOldValue());
                        ThunderRtcConstant.ThunderLastmileProbeStatus newValue = ThunderRtcConstant.ThunderLastmileProbeStatus.parseInt(result2.getNewValue());
                        ThunderRtcConstant.ThunderLastmileProbeReason reason = ThunderRtcConstant.ThunderLastmileProbeReason.parseInt(result2.getReason());
                        if (ThunderEngine.mRtcEventHandler != null) {
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.onLastmileProbeStatusChanged oldValue = %d, newValue = %d, reason = %d", oldValue, newValue, reason);
                            }
                            ThunderEngine.mRtcEventHandler.onLastmileProbeStatusChanged(oldValue, newValue, reason);
                            return;
                        }
                        return;
                    case 82:
                        ThunderNotification.ThunderAudioEchoTestStatus status = (ThunderNotification.ThunderAudioEchoTestStatus) message.obj;
                        if (ThunderEngine.mThunderAudioEchoTestHandler != null) {
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.AudioEchoTestStatus %d", Integer.valueOf(status.getStatus()));
                            }
                            ThunderEngine.mThunderAudioEchoTestHandler.onAudioEchoTestStatus(status.getStatus());
                            return;
                        }
                        return;
                    case 83:
                        ThunderNotification.ThunderUserKickedOff info25 = (ThunderNotification.ThunderUserKickedOff) message.obj;
                        ThunderRoomUserInfo userInfo = new ThunderRoomUserInfo();
                        userInfo.uid = info25.getUid();
                        userInfo.userName = info25.getUserName();
                        userInfo.attribute = info25.getAttribute();
                        userInfo.role = info25.getRole();
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.onUserKickedOff uid=%s, userName=%s, attribute=%s, role=%d", userInfo.uid, userInfo.userName, userInfo.attribute, Integer.valueOf(userInfo.role));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onUserKickedOff(userInfo);
                            return;
                        }
                        return;
                    case 84:
                        ThunderNotification.ThunderChorusPlayStatus status2 = (ThunderNotification.ThunderChorusPlayStatus) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.onChorusPlayStatus bPlayMusic=%b, musicLabel=%s, delayTime=%d, seekPos=%d", Boolean.valueOf(status2.isPlayMusic()), status2.getMusicLabel(), Integer.valueOf(status2.getDelayTime()), Integer.valueOf(status2.getSeekPos()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onChorusPlayStatus(status2.isPlayMusic(), status2.getMusicLabel(), status2.getDelayTime(), status2.getSeekPos());
                            return;
                        }
                        return;
                    case 85:
                        ThunderEngine.mRtcEventHandler.onMediaRecordingStatus(((ThunderNotification.ThunderMediaRecordingStatus) message.obj).getStatus());
                        return;
                    case 86:
                        ThunderNotification.ThunderKtvExtraData data = (ThunderNotification.ThunderKtvExtraData) message.obj;
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.onKtvExtraData data=%s, offset=%d", data.getExtraData(), Integer.valueOf(data.getMusicOffset()));
                        }
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderEngine.mRtcEventHandler.onKtvExtraData(data.getExtraData(), data.getMusicOffset());
                            return;
                        }
                        return;
                    case 91:
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderVideoCapture camera open success");
                            ThunderEngine.mRtcEventHandler.onCameraOpenSuccess();
                            return;
                        }
                        return;
                    case 92:
                        ThunderNotification.ThunderCameraParameterChanged info26 = (ThunderNotification.ThunderCameraParameterChanged) message.obj;
                        if (ThunderEngine.mRtcEventHandler != null) {
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderCameraParameterChanged res = %s, position = %d, orientation = %d", info26.getResolution(), Integer.valueOf(info26.getPosition()), Integer.valueOf(info26.getOrientation()));
                            ThunderEngine.mRtcEventHandler.onCameraParameterChanged(info26.getResolution(), info26.getPosition(), info26.getOrientation());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e2) {
                StringWriter errors = new StringWriter();
                e2.printStackTrace(new PrintWriter(errors));
                ThunderLog.error(ThunderLog.kLogTagRtcEngine, String.format("handleMessage err=%s", new Object[]{errors.toString()}));
            }
            StringWriter errors2 = new StringWriter();
            e2.printStackTrace(new PrintWriter(errors2));
            ThunderLog.error(ThunderLog.kLogTagRtcEngine, String.format("handleMessage err=%s", new Object[]{errors2.toString()}));
        }
    }

    static {
        loadLibrary();
    }

    private ThunderEngine() {
        this.mNetStateService = null;
        this.mLastEngineConfig = new ThunderEngineConfig();
        this.mAudioFilePlayerSet = new ConcurrentSkipListSet();
        this.mExternalVideoSource = null;
        mPublisher = new ThunderPublisher();
    }

    private static class SingleonHolder {
        /* access modifiers changed from: private */
        public static ThunderEngine INSTANCE = new ThunderEngine();

        private SingleonHolder() {
        }
    }

    private static void loadLibrary() {
        if ("full".equalsIgnoreCase("fullvideo")) {
            try {
                System.loadLibrary("c++_shared");
            } catch (Throwable e2) {
                e2.printStackTrace();
                Log.e(ThunderLog.kLogTagRtcEngine, "fullvideo flavor load c++_shared failed!");
            }
        }
        try {
            if ("full".equalsIgnoreCase("fullvideo")) {
                System.loadLibrary("ffmpeg-neon");
                System.loadLibrary("yydec265");
            }
        } catch (Throwable e3) {
            e3.printStackTrace();
            Log.e(ThunderLog.kLogTagRtcEngine, "load ffmpeg-neon & Ittiamhevcdec failed!");
        }
        try {
            System.loadLibrary("thunder");
            mIsLoadLibrarySuccess = true;
            Log.i(ThunderLog.kLogTagRtcEngine, "load thunder library success!");
        } catch (Throwable e4) {
            mIsLoadLibrarySuccess = false;
            e4.printStackTrace();
            Log.e(ThunderLog.kLogTagRtcEngine, "load thunder failed!");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0237 A[Catch:{ NumberFormatException -> 0x0276 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized com.thunder.livesdk.ThunderEngine createRtcEngine(android.content.Context r26, java.lang.String r27, long r28, int r30, int r31, int r32, com.thunder.livesdk.ThunderEventHandler r33, android.os.Looper r34) {
        /*
            r14 = r26
            r13 = r27
            r12 = r33
            r10 = r34
            java.lang.Class<com.thunder.livesdk.ThunderEngine> r17 = com.thunder.livesdk.ThunderEngine.class
            monitor-enter(r17)
            java.util.Timer r0 = mDestroyTimer     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x0017
            r0.cancel()     // Catch:{ all -> 0x0284 }
            java.util.TimerTask r0 = mDestroyTask     // Catch:{ all -> 0x0284 }
            r0.cancel()     // Catch:{ all -> 0x0284 }
        L_0x0017:
            r1 = 0
            r18 = 0
            long r3 = java.lang.Long.parseLong(r27)     // Catch:{ NumberFormatException -> 0x0276 }
            r19 = r3
            boolean r0 = mIsLoadLibrarySuccess     // Catch:{ all -> 0x0284 }
            r11 = 1
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = com.thunder.livesdk.helper.ThunderSoLoader.getAbi()     // Catch:{ all -> 0x0284 }
            boolean r0 = com.thunder.livesdk.helper.ThunderSoLoader.soFilesDownloaded(r14, r0)     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x0033
            monitor-exit(r17)
            return r18
        L_0x0033:
            boolean r0 = com.thunder.livesdk.helper.ThunderSoLoader.loadLibs(r26)     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x003b
            monitor-exit(r17)
            return r18
        L_0x003b:
            mIsLoadLibrarySuccess = r11     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = mLogDir     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x0044
            setLogFilePath(r0)     // Catch:{ all -> 0x0284 }
        L_0x0044:
            com.thunder.livesdk.IThunderLogCallback r0 = mLogCallback     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x004b
            setLogCallback(r0)     // Catch:{ all -> 0x0284 }
        L_0x004b:
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x0059
            com.thunder.livesdk.ThunderEngine r0 = new com.thunder.livesdk.ThunderEngine     // Catch:{ all -> 0x0284 }
            r0.<init>()     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine unused = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE = r0     // Catch:{ all -> 0x0284 }
        L_0x0059:
            com.thunder.livesdk.ThunderEngine$NotificationHandler r0 = mHandler     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x0076
            if (r10 == 0) goto L_0x006b
            com.thunder.livesdk.ThunderEngine$NotificationHandler r0 = new com.thunder.livesdk.ThunderEngine$NotificationHandler     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r0.<init>(r1, r10)     // Catch:{ all -> 0x0284 }
            mHandler = r0     // Catch:{ all -> 0x0284 }
            goto L_0x0076
        L_0x006b:
            com.thunder.livesdk.ThunderEngine$NotificationHandler r0 = new com.thunder.livesdk.ThunderEngine$NotificationHandler     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r0.<init>(r1)     // Catch:{ all -> 0x0284 }
            mHandler = r0     // Catch:{ all -> 0x0284 }
        L_0x0076:
            boolean r0 = mIsInited     // Catch:{ all -> 0x0284 }
            r8 = 5
            r21 = 4
            r22 = 3
            r23 = 2
            r24 = 0
            if (r0 != 0) goto L_0x015b
            mRtcEventHandler = r12     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.helper.ThunderHttpsRequestHandler r0 = new com.thunder.livesdk.helper.ThunderHttpsRequestHandler     // Catch:{ all -> 0x0284 }
            r0.<init>()     // Catch:{ all -> 0x0284 }
            mHttpsRequestHandler = r0     // Catch:{ all -> 0x0284 }
            boolean r0 = mIsLoadLibrarySuccess     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x009c
            java.lang.String r0 = "yrtc"
            java.lang.String r1 = "reload thunder library..."
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x0284 }
            loadLibrary()     // Catch:{ all -> 0x0284 }
        L_0x009c:
            com.thunder.livesdk.video.ThunderVideoLogCallback r0 = com.thunder.livesdk.video.ThunderVideoLogCallback.sharedInstance()     // Catch:{ all -> 0x0284 }
            com.yy.videoplayer.utils.YMFLog.registerLogger(r0)     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.system.ThunderNetStateService r0 = r0.mNetStateService     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x00b4
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.system.ThunderNetStateService r0 = r0.mNetStateService     // Catch:{ all -> 0x0284 }
            r0.fini()     // Catch:{ all -> 0x0284 }
        L_0x00b4:
            com.thunder.livesdk.system.ThunderForeBackgroundListener r0 = mForeBackgroundListener     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x00bb
            r0.fini()     // Catch:{ all -> 0x0284 }
        L_0x00bb:
            com.thunder.livesdk.ThunderEngine$1 r0 = new com.thunder.livesdk.ThunderEngine$1     // Catch:{ all -> 0x0284 }
            r0.<init>()     // Catch:{ all -> 0x0284 }
            mNotificationDispatcher = r0     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine$NotificationHandler r1 = mHandler     // Catch:{ all -> 0x0284 }
            r0.registerNotificationHandler(r1)     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderDeviceInfo r15 = new com.thunder.livesdk.ThunderDeviceInfo     // Catch:{ all -> 0x0284 }
            r15.<init>(r14)     // Catch:{ all -> 0x0284 }
            com.yy.videoplayer.decoder.YYVideoLibMgr r1 = com.yy.videoplayer.decoder.YYVideoLibMgr.instance()     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "1.0"
            java.lang.String r4 = "Thunder"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0284 }
            r7 = 0
            r2 = r26
            r1.init(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0284 }
            com.yy.mediaframework.VideoLibAPI r1 = com.yy.mediaframework.VideoLibAPI.instance()     // Catch:{ all -> 0x0284 }
            r2 = r19
            r4 = r28
            r6 = r26
            r1.initVideoLib(r2, r4, r6)     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.helper.ThunderNative$NotificationDispatcher r16 = mNotificationDispatcher     // Catch:{ all -> 0x0284 }
            r0 = r8
            r8 = r19
            r4 = r10
            r1 = r11
            r10 = r28
            r3 = r12
            r12 = r30
            r2 = r13
            r13 = r31
            r7 = r14
            r14 = r26
            int r5 = com.thunder.livesdk.helper.ThunderNative.init(r8, r10, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0284 }
            if (r5 >= 0) goto L_0x010d
            java.lang.String r0 = "yrtc"
            java.lang.String r1 = "init failed"
            com.thunder.livesdk.log.ThunderLog.error(r0, r1)     // Catch:{ all -> 0x0284 }
            monitor-exit(r17)
            return r18
        L_0x010d:
            com.thunder.livesdk.ThunderEngine r6 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.system.ThunderNetStateService r8 = new com.thunder.livesdk.system.ThunderNetStateService     // Catch:{ all -> 0x0284 }
            r8.<init>(r7)     // Catch:{ all -> 0x0284 }
            r6.mNetStateService = r8     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r6 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.system.ThunderNetStateService r6 = r6.mNetStateService     // Catch:{ all -> 0x0284 }
            r6.init()     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.system.ThunderForeBackgroundListener r6 = new com.thunder.livesdk.system.ThunderForeBackgroundListener     // Catch:{ all -> 0x0284 }
            r6.<init>(r7)     // Catch:{ all -> 0x0284 }
            mForeBackgroundListener = r6     // Catch:{ all -> 0x0284 }
            r6.init()     // Catch:{ all -> 0x0284 }
            mIsInited = r1     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderAudioPlaybackCapture.init(r26)     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = "yrtc"
            java.lang.String r8 = "createEngine, appid %s, sceneId %d, areaType %d, serverDomain %d, handler %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0284 }
            r0[r24] = r2     // Catch:{ all -> 0x0284 }
            java.lang.Long r9 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x0284 }
            r0[r1] = r9     // Catch:{ all -> 0x0284 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x0284 }
            r0[r23] = r1     // Catch:{ all -> 0x0284 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0284 }
            r0[r22] = r1     // Catch:{ all -> 0x0284 }
            if (r3 != 0) goto L_0x0150
            java.lang.String r1 = ""
            goto L_0x0154
        L_0x0150:
            java.lang.String r1 = r33.toString()     // Catch:{ all -> 0x0284 }
        L_0x0154:
            r0[r21] = r1     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.log.ThunderLog.release(r6, r8, r0)     // Catch:{ all -> 0x0284 }
            goto L_0x0249
        L_0x015b:
            r0 = r8
            r4 = r10
            r1 = r11
            r3 = r12
            r2 = r13
            r7 = r14
            com.thunder.livesdk.helper.ThunderNative$NotificationDispatcher r5 = mNotificationDispatcher     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine$NotificationHandler r6 = mHandler     // Catch:{ all -> 0x0284 }
            r5.unregisterNotificationHandler(r6)     // Catch:{ all -> 0x0284 }
            if (r4 == 0) goto L_0x0176
            com.thunder.livesdk.ThunderEngine$NotificationHandler r5 = new com.thunder.livesdk.ThunderEngine$NotificationHandler     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r6 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0284 }
            mHandler = r5     // Catch:{ all -> 0x0284 }
            goto L_0x0181
        L_0x0176:
            com.thunder.livesdk.ThunderEngine$NotificationHandler r5 = new com.thunder.livesdk.ThunderEngine$NotificationHandler     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r6 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r5.<init>(r6)     // Catch:{ all -> 0x0284 }
            mHandler = r5     // Catch:{ all -> 0x0284 }
        L_0x0181:
            com.thunder.livesdk.helper.ThunderNative$NotificationDispatcher r5 = mNotificationDispatcher     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine$NotificationHandler r6 = mHandler     // Catch:{ all -> 0x0284 }
            r5.registerNotificationHandler(r6)     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEventHandler r5 = mRtcEventHandler     // Catch:{ all -> 0x0284 }
            if (r5 == r3) goto L_0x018e
            mRtcEventHandler = r3     // Catch:{ all -> 0x0284 }
        L_0x018e:
            com.thunder.livesdk.ThunderEngine r5 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r5 = r5.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            java.lang.String r5 = r5.appId     // Catch:{ all -> 0x0284 }
            r11 = r5
            com.thunder.livesdk.ThunderEngine r5 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r5 = r5.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            long r5 = r5.sceneId     // Catch:{ all -> 0x0284 }
            r12 = r5
            com.thunder.livesdk.ThunderEngine r5 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r5 = r5.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            int r5 = r5.areaType     // Catch:{ all -> 0x0284 }
            r14 = r5
            com.thunder.livesdk.ThunderEngine r5 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r5 = r5.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            int r5 = r5.serverDomain     // Catch:{ all -> 0x0284 }
            r15 = r5
            com.thunder.livesdk.ThunderEngine r5 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r5 = r5.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            int r5 = r5.switchAppIdAction     // Catch:{ all -> 0x0284 }
            r16 = r5
            boolean r5 = r11.equals(r2)     // Catch:{ all -> 0x0284 }
            if (r5 == 0) goto L_0x01cf
            int r5 = (r12 > r28 ? 1 : (r12 == r28 ? 0 : -1))
            if (r5 != 0) goto L_0x01cf
            r10 = r30
            if (r14 != r10) goto L_0x01d1
            r9 = r31
            if (r15 == r9) goto L_0x0249
            goto L_0x01d3
        L_0x01cf:
            r10 = r30
        L_0x01d1:
            r9 = r31
        L_0x01d3:
            java.lang.String r5 = "yrtc"
            java.lang.String r6 = "createEngine, change engine config, appId %s->%s sceneId %d->%d areaType %d->%d serverDomain %d->%d switchAppIdAction %d->%d"
            r8 = 10
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0284 }
            r8[r24] = r11     // Catch:{ all -> 0x0284 }
            r8[r1] = r2     // Catch:{ all -> 0x0284 }
            java.lang.Long r25 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0284 }
            r8[r23] = r25     // Catch:{ all -> 0x0284 }
            java.lang.Long r23 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x0284 }
            r8[r22] = r23     // Catch:{ all -> 0x0284 }
            java.lang.Integer r22 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0284 }
            r8[r21] = r22     // Catch:{ all -> 0x0284 }
            java.lang.Integer r21 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x0284 }
            r8[r0] = r21     // Catch:{ all -> 0x0284 }
            r0 = 6
            java.lang.Integer r21 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0284 }
            r8[r0] = r21     // Catch:{ all -> 0x0284 }
            r0 = 7
            java.lang.Integer r21 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0284 }
            r8[r0] = r21     // Catch:{ all -> 0x0284 }
            r0 = 8
            java.lang.Integer r21 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0284 }
            r8[r0] = r21     // Catch:{ all -> 0x0284 }
            r0 = 9
            java.lang.Integer r21 = java.lang.Integer.valueOf(r32)     // Catch:{ all -> 0x0284 }
            r8[r0] = r21     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.log.ThunderLog.release(r5, r6, r8)     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r0.leaveRoom()     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            r8 = r32
            r0.resetEngineStatus(r8)     // Catch:{ all -> 0x0284 }
            r5 = r19
            r7 = r28
            r9 = r30
            r10 = r31
            int r0 = com.thunder.livesdk.helper.ThunderNative.updateAppInfo(r5, r7, r9, r10)     // Catch:{ all -> 0x0284 }
            if (r0 >= 0) goto L_0x0249
            java.lang.String r5 = "yrtc"
            java.lang.String r6 = "createEngine, update engine config failed %d"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0284 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0284 }
            r1[r24] = r7     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.log.ThunderLog.error(r5, r6, r1)     // Catch:{ all -> 0x0284 }
            monitor-exit(r17)
            return r18
        L_0x0249:
            m_appId = r19     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            com.thunder.livesdk.ThunderEngineConfig r1 = r0.mLastEngineConfig     // Catch:{ all -> 0x0284 }
            r10 = r2
            r2 = r26
            r3 = r27
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r1.copy(r2, r3, r4, r6, r7, r8, r9)     // Catch:{ all -> 0x0284 }
            java.util.HashSet<java.lang.String> r0 = mAppidSet     // Catch:{ all -> 0x0284 }
            boolean r0 = r0.contains(r10)     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x0270
            java.util.HashSet<java.lang.String> r0 = mAppidSet     // Catch:{ all -> 0x0284 }
            r0.add(r10)     // Catch:{ all -> 0x0284 }
        L_0x0270:
            com.thunder.livesdk.ThunderEngine r0 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0284 }
            monitor-exit(r17)
            return r0
        L_0x0276:
            r0 = move-exception
            r10 = r13
            r3 = r0
            r0 = r3
            java.lang.String r3 = "yrtc"
            java.lang.String r4 = "init failed, appid is not number"
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x0284 }
            monitor-exit(r17)
            return r18
        L_0x0284:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thunder.livesdk.ThunderEngine.createRtcEngine(android.content.Context, java.lang.String, long, int, int, int, com.thunder.livesdk.ThunderEventHandler, android.os.Looper):com.thunder.livesdk.ThunderEngine");
    }

    public static synchronized ThunderEngine getCurrentEngine() {
        ThunderEngine access$600;
        synchronized (ThunderEngine.class) {
            access$600 = SingleonHolder.INSTANCE;
        }
        return access$600;
    }

    public static synchronized ThunderEngine createEngine(ThunderEngineConfig config) {
        ThunderEngine rtcEngine;
        synchronized (ThunderEngine.class) {
            rtcEngine = createRtcEngine(config.context, config.appId, config.sceneId, config.areaType, config.serverDomain, config.switchAppIdAction, config.handler, (Looper) null);
        }
        return rtcEngine;
    }

    public static synchronized ThunderEngine createWithLoop(ThunderEngineConfig config, Looper loop) {
        ThunderEngine rtcEngine;
        synchronized (ThunderEngine.class) {
            rtcEngine = createRtcEngine(config.context, config.appId, config.sceneId, config.areaType, config.serverDomain, config.switchAppIdAction, config.handler, loop);
        }
        return rtcEngine;
    }

    public static synchronized void destroyEngine() {
        synchronized (ThunderEngine.class) {
            mAppidSet.clear();
            destroyRtcEngine();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        return -13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int destroyEngine(java.lang.String r6) {
        /*
            java.lang.Class<com.thunder.livesdk.ThunderEngine> r0 = com.thunder.livesdk.ThunderEngine.class
            monitor-enter(r0)
            r1 = -13
            if (r6 == 0) goto L_0x006b
            boolean r2 = r6.isEmpty()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x000e
            goto L_0x006b
        L_0x000e:
            java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            java.util.HashSet<java.lang.String> r1 = mAppidSet     // Catch:{ all -> 0x0068 }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x001e
            r1 = -40
            monitor-exit(r0)
            return r1
        L_0x001e:
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0068 }
            r2 = 0
            if (r1 == 0) goto L_0x003f
            long r3 = m_appId     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0068 }
            boolean r1 = r6.equals(r1)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x003f
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0068 }
            r1.leaveRoom()     // Catch:{ all -> 0x0068 }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x0068 }
            r1.resetEngineStatus(r2)     // Catch:{ all -> 0x0068 }
        L_0x003f:
            java.util.HashSet<java.lang.String> r1 = mAppidSet     // Catch:{ all -> 0x0068 }
            r1.remove(r6)     // Catch:{ all -> 0x0068 }
            java.util.HashSet<java.lang.String> r1 = mAppidSet     // Catch:{ all -> 0x0068 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x004e
            monitor-exit(r0)
            return r2
        L_0x004e:
            java.util.Timer r1 = new java.util.Timer     // Catch:{ all -> 0x0068 }
            r1.<init>()     // Catch:{ all -> 0x0068 }
            mDestroyTimer = r1     // Catch:{ all -> 0x0068 }
            com.thunder.livesdk.ThunderEngine$2 r1 = new com.thunder.livesdk.ThunderEngine$2     // Catch:{ all -> 0x0068 }
            r1.<init>()     // Catch:{ all -> 0x0068 }
            mDestroyTask = r1     // Catch:{ all -> 0x0068 }
            java.util.Timer r3 = mDestroyTimer     // Catch:{ all -> 0x0068 }
            r4 = 10000(0x2710, double:4.9407E-320)
            r3.schedule(r1, r4)     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)
            return r2
        L_0x0065:
            r2 = move-exception
            monitor-exit(r0)
            return r1
        L_0x0068:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        L_0x006b:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thunder.livesdk.ThunderEngine.destroyEngine(java.lang.String):int");
    }

    private void resetEngineStatus(int switchAppIdAction) {
        if ((switchAppIdAction & 1) == 0) {
            registerVideoCaptureTextureFrameObserver((VideoTextureFrameObserver) null);
        }
        cleanAllAudioFilePlayer();
        mThunderMediaExtraInfoCallback = null;
        ThunderNative.resetEngineStatus(switchAppIdAction);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void destroyRtcEngine() {
        /*
            java.lang.Class<com.thunder.livesdk.ThunderEngine> r0 = com.thunder.livesdk.ThunderEngine.class
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = mAppidSet     // Catch:{ all -> 0x004b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            boolean r1 = mIsInited     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0049
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x004b }
            r2 = 0
            r1.setVideoWatermark(r2)     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x004b }
            r3 = 0
            r1.setLocalVideoMirrorMode(r3)     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x004b }
            r1.cleanAllAudioFilePlayer()     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.ThunderEngine r1 = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE     // Catch:{ all -> 0x004b }
            r1.resetRtcEngine()     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.ThunderEngine unused = com.thunder.livesdk.ThunderEngine.SingleonHolder.INSTANCE = r2     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.helper.ThunderNative.fini()     // Catch:{ all -> 0x004b }
            com.thunder.livesdk.ThunderAudioPlaybackCapture.fini()     // Catch:{ all -> 0x004b }
            com.yy.videoplayer.decoder.YYVideoLibMgr r1 = com.yy.videoplayer.decoder.YYVideoLibMgr.instance()     // Catch:{ all -> 0x004b }
            java.lang.String r4 = "Thunder"
            r1.deInit(r4)     // Catch:{ all -> 0x004b }
            mIsInited = r3     // Catch:{ all -> 0x004b }
            r3 = 0
            m_appId = r3     // Catch:{ all -> 0x004b }
            mThunderAudioEchoTestHandler = r2     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r0)
            return
        L_0x004b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thunder.livesdk.ThunderEngine.destroyRtcEngine():void");
    }

    public static synchronized boolean isLibReady(Context context, String abi, IThunderLibDownloadStatusCallback callback) {
        synchronized (ThunderEngine.class) {
            if (mIsLoadLibrarySuccess) {
                if (callback != null) {
                    callback.onLibDownloadSuccess();
                }
                return true;
            }
            boolean downloadSoFiles = ThunderSoLoader.downloadSoFiles(context, abi, callback);
            return downloadSoFiles;
        }
    }

    public static String getVersion() {
        if (!mIsLoadLibrarySuccess) {
            return "4.4.3.6";
        }
        return ThunderNative.getVersion();
    }

    public static long getAppId() {
        return m_appId;
    }

    public static int setLogFilePath(String filePath) {
        return -10000;
    }

    public static int setLogCallback(IThunderLogCallback callback) {
        if (mIsLoadLibrarySuccess) {
            return ThunderNative.setLogCallback(callback);
        }
        mLogCallback = callback;
        return -1;
    }

    public static int setLogLevel(int filter) {
        ThunderLog.setLogLevel(filter);
        if (!mIsLoadLibrarySuccess) {
            return -1;
        }
        return ThunderNative.setLogLevel(filter);
    }

    public int setParameters(String options) {
        if (options == null || options.isEmpty()) {
            return -13;
        }
        return ThunderNative.setParameters(options);
    }

    public void setSceneId(long sceneId) {
        ThunderNative.setSceneId(sceneId);
    }

    public int setMediaMode(int mode) {
        return ThunderNative.setMediaMode(mode);
    }

    public int setRoomMode(int mode) {
        return ThunderNative.setRoomMode(mode);
    }

    public int setArea(int area) {
        return ThunderNative.setAreaType(area);
    }

    public int getConnectionStatus() {
        return ThunderNative.getConnectionStatus();
    }

    public int enableWebSdkCompatibility(boolean enabled) {
        return ThunderNative.enableWebSdkCompatibility(enabled);
    }

    public int setUse64bitUid(boolean is64bitUid) {
        return ThunderNative.setUse64bitUid(is64bitUid);
    }

    public int joinRoom(byte[] token, String roomName, String uid) {
        return ThunderNative.joinRoom(token, roomName, uid);
    }

    public int leaveRoom() {
        return ThunderNative.leaveRoom();
    }

    public int updateToken(byte[] token) {
        return ThunderNative.updateToken(token);
    }

    public int setAudioConfig(int profile, int commutMode, int scenarioMode) {
        return ThunderNative.setAudioConfig(profile, commutMode, scenarioMode);
    }

    public int enableVoicePosition(boolean enable) {
        return ThunderNative.enableVoicePosition(enable);
    }

    public int enableMOSAutoTest(boolean enable) {
        return ThunderNative.enableMOSAutoTest(enable);
    }

    public int setMOSAutoTestFileParam(String filePath, int samplerate, int channels, int circleTimes) {
        return ThunderNative.setMOSAutoTestFileParam(filePath, samplerate, channels, circleTimes);
    }

    public int enableLoudspeaker(boolean enabled) {
        return ThunderNative.enableLoudSpeaker(enabled);
    }

    public boolean isLoudspeakerEnabled() {
        return ThunderNative.getLoudSpeakerEnabled();
    }

    public int setAudioVolumeIndication(int interval, int moreThanThd, int lessThanThd, int smooth) {
        return ThunderNative.setPlayVolumeInterval(interval, moreThanThd, lessThanThd);
    }

    public int enableCaptureVolumeIndication(int interval, int moreThanThd, int lessThanThd, int smooth) {
        return ThunderNative.setCaptureVolumeInterval(interval, moreThanThd, lessThanThd);
    }

    public int startAudioRecord(String fileName, int saverMode, int sampleRate, int quality) {
        if (fileName.isEmpty()) {
            return -13;
        }
        return ThunderNative.startAudioRecord(fileName, saverMode, sampleRate, quality);
    }

    public int stopAudioRecord() {
        return ThunderNative.stopAudioRecord();
    }

    public void setSoundEffect(int mode) {
        ThunderNative.setSoundEffect(mode);
    }

    public void setVoiceChanger(int mode) {
        ThunderNative.setVoiceChanger(mode);
    }

    public int stopLocalAudioStream(boolean stop) {
        return ThunderNative.startPublishAudio(!stop);
    }

    public int enableLocalAudioCapture(boolean enable) {
        return ThunderNative.startAudioCapture(enable);
    }

    public boolean isSDKSupportAudioPlaybackCapture() {
        return ThunderAudioPlaybackCapture.isSDKSupportAudioPlaybackCapture();
    }

    public int setAudioPlaybackCaptureVolume(int volume) {
        return ThunderAudioPlaybackCapture.setAudioPlaybackCaptureVolume(volume);
    }

    public void setAudioPlaybackCaptureMode(int mode) {
        ThunderAudioPlaybackCapture.setAudioPlaybackCaptureMode(mode);
    }

    public void setAudioPlaybackCaptureUid(int[] appUids) {
        ThunderAudioPlaybackCapture.setAudioPlaybackCaptureUid(appUids);
    }

    public void setAudioPlaybackCaptureProjection(MediaProjection projection) {
        ThunderAudioPlaybackCapture.setAudioPlaybackCaptureProjection(projection);
    }

    public MediaProjection getAudioPlaybackCaptureProjection() {
        return ThunderAudioPlaybackCapture.getAudioPlaybackCaptureProjection();
    }

    public int enableAudioPlaybackCapture(boolean enable) {
        return ThunderAudioPlaybackCapture.enableAudioPlaybackCapture(enable);
    }

    public int enableLocalAudioEncoder(boolean enable) {
        return ThunderNative.startAudioEncode(enable);
    }

    public int enableLocalAudioPublisher(boolean enable) {
        return ThunderNative.startPushAudioStream(enable);
    }

    public boolean isAudioCaptureEnabled() {
        return ThunderNative.isAudioCaptureEnabled() == 1;
    }

    public boolean isAudioEncoderEnabled() {
        return ThunderNative.isAudioEncoderEnabled() == 1;
    }

    public boolean isAudioPublisherEnabled() {
        return ThunderNative.isAudioPublisherEnabled() == 1;
    }

    public int stopAllRemoteAudioStreams(boolean stop) {
        return ThunderNative.stopAllRemoteStreams(false, stop);
    }

    public int stopRemoteAudioStream(String uid, boolean stop) {
        return ThunderNative.stopRemoteAudioStream(uid, stop);
    }

    public int setLoudSpeakerVolume(int volume) {
        return ThunderNative.setSpeakerVolume(volume);
    }

    public int setMicVolume(int volume) {
        return ThunderNative.setMicVolume(volume);
    }

    public int setRemoteAudioStreamsVolume(String uid, int volume) {
        return ThunderNative.setRemoteAudioStreamVolume(uid, volume);
    }

    public int setRemoteUidVoicePosition(String uid, int azimuth, int gain) {
        return -10000;
    }

    public int setRemoteUidVoicePosition(String uid, int azimuth, int elevation, float distance) {
        return ThunderNative.setRemoteUidVoicePosition(uid, azimuth, elevation, distance);
    }

    public ThunderAudioFilePlayer createAudioFilePlayer() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "createAudioFilePlayer");
        ThunderAudioFilePlayer audioFilePlayer = new ThunderAudioFilePlayer();
        this.mAudioFilePlayerSet.add(audioFilePlayer);
        return audioFilePlayer;
    }

    public void destroyAudioFilePlayer(ThunderAudioFilePlayer audioFilePlayer) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "destroyAudioFilePlayer: %s", getPrintString(audioFilePlayer));
        if (audioFilePlayer == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "destroyAudioFilePlayer null");
            return;
        }
        audioFilePlayer.destroyAudioFilePlayer();
        this.mAudioFilePlayerSet.remove(audioFilePlayer);
    }

    public int setEnableEqualizer(boolean enabled) {
        return ThunderNative.enableEqualizer(enabled);
    }

    public int setEqGains(int[] gains) {
        if (gains == null) {
            return -13;
        }
        return ThunderNative.setGqGains(gains);
    }

    public int setEnableReverb(boolean enabled) {
        return ThunderNative.enableReverb(enabled);
    }

    public int setReverbExParameter(ThunderRtcConstant.ReverbExParameter param) {
        if (param == null) {
            return -13;
        }
        return ThunderNative.setReverbExParameter(param.mRoomSize, param.mPreDelay, param.mReverberance, param.mHfDamping, param.mToneLow, param.mToneHigh, param.mWetGain, param.mDryGain, param.mStereoWidth);
    }

    public int setEnableLimiter(boolean enabled) {
        return ThunderNative.enableLimiter(enabled);
    }

    public int setLimiterParam(ThunderRtcConstant.LimterParam param) {
        if (param == null) {
            return -13;
        }
        return ThunderNative.setLimiterParameter(param.fCeiling, param.fThreshold, param.fPreGain, param.fRelease, param.fAttack, param.fLookahead, param.fLookaheadRatio, param.fRMS, param.fStLink);
    }

    public int setVoicePitch(float pitch) {
        return ThunderNative.setVoicePitch(pitch);
    }

    public void enableAudioPlaySpectrum(boolean enable) {
        ThunderNative.enableAudioPlaySpectrum(enable);
    }

    public void setAudioPlaySpectrumInfo(int spectrumLen, int notifyIntervalMS) {
        ThunderNative.setAudioPlaySpectrumInfo(spectrumLen, notifyIntervalMS);
    }

    public int sendUserAppMsgData(byte[] msgData) {
        if (msgData != null && msgData.length != 0) {
            return ThunderNative.sendUserAppMsgData(msgData);
        }
        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "sendUserAppMsgData is null or length is 0");
        return -13;
    }

    public int sendMediaExtraInfo(ByteBuffer data, int dataLen) {
        if (data == null) {
            ThunderLog.error(ThunderLog.kLogTagRtcEngine, "sendMediaExtraInfo is null");
            return -13;
        } else if (data.remaining() < dataLen) {
            ThunderLog.error(ThunderLog.kLogTagRtcEngine, "sendMediaExtraInfo: dataLen large than data.remaining()");
            return -13;
        } else {
            byte[] extraInfo = new byte[dataLen];
            data.get(extraInfo, 0, extraInfo.length);
            return ThunderNative.sendMediaExtraInfo(-1, extraInfo);
        }
    }

    public int setMediaExtraInfoCallback(IThunderMediaExtraInfoCallback callback) {
        mThunderMediaExtraInfoCallback = callback;
        ThunderNative.makeBehaviorEvent(15, callback == null ? "null" : "not null");
        return 0;
    }

    public int enableMixVideoExtraInfo(boolean enable) {
        return ThunderNative.enableMixVideoExtraInfo(enable);
    }

    public int syncMediaPlayingProgress(int currentMs) {
        return (int) ThunderNative.sendAudioFilePlayerInfo(0, currentMs, 0);
    }

    public void enableAudioDataIndication(boolean enablePlay) {
        ThunderNative.enableAudioDataIndication(enablePlay);
    }

    public int setAudioSourceType(int sourceType) {
        return ThunderNative.setAudioPublishMode(sourceType);
    }

    public int adaptToSystemKaraoke(boolean enable) {
        return ThunderNative.adaptToSystemKaraoke(enable);
    }

    public int setEnableInEarMonitor(boolean enable) {
        return ThunderNative.enableInEarMonitor(enable);
    }

    public int setEarMonitoringVolume(int volume) {
        return ThunderNative.setEarMonitoringVolume(volume);
    }

    public int setVideoEncoderConfig(ThunderVideoEncoderConfiguration yyVideoConfig) {
        if (yyVideoConfig != null) {
            return ThunderNative.setVideoEncoderConfig(yyVideoConfig);
        }
        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "setVideoEncoderConfig is null");
        return -13;
    }

    public int setVideoEncoderParameters(ThunderVideoEncoderParam videoEncoderParam, List<ThunderRtcVideoTransParam> list) {
        if (videoEncoderParam == null) {
            return -13;
        }
        return ThunderNative.setVideoEncoderParameters(videoEncoderParam, (List<ThunderRtcVideoTransParam>) null);
    }

    public int setVideoCaptureParameters(ThunderCameraCaptureParameters cameraCaptureParameters) {
        if (cameraCaptureParameters == null) {
            return -13;
        }
        return ThunderNative.setVideoCaptureParameters(cameraCaptureParameters);
    }

    public int setRtcDefaultTransIdInAuto(int defaultTransIdInAuto) {
        return -10000;
    }

    public int setSubscribeVideoTransId(String uid, int subTransId) {
        return -10000;
    }

    public int getPlayingVideoTransId(String uid) {
        return -10000;
    }

    public int setLocalVideoCanvas(ThunderVideoCanvas local) {
        if (local != null) {
            return ThunderNative.setLocalVideoCanvas(local.mView, local.mRenderMode);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLocalVideoCanvas is null");
        return -13;
    }

    public int setRemoteVideoCanvas(ThunderVideoCanvas remote) {
        if (remote != null) {
            return ThunderNative.setRemoteVideoCanvas(remote.mView, remote.mRenderMode, remote.mUid, remote.mSeatIndex);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteVideoCanvas is null");
        return -13;
    }

    public int onExternalSurfaceCreated(boolean isLocal, Surface surface) {
        return ThunderNative.setExternalSurfaceCreated(isLocal, surface);
    }

    public int onExternalSurfaceChanged(boolean isLocal, Surface surface, int surfaceWidth, int surfaceHeight) {
        return ThunderNative.setExternalSurfaceChanged(isLocal, surface, surfaceWidth, surfaceHeight);
    }

    public int onExternalSurfaceDestroyed(boolean isLocal, Surface surface) {
        return ThunderNative.setExternalSurfaceDestroyed(isLocal, surface);
    }

    public int setLocalCanvasScaleMode(int mode) {
        return ThunderNative.setLocalVideoCanvasMode(mode);
    }

    public int setRemoteCanvasMode(String uid, int renderMode, int mirrorMode) {
        return ThunderNative.setRemoteVideoCanvasMode(uid, renderMode, mirrorMode);
    }

    public int startLocalVideoPreview() {
        return ThunderNative.startLocalVideoPreview(true);
    }

    public int stopLocalVideoPreview() {
        return ThunderNative.startLocalVideoPreview(false);
    }

    public int enableLocalVideoCapture(boolean enable) {
        return ThunderNative.startVideoCapture(enable);
    }

    public int pauseLocalVideoCapture(boolean pause) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "pauseLocalVideoCapture %b", Boolean.valueOf(pause));
        return ThunderNative.pauseVideoCapture(pause);
    }

    public int stopLocalVideoStream(boolean stop) {
        if (stop) {
            return ThunderNative.startVideoEncode(false) | ThunderNative.startPushVideoStream(false);
        }
        int ret = ThunderNative.startVideoEncode(true);
        if (ret != 0) {
            return ret;
        }
        int ret2 = ThunderNative.startPushVideoStream(true);
        if (ret2 != 0) {
            ThunderNative.startVideoEncode(false);
        }
        return ret2;
    }

    public int enableLocalVideoEncoder(boolean enable) {
        return ThunderNative.startVideoEncode(enable);
    }

    public int enableLocalVideoPublisher(boolean enabled) {
        return ThunderNative.startPushVideoStream(enabled);
    }

    public int stopRemoteVideoStream(String uid, boolean stop) {
        return ThunderNative.stopRemoteVideoStream(uid, stop);
    }

    public int stopAllRemoteVideoStreams(boolean stop) {
        return ThunderNative.stopAllRemoteStreams(true, stop);
    }

    public int enableLocalDualStreamMode(boolean enabled) {
        return ThunderNative.enableLocalDualStreamMode(enabled);
    }

    public int setDefaultRemoteVideoStreamType(int type) {
        return ThunderNative.setDefaultRemoteVideoStreamType(type);
    }

    public int changeRemoteVideoStreamType(String uid, int type) {
        return ThunderNative.changeRemoteVideoStreamType(uid, type);
    }

    public int switchUserRole(int role) {
        return ThunderNative.switchUserRole(role);
    }

    public int registerVideoCaptureTextureFrameObserver(VideoTextureFrameObserver observer) {
        VideoFrameTextrue.getInstance().enableVideoTextrue(observer);
        return 0;
    }

    public int registerVideoCaptureFrameObserver(ThunderVideoCaptureObserver observer) {
        return VideoFrameYuvCapture.getInstance().enableVideoCapture((IVideoCaptureObserver) observer);
    }

    public int registerVideoCaptureFrameDataObserver(IVideoCaptureFrameObserver observer) {
        return VideoFrameYuvCapture.getInstance().enableVideoCapture(observer);
    }

    public int registerVideoDecodeFrameObserver(String uid, IVideoDecodeObserver observer) {
        return ThunderNative.setVideoFrameObserver(uid, observer);
    }

    public int registerVideoEncodedFrameObserver(IVideoEncodedFrameObserver observer) {
        ThunderVideoPublishEngineImp.setVideoEncodedFrameObserver(observer);
        return 0;
    }

    public int registerCameraEncodedFrameObserver(ICameraEncodedFrameObserver observer) {
        ThunderVideoPublishEngineImp.setCameraEncodedFrameObserver(observer);
        return 0;
    }

    public int registerAudioFrameObserver(IAudioFrameObserver observer) {
        ThunderNative.registerAudioFrameObserver(observer);
        return 0;
    }

    public int registerAudioEncodedFrameObserver(IAudioEncodedFrameObserver observer) {
        return ThunderNative.registerAudioEncodedFrameObserver(observer);
    }

    public int setRecordingAudioFrameParameters(int sampleRate, int channel, int mode, int samplesPerCall) {
        return ThunderNative.setRecordingAudioFrameParameters(sampleRate, channel, mode, samplesPerCall);
    }

    public int setPlaybackAudioFrameParameters(int sampleRate, int channel, int mode, int samplesPerCall) {
        return ThunderNative.setPlaybackAudioFrameParameters(sampleRate, channel, mode, samplesPerCall);
    }

    public int setMixedAudioFrameParameters(int sampleRate, int channel, int samplesPerCall) {
        return ThunderNative.setMixedAudioFrameParameters(sampleRate, channel, samplesPerCall);
    }

    public int setVideoWatermark(ThunderBoltImage watermark) {
        if (watermark == null || (watermark.height > 0 && watermark.width > 0 && watermark.width <= 1920 && watermark.height <= 1920 && watermark.x >= 0 && watermark.y >= 0)) {
            return ThunderNative.setPubWatermark(watermark);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoWatermark invalid params, x %d, y %d, w %d, h %d ", Integer.valueOf(watermark.x), Integer.valueOf(watermark.y), Integer.valueOf(watermark.width), Integer.valueOf(watermark.height));
        return -13;
    }

    public int setCustomAudioSource(boolean enabled, int sampleRate, int channel) {
        return ThunderNative.setCustomAudioSource(enabled, sampleRate, channel);
    }

    public int pushCustomAudioFrame(byte[] data, long timeStamp) {
        if (data != null && data.length != 0) {
            return ThunderNative.pushCustomAudioFrame(data, timeStamp);
        }
        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "pushCustomAudioFrame is null");
        return -13;
    }

    public int pushCustomAudioFrame(int id, byte[] data, int sampleRate, int channel, long timeStamp) {
        if (data != null && data.length != 0) {
            return ThunderNative.pushCustomAudioFrame(id, data, sampleRate, channel, timeStamp);
        }
        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "pushCustomAudioFrame with id argument is null");
        return -13;
    }

    public int setCustomVideoSource(ThunderCustomVideoSource videoSource) {
        if (ThunderNative.getUserRole() != 1) {
            ThunderLog.warn(ThunderLog.kLogTagRtcEngine, "setCustomVideoSource not anchor");
            return -31;
        } else if (videoSource == null || (videoSource instanceof ThunderDefaultCamera)) {
            if (videoSource != null) {
                return ThunderNative.attachVideoCapture(videoSource, 0);
            }
            return ThunderNative.attachVideoCapture(mPublisher.getDefaluteCamera(), 0);
        } else if (videoSource instanceof ScreenRecordSource) {
            return ThunderNative.attachVideoCapture(((ScreenRecordSource) videoSource).mScreenCapture, 1);
        } else {
            ExternalVideoSource externalVideoSource = this.mExternalVideoSource;
            if (externalVideoSource == null || !externalVideoSource.equals(videoSource)) {
                ExternalVideoSource externalVideoSource2 = new ExternalVideoSource(videoSource);
                this.mExternalVideoSource = externalVideoSource2;
                if (videoSource instanceof ThunderExternalVideoSource) {
                    externalVideoSource2.setVideoBufferType(((ThunderExternalVideoSource) videoSource).getThunderVideoBufferType());
                }
            }
            return ThunderNative.attachVideoCapture(this.mExternalVideoSource, 2);
        }
    }

    public int addPublishOriginStreamUrl(String url) {
        return ThunderNative.updatePublishOriginStreamUrl(true, url);
    }

    public int removePublishOriginStreamUrl(String url) {
        return ThunderNative.updatePublishOriginStreamUrl(false, url);
    }

    public int addPublishTranscodingStreamUrl(String taskId, String url) {
        return ThunderNative.updatePublishTranscodingStreamUrl(taskId, true, url);
    }

    public int removePublishTranscodingStreamUrl(String taskId, String url) {
        return ThunderNative.updatePublishTranscodingStreamUrl(taskId, false, url);
    }

    public int setLiveTranscodingTask(String taskId, LiveTranscoding transcoding) {
        return ThunderNative.setLiveTranscodingTask(taskId, transcoding);
    }

    public int removeLiveTranscodingTask(String taskId) {
        return ThunderNative.removeLiveTranscodingTask(taskId);
    }

    public int addSubscribe(String roomId, String uid) {
        return ThunderNative.subscribeUser(true, roomId, uid);
    }

    public int removeSubscribe(String roomId, String uid) {
        return ThunderNative.subscribeUser(false, roomId, uid);
    }

    public int subscribeRoom(String roomId) {
        return ThunderNative.subscribeRoom(true, roomId);
    }

    public int unsubscribeRoom(String roomId) {
        return ThunderNative.subscribeRoom(false, roomId);
    }

    public int switchFrontCamera(boolean bFront) {
        return ThunderNative.switchFrontCamera(bFront);
    }

    public boolean isCameraOpen() {
        return ThunderNative.isCameraOpen();
    }

    public boolean isFrontCamera() {
        return ThunderNative.isFrontCamera();
    }

    public int setCameraFocusLocked(boolean enable) {
        return ThunderNative.setCameraFocusLocked(enable);
    }

    public int setCameraExposureLocked(boolean enable) {
        return ThunderNative.setCameraExposureLocked(enable);
    }

    public int setCamera2Capture(boolean enable) {
        return ThunderNative.setCamera2Capture(enable);
    }

    public int setCameraFocusAndExposureModeLocked(boolean enable) {
        return ThunderNative.setCameraFocusAndExposureModeLocked(enable);
    }

    public boolean isCameraFocusAndExposureModeLocked() {
        return ThunderNative.isCameraFocusAndExposureModeLocked();
    }

    public boolean isCameraFocusSupported() {
        return ThunderNative.isCameraManualFocusPositionSupported();
    }

    public boolean isCameraExposurePositionSupported() {
        return ThunderNative.isCameraManualExposurePositionSupported();
    }

    public int setCameraExposureCompensation(float compensation) {
        if (compensation < 0.0f || compensation > 1.0f) {
            return -13;
        }
        int ret = ThunderNative.setCameraExposureCompensation(compensation);
        if (ret != 0) {
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        return ret;
    }

    public float getCameraExposureCompensation() {
        return ThunderNative.getCameraExposureCompensation();
    }

    public float[] getCameraExposureCompensationRange() {
        return new float[]{ThunderNative.getCameraMinExposureCompensation(), ThunderNative.getCameraMaxExposureCompensation()};
    }

    public float[] getCameraExposureDurationRange() {
        return new float[]{ThunderNative.getCameraMinExposureDuration(), ThunderNative.getCameraMaxExposureDuration()};
    }

    public float getCameraExposureDuration() {
        float ret = ThunderNative.getCameraExposureDuration();
        if (ret >= 0.0f) {
            return ret;
        }
        if (ret > -1.5f) {
            return -4001.0f;
        }
        return -10000.0f;
    }

    public int setCameraExposureDuration(float exposeDuration) {
        float[] range = {ThunderNative.getCameraMinExposureDuration(), ThunderNative.getCameraMaxExposureDuration()};
        if (range[0] <= 0.0f || range[1] <= 0.0f) {
            return -10000;
        }
        if (exposeDuration < 0.0f || exposeDuration < range[0] || exposeDuration > range[1]) {
            return -13;
        }
        return ThunderNative.setCameraExposureDuration(exposeDuration);
    }

    public float[] getCameraExposureISORange() {
        return new float[]{ThunderNative.getCameraMinExposureISO(), ThunderNative.getCameraMaxExposureISO()};
    }

    public float getCameraExposureISO() {
        float ret = ThunderNative.getCameraExposureISO();
        if (ret >= 0.0f) {
            return ret;
        }
        if (ret > -1.5f) {
            return -4001.0f;
        }
        return -10000.0f;
    }

    public int setCameraExposureISO(float exposeISO) {
        float[] range = {ThunderNative.getCameraMinExposureISO(), ThunderNative.getCameraMaxExposureISO()};
        if (range[0] <= 0.0f || range[1] <= 0.0f) {
            return -10000;
        }
        if (exposeISO < 0.0f || exposeISO < range[0] || exposeISO > range[1]) {
            return -13;
        }
        return ThunderNative.setCameraExposureISO(exposeISO);
    }

    public float getCameraLensPosition() {
        float ret = ThunderNative.getCameraLensPosition();
        if (ret >= 0.0f) {
            return ret;
        }
        if (ret > -1.5f) {
            return -4001.0f;
        }
        return -10000.0f;
    }

    public int setCameraLensPosition(float lensPosition) {
        if (lensPosition < 0.0f) {
            return -13;
        }
        return ThunderNative.setCameraLensPosition(lensPosition);
    }

    public boolean isCameraZoomSupported() {
        return ThunderNative.isCameraZoomSupported();
    }

    public float getCameraMaxZoomFactor() {
        return ThunderNative.getCameraMaxZoomFactor();
    }

    public float setCameraZoomFactor(float zoomFactor) {
        return ThunderNative.setCameraZoomFactor(zoomFactor);
    }

    public float getCameraZoomFactor() {
        float ret = ThunderNative.getCameraZoomFactor();
        if (ret < 0.0f) {
            return -4001.0f;
        }
        return ret;
    }

    public boolean isCameraTorchSupported() {
        return ThunderNative.isCameraTorchSupported();
    }

    public boolean isCameraTorchOpen() {
        return ThunderNative.isCameraTorchOpen();
    }

    public int setCameraTorchOn(boolean isOn) {
        return ThunderNative.setCameraTorchOn(isOn);
    }

    public int setCameraFocusPositionInPreview(float posX, float posY) {
        return ThunderNative.setCameraFocusPosition(posX, posY);
    }

    public int setCameraExposurePosition(float posX, float posY) {
        return ThunderNative.setCameraExposurePosition(posX, posY);
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return ThunderNative.isCameraAutoFocusFaceModeSupported();
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean enable) {
        return ThunderNative.setCameraAutoFocusFaceModeEnabled(enable);
    }

    public int getVideoCaptureOrientation() {
        return ThunderNative.getOrientation();
    }

    public int setVideoCaptureOrientation(int orientation) {
        return ThunderNative.setOrientation(orientation);
    }

    public int setLocalVideoMirrorMode(int mode) {
        return ThunderNative.setLocalVideoMirrorMode(mode);
    }

    public int enableHowlingDetector(Boolean enabled) {
        return ThunderNative.enableHowlingDetector(enabled.booleanValue());
    }

    public int enableEchoDetector(Boolean enabled) {
        return ThunderNative.enableEchoDetector(enabled.booleanValue());
    }

    public int enableMusicDetector(Boolean enabled) {
        return ThunderNative.enableMusicDetector(enabled.booleanValue());
    }

    public int enableLocalSpeakingDetector(Boolean enabled) {
        return ThunderNative.enableLocalSpeakingDetector(enabled.booleanValue());
    }

    public int startInputDeviceTest() {
        return ThunderNative.startInputDeviceTest();
    }

    public int stopInputDeviceTest() {
        return ThunderNative.stopInputDeviceTest();
    }

    public int startOutputDeviceTest(String filePath) {
        return ThunderNative.startOutputDeviceTest(filePath);
    }

    public int stopOutputDeviceTest() {
        return ThunderNative.stopOutputDeviceTest();
    }

    public int enableMicDenoise(boolean enabled) {
        return ThunderNative.enableMicDenoise(enabled);
    }

    public boolean isMicDenoiseEnabled() {
        return ThunderNative.micDenoiseEnabled() == 1;
    }

    public int enableAGC(boolean enabled) {
        return ThunderNative.enableAGC(enabled);
    }

    public int enableAEC(boolean enabled) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAEC %b", Boolean.valueOf(enabled));
        return ThunderNative.enableAEC(enabled);
    }

    public int enableAIDenoise(boolean enabled) {
        return ThunderNative.enableAIDenoise(enabled);
    }

    public int enableAIVAD(boolean enabled) {
        return ThunderNative.enableAIVAD(enabled);
    }

    public int setMultiVideoViewLayout(ThunderMultiVideoViewParam params) {
        if (params != null) {
            return ThunderNative.initMultiPlayerViewLayout(params, params.mViewId, params.mView);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMultiVideoViewLayout null");
        return -13;
    }

    public Bitmap captureRemoteScreenShot(String uid) {
        return ThunderNative.captureRemoteScreenShot(uid);
    }

    public int setCaptureReplaceImage(Bitmap bitmap) {
        return ThunderNative.setCaptureReplaceImage(bitmap);
    }

    public int setCaptureReplaceVideo(ThunderCaptureReplaceVideoConfig config) {
        return ThunderNative.setCaptureReplaceVideo(config);
    }

    public int startMediaRecording(ThunderMediaRecordingConfig config) {
        return ThunderNative.startMediaRecording(config);
    }

    public int stopMediaRecording() {
        return ThunderNative.stopMediaRecording();
    }

    public Bitmap captureLocalScreenShot() {
        return ThunderNative.captureLocalScreenShot();
    }

    public ThunderVideoEncodeParam getVideoEncoderParam(ThunderVideoEncoderConfiguration videoConfig) {
        if (videoConfig != null) {
            return ThunderNative.getVideoEncoderParamByGear(videoConfig.playType, videoConfig.publishMode);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "getVideoEncoderParam null params");
        return null;
    }

    public static ThunderDefaultCamera getDefaluteCamera() {
        ThunderPublisher thunderPublisher = mPublisher;
        if (thunderPublisher != null) {
            return thunderPublisher.getDefaluteCamera();
        }
        return null;
    }

    private void resetRtcEngine() {
        mHandler = null;
        mRtcEventHandler = null;
        mHttpsRequestHandler = null;
        s_captureVolumeNotifyCount = 0;
        s_playVolumeNotifyCount = 0;
        s_playDataNotifyCount = 0;
        s_audioPlaySpectrumCount = 0;
        if (mPublisher.getDefaluteCamera() != null) {
            ThunderPreviewConfig config = (ThunderPreviewConfig) mPublisher.getDefaluteCamera().getCaptureConfig();
            config.cameraPosition = 0;
            config.captureOrientation = 0;
        }
        mPublisher = null;
        mThunderMediaExtraInfoCallback = null;
        if (SingleonHolder.INSTANCE.mNetStateService != null) {
            SingleonHolder.INSTANCE.mNetStateService.fini();
        }
        ThunderForeBackgroundListener thunderForeBackgroundListener = mForeBackgroundListener;
        if (thunderForeBackgroundListener != null) {
            thunderForeBackgroundListener.fini();
        }
        SingleonHolder.INSTANCE.mNetStateService = null;
        mForeBackgroundListener = null;
        mLogDir = null;
        mLogCallback = null;
    }

    private void cleanAllAudioFilePlayer() {
        for (ThunderAudioFilePlayer audioFilePlayer : this.mAudioFilePlayerSet) {
            audioFilePlayer.destroyAudioFilePlayer();
        }
        this.mAudioFilePlayerSet.clear();
    }

    public int startLastmileProbeTest(ThunderLastmileProbeConfig config) {
        return ThunderNative.startLastmileProbeTest(config);
    }

    public int stopLastmileProbeTest() {
        return ThunderNative.stopLastmileProbeTest();
    }

    public int startAudioEchoTest(int intervalInSeconds, IThunderAudioEchoTestHandler handler) {
        int ret = ThunderNative.startAudioEchoTest(intervalInSeconds);
        if (ret == 0) {
            mThunderAudioEchoTestHandler = handler;
        }
        return ret;
    }

    public int stopAudioEchoTest() {
        return ThunderNative.stopAudioEchoTest();
    }

    public int setRemoteVideoStreamLastFrameMode(int lastFrameMode) {
        return ThunderNative.setRemoteVideoStreamLastFrameMode(lastFrameMode);
    }

    public ArrayList<ThunderRoomAudioLevel> getAllAudioLevels() {
        ThunderRoomAudioLevel[] roomAudioLevel = ThunderNative.getAllAudioLevels();
        ArrayList<ThunderRoomAudioLevel> list = new ArrayList<>();
        if (roomAudioLevel == null) {
            return null;
        }
        for (ThunderRoomAudioLevel add : roomAudioLevel) {
            list.add(add);
        }
        return list;
    }

    public int enableUserList(boolean enabled) {
        return ThunderNative.enableUserList(enabled);
    }

    public int setUserName(String userName) {
        return ThunderNative.setUserName(userName);
    }

    public ThunderRoomUserInfo[] getRoomUserList() {
        return ThunderNative.getRoomUserList();
    }

    public int kickOffUser(String uid) {
        return ThunderNative.kickOffUser(uid);
    }

    public int setRoomModeDetail(ThunderRoomModeDetailValue detailValue) {
        if (detailValue != null) {
            return ThunderNative.setRoomModeDetail(detailValue);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRoomModeDetail null");
        return -13;
    }

    public int enableChorus(boolean enabled, String musicLabel) {
        return ThunderNative.enableChorus(enabled, musicLabel);
    }

    public int enableKtvExtraData(boolean enabled, String extraData, boolean bSetOffset) {
        return ThunderNative.enableKtvExtraData(enabled, extraData, bSetOffset);
    }

    public int setLowLatencyUsers(Set<String> users) {
        return ThunderNative.setLowLatencyUsers(users);
    }

    public ThunderLowLatencyStatus getLowLatencyStatus(String uid) {
        if (uid != null && !uid.isEmpty()) {
            return ThunderNative.getLowLatencyStatus(uid);
        }
        ThunderLog.error(ThunderLog.kLogTagRtcEngine, "getLowLatencyStatus uid invalid");
        return null;
    }

    private String getPrintString(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    public static synchronized int setDnsResolveCallback(IThunderDnsHostResolveCallback callback) {
        int dnsHostResolveCallback;
        synchronized (ThunderEngine.class) {
            dnsHostResolveCallback = Preference.setDnsHostResolveCallback(callback);
        }
        return dnsHostResolveCallback;
    }
}
