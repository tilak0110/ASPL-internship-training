package designpattern.Structural_Design_Pattern.Proxy_Pattern;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display();
        image.display();
    }
}
