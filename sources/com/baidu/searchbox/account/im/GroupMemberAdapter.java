package com.baidu.searchbox.account.im;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.account.ImBaseMember;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.set.items.FansGroupSettingsUtils;
import com.baidu.searchbox.ui.stickylistheader.StickyListHeadersAdapter;
import com.baidu.spswitch.utils.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GroupMemberAdapter extends BaseAdapter implements SectionIndexer, StickyListHeadersAdapter {
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final char DEFAULTT_CHAR = '#';
    public static final char MANAGER_CHAR = '_';
    public static final String TITLE_AT_ALL_MEMBER = "全体成员";
    public static final String UK_AT_ALL_MEMBER = "-1";
    private int mActionType = -1;
    /* access modifiers changed from: private */
    public GroupMemberListActivity mContext = null;
    /* access modifiers changed from: private */
    public List<ImBaseMember> mData = new ArrayList();
    private int mIconRoundSize;
    private int mIconSize;
    private boolean mIsGroupManager;
    private boolean mIsGroupMaster;
    private boolean mIsStarGroup = true;
    private int mMainRoleSize;
    private boolean mNeedCheckbox = false;
    private String mRoleTag = "";
    private int[] mSectionIndices;
    private String[] mSectionLetters;
    private boolean mTopManager = true;

    public static class ViewHeaderHolder {
        public TextView header;
    }

    public boolean isNeedCheckbox() {
        return this.mNeedCheckbox;
    }

    public void setNeedCheckbox(boolean needCheckbox) {
        this.mNeedCheckbox = needCheckbox;
    }

    public void setTopManager(boolean managerTop) {
        this.mTopManager = managerTop;
    }

    public GroupMemberAdapter(GroupMemberListActivity context) {
        this.mContext = context;
        this.mIconRoundSize = MessageRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.myfriend_icon_round_size);
        this.mIconSize = MessageRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.xsearch_msg_icon_size);
    }

    public void setData(List<ImBaseMember> data, boolean needSort, boolean isStarGroup) {
        List<ImBaseMember> baseMemberList = new ArrayList<>(data);
        this.mIsStarGroup = isStarGroup;
        this.mData.clear();
        Collections.sort(baseMemberList, new Comparator<ImBaseMember>() {
            public int compare(ImBaseMember o1, ImBaseMember o2) {
                String s2 = null;
                String s1 = o1 == null ? null : o1.getPinyin();
                if (o2 != null) {
                    s2 = o2.getPinyin();
                }
                if (s1 == null) {
                    s1 = "";
                }
                if (s2 == null) {
                    s2 = "";
                }
                return s1.compareTo(s2);
            }
        });
        this.mData.addAll(baseMemberList);
        if (needSort) {
            sortByFirstChar();
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        List<ImBaseMember> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int position) {
        List<ImBaseMember> list = this.mData;
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        String name;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.item_select_friend_list, parent, false);
            holder = new Holder();
            holder.icon = (SimpleDraweeView) convertView.findViewById(R.id.site_icon);
            holder.textView = (TextView) convertView.findViewById(R.id.site_title);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            holder.checkBox.setVisibility(isNeedCheckbox() ? 0 : 8);
            holder.groupmanager = (TextView) convertView.findViewById(R.id.img_group_manager);
            FontSizeTextViewExtKt.setScaledSizeRes(holder.textView, 0, R.dimen.message_dimens_16dp);
            FontSizeTextViewExtKt.setScaledSizeRes(holder.groupmanager, 0, R.dimen.message_dimens_14dp);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            convertView.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.xsearch_list_item_background, (Resources.Theme) null));
        }
        holder.textView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        if (Build.VERSION.SDK_INT >= 21) {
            holder.checkBox.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.message_select_box, (Resources.Theme) null));
        }
        holder.groupmanager.setVisibility(FansGroupSettingsUtils.hasRole((ImBaseMember) getItem(position)) ? 0 : 8);
        ImBaseMember info = this.mData.get(position);
        if (holder.groupmanager.getVisibility() == 0) {
            showRoleTag(info, holder.groupmanager);
        }
        if (isNeedCheckbox()) {
            holder.checkBox.setVisibility(0);
            holder.checkBox.setChecked(this.mContext.isPersonSelected(info));
            convertView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Holder holder = (Holder) v.getTag();
                    holder.checkBox.toggle();
                    if (!holder.checkBox.isChecked()) {
                        GroupMemberAdapter.this.mContext.deletePerson((ImBaseMember) GroupMemberAdapter.this.mData.get(position));
                    } else if (!GroupMemberAdapter.this.mContext.addPerson((ImBaseMember) GroupMemberAdapter.this.mData.get(position))) {
                        holder.checkBox.toggle();
                    }
                }
            });
        } else {
            holder.checkBox.setVisibility(8);
        }
        if (this.mIsStarGroup) {
            if (!TextUtils.isEmpty(info.getNickName())) {
                name = info.getNickName();
            } else {
                name = info.getDisplayName();
            }
        } else if (!TextUtils.isEmpty(info.getRemark())) {
            name = info.getRemark();
        } else if (!TextUtils.isEmpty(info.getNickName())) {
            name = info.getNickName();
        } else {
            name = info.getDisplayName();
        }
        holder.textView.setText(name);
        if (!TextUtils.isEmpty(info.getAvatar())) {
            holder.icon.setImageURI(Uri.parse(info.getAvatar()));
        }
        return convertView;
    }

    private void showRoleTag(ImBaseMember info, TextView roleTag) {
        int strokeColor;
        int bgColor;
        int tagColor;
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius((float) UIUtils.dip2px(this.mContext, 8.0f));
        if (FansGroupSettingsUtils.isManager(info)) {
            tagColor = this.mContext.getResources().getColor(R.color.message_fans_group_manager_tag);
            bgColor = this.mContext.getResources().getColor(R.color.message_fans_group_manager_bg);
            strokeColor = this.mContext.getResources().getColor(R.color.message_fans_group_manager_stroke);
        } else {
            tagColor = this.mContext.getResources().getColor(R.color.message_fans_group_owner_tag);
            bgColor = this.mContext.getResources().getColor(R.color.message_fans_group_owner_bg);
            strokeColor = this.mContext.getResources().getColor(R.color.message_fans_group_owner_stroke);
        }
        drawable.setStroke(UIUtils.dip2px(this.mContext, 0.58f), strokeColor);
        drawable.setColor(bgColor);
        String tag = info.getRoleDisplayName();
        roleTag.setTextColor(tagColor);
        roleTag.setText(TextUtils.isEmpty(tag) ? this.mContext.getResources().getText(R.string.message_group_owner) : tag);
        FontSizeTextViewExtKt.setScaledSizeRes(roleTag, 0, R.dimen.message_dimens_9dp);
        roleTag.setBackground(drawable);
    }

    public char getItemFirstChar(int position) {
        ImBaseMember item = (ImBaseMember) getItem(position);
        if (position >= this.mMainRoleSize || !FansGroupSettingsUtils.hasRole(item) || !this.mTopManager) {
            return getItemFirstChar(item);
        }
        return MANAGER_CHAR;
    }

    private char getItemFirstChar(ImBaseMember info) {
        char firstChar = ' ';
        if (info != null && !TextUtils.isEmpty(info.getPinyin())) {
            firstChar = info.getPinyin().charAt(0);
        }
        if (firstChar > 'Z' || firstChar < 'A') {
            return '#';
        }
        return firstChar;
    }

    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        ViewHeaderHolder headerHolder;
        if (convertView == null) {
            headerHolder = new ViewHeaderHolder();
            convertView = View.inflate(this.mContext, R.layout.sociality_import_adbook_head_item, (ViewGroup) null);
            headerHolder.header = (TextView) convertView.findViewById(R.id.header_index);
            convertView.setTag(headerHolder);
        } else {
            headerHolder = (ViewHeaderHolder) convertView.getTag();
        }
        headerHolder.header.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.searchbox.follow.R.color.follow_list_section_bg));
        headerHolder.header.setTextColor(this.mContext.getResources().getColor(com.baidu.searchbox.follow.R.color.follow_list_section_text_color));
        headerHolder.header.setVisibility(0);
        if (position >= this.mMainRoleSize || !this.mTopManager) {
            char firstChar = getItemFirstChar(position);
            if (firstChar < 'A' || firstChar > 'Z') {
                firstChar = '#';
            }
            headerHolder.header.setText(firstChar + "");
        } else if (this.mActionType == 9) {
            headerHolder.header.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.mRoleTag)) {
            headerHolder.header.setText(this.mRoleTag);
        } else {
            headerHolder.header.setText(this.mContext.getResources().getText(R.string.message_group_owner));
        }
        return convertView;
    }

    public long getHeaderId(int position) {
        return (long) getItemFirstChar(position);
    }

    public int getPositionForSection(int sectionIndex) {
        int[] iArr = this.mSectionIndices;
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        if (sectionIndex > iArr.length - 1) {
            sectionIndex = iArr.length - 1;
        } else if (sectionIndex < 0) {
            sectionIndex = 0;
        }
        return iArr[sectionIndex];
    }

    public int getSectionForPosition(int position) {
        if (this.mSectionIndices == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.mSectionIndices;
            if (i2 >= iArr.length) {
                return iArr.length - 1;
            }
            if (position < iArr[i2]) {
                return i2 - 1;
            }
            i2++;
        }
    }

    public String[] getSections() {
        return this.mSectionLetters;
    }

    private void sortByFirstChar() {
        char lastChar = 0;
        ArrayList<Integer> sectionIndices = new ArrayList<>();
        ArrayList<String> sectionLetters = new ArrayList<>();
        List<ImBaseMember> tailDatas = new ArrayList<>();
        ImBaseMember owner = null;
        List<ImBaseMember> managerList = new ArrayList<>();
        Iterator<ImBaseMember> iterator = this.mData.iterator();
        int i2 = 0;
        while (iterator.hasNext()) {
            ImBaseMember data = iterator.next();
            if (FansGroupSettingsUtils.isOwner(data) && this.mTopManager) {
                owner = data;
                iterator.remove();
                sectionIndices.add(Integer.valueOf(i2));
                i2++;
            } else if (!FansGroupSettingsUtils.isManager(data) || !this.mTopManager) {
                char indexChar = getItemFirstChar(data);
                if (indexChar > 'Z' || indexChar < 'A') {
                    tailDatas.add(data);
                    iterator.remove();
                } else {
                    if (indexChar > lastChar) {
                        lastChar = indexChar;
                        sectionIndices.add(Integer.valueOf(i2));
                        sectionLetters.add(String.valueOf(lastChar));
                    }
                    i2++;
                }
            } else {
                managerList.add(data);
                iterator.remove();
                sectionIndices.add(Integer.valueOf(i2));
                i2++;
            }
        }
        if (managerList.size() > 0) {
            this.mData.addAll(0, managerList);
            this.mMainRoleSize += managerList.size();
        }
        if (owner != null) {
            this.mData.add(0, owner);
            this.mMainRoleSize++;
        }
        getRoleTag(owner, managerList);
        if (this.mActionType == 9 && (this.mIsGroupMaster || this.mIsGroupManager)) {
            String avatar = MessageUtils.getUri(R.drawable.message_at_all_member).toString();
            ImBaseMember allMember = new ImBaseMember();
            allMember.setNickName(TITLE_AT_ALL_MEMBER);
            allMember.setAvatar(avatar);
            allMember.setUK("-1");
            this.mMainRoleSize++;
            this.mData.add(0, allMember);
        }
        if (tailDatas.size() > 0) {
            this.mData.addAll(tailDatas);
            sectionIndices.add(Integer.valueOf(i2));
            sectionLetters.add(String.valueOf('#'));
        }
        int[] indices = new int[sectionIndices.size()];
        for (int j2 = 0; j2 < sectionIndices.size(); j2++) {
            indices[j2] = sectionIndices.get(j2).intValue();
        }
        this.mSectionIndices = indices;
        this.mSectionLetters = (String[]) sectionLetters.toArray(new String[0]);
    }

    private void getRoleTag(ImBaseMember owner, List<ImBaseMember> managerList) {
        String ownerDisplayName = "";
        String managerDisplayName = "";
        if (owner != null) {
            ownerDisplayName = owner.getRoleDisplayName();
        }
        if (managerList != null && managerList.size() > 0) {
            String roleDisplayName = managerList.get(0).getRoleDisplayName();
            if (!TextUtils.isEmpty(roleDisplayName)) {
                managerDisplayName = roleDisplayName;
            }
        }
        if (TextUtils.isEmpty(ownerDisplayName) && TextUtils.isEmpty(managerDisplayName)) {
            this.mRoleTag = (String) this.mContext.getResources().getText(R.string.message_group_owner);
        } else if (!TextUtils.isEmpty(ownerDisplayName) && TextUtils.isEmpty(managerDisplayName)) {
            this.mRoleTag = ownerDisplayName;
        } else if (!TextUtils.isEmpty(ownerDisplayName) || TextUtils.isEmpty(managerDisplayName)) {
            this.mRoleTag = ownerDisplayName + "/" + managerDisplayName;
        } else {
            this.mRoleTag = managerDisplayName;
        }
    }

    private static class Holder {
        CheckBox checkBox;
        TextView groupmanager;
        SimpleDraweeView icon;
        TextView textView;

        private Holder() {
        }
    }

    public void setActionType(int actionType) {
        this.mActionType = actionType;
    }

    public void setIsGroupMaster(boolean isGroupMaster) {
        this.mIsGroupMaster = isGroupMaster;
    }

    public void setIsGroupManager(boolean isGroupManager) {
        this.mIsGroupManager = isGroupManager;
    }
}
