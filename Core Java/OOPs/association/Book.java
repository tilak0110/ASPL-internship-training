package OOPs.association;

class Book {
    String title;
    Author author; // Association

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book Title: " + title);
        author.display();
    }
}