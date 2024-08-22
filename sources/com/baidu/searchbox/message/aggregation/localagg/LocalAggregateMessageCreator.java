package com.baidu.searchbox.message.aggregation.localagg;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.push.BaseMultiStatusMsgCreator;
import com.baidu.searchbox.push.MyMessageCreator;
import com.baidu.searchbox.push.MyMessageItem;
import com.baidu.searchbox.push.MyMessageUtils;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.mymessagefragment.viewholder.MyMessageAdapterViewHolder;
import com.baidu.searchbox.ui.view.BadgeView;

public class LocalAggregateMessageCreator extends BaseMultiStatusMsgCreator {
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    private static final String TAG = LocalAggregateMessageCreator.class.getSimpleName();

    public MyMessageItem createMessage(Object object) {
        return createMessage(object, (Object) null);
    }

    public MyMessageItem createMessage(Object object, Object obj) {
        if (object == null || !(object instanceof ChatSession)) {
            return null;
        }
        ChatSession session = (ChatSession) object;
        LocalAggregateMessageItem item = new LocalAggregateMessageItem();
        item.iconUrl = session.getClassAvatar();
        if (!TextUtils.isEmpty(session.getNickName())) {
            item.name = session.getNickName();
        } else if (!TextUtils.isEmpty(session.getClassTitle())) {
            item.name = session.getClassTitle();
        } else {
            item.name = session.getName();
        }
        item.time = session.getLastMsgTime();
        item.formattedTime = MyMessageUtils.formatMessageTime(MessageRuntime.getAppContext(), item.time);
        boolean z = true;
        item.hasRead = session.getNewMsgSum() == 0;
        item.isHighLight = session.isRed();
        item.notReadCount = MyMessageUtils.parseNotReadCount(session.getNewMsgSum());
        item.originalNotReadCount = session.getNewMsgSum();
        item.state = parseState(session.getState());
        item.vPortrait = session.getVPortrait();
        item.certification = session.getCertification();
        item.shield = session.getShield();
        item.contacter = session.getContacter();
        item.contacterId = session.getContacterId();
        item.category = session.getCategory();
        item.chatType = session.getChatType();
        item.businessType = session.getBusinessType();
        item.classType = session.getClassType();
        item.classSubType = session.getClassSubType();
        item.defaultIconType = 8;
        item.description = session.getLastMsg();
        if (!(obj instanceof String) || !TextUtils.equals((String) obj, MyMessageCreator.CREATE_TYPE_NO_MARK_TOP)) {
            if (session.getMarkTop() != 1) {
                z = false;
            }
            item.isMarkTop = z;
            item.markTopTime = session.getMarkTopTime();
        } else {
            item.isMarkTop = false;
        }
        item.disturb = session.getDisturb();
        return item;
    }

    public View createView(View convertView, MyMessageItem item) {
        if (item != null && (item instanceof LocalAggregateMessageItem) && (convertView.getTag() instanceof MyMessageAdapterViewHolder)) {
            LocalAggregateMessageItem message = (LocalAggregateMessageItem) item;
            MyMessageAdapterViewHolder holder = (MyMessageAdapterViewHolder) convertView.getTag();
            holder.nameView.setText(message.name);
            holder.descriptionView.setText(parseEmotion(AppRuntime.getAppContext(), message.description, holder.descriptionView));
            setDescriptionTextColor(holder, message);
            if (TextUtils.isEmpty(message.formattedTime)) {
                holder.timeView.setVisibility(8);
            } else {
                holder.timeView.setVisibility(0);
                holder.timeView.setText(message.formattedTime);
            }
            updateUnreadViewDisplay(holder, message);
            holder.sendOrFailedView.setVisibility(8);
            holder.stateView.setVisibility(8);
            holder.iconView.setVisibility(0);
            MyMessageUtils.setIcon(message.iconUrl, message.defaultIconType, holder);
            holder.letterImageView.setVisibility(8);
            setItemBackground(holder, message);
            holder.vipIcon.setVisibility(8);
            holder.certification.setVisibility(8);
            if (!supportAggDisturb(message)) {
                holder.shield.setVisibility(8);
            } else if (message.disturb == 1) {
                holder.shield.setVisibility(0);
            } else {
                holder.shield.setVisibility(8);
            }
            holder.lastMessageUser.setVisibility(8);
            if (holder.mHorizontalOverlapRoundImgView != null) {
                holder.mHorizontalOverlapRoundImgView.setVisibility(8);
            }
            if (item.isMarkTop && item.classType == 15) {
                holder.rootView.setBackground(ResourcesCompat.getDrawable(MessageRuntime.getAppContext().getResources(), R.drawable.xsearch_list_item_background, (Resources.Theme) null));
            }
            if (holder.aiIcon != null) {
                holder.aiIcon.setVisibility(8);
            }
            showGuideIfNeed(message);
            return convertView;
        } else if (!DEBUG) {
            return convertView;
        } else {
            throw new RuntimeException("The MyMessageItem is null or not a LocalAggregateMessageItem!");
        }
    }

    /* access modifiers changed from: protected */
    public void updateUnreadViewDisplay(MyMessageAdapterViewHolder holder, LocalAggregateMessageItem message) {
        BadgeView.Type unReadDisplayType;
        boolean z = true;
        if (supportAggDisturb(message)) {
            unReadDisplayType = (message.originalNotReadCount < 0 || message.disturb == 1) ? BadgeView.Type.DOT : BadgeView.Type.BIG_TEXT;
        } else {
            unReadDisplayType = BadgeView.Type.DOT;
        }
        if (DEBUG) {
            LogUtils.d(TAG, "updateUnreadViewDisplay == > name: " + message.name + " updateBadgeView hasUnread :" + (message.originalNotReadCount != 0) + ", message.clearUnread :" + message.clearUnread + ", type :" + unReadDisplayType);
        }
        if (message.originalNotReadCount == 0) {
            z = false;
        }
        updateBadgeView(z, holder, message, unReadDisplayType);
        if (holder.badgeView != null) {
            holder.badgeView.updateBadgeSize();
            ViewGroup.LayoutParams layoutParams = holder.badgeView.getLayoutParams();
            if (layoutParams != null) {
                holder.badgeView.setMinWidth(layoutParams.height);
            }
        }
    }

    private boolean supportAggDisturb(LocalAggregateMessageItem message) {
        return message.classType != 14;
    }

    /* access modifiers changed from: protected */
    public void showGuideIfNeed(LocalAggregateMessageItem message) {
        if (!supportAggDisturb(message) && MarketAggregateUtil.needShowGuide()) {
            MarketAggregateUtil.showGuide();
            UniversalToast.makeText(MessageRuntime.getAppContext(), R.string.message_market_aggregate_guide).showToast();
        }
    }
}
