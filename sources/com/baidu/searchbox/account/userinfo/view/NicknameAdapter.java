package com.baidu.searchbox.account.userinfo.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.app.account.BoxAccountContants;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.userinfo.activity.AccountUserInfoEditUBC;
import com.baidu.searchbox.account.userinfo.event.INicknameSelectEventListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J\u0014\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/view/NicknameAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "dataList", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "mFrom", "getMFrom", "()Ljava/lang/String;", "setMFrom", "(Ljava/lang/String;)V", "nicknameEvent", "Lcom/baidu/searchbox/account/userinfo/event/INicknameSelectEventListener;", "getNicknameEvent", "()Lcom/baidu/searchbox/account/userinfo/event/INicknameSelectEventListener;", "setNicknameEvent", "(Lcom/baidu/searchbox/account/userinfo/event/INicknameSelectEventListener;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getSelectedUbcExt", "selectedNickname", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setNicknameData", "", "list", "NicknameViewHolder", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NicknameAdapter.kt */
public final class NicknameAdapter extends BaseAdapter {
    private final Context context;
    private List<String> dataList;
    private String mFrom;
    private INicknameSelectEventListener nicknameEvent;

    public NicknameAdapter(Context context2, List<String> dataList2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(dataList2, "dataList");
        this.context = context2;
        this.dataList = dataList2;
    }

    public final INicknameSelectEventListener getNicknameEvent() {
        return this.nicknameEvent;
    }

    public final void setNicknameEvent(INicknameSelectEventListener iNicknameSelectEventListener) {
        this.nicknameEvent = iNicknameSelectEventListener;
    }

    public final String getMFrom() {
        return this.mFrom;
    }

    public final void setMFrom(String str) {
        this.mFrom = str;
    }

    public int getCount() {
        return this.dataList.size();
    }

