package com.baidu.cyberplayer.debug.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.cyberplayer.debug.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class DebugGroupLayout extends FrameLayout {
    private TextView mGroupTitle;
    private LinearLayout mGroupTitleRoot;
    private String mGroupTitleStr;
    private LinearLayout mItemContainer;
    private HashMap<String, String> mItems;

    public DebugGroupLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DebugGroupLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DebugGroupLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.debug_group_layout, this);
        this.mItemContainer = (LinearLayout) findViewById(R.id.debug_item_container);
        this.mGroupTitle = (TextView) findViewById(R.id.group_title);
        this.mGroupTitleRoot = (LinearLayout) findViewById(R.id.group_title_root);
    }

    public void setContent(GroupModel groupModel) {
        this.mGroupTitleStr = groupModel.getTitle();
        this.mItems = groupModel.getItems();
        updateViews();
    }

    public void updateViews() {
        if (TextUtils.isEmpty(this.mGroupTitleStr)) {
            this.mGroupTitleRoot.setVisibility(8);
        } else {
            this.mGroupTitle.setText(this.mGroupTitleStr);
        }
        HashMap<String, String> hashMap = this.mItems;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : this.mItems.entrySet()) {
                LinearLayout itemLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.debug_item_layout, this.mItemContainer, false);
                TextView keyText = (TextView) itemLayout.findViewById(R.id.key_text);
                TextView valueText = (TextView) itemLayout.findViewById(R.id.value_text);
                keyText.setText(entry.getKey());
                valueText.setText(entry.getValue());
                this.mItemContainer.addView(itemLayout);
            }
        }
    }

    public static class GroupModel {
        private HashMap<String, String> mItems = new LinkedHashMap();
        private String mTitle;

        public void setTitle(String title) {
            this.mTitle = title;
        }

        public void addItem(String key, String value) {
            this.mItems.put(key, value);
        }

        public HashMap<String, String> getItems() {
            return this.mItems;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public JSONObject makeJson() {
            try {
                JSONObject itemsObj = new JSONObject();
                for (Map.Entry<String, String> entry : this.mItems.entrySet()) {
                    itemsObj.put(entry.getKey(), entry.getValue());
                }
                JSONObject groupObj = new JSONObject();
                groupObj.put(this.mTitle, itemsObj);
                return groupObj;
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
