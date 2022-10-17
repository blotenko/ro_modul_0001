package Port;

import java.util.ArrayList;
import java.util.List;

public class Port {

    private double maxCapacity;
    private double currentCapacity;
    private int maxContainers;
    private ArrayList<Container> containers;
    private int maxPier;
    private ArrayList<Ship> ships;

    public Port(int maxContainers, double maxCapacity, int maxPier) {
        this.maxContainers = maxContainers;
        this.maxPier = maxPier;
        this.maxCapacity = maxCapacity;
        this.ships = new ArrayList<>();
        this.containers = new ArrayList<>();
    }

    public void addShip(Ship ship) throws TooManyShipsException {
        if (this.ships.size() == this.maxPier) {
            throw new TooManyShipsException("Too many ships. Maximum is " + this.maxPier);
        }
        this.ships.add(ship);
    }

    public void removeShip(Ship ship) throws TooManyShipsException {
        if (this.ships.indexOf(ship) == -1) {
            throw new TooManyShipsException("No ship found");
        }
        this.ships.remove(ship);
    }

    public void moveContainerToShip(Container container, Ship ship) throws ShipOverflowException, ContainerException {
        if (this.ships.indexOf(ship) == -1) {
            throw new ShipOverflowException("No ship found.");
        }
        if (this.containers.indexOf(container) == -1) {
            throw new ContainerException("No container found.");
        }
        this.currentCapacity -= container.getWeight();
        this.containers.remove(container);
        ship.moveContainerToShip(container);
    }

    public void moveContainerFromShip(Container container, Ship ship) throws ShipOverflowException, ContainerException {
        if (this.ships.indexOf(ship) == -1) {
            throw new ShipOverflowException("No ship found.");
        }
        ship.moveContainerToPort(container);
        this.currentCapacity += container.getWeight();
        this.containers.add(container);
    }

    public void addContainer(Container container) throws ShipOverflowException {
        if (this.containers.size() == this.maxContainers) {
            throw new ShipOverflowException("Too many containers.");
        } else if ((this.currentCapacity + container.getWeight()) > this.maxCapacity) {
            throw new ShipOverflowException("Total ship capacity overflow.");
        }
        this.currentCapacity += container.getWeight();
        this.containers.add(container);
    }

    public void removeContainer(Container container) throws ShipOverflowException {
        if (this.containers.indexOf(container) == -1) {
            throw new ShipOverflowException("No containers found.");
        }
        this.currentCapacity -= container.getWeight();
        this.containers.remove(container);
    }
}