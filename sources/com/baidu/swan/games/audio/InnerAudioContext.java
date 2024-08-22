package com.baidu.swan.games.audio;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.engine.IV8Engine;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.games.audio.player.AudioBufferManager;
import com.baidu.swan.games.audio.player.AudioPlayerManager;
import com.baidu.swan.games.binding.IV8FieldChanged;

public class InnerAudioContext extends EventTargetImpl implements AudioApi, IV8FieldChanged, AudioDispatchCallback {
    private static final String FIELD_AUTO_PLAY = "autoplay";
    private static final String FIELD_LOOP = "loop";
    private static final String FIELD_SRC = "src";
    private static final String FIELD_START_TIME = "startTime";
    private static final String FIELD_VOLUME = "volume";
    private static final String TAG = "Aigame AudioContext";
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;
    @V8JavascriptField
    public boolean loop;
    /* access modifiers changed from: private */
    public IV8Engine mEngine;
    /* access modifiers changed from: private */
    public AudioPlayer mPlayer;
    String mPlayerId;
    @V8JavascriptField
    public boolean obeyMuteSwitch = true;
    @V8JavascriptField
    public boolean paused = true;
    @V8JavascriptField
    public String src = "";
    @V8JavascriptField
    public float startTime;
    @V8JavascriptField
    public float volume = 1.0f;

    public InnerAudioContext(IV8Engine engine) {
        super(engine);
        this.mEngine = engine;
        createPlayer();
    }

    private void init() {
        if (this.mPlayer != null) {
            AudioStatusCallbackForV8 statusCallback = new AudioStatusCallbackForV8(this, AudioUtils.getCallbackJson());
            statusCallback.setDispatchCallback(this);
            this.mPlayer.setAudioStatusCallback(statusCallback);
        }
    }

    private void createPlayer() {
        String id = String.valueOf(AudioIdCreator.createAudioId());
        this.mPlayerId = id;
        this.mPlayer = getPlayer(id);
        init();
    }

