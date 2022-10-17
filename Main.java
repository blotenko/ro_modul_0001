package Port;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] arg){
        Port port = new Port(20, 200, 2);
        try {
            Ship ship1 = new Ship(12, 4);
            Ship ship2 = new Ship(4, 2);

            Container container1 = new Container(2);
            Container container2 = new Container(3.2);

            port.addContainer(container1);
            port.addContainer(container2);

            port.removeContainer(container1);

            port.addShip(ship1);
            port.addShip(ship2);
            port.removeShip(ship1);

            port.moveContainerToShip(container2, ship2);
            port.moveContainerFromShip(container2, ship2);
        } catch (TooManyShipsException|ShipOverflowException|ContainerException e) {
            System.out.println(e.getMessage());
        }
    }
}
