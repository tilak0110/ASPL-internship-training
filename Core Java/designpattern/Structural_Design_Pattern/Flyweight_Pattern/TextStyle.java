package designpattern.Structural_Design_Pattern.Flyweight_Pattern;

class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    TextStyle(String font, int size, boolean bold) {
        this.font = font;
        this.size = size;
        this.bold = bold;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public boolean isBold() {
        return bold;
    }
}