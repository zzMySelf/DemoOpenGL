package com.baidu.browser.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.browser.search.LightSearchActivity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.QueryUtils;
import com.baidu.search.core.utils.IncognitoModeUtil;
import com.baidu.search.frame.ioc.SearchFrameRuntime;
import com.baidu.search.frame.statistic.SearchFrameConstants;
import com.baidu.searchbox.browser.SearchBrowser;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.tts.FeedTTSExternalHandler;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.hissug.ISugDurationForSearch;
import com.baidu.searchbox.hissug.data.IHistoryInterface;
import com.baidu.searchbox.hissug.data.model.SearchHistory;
import com.baidu.searchbox.hissug.ubc.UbcHisSugShow;
import com.baidu.searchbox.hissug.util.QueryLimitUtil;
import com.baidu.searchbox.multiwindowinterface.MultiWindowInterface;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.search.SearchActivityEventManager;
import com.baidu.searchbox.search.SearchManager;
import com.baidu.searchbox.search.pyramid.SearchInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.talos.common.TalosCommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J,\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J$\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J&\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/browser/impl/SearchImpl;", "Lcom/baidu/searchbox/search/pyramid/SearchInterface;", "()V", "DEBUG", "", "TAG", "", "imageSearchClick", "", "inputboxClick", "source", "isHistoryPrivateMode", "ctx", "Landroid/content/Context;", "isLightSearchProcessText", "activity", "Landroid/app/Activity;", "startLightSearchActivityCommon", "intent", "Landroid/content/Intent;", "isAnim", "isNewTask", "startLightSearchActivityNewTaskAndClearTop", "appContext", "startLightSearchActivitySingleTopAndClearTop", "voiceHisStartLightSearch", "context", "searchHistory", "", "sa", "lib_search_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchImpl.kt */
public final class SearchImpl implements SearchInterface {
    private final boolean DEBUG = AppConfig.isDebug();
    private final String TAG = "SearchFrameImpl";

    public void startLightSearchActivityCommon(Context activity, Intent intent, boolean isAnim, boolean isNewTask) {
        if (activity != null && intent != null) {
            SearchActivityEventManager.INSTANCE.postSearchActivityEvent(1);
            Activity convertContextToActivity = TalosCommonUtil.convertContextToActivity(activity);
            Context launchActivity = convertContextToActivity == null ? activity : convertContextToActivity;
            MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
            if ((multiWindowInterface != null || (launchActivity instanceof LightSearchActivity)) && (multiWindowInterface.size(IncognitoModeUtil.isIncognitoSwitchOn()) < 8 || (launchActivity instanceof LightSearchActivity))) {
                intent.setFlags((!(launchActivity instanceof Activity) || isNewTask) ? 268435456 : 536870912);
            } else {
                intent.addFlags(603979776);
            }
            intent.setClass(launchActivity, LightSearchActivity.class);
            intent.putExtra(LightSearchActivity.TRANSITION_ANIMATION, isAnim);
            if (this.DEBUG) {
                intent.putExtra(LightSearchActivity.FIX_START_ACTIVITY, true);
            }
            ActivityUtils.startActivitySafely(launchActivity, intent);
        }
    }

    public void startLightSearchActivityCommon(Context activity, Intent intent, boolean isAnim) {
        startLightSearchActivityCommon(activity, intent, isAnim, false);
    }

    public void startLightSearchActivitySingleTopAndClearTop(Context activity, Intent intent, boolean isAnim) {
        if (activity != null && intent != null) {
            intent.addFlags(603979776);
            intent.setClass(activity, LightSearchActivity.class);
            intent.putExtra(LightSearchActivity.TRANSITION_ANIMATION, isAnim);
            if (this.DEBUG) {
                intent.putExtra(LightSearchActivity.FIX_START_ACTIVITY, true);
            }
            ActivityUtils.startActivitySafely(activity, intent);
        }
    }

    public void startLightSearchActivityNewTaskAndClearTop(Context appContext, Intent intent, boolean isAnim) {
        if (appContext != null && intent != null) {
            intent.addFlags(805306368);
            intent.setClass(appContext, LightSearchActivity.class);
            intent.putExtra(LightSearchActivity.TRANSITION_ANIMATION, isAnim);
            if (this.DEBUG) {
                intent.putExtra(LightSearchActivity.FIX_START_ACTIVITY, true);
            }
            ActivityUtils.startActivitySafely(appContext, intent);
        }
    }

    public boolean isLightSearchProcessText(Activity activity) {
        if (!(activity instanceof LightSearchActivity)) {
            return false;
        }
        Intent intent = ((LightSearchActivity) activity).getIntent();
        return Intrinsics.areEqual((Object) SearchFrameConstants.SYSTEM_PROCESS_TEXT_SA, (Object) intent != null ? intent.getStringExtra("sa") : null);
    }

