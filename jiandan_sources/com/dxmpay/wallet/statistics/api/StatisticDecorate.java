package com.dxmpay.wallet.statistics.api;

import java.util.Collection;
import java.util.Map;

public class StatisticDecorate implements IStatistic {
    public IStatistic qw;

    public void onEvent(String str) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEvent(str);
        }
    }

    public void onEventEnd(String str, int i2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str, i2);
        }
    }

    public void onEventEndWithValue(String str, int i2, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, i2, str2);
        }
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection);
        }
    }

    public void onEventStart(String str) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventStart(str);
        }
    }

    public void onEventWithValue(String str, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValue(str, str2);
        }
    }

    public void onEventWithValues(String str, Collection<String> collection) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection);
        }
    }

    public void setStatistic(IStatistic iStatistic) {
        this.qw = iStatistic;
    }

    public void triggerSending() {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.triggerSending();
        }
    }

    public void onEvent(String str, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEvent(str, str2);
        }
    }

    public void onEventEnd(String str, int i2, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str, i2, str2);
        }
    }

    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, i2, str2, str3);
        }
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, map);
        }
    }

    public void onEventWithValue(String str, String str2, String str3) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValue(str, str2, str3);
        }
    }

    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, map);
        }
    }

    public void onEventEnd(String str) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str);
        }
    }

    public void onEventEndWithValue(String str, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, str2);
        }
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, str2);
        }
    }

    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, str2);
        }
    }

    public void onEventEnd(String str, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str, str2);
        }
    }

    public void onEventEndWithValue(String str, String str2, String str3) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, str2, str3);
        }
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, map, str2);
        }
    }

    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, map, str2);
        }
    }

    public void onEventEndWithValues(String str, Collection<String> collection) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, collection);
        }
    }

    public void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, collection, map);
        }
    }

    public void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, collection, str2);
        }
    }

    public void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic = this.qw;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, collection, map, str2);
        }
    }
}
