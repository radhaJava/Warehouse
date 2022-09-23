package cashier;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CashierController {
    private final CashierModel model;
    private final CashierView view;
    Scanner scanner = new Scanner(System.in);

    public CashierController(CashierModel model, CashierView view) {
        this.model = model;
        this.view = view;
    }

    public void requestUserInput() {
        String input = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(input.trim());
            model.handleOption(selectedOption);
        } catch (NumberFormatException | NoSuchElementException exception) {
            view.showPrompt();
            requestUserInput();
        }
    }

}
