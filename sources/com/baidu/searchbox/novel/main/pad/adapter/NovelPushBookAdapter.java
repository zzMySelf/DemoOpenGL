package com.baidu.searchbox.novel.main.pad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.pad.bean.NovelHomePageRecommendPushBookData;
import com.baidu.searchbox.novel.main.pad.holder.NovelPushBookHolder;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import java.util.List;

public class NovelPushBookAdapter extends RecyclerView.Adapter<NovelPushBookHolder> {
    private Context context;
    private int fontSizeType = 0;
    private boolean isNightMode = false;
    private List<NovelHomePageRecommendPushBookData.PushBook> pushBookList;

    public NovelPushBookAdapter(Context context2) {
        this.context = context2;
        this.fontSizeType = NovelFontSizeSettingsWrapper.getFontSizeType(context2);
        this.isNightMode = NovelNightModeUtils.isNightMode();
    }

    public void setPushBookList(List<NovelHomePageRecommendPushBookData.PushBook> pushBookList2) {
        this.pushBookList = pushBookList2;
        this.fontSizeType = NovelFontSizeSettingsWrapper.getFontSizeType(this.context);
        this.isNightMode = NovelNightModeUtils.isNightMode();
    }

    public NovelPushBookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context2 = this.context;
        if (context2 != null) {
            return new NovelPushBookHolder(LayoutInflater.from(context2).inflate(R.layout.novel_push_book_item, (ViewGroup) null));
        }
        return new NovelPushBookHolder((View) null);
    }

    public void onBindViewHolder(NovelPushBookHolder holder, int position) {
        List<NovelHomePageRecommendPushBookData.PushBook> list;
        NovelHomePageRecommendPushBookData.PushBook pushBook;
        if (holder != null && (list = this.pushBookList) != null && list.size() != 0 && position < this.pushBookList.size() && (pushBook = this.pushBookList.get(position)) != null) {
            holder.setData(pushBook);
        }
    }

    public int getItemCount() {
        List<NovelHomePageRecommendPushBookData.PushBook> list = this.pushBookList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isNightModeChanged() {
        return this.isNightMode != NovelNightModeUtils.isNightMode();
    }

    public boolean isFontSizeChanged() {
        return this.fontSizeType != NovelFontSizeSettingsWrapper.getFontSizeType(this.context);
    }
}
