package com.baidu.swan.apps.publisher.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.publisher.utils.SpanStringUtils;
import com.baidu.swan.apps.util.SwanAppFrescoImageUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiInfoManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EMOJI_INFO_FILE = "emoji.json";
    private static final String EMOJI_REGEX = "\\[([一-龥\\w])+\\]";
    private static final String KEY_EMOJIS = "emoticons";
    private static final String KEY_PKG_ICON = "package_icon";
    private static final String NET_IMAGE_PREFIX = "http";
    private static final String TAG = "EmojiInfoManager";
    private static EmojiInfoManager mInstance;
    private HashMap<String, EmojiItem> mAllEmojis = new HashMap<>();
    private List<String> mEmojiOrderList = new ArrayList();

    public static EmojiInfoManager getInstance() {
        if (mInstance == null) {
            synchronized (EmojiInfoManager.class) {
                if (mInstance == null) {
                    mInstance = new EmojiInfoManager();
                }
            }
        }
        return mInstance;
    }

    private EmojiInfoManager() {
    }

    /* access modifiers changed from: package-private */
    public void loadEmojiInfo(String path, ViewGroup panelLayout) {
        JSONObject classicEmotionObj;
        JSONArray packages;
        JSONObject emotiInfoObject;
        String emojiUrl;
        Bitmap emojiBitmap;
        EmojiInfoManager emojiInfoManager = this;
        String str = path;
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "get emoji info from " + str);
        }
        File pathFile = new File(str);
        if (!pathFile.exists()) {
            ViewGroup viewGroup = panelLayout;
        } else if (!pathFile.isDirectory()) {
            ViewGroup viewGroup2 = panelLayout;
        } else {
            String fileContent = SwanAppFileUtils.readFileData(new File(str + File.separator + EMOJI_INFO_FILE));
            if (!TextUtils.isEmpty(fileContent)) {
                try {
                    JSONObject emotiInfoObject2 = new JSONObject(fileContent);
                    JSONArray packages2 = emotiInfoObject2.optJSONArray("packages");
                    if (packages2 != null && (classicEmotionObj = packages2.optJSONObject(0)) != null) {
                        String pkgIconFileName = classicEmotionObj.optString(KEY_PKG_ICON);
                        if (!TextUtils.isEmpty(pkgIconFileName)) {
                            try {
                                emojiInfoManager.initEmojiPkgIconView(str, panelLayout, pkgIconFileName);
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                                return;
                            }
                        } else {
                            ViewGroup viewGroup3 = panelLayout;
                        }
                        JSONArray allEmojiArray = classicEmotionObj.optJSONArray(KEY_EMOJIS);
                        emojiInfoManager.mEmojiOrderList.clear();
                        emojiInfoManager.mAllEmojis.clear();
                        if (allEmojiArray != null) {
                            int size = allEmojiArray.length();
                            int i2 = 0;
                            while (i2 < size) {
                                JSONObject iconObject = (JSONObject) allEmojiArray.get(i2);
                                String id = iconObject.optString("id");
                                String text = iconObject.optString("text");
                                String imgName = iconObject.optString("icon");
                                if (TextUtils.isEmpty(text) || TextUtils.isEmpty(imgName)) {
                                    emotiInfoObject = emotiInfoObject2;
                                    packages = packages2;
                                } else {
                                    emotiInfoObject = emotiInfoObject2;
                                    packages = packages2;
                                    if (!imgName.toLowerCase().startsWith("http")) {
                                        emojiBitmap = BitmapFactory.decodeFile(str + File.separator + imgName);
                                        emojiUrl = null;
                                    } else {
                                        emojiBitmap = null;
                                        emojiUrl = imgName;
                                    }
                                    emojiInfoManager.mEmojiOrderList.add(text);
                                    emojiInfoManager.mAllEmojis.put(text, new EmojiItem(id, text, emojiBitmap, emojiUrl));
                                }
                                i2++;
                                emojiInfoManager = this;
                                str = path;
                                emotiInfoObject2 = emotiInfoObject;
                                packages2 = packages;
                            }
                            JSONArray jSONArray = packages2;
                            return;
                        }
                        JSONArray jSONArray2 = packages2;
                        return;
                    }
                    return;
                } catch (JSONException e3) {
                    e = e3;
                    ViewGroup viewGroup4 = panelLayout;
                    e.printStackTrace();
                    return;
                }
            } else if (z) {
                Log.d(TAG, "读取emoji配置文件失败");
                return;
            } else {
                return;
            }
        }
        if (z) {
            Log.d(TAG, "文件路径错误");
        }
    }

    private void initEmojiPkgIconView(String path, ViewGroup panelLayout, String pkgIconFileName) {
        final ImageView pkgIconIv = (ImageView) panelLayout.findViewById(R.id.emoji_pkg_icon);
        if (pkgIconIv == null) {
            return;
        }
        if (!pkgIconFileName.toLowerCase().startsWith("http")) {
            Bitmap pkgIconBitmap = BitmapFactory.decodeFile(path + File.separator + pkgIconFileName);
            if (pkgIconBitmap != null) {
                pkgIconIv.setImageBitmap(pkgIconBitmap);
                return;
            }
            return;
        }
        SwanAppFrescoImageUtils.loadImageByFresco(pkgIconFileName, new SwanAppFrescoImageUtils.DownloadSwanAppIconListener() {
            public void getIcon(String url, final Bitmap bitmap) {
                if (bitmap != null) {
                    SwanAppUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            pkgIconIv.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public List<String> getEmojiOrderList() {
        return this.mEmojiOrderList;
    }

    public boolean isEmojiLoaded() {
        List<String> list = this.mEmojiOrderList;
        return list != null && list.size() > 0;
    }

    public Bitmap getEmojiBitmap(String key) {
        EmojiItem item;
        HashMap<String, EmojiItem> hashMap = this.mAllEmojis;
        if (hashMap == null || (item = hashMap.get(key)) == null) {
            return null;
        }
        return item.getImg();
    }

    public EmojiItem getEmojiItem(String key) {
        HashMap<String, EmojiItem> hashMap = this.mAllEmojis;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public SpannableString parseEmotion(Context context, CharSequence content, TextView textView) {
        ImageSpan span;
        if (DEBUG) {
            Log.d(TAG, "parseEmotion in UI thread, use cache");
        }
        SpannableString spannableString = new SpannableString(content);
        Matcher matcherEmotion = Pattern.compile(EMOJI_REGEX).matcher(spannableString);
        while (matcherEmotion.find()) {
            String key = matcherEmotion.group();
            int start = matcherEmotion.start();
            Bitmap emojiImg = getInstance().getEmojiBitmap(key);
            if (emojiImg == null) {
                break;
            }
            int size = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(emojiImg, size, size, true);
            if (scaledBitmap != null) {
                if (textView instanceof EditText) {
                    span = new SpanStringUtils.CenterImageSpanEditText(context.getApplicationContext(), scaledBitmap);
                } else {
                    span = new SpanStringUtils.CenterImageSpan(context.getApplicationContext(), scaledBitmap);
                }
                spannableString.setSpan(span, start, key.length() + start, 33);
            }
        }
        return spannableString;
    }
}
