import java.util.Scanner;

public class UserInterface {

    private final OrderStorage orderStorage;

    public UserInterface() {
        this.orderStorage = OrderStorage.getInstance();
    }

    public void runUI() {
        final Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("Welcome to Order Management System!");

        String character;
        final OrderStorage orderStorage = OrderStorage.getInstance();

        do {
            displayMenu();
            character = input.nextLine();

            switch (character.toUpperCase()) {
                case "1":
                    handleNewOrderOption(input);
                    break;
                case "2":
                    handleAssignEmployeeOption(input);
                    break;
                case "3":
                    handleFinishOption(input);
                    break;
                case "4":
                    handleRejectOption(input);
                    break;
                case "9":
                    handlePrintCacheOption();
                    break;
                case "0":
                    handlePrintAllOption();
                    break;
            }
        } while (!character.equalsIgnoreCase("q"));
    }

    private void handleNewOrderOption(Scanner input) {
        System.out.println("Please enter productId.");
        int productId = readIntValue(input);
        System.out.println("Please enter quantity.");
        int quantity = readIntValue(input);

        new RegisterOrderCommand(this.orderStorage, productId, quantity).execute();
    }

    private void handleAssignEmployeeOption(Scanner input) {
        int orderId;
        System.out.println("Please enter order id");
        orderId = readIntValue(input);
        System.out.println("Please enter first name of the employee you want to assign to this order");
        String employeeFirstName = readStringValue(input);
        System.out.println("Please enter last name of the employee you want to assign to this order");
        String employeeLastName = readStringValue(input);

        new AssignOrderCommand(this.orderStorage, orderId, employeeFirstName, employeeLastName).execute();
    }

    private void handleFinishOption(Scanner input) {
        int orderId;
        System.out.println("Please enter order id");
        orderId = readIntValue(input);

        new FinishOrderCommand(this.orderStorage, orderId).execute();
    }

    private void handlePrintAllOption() {
        new PrintAllOrdersCommand(this.orderStorage).execute();
    }

    private void handleRejectOption(Scanner input) {
        int orderId;
        System.out.println("Please enter order id");
        orderId = readIntValue(input);

        new RejectOrderCommand(this.orderStorage, orderId).execute();
    }

    private void handlePrintCacheOption() {
        EmployeeFactory.printCache();
    }

    private String readStringValue(Scanner input) {
        String value = input.nextLine();

        while (value == null || value.trim().equals("")) {
            System.out.println("Please enter value.");
            value = input.nextLine();
        }

        return value;
    }

    private int readIntValue(Scanner input) {
        String value = input.nextLine();
        int intValue = 0;

        while (value.trim().equals("") || intValue == 0) {
            try {
                intValue = Integer.parseInt(value);
            } catch (Exception e) {
                intValue = 0;
                System.out.println("Please enter numeric value.");
                value = input.nextLine();
            }
        }

        return intValue;
    }

    private void displayMenu() {
        System.out.println("-----------------------------------");
        System.out.println("Press `q` to exit.");
        System.out.println("-----------------------------------");
        System.out.println("Press `0` to show all existing order.");
        System.out.println("Press `1` to register new order.");
        System.out.println("Press `2` to assign order to employee.");
        System.out.println("Press `3` to finish order.");
        System.out.println("Press `4` to reject order.");
        System.out.println("-----------------------------------");
        System.out.println("Press `9` to print employee cache.");
        System.out.println("-----------------------------------");
    }
}
