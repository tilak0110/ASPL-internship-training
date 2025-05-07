package designpattern.Structural_Design_Pattern.Composite_Pattern;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        root.addComponent(new File("resume.pdf"));
        Folder sub = new Folder("Photos");
        sub.addComponent(new File("pic1.jpg"));
        root.addComponent(sub);
        root.showDetails();
    }
}