    /* access modifiers changed from: private */
    public void prepare(final boolean fromDataBuffer) {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    if (!fromDataBuffer || InnerAudioContext.this.mPlayer.isUserPlay()) {
                        InnerAudioContext.this.mPlayer.openPlayer(AudioUtils.convertParams(InnerAudioContext.this));
                        if (InnerAudioContext.this.autoplay) {
                            InnerAudioContext.this.mPlayer.play();
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void play() {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    InnerAudioContext.this.mPlayer.play();
                }
            });
        }
    }

    @JavascriptInterface
    public void pause() {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    InnerAudioContext.this.mPlayer.pause();
                }
            });
        }
    }

    @JavascriptInterface
    public void seek(final float position) {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    InnerAudioContext.this.mPlayer.seekTo(position);
                }
            });
        }
    }

    @JavascriptInterface
    public void stop() {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    InnerAudioContext.this.mPlayer.stop();
                }
            });
        }
    }

    @JavascriptInterface
    public void destroy() {
        if (this.mPlayer != null) {
            AudioPlayerManager.getInstance().getAudioThreadHandler().post(new Runnable() {
                public void run() {
                    InnerAudioContext.this.mPlayer.release();
                }
            });
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer buffer) {
        AudioPlayerManager.getInstance().saveBuffer(buffer, new AudioBufferManager.SaveBufferCallback() {
            public void success(final String path) {
                InnerAudioContext.this.mEngine.runOnJSThread(new Runnable() {
                    public void run() {
                        InnerAudioContext.this.src = SwanAppController.getInstance().getSwanFilePaths().realPathToScheme(path);
                        if (SwanAppLibConfig.DEBUG) {
                            Log.d(InnerAudioContext.TAG, "prepare path: " + InnerAudioContext.this.src + " autoPlay: " + InnerAudioContext.this.autoplay + " class: " + toString());
                        }
                        InnerAudioContext.this.prepare(true);
                    }
                });
            }

            public void fail() {
            }
        });
    }

    public int getDuration() {
        AudioPlayer audioPlayer = this.mPlayer;
        if (audioPlayer != null) {
            return (int) audioPlayer.getDuration();
        }
        return 0;
    }

    public int getCurrentTime() {
        AudioPlayer audioPlayer = this.mPlayer;
        if (audioPlayer != null) {
            return audioPlayer.getCurrentPosition();
        }
        return 0;
    }

    public boolean isPaused() {
        AudioPlayer audioPlayer = this.mPlayer;
        if (audioPlayer == null) {
            return true;
        }
        audioPlayer.isPaused();
        return true;
    }

    public int getBuffered() {
        AudioPlayer audioPlayer = this.mPlayer;
        if (audioPlayer != null) {
            return audioPlayer.getBuffered();
        }
        return 0;
    }

    private static AudioPlayer getPlayer(String id) {
        return new AudioPlayer(id);
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String fieldName) {
        if (SwanAppLibConfig.DEBUG) {
            Log.d(TAG, fieldName);
        }
        char c2 = 65535;
        switch (fieldName.hashCode()) {
            case -2129294769:
                if (fieldName.equals("startTime")) {
                    c2 = 1;
                    break;
                }
                break;
            case -810883302:
                if (fieldName.equals("volume")) {
                    c2 = 2;
                    break;
                }
                break;
            case 114148:
                if (fieldName.equals("src")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3327652:
                if (fieldName.equals("loop")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1439562083:
                if (fieldName.equals("autoplay")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                updateConfig(AudioUtils.convertParams(this));
                return;
            case 2:
                if (AudioUtils.checkVolumeValue(this.volume)) {
                    updateConfig(AudioUtils.convertParams(this));
                    return;
                } else {
                    this.volume = this.mPlayer.getVolume();
                    return;
                }
            case 3:
                prepare(false);
                return;
            case 4:
                if (this.autoplay) {
                    play();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void updateConfig(AudioPlayerParams params) {
        this.mPlayer.update(params);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchCallback(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1522036513: goto L_0x0054;
                case 3443508: goto L_0x0049;
                case 3540994: goto L_0x003e;
                case 96651962: goto L_0x0034;
                case 96784904: goto L_0x002a;
                case 106440182: goto L_0x001f;
                case 550609668: goto L_0x0015;
                case 1762557398: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x005e
        L_0x000a:
            java.lang.String r0 = "timeupdate"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r1
            goto L_0x005f
        L_0x0015:
            java.lang.String r0 = "canplay"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x005f
        L_0x001f:
            java.lang.String r0 = "pause"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x005f
        L_0x002a:
            java.lang.String r0 = "error"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x005f
        L_0x0034:
            java.lang.String r0 = "ended"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x005f
        L_0x003e:
            java.lang.String r0 = "stop"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x005f
        L_0x0049:
            java.lang.String r0 = "play"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x005f
        L_0x0054:
            java.lang.String r0 = "buffered"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            r3 = 1000(0x3e8, double:4.94E-321)
            switch(r0) {
                case 0: goto L_0x008c;
                case 1: goto L_0x0074;
                case 2: goto L_0x0071;
                case 3: goto L_0x006e;
                case 4: goto L_0x006e;
                case 5: goto L_0x006e;
                case 6: goto L_0x006e;
                case 7: goto L_0x0065;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x0093
        L_0x0065:
            int r0 = r5.getDuration()
            long r0 = (long) r0
            long r0 = r0 / r3
            r5.duration = r0
            goto L_0x0093
        L_0x006e:
            r5.paused = r1
            goto L_0x0093
        L_0x0071:
            r5.paused = r2
            goto L_0x0093
        L_0x0074:
            if (r7 == 0) goto L_0x0093
            int r0 = r5.getDuration()
            long r0 = (long) r0
            long r0 = r0 / r3
            r5.duration = r0
            int r0 = r5.getCurrentTime()
            double r0 = (double) r0
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r0 = r0 / r2
            r5.currentTime = r0
            goto L_0x0093
        L_0x008c:
            int r0 = r5.getBuffered()
            r5.buffered = r0
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.games.audio.InnerAudioContext.dispatchCallback(java.lang.String, org.json.JSONObject):void");
    }
}
