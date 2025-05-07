package designpattern.Structural_Design_Pattern.Flyweight_Pattern;

import java.util.HashMap;
import java.util.Map;

class TextStyleFactory {
    private static Map<String, TextStyle> pool = new HashMap<>();

    public static TextStyle getStyle(String font, int size, boolean bold) {
        String key = font+size+bold;
        if(!pool.containsKey(key)) {
            pool.put(key, new TextStyle(font, size, bold));
        }
        return pool.get(key);
    }
}