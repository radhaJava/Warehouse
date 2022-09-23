package admin;
/*
Admin reads the user, order,transaction
 */
public class Admin {
    public Admin() {
        AdminModel model = new AdminModel();
        AdminView view = new AdminView(model.getMenuOptions());
        AdminController controller = new AdminController(model, view);
        controller.requestUserInput();
    }

}
