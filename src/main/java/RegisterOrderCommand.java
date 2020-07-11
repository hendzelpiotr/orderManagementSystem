class RegisterOrderCommand extends Command {

    private final int productId;
    private final int quantity;

    public RegisterOrderCommand(OrderStorage storage, int productId, int quantity) {
        super(storage);
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    void execute() {
        final OrderDirector director = new OrderDirector();
        OrderBuilder builder = new OrderBuilder();
        director.constructNewOrder(builder);
        final Order order = builder.withProductId(productId)
                .withQuantity(quantity)
                .build();
        storage.saveOrUpdate(order);
    }

}
