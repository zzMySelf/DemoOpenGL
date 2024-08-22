package com.baidu.mms.voicesearch.voice.view.guideresource;

import android.text.TextUtils;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.guidewordsview.horizontalview.GuideWordsBean;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.guidewordsview.horizontalview.GuideWordsDateManager;
import com.baidu.mms.voicesearch.voice.bean.dao.AssistantSugBean;
import com.baidu.mms.voicesearch.voice.requests.MMSVoiceRequestManager;
import com.baidu.mms.voicesearch.voice.utils.GlobalConstant;
import com.baidu.searchbox.hissug.data.model.SearchHistory;
import com.baidu.voicesearch.component.net.VoiceRequestCallback;
import com.baidu.voicesearch.component.utils.NormalTask;
import com.baidu.voicesearch.component.utils.StatisticConstants;
import com.baidu.voicesearch.component.utils.TaskDispatcher;
import com.baidu.voicesearch.component.utils.VoiceParamManager;
import com.baidu.voicesearch.component.vglog.VgLogManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceView$initData$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideResourceView.kt */
public final class GuideResourceView$initData$1 extends NormalTask {
    final /* synthetic */ ArrayList<SearchHistory> $hisList;
    final /* synthetic */ ArrayList<AssistantSugBean.SugItemBean> $hotList;
    final /* synthetic */ GuideResourceView this$0;

    GuideResourceView$initData$1(GuideResourceView $receiver, ArrayList<SearchHistory> $hisList2, ArrayList<AssistantSugBean.SugItemBean> $hotList2) {
        this.this$0 = $receiver;
        this.$hisList = $hisList2;
        this.$hotList = $hotList2;
    }

    public boolean doTask() {
        try {
            ArrayList topSugList = GuideWordsDateManager.getInstance().getTopSugList();
            if (topSugList != null && topSugList.size() > 0) {
                int size = topSugList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    GuideResourceDataBean item = new GuideResourceDataBean();
                    item.setWordsItem(topSugList.get(i2));
                    item.setType(1);
                    this.this$0.guideResourceList.add(item);
                    GuideWordsBean.WordsItemBean wordsItem = item.getWordsItem();
                    if (!TextUtils.isEmpty(wordsItem != null ? wordsItem.show_cb : null)) {
                        MMSVoiceRequestManager instance = MMSVoiceRequestManager.getInstance();
                        GuideWordsBean.WordsItemBean wordsItem2 = item.getWordsItem();
                        instance.uploadInfoToServer(wordsItem2 != null ? wordsItem2.show_cb : null, (VoiceRequestCallback) null);
                    }
                }
                VgLogManager.getInstance().addLog(StatisticConstants.FC1402, StatisticConstants.TOP_SUG_SHOW, VoiceParamManager.getInstance().getImeCommonParams());
            }
            GuideResourceView guideResourceView = this.this$0;
            guideResourceView.canShowHis = guideResourceView.canShowHistory();
            ArrayList<SearchHistory> arrayList = this.$hisList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator iterator = this.$hisList.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "hisList.iterator()");
                while (true) {
                    boolean z = false;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    SearchHistory temp = iterator.next();
                    Intrinsics.checkNotNullExpressionValue(temp, "iterator.next()");
                    if (temp.getType() == 2001) {
                        z = true;
                    }
                    if (z) {
                        iterator.remove();
                    }
                }
                int maxHisCount = this.this$0.immersionMaxHis;
                ArrayList<SearchHistory> arrayList2 = this.$hisList;
                GuideResourceView guideResourceView2 = this.this$0;
                GuideResourceView$initData$1 guideResourceView$initData$1 = this;
                int coerceAtMost = RangesKt.coerceAtMost(maxHisCount, arrayList2.size());
                for (int i3 = 0; i3 < coerceAtMost; i3++) {
                    GuideResourceDataBean item2 = new GuideResourceDataBean();
                    item2.setHistoryItem(arrayList2.get(i3));
                    item2.setCanDisplay(guideResourceView2.canShowHis);
                    guideResourceView2.guideResourceList.add(item2);
                }
                GuideResourceDataBean guideResourceDataBean = (GuideResourceDataBean) this.this$0.guideResourceList.get(this.this$0.guideResourceList.size() - 1);
                if ((guideResourceDataBean != null ? guideResourceDataBean.getHistoryItem() : null) != null && this.this$0.canShowHis) {
                    VgLogManager instance2 = VgLogManager.getInstance();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(GlobalConstant.isLogin ? 1 : 0);
                    String format = String.format(StatisticConstants.HIS_SHOW, Arrays.copyOf(objArr, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    instance2.addLog(StatisticConstants.FC1901, format, VoiceParamManager.getInstance().getImeCommonParams());
                }
            }
            ArrayList tempArray = new ArrayList();
            ArrayList<AssistantSugBean.SugItemBean> arrayList3 = this.$hotList;
            if (arrayList3 != null && arrayList3.size() > 0) {
                int size2 = this.$hotList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    GuideResourceDataBean item3 = new GuideResourceDataBean();
                    item3.setSugItem(this.$hotList.get(i4));
                    tempArray.add(item3);
                }
                JSONArray sugWords = new JSONArray();
                int size3 = this.$hotList.size();
                for (int index = 0; index < size3; index++) {
                    String sug = this.$hotList.get(index).query;
                    sugWords.put(sug == null ? "" : sug);
                }
                VgLogManager.getInstance().addLog(StatisticConstants.FC1502, "show_sugword&sugword=" + sugWords, VoiceParamManager.getInstance().getImeCommonParams());
            }
            ArrayList wordList = GuideWordsDateManager.getInstance().getNormalSugList();
            if (wordList != null && wordList.size() > 0) {
                int size4 = wordList.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    GuideResourceDataBean item4 = new GuideResourceDataBean();
                    item4.setWordsItem(wordList.get(i5));
                    tempArray.add(item4);
                    GuideWordsBean.WordsItemBean wordsItem3 = item4.getWordsItem();
                    if (!TextUtils.isEmpty(wordsItem3 != null ? wordsItem3.show_cb : null)) {
                        MMSVoiceRequestManager instance3 = MMSVoiceRequestManager.getInstance();
                        GuideWordsBean.WordsItemBean wordsItem4 = item4.getWordsItem();
                        instance3.uploadInfoToServer(wordsItem4 != null ? wordsItem4.show_cb : null, (VoiceRequestCallback) null);
                    }
                }
                VgLogManager.getInstance().addLog("0033", StatisticConstants.KEY_GUIDE_LABEL_SHOW, VoiceParamManager.getInstance().getImeCommonParams());
            }
            Collections.shuffle(tempArray);
            int size5 = tempArray.size();
            for (int i6 = 0; i6 < size5; i6++) {
                this.this$0.guideResourceList.add(tempArray.get(i6));
            }
        } catch (Exception e2) {
        }
        TaskDispatcher.getSharedInstance().addToMainLooper(new GuideResourceView$initData$1$doTask$2(this.this$0));
        return super.doTask();
    }
}
