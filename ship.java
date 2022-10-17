package Port;


import java.util.ArrayList;

 class Ship {
    private double maxCapacity;
    private double currentCapacity;
    private int maxContainers;
    private ArrayList<Container> containers;

    public Ship(int maxCapacity, int maxContainers) {
        this.maxCapacity = maxCapacity;
        this.maxContainers = maxContainers;
        this.containers = new ArrayList<>();
    }

    /**
     * Загрузка контейнеров
     * @param container
     * @throws ShipOverflowException
     */
    public void moveContainerToShip(Container container) throws ShipOverflowException {
        if (this.containers.size() == this.maxContainers) {
            throw new ShipOverflowException("Too many containers on ship.");
        } else if ((this.currentCapacity + container.getWeight()) > this.maxCapacity) {
            throw new ShipOverflowException("Total ship capacity overflow.");
        }
        this.currentCapacity += container.getWeight();
        this.containers.add(container);
    }

    /**
     * Разгрузка контейнеров
     * @param container
     * @throws ShipOverflowException
     */
    public void moveContainerToPort(Container container) throws ContainerException {
        if (this.containers.indexOf(container) == -1) {
            throw new ContainerException("No containers found.");
        }
        this.currentCapacity -= container.getWeight();
        this.containers.remove(container);
    }
}
 class ShipOverflowException extends Exception {
    public ShipOverflowException(String errorMessage) {
        super(errorMessage);
    }
}

 class TooManyShipsException extends Exception {
    public TooManyShipsException(String errorMessage) {
        super(errorMessage);
    }
}