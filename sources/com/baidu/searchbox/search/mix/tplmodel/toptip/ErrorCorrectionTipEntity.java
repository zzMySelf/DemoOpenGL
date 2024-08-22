package com.baidu.searchbox.search.mix.tplmodel.toptip;

import com.baidu.browser.statistic.BrowserStatisticConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0016J\b\u0010/\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u00066"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/ErrorCorrectionTipEntity;", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopResultEntity;", "()V", "correctWord", "", "getCorrectWord", "()Ljava/lang/String;", "setCorrectWord", "(Ljava/lang/String;)V", "correctWordClass", "getCorrectWordClass", "setCorrectWordClass", "correctWordInfos", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/HighLightInfo;", "Lkotlin/collections/ArrayList;", "getCorrectWordInfos", "()Ljava/util/ArrayList;", "setCorrectWordInfos", "(Ljava/util/ArrayList;)V", "correctWordSwitch", "", "getCorrectWordSwitch", "()Z", "setCorrectWordSwitch", "(Z)V", "isFullReplace", "setFullReplace", "isPartReplace", "setPartReplace", "originalUrl", "getOriginalUrl", "setOriginalUrl", "originalWord", "getOriginalWord", "setOriginalWord", "replaceUrl", "getReplaceUrl", "setReplaceUrl", "replaceWord", "getReplaceWord", "setReplaceWord", "rootClass", "getRootClass", "setRootClass", "isCorrectWordInfosOk", "isOk", "isOriginalInfoOk", "isReplaceInfoOk", "parseJson", "", "jsonObject", "Lorg/json/JSONObject;", "parseToJson", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorCorrectionTipEntity.kt */
public final class ErrorCorrectionTipEntity extends TopResultEntity {
    private String correctWord;
    private String correctWordClass;
    private ArrayList<HighLightInfo> correctWordInfos;
    private boolean correctWordSwitch;
    private boolean isFullReplace;
    private boolean isPartReplace;
    private String originalUrl;
    private String originalWord;
    private String replaceUrl;
    private String replaceWord;
    private String rootClass;

    public final boolean isFullReplace() {
        return this.isFullReplace;
    }

    public final void setFullReplace(boolean z) {
        this.isFullReplace = z;
    }

    public final boolean isPartReplace() {
        return this.isPartReplace;
    }

    public final void setPartReplace(boolean z) {
        this.isPartReplace = z;
    }

    public final String getReplaceWord() {
        return this.replaceWord;
    }

    public final void setReplaceWord(String str) {
        this.replaceWord = str;
    }

    public final String getReplaceUrl() {
        return this.replaceUrl;
    }

    public final void setReplaceUrl(String str) {
        this.replaceUrl = str;
    }

    public final String getOriginalWord() {
        return this.originalWord;
    }

    public final void setOriginalWord(String str) {
        this.originalWord = str;
    }

    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    public final void setOriginalUrl(String str) {
        this.originalUrl = str;
    }

    public final String getRootClass() {
        return this.rootClass;
    }

    public final void setRootClass(String str) {
        this.rootClass = str;
    }

    public final boolean getCorrectWordSwitch() {
        return this.correctWordSwitch;
    }

    public final void setCorrectWordSwitch(boolean z) {
        this.correctWordSwitch = z;
    }

    public final String getCorrectWordClass() {
        return this.correctWordClass;
    }

    public final void setCorrectWordClass(String str) {
        this.correctWordClass = str;
    }

    public final ArrayList<HighLightInfo> getCorrectWordInfos() {
        return this.correctWordInfos;
    }

    public final void setCorrectWordInfos(ArrayList<HighLightInfo> arrayList) {
        this.correctWordInfos = arrayList;
    }

    public final String getCorrectWord() {
        return this.correctWord;
    }

    public final void setCorrectWord(String str) {
        this.correctWord = str;
    }

    public JSONObject parseToJson() {
        JSONObject jsonObject = super.parseToJson().put("isFullReplace", this.isFullReplace).put("isPartReplace", this.isPartReplace).put("replaceWord", this.replaceWord).put("replaceUrl", this.replaceUrl).put("originalWord", this.originalWord).put(BrowserStatisticConstants.UBC_PAGE_DURATION_ORIGINAL_URL, this.originalUrl).put("rootClass", this.rootClass);
        if (this.correctWordSwitch) {
            jsonObject.put("correctWordSwitch", true).put("correctWordClass", this.correctWordClass);
            JSONArray jsonArray = new JSONArray();
            ArrayList<HighLightInfo> $this$forEach$iv = this.correctWordInfos;
            if ($this$forEach$iv != null) {
                for (HighLightInfo it : $this$forEach$iv) {
                    jsonArray.put(new JSONObject().put("word", it.getWord()).put("type", it.getType()));
                }
            }
            jsonObject.put("correctWordInfos", new JSONArray(this.correctWordInfos));
        }
        Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
        return jsonObject;
    }

