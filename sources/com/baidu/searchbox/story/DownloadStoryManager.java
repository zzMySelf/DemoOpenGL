package com.baidu.searchbox.story;

import android.content.Context;
import com.baidu.searchbox.environment.runtime.NovelRuntime;
import com.baidu.searchbox.novel.ioc.container.INovelAbility;
import com.baidu.searchbox.noveladapter.novelruntime.NovelRuntimeWarpper;
import com.baidu.searchbox.story.NovelDiffUtility;
import com.baidu.searchbox.story.data.CatalogItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public final class DownloadStoryManager {
    public static final String KEY_NOVEL_GID = "gid";
    public static final String NOVEL_CACHE_CHAPTER_PATH = "download_chapter_cache";
    public static final String NOVEL_CACHE_PATH = "download_novel_cache";
    public static final String NOVEL_DIRECTORY_NAME = "bookdriectory.pb";
    public static final String TAG = DownloadStoryManager.class.getCanonicalName();
    public static DownloadStoryManager mManager;
    public static HashMap<Long, NovelDiffInfo> novelDiffList = new HashMap<>();

    private DownloadStoryManager(Context context) {
    }

    public static DownloadStoryManager getInstance(Context context) {
        if (mManager == null) {
            synchronized (DownloadStoryManager.class) {
                if (mManager == null) {
                    mManager = new DownloadStoryManager(context);
                }
            }
        }
        return mManager;
    }

    public static int checkStoryData(long gid, String filename, String boundary, long downloadMod) {
        INovelAbility iNovelAbility = NovelRuntime.getNovelAbility();
        if (iNovelAbility == null) {
            return 0;
        }
        return iNovelAbility.checkStoryData(NovelRuntimeWarpper.getAppContext(), gid, filename, boundary, downloadMod).optInt("errorCode");
    }

    public static class NovelDiffInfo {
        private LinkedHashMap<String, NovelDiffUtility.RangeInfo> addList = new LinkedHashMap<>();
        private ArrayList<String> deleteList = new ArrayList<>();
        private String md5;
        private LinkedList<NovelDiffUtility.MergeRangeInfo> ranglist = new LinkedList<>();
        private long timeStamp;
        private LinkedHashMap<String, NovelDiffUtility.RangeInfo> updateList = new LinkedHashMap<>();

        public void setTimeStamp(long timeStamp2) {
            this.timeStamp = timeStamp2;
        }

        public long getTimeStamp() {
            return this.timeStamp;
        }

        public void setMd5(String md52) {
            this.md5 = md52;
        }

        public String getMd5() {
            return this.md5;
        }

        public ArrayList<String> getDeleteList() {
            return this.deleteList;
        }

        public LinkedHashMap<String, NovelDiffUtility.RangeInfo> getAddList() {
            return this.addList;
        }

        public LinkedHashMap<String, NovelDiffUtility.RangeInfo> getUpdateList() {
            return this.updateList;
        }

        public LinkedList<NovelDiffUtility.MergeRangeInfo> getRanglist() {
            return this.ranglist;
        }

        private void add(CatalogItem item) {
            this.addList.put(item.getCid(), new NovelDiffUtility.RangeInfo(item.getContentOffsetStart(), item.getContentOffsetEnd()));
            merge(item);
        }

        private void merge(CatalogItem item) {
            if (this.ranglist.isEmpty()) {
                createMergeInfo(item);
                return;
            }
            NovelDiffUtility.MergeRangeInfo mergeInfo = this.ranglist.getLast();
            if (mergeInfo.getEnd() + 1 == item.getContentOffsetStart()) {
                mergeInfo.append(item.getCid(), item.getContentOffsetStart(), item.getContentOffsetEnd());
            } else {
                createMergeInfo(item);
            }
        }

        private void createMergeInfo(CatalogItem item) {
            ArrayList<String> cidList = new ArrayList<>();
            cidList.add(item.getCid());
            this.ranglist.add(new NovelDiffUtility.MergeRangeInfo(cidList, item.getContentOffsetStart(), item.getContentOffsetEnd()));
        }

        private void update(CatalogItem item) {
            this.updateList.put(item.getCid(), new NovelDiffUtility.RangeInfo(item.getContentOffsetStart(), item.getContentOffsetEnd()));
            merge(item);
        }

        private void delete(CatalogItem item) {
            this.deleteList.add(item.getCid());
        }

        public void diff(List<CatalogItem> newChapterList, List<CatalogItem> oldChapterList) {
            HashMap<String, CatalogItem> oldChapterMap = new HashMap<>();
            if (oldChapterList != null) {
                for (CatalogItem item : oldChapterList) {
                    oldChapterMap.put(item.getCid(), item);
                }
            }
            for (CatalogItem item2 : newChapterList) {
                if (item2.getContentOffsetStart() != 0 || item2.getContentOffsetEnd() != 0) {
                    CatalogItem oldItem = oldChapterMap.remove(item2.getCid());
                    if (oldItem == null) {
                        add(item2);
                    } else if (oldItem.getContentOffsetStart() == 0 && oldItem.getContentOffsetEnd() == 0) {
                        add(item2);
                    } else if (oldItem.getUpdateTime() != item2.getUpdateTime()) {
                        update(item2);
                    }
                }
            }
            if (!oldChapterMap.isEmpty()) {
                for (CatalogItem item3 : oldChapterMap.values()) {
                    if (item3.getContentOffsetStart() != 0 || item3.getContentOffsetEnd() != 0) {
                        delete(item3);
                    }
                }
            }
        }
    }
}
