package loginPage;

import util.PrintHandler;

import java.util.Scanner;

public class LoginPageController extends PrintHandler {
    private final LoginPageModel model;
    private final LoginPageView view;
    Scanner scanner = new Scanner(System.in);

    public LoginPageController(LoginPageModel model, LoginPageView view) {
        this.model = model;
        this.view = view;
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
