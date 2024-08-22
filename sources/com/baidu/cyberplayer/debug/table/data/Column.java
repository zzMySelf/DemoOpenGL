package com.baidu.cyberplayer.debug.table.data;

import android.graphics.Paint;
import com.baidu.cyberplayer.debug.table.format.IFormat;
import com.baidu.cyberplayer.debug.table.format.draw.IDrawFormat;
import com.baidu.cyberplayer.debug.table.format.draw.TextDrawFormat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Column<T> implements Comparable<Column> {
    public static final String INVAL_VALUE = "";
    private boolean isFixed;
    private boolean isTitleBold;
    private String mColumnName;
    private int mComputeWidth;
    private List<T> mDatas;
    private IDrawFormat<T> mDrawFormat;
    private String mFieldName;
    private IFormat<T> mFormat;
    private Paint.Align mTextAlign;
    private Paint.Align mTitleAlign;

    public String getColumnName() {
        return this.mColumnName;
    }

    public Paint.Align getTitleAlign() {
        return this.mTitleAlign;
    }

    public boolean isTitleBold() {
        return this.isTitleBold;
    }

    public void setTitleBold(boolean isTitleBold2) {
        this.isTitleBold = isTitleBold2;
    }

    public void setTitleAlign(Paint.Align titleAlign) {
        this.mTitleAlign = titleAlign;
    }

    public Column(String columnName, List<Column> list) {
        this.isTitleBold = true;
        this.mColumnName = columnName;
    }

    public Column(String columnName, Column... children) {
        this(columnName, (List<Column>) Arrays.asList(children));
    }

    public Column(String columnName, String fieldName) {
        this(columnName, fieldName, (IFormat) null, (IDrawFormat) null);
    }

    public Column(String columnName, String fieldName, IFormat<T> format) {
        this(columnName, fieldName, format, (IDrawFormat) null);
    }

    public Column(String columnName, String fieldName, IDrawFormat<T> drawFormat) {
        this(columnName, fieldName, (IFormat) null, drawFormat);
    }

    public Column(String columnName, String fieldName, IFormat<T> format, IDrawFormat<T> drawFormat) {
        this.isTitleBold = true;
        this.mColumnName = columnName;
        this.mFormat = format;
        this.mFieldName = fieldName;
        this.mDrawFormat = drawFormat;
        this.mDatas = new ArrayList();
    }

    public boolean isParent() {
        return false;
    }

    public List<T> getDatas() {
        return this.mDatas;
    }

    public void fillData(List<Object> datas) throws NoSuchFieldException, IllegalAccessException {
        Field childField;
        if (datas.size() > 0) {
            String[] fieldNames = this.mFieldName.split("\\.");
            if (fieldNames.length > 0) {
                Field[] fields = new Field[fieldNames.length];
                int size = datas.size();
                for (int k = 0; k < size; k++) {
                    Object child = datas.get(k);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= fieldNames.length) {
                            break;
                        } else if (child == null) {
                            addData((Object) null, true);
                            break;
                        } else {
                            if (fields[i2] != null) {
                                childField = fields[i2];
                            } else {
                                Field childField2 = child.getClass().getDeclaredField(fieldNames[i2]);
                                childField2.setAccessible(true);
                                fields[i2] = childField2;
                                childField = childField2;
                            }
                            if (childField == null) {
                                addData((Object) null, true);
                                break;
                            }
                            if (i2 == fieldNames.length - 1) {
                                addData(childField.get(child), true);
                            } else {
                                child = childField.get(child);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addData(T t, boolean isFoot) {
        if (isFoot) {
            this.mDatas.add(t);
        } else {
            this.mDatas.add(0, t);
        }
    }

    public Paint.Align getTextAlign() {
        return this.mTextAlign;
    }

    public void setTextAlign(Paint.Align textAlign) {
        this.mTextAlign = textAlign;
    }

    public IDrawFormat<T> getDrawFormat() {
        if (this.mDrawFormat == null) {
            this.mDrawFormat = new TextDrawFormat();
        }
        return this.mDrawFormat;
    }

    public boolean isFixed() {
        return this.isFixed;
    }

    public void setFixed(boolean fixed) {
        this.isFixed = fixed;
    }

    public int getComputeWidth() {
        return this.mComputeWidth;
    }

    public void setComputeWidth(int computeWidth) {
        this.mComputeWidth = computeWidth;
    }

    public String format(int position) {
        if (position < 0 || position >= this.mDatas.size()) {
            return "";
        }
        return format(this.mDatas.get(position));
    }

    public String format(T t) {
        IFormat<T> iFormat = this.mFormat;
        if (iFormat != null) {
            return iFormat.format(t);
        }
        return t == null ? "" : t.toString();
    }

    public int compareTo(Column column) {
        return 0;
    }
}
