package designpattern.Behavioral_Design_Pattern.Iterator_Pattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator<String> iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = iter.next();
            System.out.println("Name: " + name);
        }

        List<String> namesList = List.of("Tilak", "Sumit", "Jerry", "Shesh");
        java.util.Iterator<String> it = namesList.iterator();
        while (it.hasNext()) {
            System.out.println("List Name: " + it.next());
        }
    }
}