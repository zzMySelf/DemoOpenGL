package com.itextpdf.text.html.simpleparser;

import androidx.core.net.MailTo;
import java.util.HashMap;

public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {
    public static final HTMLTagProcessor A = new yj();
    public static final HTMLTagProcessor BR = new uk();
    public static final HTMLTagProcessor DIV = new qw();
    public static final HTMLTagProcessor EM_STRONG_STRIKE_SUP_SUP = new th();
    public static final HTMLTagProcessor H = new Cif();
    public static final HTMLTagProcessor HR = new o();
    public static final HTMLTagProcessor IMG = new rg();
    public static final HTMLTagProcessor LI = new Cswitch();
    public static final HTMLTagProcessor PRE = new when();
    public static final HTMLTagProcessor SPAN = new pf();
    public static final HTMLTagProcessor TABLE = new ad();
    public static final HTMLTagProcessor TD = new fe();
    public static final HTMLTagProcessor TR = new de();
    public static final HTMLTagProcessor UL_OL = new i();
    public static final long serialVersionUID = -959260811961222824L;

    public static class ad implements HTMLTagProcessor {
    }

    public static class de implements HTMLTagProcessor {
    }

    public static class fe implements HTMLTagProcessor {
    }

    public static class i implements HTMLTagProcessor {
    }

    /* renamed from: com.itextpdf.text.html.simpleparser.HTMLTagProcessors$if  reason: invalid class name */
    public static class Cif implements HTMLTagProcessor {
    }

    public static class o implements HTMLTagProcessor {
    }

    public static class pf implements HTMLTagProcessor {
    }

    public static class qw implements HTMLTagProcessor {
    }

    public static class rg implements HTMLTagProcessor {
    }

    /* renamed from: com.itextpdf.text.html.simpleparser.HTMLTagProcessors$switch  reason: invalid class name */
    public static class Cswitch implements HTMLTagProcessor {
    }

    public static class th implements HTMLTagProcessor {
    }

    public static class uk implements HTMLTagProcessor {
    }

    public static class when implements HTMLTagProcessor {
    }

    public static class yj implements HTMLTagProcessor {
    }

    public HTMLTagProcessors() {
        put("a", A);
        put("b", EM_STRONG_STRIKE_SUP_SUP);
        put(MailTo.BODY, DIV);
        put("br", BR);
        put("div", DIV);
        put("em", EM_STRONG_STRIKE_SUP_SUP);
        put("font", SPAN);
        put("h1", H);
        put("h2", H);
        put("h3", H);
        put("h4", H);
        put("h5", H);
        put("h6", H);
        put("hr", HR);
        put(com.cmic.sso.sdk.e.i.a, EM_STRONG_STRIKE_SUP_SUP);
        put("img", IMG);
        put("li", LI);
        put("ol", UL_OL);
        put("p", DIV);
        put("pre", PRE);
        put("s", EM_STRONG_STRIKE_SUP_SUP);
        put("span", SPAN);
        put("strike", EM_STRONG_STRIKE_SUP_SUP);
        put("strong", EM_STRONG_STRIKE_SUP_SUP);
        put("sub", EM_STRONG_STRIKE_SUP_SUP);
        put("sup", EM_STRONG_STRIKE_SUP_SUP);
        put("table", TABLE);
        put("td", TD);
        put(fe.mmm.qw.tt.th.th.f8525rg, TD);
        put("tr", TR);
        put("u", EM_STRONG_STRIKE_SUP_SUP);
        put("ul", UL_OL);
    }
}
