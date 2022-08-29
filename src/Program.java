import java.util.ArrayList;

public class Program implements Messages, InputData, SaveData {
    public static ArrayList<Sender> senders = new ArrayList<>();
    public static ArrayList<Container> containers = new ArrayList<>();
    public static ArrayList<Warehouse> warehouses = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();

    Warehouse warehouse1 = new Warehouse(containers);

    Ship ship1 = new Ship("Black Perl", "Gdansk", "Oslo");

    public void start(){
        System.out.println(WELLCOMEMESSAGE);
        choiceSet();
    }

    public void choiceSet() {
        menu();
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                createSender();
                break;
            case "2":
                createContainer();
                break;
            case "3":
                loadContainerOnShip();
                break;
            case "Exit":
                break;
            default:
                System.out.println(MESSAGE13);
                break;
        }
    }

    public void menu() {
        System.out.println(MESSAGE14 + '\n' + MENU + '\n' + SEPARATOR);
    }

    public Sender createSender() {
        System.out.println(MESSAGE15 + '\n' + MESSAGE1);
        String name = scanner.nextLine();
        System.out.println(MESSAGE2);
        String surname = scanner.nextLine();
        System.out.println(MESSAGE3);
        String personalIdNumber = scanner.nextLine();

        Sender sender = new Sender(name, surname, personalIdNumber);
        senders.add(sender);
        saveData("sender.txt", senders);
        System.out.println(SEPARATOR);
        choiceSet();

        return sender;
    }

    public Sender selectSenderId(){
        Sender selectSender = null;
        System.out.println(MESSAGE3);
        String idSender = scanner.nextLine();

        if (senders.size() >= 1) {
            for (Sender s : senders) {
                if (s.getPersonalIdNumber().equals(idSender)) {
                    selectSender = s;
                } else {
                    System.out.println(MESSAGE10);
                }
            }
        }
        return selectSender;
    }

    public Container createContainer() {
        System.out.println(MESSAGE16);
        Container newContainer = null;
        int containerVariety = 0;
        boolean isInputRequired = true;
        while (isInputRequired) {
            System.out.println(MESSAGE11+ '\n' + MESSAGE7 + '\n' + MESSAGE8);
            try {
                containerVariety = inputInt();
                if (containerVariety > 2 || containerVariety <= 0) {
                    System.out.println(MESSAGE9);
                } else {
                    isInputRequired = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(WRONGFORMAT);
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Sender sender = selectSenderId();

        switch (containerVariety) {
            case 1:
                String material;
                System.out.println(MESSAGE5);
                material = scanner.nextLine();
                newContainer = new HeavyContainer(sender, material);
                break;
            case 2:
                int capacity;
                System.out.println(MESSAGE6);
                capacity = inputInt();
                newContainer = new LiquidMaterialsContainer(sender, capacity);
                break;
            default:
                break;
        }

        System.out.println(MESSAGE12 + '\n' + Decision.YES + '\n' + Decision.NO);
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")){
            warehouse1.loadContainer(newContainer);
            warehouses.add(warehouse1);
            saveData("container.txt", warehouse1.getContainers());
            choiceSet();
        } else {
            System.out.println(APPRECIATE);
        }
        System.out.println(SEPARATOR);

        return newContainer;
    }

    public void loadContainerOnShip(){
        Sender sender = selectSenderId();
        for (int i = 0; i < ship1.getMaxAmountContainers(); i++) {
            if (sender.equals(warehouse1.getContainers().get(i).getSender())) {
                Container loadedContainer = warehouse1.getContainers().get(i);
                ship1.loadContainer(loadedContainer);
                ships.add(ship1);
                break;
            } else {
                System.out.println(MESSAGE13);
            }
        }
        saveData("ship.txt", ships);
    }
}
