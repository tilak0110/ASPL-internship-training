package OOPs.association;

class Author {
    String name;

    public Author(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Author Name: " + name);
    }
}