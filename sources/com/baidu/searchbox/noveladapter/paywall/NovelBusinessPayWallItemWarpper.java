package com.baidu.searchbox.noveladapter.paywall;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.paywall.openmodel.BusinessPayWallItem;

public class NovelBusinessPayWallItemWarpper implements NoProGuard {
    private BusinessPayWallItem mItemInfoModel = new BusinessPayWallItem();

    public BusinessPayWallItem getPayWallItem() {
        return this.mItemInfoModel;
    }

    public void setBookStatus(String bookStatus) {
        if (this.mItemInfoModel != null) {
            if ("连载".equals(bookStatus)) {
                this.mItemInfoModel.bookStatus = BusinessPayWallItem.BookStatus.UPDATING;
            } else if ("完结".equals(bookStatus)) {
                this.mItemInfoModel.bookStatus = BusinessPayWallItem.BookStatus.COMPLETED;
            } else {
                this.mItemInfoModel.bookStatus = BusinessPayWallItem.BookStatus.UNKNOWN;
            }
        }
    }

    public String getType() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.type;
    }

    public void setType(String type) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.type = type;
        }
    }

    public String getTplid() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.tplid;
    }

    public void setTplid(String tplid) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.tplid = tplid;
        }
    }

    public String getThirdId() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.thirdId;
    }

    public void setThirdId(String thirdId) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.thirdId = thirdId;
        }
    }

    public String getChapterNum() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.chapterNum;
    }

    public void setChapterNum(String chapterNum) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.chapterNum = chapterNum;
        }
    }

    public String getStatus() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.status;
    }

    public void setStatus(String status) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.status = status;
        }
    }

    public String getOwnType() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.ownType;
    }

    public void setOwnType(String ownType) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.ownType = ownType;
        }
    }

    public int getResourceFree() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return 0;
        }
        return businessPayWallItem.resourceFree;
    }

    public void setResourceFree(int resourceFree) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.resourceFree = resourceFree;
        }
    }

    public String getCover() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.cover;
    }

    public void setCover(String cover) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.cover = cover;
        }
    }

    public String getTitle() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.title;
    }

    public void setTitle(String title) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.title = title;
        }
    }

    public long getReadTime() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return 0;
        }
        return businessPayWallItem.readTime;
    }

    public void setReadTime(long readTime) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.readTime = readTime;
        }
    }

    public String getCmd() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.cmd;
    }

    public void setCmd(String cmd) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.cmd = cmd;
        }
    }

    public String getAuthor() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.author;
    }

    public void setAuthor(String author) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.author = author;
        }
    }

    public long getModifyTime() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return 0;
        }
        return businessPayWallItem.modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.modifyTime = modifyTime;
        }
    }

    public String getCouponInfo() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.couponInfo = couponInfo;
        }
    }

    public String getLastChapter() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.lastChapter = lastChapter;
        }
    }

    public boolean isOffline() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return false;
        }
        return businessPayWallItem.offline;
    }

    public void setOffline(boolean offline) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.offline = offline;
        }
    }

    public int getBookType() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return 0;
        }
        return businessPayWallItem.bookType;
    }

    public void setBookType(int bookType) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.bookType = bookType;
        }
    }

    public String getTagIcon() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return null;
        }
        return businessPayWallItem.tagIcon;
    }

    public void setTagIcon(String tagIcon) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.tagIcon = tagIcon;
        }
    }

    public int getIsRecommend() {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem == null) {
            return 0;
        }
        return businessPayWallItem.isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        BusinessPayWallItem businessPayWallItem = this.mItemInfoModel;
        if (businessPayWallItem != null) {
            businessPayWallItem.isRecommend = isRecommend;
        }
    }
}
