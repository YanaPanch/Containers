public class LiquidMaterialsContainer extends Container{
    private int capacity;

    public LiquidMaterialsContainer(Sender sender, int capacity) {
        super(sender);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return getSender() +
                ", Height: " + getHEIGHT() +
                ", Width: " + getWIDTH() +
                ", Depth: " + getDEPTH() +
                ", Capacity: " + this.capacity;
    }
}
