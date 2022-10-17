package Port;

public class Container {
    private double weight;

    public Container(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

 class ContainerException extends Exception {
    public ContainerException(String errorMessage) {
        super(errorMessage);
    }
}