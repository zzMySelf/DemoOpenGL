package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastDateParser implements DateParser, Serializable {
    public static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) {
        public int modify(FastDateParser fastDateParser, int i2) {
            return i2 < 100 ? fastDateParser.adjustYear(i2) : i2;
        }
    };
    public static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    public static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    public static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) {
        public int modify(FastDateParser fastDateParser, int i2) {
            if (i2 != 7) {
                return 1 + i2;
            }
            return 1;
        }
    };
    public static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    public static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) {
        public int modify(FastDateParser fastDateParser, int i2) {
            if (i2 == 12) {
                return 0;
            }
            return i2;
        }
    };
    public static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) {
        public int modify(FastDateParser fastDateParser, int i2) {
            if (i2 == 24) {
                return 0;
            }
            return i2;
        }
    };
    public static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    public static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    public static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    public static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    public static final Comparator<String> LONGER_FIRST_LOWERCASE = new Comparator<String>() {
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    };
    public static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
    public static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    public static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) {
        public int modify(FastDateParser fastDateParser, int i2) {
            return i2 - 1;
        }
    };
    public static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    public static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    public static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    public static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    public static final long serialVersionUID = 3;
    public final int century;
    public final Locale locale;
    public final String pattern;
    public transient List<StrategyAndWidth> patterns;
    public final int startYear;
    public final TimeZone timeZone;

    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        public final int field;
        public final Map<String, Integer> lKeyValues;
        public final Locale locale;

        public CaseInsensitiveTextStrategy(int i2, Calendar calendar, Locale locale2) {
            super();
            this.field = i2;
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale2, i2, sb);
            sb.setLength(sb.length() - 1);
            sb.append(")");
            createPattern(sb);
        }

        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.field, this.lKeyValues.get(str.toLowerCase(this.locale)).intValue());
        }
    }

    public static class CopyQuotedStrategy extends Strategy {
        public final String formatField;

        public CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        public boolean isNumber() {
            return false;
        }

        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            int i3 = 0;
            while (i3 < this.formatField.length()) {
                int index = parsePosition.getIndex() + i3;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                } else if (this.formatField.charAt(i3) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                } else {
                    i3++;
                }
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }
    }

    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        public static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        public static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        public static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        public ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        public static Strategy getStrategy(int i2) {
            if (i2 == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i2 == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i2 == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            if (str.equals("Z")) {
                calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
                return;
            }
            calendar.setTimeZone(TimeZone.getTimeZone("GMT" + str));
        }
    }

    public static class NumberStrategy extends Strategy {
        public final int field;

        public NumberStrategy(int i2) {
            super();
            this.field = i2;
        }

        public boolean isNumber() {
            return true;
        }

        public int modify(FastDateParser fastDateParser, int i2) {
            return i2;
        }

        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i2 == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i3 = i2 + index;
                if (length > i3) {
                    length = i3;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, parseInt));
            return true;
        }
    }

    public static abstract class PatternStrategy extends Strategy {
        public Pattern pattern;

        public PatternStrategy() {
            super();
        }

        public void createPattern(StringBuilder sb) {
            createPattern(sb.toString());
        }

        public boolean isNumber() {
            return false;
        }

        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        public void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }
    }

    public static abstract class Strategy {
        public Strategy() {
        }

        public boolean isNumber() {
            return false;
        }

        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2);
    }

    public static class StrategyAndWidth {
        public final Strategy strategy;
        public final int width;

        public StrategyAndWidth(Strategy strategy2, int i2) {
            this.strategy = strategy2;
            this.width = i2;
        }

        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy2 = listIterator.next().strategy;
            listIterator.previous();
            if (strategy2.isNumber()) {
                return this.width;
            }
            return 0;
        }
    }

    public class StrategyParser {
        public int currentIdx;
        public final Calendar definingCalendar;
        public final String pattern;

        public StrategyParser(String str, Calendar calendar) {
            this.pattern = str;
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c) {
            int i2 = this.currentIdx;
            do {
                int i3 = this.currentIdx + 1;
                this.currentIdx = i3;
                if (i3 >= this.pattern.length() || this.pattern.charAt(this.currentIdx) != c) {
                    int i4 = this.currentIdx - i2;
                }
                int i32 = this.currentIdx + 1;
                this.currentIdx = i32;
                break;
            } while (this.pattern.charAt(this.currentIdx) != c);
            int i42 = this.currentIdx - i2;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c, i42, this.definingCalendar), i42);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.currentIdx < this.pattern.length()) {
                char charAt = this.pattern.charAt(this.currentIdx);
                if (!z && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i2 = this.currentIdx + 1;
                    this.currentIdx = i2;
                    if (i2 == this.pattern.length() || this.pattern.charAt(this.currentIdx) != '\'') {
                        z = !z;
                    }
                }
                this.currentIdx++;
                sb.append(charAt);
            }
            if (!z) {
                String sb2 = sb.toString();
                return new StrategyAndWidth(new CopyQuotedStrategy(sb2), sb2.length());
            }
            throw new IllegalArgumentException("Unterminated quote");
        }

        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= this.pattern.length()) {
                return null;
            }
            char charAt = this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(charAt)) {
                return letterPattern(charAt);
            }
            return literal();
        }
    }

    public static class TimeZoneStrategy extends PatternStrategy {
        public static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        public static final int ID = 0;
        public static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        public final Locale locale;
        public final Map<String, TzInfo> tzNames = new HashMap();

        public static class TzInfo {
            public int dstOffset;
            public TimeZone zone;

            public TzInfo(TimeZone timeZone, boolean z) {
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }
        }

        public TimeZoneStrategy(Locale locale2) {
            super();
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet<>(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale2).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i2 = 1; i2 < strArr.length; i2++) {
                        if (i2 == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i2 == 5) {
                            tzInfo2 = tzInfo;
                        }
                        String lowerCase = strArr[i2].toLowerCase(locale2);
                        if (treeSet.add(lowerCase)) {
                            this.tzNames.put(lowerCase, tzInfo2);
                        }
                    }
                }
            }
            for (String access$800 : treeSet) {
                sb.append('|');
                StringBuilder unused = FastDateParser.simpleQuote(sb, access$800);
            }
            sb.append(")");
            createPattern(sb);
        }

        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                calendar.setTimeZone(TimeZone.getTimeZone("GMT" + str));
            } else if (str.regionMatches(true, 0, "GMT", 0, 3)) {
                calendar.setTimeZone(TimeZone.getTimeZone(str.toUpperCase()));
            } else {
                TzInfo tzInfo = this.tzNames.get(str.toLowerCase(this.locale));
                calendar.set(16, tzInfo.dstOffset);
                calendar.set(15, tzInfo.zone.getRawOffset());
            }
        }
    }

    public FastDateParser(String str, TimeZone timeZone2, Locale locale2) {
        this(str, timeZone2, locale2, (Date) null);
    }

    /* access modifiers changed from: private */
    public int adjustYear(int i2) {
        int i3 = this.century + i2;
        return i2 >= this.startYear ? i3 : i3 + 100;
    }

    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale2, int i2, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i2, 0, locale2);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry next : displayNames.entrySet()) {
            String lowerCase = ((String) next.getKey()).toLowerCase(locale2);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, next.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb, (String) it.next()).append('|');
        }
        return hashMap;
    }

    public static ConcurrentMap<Locale, Strategy> getCache(int i2) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        synchronized (caches) {
            if (caches[i2] == null) {
                caches[i2] = new ConcurrentHashMap(3);
            }
            concurrentMap = caches[i2];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i2, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i2);
        Strategy strategy = (Strategy) cache.get(this.locale);
        if (strategy == null) {
            strategy = i2 == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i2, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    /* access modifiers changed from: private */
    public Strategy getStrategy(char c, int i2, Calendar calendar) {
        if (c != 'y') {
            if (c != 'z') {
                switch (c) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                return i2 >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i2);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i2 == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        return i2 > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(this.pattern, calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy != null) {
                this.patterns.add(nextStrategy);
            } else {
                return;
            }
        }
    }

    public static boolean isFormatLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(charAt == '$' || charAt == '.' || charAt == '?' || charAt == '^' || charAt == '[' || charAt == '\\' || charAt == '{' || charAt == '|')) {
                switch (charAt) {
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                        break;
                }
            }
            sb.append('\\');
            sb.append(charAt);
        }
        return sb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
        }
        throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
    }

    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    public FastDateParser(String str, TimeZone timeZone2, Locale locale2, Date date) {
        int i2;
        this.pattern = str;
        this.timeZone = timeZone2;
        this.locale = locale2;
        Calendar instance = Calendar.getInstance(timeZone2, locale2);
        if (date != null) {
            instance.setTime(date);
            i2 = instance.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i2 = 0;
        } else {
            instance.setTime(new Date());
            i2 = instance.get(1) - 80;
        }
        int i3 = (i2 / 100) * 100;
        this.century = i3;
        this.startYear = i2 - i3;
        init(instance);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        instance.clear();
        if (parse(str, parsePosition, instance)) {
            return instance.getTime();
        }
        return null;
    }

    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }
}
