package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.swan.apps.res.ui.wheelview3d.adapter.NumericWheelAdapter;
import com.baidu.swan.apps.res.ui.wheelview3d.listener.OnItemSelectedListener;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final int MONTH_COUNT = 12;
    public static final int START_YEAR = 1900;
    public static final String WHEEL_VIEW_DAY_TYPE = "day";
    public static final String WHEEL_VIEW_MONTH_TYPE = "month";
    public static final String WHEEL_VIEW_YEAR_TYPE = "year";
    private static final int YEAR_COUNT = 200;
    /* access modifiers changed from: private */
    public int mDay = 1;
    private int mDayNum = 31;
    private WheelView3d mDayWheelView;
    private boolean mDisabled;
    private Date mEndDate;
    private int mEndDay = 31;
    private int mEndMonth = 12;
    private int mEndYear = 2100;
    private String mFields;
    private int mGravityOffset = 12;
    /* access modifiers changed from: private */
    public int mMonth = 1;
    private WheelView3d mMonthWheelView;
    private int mOuterTextSize;
    private Date mStartDate;
    /* access modifiers changed from: private */
    public int mStartDay = 1;
    /* access modifiers changed from: private */
    public int mStartMonth = 1;
    /* access modifiers changed from: private */
    public int mStartYear = 1900;
    private int mTextSize;
    private OnTimeChangedListener mTimeChangeListener;
    /* access modifiers changed from: private */
    public int mYear = 1900;
    private WheelView3d mYearWheelView;

    public interface OnTimeChangedListener {
        void onTimeChanged(BdDatePicker bdDatePicker, int i2, int i3, int i4);
    }

    public BdDatePicker(Context context) {
        super(context);
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.aiapps_datepicker_layout, this);
        this.mGravityOffset = SwanAppUIUtils.dp2px((float) this.mGravityOffset);
        this.mTextSize = SwanAppUIUtils.dp2px(16.0f);
        this.mOuterTextSize = SwanAppUIUtils.dp2px(14.0f);
        WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.wheel_year);
        this.mYearWheelView = wheelView3d;
        wheelView3d.setCenterTextSize(this.mTextSize);
        this.mYearWheelView.setOuterTextSize(this.mOuterTextSize);
        this.mYearWheelView.setLineSpacingMultiplier(3.0f);
        this.mYearWheelView.setTextColorCenter(-16777216);
        this.mYearWheelView.setTextColorOut(-16777216);
        this.mYearWheelView.setDividerType(WheelView3d.DividerType.FILL);
        this.mYearWheelView.setVisibleItem(7);
        this.mYearWheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(WheelView3d wheelView, int index) {
                BdDatePicker bdDatePicker = BdDatePicker.this;
                int unused = bdDatePicker.mYear = bdDatePicker.mStartYear + index;
                BdDatePicker.this.initMonths();
                BdDatePicker.this.initDays();
            }
        });
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.wheel_month);
        this.mMonthWheelView = wheelView3d2;
        wheelView3d2.setCenterTextSize(this.mTextSize);
        this.mMonthWheelView.setOuterTextSize(this.mOuterTextSize);
        this.mMonthWheelView.setTextColorCenter(-16777216);
        this.mMonthWheelView.setTextColorOut(-16777216);
        this.mMonthWheelView.setLineSpacingMultiplier(3.0f);
        this.mMonthWheelView.setDividerType(WheelView3d.DividerType.FILL);
        this.mMonthWheelView.setVisibleItem(7);
        this.mMonthWheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(WheelView3d wheelView, int index) {
                BdDatePicker bdDatePicker = BdDatePicker.this;
                int unused = bdDatePicker.mMonth = bdDatePicker.mStartMonth + index;
                BdDatePicker.this.initDays();
            }
        });
        WheelView3d wheelView3d3 = (WheelView3d) findViewById(R.id.wheel_day);
        this.mDayWheelView = wheelView3d3;
        wheelView3d3.setCenterTextSize(this.mTextSize);
        this.mDayWheelView.setOuterTextSize(this.mOuterTextSize);
        this.mDayWheelView.setTextColorCenter(-16777216);
        this.mDayWheelView.setTextColorOut(-16777216);
        this.mDayWheelView.setLineSpacingMultiplier(3.0f);
        this.mDayWheelView.setDividerType(WheelView3d.DividerType.FILL);
        this.mDayWheelView.setVisibleItem(7);
        this.mDayWheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(WheelView3d wheelView, int index) {
                BdDatePicker bdDatePicker = BdDatePicker.this;
                int unused = bdDatePicker.mDay = bdDatePicker.mStartDay + index;
            }
        });
        initDatas();
    }

    private void initDatas() {
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2) + 1;
        this.mDay = calendar.get(5);
        updateDatas();
    }

    public void updateDatas() {
        initYears();
        initMonths();
        initDays();
    }

    private void initYears() {
        int i2 = this.mYear;
        int i3 = this.mStartYear;
        if (i2 < i3 || i2 > this.mEndYear) {
            this.mYear = i3;
        }
        this.mYearWheelView.setAdapter(new NumericWheelAdapter(this.mStartYear, this.mEndYear));
        setCyclic(this.mYearWheelView, this.mStartYear, this.mEndYear);
    }

    public void initMonths() {
        this.mStartMonth = 1;
        this.mEndMonth = 12;
        Date date = this.mStartDate;
        if (date != null && this.mYear == this.mStartYear) {
            this.mStartMonth = date.getMonth() + 1;
        }
        Date date2 = this.mEndDate;
        if (date2 != null && this.mYear == this.mEndYear) {
            this.mEndMonth = date2.getMonth() + 1;
        }
        this.mMonthWheelView.setAdapter(new NumericWheelAdapter(this.mStartMonth, this.mEndMonth));
        setCyclic(this.mMonthWheelView, this.mStartMonth, this.mEndMonth);
        setMonth(this.mMonth);
    }

    public void initDays() {
        int[] minMonths = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.mMonth) >= 0) {
            this.mDayNum = 31;
        } else if (Arrays.binarySearch(minMonths, this.mMonth) >= 0) {
            this.mDayNum = 30;
        } else {
            int i2 = this.mYear;
            if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                this.mDayNum = 28;
            } else {
                this.mDayNum = 29;
            }
        }
        this.mStartDay = 1;
        this.mEndDay = this.mDayNum;
        Date date = this.mStartDate;
        if (date != null && this.mYear == this.mStartYear && this.mMonth == date.getMonth() + 1) {
            this.mStartDay = this.mStartDate.getDate();
        }
        Date date2 = this.mEndDate;
        if (date2 != null && this.mYear == this.mEndYear && this.mMonth == date2.getMonth() + 1) {
            this.mEndDay = this.mEndDate.getDate();
        }
        this.mDayWheelView.setAdapter(new NumericWheelAdapter(this.mStartDay, this.mEndDay));
        setCyclic(this.mDayWheelView, this.mStartDay, this.mEndDay);
        setDay(this.mDay);
    }

    private void setCyclic(WheelView3d wheelView, int start, int end) {
        if ((end - start) + 1 <= 3) {
            wheelView.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(OnTimeChangedListener listener) {
        this.mTimeChangeListener = listener;
    }

    public void setYear(int year) {
        if (year < this.mStartYear) {
            year = this.mStartYear;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The year must be between " + this.mStartYear + " and " + this.mEndYear).showToastBottom();
            }
        } else if (year > this.mEndYear) {
            year = this.mEndYear;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The year must be between " + this.mStartYear + " and " + this.mEndYear).showToast();
            }
        }
        this.mYear = year;
        this.mYearWheelView.setCurrentItem(year - this.mStartYear);
    }

    public int getYear() {
        return this.mYear;
    }

    public void setMonth(int month) {
        if (month < this.mStartMonth) {
            month = this.mStartMonth;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The month must be between " + this.mStartMonth + " and " + this.mEndMonth).showToastBottom();
            }
        } else if (month > this.mEndMonth) {
            month = this.mEndMonth;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The month must be between " + this.mStartMonth + " and " + this.mEndMonth).showToast();
            }
        }
        this.mMonth = month;
        this.mMonthWheelView.setCurrentItem(month - this.mStartMonth);
    }

    public int getMonth() {
        return this.mMonth;
    }

    public void setDay(int day) {
        int i2;
        if (day < this.mStartDay || day > (i2 = this.mEndDay)) {
            day = this.mStartDay;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The day must be between " + this.mStartDay + " and " + this.mEndDay).showToast();
            }
        } else if (day > i2) {
            day = this.mEndDay;
            if (DEBUG) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "The day must be between " + this.mStartDay + " and " + this.mEndDay).showToastBottom();
            }
        }
        this.mDay = day;
        this.mDayWheelView.setCurrentItem(day - this.mStartDay);
    }

    public int getDay() {
        return this.mDay;
    }

    public void setStartDate(Date startDate) {
        if (startDate != null) {
            this.mStartDate = startDate;
            this.mStartYear = startDate.getYear() + 1900;
            return;
        }
        this.mStartYear = 1900;
    }

    public void setEndDate(Date endDate) {
        if (endDate != null) {
            this.mEndDate = endDate;
            this.mEndYear = endDate.getYear() + 1900;
            return;
        }
        this.mEndYear = 2100;
    }

    public void setFields(String fields) {
        this.mFields = fields;
        if (!TextUtils.isEmpty(fields)) {
            char c2 = 65535;
            switch (fields.hashCode()) {
                case 3704893:
                    if (fields.equals("year")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 104080000:
                    if (fields.equals("month")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.mYearWheelView.setGravity(17);
                    this.mMonthWheelView.setVisibility(8);
                    this.mDayWheelView.setVisibility(8);
                    return;
                case 1:
                    this.mYearWheelView.setGravity(5);
                    this.mYearWheelView.setGravityOffset(this.mGravityOffset);
                    this.mMonthWheelView.setGravity(3);
                    this.mMonthWheelView.setGravityOffset(this.mGravityOffset);
                    this.mMonthWheelView.setVisibility(0);
                    this.mDayWheelView.setVisibility(8);
                    return;
                default:
                    this.mYearWheelView.setGravity(5);
                    this.mYearWheelView.setGravityOffset(this.mGravityOffset);
                    this.mDayWheelView.setGravity(3);
                    this.mDayWheelView.setGravityOffset(this.mGravityOffset);
                    this.mMonthWheelView.setVisibility(0);
                    this.mDayWheelView.setVisibility(0);
                    return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isWheelViewVisible(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            int r1 = r5.hashCode()
            r2 = 1
            r3 = 0
            switch(r1) {
                case 99228: goto L_0x0021;
                case 3704893: goto L_0x0016;
                case 104080000: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x002b
        L_0x000b:
            java.lang.String r1 = "month"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x002c
        L_0x0016:
            java.lang.String r1 = "year"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x000a
            r1 = r3
            goto L_0x002c
        L_0x0021:
            java.lang.String r1 = "day"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x000a
            r1 = 2
            goto L_0x002c
        L_0x002b:
            r1 = -1
        L_0x002c:
            switch(r1) {
                case 0: goto L_0x0036;
                case 1: goto L_0x0033;
                case 2: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0039
        L_0x0030:
            com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d r0 = r4.mDayWheelView
            goto L_0x0039
        L_0x0033:
            com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d r0 = r4.mMonthWheelView
            goto L_0x0039
        L_0x0036:
            com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d r0 = r4.mYearWheelView
        L_0x0039:
            if (r0 == 0) goto L_0x0044
            int r1 = r0.getVisibility()
            if (r1 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r2 = r3
        L_0x0043:
            return r2
        L_0x0044:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.res.ui.BdDatePicker.isWheelViewVisible(java.lang.String):boolean");
    }

    public void setDisabled(boolean disabled) {
        this.mDisabled = disabled;
        this.mYearWheelView.setIsOptions(disabled);
        this.mMonthWheelView.setIsOptions(disabled);
        this.mDayWheelView.setIsOptions(disabled);
    }

    public void setScrollCycle(boolean scrollCycle) {
        this.mMonthWheelView.setCyclic(scrollCycle);
        this.mYearWheelView.setCyclic(scrollCycle);
        this.mDayWheelView.setCyclic(scrollCycle);
    }
}
