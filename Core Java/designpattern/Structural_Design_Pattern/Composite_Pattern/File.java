package designpattern.Structural_Design_Pattern.Composite_Pattern;

public class File implements FileSystemComponent{
    private String name;

    File(String name) { this.name = name; }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
