package com.baidu.searchbox.tts.nps;

import com.baidu.searchbox.tts.SpeakActionListener;
import com.baidu.searchbox.tts.SpeechSynthesizerListener;
import com.baidu.searchbox.tts.nps.NPSReport;
import com.baidu.tts.plugin.api.IPreLoadEntityPlugin;
import com.baidu.tts.plugin.api.IPreLoadEventPlugin;
import com.baidu.tts.plugin.api.ISpeechSynthesizerListener;

public class NPSSpeechSynthesizerListener implements ISpeechSynthesizerListener {
    private SpeakActionListener actionListener;
    private String source;
    private SpeechSynthesizerListener synthesizerListener;

    @Deprecated
    public NPSSpeechSynthesizerListener(String source2, SpeechSynthesizerListener synthesizerListener2, SpeakActionListener actionListener2) {
        this.source = source2;
        this.synthesizerListener = synthesizerListener2;
        this.actionListener = actionListener2;
    }

    public void onSynthesizeStart(String utteranceId) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSynthesizeStart(utteranceId);
        }
        NPSReport.applySuccess("api", NPSReport.Action.SPEECH_SYNTHESIZER, this.source, String.format("onSynthesizeStart(%s)", new Object[]{utteranceId}));
    }

    public void onSynthesizeDataArrived(String utteranceId, byte[] audioData, int progress, int engineType) {
        SpeakActionListener speakActionListener = this.actionListener;
        if (speakActionListener != null) {
            speakActionListener.onSynthesizeDataArrived(utteranceId, progress, engineType);
        }
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSynthesizeDataArrived(utteranceId, progress);
        }
    }

    public void onSynthesizeFinish(String utteranceId) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSynthesizeFinish(utteranceId);
        }
        NPSReport.applySuccess("api", NPSReport.Action.SPEECH_SYNTHESIZER, this.source, String.format("onSynthesizeFinish(%s)", new Object[]{utteranceId}));
    }

    public void onSpeechStart(String utteranceId) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSpeechStart(utteranceId);
        }
        NPSReport.applySuccess("api", NPSReport.Action.SPEECH_SYNTHESIZER, this.source, String.format("onSpeechStart(%s)", new Object[]{utteranceId}));
    }

    public void onSpeechProgressChanged(String utteranceId, int progress) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSpeechProgressChanged(utteranceId, progress);
        }
    }

    public void onSpeechFinish(String utteranceId) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onSpeechFinish(utteranceId);
        }
        NPSReport.applySuccess("api", NPSReport.Action.SPEECH_SYNTHESIZER, this.source, String.format("onSpeechFinish(%s)", new Object[]{utteranceId}));
    }

    public void onError(String utteranceId, int errno, String msg) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onError(utteranceId, errno, msg);
        }
        NPSReport.applyFail("api", NPSReport.Action.SPEECH_SYNTHESIZER, (Throwable) null, this.source, String.format("onError(%s %s %s)", new Object[]{utteranceId, Integer.valueOf(errno), msg}));
    }

    public void onLipDataArrived(String utteranceId, String lipData) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onLipDataArrived(utteranceId, lipData);
        }
        NPSReport.applySuccess("api", NPSReport.Action.SPEECH_SYNTHESIZER, this.source, String.format("onLipDataArrived(%s %s)", new Object[]{utteranceId, lipData}));
    }

    public void onPreLoadEvent(IPreLoadEventPlugin preloadEvent) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onPreloadEvent(preloadEvent);
        }
    }

    public void onNext(IPreLoadEntityPlugin preloadEntity) {
        SpeechSynthesizerListener speechSynthesizerListener = this.synthesizerListener;
        if (speechSynthesizerListener != null) {
            speechSynthesizerListener.onPreloadNext(preloadEntity);
        }
    }
}
