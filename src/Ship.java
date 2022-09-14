import java.util.ArrayList;

public class Ship implements Messages {
    private String name;
    private String homePort;
    private String destinationPort;
    private int maxAmountContainers = 2;
    private ArrayList<Container> containers = new ArrayList<>();

    public Ship(String name, String homePort, String destinationPort) {
        this.name = name;
        this.homePort = homePort;
        this.destinationPort = destinationPort;
    }

    public int getMaxAmountContainers() {
        return maxAmountContainers;
    }

    public boolean isFreeSpace() {
        if (containers.size() > maxAmountContainers) {
            System.out.println(MESSAGE4);
            return false;
        } else {
            return true;
        }
    }

    public void loadContainer(Container container) {
        if (isFreeSpace()) {
            containers.add(container);
        } else{
            System.out.println(MESSAGE4);
        }
    }

    @Override
    public String toString() {
        return "Ship name: " + name + '\n' +
                ", Home Port: " + homePort + '\n' +
                ", Destination Port: " + destinationPort + '\n' +
                ", Max Amount of Containers: " + maxAmountContainers + '\n' +
                ", Containers: " + containers + '\n';
    }
}
