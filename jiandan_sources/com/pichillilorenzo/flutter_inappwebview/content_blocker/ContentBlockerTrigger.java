package com.pichillilorenzo.flutter_inappwebview.content_blocker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ContentBlockerTrigger {
    public List<String> ifDomain = new ArrayList();
    public List<String> ifTopUrl = new ArrayList();
    public List<String> loadType = new ArrayList();
    public List<ContentBlockerTriggerResourceType> resourceType = new ArrayList();
    public List<String> unlessDomain = new ArrayList();
    public List<String> unlessTopUrl = new ArrayList();
    @NonNull
    public String urlFilter;
    public Boolean urlFilterIsCaseSensitive;
    public Pattern urlFilterPatternCompiled;

    public ContentBlockerTrigger(@NonNull String str, @Nullable Boolean bool, @Nullable List<ContentBlockerTriggerResourceType> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable List<String> list5, @Nullable List<String> list6) {
        this.urlFilter = str;
        this.urlFilterPatternCompiled = Pattern.compile(str);
        this.resourceType = list == null ? this.resourceType : list;
        boolean z = false;
        this.urlFilterIsCaseSensitive = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
        this.ifDomain = list2 == null ? this.ifDomain : list2;
        this.unlessDomain = list3 == null ? this.unlessDomain : list3;
        if (!(!this.ifDomain.isEmpty() && !this.unlessDomain.isEmpty())) {
            list4 = list4 == null ? this.loadType : list4;
            this.loadType = list4;
            if (list4.size() <= 2) {
                this.ifTopUrl = list5 == null ? this.ifTopUrl : list5;
                this.unlessTopUrl = list6 == null ? this.unlessTopUrl : list6;
                if (!this.ifTopUrl.isEmpty() && !this.unlessTopUrl.isEmpty()) {
                    z = true;
                }
                if (z) {
                    throw new AssertionError();
                }
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static ContentBlockerTrigger fromMap(Map<String, Object> map) {
        String str = (String) map.get("url-filter");
        Boolean bool = (Boolean) map.get("url-filter-is-case-sensitive");
        List<String> list = (List) map.get("resource-type");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String fromValue : list) {
                arrayList.add(ContentBlockerTriggerResourceType.fromValue(fromValue));
            }
        } else {
            arrayList.addAll(Arrays.asList(ContentBlockerTriggerResourceType.values()));
        }
        return new ContentBlockerTrigger(str, bool, arrayList, (List) map.get("if-domain"), (List) map.get("unless-domain"), (List) map.get("load-type"), (List) map.get("if-top-url"), (List) map.get("unless-top-url"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentBlockerTrigger.class != obj.getClass()) {
            return false;
        }
        ContentBlockerTrigger contentBlockerTrigger = (ContentBlockerTrigger) obj;
        if (this.urlFilter.equals(contentBlockerTrigger.urlFilter) && this.urlFilterPatternCompiled.equals(contentBlockerTrigger.urlFilterPatternCompiled) && this.urlFilterIsCaseSensitive.equals(contentBlockerTrigger.urlFilterIsCaseSensitive) && this.resourceType.equals(contentBlockerTrigger.resourceType) && this.ifDomain.equals(contentBlockerTrigger.ifDomain) && this.unlessDomain.equals(contentBlockerTrigger.unlessDomain) && this.loadType.equals(contentBlockerTrigger.loadType) && this.ifTopUrl.equals(contentBlockerTrigger.ifTopUrl)) {
            return this.unlessTopUrl.equals(contentBlockerTrigger.unlessTopUrl);
        }
        return false;
    }

    public List<String> getIfDomain() {
        return this.ifDomain;
    }

    public List<String> getIfTopUrl() {
        return this.ifTopUrl;
    }

    public List<String> getLoadType() {
        return this.loadType;
    }

    public List<ContentBlockerTriggerResourceType> getResourceType() {
        return this.resourceType;
    }

    public List<String> getUnlessDomain() {
        return this.unlessDomain;
    }

    public List<String> getUnlessTopUrl() {
        return this.unlessTopUrl;
    }

    @NonNull
    public String getUrlFilter() {
        return this.urlFilter;
    }

    public Boolean getUrlFilterIsCaseSensitive() {
        return this.urlFilterIsCaseSensitive;
    }

    public Pattern getUrlFilterPatternCompiled() {
        return this.urlFilterPatternCompiled;
    }

    public int hashCode() {
        return (((((((((((((((this.urlFilter.hashCode() * 31) + this.urlFilterPatternCompiled.hashCode()) * 31) + this.urlFilterIsCaseSensitive.hashCode()) * 31) + this.resourceType.hashCode()) * 31) + this.ifDomain.hashCode()) * 31) + this.unlessDomain.hashCode()) * 31) + this.loadType.hashCode()) * 31) + this.ifTopUrl.hashCode()) * 31) + this.unlessTopUrl.hashCode();
    }

    public void setIfDomain(List<String> list) {
        this.ifDomain = list;
    }

    public void setIfTopUrl(List<String> list) {
        this.ifTopUrl = list;
    }

    public void setLoadType(List<String> list) {
        this.loadType = list;
    }

    public void setResourceType(List<ContentBlockerTriggerResourceType> list) {
        this.resourceType = list;
    }

    public void setUnlessDomain(List<String> list) {
        this.unlessDomain = list;
    }

    public void setUnlessTopUrl(List<String> list) {
        this.unlessTopUrl = list;
    }

    public void setUrlFilter(@NonNull String str) {
        this.urlFilter = str;
    }

    public void setUrlFilterIsCaseSensitive(Boolean bool) {
        this.urlFilterIsCaseSensitive = bool;
    }

    public void setUrlFilterPatternCompiled(Pattern pattern) {
        this.urlFilterPatternCompiled = pattern;
    }

    public String toString() {
        return "ContentBlockerTrigger{urlFilter='" + this.urlFilter + ExtendedMessageFormat.QUOTE + ", urlFilterPatternCompiled=" + this.urlFilterPatternCompiled + ", urlFilterIsCaseSensitive=" + this.urlFilterIsCaseSensitive + ", resourceType=" + this.resourceType + ", ifDomain=" + this.ifDomain + ", unlessDomain=" + this.unlessDomain + ", loadType=" + this.loadType + ", ifTopUrl=" + this.ifTopUrl + ", unlessTopUrl=" + this.unlessTopUrl + ExtendedMessageFormat.END_FE;
    }
}
