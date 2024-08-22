package com.itextpdf.text;

import com.baidu.android.common.others.IStringUtil;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.c.qw;
import fe.when.ad.ddd;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import fe.when.ad.fe;
import fe.when.ad.xxx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Section extends ArrayList<Element> implements TextElementArray, LargeElement, Indentable, IAccessibleElement {
    public static final int NUMBERSTYLE_DOTTED = 0;
    public static final int NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT = 1;
    public static final long serialVersionUID = 3324172577544748043L;
    public boolean addedCompletely = false;
    public boolean bookmarkOpen = true;
    public String bookmarkTitle;
    public boolean complete = true;
    public float indentation;
    public float indentationLeft;
    public float indentationRight;
    public boolean notAddedYet = true;
    public int numberDepth;
    public int numberStyle = 0;
    public ArrayList<Integer> numbers = null;
    public int subsections = 0;
    public Paragraph title;
    public boolean triggerNewPage = false;

    public Section() {
        Paragraph paragraph = new Paragraph();
        this.title = paragraph;
        this.numberDepth = 1;
        paragraph.setRole(new s0("H" + this.numberDepth));
    }

    public static Paragraph constructTitle(Paragraph paragraph, ArrayList<Integer> arrayList, int i2, int i3) {
        if (paragraph == null) {
            return null;
        }
        int min = Math.min(arrayList.size(), i2);
        if (min < 1) {
            return paragraph;
        }
        StringBuffer stringBuffer = new StringBuffer(" ");
        for (int i4 = 0; i4 < min; i4++) {
            stringBuffer.insert(0, IStringUtil.CURRENT_PATH);
            stringBuffer.insert(0, arrayList.get(i4).intValue());
        }
        if (i3 == 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 2);
        }
        Paragraph paragraph2 = new Paragraph((Phrase) paragraph);
        paragraph2.add(0, (Element) new fe(stringBuffer.toString(), paragraph.getFont()));
        return paragraph2;
    }

    private void setNumbers(int i2, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.numbers = arrayList2;
        arrayList2.add(Integer.valueOf(i2));
        this.numbers.addAll(arrayList);
    }

    public boolean addAll(Collection<? extends Element> collection) {
        if (collection.size() == 0) {
            return false;
        }
        for (Element add : collection) {
            add(add);
        }
        return true;
    }

    public ddd addMarkedSection() {
        ddd ddd = new ddd(new Section((Paragraph) null, this.numberDepth + 1));
        add((Element) ddd);
        return ddd;
    }

    public Section addSection(float f, Paragraph paragraph, int i2) {
        if (!isAddedCompletely()) {
            Section section = new Section(paragraph, i2);
            section.setIndentation(f);
            add((Element) section);
            return section;
        }
        throw new IllegalStateException(qw.ad("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public void flushContent() {
        setNotAddedYet(false);
        this.title = null;
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element instanceof Section) {
                Section section = (Section) element;
                if (section.isComplete() || size() != 1) {
                    section.setAddedCompletely(true);
                } else {
                    section.flushContent();
                    return;
                }
            }
            it.remove();
        }
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        return this.title.getAccessibleAttribute(s0Var);
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.title.getAccessibleAttributes();
    }

    public Paragraph getBookmarkTitle() {
        String str = this.bookmarkTitle;
        if (str == null) {
            return getTitle();
        }
        return new Paragraph(str);
    }

    public List<fe> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Element) it.next()).getChunks());
        }
        return arrayList;
    }

    public int getDepth() {
        return this.numbers.size();
    }

    public fe.when.ad.qw getId() {
        return this.title.getId();
    }

    public float getIndentation() {
        return this.indentation;
    }

    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    public float getIndentationRight() {
        return this.indentationRight;
    }

    public int getNumberDepth() {
        return this.numberDepth;
    }

    public int getNumberStyle() {
        return this.numberStyle;
    }

    public s0 getRole() {
        return this.title.getRole();
    }

    public Paragraph getTitle() {
        return constructTitle(this.title, this.numbers, this.numberDepth, this.numberStyle);
    }

    public boolean isAddedCompletely() {
        return this.addedCompletely;
    }

    public boolean isBookmarkOpen() {
        return this.bookmarkOpen;
    }

    public boolean isChapter() {
        return type() == 16;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isNestable() {
        return false;
    }

    public boolean isNotAddedYet() {
        return this.notAddedYet;
    }

    public boolean isSection() {
        return type() == 13;
    }

    public boolean isTriggerNewPage() {
        return this.triggerNewPage && this.notAddedYet;
    }

    public void newPage() {
        add((Element) fe.f470switch);
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = iterator();
            while (it.hasNext()) {
                elementListener.ad((Element) it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        this.title.setAccessibleAttribute(s0Var, y0Var);
    }

    public void setAddedCompletely(boolean z) {
        this.addedCompletely = z;
    }

    public void setBookmarkOpen(boolean z) {
        this.bookmarkOpen = z;
    }

    public void setBookmarkTitle(String str) {
        this.bookmarkTitle = str;
    }

    public void setChapterNumber(int i2) {
        ArrayList<Integer> arrayList = this.numbers;
        arrayList.set(arrayList.size() - 1, Integer.valueOf(i2));
        Iterator it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Section) {
                ((Section) next).setChapterNumber(i2);
            }
        }
    }

    public void setComplete(boolean z) {
        this.complete = z;
    }

    public void setId(fe.when.ad.qw qwVar) {
        this.title.setId(qwVar);
    }

    public void setIndentation(float f) {
        this.indentation = f;
    }

    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setNotAddedYet(boolean z) {
        this.notAddedYet = z;
    }

    public void setNumberDepth(int i2) {
        this.numberDepth = i2;
    }

    public void setNumberStyle(int i2) {
        this.numberStyle = i2;
    }

    public void setRole(s0 s0Var) {
        this.title.setRole(s0Var);
    }

    public void setTitle(Paragraph paragraph) {
        this.title = paragraph;
    }

    public void setTriggerNewPage(boolean z) {
        this.triggerNewPage = z;
    }

    public int type() {
        return 13;
    }

    public void add(int i2, Element element) {
        if (!isAddedCompletely()) {
            try {
                if (element.isNestable()) {
                    super.add(i2, element);
                } else {
                    throw new ClassCastException(qw.ad("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
                }
            } catch (ClassCastException e) {
                throw new ClassCastException(qw.ad("insertion.of.illegal.element.1", e.getMessage()));
            }
        } else {
            throw new IllegalStateException(qw.ad("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
    }

    public Section addSection(float f, Paragraph paragraph) {
        return addSection(f, paragraph, this.numberDepth + 1);
    }

    public Section addSection(Paragraph paragraph, int i2) {
        return addSection(0.0f, paragraph, i2);
    }

    public Section addSection(Paragraph paragraph) {
        return addSection(0.0f, paragraph, this.numberDepth + 1);
    }

    public boolean add(Element element) {
        if (!isAddedCompletely()) {
            try {
                if (element.type() == 13) {
                    Section section = (Section) element;
                    int i2 = this.subsections + 1;
                    this.subsections = i2;
                    section.setNumbers(i2, this.numbers);
                    return super.add(section);
                } else if ((element instanceof ddd) && ((xxx) element).f9901ad.type() == 13) {
                    ddd ddd = (ddd) element;
                    int i3 = this.subsections + 1;
                    this.subsections = i3;
                    ((Section) ddd.f9901ad).setNumbers(i3, this.numbers);
                    return super.add(ddd);
                } else if (element.isNestable()) {
                    return super.add(element);
                } else {
                    throw new ClassCastException(qw.ad("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
                }
            } catch (ClassCastException e) {
                throw new ClassCastException(qw.ad("insertion.of.illegal.element.1", e.getMessage()));
            }
        } else {
            throw new IllegalStateException(qw.ad("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
    }

    public Section addSection(float f, String str, int i2) {
        return addSection(f, new Paragraph(str), i2);
    }

    public Section addSection(String str, int i2) {
        return addSection(new Paragraph(str), i2);
    }

    public Section addSection(float f, String str) {
        return addSection(f, new Paragraph(str));
    }

    public Section addSection(String str) {
        return addSection(new Paragraph(str));
    }

    public Section(Paragraph paragraph, int i2) {
        this.numberDepth = i2;
        this.title = paragraph;
        if (paragraph != null) {
            paragraph.setRole(new s0("H" + i2));
        }
    }
}
