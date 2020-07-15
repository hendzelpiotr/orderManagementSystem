class RejectOrderCommand extends Command {

    private final int orderId;

    public RejectOrderCommand(OrderStorage storage, int orderId) {
        super(storage);
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        final Order order = storage.getOrder(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        order.getState().reject();
    }
}