    public void parseJson(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        super.parseJson(jsonObject);
        this.isFullReplace = jsonObject.optBoolean("isFullReplace");
        this.isPartReplace = jsonObject.optBoolean("isPartReplace");
        this.replaceWord = jsonObject.optString("replaceWord");
        this.replaceUrl = jsonObject.optString("replaceUrl");
        this.originalWord = jsonObject.optString("originalWord");
        this.originalUrl = jsonObject.optString(BrowserStatisticConstants.UBC_PAGE_DURATION_ORIGINAL_URL);
        this.rootClass = jsonObject.optString("rootClass");
        boolean optBoolean = jsonObject.optBoolean("correctWordSwitch");
        this.correctWordSwitch = optBoolean;
        if (optBoolean) {
            this.correctWordClass = jsonObject.optString("correctWordClass");
            String infos = jsonObject.optString("correctWordInfos");
            Intrinsics.checkNotNullExpressionValue(infos, "infos");
            if (infos.length() > 0) {
                JSONArray infoArray = new JSONArray(infos);
                this.correctWordInfos = new ArrayList<>();
                StringBuilder correctWordSB = new StringBuilder();
                int length = infoArray.length();
                for (int index = 0; index < length; index++) {
                    JSONObject highLight = infoArray.optJSONObject(index);
                    if (highLight != null) {
                        String word = highLight.optString("word");
                        ArrayList<HighLightInfo> arrayList = this.correctWordInfos;
                        if (arrayList != null) {
                            Intrinsics.checkNotNullExpressionValue(word, "word");
                            arrayList.add(new HighLightInfo(word, highLight.optInt("type")));
                        }
                        if (correctWordSB.append(word) != null) {
                        }
                    }
                    ArrayList<HighLightInfo> arrayList2 = this.correctWordInfos;
                    if (arrayList2 != null) {
                        Boolean.valueOf(arrayList2.add(new HighLightInfo("", 0)));
                    }
                }
                this.correctWord = correctWordSB.toString();
            }
        }
    }

    public boolean isOk() {
        if (this.isFullReplace || this.isPartReplace) {
            if (!isReplaceInfoOk() || !isOriginalInfoOk()) {
                return false;
            }
            return isCorrectWordInfosOk();
        } else if (isReplaceInfoOk()) {
            return isCorrectWordInfosOk();
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isOriginalInfoOk() {
        /*
            r3 = this;
            java.lang.String r0 = r3.originalUrl
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != r1) goto L_0x0015
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r3.originalWord
            if (r0 == 0) goto L_0x002b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0026
            r0 = r1
            goto L_0x0027
        L_0x0026:
            r0 = r2
        L_0x0027:
            if (r0 != r1) goto L_0x002b
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            if (r0 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.mix.tplmodel.toptip.ErrorCorrectionTipEntity.isOriginalInfoOk():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isReplaceInfoOk() {
        /*
            r3 = this;
            java.lang.String r0 = r3.replaceUrl
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != r1) goto L_0x0015
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r3.replaceWord
            if (r0 == 0) goto L_0x002b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0026
            r0 = r1
            goto L_0x0027
        L_0x0026:
            r0 = r2
        L_0x0027:
            if (r0 != r1) goto L_0x002b
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            if (r0 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.mix.tplmodel.toptip.ErrorCorrectionTipEntity.isReplaceInfoOk():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isCorrectWordInfosOk() {
        /*
            r3 = this;
            boolean r0 = r3.correctWordSwitch
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0030
            java.util.ArrayList<com.baidu.searchbox.search.mix.tplmodel.toptip.HighLightInfo> r0 = r3.correctWordInfos
            if (r0 == 0) goto L_0x0015
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r3.correctWord
            if (r0 == 0) goto L_0x002b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0026
            r0 = r2
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            if (r0 != r2) goto L_0x002b
            r0 = r2
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r1 = r2
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.mix.tplmodel.toptip.ErrorCorrectionTipEntity.isCorrectWordInfosOk():boolean");
    }
}
