public abstract class Container {
    final int HEIGHT = 3;
    final int WIDTH = 4;
    final int DEPTH = 5;
    private Sender sender;

    public Container(Sender sender) {
        this.sender = sender;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getDEPTH() {
        return DEPTH;
    }

    public Sender getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Container: " + "height " + this.HEIGHT + ", width " + this.WIDTH + ", depth " + this.DEPTH + ", sender: " + sender + '\n';
    }
}