    public void voiceHisStartLightSearch(Context context, Object searchHistory, String sa) {
        SearchHistory history;
        String $this$trim$iv;
        String query;
        IHistoryInterface historyInterface;
        Context context2 = context;
        Object obj = searchHistory;
        String str = sa;
        if (obj instanceof SearchHistory) {
            history = (SearchHistory) obj;
        } else {
            history = null;
        }
        if (history != null && context2 != null) {
            String str2 = null;
            if (history.isDirectHis() && !TextUtils.isEmpty(history.getUrl())) {
                String url = history.getUrl();
                String tag = history.getTag();
                boolean isPrivateMode = isHistoryPrivateMode(context);
                boolean incognitoMode = IncognitoModeUtil.isIncognitoSwitchOn();
                if (!isPrivateMode && !incognitoMode && (historyInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE())) != null) {
                    historyInterface.addSugDirectHistory(context, history.getWord(), tag, url, history.getType() + "");
                }
                if (url != null) {
                    CharSequence $this$trim$iv$iv = url;
                    int startIndex$iv$iv = 0;
                    int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
                    boolean startFound$iv$iv = false;
                    while (startIndex$iv$iv <= endIndex$iv$iv) {
                        char it = Intrinsics.compare((int) $this$trim$iv$iv.charAt(!startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv), 32) <= 0 ? (char) 1 : 0;
                        if (!startFound$iv$iv) {
                            if (it == 0) {
                                startFound$iv$iv = true;
                            } else {
                                startIndex$iv$iv++;
                            }
                        } else if (it == 0) {
                            break;
                        } else {
                            endIndex$iv$iv--;
                        }
                    }
                    str2 = $this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1).toString();
                }
                if (UnitedSchemeUtility.isUnitedScheme(str2)) {
                    SearchFrameRuntime.getSearchFrameContext().invokeSchemeOrCmd(context2, url, "inside");
                    return;
                }
                Bundle extras = new Bundle();
                extras.putString("key_url", url);
                extras.putInt("searchcalltype", 1);
                extras.putBoolean("EXTRA_URL_NEW_WINDOW", false);
                SearchBrowser.startBrowser(context2, extras);
            } else if (!TextUtils.isEmpty(history.getWord())) {
                String query2 = history.getWord();
                if (!TextUtils.isEmpty(query2)) {
                    if (query2 != null) {
                        CharSequence $this$trim$iv$iv2 = query2;
                        int startIndex$iv$iv2 = 0;
                        int endIndex$iv$iv2 = $this$trim$iv$iv2.length() - 1;
                        boolean startFound$iv$iv2 = false;
                        while (startIndex$iv$iv2 <= endIndex$iv$iv2) {
                            char it2 = Intrinsics.compare((int) $this$trim$iv$iv2.charAt(!startFound$iv$iv2 ? startIndex$iv$iv2 : endIndex$iv$iv2), 32) <= 0 ? (char) 1 : 0;
                            if (!startFound$iv$iv2) {
                                if (it2 == 0) {
                                    startFound$iv$iv2 = true;
                                } else {
                                    startIndex$iv$iv2++;
                                }
                            } else if (it2 == 0) {
                                break;
                            } else {
                                endIndex$iv$iv2--;
                            }
                        }
                        $this$trim$iv = $this$trim$iv$iv2.subSequence(startIndex$iv$iv2, endIndex$iv$iv2 + 1).toString();
                    } else {
                        $this$trim$iv = null;
                    }
                    if (!TextUtils.isEmpty($this$trim$iv)) {
                        String tmp = QueryUtils.getUrlFromQuery(query2);
                        String query3 = QueryUtils.replaceBlank(query2);
                        if (TextUtils.isEmpty(tmp)) {
                            query = QueryLimitUtil.queryLimitByte(query3, 72);
                        } else {
                            query = query3;
                        }
                        boolean isPrivateMode2 = isHistoryPrivateMode(context);
                        boolean incognitoMode2 = IncognitoModeUtil.isIncognitoSwitchOn();
                        IHistoryInterface historyInterface2 = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
                        if (!isPrivateMode2 && !incognitoMode2 && historyInterface2 != null) {
                            historyInterface2.addLocalHistory(context.getApplicationContext(), TextUtils.isEmpty(tmp) ? query : tmp, (String) null);
                        }
                        if (!TextUtils.isEmpty(query)) {
                            HashMap params = new HashMap();
                            if (str != null) {
                                String str3 = sa;
                                params.put("sa", str);
                            }
                            IHistoryInterface iHistoryInterface = historyInterface2;
                            SearchManager.launchWebSearchForSearchActivity(context, history.getWord(), "", (String) null, "", false, (ArrayList<String>) null, params, (ISugDurationForSearch) null);
                        }
                    }
                }
            }
        }
    }

    public void inputboxClick(String source) {
        long time = -1;
        if (TextUtils.equals(source, "home")) {
            UbcHisSugShow.getInstance().setBoxClickEventTime(System.currentTimeMillis());
            time = SpeedStats.getInstance().fetchOnUserInteractionTime();
        }
        if (time == -1) {
            time = System.currentTimeMillis();
        }
        UbcHisSugShow.getInstance().setBoxclick(time);
    }

    public void imageSearchClick() {
        MusicManager.Companion.get().interrupt(FeedTTSExternalHandler.INTERRUPT_FROM_HOME_SEARCH_VIDEO);
        TTSRuntime.getInstance().postInterruptedEvent(FeedTTSExternalHandler.INTERRUPT_FROM_HOME_SEARCH_VIDEO);
    }

    private final boolean isHistoryPrivateMode(Context ctx) {
        IHistoryInterface iHistoryInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
        if (iHistoryInterface != null) {
            return iHistoryInterface.isNoHisMode(ctx);
        }
        return false;
    }
}
