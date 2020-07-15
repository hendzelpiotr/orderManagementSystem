import java.time.Instant;

class Order {
    private final int orderId;
    private final Instant startedAt;
    private final int quantity;
    private final int productId;
    private final int createdBy;
    private Instant finishedAt;
    private State state;
    private Employee assignedEmployee;

    Order(int orderId,
          Instant startedAt,
          Instant finishedAt,
          int quantity,
          int productId,
          int createdBy) {
        this.orderId = orderId;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.quantity = quantity;
        this.productId = productId;
        this.createdBy = createdBy;
        this.state = new NewState(this);
    }

    public void changeState(State state) {
        System.out.println(String.format("Changing state of the order %s from %s to %s", orderId, this.state.getName(), state.getName()));

        this.state = state;
    }

    public void assignEmployee(Employee employee) {
        this.assignedEmployee = employee;
    }

    public void setFinishedAt(Instant finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getOrderId() {
        return orderId;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Instant getFinishedAt() {
        return finishedAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public State getState() {
        return state;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void print() {
        final String formattedMessage = String.format(
                "Order: " +
                        "\n\t - id: %s " +
                        "\n\t - created by: %s " +
                        "\n\t - created at: %s " +
                        "\n\t - productId: %s " +
                        "\n\t - quantity: %s " +
                        "\n\t - finishedAt: %s " +
                        "\n\t - current state: %s  " +
                        "\n\t - assigned employee: %s ",
                this.orderId,
                this.createdBy,
                this.startedAt,
                this.productId,
                this.quantity,
                this.finishedAt,
                state.getName(),
                this.assignedEmployee == null ? null : this.assignedEmployee.getName()
        );
        System.out.println(formattedMessage);
    }
}
