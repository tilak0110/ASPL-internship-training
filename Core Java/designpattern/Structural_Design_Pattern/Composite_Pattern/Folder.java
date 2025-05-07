package designpattern.Structural_Design_Pattern.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{

    private List<FileSystemComponent> children = new ArrayList<>();
    private String name;

    Folder(String name) { this.name = name; }

    void addComponent(FileSystemComponent comp) {
        children.add(comp);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for(FileSystemComponent child : children) {
            child.showDetails();
        }
    }
}
