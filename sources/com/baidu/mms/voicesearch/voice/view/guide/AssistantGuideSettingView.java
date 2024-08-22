package com.baidu.mms.voicesearch.voice.view.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting.VoiceAssistantSettingBaseItemView;
import com.baidu.mms.voicesearch.voice.bean.dao.VoiceAssistantBean;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.view.guide.AssistantGuideItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0015\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001cJ \u0010\u001a\u001a\u00020\u00192\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0019H\u0002J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010$\u001a\u00020\u0019R\"\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00140\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0014`\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideSettingView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/baidu/mms/voicesearch/voice/bean/dao/VoiceAssistantBean;", "Lkotlin/collections/ArrayList;", "mSwitchView", "Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideSwitchView;", "viewMap", "Ljava/util/HashMap;", "Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideItemView;", "Lkotlin/collections/HashMap;", "voiceAssistantController", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/VoiceAssistantController;", "changeSkin", "", "initData", "id", "(Ljava/lang/Integer;)V", "", "itemCheckedCallBack", "Lcom/baidu/mms/voicesearch/voice/view/guide/AssistantGuideItemView$AssistantCheckedCallBack;", "initView", "onClick", "v", "Landroid/view/View;", "onDestroy", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantGuideSettingView.kt */
public final class AssistantGuideSettingView extends LinearLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ArrayList<VoiceAssistantBean> dataList;
    private AssistantGuideSwitchView mSwitchView;
    private HashMap<Integer, AssistantGuideItemView> viewMap;
    private VoiceAssistantController voiceAssistantController;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public AssistantGuideSettingView(Context context) {
        super(context);
        this.dataList = new ArrayList<>();
        this.viewMap = new HashMap<>();
        initView();
    }

    public AssistantGuideSettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.dataList = new ArrayList<>();
        this.viewMap = new HashMap<>();
        initView();
    }

    public AssistantGuideSettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.dataList = new ArrayList<>();
        this.viewMap = new HashMap<>();
        initView();
    }

    private final void initView() {
        this.voiceAssistantController = new VoiceAssistantController();
        changeSkin();
    }

    public final void changeSkin() {
        VoiceAssistantController voiceAssistantController2 = this.voiceAssistantController;
        if (voiceAssistantController2 != null) {
            voiceAssistantController2.changeSkin();
        }
    }

    public final void initData(List<VoiceAssistantBean> dataList2, AssistantGuideItemView.AssistantCheckedCallBack itemCheckedCallBack) {
        Map<Integer, AssistantGuideItemView> map;
        List<VoiceAssistantBean> list = dataList2;
        AssistantGuideItemView.AssistantCheckedCallBack assistantCheckedCallBack = itemCheckedCallBack;
        Intrinsics.checkNotNullParameter(assistantCheckedCallBack, "itemCheckedCallBack");
        if (list != null && !dataList2.isEmpty()) {
            this.viewMap.clear();
            this.dataList.clear();
            this.dataList.addAll(list);
            if (dataList2.size() == 2) {
                LinearLayout container = new LinearLayout(getContext());
                container.setOrientation(0);
                LinearLayout.LayoutParams containerLp = new LinearLayout.LayoutParams(-1, -2);
                AssistantGuideItemView childView1 = new AssistantGuideItemView(getContext());
                LinearLayout.LayoutParams childView1Lp = new LinearLayout.LayoutParams(0, (int) Tools.dip2px(67.0f));
                childView1Lp.weight = 1.0f;
                Space spaceGap = new Space(getContext());
                LinearLayout.LayoutParams spaceGapLp = new LinearLayout.LayoutParams((int) Tools.dip2px(7.0f), -1);
                AssistantGuideItemView childView2 = new AssistantGuideItemView(getContext());
                LinearLayout.LayoutParams childView2Lp = new LinearLayout.LayoutParams(0, (int) Tools.dip2px(67.0f));
                childView2Lp.weight = 1.0f;
                container.addView(childView1, childView1Lp);
                container.addView(spaceGap, spaceGapLp);
                container.addView(childView2, childView2Lp);
                childView1.setOnClickListener(this);
                childView2.setOnClickListener(this);
                childView1.setAssistantCheckedCallBack(assistantCheckedCallBack);
                childView2.setAssistantCheckedCallBack(assistantCheckedCallBack);
                VoiceAssistantController voiceAssistantController2 = this.voiceAssistantController;
                if (voiceAssistantController2 != null) {
                    voiceAssistantController2.addToObserver(childView1);
                }
                VoiceAssistantController voiceAssistantController3 = this.voiceAssistantController;
                if (voiceAssistantController3 != null) {
                    voiceAssistantController3.addToObserver(childView2);
                }
                childView1.setVoiceAssistantController(this.voiceAssistantController);
                childView2.setVoiceAssistantController(this.voiceAssistantController);
                childView1.initData(list.get(0));
                childView2.initData(list.get(1));
                Map map2 = this.viewMap;
                VoiceAssistantBean voiceAssistantBean = list.get(0);
                map2.put(voiceAssistantBean != null ? Integer.valueOf(voiceAssistantBean.getId()) : null, childView1);
                Map map3 = this.viewMap;
                VoiceAssistantBean voiceAssistantBean2 = list.get(1);
                map3.put(voiceAssistantBean2 != null ? Integer.valueOf(voiceAssistantBean2.getId()) : null, childView2);
                addView(container, containerLp);
            } else if (dataList2.size() == 3) {
                LinearLayout container2 = new LinearLayout(getContext());
                container2.setOrientation(0);
                LinearLayout.LayoutParams containerLp2 = new LinearLayout.LayoutParams(-1, -2);
                AssistantGuideItemView childView12 = new AssistantGuideItemView(getContext());
                LinearLayout.LayoutParams childView1Lp2 = new LinearLayout.LayoutParams(0, (int) Tools.dip2px(67.0f));
                childView1Lp2.weight = 1.0f;
                Space spaceGap1 = new Space(getContext());
                LinearLayout.LayoutParams spaceGapLp1 = new LinearLayout.LayoutParams((int) Tools.dip2px(7.0f), -1);
                AssistantGuideItemView childView22 = new AssistantGuideItemView(getContext());
                LinearLayout.LayoutParams childView2Lp2 = new LinearLayout.LayoutParams(0, (int) Tools.dip2px(67.0f));
                childView2Lp2.weight = 1.0f;
                Space spaceGap2 = new Space(getContext());
                LinearLayout.LayoutParams spaceGapLp2 = new LinearLayout.LayoutParams((int) Tools.dip2px(7.0f), -1);
                AssistantGuideItemView childView3 = new AssistantGuideItemView(getContext());
                LinearLayout.LayoutParams containerLp3 = containerLp2;
                LinearLayout.LayoutParams childView3Lp = new LinearLayout.LayoutParams(0, (int) Tools.dip2px(67.0f));
                childView3Lp.weight = 1.0f;
                container2.addView(childView12, childView1Lp2);
                container2.addView(spaceGap1, spaceGapLp1);
                container2.addView(childView22, childView2Lp2);
                container2.addView(spaceGap2, spaceGapLp2);
                container2.addView(childView3, childView3Lp);
                childView12.setOnClickListener(this);
                childView22.setOnClickListener(this);
                childView3.setOnClickListener(this);
                childView12.setAssistantCheckedCallBack(assistantCheckedCallBack);
                childView22.setAssistantCheckedCallBack(assistantCheckedCallBack);
                childView3.setAssistantCheckedCallBack(assistantCheckedCallBack);
                VoiceAssistantController voiceAssistantController4 = this.voiceAssistantController;
                if (voiceAssistantController4 != null) {
                    voiceAssistantController4.addToObserver(childView12);
                }
                VoiceAssistantController voiceAssistantController5 = this.voiceAssistantController;
                if (voiceAssistantController5 != null) {
                    voiceAssistantController5.addToObserver(childView22);
                }
                VoiceAssistantController voiceAssistantController6 = this.voiceAssistantController;
                if (voiceAssistantController6 != null) {
                    voiceAssistantController6.addToObserver(childView3);
                }
                childView12.setVoiceAssistantController(this.voiceAssistantController);
                childView22.setVoiceAssistantController(this.voiceAssistantController);
                childView3.setVoiceAssistantController(this.voiceAssistantController);
                childView12.initData(list.get(0));
                childView22.initData(list.get(1));
                childView3.initData(list.get(2));
                Map map4 = this.viewMap;
                VoiceAssistantBean voiceAssistantBean3 = list.get(0);
                map4.put(voiceAssistantBean3 != null ? Integer.valueOf(voiceAssistantBean3.getId()) : null, childView12);
                Map map5 = this.viewMap;
                VoiceAssistantBean voiceAssistantBean4 = list.get(1);
                map5.put(voiceAssistantBean4 != null ? Integer.valueOf(voiceAssistantBean4.getId()) : null, childView22);
                Map map6 = this.viewMap;
                VoiceAssistantBean voiceAssistantBean5 = list.get(2);
                map6.put(voiceAssistantBean5 != null ? Integer.valueOf(voiceAssistantBean5.getId()) : null, childView3);
                addView(container2, containerLp3);
            } else if (dataList2.size() > 3) {
                AssistantGuideSwitchView assistantGuideSwitchView = new AssistantGuideSwitchView(getContext());
                this.mSwitchView = assistantGuideSwitchView;
                assistantGuideSwitchView.setVoiceAssistantController(this.voiceAssistantController);
                int mCurrentStatus = 1;
                AssistantGuideSettingView assistantGuideSettingView = this;
                int i2 = 0;
                int size = dataList2.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    VoiceAssistantBean voiceAssistantBean6 = list.get(i2);
                    if (voiceAssistantBean6 != null && voiceAssistantBean6.getId() == 1) {
                        mCurrentStatus = i2;
                        break;
                    }
                    i2++;
                }
                AssistantGuideSwitchView assistantGuideSwitchView2 = this.mSwitchView;
                if (assistantGuideSwitchView2 != null) {
                    assistantGuideSwitchView2.setInitIndex(mCurrentStatus);
                }
                AssistantGuideSwitchView assistantGuideSwitchView3 = this.mSwitchView;
                if (assistantGuideSwitchView3 != null) {
                    assistantGuideSwitchView3.setAssistantCheckedCallBack(assistantCheckedCallBack);
                }
                AssistantGuideSwitchView assistantGuideSwitchView4 = this.mSwitchView;
                if (assistantGuideSwitchView4 != null) {
                    assistantGuideSwitchView4.setData(list, 0);
                }
                LinearLayout.LayoutParams mSwitchViewLp = new LinearLayout.LayoutParams(-1, (int) Tools.dip2px(67.0f));
                HashMap<Integer, AssistantGuideItemView> hashMap = this.viewMap;
                AssistantGuideSwitchView assistantGuideSwitchView5 = this.mSwitchView;
                if (assistantGuideSwitchView5 == null || (map = assistantGuideSwitchView5.getViewMap()) == null) {
                    map = new HashMap<>();
                }
                hashMap.putAll(map);
                addView(this.mSwitchView, mSwitchViewLp);
            }
        }
    }

    public final void initData(Integer id) {
        AssistantGuideItemView assistantGuideItemView;
        if (id != null && (assistantGuideItemView = this.viewMap.get(id)) != null) {
            assistantGuideItemView.startDownloadRes();
        }
    }

    public void onClick(View v) {
        if (v instanceof AssistantGuideItemView) {
            VoiceAssistantSettingBaseItemView.setChecked$default((VoiceAssistantSettingBaseItemView) v, true, false, 2, (Object) null);
        }
    }

    public final void onDestroy() {
        VoiceAssistantController voiceAssistantController2 = this.voiceAssistantController;
        if (voiceAssistantController2 != null) {
            voiceAssistantController2.onDestroy();
        }
        this.voiceAssistantController = null;
        AssistantGuideSwitchView assistantGuideSwitchView = this.mSwitchView;
        if (assistantGuideSwitchView != null) {
            assistantGuideSwitchView.recycleView();
        }
    }
}
