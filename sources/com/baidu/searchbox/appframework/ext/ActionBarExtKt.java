package com.baidu.searchbox.appframework.ext;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.ui.BdActionBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u0012\u0010>\u001a\u00020!*\u00020\u00112\u0006\u0010?\u001a\u00020!\u001a\u0012\u0010@\u001a\u00020A*\u00020\u00112\u0006\u0010B\u001a\u00020-\u001a\u0014\u0010C\u001a\u00020A*\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010E\u001a\u0014\u0010F\u001a\u00020A*\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010E\u001a\n\u0010G\u001a\u00020A*\u00020\u0011\u001a\n\u0010H\u001a\u00020A*\u00020\u0011\u001a\u0012\u0010I\u001a\u00020A*\u00020\u00112\u0006\u0010B\u001a\u00020-\u001a\u0012\u0010J\u001a\u00020A*\u00020\u00112\u0006\u0010K\u001a\u00020\u0004\u001a\u001a\u0010J\u001a\u00020A*\u00020\u00112\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020'\u001a\u0012\u0010M\u001a\u00020A*\u00020\u00112\u0006\u0010N\u001a\u00020\u0004\u001a\u001a\u0010M\u001a\u00020A*\u00020\u00112\u0006\u0010N\u001a\u00020\u00042\u0006\u0010L\u001a\u00020'\u001a\u0012\u0010O\u001a\u00020A*\u00020\u00112\u0006\u0010P\u001a\u00020\u0004\u001a\u0012\u0010Q\u001a\u00020A*\u00020\u00112\u0006\u0010R\u001a\u00020\u0004\u001a\u0012\u0010S\u001a\u00020A*\u00020\u00112\u0006\u0010N\u001a\u00020\u0004\u001a\u0012\u0010T\u001a\u00020A*\u00020\u00112\u0006\u0010U\u001a\u00020-\u001a\u0012\u0010V\u001a\u00020A*\u00020\u00112\u0006\u0010U\u001a\u00020-\u001a\n\u0010W\u001a\u00020A*\u00020\u0011\u001a\n\u0010X\u001a\u00020A*\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"(\u0010\u0010\u001a\u00020\u0004*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"(\u0010\u0017\u001a\u00020\u0004*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\",\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\",\u0010 \u001a\u0004\u0018\u00010!*\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!8F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\",\u0010&\u001a\u0004\u0018\u00010'*\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'8F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\"(\u0010,\u001a\u00020-*\u00020\u00112\u0006\u0010,\u001a\u00020-8F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\",\u00104\u001a\u0004\u0018\u000103*\u00020\u00112\b\u00102\u001a\u0004\u0018\u0001038F@FX\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108\",\u00109\u001a\u0004\u0018\u00010!*\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010!8F@FX\u000e¢\u0006\f\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%\"(\u0010<\u001a\u00020-*\u00020\u00112\u0006\u0010<\u001a\u00020-8F@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010/\"\u0004\b=\u00101¨\u0006Y"}, d2 = {"ACTION_BAR_STYLE_DARK", "", "ACTION_BAR_STYLE_LIGHT", "BDACTION_BAR_BABKGROUND_TYPE_COLOR", "", "BDACTION_BAR_BACKGROUND_TYPE_DRAWABLE", "CONTEXT_ACTION_BAR_ANIM_DURATION", "", "EXTRA_ACTIONBAR_BACKGROUND_COLOR", "EXTRA_ACTIONBAR_BACKGROUND_COLOR_STRING", "EXTRA_ACTIONBAR_BACK_BTN_STYLE", "EXTRA_ACTIONBAR_LEFT_TITLE", "EXTRA_SHOW_TITLE_BAR_KEY", "NOT_SHOW", "SCHEME_ACTIONBAR_COLOR_KEY", "SHOW", "actionBarBGDrawableId", "Lcom/baidu/searchbox/appframework/ext/IActionBarExt;", "getActionBarBGDrawableId", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)I", "setActionBarBGDrawableId", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;I)V", "actionBarType", "actionBarBGType", "getActionBarBGType", "setActionBarBGType", "actionBarContainer", "Landroid/widget/FrameLayout;", "getActionBarContainer", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)Landroid/widget/FrameLayout;", "setActionBarContainer", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;Landroid/widget/FrameLayout;)V", "actionBarShadow", "Landroid/view/View;", "getActionBarShadow", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)Landroid/view/View;", "setActionBarShadow", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;Landroid/view/View;)V", "actionBarTemplate", "Lcom/baidu/searchbox/ui/BdActionBar$ActionbarTemplate;", "getActionBarTemplate", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)Lcom/baidu/searchbox/ui/BdActionBar$ActionbarTemplate;", "setActionBarTemplate", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;Lcom/baidu/searchbox/ui/BdActionBar$ActionbarTemplate;)V", "actionBarVisible", "", "getActionBarVisible", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)Z", "setActionBarVisible", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;Z)V", "actionBar", "Lcom/baidu/searchbox/ui/BdActionBar;", "bdActionBar", "getBdActionBar", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;)Lcom/baidu/searchbox/ui/BdActionBar;", "setBdActionBar", "(Lcom/baidu/searchbox/appframework/ext/IActionBarExt;Lcom/baidu/searchbox/ui/BdActionBar;)V", "contextActionBar", "getContextActionBar", "setContextActionBar", "isStyleChangeing", "setStyleChangeing", "addActionBar", "contentView", "closeContextActionBar", "", "doAnim", "handleActionBarDataFromIntent", "intent", "Landroid/content/Intent;", "handleShowActionBarFromIntent", "initActionBar", "initContextActionBar", "openContextActionBar", "setActionBarBackground", "resid", "template", "setActionBarBackgroundColor", "color", "setActionBarGravity", "gravity", "setActionBarParentHeight", "height", "setShadowBackgroundColor", "showActionBar", "show", "showActionBarShadow", "showActionBarWithoutLeft", "updateActionBarUI", "lib-appframework-actionbarext_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionBarExt.kt */
public final class ActionBarExtKt {
    public static final String ACTION_BAR_STYLE_DARK = "dark";
    public static final String ACTION_BAR_STYLE_LIGHT = "light";
    public static final int BDACTION_BAR_BABKGROUND_TYPE_COLOR = 1;
    public static final int BDACTION_BAR_BACKGROUND_TYPE_DRAWABLE = 0;
    public static final long CONTEXT_ACTION_BAR_ANIM_DURATION = 200;
    public static final String EXTRA_ACTIONBAR_BACKGROUND_COLOR = "extra_actionbar_color_id";
    public static final String EXTRA_ACTIONBAR_BACKGROUND_COLOR_STRING = "extra_actionbar_color_str";
    public static final String EXTRA_ACTIONBAR_BACK_BTN_STYLE = "extra_actionbar_back_btn_style";
    public static final String EXTRA_ACTIONBAR_LEFT_TITLE = "extra_actionbar_left_title";
    public static final String EXTRA_SHOW_TITLE_BAR_KEY = "showtitlebar";
    public static final String NOT_SHOW = "0";
    public static final String SCHEME_ACTIONBAR_COLOR_KEY = "barcolor";
    public static final String SHOW = "1";

