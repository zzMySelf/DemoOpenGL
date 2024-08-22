package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

public class LookupTranslator extends CharSequenceTranslator {
    public final int longest;
    public final HashMap<String, String> lookupMap = new HashMap<>();
    public final HashSet<Character> prefixSet = new HashSet<>();
    public final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.prefixSet.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i3 = length < i3 ? length : i3;
                if (length > i4) {
                    i4 = length;
                }
            }
            i2 = i4;
        }
        this.shortest = i3;
        this.longest = i2;
    }

    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        if (!this.prefixSet.contains(Character.valueOf(charSequence.charAt(i2)))) {
            return 0;
        }
        int i3 = this.longest;
        if (i2 + i3 > charSequence.length()) {
            i3 = charSequence.length() - i2;
        }
        while (i3 >= this.shortest) {
            String str = this.lookupMap.get(charSequence.subSequence(i2, i2 + i3).toString());
            if (str != null) {
                writer.write(str);
                return i3;
            }
            i3--;
        }
        return 0;
    }
}
