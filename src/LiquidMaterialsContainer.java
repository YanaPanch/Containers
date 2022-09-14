public class LiquidMaterialsContainer extends Container{
    private int capacity;

    public LiquidMaterialsContainer(Sender sender, int capacity) {
        super(sender);
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
