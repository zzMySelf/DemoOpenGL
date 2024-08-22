package com.baidu.searchbox.comment.commentlist.manager;

import android.content.res.Configuration;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.comment.BaseHolder;
import com.baidu.searchbox.comment.data.CommonManagerControlData;
import com.baidu.searchbox.comment.definition.IBusinessManager;
import com.baidu.searchbox.comment.definition.ISubBusiness;
import com.baidu.searchbox.comment.definition.toolbar.ICommentBarProxy;
import com.baidu.searchbox.comment.list.CommonData;
import com.baidu.searchbox.comment.model.CommentModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface IProxyManager extends IBusinessManager {
    void addCommentItem(CommentModel commentModel, boolean z);

    void addData(ISubBusiness.SubBusinessEnum subBusinessEnum, CommonData commonData);

    void addData(ISubBusiness.SubBusinessEnum subBusinessEnum, CommonData commonData, int i2);

    void addDataList(ISubBusiness.SubBusinessEnum subBusinessEnum, List<CommonData> list, int i2);

    void afterBindViewHolder(BaseHolder baseHolder, int i2, int i3);

    void changeItem(ISubBusiness.SubBusinessEnum subBusinessEnum, int i2, CommonData commonData);

    void changeItemList(ISubBusiness.SubBusinessEnum subBusinessEnum, ArrayList<CommonData> arrayList);

    void configurationChanged(Configuration configuration);

    void delBusinessList(ISubBusiness.SubBusinessEnum subBusinessEnum, int i2);

    void delBusinessList(ISubBusiness.SubBusinessEnum subBusinessEnum, int i2, int i3);

    void delItem(ISubBusiness.SubBusinessEnum subBusinessEnum, int i2);

    void delItemByData(ISubBusiness.SubBusinessEnum subBusinessEnum, CommonData commonData);

    void delItemList(ISubBusiness.SubBusinessEnum subBusinessEnum);

    int doBlacklistDelComment(List<String> list);

    int findFirstViewPos();

    CommonData findItem(ISubBusiness.SubBusinessEnum subBusinessEnum, int i2);

    int findItemAbsolutePosition(int i2, ISubBusiness.SubBusinessEnum subBusinessEnum);

    List<CommonData> findItemList(ISubBusiness.SubBusinessEnum subBusinessEnum);

    int findLastVisibleItemPosition();

    int findPositionByObject(Object obj);

    View findViewByPosition(int i2);

    int getFirstPosition(ISubBusiness.SubBusinessEnum subBusinessEnum);

    int getFirstViewOffset();

    int getFirstViewPos();

    int getItemViewBottom(int i2, boolean z);

    int getLastCompletelyVisible();

    int getLastViewPos();

    LinkedList<CommonManagerControlData> getListData();

    RecyclerView getListView();

    void hideInteraction();

    boolean isItemCompletelyVisible(int i2);

    void notifyCommentRequestStatus(int i2);

    void notifyData();

    void notifyDataAdd(int i2);

    void notifyItemRangeChanged(int i2, int i3);

    void notifyItemRangeRemoved(int i2, int i3);

    void notifySingleData(int i2);

    void onCommentCountChange(int i2);

    void onNightModeChanged();

    void onPause(String str);

    void onResume();

    List<CommonData> removeLastComment(ISubBusiness.SubBusinessEnum subBusinessEnum);

    void revertScroll(int i2);

    int scrollItemContentBottomTo(int i2, int i3, int i4);

    void setCommentBarProxy(ICommentBarProxy iCommentBarProxy);

    void setSelectionPostion(int i2, int i3);
}
