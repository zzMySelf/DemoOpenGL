package com.baidu.browser.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class BdUrlExtractor {
    private static final String URL_EXP = "(http://|https://|www\\.)?([a-zA-Z_0-9]+\\.)+(biz|com|edu|gov|info|int|mil|name|net|org|pro|aero|cat|coop|jobs|museum|travel|arpa|root|mobi|post|tel|asia|geo|kid|mail|sco|web|xxx|nato|example|invalid|test|bitnet|csnet|onion|uucp|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw){1}(:[0-9]+)*(/($|[a-zA-Z0-9.,;?'\\+&amp;%$#=~_-]+))*";
    private static final String URL_FORMAT = "^(http://|https://|www\\.)?([a-zA-Z_0-9]+\\.)+([a-zA-Z_0-9]+){1}(:[0-9]+)*(/($|[a-zA-Z0-9.,;?'\\+&amp;%$#=~_-]+))*$";

    private BdUrlExtractor() {
    }

    public static String getUrlInText(String aText) {
        return findByRegex(aText);
    }

    private static String findByRegex(String aText) {
        Matcher matcher = Pattern.compile(URL_EXP, 2).matcher(aText);
        BdLog.d("wgn2: aText = " + aText);
        if (!matcher.find()) {
            return null;
        }
        String url = matcher.group();
        BdLog.d("wgn2: url = " + url);
        return url;
    }

    public static boolean isUrlValid(String aUrl) {
        return Pattern.compile(URL_FORMAT, 2).matcher(aUrl).find();
    }
}
