import java.util.List;

class PrintAllOrdersCommand extends Command {

    public PrintAllOrdersCommand(OrderStorage storage) {
        super(storage);
    }

    @Override
    public void execute() {
        final List<Order> orders = storage.getAll();

        if (orders.isEmpty()) {
            printWhenEmpty();
        }

        printAll(orders);
    }

    private void printWhenEmpty() {
        System.out.println("Orders not found.");
    }

    private void printAll(List<Order> orders) {
        orders.forEach(Order::print);
    }
}
