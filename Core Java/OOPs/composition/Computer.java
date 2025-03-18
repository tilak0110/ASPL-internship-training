package OOPs.composition;

class Computer {
    private final CPU cpu; // Composition (Computer "owns" CPU)

    public Computer() {
        cpu = new CPU(); // CPU is created inside Computer
    }

    void start() {
        cpu.process();
        System.out.println("Computer is running...");
    }
}