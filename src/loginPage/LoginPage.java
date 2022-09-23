package loginPage;

public class LoginPage {
    public LoginPage() {
        LoginPageModel model = new LoginPageModel();
        LoginPageView view = new LoginPageView(model.getMenuOptions());
        LoginPageController controller = new LoginPageController(model, view);
        controller.requestUserInput();
    }
}
