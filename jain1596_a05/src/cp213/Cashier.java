package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author Devansh Jain, 169061596 jain1596@mylaurier.ca
 * @author David Brown
 * @version 2024-11-28
 */
public class Cashier {

    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
        this.menu = menu;
    }

    /**
     * Reads keyboard input. Returns a positive quantity, or 0 if the input is not a
     * valid positive integer.
     *
     * @param scan A keyboard Scanner.
     * @return
     */
    private int askForQuantity(Scanner scan) {
        int quantity = 0;
        System.out.print("How many do you want? ");

        try {
            String line = scan.nextLine();
            quantity = Integer.parseInt(line);
        } catch (NumberFormatException nfex) {
            System.out.println("Not a valid number");
        }
        return quantity;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
        System.out.println("\nMenu:");
        System.out.println(menu.toString());
        System.out.println("Press 0 when done.");
        System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
        System.out.println("Welcome to WLU Foodorama!");
        Scanner input = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            printCommands();
            System.out.print("Command: ");
            String command = input.nextLine();

            try {
                int itemIndex = Integer.parseInt(command) - 1;

                if (itemIndex == -1) {
                    break;
                } else if (itemIndex >= 0 && itemIndex < menu.size()) {
                    MenuItem item = menu.getItem(itemIndex);
                    int quantity = askForQuantity(input);

                    if (quantity > 0) {
                        order.add(item, quantity);
                    }
                }
            } catch (NumberFormatException err) {
                System.out.println("Not a valid number");
            }
        }

        return order;
    }
}