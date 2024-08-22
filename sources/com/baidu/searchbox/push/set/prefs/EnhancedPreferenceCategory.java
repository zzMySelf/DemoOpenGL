package com.baidu.searchbox.push.set.prefs;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.widget.preference.Preference;
import com.baidu.searchbox.widget.preference.PreferenceCategory;
import com.baidu.searchbox.widget.preference.PreferenceGroup;

public class EnhancedPreferenceCategory extends PreferenceCategory {
    private PreferenceGroup mParent;

    public EnhancedPreferenceCategory(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public EnhancedPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EnhancedPreferenceCategory(Context context) {
        super(context);
    }

    public void setParent(PreferenceGroup parent) {
        this.mParent = parent;
    }

    public boolean removePreference(Preference preference) {
        PreferenceGroup preferenceGroup;
        if (!super.removePreference(preference)) {
            return false;
        }
        if (getPreferenceCount() != 0 || (preferenceGroup = this.mParent) == null) {
            return true;
        }
        preferenceGroup.removePreference(this);
        return true;
    }

    public boolean addPreference(Preference preference) {
        if (super.findPreference(preference.getKey()) != null || !super.addPreference(preference)) {
            return false;
        }
        PreferenceGroup preferenceGroup = this.mParent;
        if (preferenceGroup == null || preferenceGroup.findPreference(getKey()) != null) {
            return true;
        }
        this.mParent.addPreference(this);
        return true;
    }
}
