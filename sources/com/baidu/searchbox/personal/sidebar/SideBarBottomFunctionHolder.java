package com.baidu.searchbox.personal.sidebar;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.adapter.TemplateContentAdapter;
import com.baidu.searchbox.personal.sidebar.SideBarBaseHolder;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/personal/sidebar/SideBarBottomFunctionHolder;", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "itemView", "Landroid/view/View;", "listener", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "mainMenuViewWidth", "", "scaleParam", "", "(Landroid/view/View;Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;IF)V", "getListener", "()Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "setListener", "(Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;)V", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getMainMenuViewWidth", "()I", "setMainMenuViewWidth", "(I)V", "getScaleParam", "()F", "populate", "", "data", "ubcShow", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SideBarBottomFunctionHolder.kt */
public final class SideBarBottomFunctionHolder extends SideBarBaseHolder<PersonalCenterTabModel> {
    private SideBarBaseHolder.ActionListener listener;
    private final Context mContext;
    private int mainMenuViewWidth;
    private final float scaleParam;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SideBarBottomFunctionHolder(View view2, SideBarBaseHolder.ActionListener actionListener, int i2, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, actionListener, i2, (i3 & 8) != 0 ? 1.0f : f2);
    }

    public final SideBarBaseHolder.ActionListener getListener() {
        return this.listener;
    }

    public final void setListener(SideBarBaseHolder.ActionListener actionListener) {
        this.listener = actionListener;
    }

    public final int getMainMenuViewWidth() {
        return this.mainMenuViewWidth;
    }

    public final void setMainMenuViewWidth(int i2) {
        this.mainMenuViewWidth = i2;
    }

    public final float getScaleParam() {
        return this.scaleParam;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBarBottomFunctionHolder(View itemView, SideBarBaseHolder.ActionListener listener2, int mainMenuViewWidth2, float scaleParam2) {
        super(itemView, listener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener2;
        this.mainMenuViewWidth = mainMenuViewWidth2;
        this.scaleParam = scaleParam2;
        this.mContext = itemView.getContext();
    }

    public void populate(PersonalCenterTabModel data) {
        List<PersonalCenterTabItemModel> body;
        Iterable $this$forEachIndexed$iv;
        LayoutInflater mInflater;
        int $i$f$forEachIndexed;
        Context context = this.mContext;
        if (context != null) {
            LayoutInflater mInflater2 = LayoutInflater.from(context);
            if (this.itemView instanceof LinearLayout) {
                ((LinearLayout) this.itemView).removeAllViews();
            }
            if (data == null || (body = data.getBody()) == null) {
                return;
            }
            Iterable $this$forEachIndexed$iv2 = body;
            int $i$f$forEachIndexed2 = false;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv2) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PersonalCenterTabItemModel item = (PersonalCenterTabItemModel) item$iv;
                if (index < 3) {
                    View inflate = mInflater2.inflate(R.layout.personal_sidebar_bottom_item_layout, (ViewGroup) null);
                    View $this$populate_u24lambda_u2d2_u24lambda_u2d1 = inflate;
                    TextView tv = (TextView) $this$populate_u24lambda_u2d2_u24lambda_u2d1.findViewById(R.id.common_fun_text);
                    ImageView bg = (ImageView) $this$populate_u24lambda_u2d2_u24lambda_u2d1.findViewById(R.id.common_fun_img_bg);
                    mInflater = mInflater2;
                    tv.setText(item.getTitle());
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    tv.setTextColor($this$populate_u24lambda_u2d2_u24lambda_u2d1.getContext().getResources().getColor(R.color.GC1));
                    SimpleDraweeView iv = (SimpleDraweeView) $this$populate_u24lambda_u2d2_u24lambda_u2d1.findViewById(R.id.common_fun_img);
                    FontSizeTextViewExtKt.setScaledSizeRes$default(tv, 2, R.dimen.sidebar_bottom_fun_title_size, 0, 4, (Object) null);
                    FontSizeViewExtKt.setScaledSizeRes$default(iv, 2, R.dimen.sidebar_common_fun_img_size, R.dimen.sidebar_common_fun_img_size, 0, 8, (Object) null);
                    FontSizeViewExtKt.setScaledSizeRes$default(bg, 2, R.dimen.sidebar_common_fun_img_bg_size, R.dimen.sidebar_common_fun_img_bg_size, 0, 8, (Object) null);
                    GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder($this$populate_u24lambda_u2d2_u24lambda_u2d1.getContext().getResources()).build();
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                    hierarchy.setPlaceholderImage($this$populate_u24lambda_u2d2_u24lambda_u2d1.getContext().getResources().getDrawable(R.drawable.personal_default_item));
                    hierarchy.setUseGlobalColorFilter(false);
                    iv.setHierarchy(hierarchy);
                    if (NightModeHelper.getNightModeSwitcherState()) {
                        if (Intrinsics.areEqual((Object) item.getKeyId(), (Object) SidebarWindowLayoutForPad.SETTING_ID)) {
                            iv.setImageURI(Uri.parse(SidebarWindowLayoutForPad.SETTING_ASSET_NIGHT));
                        }
                        if (!TextUtils.isEmpty(item.getIconNightUrl())) {
                            iv.setImageURI(Uri.parse(item.getIconNightUrl()));
                        } else if (!TextUtils.isEmpty(item.getIcon())) {
                            iv.setImageURI(Uri.parse(item.getIcon()));
                        }
                    } else {
                        if (Intrinsics.areEqual((Object) item.getKeyId(), (Object) SidebarWindowLayoutForPad.SETTING_ID)) {
                            iv.setImageURI(Uri.parse(SidebarWindowLayoutForPad.SETTING_ASSET));
                        }
                        if (!TextUtils.isEmpty(item.getIcon())) {
                            iv.setImageURI(Uri.parse(item.getIcon()));
                        }
                    }
                    bg.setBackground($this$populate_u24lambda_u2d2_u24lambda_u2d1.getResources().getDrawable(R.drawable.sidebar_bottom_image_bg));
                    $this$populate_u24lambda_u2d2_u24lambda_u2d1.setOnTouchListener(new TouchStateListener($this$populate_u24lambda_u2d2_u24lambda_u2d1));
                    $this$populate_u24lambda_u2d2_u24lambda_u2d1.setOnClickListener(new SideBarBottomFunctionHolder$$ExternalSyntheticLambda0(item, $this$populate_u24lambda_u2d2_u24lambda_u2d1));
                    View bottomItem = inflate;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mainMenuViewWidth / 3, -1);
                    layoutParams.gravity = 17;
                    bottomItem.setScaleX(this.scaleParam);
                    bottomItem.setScaleY(this.scaleParam);
                    if (this.itemView instanceof LinearLayout) {
                        ((LinearLayout) this.itemView).addView(bottomItem, layoutParams);
                    }
                    PersonCenterUBCStatistic.statisticUBC(data.getUbcType(), "0", "show", (JSONObject) null, data.getUbcFrom(), "192", (String) null);
                } else {
                    mInflater = mInflater2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                }
                index = index$iv;
                $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                mInflater2 = mInflater;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            }
            Iterable iterable = $this$forEachIndexed$iv2;
            int i2 = $i$f$forEachIndexed2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2125populate$lambda2$lambda1$lambda0(PersonalCenterTabItemModel $item, View $this_apply, View it) {
        Intrinsics.checkNotNullParameter($item, "$item");
        if (TextUtils.equals($item.getForceLogin(), "1")) {
            TemplateContentAdapter.checkoutLogin($this_apply.getContext(), $item);
        } else {
            Router.invoke($this_apply.getContext(), $item.getScheme());
        }
        PersonCenterUBCStatistic.statisticUBC($item.getUbcType(), "0", "click", (JSONObject) null, $item.getUbcFrom(), "192", (String) null);
    }

    public void ubcShow(PersonalCenterTabModel data) {
    }
}
