package designpattern.Behavioral_Design_Pattern.Iterator_Pattern;

class NameRepository implements Container<String> {
    private String[] names = {"Tilak", "sumit", "shesh", "jitesh"};

    @Override
    public Iterator<String> getIterator() {
        return new NameIterator();
    }

    // Concrete Iterator as inner class
    private class NameIterator implements Iterator<String> {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
