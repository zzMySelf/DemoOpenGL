package com.baidu.searchbox.personal;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.utils.IncognitoModeInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType;
import com.baidu.searchbox.newpersonalcenter.guide.PersonalScrollGuideManager;
import com.baidu.searchbox.newpersonalcenter.model.TipModel;
import com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.animatoricon.AnimatorIconManager;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NewVerticalScrollUbcTrigger extends RecyclerView.OnScrollListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int ITEM_COUNT_CHANG_YONG = 10;
    private static final String MODEL_COMMON_FUNCTION = "常用功能新版";
    private static final String MODEL_COMMON_SWAM = "小程序中心";
    private static final String MODEL_MINE_SWAM = "我的小程序";
    private static final String TAG = "ScrollUbc";
    private static final float TRULY_VISIBLE_HEIGHT_RATIO_TH = 0.5f;
    public static List<String> bannerUbc = Collections.synchronizedList(new ArrayList());
    public static boolean managerShowUbc;
    private final List<String> groupShowTimesHistory = Collections.synchronizedList(new ArrayList());
    private boolean isScrollDown = false;
    private int mFirstTrulyVisiblePosition;
    private boolean mFragmentVisible = false;
    private int mLastTrulyVisiblePosition;
    private final PersonalCenterMode mPersonalCenterMode;
    private final HashMap<String, Integer> mTitleScreenIndexMap = new HashMap<>();
    private final List<String> titleHistory = Collections.synchronizedList(new ArrayList());

    public NewVerticalScrollUbcTrigger(PersonalCenterMode personalCenterMode) {
        this.mPersonalCenterMode = personalCenterMode;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
            int firstTrulyVisibleItemPosition = getFirstTrulyVisibleItemPosition(manager);
            int lastTrulyVisibleItemPosition = getLastTrulyVisibleItemPosition(manager);
            boolean updated = false;
            if (this.mFirstTrulyVisiblePosition != firstTrulyVisibleItemPosition) {
                this.mFirstTrulyVisiblePosition = firstTrulyVisibleItemPosition;
                updated = true;
            }
            if (this.mLastTrulyVisiblePosition != lastTrulyVisibleItemPosition) {
                this.mLastTrulyVisiblePosition = lastTrulyVisibleItemPosition;
                updated = true;
            }
            if (updated) {
                if (DEBUG) {
                    Log.e(TAG, "scroll firstTrulyVisible:" + firstTrulyVisibleItemPosition);
                    Log.e(TAG, "scroll lastTrulyVisible:" + lastTrulyVisibleItemPosition);
                }
                ubcStatistic(layoutManager, firstTrulyVisibleItemPosition, lastTrulyVisibleItemPosition, PersonalizedDataManagerWrapper.INSTANCE.getCardManagePosition());
            }
            if (!PersonalScrollGuideManager.INSTANCE.isScrollGuideShowing() && this.isScrollDown) {
                PersonCenterUBCStatistic.statisticUBC("slide", (String) null, "click", (JSONObject) null, "slide", "192", (String) null);
            }
        }
    }

    public void refreshStatistic(RecyclerView recyclerView) {
        if (this.mFragmentVisible) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                this.mFirstTrulyVisiblePosition = getFirstTrulyVisibleItemPosition(manager);
                this.mLastTrulyVisiblePosition = getLastTrulyVisibleItemPosition(manager);
            }
            syncScreenIndex();
            ubcStatistic(layoutManager, this.mFirstTrulyVisiblePosition, this.mLastTrulyVisiblePosition, PersonalizedDataManagerWrapper.INSTANCE.getCardManagePosition());
        }
    }

    public void clear() {
        this.titleHistory.clear();
        bannerUbc.clear();
        this.groupShowTimesHistory.clear();
        managerShowUbc = false;
    }

    public static int safeIndex(int currentIndex, int itemCount) {
        if (currentIndex < 0) {
            return 0;
        }
        if (currentIndex >= itemCount) {
            return itemCount - 1;
        }
        return currentIndex;
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x027d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0264  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ubcStatistic(androidx.recyclerview.widget.RecyclerView.LayoutManager r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r7 = r24
            r8 = r25
            r9 = r28
            int[] r0 = com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger.AnonymousClass2.$SwitchMap$com$baidu$searchbox$personal$PersonalCenterMode
            com.baidu.searchbox.personal.PersonalCenterMode r1 = r7.mPersonalCenterMode
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0020;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.util.ArrayList r0 = new java.util.ArrayList
            com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper r1 = com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper.INSTANCE
            java.util.List r1 = r1.getMergedGroupModels()
            r0.<init>(r1)
            r10 = r0
            goto L_0x0039
        L_0x0020:
            java.util.ArrayList r0 = new java.util.ArrayList
            com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper r1 = com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper.INSTANCE
            java.util.List r1 = r1.getMergedGroupModels()
            r0.<init>(r1)
            r10 = r0
            goto L_0x0039
        L_0x002d:
            java.util.ArrayList r0 = new java.util.ArrayList
            com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper r1 = com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper.INSTANCE
            java.util.List r1 = r1.getMixFusionData()
            r0.<init>(r1)
            r10 = r0
        L_0x0039:
            int r0 = r10.size()
            if (r0 > 0) goto L_0x0040
            return
        L_0x0040:
            int r0 = r10.size()
            r1 = r26
            int r11 = safeIndex(r1, r0)
            int r0 = r10.size()
            int r0 = r0 + 1
            r1 = r27
            int r0 = safeIndex(r1, r0)
            boolean r1 = DEBUG
            java.lang.String r12 = "ScrollUbc"
            if (r1 == 0) goto L_0x00c5
            r1 = 0
        L_0x005d:
            int r2 = r10.size()
            if (r1 >= r2) goto L_0x00a5
            java.lang.Object r2 = r10.get(r1)
            com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel r2 = (com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel) r2
            boolean r3 = r2 instanceof com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel
            if (r3 == 0) goto L_0x00a2
            r3 = r2
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel r3 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel) r3
            java.util.List r4 = r3.getPersonalCenterTabs()
            int r5 = r3.getCurrentSelectedPosition()
            int r6 = r4.size()
            if (r5 >= r6) goto L_0x00a2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.String r13 = "->"
            java.lang.StringBuilder r6 = r6.append(r13)
            java.lang.Object r13 = r4.get(r5)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r13 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r13
            java.lang.String r13 = r13.getTitle()
            java.lang.StringBuilder r6 = r6.append(r13)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r12, r6)
        L_0x00a2:
            int r1 = r1 + 1
            goto L_0x005d
        L_0x00a5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fromIndex:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = ", toIndex:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r12, r1)
        L_0x00c5:
            com.baidu.common.matrixstyle.StyleMode r1 = com.baidu.common.matrixstyle.StyleMode.INSTANCE
            boolean r1 = r1.isTeenagerStyle()
            if (r1 == 0) goto L_0x00cf
            r1 = r0
            goto L_0x00d1
        L_0x00cf:
            int r1 = r0 + 1
        L_0x00d1:
            r13 = r1
            r0 = 0
            r1 = r11
            r14 = r1
        L_0x00d5:
            if (r14 >= r13) goto L_0x0281
            int r1 = r10.size()
            if (r14 < r1) goto L_0x00df
            goto L_0x0281
        L_0x00df:
            java.lang.Object r1 = r10.get(r14)
            r15 = r1
            com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel r15 = (com.baidu.searchbox.kmm.personalcenter.PersonalCenterBaseModel) r15
            if (r15 != 0) goto L_0x00ea
            goto L_0x027d
        L_0x00ea:
            r1 = 0
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            r5 = -1
            boolean r6 = r15 instanceof com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel
            if (r6 == 0) goto L_0x01c1
            r6 = r15
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel r6 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel) r6
            r26 = r1
            java.util.List r1 = r6.getPersonalCenterTabs()
            int r16 = r1.size()
            if (r16 != 0) goto L_0x0105
            goto L_0x027d
        L_0x0105:
            int r2 = r1.size()
            r27 = r2
            int r2 = r6.getCurrentSelectedPosition()
            r16 = r3
            java.lang.String r3 = "当前模块是："
            if (r2 < 0) goto L_0x0122
            r17 = r4
            int r4 = r1.size()
            if (r2 < r4) goto L_0x011f
            goto L_0x0124
        L_0x011f:
            r18 = r5
            goto L_0x015f
        L_0x0122:
            r17 = r4
        L_0x0124:
            int r4 = r1.size()
            int r2 = r2 % r4
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x015d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r18 = r5
            java.lang.String r5 = "纠正 currentShowTabIndex"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.util.List r5 = r6.getPersonalCenterTabs()
            java.lang.Object r5 = r5.get(r2)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r5 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r5
            java.lang.String r5 = r5.getTitle()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r12, r4)
            goto L_0x015f
        L_0x015d:
            r18 = r5
        L_0x015f:
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x0190
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "ubc get currentShowTabIndex"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.util.List r4 = r6.getPersonalCenterTabs()
            java.lang.Object r4 = r4.get(r2)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r4 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r4
            java.lang.String r4 = r4.getTitle()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r12, r3)
        L_0x0190:
            java.lang.Object r3 = r1.get(r2)
            r4 = r3
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r4 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r4
            int r5 = r4.getTempCategory()
            if (r4 != 0) goto L_0x019f
            goto L_0x027d
        L_0x019f:
            java.lang.String r3 = r4.getTitle()
            r19 = r1
            java.lang.String r1 = "常用功能新版"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x01b3
            int r1 = r6.getCurrentScreenIndex()
            goto L_0x01b4
        L_0x01b3:
            r1 = r2
        L_0x01b4:
            java.lang.String r3 = r6.getGroupId()
            r17 = r27
            r16 = r1
            r6 = r3
            r18 = r5
            r5 = r4
            goto L_0x01f7
        L_0x01c1:
            r26 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            boolean r1 = r15 instanceof com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel
            if (r1 == 0) goto L_0x01ef
            r4 = r15
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r4 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r4
            r2 = 1
            java.lang.String r1 = r4.getGroupId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01e0
            java.lang.String r3 = r4.getGroupId()
            goto L_0x01e2
        L_0x01e0:
            r3 = r16
        L_0x01e2:
            int r5 = r4.getTempCategory()
            r16 = r26
            r17 = r2
            r6 = r3
            r18 = r5
            r5 = r4
            goto L_0x01f7
        L_0x01ef:
            r6 = r16
            r5 = r17
            r16 = r26
            r17 = r2
        L_0x01f7:
            if (r5 != 0) goto L_0x01fb
            goto L_0x027d
        L_0x01fb:
            r1 = -1
            if (r9 <= 0) goto L_0x020e
            if (r14 <= r9) goto L_0x020e
            com.baidu.searchbox.newpersonalcenter.guide.PersonalScrollGuideManager r2 = com.baidu.searchbox.newpersonalcenter.guide.PersonalScrollGuideManager.INSTANCE
            boolean r2 = r2.isScrollGuideShowing()
            if (r2 == 0) goto L_0x0209
            return
        L_0x0209:
            int r1 = r14 - r9
            r19 = r1
            goto L_0x0210
        L_0x020e:
            r19 = r1
        L_0x0210:
            java.util.List<java.lang.String> r1 = r7.groupShowTimesHistory
            boolean r1 = r1.contains(r6)
            if (r1 != 0) goto L_0x0245
            java.util.List<java.lang.String> r1 = r7.groupShowTimesHistory
            r1.add(r6)
            com.baidu.searchbox.personal.PersonalCenterMode r1 = r7.mPersonalCenterMode
            com.baidu.searchbox.personal.PersonalCenterMode r2 = com.baidu.searchbox.personal.PersonalCenterMode.PERSONAL_CENTER_AI
            if (r1 != r2) goto L_0x0236
            com.baidu.searchbox.aipersonal.AiPersonalUtils r1 = com.baidu.searchbox.aipersonal.AiPersonalUtils.INSTANCE
            r2 = 0
            java.lang.String r3 = "ubcStatistic-new "
            java.lang.String r1 = r1.getAiCardDataType(r5, r2, r3)
            com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper r2 = com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper.INSTANCE
            com.baidu.searchbox.kmm.personalcenter.smart.PersonalCenterSmartDataMgr r2 = r2.getManager()
            com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.recommendCardShow(r2, r5, r1)
        L_0x0236:
            com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper r1 = com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper.INSTANCE
            com.baidu.searchbox.newpersonalcenter.managerpage.SelectedTabsBO r1 = r1.findSelectedTabSync(r6)
            if (r1 == 0) goto L_0x0245
            r1.increaseShowTimes()
            r0 = 1
            r20 = r0
            goto L_0x0247
        L_0x0245:
            r20 = r0
        L_0x0247:
            r0 = 0
            if (r8 == 0) goto L_0x0264
            int r1 = r5.getTempCategory()
            r2 = 7001(0x1b59, float:9.81E-42)
            if (r1 != r2) goto L_0x0264
            android.view.View r1 = r8.findViewByPosition(r14)
            if (r1 == 0) goto L_0x0264
            int r2 = com.baidu.searchbox.personalcenter.R.id.personal_swan_card_view
            android.view.View r2 = r1.findViewById(r2)
            r0 = r2
            com.baidu.swan.card.card.view.SwanCardView r0 = (com.baidu.swan.card.card.view.SwanCardView) r0
            r21 = r0
            goto L_0x0266
        L_0x0264:
            r21 = r0
        L_0x0266:
            java.lang.String r3 = "show"
            r0 = r24
            r1 = r21
            r2 = r5
            r4 = r16
            r22 = r5
            r5 = r17
            r23 = r6
            r6 = r19
            r0.ubcSingleInfo(r1, r2, r3, r4, r5, r6)
            r0 = r20
        L_0x027d:
            int r14 = r14 + 1
            goto L_0x00d5
        L_0x0281:
            com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper r1 = com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper.INSTANCE
            java.util.List r1 = r1.getSelectedTabsSync()
            if (r0 == 0) goto L_0x029b
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x029b
            com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger$1 r2 = new com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger$1
            r2.<init>(r1)
            r3 = 0
            java.lang.String r4 = "updateSelectedTabs"
            com.baidu.searchbox.elasticthread.ExecutorUtilsExt.postOnElastic(r2, r4, r3)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger.ubcStatistic(androidx.recyclerview.widget.RecyclerView$LayoutManager, int, int, int):void");
    }

    /* Debug info: failed to restart local var, previous not found, register: 33 */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a6, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ubcSingleInfo(com.baidu.swan.card.card.view.SwanCardView r34, com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r35, java.lang.String r36, int r37, int r38, int r39) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r37
            r5 = r38
            r6 = r39
            if (r3 != 0) goto L_0x000f
            return
        L_0x000f:
            boolean r0 = DEBUG     // Catch:{ Exception -> 0x02ab }
            if (r0 == 0) goto L_0x0034
            java.lang.String r7 = "ScrollUbc"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ab }
            r8.<init>()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r9 = "ubcSingleInfo model:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r9 = r35.getTitle()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02ab }
            android.util.Log.e(r7, r8)     // Catch:{ Exception -> 0x02ab }
        L_0x0034:
            int r7 = r35.getFirstVisiblePosition()     // Catch:{ Exception -> 0x02ab }
            int r8 = r35.getLastVisiblePosition()     // Catch:{ Exception -> 0x02ab }
            if (r7 >= 0) goto L_0x003f
            r7 = 0
        L_0x003f:
            if (r8 >= 0) goto L_0x0042
            r8 = 0
        L_0x0042:
            java.util.List r9 = r35.getBody()     // Catch:{ Exception -> 0x02ab }
            if (r9 == 0) goto L_0x02a8
            int r10 = r9.size()     // Catch:{ Exception -> 0x02ab }
            if (r10 != 0) goto L_0x0052
            r10 = r36
            goto L_0x02aa
        L_0x0052:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ab }
            r10.<init>()     // Catch:{ Exception -> 0x02ab }
            monitor-enter(r9)     // Catch:{ Exception -> 0x02ab }
            r10.addAll(r9)     // Catch:{ all -> 0x029d }
            monitor-exit(r9)     // Catch:{ all -> 0x029d }
            int r11 = r10.size()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r12 = r35.getTitle()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r13 = "常用功能新版"
            boolean r13 = r13.equals(r12)     // Catch:{ Exception -> 0x02ab }
            r14 = 9
            if (r13 == 0) goto L_0x007b
            if (r4 != 0) goto L_0x0077
            int r13 = java.lang.Math.min(r14, r11)     // Catch:{ Exception -> 0x02ab }
            r8 = r13
            goto L_0x0093
        L_0x0077:
            r7 = 10
            r8 = r11
            goto L_0x0093
        L_0x007b:
            java.lang.String r13 = "小程序中心"
            boolean r13 = r13.equals(r12)     // Catch:{ Exception -> 0x02ab }
            if (r13 != 0) goto L_0x008d
            java.lang.String r13 = "我的小程序"
            boolean r13 = r13.equals(r12)     // Catch:{ Exception -> 0x02ab }
            if (r13 == 0) goto L_0x0093
        L_0x008d:
            r7 = 0
            int r13 = java.lang.Math.min(r14, r11)     // Catch:{ Exception -> 0x02ab }
            r8 = r13
        L_0x0093:
            if (r8 != 0) goto L_0x0098
            if (r5 <= 0) goto L_0x0098
            r8 = r11
        L_0x0098:
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = "ScrollUbc"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ab }
            r13.<init>()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r14 = "ubcSingleInfo firstItemIndex:"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r13 = r13.append(r7)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r14 = ", lastItemIndex:"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r13 = r13.append(r8)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r14 = ",itemSize:"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r13 = r13.append(r11)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02ab }
            android.util.Log.e(r0, r13)     // Catch:{ Exception -> 0x02ab }
        L_0x00c7:
            if (r11 <= 0) goto L_0x0294
            if (r7 < 0) goto L_0x0294
            if (r7 >= r11) goto L_0x0294
            r0 = 0
            r13 = r7
        L_0x00cf:
            if (r13 > r8) goto L_0x028b
            if (r13 >= r11) goto L_0x028b
            java.lang.Object r14 = r10.get(r13)     // Catch:{ Exception -> 0x02ab }
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel r14 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r14     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = "nocacheclean"
            r16 = r7
            java.lang.String r7 = r14.getKeyId()     // Catch:{ Exception -> 0x02ab }
            boolean r7 = r15.equals(r7)     // Catch:{ Exception -> 0x02ab }
            if (r7 == 0) goto L_0x00ee
            r17 = r8
            r18 = r10
            goto L_0x01b4
        L_0x00ee:
            java.lang.String r7 = "cacheclean"
            java.lang.String r15 = r14.getKeyId()     // Catch:{ Exception -> 0x02ab }
            boolean r7 = r7.equals(r15)     // Catch:{ Exception -> 0x02ab }
            if (r7 == 0) goto L_0x0100
            r17 = r8
            r18 = r10
            goto L_0x01b4
        L_0x0100:
            int r7 = r35.getTempCategory()     // Catch:{ Exception -> 0x02ab }
            r15 = 3003(0xbbb, float:4.208E-42)
            if (r7 != r15) goto L_0x0116
            if (r13 != 0) goto L_0x0110
            java.lang.String r7 = "first"
            r14.setUbcSource(r7)     // Catch:{ Exception -> 0x02ab }
            goto L_0x0116
        L_0x0110:
            r17 = r8
            r18 = r10
            goto L_0x01b4
        L_0x0116:
            int r7 = r35.getTempCategory()     // Catch:{ Exception -> 0x02ab }
            r15 = 999(0x3e7, float:1.4E-42)
            if (r7 != r15) goto L_0x0124
            r17 = r8
            r18 = r10
            goto L_0x01b4
        L_0x0124:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ab }
            r7.<init>()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = r35.getTabId()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r7 = r7.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = r14.getTitle()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r7 = r7.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = "-"
            java.lang.StringBuilder r7 = r7.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r7 = r7.append(r13)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x02ab }
            java.util.List<java.lang.String> r15 = r1.titleHistory     // Catch:{ Exception -> 0x02ab }
            boolean r15 = r15.contains(r7)     // Catch:{ Exception -> 0x02ab }
            if (r15 == 0) goto L_0x01b8
            boolean r15 = DEBUG     // Catch:{ Exception -> 0x02ab }
            if (r15 == 0) goto L_0x01b0
            java.lang.String r15 = "ScrollUbc"
            r17 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ab }
            r8.<init>()     // Catch:{ Exception -> 0x02ab }
            r18 = r10
            java.lang.String r10 = "itemUBC=>skip=>"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = r35.getTabId()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r12)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = "-"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = ":"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r13)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = "=>"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = r14.getTitle()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = ",page:"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = getPage(r14, r13)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02ab }
            android.util.Log.e(r15, r8)     // Catch:{ Exception -> 0x02ab }
            goto L_0x01b4
        L_0x01b0:
            r17 = r8
            r18 = r10
        L_0x01b4:
            r10 = r36
            goto L_0x0281
        L_0x01b8:
            r17 = r8
            r18 = r10
            java.util.List<java.lang.String> r8 = r1.titleHistory     // Catch:{ Exception -> 0x02ab }
            r8.add(r7)     // Catch:{ Exception -> 0x02ab }
            boolean r8 = DEBUG     // Catch:{ Exception -> 0x02ab }
            if (r8 == 0) goto L_0x0219
            java.lang.String r8 = "ScrollUbc"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ab }
            r10.<init>()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = "itemUBC=>"
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = r35.getTabId()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = "-"
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r5)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = ":"
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = "=>"
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = r14.getTitle()     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = ",page:"
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r15 = getPage(r14, r13)     // Catch:{ Exception -> 0x02ab }
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02ab }
            android.util.Log.e(r8, r10)     // Catch:{ Exception -> 0x02ab }
        L_0x0219:
            if (r6 <= 0) goto L_0x0220
            java.lang.String r8 = java.lang.String.valueOf(r39)     // Catch:{ Exception -> 0x02ab }
            goto L_0x0224
        L_0x0220:
            java.lang.String r8 = r35.getUbcType()     // Catch:{ Exception -> 0x02ab }
        L_0x0224:
            r19 = r8
            if (r6 <= 0) goto L_0x022d
            java.lang.String r8 = java.lang.String.valueOf(r39)     // Catch:{ Exception -> 0x02ab }
            goto L_0x0231
        L_0x022d:
            java.lang.String r8 = getType(r14)     // Catch:{ Exception -> 0x02ab }
        L_0x0231:
            r26 = r8
            if (r0 != 0) goto L_0x0263
            r0 = 1
            if (r2 == 0) goto L_0x0249
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x02ab }
            r8.<init>()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = "cardPosition"
            r8.put(r10, r6)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r10 = "personalCenterUbcEvent"
            r15 = 1
            r2.onEvent(r10, r8, r15)     // Catch:{ Exception -> 0x02ab }
        L_0x0249:
            java.lang.String r20 = getTabTipsSource(r35)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r21 = "show"
            org.json.JSONObject r22 = getExt((com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r35)     // Catch:{ Exception -> 0x02ab }
            java.lang.String r23 = r35.getUbcFrom()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r24 = r35.getUbcId()     // Catch:{ Exception -> 0x02ab }
            java.lang.String r25 = "more"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x02ab }
        L_0x0263:
            java.lang.String r27 = getTipsSource(r14, r12)     // Catch:{ Exception -> 0x02ab }
            r10 = r36
            java.lang.String r28 = getValue(r14, r10)     // Catch:{ Exception -> 0x02a4 }
            org.json.JSONObject r29 = getExt((com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r14)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r30 = getFrom(r3, r14)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r31 = r14.getUbcEventId()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r32 = getPage(r14, r13)     // Catch:{ Exception -> 0x02a4 }
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r26, r27, r28, r29, r30, r31, r32)     // Catch:{ Exception -> 0x02a4 }
        L_0x0281:
            int r13 = r13 + 1
            r7 = r16
            r8 = r17
            r10 = r18
            goto L_0x00cf
        L_0x028b:
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r36
            goto L_0x029c
        L_0x0294:
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r36
        L_0x029c:
            goto L_0x02b5
        L_0x029d:
            r0 = move-exception
            r18 = r10
            r10 = r36
        L_0x02a2:
            monitor-exit(r9)     // Catch:{ all -> 0x02a6 }
            throw r0     // Catch:{ Exception -> 0x02a4 }
        L_0x02a4:
            r0 = move-exception
            goto L_0x02ae
        L_0x02a6:
            r0 = move-exception
            goto L_0x02a2
        L_0x02a8:
            r10 = r36
        L_0x02aa:
            return
        L_0x02ab:
            r0 = move-exception
            r10 = r36
        L_0x02ae:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x02b5
            r0.printStackTrace()
        L_0x02b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger.ubcSingleInfo(com.baidu.swan.card.card.view.SwanCardView, com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel, java.lang.String, int, int, int):void");
    }

    public static String getValue(PersonalCenterTabItemModel info, String value) {
        return value;
    }

    public static String getTipsSource(PersonalCenterTabItemModel info) {
        String modelTitle = "";
        if (info.getItemType() == PersonalCenterTabItemModel.ItemType.COMMON_FUN) {
            modelTitle = MODEL_COMMON_FUNCTION;
        }
        return getTipsSource(info, modelTitle);
    }

    public static String getTipsSource(PersonalCenterTabItemModel info, String modelTitle) {
        String source = info.getUbcSource();
        boolean animatorPlayed = AnimatorIconManager.INSTANCE.requireBadgeAnimationPlayed(info.getKeyId());
        if (TextUtils.isEmpty(source)) {
            String type = info.getUbcType();
            if ("personal_show".equalsIgnoreCase(type) || "personal".equalsIgnoreCase(type) || PersonalConstants.TYPE_BIAN_MIN.equalsIgnoreCase(type) || MODEL_COMMON_FUNCTION.equals(modelTitle) || isWenYiWenData(info) || "mine".equals(type)) {
                switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType[info.getTipsType().ordinal()]) {
                    case 1:
                        source = "0";
                        break;
                    case 2:
                        String key = info.getKeyId();
                        if (!TextUtils.equals(key, "skin")) {
                            source = "1";
                            break;
                        } else {
                            TipModel tipModel = NewPersonalItemNewTip.getInstance().getTipModelByKey(key);
                            if (tipModel != null) {
                                source = tipModel.isSkinLinkPointTip() ? "5" : "1";
                                break;
                            }
                        }
                        break;
                    case 3:
                        source = "2";
                        break;
                    case 4:
                        if (!animatorPlayed) {
                            source = "3";
                            break;
                        } else {
                            source = "4";
                            break;
                        }
                }
            }
            if (info.getTipsType() == TipsType.TEXT_TIP) {
                if (animatorPlayed) {
                    source = "4";
                } else {
                    source = "3";
                }
            }
            if (!TextUtils.isEmpty(source)) {
                return source;
            }
            switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[info.getItemType().ordinal()]) {
                case 1:
                    return "history";
                case 2:
                    return "recommend";
                case 3:
                    return "guanzhu";
                case 4:
                    return "topping";
                case 5:
                    return PersonalConstants.SOURCE_SWAN_TOPPING_LIVE;
                default:
                    return source;
            }
        } else if (info.getTipsType() != TipsType.TEXT_TIP) {
            return source;
        } else {
            if (animatorPlayed) {
                return "4";
            }
            return "3";
        }
    }

    /* renamed from: com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$personal$PersonalCenterMode;

        static {
            int[] iArr = new int[PersonalCenterTabItemModel.ItemType.values().length];
            $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType = iArr;
            try {
                iArr[PersonalCenterTabItemModel.ItemType.XCX_HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[PersonalCenterTabItemModel.ItemType.XCX_RECOMMEND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[PersonalCenterTabItemModel.ItemType.XCX_FAVORITE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[PersonalCenterTabItemModel.ItemType.XCX_TOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[PersonalCenterTabItemModel.ItemType.XCX_TOPPING_LIVE.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr2 = new int[TipsType.values().length];
            $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType = iArr2;
            try {
                iArr2[TipsType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType[TipsType.DOT_TIP.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType[TipsType.NUMBER_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType[TipsType.TEXT_TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            int[] iArr3 = new int[PersonalCenterMode.values().length];
            $SwitchMap$com$baidu$searchbox$personal$PersonalCenterMode = iArr3;
            try {
                iArr3[PersonalCenterMode.PERSONAL_CENTER_FUSION.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$personal$PersonalCenterMode[PersonalCenterMode.PERSONAL_CENTER_AI.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    private static boolean isWenYiWenData(PersonalCenterTabItemModel info) {
        return info != null && TextUtils.equals("wenyiwen", info.getUbcFrom());
    }

    public static String getTabTipsSource(PersonalCenterTabModel tabModel) {
        String source = tabModel.getUbcSource();
        if (!TextUtils.isEmpty(source)) {
            return source;
        }
        switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$constants$TipsType[tabModel.getTipsType().ordinal()]) {
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3";
            default:
                return source;
        }
    }

    public static String getType(PersonalCenterTabItemModel info) {
        String type = info.getUbcType();
        if (!TextUtils.isEmpty(type)) {
            return type;
        }
        switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[info.getItemType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "mine";
            default:
                return PersonalConstants.TYPE_CHANGYONG;
        }
    }

    public static String getFrom(PersonalCenterTabModel personalCenterTabModel, PersonalCenterTabItemModel info) {
        String from = info.getUbcFrom();
        if (!TextUtils.isEmpty(from)) {
            return from;
        }
        switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[info.getItemType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "scan";
            default:
                if (personalCenterTabModel == null) {
                    return "wode";
                }
                String from2 = personalCenterTabModel.getUbcFrom();
                if (!TextUtils.isEmpty(from2)) {
                    return from2;
                }
                return "wode";
        }
    }

    public static JSONObject getExt(PersonalCenterTabItemModel info) {
        JSONObject json = new JSONObject();
        String ext = info.getUbcExt();
        if (TextUtils.isEmpty(ext)) {
            switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$kmm$personalcenter$entities$PersonalCenterTabItemModel$ItemType[info.getItemType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    ext = "appkey";
                    break;
            }
        }
        try {
            String keyId = info.getKeyId();
            String extKey = "key";
            if (TextUtils.equals("incognitomode", keyId)) {
                IncognitoModeInterface incognitoInterface = (IncognitoModeInterface) ServiceManager.getService(IncognitoModeInterface.SERVICE_REFERENCE);
                if (incognitoInterface != null && !incognitoInterface.isIncognitoSwitchOn()) {
                    extKey = PersonalConstants.KEY_EXT_IS_FIRST;
                    ext = incognitoInterface.hasSetIncognitoSwitch() ? "0" : "1";
                }
            }
            json.put(extKey, ext);
            if (AnimatorIconManager.INSTANCE.requireIconAnimationPlayed(keyId)) {
                json.put("status", "1");
            } else {
                json.put("status", "0");
            }
            String ubcFrom = info.getUbcFrom();
            String ubcExt = info.getUbcExt();
            if (TextUtils.equals("tianqi", ubcFrom) && !TextUtils.isEmpty(ubcExt)) {
                JSONObject weatherJO = new JSONObject(ubcExt);
                Iterator<String> it = weatherJO.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    json.putOpt(key, weatherJO.opt(key));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }

    public static JSONObject getExt(PersonalCenterTabModel info) {
        JSONObject json = new JSONObject();
        String ext = info.getUbcExt();
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        try {
            if (info.getTempCategory() == 7002) {
                return new JSONObject(ext);
            }
            json.put("key", ext);
            return json;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return json;
        }
    }

    public static String getPage(PersonalCenterTabItemModel info, int position) {
        return "" + (position + 1);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0) {
            this.isScrollDown = true;
        } else {
            this.isScrollDown = false;
        }
    }

    public void updateScreenIndex(String title, int screenIndex) {
        if (!TextUtils.isEmpty(title)) {
            this.mTitleScreenIndexMap.put(title, Integer.valueOf(screenIndex));
        }
    }

    public void syncScreenIndex() {
        List<PersonalCenterBaseModel> list;
        PersonalCenterTabModel model;
        if (this.mTitleScreenIndexMap.containsKey(MODEL_COMMON_FUNCTION)) {
            int position = this.mTitleScreenIndexMap.get(MODEL_COMMON_FUNCTION).intValue();
            switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$personal$PersonalCenterMode[this.mPersonalCenterMode.ordinal()]) {
                case 1:
                    list = PersonalizedDataManagerWrapper.INSTANCE.getMixFusionData();
                    break;
                case 2:
                    list = PersonalAiDataManagerWrapper.INSTANCE.getMergedGroupModels();
                    break;
                default:
                    list = PersonalizedDataManagerWrapper.INSTANCE.getMergedGroupModels();
                    break;
            }
            for (PersonalCenterBaseModel m : list) {
                if (m instanceof PersonalCenterGroupModel) {
                    PersonalCenterGroupModel groupModel = (PersonalCenterGroupModel) m;
                    List<PersonalCenterTabModel> tabs = groupModel.getPersonalCenterTabs();
                    if (!(tabs.size() == 0 || (model = tabs.get(0)) == null || !MODEL_COMMON_FUNCTION.equals(model.getTitle()))) {
                        groupModel.setCurrentScreenIndex(position);
                    }
                }
            }
        }
    }

    public void setVisible(boolean visible) {
        this.mFragmentVisible = visible;
    }

    public static float getVisibleHeightRatio(View view2) {
        Rect visibleRect = new Rect();
        boolean isVisible = view2.getLocalVisibleRect(visibleRect);
        int measuredHeight = view2.getMeasuredHeight();
        if (!isVisible || measuredHeight == 0) {
            return 0.0f;
        }
        return ((float) visibleRect.height()) / ((float) measuredHeight);
    }

    public static int getFirstTrulyVisibleItemPosition(LinearLayoutManager layoutManager) {
        if (layoutManager == null) {
            return -1;
        }
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        View firstVisibleItem = layoutManager.findViewByPosition(firstVisibleItemPosition);
        if (firstVisibleItem != null) {
            float firstShownRatio = getVisibleHeightRatio(firstVisibleItem);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "firstShownRatio of position " + firstVisibleItemPosition + " is " + firstShownRatio);
            }
            if (firstShownRatio > 0.0f && firstShownRatio < 0.5f) {
                return firstVisibleItemPosition + 1;
            }
        }
        return firstVisibleItemPosition;
    }

    public static int getLastTrulyVisibleItemPosition(LinearLayoutManager layoutManager) {
        if (layoutManager == null) {
            return -1;
        }
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        View lastVisibleItem = layoutManager.findViewByPosition(lastVisibleItemPosition);
        if (lastVisibleItem != null) {
            float lastShownRatio = getVisibleHeightRatio(lastVisibleItem);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "lastShownRatio of position " + lastVisibleItemPosition + " is " + lastShownRatio);
            }
            if (lastShownRatio > 0.0f && lastShownRatio < 0.5f) {
                return lastVisibleItemPosition - 1;
            }
        }
        return lastVisibleItemPosition;
    }
}
