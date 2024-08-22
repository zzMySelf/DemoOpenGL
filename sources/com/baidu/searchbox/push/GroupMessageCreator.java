package com.baidu.searchbox.push;

import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.message.fangroup.FanGroupMessageItem;
import com.baidu.searchbox.push.mymessagefragment.viewholder.MyMessageAdapterViewHolder;
import com.baidu.searchbox.ui.view.BadgeView;

public class GroupMessageCreator extends BaseMultiStatusMsgCreator {
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    protected static final int GROUP_TYPE_FAN = 1;
    protected static final int GROUP_TYPE_NORMAL = 0;
    public int groupType = 0;

    public MyMessageItem createMessage(Object object) {
        if (object == null || !(object instanceof ChatSession)) {
            return null;
        }
        ChatSession session = (ChatSession) object;
        if (this.groupType == 0 && session.getChatType() != 3) {
            return null;
        }
        boolean z = true;
        if (this.groupType == 1 && session.getChatType() != 57) {
            return null;
        }
        GroupMessageItem item = this.groupType == 1 ? new FanGroupMessageItem() : new GroupMessageItem();
        item.iconUrl = session.getIconUrl();
        item.name = session.getName();
        item.description = session.getLastMsg();
        item.time = session.getLastMsgTime();
        item.formattedTime = MyMessageUtils.formatMessageTime(MessageRuntime.getAppContext(), item.time);
        item.hasRead = session.getNewMsgSum() <= 0;
        if (!MessageUtils.isBusinessAccount()) {
            item.notReadCount = MyMessageUtils.parseNotReadCount(session.getNewMsgSum());
            item.originalNotReadCount = session.getNewMsgSum();
        }
        item.isHighLight = session.isRed();
        item.notReadCount = MyMessageUtils.parseNotReadCount(session.getNewMsgSum());
        item.state = parseState(session.getState());
        item.userId = session.getContacter();
        item.defaultIconType = 4;
        item.vPortrait = session.getVPortrait();
        item.certification = session.getCertification();
        item.shield = session.getShield();
        item.contacter = session.getContacter();
        item.category = session.getCategory();
        item.chatType = session.getChatType();
        if (session.getMarkTop() != 1) {
            z = false;
        }
        item.isMarkTop = z;
        item.markTopTime = session.getMarkTopTime();
        item.groupShied = session.getDisturb();
        return item;
    }

    public MyMessageItem createMessage(Object object, Object obj) {
        if (!DEBUG) {
            return null;
        }
        throw new UnsupportedOperationException("Should not use GroupMessageCreator.createMessage(Object object, Object obj)!");
    }

    public View createView(View convertView, MyMessageItem item) {
        if (item != null && (item instanceof GroupMessageItem) && (convertView.getTag() instanceof MyMessageAdapterViewHolder)) {
            GroupMessageItem message = (GroupMessageItem) item;
            MyMessageAdapterViewHolder holder = (MyMessageAdapterViewHolder) convertView.getTag();
            if (TextUtils.isEmpty(item.name)) {
                ((GroupMessageItem) item).name = MessageRuntime.getAppContext().getResources().getString(R.string.group_chat);
            }
            holder.nameView.setText(message.name);
            holder.letterImageView.setLetter(message.name);
            holder.letterImageView.setTextSize(MessageRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.message_letter_text_size));
            holder.descriptionView.setText(parseEmotion(AppRuntime.getAppContext(), message.description, holder.descriptionView));
            setDescriptionTextColor(holder, message);
            holder.timeView.setVisibility(0);
            holder.timeView.setText(message.formattedTime);
            if (message.state == 2) {
                holder.sendOrFailedView.setVisibility(0);
                holder.sendOrFailedView.setImageResource(R.drawable.my_message_item_send);
                holder.stateView.setVisibility(8);
            } else if (message.state == 1) {
                holder.sendOrFailedView.setVisibility(0);
                holder.sendOrFailedView.setImageResource(R.drawable.my_message_item_failed);
                holder.stateView.setVisibility(8);
            } else if (message.state == 3) {
                holder.sendOrFailedView.setVisibility(8);
                holder.stateView.setVisibility(0);
                holder.stateView.setText(R.string.my_message_item_state_draft);
                holder.stateView.setTextColor(MessageRuntime.getAppContext().getResources().getColor(R.color.my_message_item_content_highlight));
            } else {
                holder.sendOrFailedView.setVisibility(8);
                holder.stateView.setVisibility(8);
            }
            if (item.isGroup) {
                holder.iconView.setVisibility(0);
                holder.letterImageView.setVisibility(4);
                MyMessageUtils.setIcon(message.iconUrl, message.defaultIconType, holder);
            } else {
                holder.letterImageView.setVisibility(0);
                holder.letterImageView.setBackgroundColorMark(message.userId);
                holder.iconView.setVisibility(4);
            }
            setItemBackground(holder, message);
            if (holder.vipIcon != null) {
                holder.vipIcon.setImageURI(message.vPortrait);
            }
            holder.certification.setVisibility(8);
            holder.lastMessageUser.setVisibility(8);
            if (holder.shield != null) {
                if (message.groupShied == 1) {
                    updateBadgeView(!TextUtils.isEmpty(message.notReadCount), holder, message, BadgeView.Type.DOT);
                    holder.shield.setVisibility(0);
                } else if (message.groupShied == 0) {
                    holder.shield.setVisibility(8);
                    updateBadgeView(!TextUtils.isEmpty(message.notReadCount), holder, message, BadgeView.Type.BIG_TEXT);
                }
            }
            if (holder.mHorizontalOverlapRoundImgView != null) {
                holder.mHorizontalOverlapRoundImgView.setVisibility(8);
            }
            if (holder.aiIcon != null) {
                holder.aiIcon.setVisibility(8);
            }
            return convertView;
        } else if (!DEBUG) {
            return convertView;
        } else {
            throw new IllegalArgumentException("The MyMessageItem is null or not a UserMessageItem!");
        }
    }

    /* access modifiers changed from: protected */
    public void parseImportantMsg(ChatSession session, GroupMessageItem item) {
        if (session.getNewMsgSum() > 0 && item.state != 2 && item.state != 1 && session.getRemindType() > 0) {
            item.importantMsgId = session.getRemindMsgid();
            item.importantMsgType = session.getRemindType();
            item.importantRemark = session.getRemindTypeRemark();
            if (session.getRemindType() == 1 || session.getRemindType() == 2 || session.getRemindType() == 4 || session.getRemindType() == 5 || session.getRemindType() == 3) {
                item.state = 4;
            }
        }
    }
}