    public Object getItem(int position) {
        return this.dataList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: android.widget.TextView} */
    /* JADX WARNING: type inference failed for: r2v8, types: [com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder] */
    /* JADX WARNING: type inference failed for: r2v10, types: [com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            r10 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0011
            android.content.Context r1 = r10.context
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.baidu.searchbox.account.R.layout.item_nickname_result
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r13, r3)
            goto L_0x0012
        L_0x0011:
            r1 = r12
        L_0x0012:
            r2 = 0
            if (r12 != 0) goto L_0x0068
            com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder r3 = new com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder
            r3.<init>()
            r0 = r3
            if (r1 == 0) goto L_0x0026
            int r2 = com.baidu.searchbox.account.R.id.textView
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x0026:
            r0.setNicknameTextView(r2)
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r1.setTag(r0)
        L_0x002f:
            android.widget.TextView r2 = r0.getNicknameTextView()
            if (r2 != 0) goto L_0x0036
            goto L_0x0043
        L_0x0036:
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            int r4 = com.baidu.searchbox.account.R.drawable.account_nickname_result_bg
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r2.setBackground(r3)
        L_0x0043:
            android.widget.TextView r2 = r0.getNicknameTextView()
            if (r2 == 0) goto L_0x0056
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            int r4 = com.baidu.android.common.ui.style.R.color.GC1
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r2.setTextColor(r3)
        L_0x0056:
            r2 = 0
            android.widget.TextView r3 = r0.getNicknameTextView()
            if (r3 != 0) goto L_0x005e
            goto L_0x007f
        L_0x005e:
            r4 = 1096810496(0x41600000, float:14.0)
            float r4 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r2, r4)
            r3.setTextSize(r4)
            goto L_0x007f
        L_0x0068:
            if (r1 == 0) goto L_0x006f
            java.lang.Object r3 = r1.getTag()
            goto L_0x0070
        L_0x006f:
            r3 = r2
        L_0x0070:
            boolean r4 = r3 instanceof com.baidu.searchbox.account.userinfo.view.NicknameAdapter.NicknameViewHolder
            if (r4 == 0) goto L_0x0077
            r2 = r3
            com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder r2 = (com.baidu.searchbox.account.userinfo.view.NicknameAdapter.NicknameViewHolder) r2
        L_0x0077:
            if (r2 != 0) goto L_0x007e
            com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder r2 = new com.baidu.searchbox.account.userinfo.view.NicknameAdapter$NicknameViewHolder
            r2.<init>()
        L_0x007e:
            r0 = r2
        L_0x007f:
            java.util.List<java.lang.String> r2 = r10.dataList
            java.lang.Object r2 = r2.get(r11)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            android.widget.TextView r2 = r0.getNicknameTextView()
            if (r2 != 0) goto L_0x008f
            goto L_0x0095
        L_0x008f:
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0095:
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            if (r1 == 0) goto L_0x00ad
            com.baidu.searchbox.account.userinfo.view.NicknameAdapter$$ExternalSyntheticLambda0 r9 = new com.baidu.searchbox.account.userinfo.view.NicknameAdapter$$ExternalSyntheticLambda0
            r2 = r9
            r5 = r0
            r6 = r10
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r1.setOnTouchListener(r9)
        L_0x00ad:
            java.lang.String r2 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.view.NicknameAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: getView$lambda-0  reason: not valid java name */
    public static final boolean m14635getView$lambda0(Ref.FloatRef $startX, Ref.FloatRef $startY, NicknameViewHolder $holder, NicknameAdapter this$0, String $data, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter($startX, "$startX");
        Intrinsics.checkNotNullParameter($startY, "$startY");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($data, "$data");
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            $startX.element = event.getX();
            $startY.element = event.getY();
            TextView nicknameTextView = $holder.getNicknameTextView();
            if (nicknameTextView != null) {
                nicknameTextView.setBackground(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.account_nickname_result_bg_down));
            }
            TextView nicknameTextView2 = $holder.getNicknameTextView();
            if (nicknameTextView2 != null) {
                nicknameTextView2.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC6));
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            float deltaX = Math.abs(event.getX() - $startX.element);
            float deltaY = Math.abs(event.getY() - $startY.element);
            TextView nicknameTextView3 = $holder.getNicknameTextView();
            if (nicknameTextView3 != null) {
                nicknameTextView3.setBackground(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.account_nickname_result_bg));
            }
            TextView nicknameTextView4 = $holder.getNicknameTextView();
            if (nicknameTextView4 != null) {
                nicknameTextView4.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC1));
            }
            if (deltaX < 10.0f && deltaY < 10.0f) {
                INicknameSelectEventListener iNicknameSelectEventListener = this$0.nicknameEvent;
                if (iNicknameSelectEventListener != null) {
                    iNicknameSelectEventListener.selectNickname($data);
                }
                AccountUserInfoEditUBC.userInfoEditNicknameUBC(this$0.mFrom, BoxAccountContants.UBC_PAGE_AINICKNAME_GENERATED, "click", BoxAccountContants.UBC_PAGE_AINICKNAME_GENERATED, (String) null, this$0.getSelectedUbcExt($data));
            }
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/view/NicknameAdapter$NicknameViewHolder;", "", "()V", "nicknameTextView", "Landroid/widget/TextView;", "getNicknameTextView", "()Landroid/widget/TextView;", "setNicknameTextView", "(Landroid/widget/TextView;)V", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NicknameAdapter.kt */
    private static final class NicknameViewHolder {
        private TextView nicknameTextView;

        public final TextView getNicknameTextView() {
            return this.nicknameTextView;
        }

        public final void setNicknameTextView(TextView textView) {
            this.nicknameTextView = textView;
        }
    }

    public final void setNicknameData(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList = list;
        notifyDataSetChanged();
    }

    private final String getSelectedUbcExt(String selectedNickname) {
        try {
            JSONObject ext = new JSONObject();
            ext.put("text", selectedNickname);
            return ext.toString();
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            String str = null;
            return null;
        }
    }
}
