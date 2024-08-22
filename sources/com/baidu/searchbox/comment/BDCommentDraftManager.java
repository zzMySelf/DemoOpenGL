package com.baidu.searchbox.comment;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.LruCache;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.comment.definition.ICommentInput;
import com.baidu.searchbox.comment.interfacelayer.R;
import com.baidu.searchbox.comment.model.CommentAtDraftItemModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Map;
import java.util.Set;

public class BDCommentDraftManager {
    private static final String COMMENT_DRAFT_DIR_ROOT = "comment_draft_root";
    private static final String COMMENT_DRAFT_FILE_NAME = "drafts.json";
    private static final int DRAFT_COLOR = 0;
    private static int LRU_MAX_COUNT = 10;
    private static LruCache<String, ICommentInput.Draft> sCommentDrafts = new LruCache<>(LRU_MAX_COUNT);

    static {
        restoreDraftsFromDisk();
    }

    public static String getDraftId(int commentType, String parentId, String topicId, String sourceType, String key) {
        String draftId = null;
        if (1 == commentType) {
            draftId = parentId;
        } else if (!TextUtils.isEmpty(topicId)) {
            draftId = topicId;
        } else if (!TextUtils.isEmpty(sourceType) && !TextUtils.isEmpty(key)) {
            draftId = sourceType + key;
        }
        if (draftId == null) {
            return "";
        }
        return draftId;
    }

    public static void setDraft(String id, ICommentInput.Draft draft) {
        if (!TextUtils.isEmpty(id) && draft != null && draft.isValid()) {
            ICommentInput.Draft oldDraft = sCommentDrafts.get(id);
            if (oldDraft == null || !oldDraft.equals(draft)) {
                sCommentDrafts.put(id, draft);
                saveDraftsToDisk();
            }
        }
    }

    public static ICommentInput.Draft getDraft(String id) {
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return sCommentDrafts.get(id);
    }

    public static String getDraftText(String id) {
        ICommentInput.Draft draft;
        if (TextUtils.isEmpty(id) || (draft = sCommentDrafts.get(id)) == null) {
            return "";
        }
        return draft.text;
    }

    public static SpannableString getCompleteDraft(String id) {
        return getCompleteDraft(id, 0);
    }

    public static SpannableString getCompleteDraft(String id, int draftColor) {
        SpannableString draftMark;
        if (TextUtils.isEmpty(id)) {
            return new SpannableString("");
        }
        ICommentInput.Draft draft = sCommentDrafts.get(id);
        if (draft == null || !draft.isValid()) {
            return new SpannableString("");
        }
        SpannableString picturePrefix = new SpannableString(AppRuntime.getAppContext().getResources().getString(R.string.comment_drafthead) + " ");
        if (!TextUtils.isEmpty(draft.pictureUrl)) {
            draftMark = new SpannableString(picturePrefix + draft.text);
        } else {
            draftMark = new SpannableString(draft.text);
        }
        if (draftColor == 0) {
            draftColor = R.color.draft_text_color;
        }
        int i2 = 0;
        draftMark.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppRuntime.getAppContext(), draftColor)), 0, draftMark.length(), 0);
        if (!(draft.getAtDraftInfo() == null || draft.getAtDraftInfo().modelList == null)) {
            int atColor = ContextCompat.getColor(AppRuntime.getAppContext(), com.baidu.searchbox.interaction.styles.R.color.IC252);
            if (!TextUtils.isEmpty(draft.pictureUrl)) {
                i2 = picturePrefix.length();
            }
            int atOffset = i2;
            for (CommentAtDraftItemModel item : draft.getAtDraftInfo().modelList) {
                if (item.from >= 0 && item.to > item.from) {
                    draftMark.setSpan(new ForegroundColorSpan(atColor), item.from + atOffset, Math.min(item.to + 1 + atOffset, draftMark.length()), 33);
                }
            }
        }
        return draftMark;
    }

    public static void removeDraft(String id) {
        if (!TextUtils.isEmpty(id)) {
            sCommentDrafts.remove(id);
            saveDraftsToDisk();
        }
    }

    private static File getCommentDraftRootDir() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), COMMENT_DRAFT_DIR_ROOT);
    }

    private static void makeCommentDraftRootDirIfNecessary() {
        File praiseDir = getCommentDraftRootDir();
        if (!praiseDir.exists()) {
            praiseDir.mkdirs();
        }
    }

    private static void saveDraftsToDisk() {
        if (sCommentDrafts.size() >= 0) {
            String json = ICommentInput.Draft.toJson(sCommentDrafts.snapshot());
            makeCommentDraftRootDirIfNecessary();
            File savePath = new File(getCommentDraftRootDir(), COMMENT_DRAFT_FILE_NAME);
            FileUtils.deleteFile(savePath);
            if (!TextUtils.isEmpty(json)) {
                FileUtils.saveFile(json, savePath);
            }
        }
    }

    private static void restoreDraftsFromDisk() {
        Map<String, ICommentInput.Draft> draftMap;
        makeCommentDraftRootDirIfNecessary();
        File restorePath = new File(getCommentDraftRootDir(), COMMENT_DRAFT_FILE_NAME);
        if (restorePath.exists()) {
            String restoreStr = FileUtils.readFileData(restorePath);
            if (!TextUtils.isEmpty(restoreStr) && (draftMap = ICommentInput.Draft.valueOf(restoreStr)) != null && !draftMap.isEmpty()) {
                sCommentDrafts.evictAll();
                Set<Map.Entry<String, ICommentInput.Draft>> entrySet = draftMap.entrySet();
                if (entrySet != null) {
                    for (Map.Entry<String, ICommentInput.Draft> entry : entrySet) {
                        sCommentDrafts.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
