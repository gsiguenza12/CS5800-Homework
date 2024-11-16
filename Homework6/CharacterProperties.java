package com.company;

import java.io.Serializable;

public class CharacterProperties implements Serializable {
    private String font;
    private String color;
    private int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CharacterProperties{" +
                "font='" + font + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
