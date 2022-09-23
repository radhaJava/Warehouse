package admin;

import util.PrintHandler;

import static util.PrintHandler.onInvalidInput;

public class AdminController {
    private static AdminModel model;
    private static AdminView view;

    public AdminController(AdminModel model, AdminView view) {
        AdminController.model = model;
        AdminController.view = view;
    }

    public void requestUserInput() {
        String input = PrintHandler.scanUserInputString();
        try {
            int selectedOption = Integer.parseInt(input);
            model.handleOption(selectedOption);
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            onInvalidInput();
            requestUserInput();
        }
    }
}
