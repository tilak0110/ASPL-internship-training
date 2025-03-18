package OOPs.association;

public class AssociationDemo {
    public static void main(String[] args) {
        Author author = new Author("Tilak Raj");
        Book book = new Book("Java Programming", author);

        book.display();
    }
}