    public static final BdActionBar getBdActionBar(IActionBarExt $this$bdActionBar) {
        Intrinsics.checkNotNullParameter($this$bdActionBar, "<this>");
        Object actionBarExtObject = $this$bdActionBar.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getBdActionBar();
        }
        return null;
    }

    public static final void setBdActionBar(IActionBarExt $this$bdActionBar, BdActionBar actionBar) {
        Intrinsics.checkNotNullParameter($this$bdActionBar, "<this>");
        if ($this$bdActionBar.getActionBarExtObject() == null) {
            $this$bdActionBar.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$bdActionBar.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setBdActionBar(actionBar);
        }
    }

    public static final View getActionBarShadow(IActionBarExt $this$actionBarShadow) {
        Intrinsics.checkNotNullParameter($this$actionBarShadow, "<this>");
        Object actionBarExtObject = $this$actionBarShadow.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarShadow();
        }
        return null;
    }

    public static final void setActionBarShadow(IActionBarExt $this$actionBarShadow, View actionBarShadow) {
        Intrinsics.checkNotNullParameter($this$actionBarShadow, "<this>");
        if ($this$actionBarShadow.getActionBarExtObject() == null) {
            $this$actionBarShadow.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarShadow.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarShadow(actionBarShadow);
        }
    }

    public static final FrameLayout getActionBarContainer(IActionBarExt $this$actionBarContainer) {
        Intrinsics.checkNotNullParameter($this$actionBarContainer, "<this>");
        Object actionBarExtObject = $this$actionBarContainer.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarContainer();
        }
        return null;
    }

    public static final void setActionBarContainer(IActionBarExt $this$actionBarContainer, FrameLayout actionBarContainer) {
        Intrinsics.checkNotNullParameter($this$actionBarContainer, "<this>");
        if ($this$actionBarContainer.getActionBarExtObject() == null) {
            $this$actionBarContainer.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarContainer.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarContainer(actionBarContainer);
        }
    }

    public static final boolean getActionBarVisible(IActionBarExt $this$actionBarVisible) {
        Intrinsics.checkNotNullParameter($this$actionBarVisible, "<this>");
        Object actionBarExtObject = $this$actionBarVisible.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarVisible();
        }
        return true;
    }

    public static final void setActionBarVisible(IActionBarExt $this$actionBarVisible, boolean actionBarVisible) {
        Intrinsics.checkNotNullParameter($this$actionBarVisible, "<this>");
        if ($this$actionBarVisible.getActionBarExtObject() == null) {
            $this$actionBarVisible.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarVisible.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarVisible(actionBarVisible);
        }
    }

    public static final BdActionBar.ActionbarTemplate getActionBarTemplate(IActionBarExt $this$actionBarTemplate) {
        Intrinsics.checkNotNullParameter($this$actionBarTemplate, "<this>");
        Object actionBarExtObject = $this$actionBarTemplate.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarTemplate();
        }
        return null;
    }

    public static final void setActionBarTemplate(IActionBarExt $this$actionBarTemplate, BdActionBar.ActionbarTemplate actionBarTemplate) {
        Intrinsics.checkNotNullParameter($this$actionBarTemplate, "<this>");
        if ($this$actionBarTemplate.getActionBarExtObject() == null) {
            $this$actionBarTemplate.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarTemplate.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarTemplate(actionBarTemplate);
        }
    }

    public static final int getActionBarBGDrawableId(IActionBarExt $this$actionBarBGDrawableId) {
        Intrinsics.checkNotNullParameter($this$actionBarBGDrawableId, "<this>");
        Object actionBarExtObject = $this$actionBarBGDrawableId.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarBGDrawableId();
        }
        return -1;
    }

    public static final void setActionBarBGDrawableId(IActionBarExt $this$actionBarBGDrawableId, int actionBarBGDrawableId) {
        Intrinsics.checkNotNullParameter($this$actionBarBGDrawableId, "<this>");
        if ($this$actionBarBGDrawableId.getActionBarExtObject() == null) {
            $this$actionBarBGDrawableId.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarBGDrawableId.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarBGDrawableId(actionBarBGDrawableId);
        }
    }

    public static final int getActionBarBGType(IActionBarExt $this$actionBarBGType) {
        Intrinsics.checkNotNullParameter($this$actionBarBGType, "<this>");
        Object actionBarExtObject = $this$actionBarBGType.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getActionBarBGType();
        }
        return 0;
    }

    public static final void setActionBarBGType(IActionBarExt $this$actionBarBGType, int actionBarType) {
        Intrinsics.checkNotNullParameter($this$actionBarBGType, "<this>");
        if ($this$actionBarBGType.getActionBarExtObject() == null) {
            $this$actionBarBGType.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$actionBarBGType.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setActionBarBGType(actionBarType);
        }
    }

    public static final View getContextActionBar(IActionBarExt $this$contextActionBar) {
        Intrinsics.checkNotNullParameter($this$contextActionBar, "<this>");
        Object actionBarExtObject = $this$contextActionBar.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.getContextActionBar();
        }
        return null;
    }

    public static final void setContextActionBar(IActionBarExt $this$contextActionBar, View contextActionBar) {
        Intrinsics.checkNotNullParameter($this$contextActionBar, "<this>");
        if ($this$contextActionBar.getActionBarExtObject() == null) {
            $this$contextActionBar.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$contextActionBar.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setContextActionBar(contextActionBar);
        }
    }

    public static final boolean isStyleChangeing(IActionBarExt $this$isStyleChangeing) {
        Intrinsics.checkNotNullParameter($this$isStyleChangeing, "<this>");
        Object actionBarExtObject = $this$isStyleChangeing.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            return actionBarExt.isStyleChangeing();
        }
        return false;
    }

    public static final void setStyleChangeing(IActionBarExt $this$isStyleChangeing, boolean isStyleChangeing) {
        Intrinsics.checkNotNullParameter($this$isStyleChangeing, "<this>");
        if ($this$isStyleChangeing.getActionBarExtObject() == null) {
            $this$isStyleChangeing.setActionBarExtObject(new ActionBarExt());
        }
        Object actionBarExtObject = $this$isStyleChangeing.getActionBarExtObject();
        ActionBarExt actionBarExt = actionBarExtObject instanceof ActionBarExt ? (ActionBarExt) actionBarExtObject : null;
        if (actionBarExt != null) {
            actionBarExt.setStyleChangeing(isStyleChangeing);
        }
    }

    public static final void initActionBar(IActionBarExt $this$initActionBar) {
        Intrinsics.checkNotNullParameter($this$initActionBar, "<this>");
        BdActionBar bdActionBar = new BdActionBar($this$initActionBar.getExtContext());
        BdActionBar $this$initActionBar_u24lambda_u2d1 = bdActionBar;
        FrameLayout.LayoutParams $this$initActionBar_u24lambda_u2d1_u24lambda_u2d0 = new FrameLayout.LayoutParams(-1, $this$initActionBar_u24lambda_u2d1.getResources().getDimensionPixelOffset(R.dimen.normal_base_action_bar_height));
        $this$initActionBar_u24lambda_u2d1_u24lambda_u2d0.bottomMargin = 1;
        $this$initActionBar_u24lambda_u2d1.setLayoutParams($this$initActionBar_u24lambda_u2d1_u24lambda_u2d0);
        setBdActionBar($this$initActionBar, bdActionBar);
        View view2 = new View($this$initActionBar.getExtContext());
        View $this$initActionBar_u24lambda_u2d3 = view2;
        FrameLayout.LayoutParams $this$initActionBar_u24lambda_u2d3_u24lambda_u2d2 = new FrameLayout.LayoutParams(-1, 1);
        $this$initActionBar_u24lambda_u2d3_u24lambda_u2d2.gravity = 80;
        $this$initActionBar_u24lambda_u2d3.setLayoutParams($this$initActionBar_u24lambda_u2d3_u24lambda_u2d2);
        $this$initActionBar_u24lambda_u2d3.setBackgroundColor($this$initActionBar_u24lambda_u2d3.getResources().getColor(R.color.GC35));
        setActionBarShadow($this$initActionBar, view2);
        FrameLayout frameLayout = new FrameLayout($this$initActionBar.getExtContext());
        FrameLayout $this$initActionBar_u24lambda_u2d4 = frameLayout;
        $this$initActionBar_u24lambda_u2d4.addView(getBdActionBar($this$initActionBar));
        $this$initActionBar_u24lambda_u2d4.addView(getActionBarShadow($this$initActionBar));
        setActionBarContainer($this$initActionBar, frameLayout);
        BdActionBar $this$initActionBar_u24lambda_u2d9 = getBdActionBar($this$initActionBar);
        if ($this$initActionBar_u24lambda_u2d9 != null) {
            $this$initActionBar_u24lambda_u2d9.setLeftTitleInvalidate(true);
            $this$initActionBar_u24lambda_u2d9.setRightTxtZone1Visibility(8);
            $this$initActionBar_u24lambda_u2d9.setLeftZoneOnClickListener(new ActionBarExtKt$$ExternalSyntheticLambda0($this$initActionBar));
            $this$initActionBar_u24lambda_u2d9.setOnMenuItemClickListener(new ActionBarExtKt$$ExternalSyntheticLambda1($this$initActionBar));
            $this$initActionBar_u24lambda_u2d9.setOnDoubleClickListener(new ActionBarExtKt$$ExternalSyntheticLambda2($this$initActionBar));
            $this$initActionBar_u24lambda_u2d9.setOnMenuItemsUpdateListener(new ActionBarExtKt$$ExternalSyntheticLambda3($this$initActionBar));
            setActionBarBackground($this$initActionBar, R.drawable.action_bar_bg, BdActionBar.ActionbarTemplate.BALCK_TITLE_TEMPLATE);
            $this$initActionBar.onCreateOptionsMenuItems($this$initActionBar_u24lambda_u2d9);
            showActionBar($this$initActionBar, getActionBarVisible($this$initActionBar));
            initContextActionBar($this$initActionBar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initActionBar$lambda-9$lambda-5  reason: not valid java name */
    public static final void m16065initActionBar$lambda9$lambda5(IActionBarExt $this_initActionBar, View it) {
        Intrinsics.checkNotNullParameter($this_initActionBar, "$this_initActionBar");
        $this_initActionBar.onActionBarBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: initActionBar$lambda-9$lambda-6  reason: not valid java name */
    public static final void m16066initActionBar$lambda9$lambda6(IActionBarExt $this_initActionBar, BdMenuItem item) {
        Intrinsics.checkNotNullParameter($this_initActionBar, "$this_initActionBar");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        $this_initActionBar.onOptionsMenuItemSelected(item);
    }

    /* access modifiers changed from: private */
    /* renamed from: initActionBar$lambda-9$lambda-7  reason: not valid java name */
    public static final void m16067initActionBar$lambda9$lambda7(IActionBarExt $this_initActionBar, View it) {
        Intrinsics.checkNotNullParameter($this_initActionBar, "$this_initActionBar");
        $this_initActionBar.onActionBarDoubleClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: initActionBar$lambda-9$lambda-8  reason: not valid java name */
    public static final void m16068initActionBar$lambda9$lambda8(IActionBarExt $this_initActionBar, List inItems) {
        Intrinsics.checkNotNullParameter($this_initActionBar, "$this_initActionBar");
        Intrinsics.checkNotNullExpressionValue(inItems, "inItems");
        $this_initActionBar.onUpdateOptionsMenuItems(inItems);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View addActionBar(com.baidu.searchbox.appframework.ext.IActionBarExt r6, android.view.View r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "contentView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            android.content.Context r1 = r6.getExtContext()
            r0.<init>(r1)
            r1 = r0
            r2 = 0
            r3 = 1
            r1.setOrientation(r3)
            android.content.res.Resources r3 = r1.getResources()
            int r4 = com.baidu.android.common.ui.style.R.color.white
            int r3 = r3.getColor(r4)
            r1.setBackgroundColor(r3)
            android.widget.FrameLayout r1 = getActionBarContainer(r6)
            r2 = -1
            r3 = 0
            if (r1 == 0) goto L_0x0061
            android.widget.FrameLayout r1 = getActionBarContainer(r6)
            if (r1 == 0) goto L_0x003b
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x003c
        L_0x003b:
            r1 = r3
        L_0x003c:
            boolean r4 = r1 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x0043
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x0044
        L_0x0043:
            r1 = r3
        L_0x0044:
            if (r1 == 0) goto L_0x004f
            android.widget.FrameLayout r4 = getActionBarContainer(r6)
            android.view.View r4 = (android.view.View) r4
            r1.removeView(r4)
        L_0x004f:
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r4 = -2
            r1.<init>(r2, r4)
            android.widget.FrameLayout r4 = getActionBarContainer(r6)
            android.view.View r4 = (android.view.View) r4
            r5 = r1
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r0.addView(r4, r5)
        L_0x0061:
            android.view.ViewParent r1 = r7.getParent()
            boolean r4 = r1 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x006c
            r3 = r1
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L_0x006c:
            if (r3 == 0) goto L_0x0071
            r3.removeView(r7)
        L_0x0071:
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r1.<init>(r2, r2)
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.weight = r2
            r2 = r1
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0.addView(r7, r2)
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.appframework.ext.ActionBarExtKt.addActionBar(com.baidu.searchbox.appframework.ext.IActionBarExt, android.view.View):android.view.View");
    }

    public static final void initContextActionBar(IActionBarExt $this$initContextActionBar) {
        Intrinsics.checkNotNullParameter($this$initContextActionBar, "<this>");
        setContextActionBar($this$initContextActionBar, $this$initContextActionBar.onCreateContextActionBar());
        View $this$initContextActionBar_u24lambda_u2d12 = getContextActionBar($this$initContextActionBar);
        if ($this$initContextActionBar_u24lambda_u2d12 != null) {
            $this$initContextActionBar_u24lambda_u2d12.setVisibility(8);
            FrameLayout.LayoutParams $this$initContextActionBar_u24lambda_u2d12_u24lambda_u2d11 = new FrameLayout.LayoutParams(-1, $this$initContextActionBar_u24lambda_u2d12.getResources().getDimensionPixelOffset(R.dimen.normal_base_action_bar_height));
            $this$initContextActionBar_u24lambda_u2d12_u24lambda_u2d11.bottomMargin = 1;
            $this$initContextActionBar_u24lambda_u2d12.setLayoutParams($this$initContextActionBar_u24lambda_u2d12_u24lambda_u2d11);
            FrameLayout actionBarContainer = getActionBarContainer($this$initContextActionBar);
            if (actionBarContainer != null) {
                actionBarContainer.addView(getContextActionBar($this$initContextActionBar));
            }
        }
    }

    public static final void handleShowActionBarFromIntent(IActionBarExt $this$handleShowActionBarFromIntent, Intent intent) {
        Intrinsics.checkNotNullParameter($this$handleShowActionBarFromIntent, "<this>");
        if (intent != null) {
            String showActionBar = "0";
            if (intent.hasExtra("showtitlebar")) {
                String stringExtra = intent.getStringExtra("showtitlebar");
                if (stringExtra == null) {
                    stringExtra = "0";
                }
                showActionBar = stringExtra;
            }
            if (Intrinsics.areEqual((Object) "1", (Object) showActionBar)) {
                showActionBar($this$handleShowActionBarFromIntent, true);
            } else {
                showActionBar($this$handleShowActionBarFromIntent, false);
            }
        }
    }

    public static final void handleActionBarDataFromIntent(IActionBarExt $this$handleActionBarDataFromIntent, Intent intent) {
        BdActionBar bdActionBar;
        BdActionBar bdActionBar2;
        Intrinsics.checkNotNullParameter($this$handleActionBarDataFromIntent, "<this>");
        if (intent != null) {
            if (intent.hasExtra("barcolor")) {
                String colorStr = intent.getStringExtra("barcolor");
                int color = 0;
                if (!TextUtils.isEmpty(colorStr)) {
                    try {
                        color = Integer.parseInt(colorStr);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                setActionBarBackgroundColor($this$handleActionBarDataFromIntent, color);
            } else if (intent.hasExtra("extra_actionbar_color_id")) {
                setActionBarBackgroundColor($this$handleActionBarDataFromIntent, intent.getIntExtra("extra_actionbar_color_id", 0));
            } else if (intent.hasExtra("extra_actionbar_color_str")) {
                String colorStr2 = intent.getStringExtra("extra_actionbar_color_str");
                if (!TextUtils.isEmpty(colorStr2)) {
                    try {
                        setActionBarBackgroundColor($this$handleActionBarDataFromIntent, Color.parseColor(colorStr2));
                    } catch (IllegalArgumentException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            if (intent.hasExtra("extra_actionbar_left_title")) {
                String title = intent.getStringExtra("extra_actionbar_left_title");
                if (!TextUtils.isEmpty(title) && (bdActionBar2 = getBdActionBar($this$handleActionBarDataFromIntent)) != null) {
                    bdActionBar2.setLeftTitle(title);
                }
            }
            if (intent.hasExtra("extra_actionbar_back_btn_style")) {
                String backBtnStyle = intent.getStringExtra("extra_actionbar_back_btn_style");
                if (TextUtils.equals(backBtnStyle, "light")) {
                    BdActionBar bdActionBar3 = getBdActionBar($this$handleActionBarDataFromIntent);
                    if (bdActionBar3 != null) {
                        bdActionBar3.setLeftZoneImageSrc(com.baidu.searchbox.appframework.actionbarext.R.drawable.action_bar_menu_light_selector);
                    }
                } else if (TextUtils.equals(backBtnStyle, "dark") && (bdActionBar = getBdActionBar($this$handleActionBarDataFromIntent)) != null) {
                    bdActionBar.setLeftZoneImageSrc(R.drawable.action_bar_back_normal);
                }
            }
        }
    }

    public static final void updateActionBarUI(IActionBarExt $this$updateActionBarUI) {
        Intrinsics.checkNotNullParameter($this$updateActionBarUI, "<this>");
        BdActionBar $this$updateActionBarUI_u24lambda_u2d13 = getBdActionBar($this$updateActionBarUI);
        if ($this$updateActionBarUI_u24lambda_u2d13 != null && getActionBarBGType($this$updateActionBarUI) == 0) {
            $this$updateActionBarUI_u24lambda_u2d13.setBackground($this$updateActionBarUI_u24lambda_u2d13.getResources().getDrawable(getActionBarBGDrawableId($this$updateActionBarUI)));
            setShadowBackgroundColor($this$updateActionBarUI, R.color.setting_item_divider_color);
            if ($this$updateActionBarUI_u24lambda_u2d13.isRightMeuVisible()) {
                $this$updateActionBarUI_u24lambda_u2d13.setRightMenuImageSrc($this$updateActionBarUI_u24lambda_u2d13.getRightMenuImageViewSrcId());
            }
            if ($this$updateActionBarUI_u24lambda_u2d13.isRightZone2Visible()) {
                $this$updateActionBarUI_u24lambda_u2d13.setRightImgZone2Src($this$updateActionBarUI_u24lambda_u2d13.getRightImgZone2ImageSrcId());
            }
            if ($this$updateActionBarUI_u24lambda_u2d13.isRightImgZone1Visible()) {
                $this$updateActionBarUI_u24lambda_u2d13.setRightImgZone1ImageSrc($this$updateActionBarUI_u24lambda_u2d13.getRightImgZone1ImageSrcId());
            }
            if (getActionBarTemplate($this$updateActionBarUI) == null) {
                $this$updateActionBarUI_u24lambda_u2d13.setTitleColor($this$updateActionBarUI_u24lambda_u2d13.getTitleColorId());
            } else {
                $this$updateActionBarUI_u24lambda_u2d13.setTemplate(getActionBarTemplate($this$updateActionBarUI));
            }
        }
    }

    public static final void setActionBarParentHeight(IActionBarExt $this$setActionBarParentHeight, int height) {
        Intrinsics.checkNotNullParameter($this$setActionBarParentHeight, "<this>");
        FrameLayout $this$setActionBarParentHeight_u24lambda_u2d14 = getActionBarContainer($this$setActionBarParentHeight);
        if ($this$setActionBarParentHeight_u24lambda_u2d14 != null) {
            ViewGroup.LayoutParams lp = $this$setActionBarParentHeight_u24lambda_u2d14.getLayoutParams();
            if (lp != null) {
                lp.height = height;
            }
            $this$setActionBarParentHeight_u24lambda_u2d14.setLayoutParams(lp);
        }
    }

    public static final void setActionBarGravity(IActionBarExt $this$setActionBarGravity, int gravity) {
        Intrinsics.checkNotNullParameter($this$setActionBarGravity, "<this>");
        BdActionBar $this$setActionBarGravity_u24lambda_u2d15 = getBdActionBar($this$setActionBarGravity);
        if ($this$setActionBarGravity_u24lambda_u2d15 != null) {
            ViewGroup.LayoutParams layoutParams = $this$setActionBarGravity_u24lambda_u2d15.getLayoutParams();
            FrameLayout.LayoutParams lp = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            boolean z = false;
            if (lp != null && gravity == lp.gravity) {
                z = true;
            }
            if (!z) {
                $this$setActionBarGravity_u24lambda_u2d15.setLayoutParams(lp);
            }
        }
    }

    public static final void showActionBar(IActionBarExt $this$showActionBar, boolean show) {
        Intrinsics.checkNotNullParameter($this$showActionBar, "<this>");
        setActionBarVisible($this$showActionBar, show);
        int visibility = show ? 0 : 8;
        FrameLayout actionBarContainer = getActionBarContainer($this$showActionBar);
        if (actionBarContainer != null) {
            actionBarContainer.setVisibility(visibility);
        }
        BdActionBar bdActionBar = getBdActionBar($this$showActionBar);
        if (bdActionBar != null) {
            bdActionBar.setVisibility(visibility);
        }
        View actionBarShadow = getActionBarShadow($this$showActionBar);
        if (actionBarShadow != null) {
            actionBarShadow.setVisibility(visibility);
        }
    }

    public static final void showActionBarShadow(IActionBarExt $this$showActionBarShadow, boolean show) {
        Intrinsics.checkNotNullParameter($this$showActionBarShadow, "<this>");
        View actionBarShadow = getActionBarShadow($this$showActionBarShadow);
        if (actionBarShadow != null) {
            actionBarShadow.setVisibility(show ? 0 : 8);
        }
    }

    public static final void setActionBarBackgroundColor(IActionBarExt $this$setActionBarBackgroundColor, int color, BdActionBar.ActionbarTemplate template) {
        Intrinsics.checkNotNullParameter($this$setActionBarBackgroundColor, "<this>");
        Intrinsics.checkNotNullParameter(template, "template");
        BdActionBar $this$setActionBarBackgroundColor_u24lambda_u2d16 = getBdActionBar($this$setActionBarBackgroundColor);
        if ($this$setActionBarBackgroundColor_u24lambda_u2d16 != null) {
            setActionBarTemplate($this$setActionBarBackgroundColor, template);
            setActionBarBGType($this$setActionBarBackgroundColor, 1);
            $this$setActionBarBackgroundColor_u24lambda_u2d16.setBackgroundColor(color);
            FrameLayout actionBarContainer = getActionBarContainer($this$setActionBarBackgroundColor);
            if (actionBarContainer != null) {
                actionBarContainer.setBackgroundColor(color);
            }
            $this$setActionBarBackgroundColor_u24lambda_u2d16.setTemplate(template);
        }
    }

    public static final void setActionBarBackgroundColor(IActionBarExt $this$setActionBarBackgroundColor, int color) {
        Intrinsics.checkNotNullParameter($this$setActionBarBackgroundColor, "<this>");
        BdActionBar $this$setActionBarBackgroundColor_u24lambda_u2d17 = getBdActionBar($this$setActionBarBackgroundColor);
        if ($this$setActionBarBackgroundColor_u24lambda_u2d17 != null) {
            $this$setActionBarBackgroundColor_u24lambda_u2d17.setBackgroundColor(color);
            FrameLayout actionBarContainer = getActionBarContainer($this$setActionBarBackgroundColor);
            if (actionBarContainer != null) {
                actionBarContainer.setBackgroundColor(color);
            }
            setActionBarBGType($this$setActionBarBackgroundColor, 1);
            setShadowBackgroundColor($this$setActionBarBackgroundColor, R.color.setting_item_divider_color);
            if (color != 0 && color != -1) {
                $this$setActionBarBackgroundColor_u24lambda_u2d17.setTitleColor(R.color.white_text);
                $this$setActionBarBackgroundColor_u24lambda_u2d17.setRightMenuImageSrc(R.drawable.action_bar_menu_normal_selector);
            }
        }
    }

    public static final void setActionBarBackground(IActionBarExt $this$setActionBarBackground, int resid) {
        Intrinsics.checkNotNullParameter($this$setActionBarBackground, "<this>");
        BdActionBar $this$setActionBarBackground_u24lambda_u2d18 = getBdActionBar($this$setActionBarBackground);
        if ($this$setActionBarBackground_u24lambda_u2d18 != null) {
            setActionBarBGDrawableId($this$setActionBarBackground, resid);
            $this$setActionBarBackground_u24lambda_u2d18.setBackground($this$setActionBarBackground_u24lambda_u2d18.getResources().getDrawable(resid));
            FrameLayout actionBarContainer = getActionBarContainer($this$setActionBarBackground);
            if (actionBarContainer != null) {
                actionBarContainer.setBackground($this$setActionBarBackground_u24lambda_u2d18.getResources().getDrawable(resid));
            }
            setActionBarBGType($this$setActionBarBackground, 0);
            setShadowBackgroundColor($this$setActionBarBackground, R.color.setting_item_divider_color);
        }
    }

    public static final void setActionBarBackground(IActionBarExt $this$setActionBarBackground, int resid, BdActionBar.ActionbarTemplate template) {
        Intrinsics.checkNotNullParameter($this$setActionBarBackground, "<this>");
        Intrinsics.checkNotNullParameter(template, "template");
        BdActionBar $this$setActionBarBackground_u24lambda_u2d19 = getBdActionBar($this$setActionBarBackground);
        if ($this$setActionBarBackground_u24lambda_u2d19 != null) {
            setActionBarBackground($this$setActionBarBackground, resid);
            $this$setActionBarBackground_u24lambda_u2d19.setTemplate(template);
        }
    }

    public static final void setShadowBackgroundColor(IActionBarExt $this$setShadowBackgroundColor, int color) {
        Intrinsics.checkNotNullParameter($this$setShadowBackgroundColor, "<this>");
        View $this$setShadowBackgroundColor_u24lambda_u2d20 = getActionBarShadow($this$setShadowBackgroundColor);
        if ($this$setShadowBackgroundColor_u24lambda_u2d20 != null) {
            $this$setShadowBackgroundColor_u24lambda_u2d20.setBackgroundColor($this$setShadowBackgroundColor_u24lambda_u2d20.getResources().getColor(color));
        }
    }

    public static final void openContextActionBar(IActionBarExt $this$openContextActionBar, boolean doAnim) {
        Intrinsics.checkNotNullParameter($this$openContextActionBar, "<this>");
        if (getContextActionBar($this$openContextActionBar) != null && getBdActionBar($this$openContextActionBar) != null && !isStyleChangeing($this$openContextActionBar)) {
            setStyleChangeing($this$openContextActionBar, true);
            if (!doAnim) {
                BdActionBar bdActionBar = getBdActionBar($this$openContextActionBar);
                if (bdActionBar != null) {
                    bdActionBar.setVisibility(8);
                }
                View contextActionBar = getContextActionBar($this$openContextActionBar);
                if (contextActionBar != null) {
                    contextActionBar.setVisibility(0);
                }
                $this$openContextActionBar.onContextActionBarVisibleChanged(true);
                setStyleChangeing($this$openContextActionBar, false);
                return;
            }
            BdActionBar bdActionBar2 = getBdActionBar($this$openContextActionBar);
            Intrinsics.checkNotNull(bdActionBar2);
            Animation animActionBar = AnimationUtils.loadAnimation(bdActionBar2.getContext(), 17432577);
            animActionBar.setInterpolator(new AccelerateInterpolator());
            animActionBar.setDuration(200);
            animActionBar.setAnimationListener(new ActionBarExtKt$openContextActionBar$1($this$openContextActionBar));
            BdActionBar bdActionBar3 = getBdActionBar($this$openContextActionBar);
            if (bdActionBar3 != null) {
                bdActionBar3.startAnimation(animActionBar);
            }
            BdActionBar bdActionBar4 = getBdActionBar($this$openContextActionBar);
            Intrinsics.checkNotNull(bdActionBar4);
            Animation animContextActionBar = AnimationUtils.loadAnimation(bdActionBar4.getContext(), com.baidu.searchbox.appframework.actionbarext.R.anim.video_top_appear);
            animContextActionBar.setDuration(200);
            View contextActionBar2 = getContextActionBar($this$openContextActionBar);
            if (contextActionBar2 != null) {
                contextActionBar2.setVisibility(0);
            }
            View contextActionBar3 = getContextActionBar($this$openContextActionBar);
            if (contextActionBar3 != null) {
                contextActionBar3.startAnimation(animContextActionBar);
            }
            $this$openContextActionBar.onContextActionBarVisibleChanged(true);
        }
    }

    public static final void closeContextActionBar(IActionBarExt $this$closeContextActionBar, boolean doAnim) {
        Intrinsics.checkNotNullParameter($this$closeContextActionBar, "<this>");
        if (getContextActionBar($this$closeContextActionBar) != null && getBdActionBar($this$closeContextActionBar) != null && !isStyleChangeing($this$closeContextActionBar)) {
            setStyleChangeing($this$closeContextActionBar, true);
            if (!doAnim) {
                BdActionBar bdActionBar = getBdActionBar($this$closeContextActionBar);
                if (bdActionBar != null) {
                    bdActionBar.setVisibility(0);
                }
                View contextActionBar = getContextActionBar($this$closeContextActionBar);
                if (contextActionBar != null) {
                    contextActionBar.setVisibility(8);
                }
                $this$closeContextActionBar.onContextActionBarVisibleChanged(false);
                setStyleChangeing($this$closeContextActionBar, false);
                return;
            }
            BdActionBar bdActionBar2 = getBdActionBar($this$closeContextActionBar);
            Intrinsics.checkNotNull(bdActionBar2);
            Animation animActionBar = AnimationUtils.loadAnimation(bdActionBar2.getContext(), 17432576);
            animActionBar.setInterpolator(new AccelerateInterpolator());
            animActionBar.setDuration(200);
            BdActionBar bdActionBar3 = getBdActionBar($this$closeContextActionBar);
            if (bdActionBar3 != null) {
                bdActionBar3.setVisibility(0);
            }
            BdActionBar bdActionBar4 = getBdActionBar($this$closeContextActionBar);
            if (bdActionBar4 != null) {
                bdActionBar4.startAnimation(animActionBar);
            }
            BdActionBar bdActionBar5 = getBdActionBar($this$closeContextActionBar);
            Intrinsics.checkNotNull(bdActionBar5);
            Animation animContextActionBar = AnimationUtils.loadAnimation(bdActionBar5.getContext(), com.baidu.searchbox.appframework.actionbarext.R.anim.video_top_disappear);
            animContextActionBar.setDuration(200);
            animContextActionBar.setAnimationListener(new ActionBarExtKt$closeContextActionBar$1($this$closeContextActionBar));
            View contextActionBar2 = getContextActionBar($this$closeContextActionBar);
            if (contextActionBar2 != null) {
                contextActionBar2.startAnimation(animContextActionBar);
            }
            $this$closeContextActionBar.onContextActionBarVisibleChanged(false);
        }
    }

    public static final void showActionBarWithoutLeft(IActionBarExt $this$showActionBarWithoutLeft) {
        Intrinsics.checkNotNullParameter($this$showActionBarWithoutLeft, "<this>");
        BdActionBar $this$showActionBarWithoutLeft_u24lambda_u2d21 = getBdActionBar($this$showActionBarWithoutLeft);
        if ($this$showActionBarWithoutLeft_u24lambda_u2d21 != null) {
            showActionBar($this$showActionBarWithoutLeft, true);
            $this$showActionBarWithoutLeft_u24lambda_u2d21.setLeftFirstViewVisibility(false);
        }
    }
}
