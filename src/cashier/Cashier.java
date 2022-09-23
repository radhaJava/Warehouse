package cashier;
/*
Cashier will do  add products,  sell products by updating products
  and create order if warehouse have less numb of  products.
  Cashier actions will do the respective functions
 */

public class Cashier {

    public Cashier() {
        CashierModel model = new CashierModel();
        CashierView view = new CashierView(model.getProductListFromFile(),model.getMenuOptions());
        CashierController controller = new CashierController(model, view);
        controller.requestUserInput();

    }
}