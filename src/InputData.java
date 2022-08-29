import java.util.Scanner;

public interface InputData extends Messages {
    Scanner scanner = new Scanner(System.in);

    default int inputInt(){
        boolean isInputRequired = true;
        int intValue = 0;
        while (isInputRequired) {
            String choice = scanner.nextLine();
            try {
                intValue = Integer.parseInt(choice);
                isInputRequired = false;
            } catch (NumberFormatException e) {
                System.out.println(WRONGFORMAT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return intValue;
    }
}
