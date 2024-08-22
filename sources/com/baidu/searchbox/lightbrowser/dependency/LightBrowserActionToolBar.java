package com.baidu.searchbox.lightbrowser.dependency;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.appframework.ext.ToolBarExtKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.imsdk.ImMsgControl;
import com.baidu.searchbox.lightbrowser.IntentConstant;
import com.baidu.searchbox.lightbrowser.container.LightBrowserContainer;
import com.baidu.searchbox.lightbrowser.container.presenter.BottomBarComponent;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserActionToolBar;
import com.baidu.searchbox.praise.PraiseEffectType;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.toolbar.PraiseToolBarItem;
import com.baidu.searchbox.toolbar.WendaToolBarItem;
import com.baidu.searchbox.unifiedtoolbar.base.BadgeBackgroundStyle;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LightBrowserActionToolBar implements ILightBrowserActionToolBar {
    public List<BaseToolBarItem> getToolBarItemList(LightBrowserContainer container) {
        if (container == null) {
            return null;
        }
        List<BaseToolBarItem> items = new ArrayList<>();
        items.add(new BaseToolBarItem(1));
        if (container.getIntent().hasExtra("toolbaricons") && !FeedConfig.isTeenagerMode()) {
            items.add(new BaseToolBarItem(18));
            items.add(new BaseToolBarItem(10));
            items.add(new BaseToolBarItem(7));
            items.add(new PraiseToolBarItem(13, true, false));
            items.add(new WendaToolBarItem(14));
            items.add(new BaseToolBarItem(8));
            items.add(new BaseToolBarItem(23));
            items.add(new BaseToolBarItem(15));
            items.add(new BaseToolBarItem(25));
            items.add(new BaseToolBarItem(26));
            items.add(new BaseToolBarItem(17));
            items.add(new BaseToolBarItem(9));
            items.add(new BaseToolBarItem(2));
        }
        return items;
    }

    public boolean onToolBarItemClick(LightBrowserContainer container, View view2, BaseToolBarItem item) {
        if (container == null) {
            return false;
        }
        switch (item.getItemId()) {
            case 2:
                container.onHomeClick(view2.getContext());
                return true;
            case 7:
                container.onCommentsClick();
                return true;
            case 8:
                container.onStarClick();
                return true;
            case 9:
                container.onShareClick("bar");
                return true;
            case 10:
                container.onCommentInputClick();
                return false;
            case 13:
                container.onPraiseClick();
                return true;
            case 14:
                container.onWendaClick(item);
                return true;
            case 15:
                container.onForwardingClick();
                return true;
            case 17:
                container.onActionBarMenuPressed();
                return true;
            case 18:
                container.onCloseClick();
                return true;
            default:
                return false;
        }
    }

    public void configToolBarByIntent(BottomBarComponent bottomBar, Intent intent) {
        if (intent != null) {
            configToolBarStyle(bottomBar, intent);
            importantEventPraiseConfig(bottomBar, intent);
        }
    }

    private void configToolBarStyle(BottomBarComponent bottomBar, Intent intent) {
        if (bottomBar != null && intent != null && intent.hasExtra("toolbaricons")) {
            try {
                String mContextJsonStr = intent.getStringExtra("context");
                if (!TextUtils.isEmpty(mContextJsonStr)) {
                    bottomBar.setNid(new JSONObject(mContextJsonStr).optString("nid"));
                }
            } catch (JSONException e2) {
            }
            String icons = intent.getStringExtra("toolbaricons");
            if (bottomBar.isFunctionBottomBar(icons)) {
                bottomBar.configFunctionBottomBar(icons);
                return;
            }
            try {
                JSONObject toolStyleObject = new JSONObject(intent.getStringExtra("toolbaricons")).optJSONObject("type");
                if (toolStyleObject != null) {
                    Iterator<String> iterator = toolStyleObject.keys();
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        configToolBarItemStyle(bottomBar, ToolBarExtKt.getToolBarItemId(key), toolStyleObject.optString(key));
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void configToolBarItemStyle(BottomBarComponent bottomBar, int item, String style) {
        if (bottomBar != null) {
            switch (item) {
                case 13:
                    bottomBar.updatePraiseIconByType(style);
                    return;
                default:
                    return;
            }
        }
    }

    private void importantEventPraiseConfig(BottomBarComponent bottomBar, Intent intent) {
        BadgeBackgroundStyle style;
        if (bottomBar != null && intent != null && intent.hasExtra(IntentConstant.EXTRA_PRAISE_CONFIG)) {
            String iconName = null;
            String disAnimation = null;
            String tipsStyle = null;
            String animName = null;
            String animType = null;
            String praiseConfig = intent.getStringExtra(IntentConstant.EXTRA_PRAISE_CONFIG);
            if (!TextUtils.isEmpty(praiseConfig)) {
                try {
                    JSONObject jsonObject = new JSONObject(praiseConfig);
                    iconName = jsonObject.optString("icon");
                    disAnimation = jsonObject.optString(IntentConstant.EXTRA_PRAISE_DISABLE_ANIM);
                    tipsStyle = jsonObject.optString(IntentConstant.EXTRA_PRAISE_TIPS_STYLE);
                    animName = jsonObject.optString("animation_name");
                    animType = PraiseEffectType.map(jsonObject.optString("animation_type"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.equals(tipsStyle, "1")) {
                style = BadgeBackgroundStyle.GRAY;
            } else {
                style = BadgeBackgroundStyle.NORMAL;
            }
            bottomBar.updatePraiseIconByImportantEvent(iconName, disAnimation, style);
            bottomBar.setPraiseAnimInfo(animName, animType);
        }
    }

    /* renamed from: com.baidu.searchbox.lightbrowser.dependency.LightBrowserActionToolBar$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID;

        static {
            int[] iArr = new int[BottomBarElementID.values().length];
            $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID = iArr;
            try {
                iArr[BottomBarElementID.ELEMENT_ID_COMMENT_ICON.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_COMMENT_INPUT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_FAVOR.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_PRAISE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_SHARE.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_3.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public boolean onBottomBarItemClick(LightBrowserContainer container, BarElementClickContext context) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[context.getElementId().ordinal()]) {
            case 1:
                container.onCommentsClick();
                return true;
            case 2:
                container.onCommentInputClick();
                return true;
            case 3:
                container.onStarClick();
                return true;
            case 4:
                container.onPraiseClick();
                return true;
            case 5:
                container.onShareClick("bar");
                return true;
            case 6:
            case 7:
            case 8:
                if (container.getBottomBar() == null) {
                    return false;
                }
                container.loadJavaScript(container.getBottomBar().getFuncBottomBarEvent(context.getElementId()));
                return true;
            default:
                return false;
        }
    }

    public long getMessageUnreadCount() {
        return ImMsgControl.getInstance(AppRuntime.getAppContext()).getImChatUnreadCount(0);
    }
}
