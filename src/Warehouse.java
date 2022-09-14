import java.util.ArrayList;

public class Warehouse implements Messages{
    private int maxAmountContainers = 2;
    private ArrayList<Container> containers = new ArrayList<>();

    public Warehouse(ArrayList<Container> containersList) {
        this.containers = containersList;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public boolean isEmpty(){
        if (containers.size() > maxAmountContainers){
            System.out.println(MESSAGE4);
            return false;
        } else {
            return true;
        }
    }

    public void loadContainer(Container container){
        if (isEmpty()){
            containers.add(container);
        } else {
            System.out.println(MESSAGE4);
        }
    }

    @Override
    public String toString() {
        return "Max amount of containers " + maxAmountContainers + '\n' + getContainers();
    }
}
