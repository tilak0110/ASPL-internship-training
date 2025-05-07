package designpattern.Structural_Design_Pattern.Proxy_Pattern;

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if(realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
