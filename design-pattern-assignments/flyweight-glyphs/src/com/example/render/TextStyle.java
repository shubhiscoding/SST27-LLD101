package com.example.render;

public class TextStyle {
    public final String font;
    public final int size;
    public final boolean bold;
    public TextStyle(String font, int size, boolean bold) {
        this.font = font; this.size = size; this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }
}
