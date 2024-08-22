package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController;
import com.baidu.mms.voicesearch.voice.bean.dao.VoiceAssistantBean;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.speechbundle.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001e2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010 J\b\u0010!\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010$\u001a\u00020\u001eJ\u0010\u0010%\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010(R\"\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/setting/VoiceAssistantSettingView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/baidu/mms/voicesearch/voice/bean/dao/VoiceAssistantBean;", "Lkotlin/collections/ArrayList;", "mDivider", "Landroid/view/View;", "mSwitchView", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/setting/VoiceAssistantSwitchView;", "mainTitle", "Landroid/widget/TextView;", "placeHolderUrl", "", "placeHolderUrlNight", "rootView", "subTitle", "voiceAssistantController", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/VoiceAssistantController;", "changeSkin", "", "initData", "", "initView", "onClick", "v", "onDestroy", "setOuterScrollView", "Landroid/widget/ScrollView;", "setOuterSlidView", "Landroid/widget/RelativeLayout;", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceAssistantSettingView.kt */
public final class VoiceAssistantSettingView extends LinearLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ArrayList<VoiceAssistantBean> dataList;
    private View mDivider;
    private VoiceAssistantSwitchView mSwitchView;
    private TextView mainTitle;
    private final String placeHolderUrl;
    private final String placeHolderUrlNight;
    private LinearLayout rootView;
    private TextView subTitle;
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

    public VoiceAssistantSettingView(Context context) {
        super(context);
        this.dataList = new ArrayList<>();
        this.placeHolderUrl = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_normal.png";
        this.placeHolderUrlNight = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_night.png";
        initView();
    }

    public VoiceAssistantSettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.dataList = new ArrayList<>();
        this.placeHolderUrl = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_normal.png";
        this.placeHolderUrlNight = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_night.png";
        initView();
    }

    public VoiceAssistantSettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.dataList = new ArrayList<>();
        this.placeHolderUrl = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_normal.png";
        this.placeHolderUrlNight = "https://mms-voice.cdn.bcebos.com/airesource/voicesetting/default_more_assistant_night.png";
        initView();
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.voice_assistant_setting_layout, this, true);
        this.mainTitle = (TextView) findViewById(R.id.voice_assistant_item_title);
        this.subTitle = (TextView) findViewById(R.id.voice_assistant_item_hint);
        this.mDivider = findViewById(R.id.voice_assistant_item_top_divider);
        this.rootView = (LinearLayout) findViewById(R.id.voice_assistant_item_root);
        this.voiceAssistantController = new VoiceAssistantController();
        changeSkin();
    }

    public final void changeSkin() {
        if (SkinManager.getInstance().isNightMode()) {
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setBackgroundColor(Color.parseColor("#303030"));
            }
            LinearLayout linearLayout = this.rootView;
            if (linearLayout != null) {
                linearLayout.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_night_selector_tab_background));
            }
            TextView textView = this.mainTitle;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#666666"));
            }
            TextView textView2 = this.subTitle;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#444444"));
            }
        } else {
            View view3 = this.mDivider;
            if (view3 != null) {
                view3.setBackgroundColor(Color.parseColor("#E6E6E6"));
            }
            LinearLayout linearLayout2 = this.rootView;
            if (linearLayout2 != null) {
                linearLayout2.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_selector_tab_background));
            }
            TextView textView3 = this.mainTitle;
            if (textView3 != null) {
                textView3.setTextColor(getContext().getResources().getColor(R.color.mms_voice_title_bar_text_color));
            }
            TextView textView4 = this.subTitle;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getResources().getColor(R.color.mms_voice_setting_page_subtitle_text_color));
            }
        }
        VoiceAssistantController voiceAssistantController2 = this.voiceAssistantController;
        if (voiceAssistantController2 != null) {
            voiceAssistantController2.changeSkin();
        }
    }

    public final void initData(List<VoiceAssistantBean> dataList2) {
        if (dataList2 == null || dataList2.isEmpty()) {
            TextView textView = this.mainTitle;
            if (textView != null) {
                textView.setText(getContext().getString(R.string.mms_voice_ai_assistant_main_title_exp));
            }
            TextView textView2 = this.subTitle;
            if (textView2 != null) {
                textView2.setText(getContext().getString(R.string.mms_voice_ai_assistant_sub_title_default));
                return;
            }
            return;
        }
        TextView textView3 = this.mainTitle;
        if (textView3 != null) {
            textView3.setText(getContext().getString(R.string.mms_voice_ai_assistant_main_title_exp));
        }
        TextView textView4 = this.subTitle;
        if (textView4 != null) {
            textView4.setText(getContext().getString(R.string.mms_voice_ai_assistant_sub_title_exp));
        }
        this.dataList.clear();
        this.dataList.addAll(dataList2);
        if (this.dataList.size() == 2) {
            VoiceAssistantBean placeHolderItem = new VoiceAssistantBean();
            placeHolderItem.setIconUrlNormal(this.placeHolderUrl);
            placeHolderItem.setIconUrlNight(this.placeHolderUrlNight);
            Context context = getContext();
            placeHolderItem.setMainTitle(context != null ? context.getString(R.string.assistant_place_holder_text) : null);
            placeHolderItem.setPlaceHolderItem(true);
            this.dataList.add(placeHolderItem);
        }
        if (this.dataList.size() >= 3) {
            VoiceAssistantSwitchView voiceAssistantSwitchView = new VoiceAssistantSwitchView(getContext());
            this.mSwitchView = voiceAssistantSwitchView;
            voiceAssistantSwitchView.setVoiceAssistantController(this.voiceAssistantController);
            int mCurrentStatus = VoiceAssistantController.Companion.getVoiceAssistantType();
            VoiceAssistantSettingView voiceAssistantSettingView = this;
            int i2 = 0;
            int size = dataList2.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                VoiceAssistantBean voiceAssistantBean = dataList2.get(i2);
                if (voiceAssistantBean != null && voiceAssistantBean.getId() == mCurrentStatus) {
                    mCurrentStatus = i2;
                    break;
                }
                i2++;
            }
            VoiceAssistantSwitchView voiceAssistantSwitchView2 = this.mSwitchView;
            if (voiceAssistantSwitchView2 != null) {
                voiceAssistantSwitchView2.setInitIndex(mCurrentStatus);
            }
            VoiceAssistantSwitchView voiceAssistantSwitchView3 = this.mSwitchView;
            if (voiceAssistantSwitchView3 != null) {
                voiceAssistantSwitchView3.setData(this.dataList, 0);
            }
            LinearLayout.LayoutParams mSwitchViewLp = new LinearLayout.LayoutParams(-1, (int) Tools.dip2px(141.0f));
            mSwitchViewLp.bottomMargin = (int) Tools.dip2px(15.0f);
            LinearLayout linearLayout = this.rootView;
            if (linearLayout != null) {
                linearLayout.addView(this.mSwitchView, mSwitchViewLp);
            }
        }
    }

    public final void setOuterScrollView(ScrollView v) {
        VoiceAssistantSwitchView voiceAssistantSwitchView = this.mSwitchView;
        if (voiceAssistantSwitchView != null) {
            voiceAssistantSwitchView.setOuterScrollView(v);
        }
    }

    public final void setOuterSlidView(RelativeLayout v) {
        VoiceAssistantSwitchView voiceAssistantSwitchView = this.mSwitchView;
        if (voiceAssistantSwitchView != null) {
            voiceAssistantSwitchView.setOuterSlidView(v);
        }
    }

    public void onClick(View v) {
        if (v instanceof VoiceAssistantSettingItem) {
            VoiceAssistantSettingBaseItemView.setChecked$default((VoiceAssistantSettingBaseItemView) v, true, false, 2, (Object) null);
        }
    }

    public final void onDestroy() {
        VoiceAssistantController voiceAssistantController2 = this.voiceAssistantController;
        if (voiceAssistantController2 != null) {
            voiceAssistantController2.onDestroy();
        }
        this.voiceAssistantController = null;
        VoiceAssistantSwitchView voiceAssistantSwitchView = this.mSwitchView;
        if (voiceAssistantSwitchView != null) {
            voiceAssistantSwitchView.recycleView();
        }
    }
}
