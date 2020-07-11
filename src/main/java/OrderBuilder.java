import java.time.Instant;

class OrderBuilder implements Builder {

    private int orderId;
    private Instant startedAt;
    private Instant finishedAt;
    private int quantity;
    private int productId;
    private int createdBy;
    private Employee employee;

    @Override
    public OrderBuilder withOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override
    public OrderBuilder withStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    @Override
    public OrderBuilder withFinishedAt(Instant finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    @Override
    public OrderBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public OrderBuilder withProductId(int product) {
        this.productId = product;
        return this;
    }

    @Override
    public OrderBuilder withCreatedBy(int userId) {
        this.createdBy = userId;
        return this;
    }

    @Override
    public Builder withEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Order build() {
        return new Order(
                orderId, startedAt, finishedAt, quantity, productId, createdBy);
    }

}
