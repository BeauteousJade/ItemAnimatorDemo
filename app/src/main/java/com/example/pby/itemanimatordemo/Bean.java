package com.example.pby.itemanimatordemo;

public class Bean {
    private String mContent;
    private int mColor;


    public Bean() {
    }

    public Bean(String mContent, int mColor) {
        this.mContent = mContent;
        this.mColor = mColor;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }
}
