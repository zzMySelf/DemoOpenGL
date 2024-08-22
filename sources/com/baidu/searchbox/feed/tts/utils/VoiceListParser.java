package com.baidu.searchbox.feed.tts.utils;

import android.text.TextUtils;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tts.TTSSpeakerEngine;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.data.bean.VoiceListBean;
import com.baidu.searchbox.feed.tts.db.contract.SpeakerConfigTable;
import com.baidu.searchbox.feed.tts.model.TTSSpeakerModel;
import com.baidu.searchbox.feed.tts.ui.delegates.FeedTtsPlayController;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceListParser {
    public VoiceListBean parseResponse(String response) {
        JSONObject codeObj;
        JSONObject itemListObj;
        int voiceNum;
        JSONArray starVoiceArray;
        if (TextUtils.isEmpty(response)) {
            return null;
        }
        VoiceListBean voiceListBean = new VoiceListBean();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject dataJsonObj = jsonObject.optJSONObject("data");
            if (dataJsonObj == null || (codeObj = dataJsonObj.optJSONObject(TTSRequester.CMD_PERSONAL_STAR_VOICES)) == null) {
                return voiceListBean;
            }
            voiceListBean.voiceMd5 = codeObj.optString("voice_md5");
            String oldMd5 = FeedTTSPreferenceUtil.getString(TTSSpeakerEngine.KEY_TTS_VOICE_LIST_MD5, "");
            if (TextUtils.equals(voiceListBean.voiceMd5, oldMd5)) {
                return voiceListBean;
            }
            voiceListBean.personalVoiceCmd = codeObj.optString("title_cmd");
            voiceListBean.personalVoiceSwitch = codeObj.optString("is_person_turn");
            voiceListBean.starTransitionThreshold = codeObj.optInt("star_transition_threshold", -1);
            JSONObject itemListObj2 = codeObj.optJSONObject("voice_item");
            if (itemListObj2 == null) {
                return voiceListBean;
            }
            if ("1".equals(voiceListBean.personalVoiceSwitch)) {
                JSONArray personalVoiceArray = itemListObj2.optJSONArray("personal_voices");
                if (personalVoiceArray != null) {
                    int voiceNum2 = personalVoiceArray.length();
                    JSONObject jSONObject = jsonObject;
                    voiceListBean.personalVoiceList = new ArrayList(voiceNum2);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= voiceNum2) {
                            JSONObject jSONObject2 = codeObj;
                            String str = oldMd5;
                            break;
                        }
                        JSONObject voiceObj = personalVoiceArray.optJSONObject(i2);
                        if (voiceObj == null) {
                            JSONObject jSONObject3 = dataJsonObj;
                            JSONObject jSONObject4 = codeObj;
                            String str2 = oldMd5;
                            break;
                        }
                        JSONObject dataJsonObj2 = dataJsonObj;
                        JSONObject codeObj2 = codeObj;
                        TTSSpeakerModel personalVoice = new TTSSpeakerModel();
                        personalVoice.speakerId = voiceObj.optString("mid");
                        personalVoice.displayIndex = voiceObj.optInt("display_index");
                        personalVoice.displayName = voiceObj.optString("display_name");
                        personalVoice.onlineId = voiceObj.optInt(SpeakerConfigTable.ONLINE_ID);
                        personalVoice.onlinePid = voiceObj.optString(SpeakerConfigTable.ONLINE_PID, "0");
                        personalVoice.modelName = personalVoice.speakerId;
                        personalVoice.imgUrl = voiceObj.optString("cover_img");
                        personalVoice.tryCmd = voiceObj.optString("try_cmd");
                        personalVoice.type = 1;
                        personalVoice.personalOnly = new TTSSpeakerModel.PersonalOnly();
                        personalVoice.personalOnly.produceStatus = voiceObj.optInt("produce_status");
                        personalVoice.personalOnly.downloadUrl = voiceObj.optString("voice_url");
                        personalVoice.personalOnly.modelSize = voiceObj.optString("size");
                        personalVoice.personalOnly.remainTime = voiceObj.optInt("remain_time");
                        personalVoice.personalOnly.modelMd5 = voiceObj.optString("md5");
                        voiceListBean.personalVoiceList.add(personalVoice);
                        TTSRuntime.getInstance().replaceTTSSpeakerConfig(personalVoice);
                        i2++;
                        String str3 = response;
                        dataJsonObj = dataJsonObj2;
                        oldMd5 = oldMd5;
                        codeObj = codeObj2;
                    }
                } else {
                    JSONObject jSONObject5 = dataJsonObj;
                    JSONObject jSONObject6 = codeObj;
                    String str4 = oldMd5;
                }
            } else {
                JSONObject jSONObject7 = dataJsonObj;
                JSONObject jSONObject8 = codeObj;
                String str5 = oldMd5;
            }
            JSONArray starVoiceArray2 = itemListObj2.optJSONArray("star_voices");
            if (starVoiceArray2 != null) {
                int voiceNum3 = starVoiceArray2.length();
                voiceListBean.starVoiceList = new ArrayList(voiceNum3);
                int i3 = 0;
                while (true) {
                    if (i3 >= voiceNum3) {
                        int i4 = voiceNum3;
                        JSONObject jSONObject9 = itemListObj2;
                        break;
                    }
                    JSONObject voiceObj2 = starVoiceArray2.optJSONObject(i3);
                    if (voiceObj2 == null) {
                        JSONArray jSONArray = starVoiceArray2;
                        JSONObject jSONObject10 = itemListObj2;
                        break;
                    }
                    TTSSpeakerModel starVoice = new TTSSpeakerModel();
                    starVoice.speakerId = voiceObj2.optString(SpeakerConfigTable.SPEAKER_ID);
                    starVoice.displayIndex = voiceObj2.optInt("display_index");
                    starVoice.displayName = voiceObj2.optString("display_name");
                    starVoice.onlineId = voiceObj2.optInt(SpeakerConfigTable.ONLINE_ID);
                    starVoice.onlinePid = voiceObj2.optString(SpeakerConfigTable.ONLINE_PID, "0");
                    starVoice.modelName = voiceObj2.optString(SpeakerConfigTable.MODEL_NAME);
                    starVoice.imgUrl = voiceObj2.optString("cover_img");
                    starVoice.tryCmd = voiceObj2.optString("try_cmd");
                    starVoice.type = 2;
                    starVoice.starOnly = new TTSSpeakerModel.StarOnly();
                    starVoice.starOnly.prologue = voiceObj2.optString("prologue");
                    JSONArray transitionArray = voiceObj2.optJSONArray("transition_words");
                    if (transitionArray != null) {
                        int transitionNum = transitionArray.length();
                        starVoiceArray = starVoiceArray2;
                        voiceNum = voiceNum3;
                        starVoice.starOnly.transitionList = new ArrayList(transitionNum);
                        int j2 = 0;
                        while (j2 < transitionNum) {
                            starVoice.starOnly.transitionList.add(transitionArray.optString(j2));
                            j2++;
                            itemListObj2 = itemListObj2;
                        }
                        itemListObj = itemListObj2;
                        FeedTTSPreferenceUtil.removeKey(FeedTtsPlayController.KEY_PREFIX_STAR_TRANSITION_NEXT_INDEX + starVoice.speakerId);
                    } else {
                        starVoiceArray = starVoiceArray2;
                        voiceNum = voiceNum3;
                        itemListObj = itemListObj2;
                    }
                    JSONArray speeds = voiceObj2.optJSONArray("speed");
                    if (speeds != null) {
                        OnLineLog.get(OnLineLog.TAG_TTS).d("voiceListparser :" + speeds);
                        int len = speeds.length();
                        int[] svs = new int[len];
                        for (int si = 0; si < len; si++) {
                            svs[si] = speeds.optInt(si);
                        }
                        starVoice.speedValues = svs;
                        JSONArray jSONArray2 = speeds;
                        int i5 = len;
                        TTSSpeakerEngine.getInstance().saveSpeakerSpeed(starVoice.speakerId, starVoice.onlinePid, svs);
                    }
                    voiceListBean.starVoiceList.add(starVoice);
                    TTSRuntime.getInstance().replaceTTSSpeakerConfig(starVoice);
                    i3++;
                    starVoiceArray2 = starVoiceArray;
                    voiceNum3 = voiceNum;
                    itemListObj2 = itemListObj;
                }
            } else {
                JSONObject jSONObject11 = itemListObj2;
            }
            return voiceListBean;
        } catch (JSONException e2) {
            if (!TTSRuntime.DEBUG) {
                return voiceListBean;
            }
            throw new RuntimeException(e2);
        }
    }
}
