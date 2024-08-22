package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public interface IDataSet<T extends Entry> {
    boolean addEntry(T t);

    void addEntryOrdered(T t);

    void calcMinMax();

    void calcMinMaxY(float f2, float f3);

    void clear();

    boolean contains(T t);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int i2);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float f2);

    int getEntryCount();

    T getEntryForIndex(int i2);

    T getEntryForXValue(float f2, float f3);

    T getEntryForXValue(float f2, float f3, DataSet.Rounding rounding);

    int getEntryIndex(float f2, float f3, DataSet.Rounding rounding);

    int getEntryIndex(T t);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    MPPointF getIconsOffset();

    int getIndexInEntries(int i2);

    String getLabel();

    IValueFormatter getValueFormatter();

    int getValueTextColor();

    int getValueTextColor(int i2);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    boolean removeEntry(int i2);

    boolean removeEntry(T t);

    boolean removeEntryByXValue(float f2);

    boolean removeFirst();

    boolean removeLast();

    void setAxisDependency(YAxis.AxisDependency axisDependency);

    void setDrawIcons(boolean z);

    void setDrawValues(boolean z);

    void setHighlightEnabled(boolean z);

    void setIconsOffset(MPPointF mPPointF);

    void setLabel(String str);

    void setValueFormatter(IValueFormatter iValueFormatter);

    void setValueTextColor(int i2);

    void setValueTextColors(List<Integer> list);

    void setValueTextSize(float f2);

    void setValueTypeface(Typeface typeface);

    void setVisible(boolean z);
}
