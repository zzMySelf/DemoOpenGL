package com.baidu.searchbox.widget.preference;

public class ChoiceItem {
    private int itemIndex;
    private Boolean itemSelected;
    private ItemSelectedListener itemSelectedListener;
    private String itemText;

    public ChoiceItem(int id, String text, boolean itemS, ItemSelectedListener listener) {
        this.itemIndex = id;
        this.itemText = text;
        this.itemSelected = Boolean.valueOf(itemS);
        this.itemSelectedListener = listener;
    }

    public String getItemText() {
        return this.itemText;
    }

    public void setItemText(String text) {
        this.itemText = text;
    }

    public Boolean getItemSelected() {
        return this.itemSelected;
    }

    public void setItemSelected(Boolean selected) {
        this.itemSelected = selected;
    }

    public int getItemIndex() {
        return this.itemIndex;
    }

    public void setItemIndex(int index) {
        this.itemIndex = index;
    }

    public ItemSelectedListener getItemSelectedListener() {
        return this.itemSelectedListener;
    }

    public void setItemSelectedListener(ItemSelectedListener selectedListener) {
        this.itemSelectedListener = selectedListener;
    }
}
