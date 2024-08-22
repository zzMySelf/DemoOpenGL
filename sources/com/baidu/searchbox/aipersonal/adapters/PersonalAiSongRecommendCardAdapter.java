package com.baidu.searchbox.aipersonal.adapters;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.aipersonal.AiPersonalUtils;
import com.baidu.searchbox.aipersonal.widgets.TouchPressStateListener;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.personalcenter.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010#\u001a\u00020\fH\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fH\u0016J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/searchbox/aipersonal/adapters/PersonalAiSongRecommendCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/aipersonal/adapters/PersonalAiSongRecommendCardItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "(Landroid/content/Context;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "TAG", "", "kotlin.jvm.PlatformType", "cardPosition", "", "getCardPosition", "()I", "setCardPosition", "(I)V", "getContext", "()Landroid/content/Context;", "dp20", "", "getDp20", "()F", "dp20$delegate", "Lkotlin/Lazy;", "dp35", "getDp35", "dp35$delegate", "getListener", "()Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "setListener", "(Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "mData", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "getItemCount", "jumpToDetail", "", "bodyData", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiSongRecommendCardAdapter.kt */
public final class PersonalAiSongRecommendCardAdapter extends RecyclerView.Adapter<PersonalAiSongRecommendCardItemViewHolder> {
    private final String TAG = PersonalAiSongRecommendCardAdapter.class.getSimpleName();
    private int cardPosition = -1;
    private final Context context;
    private final Lazy dp20$delegate = LazyKt.lazy(new PersonalAiSongRecommendCardAdapter$dp20$2(this));
    private final Lazy dp35$delegate = LazyKt.lazy(new PersonalAiSongRecommendCardAdapter$dp35$2(this));
    private ModuleActionListener listener;
    private final List<PersonalCenterTabItemModel> mData = new ArrayList();

    public final Context getContext() {
        return this.context;
    }

    public final ModuleActionListener getListener() {
        return this.listener;
    }

    public final void setListener(ModuleActionListener moduleActionListener) {
        this.listener = moduleActionListener;
    }

    public PersonalAiSongRecommendCardAdapter(Context context2, ModuleActionListener listener2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.listener = listener2;
    }

    private final float getDp35() {
        return ((Number) this.dp35$delegate.getValue()).floatValue();
    }

    private final float getDp20() {
        return ((Number) this.dp20$delegate.getValue()).floatValue();
    }

    public final int getCardPosition() {
        return this.cardPosition;
    }

    public final void setCardPosition(int i2) {
        this.cardPosition = i2;
    }

    public PersonalAiSongRecommendCardItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.personal_ai_song_recom_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new PersonalAiSongRecommendCardItemViewHolder(itemView);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void onBindViewHolder(PersonalAiSongRecommendCardItemViewHolder holder, int position) {
        PersonalAiSongRecommendCardItemViewHolder personalAiSongRecommendCardItemViewHolder = holder;
        Intrinsics.checkNotNullParameter(personalAiSongRecommendCardItemViewHolder, "holder");
        PersonalCenterTabItemModel bodyData = this.mData.get(holder.getAdapterPosition());
        TextView $this$onBindViewHolder_u24lambda_u2d0 = holder.getMTvSongName();
        $this$onBindViewHolder_u24lambda_u2d0.setText(bodyData.getTitle());
        $this$onBindViewHolder_u24lambda_u2d0.setTextColor(ContextCompat.getColor($this$onBindViewHolder_u24lambda_u2d0.getContext(), R.color.GC1));
        FontSizeTextViewExtKt.setScaledSizeRes$default($this$onBindViewHolder_u24lambda_u2d0, 2, R.dimen.personal_ai_card_v2_sub_title_size, 0, 4, (Object) null);
        SimpleDraweeView $this$onBindViewHolder_u24lambda_u2d1 = holder.getMIvThumb();
        CharSequence icon = bodyData.getIcon();
        if (!(icon == null || icon.length() == 0)) {
            $this$onBindViewHolder_u24lambda_u2d1.setImageURI(Uri.parse(bodyData.getIcon()));
        } else {
            $this$onBindViewHolder_u24lambda_u2d1.setImageDrawable(ContextCompat.getDrawable($this$onBindViewHolder_u24lambda_u2d1.getContext(), R.drawable.personal_ai_backup_icon));
        }
        FontSizeViewExtKt.setScaledSize$default($this$onBindViewHolder_u24lambda_u2d1, 2, getDp35(), getDp35(), 0, 8, (Object) null);
        TextView $this$onBindViewHolder_u24lambda_u2d2 = holder.getMTvSongDes();
        $this$onBindViewHolder_u24lambda_u2d2.setText(bodyData.getSubTitle());
        $this$onBindViewHolder_u24lambda_u2d2.setTextColor(ContextCompat.getColor($this$onBindViewHolder_u24lambda_u2d2.getContext(), R.color.GC4));
        FontSizeTextViewExtKt.setScaledSizeRes$default($this$onBindViewHolder_u24lambda_u2d2, 2, R.dimen.personal_ai_card_v2_sub_desc_size, 0, 4, (Object) null);
        View $this$onBindViewHolder_u24lambda_u2d4 = personalAiSongRecommendCardItemViewHolder.itemView;
        ModuleActionListener moduleActionListener = this.listener;
        if (moduleActionListener != null) {
            moduleActionListener.onChildItemClickListener(bodyData, holder.getAdapterPosition(), this.cardPosition);
        }
        $this$onBindViewHolder_u24lambda_u2d4.setOnTouchListener(new TouchPressStateListener());
        $this$onBindViewHolder_u24lambda_u2d4.setOnClickListener(new PersonalAiSongRecommendCardAdapter$$ExternalSyntheticLambda0(this, bodyData, personalAiSongRecommendCardItemViewHolder, $this$onBindViewHolder_u24lambda_u2d4));
        ImageView $this$onBindViewHolder_u24lambda_u2d6 = holder.getMIvPlay();
        $this$onBindViewHolder_u24lambda_u2d6.setImageDrawable(ContextCompat.getDrawable($this$onBindViewHolder_u24lambda_u2d6.getContext(), R.drawable.personal_ai_play));
        FontSizeViewExtKt.setScaledSize$default($this$onBindViewHolder_u24lambda_u2d6, 2, getDp20(), getDp20(), 0, 8, (Object) null);
        $this$onBindViewHolder_u24lambda_u2d6.setOnClickListener(new PersonalAiSongRecommendCardAdapter$$ExternalSyntheticLambda1(this, bodyData, personalAiSongRecommendCardItemViewHolder, $this$onBindViewHolder_u24lambda_u2d6));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-4$lambda-3  reason: not valid java name */
    public static final void m14994onBindViewHolder$lambda4$lambda3(PersonalAiSongRecommendCardAdapter this$0, PersonalCenterTabItemModel $bodyData, PersonalAiSongRecommendCardItemViewHolder $holder, View $this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($bodyData, "$bodyData");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        ModuleActionListener moduleActionListener = this$0.listener;
        if (moduleActionListener != null) {
            moduleActionListener.onChildItemClickListener($bodyData, $holder.getAdapterPosition(), this$0.cardPosition);
        }
        String forceLogin = $bodyData.getForceLogin();
        if (forceLogin == null) {
            forceLogin = "";
        }
        if (TextUtils.equals(forceLogin, "1")) {
            AiPersonalUtils aiPersonalUtils = AiPersonalUtils.INSTANCE;
            Context context2 = $this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            aiPersonalUtils.aiCardCheckoutLoginAndRun(context2, $bodyData, new PersonalAiSongRecommendCardAdapter$onBindViewHolder$4$1$1(this$0));
            if (AppConfig.isDebug()) {
                Log.d(this$0.TAG, " 命中强制登录");
                return;
            }
            return;
        }
        this$0.jumpToDetail($bodyData);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-6$lambda-5  reason: not valid java name */
    public static final void m14995onBindViewHolder$lambda6$lambda5(PersonalAiSongRecommendCardAdapter this$0, PersonalCenterTabItemModel $bodyData, PersonalAiSongRecommendCardItemViewHolder $holder, ImageView $this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($bodyData, "$bodyData");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        ModuleActionListener moduleActionListener = this$0.listener;
        if (moduleActionListener != null) {
            moduleActionListener.onChildItemClickListener($bodyData, $holder.getAdapterPosition(), this$0.cardPosition);
        }
        String forceLogin = $bodyData.getForceLogin();
        if (forceLogin == null) {
            forceLogin = "";
        }
        if (TextUtils.equals(forceLogin, "1")) {
            AiPersonalUtils aiPersonalUtils = AiPersonalUtils.INSTANCE;
            Context context2 = $this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            aiPersonalUtils.aiCardCheckoutLoginAndRun(context2, $bodyData, new PersonalAiSongRecommendCardAdapter$onBindViewHolder$5$1$1(this$0));
            if (AppConfig.isDebug()) {
                Log.d(this$0.TAG, " 命中强制登录");
                return;
            }
            return;
        }
        this$0.jumpToDetail($bodyData);
    }

    /* access modifiers changed from: private */
    public final void jumpToDetail(PersonalCenterTabItemModel bodyData) {
        String tempScheme = null;
        if (TextUtils.isEmpty(bodyData != null ? bodyData.getMButtonSchema() : null)) {
            if (!TextUtils.isEmpty(bodyData != null ? bodyData.getScheme() : null)) {
                if (bodyData != null) {
                    tempScheme = bodyData.getScheme();
                }
            } else if (bodyData == null || (tempScheme = bodyData.getMSwitchButtonSchema()) == null) {
                tempScheme = "";
            }
        } else if (bodyData != null) {
            tempScheme = bodyData.getMButtonSchema();
        }
        Router.invoke(this.context, tempScheme);
        if (AppConfig.isDebug()) {
            Log.d(this.TAG, " jumpToDetail，scheme ：" + tempScheme + ' ');
        }
    }

    public final void setData(PersonalCenterTabModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getBody() != null && !data.getBody().isEmpty()) {
            this.mData.clear();
            this.mData.addAll(data.getBody());
            notifyDataSetChanged();
        } else if (AppConfig.isDebug()) {
            Log.e(this.TAG, " 数据为null ");
        }
    }
}
