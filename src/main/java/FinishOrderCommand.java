class FinishOrderCommand extends Command {

    private final int orderId;

    public FinishOrderCommand(OrderStorage storage, int orderId) {
        super(storage);
        this.orderId = orderId;
    }

    @Override
    void execute() {
        final Order order = storage.getOrder(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        order.getState().finish();
    }
}
