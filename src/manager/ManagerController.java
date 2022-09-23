package manager;

import util.PrintHandler;

import static util.PrintHandler.onInvalidInput;

public class ManagerController {
    private static ManagerView view;
    private static ManagerModel model;

    public ManagerController(ManagerModel model, ManagerView view) {
        ManagerController.model = model;
        ManagerController.view = view;
    }

    public void requestUserInput() {
        String input = PrintHandler.scanUserInputString();
        try {
            int selectedOption = Integer.parseInt(input);
            model.handleOption(selectedOption);
        } catch (NumberFormatException | IndexOutOfBoundsException  exception) {
            onInvalidInput();
            requestUserInput();
        }
    }
}
