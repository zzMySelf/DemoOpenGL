package com.baidu.searchbox.feed.tts.debug;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.CustomItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.RadioDebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.debug.data.ViewFetcher;
import com.baidu.searchbox.download.center.clearcache.manualclean.TtsClearCacheKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.tts.TTSSwitchUtil;
import com.baidu.searchbox.feed.tts.commonstreams.StreamsFacade;
import com.baidu.searchbox.feed.tts.player.TtsEngineEvent;
import com.baidu.searchbox.feed.tts.player.TtsPlayer;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.purelisten.PureListenABTestUtilsKt;
import com.baidu.searchbox.tts.TtsPluginWrapper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0005YZ[\\]B\u0005¢\u0006\u0002\u0010\u0002J8\u00100\u001a\u0002012\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030 j\b\u0012\u0004\u0012\u000203`\"2\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002J(\u00108\u001a\u0002012\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030 j\b\u0012\u0004\u0012\u000203`\"2\u0006\u00109\u001a\u00020:H\u0002J8\u0010;\u001a\u0002012\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030 j\b\u0012\u0004\u0012\u000203`\"2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\tH\u0002J:\u0010?\u001a\u0002012\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030 j\b\u0012\u0004\u0012\u000203`\"2\b\u0010<\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u001cH\u0002J\"\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020\t0H2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0002J\u0010\u0010J\u001a\u00020&2\u0006\u0010=\u001a\u00020\u0004H\u0002J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u0002030\u0015H\u0016J\u0010\u0010L\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0004H\u0002J\b\u0010M\u001a\u00020\u0004H\u0016J\b\u0010N\u001a\u000207H\u0002J\b\u0010O\u001a\u000207H\u0002J\u0012\u0010P\u001a\u0002012\b\u0010Q\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\tH\u0002J\u0018\u0010V\u001a\u0002012\u0006\u0010I\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\tH\u0002J\b\u0010X\u001a\u000201H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006^"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "TAG", "", "cycleAction", "com/baidu/searchbox/feed/tts/debug/TTSConfigProvider$cycleAction$1", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$cycleAction$1;", "cycleListIndex", "", "getCycleListIndex", "()I", "setCycleListIndex", "(I)V", "cycleObj", "Ljava/lang/Object;", "getCycleObj", "()Ljava/lang/Object;", "setCycleObj", "(Ljava/lang/Object;)V", "listData", "", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;", "getListData", "()Ljava/util/List;", "setListData", "(Ljava/util/List;)V", "mInsertPlayListener", "Landroid/view/View$OnClickListener;", "mMinibarABListener", "mMusicCoreSetListener", "mSecondaryItemList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/debug/data/CheckItemInfo;", "Lkotlin/collections/ArrayList;", "mTTSAppendListener", "mTTSEndListener", "mTTSMainSwitchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mTTSPlayListener", "mTTSPluginParamSetListener", "mTTSPreFetchListener", "mTtsClearCacheListener", "singleFile", "getSingleFile", "()Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;", "setSingleFile", "(Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;)V", "addTTSCheckItem", "", "debugItemList", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "content", "checkedChangeListener", "isChecked", "", "addTTSCustomItem", "viewFetcher", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "addTTSEditItem", "title", "key", "defValue", "addTTSTextItem", "clickListener", "createInputLine", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "label", "inputTxt", "getBriefHomeInfo", "Lcom/baidu/searchbox/debug/data/RadioDebugItemInfo;", "switchKey", "getCheckedChangeListener", "getChildItemList", "getDebugSwitch", "getGroupName", "getTTSMainSwitch", "getTTSUpdateRalSwitch", "playSingleStream", "fileItem", "saveStreamSP", "online", "offline", "playMode", "setDebugSwitch", "value", "showToast", "Callback", "FileItem", "StreamItemView", "StreamTtsAdapter", "StreamTtsVH", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TTSConfigProvider.kt */
public final class TTSConfigProvider extends DebugDataGroupProvider {
    /* access modifiers changed from: private */
    public final String TAG = "TTSDebugConfig";
    private final TTSConfigProvider$cycleAction$1 cycleAction = new TTSConfigProvider$cycleAction$1(this);
    private int cycleListIndex = -1;
    private Object cycleObj = new Object();
    private List<FileItem> listData;
    private final View.OnClickListener mInsertPlayListener = new TTSConfigProvider$$ExternalSyntheticLambda18(this);
    private final View.OnClickListener mMinibarABListener = new TTSConfigProvider$$ExternalSyntheticLambda4();
    private final View.OnClickListener mMusicCoreSetListener = new TTSConfigProvider$$ExternalSyntheticLambda2();
    private ArrayList<CheckItemInfo> mSecondaryItemList = new ArrayList<>();
    private final View.OnClickListener mTTSAppendListener = new TTSConfigProvider$$ExternalSyntheticLambda20();
    private final View.OnClickListener mTTSEndListener = new TTSConfigProvider$$ExternalSyntheticLambda21();
    private final CompoundButton.OnCheckedChangeListener mTTSMainSwitchListener = new TTSConfigProvider$$ExternalSyntheticLambda17(this);
    private final View.OnClickListener mTTSPlayListener = new TTSConfigProvider$$ExternalSyntheticLambda19(this);
    private final View.OnClickListener mTTSPluginParamSetListener = new TTSConfigProvider$$ExternalSyntheticLambda1(this);
    private final View.OnClickListener mTTSPreFetchListener = new TTSConfigProvider$$ExternalSyntheticLambda22();
    private final View.OnClickListener mTtsClearCacheListener = new TTSConfigProvider$$ExternalSyntheticLambda3();
    private FileItem singleFile;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$Callback;", "", "onItemClick", "", "fileItem", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSConfigProvider.kt */
    public interface Callback {
        void onItemClick(FileItem fileItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSMainSwitchListener$lambda-0  reason: not valid java name */
    public static final void m19634mTTSMainSwitchListener$lambda0(TTSConfigProvider this$0, CompoundButton buttonView, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<CheckItemInfo> it = this$0.mSecondaryItemList.iterator();
        while (it.hasNext()) {
            View view2 = it.next().getView();
            if (view2 != null) {
                view2.setEnabled(isChecked);
            }
        }
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
        editor.putBoolean(TTSSwitchUtil.KEY_TTS_LOCAL_MODE, isChecked);
        editor.commit();
        UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "操作成功,重启后方可生效!").showToast();
    }

