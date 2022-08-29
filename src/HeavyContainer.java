public class HeavyContainer extends Container {
    private String material;

    public HeavyContainer(Sender sender, String material) {
        super(sender);
        this.material = material;
    }

    @Override
    public String toString() {
        return getSender() +
                ", Height: " + getHEIGHT() +
                ", Width: " + getWIDTH() +
                ", Depth: " + getDEPTH() +
                ", Material: " + this.material;
    }
}
