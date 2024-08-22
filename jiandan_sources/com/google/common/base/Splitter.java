package com.google.common.base;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Splitter {
    public final int limit;
    public final boolean omitEmptyStrings;
    public final Strategy strategy;
    public final CharMatcher trimmer;

    @Beta
    public static final class MapSplitter {
        public static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        public final Splitter entrySplitter;
        public final Splitter outerSplitter;

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next : this.outerSplitter.split(charSequence)) {
                Iterator access$000 = this.entrySplitter.splittingIterator(next);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
                String str = (String) access$000.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str), "Duplicate key [%s] found.", (Object) str);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
                linkedHashMap.put(str, (String) access$000.next());
                Preconditions.checkArgument(!access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        public MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }
    }

    public static abstract class SplittingIterator extends AbstractIterator<String> {
        public int limit;
        public int offset = 0;
        public final boolean omitEmptyStrings;
        public final CharSequence toSplit;
        public final CharMatcher trimmer;

        public SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        public abstract int separatorEnd(int i2);

        public abstract int separatorStart(int i2);

        public String computeNext() {
            int i2;
            int i3 = this.offset;
            while (true) {
                int i4 = this.offset;
                if (i4 == -1) {
                    return (String) endOfData();
                }
                int separatorStart = separatorStart(i4);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                int i5 = this.offset;
                if (i5 == i3) {
                    int i6 = i5 + 1;
                    this.offset = i6;
                    if (i6 > this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i3 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i3))) {
                        i3++;
                    }
                    while (i2 > i3 && this.trimmer.matches(this.toSplit.charAt(i2 - 1))) {
                        separatorStart = i2 - 1;
                    }
                    if (!this.omitEmptyStrings || i3 != i2) {
                        int i7 = this.limit;
                    } else {
                        i3 = this.offset;
                    }
                }
            }
            int i72 = this.limit;
            if (i72 == 1) {
                i2 = this.toSplit.length();
                this.offset = -1;
                while (i2 > i3 && this.trimmer.matches(this.toSplit.charAt(i2 - 1))) {
                    i2--;
                }
            } else {
                this.limit = i72 - 1;
            }
            return this.toSplit.subSequence(i3, i2).toString();
        }
    }

    public interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    public Splitter(Strategy strategy2) {
        this(strategy2, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    public static Splitter fixedLength(final int i2) {
        Preconditions.checkArgument(i2 > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i2) {
                        return i2;
                    }

                    public int separatorStart(int i2) {
                        int i3 = i2 + i2;
                        if (i3 < this.toSplit.length()) {
                            return i3;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    /* access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    public Splitter limit(int i2) {
        Preconditions.checkArgument(i2 > 0, "must be greater than zero: %s", i2);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i2);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder appendTo = on.appendTo(sb, (Iterable<?>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    public Splitter(Strategy strategy2, boolean z, CharMatcher charMatcher, int i2) {
        this.strategy = strategy2;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i2;
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i2) {
                        return i2 + 1;
                    }

                    public int separatorStart(int i2) {
                        return charMatcher.indexIn(this.toSplit, i2);
                    }
                };
            }
        });
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c) {
        return withKeyValueSeparator(on(c));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i2) {
                        return i2 + str.length();
                    }

                    public int separatorStart(int i2) {
                        int length = str.length();
                        int length2 = this.toSplit.length() - length;
                        while (i2 <= length2) {
                            int i3 = 0;
                            while (i3 < length) {
                                if (this.toSplit.charAt(i3 + i2) != str.charAt(i3)) {
                                    i2++;
                                } else {
                                    i3++;
                                }
                            }
                            return i2;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return on((CommonPattern) new JdkPattern(pattern));
    }

    public static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", (Object) commonPattern);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = commonPattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i2) {
                        return matcher.end();
                    }

                    public int separatorStart(int i2) {
                        if (matcher.find(i2)) {
                            return matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }
}
