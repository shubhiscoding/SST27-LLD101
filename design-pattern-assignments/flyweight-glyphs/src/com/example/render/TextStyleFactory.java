package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String, TextStyle> pool = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "-" + size + "-" + bold;
        if (!pool.containsKey(key)) {
            pool.put(key, new TextStyle(font, size, bold));
        }
        return pool.get(key);
    }
}
