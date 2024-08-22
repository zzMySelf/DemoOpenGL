package com.baidu.spswitch.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.adapter.viewholder.EmotionFavorHolder;
import com.baidu.spswitch.emotion.adapter.viewholder.EmotionImageHolder;
import com.baidu.spswitch.emotion.bean.EmojiFavorItemModel;
import com.baidu.spswitch.emotion.bean.EmotionPreviewModel;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.emotion.net.EmotionRequest;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;

public class EmotionPreviewHandler {
    private static final int DIVIDER_HEIGHT = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f);
    private static final String TAG = "EmotionPreviewHandler";
    private static final int TRIANGLE_DIFF = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 7.0f);
    private int mActivePointerId;
    private final Context mContext;
    /* access modifiers changed from: private */
    public int mCurPos;
    private int mCutOffItemHeight;
    private int mExtraHeight = 10;
    private boolean mIsItemPosInited;
    private boolean mIsLongPressed;
    private int mItemHeightWithPadding;
    private int mItemHorizontalDiff;
    private int mItemWidthWithPadding;
    protected EmotionPanelConfig mPanelConfig;
    /* access modifiers changed from: private */
    public final PopupEmotionManager mPopupEmotionManager;
    private int mPos;
    private int[] mPressedItemPos;
    private int[] mPressedItemRowCol;
    /* access modifiers changed from: private */
    public EmotionPreviewModel mPressedModel;
    private View mPressedView;
    /* access modifiers changed from: private */
    public final RecyclerView mRecyclerView;
    private final int mSpanCount;
    protected EmotionTypeModel mTypeModel;
    private RectF mValidLongPressedRect;
    private boolean mValidTouch;
    private BDEmotionDynamicAdapter.BaseEmotionHolder mViewHolder;

    public EmotionPreviewHandler(Context context, RecyclerView recyclerView, int spanCount) {
        this.mContext = context;
        this.mPopupEmotionManager = new PopupEmotionManager(context);
        this.mSpanCount = spanCount;
        this.mRecyclerView = recyclerView;
        initListeners();
    }

    public void initListeners() {
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (EmotionPreviewHandler.this.mPopupEmotionManager != null && EmotionPreviewHandler.this.mPopupEmotionManager.isShowing()) {
                    EmotionPreviewHandler.this.mPopupEmotionManager.dismiss();
                }
            }
        });
        this.mPopupEmotionManager.setPopupEmotionListener(new PopupEmotionManager.IPopupEmotionListener() {
            public void show(int sectionType, String exprName, int exprRow, int exprCol) {
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    String access$200 = emotionPreviewHandler.getPreViewEmotionUbcType(emotionPreviewHandler.mPressedModel.getPreviewEmotionType());
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler2 = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, access$200, str2, str3, "", emotionPreviewHandler2.getPreViewEmotionUbcId(emotionPreviewHandler2.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionConfirmDeleteClick() {
                BDEmotionDynamicAdapter adapter = (BDEmotionDynamicAdapter) EmotionPreviewHandler.this.mRecyclerView.getAdapter();
                if (adapter != null && (adapter.getDataByPos(EmotionPreviewHandler.this.mCurPos) instanceof EmojiFavorItemModel)) {
                    EmojiFavorItemModel model = (EmojiFavorItemModel) adapter.getDataByPos(EmotionPreviewHandler.this.mCurPos);
                    adapter.deleteSingleEmotionByPosition(EmotionPreviewHandler.this.mCurPos);
                    if (model != null) {
                        EmotionPreviewHandler.this.requestDeleteFavorEmotion(model);
                    }
                }
                EmotionPreviewHandler.this.dismissEmotionPopUp();
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_CONFIRM_DELETE_CLICK, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionDeleteClick() {
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_DELETE_CLICK, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionMoveToFirstClick() {
                BDEmotionDynamicAdapter adapter = (BDEmotionDynamicAdapter) EmotionPreviewHandler.this.mRecyclerView.getAdapter();
                if (adapter != null) {
                    EmojiFavorItemModel model = (EmojiFavorItemModel) adapter.getDataByPos(EmotionPreviewHandler.this.mCurPos);
                    adapter.stickFavorEmotionByPosition(EmotionPreviewHandler.this.mCurPos);
                    if (model != null) {
                        EmotionPreviewHandler.this.requestAddFavorEmotion(model);
                    }
                }
                EmotionPreviewHandler.this.dismissEmotionPopUp();
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_MOVE_CLICK, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionConfirmDeleteShow() {
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_CONFIRM_DELETE_SHOW, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionDeleteShow() {
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_DELETE_SHOW, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }

            public void emotionMoveToFirstShow() {
                if (EmotionPreviewHandler.this.mPressedModel != null && EmotionPreviewHandler.this.mPanelConfig != null && EmotionPreviewHandler.this.mTypeModel != null) {
                    String str = EmotionPreviewHandler.this.mPanelConfig.from;
                    String str2 = EmotionPreviewHandler.this.mPanelConfig.page;
                    String str3 = EmotionPreviewHandler.this.mPanelConfig.source;
                    EmotionPreviewHandler emotionPreviewHandler = EmotionPreviewHandler.this;
                    EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_EMOJI_MOVE_SHOW, str2, str3, "", emotionPreviewHandler.getPreViewEmotionUbcId(emotionPreviewHandler.mPressedModel.getPreviewEmotionType()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String getPreViewEmotionUbcId(String previewEmotionType) {
        if (previewEmotionType == null) {
            return null;
        }
        char c2 = 65535;
        switch (previewEmotionType.hashCode()) {
            case 97205822:
                if (previewEmotionType.equals("favor")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2124767295:
                if (previewEmotionType.equals("dynamic")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (this.mPressedModel == null || this.mTypeModel == null) {
                    return null;
                }
                return this.mTypeModel.getId() + "-" + this.mPressedModel.getId();
            case 1:
                if (this.mPressedModel != null) {
                    return "favorite-" + this.mPressedModel.getId();
                }
                return null;
            default:
                return null;
        }
    }

    /* access modifiers changed from: private */
    public String getPreViewEmotionUbcType(String previewEmotionType) {
        if (previewEmotionType == null) {
            return null;
        }
        char c2 = 65535;
        switch (previewEmotionType.hashCode()) {
            case 97205822:
                if (previewEmotionType.equals("favor")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2124767295:
                if (previewEmotionType.equals("dynamic")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return EmotionUbcHelper.TYPE_MEME_PRESS;
            case 1:
                return EmotionUbcHelper.TYPE_FAVOR_PRESS;
            default:
                return null;
        }
    }

    /* access modifiers changed from: private */
    public void requestDeleteFavorEmotion(EmojiFavorItemModel model) {
        int lastIndex;
        String suffix = "";
        if (model.isGif() && !TextUtils.isEmpty(model.getImgUrl()) && (lastIndex = model.getImgUrl().lastIndexOf(".")) < model.getImgUrl().length() - 1) {
            suffix = model.getImgUrl().substring(lastIndex + 1);
        }
        EmotionRequest.operateFavor(model.getId(), model.getType(), suffix, String.valueOf(model.getImgWidth()), String.valueOf(model.getImgHeight()), "del");
    }

    /* access modifiers changed from: private */
    public void requestAddFavorEmotion(EmojiFavorItemModel model) {
        int lastIndex;
        String suffix = "";
        if (model.isGif() && !TextUtils.isEmpty(model.getImgUrl()) && (lastIndex = model.getImgUrl().lastIndexOf(".")) < model.getImgUrl().length() - 1) {
            suffix = model.getImgUrl().substring(lastIndex + 1);
        }
        EmotionRequest.operateFavor(model.getId(), model.getType(), suffix, String.valueOf(model.getImgWidth()), String.valueOf(model.getImgHeight()), "add");
    }

    public void setPanelConfig(EmotionPanelConfig panelConfig) {
        this.mPanelConfig = panelConfig;
    }

    public void setTypeModel(EmotionTypeModel typeModel) {
        this.mTypeModel = typeModel;
    }

    public boolean onTouch(View view2, MotionEvent event) {
        int actionPointerId = event.getPointerId(event.getActionIndex());
        switch (event.getAction()) {
            case 0:
                this.mActivePointerId = actionPointerId;
                this.mValidTouch = true;
                break;
            case 1:
                return releaseLongPressedIfNecessary(view2, event);
            case 2:
                if (this.mValidTouch && this.mActivePointerId == actionPointerId && this.mIsLongPressed) {
                    showLongPressedIfNecessary(event.getRawX(), event.getRawY());
                    return true;
                }
            case 5:
            case 6:
                this.mValidTouch = false;
                break;
        }
        return false;
    }

    public void onLongClick(View view2, int position, Object data) {
        if (view2 != null && (data instanceof EmotionPreviewModel) && this.mSpanCount > 1) {
            this.mItemWidthWithPadding = this.mRecyclerView.getWidth() / this.mSpanCount;
            int width = this.mRecyclerView.getWidth();
            int width2 = view2.getWidth();
            int i2 = this.mSpanCount;
            this.mItemHorizontalDiff = (width - (width2 * i2)) / (i2 - 1);
            this.mItemHeightWithPadding = view2.getHeight() + DIVIDER_HEIGHT;
            this.mIsLongPressed = true;
            this.mPressedView = view2;
            this.mPressedModel = (EmotionPreviewModel) data;
            this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
            this.mPopupEmotionManager.reset();
            this.mPos = position;
        }
    }

    private boolean releaseLongPressedIfNecessary(View v, MotionEvent event) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "releaseLongPressedIfNecessary: mIsLongPressed " + this.mIsLongPressed);
        }
        setBackGround(this.mCurPos, false);
        if (!this.mIsLongPressed) {
            return false;
        }
        this.mIsLongPressed = false;
        this.mIsItemPosInited = false;
        this.mRecyclerView.requestDisallowInterceptTouchEvent(false);
        dismissLongPressedIfNecessary();
        event.setAction(3);
        v.dispatchTouchEvent(event);
        return true;
    }

    private void showLongPressedIfNecessary(float rawX, float rawY) {
        int[] rowColDiff;
        int[] rowCol;
        EmotionPreviewModel emotionPreviewModel;
        if (this.mIsLongPressed && this.mPopupEmotionManager != null && this.mRecyclerView != null && this.mItemWidthWithPadding != 0) {
            RectF validRect = getValidLongPressedRect();
            if (validRect != null && !validRect.contains((float) ((int) rawX), (float) ((int) rawY))) {
                return;
            }
            if (!this.mPopupEmotionManager.isPostRunning()) {
                if (!this.mIsItemPosInited) {
                    this.mIsItemPosInited = true;
                    int[] iArr = new int[2];
                    this.mPressedItemPos = iArr;
                    this.mPressedView.getLocationOnScreen(iArr);
                    if (DeviceUtils.ScreenInfo.isScreenLand()) {
                        Rect rect = new Rect();
                        this.mPressedView.getGlobalVisibleRect(rect);
                        this.mPressedItemPos[0] = rect.left;
                    }
                    this.mPressedItemRowCol = getIconRowAndColIndex(rawX, rawY);
                    rowCol = this.mPressedItemRowCol;
                    rowColDiff = new int[]{0, 0};
                } else {
                    rowCol = getIconRowAndColIndex(rawX, rawY);
                    int i2 = rowCol[0];
                    int[] iArr2 = this.mPressedItemRowCol;
                    rowColDiff = new int[]{i2 - iArr2[0], rowCol[1] - iArr2[1]};
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "showLongPressedIfNecessary: " + this.mPressedItemPos[0] + " " + this.mPressedItemPos[1] + " rowColDiff " + rowColDiff[0] + " " + rowColDiff[1]);
                }
                if (rowCol[0] < 0 || rowCol[1] < 0) {
                    dismissEmotionPopUp();
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "showLongPressedIfNecessary: row or col < 0 ");
                        return;
                    }
                    return;
                }
                updatePressedModel(rowCol[0], rowCol[1]);
                setBackGround(this.mCurPos, true);
                EmotionPreviewModel emotionPreviewModel2 = this.mPressedModel;
                String previewEmotionType = "";
                String exprName = emotionPreviewModel2 != null ? emotionPreviewModel2.getText() : previewEmotionType;
                if (!TextUtils.isEmpty(exprName) || (emotionPreviewModel = this.mPressedModel) == null || !TextUtils.equals(emotionPreviewModel.getPreviewEmotionType(), "dynamic")) {
                    EmotionPreviewModel emotionPreviewModel3 = this.mPressedModel;
                    if (emotionPreviewModel3 != null) {
                        previewEmotionType = emotionPreviewModel3.getPreviewEmotionType();
                    }
                    show(rowCol, rowColDiff, exprName, previewEmotionType);
                    return;
                }
                dismissEmotionPopUp();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "showLongPressedIfNecessary:  exprName is null");
                }
            } else if (AppConfig.isDebug()) {
                Log.d(TAG, "showLongPressedIfNecessary: isRunning " + this.mPopupEmotionManager.isPostRunning() + " isShowing " + this.mPopupEmotionManager.isShowing());
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "showLongPressedIfNecessary: mIsLongPressed " + this.mIsLongPressed);
        }
    }

    private void show(int[] rowCol, int[] rowColDiff, String exprName, String previewType) {
        PopupEmotionManager.ShowParam showParam = new PopupEmotionManager.ShowParam();
        showParam.sectionType = -1;
        showParam.exprRow = rowCol[0];
        showParam.exprCol = rowCol[1];
        showParam.anchorWidth = this.mPressedView.getWidth();
        showParam.isLastCol = rowCol[1] == this.mSpanCount - 1;
        showParam.anchorXpos = this.mPressedItemPos[0] + (rowColDiff[1] * (this.mPressedView.getWidth() + this.mItemHorizontalDiff));
        if (rowCol[0] == 0) {
            showParam.anchorYpos = ((this.mPressedItemPos[1] + (rowColDiff[0] * this.mItemHeightWithPadding)) - TRIANGLE_DIFF) + this.mCutOffItemHeight;
        } else {
            showParam.anchorYpos = (this.mPressedItemPos[1] + (rowColDiff[0] * this.mItemHeightWithPadding)) - TRIANGLE_DIFF;
        }
        showParam.exprName = exprName;
        showParam.exprBitmap = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, showParam.exprName);
        EmotionPreviewModel emotionPreviewModel = this.mPressedModel;
        showParam.exprBitmapUrl = emotionPreviewModel != null ? emotionPreviewModel.getImgUrl() : null;
        showParam.previewType = previewType;
        this.mPopupEmotionManager.show(showParam);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = ((androidx.recyclerview.widget.LinearLayoutManager) r10.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] getIconRowAndColIndex(float r11, float r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            androidx.recyclerview.widget.RecyclerView r2 = r10.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            boolean r2 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r2 == 0) goto L_0x003b
            androidx.recyclerview.widget.RecyclerView r2 = r10.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r2 = (androidx.recyclerview.widget.LinearLayoutManager) r2
            int r1 = r2.findFirstVisibleItemPosition()
            androidx.recyclerview.widget.RecyclerView r2 = r10.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            android.view.View r2 = r2.findViewByPosition(r1)
            if (r2 == 0) goto L_0x003b
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r2.getGlobalVisibleRect(r3)
            int r4 = r3.bottom
            int r5 = r3.top
            int r0 = r4 - r5
            android.view.View r4 = r10.mPressedView
            int r4 = r4.getHeight()
            int r4 = r4 - r0
            r10.mCutOffItemHeight = r4
        L_0x003b:
            r2 = 2
            int[] r3 = new int[r2]
            androidx.recyclerview.widget.RecyclerView r4 = r10.mRecyclerView
            r4.getLocationOnScreen(r3)
            r4 = 0
            r5 = r3[r4]
            float r5 = (float) r5
            float r11 = r11 - r5
            r5 = 1
            r6 = r3[r5]
            float r6 = (float) r6
            float r12 = r12 - r6
            r6 = 0
            if (r1 != 0) goto L_0x0066
            float r7 = (float) r0
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x005b
            int[] r2 = new int[r2]
            r2 = {-1, -1} // fill-array
            return r2
        L_0x005b:
            r10.mCutOffItemHeight = r4
            float r7 = (float) r0
            float r7 = r12 - r7
            int r7 = (int) r7
            int r8 = r10.mItemHeightWithPadding
            int r6 = r7 / r8
            goto L_0x007d
        L_0x0066:
            float r7 = (float) r0
            int r8 = DIVIDER_HEIGHT
            float r8 = (float) r8
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            float r7 = r7 + r8
            int r7 = (int) r7
            float r8 = (float) r7
            int r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x007d
            float r8 = (float) r7
            float r8 = r12 - r8
            int r8 = (int) r8
            int r9 = r10.mItemHeightWithPadding
            int r8 = r8 / r9
            int r6 = r8 + 1
        L_0x007d:
            int r7 = (int) r11
            int r8 = r10.mItemWidthWithPadding
            int r7 = r7 / r8
            boolean r8 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r8 == 0) goto L_0x00c7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "getIconRowAndColIndex: x "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r11)
            java.lang.String r9 = " y "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r12)
            java.lang.String r9 = " colIndex "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r7)
            java.lang.String r9 = " rowIndex "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r6)
            java.lang.String r9 = " cutOffHeight "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "EmotionPreviewHandler"
            android.util.Log.d(r9, r8)
        L_0x00c7:
            int[] r2 = new int[r2]
            r8 = -1
            if (r6 >= 0) goto L_0x00ce
            r9 = r8
            goto L_0x00cf
        L_0x00ce:
            r9 = r6
        L_0x00cf:
            r2[r4] = r9
            int r4 = r10.mSpanCount
            if (r7 < r4) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r8 = r7
        L_0x00d7:
            r2[r5] = r8
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.spswitch.utils.EmotionPreviewHandler.getIconRowAndColIndex(float, float):int[]");
    }

    private void updatePressedModel(int rowIndex, int colIndex) {
        int i2;
        if ((this.mRecyclerView.getAdapter() instanceof BDEmotionDynamicAdapter) && rowIndex >= 0 && colIndex >= 0) {
            int beforeIndex = this.mCurPos;
            BDEmotionDynamicAdapter adapter = (BDEmotionDynamicAdapter) this.mRecyclerView.getAdapter();
            int i3 = this.mPos;
            int[] iArr = this.mPressedItemRowCol;
            this.mCurPos = i3 + ((rowIndex - iArr[0]) * this.mSpanCount) + (colIndex - iArr[1]);
            if (!(this.mCurPos == beforeIndex || beforeIndex == 0)) {
                setBackGround(beforeIndex, false);
            }
            if (!(adapter.getDataByPos(this.mCurPos) instanceof EmotionPreviewModel) || (i2 = this.mCurPos) < 0) {
                dismissEmotionPopUp();
                this.mPressedModel = null;
                return;
            }
            EmotionPreviewModel model = (EmotionPreviewModel) adapter.getDataByPos(i2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "getExpressionName: text " + model.getText() + " id " + model.getId() + " pos " + this.mCurPos);
            }
            this.mPressedModel = model;
        }
    }

    private void dismissLongPressedIfNecessary() {
        EmotionPreviewModel emotionPreviewModel;
        if (this.mPopupEmotionManager != null && (emotionPreviewModel = this.mPressedModel) != null && !TextUtils.equals(emotionPreviewModel.getPreviewEmotionType(), "favor")) {
            this.mPopupEmotionManager.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void dismissEmotionPopUp() {
        PopupEmotionManager popupEmotionManager = this.mPopupEmotionManager;
        if (popupEmotionManager != null) {
            popupEmotionManager.dismiss();
        }
    }

    private RectF getValidLongPressedRect() {
        RectF rectF = this.mValidLongPressedRect;
        if (rectF != null) {
            return rectF;
        }
        if (this.mRecyclerView == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19 && !this.mRecyclerView.isLaidOut()) {
            return null;
        }
        int[] leftTop = new int[2];
        this.mRecyclerView.getLocationOnScreen(leftTop);
        RectF rectF2 = new RectF((float) leftTop[0], (float) leftTop[1], (float) (leftTop[0] + this.mRecyclerView.getWidth()), (float) (leftTop[1] + this.mRecyclerView.getHeight()));
        this.mValidLongPressedRect = rectF2;
        return rectF2;
    }

    private void setBackGround(int position, boolean pressed) {
        BDEmotionDynamicAdapter.BaseEmotionHolder baseEmotionHolder = (BDEmotionDynamicAdapter.BaseEmotionHolder) this.mRecyclerView.findViewHolderForAdapterPosition(position);
        this.mViewHolder = baseEmotionHolder;
        if ((baseEmotionHolder instanceof EmotionImageHolder) || (baseEmotionHolder instanceof EmotionFavorHolder)) {
            baseEmotionHolder.setPressedBackGround(pressed);
        }
    }
}