    private final CompoundButton.OnCheckedChangeListener getCheckedChangeListener(String key) {
        return new TTSConfigProvider$$ExternalSyntheticLambda7(key);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCheckedChangeListener$lambda-1  reason: not valid java name */
    public static final void m19624getCheckedChangeListener$lambda1(String $key, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter($key, "$key");
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
        editor.putBoolean($key, isChecked);
        editor.commit();
        UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "操作成功,重启后方可生效!").showToast();
    }

    public final Object getCycleObj() {
        return this.cycleObj;
    }

    public final void setCycleObj(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.cycleObj = obj;
    }

    public final List<FileItem> getListData() {
        return this.listData;
    }

    public final void setListData(List<FileItem> list) {
        this.listData = list;
    }

    public final FileItem getSingleFile() {
        return this.singleFile;
    }

    public final void setSingleFile(FileItem fileItem) {
        this.singleFile = fileItem;
    }

    public final int getCycleListIndex() {
        return this.cycleListIndex;
    }

    public final void setCycleListIndex(int i2) {
        this.cycleListIndex = i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: mInsertPlayListener$lambda-2  reason: not valid java name */
    public static final void m19625mInsertPlayListener$lambda2(TTSConfigProvider this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuffer paramsJson = new StringBuffer();
        BufferedReader bir = new BufferedReader(new InputStreamReader(new FileInputStream("/sdcard/AAbdtts/one.json")));
        for (String line = bir.readLine(); line != null; line = bir.readLine()) {
            paramsJson.append(line);
        }
        Ref.ObjectRef json = new Ref.ObjectRef();
        json.element = new JSONObject(paramsJson.toString());
        StringBuffer paramsJson0 = new StringBuffer();
        BufferedReader bir0 = new BufferedReader(new InputStreamReader(new FileInputStream("/sdcard/AAbdtts/prev.json")));
        for (String line0 = bir0.readLine(); line0 != null; line0 = bir0.readLine()) {
            paramsJson0.append(line0);
        }
        Ref.ObjectRef json0 = new Ref.ObjectRef();
        json0.element = new JSONObject(paramsJson0.toString());
        StringBuffer paramsJson2 = new StringBuffer();
        BufferedReader bir2 = new BufferedReader(new InputStreamReader(new FileInputStream("/sdcard/AAbdtts/next.json")));
        String line2 = bir2.readLine();
        while (line2 != null) {
            paramsJson2.append(line2);
            line2 = bir2.readLine();
        }
        Ref.ObjectRef json2 = new Ref.ObjectRef();
        Object obj = "/sdcard/AAbdtts/one.json";
        json2.element = new JSONObject(paramsJson2.toString());
        String str = line2;
        StringBuffer stringBuffer = paramsJson2;
        Object obj2 = "/sdcard/AAbdtts/next.json";
        Ref.ObjectRef objectRef = json0;
        StreamsFacade.playStreams(new JSONObject(paramsJson.toString()), new TTSConfigProvider$mInsertPlayListener$1$1(this$0, json, new Ref.BooleanRef(), json0, json2));
        MediaRuntime.getContext().startFullPlayer(BdBoxActivityManager.getTopActivity(), 1, "ttsVideo");
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPlayListener$lambda-6  reason: not valid java name */
    public static final void m19635mTTSPlayListener$lambda6(TTSConfigProvider this$0, View it) {
        TTSConfigProvider tTSConfigProvider = this$0;
        Intrinsics.checkNotNullParameter(tTSConfigProvider, "this$0");
        LinearLayout outter = new LinearLayout(it.getContext());
        outter.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        outter.setOrientation(1);
        String speakerVal = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPlayer.DEBUG_ONLINE_SPEAKER, "");
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        LinearLayout speakerInput = tTSConfigProvider.createInputLine(context, "在线Speaker：", speakerVal);
        outter.addView(speakerInput);
        String modelVal = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPlayer.DEBUG_OFFLINE_MODEL, "");
        Context context2 = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "it.context");
        LinearLayout modelInput = tTSConfigProvider.createInputLine(context2, "离线Model（duyuwen）：", modelVal);
        outter.addView(modelInput);
        Ref.ObjectRef radioGroup = new Ref.ObjectRef();
        radioGroup.element = new RadioGroup(it.getContext());
        ((RadioGroup) radioGroup.element).setOrientation(0);
        ((RadioGroup) radioGroup.element).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Ref.ObjectRef oneRadio = new Ref.ObjectRef();
        oneRadio.element = new RadioButton(it.getContext());
        RadioButton cycleRadio = new RadioButton(it.getContext());
        ((RadioButton) oneRadio.element).setText("单次播放");
        ((RadioButton) oneRadio.element).setId(View.generateViewId());
        cycleRadio.setText("循环播放");
        cycleRadio.setId(View.generateViewId());
        ((RadioGroup) radioGroup.element).addView((View) oneRadio.element);
        ((RadioGroup) radioGroup.element).addView(cycleRadio);
        outter.addView((View) radioGroup.element);
        int modeVal = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getInt(TtsPlayer.DEBUG_PLAY_MODE, 1);
        int checkId = modeVal == 2 ? cycleRadio.getId() : ((RadioButton) oneRadio.element).getId();
        ((RadioGroup) radioGroup.element).check(checkId);
        String dirPath = AppRuntime.getAppContext().getFilesDir().toString() + "/tts/bdttsTest/";
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "read from :>" + dirPath).show();
        TextView dirTextView = new TextView(it.getContext());
        dirTextView.setText("使用目录：" + dirPath);
        outter.addView(dirTextView);
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Button allBtn = new Button(it.getContext());
        int i2 = checkId;
        allBtn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        allBtn.setText("播放全部");
        outter.addView(allBtn);
        Button allBtn2 = allBtn;
        String str = dirPath;
        TTSConfigProvider$$ExternalSyntheticLambda12 tTSConfigProvider$$ExternalSyntheticLambda12 = r0;
        int i3 = modeVal;
        RadioButton radioButton = cycleRadio;
        Ref.ObjectRef oneRadio2 = oneRadio;
        TTSConfigProvider$$ExternalSyntheticLambda12 tTSConfigProvider$$ExternalSyntheticLambda122 = new TTSConfigProvider$$ExternalSyntheticLambda12(this$0, speakerInput, modelInput, radioGroup, oneRadio);
        allBtn2.setOnClickListener(tTSConfigProvider$$ExternalSyntheticLambda12);
        ArrayList filePaths = new ArrayList();
        File[] subFiles = file.listFiles();
        if (subFiles != null && subFiles.length > 0) {
            int i4 = 0;
            for (int length = subFiles.length; i4 < length; length = length) {
                String absolutePath = subFiles[i4].getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "subFiles[i].absolutePath");
                filePaths.add(new FileItem(absolutePath, true, false));
                i4++;
            }
        }
        FrameLayout frameLayout = new FrameLayout(it.getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, DeviceUtils.ScreenInfo.dp2px(it.getContext(), 350.0f)));
        outter.addView(frameLayout);
        RecyclerView rl = new RecyclerView(it.getContext());
        StreamTtsAdapter adapter = new StreamTtsAdapter();
        adapter.setDataList(filePaths);
        tTSConfigProvider.listData = filePaths;
        Button button = allBtn2;
        StreamTtsAdapter adapter2 = adapter;
        ArrayList arrayList = filePaths;
        RecyclerView rl2 = rl;
        String str2 = speakerVal;
        File[] fileArr = subFiles;
        adapter2.setItemClickLis(new TTSConfigProvider$mTTSPlayListener$1$2(this$0, speakerInput, modelInput, radioGroup, oneRadio2));
        rl2.setAdapter(adapter2);
        rl2.setLayoutManager(new LinearLayoutManager(it.getContext()));
        rl2.addItemDecoration(new DividerItemDecoration(it.getContext(), 1));
        frameLayout.addView(rl2);
        AlertDialog.Builder view2 = new AlertDialog.Builder(it.getContext()).setView(outter);
        LinearLayout linearLayout = outter;
        TTSConfigProvider$$ExternalSyntheticLambda13 tTSConfigProvider$$ExternalSyntheticLambda13 = r0;
        StreamTtsAdapter streamTtsAdapter = adapter2;
        RecyclerView recyclerView = rl2;
        TTSConfigProvider$$ExternalSyntheticLambda13 tTSConfigProvider$$ExternalSyntheticLambda132 = new TTSConfigProvider$$ExternalSyntheticLambda13(speakerInput, modelInput, radioGroup, oneRadio2, this$0);
        view2.setPositiveButton("重置", tTSConfigProvider$$ExternalSyntheticLambda13).setNegativeButton("关闭", new TTSConfigProvider$$ExternalSyntheticLambda14()).create().show();
        BdEventBus.Companion.getDefault().register(tTSConfigProvider.cycleObj, TtsEngineEvent.class, 1, tTSConfigProvider.cycleAction);
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPlayListener$lambda-6$lambda-3  reason: not valid java name */
    public static final void m19636mTTSPlayListener$lambda6$lambda3(TTSConfigProvider this$0, LinearLayout $speakerInput, LinearLayout $modelInput, Ref.ObjectRef $radioGroup, Ref.ObjectRef $oneRadio, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($speakerInput, "$speakerInput");
        Intrinsics.checkNotNullParameter($modelInput, "$modelInput");
        Intrinsics.checkNotNullParameter($radioGroup, "$radioGroup");
        Intrinsics.checkNotNullParameter($oneRadio, "$oneRadio");
        FileItem fileItem = null;
        this$0.singleFile = null;
        int i2 = 2;
        View childAt = $speakerInput.getChildAt(2);
        if (childAt != null) {
            String obj = ((EditText) childAt).getText().toString();
            View childAt2 = $modelInput.getChildAt(2);
            if (childAt2 != null) {
                String obj2 = ((EditText) childAt2).getText().toString();
                if (((RadioGroup) $radioGroup.element).getCheckedRadioButtonId() == ((RadioButton) $oneRadio.element).getId()) {
                    i2 = 1;
                }
                this$0.saveStreamSP(obj, obj2, i2);
                this$0.cycleListIndex = 0;
                List<FileItem> list = this$0.listData;
                if (list != null) {
                    fileItem = list.get(0);
                }
                this$0.playSingleStream(fileItem);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPlayListener$lambda-6$lambda-4  reason: not valid java name */
    public static final void m19637mTTSPlayListener$lambda6$lambda4(LinearLayout $speakerInput, LinearLayout $modelInput, Ref.ObjectRef $radioGroup, Ref.ObjectRef $oneRadio, TTSConfigProvider this$0, DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter($speakerInput, "$speakerInput");
        Intrinsics.checkNotNullParameter($modelInput, "$modelInput");
        Intrinsics.checkNotNullParameter($radioGroup, "$radioGroup");
        Intrinsics.checkNotNullParameter($oneRadio, "$oneRadio");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View childAt = $speakerInput.getChildAt(2);
        if (childAt != null) {
            ((EditText) childAt).setText("");
            View childAt2 = $modelInput.getChildAt(2);
            if (childAt2 != null) {
                ((EditText) childAt2).setText("");
                ((RadioGroup) $radioGroup.element).check(((RadioButton) $oneRadio.element).getId());
                BdEventBus.Companion.getDefault().unregister(this$0.cycleObj);
                this$0.saveStreamSP("", "", 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPlayListener$lambda-6$lambda-5  reason: not valid java name */
    public static final void m19638mTTSPlayListener$lambda6$lambda5(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    /* access modifiers changed from: private */
    public final void playSingleStream(FileItem fileItem) {
        if (fileItem != null) {
            StringBuffer paramsJson = new StringBuffer();
            BufferedReader bir = new BufferedReader(new InputStreamReader(new FileInputStream(fileItem.getPath())));
            for (String line = bir.readLine(); line != null; line = bir.readLine()) {
                paramsJson.append(line);
            }
            StreamsFacade.playStreamsDispatcher(new JSONObject(paramsJson.toString()), (Context) null, (UnitedSchemeEntity) null, (CallbackHandler) null);
        }
    }

    /* access modifiers changed from: private */
    public final void saveStreamSP(String online, String offline, int playMode) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
        editor.putString(TtsPlayer.DEBUG_ONLINE_SPEAKER, online);
        editor.putString(TtsPlayer.DEBUG_OFFLINE_MODEL, offline);
        editor.putInt(TtsPlayer.DEBUG_PLAY_MODE, playMode);
        editor.apply();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$StreamTtsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$StreamTtsVH;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "itemClickLis", "Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$Callback;", "getItemClickLis", "()Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$Callback;", "setItemClickLis", "(Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$Callback;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSConfigProvider.kt */
    public static final class StreamTtsAdapter extends RecyclerView.Adapter<StreamTtsVH> {
        private ArrayList<FileItem> dataList = new ArrayList<>();
        private Callback itemClickLis;

        public final Callback getItemClickLis() {
            return this.itemClickLis;
        }

        public final void setItemClickLis(Callback callback) {
            this.itemClickLis = callback;
        }

        public final ArrayList<FileItem> getDataList() {
            return this.dataList;
        }

        public final void setDataList(ArrayList<FileItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.dataList = arrayList;
        }

        public StreamTtsVH onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new StreamTtsVH(new StreamItemView(context));
        }

        public int getItemCount() {
            return this.dataList.size();
        }

        public void onBindViewHolder(StreamTtsVH holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            File file = new File(this.dataList.get(position).getPath());
            TextView content = holder.getContent();
            if (content != null) {
                content.setText(file.getName());
            }
            TextView content2 = holder.getContent();
            if (content2 != null) {
                content2.setOnClickListener(new TTSConfigProvider$StreamTtsAdapter$$ExternalSyntheticLambda0(this, position));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
        public static final void m19647onBindViewHolder$lambda0(StreamTtsAdapter this$0, int $position, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Callback callback = this$0.itemClickLis;
            if (callback != null) {
                FileItem fileItem = this$0.dataList.get($position);
                Intrinsics.checkNotNullExpressionValue(fileItem, "dataList.get(position)");
                callback.onItemClick(fileItem);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$StreamItemView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSConfigProvider.kt */
    public static final class StreamItemView extends FrameLayout {
        public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StreamItemView(Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            LayoutInflater.from(ctx).inflate(17367043, this);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$StreamTtsVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "setContent", "(Landroid/widget/TextView;)V", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSConfigProvider.kt */
    public static final class StreamTtsVH extends RecyclerView.ViewHolder {
        private TextView content;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StreamTtsVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.content = (TextView) itemView.findViewById(16908308);
        }

        public final TextView getContent() {
            return this.content;
        }

        public final void setContent(TextView textView) {
            this.content = textView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSAppendListener$lambda-7  reason: not valid java name */
    public static final void m19632mTTSAppendListener$lambda7(View it) {
        FeedRouter.invoke(FeedRuntime.getAppContext(), "baiduboxapp://v18/tts/append?params={\"id\":\"answer_12616354156985686731\",\"title\":\"这是测试TTS调起播放的示例\",\"context\":{\"rid\":[bb389eb6676ec6de458e2077f7042fc950ad3b7,64ae6b49a3779d430254eba05965bc3f5a26501], \"tid\":\"45466576576576787\"}\"from\":\"landpage\"}", false);
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSEndListener$lambda-8  reason: not valid java name */
    public static final void m19633mTTSEndListener$lambda8(View it) {
        FeedRouter.invoke(FeedRuntime.getAppContext(), "baiduboxapp://v18/tts/end?", false);
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPreFetchListener$lambda-9  reason: not valid java name */
    public static final void m19642mTTSPreFetchListener$lambda9(View it) {
        FeedRouter.invoke(FeedRuntime.getAppContext(), "baiduboxapp://v18/tts/prefetch?params={\"id\":\"answer_11207025024475078995\",\"title\":\"居民楼惊现2亿钞票，疑为传销收入，传销能黑多少钱？\",\"context\":{\"rid\":[\"4df9f56e27f927c7bfb783ce1261d85b8648272\",\"f3ae40921d70d3b15b888a7ba0aa6ed82045bba\",\"04e911fe6d4814eb894573e05bcd020849dc057\",\"d882a326e2fdffdcf6b5e687fa3e16249eace25\"],\"abstract\":1},\"from\":\"landpage\"}&callback=_bdbox_js_980&upgrade=0&oauthType=wenDaList", false);
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPluginParamSetListener$lambda-12  reason: not valid java name */
    public static final void m19639mTTSPluginParamSetListener$lambda12(TTSConfigProvider this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout outter = new LinearLayout(it.getContext());
        outter.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        outter.setOrientation(1);
        String inputTxt1 = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPlayer.DEBUG_TEXT2AUDIO_URL, "");
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        LinearLayout line1 = this$0.createInputLine(context, "合成地址：", inputTxt1);
        outter.addView(line1);
        String inputTxt2 = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPlayer.DEBUG_ONLINE_SPEAKER, "");
        Context context2 = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "it.context");
        LinearLayout line2 = this$0.createInputLine(context2, "在线Speaker：", inputTxt2);
        outter.addView(line2);
        String inputTxt3 = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPluginWrapper.DEBUG_ONLINE_PID, "");
        Context context3 = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "it.context");
        LinearLayout line3 = this$0.createInputLine(context3, "PID：", inputTxt3);
        outter.addView(line3);
        String inputTxt4 = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getString(TtsPlayer.DEBUG_ONLINE_PIDKEY, "");
        Context context4 = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "it.context");
        LinearLayout line4 = this$0.createInputLine(context4, "PID-KEY：", inputTxt4);
        outter.addView(line4);
        new AlertDialog.Builder(it.getContext()).setView(outter).setPositiveButton("确定", new TTSConfigProvider$$ExternalSyntheticLambda9(line1, line2, line3, line4)).setNegativeButton(AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, new TTSConfigProvider$$ExternalSyntheticLambda10()).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPluginParamSetListener$lambda-12$lambda-10  reason: not valid java name */
    public static final void m19640mTTSPluginParamSetListener$lambda12$lambda10(LinearLayout $line1, LinearLayout $line2, LinearLayout $line3, LinearLayout $line4, DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter($line1, "$line1");
        Intrinsics.checkNotNullParameter($line2, "$line2");
        Intrinsics.checkNotNullParameter($line3, "$line3");
        Intrinsics.checkNotNullParameter($line4, "$line4");
        View childAt = $line1.getChildAt(2);
        if (childAt != null) {
            EditText et1 = (EditText) childAt;
            View childAt2 = $line2.getChildAt(2);
            if (childAt2 != null) {
                EditText et2 = (EditText) childAt2;
                View childAt3 = $line3.getChildAt(2);
                if (childAt3 != null) {
                    EditText et3 = (EditText) childAt3;
                    View childAt4 = $line4.getChildAt(2);
                    if (childAt4 != null) {
                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
                        editor.putString(TtsPlayer.DEBUG_TEXT2AUDIO_URL, et1.getText().toString());
                        editor.putString(TtsPlayer.DEBUG_ONLINE_SPEAKER, et2.getText().toString());
                        editor.putString(TtsPluginWrapper.DEBUG_ONLINE_PID, et3.getText().toString());
                        editor.putString(TtsPlayer.DEBUG_ONLINE_PIDKEY, ((EditText) childAt4).getText().toString());
                        editor.commit();
                        UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "操作成功,重启后方可生效!").showToast();
                        dialog.dismiss();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
    }

    /* access modifiers changed from: private */
    /* renamed from: mTTSPluginParamSetListener$lambda-12$lambda-11  reason: not valid java name */
    public static final void m19641mTTSPluginParamSetListener$lambda12$lambda11(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    private final LinearLayout createInputLine(Context context, String label, String inputTxt) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        TextView textView2 = new TextView(context);
        textView2.setText(label);
        Ref.ObjectRef editText2 = new Ref.ObjectRef();
        editText2.element = new EditText(context);
        ((EditText) editText2.element).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ((EditText) editText2.element).setText(inputTxt);
        Button btn2 = new Button(context);
        btn2.setText("重置");
        btn2.setOnClickListener(new TTSConfigProvider$$ExternalSyntheticLambda8(editText2));
        linearLayout.addView(textView2);
        linearLayout.addView(btn2);
        linearLayout.addView((View) editText2.element);
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: createInputLine$lambda-13  reason: not valid java name */
    public static final void m19623createInputLine$lambda13(Ref.ObjectRef $editText2, View it) {
        Intrinsics.checkNotNullParameter($editText2, "$editText2");
        ((EditText) $editText2.element).setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: mMusicCoreSetListener$lambda-16  reason: not valid java name */
    public static final void m19629mMusicCoreSetListener$lambda16(View it) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext());
        LinearLayout ll = new LinearLayout(it.getContext());
        ll.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ll.setOrientation(1);
        Ref.ObjectRef ckbox = new Ref.ObjectRef();
        ckbox.element = new CheckBox(it.getContext());
        ((CheckBox) ckbox.element).setText("是否使用debug设置");
        ((CheckBox) ckbox.element).setChecked(sp.getBoolean("music_switch_debug_local", false));
        Ref.ObjectRef editText = new Ref.ObjectRef();
        editText.element = new EditText(it.getContext());
        ((EditText) editText.element).setText(String.valueOf(sp.getInt("audio_switch_to_dumedia", 0)));
        ll.addView((View) ckbox.element, new LinearLayout.LayoutParams(-1, -2));
        ll.addView((View) editText.element, new LinearLayout.LayoutParams(-1, -2));
        new AlertDialog.Builder(it.getContext()).setTitle("输入实验值:(0-无,1-好听,2-小程序,4-搜索)").setView(ll).setPositiveButton("确定", new TTSConfigProvider$$ExternalSyntheticLambda5(ckbox, editText)).setNegativeButton(AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, new TTSConfigProvider$$ExternalSyntheticLambda6()).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: mMusicCoreSetListener$lambda-16$lambda-14  reason: not valid java name */
    public static final void m19630mMusicCoreSetListener$lambda16$lambda14(Ref.ObjectRef $ckbox, Ref.ObjectRef $editText, DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter($ckbox, "$ckbox");
        Intrinsics.checkNotNullParameter($editText, "$editText");
        try {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
            editor.putBoolean("music_switch_debug_local", ((CheckBox) $ckbox.element).isChecked());
            editor.putInt("audio_switch_to_dumedia", Integer.parseInt(((EditText) $editText.element).getText().toString()));
            editor.commit();
            UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "操作成功,重启后方可生效!").showToast();
            dialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
            UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "错误：输入的非数字").showToast();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mMusicCoreSetListener$lambda-16$lambda-15  reason: not valid java name */
    public static final void m19631mMusicCoreSetListener$lambda16$lambda15(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: mTtsClearCacheListener$lambda-23  reason: not valid java name */
    public static final void m19643mTtsClearCacheListener$lambda23(View it) {
        LinearLayout ll = new LinearLayout(it.getContext());
        ll.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ll.setOrientation(1);
        Ref.ObjectRef editText = new Ref.ObjectRef();
        editText.element = new EditText(it.getContext());
        ll.addView((View) editText.element, new LinearLayout.LayoutParams(-1, -2));
        new AlertDialog.Builder(it.getContext()).setTitle("输入不可删除的音色列表,举例(duyuwen,yyjw)").setView(ll).setPositiveButton("确定", new TTSConfigProvider$$ExternalSyntheticLambda15(editText)).setNegativeButton(AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, new TTSConfigProvider$$ExternalSyntheticLambda16()).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: mTtsClearCacheListener$lambda-23$lambda-21  reason: not valid java name */
    public static final void m19644mTtsClearCacheListener$lambda23$lambda21(Ref.ObjectRef $editText, DialogInterface dialog, int which) {
        File[] it;
        Ref.ObjectRef objectRef = $editText;
        Intrinsics.checkNotNullParameter(objectRef, "$editText");
        List idList = new ArrayList();
        for (String item : StringsKt.split$default((CharSequence) ((EditText) objectRef.element).getText().toString(), new String[]{","}, false, 0, 6, (Object) null)) {
            String ids = TtsPluginWrapper.getModelIdFromDisk(item);
            if (!TextUtils.isEmpty(ids)) {
                Intrinsics.checkNotNullExpressionValue(ids, "ids");
                idList.add(ids);
            }
        }
        File clearDir = new File(AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + TtsClearCacheKt.TTS_MODEL_DIR);
        if (clearDir.exists() && (it = clearDir.listFiles()) != null && it.length > 0) {
            List filePaths = new ArrayList();
            for (File file : it) {
                if (!TextUtils.isEmpty(file.getAbsolutePath()) && file.isFile()) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    filePaths.add(absolutePath);
                }
            }
            MediaRuntime.getContext().clearModelFiles(idList, filePaths, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mTtsClearCacheListener$lambda-23$lambda-22  reason: not valid java name */
    public static final void m19645mTtsClearCacheListener$lambda23$lambda22(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: mMinibarABListener$lambda-26  reason: not valid java name */
    public static final void m19626mMinibarABListener$lambda26(View it) {
        LinearLayout ll = new LinearLayout(it.getContext());
        ll.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ll.setOrientation(1);
        Ref.ObjectRef ckbox = new Ref.ObjectRef();
        ckbox.element = new CheckBox(it.getContext());
        ((CheckBox) ckbox.element).setText("是否使用实验配置");
        ((CheckBox) ckbox.element).setChecked(FeedTTSPreferenceUtil.getBoolean("tts_minibar_abtest_debug", false));
        Ref.ObjectRef editText = new Ref.ObjectRef();
        editText.element = new EditText(it.getContext());
        ((EditText) editText.element).setText(String.valueOf(FeedTTSPreferenceUtil.getInt("tts_minibar_abtest_debug_value", 0)));
        ll.addView((View) ckbox.element, new LinearLayout.LayoutParams(-1, -2));
        ll.addView((View) editText.element, new LinearLayout.LayoutParams(-1, -2));
        new AlertDialog.Builder(it.getContext()).setTitle("输入实验值:(0=无,1=实验1,2=实验2,3=实验3)").setView(ll).setPositiveButton("确定", new TTSConfigProvider$$ExternalSyntheticLambda0(ckbox, editText)).setNegativeButton(AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, new TTSConfigProvider$$ExternalSyntheticLambda11()).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: mMinibarABListener$lambda-26$lambda-24  reason: not valid java name */
    public static final void m19627mMinibarABListener$lambda26$lambda24(Ref.ObjectRef $ckbox, Ref.ObjectRef $editText, DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter($ckbox, "$ckbox");
        Intrinsics.checkNotNullParameter($editText, "$editText");
        try {
            FeedTTSPreferenceUtil.putBoolean("tts_minibar_abtest_debug", ((CheckBox) $ckbox.element).isChecked());
            FeedTTSPreferenceUtil.putInt("tts_minibar_abtest_debug_value", Integer.parseInt(((EditText) $editText.element).getText().toString()));
            UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "操作成功,重启后方可生效!").showToast();
            dialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
            UniversalToast.makeText(FeedRuntime.getAppContext(), (CharSequence) "错误：输入的非数字").showToast();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mMinibarABListener$lambda-26$lambda-25  reason: not valid java name */
    public static final void m19628mMinibarABListener$lambda26$lambda25(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    private final boolean getTTSMainSwitch() {
        return PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getBoolean(TTSSwitchUtil.KEY_TTS_LOCAL_MODE, false);
    }

    private final boolean getTTSUpdateRalSwitch() {
        return PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getBoolean(TTSSwitchUtil.KEY_TTS_RAL_SWITCH, false);
    }

    private final void addTTSCheckItem(ArrayList<DebugItemInfo> debugItemList, String content, CompoundButton.OnCheckedChangeListener checkedChangeListener, boolean isChecked) {
        CheckItemInfo ttsCheckItem = new CheckItemInfo(content, checkedChangeListener, Boolean.valueOf(isChecked));
        View view2 = ttsCheckItem.getView();
        if (view2 != null) {
            view2.setEnabled(getTTSMainSwitch());
        }
        debugItemList.add(ttsCheckItem);
        this.mSecondaryItemList.add(ttsCheckItem);
    }

    private final void addTTSTextItem(ArrayList<DebugItemInfo> debugItemList, String title, String content, View.OnClickListener clickListener) {
        debugItemList.add(new TextItemInfo(title, content, clickListener));
    }

    private final void addTTSCustomItem(ArrayList<DebugItemInfo> debugItemList, ViewFetcher viewFetcher) {
        debugItemList.add(new CustomItemInfo(viewFetcher));
    }

    private final void addTTSEditItem(ArrayList<DebugItemInfo> debugItemList, String title, String key, int defValue) {
        addTTSCustomItem(debugItemList, new TTSConfigProvider$addTTSEditItem$1(title, key, defValue));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/feed/tts/debug/TTSConfigProvider$FileItem;", "", "p", "", "isF", "", "isS", "(Ljava/lang/String;ZZ)V", "()Z", "isFile", "setFile", "(Z)V", "isSelected", "setSelected", "getP", "()Ljava/lang/String;", "path", "getPath", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSConfigProvider.kt */
    public static final class FileItem {
        private final boolean isF;
        private boolean isFile;
        private final boolean isS;
        private boolean isSelected;
        private final String p;
        private String path;

        public static /* synthetic */ FileItem copy$default(FileItem fileItem, String str, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = fileItem.p;
            }
            if ((i2 & 2) != 0) {
                z = fileItem.isF;
            }
            if ((i2 & 4) != 0) {
                z2 = fileItem.isS;
            }
            return fileItem.copy(str, z, z2);
        }

        public final String component1() {
            return this.p;
        }

        public final boolean component2() {
            return this.isF;
        }

        public final boolean component3() {
            return this.isS;
        }

        public final FileItem copy(String str, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "p");
            return new FileItem(str, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileItem)) {
                return false;
            }
            FileItem fileItem = (FileItem) obj;
            return Intrinsics.areEqual((Object) this.p, (Object) fileItem.p) && this.isF == fileItem.isF && this.isS == fileItem.isS;
        }

        public int hashCode() {
            int hashCode = this.p.hashCode() * 31;
            boolean z = this.isF;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.isS;
            if (!z3) {
                z2 = z3;
            }
            return i2 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "FileItem(p=" + this.p + ", isF=" + this.isF + ", isS=" + this.isS + ')';
        }

        public FileItem(String p2, boolean isF2, boolean isS2) {
            Intrinsics.checkNotNullParameter(p2, "p");
            this.p = p2;
            this.isF = isF2;
            this.isS = isS2;
            this.path = p2;
            this.isFile = isF2;
            this.isSelected = isS2;
        }

        public final String getP() {
            return this.p;
        }

        public final boolean isF() {
            return this.isF;
        }

        public final boolean isS() {
            return this.isS;
        }

        public final String getPath() {
            return this.path;
        }

        public final void setPath(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.path = str;
        }

        public final boolean isFile() {
            return this.isFile;
        }

        public final void setFile(boolean z) {
            this.isFile = z;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }
    }

    public List<DebugItemInfo> getChildItemList() {
        ArrayList debugItemList = new ArrayList();
        debugItemList.add(new CheckItemInfo("以下勾选优先于实验命中（总开关）", this.mTTSMainSwitchListener, Boolean.valueOf(getTTSMainSwitch())));
        addTTSCheckItem(debugItemList, "TTS update 开启看听模式", getCheckedChangeListener(TTSSwitchUtil.KEY_TTS_RAL_SWITCH), getTTSUpdateRalSwitch());
        addTTSTextItem(debugItemList, (String) null, "StreamTts-Play", this.mTTSPlayListener);
        addTTSTextItem(debugItemList, (String) null, "追加数据", this.mTTSAppendListener);
        addTTSTextItem(debugItemList, (String) null, "停止语音", this.mTTSEndListener);
        addTTSTextItem(debugItemList, (String) null, "预取数据", this.mTTSPreFetchListener);
        addTTSTextItem(debugItemList, (String) null, "设置合成地址等参数", this.mTTSPluginParamSetListener);
        addTTSTextItem(debugItemList, (String) null, "音乐内核 设置内核切换实验值", this.mMusicCoreSetListener);
        addTTSTextItem(debugItemList, (String) null, "minibar实验", this.mMinibarABListener);
        addTTSTextItem(debugItemList, (String) null, "自动/手动清理", this.mTtsClearCacheListener);
        addTTSTextItem(debugItemList, (String) null, "插入性播报测试", this.mInsertPlayListener);
        addTTSEditItem(debugItemList, "Feed-TTS插播音乐间隔：", TTSConfigProviderKt.DEBUG_KEY_INTERVAL_TO_INSERT_MUSIC, 10);
        debugItemList.add(getBriefHomeInfo("纯听流实验开关", PureListenABTestUtilsKt.KEY_PURE_LISTEN_DEBUG_ABTEST));
        return debugItemList;
    }

    private final RadioDebugItemInfo<Integer> getBriefHomeInfo(String title, String switchKey) {
        List radioList = new ArrayList();
        radioList.add(new Pair("依照AB", 0));
        radioList.add(new Pair("强制命中纯听内容流实验1", 1));
        radioList.add(new Pair("强制命中纯听内容流实验2", 2));
        radioList.add(new Pair("强制命中纯听内容流实验3", 3));
        return new RadioDebugItemInfo<>(title, radioList, Integer.valueOf(getDebugSwitch(switchKey)), new TTSConfigProvider$getBriefHomeInfo$1(this, switchKey));
    }

    /* access modifiers changed from: private */
    public final void showToast() {
        UniversalToast.makeText(AppRuntime.getAppContext().getApplicationContext(), (CharSequence) "已切换，重启百度后生效").setDuration(2).showToast();
    }

    private final int getDebugSwitch(String switchKey) {
        return PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).getInt(switchKey, 0);
    }

    /* access modifiers changed from: private */
    public final void setDebugSwitch(String switchKey, int value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(FeedRuntime.getAppContext()).edit();
        editor.putInt(switchKey, value);
        editor.apply();
    }

    public String getGroupName() {
        return "TTS";
    }
}
