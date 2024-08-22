package org.apache.commons.lang3.time;

import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    public static final long serialVersionUID = 1;
    public final Locale mLocale;
    public transient int mMaxLengthEstimate;
    public final String mPattern;
    public transient Rule[] mRules;
    public final TimeZone mTimeZone;

    public static class CharacterLiteral implements Rule {
        public final char mValue;

        public CharacterLiteral(char c) {
            this.mValue = c;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    public static class Iso8601_Rule implements Rule {
        public static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        public static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
        public static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        public final int length;

        public Iso8601_Rule(int i2) {
            this.length = i2;
        }

        public static Iso8601_Rule getRule(int i2) {
            if (i2 == 1) {
                return ISO8601_HOURS;
            }
            if (i2 == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i2 == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(15) + calendar.get(16);
            if (i2 == 0) {
                appendable.append("Z");
                return;
            }
            if (i2 < 0) {
                appendable.append('-');
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / 3600000;
            FastDatePrinter.appendDigits(appendable, i3);
            int i4 = this.length;
            if (i4 >= 5) {
                if (i4 == 6) {
                    appendable.append(':');
                }
                FastDatePrinter.appendDigits(appendable, (i2 / CometHttpRequestInterceptor.a) - (i3 * 60));
            }
        }

        public int estimateLength() {
            return this.length;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i2) throws IOException;
    }

    public static class PaddedNumberField implements NumberRule {
        public final int mField;
        public final int mSize;

        public PaddedNumberField(int i2, int i3) {
            if (i3 >= 3) {
                this.mField = i2;
                this.mSize = i3;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return this.mSize;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i2, this.mSize);
        }
    }

    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        public final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        public final int mField;
        public final String[] mValues;

        public TextField(int i2, String[] strArr) {
            this.mField = i2;
            this.mValues = strArr;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        public final Locale mLocale;
        public final int mStyle;
        public final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i2, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i2;
            } else {
                this.mStyle = i2;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (!this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) || this.mStyle != timeZoneDisplayKey.mStyle || !this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    public static class TimeZoneNameRule implements Rule {
        public final String mDaylight;
        public final Locale mLocale;
        public final String mStandard;
        public final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i2) {
            this.mLocale = locale;
            this.mStyle = i2;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i2, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i2, locale);
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) != 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            }
        }

        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        public static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        public static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        public final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(15) + calendar.get(16);
            if (i2 < 0) {
                appendable.append('-');
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / 3600000;
            FastDatePrinter.appendDigits(appendable, i3);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i2 / CometHttpRequestInterceptor.a) - (i3 * 60));
        }

        public int estimateLength() {
            return 5;
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        public static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendDigits(appendable, i2);
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        public final int mField;

        public TwoDigitNumberField(int i2) {
            this.mField = i2;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 < 100) {
                FastDatePrinter.appendDigits(appendable, i2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i2, 2);
            }
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        public static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendDigits(appendable, i2);
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        public static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 < 10) {
                appendable.append((char) (i2 + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i2);
            }
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        public final int mField;

        public UnpaddedNumberField(int i2) {
            this.mField = i2;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 < 10) {
                appendable.append((char) (i2 + 48));
            } else if (i2 < 100) {
                FastDatePrinter.appendDigits(appendable, i2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i2, 1);
            }
        }
    }

    public static class WeekYear implements NumberRule {
        public final NumberRule mRule;

        public WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            this.mRule.appendTo(appendable, CalendarReflection.getWeekYear(calendar));
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    public static void appendDigits(Appendable appendable, int i2) throws IOException {
        appendable.append((char) ((i2 / 10) + 48));
        appendable.append((char) ((i2 % 10) + 48));
    }

    public static void appendFullDigits(Appendable appendable, int i2, int i3) throws IOException {
        if (i2 < 10000) {
            int i4 = i2 < 1000 ? i2 < 100 ? i2 < 10 ? 1 : 2 : 3 : 4;
            for (int i5 = i3 - i4; i5 > 0; i5--) {
                appendable.append('0');
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            appendable.append((char) ((i2 / 1000) + 48));
                            i2 %= 1000;
                        } else {
                            return;
                        }
                    }
                    if (i2 >= 100) {
                        appendable.append((char) ((i2 / 100) + 48));
                        i2 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i2 >= 10) {
                    appendable.append((char) ((i2 / 10) + 48));
                    i2 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i2 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i6 = 0;
        while (i2 != 0) {
            cArr[i6] = (char) ((i2 % 10) + 48);
            i2 /= 10;
            i6++;
        }
        while (i6 < i3) {
            appendable.append('0');
            i3--;
        }
        while (true) {
            i6--;
            if (i6 >= 0) {
                appendable.append(cArr[i6]);
            } else {
                return;
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i2, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i2, locale);
        String str = (String) cTimeZoneDisplayCache.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String putIfAbsent = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i2 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i2;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        if (!this.mPattern.equals(fastDatePrinter.mPattern) || !this.mTimeZone.equals(fastDatePrinter.mTimeZone) || !this.mLocale.equals(fastDatePrinter.mLocale)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String str;
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        if (obj == null) {
            str = "<null>";
        } else {
            str = obj.getClass().getName();
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public List<Rule> parsePattern() {
        TextField textField;
        TwoDigitYearField twoDigitYearField;
        int i2;
        Object timeZoneNameRule;
        TextField textField2;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            iArr[i3] = i4;
            String parseToken = parseToken(this.mPattern, iArr);
            int i5 = iArr[i3];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i3);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() != 1) {
                                timeZoneNameRule = new StringLiteral(substring);
                                break;
                            } else {
                                timeZoneNameRule = new CharacterLiteral(substring.charAt(0));
                                break;
                            }
                        case 'K':
                            timeZoneNameRule = selectNumberRule(10, length2);
                            break;
                        case 'M':
                            if (length2 < 4) {
                                if (length2 != 3) {
                                    if (length2 != 2) {
                                        timeZoneNameRule = UnpaddedMonthField.INSTANCE;
                                        break;
                                    } else {
                                        timeZoneNameRule = TwoDigitMonthField.INSTANCE;
                                        break;
                                    }
                                } else {
                                    timeZoneNameRule = new TextField(2, shortMonths);
                                    break;
                                }
                            } else {
                                timeZoneNameRule = new TextField(2, months);
                                break;
                            }
                        case 'S':
                            timeZoneNameRule = selectNumberRule(14, length2);
                            break;
                        case 'a':
                            timeZoneNameRule = new TextField(9, amPmStrings);
                            break;
                        case 'd':
                            timeZoneNameRule = selectNumberRule(5, length2);
                            break;
                        case 'h':
                            timeZoneNameRule = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            timeZoneNameRule = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            timeZoneNameRule = selectNumberRule(12, length2);
                            break;
                        case 's':
                            timeZoneNameRule = selectNumberRule(13, length2);
                            break;
                        case 'u':
                            timeZoneNameRule = new DayInWeekField(selectNumberRule(7, length2));
                            break;
                        case 'w':
                            timeZoneNameRule = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    timeZoneNameRule = selectNumberRule(6, length2);
                                    break;
                                case 'E':
                                    textField2 = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case 'F':
                                    timeZoneNameRule = selectNumberRule(8, length2);
                                    break;
                                case 'G':
                                    i3 = 0;
                                    textField = new TextField(0, eras);
                                    break;
                                case 'H':
                                    timeZoneNameRule = selectNumberRule(11, length2);
                                    break;
                                default:
                                    switch (charAt) {
                                        case 'W':
                                            timeZoneNameRule = selectNumberRule(4, length2);
                                            break;
                                        case 'X':
                                            timeZoneNameRule = Iso8601_Rule.getRule(length2);
                                            break;
                                        case 'Y':
                                            break;
                                        case 'Z':
                                            if (length2 != 1) {
                                                if (length2 != 2) {
                                                    timeZoneNameRule = TimeZoneNumberRule.INSTANCE_COLON;
                                                    break;
                                                } else {
                                                    timeZoneNameRule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                                    break;
                                                }
                                            } else {
                                                timeZoneNameRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                                break;
                                            }
                                        default:
                                            throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                    }
                            }
                    }
                } else if (length2 >= 4) {
                    timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                } else {
                    timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                }
                textField2 = timeZoneNameRule;
                i3 = 0;
                textField = textField2;
                arrayList.add(textField);
                i4 = i5 + 1;
            }
            i3 = 0;
            if (length2 == 2) {
                twoDigitYearField = TwoDigitYearField.INSTANCE;
            } else {
                if (length2 < 4) {
                    i2 = 1;
                    length2 = 4;
                } else {
                    i2 = 1;
                }
                twoDigitYearField = selectNumberRule(i2, length2);
            }
            textField = charAt == 'Y' ? new WeekYear(twoDigitYearField) : twoDigitYearField;
            arrayList.add(textField);
            i4 = i5 + 1;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i2);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= length || str.charAt(i3) != charAt) {
                    break;
                }
                sb.append(charAt);
                i2 = i3;
            }
        } else {
            sb.append(ExtendedMessageFormat.QUOTE);
            boolean z = false;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i2);
                if (charAt2 == '\'') {
                    int i4 = i2 + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i2++;
            }
            i2--;
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public NumberRule selectNumberRule(int i2, int i3) {
        if (i3 == 1) {
            return new UnpaddedNumberField(i2);
        }
        if (i3 != 2) {
            return new PaddedNumberField(i2, i3);
        }
        return new TwoDigitNumberField(i2);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public static class DayInWeekField implements NumberRule {
        public final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = 7;
            int i3 = calendar.get(7);
            NumberRule numberRule = this.mRule;
            if (i3 != 1) {
                i2 = i3 - 1;
            }
            numberRule.appendTo(appendable, i2);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (Rule appendTo : this.mRules) {
                appendTo.appendTo(b, calendar);
            }
        } catch (IOException e) {
            ExceptionUtils.rethrow(e);
        }
        return b;
    }

    public static class TwelveHourField implements NumberRule {
        public final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(10);
            if (i2 == 0) {
                i2 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        public final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(11);
            if (i2 == 0) {
                i2 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    public String format(Object obj) {
        String str;
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        if (obj == null) {
            str = "<null>";
        } else {
            str = obj.getClass().getName();
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public String format(long j) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(newCalendar, stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    public <B extends Appendable> B format(long j, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRules(newCalendar, b);
    }

    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRules(newCalendar, b);
    }

    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(calendar, b);
    }
}
