package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCAudioSamples;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import java.nio.ByteBuffer;

public abstract class RTCRoomProvider {

    public enum CyberRtcLiveTransferMode {
        RTC_LIVE_TRANSFER_MODE_ANCHOR_TRANSMISSION,
        RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION
    }

    public interface CyberRtcRoomDelegate {
        void onEngineStatisticsInfo(int i2);

        void onErrorInfoUpdate(int i2);

        void onPeerConnectStateUpdate(int i2);

        void onRoomDataMessage(ByteBuffer byteBuffer);

        void onRoomEventUpdate(int i2, long j2, String str);

        void onStreamInfoUpdate(String[] strArr);
    }

    public static class CyberRtcRoomVideoDimension {
        public int videoHeight;
        public int videoRotation;
        public int videoWidth;
    }

    public enum CyberRtcSoundMode {
        RTC_SOUND_MODE_SPEAKER,
        RTC_SOUND_MODE_EAR
    }

    public abstract void changeSurfaceSize(long j2, int i2, int i3);

    public abstract boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, CyberRtcLiveTransferMode cyberRtcLiveTransferMode);

    public abstract void destroy();

    public abstract void destroyExternalSurface(long j2, Surface surface);

    public abstract void disbandRoom();

    public abstract void enableAgc(boolean z);

    public abstract void enableAns(boolean z);

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract void enableStatsToServer(boolean z, String str);

    public abstract CyberRtcRoomAudioLevel[] getRemoteAudioLevels();

    public abstract CyberRtcRoomVideoDimension getRemoteVideoDimension(long j2);

    public abstract void getUserAttribute(long j2);

    public abstract CyberRtcRoomUserInfo[] getUserListOfRoom();

    public abstract boolean initWithAppID(Context context, String str, String str2, String str3, boolean z);

    public abstract void kickOffUserWithID(long j2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteCamera(boolean z);

    public abstract void muteMicphone(boolean z);

    public abstract void presetLoudSpeaker(boolean z);

    public abstract void publishStreaming();

    public abstract void sendMessageToUser(String str, long j2);

    public abstract void setAudioRecordDelegate(CyberRTCAudioSamples.CyberRTCSamplesReadyCallback cyberRTCSamplesReadyCallback);

    public abstract void setCyberRTCRoomDelegate(CyberRtcRoomDelegate cyberRtcRoomDelegate);

    public abstract void setExternalSurface(long j2, Surface surface);

    public abstract void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType);

    public abstract void setRemoteAudioPlayState(boolean z, long j2);

    public abstract void setRemoteDisplay(CyberRTCVideoView cyberRTCVideoView);

    public abstract void setRemoteVideoPlayState(boolean z, long j2);

    public abstract void setSoundMod(CyberRtcSoundMode cyberRtcSoundMode);

    public abstract void setUserAttribute(String str);

    public abstract void shutUpUserWithID(long j2);

    public abstract void shutUpUserWithID(long j2, boolean z);

    public abstract void startPublish();

    public abstract void stopPublish();

    public abstract void stopSubscribeStreaming(long j2);

    public abstract void subscribeStreaming(int i2, long j2);

    public abstract void switchCamera();

    public static class CyberRtcRoomUserInfo {
        public String attribute;
        public int role;
        public long userID;
        public String userName;

        public CyberRtcRoomUserInfo(long userID2, String userName2, String attribute2, int role2) {
            this.userID = userID2;
            this.userName = userName2;
            this.attribute = attribute2;
            this.role = role2;
        }
    }

    public static class CyberRtcRoomAudioLevel {
        public String nicName;
        public long userID;
        public int volumeLevel;

        public CyberRtcRoomAudioLevel(long userID2, String nicName2, int volumeLevel2) {
            this.userID = userID2;
            this.nicName = nicName2;
            this.volumeLevel = volumeLevel2;
        }
    }
}
